package au.org.consumerdatastandards.integration.api.banking;

import au.org.consumerdatastandards.client.ApiException;
import au.org.consumerdatastandards.client.ApiResponse;
import au.org.consumerdatastandards.client.ConformanceError;
import au.org.consumerdatastandards.client.api.banking.BankingAccountsAPI;
import au.org.consumerdatastandards.client.model.banking.BankingAccount;
import au.org.consumerdatastandards.client.model.banking.BankingAccountDetail;
import au.org.consumerdatastandards.client.model.banking.BankingAccountV2;
import au.org.consumerdatastandards.client.model.banking.BankingBalance;
import au.org.consumerdatastandards.client.model.banking.BankingProductCategory;
import au.org.consumerdatastandards.client.model.banking.BankingTransaction;
import au.org.consumerdatastandards.client.model.banking.BankingTransactionDetail;
import au.org.consumerdatastandards.client.model.banking.ParamAccountOpenStatus;
import au.org.consumerdatastandards.client.model.banking.RequestAccountIds;
import au.org.consumerdatastandards.client.model.banking.ResponseBankingAccountById;
import au.org.consumerdatastandards.client.model.banking.ResponseBankingAccountList;
import au.org.consumerdatastandards.client.model.banking.ResponseBankingAccountsBalanceById;
import au.org.consumerdatastandards.client.model.banking.ResponseBankingAccountsBalanceList;
import au.org.consumerdatastandards.client.model.banking.ResponseBankingTransactionById;
import au.org.consumerdatastandards.client.model.banking.ResponseBankingTransactionList;
import au.org.consumerdatastandards.integration.utils.ResponseCode;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static au.org.consumerdatastandards.client.ConformanceError.Type.DATA_NOT_MATCHING_CRITERIA;

public class BankingAccountsIT extends BankingITBase {
    public BankingAccountsIT() throws ApiException, IOException {
        super();
    }

