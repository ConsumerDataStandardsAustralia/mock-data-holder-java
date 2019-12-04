package au.org.consumerdatastandards.conformance.scheduled.payments;

import au.org.consumerdatastandards.api.banking.models.BankingScheduledPayment;
import au.org.consumerdatastandards.api.banking.models.BankingScheduledPaymentFrom;
import au.org.consumerdatastandards.api.banking.models.ParamAccountOpenStatus;
import au.org.consumerdatastandards.api.banking.models.ParamProductCategory;
import au.org.consumerdatastandards.api.banking.models.ResponseBankingScheduledPaymentsList;
import au.org.consumerdatastandards.api.banking.models.ResponseBankingScheduledPaymentsListData;
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

public class ScheduledPaymentsAPISteps extends AccountsAPIStepsBase {

    private String requestUrl;
    private Response listScheduledPaymentsBulkResponse;
    private Response listScheduledPaymentsResponse;
    private Response listScheduledPaymentsSpecificAccountsResponse;

    @Step("Request /banking/payments/scheduled")
    public void listScheduledPaymentsBulk(String productCategory, String openStatus, Boolean isOwned, Integer page, Integer pageSize) {
        String url = getApiBasePath() + "/banking/payments/scheduled";
        requestUrl = url;
        boolean paramAdded = false;
        RequestSpecification given = buildHeaders(given())
                .header(Header.VERSION.getKey(), payloadValidator.getEndpointVersion("listScheduledPaymentsBulk"));
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

        listScheduledPaymentsBulkResponse = given.when().get(url).then().log().all().extract().response();
    }

    @Step("Validate /banking/payments/scheduled response")
    public List<BankingScheduledPayment> validateListScheduledPaymentsBulkResponse(String productCategory, String openStatus, Boolean isOwned, Integer page, Integer pageSize) {
        boolean paramsValid = validateListScheduledPaymentsBulkParams(productCategory, openStatus, isOwned, page, pageSize);
        int statusCode = listScheduledPaymentsBulkResponse.statusCode();
        if (paramsValid) {
            assertEquals(ResponseCode.OK.getCode(), statusCode);
            List<ConformanceError> conformanceErrors = new ArrayList<>();
            checkResponseHeaders(listScheduledPaymentsBulkResponse, conformanceErrors);
            checkProtectedEndpointResponseHeaders(listScheduledPaymentsBulkResponse, conformanceErrors);
            checkJsonContentType(listScheduledPaymentsBulkResponse.contentType(), conformanceErrors);

            dumpConformanceErrors(conformanceErrors);

            assertTrue("Conformance errors found in response payload"
                    + buildConformanceErrorsDescription(conformanceErrors), conformanceErrors.isEmpty());

            String json = listScheduledPaymentsBulkResponse.getBody().asString();
            ObjectMapper objectMapper = ConformanceUtil.createObjectMapper();

            try {
                ResponseBankingScheduledPaymentsList responseScheduledPaymentsList = objectMapper.readValue(json, ResponseBankingScheduledPaymentsList.class);
                conformanceErrors.addAll(payloadValidator.validateResponse(this.requestUrl, responseScheduledPaymentsList,
                        "listScheduledPaymentsBulk", statusCode));

                ResponseBankingScheduledPaymentsListData data = (ResponseBankingScheduledPaymentsListData) getResponseData(responseScheduledPaymentsList);
                return getScheduledPaymentsList(data);
            } catch (IOException e) {
                fail(e.getMessage());
            }
        } else {
            assertEquals(ResponseCode.BAD_REQUEST.getCode(), statusCode);
        }
        return null;
    }

