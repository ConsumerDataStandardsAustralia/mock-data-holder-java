package au.org.consumerdatastandards.integration.api.banking;

import au.org.consumerdatastandards.client.ApiException;
import au.org.consumerdatastandards.client.ApiResponse;
import au.org.consumerdatastandards.client.ConformanceError;
import au.org.consumerdatastandards.client.api.banking.BankingAccountsAPI;
import au.org.consumerdatastandards.client.api.banking.BankingScheduledPaymentsAPI;
import au.org.consumerdatastandards.client.model.banking.BankingAccountDetail;
import au.org.consumerdatastandards.client.model.banking.BankingProductCategory;
import au.org.consumerdatastandards.client.model.banking.BankingScheduledPayment;
import au.org.consumerdatastandards.client.model.banking.BankingScheduledPaymentTo;
import au.org.consumerdatastandards.client.model.banking.ParamAccountOpenStatus;
import au.org.consumerdatastandards.client.model.banking.RequestAccountIds;
import au.org.consumerdatastandards.client.model.banking.ResponseBankingScheduledPaymentsList;
import au.org.consumerdatastandards.integration.utils.ResponseCode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BankingScheduledPaymentsIT extends BankingITBase {
    public BankingScheduledPaymentsIT() throws IOException, ApiException {
        super(new BankingScheduledPaymentsAPI());
    }

    @ParameterizedTest
    @CsvSource({
            "BUSINESS_LOANS,ALL,,,"
    })
    public <T extends BankingScheduledPaymentTo> void listScheduledPaymentsBulk(BankingProductCategory productCategory, ParamAccountOpenStatus openStatus,
                                          Boolean isOwned, Integer page, Integer pageSize) throws ApiException {
        ApiResponse<ResponseBankingScheduledPaymentsList<T>> resp = ((BankingScheduledPaymentsAPI) getAPI())
                .listScheduledPaymentsBulkWithHttpInfo(productCategory, openStatus, isOwned, page, pageSize);
        Assertions.assertEquals(ResponseCode.OK.getCode(), resp.getStatusCode());
        List<ConformanceError> conformanceErrors = new ArrayList<>();
        checkResponseHeaders(resp.getHeaders(), conformanceErrors);

        BankingAccountsAPI accountsAPI = new BankingAccountsAPI();
        accountsAPI.setApiClient(getAPI().getApiClient());
        for (BankingScheduledPayment<T> payment : resp.getBody().getData().getScheduledPayments()) {
            BankingAccountDetail accountDetail = accountsAPI.getAccountDetail(payment.getFrom().getAccountId(), 1).getData();
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
        ApiResponse<ResponseBankingScheduledPaymentsList<BankingScheduledPaymentTo>> resp = ((BankingScheduledPaymentsAPI) getAPI())
                .listScheduledPaymentsWithHttpInfo(accountId, page, pageSize, 1);
        Assertions.assertEquals(ResponseCode.OK.getCode(), resp.getStatusCode());
        List<ConformanceError> conformanceErrors = new ArrayList<>();
        checkResponseHeaders(resp.getHeaders(), conformanceErrors);
        for (BankingScheduledPayment<BankingScheduledPaymentTo> scheduledPayment : resp.getBody().getData().getScheduledPayments()) {
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
        ApiResponse<ResponseBankingScheduledPaymentsList<BankingScheduledPaymentTo>> resp = ((BankingScheduledPaymentsAPI) getAPI())
                .listScheduledPaymentsSpecificAccountsWithHttpInfo(idList, page, pageSize, 1);
        Assertions.assertEquals(ResponseCode.OK.getCode(), resp.getStatusCode());
        List<ConformanceError> conformanceErrors = new ArrayList<>();
        checkResponseHeaders(resp.getHeaders(), conformanceErrors);
        for (BankingScheduledPayment<BankingScheduledPaymentTo> payment : resp.getBody().getData().getScheduledPayments()) {
            checkAccountInList(payment.getFrom().getAccountId(), idList.getData().getAccountIds(), conformanceErrors);
        }

        dumpConformanceErrors(conformanceErrors);

        Assertions.assertTrue(conformanceErrors.isEmpty(),
                CONFORMANCE_ERRORS_FOUND + buildConformanceErrorsDescription(conformanceErrors));
    }
}
