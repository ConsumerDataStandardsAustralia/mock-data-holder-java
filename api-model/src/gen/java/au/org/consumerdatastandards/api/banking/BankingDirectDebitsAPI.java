package au.org.consumerdatastandards.api.banking;

import au.org.consumerdatastandards.api.banking.models.RequestAccountIds;
import au.org.consumerdatastandards.api.banking.models.ResponseBankingDirectDebitAuthorisationList;
import au.org.consumerdatastandards.api.common.models.ResponseErrorList;
import au.org.consumerdatastandards.api.banking.models.ParamProductCategory;
import au.org.consumerdatastandards.api.banking.models.ParamAccountOpenStatus;
import au.org.consumerdatastandards.support.data.*;
import au.org.consumerdatastandards.support.*;

@Section(name = "BankingDirectDebits", tags = {"Banking", "Direct Debits"})
public interface BankingDirectDebitsAPI  {

    @Endpoint(
        path = "/banking/accounts/{accountId}/direct-debits",
        summary = "Get Direct Debits For Account",
        description = "Obtain direct debit authorisations for a specific account",
        requestMethod = RequestMethod.GET,
        operationId = "listDirectDebits",
        responses = {
            @EndpointResponse(
                responseCode = ResponseCode.OK,
                description = "Success",
                content = ResponseBankingDirectDebitAuthorisationList.class
            )
        }
    )
    @CustomAttributes({
        @CustomAttribute(name = "x-scopes", value = "bank:regular_payments:read", multiple = true),
        @CustomAttribute(name = "x-version", value = "1")
    })
    ResponseBankingDirectDebitAuthorisationList listDirectDebits(
        @Param(
            name = "accountId",
            description = "ID of the account to get direct debit authorisations for.  Must have previously been returned by one of the account list end points.",
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
        path = "/banking/accounts/direct-debits",
        summary = "Get Bulk Direct Debits",
        description = "Obtain direct debit authorisations for multiple, filtered accounts",
        requestMethod = RequestMethod.GET,
        operationId = "listDirectDebitsBulk",
        responses = {
            @EndpointResponse(
                responseCode = ResponseCode.OK,
                description = "Success",
                content = ResponseBankingDirectDebitAuthorisationList.class
            )
        }
    )
    @CustomAttributes({
        @CustomAttribute(name = "x-scopes", value = "bank:regular_payments:read", multiple = true),
        @CustomAttribute(name = "x-version", value = "1")
    })
    ResponseBankingDirectDebitAuthorisationList listDirectDebitsBulk(
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
        path = "/banking/accounts/direct-debits",
        summary = "Get Direct Debits For Specific Accounts",
        description = "Obtain direct debit authorisations for a specified list of accounts",
        requestMethod = RequestMethod.POST,
        operationId = "listDirectDebitsSpecificAccounts",
        responses = {
            @EndpointResponse(
                responseCode = ResponseCode.OK,
                description = "Success",
                content = ResponseBankingDirectDebitAuthorisationList.class
            ),
            @EndpointResponse(
                responseCode = ResponseCode.UNPROCESSABLE_ENTITY,
                description = "The request was well formed but was unable to be processed due to business logic specific to the request",
                content = ResponseErrorList.class
            )
        }
    )
    @CustomAttributes({
        @CustomAttribute(name = "x-scopes", value = "bank:regular_payments:read", multiple = true),
        @CustomAttribute(name = "x-version", value = "1"),
        @CustomAttribute(name = "x-contentType", value = "16")
    })
    ResponseBankingDirectDebitAuthorisationList listDirectDebitsSpecificAccounts(
        @Param(
            name = "accountIds",
            description = "Array of specific accountIds to obtain authorisations for",
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
