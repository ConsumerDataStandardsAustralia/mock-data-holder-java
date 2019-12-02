package au.org.consumerdatastandards.holder.api;

import au.org.consumerdatastandards.holder.model.ParamAccountOpenStatus;
import au.org.consumerdatastandards.holder.model.ParamProductCategory;
import au.org.consumerdatastandards.holder.model.RequestAccountIds;
import au.org.consumerdatastandards.holder.model.ResponseBankingDirectDebitAuthorisationList;
import au.org.consumerdatastandards.holder.model.ResponseErrorList;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
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
import java.time.OffsetDateTime;
import java.util.Optional;
import java.util.UUID;

@Api(value = "BankingDirectDebits", description = "the BankingDirectDebits API")
public interface BankingDirectDebitsApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    @ApiOperation(
        value = "Get Direct Debits For Account",
        nickname = "listDirectDebits",
        notes = "Obtain direct debit authorisations for a specific account",
        response = ResponseBankingDirectDebitAuthorisationList.class,
        tags = {"DirectDebits", "Banking"}
    )
    @ApiResponses(value = {
        @ApiResponse(
            code = 200,
            message = "Success",
            response = ResponseBankingDirectDebitAuthorisationList.class
        )
    })
    @RequestMapping(
        value = "/banking/accounts/{accountId}/direct-debits",
        method = RequestMethod.GET
    )
    ResponseEntity<ResponseBankingDirectDebitAuthorisationList> listDirectDebits(
        @ApiParam(
            value = "ID of the account to get direct debit authorisations for.  Must have previously been returned by one of the account list end points.",
            required = true
        )
        @PathVariable("accountId") @NotBlank String accountId,
        @ApiParam(
            value = "Page of results to request (standard pagination)",
            defaultValue = "1"
        ) @RequestParam(value = "page", required = false, defaultValue = "1") @Min(1) Integer page,
        @ApiParam(
            value = "Page size to request. Default is 25 (standard pagination)",
            defaultValue = "25"
        ) @RequestParam(value = "page-size", required = false, defaultValue = "25") @Min(1) Integer pageSize,
        @ApiParam(
            value = "The customers original User Agent header if the customer is currently logged in to the data recipient. Mandatory for customer present calls. Not required for unattended or unauthenticated calls. Base64 encoded contents which may included additional parameters."
        )
        @RequestHeader(value = "x-cds-User-Agent", required = false) String xCdsUserAgent,
        @ApiParam(
            value = "Subject identifier. Locally unique and never reassigned identifier within the Holder for the End-User. Mandatory for authenticated calls. Not required for unattended or unauthenticated calls."
        )
        @RequestHeader(value = "x-cds-subject", required = false) String xCdsSubject,
        @ApiParam(
            value = "The time when the customer last logged in to the data recipient. Required for all resource calls (customer present and unattended). Not to be included for unauthenticated calls."
        )
        @RequestHeader(value = "x-fapi-auth-date", required = false) @NotNull @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) OffsetDateTime xFapiAuthDate,
        @ApiParam(
            value = "The customer's original IP address if the customer is currently logged in to the data recipient. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls."
        )
        @RequestHeader(value = "x-fapi-customer-ip-address", required = false) String xFapiCustomerIpAddress,
        @ApiParam(
            value = "An [RFC4122](https://tools.ietf.org/html/rfc4122) UID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction."
        )
        @RequestHeader(value = "x-fapi-interaction-id", required = false) UUID xFapiInteractionId,
        @ApiParam(
            value = "Minimum version of the API end point requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If all versions requested are not supported then the data holder should respond with a 406 Not Acceptable."
        )
        @RequestHeader(value = "x-min-v", required = false) @Min(1) Integer xMinV,
        @ApiParam(
            value = "Version of the API end point requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If the value of [x-min-v](#request-headers) is equal to or higher than the value of [x-v](#request-headers) then the [x-min-v](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder should respond with a 406 Not Acceptable. See [HTTP Headers](#request-headers)"
        )
        @RequestHeader(value = "x-v", required = false) @Min(1) Integer xV
    );

    @ApiOperation(
        value = "Get Bulk Direct Debits",
        nickname = "listDirectDebitsBulk",
        notes = "Obtain direct debit authorisations for multiple, filtered accounts",
        response = ResponseBankingDirectDebitAuthorisationList.class,
        tags = {"DirectDebits", "Banking"}
    )
    @ApiResponses(value = {
        @ApiResponse(
            code = 200,
            message = "Success",
            response = ResponseBankingDirectDebitAuthorisationList.class
        )
    })
    @RequestMapping(
        value = "/banking/accounts/direct-debits",
        method = RequestMethod.GET
    )
    ResponseEntity<ResponseBankingDirectDebitAuthorisationList> listDirectDebitsBulk(
        @ApiParam(
            value = "Filters accounts based on whether they are owned by the authorised customer.  True for owned accounts, false for unowned accounts and absent for all accounts"
        ) @RequestParam(value = "is-owned", required = false) Boolean isOwned,
        @ApiParam(
            value = "Used to filter results according to open/closed status. Values can be OPEN, CLOSED or ALL. If absent then ALL is assumed",
            allowableValues = "ALL, CLOSED, OPEN",
            defaultValue = "ALL"
        ) @RequestParam(value = "open-status", required = false, defaultValue = "ALL") ParamAccountOpenStatus paramOpenStatus,
        @ApiParam(
            value = "Used to filter results on the productCategory field applicable to accounts. Any one of the valid values for this field can be supplied. If absent then all accounts returned.",
            allowableValues = "BUSINESS_LOANS, CRED_AND_CHRG_CARDS, LEASES, MARGIN_LOANS, OVERDRAFTS, PERS_LOANS, REGULATED_TRUST_ACCOUNTS, RESIDENTIAL_MORTGAGES, TERM_DEPOSITS, TRADE_FINANCE, TRANS_AND_SAVINGS_ACCOUNTS, TRAVEL_CARDS"
        ) @RequestParam(value = "product-category", required = false) ParamProductCategory paramProductCategory,
        @ApiParam(
            value = "Page of results to request (standard pagination)",
            defaultValue = "1"
        ) @RequestParam(value = "page", required = false, defaultValue = "1") @Min(1) Integer page,
        @ApiParam(
            value = "Page size to request. Default is 25 (standard pagination)",
            defaultValue = "25"
        ) @RequestParam(value = "page-size", required = false, defaultValue = "25") @Min(1) Integer pageSize,
        @ApiParam(
            value = "The customers original User Agent header if the customer is currently logged in to the data recipient. Mandatory for customer present calls. Not required for unattended or unauthenticated calls. Base64 encoded contents which may included additional parameters."
        )
        @RequestHeader(value = "x-cds-User-Agent", required = false) String xCdsUserAgent,
        @ApiParam(
            value = "Subject identifier. Locally unique and never reassigned identifier within the Holder for the End-User. Mandatory for authenticated calls. Not required for unattended or unauthenticated calls."
        )
        @RequestHeader(value = "x-cds-subject", required = false) String xCdsSubject,
        @ApiParam(
            value = "The time when the customer last logged in to the data recipient. Required for all resource calls (customer present and unattended). Not to be included for unauthenticated calls."
        )
        @RequestHeader(value = "x-fapi-auth-date", required = false) @NotNull @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) OffsetDateTime xFapiAuthDate,
        @ApiParam(
            value = "The customer's original IP address if the customer is currently logged in to the data recipient. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls."
        )
        @RequestHeader(value = "x-fapi-customer-ip-address", required = false) String xFapiCustomerIpAddress,
        @ApiParam(
            value = "An [RFC4122](https://tools.ietf.org/html/rfc4122) UID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction."
        )
        @RequestHeader(value = "x-fapi-interaction-id", required = false) UUID xFapiInteractionId,
        @ApiParam(
            value = "Minimum version of the API end point requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If all versions requested are not supported then the data holder should respond with a 406 Not Acceptable."
        )
        @RequestHeader(value = "x-min-v", required = false) @Min(1) Integer xMinV,
        @ApiParam(
            value = "Version of the API end point requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If the value of [x-min-v](#request-headers) is equal to or higher than the value of [x-v](#request-headers) then the [x-min-v](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder should respond with a 406 Not Acceptable. See [HTTP Headers](#request-headers)"
        )
        @RequestHeader(value = "x-v", required = false) @Min(1) Integer xV
    );

    @ApiOperation(
        value = "Get Direct Debits For Specific Accounts",
        nickname = "listDirectDebitsSpecificAccounts",
        notes = "Obtain direct debit authorisations for a specified list of accounts",
        response = ResponseBankingDirectDebitAuthorisationList.class,
        tags = {"DirectDebits", "Banking"}
    )
    @ApiResponses(value = {
        @ApiResponse(
            code = 200,
            message = "Success",
            response = ResponseBankingDirectDebitAuthorisationList.class
        ),
        @ApiResponse(
            code = 422,
            message = "The request was well formed but was unable to be processed due to business logic specific to the request",
            response = ResponseErrorList.class
        )
    })
    @RequestMapping(
        value = "/banking/accounts/direct-debits",
        method = RequestMethod.POST
    )
    ResponseEntity<ResponseBankingDirectDebitAuthorisationList> listDirectDebitsSpecificAccounts(
        @ApiParam(
            value = "Array of specific accountIds to obtain authorisations for"
        ) @RequestBody RequestAccountIds accountIds,
        @ApiParam(
            value = "Page of results to request (standard pagination)",
            defaultValue = "1"
        ) @RequestParam(value = "page", required = false, defaultValue = "1") @Min(1) Integer page,
        @ApiParam(
            value = "Page size to request. Default is 25 (standard pagination)",
            defaultValue = "25"
        ) @RequestParam(value = "page-size", required = false, defaultValue = "25") @Min(1) Integer pageSize,
        @ApiParam(
            value = "The customers original User Agent header if the customer is currently logged in to the data recipient. Mandatory for customer present calls. Not required for unattended or unauthenticated calls. Base64 encoded contents which may included additional parameters."
        )
        @RequestHeader(value = "x-cds-User-Agent", required = false) String xCdsUserAgent,
        @ApiParam(
            value = "Subject identifier. Locally unique and never reassigned identifier within the Holder for the End-User. Mandatory for authenticated calls. Not required for unattended or unauthenticated calls."
        )
        @RequestHeader(value = "x-cds-subject", required = false) String xCdsSubject,
        @ApiParam(
            value = "The time when the customer last logged in to the data recipient. Required for all resource calls (customer present and unattended). Not to be included for unauthenticated calls."
        )
        @RequestHeader(value = "x-fapi-auth-date", required = false) @NotNull @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) OffsetDateTime xFapiAuthDate,
        @ApiParam(
            value = "The customer's original IP address if the customer is currently logged in to the data recipient. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls."
        )
        @RequestHeader(value = "x-fapi-customer-ip-address", required = false) String xFapiCustomerIpAddress,
        @ApiParam(
            value = "An [RFC4122](https://tools.ietf.org/html/rfc4122) UID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction."
        )
        @RequestHeader(value = "x-fapi-interaction-id", required = false) UUID xFapiInteractionId,
        @ApiParam(
            value = "Minimum version of the API end point requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If all versions requested are not supported then the data holder should respond with a 406 Not Acceptable."
        )
        @RequestHeader(value = "x-min-v", required = false) @Min(1) Integer xMinV,
        @ApiParam(
            value = "Version of the API end point requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If the value of [x-min-v](#request-headers) is equal to or higher than the value of [x-v](#request-headers) then the [x-min-v](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder should respond with a 406 Not Acceptable. See [HTTP Headers](#request-headers)"
        )
        @RequestHeader(value = "x-v", required = false) @Min(1) Integer xV
    );
}
