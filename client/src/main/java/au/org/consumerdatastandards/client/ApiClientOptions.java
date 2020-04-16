package au.org.consumerdatastandards.client;

public interface ApiClientOptions {
    String getServerUrl();
    void setServerUrl(String serverUrl);
    String getProxy();
    void setProxy(String proxy);
    boolean isValidationEnabled();
    void setValidationEnabled(boolean validationEnabled);
    String getUserAgent();
    void setUserAgent(String userAgent);
    boolean isDebugEnabled();
    void setDebugEnabled(boolean debugEnabled);
    boolean isVerifyingSsl();
    void setVerifyingSsl(boolean verifyingSsl);
    void setAccessToken(String jwt);
    String getAccessToken();
    String getCertFilePath();
    void setCertFilePath(String certFilePath);
    String getKeyFilePath();
    void setKeyFilePath(String keyFilePath);
    String getRootCaFilePath();
    void setRootCaFilePath(String rootCaFilePath);
    boolean isMtlsEnabled();
    void setMtlsEnabled(boolean mtlsEnabled);
    void setAuthServer(String authServer);
    String getAuthServer();
    String getClientId();
    void setClientId(String clientId);
    String getRefreshToken();
    void setRefreshToken(String refreshToken);
    String getJwksPath();
    void setJwksPath(String jwksPath);
}
