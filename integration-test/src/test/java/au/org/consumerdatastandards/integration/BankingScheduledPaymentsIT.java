package au.org.consumerdatastandards.integration;

import au.org.consumerdatastandards.client.ApiException;
import au.org.consumerdatastandards.client.ApiResponse;
import au.org.consumerdatastandards.client.ConformanceError;
import au.org.consumerdatastandards.client.api.BankingAccountsAPI;
import au.org.consumerdatastandards.client.api.BankingScheduledPaymentsAPI;
import au.org.consumerdatastandards.client.model.BankingAccountDetail;
import au.org.consumerdatastandards.client.model.BankingProductCategory;
import au.org.consumerdatastandards.client.model.BankingScheduledPayment;
import au.org.consumerdatastandards.client.model.ParamAccountOpenStatus;
import au.org.consumerdatastandards.client.model.RequestAccountIds;
import au.org.consumerdatastandards.client.model.ResponseBankingScheduledPaymentsList;
import au.org.consumerdatastandards.integration.utils.ResponseCode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BankingScheduledPaymentsIT extends ProtectedITBase {
    public BankingScheduledPaymentsIT() throws IOException, ApiException {
        super(new BankingScheduledPaymentsAPI());
    }

    @ParameterizedTest
    @CsvSource({
            "BUSINESS_LOANS,ALL,,,"
    })
    public void listScheduledPaymentsBulk(BankingProductCategory productCategory, ParamAccountOpenStatus openStatus,
                                          Boolean isOwned, Integer page, Integer pageSize) throws ApiException {
        ApiResponse<ResponseBankingScheduledPaymentsList> resp = ((BankingScheduledPaymentsAPI) getAPI())
                .listScheduledPaymentsBulkWithHttpInfo(productCategory, openStatus, isOwned, page, pageSize);
        Assertions.assertEquals(ResponseCode.OK.getCode(), resp.getStatusCode());
        List<ConformanceError> conformanceErrors = new ArrayList<>();
        checkResponseHeaders(resp.getHeaders(), conformanceErrors);

        BankingAccountsAPI accountsAPI = new BankingAccountsAPI();
        accountsAPI.setApiClient(getAPI().getApiClient());
        for (BankingScheduledPayment payment : resp.getData().getData().getScheduledPayments()) {
            BankingAccountDetail accountDetail = accountsAPI.getAccountDetail(payment.getFrom().getAccountId()).getData();
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
            "1234567,,"
    })
    public void listScheduledPayments(String accountId, Integer page, Integer pageSize) throws ApiException {
        ApiResponse<ResponseBankingScheduledPaymentsList> resp = ((BankingScheduledPaymentsAPI) getAPI())
                .listScheduledPaymentsWithHttpInfo(accountId, page, pageSize);
        Assertions.assertEquals(ResponseCode.OK.getCode(), resp.getStatusCode());
        List<ConformanceError> conformanceErrors = new ArrayList<>();
        checkResponseHeaders(resp.getHeaders(), conformanceErrors);
        for (BankingScheduledPayment scheduledPayment : resp.getData().getData().getScheduledPayments()) {
            checkAccountId(scheduledPayment.getFrom().getAccountId(), accountId, conformanceErrors);
        }

        dumpConformanceErrors(conformanceErrors);

        Assertions.assertTrue(conformanceErrors.isEmpty(),
                CONFORMANCE_ERRORS_FOUND + buildConformanceErrorsDescription(conformanceErrors));
    }

    @ParameterizedTest
    @CsvSource({
            "1234567 2345567 3456789,,"
    })
    public void listScheduledPaymentsSpecificAccounts(String accountIds, Integer page, Integer pageSize) throws ApiException {
        RequestAccountIds idList = getRequestAccountIds(accountIds);
        ApiResponse<ResponseBankingScheduledPaymentsList> resp = ((BankingScheduledPaymentsAPI) getAPI())
                .listScheduledPaymentsSpecificAccountsWithHttpInfo(idList, page, pageSize);
        Assertions.assertEquals(ResponseCode.OK.getCode(), resp.getStatusCode());
        List<ConformanceError> conformanceErrors = new ArrayList<>();
        checkResponseHeaders(resp.getHeaders(), conformanceErrors);
        for (BankingScheduledPayment payment : resp.getData().getData().getScheduledPayments()) {
            checkAccountInList(payment.getFrom().getAccountId(), idList.getData().getAccountIds(), conformanceErrors);
        }

        dumpConformanceErrors(conformanceErrors);

        Assertions.assertTrue(conformanceErrors.isEmpty(),
                CONFORMANCE_ERRORS_FOUND + buildConformanceErrorsDescription(conformanceErrors));
    }
}
