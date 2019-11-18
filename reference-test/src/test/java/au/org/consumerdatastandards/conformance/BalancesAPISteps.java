package au.org.consumerdatastandards.conformance;

import au.org.consumerdatastandards.api.banking.models.BankingAccount;
import au.org.consumerdatastandards.api.banking.models.BankingAccountDetail;
import au.org.consumerdatastandards.api.banking.models.BankingBalance;
import au.org.consumerdatastandards.api.banking.models.ParamProductCategory;
import au.org.consumerdatastandards.api.banking.models.ResponseBankingAccountsBalanceById;
import au.org.consumerdatastandards.api.banking.models.ResponseBankingAccountsBalanceList;
import au.org.consumerdatastandards.api.banking.models.ResponseBankingAccountsBalanceListData;
import au.org.consumerdatastandards.conformance.util.ConformanceUtil;
import au.org.consumerdatastandards.support.Header;
import au.org.consumerdatastandards.support.ResponseCode;
import au.org.consumerdatastandards.support.data.CustomDataType;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.thucydides.core.annotations.Step;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static net.serenitybdd.rest.SerenityRest.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class BalancesAPISteps extends AccountsAPIStepsBase {

    private PayloadValidator payloadValidator = new PayloadValidator();
    private String requestUrl;
    private Response listBalancesBulkResponse;
    private ResponseBankingAccountsBalanceList responseBankingAccountsBalancesList;
    private Response listBalanceResponse;

    @Step("Request /banking/accounts/balances")
    public void listBalancesBulk(String productCategory, String openStatus, Boolean isOwned, Integer page, Integer pageSize) {
        String url = getApiBasePath() + "/banking/accounts/balances";
        requestUrl = url;
        boolean paramAdded = false;
        RequestSpecification given = given()
                .header("Accept", "application/json")
                .header(Header.VERSION.getKey(), payloadValidator.getEndpointVersion("listBalancesBulk"));
        if (!StringUtils.isBlank(openStatus)) {
            given.queryParam("open-status", openStatus);
            requestUrl += "?open-status=" + openStatus;
            paramAdded = true;
        }
        if (isOwned != null) {
            given.queryParam("is-owned", isOwned);
            requestUrl += (paramAdded ? "&" : "?") + "is-owned=" + isOwned;
            paramAdded = true;
        }
        if (!StringUtils.isBlank(productCategory)) {
            given.queryParam("product-category", productCategory);
            requestUrl += (paramAdded ? "&" : "?") + "product-category=" + productCategory;
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

        listBalancesBulkResponse = given.relaxedHTTPSValidation().when().get(url).then().log().all().extract().response();
    }

    @Step("Validate /banking/accounts/balances response")
    public List<BankingBalance> validateListBalanceBulkResponse(String productCategory, String openStatus, Boolean isOwned, Integer page, Integer pageSize) {
        boolean paramsValid = validateListBalanceBulkParams(productCategory, openStatus, isOwned, page, pageSize);
        int statusCode = listBalancesBulkResponse.statusCode();
        if (paramsValid) {
            assertEquals(ResponseCode.OK.getCode(), statusCode);
            List<ConformanceError> conformanceErrors = new ArrayList<>();
            checkResponseHeaders(listBalancesBulkResponse, conformanceErrors);
            checkProtectedEndpointResponseHeaders(listBalancesBulkResponse, conformanceErrors);
            checkJsonContentType(listBalancesBulkResponse.contentType(), conformanceErrors);

            dumpConformanceErrors(conformanceErrors);

            assertTrue("Conformance errors found in response payload"
                    + buildConformanceErrorsDescription(conformanceErrors), conformanceErrors.isEmpty());

            String json = listBalancesBulkResponse.getBody().asString();
            ObjectMapper objectMapper = ConformanceUtil.createObjectMapper();

            try {
                responseBankingAccountsBalancesList = objectMapper.readValue(json, ResponseBankingAccountsBalanceList.class);
                payloadValidator.validateResponse(this.requestUrl, responseBankingAccountsBalancesList, "listBalancesBulk", statusCode);

                ResponseBankingAccountsBalanceListData data = (ResponseBankingAccountsBalanceListData) getResponseData(responseBankingAccountsBalancesList);
                return getBulkBalances(data);
            } catch (IOException e) {
                fail(e.getMessage());
            }
        } else {
            assertEquals(ResponseCode.BAD_REQUEST.getCode(), statusCode);
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    private List<BankingBalance> getBulkBalances(ResponseBankingAccountsBalanceListData balancesListData) {
        return (List<BankingBalance>) getField(balancesListData, "balances");
    }

    private static boolean validateListBalanceBulkParams(String productCategory, String openStatus, Boolean isOwned, Integer page, Integer pageSize) {
        if (!StringUtils.isBlank(productCategory)) {
            try {
                ParamProductCategory.valueOf(productCategory);
            } catch (IllegalArgumentException e) {
                return false;
            }
        }
        if (!StringUtils.isBlank(openStatus)) {
            try {
                BankingAccount.OpenStatus.valueOf(openStatus);
            } catch (IllegalArgumentException e) {
                return false;
            }
        }
        return (page == null || page >= 1) && (pageSize == null || pageSize >= 1);
    }

    @Step("Validate BankingAccountDetail productCategory, openStatus, isOwned")
    public void validateReferencedByIdAccount(BankingAccountDetail accountDetail, String productCategory, String openStatus, Boolean isOwned) {
        List<ConformanceError> conformanceErrors = new ArrayList<>();
        checkProductCategory(accountDetail, productCategory, conformanceErrors);
        checkOpenStatus(accountDetail, openStatus, conformanceErrors);
        checkOwned(accountDetail, isOwned, conformanceErrors);

        dumpConformanceErrors(conformanceErrors);

        assertTrue("Conformance errors found in response payload"
                + buildConformanceErrorsDescription(conformanceErrors), conformanceErrors.isEmpty());
    }

    @Step("Request /banking/accounts/{accountId}/balance")
    public void listBalance(String accountId) {
        String url = getApiBasePath() + "/banking/accounts/" + accountId + "/balance";
        requestUrl = url;
        listBalanceResponse = given().relaxedHTTPSValidation()
                .header("Accept", "application/json")
                .header(Header.VERSION.getKey(), payloadValidator.getEndpointVersion("listBalance"))
                .when().get(url).then().log().all().extract().response();
    }

    @Step("Validate /banking/accounts/{accountId}/balance response")
    public void validateListBalanceResponse(String accountId) {
        int statusCode = listBalanceResponse.statusCode();
        if (accountId.matches(CustomDataType.ASCII.getPattern())) {
            List<ConformanceError> conformanceErrors = new ArrayList<>();
            checkResponseHeaders(listBalanceResponse, conformanceErrors);
            checkJsonContentType(listBalanceResponse.contentType(), conformanceErrors);
            String json = listBalanceResponse.getBody().asString();
            ObjectMapper objectMapper = ConformanceUtil.createObjectMapper();
            try {
                Class<?> expandedResponseClass = ConformanceUtil.expandModel(ResponseBankingAccountsBalanceById.class);
                Object responseBankingAccountsBalanceById = objectMapper.readValue(json, expandedResponseClass);
                conformanceErrors.addAll(payloadValidator.validateResponse(this.requestUrl, responseBankingAccountsBalanceById,
                        "listBalance", statusCode));
                Object data = getResponseData(responseBankingAccountsBalanceById);
                checkAccountId(data, accountId, conformanceErrors);

                dumpConformanceErrors(conformanceErrors);

                assertTrue("Conformance errors found in response payload:"
                        + buildConformanceErrorsDescription(conformanceErrors), conformanceErrors.isEmpty());
            } catch (IOException e) {
                fail(e.getMessage());
            }
        } else {
            assertEquals(ResponseCode.BAD_REQUEST.getCode(), statusCode);
        }
    }
}
