package au.org.consumerdatastandards.holder.api;

import au.org.consumerdatastandards.holder.model.*;
import au.org.consumerdatastandards.holder.service.BankingPayeeService;
import au.org.consumerdatastandards.holder.util.WebUtil;
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
public class BankingPayeesApiController extends ApiControllerBase implements BankingPayeesApi {

    private final BankingPayeeService payeeService;
    private final NativeWebRequest request;

    @Autowired
    public BankingPayeesApiController(NativeWebRequest request, BankingPayeeService payeeService) {
        this.request = request;
        this.payeeService = payeeService;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    public ResponseEntity<ResponseBankingPayeeById> getPayeeDetail(String payeeId,
                                                                   String xCdsClientHeaders,
                                                                   OffsetDateTime xFapiAuthDate,
                                                                   String xFapiCustomerIpAddress,
                                                                   UUID xFapiInteractionId,
                                                                   Integer xMinV,
                                                                   Integer xV) {
        validateHeaders(xCdsClientHeaders, xFapiCustomerIpAddress, xMinV, xV);
        HttpHeaders headers = generateResponseHeaders(request);
        BankingPayeeDetail payeeDetail = payeeService.getBankingPayeeDetail(payeeId);
        if (payeeDetail == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        ResponseBankingPayeeById responseBankingPayeeById = new ResponseBankingPayeeById();
        responseBankingPayeeById.setData(payeeDetail);
        responseBankingPayeeById.setLinks(new Links().self(WebUtil.getOriginalUrl(request)));
        return new ResponseEntity<>(responseBankingPayeeById, headers, HttpStatus.OK);
    }

    public ResponseEntity<ResponseBankingPayeeList> listPayees(Integer page,
                                                               Integer pageSize,
                                                               ParamPayeeType type,
                                                               String xCdsClientHeaders,
                                                               OffsetDateTime xFapiAuthDate,
                                                               String xFapiCustomerIpAddress,
                                                               UUID xFapiInteractionId,
                                                               Integer xMinV,
                                                               Integer xV) {
        validateHeaders(xCdsClientHeaders, xFapiCustomerIpAddress, xMinV, xV);
        validatePageSize(pageSize);
        HttpHeaders headers = generateResponseHeaders(request);
        Integer actualPage = getPagingValue(page, 1);
        Integer actualPageSize = getPagingValue(pageSize, 25);
        ResponseBankingPayeeListData listData = new ResponseBankingPayeeListData();
        BankingPayee.Type payeeType = null;
        if (!ParamPayeeType.ALL.equals(type)) {
            payeeType = BankingPayee.Type.valueOf(type.name());
        }
        Page<BankingPayee> payeePage = payeeService.getBankingPayees(payeeType, PageRequest.of(actualPage - 1, actualPageSize));
        validatePageRange(actualPage, payeePage.getTotalPages());
        listData.setPayees(payeePage.getContent());
        ResponseBankingPayeeList responseBankingPayeeList = new ResponseBankingPayeeList();
        responseBankingPayeeList.setData(listData);
        responseBankingPayeeList.setLinks(getLinkData(request, payeePage, actualPage, actualPageSize));
        responseBankingPayeeList.setMeta(getMetaData(payeePage));
        return new ResponseEntity<>(responseBankingPayeeList, headers, HttpStatus.OK);
    }
}
