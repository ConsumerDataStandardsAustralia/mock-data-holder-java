package au.org.consumerdatastandards.holder.api;

import au.org.consumerdatastandards.holder.model.ParamAccountOpenStatus;
import au.org.consumerdatastandards.holder.model.ParamProductCategory;
import au.org.consumerdatastandards.holder.model.RequestAccountIds;
import au.org.consumerdatastandards.holder.model.ResponseBankingScheduledPaymentsList;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;

@Controller
@RequestMapping("${openapi.consumerDataStandards.base-path:/cds-au/v1}")
public class BankingScheduledPaymentsApiController implements BankingScheduledPaymentsApi {

    private final NativeWebRequest request;

    @Autowired
    public BankingScheduledPaymentsApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    public ResponseEntity<ResponseBankingScheduledPaymentsList> listScheduledPayments(String accountId,
                                                                                      Integer page,
                                                                                      Integer pageSize,
                                                                                      String xCdsUserAgent,
                                                                                      String xCdsSubject,
                                                                                      String xFapiAuthDate,
                                                                                      String xFapiCustomerIpAddress,
                                                                                      String xFapiInteractionId,
                                                                                      String xMinV,
                                                                                      String xV) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<ResponseBankingScheduledPaymentsList> listScheduledPaymentsBulk(ParamProductCategory productCategory,
                                                                                          ParamAccountOpenStatus openStatus,
                                                                                          Boolean isOwned,
                                                                                          Integer page,
                                                                                          Integer pageSize,
                                                                                          String xCdsUserAgent,
                                                                                          String xCdsSubject,
                                                                                          String xFapiAuthDate,
                                                                                          String xFapiCustomerIpAddress,
                                                                                          String xFapiInteractionId,
                                                                                          String xMinV,
                                                                                          String xV) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ResponseBankingScheduledPaymentsList> listScheduledPaymentsSpecificAccounts(RequestAccountIds accountIds,
                                                                                                      Integer page,
                                                                                                      Integer pageSize,
                                                                                                      String xCdsUserAgent,
                                                                                                      String xCdsSubject,
                                                                                                      String xFapiAuthDate,
                                                                                                      String xFapiCustomerIpAddress,
                                                                                                      String xFapiInteractionId,
                                                                                                      String xMinV,
                                                                                                      String xV) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}
