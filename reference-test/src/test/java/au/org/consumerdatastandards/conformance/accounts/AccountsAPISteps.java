package au.org.consumerdatastandards.conformance.accounts;

import au.org.consumerdatastandards.api.banking.models.BankingAccount;
import au.org.consumerdatastandards.api.banking.models.ParamAccountOpenStatus;
import au.org.consumerdatastandards.api.banking.models.ParamProductCategory;
import au.org.consumerdatastandards.api.banking.models.ResponseBankingAccountList;
import au.org.consumerdatastandards.api.banking.models.ResponseBankingAccountListData;
import au.org.consumerdatastandards.conformance.AccountsAPIStepsBase;
import au.org.consumerdatastandards.conformance.ConformanceError;
import au.org.consumerdatastandards.conformance.util.ConformanceUtil;
import au.org.consumerdatastandards.support.Header;
import au.org.consumerdatastandards.support.ResponseCode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.thucydides.core.annotations.Step;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static net.serenitybdd.rest.SerenityRest.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class AccountsAPISteps extends AccountsAPIStepsBase {

    private Response listAccountsResponse;
    private String requestUrl;
    private ResponseBankingAccountList responseBankingAccountList;

    @Step("Request /banking/accounts")
    void listAccounts(String productCategory, String openStatus, Boolean isOwned, Integer page, Integer pageSize) {
        String url = getApiBasePath() + "/banking/accounts";
        requestUrl = url;
        boolean paramAdded = false;
        RequestSpecification given = buildHeaders(given())
                .header(Header.VERSION.getKey(), payloadValidator.getEndpointVersion("listAccounts"));
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

        listAccountsResponse = given.when().get(url).then().log().all().extract().response();
    }

    @Step("Validate /banking/accounts response")
    void validateListAccountsResponse(String productCategory, String openStatus, Boolean isOwned, Integer page, Integer pageSize) {
        boolean paramsValid = validateListAccountsParams(productCategory, openStatus, isOwned, page, pageSize);
        int statusCode = listAccountsResponse.statusCode();
        if (paramsValid) {
            assertEquals(ResponseCode.OK.getCode(), statusCode);
            List<ConformanceError> conformanceErrors = new ArrayList<>();
            checkResponseHeaders(listAccountsResponse, conformanceErrors);
            checkProtectedEndpointResponseHeaders(listAccountsResponse, conformanceErrors);
            checkJsonContentType(listAccountsResponse.contentType(), conformanceErrors);
            String json = listAccountsResponse.getBody().asString();
            ObjectMapper objectMapper = ConformanceUtil.createObjectMapper();
            try {
                responseBankingAccountList = objectMapper.readValue(json, ResponseBankingAccountList.class);
                conformanceErrors.addAll(payloadValidator.validateResponse(this.requestUrl, responseBankingAccountList,
                        "listAccounts", statusCode));
                ResponseBankingAccountListData data = (ResponseBankingAccountListData) getResponseData(responseBankingAccountList);
                List<BankingAccount> accounts = getAccounts(data);
                if (accounts != null) {
                    for (BankingAccount account : accounts) {
                        checkProductCategory(account, productCategory, conformanceErrors);
                        checkOpenStatus(account, openStatus, conformanceErrors);
                        checkOwned(account, isOwned, conformanceErrors);
                    }
                }

                dumpConformanceErrors(conformanceErrors);


                assertTrue("Conformance errors found in response payload"
                        + buildConformanceErrorsDescription(conformanceErrors), conformanceErrors.isEmpty());
            } catch (IOException e) {
                fail(e.getMessage());
            }
        } else {
            assertEquals(ResponseCode.BAD_REQUEST.getCode(), statusCode);
        }
    }

    @SuppressWarnings("unchecked")
    private static List<BankingAccount> getAccounts(Object accountListData) {
        return (List<BankingAccount>) getField(accountListData, "accounts");
    }

    private static boolean validateListAccountsParams(String productCategory, String openStatus, Boolean isOwned, Integer page, Integer pageSize) {
        if (!StringUtils.isBlank(productCategory)) {
            try {
                ParamProductCategory.valueOf(productCategory);
            } catch (IllegalArgumentException e) {
                return false;
            }
        }
        if (!StringUtils.isBlank(openStatus)) {
            try {
                ParamAccountOpenStatus.valueOf(openStatus);
            } catch (IllegalArgumentException e) {
                return false;
            }
        }
        return (page == null || page >= 1) && (pageSize == null || pageSize >= 1);
    }

    List<String> getAccountIds() {
        String json = listAccountsResponse.getBody().asString();
        ObjectMapper objectMapper = ConformanceUtil.createObjectMapper();
        try {
            responseBankingAccountList = objectMapper.readValue(json, ResponseBankingAccountList.class);
            if (responseBankingAccountList != null) {
                List<BankingAccount> accounts = getAccounts(getResponseData(responseBankingAccountList));
                if (accounts != null && !accounts.isEmpty()) {
                    return accounts.stream().map(AccountsAPIStepsBase::getAccountId).collect(Collectors.toList());
                }
            }
        } catch (IOException e) {
            fail(e.getMessage());
        }
        return null;
    }
}