    private static boolean validateListScheduledPaymentsBulkParams(String productCategory, String openStatus, Boolean isOwned, Integer page, Integer pageSize) {
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

    @Step("Request /banking/accounts/{accountId}/payments/scheduled")
    public void listScheduledPayments(String accountId, Integer page, Integer pageSize) {
        String url = getApiBasePath() + "/banking/accounts/" + accountId + "/payments/scheduled";
        requestUrl = url;
        boolean paramAdded = false;
        RequestSpecification given = buildHeaders(given())
                .header(Header.VERSION.getKey(), payloadValidator.getEndpointVersion("listScheduledPayments"));
        if (page != null) {
            given.queryParam("page", page);
            requestUrl += "?page=" + page;
            paramAdded = true;
        }
        if (pageSize != null) {
            given.queryParam("page-size", pageSize);
            requestUrl += (paramAdded ? "&" : "?") + "page-size=" + pageSize;
        }

        listScheduledPaymentsResponse = given.when().get(url).then().log().all().extract().response();
    }

    @Step("Validate /banking/accounts/{accountId}/payments/scheduled response")
    public void validateListScheduledPaymentsResponse(String accountId, Integer page, Integer pageSize) {
        boolean paramsValid = validateListScheduledPaymentsParams(accountId, page, pageSize);
        int statusCode = listScheduledPaymentsResponse.statusCode();
        if (paramsValid) {
            assertTrue(statusCode == ResponseCode.OK.getCode() || statusCode == ResponseCode.NOT_FOUND.getCode());
            if (statusCode == ResponseCode.OK.getCode()) {
                List<ConformanceError> conformanceErrors = new ArrayList<>();
                checkResponseHeaders(listScheduledPaymentsResponse, conformanceErrors);
                checkProtectedEndpointResponseHeaders(listScheduledPaymentsResponse, conformanceErrors);
                checkJsonContentType(listScheduledPaymentsResponse.contentType(), conformanceErrors);

                String json = listScheduledPaymentsResponse.getBody().asString();
                ObjectMapper objectMapper = ConformanceUtil.createObjectMapper();

                try {
                    ResponseBankingScheduledPaymentsList responseBankingScheduledPaymentsList = objectMapper.readValue(json, ResponseBankingScheduledPaymentsList.class);
                    conformanceErrors.addAll(payloadValidator.validateResponse(this.requestUrl, responseBankingScheduledPaymentsList,
                            "listScheduledPayments", statusCode));

                    ResponseBankingScheduledPaymentsListData data = (ResponseBankingScheduledPaymentsListData) getResponseData(responseBankingScheduledPaymentsList);

                    checkScheduledPaymentsForAccountId(data, accountId, conformanceErrors);
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

    private void checkScheduledPaymentsForAccountId(ResponseBankingScheduledPaymentsListData data, String accountId, List<ConformanceError> errors) {
        if (StringUtils.isNotBlank(accountId)) {
            List<BankingScheduledPayment> scheduledPayments = getScheduledPaymentsList(data);
            for (BankingScheduledPayment scheduledPayment : scheduledPayments) {
                String accId = getScheduledPaymentAccountId(scheduledPayment);
                if (!accId.equals(accountId)) {
                    errors.add(new ConformanceError().errorType(DATA_NOT_MATCHING_CRITERIA)
                            .dataJson(ConformanceUtil.toJson(scheduledPayment)).errorMessage(String.format(
                                    "Unexpected accountId %s in response. Expected: %s", accId, accountId)));
                }
            }
        }
    }

    static String getScheduledPaymentAccountId(BankingScheduledPayment scheduledPayment) {
        return getAccountId((BankingScheduledPaymentFrom) getField(scheduledPayment, "from"));
    }

    @SuppressWarnings("unchecked")
    private List<BankingScheduledPayment> getScheduledPaymentsList(Object scheduledPaymentsListData) {
        return (List<BankingScheduledPayment>) getField(scheduledPaymentsListData, "scheduledPayments");
    }

    private static boolean validateListScheduledPaymentsParams(String accountId, Integer page, Integer pageSize) {
        if (!accountId.matches(CustomDataType.ASCII.getPattern())) {
            return false;
        }
        return (page == null || page >= 1) && (pageSize == null || pageSize >= 1);
    }

    @Step("Request POST /banking/payments/scheduled")
    public void listScheduledPaymentsSpecificAccounts(String[] accountIds, Integer page, Integer pageSize) throws JsonProcessingException {
        String url = getApiBasePath() + "/banking/payments/scheduled";
        requestUrl = url;
        boolean paramAdded = false;
        RequestSpecification given = buildJSONPostHeaders(given())
                .header(Header.VERSION.getKey(), payloadValidator.getEndpointVersion("listScheduledPaymentsSpecificAccounts"));
        if (page != null) {
            given.queryParam("page", page);
            requestUrl += "?page=" + page;
            paramAdded = true;
        }
        if (pageSize != null) {
            given.queryParam("page-size", pageSize);
            requestUrl += (paramAdded ? "&" : "?") + "page-size=" + pageSize;
        }
        listScheduledPaymentsSpecificAccountsResponse = given.body(prepareRequestJson(accountIds))
                .when().post(url).then().log().all().extract().response();
    }

    @Step("Request POST /banking/payments/scheduled response")
    public void validateListScheduledPaymentsSpecificAccountsResponse(String[] accountIds, Integer page, Integer pageSize) {
        boolean paramsValid = validateListScheduledPaymentsSpecificAccountsParams(accountIds, page, pageSize);
        int statusCode = listScheduledPaymentsSpecificAccountsResponse.statusCode();
        if (paramsValid) {
            assertEquals(ResponseCode.OK.getCode(), statusCode);
            List<ConformanceError> conformanceErrors = new ArrayList<>();
            checkResponseHeaders(listScheduledPaymentsSpecificAccountsResponse, conformanceErrors);
            checkJsonContentType(listScheduledPaymentsSpecificAccountsResponse.contentType(), conformanceErrors);
            String json = listScheduledPaymentsSpecificAccountsResponse.getBody().asString();
            ObjectMapper objectMapper = ConformanceUtil.createObjectMapper();
            try {
                Class<?> expandedResponseClass = ConformanceUtil.expandModel(ResponseBankingScheduledPaymentsList.class);
                Object responseBankingScheduledPaymentsList = objectMapper.readValue(json, expandedResponseClass);
                conformanceErrors.addAll(payloadValidator.validateResponse(this.requestUrl, responseBankingScheduledPaymentsList,
                        "listScheduledPaymentsSpecificAccounts", statusCode));
                Object data = getResponseData(responseBankingScheduledPaymentsList);
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
        List<BankingScheduledPayment> scheduledPayments = getScheduledPaymentsList(data);
        if (scheduledPayments != null) {
            List<String> idList = Arrays.asList(accountIds);
            for (BankingScheduledPayment scheduledPayment : scheduledPayments) {
                String accountId = getScheduledPaymentAccountId(scheduledPayment);
                if (!idList.contains(accountId)) {
                    conformanceErrors.add(new ConformanceError().errorType(DATA_NOT_MATCHING_CRITERIA)
                            .dataJson(ConformanceUtil.toJson(scheduledPayment)).errorMessage(String.format(
                                    "Unexpected accountId %s in response", accountId)));
                }
            }
        }
    }

    private boolean validateListScheduledPaymentsSpecificAccountsParams(String[] accountIds, Integer page, Integer pageSize) {
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
