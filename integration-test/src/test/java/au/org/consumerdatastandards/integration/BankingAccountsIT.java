package au.org.consumerdatastandards.integration;

import au.org.consumerdatastandards.client.ApiException;
import au.org.consumerdatastandards.client.ApiResponse;
import au.org.consumerdatastandards.client.ConformanceError;
import au.org.consumerdatastandards.client.api.BankingAccountsAPI;
import au.org.consumerdatastandards.client.model.BankingAccount;
import au.org.consumerdatastandards.client.model.BankingAccountDetail;
import au.org.consumerdatastandards.client.model.BankingBalance;
import au.org.consumerdatastandards.client.model.BankingProductCategory;
import au.org.consumerdatastandards.client.model.BankingTransaction;
import au.org.consumerdatastandards.client.model.BankingTransactionDetail;
import au.org.consumerdatastandards.client.model.ParamAccountOpenStatus;
import au.org.consumerdatastandards.client.model.RequestAccountIds;
import au.org.consumerdatastandards.client.model.RequestAccountIdsData;
import au.org.consumerdatastandards.client.model.ResponseBankingAccountById;
import au.org.consumerdatastandards.client.model.ResponseBankingAccountList;
import au.org.consumerdatastandards.client.model.ResponseBankingAccountsBalanceById;
import au.org.consumerdatastandards.client.model.ResponseBankingAccountsBalanceList;
import au.org.consumerdatastandards.client.model.ResponseBankingTransactionById;
import au.org.consumerdatastandards.client.model.ResponseBankingTransactionList;
import au.org.consumerdatastandards.integration.utils.ResponseCode;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static au.org.consumerdatastandards.client.ConformanceError.Type.DATA_NOT_MATCHING_CRITERIA;

public class BankingAccountsIT extends ITBase {
    private final BankingAccountsAPI api = new BankingAccountsAPI();

    public BankingAccountsIT() throws ApiException, IOException {
        super();
        api.setApiClient(clientFactory.create(true, false));
    }

    @ParameterizedTest
    @CsvSource({
            "BUSINESS_LOANS,ALL,,,"
    })
    public void listAccounts(BankingProductCategory productCategory, ParamAccountOpenStatus openStatus, Boolean isOwned, Integer page, Integer pageSize) throws ApiException {
        ApiResponse<ResponseBankingAccountList> resp = api.listAccountsWithHttpInfo(productCategory, openStatus, isOwned, page, pageSize);
        Assertions.assertEquals(ResponseCode.OK.getCode(), resp.getStatusCode());
        List<ConformanceError> conformanceErrors = new ArrayList<>();
        checkResponseHeaders(resp.getHeaders(), conformanceErrors);
        for (BankingAccount account : resp.getData().getData().getAccounts()) {
            checkProductCategory(account.getProductCategory(), productCategory, conformanceErrors);
            checkOwned(account.getIsOwned(), isOwned, conformanceErrors);
            checkOpenStatus(account.getOpenStatus(), openStatus, conformanceErrors);
        }

        dumpConformanceErrors(conformanceErrors);

        Assertions.assertTrue(conformanceErrors.isEmpty(),
                CONFORMANCE_ERRORS_FOUND + buildConformanceErrorsDescription(conformanceErrors));
    }

    @Test
    public void getAccountDetail() throws ApiException {
        ResponseBankingAccountList resp = api.listAccounts(null, null, null, null, 50);
        List<ConformanceError> conformanceErrors = new ArrayList<>();
        for (BankingAccount account : resp.getData().getAccounts()) {
            ApiResponse<ResponseBankingAccountById> accountDetail = api.getAccountDetailWithHttpInfo(account.getAccountId());
            Assertions.assertEquals(ResponseCode.OK.getCode(), accountDetail.getStatusCode());
            checkResponseHeaders(accountDetail.getHeaders(), conformanceErrors);
            checkAccountId(accountDetail.getData().getData().getAccountId(), account.getAccountId(), conformanceErrors);
        }

        dumpConformanceErrors(conformanceErrors);

        Assertions.assertTrue(conformanceErrors.isEmpty(),
                CONFORMANCE_ERRORS_FOUND + buildConformanceErrorsDescription(conformanceErrors));
    }

