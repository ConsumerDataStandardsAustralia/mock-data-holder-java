package au.org.consumerdatastandards.conformance.directdebits;

import au.org.consumerdatastandards.api.banking.models.BankingDirectDebit;
import au.org.consumerdatastandards.api.banking.models.ParamAccountOpenStatus;
import au.org.consumerdatastandards.api.banking.models.ParamProductCategory;
import au.org.consumerdatastandards.api.banking.models.ResponseBankingDirectDebitAuthorisationList;
import au.org.consumerdatastandards.api.banking.models.ResponseBankingDirectDebitAuthorisationListData;
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

public class DirectDebitsAPISteps extends AccountsAPIStepsBase {

    private String requestUrl;
    private Response listDirectDebitsBulkResponse;
    private Response listDirectDebitsResponse;
    private Response listDirectDebitsSpecificAccountsResponse;

    @Step("Request /banking/accounts/direct-debits")
    public void listDirectDebitsBulk(String productCategory, String openStatus, Boolean isOwned, Integer page, Integer pageSize) {
        String url = getApiBasePath() + "/banking/accounts/direct-debits";
        requestUrl = url;
        boolean paramAdded = false;
        RequestSpecification given = buildHeaders(given())
                .header(Header.VERSION.getKey(), payloadValidator.getEndpointVersion("listDirectDebitsBulk"));
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

        listDirectDebitsBulkResponse = given.when().get(url).then().log().all().extract().response();
    }

    @Step("Validate /banking/accounts/direct-debits response")
    public List<BankingDirectDebit> validateListDirectDebitsBulkResponse(String productCategory, String openStatus, Boolean isOwned, Integer page, Integer pageSize) {
        boolean paramsValid = validateListDirectDebitsBulkParams(productCategory, openStatus, isOwned, page, pageSize);
        int statusCode = listDirectDebitsBulkResponse.statusCode();
        if (paramsValid) {
            assertEquals(ResponseCode.OK.getCode(), statusCode);
            List<ConformanceError> conformanceErrors = new ArrayList<>();
            checkResponseHeaders(listDirectDebitsBulkResponse, conformanceErrors);
            checkProtectedEndpointResponseHeaders(listDirectDebitsBulkResponse, conformanceErrors);
            checkJsonContentType(listDirectDebitsBulkResponse.contentType(), conformanceErrors);

            dumpConformanceErrors(conformanceErrors);

            assertTrue("Conformance errors found in response payload"
                    + buildConformanceErrorsDescription(conformanceErrors), conformanceErrors.isEmpty());

            String json = listDirectDebitsBulkResponse.getBody().asString();
            ObjectMapper objectMapper = ConformanceUtil.createObjectMapper();

            try {
                ResponseBankingDirectDebitAuthorisationList responseDirectDebitList = objectMapper.readValue(json, ResponseBankingDirectDebitAuthorisationList.class);
                conformanceErrors.addAll(payloadValidator.validateResponse(this.requestUrl, responseDirectDebitList,
                        "listDirectDebitsBulk", statusCode));

                ResponseBankingDirectDebitAuthorisationListData data = (ResponseBankingDirectDebitAuthorisationListData) getResponseData(responseDirectDebitList);
                return getDirectDebitList(data);
            } catch (IOException e) {
                fail(e.getMessage());
            }
        } else {
            assertEquals(ResponseCode.BAD_REQUEST.getCode(), statusCode);
        }
        return null;
    }

