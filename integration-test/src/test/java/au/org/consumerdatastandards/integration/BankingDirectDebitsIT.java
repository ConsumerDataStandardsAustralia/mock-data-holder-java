package au.org.consumerdatastandards.integration;

import au.org.consumerdatastandards.client.ApiException;
import au.org.consumerdatastandards.client.ApiResponse;
import au.org.consumerdatastandards.client.ConformanceError;
import au.org.consumerdatastandards.client.api.BankingAccountsAPI;
import au.org.consumerdatastandards.client.api.BankingDirectDebitsAPI;
import au.org.consumerdatastandards.client.model.BankingAccountDetail;
import au.org.consumerdatastandards.client.model.BankingDirectDebit;
import au.org.consumerdatastandards.client.model.BankingProductCategory;
import au.org.consumerdatastandards.client.model.ParamAccountOpenStatus;
import au.org.consumerdatastandards.client.model.RequestAccountIds;
import au.org.consumerdatastandards.client.model.ResponseBankingDirectDebitAuthorisationList;
import au.org.consumerdatastandards.integration.utils.ResponseCode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BankingDirectDebitsIT extends ProtectedITBase {
    public BankingDirectDebitsIT() throws IOException, ApiException {
        super(new BankingDirectDebitsAPI());
    }

    @ParameterizedTest
    @CsvSource({
            "1234567 2345567 3456789,,"
    })
    public void listDirectDebits(String accountId, Integer page, Integer pageSize) throws ApiException {
        ApiResponse<ResponseBankingDirectDebitAuthorisationList> resp =
                ((BankingDirectDebitsAPI)getAPI()).listDirectDebitsWithHttpInfo(accountId, page, pageSize);
        Assertions.assertEquals(ResponseCode.OK.getCode(), resp.getStatusCode());
        List<ConformanceError> conformanceErrors = new ArrayList<>();
        checkResponseHeaders(resp.getHeaders(), conformanceErrors);
        for (BankingDirectDebit directDebit : resp.getData().getData().getDirectDebitAuthorisations()) {
            checkAccountId(directDebit.getAccountId(), accountId, conformanceErrors);
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

        BankingAccountsAPI accountsAPI = new BankingAccountsAPI();
        accountsAPI.setApiClient(getAPI().getApiClient());
        for (BankingDirectDebit directDebit : resp.getData().getData().getDirectDebitAuthorisations()) {
            BankingAccountDetail accountDetail = accountsAPI.getAccountDetail(directDebit.getAccountId()).getData();
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
            "1234567 2345567 3456789,,"
    })
    public void listDirectDebitsSpecificAccounts(String accountIds, Integer page, Integer pageSize) throws ApiException {
        RequestAccountIds idList = getRequestAccountIds(accountIds);
        ApiResponse<ResponseBankingDirectDebitAuthorisationList> resp =
                ((BankingDirectDebitsAPI) getAPI()).listDirectDebitsSpecificAccountsWithHttpInfo(idList, page, pageSize);
        Assertions.assertEquals(ResponseCode.OK.getCode(), resp.getStatusCode());
        List<ConformanceError> conformanceErrors = new ArrayList<>();
        checkResponseHeaders(resp.getHeaders(), conformanceErrors);

        for (BankingDirectDebit directDebit : resp.getData().getData().getDirectDebitAuthorisations()) {
            checkAccountInList(directDebit.getAccountId(), idList.getData().getAccountIds(), conformanceErrors);
        }

        dumpConformanceErrors(conformanceErrors);

        Assertions.assertTrue(conformanceErrors.isEmpty(),
                CONFORMANCE_ERRORS_FOUND + buildConformanceErrorsDescription(conformanceErrors));
    }
}