    private void checkAccountId(String accountId, String reqAccountId, List<ConformanceError> conformanceErrors) {
        if (!accountId.equals(reqAccountId)) {
            conformanceErrors.add(new ConformanceError().errorType(DATA_NOT_MATCHING_CRITERIA)
                    .errorMessage(String.format(
                            "Response accountId %s does not match request accountId %s", accountId, reqAccountId)));
        }
    }

    @ParameterizedTest
    @CsvSource({
            "RmrxLLD7blXRhplXn9S3uCq0WafZrZ1EE693WngNwB8"
    })
    public void getBalance(String accountId) throws ApiException {
        ApiResponse<ResponseBankingAccountsBalanceById> resp = api.getBalanceWithHttpInfo(accountId);
        Assertions.assertEquals(ResponseCode.OK.getCode(), resp.getStatusCode());
        List<ConformanceError> conformanceErrors = new ArrayList<>();
        checkResponseHeaders(resp.getHeaders(), conformanceErrors);
        checkAccountId(resp.getData().getData().getAccountId(), accountId, conformanceErrors);

        dumpConformanceErrors(conformanceErrors);

        Assertions.assertTrue(conformanceErrors.isEmpty(),
                CONFORMANCE_ERRORS_FOUND + buildConformanceErrorsDescription(conformanceErrors));
    }

    @ParameterizedTest
    @CsvSource({
            "TRANS_AND_SAVINGS_ACCOUNTS,OPEN,,,"
    })
    public void listBalancesBulk(BankingProductCategory productCategory, ParamAccountOpenStatus openStatus, Boolean isOwned, Integer page, Integer pageSize) throws ApiException {
        ApiResponse<ResponseBankingAccountsBalanceList> resp = api.listBalancesBulkWithHttpInfo(productCategory, openStatus, isOwned, page, pageSize);
        Assertions.assertEquals(ResponseCode.OK.getCode(), resp.getStatusCode());
        List<ConformanceError> conformanceErrors = new ArrayList<>();
        checkResponseHeaders(resp.getHeaders(), conformanceErrors);
        for (BankingBalance acc : resp.getData().getData().getBalances()) {
            BankingAccountDetail account = api.getAccountDetail(acc.getAccountId()).getData();
            checkProductCategory(account.getProductCategory(), productCategory, conformanceErrors);
            checkOwned(account.getIsOwned(), isOwned, conformanceErrors);
            checkOpenStatus(account.getOpenStatus(), openStatus, conformanceErrors);
        }

        dumpConformanceErrors(conformanceErrors);

        Assertions.assertTrue(conformanceErrors.isEmpty(),
                CONFORMANCE_ERRORS_FOUND + buildConformanceErrorsDescription(conformanceErrors));
    }

    @ParameterizedTest
    @CsvSource({
            "1234567 2345567 3456789,,"
    })
    public void listBalancesSpecificAccounts(String accountIds, Integer page, Integer pageSize) throws ApiException {
        RequestAccountIds accIds = new RequestAccountIds();
        RequestAccountIdsData data = new RequestAccountIdsData();
        List<String> idList = Arrays.asList(accountIds.split(" "));
        data.setAccountIds(idList);
        accIds.setData(data);
        ApiResponse<ResponseBankingAccountsBalanceList> resp = api.listBalancesSpecificAccountsWithHttpInfo(accIds, page, pageSize);
        Assertions.assertEquals(ResponseCode.OK.getCode(), resp.getStatusCode());
        List<ConformanceError> conformanceErrors = new ArrayList<>();
        checkResponseHeaders(resp.getHeaders(), conformanceErrors);
        for (BankingBalance bal : resp.getData().getData().getBalances()) {
            checkAccountInList(bal.getAccountId(), idList, conformanceErrors);
        }

        dumpConformanceErrors(conformanceErrors);

        Assertions.assertTrue(conformanceErrors.isEmpty(),
                CONFORMANCE_ERRORS_FOUND + buildConformanceErrorsDescription(conformanceErrors));
    }

