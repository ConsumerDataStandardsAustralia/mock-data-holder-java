package au.org.consumerdatastandards.api.common;

import au.org.consumerdatastandards.api.common.models.CommonDiscoveryStatus;
import au.org.consumerdatastandards.api.common.models.ResponseDiscoveryOutagesList;
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
                headers = {
                    @ResponseHeader(
                        name="x-v",
                        type = "string",
                        description = "The [version](#response-headers) of the API end point that the data holder has responded with."
                    )
                },
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
            description = "Version of the API end point requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If the value of [x-min-v](#request-headers) is equal to or higher than the value of [x-v](#request-headers) then the [x-min-v](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder should respond with a 406 Not Acceptable. See [HTTP Headers](#request-headers)",
            in = ParamLocation.HEADER,
            reference = "RequestHeader_x-v"
        )
        String xV, 
        @Param(
            name = "x-min-v",
            description = "Minimum version of the API end point requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If all versions requested are not supported then the data holder should respond with a 406 Not Acceptable.",
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
                headers = {
                    @ResponseHeader(
                        name="x-v",
                        type = "string",
                        description = "The [version](#response-headers) of the API end point that the data holder has responded with."
                    )
                },
                content = CommonDiscoveryStatus.class
            )
        }
    )
    @CustomAttributes({
        @CustomAttribute(name = "x-version", value = "1")
    })
    CommonDiscoveryStatus getStatus(
        @Param(
            name = "x-v",
            description = "Version of the API end point requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If the value of [x-min-v](#request-headers) is equal to or higher than the value of [x-v](#request-headers) then the [x-min-v](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder should respond with a 406 Not Acceptable. See [HTTP Headers](#request-headers)",
            in = ParamLocation.HEADER,
            reference = "RequestHeader_x-v"
        )
        String xV, 
        @Param(
            name = "x-min-v",
            description = "Minimum version of the API end point requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If all versions requested are not supported then the data holder should respond with a 406 Not Acceptable.",
            in = ParamLocation.HEADER,
            reference = "RequestHeader_x-min-v"
        )
        String xMinV
    );
}
