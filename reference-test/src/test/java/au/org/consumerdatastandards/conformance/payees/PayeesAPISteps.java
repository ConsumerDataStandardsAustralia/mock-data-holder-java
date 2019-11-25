package au.org.consumerdatastandards.conformance.payees;

import au.org.consumerdatastandards.api.banking.BankingPayeesAPI;
import au.org.consumerdatastandards.api.banking.models.BankingPayee;
import au.org.consumerdatastandards.api.banking.models.ResponseBankingDirectDebitAuthorisationListData;
import au.org.consumerdatastandards.api.banking.models.ResponseBankingPayeeList;
import au.org.consumerdatastandards.conformance.APIStepsBase;
import au.org.consumerdatastandards.conformance.ConformanceError;
import au.org.consumerdatastandards.conformance.PayloadValidator;
import au.org.consumerdatastandards.conformance.util.ConformanceUtil;
import au.org.consumerdatastandards.support.Header;
import au.org.consumerdatastandards.support.ResponseCode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.thucydides.core.annotations.Step;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.reflect.FieldUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static au.org.consumerdatastandards.conformance.ConformanceError.Type.DATA_NOT_MATCHING_CRITERIA;
import static net.serenitybdd.rest.SerenityRest.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class PayeesAPISteps extends APIStepsBase {

    private PayloadValidator payloadValidator = new PayloadValidator();
    private String requestUrl;
    private Response listPayeesResponse;

    @Step("Request /banking/payees")
    public void listPayees(String type, Integer page, Integer pageSize) {
        String url = getApiBasePath() + "/banking/accounts/direct-debits";
        requestUrl = url;
        boolean paramAdded = false;
        RequestSpecification given = given()
                .header("Accept", "application/json")
                .header(Header.VERSION.getKey(), payloadValidator.getEndpointVersion("listPayees"));
        if (!StringUtils.isBlank(type)) {
            given.queryParam("type", type);
            requestUrl += "?type=" + type;
            paramAdded = true;
        }
        if (page != null) {
            given.queryParam("page", page);
            requestUrl += (paramAdded ? "&" : "?") + "page=" + page;
            paramAdded = true;
        }
        if (pageSize != null) {
            given.queryParam("page-size", pageSize);
            requestUrl += (paramAdded ? "&" : "?") + "page-size=" + pageSize;
        }

        listPayeesResponse = given.relaxedHTTPSValidation().when().get(url).then().log().all().extract().response();
    }

    @Step("Validate /banking/payees response")
    public void validateListPayeesResponse(String type, Integer page, Integer pageSize) {
        boolean paramsValid = validateListPayeesParams(type, page, pageSize);
        int statusCode = listPayeesResponse.statusCode();
        if (paramsValid) {
            assertEquals(ResponseCode.OK.getCode(), statusCode);
            List<ConformanceError> conformanceErrors = new ArrayList<>();
            checkResponseHeaders(listPayeesResponse, conformanceErrors);
            checkProtectedEndpointResponseHeaders(listPayeesResponse, conformanceErrors);
            checkJsonContentType(listPayeesResponse.contentType(), conformanceErrors);

            dumpConformanceErrors(conformanceErrors);

            assertTrue("Conformance errors found in response payload"
                    + buildConformanceErrorsDescription(conformanceErrors), conformanceErrors.isEmpty());

            String json = listPayeesResponse.getBody().asString();
            ObjectMapper objectMapper = ConformanceUtil.createObjectMapper();

            try {
                ResponseBankingPayeeList responseBankingPayeeList = objectMapper.readValue(json, ResponseBankingPayeeList.class);
                payloadValidator.validateResponse(this.requestUrl, responseBankingPayeeList, "listPayees", statusCode);

                ResponseBankingDirectDebitAuthorisationListData data = (ResponseBankingDirectDebitAuthorisationListData) getResponseData(responseBankingPayeeList);
                List<BankingPayee> payees = getBankingPayeeList(data);
                for (BankingPayee payee : payees) {
                    checkType(payee, type, conformanceErrors);
                }

            } catch (IOException e) {
                fail(e.getMessage());
            }
        } else {
            assertEquals(ResponseCode.BAD_REQUEST.getCode(), statusCode);
        }
    }

    private void checkType(BankingPayee payee, String type, List<ConformanceError> errors) {
        if (!StringUtils.isBlank(type)) {
            BankingPayeesAPI.ParamType payeeType = (BankingPayeesAPI.ParamType) getField(payee, "type");
            if (payeeType == null || !payeeType.name().equals(type)) {
                errors.add(new ConformanceError().errorType(DATA_NOT_MATCHING_CRITERIA)
                        .errorField(FieldUtils.getField(BankingPayee.class, "type", true))
                        .dataJson(ConformanceUtil.toJson(payee))
                        .errorMessage(String.format(
                                "BankingPayee type %s does not match type query %s",
                                payeeType, type)));
            }
        }
    }

    private static boolean validateListPayeesParams(String type, Integer page, Integer pageSize) {
        if (!StringUtils.isBlank(type)) {
            try {
                BankingPayeesAPI.ParamType.valueOf(type);
            } catch (IllegalArgumentException e) {
                return false;
            }
        }
        return (page == null || page >= 1) && (pageSize == null || pageSize >= 1);
    }

    @SuppressWarnings("unchecked")
    private List<BankingPayee> getBankingPayeeList(Object bankingPayeeListData) {
        return (List<BankingPayee>) getField(bankingPayeeListData, "payees");
    }
}
