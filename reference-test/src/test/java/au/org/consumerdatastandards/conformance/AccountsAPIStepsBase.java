package au.org.consumerdatastandards.conformance;

import au.org.consumerdatastandards.api.banking.models.BankingAccount;
import au.org.consumerdatastandards.api.banking.models.BankingProductCategory;
import au.org.consumerdatastandards.api.banking.models.ResponseBankingAccountById;
import au.org.consumerdatastandards.conformance.util.ConformanceUtil;
import au.org.consumerdatastandards.support.Header;
import au.org.consumerdatastandards.support.ResponseCode;
import au.org.consumerdatastandards.support.data.CustomDataType;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.restassured.response.Response;
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

public class AccountsAPIStepsBase extends ProtectedAPIStepsBase {

    private String requestUrl;
    private Response getAccountDetailResponse;

    @Step("Request /banking/accounts/{accountId}")
    public void getAccountDetail(String accountId) {
        String url = getApiBasePath() + "/banking/accounts/" + accountId;
        requestUrl = url;
        getAccountDetailResponse = buildHeaders(given())
                .header(Header.VERSION.getKey(), payloadValidator.getEndpointVersion("getAccountDetail"))
                .when().get(url).then().log().body().extract().response();
    }

    @Step("Validate /banking/accounts/{accountId} response")
    public Object validateGetAccountDetailResponse(String accountId) {
        int statusCode = getAccountDetailResponse.statusCode();
        if (accountId.matches(CustomDataType.ASCII.getPattern())) {
            assertTrue(statusCode == ResponseCode.OK.getCode() || statusCode == ResponseCode.NOT_FOUND.getCode());
            if (statusCode == ResponseCode.OK.getCode()) {
                List<ConformanceError> conformanceErrors = new ArrayList<>();
                checkResponseHeaders(getAccountDetailResponse, conformanceErrors);
                checkJsonContentType(getAccountDetailResponse.contentType(), conformanceErrors);
                String json = getAccountDetailResponse.getBody().asString();
                ObjectMapper objectMapper = ConformanceUtil.createObjectMapper();
                try {
                    Class<?> expandedResponseClass = ConformanceUtil.expandModel(ResponseBankingAccountById.class);
                    Object responseBankingAccountById = objectMapper.readValue(json, expandedResponseClass);
                    conformanceErrors.addAll(payloadValidator.validateResponse(this.requestUrl, responseBankingAccountById,
                            "getAccountDetail", statusCode));
                    Object responseData = getResponseData(responseBankingAccountById);
                    String id = getAccountId(responseData);
                    if (!id.equals(accountId)) {
                        conformanceErrors.add(new ConformanceError().errorType(DATA_NOT_MATCHING_CRITERIA)
                                .dataJson(ConformanceUtil.toJson(responseBankingAccountById)).errorMessage(String.format(
                                        "Response accountId %s does not match request accountId %s", id, accountId)));
                    }

                    dumpConformanceErrors(conformanceErrors);

                    assertTrue("Conformance errors found in response payload:"
                            + buildConformanceErrorsDescription(conformanceErrors), conformanceErrors.isEmpty());
                    return responseData;
                } catch (IOException e) {
                    fail(e.getMessage());
                }
            }
        } else {
            assertEquals(ResponseCode.BAD_REQUEST.getCode(), statusCode);
        }
        return null;
    }

    public static String getAccountId(Object data) {
        return (String) getField(data, "accountId");
    }

    protected void checkOwned(Object account, Boolean isOwned, List<ConformanceError> errors) {
        if (isOwned != null) {
            Boolean accountOwned = (Boolean) getField(account, "isOwned");
            if (!isOwned.equals(accountOwned)) {
                errors.add(new ConformanceError().errorType(DATA_NOT_MATCHING_CRITERIA)
                        .errorField(FieldUtils.getField(account.getClass(), "isOwned", true))
                        .dataJson(ConformanceUtil.toJson(account))
                        .errorMessage(String.format(
                                "BankingAccount isOwned %b does not match isOwned query %b",
                                accountOwned, isOwned)));
            }
        }
    }

    protected void checkOpenStatus(Object account, String openStatus, List<ConformanceError> errors) {
        if (!StringUtils.isBlank(openStatus)) {
            BankingAccount.OpenStatus accountOpenStatus = (BankingAccount.OpenStatus) getField(account, "openStatus");
            if (accountOpenStatus == null || !accountOpenStatus.name().equals(openStatus)) {
                errors.add(new ConformanceError().errorType(DATA_NOT_MATCHING_CRITERIA)
                        .errorField(FieldUtils.getField(account.getClass(), "openStatus", true))
                        .dataJson(ConformanceUtil.toJson(account))
                        .errorMessage(String.format(
                                "BankingAccount openStatus %s does not match openStatus query %s",
                                (accountOpenStatus == null ? null : accountOpenStatus.name()), openStatus)));
            }
        }
    }

    protected void checkProductCategory(Object account, String productCategory, List<ConformanceError> errors) {
        if (!StringUtils.isBlank(productCategory)) {
            BankingProductCategory bankingProductCategory = (BankingProductCategory) getField(account, "productCategory");
            if (bankingProductCategory == null || !bankingProductCategory.name().equals(productCategory)) {
                errors.add(new ConformanceError().errorType(DATA_NOT_MATCHING_CRITERIA)
                        .errorField(FieldUtils.getField(account.getClass(), "productCategory", true))
                        .dataJson(ConformanceUtil.toJson(account))
                        .errorMessage(String.format(
                                "BankingAccount productCategory %s does not match productCategory query %s",
                                bankingProductCategory, productCategory)));
            }
        }
    }

    protected void checkAccountId(Object obj, String accountId, List<ConformanceError> conformanceErrors) {
        String id = (String) getField(obj, "accountId");;
        if (!id.equals(accountId)) {
            conformanceErrors.add(new ConformanceError().errorType(DATA_NOT_MATCHING_CRITERIA)
                    .dataJson(ConformanceUtil.toJson(obj)).errorMessage(String.format(
                            "Response accountId %s does not match request accountId %s", id, accountId)));
        }
    }

    @Step("Validate BankingAccountDetail productCategory, openStatus, isOwned")
    public void validateReferencedByIdAccount(Object accountDetail, String productCategory, String openStatus, Boolean isOwned) {
        List<ConformanceError> conformanceErrors = new ArrayList<>();
        checkProductCategory(accountDetail, productCategory, conformanceErrors);
        checkOpenStatus(accountDetail, openStatus, conformanceErrors);
        checkOwned(accountDetail, isOwned, conformanceErrors);

        dumpConformanceErrors(conformanceErrors);

        assertTrue("Conformance errors found in response payload"
                + buildConformanceErrorsDescription(conformanceErrors), conformanceErrors.isEmpty());
    }

    protected String prepareRequestJson(String[] accountIds) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode accIdsObj = mapper.createObjectNode();
        ObjectNode accData = mapper.createObjectNode();
        ArrayNode accIdsArr = mapper.createArrayNode();
        for (String accountId : accountIds) {
            accIdsArr.add(accountId);
        }
        accData.set("accountIds", accIdsArr);
        accIdsObj.set("data", accData);
        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(accIdsObj);
    }
}
