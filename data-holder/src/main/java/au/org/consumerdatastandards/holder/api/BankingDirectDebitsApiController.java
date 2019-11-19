package au.org.consumerdatastandards.holder.api;

import au.org.consumerdatastandards.holder.model.BankingDirectDebit;
import au.org.consumerdatastandards.holder.model.RequestAccountIds;
import au.org.consumerdatastandards.holder.model.ResponseBankingDirectDebitAuthorisationList;
import au.org.consumerdatastandards.holder.model.ResponseBankingDirectDebitAuthorisationListData;
import au.org.consumerdatastandards.holder.service.BankingDirectDebitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;

import java.time.OffsetDateTime;
import java.util.Optional;
import java.util.UUID;

@Validated
@Controller
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
                                                                                        String xCdsUserAgent,
                                                                                        String xCdsSubject,
                                                                                        OffsetDateTime xFapiAuthDate,
                                                                                        String xFapiCustomerIpAddress,
                                                                                        UUID xFapiInteractionId,
                                                                                        Integer xMinV,
                                                                                        Integer xV) {
        validateHeaders(xCdsUserAgent, xCdsSubject, xFapiCustomerIpAddress, xMinV, xV);
        validatePageInputs(page, pageSize);
        HttpHeaders headers = generateResponseHeaders(request);
        Integer actualPage = getPagingValue(page, 1);
        Integer actualPageSize = getPagingValue(pageSize, 25);
        ResponseBankingDirectDebitAuthorisationListData listData = new ResponseBankingDirectDebitAuthorisationListData();
        Page<BankingDirectDebit> directDebitPage =
            directDebitService.getBankingDirectDebits(accountId, PageRequest.of(actualPage, actualPageSize));
        return getResponse(headers, actualPage, actualPageSize, listData, directDebitPage);
    }

    public ResponseEntity<ResponseBankingDirectDebitAuthorisationList> listDirectDebitsSpecificAccounts(RequestAccountIds accountIds,
                                                                                                        Integer page,
                                                                                                        Integer pageSize,
                                                                                                        String xCdsUserAgent,
                                                                                                        String xCdsSubject,
                                                                                                        OffsetDateTime xFapiAuthDate,
                                                                                                        String xFapiCustomerIpAddress,
                                                                                                        UUID xFapiInteractionId,
                                                                                                        Integer xMinV,
                                                                                                        Integer xV) {
        validateHeaders(xCdsUserAgent, xCdsSubject, xFapiCustomerIpAddress, xMinV, xV);
        validatePageInputs(page, pageSize);
        HttpHeaders headers = generateResponseHeaders(request);
        Integer actualPage = getPagingValue(page, 1);
        Integer actualPageSize = getPagingValue(pageSize, 25);
        ResponseBankingDirectDebitAuthorisationListData listData = new ResponseBankingDirectDebitAuthorisationListData();
        Page<BankingDirectDebit> directDebitPage =
            directDebitService.getBankingDirectDebits(accountIds.getData().getAccountIds(), PageRequest.of(actualPage, actualPageSize));
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
