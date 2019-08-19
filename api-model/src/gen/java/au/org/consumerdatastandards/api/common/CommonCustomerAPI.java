package au.org.consumerdatastandards.api.common;

import au.org.consumerdatastandards.api.common.models.ResponseCommonCustomer;
import au.org.consumerdatastandards.api.common.models.ResponseCommonCustomerDetail;
import au.org.consumerdatastandards.support.data.*;
import au.org.consumerdatastandards.support.*;

@Section(name = "CommonCustomer", tags = {"Common APIs", "Customer"})
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
        @CustomAttribute(name = "x-scopes", value = "common_basic_customer", multiple = true),
        @CustomAttribute(name = "x-version", value = "1")
    })
    ResponseCommonCustomer getCustomer();

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
        @CustomAttribute(name = "x-scopes", value = "common_detailed_customer", multiple = true),
        @CustomAttribute(name = "x-version", value = "1")
    })
    ResponseCommonCustomerDetail getCustomerDetail();
}
