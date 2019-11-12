package au.org.consumerdatastandards.conformance;

import au.org.consumerdatastandards.conformance.util.ConformanceUtil;
import au.org.consumerdatastandards.support.Header;
import io.restassured.response.Response;
import net.thucydides.core.annotations.Step;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;

import static au.org.consumerdatastandards.conformance.ConformanceError.Type.DATA_NOT_MATCHING_CRITERIA;
import static au.org.consumerdatastandards.conformance.ConformanceError.Type.MISSING_HEADER;

public class APIStepsBase {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    protected PayloadValidator payloadValidator = new PayloadValidator();

    private String apiBasePath;

    @Step("Setup API base path to {0}")
    void setupApiBasePath(String apiBasePath) {
        this.apiBasePath = apiBasePath;
    }

    String getApiBasePath() {
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
        String version = response.header(Header.FAPI_INTERACTION_ID.getKey());
        if (StringUtils.isBlank(version)) {
            conformanceErrors.add(new ConformanceError().errorType(MISSING_HEADER)
                    .errorMessage("missing '" + Header.FAPI_INTERACTION_ID.getKey() + "' in response header"));
        } else {
            ConformanceUtil.checkHeaderValue(version, Header.FAPI_INTERACTION_ID, conformanceErrors);
        }
    }

    protected void checkJsonContentType(String contentType, List<ConformanceError> conformanceErrors) {
        if (!isContentTypeValid(contentType)) {
            conformanceErrors.add(new ConformanceError().errorType(DATA_NOT_MATCHING_CRITERIA)
                    .errorMessage("missing content-type application/json in response header"));
        }
    }

    protected boolean isContentTypeValid(String contentType) {
        return contentType != null && contentType.startsWith("application/json");
    }

    protected String buildConformanceErrorsDescription(List<ConformanceError> conformanceErrors) {
        StringBuilder sb = new StringBuilder();
        for (ConformanceError error : conformanceErrors) {
            sb.append("\n\n").append(error.getDescription());
        }
        return sb.toString();
    }

    protected static Object getField(Object obj, String fieldName) {
        Field dataField = FieldUtils.getField(obj.getClass(), fieldName, true);
        return ReflectionUtils.getField(dataField, obj);
    }

    protected void dumpConformanceErrors(List<ConformanceError> conformanceErrors) {
        for (ConformanceError error : conformanceErrors) {
            logger.info("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            logger.error(error.getDescription());
        }
    }
}
