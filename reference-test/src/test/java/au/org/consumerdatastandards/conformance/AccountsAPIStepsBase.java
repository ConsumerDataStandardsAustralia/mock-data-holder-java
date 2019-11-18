package au.org.consumerdatastandards.conformance;

import au.org.consumerdatastandards.api.banking.models.BankingAccount;
import au.org.consumerdatastandards.api.banking.models.BankingAccountDetail;
import au.org.consumerdatastandards.api.banking.models.BankingProductCategory;
import au.org.consumerdatastandards.api.banking.models.ResponseBankingAccountById;
import au.org.consumerdatastandards.api.banking.models.ResponseBankingAccountList;
import au.org.consumerdatastandards.conformance.util.ConformanceUtil;
import au.org.consumerdatastandards.support.Header;
import au.org.consumerdatastandards.support.ResponseCode;
import au.org.consumerdatastandards.support.data.CustomDataType;
import com.fasterxml.jackson.databind.ObjectMapper;
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

public class AccountsAPIStepsBase extends APIStepsBase {

    private PayloadValidator payloadValidator = new PayloadValidator();
    private Response listAccountsResponse;
    private String requestUrl;
    private ResponseBankingAccountList responseBankingAccountList;
    private Response getAccountDetailResponse;

    @Step("Request /banking/accounts/{accountId}")
    void getAccountDetail(String accountId) {
        String url = getApiBasePath() + "/banking/accounts/" + accountId;
        requestUrl = url;
        getAccountDetailResponse = given().relaxedHTTPSValidation()
                .header("Accept", "application/json")
                .header(Header.VERSION.getKey(), payloadValidator.getEndpointVersion("getAccountDetail"))
                .when().get(url).then().log().body().extract().response();
    }

    @Step("Validate /banking/accounts/{accountId} response")
    BankingAccountDetail validateGetAccountDetailResponse(String accountId) {
        int statusCode = getAccountDetailResponse.statusCode();
        if (accountId.matches(CustomDataType.ASCII.getPattern())) {
            assertEquals(ResponseCode.OK.getCode(), statusCode);
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
                BankingAccountDetail responseData = (BankingAccountDetail) getResponseData(responseBankingAccountById);
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
        } else {
            assertEquals(ResponseCode.BAD_REQUEST.getCode(), statusCode);
        }
        return null;
    }

    protected static String getAccountId(Object data) {
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
}
