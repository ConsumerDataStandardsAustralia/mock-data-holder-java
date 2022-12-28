package au.org.consumerdatastandards.holder.api.telco;

import au.org.consumerdatastandards.holder.api.ApiControllerBase;
import au.org.consumerdatastandards.holder.model.telco.RequestAccountIds;
import au.org.consumerdatastandards.holder.model.telco.RequestServiceIds;
import au.org.consumerdatastandards.holder.model.telco.TelcoAccountDetailResponse;
import au.org.consumerdatastandards.holder.model.telco.TelcoAccountListResponse;
import au.org.consumerdatastandards.holder.model.telco.TelcoBalanceListResponse;
import au.org.consumerdatastandards.holder.model.telco.TelcoBalanceResponse;
import au.org.consumerdatastandards.holder.model.telco.TelcoConcessionsResponse;
import au.org.consumerdatastandards.holder.model.telco.TelcoInvoiceListResponse;
import au.org.consumerdatastandards.holder.model.telco.TelcoPaymentScheduleResponse;
import au.org.consumerdatastandards.holder.model.telco.TelcoProductListResponse;
import au.org.consumerdatastandards.holder.model.telco.TelcoProductResponse;
import au.org.consumerdatastandards.holder.model.telco.TelcoServiceUsageListResponse;
import au.org.consumerdatastandards.holder.model.telco.TelcoServiceUsageResponse;
import au.org.consumerdatastandards.holder.model.telco.TelcoTransactionListResponse;
import au.org.consumerdatastandards.holder.model.telco.TelcoUsageListResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;

@Validated
@Controller
@CrossOrigin
@RequestMapping("${openapi.consumerDataStandards.base-path:/cds-au/v1}")
public class TelcoApiController extends ApiControllerBase implements TelcoApi {

    private final NativeWebRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public TelcoApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public ResponseEntity<TelcoAccountDetailResponse> getAccount(String accountId, String xV, String openStatus, String xMinV, String xFapiInteractionId, String xFapiAuthDate, String xFapiCustomerIpAddress, String xCdsClientHeaders) {
        return null;
    }

    @Override
    public ResponseEntity<TelcoBalanceResponse> getBalanceForAccount(String accountId, String xV, String xMinV, String xFapiInteractionId, String xFapiAuthDate, String xFapiCustomerIpAddress, String xCdsClientHeaders) {
        return null;
    }

    @Override
    public ResponseEntity<TelcoConcessionsResponse> getConcessions(String accountId, String xV, String xMinV, String xFapiInteractionId, String xFapiAuthDate, String xFapiCustomerIpAddress, String xCdsClientHeaders) {
        return null;
    }

    @Override
    public ResponseEntity<TelcoInvoiceListResponse> getInvoicesForAccount(String accountId, String xV, String newestDate, String oldestDate, Integer page, Integer pageSize, String xMinV, String xFapiInteractionId, String xFapiAuthDate, String xFapiCustomerIpAddress, String xCdsClientHeaders) {
        return null;
    }

    @Override
    public ResponseEntity<TelcoPaymentScheduleResponse> getPaymentSchedule(String accountId, String xV, String xMinV, String xFapiInteractionId, String xFapiAuthDate, String xFapiCustomerIpAddress, String xCdsClientHeaders) {
        return null;
    }

    @Override
    public ResponseEntity<TelcoProductResponse> getProduct(String productId, String xV, String xMinV) {
        return null;
    }

    @Override
    public ResponseEntity<TelcoTransactionListResponse> getTransactionsForAccount(String accountId, String xV, String newestTime, String oldestTime, Integer page, Integer pageSize, String xMinV, String xFapiInteractionId, String xFapiAuthDate, String xFapiCustomerIpAddress, String xCdsClientHeaders) {
        return null;
    }

    @Override
    public ResponseEntity<TelcoServiceUsageResponse> getUsageForService(String serviceId, String xV, String oldestDate, String newestDate, Integer page, Integer pageSize, String xMinV, String xFapiInteractionId, String xFapiAuthDate, String xFapiCustomerIpAddress, String xCdsClientHeaders) {
        return null;
    }

    @Override
    public ResponseEntity<TelcoAccountListResponse> listAccounts(String xV, String openStatus, Integer page, Integer pageSize, String xMinV, String xFapiInteractionId, String xFapiAuthDate, String xFapiCustomerIpAddress, String xCdsClientHeaders) {
        return null;
    }

    @Override
    public ResponseEntity<TelcoBalanceListResponse> listBalance(String xV, Integer page, Integer pageSize, String xMinV, String xFapiInteractionId, String xFapiAuthDate, String xFapiCustomerIpAddress, String xCdsClientHeaders) {
        return null;
    }

    @Override
    public ResponseEntity<TelcoBalanceListResponse> listBalancesForAccounts(String xV, RequestAccountIds accountIdList, Integer page, Integer pageSize, String xMinV, String xFapiInteractionId, String xFapiAuthDate, String xFapiCustomerIpAddress, String xCdsClientHeaders) {
        return null;
    }

    @Override
    public ResponseEntity<TelcoTransactionListResponse> listBillingForAccounts(String xV, RequestAccountIds accountIdList, String newestTime, String oldestTime, Integer page, Integer pageSize, String xMinV, String xFapiInteractionId, String xFapiAuthDate, String xFapiCustomerIpAddress, String xCdsClientHeaders) {
        return null;
    }

    @Override
    public ResponseEntity<TelcoInvoiceListResponse> listInvoices(String xV, String newestDate, String oldestDate, Integer page, Integer pageSize, String xMinV, String xFapiInteractionId, String xFapiAuthDate, String xFapiCustomerIpAddress, String xCdsClientHeaders) {
        return null;
    }

    @Override
    public ResponseEntity<TelcoInvoiceListResponse> listInvoicesForAccounts(String xV, RequestAccountIds accountIdList, String newestDate, String oldestDate, Integer page, Integer pageSize, String xMinV, String xFapiInteractionId, String xFapiAuthDate, String xFapiCustomerIpAddress, String xCdsClientHeaders) {
        return null;
    }

    @Override
    public ResponseEntity<TelcoProductListResponse> listProducts(String xV, String type, String billingType, String effective, String updatedSince, String brand, Integer page, Integer pageSize, String xMinV) {
        return null;
    }

    @Override
    public ResponseEntity<TelcoTransactionListResponse> listTransactions(String xV, String newestTime, String oldestTime, Integer page, Integer pageSize, String xMinV, String xFapiInteractionId, String xFapiAuthDate, String xFapiCustomerIpAddress, String xCdsClientHeaders) {
        return null;
    }

    @Override
    public ResponseEntity<TelcoUsageListResponse> listUsage(String xV, String oldestDate, String newestDate, Integer page, Integer pageSize, String xMinV, String xFapiInteractionId, String xFapiAuthDate, String xFapiCustomerIpAddress, String xCdsClientHeaders) {
        return null;
    }

    @Override
    public ResponseEntity<TelcoServiceUsageListResponse> listUsageForService(String xV, RequestServiceIds serviceIdList, String oldestDate, String newestDate, Integer page, Integer pageSize, String xMinV, String xFapiInteractionId, String xFapiAuthDate, String xFapiCustomerIpAddress, String xCdsClientHeaders) {
        return null;
    }
}
