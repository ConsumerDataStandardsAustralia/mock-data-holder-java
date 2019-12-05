package au.org.consumerdatastandards.conformance;

import au.org.consumerdatastandards.conformance.util.ConformanceUtil;
import au.org.consumerdatastandards.support.Header;
import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.thucydides.core.annotations.Step;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ReflectionUtils;

import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.List;
import java.util.Properties;

import static au.org.consumerdatastandards.conformance.ConformanceError.Type.DATA_NOT_MATCHING_CRITERIA;
import static au.org.consumerdatastandards.conformance.ConformanceError.Type.MISSING_HEADER;

public class APIStepsBase {

    private static final String APPLICATION_JSON = "application/json";

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    protected PayloadValidator payloadValidator = new PayloadValidator();
    protected Properties props;

    private String apiBasePath;

    protected RequestSpecification buildHeaders(RequestSpecification given) {
        return given.header("Accept", APPLICATION_JSON);
    }

    protected RequestSpecification buildJSONPostHeaders(RequestSpecification given) {
        return buildHeaders(given).header("Content-Type", APPLICATION_JSON);
    }

    @Step("Setup API base path to {0}")
    void setupApiBasePath(String apiBasePath) {
        this.apiBasePath = apiBasePath;
    }

    @Step("Setup PTT properties")
    void setupPttProperties() throws IOException, KeyStoreException, CertificateException,
        NoSuchAlgorithmException, UnrecoverableKeyException, KeyManagementException {

        props = new Properties();
        props.load(APIStepsBase.class.getResourceAsStream("/ptt.properties"));
        SSLConfig sslConfig = SSLConfig.sslConfig().allowAllHostnames();

        String keyStorePath = props.getProperty("keystore.path");
        String trustStorePath = props.getProperty("truststore.path");

        if (keyStorePath != null && trustStorePath != null) {
            KeyStore clientStore = KeyStore.getInstance("JKS");
            String keyStorePassword = props.getProperty("keystore.password");
            clientStore.load(new FileInputStream(keyStorePath), keyStorePassword.toCharArray());

            KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            kmf.init(clientStore, keyStorePassword.toCharArray());
            KeyManager[] kms = kmf.getKeyManagers();

            KeyStore trustStore = KeyStore.getInstance("JKS");
            String trustStorePassword = props.getProperty("truststore.password");
            trustStore.load(new FileInputStream(trustStorePath), trustStorePassword.toCharArray());

            TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            tmf.init(trustStore);
            TrustManager[] tms = tmf.getTrustManagers();

            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(kms, tms, new SecureRandom());
            sslConfig = sslConfig.with().sslSocketFactory(new SSLSocketFactory(clientStore, keyStorePassword, trustStore));
        }
        RestAssured.config = RestAssured.config().sslConfig(sslConfig);
    }

    public String getApiBasePath() {
        return apiBasePath;
    }

    protected void checkResponseHeaders(Response response, List<ConformanceError> conformanceErrors) {
        String version = response.header(Header.VERSION.getKey());
        if (StringUtils.isBlank(version)) {
            conformanceErrors.add(new ConformanceError().errorType(MISSING_HEADER)
                    .errorMessage("missing '" + Header.VERSION.getKey() + "' in response header"));
        } else {
            ConformanceUtil.checkHeaderValue(version, Header.VERSION, conformanceErrors);
        }
    }

    protected void checkProtectedEndpointResponseHeaders(Response response, List<ConformanceError> conformanceErrors) {
        String fapiInteractionId = response.header(Header.FAPI_INTERACTION_ID.getKey());
        if (StringUtils.isBlank(fapiInteractionId)) {
            conformanceErrors.add(new ConformanceError().errorType(MISSING_HEADER)
                    .errorMessage("missing '" + Header.FAPI_INTERACTION_ID.getKey() + "' in response header"));
        } else {
            ConformanceUtil.checkHeaderValue(fapiInteractionId, Header.FAPI_INTERACTION_ID, conformanceErrors);
        }
    }

    protected void checkJsonContentType(String contentType, List<ConformanceError> conformanceErrors) {
        if (!isContentTypeValid(contentType)) {
            conformanceErrors.add(new ConformanceError().errorType(DATA_NOT_MATCHING_CRITERIA)
                    .errorMessage("missing content-type application/json in response header"));
        }
    }

    protected boolean isContentTypeValid(String contentType) {
        return contentType != null && contentType.startsWith(APPLICATION_JSON);
    }

    protected String buildConformanceErrorsDescription(List<ConformanceError> conformanceErrors) {
        StringBuilder sb = new StringBuilder();
        for (ConformanceError error : conformanceErrors) {
            sb.append("\n\n").append(error.getDescription());
        }
        return sb.toString();
    }

    protected static Object getField(Object obj, String fieldName) {
        String expandedFieldName = ConformanceUtil.getFieldName(obj, fieldName);
        Field dataField = FieldUtils.getField(obj.getClass(), expandedFieldName, true);
        return ReflectionUtils.getField(dataField, obj);
    }

    protected static Object getResponseData(Object response) {
        return getField(response, "data");
    }

    protected void dumpConformanceErrors(List<ConformanceError> conformanceErrors) {
        for (ConformanceError error : conformanceErrors) {
            logger.info("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            logger.error(error.getDescription());
        }
    }
}
