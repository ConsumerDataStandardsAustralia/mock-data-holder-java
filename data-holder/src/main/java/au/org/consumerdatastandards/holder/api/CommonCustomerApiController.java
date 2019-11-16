package au.org.consumerdatastandards.holder.api;

import au.org.consumerdatastandards.holder.model.ResponseCommonCustomer;
import au.org.consumerdatastandards.holder.model.ResponseCommonCustomerDetail;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;

@Controller
@RequestMapping("${openapi.consumerDataStandards.base-path:/cds-au/v1}")
public class CommonCustomerApiController implements CommonCustomerApi {

    private final NativeWebRequest request;

    @Autowired
    public CommonCustomerApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    public ResponseEntity<ResponseCommonCustomer> getCustomer(String xCdsUserAgent,
                                                              String xCdsSubject,
                                                              String xFapiAuthDate,
                                                              String xFapiCustomerIpAddress,
                                                              String xFapiInteractionId,
                                                              String xMinV,
                                                              String xV) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ResponseCommonCustomerDetail> getCustomerDetail(String xCdsUserAgent,
                                                                          String xCdsSubject,
                                                                          String xFapiAuthDate,
                                                                          String xFapiCustomerIpAddress,
                                                                          String xFapiInteractionId,
                                                                          String xMinV,
                                                                          String xV) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}