    @ParameterizedTest
    @CsvSource({
            "BUSINESS_LOANS,ALL,,,"
    })
    public void listAccountsV1(BankingProductCategory productCategory, ParamAccountOpenStatus openStatus, Boolean isOwned,
                             Integer page, Integer pageSize) throws ApiException {
        ApiResponse<ResponseBankingAccountList<BankingAccount>> resp =
                ((BankingAccountsAPI)getAPI()).listAccountsWithHttpInfo(productCategory, openStatus, isOwned, 1, page, pageSize);
        Assertions.assertEquals(ResponseCode.OK.getCode(), resp.getStatusCode());
        List<ConformanceError> conformanceErrors = new ArrayList<>();
        checkResponseHeaders(resp.getHeaders(), conformanceErrors);
        for (BankingAccount account : resp.getBody().getData().getAccounts()) {
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
            "BUSINESS_LOANS,ALL,,,"
    })
    public void listAccountsV2(BankingProductCategory productCategory, ParamAccountOpenStatus openStatus, Boolean isOwned,
                             Integer page, Integer pageSize) throws ApiException {
        ApiResponse<ResponseBankingAccountList<BankingAccountV2>> resp =
                ((BankingAccountsAPI)getAPI()).listAccountsWithHttpInfo(productCategory, openStatus, isOwned, 2, page, pageSize);
        Assertions.assertEquals(ResponseCode.OK.getCode(), resp.getStatusCode());
        List<ConformanceError> conformanceErrors = new ArrayList<>();
        checkResponseHeaders(resp.getHeaders(), conformanceErrors);
        for (BankingAccountV2 account : resp.getBody().getData().getAccounts()) {
            checkProductCategory(account.getProductCategory(), productCategory, conformanceErrors);
            checkOwned(account.getIsOwned(), isOwned, conformanceErrors);
            checkOpenStatus(account.getOpenStatus(), openStatus, conformanceErrors);
        }

        dumpConformanceErrors(conformanceErrors);

        Assertions.assertTrue(conformanceErrors.isEmpty(),
                CONFORMANCE_ERRORS_FOUND + buildConformanceErrorsDescription(conformanceErrors));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void getAccountDetail(int version) throws ApiException {
        ResponseBankingAccountList<BankingAccount> resp =
                ((BankingAccountsAPI)getAPI()).listAccounts(null, null, null, 1, null, 50);
        List<ConformanceError> conformanceErrors = new ArrayList<>();
        for (BankingAccount account : resp.getData().getAccounts()) {
            ApiResponse<ResponseBankingAccountById> accountDetail = ((BankingAccountsAPI)getAPI()).getAccountDetailWithHttpInfo(account.getAccountId(), version);
            Assertions.assertEquals(ResponseCode.OK.getCode(), accountDetail.getStatusCode());
            checkResponseHeaders(accountDetail.getHeaders(), conformanceErrors);
            checkAccountId(accountDetail.getBody().getData().getAccountId(), account.getAccountId(), conformanceErrors);
        }

        dumpConformanceErrors(conformanceErrors);

        Assertions.assertTrue(conformanceErrors.isEmpty(),
                CONFORMANCE_ERRORS_FOUND + buildConformanceErrorsDescription(conformanceErrors));
    }

    @ParameterizedTest
    @CsvSource({
            "1"
    })
    public void getBalance(int numAccounts) throws ApiException {
        List<ConformanceError> conformanceErrors = new ArrayList<>();
        ResponseBankingAccountList<BankingAccount> accounts = ((BankingAccountsAPI) getAPI()).listAccounts(null, null, null, 2, 1, numAccounts);

        for (BankingAccount account : accounts.getData().getAccounts()) {
            ApiResponse<ResponseBankingAccountsBalanceById> resp = ((BankingAccountsAPI) getAPI()).getBalanceWithHttpInfo(account.getAccountId());
            Assertions.assertEquals(ResponseCode.OK.getCode(), resp.getStatusCode());
            checkResponseHeaders(resp.getHeaders(), conformanceErrors);
            checkAccountId(resp.getBody().getData().getAccountId(), account.getAccountId(), conformanceErrors);
        }
        dumpConformanceErrors(conformanceErrors);

        Assertions.assertTrue(conformanceErrors.isEmpty(),
                CONFORMANCE_ERRORS_FOUND + buildConformanceErrorsDescription(conformanceErrors));
    }

    @ParameterizedTest
    @CsvSource({
            "TRANS_AND_SAVINGS_ACCOUNTS,OPEN,,,"
    })
    public void listBalancesBulk(BankingProductCategory productCategory, ParamAccountOpenStatus openStatus, Boolean isOwned, Integer page, Integer pageSize) throws ApiException {
        ApiResponse<ResponseBankingAccountsBalanceList> resp =
                ((BankingAccountsAPI)getAPI()).listBalancesBulkWithHttpInfo(productCategory, openStatus, isOwned, page, pageSize);
        Assertions.assertEquals(ResponseCode.OK.getCode(), resp.getStatusCode());
        List<ConformanceError> conformanceErrors = new ArrayList<>();
        checkResponseHeaders(resp.getHeaders(), conformanceErrors);
        for (BankingBalance acc : resp.getBody().getData().getBalances()) {
            BankingAccountDetail account = ((BankingAccountsAPI)getAPI()).getAccountDetail(acc.getAccountId(), 1).getData();
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
    public void listBalancesSpecificAccounts_unavailabe(String accountIds, Integer page, Integer pageSize) {
        RequestAccountIds accIds = getRequestAccountIds(Arrays.asList(accountIds.split(" ")));
        try {
            ((BankingAccountsAPI)getAPI()).listBalancesSpecificAccountsWithHttpInfo(accIds, page, pageSize);
            Assertions.fail("The test should result in error");
        } catch (ApiException e) {
            Assertions.assertTrue(
                    e.getResponseBody().contains("urn:au-cds:error:cds-banking:Authorisation/UnavailableBankingAccount"),
                    "Response doesn't contain the UnavailableBankingAccount message");
            Assertions.assertTrue(
                    e.getResponseBody().contains("1234567"),
                    "Response doesn't reference account 1234567");
            Assertions.assertTrue(
                    e.getResponseBody().contains("2345567"),
                    "Response doesn't reference account 2345567");
            Assertions.assertTrue(
                    e.getResponseBody().contains("3456789"),
                    "Response doesn't reference account 3456789");
        }
    }

    @ParameterizedTest
    @CsvSource("3,,")
    public void listBalancesSpecificAccounts(int numAccounts, Integer page, Integer pageSize) throws ApiException {
        ResponseBankingAccountList<BankingAccount> accounts = ((BankingAccountsAPI) getAPI()).listAccounts(null, null, null, 2, 1, numAccounts);
        RequestAccountIds accIds = getRequestAccountIds(accounts.getData().getAccounts().stream().map(BankingAccount::getAccountId).collect(Collectors.toList()));
        ApiResponse<ResponseBankingAccountsBalanceList> resp =
                ((BankingAccountsAPI) getAPI()).listBalancesSpecificAccountsWithHttpInfo(accIds, page, pageSize);
        Assertions.assertEquals(ResponseCode.OK.getCode(), resp.getStatusCode());
        List<ConformanceError> conformanceErrors = new ArrayList<>();
        checkResponseHeaders(resp.getHeaders(), conformanceErrors);
        for (BankingBalance bal : resp.getBody().getData().getBalances()) {
            checkAccountInList(bal.getAccountId(), accIds.getData().getAccountIds(), conformanceErrors);
        }

        dumpConformanceErrors(conformanceErrors);

        Assertions.assertTrue(conformanceErrors.isEmpty(),
                CONFORMANCE_ERRORS_FOUND + buildConformanceErrorsDescription(conformanceErrors));
    }

    @ParameterizedTest
    @CsvSource("3,,,,,,,")
    public void getTransactions(int numAccounts, OffsetDateTime oldestTime, OffsetDateTime newestTime, String minAmount,
                                String maxAmount, String text, Integer page, Integer pageSize) throws ApiException {
        ResponseBankingAccountList<BankingAccount> accounts = ((BankingAccountsAPI) getAPI()).listAccounts(null, null, null, 2, 1, numAccounts);
        List<ConformanceError> conformanceErrors = new ArrayList<>();
        for (BankingAccount account : accounts.getData().getAccounts()) {
            ApiResponse<ResponseBankingTransactionList> resp =
                    ((BankingAccountsAPI)getAPI()).getTransactionsWithHttpInfo(account.getAccountId(), oldestTime, newestTime, minAmount, maxAmount, text, page, pageSize);
            Assertions.assertEquals(ResponseCode.OK.getCode(), resp.getStatusCode());
            checkResponseHeaders(resp.getHeaders(), conformanceErrors);
            for (BankingTransaction tx : resp.getBody().getData().getTransactions()) {
                checkAccountId(tx.getAccountId(), account.getAccountId(), conformanceErrors);
                OffsetDateTime execTime = tx.getExecutionDateTime();
                if (execTime != null) {
                    checkOldestTime(execTime, oldestTime, newestTime, conformanceErrors);
                    checkNewestTime(execTime, newestTime, conformanceErrors);
                }
                checkMinAmount(tx.getAmount(), minAmount, conformanceErrors);
                checkMaxAmount(tx.getAmount(), maxAmount, conformanceErrors);
                checkText(tx.getDescription(), tx.getReference(), text, resp.getBody().getMeta().isQueryParamUnsupported(), conformanceErrors);
            }
        }

        dumpConformanceErrors(conformanceErrors);

        Assertions.assertTrue(conformanceErrors.isEmpty(),
                BankingAccountsIT.CONFORMANCE_ERRORS_FOUND + buildConformanceErrorsDescription(conformanceErrors));
    }

    @ParameterizedTest
    @CsvSource("3,,")
    public void getTransactionDetail(int numAccounts) throws ApiException {
        ResponseBankingAccountList<BankingAccount> accounts = ((BankingAccountsAPI) getAPI()).listAccounts(null, null, null, 2, 1, numAccounts);
        List<ConformanceError> conformanceErrors = new ArrayList<>();
        for (BankingAccount account : accounts.getData().getAccounts()) {
            ResponseBankingTransactionList resp = ((BankingAccountsAPI) getAPI()).getTransactions(account.getAccountId(), null, null, null, null, null, null, null);
            for (BankingTransaction tx : resp.getData().getTransactions()) {
                ApiResponse<ResponseBankingTransactionById> detail =
                        ((BankingAccountsAPI) getAPI()).getTransactionDetailWithHttpInfo(account.getAccountId(), tx.getTransactionId());
                Assertions.assertEquals(ResponseCode.OK.getCode(), detail.getStatusCode());
                checkResponseHeaders(detail.getHeaders(), conformanceErrors);
                BankingTransactionDetail transactionDetail = detail.getBody().getData();
                checkAccountId(transactionDetail.getAccountId(), account.getAccountId(), conformanceErrors);
                checkTransactionId(transactionDetail.getTransactionId(), tx.getTransactionId(), conformanceErrors);
            }
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
}
