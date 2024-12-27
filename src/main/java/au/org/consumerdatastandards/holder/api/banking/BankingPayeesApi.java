package au.org.consumerdatastandards.holder.api.banking;

import au.org.consumerdatastandards.holder.api.DateFormat;
import au.org.consumerdatastandards.holder.model.ErrorListResponse;
import au.org.consumerdatastandards.holder.model.banking.ResponseBankingPayeeById;
import au.org.consumerdatastandards.holder.model.banking.ResponseBankingPayeeList;
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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.NativeWebRequest;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Api(value = "BankingPayees", description = "the BankingPayees API")
public interface BankingPayeesApi {

    public enum ParamPayeeType {
        BILLER,
        DIGITAL_WALLET,
        DOMESTIC,
        INTERNATIONAL,
        ALL
    }

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    @ApiOperation(
        value = "Get Payee Detail",
        nickname = "getPayeeDetail",
        notes = "Obtain detailed information on a single payee.\n\nNote that the payee sub-structure should be selected to represent the payment destination only rather than any known characteristics of the payment recipient.",
        response = ResponseBankingPayeeById.class,
        tags = {"Payees", "Banking"}
    )
    @ApiResponses(value = {
        @ApiResponse(
            code = 200,
            message = "Successful response",
            responseHeaders = @ResponseHeader(name = "x-v", response = Integer.class, description = "The [version](#response-headers) of the API endpoint that the data holder has responded with."),
            response = ResponseBankingPayeeById.class
        ),
        @ApiResponse(
            code = 400,
            message = "Invalid Page Size / Invalid Field / Missing Required Field",
            responseHeaders = @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction."),
            response = ErrorListResponse.class
        ),
        @ApiResponse(
            code = 404,
            message = "Invalid Resource / Unavailable Resource",
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
        value = "/banking/payees/{payeeId}",
        method = RequestMethod.GET
    )
    @PreAuthorize("hasAuthority('SCOPE_bank:payees:read')")
    ResponseEntity<ResponseBankingPayeeById> getPayeeDetail(
        @ApiParam(
            value = "The ID used to locate the details of a particular payee.",
            required = true
        )
        @PathVariable("payeeId") @NotBlank String payeeId,
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
        value = "Get Payees",
        nickname = "listPayees",
        notes = "Obtain a list of pre-registered payees.",
        response = ResponseBankingPayeeList.class,
        tags = {"Payees", "Banking"}
    )
    @ApiResponses(value = {
        @ApiResponse(
            code = 200,
            message = "Successful response",
            responseHeaders = @ResponseHeader(name = "x-v", response = Integer.class, description = "The [version](#response-headers) of the API endpoint that the data holder has responded with."),
            response = ResponseBankingPayeeList.class
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
        value = "/banking/payees",
        method = RequestMethod.GET
    )
    @PreAuthorize("hasAuthority('SCOPE_bank:payees:read')")
    ResponseEntity<ResponseBankingPayeeList> listPayees(
        @ApiParam(
            value = "Page of results to request (standard pagination).",
            defaultValue = "1"
        ) @RequestParam(value = "page", required = false, defaultValue = "1") @Min(1) Integer page,
        @ApiParam(
            value = "Page size to request. Default is 25 (standard pagination).",
            defaultValue = "25"
        ) @RequestParam(value = "page-size", required = false, defaultValue = "25") @Min(1) Integer pageSize,
        @ApiParam(
            value = "Filter on the payee _type_ field. In addition to normal _type_ field values, `ALL` can be specified to retrieve all payees. If absent the assumed value is `ALL`.",
            allowableValues = "ALL, BILLER, DIGITAL_WALLET, DOMESTIC, INTERNATIONAL",
            defaultValue = "ALL"
        ) @RequestParam(value = "type", required = false, defaultValue = "ALL") ParamPayeeType type,
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
