package au.org.consumerdatastandards.api.common;

import au.org.consumerdatastandards.api.common.models.ResponseDiscoveryOutages;
import au.org.consumerdatastandards.api.common.models.ResponseDiscoveryStatus;
import au.org.consumerdatastandards.support.data.*;
import au.org.consumerdatastandards.support.*;

@Section(name = "CommonDiscovery", tags = {"Common APIs", "Discovery"})
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
                content = ResponseDiscoveryOutages.class
            )
        }
    )
    @CustomAttributes({
        @CustomAttribute(name = "x-version", value = "1")
    })
    ResponseDiscoveryOutages getOutages();

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
    ResponseDiscoveryStatus getStatus();
}
