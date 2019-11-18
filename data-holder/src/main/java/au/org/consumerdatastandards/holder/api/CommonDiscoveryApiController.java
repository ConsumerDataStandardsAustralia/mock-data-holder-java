package au.org.consumerdatastandards.holder.api;

import au.org.consumerdatastandards.holder.model.CommonDiscoveryStatus;
import au.org.consumerdatastandards.holder.model.ResponseDiscoveryOutagesList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;

import javax.validation.constraints.Min;
import java.util.Optional;

@Validated
@Controller
@RequestMapping("${openapi.consumerDataStandards.base-path:/cds-au/v1}")
public class CommonDiscoveryApiController implements CommonDiscoveryApi {

    private final NativeWebRequest request;

    @Autowired
    public CommonDiscoveryApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    public ResponseEntity<ResponseDiscoveryOutagesList> getOutages(@Min(1) Integer xMinV, @Min(1) Integer xV) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

      public ResponseEntity<CommonDiscoveryStatus> getStatus(@Min(1) Integer xMinV, @Min(1) Integer xV) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}
