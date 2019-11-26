package au.org.consumerdatastandards.conformance.customer;

import au.org.consumerdatastandards.api.common.models.ResponseCommonCustomer;
import au.org.consumerdatastandards.conformance.APIStepsBase;
import au.org.consumerdatastandards.conformance.ConformanceError;
import au.org.consumerdatastandards.conformance.util.ConformanceUtil;
import au.org.consumerdatastandards.support.Header;
import au.org.consumerdatastandards.support.ResponseCode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import net.thucydides.core.annotations.Step;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static net.serenitybdd.rest.SerenityRest.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class CustomerAPISteps extends APIStepsBase {

    private String requestUrl;
    private Response getCustomerResponse;

    @Step("Request /common/customer")
    public void getCustomer() {
        String url = getApiBasePath() + "/common/customer";
        requestUrl = url;
        getCustomerResponse = given().relaxedHTTPSValidation()
                .header("Accept", "application/json")
                .header(Header.VERSION.getKey(), payloadValidator.getEndpointVersion("getCustomer"))
                .when().get(url).then().log().all().extract().response();
    }

    @Step("Validate /common/customer response")
    public void validateGetCustomerResponse() {
        int statusCode = getCustomerResponse.statusCode();
        assertEquals(ResponseCode.OK.getCode(), statusCode);
        List<ConformanceError> conformanceErrors = new ArrayList<>();
        checkResponseHeaders(getCustomerResponse, conformanceErrors);
        checkProtectedEndpointResponseHeaders(getCustomerResponse, conformanceErrors);
        checkJsonContentType(getCustomerResponse.contentType(), conformanceErrors);

        String json = getCustomerResponse.getBody().asString();
        ObjectMapper objectMapper = ConformanceUtil.createObjectMapper();

        try {
            ResponseCommonCustomer responseCommonCustomer = objectMapper.readValue(json, ResponseCommonCustomer.class);
            conformanceErrors.addAll(
                    payloadValidator.validateResponse(this.requestUrl, responseCommonCustomer, "getCustomer", statusCode)
            );
        } catch (IOException e) {
            fail(e.getMessage());
        }

        dumpConformanceErrors(conformanceErrors);

        assertTrue("Conformance errors found in response payload"
                + buildConformanceErrorsDescription(conformanceErrors), conformanceErrors.isEmpty());
    }
}
