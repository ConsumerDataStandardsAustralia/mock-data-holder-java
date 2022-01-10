package au.org.consumerdatastandards.holder.api.banking;

import au.org.consumerdatastandards.holder.api.ApiControllerBase;
import au.org.consumerdatastandards.holder.model.banking.BankingProductCategory;
import au.org.consumerdatastandards.holder.model.banking.BankingScheduledPayment;
import au.org.consumerdatastandards.holder.model.banking.ParamAccountOpenStatus;
import au.org.consumerdatastandards.holder.model.banking.ParamProductCategory;
import au.org.consumerdatastandards.holder.model.banking.RequestAccountIds;
import au.org.consumerdatastandards.holder.model.banking.ResponseBankingScheduledPaymentsList;
import au.org.consumerdatastandards.holder.model.banking.ResponseBankingScheduledPaymentsListData;
import au.org.consumerdatastandards.holder.service.BankingScheduledPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Validated
@Controller
@CrossOrigin
@RequestMapping("${openapi.consumerDataStandards.base-path:/cds-au/v1}")
public class BankingScheduledPaymentsApiController extends ApiControllerBase implements BankingScheduledPaymentsApi {

    private final BankingScheduledPaymentService scheduledPaymentService;
    private final NativeWebRequest request;

    @Autowired
    public BankingScheduledPaymentsApiController(NativeWebRequest request, BankingScheduledPaymentService scheduledPaymentService) {
        this.request = request;
        this.scheduledPaymentService = scheduledPaymentService;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    public ResponseEntity<ResponseBankingScheduledPaymentsList> listScheduledPayments(String accountId,
                                                                                      Integer page,
                                                                                      Integer pageSize,
                                                                                      String xCdsClientHeaders,
                                                                                      Date xFapiAuthDate,
                                                                                      String xFapiCustomerIpAddress,
                                                                                      UUID xFapiInteractionId,
                                                                                      Integer xMinV,
                                                                                      Integer xV) {
        validateHeaders(xCdsClientHeaders, xFapiCustomerIpAddress, xFapiInteractionId, xMinV, xV);
        validatePageSize(pageSize, xFapiInteractionId);
        HttpHeaders headers = generateResponseHeaders(request);
        Integer actualPage = getPagingValue(page, 1);
        Integer actualPageSize = getPagingValue(pageSize, 25);
        ResponseBankingScheduledPaymentsListData listData = new ResponseBankingScheduledPaymentsListData();
        Page<BankingScheduledPayment> scheduledPaymentPage
            = scheduledPaymentService.getBankingScheduledPayments(accountId, PageRequest.of(actualPage - 1, actualPageSize));
        validatePageRange(actualPage, scheduledPaymentPage.getTotalPages(), xFapiInteractionId);
        return getResponse(headers, actualPage, actualPageSize, listData, scheduledPaymentPage);
    }

    @Override
    public ResponseEntity<ResponseBankingScheduledPaymentsList> listScheduledPaymentsBulk(ParamProductCategory productCategory,
                                                                                          ParamAccountOpenStatus openStatus,
                                                                                          Boolean isOwned,
                                                                                          Integer page,
                                                                                          Integer pageSize,
                                                                                          String xCdsClientHeaders,
                                                                                          Date xFapiAuthDate,
                                                                                          String xFapiCustomerIpAddress,
                                                                                          UUID xFapiInteractionId,
                                                                                          Integer xMinV,
                                                                                          Integer xV) {
        validateHeaders(xCdsClientHeaders, xFapiCustomerIpAddress, xFapiInteractionId, xMinV, xV);
        validatePageSize(pageSize, xFapiInteractionId);
        HttpHeaders headers = generateResponseHeaders(request);
        Integer actualPage = getPagingValue(page, 1);
        Integer actualPageSize = getPagingValue(pageSize, 25);
        ResponseBankingScheduledPaymentsListData listData = new ResponseBankingScheduledPaymentsListData();
        Page<BankingScheduledPayment> scheduledPaymentPage
            = scheduledPaymentService.getBankingScheduledPayments(BankingProductCategory.valueOf(productCategory.name()),
            openStatus, isOwned, PageRequest.of(actualPage - 1, actualPageSize));
        validatePageRange(actualPage, scheduledPaymentPage.getTotalPages(), xFapiInteractionId);
        return getResponse(headers, actualPage, actualPageSize, listData, scheduledPaymentPage);
    }

    public ResponseEntity<ResponseBankingScheduledPaymentsList> listScheduledPaymentsSpecificAccounts(RequestAccountIds accountIds,
                                                                                                      Integer page,
                                                                                                      Integer pageSize,
                                                                                                      String xCdsClientHeaders,
                                                                                                      Date xFapiAuthDate,
                                                                                                      String xFapiCustomerIpAddress,
                                                                                                      UUID xFapiInteractionId,
                                                                                                      Integer xMinV,
                                                                                                      Integer xV) {
        validateHeaders(xCdsClientHeaders, xFapiCustomerIpAddress, xFapiInteractionId, xMinV, xV);
        validatePageSize(pageSize, xFapiInteractionId);
        HttpHeaders headers = generateResponseHeaders(request);
        Integer actualPage = getPagingValue(page, 1);
        Integer actualPageSize = getPagingValue(pageSize, 25);
        ResponseBankingScheduledPaymentsListData listData = new ResponseBankingScheduledPaymentsListData();
        Page<BankingScheduledPayment> scheduledPaymentPage
            = scheduledPaymentService.getBankingScheduledPayments(
                accountIds.getData().getAccountIds(), PageRequest.of(actualPage - 1, actualPageSize));
        validatePageRange(actualPage, scheduledPaymentPage.getTotalPages(), xFapiInteractionId);
        return getResponse(headers, actualPage, actualPageSize, listData, scheduledPaymentPage);
    }

    private ResponseEntity<ResponseBankingScheduledPaymentsList> getResponse(HttpHeaders headers, Integer actualPage, Integer actualPageSize, ResponseBankingScheduledPaymentsListData listData, Page<BankingScheduledPayment> scheduledPaymentPage) {
        listData.setScheduledPayments(scheduledPaymentPage.getContent());
        ResponseBankingScheduledPaymentsList responseBankingScheduledPaymentsList = new ResponseBankingScheduledPaymentsList();
        responseBankingScheduledPaymentsList.setData(listData);
        responseBankingScheduledPaymentsList.setLinks(getLinkData(request, scheduledPaymentPage, actualPage, actualPageSize));
        responseBankingScheduledPaymentsList.setMeta(getMetaData(scheduledPaymentPage));
        return new ResponseEntity<>(responseBankingScheduledPaymentsList, headers, HttpStatus.OK);
    }
}
