package au.org.consumerdatastandards.integration;

import au.org.consumerdatastandards.client.ApiException;
import au.org.consumerdatastandards.client.ApiResponse;
import au.org.consumerdatastandards.client.ConformanceError;
import au.org.consumerdatastandards.client.api.BankingAccountsAPI;
import au.org.consumerdatastandards.client.model.BankingAccount;
import au.org.consumerdatastandards.client.model.BankingAccountDetail;
import au.org.consumerdatastandards.client.model.BankingBalance;
import au.org.consumerdatastandards.client.model.BankingProductCategory;
import au.org.consumerdatastandards.client.model.ParamAccountOpenStatus;
import au.org.consumerdatastandards.client.model.RequestAccountIds;
import au.org.consumerdatastandards.client.model.RequestAccountIdsData;
import au.org.consumerdatastandards.client.model.ResponseBankingAccountById;
import au.org.consumerdatastandards.client.model.ResponseBankingAccountList;
import au.org.consumerdatastandards.client.model.ResponseBankingAccountsBalanceList;
import au.org.consumerdatastandards.integration.utils.ResponseCode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;
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
                "Conformance errors found in response payload: " + buildConformanceErrorsDescription(conformanceErrors));
    }

    @Test
    public void getAccountDetail() throws ApiException {
        ResponseBankingAccountList resp = api.listAccounts(null, null, null, null, 50);
        List<ConformanceError> conformanceErrors = new ArrayList<>();
        for (BankingAccount account : resp.getData().getAccounts()) {
            ApiResponse<ResponseBankingAccountById> accountDetail = api.getAccountDetailWithHttpInfo(account.getAccountId());
            Assertions.assertEquals(ResponseCode.OK.getCode(), accountDetail.getStatusCode());
            checkResponseHeaders(accountDetail.getHeaders(), conformanceErrors);
            if (!account.getAccountId().equals(accountDetail.getData().getData().getAccountId())) {
                conformanceErrors.add(new ConformanceError().errorType(DATA_NOT_MATCHING_CRITERIA)
                        .errorMessage(String.format(
                                "Unexpected accountId %s in response", account.getAccountId())));
            }
        }

        dumpConformanceErrors(conformanceErrors);

        Assertions.assertTrue(conformanceErrors.isEmpty(),
                "Conformance errors found in response payload: " + buildConformanceErrorsDescription(conformanceErrors));
    }

    @ParameterizedTest
    @CsvSource({
            "BUSINESS_LOANS,ALL,,,"
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
                "Conformance errors found in response payload: " + buildConformanceErrorsDescription(conformanceErrors));
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
                "Conformance errors found in response payload: " + buildConformanceErrorsDescription(conformanceErrors));
    }

    private void checkAccountInList(String accountId, List<String> idList, List<ConformanceError> conformanceErrors) {
        if (!idList.contains(accountId)) {
            conformanceErrors.add(new ConformanceError().errorType(DATA_NOT_MATCHING_CRITERIA)
                    .errorMessage(String.format(
                            "Unexpected accountId %s in response", accountId)));
        }
    }

    private void checkProductCategory(BankingProductCategory respProductCategory, BankingProductCategory productCategory, List<ConformanceError> errors) {
        if (productCategory != null) {
            if (respProductCategory == null || respProductCategory != productCategory) {
                errors.add(new ConformanceError().errorType(DATA_NOT_MATCHING_CRITERIA)
                        .errorMessage(String.format(
                                "BankingAccount productCategory %s does not match productCategory query %s",
                                respProductCategory, productCategory)));
            }
        }
    }

    private void checkOwned(Boolean accountOwned, Boolean isOwned, List<ConformanceError> errors) {
        if (isOwned != null) {
            if (!isOwned.equals(accountOwned)) {
                errors.add(new ConformanceError().errorType(DATA_NOT_MATCHING_CRITERIA)
                        .errorMessage(String.format(
                                "BankingAccount isOwned %b does not match isOwned query %b",
                                accountOwned, isOwned)));
            }
        }
    }

    private void checkOpenStatus(BankingAccount.OpenStatus accountOpenStatus, ParamAccountOpenStatus openStatus, List<ConformanceError> errors) {
        if (openStatus != null && openStatus != ParamAccountOpenStatus.ALL) {
            if (accountOpenStatus == null || !accountOpenStatus.name().equals(openStatus.name())) {
                errors.add(new ConformanceError().errorType(DATA_NOT_MATCHING_CRITERIA)
                        .errorMessage(String.format(
                                "BankingAccount openStatus %s does not match openStatus query %s",
                                (accountOpenStatus == null ? null : accountOpenStatus.name()), openStatus)));
            }
        }
    }
}
