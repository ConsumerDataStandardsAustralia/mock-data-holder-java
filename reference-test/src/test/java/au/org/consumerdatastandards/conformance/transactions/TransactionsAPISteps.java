package au.org.consumerdatastandards.conformance.transactions;

import au.org.consumerdatastandards.api.banking.models.BankingTransaction;
import au.org.consumerdatastandards.api.banking.models.ResponseBankingTransactionById;
import au.org.consumerdatastandards.api.banking.models.ResponseBankingTransactionList;
import au.org.consumerdatastandards.api.banking.models.ResponseBankingTransactionListData;
import au.org.consumerdatastandards.api.banking.models.TxMetaPaginated;
import au.org.consumerdatastandards.conformance.AccountsAPIStepsBase;
import au.org.consumerdatastandards.conformance.ConformanceError;
import au.org.consumerdatastandards.conformance.util.ConformanceUtil;
import au.org.consumerdatastandards.support.Header;
import au.org.consumerdatastandards.support.ResponseCode;
import au.org.consumerdatastandards.support.data.CustomDataType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.client.util.DateTime;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.thucydides.core.annotations.Step;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.reflect.FieldUtils;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static au.org.consumerdatastandards.conformance.ConformanceError.Type.DATA_NOT_MATCHING_CRITERIA;
import static net.serenitybdd.rest.SerenityRest.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class TransactionsAPISteps extends AccountsAPIStepsBase {

    private static final long NINETY_DAYS_IN_MILLIS = 90 * 24 * 60 * 60 * 1000L;

    private Response getTransactionsResponse;
    private String requestUrl;
    private ResponseBankingTransactionList responseBankingTransactionList;
    private Response getTransactionDetailResponse;

    @Step("Request /banking/accounts/{accountId}/transactions")
    void getTransactions(String accountId, String oldestTime, String newestTime, String minAmount, String maxAmount,
                      String text, Integer page, Integer pageSize) {
        String url = getApiBasePath() + "/banking/accounts/" + accountId + "/transactions";
        requestUrl = url;
        boolean paramAdded = false;
        RequestSpecification given = buildHeaders(given())
                .header(Header.VERSION.getKey(), payloadValidator.getEndpointVersion("getTransactions"));
        if (!StringUtils.isBlank(oldestTime)) {
            given.queryParam("oldest-time", oldestTime);
            requestUrl += "?oldest-time=" + oldestTime;
            paramAdded = true;
        }
        if (!StringUtils.isBlank(newestTime)) {
            given.queryParam("newest-time", newestTime);
            requestUrl += "?newest-time=" + newestTime;
            paramAdded = true;
        }
        if (!StringUtils.isBlank(minAmount)) {
            given.queryParam("min-amount", minAmount);
            requestUrl += "?min-amount=" + minAmount;
            paramAdded = true;
        }
        if (!StringUtils.isBlank(maxAmount)) {
            given.queryParam("max-amount", maxAmount);
            requestUrl += "?max-amount=" + maxAmount;
            paramAdded = true;
        }
        if (!StringUtils.isBlank(text)) {
            given.queryParam("text", text);
            requestUrl += "?text=" + text;
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

        getTransactionsResponse = given.when().get(url).then().log().all().extract().response();
    }

    @Step("Validate /banking/accounts/{accountId}/transactions response")
    void validateGetTransactionsResponse(String accountId, String oldestTime, String newestTime, String minAmount, String maxAmount,
                                         String text, Integer page, Integer pageSize) {
        boolean paramsValid = validateGetTransactionsParams(accountId, oldestTime, newestTime, minAmount, maxAmount, text, page, pageSize);
        int statusCode = getTransactionsResponse.statusCode();
        if (paramsValid) {
            assertTrue(statusCode == ResponseCode.OK.getCode() || statusCode == ResponseCode.NOT_FOUND.getCode());
            if (statusCode == ResponseCode.OK.getCode()) {
                List<ConformanceError> conformanceErrors = new ArrayList<>();
                checkResponseHeaders(getTransactionsResponse, conformanceErrors);
                checkProtectedEndpointResponseHeaders(getTransactionsResponse, conformanceErrors);
                checkJsonContentType(getTransactionsResponse.contentType(), conformanceErrors);
                String json = getTransactionsResponse.getBody().asString();
                ObjectMapper objectMapper = ConformanceUtil.createObjectMapper();
                try {
                    responseBankingTransactionList = objectMapper.readValue(json, ResponseBankingTransactionList.class);
                    conformanceErrors.addAll(payloadValidator.validateResponse(this.requestUrl, responseBankingTransactionList,
                            "getTransactions", statusCode));
                    ResponseBankingTransactionListData data = (ResponseBankingTransactionListData) getResponseData(responseBankingTransactionList);
                    List<BankingTransaction> transactions = getTransactions(data);
                    if (transactions != null) {
                        TxMetaPaginated meta = (TxMetaPaginated) getField(responseBankingTransactionList, "meta");
                        Boolean isQueryParamUnsupported = (Boolean) getField(meta, "isQueryParamUnsupported");
                        for (BankingTransaction transaction : transactions) {
                            checkAccountId(transaction, accountId, conformanceErrors);
                            checkOldestTime(transaction, oldestTime, conformanceErrors);
                            checkNewestTime(transaction, newestTime, conformanceErrors);
                            checkMinAmount(transaction, minAmount, conformanceErrors);
                            checkMaxAmount(transaction, maxAmount, conformanceErrors);
                            checkText(transaction, text, isQueryParamUnsupported, conformanceErrors);
                        }
                    }

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

    private void checkText(BankingTransaction transaction, String text, Boolean isQueryParamUnsupported, List<ConformanceError> errors) {
        if (!StringUtils.isBlank(text) && isTextQueryParamSupported(isQueryParamUnsupported)) {
            String description = (String) getField(transaction, "description");
            String reference = (String) getField(transaction, "reference");
            if ((description == null || !description.contains(text)) && (reference == null || !reference.contains(text))) {
                errors.add(new ConformanceError().errorType(DATA_NOT_MATCHING_CRITERIA)
                        .errorField(FieldUtils.getField(BankingTransaction.class, (description == null ? "reference" : "description"), true))
                        .dataJson(ConformanceUtil.toJson(transaction))
                        .errorMessage(String.format(
                                "BankingTransaction description (%s) or reference (%s) should contain: %s", description, reference, text)));
            }
        }
    }

    private boolean isTextQueryParamSupported(Boolean isQueryParamUnsupported) {
        return !Boolean.TRUE.equals(isQueryParamUnsupported);
    }

    private void checkMinAmount(BankingTransaction transaction, String minAmount, List<ConformanceError> errors) {
        if (!StringUtils.isBlank(minAmount)) {
            String amount = (String) getField(transaction, "amount");
            if (new BigDecimal(amount).compareTo(new BigDecimal(minAmount)) < 0) {
                errors.add(new ConformanceError().errorType(DATA_NOT_MATCHING_CRITERIA)
                        .errorField(FieldUtils.getField(BankingTransaction.class, "amount", true))
                        .dataJson(ConformanceUtil.toJson(transaction))
                        .errorMessage(String.format(
                                "BankingTransaction amount %s is less than min-amount %s", amount, minAmount)));
            }
        }
    }

    private void checkMaxAmount(BankingTransaction transaction, String maxAmount, List<ConformanceError> errors) {
        if (!StringUtils.isBlank(maxAmount)) {
            String amount = (String) getField(transaction, "amount");
            if (new BigDecimal(amount).compareTo(new BigDecimal(maxAmount)) > 0) {
                errors.add(new ConformanceError().errorType(DATA_NOT_MATCHING_CRITERIA)
                        .errorField(FieldUtils.getField(BankingTransaction.class, "amount", true))
                        .dataJson(ConformanceUtil.toJson(transaction))
                        .errorMessage(String.format(
                                "BankingTransaction amount %s is greater than max-amount %s", amount, maxAmount)));
            }
        }
    }

    private void checkOldestTime(BankingTransaction transaction, String oldestTime, List<ConformanceError> errors) {
        DateTime execTime = DateTime.parseRfc3339((String) getField(transaction, "executionDateTime"));
        if (StringUtils.isBlank(oldestTime)) {
            if (execTime.getValue() < System.currentTimeMillis() - NINETY_DAYS_IN_MILLIS) {
                errors.add(new ConformanceError().errorType(DATA_NOT_MATCHING_CRITERIA)
                        .errorField(FieldUtils.getField(BankingTransaction.class, "executionDateTime", true))
                        .dataJson(ConformanceUtil.toJson(transaction))
                        .errorMessage(String.format(
                                "BankingTransaction executionDateTime %s is before default 90 days", execTime)));
            }
        } else {
            long oldestTimeMillis = DateTime.parseRfc3339(oldestTime).getValue();
            if (execTime.getValue() < oldestTimeMillis) {
                errors.add(new ConformanceError().errorType(DATA_NOT_MATCHING_CRITERIA)
                        .errorField(FieldUtils.getField(BankingTransaction.class, "executionDateTime", true))
                        .dataJson(ConformanceUtil.toJson(transaction))
                        .errorMessage(String.format(
                                "BankingTransaction executionDateTime %s is before oldest-time %s", execTime, oldestTime)));
            }
        }
    }

    private void checkNewestTime(BankingTransaction transaction, String newestTime, List<ConformanceError> errors) {
        DateTime execTime = DateTime.parseRfc3339((String) getField(transaction, "executionDateTime"));
        if (StringUtils.isBlank(newestTime)) {
            ZoneOffset zoneOffset = ZoneOffset.ofTotalSeconds(execTime.getTimeZoneShift() * 60);
            if (execTime.getValue() >= LocalDate.now().plusDays(1).atStartOfDay().toInstant(zoneOffset).toEpochMilli()) {
                errors.add(new ConformanceError().errorType(DATA_NOT_MATCHING_CRITERIA)
                        .errorField(FieldUtils.getField(BankingTransaction.class, "executionDateTime", true))
                        .dataJson(ConformanceUtil.toJson(transaction))
                        .errorMessage(String.format(
                                "BankingTransaction executionDateTime %s is after today", execTime)));
            }
        } else {
            long newestTimeMillis = DateTime.parseRfc3339(newestTime).getValue();
            if (execTime.getValue() > newestTimeMillis) {
                errors.add(new ConformanceError().errorType(DATA_NOT_MATCHING_CRITERIA)
                        .errorField(FieldUtils.getField(BankingTransaction.class, "executionDateTime", true))
                        .dataJson(ConformanceUtil.toJson(transaction))
                        .errorMessage(String.format(
                                "BankingTransaction executionDateTime %s is after newest-time %s", execTime, newestTime)));
            }
        }
    }

    @SuppressWarnings("unchecked")
    private static List<BankingTransaction> getTransactions(Object obj) {
        return (List<BankingTransaction>) getField(obj, "transactions");
    }

    private static boolean validateGetTransactionsParams(String accountId, String oldestTime, String newestTime, String minAmount, String maxAmount,
                                                         String text, Integer page, Integer pageSize) {
        if (StringUtils.isBlank(accountId)) {
            return false;
        }
        if (!StringUtils.isBlank(oldestTime)) {
            try {
                DateTime.parseRfc3339(oldestTime);
            } catch (NumberFormatException e) {
                return false;
            }
        }
        if (!StringUtils.isBlank(newestTime)) {
            try {
                DateTime.parseRfc3339(newestTime);
            } catch (NumberFormatException e) {
                return false;
            }
        }
        if (!StringUtils.isBlank(minAmount)) {
            try {
                new BigDecimal(minAmount);
            } catch (IllegalArgumentException e) {
                return false;
            }
        }
        if (!StringUtils.isBlank(maxAmount)) {
            try {
                new BigDecimal(maxAmount);
            } catch (IllegalArgumentException e) {
                return false;
            }
        }
        return (page == null || page >= 1) && (pageSize == null || pageSize >= 1);
    }

    List<String> getTransactionIds() {
        String json = getTransactionsResponse.getBody().asString();
        ObjectMapper objectMapper = ConformanceUtil.createObjectMapper();
        try {
            responseBankingTransactionList = objectMapper.readValue(json, ResponseBankingTransactionList.class);
            if (responseBankingTransactionList != null) {
                ResponseBankingTransactionListData data = (ResponseBankingTransactionListData) getResponseData(responseBankingTransactionList);
                List<BankingTransaction> transactions = getTransactions(data);
                if (transactions != null && !transactions.isEmpty()) {
                    return transactions.stream().map(transaction -> getTransactionId(transaction)).collect(Collectors.toList());
                }
            }
        } catch (IOException e) {
            fail(e.getMessage());
        }
        return null;
    }

    private static String getTransactionId(Object data) {
        return (String) getField(data, "transactionId");
    }

    @Step("Request /banking/accounts/{accountId}/transactions/{transactionId}")
    public void getTransactionDetail(String accountId, String transactionId) {
        String url = getApiBasePath() + "/banking/accounts/" + accountId + "/transactions/" + transactionId;
        requestUrl = url;
        getTransactionDetailResponse = buildHeaders(given())
                .header(Header.VERSION.getKey(), payloadValidator.getEndpointVersion("getTransactionDetail"))
                .when().get(url).then().log().body().extract().response();
    }

    @Step("Validate /banking/accounts/{accountId}/transactions/{transactionId} response")
    public void validateGetTransactionDetailResponse(String accountId, String transactionId) {
        int statusCode = getTransactionDetailResponse.statusCode();
        if (transactionId.matches(CustomDataType.ASCII.getPattern())) {
            List<ConformanceError> conformanceErrors = new ArrayList<>();
            checkResponseHeaders(getTransactionDetailResponse, conformanceErrors);
            checkJsonContentType(getTransactionDetailResponse.contentType(), conformanceErrors);
            String json = getTransactionDetailResponse.getBody().asString();
            ObjectMapper objectMapper = ConformanceUtil.createObjectMapper();
            try {
                Class<?> expandedResponseClass = ConformanceUtil.expandModel(ResponseBankingTransactionById.class);
                Object responseBankingTransactionById = objectMapper.readValue(json, expandedResponseClass);
                conformanceErrors.addAll(payloadValidator.validateResponse(this.requestUrl, responseBankingTransactionById,
                        "getTransactionDetail", statusCode));
                Object data = getResponseData(responseBankingTransactionById);
                checkAccountId(data, accountId, conformanceErrors);
                checkTransactionId(data, transactionId, conformanceErrors);

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

    private void checkTransactionId(Object data, String transactionId, List<ConformanceError> conformanceErrors) {
        String id = getTransactionId(data);
        if (!id.equals(transactionId)) {
            conformanceErrors.add(new ConformanceError().errorType(DATA_NOT_MATCHING_CRITERIA)
                    .dataJson(ConformanceUtil.toJson(data)).errorMessage(String.format(
                            "Response transactionId %s does not match request transactionId %s", id, transactionId)));
        }
    }
}
