package au.org.consumerdatastandards.holder.api.telco;

import au.org.consumerdatastandards.holder.api.ApiControllerBase;
import au.org.consumerdatastandards.holder.model.Links;
import au.org.consumerdatastandards.holder.model.LinksPaginated;
import au.org.consumerdatastandards.holder.model.telco.BillingTypeEnum;
import au.org.consumerdatastandards.holder.model.telco.RequestAccountIds;
import au.org.consumerdatastandards.holder.model.telco.RequestServiceIds;
import au.org.consumerdatastandards.holder.model.telco.TelcoAccountDetail;
import au.org.consumerdatastandards.holder.model.telco.TelcoAccountDetailResponse;
import au.org.consumerdatastandards.holder.model.telco.TelcoAccountListResponse;
import au.org.consumerdatastandards.holder.model.telco.TelcoBalance;
import au.org.consumerdatastandards.holder.model.telco.TelcoBalanceListResponse;
import au.org.consumerdatastandards.holder.model.telco.TelcoBalanceResponse;
import au.org.consumerdatastandards.holder.model.telco.TelcoConcessionsResponse;
import au.org.consumerdatastandards.holder.model.telco.TelcoConcessionsResponseData;
import au.org.consumerdatastandards.holder.model.telco.TelcoInvoiceListResponse;
import au.org.consumerdatastandards.holder.model.telco.TelcoPaymentScheduleResponse;
import au.org.consumerdatastandards.holder.model.telco.TelcoPaymentScheduleResponseData;
import au.org.consumerdatastandards.holder.model.telco.TelcoProductDetail;
import au.org.consumerdatastandards.holder.model.telco.TelcoProductListResponse;
import au.org.consumerdatastandards.holder.model.telco.TelcoProductResponse;
import au.org.consumerdatastandards.holder.model.telco.TelcoServiceUsage;
import au.org.consumerdatastandards.holder.model.telco.TelcoServiceUsageListResponse;
import au.org.consumerdatastandards.holder.model.telco.TelcoServiceUsageResponse;
import au.org.consumerdatastandards.holder.model.telco.TelcoTransactionListResponse;
import au.org.consumerdatastandards.holder.model.telco.TelcoTransactionListResponseData;
import au.org.consumerdatastandards.holder.model.telco.TelcoUsageListResponse;
import au.org.consumerdatastandards.holder.model.telco.TypeEnum;
import au.org.consumerdatastandards.holder.util.WebUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;

import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.UUID;

@Validated
@Controller
@CrossOrigin
@RequestMapping("${openapi.consumerDataStandards.base-path:/cds-au/v1}")
public class TelcoApiController extends ApiControllerBase implements TelcoApi {

    private final NativeWebRequest request;

