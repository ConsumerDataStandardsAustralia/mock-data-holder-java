package au.org.consumerdatastandards.api.common;

import au.org.consumerdatastandards.api.common.models.ResponseDiscoveryOutagesList;
import au.org.consumerdatastandards.api.common.models.ResponseDiscoveryStatus;
import au.org.consumerdatastandards.support.data.*;
import au.org.consumerdatastandards.support.*;

@Section(name = "CommonDiscovery", tags = {"Common", "Discovery"})
public interface CommonDiscoveryAPI  {

    @Endpoint(
        path = "/discovery/outages",
        summary = "Get Outages",
        description = "Obtain a list of scheduled outages for the implementation",
        requestMethod = RequestMethod.GET,
        operationId = "getOutages",
        responses = {
            @EndpointResponse(
                responseCode = ResponseCode.OK,
                description = "Success",
                content = ResponseDiscoveryOutagesList.class
            )
        }
    )
    @CustomAttributes({
        @CustomAttribute(name = "x-version", value = "1")
    })
    ResponseDiscoveryOutagesList getOutages(
        @Param(
            name = "x-v",
            description = "Version of the API end point requested by the client. Must be set to a positive integer. If the version(s) requested is not supported then the holder should respond with a 406 Not Acceptable. See [here](#request-headers)",
            in = ParamLocation.HEADER,
            reference = "RequestHeader_x-v"
        )
        String xV, 
        @Param(
            name = "x-min-v",
            description = "Minimum version of the API end point requested by the client. Must be set to a positive integer if provided. The holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If all versions requested are not supported then the holder should respond with a 406 Not Acceptable.",
            in = ParamLocation.HEADER,
            reference = "RequestHeader_x-min-v"
        )
        String xMinV
    );

    @Endpoint(
        path = "/discovery/status",
        summary = "Get Status",
        description = "Obtain a health check status for the implementation",
        requestMethod = RequestMethod.GET,
        operationId = "getStatus",
        responses = {
            @EndpointResponse(
                responseCode = ResponseCode.OK,
                description = "Success",
                content = ResponseDiscoveryStatus.class
            )
        }
    )
    @CustomAttributes({
        @CustomAttribute(name = "x-version", value = "1")
    })
    ResponseDiscoveryStatus getStatus(
        @Param(
            name = "x-v",
            description = "Version of the API end point requested by the client. Must be set to a positive integer. If the version(s) requested is not supported then the holder should respond with a 406 Not Acceptable. See [here](#request-headers)",
            in = ParamLocation.HEADER,
            reference = "RequestHeader_x-v"
        )
        String xV, 
        @Param(
            name = "x-min-v",
            description = "Minimum version of the API end point requested by the client. Must be set to a positive integer if provided. The holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If all versions requested are not supported then the holder should respond with a 406 Not Acceptable.",
            in = ParamLocation.HEADER,
            reference = "RequestHeader_x-min-v"
        )
        String xMinV
    );
}
