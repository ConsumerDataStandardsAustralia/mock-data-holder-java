package au.org.consumerdatastandards.conformance;

import au.org.consumerdatastandards.support.Header;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSObject;
import com.nimbusds.jose.crypto.RSASSASigner;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import io.restassured.http.ContentType;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.time.OffsetDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static net.serenitybdd.rest.SerenityRest.given;
import static org.junit.Assert.fail;

public class ProtectedAPIStepsBase extends APIStepsBase {

    public static final String INTROSPECTION_ENDPOINT = "introspection_endpoint";
    public static final String TOKEN_ENDPOINT = "token_endpoint";

    private static HashMap<String, String> config;
    private long lastChecked;
    private boolean active;

    protected RequestSpecification buildHeaders(RequestSpecification given) {
        String accessToken = props.getProperty("access.token");
        String authServer = props.getProperty("auth.server");
        String refreshToken = props.getProperty("refresh.token");
        if (StringUtils.isNotBlank(authServer) && StringUtils.isNotBlank(refreshToken)) {
            try {
                Map<String, String> config = discoveredInfo(authServer);
                boolean valid = StringUtils.isNotBlank(accessToken);
                if (valid) {
                    valid = checkTokenValidity(accessToken, authServer, config.get(INTROSPECTION_ENDPOINT));
                }
                if (!valid) {
                    accessToken = acquireNewAccessToken(config.get(TOKEN_ENDPOINT));
                    props.setProperty("access_token", accessToken);
                }
            } catch (IOException | ParseException | JOSEException e) {
                throw new RuntimeException(e);
            }
        }

        return super.buildHeaders(given)
                .header("Authorization", "Bearer " + accessToken)
                .header(Header.FAPI_AUTH_DATE.getKey(), OffsetDateTime.now().toString());
    }

    private boolean checkTokenValidity(String accessToken, String authServer, String introspectionEndpoint) throws IOException, ParseException, JOSEException {
        // Assume the check is good for a minute since the last query
        if (lastChecked > 0 && System.currentTimeMillis() < lastChecked + 60 * 1000) {
            return active;
        }
        active = given()
                .contentType("application/x-www-form-urlencoded")
                .body("token=" + accessToken + "&token_type_hint=access_token&" + createAuthAssertionParamStr(authServer))
                .when().post(introspectionEndpoint)
                .then().log().all().contentType(ContentType.JSON).extract().path("active");
        lastChecked = System.currentTimeMillis();
        return active;
    }

    private String createAuthAssertionParamStr(String aud) throws IOException, ParseException, JOSEException {
        String clientId = props.getProperty("client.id");
        JWTClaimsSet claims = new JWTClaimsSet.Builder()
                .subject(clientId)
                .issuer(clientId)
                .audience(aud)
                .expirationTime(new Date(System.currentTimeMillis() + 5 * 60 * 1000)) // the assertion expires in 5 minutes
                .jwtID(UUID.randomUUID().toString())
                .build();
        JWKSet jwkSet = JWKSet.load(new File(props.getProperty("jwks.path")));
        RSAKey rsaKey = (RSAKey) jwkSet.getKeys().get(0);
        JWSObject signedJWT = new SignedJWT(new JWSHeader.Builder(JWSAlgorithm.RS256).keyID(rsaKey.getKeyID()).build(), claims);
        RSASSASigner signer = new RSASSASigner(rsaKey);
        signedJWT.sign(signer);
        return "client_assertion_type=urn:ietf:params:oauth:client-assertion-type:jwt-bearer&client_id=" + clientId
                + "&client_assertion=" + signedJWT.serialize();
    }

    private String acquireNewAccessToken(String tokenEndpoint) throws IOException, ParseException, JOSEException {
        String post = "grant_type=refresh_token&" + createAuthAssertionParamStr(tokenEndpoint)
                + "&refresh_token=" + props.getProperty("refresh.token");

        ExtractableResponse<Response> tokenResponse = given()
                .contentType("application/x-www-form-urlencoded")
                .body(post)
                .when().post(tokenEndpoint)
                .then().log().all().contentType(ContentType.JSON).extract();
        String error = tokenResponse.path("error");
        if (error != null) {
            String msg = tokenResponse.path("error_description");
            fail(msg == null ? error : msg);
        }
        lastChecked = System.currentTimeMillis();
        active = true;
        return tokenResponse.path("access_token");
    }

    private static Map<String, String> discoveredInfo(String authServer) {
        if (config == null) {
            ExtractableResponse<Response> resp = given().when().get(authServer + ".well-known/openid-configuration")
                    .then().log().all().contentType(ContentType.JSON).extract();
            config = new HashMap<>();
            config.put(TOKEN_ENDPOINT, resp.path(TOKEN_ENDPOINT));
            config.put(INTROSPECTION_ENDPOINT, resp.path(INTROSPECTION_ENDPOINT));
        }
        return config;
    }
}