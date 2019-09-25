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
                headers = {
                    @ResponseHeader(
                        name="x-v",
                        type = "string",
                        description = "The [version](#response-headers) of the API end point that the data holder has responded with."
                    ),
                    @ResponseHeader(
                        name="x-fapi-interaction-id",
                        type = "string",
                        description = "An RFC4122 UID used as a correlation id. The data holder must set the response header x-fapi-interaction-id to the value received from the corresponding fapi client request header or to a new RFC4122 UUID value if the request header was not provided to track the interaction."
                    )
                },
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
        String xMinV, 
        @Param(
            name = "x-fapi-interaction-id",
            description = "An [RFC4122](https://tools.ietf.org/html/rfc4122) UID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction.",
            in = ParamLocation.HEADER,
            reference = "RequestHeader_x-fapi-interaction-id"
        )
        String xFapiInteractionId, 
        @Param(
            name = "x-fapi-auth-date",
            description = "The time when the customer last logged in to the data recipient. Required for all resource calls (customer present and unattended). Not to be included for unauthenticated calls.",
            in = ParamLocation.HEADER,
            reference = "RequestHeader_x-fapi-auth-date"
        )
        String xFapiAuthDate, 
        @Param(
            name = "x-fapi-customer-ip-address",
            description = "The customer&#39;s original IP address if the customer is currently logged in to the data recipient. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls.",
            in = ParamLocation.HEADER,
            reference = "RequestHeader_x-fapi-customer-ip-address"
        )
        String xFapiCustomerIpAddress, 
        @Param(
            name = "x-cds-User-Agent",
            description = "The customers original User Agent header if the customer is currently logged in to the data recipient. Mandatory for customer present calls. Not required for unattended or unauthenticated calls. Base64 encoded contents which may included additional parameters.",
            in = ParamLocation.HEADER,
            reference = "RequestHeader_x-cds-User-Agent"
        )
        @CDSDataType(CustomDataType.Base64)
        String xCdsUserAgent, 
        @Param(
            name = "x-cds-subject",
            description = "Subject identifier. Locally unique and never reassigned identifier within the Holder for the End-User. Mandatory for authenticated calls. Not required for unattended or unauthenticated calls.",
            in = ParamLocation.HEADER,
            reference = "RequestHeader_x-cds-subject"
        )
        String xCdsSubject
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
                headers = {
                    @ResponseHeader(
                        name="x-v",
                        type = "string",
                        description = "The [version](#response-headers) of the API end point that the data holder has responded with."
                    ),
                    @ResponseHeader(
                        name="x-fapi-interaction-id",
                        type = "string",
                        description = "An RFC4122 UID used as a correlation id. The data holder must set the response header x-fapi-interaction-id to the value received from the corresponding fapi client request header or to a new RFC4122 UUID value if the request header was not provided to track the interaction."
                    )
                },
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
        String xMinV, 
        @Param(
            name = "x-fapi-interaction-id",
            description = "An [RFC4122](https://tools.ietf.org/html/rfc4122) UID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction.",
            in = ParamLocation.HEADER,
            reference = "RequestHeader_x-fapi-interaction-id"
        )
        String xFapiInteractionId, 
        @Param(
            name = "x-fapi-auth-date",
            description = "The time when the customer last logged in to the data recipient. Required for all resource calls (customer present and unattended). Not to be included for unauthenticated calls.",
            in = ParamLocation.HEADER,
            reference = "RequestHeader_x-fapi-auth-date"
        )
        String xFapiAuthDate, 
        @Param(
            name = "x-fapi-customer-ip-address",
            description = "The customer&#39;s original IP address if the customer is currently logged in to the data recipient. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls.",
            in = ParamLocation.HEADER,
            reference = "RequestHeader_x-fapi-customer-ip-address"
        )
        String xFapiCustomerIpAddress, 
        @Param(
            name = "x-cds-User-Agent",
            description = "The customers original User Agent header if the customer is currently logged in to the data recipient. Mandatory for customer present calls. Not required for unattended or unauthenticated calls. Base64 encoded contents which may included additional parameters.",
            in = ParamLocation.HEADER,
            reference = "RequestHeader_x-cds-User-Agent"
        )
        @CDSDataType(CustomDataType.Base64)
        String xCdsUserAgent, 
        @Param(
            name = "x-cds-subject",
            description = "Subject identifier. Locally unique and never reassigned identifier within the Holder for the End-User. Mandatory for authenticated calls. Not required for unattended or unauthenticated calls.",
            in = ParamLocation.HEADER,
            reference = "RequestHeader_x-cds-subject"
        )
        String xCdsSubject
    );
}
