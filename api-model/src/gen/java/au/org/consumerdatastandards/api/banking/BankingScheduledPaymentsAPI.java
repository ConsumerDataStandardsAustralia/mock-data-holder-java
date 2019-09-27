package au.org.consumerdatastandards.api.banking;

import au.org.consumerdatastandards.api.banking.models.RequestAccountIds;
import au.org.consumerdatastandards.api.banking.models.ResponseBankingScheduledPaymentsList;
import au.org.consumerdatastandards.api.common.models.ResponseErrorList;
import au.org.consumerdatastandards.api.banking.models.ParamProductCategory;
import au.org.consumerdatastandards.api.banking.models.ParamAccountOpenStatus;
import au.org.consumerdatastandards.support.data.*;
import au.org.consumerdatastandards.support.*;

@Section(name = "BankingScheduledPayments", tags = {"Banking", "Scheduled Payments"})
public interface BankingScheduledPaymentsAPI  {

    @Endpoint(
        path = "/banking/accounts/{accountId}/payments/scheduled",
        summary = "Get Scheduled Payments for Account",
        description = "Obtain scheduled, outgoing payments for a specific account",
        requestMethod = RequestMethod.GET,
        operationId = "listScheduledPayments",
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
                content = ResponseBankingScheduledPaymentsList.class
            )
        }
    )
    @CustomAttributes({
        @CustomAttribute(name = "x-scopes", value = "bank:regular_payments:read", multiple = true),
        @CustomAttribute(name = "x-version", value = "1")
    })
    ResponseBankingScheduledPaymentsList listScheduledPayments(
        @Param(
            name = "accountId",
            description = "ID of the account to get scheduled payments for. Must have previously been returned by one of the account list end points. The account specified is the source account for the payment",
            in = ParamLocation.PATH
        )
        @CDSDataType(CustomDataType.ASCII)
        String accountId, 
        @Param(
            name = "page",
            description = "Page of results to request (standard pagination)",
            in = ParamLocation.QUERY,
            defaultValue = "1",
            reference = "ParamPage"
        )
        @CDSDataType(CustomDataType.PositiveInteger)
        Integer page, 
        @Param(
            name = "page-size",
            description = "Page size to request. Default is 25 (standard pagination)",
            in = ParamLocation.QUERY,
            defaultValue = "25",
            reference = "ParamPageSize"
        )
        @CDSDataType(CustomDataType.PositiveInteger)
        Integer pageSize,
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
        path = "/banking/payments/scheduled",
        summary = "Get Scheduled Payments Bulk",
        description = "Obtain scheduled payments for multiple, filtered accounts that are the source of funds for the payments",
        requestMethod = RequestMethod.GET,
        operationId = "listScheduledPaymentsBulk",
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
                content = ResponseBankingScheduledPaymentsList.class
            )
        }
    )
    @CustomAttributes({
        @CustomAttribute(name = "x-scopes", value = "bank:regular_payments:read", multiple = true),
        @CustomAttribute(name = "x-version", value = "1")
    })
    ResponseBankingScheduledPaymentsList listScheduledPaymentsBulk(
        @Param(
            name = "product-category",
            description = "Used to filter results on the productCategory field applicable to accounts. Any one of the valid values for this field can be supplied. If absent then all accounts returned.",
            in = ParamLocation.QUERY,
            reference = "ParamProductCategory"
        )
        ParamProductCategory productCategory, 
        @Param(
            name = "open-status",
            description = "Used to filter results according to open/closed status. Values can be OPEN, CLOSED or ALL. If absent then ALL is assumed",
            in = ParamLocation.QUERY,
            defaultValue = "ALL",
            reference = "ParamAccountOpenStatus"
        )
        ParamAccountOpenStatus openStatus, 
        @Param(
            name = "is-owned",
            description = "Filters accounts based on whether they are owned by the authorised customer.  True for owned accounts, false for unowned accounts and absent for all accounts",
            in = ParamLocation.QUERY,
            reference = "ParamAccountIsOwned"
        )
        @CDSDataType(CustomDataType.Boolean)
        Boolean isOwned, 
        @Param(
            name = "page",
            description = "Page of results to request (standard pagination)",
            in = ParamLocation.QUERY,
            defaultValue = "1",
            reference = "ParamPage"
        )
        @CDSDataType(CustomDataType.PositiveInteger)
        Integer page, 
        @Param(
            name = "page-size",
            description = "Page size to request. Default is 25 (standard pagination)",
            in = ParamLocation.QUERY,
            defaultValue = "25",
            reference = "ParamPageSize"
        )
        @CDSDataType(CustomDataType.PositiveInteger)
        Integer pageSize,
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
        path = "/banking/payments/scheduled",
        summary = "Get Scheduled Payments For Specific Accounts",
        description = "Obtain scheduled payments for a specified list of accounts",
        requestMethod = RequestMethod.POST,
        operationId = "listScheduledPaymentsSpecificAccounts",
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
                content = ResponseBankingScheduledPaymentsList.class
            ),
            @EndpointResponse(
                responseCode = ResponseCode.UNPROCESSABLE_ENTITY,
                description = "The request was well formed but was unable to be processed due to business logic specific to the request",
                headers = {
                    @ResponseHeader(
                        name="x-fapi-interaction-id",
                        type = "string",
                        description = "An [RFC4122](https://tools.ietf.org/html/rfc4122) UID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction."
                    )
                },
                content = ResponseErrorList.class
            )
        }
    )
    @CustomAttributes({
        @CustomAttribute(name = "x-scopes", value = "bank:regular_payments:read", multiple = true),
        @CustomAttribute(name = "x-version", value = "1")
    })
    ResponseBankingScheduledPaymentsList listScheduledPaymentsSpecificAccounts(
        @Param(
            name = "accountIds",
            description = "Array of specific accountIds to obtain scheduled payments for.  The accounts specified are the source of funds for the payments returned",
            in = ParamLocation.BODY
        )
        RequestAccountIds accountIds, 
        @Param(
            name = "page",
            description = "Page of results to request (standard pagination)",
            in = ParamLocation.QUERY,
            defaultValue = "1",
            reference = "ParamPage"
        )
        @CDSDataType(CustomDataType.PositiveInteger)
        Integer page, 
        @Param(
            name = "page-size",
            description = "Page size to request. Default is 25 (standard pagination)",
            in = ParamLocation.QUERY,
            defaultValue = "25",
            reference = "ParamPageSize"
        )
        @CDSDataType(CustomDataType.PositiveInteger)
        Integer pageSize,
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