    private static boolean validateListDirectDebitsBulkParams(String productCategory, String openStatus, Boolean isOwned, Integer page, Integer pageSize) {
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

    @Step("Request /banking/accounts/{accountId}/direct-debits")
    public void listDirectDebits(String accountId, Integer page, Integer pageSize) {
        String url = getApiBasePath() + "/banking/accounts/" + accountId + "/direct-debits";
        requestUrl = url;
        boolean paramAdded = false;
        RequestSpecification given = buildHeaders(given())
                .header(Header.VERSION.getKey(), payloadValidator.getEndpointVersion("listDirectDebits"));
        if (page != null) {
            given.queryParam("page", page);
            requestUrl += "?page=" + page;
            paramAdded = true;
        }
        if (pageSize != null) {
            given.queryParam("page-size", pageSize);
            requestUrl += (paramAdded ? "&" : "?") + "page-size=" + pageSize;
        }

        listDirectDebitsResponse = given.when().get(url).then().log().all().extract().response();
    }

    @Step("Validate /banking/accounts/{accountId}/direct-debits response")
    public void validateListDirectDebitsResponse(String accountId, Integer page, Integer pageSize) {
        boolean paramsValid = validateListDirectDebitsParams(accountId, page, pageSize);
        int statusCode = listDirectDebitsResponse.statusCode();
        if (paramsValid) {
            assertTrue(statusCode == ResponseCode.OK.getCode() || statusCode == ResponseCode.NOT_FOUND.getCode());
            if (statusCode == ResponseCode.OK.getCode()) {
                List<ConformanceError> conformanceErrors = new ArrayList<>();
                checkResponseHeaders(listDirectDebitsResponse, conformanceErrors);
                checkProtectedEndpointResponseHeaders(listDirectDebitsResponse, conformanceErrors);
                checkJsonContentType(listDirectDebitsResponse.contentType(), conformanceErrors);

                String json = listDirectDebitsResponse.getBody().asString();
                ObjectMapper objectMapper = ConformanceUtil.createObjectMapper();

                try {
                    ResponseBankingDirectDebitAuthorisationList responseBankingDirectDebitAuthorisationList = objectMapper.readValue(json, ResponseBankingDirectDebitAuthorisationList.class);
                    conformanceErrors.addAll(payloadValidator.validateResponse(this.requestUrl, responseBankingDirectDebitAuthorisationList,
                            "listDirectDebits", statusCode));

                    ResponseBankingDirectDebitAuthorisationListData data = (ResponseBankingDirectDebitAuthorisationListData) getResponseData(responseBankingDirectDebitAuthorisationList);

                    checkDirectDebitsForAccountId(data, accountId, conformanceErrors);
                } catch (IOException e) {
                    fail(e.getMessage());
                }

                dumpConformanceErrors(conformanceErrors);

                assertTrue("Conformance errors found in response payload"
                        + buildConformanceErrorsDescription(conformanceErrors), conformanceErrors.isEmpty());
            }
        } else {
            assertEquals(ResponseCode.BAD_REQUEST.getCode(), statusCode);
        }
    }

    private void checkDirectDebitsForAccountId(ResponseBankingDirectDebitAuthorisationListData data, String accountId, List<ConformanceError> errors) {
        if (StringUtils.isNotBlank(accountId)) {
            List<BankingDirectDebit> directDebits = getDirectDebitList(data);
            for (BankingDirectDebit directDebit : directDebits) {
                String accId = (String) getField(directDebit, "accountId");
                if (!accId.equals(accountId)) {
                    errors.add(new ConformanceError().errorType(DATA_NOT_MATCHING_CRITERIA)
                            .dataJson(ConformanceUtil.toJson(directDebit)).errorMessage(String.format(
                                    "Unexpected accountId %s in response. Expected: %s", accId, accountId)));
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    private List<BankingDirectDebit> getDirectDebitList(Object directDebitListData) {
        return (List<BankingDirectDebit>) getField(directDebitListData, "directDebitAuthorisations");
    }

    private static boolean validateListDirectDebitsParams(String accountId, Integer page, Integer pageSize) {
        if (!accountId.matches(CustomDataType.ASCII.getPattern())) {
            return false;
        }
        return (page == null || page >= 1) && (pageSize == null || pageSize >= 1);
    }

    @Step("Request POST /banking/accounts/direct-debits")
    public void listDirectDebitsSpecificAccounts(String[] accountIds, Integer page, Integer pageSize) throws JsonProcessingException {
        String url = getApiBasePath() + "/banking/accounts/direct-debits";
        requestUrl = url;
        boolean paramAdded = false;
        RequestSpecification given = buildJSONPostHeaders(given())
                .header(Header.VERSION.getKey(), payloadValidator.getEndpointVersion("listDirectDebitsSpecificAccounts"));
        if (page != null) {
            given.queryParam("page", page);
            requestUrl += "?page=" + page;
            paramAdded = true;
        }
        if (pageSize != null) {
            given.queryParam("page-size", pageSize);
            requestUrl += (paramAdded ? "&" : "?") + "page-size=" + pageSize;
        }
        listDirectDebitsSpecificAccountsResponse = given.body(prepareRequestJson(accountIds))
                .when().post(url).then().log().all().extract().response();
    }

    @Step("Request POST /banking/accounts/direct-debits response")
    public void validateListDirectDebitsSpecificAccountsResponse(String[] accountIds, Integer page, Integer pageSize) {
        boolean paramsValid = validateListDirectDebitsSpecificAccountsParams(accountIds, page, pageSize);
        int statusCode = listDirectDebitsSpecificAccountsResponse.statusCode();
        if (paramsValid) {
            assertEquals(ResponseCode.OK.getCode(), statusCode);
            List<ConformanceError> conformanceErrors = new ArrayList<>();
            checkResponseHeaders(listDirectDebitsSpecificAccountsResponse, conformanceErrors);
            checkJsonContentType(listDirectDebitsSpecificAccountsResponse.contentType(), conformanceErrors);
            String json = listDirectDebitsSpecificAccountsResponse.getBody().asString();
            ObjectMapper objectMapper = ConformanceUtil.createObjectMapper();
            try {
                Class<?> expandedResponseClass = ConformanceUtil.expandModel(ResponseBankingDirectDebitAuthorisationList.class);
                Object responseBankingDirectDebitAuthorisationList = objectMapper.readValue(json, expandedResponseClass);
                conformanceErrors.addAll(payloadValidator.validateResponse(this.requestUrl, responseBankingDirectDebitAuthorisationList,
                        "listDirectDebitsSpecificAccounts", statusCode));
                Object data = getResponseData(responseBankingDirectDebitAuthorisationList);
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

    private void checkAccountIds(Object data, String[] accountIds, List<ConformanceError> conformanceErrors) {
        List<BankingDirectDebit> directDebits = getDirectDebitList(data);
        if (directDebits != null) {
            List<String> idList = Arrays.asList(accountIds);
            for (BankingDirectDebit directDebit : directDebits) {
                String accountId = getAccountId(directDebit);
                if (!idList.contains(accountId)) {
                    conformanceErrors.add(new ConformanceError().errorType(DATA_NOT_MATCHING_CRITERIA)
                            .dataJson(ConformanceUtil.toJson(directDebit)).errorMessage(String.format(
                                    "Unexpected accountId %s in response", accountId)));
                }
            }
        }
    }

    private boolean validateListDirectDebitsSpecificAccountsParams(String[] accountIds, Integer page, Integer pageSize) {
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