    @ParameterizedTest
    @CsvSource({
            "1234567,,,,,,,"
    })
    public void getTransactions(String accountId, OffsetDateTime oldestTime, OffsetDateTime newestTime, String minAmount,
                                String maxAmount, String text, Integer page, Integer pageSize) throws ApiException {
        ApiResponse<ResponseBankingTransactionList> resp = api.getTransactionsWithHttpInfo(accountId, oldestTime, newestTime, minAmount, maxAmount, text, page, pageSize);
        Assertions.assertEquals(ResponseCode.OK.getCode(), resp.getStatusCode());
        List<ConformanceError> conformanceErrors = new ArrayList<>();
        checkResponseHeaders(resp.getHeaders(), conformanceErrors);
        for (BankingTransaction tx : resp.getData().getData().getTransactions()) {
            checkAccountId(tx.getAccountId(), accountId, conformanceErrors);
            checkOldestTime(tx.getExecutionDateTime(), oldestTime, newestTime, conformanceErrors);
            checkNewestTime(tx.getExecutionDateTime(), newestTime, conformanceErrors);
            checkMinAmount(tx.getAmount(), minAmount, conformanceErrors);
            checkMaxAmount(tx.getAmount(), maxAmount, conformanceErrors);
            checkText(tx.getDescription(), tx.getReference(), text, resp.getData().getMeta().isQueryParamUnsupported(), conformanceErrors);
        }

        dumpConformanceErrors(conformanceErrors);

        Assertions.assertTrue(conformanceErrors.isEmpty(),
                BankingAccountsIT.CONFORMANCE_ERRORS_FOUND + buildConformanceErrorsDescription(conformanceErrors));
    }

    @ParameterizedTest
    @CsvSource({
            "1234567"
    })
    public void getTransactionDetail(String accountId) throws ApiException {
        ResponseBankingTransactionList resp = api.getTransactions(accountId, null, null, null, null, null, null, null);
        List<ConformanceError> conformanceErrors = new ArrayList<>();
        for (BankingTransaction tx : resp.getData().getTransactions()) {
            ApiResponse<ResponseBankingTransactionById> detail = api.getTransactionDetailWithHttpInfo(accountId, tx.getTransactionId());
            Assertions.assertEquals(ResponseCode.OK.getCode(), detail.getStatusCode());
            checkResponseHeaders(detail.getHeaders(), conformanceErrors);
            BankingTransactionDetail transactionDetail = detail.getData().getData();
            checkAccountId(transactionDetail.getAccountId(), accountId, conformanceErrors);
            checkTransactionId(transactionDetail.getTransactionId(), tx.getTransactionId(), conformanceErrors);
        }

        dumpConformanceErrors(conformanceErrors);

        Assertions.assertTrue(conformanceErrors.isEmpty(),
                BankingAccountsIT.CONFORMANCE_ERRORS_FOUND + buildConformanceErrorsDescription(conformanceErrors));
    }

    private void checkTransactionId(String id, String transactionId, List<ConformanceError> conformanceErrors) {
        if (!id.equals(transactionId)) {
            conformanceErrors.add(new ConformanceError().errorType(DATA_NOT_MATCHING_CRITERIA)
                    .errorMessage(String.format(
                            "Response transactionId %s does not match request transactionId %s", id, transactionId)));
        }
    }

    private void checkMinAmount(String amount, String minAmount, List<ConformanceError> errors) {
        if (StringUtils.isNotBlank(minAmount) && new BigDecimal(amount).compareTo(new BigDecimal(minAmount)) < 0) {
            errors.add(new ConformanceError().errorType(DATA_NOT_MATCHING_CRITERIA)
                    .errorMessage(String.format(
                            "BankingTransaction amount %s is less than min-amount %s", amount, minAmount)));
        }
    }

    private void checkMaxAmount(String amount, String maxAmount, List<ConformanceError> errors) {
        if (StringUtils.isNotBlank(maxAmount) && new BigDecimal(amount).compareTo(new BigDecimal(maxAmount)) > 0) {
            errors.add(new ConformanceError().errorType(DATA_NOT_MATCHING_CRITERIA)
                    .errorMessage(String.format(
                            "BankingTransaction amount %s is greater than max-amount %s", amount, maxAmount)));
        }
    }

