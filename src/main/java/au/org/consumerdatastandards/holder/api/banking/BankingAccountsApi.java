package au.org.consumerdatastandards.holder.api.banking;

import au.org.consumerdatastandards.holder.api.DateFormat;
import au.org.consumerdatastandards.holder.model.ErrorListResponse;
import au.org.consumerdatastandards.holder.model.banking.ParamAccountOpenStatus;
import au.org.consumerdatastandards.holder.model.banking.ParamProductCategory;
import au.org.consumerdatastandards.holder.model.banking.RequestAccountIds;
import au.org.consumerdatastandards.holder.model.banking.ResponseBankingAccountById;
import au.org.consumerdatastandards.holder.model.banking.ResponseBankingAccountList;
import au.org.consumerdatastandards.holder.model.banking.ResponseBankingAccountsBalanceById;
import au.org.consumerdatastandards.holder.model.banking.ResponseBankingAccountsBalanceList;
import au.org.consumerdatastandards.holder.model.banking.ResponseBankingTransactionById;
import au.org.consumerdatastandards.holder.model.banking.ResponseBankingTransactionList;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ResponseHeader;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.NativeWebRequest;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Api(value = "BankingAccounts", description = "the BankingAccounts API")
public interface BankingAccountsApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    @ApiOperation(
        value = "Get Account Detail",
        nickname = "getAccountDetail",
        notes = "Obtain detailed information on a single account.",
        response = ResponseBankingAccountById.class,
        tags = {"Accounts", "Banking"}
    )
    @ApiResponses(value = {
        @ApiResponse(
            code = 200,
            message = "Successful response",
            responseHeaders = @ResponseHeader(name = "x-v", response = Integer.class, description = "The [version](#response-headers) of the API endpoint that the data holder has responded with."),
            response = ResponseBankingAccountById.class
        ),
        @ApiResponse(
            code = 400,
            message = "Invalid Version / Invalid Field / Missing Required Field",
            responseHeaders = @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction."),
            response = ErrorListResponse.class
        ),
        @ApiResponse(
            code = 404,
            message = "Unavailable Banking Account / Invalid Banking Account",
            responseHeaders = @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction."),
            response = ErrorListResponse.class
        ),
        @ApiResponse(
            code = 406,
            message = "Unsupported Version",
            responseHeaders = @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction."),
            response = ErrorListResponse.class
        )
    })
    @RequestMapping(
        value = "/banking/accounts/{accountId}",
        method = RequestMethod.GET
    )
    @PreAuthorize("hasAuthority('SCOPE_bank:accounts.detail:read')")
    ResponseEntity<ResponseBankingAccountById> getAccountDetail(
        @ApiParam(
            value = "A tokenised identifier for the account which is unique but not shareable.",
            required = true
        )
        @PathVariable("accountId") @NotBlank String accountId,
        @ApiParam(
            value = "The customer's original standard http headers [Base64](#common-field-types) encoded, including the original User-Agent header, if the customer is currently logged in to the Data Recipient Software Product. Mandatory for customer present calls. Not required for unattended or unauthenticated calls."
        )
        @RequestHeader(value = "x-cds-client-headers", required = false) String xCdsClientHeaders,
        @ApiParam(
            value = "The time when the customer last logged in to the Data Recipient Software Product as described in **[[FAPI-1.0-Baseline]](#nref-FAPI-1-0-Baseline)**. Required for all resource calls (customer present and unattended). Not required for unauthenticated calls."
        )
        @RequestHeader(value = "x-fapi-auth-date", required = false) @NotNull @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, fallbackPatterns = DateFormat.HTTP) Date xFapiAuthDate,
        @ApiParam(
            value = "The customer's original IP address if the customer is currently logged in to the Data Recipient Software Product. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls."
        )
        @RequestHeader(value = "x-fapi-customer-ip-address", required = false) String xFapiCustomerIpAddress,
        @ApiParam(
            value = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction."
        )
        @RequestHeader(value = "x-fapi-interaction-id", required = false) UUID xFapiInteractionId,
        @ApiParam(
            value = "Minimum version of the API endpoint requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [_x-min-v_](#request-headers) and [_x-v_](#request-headers). If all versions requested are not supported then the data holder **MUST** respond with a `406 Not Acceptable`."
        )
        @RequestHeader(value = "x-min-v", required = false) @Min(1) Integer xMinV,
        @ApiParam(
            value = "Version of the API endpoint requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [_x-min-v_](#request-headers) and [_x-v_](#request-headers). If the value of [_x-min-v_](#request-headers) is equal to or higher than the value of [_x-v_](#request-headers) then the [_x-min-v_](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder **MUST** respond with a `406 Not Acceptable`. See [HTTP Headers](#request-headers)."
        )
        @RequestHeader(value = "x-v", required = false) @Min(1) Integer xV
    );

    @ApiOperation(
        value = "Get Transaction Detail",
        nickname = "getTransactionDetail",
        notes = "Obtain detailed information on a transaction for a specific account.",
        response = ResponseBankingTransactionById.class,
        tags = {"Accounts", "Banking"}
    )
    @ApiResponses(value = {
        @ApiResponse(
            code = 200,
            message = "Successful response",
            responseHeaders = @ResponseHeader(name = "x-v", response = Integer.class, description = "The [version](#response-headers) of the API endpoint that the data holder has responded with."),
            response = ResponseBankingTransactionById.class
        ),
        @ApiResponse(
            code = 400,
            message = "Invalid Version / Invalid Field / Missing Required Field / Invalid Date",
            responseHeaders = @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction."),
            response = ErrorListResponse.class
        ),
        @ApiResponse(
            code = 404,
            message = "Unavailable Banking Account / Invalid Banking Account / Unavailable Resource / Invalid Resource",
            responseHeaders = @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction."),
            response = ErrorListResponse.class
        ),
        @ApiResponse(
            code = 406,
            message = "Unsupported Version",
            responseHeaders = @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction."),
            response = ErrorListResponse.class
        )
    })
    @RequestMapping(
        value = "/banking/accounts/{accountId}/transactions/{transactionId}",
        method = RequestMethod.GET
    )
    @PreAuthorize("hasAuthority('SCOPE_bank:transactions:read')")
    ResponseEntity<ResponseBankingTransactionById> getTransactionDetail(
        @ApiParam(
            value = "ID of the account to get transactions for. Must have previously been returned by one of the account list endpoints.",
            required = true
        )
        @PathVariable("accountId") @NotBlank String accountId,
        @ApiParam(
            value = "ID of the transaction obtained from a previous call to one of the other transaction endpoints.",
            required = true
        )
        @PathVariable("transactionId") @NotBlank String transactionId,
        @ApiParam(
            value = "The customer's original standard http headers [Base64](#common-field-types) encoded, including the original User-Agent header, if the customer is currently logged in to the Data Recipient Software Product. Mandatory for customer present calls. Not required for unattended or unauthenticated calls."
        )
        @RequestHeader(value = "x-cds-client-headers", required = false) String xCdsClientHeaders,
        @ApiParam(
            value = "The time when the customer last logged in to the Data Recipient Software Product as described in **[[FAPI-1.0-Baseline]](#nref-FAPI-1-0-Baseline)**. Required for all resource calls (customer present and unattended). Not required for unauthenticated calls."
        )
        @RequestHeader(value = "x-fapi-auth-date", required = false) @NotNull @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, fallbackPatterns = DateFormat.HTTP) Date xFapiAuthDate,
        @ApiParam(
            value = "The customer's original IP address if the customer is currently logged in to the Data Recipient Software Product. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls."
        )
        @RequestHeader(value = "x-fapi-customer-ip-address", required = false) String xFapiCustomerIpAddress,
        @ApiParam(
            value = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction."
        )
        @RequestHeader(value = "x-fapi-interaction-id", required = false) UUID xFapiInteractionId,
        @ApiParam(
            value = "Minimum version of the API endpoint requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [_x-min-v_](#request-headers) and [_x-v_](#request-headers). If all versions requested are not supported then the data holder **MUST** respond with a `406 Not Acceptable`."
        )
        @RequestHeader(value = "x-min-v", required = false) @Min(1) Integer xMinV,
        @ApiParam(
            value = "Version of the API endpoint requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [_x-min-v_](#request-headers) and [_x-v_](#request-headers). If the value of [_x-min-v_](#request-headers) is equal to or higher than the value of [_x-v_](#request-headers) then the [_x-min-v_](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder **MUST** respond with a `406 Not Acceptable`. See [HTTP Headers](#request-headers)."
        )
        @RequestHeader(value = "x-v", required = false) @Min(1) Integer xV
    );

    @ApiOperation(
        value = "Get Transactions For Account",
        nickname = "getTransactions",
        notes = "Obtain transactions for a specific account.\n\nSome general notes that apply to all endpoints that retrieve transactions:<ul><li>Where multiple transactions are returned, transactions should be ordered according to effective date in descending order<li>As the date and time for a transaction can alter depending on status and transaction type two separate date/times are included in the payload. There are still some scenarios where neither of these time stamps is available. For the purpose of filtering and ordering it is expected that the data holder will use the \"effective\" date/time which will be defined as:<ul><li>Posted date/time if available, then<li>Execution date/time if available, then<li>A reasonable date/time nominated by the data holder using internal data structures</ul><li>For transaction amounts it should be assumed that a negative value indicates a reduction of the available balance on the account while a positive value indicates an increase in the available balance on the account<li>For aggregated transactions (i.e. groups of sub transactions reported as a single entry for the account) only the aggregated information, with as much consistent information across the subsidiary transactions as possible, is required to be shared.</ul>",
        response = ResponseBankingTransactionList.class,
        tags = {"Accounts", "Banking"}
    )
    @ApiResponses(value = {
        @ApiResponse(
            code = 200,
            message = "Successful response",
            responseHeaders = @ResponseHeader(name = "x-v", response = Integer.class, description = "The [version](#response-headers) of the API endpoint that the data holder has responded with."),
            response = ResponseBankingTransactionList.class
        ),
        @ApiResponse(
            code = 400,
            message = "Invalid Field / Missing Required Field / Invalid Date / Invalid Page Size",
            responseHeaders = @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction."),
            response = ErrorListResponse.class
        ),
        @ApiResponse(
            code = 404,
            message = "Unavailable Banking Account / Invalid Banking Account",
            responseHeaders = @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction."),
            response = ErrorListResponse.class
        ),
        @ApiResponse(
            code = 406,
            message = "Unsupported Version",
            responseHeaders = @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction."),
            response = ErrorListResponse.class
        ),
        @ApiResponse(
            code = 422,
            message = "Invalid Page",
            responseHeaders = @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction."),
            response = ErrorListResponse.class
        )
    })
    @RequestMapping(
        value = "/banking/accounts/{accountId}/transactions",
        method = RequestMethod.GET
    )
    @PreAuthorize("hasAuthority('SCOPE_bank:transactions:read')")
    ResponseEntity<ResponseBankingTransactionList> getTransactions(
        @ApiParam(
            value = "ID of the account to get transactions for. Must have previously been returned by one of the account list endpoints.",
            required = true
        )
        @PathVariable("accountId") @NotBlank String accountId,
        @ApiParam(
            value = "Filter transactions to only transactions with amounts less than or equal to this amount."
        ) @RequestParam(value = "max-amount", required = false) BigDecimal maxAmount,
        @ApiParam(
            value = "Filter transactions to only transactions with amounts higher than or equal to this amount."
        ) @RequestParam(value = "min-amount", required = false) BigDecimal minAmount,
        @ApiParam(
            value = "Constrain the transaction history request to transactions with effective time at or before this date/time. If absent defaults to today. Format is aligned to [DateTimeString](#common-field-types) common type."
        ) @RequestParam(value = "newest-time", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, fallbackPatterns = DateFormat.HTTP) OffsetDateTime newestTime,
        @ApiParam(
            value = "Constrain the transaction history request to transactions with effective time at or after this date/time. If absent defaults to _newest-time_ minus 90 days. Format is aligned to [DateTimeString](#common-field-types) common type."
        ) @RequestParam(value = "oldest-time", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, fallbackPatterns = DateFormat.HTTP) OffsetDateTime oldestTime,
        @ApiParam(
            value = "Page of results to request (standard pagination).",
            defaultValue = "1"
        ) @RequestParam(value = "page", required = false, defaultValue = "1") @Min(1) Integer page,
        @ApiParam(
            value = "Page size to request. Default is 25 (standard pagination).",
            defaultValue = "25"
        ) @RequestParam(value = "page-size", required = false, defaultValue = "25") @Min(1) Integer pageSize,
        @ApiParam(
            value = "Filter transactions to only transactions where this string value is found as a substring of either the _reference_ or _description_ fields. Format is arbitrary ASCII string. This parameter is optionally implemented by data holders. If it is not implemented then a response should be provided as normal without text filtering applied and an additional boolean field named _isQueryParamUnsupported_ should be included in the meta object and set to `true` (whether the text parameter is supplied or not)."
        ) @RequestParam(value = "text", required = false) String text,
        @ApiParam(
            value = "The customer's original standard http headers [Base64](#common-field-types) encoded, including the original User-Agent header, if the customer is currently logged in to the Data Recipient Software Product. Mandatory for customer present calls. Not required for unattended or unauthenticated calls."
        )
        @RequestHeader(value = "x-cds-client-headers", required = false) String xCdsClientHeaders,
        @ApiParam(
            value = "The time when the customer last logged in to the Data Recipient Software Product as described in **[[FAPI-1.0-Baseline]](#nref-FAPI-1-0-Baseline)**. Required for all resource calls (customer present and unattended). Not required for unauthenticated calls."
        )
        @RequestHeader(value = "x-fapi-auth-date", required = false) @NotNull @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, fallbackPatterns = DateFormat.HTTP) Date xFapiAuthDate,
        @ApiParam(
            value = "The customer's original IP address if the customer is currently logged in to the Data Recipient Software Product. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls."
        )
        @RequestHeader(value = "x-fapi-customer-ip-address", required = false) String xFapiCustomerIpAddress,
        @ApiParam(
            value = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction."
        )
        @RequestHeader(value = "x-fapi-interaction-id", required = false) UUID xFapiInteractionId,
        @ApiParam(
            value = "Minimum version of the API endpoint requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [_x-min-v_](#request-headers) and [_x-v_](#request-headers). If all versions requested are not supported then the data holder **MUST** respond with a `406 Not Acceptable`."
        )
        @RequestHeader(value = "x-min-v", required = false) @Min(1) Integer xMinV,
        @ApiParam(
            value = "Version of the API endpoint requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [_x-min-v_](#request-headers) and [_x-v_](#request-headers). If the value of [_x-min-v_](#request-headers) is equal to or higher than the value of [_x-v_](#request-headers) then the [_x-min-v_](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder **MUST** respond with a `406 Not Acceptable`. See [HTTP Headers](#request-headers)."
        )
        @RequestHeader(value = "x-v", required = false) @Min(1) Integer xV
    );

    @ApiOperation(
        value = "Get Accounts",
        nickname = "listAccounts",
        notes = "Obtain a list of accounts",
        response = ResponseBankingAccountList.class,
        tags = {"Accounts", "Banking"}
    )
    @ApiResponses(value = {
        @ApiResponse(
            code = 200,
            message = "Successful response",
            responseHeaders = @ResponseHeader(name = "x-v", response = Integer.class, description = "The [version](#response-headers) of the API endpoint that the data holder has responded with."),
            response = ResponseBankingAccountList.class
        ),
        @ApiResponse(
            code = 400,
            message = "Invalid Page Size / Invalid Field / Missing Required Field",
            responseHeaders = @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction."),
            response = ErrorListResponse.class
        ),
        @ApiResponse(
            code = 406,
            message = "Unsupported Version",
            responseHeaders = @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction."),
            response = ErrorListResponse.class
        ),
        @ApiResponse(
            code = 422,
            message = "Invalid Page",
            responseHeaders = @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction."),
            response = ErrorListResponse.class
        )
    })
    @RequestMapping(
        value = "/banking/accounts",
        method = RequestMethod.GET
    )
    @PreAuthorize("hasAuthority('SCOPE_bank:accounts.basic:read')")
    ResponseEntity<ResponseBankingAccountList> listAccounts(
        @ApiParam(
            value = "Filters accounts based on whether they are owned by the authorised customer. `true` for owned accounts, `false` for unowned accounts and absent for all accounts."
        ) @RequestParam(value = "is-owned", required = false) Boolean isOwned,
        @ApiParam(
            value = "Used to filter results according to open/closed status. Values can be `OPEN`, `CLOSED` or `ALL`. If absent then `ALL` is assumed.",
            allowableValues = "ALL, CLOSED, OPEN",
            defaultValue = "ALL"
        ) @RequestParam(value = "open-status", required = false, defaultValue = "ALL") ParamAccountOpenStatus openStatus,
        @ApiParam(
            value = "Page of results to request (standard pagination).",
            defaultValue = "1"
        ) @RequestParam(value = "page", required = false, defaultValue = "1") @Min(1) Integer page,
        @ApiParam(
            value = "Page size to request. Default is 25 (standard pagination).",
            defaultValue = "25"
        ) @RequestParam(value = "page-size", required = false, defaultValue = "25") @Min(1) Integer pageSize,
        @ApiParam(
            value = "Used to filter results on the _productCategory_ field applicable to accounts. Any one of the valid values for this field can be supplied. If absent then all accounts returned.",
            allowableValues = "BUSINESS_LOANS, CRED_AND_CHRG_CARDS, LEASES, MARGIN_LOANS, OVERDRAFTS, PERS_LOANS, REGULATED_TRUST_ACCOUNTS, RESIDENTIAL_MORTGAGES, TERM_DEPOSITS, TRADE_FINANCE, TRANS_AND_SAVINGS_ACCOUNTS, TRAVEL_CARDS"
        ) @RequestParam(value = "product-category", required = false) ParamProductCategory productCategory,
        @ApiParam(
            value = "The customer's original standard http headers [Base64](#common-field-types) encoded, including the original User-Agent header, if the customer is currently logged in to the Data Recipient Software Product. Mandatory for customer present calls. Not required for unattended or unauthenticated calls."
        )
        @RequestHeader(value = "x-cds-client-headers", required = false) String xCdsClientHeaders,
        @ApiParam(
            value = "The time when the customer last logged in to the Data Recipient Software Product as described in **[[FAPI-1.0-Baseline]](#nref-FAPI-1-0-Baseline)**. Required for all resource calls (customer present and unattended). Not required for unauthenticated calls."
        )
        @RequestHeader(value = "x-fapi-auth-date", required = false) @NotNull @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, fallbackPatterns = DateFormat.HTTP) Date xFapiAuthDate,
        @ApiParam(
            value = "The customer's original IP address if the customer is currently logged in to the Data Recipient Software Product. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls."
        )
        @RequestHeader(value = "x-fapi-customer-ip-address", required = false) String xFapiCustomerIpAddress,
        @ApiParam(
            value = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction."
        )
        @RequestHeader(value = "x-fapi-interaction-id", required = false) UUID xFapiInteractionId,
        @ApiParam(
            value = "Minimum version of the API endpoint requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [_x-min-v_](#request-headers) and [_x-v_](#request-headers). If all versions requested are not supported then the data holder **MUST** respond with a `406 Not Acceptable`."
        )
        @RequestHeader(value = "x-min-v", required = false) @Min(1) Integer xMinV,
        @ApiParam(
            value = "Version of the API endpoint requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [_x-min-v_](#request-headers) and [_x-v_](#request-headers). If the value of [_x-min-v_](#request-headers) is equal to or higher than the value of [_x-v_](#request-headers) then the [_x-min-v_](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder **MUST** respond with a `406 Not Acceptable`. See [HTTP Headers](#request-headers)."
        )
        @RequestHeader(value = "x-v") @Min(1) Integer xV
    );

    @ApiOperation(
        value = "Get Account Balance",
        nickname = "getBalance",
        notes = "Obtain the balance for a single specified account.",
        response = ResponseBankingAccountsBalanceById.class,
        tags = {"Accounts", "Banking"}
    )
    @ApiResponses(value = {
        @ApiResponse(
            code = 200,
            message = "Successful response",
            responseHeaders = @ResponseHeader(name = "x-v", response = Integer.class, description = "The [version](#response-headers) of the API endpoint that the data holder has responded with."),
            response = ResponseBankingAccountsBalanceById.class
        ),
        @ApiResponse(
            code = 400,
            message = "Invalid Version / Invalid Page Size / Invalid Field / Missing Required Field",
            responseHeaders = @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction."),
            response = ErrorListResponse.class
        ),
        @ApiResponse(
            code = 406,
            message = "Unsupported Version",
            responseHeaders = @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction."),
            response = ErrorListResponse.class
        )
    })
    @RequestMapping(
        value = "/banking/accounts/{accountId}/balance",
        method = RequestMethod.GET
    )
    @PreAuthorize("hasAuthority('SCOPE_bank:accounts.basic:read')")
    ResponseEntity<ResponseBankingAccountsBalanceById> getBalance(
        @ApiParam(
            value = "ID of the specific account requested.",
            required = true
        )
        @PathVariable("accountId") @NotBlank String accountId,
        @ApiParam(
            value = "The customer's original standard http headers [Base64](#common-field-types) encoded, including the original User-Agent header, if the customer is currently logged in to the Data Recipient Software Product. Mandatory for customer present calls. Not required for unattended or unauthenticated calls."
        )
        @RequestHeader(value = "x-cds-client-headers", required = false) String xCdsClientHeaders,
        @ApiParam(
            value = "The time when the customer last logged in to the Data Recipient Software Product as described in **[[FAPI-1.0-Baseline]](#nref-FAPI-1-0-Baseline)**. Required for all resource calls (customer present and unattended). Not required for unauthenticated calls."
        )
        @RequestHeader(value = "x-fapi-auth-date", required = false) @NotNull @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, fallbackPatterns = DateFormat.HTTP) Date xFapiAuthDate,
        @ApiParam(
            value = "The customer's original IP address if the customer is currently logged in to the Data Recipient Software Product. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls."
        )
        @RequestHeader(value = "x-fapi-customer-ip-address", required = false) String xFapiCustomerIpAddress,
        @ApiParam(
            value = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction."
        )
        @RequestHeader(value = "x-fapi-interaction-id", required = false) UUID xFapiInteractionId,
        @ApiParam(
            value = "Minimum version of the API endpoint requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [_x-min-v_](#request-headers) and [_x-v_](#request-headers). If all versions requested are not supported then the data holder **MUST** respond with a `406 Not Acceptable`."
        )
        @RequestHeader(value = "x-min-v", required = false) @Min(1) Integer xMinV,
        @ApiParam(
            value = "Version of the API endpoint requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [_x-min-v_](#request-headers) and [_x-v_](#request-headers). If the value of [_x-min-v_](#request-headers) is equal to or higher than the value of [_x-v_](#request-headers) then the [_x-min-v_](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder **MUST** respond with a `406 Not Acceptable`. See [HTTP Headers](#request-headers)."
        )
        @RequestHeader(value = "x-v", required = false) @Min(1) Integer xV
    );

    @ApiOperation(
        value = "Get Bulk Balances",
        nickname = "listBalancesBulk",
        notes = "Obtain balances for multiple, filtered accounts.",
        response = ResponseBankingAccountsBalanceList.class,
        tags = {"Accounts", "Banking"}
    )
    @ApiResponses(value = {
        @ApiResponse(
            code = 200,
            message = "Successful response",
            responseHeaders = @ResponseHeader(name = "x-v", response = Integer.class, description = "The [version](#response-headers) of the API endpoint that the data holder has responded with."),
            response = ResponseBankingAccountsBalanceList.class
        ),
        @ApiResponse(
            code = 400,
            message = "Invalid Version / Invalid Page Size / Invalid Field / Missing Required Field",
            responseHeaders = @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction."),
            response = ErrorListResponse.class
        ),
        @ApiResponse(
            code = 406,
            message = "Unsupported Version",
            responseHeaders = @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction."),
            response = ErrorListResponse.class
        ),
        @ApiResponse(
            code = 422,
            message = "Invalid Page",
            responseHeaders = @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction."),
            response = ErrorListResponse.class
        )
    })
    @RequestMapping(
        value = "/banking/accounts/balances",
        method = RequestMethod.GET
    )
    @PreAuthorize("hasAuthority('SCOPE_bank:accounts.basic:read')")
    ResponseEntity<ResponseBankingAccountsBalanceList> listBalancesBulk(
        @ApiParam(
            value = "Filters accounts based on whether they are owned by the authorised customer. `true` for owned accounts, `false` for unowned accounts and absent for all accounts."
        ) @RequestParam(value = "is-owned", required = false) Boolean isOwned,
        @ApiParam(
            value = "Used to filter results according to open/closed status. Values can be `OPEN`, `CLOSED` or `ALL`. If absent then `ALL` is assumed.",
            allowableValues = "ALL, CLOSED, OPEN",
            defaultValue = "ALL"
        ) @RequestParam(value = "open-status", required = false, defaultValue = "ALL") ParamAccountOpenStatus paramOpenStatus,
        @ApiParam(
            value = "Used to filter results on the _productCategory_ field applicable to accounts. Any one of the valid values for this field can be supplied. If absent then all accounts returned.",
            allowableValues = "BUSINESS_LOANS, CRED_AND_CHRG_CARDS, LEASES, MARGIN_LOANS, OVERDRAFTS, PERS_LOANS, REGULATED_TRUST_ACCOUNTS, RESIDENTIAL_MORTGAGES, TERM_DEPOSITS, TRADE_FINANCE, TRANS_AND_SAVINGS_ACCOUNTS, TRAVEL_CARDS"
        ) @RequestParam(value = "product-category", required = false) ParamProductCategory paramProductCategory,
        @ApiParam(
            value = "Page of results to request (standard pagination).",
            defaultValue = "1"
        ) @RequestParam(value = "page", required = false, defaultValue = "1") @Min(1) Integer page,
        @ApiParam(
            value = "Page size to request. Default is 25 (standard pagination).",
            defaultValue = "25"
        ) @RequestParam(value = "page-size", required = false, defaultValue = "25") @Min(1) Integer pageSize,
        @ApiParam(
            value = "The customer's original standard http headers [Base64](#common-field-types) encoded, including the original User-Agent header, if the customer is currently logged in to the Data Recipient Software Product. Mandatory for customer present calls. Not required for unattended or unauthenticated calls."
        )
        @RequestHeader(value = "x-cds-client-headers", required = false) String xCdsClientHeaders,
        @ApiParam(
            value = "The time when the customer last logged in to the Data Recipient Software Product as described in **[[FAPI-1.0-Baseline]](#nref-FAPI-1-0-Baseline)**. Required for all resource calls (customer present and unattended). Not required for unauthenticated calls."
        )
        @RequestHeader(value = "x-fapi-auth-date", required = false) @NotNull @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, fallbackPatterns = DateFormat.HTTP) Date xFapiAuthDate,
        @ApiParam(
            value = "The customer's original IP address if the customer is currently logged in to the Data Recipient Software Product. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls."
        )
        @RequestHeader(value = "x-fapi-customer-ip-address", required = false) String xFapiCustomerIpAddress,
        @ApiParam(
            value = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction."
        )
        @RequestHeader(value = "x-fapi-interaction-id", required = false) UUID xFapiInteractionId,
        @ApiParam(
            value = "Minimum version of the API endpoint requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [_x-min-v_](#request-headers) and [_x-v_](#request-headers). If all versions requested are not supported then the data holder **MUST** respond with a `406 Not Acceptable`."
        )
        @RequestHeader(value = "x-min-v", required = false) @Min(1) Integer xMinV,
        @ApiParam(
            value = "Version of the API endpoint requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [_x-min-v_](#request-headers) and [_x-v_](#request-headers). If the value of [_x-min-v_](#request-headers) is equal to or higher than the value of [_x-v_](#request-headers) then the [_x-min-v_](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder **MUST** respond with a `406 Not Acceptable`. See [HTTP Headers](#request-headers)."
        )
        @RequestHeader(value = "x-v", required = false) @Min(1) Integer xV
    );

    @ApiOperation(
        value = "Get Balances For Specific Accounts",
        nickname = "listBalancesSpecificAccounts",
        notes = "Obtain balances for a specified list of accounts.",
        response = ResponseBankingAccountsBalanceList.class,
        tags = {"Accounts", "Banking"}
    )
    @ApiResponses(value = {
        @ApiResponse(
            code = 200,
            message = "Successful response",
            responseHeaders = @ResponseHeader(name = "x-v", response = Integer.class, description = "The [version](#response-headers) of the API endpoint that the data holder has responded with."),
            response = ResponseBankingAccountsBalanceList.class
        ),
        @ApiResponse(
            code = 400,
            message = "Invalid Version / Invalid Page Size / Invalid Field / Missing Required Field",
            responseHeaders = @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction."),
            response = ErrorListResponse.class
        ),
        @ApiResponse(
            code = 406,
            message = "Unsupported Version",
            responseHeaders = @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction."),
            response = ErrorListResponse.class
        ),
        @ApiResponse(
            code = 422,
            message = "Invalid Banking Account / Unavailable Banking Account / Invalid Page",
            responseHeaders = @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction."),
            response = ErrorListResponse.class
        )
    })
    @RequestMapping(
        value = "/banking/accounts/balances",
        method = RequestMethod.POST
    )
    @PreAuthorize("hasAuthority('SCOPE_bank:accounts.basic:read')")
    ResponseEntity<ResponseBankingAccountsBalanceList> listBalancesSpecificAccounts(
        @ApiParam(
            value = "The list of _accountId_ values to obtain balances for."
        ) @RequestBody @NotNull RequestAccountIds accountIds,
        @ApiParam(
            value = "Page of results to request (standard pagination).",
            defaultValue = "1"
        ) @RequestParam(value = "page", required = false, defaultValue = "1") @Min(1) Integer page,
        @ApiParam(
            value = "Page size to request. Default is 25 (standard pagination).",
            defaultValue = "25"
        ) @RequestParam(value = "page-size", required = false, defaultValue = "25") @Min(1) Integer pageSize,
        @ApiParam(
            value = "The customer's original standard http headers [Base64](#common-field-types) encoded, including the original User-Agent header, if the customer is currently logged in to the Data Recipient Software Product. Mandatory for customer present calls. Not required for unattended or unauthenticated calls."
        )
        @RequestHeader(value = "x-cds-client-headers", required = false) String xCdsClientHeaders,
        @ApiParam(
            value = "The time when the customer last logged in to the Data Recipient Software Product as described in **[[FAPI-1.0-Baseline]](#nref-FAPI-1-0-Baseline)**. Required for all resource calls (customer present and unattended). Not required for unauthenticated calls."
        )
        @RequestHeader(value = "x-fapi-auth-date", required = false) @NotNull @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, fallbackPatterns = DateFormat.HTTP) Date xFapiAuthDate,
        @ApiParam(
            value = "The customer's original IP address if the customer is currently logged in to the Data Recipient Software Product. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls."
        )
        @RequestHeader(value = "x-fapi-customer-ip-address", required = false) String xFapiCustomerIpAddress,
        @ApiParam(
            value = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction."
        )
        @RequestHeader(value = "x-fapi-interaction-id", required = false) UUID xFapiInteractionId,
        @ApiParam(
            value = "Minimum version of the API endpoint requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [_x-min-v_](#request-headers) and [_x-v_](#request-headers). If all versions requested are not supported then the data holder **MUST** respond with a `406 Not Acceptable`."
        )
        @RequestHeader(value = "x-min-v", required = false) @Min(1) Integer xMinV,
        @ApiParam(
            value = "Version of the API endpoint requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [_x-min-v_](#request-headers) and [_x-v_](#request-headers). If the value of [_x-min-v_](#request-headers) is equal to or higher than the value of [_x-v_](#request-headers) then the [_x-min-v_](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder **MUST** respond with a `406 Not Acceptable`. See [HTTP Headers](#request-headers)."
        )
        @RequestHeader(value = "x-v", required = false) @Min(1) Integer xV
    );
}
