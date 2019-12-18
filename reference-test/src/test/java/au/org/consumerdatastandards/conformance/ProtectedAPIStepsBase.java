package au.org.consumerdatastandards.conformance;

import au.org.consumerdatastandards.support.Header;
import io.restassured.http.ContentType;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;

import static net.serenitybdd.rest.SerenityRest.given;

public class ProtectedAPIStepsBase extends APIStepsBase {

    public static final String INTROSPECTION_ENDPOINT = "introspection_endpoint";
    public static final String TOKEN_ENDPOINT = "token_endpoint";

    private static final HashMap<String, Map<String, String>> discoveredConfigs = new HashMap<>();

    protected RequestSpecification buildHeaders(RequestSpecification given) {
        String accessToken = props.getProperty("access.token");
        try {
            String authServer = props.getProperty("auth.server");
            Map<String, String> config = discoveredInfo(authServer);
            boolean valid = given()
                    .contentType("application/x-www-form-urlencoded")
                    .body("token=" + accessToken).when().post(authServer + config.get(INTROSPECTION_ENDPOINT))
                    .then().log().all().contentType(ContentType.JSON).extract().path("active");
            if (!valid) {
                accessToken = acquireNewAccessToken(config.get(TOKEN_ENDPOINT));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return super.buildHeaders(given)
                .header("Authorization", "Bearer " + accessToken)
                .header(Header.FAPI_AUTH_DATE.getKey(), OffsetDateTime.now().toString());
    }

    private String acquireNewAccessToken(String tokenEndpoint) {
        String refreshToken = props.getProperty("access.token");

        return null; // TODO implement me
    }

    private static Map<String, String> discoveredInfo(String authServer) throws IOException {
        Map<String, String> config = discoveredConfigs.get(authServer);
        if (config == null) {
            ExtractableResponse<Response> resp = given().when().get(authServer + "/.well-known/openid-configuration")
                    .then().log().all().contentType(ContentType.JSON).extract();
            config = new HashMap<>();
            config.put(TOKEN_ENDPOINT, resp.path(TOKEN_ENDPOINT));
            config.put(INTROSPECTION_ENDPOINT, resp.path(INTROSPECTION_ENDPOINT));
            discoveredConfigs.put(authServer, config);
        }
        return config;
    }
}
