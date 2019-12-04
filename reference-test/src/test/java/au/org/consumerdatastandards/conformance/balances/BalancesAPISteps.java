package au.org.consumerdatastandards.conformance.balances;

import au.org.consumerdatastandards.api.banking.models.BankingBalance;
import au.org.consumerdatastandards.api.banking.models.ParamAccountOpenStatus;
import au.org.consumerdatastandards.api.banking.models.ParamProductCategory;
import au.org.consumerdatastandards.api.banking.models.ResponseBankingAccountsBalanceById;
import au.org.consumerdatastandards.api.banking.models.ResponseBankingAccountsBalanceList;
import au.org.consumerdatastandards.api.banking.models.ResponseBankingAccountsBalanceListData;
import au.org.consumerdatastandards.conformance.AccountsAPIStepsBase;
import au.org.consumerdatastandards.conformance.ConformanceError;
import au.org.consumerdatastandards.conformance.util.ConformanceUtil;
import au.org.consumerdatastandards.support.Header;
import au.org.consumerdatastandards.support.ResponseCode;
import au.org.consumerdatastandards.support.data.CustomDataType;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.thucydides.core.annotations.Step;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static au.org.consumerdatastandards.conformance.ConformanceError.Type.DATA_NOT_MATCHING_CRITERIA;
import static net.serenitybdd.rest.SerenityRest.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class BalancesAPISteps extends AccountsAPIStepsBase {

    private String requestUrl;
    private Response listBalancesBulkResponse;
    private Response listBalanceResponse;
    private Response listBalancesSpecificAccountsResponse;

    @Step("Request /banking/accounts/balances")
    public void listBalancesBulk(String productCategory, String openStatus, Boolean isOwned, Integer page, Integer pageSize) {
        String url = getApiBasePath() + "/banking/accounts/balances";
        requestUrl = url;
        boolean paramAdded = false;
        RequestSpecification given = buildHeaders(given())
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

        listBalancesBulkResponse = given.when().get(url).then().log().all().extract().response();
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
                ResponseBankingAccountsBalanceList responseBankingAccountsBalancesList = objectMapper.readValue(json, ResponseBankingAccountsBalanceList.class);
                conformanceErrors.addAll(payloadValidator.validateResponse(this.requestUrl, responseBankingAccountsBalancesList,
                        "listBalancesBulk", statusCode));

                ResponseBankingAccountsBalanceListData data = (ResponseBankingAccountsBalanceListData) getResponseData(responseBankingAccountsBalancesList);
                return getBalances(data);
            } catch (IOException e) {
                fail(e.getMessage());
            }
        } else {
            assertEquals(ResponseCode.BAD_REQUEST.getCode(), statusCode);
        }
        return null;
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
                ParamAccountOpenStatus.valueOf(openStatus);
            } catch (IllegalArgumentException e) {
                return false;
            }
        }
        return (page == null || page >= 1) && (pageSize == null || pageSize >= 1);
    }

    @Step("Request /banking/accounts/{accountId}/balance")
    public void listBalance(String accountId) {
        String url = getApiBasePath() + "/banking/accounts/" + accountId + "/balance";
        requestUrl = url;
        listBalanceResponse = buildHeaders(given())
                .header(Header.VERSION.getKey(), payloadValidator.getEndpointVersion("listBalance"))
                .when().get(url).then().log().all().extract().response();
    }

    @Step("Validate /banking/accounts/{accountId}/balance response")
    public void validateListBalanceResponse(String accountId) {
        int statusCode = listBalanceResponse.statusCode();
        if (accountId.matches(CustomDataType.ASCII.getPattern())) {
            assertTrue(statusCode == ResponseCode.OK.getCode() || statusCode == ResponseCode.NOT_FOUND.getCode());
            if (statusCode == ResponseCode.OK.getCode()) {
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
            }
        } else {
            assertEquals(ResponseCode.BAD_REQUEST.getCode(), statusCode);
        }
    }

    @Step("Request POST /banking/accounts/balances")
    public void listBalancesSpecificAccounts(String[] accountIds, Integer page, Integer pageSize) throws JsonProcessingException {
        String url = getApiBasePath() + "/banking/accounts/balances";
        requestUrl = url;
        boolean paramAdded = false;
        RequestSpecification given = buildJSONPostHeaders(given())
                .header(Header.VERSION.getKey(), payloadValidator.getEndpointVersion("listBalancesSpecificAccounts"));
        if (page != null) {
            given.queryParam("page", page);
            requestUrl += "?page=" + page;
            paramAdded = true;
        }
        if (pageSize != null) {
            given.queryParam("page-size", pageSize);
            requestUrl += (paramAdded ? "&" : "?") + "page-size=" + pageSize;
        }
        listBalancesSpecificAccountsResponse = given.body(prepareRequestJson(accountIds))
                .when().post(url).then().log().all().extract().response();
    }

    @Step("Request POST /banking/accounts/balances response")
    public void validateListBalancesSpecificAccountsResponse(String[] accountIds, Integer page, Integer pageSize) {
        boolean paramsValid = validateListBalancesSpecificAccountsParams(accountIds, page, pageSize);
        int statusCode = listBalancesSpecificAccountsResponse.statusCode();
        if (paramsValid) {
            assertEquals(ResponseCode.OK.getCode(), statusCode);
            List<ConformanceError> conformanceErrors = new ArrayList<>();
            checkResponseHeaders(listBalancesSpecificAccountsResponse, conformanceErrors);
            checkJsonContentType(listBalancesSpecificAccountsResponse.contentType(), conformanceErrors);
            String json = listBalancesSpecificAccountsResponse.getBody().asString();
            ObjectMapper objectMapper = ConformanceUtil.createObjectMapper();
            try {
                Class<?> expandedResponseClass = ConformanceUtil.expandModel(ResponseBankingAccountsBalanceList.class);
                Object responseBankingAccountsBalanceList = objectMapper.readValue(json, expandedResponseClass);
                conformanceErrors.addAll(payloadValidator.validateResponse(this.requestUrl, responseBankingAccountsBalanceList,
                        "listBalancesSpecificAccounts", statusCode));
                Object data = getResponseData(responseBankingAccountsBalanceList);
                checkAccountIds(data, accountIds, conformanceErrors);

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

    @SuppressWarnings("unchecked")
    private List<BankingBalance> getBalances(Object data) {
        return (List<BankingBalance>) getField(data, "balances");
    }

    private void checkAccountIds(Object data, String[] accountIds, List<ConformanceError> conformanceErrors) {
        List<BankingBalance> balances = getBalances(data);
        if (balances != null) {
            List<String> idList = Arrays.asList(accountIds);
            for (BankingBalance balance : balances) {
                String accountId = getAccountId(balance);
                if (!idList.contains(accountId)) {
                    conformanceErrors.add(new ConformanceError().errorType(DATA_NOT_MATCHING_CRITERIA)
                            .dataJson(ConformanceUtil.toJson(balance)).errorMessage(String.format(
                                    "Unexpected accountId %s in response", accountId)));
                }
            }
        }
    }

    private boolean validateListBalancesSpecificAccountsParams(String[] accountIds, Integer page, Integer pageSize) {
        if (accountIds == null || accountIds.length == 0) {
            return false;
        }
        for (String accountId : accountIds) {
            if (StringUtils.isBlank(accountId)) {
                return false;
            }
        }
        return (page == null || page >= 1) && (pageSize == null || pageSize >= 1);
    }
}
