package au.org.consumerdatastandards.holder.api.telco;

import au.org.consumerdatastandards.holder.api.ApiControllerBase;
import au.org.consumerdatastandards.holder.model.Links;
import au.org.consumerdatastandards.holder.model.telco.RequestAccountIds;
import au.org.consumerdatastandards.holder.model.telco.RequestServiceIds;
import au.org.consumerdatastandards.holder.model.telco.TelcoAccountBase;
import au.org.consumerdatastandards.holder.model.telco.TelcoAccountDetail;
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
import au.org.consumerdatastandards.holder.util.WebUtil;
import org.openapitools.jackson.nullable.JsonNullable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.UUID;

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
    public ResponseEntity<TelcoAccountDetailResponse> getAccount(String accountId, Integer xV, String openStatus, Integer xMinV, UUID xFapiInteractionId, String xFapiAuthDate, String xFapiCustomerIpAddress, String xCdsClientHeaders) {
        int supportedVersion = validateHeaders(xCdsClientHeaders, xFapiCustomerIpAddress, xFapiInteractionId, xMinV, xV, 1);
        TelcoAccountDetailResponse response = new TelcoAccountDetailResponse();
        TelcoAccountDetail data = new TelcoAccountDetail();
        response.setData(data);
        response.setLinks(new Links().self(WebUtil.getOriginalUrl(request)));
        return new ResponseEntity<>(response, generateResponseHeaders(xFapiInteractionId, supportedVersion), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<TelcoBalanceResponse> getBalanceForAccount(String accountId, Integer xV, Integer xMinV, UUID xFapiInteractionId, String xFapiAuthDate, String xFapiCustomerIpAddress, String xCdsClientHeaders) {
        return null;
    }

    @Override
    public ResponseEntity<TelcoConcessionsResponse> getConcessions(String accountId, Integer xV, Integer xMinV, UUID xFapiInteractionId, String xFapiAuthDate, String xFapiCustomerIpAddress, String xCdsClientHeaders) {
        return null;
    }

    @Override
    public ResponseEntity<TelcoInvoiceListResponse> getInvoicesForAccount(String accountId, Integer xV, String newestDate, String oldestDate, Integer page, Integer pageSize, Integer xMinV, UUID xFapiInteractionId, String xFapiAuthDate, String xFapiCustomerIpAddress, String xCdsClientHeaders) {
        return null;
    }

    @Override
    public ResponseEntity<TelcoPaymentScheduleResponse> getPaymentSchedule(String accountId, Integer xV, Integer xMinV, UUID xFapiInteractionId, String xFapiAuthDate, String xFapiCustomerIpAddress, String xCdsClientHeaders) {
        return null;
    }

    @Override
    public ResponseEntity<TelcoProductResponse> getProduct(String productId, Integer xV, Integer xMinV) {
        return null;
    }

    @Override
    public ResponseEntity<TelcoTransactionListResponse> getTransactionsForAccount(String accountId, Integer xV, String newestTime, String oldestTime, Integer page, Integer pageSize, Integer xMinV, UUID xFapiInteractionId, String xFapiAuthDate, String xFapiCustomerIpAddress, String xCdsClientHeaders) {
        return null;
    }

    @Override
    public ResponseEntity<TelcoServiceUsageResponse> getUsageForService(String serviceId, Integer xV, String oldestDate, String newestDate, Integer page, Integer pageSize, Integer xMinV, UUID xFapiInteractionId, String xFapiAuthDate, String xFapiCustomerIpAddress, String xCdsClientHeaders) {
        return null;
    }

    @Override
    public ResponseEntity<TelcoAccountListResponse> listAccounts(Integer xV, String openStatus, Integer page, Integer pageSize, Integer xMinV, UUID xFapiInteractionId, String xFapiAuthDate, String xFapiCustomerIpAddress, String xCdsClientHeaders) {
        return null;
    }

    @Override
    public ResponseEntity<TelcoBalanceListResponse> listBalance(Integer xV, Integer page, Integer pageSize, Integer xMinV, UUID xFapiInteractionId, String xFapiAuthDate, String xFapiCustomerIpAddress, String xCdsClientHeaders) {
        return null;
    }

    @Override
    public ResponseEntity<TelcoBalanceListResponse> listBalancesForAccounts(Integer xV, RequestAccountIds accountIdList, Integer page, Integer pageSize, Integer xMinV, UUID xFapiInteractionId, String xFapiAuthDate, String xFapiCustomerIpAddress, String xCdsClientHeaders) {
        return null;
    }

    @Override
    public ResponseEntity<TelcoTransactionListResponse> listBillingForAccounts(Integer xV, RequestAccountIds accountIdList, String newestTime, String oldestTime, Integer page, Integer pageSize, Integer xMinV, UUID xFapiInteractionId, String xFapiAuthDate, String xFapiCustomerIpAddress, String xCdsClientHeaders) {
        return null;
    }

    @Override
    public ResponseEntity<TelcoInvoiceListResponse> listInvoices(Integer xV, String newestDate, String oldestDate, Integer page, Integer pageSize, Integer xMinV, UUID xFapiInteractionId, String xFapiAuthDate, String xFapiCustomerIpAddress, String xCdsClientHeaders) {
        return null;
    }

    @Override
    public ResponseEntity<TelcoInvoiceListResponse> listInvoicesForAccounts(Integer xV, RequestAccountIds accountIdList, String newestDate, String oldestDate, Integer page, Integer pageSize, Integer xMinV, UUID xFapiInteractionId, String xFapiAuthDate, String xFapiCustomerIpAddress, String xCdsClientHeaders) {
        return null;
    }

    @Override
    public ResponseEntity<TelcoProductListResponse> listProducts(Integer xV, String type, String billingType, String effective, String updatedSince, String brand, Integer page, Integer pageSize, Integer xMinV) {
        return null;
    }

    @Override
    public ResponseEntity<TelcoTransactionListResponse> listTransactions(Integer xV, String newestTime, String oldestTime, Integer page, Integer pageSize, Integer xMinV, UUID xFapiInteractionId, String xFapiAuthDate, String xFapiCustomerIpAddress, String xCdsClientHeaders) {
        return null;
    }

    @Override
    public ResponseEntity<TelcoUsageListResponse> listUsage(Integer xV, String oldestDate, String newestDate, Integer page, Integer pageSize, Integer xMinV, UUID xFapiInteractionId, String xFapiAuthDate, String xFapiCustomerIpAddress, String xCdsClientHeaders) {
        return null;
    }

    @Override
    public ResponseEntity<TelcoServiceUsageListResponse> listUsageForService(Integer xV, RequestServiceIds serviceIdList, String oldestDate, String newestDate, Integer page, Integer pageSize, Integer xMinV, UUID xFapiInteractionId, String xFapiAuthDate, String xFapiCustomerIpAddress, String xCdsClientHeaders) {
        return null;
    }
}
