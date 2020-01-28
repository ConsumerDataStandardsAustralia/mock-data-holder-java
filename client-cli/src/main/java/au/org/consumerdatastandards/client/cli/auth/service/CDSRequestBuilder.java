package au.org.consumerdatastandards.client.cli.auth.service;

import com.google.common.base.Joiner;
import com.google.common.base.Strings;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import org.apache.http.client.utils.URIBuilder;
import org.mitre.jwt.signer.service.JWTSigningAndValidationService;
import org.mitre.oauth2.model.RegisteredClient;
import org.mitre.openid.connect.client.service.AuthRequestUrlBuilder;
import org.mitre.openid.connect.config.ServerConfiguration;
import org.springframework.security.authentication.AuthenticationServiceException;

import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

public class CDSRequestBuilder implements AuthRequestUrlBuilder {

    private JWTSigningAndValidationService signingAndValidationService;

    /**
     * @see AuthRequestUrlBuilder#buildAuthRequestUrl(ServerConfiguration, RegisteredClient, String, String, String, Map, String)
     */
    @Override
    public String buildAuthRequestUrl(ServerConfiguration serverConfig, RegisteredClient clientConfig, String redirectUri, String nonce, String state, Map<String, String> options, String loginHint) {

        // create our signed JWT for the request object
        JWTClaimsSet.Builder claims = new JWTClaimsSet.Builder();

        String sharingDuration = options.remove(SharingDurationHybridIssuerService.SHARING_DURATION);
        if (sharingDuration != null) {
            HashMap<String, Object> objClaims = new HashMap<>();
            objClaims.put("sharing_duration", sharingDuration);
            claims.claim("claims", objClaims);
        }

        //set parameters to JwtClaims
        claims.claim("response_type", "code id_token");
        claims.claim("client_id", clientConfig.getClientId());
        claims.claim("scope", Joiner.on(" ").join(clientConfig.getScope()));

        // build our redirect URI
        claims.claim("redirect_uri", redirectUri);

        // this comes back in the id token
        claims.claim("nonce", nonce);

        // this comes back in the auth request return
        claims.claim("state", state);

        // Optional parameters
        for (Map.Entry<String, String> option : options.entrySet()) {
            claims.claim(option.getKey(), option.getValue());
        }

        // if there's a login hint, send it
        if (!Strings.isNullOrEmpty(loginHint)) {
            claims.claim("login_hint", loginHint);
        }

        JWSAlgorithm alg = clientConfig.getRequestObjectSigningAlg();
        if (alg == null) {
            alg = signingAndValidationService.getDefaultSigningAlgorithm();
        }

        SignedJWT jwt = new SignedJWT(new JWSHeader(alg), claims.build());

        signingAndValidationService.signJwt(jwt, alg);

        try {
            URIBuilder uriBuilder = new URIBuilder(serverConfig.getAuthorizationEndpointUri());
            uriBuilder.addParameter("request", jwt.serialize());

            // build out the URI
            return uriBuilder.build().toString();
        } catch (URISyntaxException e) {
            throw new AuthenticationServiceException("Malformed Authorization Endpoint Uri", e);
        }
    }

    /**
     * @return the signingAndValidationService
     */
    public JWTSigningAndValidationService getSigningAndValidationService() {
        return signingAndValidationService;
    }

    /**
     * @param signingAndValidationService the signingAndValidationService to set
     */
    public void setSigningAndValidationService(JWTSigningAndValidationService signingAndValidationService) {
        this.signingAndValidationService = signingAndValidationService;
    }
}
