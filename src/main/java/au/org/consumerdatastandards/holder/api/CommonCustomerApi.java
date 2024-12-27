package au.org.consumerdatastandards.holder.api;

import au.org.consumerdatastandards.holder.model.ResponseCommonCustomer;
import au.org.consumerdatastandards.holder.model.ResponseCommonCustomerDetail;
import au.org.consumerdatastandards.holder.model.ErrorListResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.NativeWebRequest;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Api(value = "CommonCustomer", description = "the CommonCustomer API")
public interface CommonCustomerApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    @ApiOperation(
        value = "Get Customer",
        nickname = "getCustomer",
        notes = "Obtain basic information on the customer that has authorised the current session.\n\n<h3 id='cdr-common-api_get-customer_conventions'>Conventions</h3>\nIn the customer payloads there are conventions that are explained below.\n\n#### Given Names\n\n_firstName_ represents the first of a person's given names.\n\n_middleNames_ represents a collection of given names if the person has more than one given name.\n\nWhere a data holder holds a person's given names as a single string in source systems, it may not possible in some situations to reliably split these given names into their component first and middle names. In these situations, data holders MAY use the _firstName_ field to return the single string of given names and an empty _middleNames_ array.\n\nFor example, if a person's given names are \"John Paul Winston\" and the Data Holder is unable to determine which is the first name, they can return `\"firstName\": \"John Paul Winston\"`.",
        response = ResponseCommonCustomer.class,
        tags = {"Customer", "Common"}
    )
    @ApiResponses(value = {
        @ApiResponse(
            code = 200,
            message = "Successful response",
            response = ResponseCommonCustomer.class
        ),
        @ApiResponse(
            code = 400,
            message = "Invalid Version / Invalid Field",
            response = ErrorListResponse.class
        ),
        @ApiResponse(
            code = 406,
            message = "Unsupported Version",
            response = ErrorListResponse.class
        )
    })
    @RequestMapping(
        value = "/common/customer",
        method = RequestMethod.GET
    )
    @PreAuthorize("hasAuthority('SCOPE_common:customer.basic:read')")
    ResponseEntity<ResponseCommonCustomer> getCustomer(
        @AuthenticationPrincipal Jwt jwt,
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
        value = "Get Customer Detail",
        nickname = "getCustomerDetail",
        notes = "Obtain detailed information on the authorised customer within the current session.",
        response = ResponseCommonCustomerDetail.class,
        tags = {"Customer", "Common"}
    )
    @ApiResponses(value = {
        @ApiResponse(
            code = 200,
            message = "Successful response",
            response = ResponseCommonCustomerDetail.class
        ),
        @ApiResponse(
            code = 400,
            message = "Invalid Version / Invalid Field",
            response = ErrorListResponse.class
        ),
        @ApiResponse(
            code = 406,
            message = "Unsupported Version",
            response = ErrorListResponse.class
        )
    })
    @RequestMapping(
        value = "/common/customer/detail",
        method = RequestMethod.GET
    )
    @PreAuthorize("hasAuthority('SCOPE_common:customer.detail:read')")
    ResponseEntity<ResponseCommonCustomerDetail> getCustomerDetail(
        @AuthenticationPrincipal Jwt jwt,
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
