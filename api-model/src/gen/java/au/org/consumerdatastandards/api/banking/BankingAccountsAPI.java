package au.org.consumerdatastandards.api.banking;

import au.org.consumerdatastandards.api.banking.models.RequestAccountIds;
import au.org.consumerdatastandards.api.banking.models.ResponseBankingAccountById;
import au.org.consumerdatastandards.api.banking.models.ResponseBankingAccountList;
import au.org.consumerdatastandards.api.banking.models.ResponseBankingAccountsBalanceById;
import au.org.consumerdatastandards.api.banking.models.ResponseBankingAccountsBalanceList;
import au.org.consumerdatastandards.api.banking.models.ResponseBankingTransactionById;
import au.org.consumerdatastandards.api.banking.models.ResponseBankingTransactionList;
import au.org.consumerdatastandards.api.common.models.ResponseErrorList;
import au.org.consumerdatastandards.api.banking.models.ParamProductCategory;
import au.org.consumerdatastandards.api.banking.models.ParamAccountOpenStatus;
import au.org.consumerdatastandards.support.data.*;
import au.org.consumerdatastandards.support.*;

@Section(name = "BankingAccounts", tags = {"Banking", "Accounts"})
public interface BankingAccountsAPI  {

    @Endpoint(
        path = "/banking/accounts/{accountId}",
        summary = "Get Account Detail",
        description = "Obtain detailed information on a single account",
        requestMethod = RequestMethod.GET,
        operationId = "getAccountDetail",
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
                content = ResponseBankingAccountById.class
            )
        }
    )
    @CustomAttributes({
        @CustomAttribute(name = "x-scopes", value = "bank:accounts.detail:read", multiple = true),
        @CustomAttribute(name = "x-version", value = "1")
    })
    ResponseBankingAccountById getAccountDetail(
        @Param(
            name = "accountId",
            description = "A tokenised identifier for the account which is unique but not shareable",
            in = ParamLocation.PATH
        )
        @CDSDataType(CustomDataType.ASCII)
        String accountId, 
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
            description = "The customer's original IP address if the customer is currently logged in to the data recipient. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls.",
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
        path = "/banking/accounts/{accountId}/transactions/{transactionId}",
        summary = "Get Transaction Detail",
        description = "Obtain detailed information on a transaction for a specific account",
        requestMethod = RequestMethod.GET,
        operationId = "getTransactionDetail",
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
                content = ResponseBankingTransactionById.class
            )
        }
    )
    @CustomAttributes({
        @CustomAttribute(name = "x-scopes", value = "bank:transactions:read", multiple = true),
        @CustomAttribute(name = "x-version", value = "1")
    })
    ResponseBankingTransactionById getTransactionDetail(
        @Param(
            name = "accountId",
            description = "ID of the account to get transactions for.  Must have previously been returned by one of the account list end points",
            in = ParamLocation.PATH
        )
        @CDSDataType(CustomDataType.ASCII)
        String accountId, 
        @Param(
            name = "transactionId",
            description = "ID of the transaction obtained from a previous call to one of the other transaction end points",
            in = ParamLocation.PATH
        )
        @CDSDataType(CustomDataType.ASCII)
        String transactionId, 
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
            description = "The customer's original IP address if the customer is currently logged in to the data recipient. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls.",
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
        path = "/banking/accounts/{accountId}/transactions",
        summary = "Get Transactions For Account",
        description = "Obtain transactions for a specific account.  Some general notes that apply to all end points that retrieve transactions:  - Where multiple transactions are returned, transactions should be ordered according to effective date in descending order - As the date and time for a transaction can alter depending on status and transaction type two separate date/times are included in the payload. There are still some scenarios where neither of these time stamps is available. For the purpose of filtering and ordering it is expected that the data holder will use the “effective” date/time which will be defined as:   - Posted date/time if available, then   - Execution date/time if available, then   - A reasonable date/time nominated by the data holder using internal data structures - For transaction amounts it should be assumed that a negative value indicates a reduction of the available balance on the account while a positive value indicates an increase in the available balance on the account",
        requestMethod = RequestMethod.GET,
        operationId = "getTransactions",
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
                content = ResponseBankingTransactionList.class
            )
        }
    )
    @CustomAttributes({
        @CustomAttribute(name = "x-scopes", value = "bank:transactions:read", multiple = true),
        @CustomAttribute(name = "x-version", value = "1")
    })
    ResponseBankingTransactionList getTransactions(
        @Param(
            name = "accountId",
            description = "ID of the account to get transactions for.  Must have previously been returned by one of the account list end points.",
            in = ParamLocation.PATH
        )
        @CDSDataType(CustomDataType.ASCII)
        String accountId,
        @Param(
            name = "oldest-time",
            description = "Constrain the transaction history request to transactions with effective time at or after this date/time. If absent defaults to newest-time minus 90 days.  Format is aligned to DateTimeString common type",
            in = ParamLocation.QUERY,
            reference = "ParamTransactionOldestTime"
        )
        @CDSDataType(CustomDataType.DateTime)
        String oldestTime, 
        @Param(
            name = "newest-time",
            description = "Constrain the transaction history request to transactions with effective time at or before this date/time.  If absent defaults to today.  Format is aligned to DateTimeString common type",
            in = ParamLocation.QUERY,
            reference = "ParamTransactionNewestTime"
        )
        @CDSDataType(CustomDataType.DateTime)
        String newestTime, 
        @Param(
            name = "min-amount",
            description = "Filter transactions to only transactions with amounts higher or equal to than this amount",
            in = ParamLocation.QUERY,
            reference = "ParamTransactionMinAmount"
        )
        @CDSDataType(CustomDataType.Amount)
        String minAmount, 
        @Param(
            name = "max-amount",
            description = "Filter transactions to only transactions with amounts less than or equal to than this amount",
            in = ParamLocation.QUERY,
            reference = "ParamTransactionMaxAmount"
        )
        @CDSDataType(CustomDataType.Amount)
        String maxAmount, 
        @Param(
            name = "text",
            description = "Filter transactions to only transactions where this string value is found as a substring of either the reference or description fields. Format is arbitrary ASCII string. This parameter is optionally implemented by data holders. If it is not implemented then a response should be provided as normal without text filtering applied",
            in = ParamLocation.QUERY,
            reference = "ParamTransactionText"
        )
        String text, 
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
            description = "The customer's original IP address if the customer is currently logged in to the data recipient. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls.",
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
        path = "/banking/accounts",
        summary = "Get Accounts",
        description = "Obtain a list of accounts",
        requestMethod = RequestMethod.GET,
        operationId = "listAccounts",
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
                content = ResponseBankingAccountList.class
            )
        }
    )
    @CustomAttributes({
        @CustomAttribute(name = "x-scopes", value = "bank:accounts.basic:read", multiple = true),
        @CustomAttribute(name = "x-version", value = "1")
    })
    ResponseBankingAccountList listAccounts(
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
            description = "The customer's original IP address if the customer is currently logged in to the data recipient. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls.",
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
        path = "/banking/accounts/{accountId}/balance",
        summary = "Get Account Balance",
        description = "Obtain the balance for a single specified account",
        requestMethod = RequestMethod.GET,
        operationId = "listBalance",
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
                content = ResponseBankingAccountsBalanceById.class
            )
        }
    )
    @CustomAttributes({
        @CustomAttribute(name = "x-scopes", value = "bank:accounts.basic:read", multiple = true),
        @CustomAttribute(name = "x-version", value = "1")
    })
    ResponseBankingAccountsBalanceById listBalance(
        @Param(
            name = "accountId",
            description = "ID of the specific account requested",
            in = ParamLocation.PATH
        )
        @CDSDataType(CustomDataType.ASCII)
        String accountId, 
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
            description = "The customer's original IP address if the customer is currently logged in to the data recipient. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls.",
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
        path = "/banking/accounts/balances",
        summary = "Get Bulk Balances",
        description = "Obtain balances for multiple, filtered accounts",
        requestMethod = RequestMethod.GET,
        operationId = "listBalancesBulk",
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
                content = ResponseBankingAccountsBalanceList.class
            )
        }
    )
    @CustomAttributes({
        @CustomAttribute(name = "x-scopes", value = "bank:accounts.basic:read", multiple = true),
        @CustomAttribute(name = "x-version", value = "1")
    })
    ResponseBankingAccountsBalanceList listBalancesBulk(
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
            description = "The customer's original IP address if the customer is currently logged in to the data recipient. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls.",
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
        path = "/banking/accounts/balances",
        summary = "Get Balances For Specific Accounts",
        description = "Obtain balances for a specified list of accounts",
        requestMethod = RequestMethod.POST,
        operationId = "listBalancesSpecificAccounts",
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
                content = ResponseBankingAccountsBalanceList.class
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
        @CustomAttribute(name = "x-scopes", value = "bank:accounts.basic:read", multiple = true),
        @CustomAttribute(name = "x-version", value = "1")
    })
    ResponseBankingAccountsBalanceList listBalancesSpecificAccounts(
        @Param(
            name = "accountIds",
            description = "The list of account IDs to obtain balances for",
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
            description = "The customer's original IP address if the customer is currently logged in to the data recipient. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls.",
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
