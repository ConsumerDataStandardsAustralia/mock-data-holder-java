package au.org.consumerdatastandards.client.cli.support;

import au.org.consumerdatastandards.client.ApiClientOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;

public class ClientCLIOptions implements ApiClientOptions {
    @Value("${server:}")
    private String serverUrl;
    @Value("${proxy:}")
    private String proxy;
    private boolean validationEnabled = false;
    @Value("${user.agent:Client CLI}")
    private String userAgent;
    private boolean debugEnabled = false;
    private boolean verifyingSsl = true;
    @Value("${access.token:}")
    private String accessToken;
    @Value("${refresh.token:}")
    private String refreshToken;
    @Value("${cert.path:}")
    private String certFilePath;
    @Value("${key.path:}")
    private String keyFilePath;
    @Value("${root.cert.path:}")
    private String rootCaFilePath;
    private boolean mtlsEnabled = false;
    @Value("${auth.server:}")
    private String authServer;
    @Value("${client.id:}")
    private String clientId;
    @Value("${jwks.path:keystore/keystore.jwks}")
    private String jwksPath;
    @Autowired
    private Environment environment;

    @Override
    public String getServerUrl() {
        return serverUrl;
    }

    @Override
    public void setServerUrl(String serverUrl) {
        this.serverUrl = serverUrl;
    }

    @Override
    public String getProxy() {
        return proxy;
    }

    @Override
    public void setProxy(String proxy) {
        this.proxy = proxy;
    }

    @Override
    public boolean isValidationEnabled() {
        return validationEnabled;
    }

    @Override
    public void setValidationEnabled(boolean validationEnabled) {
        this.validationEnabled = validationEnabled;
    }

    @Override
    public String getUserAgent() {
        return userAgent;
    }

    @Override
    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    @Override
    public boolean isDebugEnabled() {
        return debugEnabled;
    }

    @Override
    public void setDebugEnabled(boolean debugEnabled) {
        this.debugEnabled = debugEnabled;
    }

    @Override
    public boolean isVerifyingSsl() {
        return verifyingSsl;
    }

    @Override
    public void setVerifyingSsl(boolean verifyingSsl) {
        this.verifyingSsl = verifyingSsl;
    }

    @Override
    public void setAccessToken(String jwt) {
        this.accessToken = jwt;
    }

    @Override
    public String getAccessToken() {
        return accessToken;
    }

    @Override
    public String getCertFilePath() {
        return certFilePath;
    }

    @Override
    public void setCertFilePath(String certFilePath) {
        this.certFilePath = certFilePath;
    }

    @Override
    public String getKeyFilePath() {
        return keyFilePath;
    }

    @Override
    public void setKeyFilePath(String keyFilePath) {
        this.keyFilePath = keyFilePath;
    }

    @Override
    public String getRootCaFilePath() {
        return rootCaFilePath;
    }

    @Override
    public void setRootCaFilePath(String rootCaFilePath) {
        this.rootCaFilePath = rootCaFilePath;
    }

    @Override
    public boolean isMtlsEnabled() {
        return mtlsEnabled;
    }

    @Override
    public void setMtlsEnabled(boolean mtlsEnabled) {
        this.mtlsEnabled = mtlsEnabled;
    }

    @Override
    public void setAuthServer(String authServer) {
        this.authServer = authServer;
    }

    @Override
    public String getAuthServer() {
        return authServer;
    }

    @Override
    public String getClientId() {
        return clientId;
    }

    @Override
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    @Override
    public String getRefreshToken() {
        return refreshToken;
    }

    @Override
    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    @Override
    public String getJwksPath() {
        return jwksPath;
    }

    @Override
    public void setJwksPath(String jwksPath) {
        this.jwksPath = jwksPath;
    }

    public String getWebPort() {
        return environment.getProperty("local.server.port");
    }
}
