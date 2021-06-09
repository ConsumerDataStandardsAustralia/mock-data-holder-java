package au.org.consumerdatastandards.holder.api;

import au.org.consumerdatastandards.holder.model.ResponseCommonDiscoveryStatus;
import au.org.consumerdatastandards.holder.model.ResponseDiscoveryOutagesList;
import au.org.consumerdatastandards.holder.model.ResponseErrorListV2;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.NativeWebRequest;

import javax.validation.constraints.Min;
import java.util.Optional;

@Api(value = "CommonDiscovery", description = "the CommonDiscovery API")
public interface CommonDiscoveryApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    @ApiOperation(
        value = "Get Outages",
        nickname = "getOutages",
        notes = "Obtain a list of scheduled outages for the implementation",
        response = ResponseDiscoveryOutagesList.class,
        tags = {"Discovery", "Common"}
    )
    @ApiResponses(value = {
        @ApiResponse(
            code = 200,
            message = "Success",
            response = ResponseDiscoveryOutagesList.class
        ),
        @ApiResponse(
            code = 400,
            message = "Invalid Version / Invalid Field",
            response = ResponseErrorListV2.class
        ),
        @ApiResponse(
            code = 406,
            message = "Unsupported Version",
            response = ResponseErrorListV2.class
        )
    })
    @RequestMapping(
        value = "/discovery/outages",
        method = RequestMethod.GET
    )
    ResponseEntity<ResponseDiscoveryOutagesList> getOutages(
        @ApiParam(
            value = "Minimum version of the API end point requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable."
        )
        @RequestHeader(value = "x-min-v", required = false) @Min(1) Integer xMinV,
        @ApiParam(
            value = "Version of the API end point requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If the value of [x-min-v](#request-headers) is equal to or higher than the value of [x-v](#request-headers) then the [x-min-v](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable. See [HTTP Headers](#request-headers)"
        )
        @RequestHeader(value = "x-v", required = false) @Min(1) Integer xV
    );

    @ApiOperation(
        value = "Get Status",
        nickname = "getStatus",
        notes = "Obtain a health check status for the implementation",
        response = ResponseCommonDiscoveryStatus.class,
        tags = {"Discovery", "Common"}
    )
    @ApiResponses(value = {
        @ApiResponse(
            code = 200,
            message = "Success",
            response = ResponseCommonDiscoveryStatus.class
        ),
        @ApiResponse(
            code = 400,
            message = "Invalid Version / Invalid Field",
            response = ResponseErrorListV2.class
        ),
        @ApiResponse(
            code = 406,
            message = "Unsupported Version",
            response = ResponseErrorListV2.class
        )
    })
    @RequestMapping(
        value = "/discovery/status",
        method = RequestMethod.GET
    )
    ResponseEntity<ResponseCommonDiscoveryStatus> getStatus(
        @ApiParam(
            value = "Minimum version of the API end point requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable."
        )
        @RequestHeader(value = "x-min-v", required = false) @Min(1) Integer xMinV,
        @ApiParam(
            value = "Version of the API end point requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If the value of [x-min-v](#request-headers) is equal to or higher than the value of [x-v](#request-headers) then the [x-min-v](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable. See [HTTP Headers](#request-headers)"
        )
        @RequestHeader(value = "x-v", required = false) @Min(1) Integer xV
    );
}
