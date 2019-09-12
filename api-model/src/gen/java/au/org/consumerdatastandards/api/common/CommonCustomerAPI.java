package au.org.consumerdatastandards.api.common;

import au.org.consumerdatastandards.api.common.models.ResponseCommonCustomer;
import au.org.consumerdatastandards.api.common.models.ResponseCommonCustomerDetail;
import au.org.consumerdatastandards.support.data.*;
import au.org.consumerdatastandards.support.*;

@Section(name = "CommonCustomer", tags = {"Common", "Customer"})
public interface CommonCustomerAPI  {

    @Endpoint(
        path = "/common/customer",
        summary = "Get Customer",
        description = "Obtain basic information on the customer that has authorised the current session",
        requestMethod = RequestMethod.GET,
        operationId = "getCustomer",
        responses = {
            @EndpointResponse(
                responseCode = ResponseCode.OK,
                description = "Success",
                content = ResponseCommonCustomer.class
            )
        }
    )
    @CustomAttributes({
        @CustomAttribute(name = "x-scopes", value = "common:customer.basic:read", multiple = true),
        @CustomAttribute(name = "x-version", value = "1")
    })
    ResponseCommonCustomer getCustomer(
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
        path = "/common/customer/detail",
        summary = "Get Customer Detail",
        description = "Obtain detailed information on the authorised customer within the current session.",
        requestMethod = RequestMethod.GET,
        operationId = "getCustomerDetail",
        responses = {
            @EndpointResponse(
                responseCode = ResponseCode.OK,
                description = "Success",
                content = ResponseCommonCustomerDetail.class
            )
        }
    )
    @CustomAttributes({
        @CustomAttribute(name = "x-scopes", value = "common:customer.detail:read", multiple = true),
        @CustomAttribute(name = "x-version", value = "1")
    })
    ResponseCommonCustomerDetail getCustomerDetail(
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
