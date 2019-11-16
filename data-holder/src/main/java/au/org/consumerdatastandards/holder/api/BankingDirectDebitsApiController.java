package au.org.consumerdatastandards.holder.api;

import au.org.consumerdatastandards.holder.model.RequestAccountIds;
import au.org.consumerdatastandards.holder.model.ResponseBankingDirectDebitAuthorisationList;
import au.org.consumerdatastandards.holder.model.ResponseErrorList;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@Controller
@RequestMapping("${openapi.consumerDataStandards.base-path:/cds-au/v1}")
public class BankingDirectDebitsApiController implements BankingDirectDebitsApi {

    private final NativeWebRequest request;

    @Autowired
    public BankingDirectDebitsApiController(NativeWebRequest request) {
        this.request = request;
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
                                                                                        String xFapiAuthDate,
                                                                                        String xFapiCustomerIpAddress,
                                                                                        String xFapiInteractionId,
                                                                                        String xMinV,
                                                                                        String xV) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ResponseBankingDirectDebitAuthorisationList> listDirectDebitsSpecificAccounts(RequestAccountIds accountIds,
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
