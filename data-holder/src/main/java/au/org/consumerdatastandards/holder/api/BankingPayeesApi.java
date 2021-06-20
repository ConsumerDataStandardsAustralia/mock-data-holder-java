package au.org.consumerdatastandards.holder.api;

import au.org.consumerdatastandards.holder.model.ResponseBankingPayeeById;
import au.org.consumerdatastandards.holder.model.ResponseBankingPayeeList;
import au.org.consumerdatastandards.holder.model.ResponseErrorListV2;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
import java.time.OffsetDateTime;
import java.util.Optional;
import java.util.UUID;

@Api(value = "BankingPayees", description = "the BankingPayees API")
public interface BankingPayeesApi {

    public enum ParamPayeeType {
        BILLER,
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
        notes = "Obtain detailed information on a single payee",
        response = ResponseBankingPayeeById.class,
        tags = {"Payees", "Banking"}
    )
    @ApiResponses(value = {
        @ApiResponse(
            code = 200,
            message = "Success",
            response = ResponseBankingPayeeById.class
        ),
        @ApiResponse(
            code = 400,
            message = "Invalid Version / Invalid Page Size / Invalid Field",
            response = ResponseErrorListV2.class
        ),
        @ApiResponse(
            code = 404,
            message = "Invalid Resource / Unavailable Resource",
            response = ResponseErrorListV2.class
        ),
        @ApiResponse(
            code = 406,
            message = "Unsupported Version",
            response = ResponseErrorListV2.class
        ),
        @ApiResponse(
            code = 422,
            message = "Invalid Page",
            response = ResponseErrorListV2.class
        )
    })
    @RequestMapping(
        value = "/banking/payees/{payeeId}",
        method = RequestMethod.GET
    )
    @PreAuthorize("hasAuthority('SCOPE_bank:payees:read')")
    ResponseEntity<ResponseBankingPayeeById> getPayeeDetail(
        @ApiParam(
            value = "The ID used to locate the details of a particular payee",
            required = true
        )
        @PathVariable("payeeId") @NotBlank String payeeId,
        @ApiParam(
            value = "The customers original User Agent header if the customer is currently logged in to the data recipient. Mandatory for customer present calls. Not required for unattended or unauthenticated calls. Base64 encoded contents which may included additional parameters."
        )
        @RequestHeader(value = "x-cds-client-headers", required = false) String xCdsClientHeaders,
        @ApiParam(
            value = "The customer's original standard http headers [Base64](#common-field-types) encoded, including the original User Agent header, if the customer is currently logged in to the data recipient. Mandatory for customer present calls.  Not required for unattended or unauthenticated calls."
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
            value = "Minimum version of the API end point requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable."
        )
        @RequestHeader(value = "x-min-v", required = false) @Min(1) Integer xMinV,
        @ApiParam(
            value = "Version of the API end point requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If the value of [x-min-v](#request-headers) is equal to or higher than the value of [x-v](#request-headers) then the [x-min-v](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable. See [HTTP Headers](#request-headers)"
        )
        @RequestHeader(value = "x-v", required = false) @Min(1) Integer xV
    );

    @ApiOperation(
        value = "Get Payees",
        nickname = "listPayees",
        notes = "Obtain a list of pre-registered payees",
        response = ResponseBankingPayeeList.class,
        tags = {"Payees", "Banking"}
    )
    @ApiResponses(value = {
        @ApiResponse(
            code = 200,
            message = "Success",
            response = ResponseBankingPayeeList.class
        ),
        @ApiResponse(
            code = 400,
            message = "Invalid Version / Invalid Page Size / Invalid Field",
            response = ResponseErrorListV2.class
        ),
        @ApiResponse(
            code = 406,
            message = "Unsupported Version",
            response = ResponseErrorListV2.class
        ),
        @ApiResponse(
            code = 422,
            message = "Invalid Page",
            response = ResponseErrorListV2.class
        )
    })
    @RequestMapping(
        value = "/banking/payees",
        method = RequestMethod.GET
    )
    @PreAuthorize("hasAuthority('SCOPE_bank:payees:read')")
    ResponseEntity<ResponseBankingPayeeList> listPayees(
        @ApiParam(
            value = "Page of results to request (standard pagination)",
            defaultValue = "1"
        ) @RequestParam(value = "page", required = false, defaultValue = "1") @Min(1) Integer page,
        @ApiParam(
            value = "Page size to request. Default is 25 (standard pagination)",
            defaultValue = "25"
        ) @RequestParam(value = "page-size", required = false, defaultValue = "25") @Min(1) Integer pageSize,
        @ApiParam(
            value = "Filter on the payee type field.  In addition to normal type field values, ALL can be specified to retrieve all payees.  If absent the assumed value is ALL",
            allowableValues = "ALL, BILLER, DOMESTIC, INTERNATIONAL",
            defaultValue = "ALL"
        ) @RequestParam(value = "type", required = false, defaultValue = "ALL") ParamPayeeType type,
        @ApiParam(
            value = "The customers original User Agent header if the customer is currently logged in to the data recipient. Mandatory for customer present calls. Not required for unattended or unauthenticated calls. Base64 encoded contents which may included additional parameters."
        )
        @RequestHeader(value = "x-cds-client-headers", required = false) String xCdsClientHeaders,
        @ApiParam(
            value = "The customer's original standard http headers [Base64](#common-field-types) encoded, including the original User Agent header, if the customer is currently logged in to the data recipient. Mandatory for customer present calls.  Not required for unattended or unauthenticated calls."
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
            value = "Minimum version of the API end point requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable."
        )
        @RequestHeader(value = "x-min-v", required = false) @Min(1) Integer xMinV,
        @ApiParam(
            value = "Version of the API end point requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If the value of [x-min-v](#request-headers) is equal to or higher than the value of [x-v](#request-headers) then the [x-min-v](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable. See [HTTP Headers](#request-headers)"
        )
        @RequestHeader(value = "x-v", required = false) @Min(1) Integer xV
    );
}
