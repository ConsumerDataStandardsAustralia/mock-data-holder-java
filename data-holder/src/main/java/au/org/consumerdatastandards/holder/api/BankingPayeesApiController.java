package au.org.consumerdatastandards.holder.api;

import au.org.consumerdatastandards.holder.model.ResponseBankingPayeeById;
import au.org.consumerdatastandards.holder.model.ResponseBankingPayeeList;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
@Controller
@RequestMapping("${openapi.consumerDataStandards.base-path:/cds-au/v1}")
public class BankingPayeesApiController implements BankingPayeesApi {

    private final NativeWebRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public BankingPayeesApiController(NativeWebRequest request) {
        this.request = request;
    }

    public ResponseEntity<ResponseBankingPayeeById> getPayeeDetail(@ApiParam(value = "The ID used to locate the details of a particular payee",required=true) @PathVariable("payeeId") String payeeId,@ApiParam(value = "The customers original User Agent header if the customer is currently logged in to the data recipient. Mandatory for customer present calls. Not required for unattended or unauthenticated calls. Base64 encoded contents which may included additional parameters." ) @RequestHeader(value="x-cds-User-Agent", required=false) String xCdsUserAgent,@ApiParam(value = "Subject identifier. Locally unique and never reassigned identifier within the Holder for the End-User. Mandatory for authenticated calls. Not required for unattended or unauthenticated calls." ) @RequestHeader(value="x-cds-subject", required=false) String xCdsSubject,@ApiParam(value = "The time when the customer last logged in to the data recipient. Required for all resource calls (customer present and unattended). Not to be included for unauthenticated calls." ) @RequestHeader(value="x-fapi-auth-date", required=false) String xFapiAuthDate,@ApiParam(value = "The customer&#39;s original IP address if the customer is currently logged in to the data recipient. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls." ) @RequestHeader(value="x-fapi-customer-ip-address", required=false) String xFapiCustomerIpAddress,@ApiParam(value = "An [RFC4122](https://tools.ietf.org/html/rfc4122) UID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction." ) @RequestHeader(value="x-fapi-interaction-id", required=false) String xFapiInteractionId,@ApiParam(value = "Minimum version of the API end point requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If all versions requested are not supported then the data holder should respond with a 406 Not Acceptable." ) @RequestHeader(value="x-min-v", required=false) String xMinV,@ApiParam(value = "Version of the API end point requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If the value of [x-min-v](#request-headers) is equal to or higher than the value of [x-v](#request-headers) then the [x-min-v](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder should respond with a 406 Not Acceptable. See [HTTP Headers](#request-headers)" ) @RequestHeader(value="x-v", required=false) String xV) {
return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    public ResponseEntity<ResponseBankingPayeeList> listPayees(@ApiParam(value = "Page of results to request (standard pagination)", defaultValue = "1")  @RequestParam(value = "page", required = false, defaultValue="1") Integer page,@ApiParam(value = "Page size to request. Default is 25 (standard pagination)", defaultValue = "25")  @RequestParam(value = "page-size", required = false, defaultValue="25") Integer pageSize,@ApiParam(value = "Filter on the payee type field.  In addition to normal type field values, ALL can be specified to retrieve all payees.  If absent the assumed value is ALL", allowableValues = "ALL, BILLER, DOMESTIC, INTERNATIONAL", defaultValue = "ALL")  @RequestParam(value = "type", required = false, defaultValue="ALL") String type,@ApiParam(value = "The customers original User Agent header if the customer is currently logged in to the data recipient. Mandatory for customer present calls. Not required for unattended or unauthenticated calls. Base64 encoded contents which may included additional parameters." ) @RequestHeader(value="x-cds-User-Agent", required=false) String xCdsUserAgent,@ApiParam(value = "Subject identifier. Locally unique and never reassigned identifier within the Holder for the End-User. Mandatory for authenticated calls. Not required for unattended or unauthenticated calls." ) @RequestHeader(value="x-cds-subject", required=false) String xCdsSubject,@ApiParam(value = "The time when the customer last logged in to the data recipient. Required for all resource calls (customer present and unattended). Not to be included for unauthenticated calls." ) @RequestHeader(value="x-fapi-auth-date", required=false) String xFapiAuthDate,@ApiParam(value = "The customer&#39;s original IP address if the customer is currently logged in to the data recipient. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls." ) @RequestHeader(value="x-fapi-customer-ip-address", required=false) String xFapiCustomerIpAddress,@ApiParam(value = "An [RFC4122](https://tools.ietf.org/html/rfc4122) UID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction." ) @RequestHeader(value="x-fapi-interaction-id", required=false) String xFapiInteractionId,@ApiParam(value = "Minimum version of the API end point requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If all versions requested are not supported then the data holder should respond with a 406 Not Acceptable." ) @RequestHeader(value="x-min-v", required=false) String xMinV,@ApiParam(value = "Version of the API end point requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If the value of [x-min-v](#request-headers) is equal to or higher than the value of [x-v](#request-headers) then the [x-min-v](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder should respond with a 406 Not Acceptable. See [HTTP Headers](#request-headers)" ) @RequestHeader(value="x-v", required=false) String xV) {
return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
