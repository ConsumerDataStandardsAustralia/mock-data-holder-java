package au.org.consumerdatastandards.holder.api.banking;

import au.org.consumerdatastandards.holder.api.ApiControllerBase;
import au.org.consumerdatastandards.holder.model.banking.BankingAccount;
import au.org.consumerdatastandards.holder.model.banking.BankingDirectDebit;
import au.org.consumerdatastandards.holder.model.banking.BankingProductCategory;
import au.org.consumerdatastandards.holder.model.banking.ParamAccountOpenStatus;
import au.org.consumerdatastandards.holder.model.banking.ParamProductCategory;
import au.org.consumerdatastandards.holder.model.banking.RequestAccountIds;
import au.org.consumerdatastandards.holder.model.banking.ResponseBankingDirectDebitAuthorisationList;
import au.org.consumerdatastandards.holder.model.banking.ResponseBankingDirectDebitAuthorisationListData;
import au.org.consumerdatastandards.holder.service.banking.BankingDirectDebitService;
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
@CrossOrigin(allowedHeaders = "*")
@RequestMapping("${openapi.consumerDataStandards.base-path:/cds-au/v1}")
public class BankingDirectDebitsApiController extends ApiControllerBase implements BankingDirectDebitsApi {

    private final BankingDirectDebitService directDebitService;
    private final NativeWebRequest request;

    @Autowired
    public BankingDirectDebitsApiController(NativeWebRequest request,
                                            BankingDirectDebitService directDebitService) {
        this.request = request;
        this.directDebitService = directDebitService;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    public ResponseEntity<ResponseBankingDirectDebitAuthorisationList> listDirectDebits(String accountId,
                                                                                        Integer page,
                                                                                        Integer pageSize,
                                                                                        String xCdsClientHeaders,
                                                                                        Date xFapiAuthDate,
                                                                                        String xFapiCustomerIpAddress,
                                                                                        UUID xFapiInteractionId,
                                                                                        Integer xMinV,
                                                                                        Integer xV) {
        int supportedVersion = validateHeaders(xCdsClientHeaders, xFapiCustomerIpAddress, xFapiInteractionId, xMinV, xV, 1);
        validatePageSize(pageSize, xFapiInteractionId);
        HttpHeaders headers = generateResponseHeaders(xFapiInteractionId, supportedVersion);
        Integer actualPage = getPagingValue(page, 1);
        Integer actualPageSize = getPagingValue(pageSize, 25);
        ResponseBankingDirectDebitAuthorisationListData listData = new ResponseBankingDirectDebitAuthorisationListData();
        Page<BankingDirectDebit> directDebitPage =
            directDebitService.getBankingDirectDebits(accountId, PageRequest.of(actualPage - 1, actualPageSize));
        validatePageRange(actualPage, directDebitPage.getTotalPages(), xFapiInteractionId);
        return getResponse(headers, actualPage, actualPageSize, listData, directDebitPage);
    }

    @Override
    public ResponseEntity<ResponseBankingDirectDebitAuthorisationList> listDirectDebitsBulk(Boolean isOwned,
                                                                                            ParamAccountOpenStatus paramOpenStatus,
                                                                                            ParamProductCategory paramProductCategory,
                                                                                            Integer page,
                                                                                            Integer pageSize,
                                                                                            String xCdsClientHeaders,
                                                                                            Date xFapiAuthDate,
                                                                                            String xFapiCustomerIpAddress,
                                                                                            UUID xFapiInteractionId,
                                                                                            Integer xMinV,
                                                                                            Integer xV) {
        int supportedVersion = validateHeaders(xCdsClientHeaders, xFapiCustomerIpAddress, xFapiInteractionId, xMinV, xV, 1);
        validatePageSize(pageSize, xFapiInteractionId);
        HttpHeaders headers = generateResponseHeaders(xFapiInteractionId, supportedVersion);
        Integer actualPage = getPagingValue(page, 1);
        Integer actualPageSize = getPagingValue(pageSize, 25);
        ResponseBankingDirectDebitAuthorisationListData listData = new ResponseBankingDirectDebitAuthorisationListData();
        BankingAccount.OpenStatus openStatus = null;
        if (paramOpenStatus != null && !ParamAccountOpenStatus.ALL.equals(paramOpenStatus)) {
            openStatus = BankingAccount.OpenStatus.valueOf(paramOpenStatus.name());
        }
        BankingProductCategory productCategory = null;
        if (paramProductCategory != null) {
            productCategory = BankingProductCategory.valueOf(paramProductCategory.name());
        }
        Page<BankingDirectDebit> directDebitPage =
            directDebitService.getBankingDirectDebits(isOwned, productCategory, openStatus, PageRequest.of(actualPage - 1, actualPageSize));
        validatePageRange(actualPage, directDebitPage.getTotalPages(), xFapiInteractionId);
        return getResponse(headers, actualPage, actualPageSize, listData, directDebitPage);
    }

    public ResponseEntity<ResponseBankingDirectDebitAuthorisationList> listDirectDebitsSpecificAccounts(RequestAccountIds accountIds,
                                                                                                        Integer page,
                                                                                                        Integer pageSize,
                                                                                                        String xCdsClientHeaders,
                                                                                                        Date xFapiAuthDate,
                                                                                                        String xFapiCustomerIpAddress,
                                                                                                        UUID xFapiInteractionId,
                                                                                                        Integer xMinV,
                                                                                                        Integer xV) {
        int supportedVersion = validateHeaders(xCdsClientHeaders, xFapiCustomerIpAddress, xFapiInteractionId, xMinV, xV, 1);
        validatePageSize(pageSize, xFapiInteractionId);
        HttpHeaders headers = generateResponseHeaders(xFapiInteractionId, supportedVersion);
        Integer actualPage = getPagingValue(page, 1);
        Integer actualPageSize = getPagingValue(pageSize, 25);
        ResponseBankingDirectDebitAuthorisationListData listData = new ResponseBankingDirectDebitAuthorisationListData();
        Page<BankingDirectDebit> directDebitPage =
            directDebitService.getBankingDirectDebits(accountIds.getData().getAccountIds(), PageRequest.of(actualPage - 1, actualPageSize));
        validatePageRange(actualPage, directDebitPage.getTotalPages(), xFapiInteractionId);
        return getResponse(headers, actualPage, actualPageSize, listData, directDebitPage);
    }

    private ResponseEntity<ResponseBankingDirectDebitAuthorisationList> getResponse(
        HttpHeaders headers, Integer actualPage, Integer actualPageSize,
        ResponseBankingDirectDebitAuthorisationListData listData,
        Page<BankingDirectDebit> directDebitPage) {
        listData.setDirectDebitAuthorisations(directDebitPage.getContent());
        ResponseBankingDirectDebitAuthorisationList responseBankingDirectDebitAuthorisationList =
            new ResponseBankingDirectDebitAuthorisationList();
        responseBankingDirectDebitAuthorisationList.setData(listData);
        responseBankingDirectDebitAuthorisationList.setLinks(getLinkData(request, directDebitPage, actualPage, actualPageSize));
        responseBankingDirectDebitAuthorisationList.setMeta(getMetaData(directDebitPage));
        return new ResponseEntity<>(responseBankingDirectDebitAuthorisationList, headers, HttpStatus.OK);
    }
}
