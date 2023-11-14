package au.org.consumerdatastandards.integration.api.banking;

import au.org.consumerdatastandards.client.ApiException;
import au.org.consumerdatastandards.client.ApiResponse;
import au.org.consumerdatastandards.client.ConformanceError;
import au.org.consumerdatastandards.client.api.banking.BankingDirectDebitsAPI;
import au.org.consumerdatastandards.client.model.banking.BankingAccount;
import au.org.consumerdatastandards.client.model.banking.BankingAccountDetail;
import au.org.consumerdatastandards.client.model.banking.BankingDirectDebit;
import au.org.consumerdatastandards.client.model.banking.BankingProductCategory;
import au.org.consumerdatastandards.client.model.banking.ParamAccountOpenStatus;
import au.org.consumerdatastandards.client.model.banking.ResponseBankingAccountList;
import au.org.consumerdatastandards.client.model.banking.ResponseBankingDirectDebitAuthorisationList;
import au.org.consumerdatastandards.integration.utils.ResponseCode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BankingDirectDebitsIT extends BankingITBase {
    public BankingDirectDebitsIT() throws IOException, ApiException {
        super(new BankingDirectDebitsAPI());
    }

    @ParameterizedTest
    @CsvSource({
            "3,,"
    })
    public void listDirectDebits(int numAccounts, Integer page, Integer pageSize) throws ApiException {
        // The test uses up to numAccounts existing accounts
        ResponseBankingAccountList<BankingAccount> accounts = accountsAPI.listAccounts(null, null, null, 2, 1, numAccounts);
        List<ConformanceError> conformanceErrors = new ArrayList<>();
        for (BankingAccount account : accounts.getData().getAccounts()) {
            ApiResponse<ResponseBankingDirectDebitAuthorisationList> resp =
                    ((BankingDirectDebitsAPI) getAPI()).listDirectDebitsWithHttpInfo(account.getAccountId(), page, pageSize);
            Assertions.assertEquals(ResponseCode.OK.getCode(), resp.getStatusCode());
            checkResponseHeaders(resp.getHeaders(), conformanceErrors);
            for (BankingDirectDebit directDebit : resp.getBody().getData().getDirectDebitAuthorisations()) {
                checkAccountId(directDebit.getAccountId(), account.getAccountId(), conformanceErrors);
            }
        }
        dumpConformanceErrors(conformanceErrors);

        Assertions.assertTrue(conformanceErrors.isEmpty(),
                CONFORMANCE_ERRORS_FOUND + buildConformanceErrorsDescription(conformanceErrors));
    }

    @ParameterizedTest
    @CsvSource({
            "BUSINESS_LOANS,ALL,,,"
    })
    public void listDirectDebitsBulk(BankingProductCategory productCategory, ParamAccountOpenStatus openStatus,
                                     Boolean isOwned, Integer page, Integer pageSize) throws ApiException {
        ApiResponse<ResponseBankingDirectDebitAuthorisationList> resp =
                ((BankingDirectDebitsAPI)getAPI()).listDirectDebitsBulkWithHttpInfo(productCategory, openStatus, isOwned, page, pageSize);
        Assertions.assertEquals(ResponseCode.OK.getCode(), resp.getStatusCode());
        List<ConformanceError> conformanceErrors = new ArrayList<>();
        checkResponseHeaders(resp.getHeaders(), conformanceErrors);

        for (BankingDirectDebit directDebit : resp.getBody().getData().getDirectDebitAuthorisations()) {
            BankingAccountDetail accountDetail = accountsAPI.getAccountDetail(directDebit.getAccountId(), 1).getData();
            checkProductCategory(accountDetail.getProductCategory(), productCategory, conformanceErrors);
            checkOpenStatus(accountDetail.getOpenStatus(), openStatus, conformanceErrors);
            checkOwned(accountDetail.getIsOwned(), isOwned, conformanceErrors);
        }

        dumpConformanceErrors(conformanceErrors);

        Assertions.assertTrue(conformanceErrors.isEmpty(),
                CONFORMANCE_ERRORS_FOUND + buildConformanceErrorsDescription(conformanceErrors));
    }

    @ParameterizedTest
    @CsvSource({
            "3,,"
    })
    public void listDirectDebitsSpecificAccounts(int numAccounts, Integer page, Integer pageSize) throws ApiException {
        ResponseBankingAccountList<BankingAccount> accounts = accountsAPI.listAccounts(null, null, null, 2, 1, numAccounts);
        List<String> ids = accounts.getData().getAccounts().stream().map(BankingAccount::getAccountId).collect(Collectors.toList());
        ApiResponse<ResponseBankingDirectDebitAuthorisationList> resp =
                ((BankingDirectDebitsAPI) getAPI()).listDirectDebitsSpecificAccountsWithHttpInfo(getRequestAccountIds(ids), page, pageSize);
        Assertions.assertEquals(ResponseCode.OK.getCode(), resp.getStatusCode());
        List<ConformanceError> conformanceErrors = new ArrayList<>();
        checkResponseHeaders(resp.getHeaders(), conformanceErrors);

        for (BankingDirectDebit directDebit : resp.getBody().getData().getDirectDebitAuthorisations()) {
            checkAccountInList(directDebit.getAccountId(), ids, conformanceErrors);
        }

        dumpConformanceErrors(conformanceErrors);

        Assertions.assertTrue(conformanceErrors.isEmpty(),
                CONFORMANCE_ERRORS_FOUND + buildConformanceErrorsDescription(conformanceErrors));
    }
}