    @Autowired
    public TelcoApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public ResponseEntity<TelcoAccountDetailResponse> getAccount(String accountId, Integer xV, String openStatus,
            Integer xMinV, UUID xFapiInteractionId, String xFapiAuthDate, String xFapiCustomerIpAddress, String xCdsClientHeaders) {
        int supportedVersion = validateHeaders(xCdsClientHeaders, xFapiCustomerIpAddress, xFapiInteractionId, xMinV, xV, 1);
        TelcoAccountDetailResponse response = new TelcoAccountDetailResponse();
        TelcoAccountDetail data = new TelcoAccountDetail();
        data.setAccountId("12345");
        data.setAccountNumber("IW12345");
        data.setBrand("Interwebs");
        data.setPlans(Collections.emptyList());
        response.setData(data);
        response.setLinks(new Links().self(WebUtil.getOriginalUrl(request)));
        return new ResponseEntity<>(response, generateResponseHeaders(xFapiInteractionId, supportedVersion), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<TelcoBalanceResponse> getBalanceForAccount(String accountId, Integer xV, Integer xMinV,
            UUID xFapiInteractionId, String xFapiAuthDate, String xFapiCustomerIpAddress, String xCdsClientHeaders) {
        int supportedVersion = validateHeaders(xCdsClientHeaders, xFapiCustomerIpAddress, xFapiInteractionId, xMinV, xV, 1);
        TelcoBalanceResponse response = new TelcoBalanceResponse();
        TelcoBalance data = new TelcoBalance();
        data.setServices(Collections.emptyList());
        response.setData(data);
        response.setLinks(new Links().self(WebUtil.getOriginalUrl(request)));
        return new ResponseEntity<>(response, generateResponseHeaders(xFapiInteractionId, supportedVersion), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<TelcoConcessionsResponse> getConcessions(String accountId, Integer xV, Integer xMinV,
            UUID xFapiInteractionId, String xFapiAuthDate, String xFapiCustomerIpAddress, String xCdsClientHeaders) {
        int supportedVersion = validateHeaders(xCdsClientHeaders, xFapiCustomerIpAddress, xFapiInteractionId, xMinV, xV, 1);
        TelcoConcessionsResponse response = new TelcoConcessionsResponse();
        TelcoConcessionsResponseData data = new TelcoConcessionsResponseData();
        data.setConcessions(Collections.emptyList());
        response.setData(data);
        response.setLinks(new Links().self(WebUtil.getOriginalUrl(request)));
        return new ResponseEntity<>(response, generateResponseHeaders(xFapiInteractionId, supportedVersion), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<TelcoInvoiceListResponse> getInvoicesForAccount(String accountId, Integer xV,
            String newestDate, String oldestDate, Integer page, Integer pageSize, Integer xMinV, UUID xFapiInteractionId,
            String xFapiAuthDate, String xFapiCustomerIpAddress, String xCdsClientHeaders) {
        int supportedVersion = validateHeaders(xCdsClientHeaders, xFapiCustomerIpAddress, xFapiInteractionId, xMinV, xV, 1);
        TelcoInvoiceListResponse data = new TelcoInvoiceListResponse();
        data.setInvoices(Collections.emptyList());
        return new ResponseEntity<>(data, generateResponseHeaders(xFapiInteractionId, supportedVersion), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<TelcoPaymentScheduleResponse> getPaymentSchedule(String accountId, Integer xV, Integer xMinV,
            UUID xFapiInteractionId, String xFapiAuthDate, String xFapiCustomerIpAddress, String xCdsClientHeaders) {
        int supportedVersion = validateHeaders(xCdsClientHeaders, xFapiCustomerIpAddress, xFapiInteractionId, xMinV, xV, 1);
        TelcoPaymentScheduleResponse response = new TelcoPaymentScheduleResponse();
        TelcoPaymentScheduleResponseData data = new TelcoPaymentScheduleResponseData();
        data.setPaymentSchedules(Collections.emptyList());
        response.setData(data);
        response.setLinks(new Links().self(WebUtil.getOriginalUrl(request)));
        return new ResponseEntity<>(response, generateResponseHeaders(xFapiInteractionId, supportedVersion), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<TelcoProductResponse> getProduct(String productId, Integer xV, Integer xMinV) {
        int supportedVersion = validateSupportedVersion(xMinV, xV, WebUtil.NO_INTERACTION_ID, 1);
        TelcoProductResponse response = new TelcoProductResponse();
        TelcoProductDetail data = new TelcoProductDetail();
        data.setProductId("PROD12345");
        data.setType(TypeEnum.BROADBAND);
        data.setBillingType(BillingTypeEnum.POST_PAID);
        data.setBrand("Interwebs");
        data.setBrandName("Interwebs");
        data.setPricing(Collections.emptyList());
        response.setData(data);
        response.setLinks(new Links().self(WebUtil.getOriginalUrl(request)));
        return new ResponseEntity<>(response, generateResponseHeaders(null, supportedVersion), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<TelcoTransactionListResponse> getTransactionsForAccount(String accountId, Integer xV,
            String newestTime, String oldestTime, Integer page, Integer pageSize, Integer xMinV, UUID xFapiInteractionId,
            String xFapiAuthDate, String xFapiCustomerIpAddress, String xCdsClientHeaders) {
        int supportedVersion = validateHeaders(xCdsClientHeaders, xFapiCustomerIpAddress, xFapiInteractionId, xMinV, xV, 1);
        validatePageSize(pageSize, xFapiInteractionId);
        TelcoTransactionListResponse response = new TelcoTransactionListResponse();
        TelcoTransactionListResponseData data = new TelcoTransactionListResponseData();
        data.setTransactions(Collections.emptyList());
        response.setData(data);
        response.setLinks(createSinglePageLinksPaginated(pageSize));
        return new ResponseEntity<>(response, generateResponseHeaders(xFapiInteractionId, supportedVersion), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<TelcoServiceUsageResponse> getUsageForService(String serviceId, Integer xV, String oldestDate,
            String newestDate, Integer page, Integer pageSize, Integer xMinV, UUID xFapiInteractionId,
            String xFapiAuthDate, String xFapiCustomerIpAddress, String xCdsClientHeaders) {
        int supportedVersion = validateHeaders(xCdsClientHeaders, xFapiCustomerIpAddress, xFapiInteractionId, xMinV, xV, 1);
        validatePageSize(pageSize, xFapiInteractionId);
        TelcoServiceUsageResponse response = new TelcoServiceUsageResponse();
        TelcoServiceUsage data = new TelcoServiceUsage();
        data.setServiceId("SER12345");
        data.setStartDate(OffsetDateTime.now());
        response.setData(data);
        response.setLinks(createSinglePageLinksPaginated(pageSize));
        return new ResponseEntity<>(response, generateResponseHeaders(xFapiInteractionId, supportedVersion), HttpStatus.OK);
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

    private LinksPaginated createSinglePageLinksPaginated(Integer pageSize) {
        LinksPaginated linkData = new LinksPaginated();
        linkData.setSelf(WebUtil.getOriginalUrl(request));
        Integer actualPageSize = getPagingValue(pageSize, 25);
        linkData.setFirst(WebUtil.getPaginatedLink(request, 1, actualPageSize));
        linkData.setLast(WebUtil.getPaginatedLink(request, 1, actualPageSize));
        return linkData;
    }
}
