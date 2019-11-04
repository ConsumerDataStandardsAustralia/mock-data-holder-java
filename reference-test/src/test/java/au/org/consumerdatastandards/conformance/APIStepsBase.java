package au.org.consumerdatastandards.conformance;

import au.org.consumerdatastandards.conformance.util.ConformanceUtil;
import au.org.consumerdatastandards.support.Header;
import io.restassured.response.Response;
import net.thucydides.core.annotations.Step;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

import static au.org.consumerdatastandards.conformance.ConformanceError.Type.DATA_NOT_MATCHING_CRITERIA;
import static au.org.consumerdatastandards.conformance.ConformanceError.Type.MISSING_HEADER;

public class APIStepsBase {

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
    protected void checkJsonContentType(String contentType, List<ConformanceError> conformanceErrors) {
        if (!isContentTypeValid(contentType)) {
            conformanceErrors.add(new ConformanceError().errorType(DATA_NOT_MATCHING_CRITERIA)
                    .errorMessage("missing content-type application/json in response header"));
        }
    }

    protected boolean isContentTypeValid(String contentType) {
        return contentType != null && contentType.startsWith("application/json");
    }
}