    private void checkText(String description, String reference, String text, Boolean isQueryParamUnsupported, List<ConformanceError> errors) {
        if (StringUtils.isNotBlank(text) && isTextQueryParamSupported(isQueryParamUnsupported) &&
                (description == null || !description.contains(text)) && (reference == null || !reference.contains(text))) {
            errors.add(new ConformanceError().errorType(DATA_NOT_MATCHING_CRITERIA)
                    .errorMessage(String.format(
                            "BankingTransaction description (%s) or reference (%s) should contain: %s", description, reference, text)));
        }
    }

    private boolean isTextQueryParamSupported(Boolean isQueryParamUnsupported) {
        return !Boolean.TRUE.equals(isQueryParamUnsupported);
    }

    private void checkOldestTime(OffsetDateTime execTime, OffsetDateTime oldestTime, OffsetDateTime newestTime,
                                 List<ConformanceError> errors) {
        if (oldestTime == null) {
            if (execTime.toLocalDate().isBefore((newestTime == null ?
                    LocalDate.now() : newestTime.toLocalDate()).minusDays(90))) {
                errors.add(new ConformanceError().errorType(DATA_NOT_MATCHING_CRITERIA)
                        .errorMessage(String.format(
                                "BankingTransaction executionDateTime %s is before default 90 days", execTime)));
            }
        } else if (execTime.isBefore(oldestTime)) {
            errors.add(new ConformanceError().errorType(DATA_NOT_MATCHING_CRITERIA)
                    .errorMessage(String.format(
                            "BankingTransaction executionDateTime %s is before oldest-time %s", execTime, oldestTime)));
        }
    }

    private void checkNewestTime(OffsetDateTime execTime, OffsetDateTime newestTime, List<ConformanceError> errors) {
        if (newestTime == null) {
            if (execTime.toLocalDate().isAfter(LocalDate.now())) {
                errors.add(new ConformanceError().errorType(DATA_NOT_MATCHING_CRITERIA)
                        .errorMessage(String.format(
                                "BankingTransaction executionDateTime %s is after today", execTime)));
            }
        } else if (execTime.isAfter(newestTime)) {
            errors.add(new ConformanceError().errorType(DATA_NOT_MATCHING_CRITERIA)
                    .errorMessage(String.format(
                            "BankingTransaction executionDateTime %s is after newest-time %s", execTime, newestTime)));
        }
    }

    private void checkAccountInList(String accountId, List<String> idList, List<ConformanceError> conformanceErrors) {
        if (!idList.contains(accountId)) {
            conformanceErrors.add(new ConformanceError().errorType(DATA_NOT_MATCHING_CRITERIA)
                    .errorMessage(String.format(
                            "Unexpected accountId %s in response", accountId)));
        }
    }

    private void checkProductCategory(BankingProductCategory respProductCategory, BankingProductCategory productCategory, List<ConformanceError> errors) {
        if (productCategory != null && (respProductCategory == null || respProductCategory != productCategory)) {
            errors.add(new ConformanceError().errorType(DATA_NOT_MATCHING_CRITERIA)
                    .errorMessage(String.format(
                            "BankingAccount productCategory %s does not match productCategory query %s",
                            respProductCategory, productCategory)));
        }
    }

    private void checkOwned(Boolean accountOwned, Boolean isOwned, List<ConformanceError> errors) {
        if (isOwned != null && !isOwned.equals(accountOwned)) {
            errors.add(new ConformanceError().errorType(DATA_NOT_MATCHING_CRITERIA)
                    .errorMessage(String.format(
                            "BankingAccount isOwned %b does not match isOwned query %b",
                            accountOwned, isOwned)));
        }
    }

    private void checkOpenStatus(BankingAccount.OpenStatus accountOpenStatus, ParamAccountOpenStatus openStatus, List<ConformanceError> errors) {
        if (openStatus != null && openStatus != ParamAccountOpenStatus.ALL &&
                (accountOpenStatus == null || !accountOpenStatus.name().equals(openStatus.name()))) {
            errors.add(new ConformanceError().errorType(DATA_NOT_MATCHING_CRITERIA)
                    .errorMessage(String.format(
                            "BankingAccount openStatus %s does not match openStatus query %s",
                            (accountOpenStatus == null ? null : accountOpenStatus.name()), openStatus)));
        }
    }
}
