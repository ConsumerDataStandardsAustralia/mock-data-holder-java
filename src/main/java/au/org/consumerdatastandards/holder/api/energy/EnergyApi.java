package au.org.consumerdatastandards.holder.api.energy;

import au.org.consumerdatastandards.holder.api.DateFormat;
import au.org.consumerdatastandards.holder.model.ErrorListResponse;
import au.org.consumerdatastandards.holder.model.energy.EnergyAccountDetailResponse;
import au.org.consumerdatastandards.holder.model.energy.EnergyAccountListResponse;
import au.org.consumerdatastandards.holder.model.energy.EnergyBalanceListResponse;
import au.org.consumerdatastandards.holder.model.energy.EnergyBalanceResponse;
import au.org.consumerdatastandards.holder.model.energy.EnergyBillingListResponse;
import au.org.consumerdatastandards.holder.model.energy.EnergyConcessionsResponse;
import au.org.consumerdatastandards.holder.model.energy.EnergyDerDetailResponse;
import au.org.consumerdatastandards.holder.model.energy.EnergyDerListResponse;
import au.org.consumerdatastandards.holder.model.energy.EnergyInvoiceListResponse;
import au.org.consumerdatastandards.holder.model.energy.EnergyPaymentScheduleResponse;
import au.org.consumerdatastandards.holder.model.energy.EnergyPlanListResponse;
import au.org.consumerdatastandards.holder.model.energy.EnergyPlanResponse;
import au.org.consumerdatastandards.holder.model.energy.EnergyServicePointDetailResponse;
import au.org.consumerdatastandards.holder.model.energy.EnergyServicePointListResponse;
import au.org.consumerdatastandards.holder.model.energy.EnergyUsageListResponse;
import au.org.consumerdatastandards.holder.model.energy.ParamAccountOpenStatus;
import au.org.consumerdatastandards.holder.model.energy.ParamEffective;
import au.org.consumerdatastandards.holder.model.energy.ParamFuelTypeEnum;
import au.org.consumerdatastandards.holder.model.energy.ParamIntervalReadsEnum;
import au.org.consumerdatastandards.holder.model.energy.ParamTypeEnum;
import au.org.consumerdatastandards.holder.model.energy.RequestAccountIds;
import au.org.consumerdatastandards.holder.model.energy.RequestServicePointIds;
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

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Date;
import java.util.UUID;

@Api(value = "energy", description = "the energy API")
public interface EnergyApi {

    /**
     * GET /energy/accounts/{accountId} : Get Energy Account Detail
     * Obtain detailed information for a specific energy account
     *
     * @param accountId              ID of a specific account to obtain data for.  This is a tokenised ID previous obtained from the Account List end point. (required)
     * @param xV                     Version of the API endpoint requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [_x-min-v_](#request-headers) and [_x-v_](#request-headers). If the value of [_x-min-v_](#request-headers) is equal to or higher than the value of [_x-v_](#request-headers) then the [_x-min-v_](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder **MUST** respond with a `406 Not Acceptable`. See [HTTP Headers](#request-headers). (required)
     * @param xMinV                  Minimum version of the API endpoint requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [_x-min-v_](#request-headers) and [_x-v_](#request-headers). If all versions requested are not supported then the data holder **MUST** respond with a `406 Not Acceptable`. (optional)
     * @param xFapiInteractionId     An [RFC4122](https://tools.ietf.org/html/rfc4122) UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction. (optional)
     * @param xFapiAuthDate          The time when the customer last logged in to the Data Recipient Software Product as described in **[[FAPI-1.0-Baseline]](#nref-FAPI-1-0-Baseline)**. Required for all resource calls (customer present and unattended). Not required for unauthenticated calls. (optional)
     * @param xFapiCustomerIpAddress The customer's original IP address if the customer is currently logged in to the data recipient. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls. (optional)
     * @param xCdsClientHeaders      The customer's original standard http headers [Base64](#common-field-types) encoded, including the original User Agent header, if the customer is currently logged in to the data recipient. Mandatory for customer present calls.  Not required for unattended or unauthenticated calls. (optional)
     * @return Successful response (status code 200)
     * or The following error codes MUST be supported:<br><ul class="error-code-list"><li>[400 - Invalid Field](#error-400-field-invalid)</li><li>[400 - Missing Required Field](#error-400-field-missing)</li><li>[400 - Invalid Version](#error-400-header-invalid-version)</li><li>[406 - Unsupported Version](#error-406-header-unsupported-version)</li><li>[404 - Unavailable Energy Account](#error-404-unavailable-energy-account)</li><li>[404 - Invalid Energy Account](#error-404-invalid-energy-account)</li></ul> (status code 4xx)
     */
    @ApiOperation(value = "Get Energy Account Detail",
            nickname = "getAccount",
            notes = "Obtain detailed information for a specific energy account",
            response = EnergyAccountDetailResponse.class,
            tags = {"Energy", "Energy Accounts",})
    @ApiResponses(value = {
            @ApiResponse(code = 200,
                    responseHeaders = {
                        @ResponseHeader(name = "x-v", response = Integer.class, description = "The [version](#response-headers) of the API endpoint that the data holder has responded with."),
                        @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction.")
                    },
                    message = "Successful response",
                    response = EnergyAccountDetailResponse.class),
            @ApiResponse(code = 400,
                    responseHeaders = @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction."),
                    message = "Invalid Version / Missing Field / Invalid Field",
                    response = ErrorListResponse.class),
            @ApiResponse(code = 406,
                    responseHeaders = @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction."),
                    message = "Unsupported Version",
                    response = ErrorListResponse.class),
            @ApiResponse(code = 404,
                    responseHeaders = @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction."),
                    message = "Unavailable Energy Account / Invalid Energy Account",
                    response = ErrorListResponse.class)
    })
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/energy/accounts/{accountId}",
            produces = {"application/json"}
    )
    @PreAuthorize("hasAuthority('SCOPE_energy:accounts.detail:read')")
    ResponseEntity<EnergyAccountDetailResponse> getAccount(
            @ApiParam(
                    value = "ID of a specific account to obtain data for.  This is a tokenised ID previous obtained from the Account List end point.",
                    required = true)
            @PathVariable("accountId")
                    String accountId,
            @ApiParam(
                    value = "Version of the API endpoint requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [_x-min-v_](#request-headers) and [_x-v_](#request-headers). If the value of [_x-min-v_](#request-headers) is equal to or higher than the value of [_x-v_](#request-headers) then the [_x-min-v_](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder **MUST** respond with a `406 Not Acceptable`. See [HTTP Headers](#request-headers).",
                    required = true)
            @RequestHeader(value = "x-v", required = false)
                    Integer xV,
            @ApiParam(
                    value = "Minimum version of the API endpoint requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [_x-min-v_](#request-headers) and [_x-v_](#request-headers). If all versions requested are not supported then the data holder **MUST** respond with a `406 Not Acceptable`.")
            @RequestHeader(value = "x-min-v",
                    required = false)
                    Integer xMinV,
            @ApiParam(
                    value = "An [RFC4122](https://tools.ietf.org/html/rfc4122) UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction.")
            @RequestHeader(value = "x-fapi-interaction-id",
                    required = false)
                    UUID xFapiInteractionId,
            @ApiParam(
                    value = "The time when the customer last logged in to the Data Recipient Software Product as described in **[[FAPI-1.0-Baseline]](#nref-FAPI-1-0-Baseline)**. Required for all resource calls (customer present and unattended). Not required for unauthenticated calls.")
            @RequestHeader(value = "x-fapi-auth-date",
                    required = false)
                    @NotNull @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, fallbackPatterns = DateFormat.HTTP) Date xFapiAuthDate,
            @ApiParam(
                    value = "The customer's original IP address if the customer is currently logged in to the data recipient. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls.")
            @RequestHeader(value = "x-fapi-customer-ip-address",
                    required = false)
                    String xFapiCustomerIpAddress,
            @ApiParam(
                    value = "The customer's original standard http headers [Base64](#common-field-types) encoded, including the original User Agent header, if the customer is currently logged in to the data recipient. Mandatory for customer present calls.  Not required for unattended or unauthenticated calls.")
            @RequestHeader(value = "x-cds-client-headers",
                    required = false)
                    String xCdsClientHeaders);


    /**
     * GET /energy/accounts/{accountId}/balance : Get Balance For Energy Account
     * Obtain the current balance for a specific account
     *
     * @param accountId              ID of a specific account to obtain data for.  This is a tokenised ID previous obtained from the Account List end point. (required)
     * @param xV                     Version of the API endpoint requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [_x-min-v_](#request-headers) and [_x-v_](#request-headers). If the value of [_x-min-v_](#request-headers) is equal to or higher than the value of [_x-v_](#request-headers) then the [_x-min-v_](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder **MUST** respond with a `406 Not Acceptable`. See [HTTP Headers](#request-headers). (required)
     * @param xMinV                  Minimum version of the API endpoint requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [_x-min-v_](#request-headers) and [_x-v_](#request-headers). If all versions requested are not supported then the data holder **MUST** respond with a `406 Not Acceptable`. (optional)
     * @param xFapiInteractionId     An [RFC4122](https://tools.ietf.org/html/rfc4122) UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction. (optional)
     * @param xFapiAuthDate          The time when the customer last logged in to the Data Recipient Software Product as described in **[[FAPI-1.0-Baseline]](#nref-FAPI-1-0-Baseline)**. Required for all resource calls (customer present and unattended). Not required for unauthenticated calls. (optional)
     * @param xFapiCustomerIpAddress The customer's original IP address if the customer is currently logged in to the data recipient. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls. (optional)
     * @param xCdsClientHeaders      The customer's original standard http headers [Base64](#common-field-types) encoded, including the original User Agent header, if the customer is currently logged in to the data recipient. Mandatory for customer present calls.  Not required for unattended or unauthenticated calls. (optional)
     * @return Successful response (status code 200)
     * or The following error codes MUST be supported:<br><ul class="error-code-list"><li>[400 - Invalid Field](#error-400-field-invalid)</li><li>[400 - Missing Required Field](#error-400-field-missing)</li><li>[400 - Invalid Version](#error-400-header-invalid-version)</li><li>[406 - Unsupported Version](#error-406-header-unsupported-version)</li><li>[404 - Unavailable Energy Account](#error-404-unavailable-energy-account)</li><li>[404 - Invalid Energy Account](#error-404-invalid-energy-account)</li></ul> (status code 4xx)
     */
    @ApiOperation(value = "Get Balance For Energy Account",
            nickname = "getBalanceForAccount",
            notes = "Obtain the current balance for a specific account",
            response = EnergyBalanceResponse.class,
            tags = {"Energy", "Billing",})
    @ApiResponses(value = {
            @ApiResponse(code = 200,
                    responseHeaders = {
                        @ResponseHeader(name = "x-v", response = Integer.class, description = "The [version](#response-headers) of the API endpoint that the data holder has responded with."),
                        @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction.")
                    },
                    message = "Successful response",
                    response = EnergyBalanceResponse.class),
            @ApiResponse(code = 400,
                    responseHeaders = @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction."),
                    message = "Invalid Version / Missing Field / Invalid Field",
                    response = ErrorListResponse.class),
            @ApiResponse(code = 406,
                    responseHeaders = @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction."),
                    message = "Unsupported Version",
                    response = ErrorListResponse.class),
            @ApiResponse(code = 404,
                    responseHeaders = @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction."),
                    message = "Unavailable Energy Account / Invalid Energy Account",
                    response = ErrorListResponse.class)
    })
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/energy/accounts/{accountId}/balance",
            produces = {"application/json"}
    )
    @PreAuthorize("hasAuthority('SCOPE_energy:billing:read')")
    ResponseEntity<EnergyBalanceResponse> getBalanceForAccount(
            @ApiParam(
                    value = "ID of a specific account to obtain data for.  This is a tokenised ID previous obtained from the Account List end point.",
                    required = true)
            @PathVariable("accountId")
                    String accountId,
            @ApiParam(
                    value = "Version of the API endpoint requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [_x-min-v_](#request-headers) and [_x-v_](#request-headers). If the value of [_x-min-v_](#request-headers) is equal to or higher than the value of [_x-v_](#request-headers) then the [_x-min-v_](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder **MUST** respond with a `406 Not Acceptable`. See [HTTP Headers](#request-headers).",
                    required = true)
            @RequestHeader(value = "x-v", required = false)
                    Integer xV,
            @ApiParam(
                    value = "Minimum version of the API endpoint requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [_x-min-v_](#request-headers) and [_x-v_](#request-headers). If all versions requested are not supported then the data holder **MUST** respond with a `406 Not Acceptable`.")
            @RequestHeader(value = "x-min-v",
                    required = false)
                    Integer xMinV,
            @ApiParam(
                    value = "An [RFC4122](https://tools.ietf.org/html/rfc4122) UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction.")
            @RequestHeader(value = "x-fapi-interaction-id",
                    required = false)
                    UUID xFapiInteractionId,
            @ApiParam(
                    value = "The time when the customer last logged in to the Data Recipient Software Product as described in **[[FAPI-1.0-Baseline]](#nref-FAPI-1-0-Baseline)**. Required for all resource calls (customer present and unattended). Not required for unauthenticated calls.")
            @RequestHeader(value = "x-fapi-auth-date",
                    required = false)
                    @NotNull @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, fallbackPatterns = DateFormat.HTTP) Date xFapiAuthDate,
            @ApiParam(
                    value = "The customer's original IP address if the customer is currently logged in to the data recipient. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls.")
            @RequestHeader(value = "x-fapi-customer-ip-address",
                    required = false)
                    String xFapiCustomerIpAddress,
            @ApiParam(
                    value = "The customer's original standard http headers [Base64](#common-field-types) encoded, including the original User Agent header, if the customer is currently logged in to the data recipient. Mandatory for customer present calls.  Not required for unattended or unauthenticated calls.")
            @RequestHeader(value = "x-cds-client-headers",
                    required = false)
                    String xCdsClientHeaders);


    /**
     * GET /energy/accounts/{accountId}/billing : Get Billing For Account
     * Obtain the billing transactions for a specific account
     *
     * @param accountId              ID of a specific account to obtain data for.  This is a tokenised ID previous obtained from the Account List end point. (required)
     * @param xV                     Version of the API endpoint requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [_x-min-v_](#request-headers) and [_x-v_](#request-headers). If the value of [_x-min-v_](#request-headers) is equal to or higher than the value of [_x-v_](#request-headers) then the [_x-min-v_](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder **MUST** respond with a `406 Not Acceptable`. See [HTTP Headers](#request-headers). (required)
     * @param newestTime             Constrain the request to records with effective time at or before this date/time.  If absent defaults to current date/time.  Format is aligned to DateTimeString common type (optional)
     * @param oldestTime             Constrain the request to records with effective time at or after this date/time. If absent defaults to newest-time minus 12 months.  Format is aligned to DateTimeString common type (optional)
     * @param page                   Page of results to request (standard pagination) (optional)
     * @param pageSize               Page size to request.  Default is 25 (standard pagination) (optional)
     * @param xMinV                  Minimum version of the API endpoint requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [_x-min-v_](#request-headers) and [_x-v_](#request-headers). If all versions requested are not supported then the data holder **MUST** respond with a `406 Not Acceptable`. (optional)
     * @param xFapiInteractionId     An [RFC4122](https://tools.ietf.org/html/rfc4122) UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction. (optional)
     * @param xFapiAuthDate          The time when the customer last logged in to the Data Recipient Software Product as described in **[[FAPI-1.0-Baseline]](#nref-FAPI-1-0-Baseline)**. Required for all resource calls (customer present and unattended). Not required for unauthenticated calls. (optional)
     * @param xFapiCustomerIpAddress The customer's original IP address if the customer is currently logged in to the data recipient. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls. (optional)
     * @param xCdsClientHeaders      The customer's original standard http headers [Base64](#common-field-types) encoded, including the original User Agent header, if the customer is currently logged in to the data recipient. Mandatory for customer present calls.  Not required for unattended or unauthenticated calls. (optional)
     * @return Successful response (status code 200)
     * or The following error codes MUST be supported:<br><ul class="error-code-list"><li>[400 - Invalid Field](#error-400-field-invalid)</li><li>[400 - Missing Required Field](#error-400-field-missing)</li><li>[400 - Invalid Page Size](#error-400-field-invalid-page-size)</li><li>[400 - Invalid Version](#error-400-header-invalid-version)</li><li>[406 - Unsupported Version](#error-406-header-unsupported-version)</li><li>[422 - Invalid Page](#error-422-field-invalid-page)</li><li>[404 - Unavailable Energy Account](#error-404-unavailable-energy-account)</li><li>[404 - Invalid Energy Account](#error-404-invalid-energy-account)</li></ul> (status code 4xx)
     */
    @ApiOperation(value = "Get Billing For Account",
            nickname = "getBillingForAccount",
            notes = "Obtain the billing transactions for a specific account",
            response = EnergyBillingListResponse.class,
            tags = {"Energy", "Billing",})
    @ApiResponses(value = {
            @ApiResponse(code = 200,
                    responseHeaders = {
                        @ResponseHeader(name = "x-v", response = Integer.class, description = "The [version](#response-headers) of the API endpoint that the data holder has responded with."),
                        @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction.")
                    },
                    message = "Successful response",
                    response = EnergyBillingListResponse.class),
            @ApiResponse(code = 400,
                    responseHeaders = @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction."),
                    message = "Invalid Version / Missing Field / Invalid Field / Invalid Page Size / Invalid Date",
                    response = ErrorListResponse.class),
            @ApiResponse(code = 406,
                    responseHeaders = @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction."),
                    message = "Unsupported Version",
                    response = ErrorListResponse.class),
            @ApiResponse(code = 404,
                    responseHeaders = @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction."),
                    message = "Unavailable Energy Account / Invalid Energy Account",
                    response = ErrorListResponse.class),
            @ApiResponse(code = 422,
                    responseHeaders = @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction."),
                    message = "Invalid Page",
                    response = ErrorListResponse.class)
    })
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/energy/accounts/{accountId}/billing",
            produces = {"application/json"}
    )
    @PreAuthorize("hasAuthority('SCOPE_energy:billing:read')")
    ResponseEntity<EnergyBillingListResponse> getBillingForAccount(
            @ApiParam(
                    value = "ID of a specific account to obtain data for.  This is a tokenised ID previous obtained from the Account List end point.",
                    required = true)
            @PathVariable("accountId")
                    String accountId,
            @ApiParam(
                    value = "Version of the API endpoint requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [_x-min-v_](#request-headers) and [_x-v_](#request-headers). If the value of [_x-min-v_](#request-headers) is equal to or higher than the value of [_x-v_](#request-headers) then the [_x-min-v_](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder **MUST** respond with a `406 Not Acceptable`. See [HTTP Headers](#request-headers).",
                    required = true)
            @RequestHeader(value = "x-v", required = false)
                    Integer xV,
            @ApiParam(
                    value = "Minimum version of the API endpoint requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [_x-min-v_](#request-headers) and [_x-v_](#request-headers). If all versions requested are not supported then the data holder **MUST** respond with a `406 Not Acceptable`.")
            @RequestHeader(value = "x-min-v",
                    required = false)
                    Integer xMinV,
            @ApiParam(
                    value = "Constrain the request to records with effective time at or before this date/time.  If absent defaults to current date/time.  Format is aligned to DateTimeString common type")
            @Valid
            @RequestParam(value = "newest-time",
                    required = false)
                    OffsetDateTime newestTime,
            @ApiParam(
                    value = "Constrain the request to records with effective time at or after this date/time. If absent defaults to newest-time minus 12 months.  Format is aligned to DateTimeString common type")
            @Valid
            @RequestParam(value = "oldest-time",
                    required = false)
                    OffsetDateTime oldestTime,
            @ApiParam(value = "Page of results to request (standard pagination)")
            @Valid
            @RequestParam(value = "page",
                    required = false)
                    Integer page,
            @ApiParam(
                    value = "Page size to request.  Default is 25 (standard pagination)")
            @Valid
            @RequestParam(value = "page-size",
                    required = false)
                    Integer pageSize,
            @ApiParam(
                    value = "An [RFC4122](https://tools.ietf.org/html/rfc4122) UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction.")
            @RequestHeader(value = "x-fapi-interaction-id",
                    required = false)
                    UUID xFapiInteractionId,
            @ApiParam(
                    value = "The time when the customer last logged in to the Data Recipient Software Product as described in **[[FAPI-1.0-Baseline]](#nref-FAPI-1-0-Baseline)**. Required for all resource calls (customer present and unattended). Not required for unauthenticated calls.")
            @RequestHeader(value = "x-fapi-auth-date",
                    required = false)
                    @NotNull @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, fallbackPatterns = DateFormat.HTTP) Date xFapiAuthDate,
            @ApiParam(
                    value = "The customer's original IP address if the customer is currently logged in to the data recipient. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls.")
            @RequestHeader(value = "x-fapi-customer-ip-address",
                    required = false)
                    String xFapiCustomerIpAddress,
            @ApiParam(
                    value = "The customer's original standard http headers [Base64](#common-field-types) encoded, including the original User Agent header, if the customer is currently logged in to the data recipient. Mandatory for customer present calls.  Not required for unattended or unauthenticated calls.")
            @RequestHeader(value = "x-cds-client-headers",
                    required = false)
                    String xCdsClientHeaders);


    /**
     * GET /energy/accounts/{accountId}/concessions : Get Concessions
     * Obtain the details of any concessions or arrangements applied to a specific energy account
     *
     * @param accountId              ID of a specific account to obtain data for.  This is a tokenised ID previous obtained from the Account List end point. (required)
     * @param xV                     Version of the API endpoint requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [_x-min-v_](#request-headers) and [_x-v_](#request-headers). If the value of [_x-min-v_](#request-headers) is equal to or higher than the value of [_x-v_](#request-headers) then the [_x-min-v_](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder **MUST** respond with a `406 Not Acceptable`. See [HTTP Headers](#request-headers). (required)
     * @param xMinV                  Minimum version of the API endpoint requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [_x-min-v_](#request-headers) and [_x-v_](#request-headers). If all versions requested are not supported then the data holder **MUST** respond with a `406 Not Acceptable`. (optional)
     * @param xFapiInteractionId     An [RFC4122](https://tools.ietf.org/html/rfc4122) UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction. (optional)
     * @param xFapiAuthDate          The time when the customer last logged in to the Data Recipient Software Product as described in **[[FAPI-1.0-Baseline]](#nref-FAPI-1-0-Baseline)**. Required for all resource calls (customer present and unattended). Not required for unauthenticated calls. (optional)
     * @param xFapiCustomerIpAddress The customer's original IP address if the customer is currently logged in to the data recipient. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls. (optional)
     * @param xCdsClientHeaders      The customer's original standard http headers [Base64](#common-field-types) encoded, including the original User Agent header, if the customer is currently logged in to the data recipient. Mandatory for customer present calls.  Not required for unattended or unauthenticated calls. (optional)
     * @return Successful response (status code 200)
     * or The following error codes MUST be supported:<br><ul class="error-code-list"><li>[400 - Invalid Field](#error-400-field-invalid)</li><li>[400 - Missing Required Field](#error-400-field-missing)</li><li>[400 - Invalid Version](#error-400-header-invalid-version)</li><li>[406 - Unsupported Version](#error-406-header-unsupported-version)</li><li>[404 - Unavailable Energy Account](#error-404-unavailable-energy-account)</li><li>[404 - Invalid Energy Account](#error-404-invalid-energy-account)</li></ul> (status code 4xx)
     */
    @ApiOperation(value = "Get Concessions",
            nickname = "getConcessions",
            notes = "Obtain the details of any concessions or arrangements applied to a specific energy account",
            response = EnergyConcessionsResponse.class,
            tags = {"Energy", "Energy Accounts",})
    @ApiResponses(value = {
            @ApiResponse(code = 200,
                    responseHeaders = {
                        @ResponseHeader(name = "x-v", response = Integer.class, description = "The [version](#response-headers) of the API endpoint that the data holder has responded with."),
                        @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction.")
                    },
                    message = "Successful response",
                    response = EnergyConcessionsResponse.class),
            @ApiResponse(code = 400,
                    responseHeaders = @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction."),
                    message = "Invalid Version / Missing Field / Invalid Field",
                    response = ErrorListResponse.class),
            @ApiResponse(code = 406,
                    responseHeaders = @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction."),
                    message = "Unsupported Version",
                    response = ErrorListResponse.class),
            @ApiResponse(code = 404,
                    responseHeaders = @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction."),
                    message = "Unavailable Energy Account / Invalid Energy Account",
                    response = ErrorListResponse.class)
    })
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/energy/accounts/{accountId}/concessions",
            produces = {"application/json"}
    )
    @PreAuthorize("hasAuthority('SCOPE_energy:accounts.concessions:read')")
    ResponseEntity<EnergyConcessionsResponse> getConcessions(
            @ApiParam(
                    value = "ID of a specific account to obtain data for.  This is a tokenised ID previous obtained from the Account List end point.",
                    required = true)
            @PathVariable("accountId")
                    String accountId,
            @ApiParam(
                    value = "Version of the API endpoint requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [_x-min-v_](#request-headers) and [_x-v_](#request-headers). If the value of [_x-min-v_](#request-headers) is equal to or higher than the value of [_x-v_](#request-headers) then the [_x-min-v_](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder **MUST** respond with a `406 Not Acceptable`. See [HTTP Headers](#request-headers).",
                    required = true)
            @RequestHeader(value = "x-v", required = false)
                    Integer xV,
            @ApiParam(
                    value = "Minimum version of the API endpoint requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [_x-min-v_](#request-headers) and [_x-v_](#request-headers). If all versions requested are not supported then the data holder **MUST** respond with a `406 Not Acceptable`.")
            @RequestHeader(value = "x-min-v",
                    required = false)
                    Integer xMinV,
            @ApiParam(
                    value = "An [RFC4122](https://tools.ietf.org/html/rfc4122) UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction.")
            @RequestHeader(value = "x-fapi-interaction-id",
                    required = false)
                    UUID xFapiInteractionId,
            @ApiParam(
                    value = "The time when the customer last logged in to the Data Recipient Software Product as described in **[[FAPI-1.0-Baseline]](#nref-FAPI-1-0-Baseline)**. Required for all resource calls (customer present and unattended). Not required for unauthenticated calls.")
            @RequestHeader(value = "x-fapi-auth-date",
                    required = false)
                    @NotNull @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, fallbackPatterns = DateFormat.HTTP) Date xFapiAuthDate,
            @ApiParam(
                    value = "The customer's original IP address if the customer is currently logged in to the data recipient. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls.")
            @RequestHeader(value = "x-fapi-customer-ip-address",
                    required = false)
                    String xFapiCustomerIpAddress,
            @ApiParam(
                    value = "The customer's original standard http headers [Base64](#common-field-types) encoded, including the original User Agent header, if the customer is currently logged in to the data recipient. Mandatory for customer present calls.  Not required for unattended or unauthenticated calls.")
            @RequestHeader(value = "x-cds-client-headers",
                    required = false)
                    String xCdsClientHeaders);


    /**
     * GET /energy/electricity/servicepoints/{servicePointId}/der : Get DER For Service Point
     * Obtain a list of DER data from a particular service point
     *
     * @param servicePointId         ID of the specific service point requested.  This is a tokenised ID previous obtained from the Service Point List Data end point.  Note that it is not a nationalMeteringId. (required)
     * @param xV                     Version of the API endpoint requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [_x-min-v_](#request-headers) and [_x-v_](#request-headers). If the value of [_x-min-v_](#request-headers) is equal to or higher than the value of [_x-v_](#request-headers) then the [_x-min-v_](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder **MUST** respond with a `406 Not Acceptable`. See [HTTP Headers](#request-headers). (required)
     * @param xMinV                  Minimum version of the API endpoint requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [_x-min-v_](#request-headers) and [_x-v_](#request-headers). If all versions requested are not supported then the data holder **MUST** respond with a `406 Not Acceptable`. (optional)
     * @param xFapiInteractionId     An [RFC4122](https://tools.ietf.org/html/rfc4122) UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction. (optional)
     * @param xFapiAuthDate          The time when the customer last logged in to the Data Recipient Software Product as described in **[[FAPI-1.0-Baseline]](#nref-FAPI-1-0-Baseline)**. Required for all resource calls (customer present and unattended). Not required for unauthenticated calls. (optional)
     * @param xFapiCustomerIpAddress The customer's original IP address if the customer is currently logged in to the data recipient. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls. (optional)
     * @param xCdsClientHeaders      The customer's original standard http headers [Base64](#common-field-types) encoded, including the original User Agent header, if the customer is currently logged in to the data recipient. Mandatory for customer present calls.  Not required for unattended or unauthenticated calls. (optional)
     * @return Successful response (status code 200)
     * or The following error codes MUST be supported:<br><ul class="error-code-list"><li>[400 - Invalid Field](#error-400-field-invalid)</li><li>[400 - Missing Required Field](#error-400-field-missing)</li><li>[400 - Invalid Version](#error-400-header-invalid-version)</li><li>[406 - Unsupported Version](#error-406-header-unsupported-version)</li><li>[404 - Unavailable Service Point](#error-404-unavailable-service-point)</li><li>[404 - Invalid Service Point](#error-404-invalid-service-point)</li></ul> (status code 4xx)
     */
    @ApiOperation(value = "Get DER For Service Point",
            nickname = "getDERForServicePoint",
            notes = "Obtain a list of DER data from a particular service point",
            response = EnergyDerDetailResponse.class,
            tags = {"Energy", "Distributed Energy Resources",})
    @ApiResponses(value = {
            @ApiResponse(code = 200,
                    responseHeaders = {
                        @ResponseHeader(name = "x-v", response = Integer.class, description = "The [version](#response-headers) of the API endpoint that the data holder has responded with."),
                        @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction.")
                    },
                    message = "Successful response",
                    response = EnergyDerDetailResponse.class),
            @ApiResponse(code = 400,
                    responseHeaders = @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction."),
                    message = "Invalid Version / Missing Field / Invalid Field",
                    response = ErrorListResponse.class),
            @ApiResponse(code = 406,
                    responseHeaders = @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction."),
                    message = "Unsupported Version",
                    response = ErrorListResponse.class),
            @ApiResponse(code = 404,
                    responseHeaders = @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction."),
                    message = "Unavailable Energy Account / Invalid Energy Account",
                    response = ErrorListResponse.class)
    })
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/energy/electricity/servicepoints/{servicePointId}/der",
            produces = {"application/json"}
    )
    @PreAuthorize("hasAuthority('SCOPE_energy:electricity.der:read')")
    ResponseEntity<EnergyDerDetailResponse> getDERForServicePoint(
            @ApiParam(
                    value = "ID of the specific service point requested.  This is a tokenised ID previous obtained from the Service Point List Data end point.  Note that it is not a nationalMeteringId.",
                    required = true)
            @PathVariable("servicePointId")
                    String servicePointId,
            @ApiParam(
                    value = "Version of the API endpoint requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [_x-min-v_](#request-headers) and [_x-v_](#request-headers). If the value of [_x-min-v_](#request-headers) is equal to or higher than the value of [_x-v_](#request-headers) then the [_x-min-v_](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder **MUST** respond with a `406 Not Acceptable`. See [HTTP Headers](#request-headers).",
                    required = true)
            @RequestHeader(value = "x-v", required = false)
                    Integer xV,
            @ApiParam(
                    value = "Minimum version of the API endpoint requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [_x-min-v_](#request-headers) and [_x-v_](#request-headers). If all versions requested are not supported then the data holder **MUST** respond with a `406 Not Acceptable`.")
            @RequestHeader(value = "x-min-v",
                    required = false)
                    Integer xMinV,
            @ApiParam(
                    value = "An [RFC4122](https://tools.ietf.org/html/rfc4122) UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction.")
            @RequestHeader(value = "x-fapi-interaction-id",
                    required = false)
                    UUID xFapiInteractionId,
            @ApiParam(
                    value = "The time when the customer last logged in to the Data Recipient Software Product as described in **[[FAPI-1.0-Baseline]](#nref-FAPI-1-0-Baseline)**. Required for all resource calls (customer present and unattended). Not required for unauthenticated calls.")
            @RequestHeader(value = "x-fapi-auth-date",
                    required = false)
                    @NotNull @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, fallbackPatterns = DateFormat.HTTP) Date xFapiAuthDate,
            @ApiParam(
                    value = "The customer's original IP address if the customer is currently logged in to the data recipient. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls.")
            @RequestHeader(value = "x-fapi-customer-ip-address",
                    required = false)
                    String xFapiCustomerIpAddress,
            @ApiParam(
                    value = "The customer's original standard http headers [Base64](#common-field-types) encoded, including the original User Agent header, if the customer is currently logged in to the data recipient. Mandatory for customer present calls.  Not required for unattended or unauthenticated calls.")
            @RequestHeader(value = "x-cds-client-headers",
                    required = false)
                    String xCdsClientHeaders);


    /**
     * GET /energy/accounts/{accountId}/invoices : Get Invoices For Account
     * Obtain the invoices for a specific account
     *
     * @param accountId              ID of a specific account to obtain data for.  This is a tokenised ID previous obtained from the Account List end point. (required)
     * @param xV                     Version of the API endpoint requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [_x-min-v_](#request-headers) and [_x-v_](#request-headers). If the value of [_x-min-v_](#request-headers) is equal to or higher than the value of [_x-v_](#request-headers) then the [_x-min-v_](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder **MUST** respond with a `406 Not Acceptable`. See [HTTP Headers](#request-headers). (required)
     * @param newestDate             Constrain the request to records with issue date at or before this date.  If absent defaults to current date.  Format is aligned to DateString common type (optional)
     * @param oldestDate             Constrain the request to records with issue date at or after this date. If absent defaults to newest-date minus 24 months.  Format is aligned to DateString common type (optional)
     * @param page                   Page of results to request (standard pagination) (optional)
     * @param pageSize               Page size to request.  Default is 25 (standard pagination) (optional)
     * @param xMinV                  Minimum version of the API endpoint requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [_x-min-v_](#request-headers) and [_x-v_](#request-headers). If all versions requested are not supported then the data holder **MUST** respond with a `406 Not Acceptable`. (optional)
     * @param xFapiInteractionId     An [RFC4122](https://tools.ietf.org/html/rfc4122) UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction. (optional)
     * @param xFapiAuthDate          The time when the customer last logged in to the Data Recipient Software Product as described in **[[FAPI-1.0-Baseline]](#nref-FAPI-1-0-Baseline)**. Required for all resource calls (customer present and unattended). Not required for unauthenticated calls. (optional)
     * @param xFapiCustomerIpAddress The customer's original IP address if the customer is currently logged in to the data recipient. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls. (optional)
     * @param xCdsClientHeaders      The customer's original standard http headers [Base64](#common-field-types) encoded, including the original User Agent header, if the customer is currently logged in to the data recipient. Mandatory for customer present calls.  Not required for unattended or unauthenticated calls. (optional)
     * @return Successful response (status code 200)
     * or The following error codes MUST be supported:<br><ul class="error-code-list"><li>[400 - Invalid Field](#error-400-field-invalid)</li><li>[400 - Missing Required Field](#error-400-field-missing)</li><li>[400 - Invalid Page Size](#error-400-field-invalid-page-size)</li><li>[400 - Invalid Version](#error-400-header-invalid-version)</li><li>[406 - Unsupported Version](#error-406-header-unsupported-version)</li><li>[422 - Invalid Page](#error-422-field-invalid-page)</li><li>[404 - Unavailable Energy Account](#error-404-unavailable-energy-account)</li><li>[404 - Invalid Energy Account](#error-404-invalid-energy-account)</li></ul> (status code 4xx)
     */
    @ApiOperation(value = "Get Invoices For Account",
            nickname = "getInvoicesForAccount",
            notes = "Obtain the invoices for a specific account",
            response = EnergyInvoiceListResponse.class,
            tags = {"Energy", "Billing",})
    @ApiResponses(value = {
            @ApiResponse(code = 200,
                    responseHeaders = {
                        @ResponseHeader(name = "x-v", response = Integer.class, description = "The [version](#response-headers) of the API endpoint that the data holder has responded with."),
                        @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction.")
                    },
                    message = "Successful response",
                    response = EnergyInvoiceListResponse.class),
            @ApiResponse(code = 400,
                    responseHeaders = @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction."),
                    message = "Invalid Version / Missing Field / Invalid Field / Invalid Page Size / Invalid Date",
                    response = ErrorListResponse.class),
            @ApiResponse(code = 406,
                    responseHeaders = @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction."),
                    message = "Unsupported Version",
                    response = ErrorListResponse.class),
            @ApiResponse(code = 404,
                    responseHeaders = @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction."),
                    message = "Unavailable Energy Account / Invalid Energy Account",
                    response = ErrorListResponse.class),
            @ApiResponse(code = 422,
                    responseHeaders = @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction."),
                    message = "Invalid Page",
                    response = ErrorListResponse.class)
    })
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/energy/accounts/{accountId}/invoices",
            produces = {"application/json"}
    )
    @PreAuthorize("hasAuthority('SCOPE_energy:billing:read')")
    ResponseEntity<EnergyInvoiceListResponse> getInvoicesForAccount(
            @ApiParam(
                    value = "ID of a specific account to obtain data for.  This is a tokenised ID previous obtained from the Account List end point.",
                    required = true)
            @PathVariable("accountId")
                    String accountId,
            @ApiParam(
                    value = "Version of the API endpoint requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [_x-min-v_](#request-headers) and [_x-v_](#request-headers). If the value of [_x-min-v_](#request-headers) is equal to or higher than the value of [_x-v_](#request-headers) then the [_x-min-v_](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder **MUST** respond with a `406 Not Acceptable`. See [HTTP Headers](#request-headers).",
                    required = true)
            @RequestHeader(value = "x-v", required = false)
                    Integer xV,
            @ApiParam(
                    value = "Minimum version of the API endpoint requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [_x-min-v_](#request-headers) and [_x-v_](#request-headers). If all versions requested are not supported then the data holder **MUST** respond with a `406 Not Acceptable`.")
            @RequestHeader(value = "x-min-v",
                    required = false)
                    Integer xMinV,
            @ApiParam(
                    value = "Constrain the request to records with issue date at or before this date.  If absent defaults to current date.  Format is aligned to DateString common type")
            @Valid
            @RequestParam(value = "newest-date",
                    required = false)
                    LocalDate newestDate,
            @ApiParam(
                    value = "Constrain the request to records with issue date at or after this date. If absent defaults to newest-date minus 24 months.  Format is aligned to DateString common type")
            @Valid
            @RequestParam(value = "oldest-date",
                    required = false)
                    LocalDate oldestDate,
            @ApiParam(value = "Page of results to request (standard pagination)")
            @Valid
            @RequestParam(value = "page",
                    required = false)
                    Integer page,
            @ApiParam(
                    value = "Page size to request.  Default is 25 (standard pagination)")
            @Valid
            @RequestParam(value = "page-size",
                    required = false)
                    Integer pageSize,
            @ApiParam(
                    value = "An [RFC4122](https://tools.ietf.org/html/rfc4122) UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction.")
            @RequestHeader(value = "x-fapi-interaction-id",
                    required = false)
                    UUID xFapiInteractionId,
            @ApiParam(
                    value = "The time when the customer last logged in to the Data Recipient Software Product as described in **[[FAPI-1.0-Baseline]](#nref-FAPI-1-0-Baseline)**. Required for all resource calls (customer present and unattended). Not required for unauthenticated calls.")
            @RequestHeader(value = "x-fapi-auth-date",
                    required = false)
                    @NotNull @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, fallbackPatterns = DateFormat.HTTP) Date xFapiAuthDate,
            @ApiParam(
                    value = "The customer's original IP address if the customer is currently logged in to the data recipient. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls.")
            @RequestHeader(value = "x-fapi-customer-ip-address",
                    required = false)
                    String xFapiCustomerIpAddress,
            @ApiParam(
                    value = "The customer's original standard http headers [Base64](#common-field-types) encoded, including the original User Agent header, if the customer is currently logged in to the data recipient. Mandatory for customer present calls.  Not required for unattended or unauthenticated calls.")
            @RequestHeader(value = "x-cds-client-headers",
                    required = false)
                    String xCdsClientHeaders);


    /**
     * GET /energy/accounts/{accountId}/payment-schedule : Get Agreed Payment Schedule
     * Obtain the agreed payment schedule and details, if any, for a specific energy account.
     *
     * Some general notes about this end point:
     *
     * <ul><li>This API describes how the consumer has elected to pay for their account</li><li>Payments initiated by the consumer are classified as manual payments. The billing frequency is captured for manual payments. The consumer may choose to pay on a different schedule/frequency. The payment method and frequency is not captured for manual payments</li><li>Payments that can be initiated by the retailer, based on a consumer's preferences and permission, include payments based on a direct debit, card debit or digital wallet setup. Each of these requires a payment frequency to be provided along with other relevant fields</li><li>Information about payment plans related to debt repayments or arrangements due to hardship is not captured within this API</li></ul>
     *
     * @param accountId              ID of a specific account to obtain data for.  This is a tokenised ID previous obtained from the Account List end point. (required)
     * @param xV                     Version of the API endpoint requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [_x-min-v_](#request-headers) and [_x-v_](#request-headers). If the value of [_x-min-v_](#request-headers) is equal to or higher than the value of [_x-v_](#request-headers) then the [_x-min-v_](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder **MUST** respond with a `406 Not Acceptable`. See [HTTP Headers](#request-headers). (required)
     * @param xMinV                  Minimum version of the API endpoint requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [_x-min-v_](#request-headers) and [_x-v_](#request-headers). If all versions requested are not supported then the data holder **MUST** respond with a `406 Not Acceptable`. (optional)
     * @param xFapiInteractionId     An [RFC4122](https://tools.ietf.org/html/rfc4122) UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction. (optional)
     * @param xFapiAuthDate          The time when the customer last logged in to the Data Recipient Software Product as described in **[[FAPI-1.0-Baseline]](#nref-FAPI-1-0-Baseline)**. Required for all resource calls (customer present and unattended). Not required for unauthenticated calls. (optional)
     * @param xFapiCustomerIpAddress The customer's original IP address if the customer is currently logged in to the data recipient. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls. (optional)
     * @param xCdsClientHeaders      The customer's original standard http headers [Base64](#common-field-types) encoded, including the original User Agent header, if the customer is currently logged in to the data recipient. Mandatory for customer present calls.  Not required for unattended or unauthenticated calls. (optional)
     * @return Successful response (status code 200)
     * or The following error codes MUST be supported:<br><ul class="error-code-list"><li>[400 - Invalid Field](#error-400-field-invalid)</li><li>[400 - Missing Required Field](#error-400-field-missing)</li><li>[400 - Invalid Version](#error-400-header-invalid-version)</li><li>[406 - Unsupported Version](#error-406-header-unsupported-version)</li><li>[404 - Unavailable Energy Account](#error-404-unavailable-energy-account)</li><li>[404 - Invalid Energy Account](#error-404-invalid-energy-account)</li></ul> (status code 4xx)
     */
    @ApiOperation(value = "Get Agreed Payment Schedule",
            nickname = "getPaymentSchedule",
            notes = "Obtain the agreed payment schedule and details, if any, for a specific energy account. \n\nSome general notes about this end point:\n\n <ul><li>This API describes how the consumer has elected to pay for their account</li><li>Payments initiated by the consumer are classified as manual payments. The billing frequency is captured for manual payments. The consumer may choose to pay on a different schedule/frequency. The payment method and frequency is not captured for manual payments</li><li>Payments that can be initiated by the retailer, based on a consumer's preferences and permission, include payments based on a direct debit, card debit or digital wallet setup. Each of these requires a payment frequency to be provided along with other relevant fields</li><li>Information about payment plans related to debt repayments or arrangements due to hardship is not captured within this API</li></ul>",
            response = EnergyPaymentScheduleResponse.class,
            tags = {"Energy", "Energy Accounts",})
    @ApiResponses(value = {
            @ApiResponse(code = 200,
                    responseHeaders = {
                        @ResponseHeader(name = "x-v", response = Integer.class, description = "The [version](#response-headers) of the API endpoint that the data holder has responded with."),
                        @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction.")
                    },
                    message = "Successful response",
                    response = EnergyPaymentScheduleResponse.class),
            @ApiResponse(code = 400,
                    responseHeaders = @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction."),
                    message = "Invalid Version / Missing Field / Invalid Field",
                    response = ErrorListResponse.class),
            @ApiResponse(code = 406,
                    responseHeaders = @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction."),
                    message = "Unsupported Version",
                    response = ErrorListResponse.class),
            @ApiResponse(code = 404,
                    responseHeaders = @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction."),
                    message = "Unavailable Energy Account / Invalid Energy Account",
                    response = ErrorListResponse.class)
    })
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/energy/accounts/{accountId}/payment-schedule",
            produces = {"application/json"}
    )
    @PreAuthorize("hasAuthority('SCOPE_energy:accounts.paymentschedule:read')")
    ResponseEntity<EnergyPaymentScheduleResponse> getPaymentSchedule(
            @ApiParam(
                    value = "ID of a specific account to obtain data for.  This is a tokenised ID previous obtained from the Account List end point.",
                    required = true)
            @PathVariable("accountId")
                    String accountId,
            @ApiParam(
                    value = "Version of the API endpoint requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [_x-min-v_](#request-headers) and [_x-v_](#request-headers). If the value of [_x-min-v_](#request-headers) is equal to or higher than the value of [_x-v_](#request-headers) then the [_x-min-v_](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder **MUST** respond with a `406 Not Acceptable`. See [HTTP Headers](#request-headers).",
                    required = true)
            @RequestHeader(value = "x-v", required = false)
                    Integer xV,
            @ApiParam(
                    value = "Minimum version of the API endpoint requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [_x-min-v_](#request-headers) and [_x-v_](#request-headers). If all versions requested are not supported then the data holder **MUST** respond with a `406 Not Acceptable`.")
            @RequestHeader(value = "x-min-v",
                    required = false)
                    Integer xMinV,
            @ApiParam(
                    value = "An [RFC4122](https://tools.ietf.org/html/rfc4122) UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction.")
            @RequestHeader(value = "x-fapi-interaction-id",
                    required = false)
                    UUID xFapiInteractionId,
            @ApiParam(
                    value = "The time when the customer last logged in to the Data Recipient Software Product as described in **[[FAPI-1.0-Baseline]](#nref-FAPI-1-0-Baseline)**. Required for all resource calls (customer present and unattended). Not required for unauthenticated calls.")
            @RequestHeader(value = "x-fapi-auth-date",
                    required = false)
                    @NotNull @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, fallbackPatterns = DateFormat.HTTP) Date xFapiAuthDate,
            @ApiParam(
                    value = "The customer's original IP address if the customer is currently logged in to the data recipient. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls.")
            @RequestHeader(
                    value = "x-fapi-customer-ip-address",
                    required = false)
                    String xFapiCustomerIpAddress,
            @ApiParam(
                    value = "The customer's original standard http headers [Base64](#common-field-types) encoded, including the original User Agent header, if the customer is currently logged in to the data recipient. Mandatory for customer present calls.  Not required for unattended or unauthenticated calls.")
            @RequestHeader(value = "x-cds-client-headers",
                    required = false)
                    String xCdsClientHeaders);


    /**
     * GET /energy/plans/{planId} : Get Generic Plan Detail
     * Obtain detailed information on a single energy plan offered openly to the market
     *
     * @param planId             ID of the specific plan requested (required)
     * @param xV                 Version of the API endpoint requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [_x-min-v_](#request-headers) and [_x-v_](#request-headers). If the value of [_x-min-v_](#request-headers) is equal to or higher than the value of [_x-v_](#request-headers) then the [_x-min-v_](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder **MUST** respond with a `406 Not Acceptable`. See [HTTP Headers](#request-headers). (required)
     * @param xMinV              Minimum version of the API endpoint requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [_x-min-v_](#request-headers) and [_x-v_](#request-headers). If all versions requested are not supported then the data holder **MUST** respond with a `406 Not Acceptable`. (optional)
     * @return Successful response (status code 200)
     * or The following error codes MUST be supported:<br><ul class="error-code-list"><li>[400 - Invalid Field](#error-400-field-invalid)</li><li>[400 - Missing Required Field](#error-400-field-missing)</li><li>[400 - Invalid Version](#error-400-header-invalid-version)</li><li>[404 - Invalid Resource](#error-404-resource-invalid)</li><li>[406 - Unsupported Version](#error-406-header-unsupported-version)</li></ul> (status code 4xx)
     */
    @ApiOperation(value = "Get Generic Plan Detail",
            nickname = "getPlan",
            notes = "Obtain detailed information on a single energy plan offered openly to the market",
            response = EnergyPlanResponse.class,
            tags = {"Energy", "Generic Tariffs",})
    @ApiResponses(value = {
            @ApiResponse(code = 200,
                    responseHeaders = @ResponseHeader(name = "x-v", response = Integer.class, description = "The [version](#response-headers) of the API endpoint that the data holder has responded with."),
                    message = "Successful response",
                    response = EnergyPlanResponse.class),
            @ApiResponse(code = 400,
                    message = "Invalid Version / Missing Field / Invalid Field",
                    response = ErrorListResponse.class),
            @ApiResponse(code = 406,
                    message = "Unsupported Version",
                    response = ErrorListResponse.class),
            @ApiResponse(code = 404,
                    message = "Invalid Resource",
                    response = ErrorListResponse.class)
    })
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/energy/plans/{planId}",
            produces = {"application/json"}
    )
    ResponseEntity<EnergyPlanResponse> getPlan(
            @ApiParam(value = "ID of the specific plan requested",
                    required = true)
            @PathVariable("planId")
                    String planId,
            @ApiParam(
                    value = "Version of the API endpoint requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [_x-min-v_](#request-headers) and [_x-v_](#request-headers). If the value of [_x-min-v_](#request-headers) is equal to or higher than the value of [_x-v_](#request-headers) then the [_x-min-v_](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder **MUST** respond with a `406 Not Acceptable`. See [HTTP Headers](#request-headers).",
                    required = true)
            @RequestHeader(value = "x-v", required = false)
                    Integer xV,
            @ApiParam(
                    value = "Minimum version of the API endpoint requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [_x-min-v_](#request-headers) and [_x-v_](#request-headers). If all versions requested are not supported then the data holder **MUST** respond with a `406 Not Acceptable`.")
            @RequestHeader(value = "x-min-v",
                    required = false)
                    Integer xMinV);


    /**
     * GET /energy/electricity/servicepoints/{servicePointId} : Get Service Point Detail
     * Obtain detailed standing information for a specific service point that is owned by the customer that has authorised the current session
     *
     * @param servicePointId         ID of the specific service point requested.  This is a tokenised ID previous obtained from the Service Point List Data end point.  Note that it is not a nationalMeteringId. (required)
     * @param xV                     Version of the API endpoint requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [_x-min-v_](#request-headers) and [_x-v_](#request-headers). If the value of [_x-min-v_](#request-headers) is equal to or higher than the value of [_x-v_](#request-headers) then the [_x-min-v_](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder **MUST** respond with a `406 Not Acceptable`. See [HTTP Headers](#request-headers). (required)
     * @param xMinV                  Minimum version of the API endpoint requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [_x-min-v_](#request-headers) and [_x-v_](#request-headers). If all versions requested are not supported then the data holder **MUST** respond with a `406 Not Acceptable`. (optional)
     * @param xFapiInteractionId     An [RFC4122](https://tools.ietf.org/html/rfc4122) UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction. (optional)
     * @param xFapiAuthDate          The time when the customer last logged in to the Data Recipient Software Product as described in **[[FAPI-1.0-Baseline]](#nref-FAPI-1-0-Baseline)**. Required for all resource calls (customer present and unattended). Not required for unauthenticated calls. (optional)
     * @param xFapiCustomerIpAddress The customer's original IP address if the customer is currently logged in to the data recipient. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls. (optional)
     * @param xCdsClientHeaders      The customer's original standard http headers [Base64](#common-field-types) encoded, including the original User Agent header, if the customer is currently logged in to the data recipient. Mandatory for customer present calls.  Not required for unattended or unauthenticated calls. (optional)
     * @return Successful response (status code 200)
     * or The following error codes MUST be supported:<br><ul class="error-code-list"><li>[400 - Missing Required Field](#error-400-field-missing)</li><li>[400 - Invalid Field](#error-400-field-invalid)</li><li>[400 - Invalid Version](#error-400-header-invalid-version)</li><li>[406 - Unsupported Version](#error-406-header-unsupported-version)</li><li>[404 - Unavailable Service Point](#error-404-unavailable-service-point)</li><li>[404 - Invalid Service Point](#error-404-invalid-service-point)</li></ul> (status code 4xx)
     */
    @ApiOperation(value = "Get Service Point Detail",
            nickname = "getServicePoint",
            notes = "Obtain detailed standing information for a specific service point that is owned by the customer that has authorised the current session",
            response = EnergyServicePointDetailResponse.class,
            tags = {"Energy", "NMI Standing Data",})
    @ApiResponses(value = {
            @ApiResponse(code = 200,
                    responseHeaders = {
                        @ResponseHeader(name = "x-v", response = Integer.class, description = "The [version](#response-headers) of the API endpoint that the data holder has responded with."),
                        @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction.")
                    },
                    message = "Successful response",
                    response = EnergyServicePointDetailResponse.class),
            @ApiResponse(code = 400,
                    responseHeaders = @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction."),
                    message = "Invalid Version / Missing Field / Invalid Field",
                    response = ErrorListResponse.class),
            @ApiResponse(code = 406,
                    responseHeaders = @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction."),
                    message = "Unsupported Version",
                    response = ErrorListResponse.class),
            @ApiResponse(code = 404,
                    responseHeaders = @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction."),
                    message = "Unavailable Service Point / Invalid Service Point",
                    response = ErrorListResponse.class)
    })
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/energy/electricity/servicepoints/{servicePointId}",
            produces = {"application/json"}
    )
    @PreAuthorize("hasAuthority('SCOPE_energy:electricity.servicepoints.detail:read')")
    ResponseEntity<EnergyServicePointDetailResponse> getServicePoint(
            @ApiParam(
                    value = "ID of the specific service point requested.  This is a tokenised ID previous obtained from the Service Point List Data end point.  Note that it is not a nationalMeteringId.",
                    required = true)
            @PathVariable("servicePointId")
                    String servicePointId,
            @ApiParam(
                    value = "Version of the API endpoint requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [_x-min-v_](#request-headers) and [_x-v_](#request-headers). If the value of [_x-min-v_](#request-headers) is equal to or higher than the value of [_x-v_](#request-headers) then the [_x-min-v_](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder **MUST** respond with a `406 Not Acceptable`. See [HTTP Headers](#request-headers).",
                    required = true)
            @RequestHeader(value = "x-v", required = false)
                    Integer xV,
            @ApiParam(
                    value = "Minimum version of the API endpoint requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [_x-min-v_](#request-headers) and [_x-v_](#request-headers). If all versions requested are not supported then the data holder **MUST** respond with a `406 Not Acceptable`.")
            @RequestHeader(value = "x-min-v",
                    required = false)
                    Integer xMinV,
            @ApiParam(
                    value = "An [RFC4122](https://tools.ietf.org/html/rfc4122) UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction.")
            @RequestHeader(value = "x-fapi-interaction-id",
                    required = false)
                    UUID xFapiInteractionId,
            @ApiParam(
                    value = "The time when the customer last logged in to the Data Recipient Software Product as described in **[[FAPI-1.0-Baseline]](#nref-FAPI-1-0-Baseline)**. Required for all resource calls (customer present and unattended). Not required for unauthenticated calls.")
            @RequestHeader(value = "x-fapi-auth-date",
                    required = false)
                    @NotNull @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, fallbackPatterns = DateFormat.HTTP) Date xFapiAuthDate,
            @ApiParam(
                    value = "The customer's original IP address if the customer is currently logged in to the data recipient. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls.")
            @RequestHeader(
                    value = "x-fapi-customer-ip-address",
                    required = false)
                    String xFapiCustomerIpAddress,
            @ApiParam(
                    value = "The customer's original standard http headers [Base64](#common-field-types) encoded, including the original User Agent header, if the customer is currently logged in to the data recipient. Mandatory for customer present calls.  Not required for unattended or unauthenticated calls.")
            @RequestHeader(value = "x-cds-client-headers",
                    required = false)
                    String xCdsClientHeaders);


    /**
     * GET /energy/electricity/servicepoints/{servicePointId}/usage : Get Usage For Service Point
     * Obtain a list of electricity usage data from a particular service point
     *
     * @param servicePointId         ID of the specific service point requested.  This is a tokenised ID previous obtained from the Service Point List Data end point.  Note that it is not a nationalMeteringId. (required)
     * @param xV                     Version of the API endpoint requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [_x-min-v_](#request-headers) and [_x-v_](#request-headers). If the value of [_x-min-v_](#request-headers) is equal to or higher than the value of [_x-v_](#request-headers) then the [_x-min-v_](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder **MUST** respond with a `406 Not Acceptable`. See [HTTP Headers](#request-headers). (required)
     * @param oldestDate             Constrain the request to records with effective date at or after this date. If absent defaults to newest-date minus 24 months.  Format is aligned to DateString common type (optional)
     * @param newestDate             Constrain the request to records with effective date at or before this date.  If absent defaults to current date.  Format is aligned to DateString common type (optional)
     * @param intervalReads          Type of interval reads. Any one of the valid values for this field can be supplied. If absent defaults to NONE
     * @param page                   Page of results to request (standard pagination) (optional)
     * @param pageSize               Page size to request.  Default is 25 (standard pagination) (optional)
     * @param xMinV                  Minimum version of the API endpoint requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [_x-min-v_](#request-headers) and [_x-v_](#request-headers). If all versions requested are not supported then the data holder **MUST** respond with a `406 Not Acceptable`. (optional)
     * @param xFapiInteractionId     An [RFC4122](https://tools.ietf.org/html/rfc4122) UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction. (optional)
     * @param xFapiAuthDate          The time when the customer last logged in to the Data Recipient Software Product as described in **[[FAPI-1.0-Baseline]](#nref-FAPI-1-0-Baseline)**. Required for all resource calls (customer present and unattended). Not required for unauthenticated calls. (optional)
     * @param xFapiCustomerIpAddress The customer's original IP address if the customer is currently logged in to the data recipient. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls. (optional)
     * @param xCdsClientHeaders      The customer's original standard http headers [Base64](#common-field-types) encoded, including the original User Agent header, if the customer is currently logged in to the data recipient. Mandatory for customer present calls.  Not required for unattended or unauthenticated calls. (optional)
     * @return Successful response (status code 200)
     * or The following error codes MUST be supported:<br><ul class="error-code-list"><li>[400 - Invalid Field](#error-400-field-invalid)</li><li>[400 - Missing Required Field](#error-400-field-missing)</li><li>[400 - Invalid Page Size](#error-400-field-invalid-page-size)</li><li>[400 - Invalid Version](#error-400-header-invalid-version)</li><li>[406 - Unsupported Version](#error-406-header-unsupported-version)</li><li>[422 - Invalid Page](#error-422-field-invalid-page)</li><li>[404 - Unavailable Service Point](#error-404-unavailable-service-point)</li><li>[404 - Invalid Service Point](#error-404-invalid-service-point)</li></ul> (status code 4xx)
     */
    @ApiOperation(value = "Get Usage For Service Point",
            nickname = "getUsageForServicePoint",
            notes = "Obtain a list of electricity usage data from a particular service point",
            response = EnergyUsageListResponse.class,
            tags = {"Energy", "Electricity Usage",})
    @ApiResponses(value = {
            @ApiResponse(code = 200,
                    responseHeaders = {
                        @ResponseHeader(name = "x-v", response = Integer.class, description = "The [version](#response-headers) of the API endpoint that the data holder has responded with."),
                        @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction.")
                    },
                    message = "Successful response",
                    response = EnergyUsageListResponse.class),
            @ApiResponse(code = 400,
                    responseHeaders = @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction."),
                    message = "Invalid Version / Missing Field / Invalid Field / Invalid Page Size",
                    response = ErrorListResponse.class),
            @ApiResponse(code = 406,
                    responseHeaders = @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction."),
                    message = "Unsupported Version",
                    response = ErrorListResponse.class),
            @ApiResponse(code = 404,
                    responseHeaders = @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction."),
                    message = "Unavailable Service Point / Invalid Service Point",
                    response = ErrorListResponse.class),
            @ApiResponse(code = 422,
                    responseHeaders = @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction."),
                    message = "Invalid Page",
                    response = ErrorListResponse.class)
    })
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/energy/electricity/servicepoints/{servicePointId}/usage",
            produces = {"application/json"}
    )
    @PreAuthorize("hasAuthority('SCOPE_energy:electricity.usage:read')")
    ResponseEntity<EnergyUsageListResponse> getUsageForServicePoint(
            @ApiParam(
                    value = "ID of the specific service point requested.  This is a tokenised ID previous obtained from the Service Point List Data end point.  Note that it is not a nationalMeteringId.",
                    required = true)
            @PathVariable("servicePointId")
                    String servicePointId,
            @ApiParam(
                    value = "Version of the API endpoint requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [_x-min-v_](#request-headers) and [_x-v_](#request-headers). If the value of [_x-min-v_](#request-headers) is equal to or higher than the value of [_x-v_](#request-headers) then the [_x-min-v_](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder **MUST** respond with a `406 Not Acceptable`. See [HTTP Headers](#request-headers).",
                    required = true)
            @RequestHeader(value = "x-v", required = false)
                    Integer xV,
            @ApiParam(
                    value = "Minimum version of the API endpoint requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [_x-min-v_](#request-headers) and [_x-v_](#request-headers). If all versions requested are not supported then the data holder **MUST** respond with a `406 Not Acceptable`.")
            @RequestHeader(value = "x-min-v",
                    required = false)
                    Integer xMinV,
            @ApiParam(
                    value = "Constrain the request to records with effective date at or after this date. If absent defaults to newest-date minus 24 months.  Format is aligned to DateString common type")
            @Valid
            @RequestParam(value = "oldest-date",
                    required = false)
                    LocalDate oldestDate,
            @ApiParam(
                    value = "Constrain the request to records with effective date at or before this date.  If absent defaults to current date.  Format is aligned to DateString common type")
            @Valid
            @RequestParam(value = "newest-date",
                    required = false)
                    LocalDate newestDate,
            @ApiParam(
                    value = "Type of interval reads. Any one of the valid values for this field can be supplied. If absent defaults to NONE")
            @Valid
            @RequestParam(value = "interval-reads",
                    defaultValue = "NONE")
                    ParamIntervalReadsEnum intervalReads,
            @ApiParam(value = "Page of results to request (standard pagination)")
            @Valid
            @RequestParam(value = "page",
                    required = false)
                    Integer page,
            @ApiParam(
                    value = "Page size to request.  Default is 25 (standard pagination)")
            @Valid
            @RequestParam(value = "page-size",
                    required = false)
                    Integer pageSize,
            @ApiParam(
                    value = "An [RFC4122](https://tools.ietf.org/html/rfc4122) UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction.")
            @RequestHeader(value = "x-fapi-interaction-id",
                    required = false)
                    UUID xFapiInteractionId,
            @ApiParam(
                    value = "The time when the customer last logged in to the Data Recipient Software Product as described in **[[FAPI-1.0-Baseline]](#nref-FAPI-1-0-Baseline)**. Required for all resource calls (customer present and unattended). Not required for unauthenticated calls.")
            @RequestHeader(value = "x-fapi-auth-date",
                    required = false)
            @NotNull @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, fallbackPatterns = DateFormat.HTTP) Date xFapiAuthDate,
            @ApiParam(
                    value = "The customer's original IP address if the customer is currently logged in to the data recipient. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls.")
            @RequestHeader(value = "x-fapi-customer-ip-address",
                    required = false)
                    String xFapiCustomerIpAddress,
            @ApiParam(
                    value = "The customer's original standard http headers [Base64](#common-field-types) encoded, including the original User Agent header, if the customer is currently logged in to the data recipient. Mandatory for customer present calls.  Not required for unattended or unauthenticated calls.")
            @RequestHeader(value = "x-cds-client-headers",
                    required = false)
                    String xCdsClientHeaders);

    /**
     * GET /energy/accounts : Get Energy Accounts
     * Obtain the list of energy accounts available under the authorised consent
     *
     * @param openStatus             Used to filter results according to open/closed status. Values can be OPEN, CLOSED or ALL. If absent then ALL is assumed (optional)
     * @param xV                     Version of the API endpoint requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [_x-min-v_](#request-headers) and [_x-v_](#request-headers). If the value of [_x-min-v_](#request-headers) is equal to or higher than the value of [_x-v_](#request-headers) then the [_x-min-v_](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder **MUST** respond with a `406 Not Acceptable`. See [HTTP Headers](#request-headers). (required)
     * @param page                   Page of results to request (standard pagination) (optional)
     * @param pageSize               Page size to request.  Default is 25 (standard pagination) (optional)
     * @param xMinV                  Minimum version of the API endpoint requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [_x-min-v_](#request-headers) and [_x-v_](#request-headers). If all versions requested are not supported then the data holder **MUST** respond with a `406 Not Acceptable`. (optional)
     * @param xFapiInteractionId     An [RFC4122](https://tools.ietf.org/html/rfc4122) UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction. (optional)
     * @param xFapiAuthDate          The time when the customer last logged in to the Data Recipient Software Product as described in **[[FAPI-1.0-Baseline]](#nref-FAPI-1-0-Baseline)**. Required for all resource calls (customer present and unattended). Not required for unauthenticated calls. (optional)
     * @param xFapiCustomerIpAddress The customer's original IP address if the customer is currently logged in to the data recipient. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls. (optional)
     * @param xCdsClientHeaders      The customer's original standard http headers [Base64](#common-field-types) encoded, including the original User Agent header, if the customer is currently logged in to the data recipient. Mandatory for customer present calls.  Not required for unattended or unauthenticated calls. (optional)
     * @return Successful response (status code 200)
     * or The following error codes MUST be supported:<br><ul class="error-code-list"><li>[400 - Invalid Field](#error-400-field-invalid)</li><li>[400 - Missing Required Field](#error-400-field-missing)</li><li>[400 - Invalid Page Size](#error-400-field-invalid-page-size)</li><li>[400 - Invalid Version](#error-400-header-invalid-version)</li><li>[406 - Unsupported Version](#error-406-header-unsupported-version)</li><li>[422 - Invalid Page](#error-422-field-invalid-page)</li></ul> (status code 4xx)
     */
    @ApiOperation(value = "Get Energy Accounts",
            nickname = "listAccounts",
            notes = "Obtain the list of energy accounts available under the authorised consent",
            response = EnergyAccountListResponse.class,
            tags = {"Energy", "Energy Accounts",})
    @ApiResponses(value = {
            @ApiResponse(code = 200,
                    responseHeaders = {
                        @ResponseHeader(name = "x-v", response = Integer.class, description = "The [version](#response-headers) of the API endpoint that the data holder has responded with."),
                        @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction.")
                    },
                    message = "Successful response",
                    response = EnergyAccountListResponse.class),
            @ApiResponse(code = 400,
                    responseHeaders = @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction."),
                    message = "Invalid Version / Missing Field / Invalid Field / Invalid Page Size",
                    response = ErrorListResponse.class),
            @ApiResponse(code = 406,
                    responseHeaders = @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction."),
                    message = "Unsupported Version",
                    response = ErrorListResponse.class),
            @ApiResponse(code = 422,
                    responseHeaders = @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction."),
                    message = "Invalid Page",
                    response = ErrorListResponse.class)
    })
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/energy/accounts",
            produces = {"application/json"}
    )
    @PreAuthorize("hasAuthority('SCOPE_energy:accounts.basic:read')")
    ResponseEntity<EnergyAccountListResponse> listAccounts(
            @ApiParam(
                    value="Used to filter results according to open/closed status. Values can be OPEN, CLOSED or ALL. If absent then ALL is assumed")
            @RequestParam(value = "open-status",
                    required = false,
                    defaultValue = "ALL")
            ParamAccountOpenStatus openStatus,
            @ApiParam(
                    value = "Version of the API endpoint requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [_x-min-v_](#request-headers) and [_x-v_](#request-headers). If the value of [_x-min-v_](#request-headers) is equal to or higher than the value of [_x-v_](#request-headers) then the [_x-min-v_](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder **MUST** respond with a `406 Not Acceptable`. See [HTTP Headers](#request-headers).",
                    required = true)
            @RequestHeader(value = "x-v", required = false)
                    Integer xV,
            @ApiParam(
                    value = "Page of results to request (standard pagination)")
            @Valid
            @RequestParam(value = "page",
                    required = false)
                    Integer page,
            @ApiParam(
                    value = "Page size to request.  Default is 25 (standard pagination)")
            @Valid
            @RequestParam(value = "page-size",
                    required = false)
                    Integer pageSize,
            @ApiParam(
                    value = "Minimum version of the API endpoint requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [_x-min-v_](#request-headers) and [_x-v_](#request-headers). If all versions requested are not supported then the data holder **MUST** respond with a `406 Not Acceptable`.")
            @RequestHeader(value = "x-min-v",
                    required = false)
                    Integer xMinV,
            @ApiParam(
                    value = "An [RFC4122](https://tools.ietf.org/html/rfc4122) UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction.")
            @RequestHeader(value = "x-fapi-interaction-id",
                    required = false)
                    UUID xFapiInteractionId,
            @ApiParam(
                    value = "The time when the customer last logged in to the Data Recipient Software Product as described in **[[FAPI-1.0-Baseline]](#nref-FAPI-1-0-Baseline)**. Required for all resource calls (customer present and unattended). Not required for unauthenticated calls.")
            @RequestHeader(value = "x-fapi-auth-date",
                    required = false)
                    @NotNull @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, fallbackPatterns = DateFormat.HTTP) Date xFapiAuthDate,
            @ApiParam(
                    value = "The customer's original IP address if the customer is currently logged in to the data recipient. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls.")
            @RequestHeader(value = "x-fapi-customer-ip-address",
                    required = false)
                    String xFapiCustomerIpAddress,
            @ApiParam(
                    value = "The customer's original standard http headers [Base64](#common-field-types) encoded, including the original User Agent header, if the customer is currently logged in to the data recipient. Mandatory for customer present calls.  Not required for unattended or unauthenticated calls.")
            @RequestHeader(value = "x-cds-client-headers",
                    required = false)
                    String xCdsClientHeaders);


    /**
     * GET /energy/accounts/balances : Get Bulk Balances for Energy
     * Obtain the current balance for all accounts
     *
     * @param xV                     Version of the API endpoint requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [_x-min-v_](#request-headers) and [_x-v_](#request-headers). If the value of [_x-min-v_](#request-headers) is equal to or higher than the value of [_x-v_](#request-headers) then the [_x-min-v_](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder **MUST** respond with a `406 Not Acceptable`. See [HTTP Headers](#request-headers). (required)
     * @param page                   Page of results to request (standard pagination) (optional)
     * @param pageSize               Page size to request.  Default is 25 (standard pagination) (optional)
     * @param xMinV                  Minimum version of the API endpoint requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [_x-min-v_](#request-headers) and [_x-v_](#request-headers). If all versions requested are not supported then the data holder **MUST** respond with a `406 Not Acceptable`. (optional)
     * @param xFapiInteractionId     An [RFC4122](https://tools.ietf.org/html/rfc4122) UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction. (optional)
     * @param xFapiAuthDate          The time when the customer last logged in to the Data Recipient Software Product as described in **[[FAPI-1.0-Baseline]](#nref-FAPI-1-0-Baseline)**. Required for all resource calls (customer present and unattended). Not required for unauthenticated calls. (optional)
     * @param xFapiCustomerIpAddress The customer's original IP address if the customer is currently logged in to the data recipient. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls. (optional)
     * @param xCdsClientHeaders      The customer's original standard http headers [Base64](#common-field-types) encoded, including the original User Agent header, if the customer is currently logged in to the data recipient. Mandatory for customer present calls.  Not required for unattended or unauthenticated calls. (optional)
     * @return Successful response (status code 200)
     * or The following error codes MUST be supported:<br><ul class="error-code-list"><li>[400 - Invalid Field](#error-400-field-invalid)</li><li>[400 - Missing Required Field](#error-400-field-missing)</li><li>[400 - Invalid Page Size](#error-400-field-invalid-page-size)</li><li>[400 - Invalid Version](#error-400-header-invalid-version)</li><li>[406 - Unsupported Version](#error-406-header-unsupported-version)</li><li>[422 - Invalid Page](#error-422-field-invalid-page)</li></ul> (status code 4xx)
     */
    @ApiOperation(value = "Get Bulk Balances for Energy",
            nickname = "listBalancesBulk",
            notes = "Obtain the current balance for all accounts",
            response = EnergyBalanceListResponse.class,
            tags = {"Energy", "Billing",})
    @ApiResponses(value = {
            @ApiResponse(code = 200,
                    responseHeaders = {
                        @ResponseHeader(name = "x-v", response = Integer.class, description = "The [version](#response-headers) of the API endpoint that the data holder has responded with."),
                        @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction.")
                    },
                    message = "Successful response",
                    response = EnergyBalanceListResponse.class),
            @ApiResponse(code = 400,
                    responseHeaders = @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction."),
                    message = "Invalid Version / Missing Field / Invalid Field / Invalid Page Size",
                    response = ErrorListResponse.class),
            @ApiResponse(code = 406,
                    responseHeaders = @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction."),
                    message = "Unsupported Version",
                    response = ErrorListResponse.class),
            @ApiResponse(code = 422,
                    responseHeaders = @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction."),
                    message = "Invalid Page",
                    response = ErrorListResponse.class)
    })
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/energy/accounts/balances",
            produces = {"application/json"}
    )
    @PreAuthorize("hasAuthority('SCOPE_energy:billing:read')")
    ResponseEntity<EnergyBalanceListResponse> listBalancesBulk(
            @ApiParam(
                    value = "Version of the API endpoint requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [_x-min-v_](#request-headers) and [_x-v_](#request-headers). If the value of [_x-min-v_](#request-headers) is equal to or higher than the value of [_x-v_](#request-headers) then the [_x-min-v_](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder **MUST** respond with a `406 Not Acceptable`. See [HTTP Headers](#request-headers).",
                    required = true)
            @RequestHeader(value = "x-v", required = false)
                    Integer xV,
            @ApiParam(
                    value = "Minimum version of the API endpoint requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [_x-min-v_](#request-headers) and [_x-v_](#request-headers). If all versions requested are not supported then the data holder **MUST** respond with a `406 Not Acceptable`.")
            @RequestHeader(value = "x-min-v",
                    required = false)
                    Integer xMinV,
            @ApiParam(
                    value = "Page of results to request (standard pagination)")
            @Valid
            @RequestParam(value = "page",
                    required = false)
                    Integer page,
            @ApiParam(
                    value = "Page size to request.  Default is 25 (standard pagination)")
            @Valid
            @RequestParam(value = "page-size",
                    required = false)
                    Integer pageSize,
            @ApiParam(
                    value = "An [RFC4122](https://tools.ietf.org/html/rfc4122) UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction.")
            @RequestHeader(value = "x-fapi-interaction-id",
                    required = false)
                    UUID xFapiInteractionId,
            @ApiParam(
                    value = "The time when the customer last logged in to the Data Recipient Software Product as described in **[[FAPI-1.0-Baseline]](#nref-FAPI-1-0-Baseline)**. Required for all resource calls (customer present and unattended). Not required for unauthenticated calls.")
            @RequestHeader(value = "x-fapi-auth-date",
                    required = false)
                    @NotNull @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, fallbackPatterns = DateFormat.HTTP) Date xFapiAuthDate,
            @ApiParam(
                    value = "The customer's original IP address if the customer is currently logged in to the data recipient. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls.")
            @RequestHeader(value = "x-fapi-customer-ip-address",
                    required = false)
                    String xFapiCustomerIpAddress,
            @ApiParam(
                    value = "The customer's original standard http headers [Base64](#common-field-types) encoded, including the original User Agent header, if the customer is currently logged in to the data recipient. Mandatory for customer present calls.  Not required for unattended or unauthenticated calls.")
            @RequestHeader(value = "x-cds-client-headers",
                    required = false)
                    String xCdsClientHeaders);


    /**
     * POST /energy/accounts/balances : Get Balances For Specific Energy Accounts
     * Obtain the current balance for a specified set of accounts
     *
     * @param xV                     Version of the API endpoint requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [_x-min-v_](#request-headers) and [_x-v_](#request-headers). If the value of [_x-min-v_](#request-headers) is equal to or higher than the value of [_x-v_](#request-headers) then the [_x-min-v_](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder **MUST** respond with a `406 Not Acceptable`. See [HTTP Headers](#request-headers). (required)
     * @param accountIdList          Request payload containing list of specific Accounts to obtain data for (required)
     * @param page                   Page of results to request (standard pagination) (optional)
     * @param pageSize               Page size to request.  Default is 25 (standard pagination) (optional)
     * @param xMinV                  Minimum version of the API endpoint requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [_x-min-v_](#request-headers) and [_x-v_](#request-headers). If all versions requested are not supported then the data holder **MUST** respond with a `406 Not Acceptable`. (optional)
     * @param xFapiInteractionId     An [RFC4122](https://tools.ietf.org/html/rfc4122) UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction. (optional)
     * @param xFapiAuthDate          The time when the customer last logged in to the Data Recipient Software Product as described in **[[FAPI-1.0-Baseline]](#nref-FAPI-1-0-Baseline)**. Required for all resource calls (customer present and unattended). Not required for unauthenticated calls. (optional)
     * @param xFapiCustomerIpAddress The customer's original IP address if the customer is currently logged in to the data recipient. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls. (optional)
     * @param xCdsClientHeaders      The customer's original standard http headers [Base64](#common-field-types) encoded, including the original User Agent header, if the customer is currently logged in to the data recipient. Mandatory for customer present calls.  Not required for unattended or unauthenticated calls. (optional)
     * @return Successful response (status code 200)
     * or The following error codes MUST be supported:<br><ul class="error-code-list"><li>[400 - Invalid Field](#error-400-field-invalid)</li><li>[400 - Missing Required Field](#error-400-field-missing)</li><li>[400 - Invalid Page Size](#error-400-field-invalid-page-size)</li><li>[400 - Invalid Version](#error-400-header-invalid-version)</li><li>[406 - Unsupported Version](#error-406-header-unsupported-version)</li><li>[422 - Invalid Page](#error-422-field-invalid-page)</li><li>[422 - Unavailable Energy Account](#error-422-unavailable-energy-account)</li><li>[422 - Invalid Energy Account](#error-422-invalid-energy-account)</li></ul> (status code 4xx)
     */
    @ApiOperation(value = "Get Balances For Specific Energy Accounts",
            nickname = "listBalancesForAccounts",
            notes = "Obtain the current balance for a specified set of accounts",
            response = EnergyBalanceListResponse.class,
            tags = {"Energy", "Billing",})
    @ApiResponses(value = {
            @ApiResponse(code = 200,
                    responseHeaders = {
                        @ResponseHeader(name = "x-v", response = Integer.class, description = "The [version](#response-headers) of the API endpoint that the data holder has responded with."),
                        @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction.")
                    },
                    message = "Successful response",
                    response = EnergyBalanceListResponse.class),
            @ApiResponse(code = 400,
                    responseHeaders = @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction."),
                    message = "Invalid Version / Invalid Page Size / Missing Field / Invalid Field",
                    response = ErrorListResponse.class),
            @ApiResponse(code = 406,
                    responseHeaders = @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction."),
                    message = "Unsupported Version",
                    response = ErrorListResponse.class),
            @ApiResponse(code = 422,
                    responseHeaders = @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction."),
                    message = "Invalid Energy Account / Unavailable Energy Account / Invalid Page",
                    response = ErrorListResponse.class)
    })
    @RequestMapping(
            method = RequestMethod.POST,
            value = "/energy/accounts/balances",
            produces = {"application/json"},
            consumes = {"application/json"}
    )
    @PreAuthorize("hasAuthority('SCOPE_energy:billing:read')")
    ResponseEntity<EnergyBalanceListResponse> listBalancesForAccounts(
            @ApiParam(
                    value = "Version of the API endpoint requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [_x-min-v_](#request-headers) and [_x-v_](#request-headers). If the value of [_x-min-v_](#request-headers) is equal to or higher than the value of [_x-v_](#request-headers) then the [_x-min-v_](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder **MUST** respond with a `406 Not Acceptable`. See [HTTP Headers](#request-headers).",
                    required = true)
            @RequestHeader(value = "x-v", required = false)
                    Integer xV,
            @ApiParam(
                    value = "Minimum version of the API endpoint requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [_x-min-v_](#request-headers) and [_x-v_](#request-headers). If all versions requested are not supported then the data holder **MUST** respond with a `406 Not Acceptable`.")
            @RequestHeader(value = "x-min-v",
                    required = false)
                    Integer xMinV,
            @ApiParam(
                    value = "Request payload containing list of specific Accounts to obtain data for",
                    required = true)
            @Valid
            @RequestBody
                    RequestAccountIds accountIdList,
            @ApiParam(
                    value = "Page of results to request (standard pagination)")
            @Valid
            @RequestParam(value = "page",
                    required = false)
                    Integer page,
            @ApiParam(
                    value = "Page size to request.  Default is 25 (standard pagination)")
            @Valid
            @RequestParam(value = "page-size",
                    required = false)
                    Integer pageSize,
            @ApiParam(
                    value = "An [RFC4122](https://tools.ietf.org/html/rfc4122) UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction.")
            @RequestHeader(value = "x-fapi-interaction-id",
                    required = false)
                    UUID xFapiInteractionId,
            @ApiParam(
                    value = "The time when the customer last logged in to the Data Recipient Software Product as described in **[[FAPI-1.0-Baseline]](#nref-FAPI-1-0-Baseline)**. Required for all resource calls (customer present and unattended). Not required for unauthenticated calls.")
            @RequestHeader(value = "x-fapi-auth-date",
                    required = false)
                    @NotNull @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, fallbackPatterns = DateFormat.HTTP) Date xFapiAuthDate,
            @ApiParam(
                    value = "The customer's original IP address if the customer is currently logged in to the data recipient. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls.")
            @RequestHeader(
                    value = "x-fapi-customer-ip-address",
                    required = false)
                    String xFapiCustomerIpAddress,
            @ApiParam(
                    value = "The customer's original standard http headers [Base64](#common-field-types) encoded, including the original User Agent header, if the customer is currently logged in to the data recipient. Mandatory for customer present calls.  Not required for unattended or unauthenticated calls.")
            @RequestHeader(value = "x-cds-client-headers",
                    required = false)
                    String xCdsClientHeaders);


    /**
     * GET /energy/accounts/billing : Get Bulk Billing
     * Obtain billing transactions for all accounts
     *
     * @param xV                     Version of the API endpoint requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [_x-min-v_](#request-headers) and [_x-v_](#request-headers). If the value of [_x-min-v_](#request-headers) is equal to or higher than the value of [_x-v_](#request-headers) then the [_x-min-v_](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder **MUST** respond with a `406 Not Acceptable`. See [HTTP Headers](#request-headers). (required)
     * @param newestTime             Constrain the request to records with effective time at or before this date/time.  If absent defaults to current date/time.  Format is aligned to DateTimeString common type (optional)
     * @param oldestTime             Constrain the request to records with effective time at or after this date/time. If absent defaults to newest-time minus 12 months.  Format is aligned to DateTimeString common type (optional)
     * @param page                   Page of results to request (standard pagination) (optional)
     * @param pageSize               Page size to request.  Default is 25 (standard pagination) (optional)
     * @param xMinV                  Minimum version of the API endpoint requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [_x-min-v_](#request-headers) and [_x-v_](#request-headers). If all versions requested are not supported then the data holder **MUST** respond with a `406 Not Acceptable`. (optional)
     * @param xFapiInteractionId     An [RFC4122](https://tools.ietf.org/html/rfc4122) UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction. (optional)
     * @param xFapiAuthDate          The time when the customer last logged in to the Data Recipient Software Product as described in **[[FAPI-1.0-Baseline]](#nref-FAPI-1-0-Baseline)**. Required for all resource calls (customer present and unattended). Not required for unauthenticated calls. (optional)
     * @param xFapiCustomerIpAddress The customer's original IP address if the customer is currently logged in to the data recipient. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls. (optional)
     * @param xCdsClientHeaders      The customer's original standard http headers [Base64](#common-field-types) encoded, including the original User Agent header, if the customer is currently logged in to the data recipient. Mandatory for customer present calls.  Not required for unattended or unauthenticated calls. (optional)
     * @return Successful response (status code 200)
     * or The following error codes MUST be supported:<br><ul class="error-code-list"><li>[400 - Invalid Field](#error-400-field-invalid)</li><li>[400 - Missing Required Field](#error-400-field-missing)</li><li>[400 - Invalid Page Size](#error-400-field-invalid-page-size)</li><li>[400 - Invalid Version](#error-400-header-invalid-version)</li><li>[406 - Unsupported Version](#error-406-header-unsupported-version)</li><li>[422 - Invalid Page](#error-422-field-invalid-page)</li></ul> (status code 4xx)
     */
    @ApiOperation(value = "Get Bulk Billing",
            nickname = "listBillingBulk",
            notes = "Obtain billing transactions for all accounts",
            response = EnergyBillingListResponse.class,
            tags = {"Energy", "Billing",})
    @ApiResponses(value = {
            @ApiResponse(code = 200,
                    responseHeaders = {
                        @ResponseHeader(name = "x-v", response = Integer.class, description = "The [version](#response-headers) of the API endpoint that the data holder has responded with."),
                        @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction.")
                    },
                    message = "Successful response",
                    response = EnergyBillingListResponse.class),
            @ApiResponse(code = 400,
                    responseHeaders = @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction."),
                    message = "Invalid Version / Missing Field / Invalid Field / Invalid Page Size / Invalid Date",
                    response = ErrorListResponse.class),
            @ApiResponse(code = 406,
                    responseHeaders = @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction."),
                    message = "Unsupported Version",
                    response = ErrorListResponse.class),
            @ApiResponse(code = 422,
                    responseHeaders = @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction."),
                    message = "Invalid Page",
                    response = ErrorListResponse.class)
    })
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/energy/accounts/billing",
            produces = {"application/json"}
    )
    @PreAuthorize("hasAuthority('SCOPE_energy:billing:read')")
    ResponseEntity<EnergyBillingListResponse> listBillingBulk(
            @ApiParam(
                    value = "Version of the API endpoint requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [_x-min-v_](#request-headers) and [_x-v_](#request-headers). If the value of [_x-min-v_](#request-headers) is equal to or higher than the value of [_x-v_](#request-headers) then the [_x-min-v_](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder **MUST** respond with a `406 Not Acceptable`. See [HTTP Headers](#request-headers).",
                    required = true)
            @RequestHeader(value = "x-v", required = false)
                    Integer xV,
            @ApiParam(
                    value = "Minimum version of the API endpoint requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [_x-min-v_](#request-headers) and [_x-v_](#request-headers). If all versions requested are not supported then the data holder **MUST** respond with a `406 Not Acceptable`.")
            @RequestHeader(value = "x-min-v",
                    required = false)
                    Integer xMinV,
            @ApiParam(
                    value = "Constrain the request to records with effective time at or before this date/time.  If absent defaults to current date/time.  Format is aligned to DateTimeString common type")
            @Valid
            @RequestParam(value = "newest-time",
                    required = false)
                    OffsetDateTime newestTime,
            @ApiParam(
                    value = "Constrain the request to records with effective time at or after this date/time. If absent defaults to newest-time minus 12 months.  Format is aligned to DateTimeString common type")
            @Valid
            @RequestParam(value = "oldest-time",
                    required = false)
                    OffsetDateTime oldestTime,
            @ApiParam(
                    value = "Page of results to request (standard pagination)")
            @Valid
            @RequestParam(value = "page",
                    required = false)
                    Integer page,
            @ApiParam(
                    value = "Page size to request.  Default is 25 (standard pagination)")
            @Valid
            @RequestParam(value = "page-size",
                    required = false)
                    Integer pageSize,
            @ApiParam(
                    value = "An [RFC4122](https://tools.ietf.org/html/rfc4122) UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction.")
            @RequestHeader(value = "x-fapi-interaction-id",
                    required = false)
                    UUID xFapiInteractionId,
            @ApiParam(
                    value = "The time when the customer last logged in to the Data Recipient Software Product as described in **[[FAPI-1.0-Baseline]](#nref-FAPI-1-0-Baseline)**. Required for all resource calls (customer present and unattended). Not required for unauthenticated calls.")
            @RequestHeader(value = "x-fapi-auth-date",
                    required = false)
                    @NotNull @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, fallbackPatterns = DateFormat.HTTP) Date xFapiAuthDate,
            @ApiParam(
                    value = "The customer's original IP address if the customer is currently logged in to the data recipient. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls.")
            @RequestHeader(value = "x-fapi-customer-ip-address",
                    required = false)
                    String xFapiCustomerIpAddress,
            @ApiParam(
                    value = "The customer's original standard http headers [Base64](#common-field-types) encoded, including the original User Agent header, if the customer is currently logged in to the data recipient. Mandatory for customer present calls.  Not required for unattended or unauthenticated calls.")
            @RequestHeader(value = "x-cds-client-headers",
                    required = false)
                    String xCdsClientHeaders);


    /**
     * POST /energy/accounts/billing : Get Billing For Specific Accounts
     * Obtain billing for a specified set of accounts
     *
     * @param xV                     Version of the API endpoint requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [_x-min-v_](#request-headers) and [_x-v_](#request-headers). If the value of [_x-min-v_](#request-headers) is equal to or higher than the value of [_x-v_](#request-headers) then the [_x-min-v_](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder **MUST** respond with a `406 Not Acceptable`. See [HTTP Headers](#request-headers). (required)
     * @param accountIdList          Request payload containing list of specific Accounts to obtain data for (required)
     * @param newestTime             Constrain the request to records with effective time at or before this date/time.  If absent defaults to current date/time.  Format is aligned to DateTimeString common type (optional)
     * @param oldestTime             Constrain the request to records with effective time at or after this date/time. If absent defaults to newest-time minus 12 months.  Format is aligned to DateTimeString common type (optional)
     * @param page                   Page of results to request (standard pagination) (optional)
     * @param pageSize               Page size to request.  Default is 25 (standard pagination) (optional)
     * @param xMinV                  Minimum version of the API endpoint requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [_x-min-v_](#request-headers) and [_x-v_](#request-headers). If all versions requested are not supported then the data holder **MUST** respond with a `406 Not Acceptable`. (optional)
     * @param xFapiInteractionId     An [RFC4122](https://tools.ietf.org/html/rfc4122) UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction. (optional)
     * @param xFapiAuthDate          The time when the customer last logged in to the Data Recipient Software Product as described in **[[FAPI-1.0-Baseline]](#nref-FAPI-1-0-Baseline)**. Required for all resource calls (customer present and unattended). Not required for unauthenticated calls. (optional)
     * @param xFapiCustomerIpAddress The customer's original IP address if the customer is currently logged in to the data recipient. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls. (optional)
     * @param xCdsClientHeaders      The customer's original standard http headers [Base64](#common-field-types) encoded, including the original User Agent header, if the customer is currently logged in to the data recipient. Mandatory for customer present calls.  Not required for unattended or unauthenticated calls. (optional)
     * @param intervalReads          Type of interval reads. Any one of the valid values for this field can be supplied. If absent defaults to NONE
     * @return Successful response (status code 200)
     * or The following error codes MUST be supported:<br><ul class="error-code-list"><li>[400 - Invalid Field](#error-400-field-invalid)</li><li>[400 - Missing Required Field](#error-400-field-missing)</li><li>[400 - Invalid Page Size](#error-400-field-invalid-page-size)</li><li>[400 - Invalid Version](#error-400-header-invalid-version)</li><li>[406 - Unsupported Version](#error-406-header-unsupported-version)</li><li>[422 - Invalid Page](#error-422-field-invalid-page)</li><li>[422 - Unavailable Energy Account](#error-422-unavailable-energy-account)</li><li>[422 - Invalid Energy Account](#error-422-invalid-energy-account)</li></ul> (status code 4xx)
     */
    @ApiOperation(value = "Get Billing For Specific Accounts",
            nickname = "listBillingForAccounts",
            notes = "Obtain billing for a specified set of accounts",
            response = EnergyBillingListResponse.class,
            tags = {"Energy", "Billing",})
    @ApiResponses(value = {
            @ApiResponse(code = 200,
                    responseHeaders = {
                        @ResponseHeader(name = "x-v", response = Integer.class, description = "The [version](#response-headers) of the API endpoint that the data holder has responded with."),
                        @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction.")
                    },
                    message = "Successful response",
                    response = EnergyBillingListResponse.class),
            @ApiResponse(code = 400,
                    responseHeaders = @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction."),
                    message = "Invalid Version / Missing Field / Invalid Field / Invalid Page Size / Invalid Date",
                    response = ErrorListResponse.class),
            @ApiResponse(code = 406,
                    responseHeaders = @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction."),
                    message = "Unsupported Version",
                    response = ErrorListResponse.class),
            @ApiResponse(code = 422,
                    responseHeaders = @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction."),
                    message = "Invalid Page / Unavailable Energy Account / Invalid Energy Account",
                    response = ErrorListResponse.class)
    })
    @RequestMapping(
            method = RequestMethod.POST,
            value = "/energy/accounts/billing",
            produces = {"application/json"},
            consumes = {"application/json"}
    )
    @PreAuthorize("hasAuthority('SCOPE_energy:billing:read')")
    ResponseEntity<EnergyBillingListResponse> listBillingForAccounts(
            @ApiParam(
                    value = "Version of the API endpoint requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [_x-min-v_](#request-headers) and [_x-v_](#request-headers). If the value of [_x-min-v_](#request-headers) is equal to or higher than the value of [_x-v_](#request-headers) then the [_x-min-v_](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder **MUST** respond with a `406 Not Acceptable`. See [HTTP Headers](#request-headers).",
                    required = true)
            @RequestHeader(value = "x-v", required = false)
                    Integer xV,
            @ApiParam(
                    value = "Minimum version of the API endpoint requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [_x-min-v_](#request-headers) and [_x-v_](#request-headers). If all versions requested are not supported then the data holder **MUST** respond with a `406 Not Acceptable`.")
            @RequestHeader(value = "x-min-v",
                    required = false)
                    Integer xMinV,
            @ApiParam(
                    value = "Request payload containing list of specific Accounts to obtain data for",
                    required = true)
            @Valid
            @RequestBody
                    RequestAccountIds accountIdList,
            @ApiParam(
                    value = "Constrain the request to records with effective time at or before this date/time.  If absent defaults to current date/time.  Format is aligned to DateTimeString common type")
            @Valid
            @RequestParam(value = "newest-time",
                    required = false)
                    OffsetDateTime newestTime,
            @ApiParam(
                    value = "Constrain the request to records with effective time at or after this date/time. If absent defaults to newest-time minus 12 months.  Format is aligned to DateTimeString common type")
            @Valid
            @RequestParam(value = "oldest-time",
                    required = false)
                    OffsetDateTime oldestTime,
            @ApiParam(
                    value = "Page of results to request (standard pagination)")
            @Valid
            @RequestParam(value = "page",
                    required = false)
                    Integer page,
            @ApiParam(
                    value = "Page size to request.  Default is 25 (standard pagination)")
            @Valid
            @RequestParam(value = "page-size",
                    required = false)
                    Integer pageSize,
            @ApiParam(
                    value = "An [RFC4122](https://tools.ietf.org/html/rfc4122) UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction.")
            @RequestHeader(value = "x-fapi-interaction-id",
                    required = false)
                    UUID xFapiInteractionId,
            @ApiParam(
                    value = "The time when the customer last logged in to the Data Recipient Software Product as described in **[[FAPI-1.0-Baseline]](#nref-FAPI-1-0-Baseline)**. Required for all resource calls (customer present and unattended). Not required for unauthenticated calls.")
            @RequestHeader(value = "x-fapi-auth-date",
                    required = false)
                    @NotNull @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, fallbackPatterns = DateFormat.HTTP) Date xFapiAuthDate,
            @ApiParam(
                    value = "The customer's original IP address if the customer is currently logged in to the data recipient. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls.")
            @RequestHeader(
                    value = "x-fapi-customer-ip-address",
                    required = false)
                    String xFapiCustomerIpAddress,
            @ApiParam(
                    value = "The customer's original standard http headers [Base64](#common-field-types) encoded, including the original User Agent header, if the customer is currently logged in to the data recipient. Mandatory for customer present calls.  Not required for unattended or unauthenticated calls.")
            @RequestHeader(value = "x-cds-client-headers",
                    required = false)
                    String xCdsClientHeaders,
            @ApiParam(
                    value = "Type of interval reads. Any one of the valid values for this field can be supplied. If absent defaults to NONE")
            @Valid
            @RequestParam(value = "interval-reads",
                    defaultValue = "NONE")
                    ParamIntervalReadsEnum intervalReads);


    /**
     * GET /energy/electricity/servicepoints/der : Get Bulk DER
     * Obtain DER data for all service points associated with the customer
     *
     * @param xV                     Version of the API endpoint requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [_x-min-v_](#request-headers) and [_x-v_](#request-headers). If the value of [_x-min-v_](#request-headers) is equal to or higher than the value of [_x-v_](#request-headers) then the [_x-min-v_](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder **MUST** respond with a `406 Not Acceptable`. See [HTTP Headers](#request-headers). (required)
     * @param page                   Page of results to request (standard pagination) (optional)
     * @param pageSize               Page size to request.  Default is 25 (standard pagination) (optional)
     * @param xMinV                  Minimum version of the API endpoint requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [_x-min-v_](#request-headers) and [_x-v_](#request-headers). If all versions requested are not supported then the data holder **MUST** respond with a `406 Not Acceptable`. (optional)
     * @param xFapiInteractionId     An [RFC4122](https://tools.ietf.org/html/rfc4122) UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction. (optional)
     * @param xFapiAuthDate          The time when the customer last logged in to the Data Recipient Software Product as described in **[[FAPI-1.0-Baseline]](#nref-FAPI-1-0-Baseline)**. Required for all resource calls (customer present and unattended). Not required for unauthenticated calls. (optional)
     * @param xFapiCustomerIpAddress The customer's original IP address if the customer is currently logged in to the data recipient. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls. (optional)
     * @param xCdsClientHeaders      The customer's original standard http headers [Base64](#common-field-types) encoded, including the original User Agent header, if the customer is currently logged in to the data recipient. Mandatory for customer present calls.  Not required for unattended or unauthenticated calls. (optional)
     * @return Successful response (status code 200)
     * or The following error codes MUST be supported:<br><ul class="error-code-list"><li>[400 - Invalid Field](#error-400-field-invalid)</li><li>[400 - Missing Required Field](#error-400-field-missing)</li><li>[400 - Invalid Page Size](#error-400-field-invalid-page-size)</li><li>[400 - Invalid Version](#error-400-header-invalid-version)</li><li>[406 - Unsupported Version](#error-406-header-unsupported-version)</li><li>[422 - Invalid Page](#error-422-field-invalid-page)</li></ul> (status code 4xx)
     */
    @ApiOperation(value = "Get Bulk DER",
            nickname = "listDERBulk",
            notes = "Obtain DER data for all service points associated with the customer",
            response = EnergyDerListResponse.class,
            tags = {"Energy", "Distributed Energy Resources",})
    @ApiResponses(value = {
            @ApiResponse(code = 200,
                    responseHeaders = {
                        @ResponseHeader(name = "x-v", response = Integer.class, description = "The [version](#response-headers) of the API endpoint that the data holder has responded with."),
                        @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction.")
                    },
                    message = "Successful response",
                    response = EnergyDerListResponse.class),
            @ApiResponse(code = 400,
                    responseHeaders = @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction."),
                    message = "Invalid Version / Missing Field / Invalid Field / Invalid Page Size",
                    response = ErrorListResponse.class),
            @ApiResponse(code = 406,
                    responseHeaders = @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction."),
                    message = "Unsupported Version",
                    response = ErrorListResponse.class),
            @ApiResponse(code = 422,
                    responseHeaders = @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction."),
                    message = "Invalid Page",
                    response = ErrorListResponse.class)
    })
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/energy/electricity/servicepoints/der",
            produces = {"application/json"}
    )
    @PreAuthorize("hasAuthority('SCOPE_energy:electricity.der:read')")
    ResponseEntity<EnergyDerListResponse> listDERBulk(
            @ApiParam(
                    value = "Version of the API endpoint requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [_x-min-v_](#request-headers) and [_x-v_](#request-headers). If the value of [_x-min-v_](#request-headers) is equal to or higher than the value of [_x-v_](#request-headers) then the [_x-min-v_](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder **MUST** respond with a `406 Not Acceptable`. See [HTTP Headers](#request-headers).",
                    required = true)
            @RequestHeader(value = "x-v", required = false)
                    Integer xV,
            @ApiParam(
                    value = "Minimum version of the API endpoint requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [_x-min-v_](#request-headers) and [_x-v_](#request-headers). If all versions requested are not supported then the data holder **MUST** respond with a `406 Not Acceptable`.")
            @RequestHeader(value = "x-min-v",
                    required = false)
                    Integer xMinV,
            @ApiParam(
                    value = "Page of results to request (standard pagination)")
            @Valid
            @RequestParam(value = "page",
                    required = false)
                    Integer page,
            @ApiParam(
                    value = "Page size to request.  Default is 25 (standard pagination)")
            @Valid
            @RequestParam(value = "page-size",
                    required = false)
                    Integer pageSize,
            @ApiParam(
                    value = "An [RFC4122](https://tools.ietf.org/html/rfc4122) UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction.")
            @RequestHeader(value = "x-fapi-interaction-id",
                    required = false)
                    UUID xFapiInteractionId,
            @ApiParam(
                    value = "The time when the customer last logged in to the Data Recipient Software Product as described in **[[FAPI-1.0-Baseline]](#nref-FAPI-1-0-Baseline)**. Required for all resource calls (customer present and unattended). Not required for unauthenticated calls.")
            @RequestHeader(value = "x-fapi-auth-date",
                    required = false)
                    @NotNull @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, fallbackPatterns = DateFormat.HTTP) Date xFapiAuthDate,
            @ApiParam(
                    value = "The customer's original IP address if the customer is currently logged in to the data recipient. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls.")
            @RequestHeader(value = "x-fapi-customer-ip-address",
                    required = false)
                    String xFapiCustomerIpAddress,
            @ApiParam(
                    value = "The customer's original standard http headers [Base64](#common-field-types) encoded, including the original User Agent header, if the customer is currently logged in to the data recipient. Mandatory for customer present calls.  Not required for unattended or unauthenticated calls.")
            @RequestHeader(value = "x-cds-client-headers",
                    required = false)
                    String xCdsClientHeaders);


    /**
     * POST /energy/electricity/servicepoints/der : Get DER For Specific Service Points
     * Obtain DER data for a specific set of service points
     *
     * @param xV                     Version of the API endpoint requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [_x-min-v_](#request-headers) and [_x-v_](#request-headers). If the value of [_x-min-v_](#request-headers) is equal to or higher than the value of [_x-v_](#request-headers) then the [_x-min-v_](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder **MUST** respond with a `406 Not Acceptable`. See [HTTP Headers](#request-headers). (required)
     * @param servicePointIdList     Request payload containing list of specific Service Points to obtain data for (required)
     * @param page                   Page of results to request (standard pagination) (optional)
     * @param pageSize               Page size to request.  Default is 25 (standard pagination) (optional)
     * @param xMinV                  Minimum version of the API endpoint requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [_x-min-v_](#request-headers) and [_x-v_](#request-headers). If all versions requested are not supported then the data holder **MUST** respond with a `406 Not Acceptable`. (optional)
     * @param xFapiInteractionId     An [RFC4122](https://tools.ietf.org/html/rfc4122) UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction. (optional)
     * @param xFapiAuthDate          The time when the customer last logged in to the Data Recipient Software Product as described in **[[FAPI-1.0-Baseline]](#nref-FAPI-1-0-Baseline)**. Required for all resource calls (customer present and unattended). Not required for unauthenticated calls. (optional)
     * @param xFapiCustomerIpAddress The customer's original IP address if the customer is currently logged in to the data recipient. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls. (optional)
     * @param xCdsClientHeaders      The customer's original standard http headers [Base64](#common-field-types) encoded, including the original User Agent header, if the customer is currently logged in to the data recipient. Mandatory for customer present calls.  Not required for unattended or unauthenticated calls. (optional)
     * @return Successful response (status code 200)
     * or The following error codes MUST be supported:<br><ul class="error-code-list"><li>[400 - Invalid Field](#error-400-field-invalid)</li><li>[400 - Missing Required Field](#error-400-field-missing)</li><li>[400 - Invalid Page Size](#error-400-field-invalid-page-size)</li><li>[400 - Invalid Version](#error-400-header-invalid-version)</li><li>[406 - Unsupported Version](#error-406-header-unsupported-version)</li><li>[422 - Invalid Page](#error-422-field-invalid-page)</li><li>[422 - Unavailable Service Point](#error-422-unavailable-service-point)</li><li>[422 - Invalid Service Point](#error-422-invalid-service-point)</li></ul> (status code 4xx)
     */
    @ApiOperation(value = "Get DER For Specific Service Points",
            nickname = "listDERForServicePoints",
            notes = "Obtain DER data for a specific set of service points",
            response = EnergyDerListResponse.class,
            tags = {"Energy", "Distributed Energy Resources",})
    @ApiResponses(value = {
            @ApiResponse(code = 200,
                    responseHeaders = {
                        @ResponseHeader(name = "x-v", response = Integer.class, description = "The [version](#response-headers) of the API endpoint that the data holder has responded with."),
                        @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction.")
                    },
                    message = "Successful response",
                    response = EnergyDerListResponse.class),
            @ApiResponse(code = 400,
                    responseHeaders = @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction."),
                    message = "Invalid Version / Missing Field / Invalid Field / Invalid Page Size",
                    response = ErrorListResponse.class),
            @ApiResponse(code = 406,
                    responseHeaders = @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction."),
                    message = "Unsupported Version",
                    response = ErrorListResponse.class),
            @ApiResponse(code = 422,
                    responseHeaders = @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction."),
                    message = "Invalid Page / Unavailable Service Point / Invalid Service Point",
                    response = ErrorListResponse.class)
    })
    @RequestMapping(
            method = RequestMethod.POST,
            value = "/energy/electricity/servicepoints/der",
            produces = {"application/json"},
            consumes = {"application/json"}
    )
    @PreAuthorize("hasAuthority('SCOPE_energy:electricity.der:read')")
    ResponseEntity<EnergyDerListResponse> listDERForServicePoints(
            @ApiParam(
                    value = "Version of the API endpoint requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [_x-min-v_](#request-headers) and [_x-v_](#request-headers). If the value of [_x-min-v_](#request-headers) is equal to or higher than the value of [_x-v_](#request-headers) then the [_x-min-v_](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder **MUST** respond with a `406 Not Acceptable`. See [HTTP Headers](#request-headers).",
                    required = true)
            @RequestHeader(value = "x-v", required = false)
                    Integer xV,
            @ApiParam(
                    value = "Minimum version of the API endpoint requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [_x-min-v_](#request-headers) and [_x-v_](#request-headers). If all versions requested are not supported then the data holder **MUST** respond with a `406 Not Acceptable`.")
            @RequestHeader(value = "x-min-v",
                    required = false)
                    Integer xMinV,
            @ApiParam(
                    value = "Request payload containing list of specific Service Points to obtain data for",
                    required = true)
            @Valid
            @RequestBody
                    RequestServicePointIds servicePointIdList,
            @ApiParam(
                    value = "Page of results to request (standard pagination)")
            @Valid
            @RequestParam(value = "page",
                    required = false)
                    Integer page,
            @ApiParam(
                    value = "Page size to request.  Default is 25 (standard pagination)")
            @Valid
            @RequestParam(value = "page-size",
                    required = false)
                    Integer pageSize,
            @ApiParam(
                    value = "An [RFC4122](https://tools.ietf.org/html/rfc4122) UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction.")
            @RequestHeader(value = "x-fapi-interaction-id",
                    required = false)
                    UUID xFapiInteractionId,
            @ApiParam(
                    value = "The time when the customer last logged in to the Data Recipient Software Product as described in **[[FAPI-1.0-Baseline]](#nref-FAPI-1-0-Baseline)**. Required for all resource calls (customer present and unattended). Not required for unauthenticated calls.")
            @RequestHeader(value = "x-fapi-auth-date",
                    required = false)
                    @NotNull @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, fallbackPatterns = DateFormat.HTTP) Date xFapiAuthDate,
            @ApiParam(
                    value = "The customer's original IP address if the customer is currently logged in to the data recipient. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls.")
            @RequestHeader(value = "x-fapi-customer-ip-address",
                    required = false)
                    String xFapiCustomerIpAddress,
            @ApiParam(
                    value = "The customer's original standard http headers [Base64](#common-field-types) encoded, including the original User Agent header, if the customer is currently logged in to the data recipient. Mandatory for customer present calls.  Not required for unattended or unauthenticated calls.")
            @RequestHeader(value = "x-cds-client-headers",
                    required = false)
                    String xCdsClientHeaders);


    /**
     * GET /energy/accounts/invoices : Get Bulk Invoices
     * Obtain the invoices for all accounts
     *
     * @param xV                     Version of the API endpoint requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [_x-min-v_](#request-headers) and [_x-v_](#request-headers). If the value of [_x-min-v_](#request-headers) is equal to or higher than the value of [_x-v_](#request-headers) then the [_x-min-v_](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder **MUST** respond with a `406 Not Acceptable`. See [HTTP Headers](#request-headers). (required)
     * @param newestDate             Constrain the request to records with issue date at or before this date.  If absent defaults to current date.  Format is aligned to DateString common type (optional)
     * @param oldestDate             Constrain the request to records with issue date at or after this date. If absent defaults to newest-date minus 24 months.  Format is aligned to DateString common type (optional)
     * @param page                   Page of results to request (standard pagination) (optional)
     * @param pageSize               Page size to request.  Default is 25 (standard pagination) (optional)
     * @param xMinV                  Minimum version of the API endpoint requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [_x-min-v_](#request-headers) and [_x-v_](#request-headers). If all versions requested are not supported then the data holder **MUST** respond with a `406 Not Acceptable`. (optional)
     * @param xFapiInteractionId     An [RFC4122](https://tools.ietf.org/html/rfc4122) UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction. (optional)
     * @param xFapiAuthDate          The time when the customer last logged in to the Data Recipient Software Product as described in **[[FAPI-1.0-Baseline]](#nref-FAPI-1-0-Baseline)**. Required for all resource calls (customer present and unattended). Not required for unauthenticated calls. (optional)
     * @param xFapiCustomerIpAddress The customer's original IP address if the customer is currently logged in to the data recipient. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls. (optional)
     * @param xCdsClientHeaders      The customer's original standard http headers [Base64](#common-field-types) encoded, including the original User Agent header, if the customer is currently logged in to the data recipient. Mandatory for customer present calls.  Not required for unattended or unauthenticated calls. (optional)
     * @return Successful response (status code 200)
     * or The following error codes MUST be supported:<br><ul class="error-code-list"><li>[400 - Invalid Field](#error-400-field-invalid)</li><li>[400 - Missing Required Field](#error-400-field-missing)</li><li>[400 - Invalid Page Size](#error-400-field-invalid-page-size)</li><li>[400 - Invalid Version](#error-400-header-invalid-version)</li><li>[406 - Unsupported Version](#error-406-header-unsupported-version)</li><li>[422 - Invalid Page](#error-422-field-invalid-page)</li></ul> (status code 4xx)
     */
    @ApiOperation(value = "Get Bulk Invoices",
            nickname = "listInvoicesBulk",
            notes = "Obtain the invoices for all accounts",
            response = EnergyInvoiceListResponse.class,
            tags = {"Energy", "Billing",})
    @ApiResponses(value = {
            @ApiResponse(code = 200,
                    responseHeaders = {
                        @ResponseHeader(name = "x-v", response = Integer.class, description = "The [version](#response-headers) of the API endpoint that the data holder has responded with."),
                        @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction.")
                    },
                    message = "Successful response",
                    response = EnergyInvoiceListResponse.class),
            @ApiResponse(code = 400,
                    responseHeaders = @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction."),
                    message = "Invalid Version / Missing Field / Invalid Field / Invalid Page Size / Invalid Date",
                    response = ErrorListResponse.class),
            @ApiResponse(code = 406,
                    responseHeaders = @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction."),
                    message = "Unsupported Version",
                    response = ErrorListResponse.class),
            @ApiResponse(code = 422,
                    responseHeaders = @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction."),
                    message = "Invalid Page",
                    response = ErrorListResponse.class)
    })
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/energy/accounts/invoices",
            produces = {"application/json"}
    )
    @PreAuthorize("hasAuthority('SCOPE_energy:billing:read')")
    ResponseEntity<EnergyInvoiceListResponse> listInvoicesBulk(
            @ApiParam(
                    value = "Version of the API endpoint requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [_x-min-v_](#request-headers) and [_x-v_](#request-headers). If the value of [_x-min-v_](#request-headers) is equal to or higher than the value of [_x-v_](#request-headers) then the [_x-min-v_](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder **MUST** respond with a `406 Not Acceptable`. See [HTTP Headers](#request-headers).",
                    required = true)
            @RequestHeader(value = "x-v", required = false)
                    Integer xV,
            @ApiParam(
                    value = "Minimum version of the API endpoint requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [_x-min-v_](#request-headers) and [_x-v_](#request-headers). If all versions requested are not supported then the data holder **MUST** respond with a `406 Not Acceptable`.")
            @RequestHeader(value = "x-min-v",
                    required = false)
                    Integer xMinV,
            @ApiParam(
                    value = "Constrain the request to records with issue date at or before this date.  If absent defaults to current date.  Format is aligned to DateString common type")
            @Valid
            @RequestParam(value = "newest-date",
                    required = false)
                    LocalDate newestDate,
            @ApiParam(
                    value = "Constrain the request to records with issue date at or after this date. If absent defaults to newest-date minus 24 months.  Format is aligned to DateString common type")
            @Valid
            @RequestParam(value = "oldest-date",
                    required = false)
                    LocalDate oldestDate,
            @ApiParam(
                    value = "Page of results to request (standard pagination)")
            @Valid
            @RequestParam(value = "page",
                    required = false)
                    Integer page,
            @ApiParam(
                    value = "Page size to request.  Default is 25 (standard pagination)")
            @Valid
            @RequestParam(value = "page-size",
                    required = false)
                    Integer pageSize,
            @ApiParam(
                    value = "An [RFC4122](https://tools.ietf.org/html/rfc4122) UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction.")
            @RequestHeader(value = "x-fapi-interaction-id",
                    required = false)
                    UUID xFapiInteractionId,
            @ApiParam(
                    value = "The time when the customer last logged in to the Data Recipient Software Product as described in **[[FAPI-1.0-Baseline]](#nref-FAPI-1-0-Baseline)**. Required for all resource calls (customer present and unattended). Not required for unauthenticated calls.")
            @RequestHeader(value = "x-fapi-auth-date",
                    required = false)
                    @NotNull @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, fallbackPatterns = DateFormat.HTTP) Date xFapiAuthDate,
            @ApiParam(
                    value = "The customer's original IP address if the customer is currently logged in to the data recipient. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls.")
            @RequestHeader(value = "x-fapi-customer-ip-address",
                    required = false)
                    String xFapiCustomerIpAddress,
            @ApiParam(
                    value = "The customer's original standard http headers [Base64](#common-field-types) encoded, including the original User Agent header, if the customer is currently logged in to the data recipient. Mandatory for customer present calls.  Not required for unattended or unauthenticated calls.")
            @RequestHeader(value = "x-cds-client-headers",
                    required = false)
                    String xCdsClientHeaders);


    /**
     * POST /energy/accounts/invoices : Get Invoices For Specific Accounts
     * Obtain invoices for a specified set of accounts
     *
     * @param xV                     Version of the API endpoint requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [_x-min-v_](#request-headers) and [_x-v_](#request-headers). If the value of [_x-min-v_](#request-headers) is equal to or higher than the value of [_x-v_](#request-headers) then the [_x-min-v_](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder **MUST** respond with a `406 Not Acceptable`. See [HTTP Headers](#request-headers). (required)
     * @param accountIdList          Request payload containing list of specific Accounts to obtain data for (required)
     * @param newestDate             Constrain the request to records with issue date at or before this date.  If absent defaults to current date.  Format is aligned to DateString common type (optional)
     * @param oldestDate             Constrain the request to records with issue date at or after this date. If absent defaults to newest-date minus 24 months.  Format is aligned to DateString common type (optional)
     * @param page                   Page of results to request (standard pagination) (optional)
     * @param pageSize               Page size to request.  Default is 25 (standard pagination) (optional)
     * @param xMinV                  Minimum version of the API endpoint requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [_x-min-v_](#request-headers) and [_x-v_](#request-headers). If all versions requested are not supported then the data holder **MUST** respond with a `406 Not Acceptable`. (optional)
     * @param xFapiInteractionId     An [RFC4122](https://tools.ietf.org/html/rfc4122) UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction. (optional)
     * @param xFapiAuthDate          The time when the customer last logged in to the Data Recipient Software Product as described in **[[FAPI-1.0-Baseline]](#nref-FAPI-1-0-Baseline)**. Required for all resource calls (customer present and unattended). Not required for unauthenticated calls. (optional)
     * @param xFapiCustomerIpAddress The customer's original IP address if the customer is currently logged in to the data recipient. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls. (optional)
     * @param xCdsClientHeaders      The customer's original standard http headers [Base64](#common-field-types) encoded, including the original User Agent header, if the customer is currently logged in to the data recipient. Mandatory for customer present calls.  Not required for unattended or unauthenticated calls. (optional)
     * @return Successful response (status code 200)
     * or The following error codes MUST be supported:<br><ul class="error-code-list"><li>[400 - Invalid Field](#error-400-field-invalid)</li><li>[400 - Missing Required Field](#error-400-field-missing)</li><li>[400 - Invalid Page Size](#error-400-field-invalid-page-size)</li><li>[400 - Invalid Version](#error-400-header-invalid-version)</li><li>[406 - Unsupported Version](#error-406-header-unsupported-version)</li><li>[422 - Invalid Page](#error-422-field-invalid-page)</li><li>[422 - Unavailable Energy Account](#error-422-unavailable-energy-account)</li><li>[422 - Invalid Energy Account](#error-422-invalid-energy-account)</li></ul> (status code 4xx)
     */
    @ApiOperation(value = "Get Invoices For Specific Accounts",
            nickname = "listInvoicesForAccounts",
            notes = "Obtain invoices for a specified set of accounts",
            response = EnergyInvoiceListResponse.class,
            tags = {"Energy", "Billing",})
    @ApiResponses(value = {
            @ApiResponse(code = 200,
                    responseHeaders = {
                        @ResponseHeader(name = "x-v", response = Integer.class, description = "The [version](#response-headers) of the API endpoint that the data holder has responded with."),
                        @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction.")
                    },
                    message = "Successful response",
                    response = EnergyInvoiceListResponse.class),
            @ApiResponse(code = 400,
                    responseHeaders = @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction."),
                    message = "Invalid Version / Missing Field / Invalid Field / Invalid Page Size / Invalid Date",
                    response = ErrorListResponse.class),
            @ApiResponse(code = 406,
                    responseHeaders = @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction."),
                    message = "Unsupported Version",
                    response = ErrorListResponse.class),
            @ApiResponse(code = 422,
                    responseHeaders = @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction."),
                    message = "Invalid Page / Unavailable Energy Account / Invalid Energy Account",
                    response = ErrorListResponse.class)
    })
    @RequestMapping(
            method = RequestMethod.POST,
            value = "/energy/accounts/invoices",
            produces = {"application/json"},
            consumes = {"application/json"}
    )
    @PreAuthorize("hasAuthority('SCOPE_energy:billing:read')")
    ResponseEntity<EnergyInvoiceListResponse> listInvoicesForAccounts(
            @ApiParam(
                    value = "Version of the API endpoint requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [_x-min-v_](#request-headers) and [_x-v_](#request-headers). If the value of [_x-min-v_](#request-headers) is equal to or higher than the value of [_x-v_](#request-headers) then the [_x-min-v_](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder **MUST** respond with a `406 Not Acceptable`. See [HTTP Headers](#request-headers).",
                    required = true)
            @RequestHeader(value = "x-v", required = false)
                    Integer xV,
            @ApiParam(
                    value = "Minimum version of the API endpoint requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [_x-min-v_](#request-headers) and [_x-v_](#request-headers). If all versions requested are not supported then the data holder **MUST** respond with a `406 Not Acceptable`.")
            @RequestHeader(value = "x-min-v",
                    required = false)
                    Integer xMinV,
            @ApiParam(
                    value = "Request payload containing list of specific Accounts to obtain data for",
                    required = true)
            @Valid
            @RequestBody
                    RequestAccountIds accountIdList,
            @ApiParam(
                    value = "Constrain the request to records with issue date at or before this date.  If absent defaults to current date.  Format is aligned to DateString common type")
            @Valid
            @RequestParam(value = "newest-date",
                    required = false)
                    LocalDate newestDate,
            @ApiParam(
                    value = "Constrain the request to records with issue date at or after this date. If absent defaults to newest-date minus 24 months.  Format is aligned to DateString common type")
            @Valid
            @RequestParam(value = "oldest-date",
                    required = false)
                    LocalDate oldestDate,
            @ApiParam(
                    value = "Page of results to request (standard pagination)")
            @Valid
            @RequestParam(value = "page",
                    required = false)
                    Integer page,
            @ApiParam(
                    value = "Page size to request.  Default is 25 (standard pagination)")
            @Valid
            @RequestParam(value = "page-size",
                    required = false)
                    Integer pageSize,
            @ApiParam(
                    value = "An [RFC4122](https://tools.ietf.org/html/rfc4122) UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction.")
            @RequestHeader(value = "x-fapi-interaction-id",
                    required = false)
                    UUID xFapiInteractionId,
            @ApiParam(
                    value = "The time when the customer last logged in to the Data Recipient Software Product as described in **[[FAPI-1.0-Baseline]](#nref-FAPI-1-0-Baseline)**. Required for all resource calls (customer present and unattended). Not required for unauthenticated calls.")
            @RequestHeader(value = "x-fapi-auth-date",
                    required = false)
                    @NotNull @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, fallbackPatterns = DateFormat.HTTP) Date xFapiAuthDate,
            @ApiParam(
                    value = "The customer's original IP address if the customer is currently logged in to the data recipient. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls.")
            @RequestHeader(
                    value = "x-fapi-customer-ip-address",
                    required = false)
                    String xFapiCustomerIpAddress,
            @ApiParam(
                    value = "The customer's original standard http headers [Base64](#common-field-types) encoded, including the original User Agent header, if the customer is currently logged in to the data recipient. Mandatory for customer present calls.  Not required for unattended or unauthenticated calls.")
            @RequestHeader(value = "x-cds-client-headers",
                    required = false)
                    String xCdsClientHeaders);


    /**
     * GET /energy/plans : Get Generic Plans
     * Obtain a list of energy plans that are currently offered to the market.  Note that the results returned by this end point are expected to be ordered in descending order according to &#x60;lastUpdated&#x60;.
     *
     * @param xV                 Version of the API endpoint requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [_x-min-v_](#request-headers) and [_x-v_](#request-headers). If the value of [_x-min-v_](#request-headers) is equal to or higher than the value of [_x-v_](#request-headers) then the [_x-min-v_](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder **MUST** respond with a `406 Not Acceptable`. See [HTTP Headers](#request-headers). (required)
     * @param type               Used to filter results on the type field.  Any one of the valid values for this field can be supplied plus 'ALL'.  If absent defaults to 'ALL' (optional, default to ALL)
     * @param fuelType           Used to filter results on the fuelType field.  Any one of the valid values for this field can be supplied plus 'ALL'.  If absent defaults to 'ALL' (optional, default to ALL)
     * @param effective          Allows for the filtering of plans based on whether the current time is within the period of time defined as effective by the effectiveFrom and effectiveTo fields. Valid values are ‘CURRENT’, ‘FUTURE’ and ‘ALL’. If absent defaults to 'CURRENT' (optional, default to CURRENT)
     * @param updatedSince       Only include plans that have been updated after the specified date and time.  If absent defaults to include all plans (optional)
     * @param brand              Used to filter results on the brand field.  If absent defaults to include all plans (optional)
     * @param page               Page of results to request (standard pagination) (optional)
     * @param pageSize           Page size to request.  Default is 25 (standard pagination) (optional)
     * @param xMinV              Minimum version of the API endpoint requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [_x-min-v_](#request-headers) and [_x-v_](#request-headers). If all versions requested are not supported then the data holder **MUST** respond with a `406 Not Acceptable`. (optional)
     * @return Successful response (status code 200)
     * or The following error codes MUST be supported:<br><ul class="error-code-list"><li>[400 - Invalid Field](#error-400-field-invalid)</li><li>[400 - Missing Required Field](#error-400-field-missing)</li><li>[400 - Invalid Page Size](#error-400-field-invalid-page-size)</li><li>[400 - Invalid Version](#error-400-header-invalid-version)</li><li>[406 - Unsupported Version](#error-406-header-unsupported-version)</li><li>[422 - Invalid Page](#error-422-field-invalid-page)</li></ul> (status code 4xx)
     */
    @ApiOperation(value = "Get Generic Plans",
            nickname = "listPlans",
            notes = "Obtain a list of energy plans that are currently offered to the market.  Note that the results returned by this end point are expected to be ordered in descending order according to `lastUpdated`.",
            response = EnergyPlanListResponse.class,
            tags = {"Energy", "Generic Tariffs",})
    @ApiResponses(value = {
            @ApiResponse(code = 200,
                    responseHeaders = @ResponseHeader(name = "x-v", response = Integer.class, description = "The [version](#response-headers) of the API endpoint that the data holder has responded with."),
                    message = "Successful response",
                    response = EnergyPlanListResponse.class),
            @ApiResponse(code = 400,
                    message = "Invalid Version / Missing Field / Invalid Field / Invalid Page Size / Invalid Date",
                    response = ErrorListResponse.class),
            @ApiResponse(code = 406,
                    message = "Unsupported Version",
                    response = ErrorListResponse.class),
            @ApiResponse(code = 422,
                    message = "Invalid Page",
                    response = ErrorListResponse.class)
    })
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/energy/plans",
            produces = {"application/json"}
    )
    ResponseEntity<EnergyPlanListResponse> listPlans(
            @ApiParam(
                    value = "Version of the API endpoint requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [_x-min-v_](#request-headers) and [_x-v_](#request-headers). If the value of [_x-min-v_](#request-headers) is equal to or higher than the value of [_x-v_](#request-headers) then the [_x-min-v_](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder **MUST** respond with a `406 Not Acceptable`. See [HTTP Headers](#request-headers).",
                    required = true)
            @RequestHeader(value = "x-v", required = false)
                    Integer xV,
            @ApiParam(
                    value = "Minimum version of the API endpoint requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [_x-min-v_](#request-headers) and [_x-v_](#request-headers). If all versions requested are not supported then the data holder **MUST** respond with a `406 Not Acceptable`.")
            @RequestHeader(value = "x-min-v",
                    required = false)
                    Integer xMinV,
            @ApiParam(
                    value = "Used to filter results on the type field.  Any one of the valid values for this field can be supplied plus 'ALL'.  If absent defaults to 'ALL'",
                    allowableValues = "STANDING, MARKET, REGULATED, ALL",
                    defaultValue = "ALL")
            @Valid
            @RequestParam(value = "type",
                    required = false,
                    defaultValue = "ALL")
                    ParamTypeEnum type,
            @ApiParam(
                    value = "Used to filter results on the fuelType field.  Any one of the valid values for this field can be supplied plus 'ALL'.  If absent defaults to 'ALL'",
                    allowableValues = "ELECTRICITY, GAS, DUAL, ALL",
                    defaultValue = "ALL")
            @Valid
            @RequestParam(value = "fuelType",
                    required = false,
                    defaultValue = "ALL")
                    ParamFuelTypeEnum fuelType,
            @ApiParam(
                    value = "Allows for the filtering of plans based on whether the current time is within the period of time defined as effective by the effectiveFrom and effectiveTo fields. Valid values are ‘CURRENT’, ‘FUTURE’ and ‘ALL’. If absent defaults to 'CURRENT'",
                    allowableValues = "CURRENT, FUTURE, ALL",
                    defaultValue = "CURRENT")
            @Valid
            @RequestParam(value = "effective",
                    required = false,
                    defaultValue = "CURRENT")
                    ParamEffective effective,
            @ApiParam(
                    value = "Only include plans that have been updated after the specified date and time.  If absent defaults to include all plans")
            @Valid
            @RequestParam(value = "updated-since",
                    required = false)
                     @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, fallbackPatterns = DateFormat.HTTP) OffsetDateTime updatedSince,
            @ApiParam(
                    value = "Used to filter results on the brand field.  If absent defaults to include all plans")
            @Valid
            @RequestParam(value = "brand",
                    required = false)
                    String brand,
            @ApiParam(
                    value = "Page of results to request (standard pagination)")
            @Valid
            @RequestParam(value = "page",
                    required = false)
                    Integer page,
            @ApiParam(
                    value = "Page size to request.  Default is 25 (standard pagination)")
            @Valid
            @RequestParam(value = "page-size",
                    required = false)
                    Integer pageSize);


    /**
     * GET /energy/electricity/servicepoints : Get Service Points
     * Obtain a list of service points owned by the customer that has authorised the current session
     *
     * @param xV                     Version of the API endpoint requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [_x-min-v_](#request-headers) and [_x-v_](#request-headers). If the value of [_x-min-v_](#request-headers) is equal to or higher than the value of [_x-v_](#request-headers) then the [_x-min-v_](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder **MUST** respond with a `406 Not Acceptable`. See [HTTP Headers](#request-headers). (required)
     * @param page                   Page of results to request (standard pagination) (optional)
     * @param pageSize               Page size to request.  Default is 25 (standard pagination) (optional)
     * @param xMinV                  Minimum version of the API endpoint requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [_x-min-v_](#request-headers) and [_x-v_](#request-headers). If all versions requested are not supported then the data holder **MUST** respond with a `406 Not Acceptable`. (optional)
     * @param xFapiInteractionId     An [RFC4122](https://tools.ietf.org/html/rfc4122) UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction. (optional)
     * @param xFapiAuthDate          The time when the customer last logged in to the Data Recipient Software Product as described in **[[FAPI-1.0-Baseline]](#nref-FAPI-1-0-Baseline)**. Required for all resource calls (customer present and unattended). Not required for unauthenticated calls. (optional)
     * @param xFapiCustomerIpAddress The customer's original IP address if the customer is currently logged in to the data recipient. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls. (optional)
     * @param xCdsClientHeaders      The customer's original standard http headers [Base64](#common-field-types) encoded, including the original User Agent header, if the customer is currently logged in to the data recipient. Mandatory for customer present calls.  Not required for unattended or unauthenticated calls. (optional)
     * @return Successful response (status code 200)
     * or The following error codes MUST be supported:<br><ul class="error-code-list"><li>[400 - Missing Required Field](#error-400-field-missing)</li><li>[400 - Invalid Field](#error-400-field-invalid)</li><li>[400 - Invalid Page Size](#error-400-field-invalid-page-size)</li><li>[400 - Invalid Version](#error-400-header-invalid-version)</li><li>[406 - Unsupported Version](#error-406-header-unsupported-version)</li><li>[422 - Invalid Page](#error-422-field-invalid-page)</li></ul> (status code 4xx)
     */
    @ApiOperation(value = "Get Service Points",
            nickname = "listServicePoints",
            notes = "Obtain a list of service points owned by the customer that has authorised the current session",
            response = EnergyServicePointListResponse.class,
            tags = {"Energy", "NMI Standing Data",})
    @ApiResponses(value = {
            @ApiResponse(code = 200,
                    responseHeaders = {
                        @ResponseHeader(name = "x-v", response = Integer.class, description = "The [version](#response-headers) of the API endpoint that the data holder has responded with."),
                        @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction.")
                    },
                    message = "Successful response",
                    response = EnergyServicePointListResponse.class),
            @ApiResponse(code = 400,
                    responseHeaders = @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction."),
                    message = "Invalid Version / Missing Field / Invalid Field / Invalid Page Size",
                    response = ErrorListResponse.class),
            @ApiResponse(code = 406,
                    responseHeaders = @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction."),
                    message = "Unsupported Version",
                    response = ErrorListResponse.class),
            @ApiResponse(code = 422,
                    responseHeaders = @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction."),
                    message = "Invalid Page",
                    response = ErrorListResponse.class)
    })
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/energy/electricity/servicepoints",
            produces = {"application/json"}
    )
    @PreAuthorize("hasAuthority('SCOPE_energy:electricity.servicepoints.basic:read')")
    ResponseEntity<EnergyServicePointListResponse> listServicePoints(
            @ApiParam(
                    value = "Version of the API endpoint requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [_x-min-v_](#request-headers) and [_x-v_](#request-headers). If the value of [_x-min-v_](#request-headers) is equal to or higher than the value of [_x-v_](#request-headers) then the [_x-min-v_](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder **MUST** respond with a `406 Not Acceptable`. See [HTTP Headers](#request-headers).",
                    required = true)
            @RequestHeader(value = "x-v", required = false)
                    Integer xV,
            @ApiParam(
                    value = "Minimum version of the API endpoint requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [_x-min-v_](#request-headers) and [_x-v_](#request-headers). If all versions requested are not supported then the data holder **MUST** respond with a `406 Not Acceptable`.")
            @RequestHeader(value = "x-min-v",
                    required = false)
                    Integer xMinV,
            @ApiParam(
                    value = "Page of results to request (standard pagination)")
            @Valid
            @RequestParam(value = "page",
                    required = false)
                    Integer page,
            @ApiParam(
                    value = "Page size to request.  Default is 25 (standard pagination)")
            @Valid
            @RequestParam(value = "page-size",
                    required = false)
                    Integer pageSize,
            @ApiParam(
                    value = "An [RFC4122](https://tools.ietf.org/html/rfc4122) UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction.")
            @RequestHeader(value = "x-fapi-interaction-id",
                    required = false)
                    UUID xFapiInteractionId,
            @ApiParam(
                    value = "The time when the customer last logged in to the Data Recipient Software Product as described in **[[FAPI-1.0-Baseline]](#nref-FAPI-1-0-Baseline)**. Required for all resource calls (customer present and unattended). Not required for unauthenticated calls.")
            @RequestHeader(value = "x-fapi-auth-date",
                    required = false)
                    @NotNull @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, fallbackPatterns = DateFormat.HTTP) Date xFapiAuthDate,
            @ApiParam(
                    value = "The customer's original IP address if the customer is currently logged in to the data recipient. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls.")
            @RequestHeader(
                    value = "x-fapi-customer-ip-address",
                    required = false)
                    String xFapiCustomerIpAddress,
            @ApiParam(
                    value = "The customer's original standard http headers [Base64](#common-field-types) encoded, including the original User Agent header, if the customer is currently logged in to the data recipient. Mandatory for customer present calls.  Not required for unattended or unauthenticated calls.")
            @RequestHeader(value = "x-cds-client-headers",
                    required = false)
                    String xCdsClientHeaders);


    /**
     * GET /energy/electricity/servicepoints/usage : Get Bulk Usage
     * Obtain usage data for all service points associated with the customer
     *
     * @param xV                     Version of the API endpoint requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [_x-min-v_](#request-headers) and [_x-v_](#request-headers). If the value of [_x-min-v_](#request-headers) is equal to or higher than the value of [_x-v_](#request-headers) then the [_x-min-v_](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder **MUST** respond with a `406 Not Acceptable`. See [HTTP Headers](#request-headers). (required)
     * @param oldestDate             Constrain the request to records with effective date at or after this date. If absent defaults to newest-date minus 24 months.  Format is aligned to DateString common type (optional)
     * @param newestDate             Constrain the request to records with effective date at or before this date.  If absent defaults to current date.  Format is aligned to DateString common type (optional)
     * @param page                   Page of results to request (standard pagination) (optional)
     * @param pageSize               Page size to request.  Default is 25 (standard pagination) (optional)
     * @param xMinV                  Minimum version of the API endpoint requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [_x-min-v_](#request-headers) and [_x-v_](#request-headers). If all versions requested are not supported then the data holder **MUST** respond with a `406 Not Acceptable`. (optional)
     * @param xFapiInteractionId     An [RFC4122](https://tools.ietf.org/html/rfc4122) UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction. (optional)
     * @param xFapiAuthDate          The time when the customer last logged in to the Data Recipient Software Product as described in **[[FAPI-1.0-Baseline]](#nref-FAPI-1-0-Baseline)**. Required for all resource calls (customer present and unattended). Not required for unauthenticated calls. (optional)
     * @param xFapiCustomerIpAddress The customer's original IP address if the customer is currently logged in to the data recipient. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls. (optional)
     * @param xCdsClientHeaders      The customer's original standard http headers [Base64](#common-field-types) encoded, including the original User Agent header, if the customer is currently logged in to the data recipient. Mandatory for customer present calls.  Not required for unattended or unauthenticated calls. (optional)
     * @param intervalReads          Type of interval reads. Any one of the valid values for this field can be supplied. If absent defaults to NONE
     * @return Successful response (status code 200)
     * or The following error codes MUST be supported:<br><ul class="error-code-list"><li>[400 - Invalid Field](#error-400-field-invalid)</li><li>[400 - Missing Required Field](#error-400-field-missing)</li><li>[400 - Invalid Page Size](#error-400-field-invalid-page-size)</li><li>[400 - Invalid Version](#error-400-header-invalid-version)</li><li>[406 - Unsupported Version](#error-406-header-unsupported-version)</li><li>[422 - Invalid Page](#error-422-field-invalid-page)</li></ul> (status code 4xx)
     */
    @ApiOperation(value = "Get Bulk Usage",
            nickname = "listUsageBulk",
            notes = "Obtain usage data for all service points associated with the customer",
            response = EnergyUsageListResponse.class,
            tags = {"Energy", "Electricity Usage",})
    @ApiResponses(value = {
            @ApiResponse(code = 200,
                    responseHeaders = {
                        @ResponseHeader(name = "x-v", response = Integer.class, description = "The [version](#response-headers) of the API endpoint that the data holder has responded with."),
                        @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction.")
                    },
                    message = "Successful response",
                    response = EnergyUsageListResponse.class),
            @ApiResponse(code = 400,
                    responseHeaders = @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction."),
                    message = "Invalid Version / Missing Field / Invalid Field / Invalid Page Size / Invalid Date",
                    response = ErrorListResponse.class),
            @ApiResponse(code = 406,
                    responseHeaders = @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction."),
                    message = "Unsupported Version",
                    response = ErrorListResponse.class),
            @ApiResponse(code = 422,
                    responseHeaders = @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction."),
                    message = "Invalid Page",
                    response = ErrorListResponse.class)
    })
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/energy/electricity/servicepoints/usage",
            produces = {"application/json"}
    )
    @PreAuthorize("hasAuthority('SCOPE_energy:electricity.usage:read')")
    ResponseEntity<EnergyUsageListResponse> listUsageBulk(
            @ApiParam(
                    value = "Version of the API endpoint requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [_x-min-v_](#request-headers) and [_x-v_](#request-headers). If the value of [_x-min-v_](#request-headers) is equal to or higher than the value of [_x-v_](#request-headers) then the [_x-min-v_](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder **MUST** respond with a `406 Not Acceptable`. See [HTTP Headers](#request-headers).",
                    required = true)
            @RequestHeader(value = "x-v", required = false)
                    Integer xV,
            @ApiParam(
                    value = "Minimum version of the API endpoint requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [_x-min-v_](#request-headers) and [_x-v_](#request-headers). If all versions requested are not supported then the data holder **MUST** respond with a `406 Not Acceptable`.")
            @RequestHeader(value = "x-min-v",
                    required = false)
                    Integer xMinV,
            @ApiParam(
                    value = "Constrain the request to records with effective date at or after this date. If absent defaults to newest-date minus 24 months.  Format is aligned to DateString common type")
            @Valid
            @RequestParam(value = "oldest-date",
                    required = false)
                    LocalDate oldestDate,
            @ApiParam(
                    value = "Constrain the request to records with effective date at or before this date.  If absent defaults to current date.  Format is aligned to DateString common type")
            @Valid
            @RequestParam(value = "newest-date",
                    required = false)
                    LocalDate newestDate,
            @ApiParam(
                    value = "Page of results to request (standard pagination)")
            @Valid
            @RequestParam(value = "page",
                    required = false)
                    Integer page,
            @ApiParam(
                    value = "Page size to request.  Default is 25 (standard pagination)")
            @Valid
            @RequestParam(value = "page-size",
                    required = false)
                    Integer pageSize,
            @ApiParam(
                    value = "An [RFC4122](https://tools.ietf.org/html/rfc4122) UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction.")
            @RequestHeader(value = "x-fapi-interaction-id",
                    required = false)
                    UUID xFapiInteractionId,
            @ApiParam(
                    value = "The time when the customer last logged in to the Data Recipient Software Product as described in **[[FAPI-1.0-Baseline]](#nref-FAPI-1-0-Baseline)**. Required for all resource calls (customer present and unattended). Not required for unauthenticated calls.")
            @RequestHeader(value = "x-fapi-auth-date",
                    required = false)
                    @NotNull @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, fallbackPatterns = DateFormat.HTTP) Date xFapiAuthDate,
            @ApiParam(
                    value = "The customer's original IP address if the customer is currently logged in to the data recipient. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls.")
            @RequestHeader(value = "x-fapi-customer-ip-address",
                    required = false)
                    String xFapiCustomerIpAddress,
            @ApiParam(
                    value = "The customer's original standard http headers [Base64](#common-field-types) encoded, including the original User Agent header, if the customer is currently logged in to the data recipient. Mandatory for customer present calls.  Not required for unattended or unauthenticated calls.")
            @RequestHeader(value = "x-cds-client-headers",
                    required = false)
                    String xCdsClientHeaders,
            @ApiParam(
                    value = "Type of interval reads. Any one of the valid values for this field can be supplied. If absent defaults to NONE")
            @Valid
            @RequestParam(value = "interval-reads",
                    defaultValue = "NONE")
                    ParamIntervalReadsEnum intervalReads);


    /**
     * POST /energy/electricity/servicepoints/usage : Get Usage For Specific Service Points
     * Obtain the electricity usage data for a specific set of service points
     *
     * @param xV                     Version of the API endpoint requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [_x-min-v_](#request-headers) and [_x-v_](#request-headers). If the value of [_x-min-v_](#request-headers) is equal to or higher than the value of [_x-v_](#request-headers) then the [_x-min-v_](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder **MUST** respond with a `406 Not Acceptable`. See [HTTP Headers](#request-headers). (required)
     * @param xMinV                  Minimum version of the API endpoint requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [_x-min-v_](#request-headers) and [_x-v_](#request-headers). If all versions requested are not supported then the data holder **MUST** respond with a `406 Not Acceptable`. (optional)
     * @param servicePointIdList     Request payload containing list of specific Service Points to obtain data for (required)
     * @param oldestDate             Constrain the request to records with effective date at or after this date. If absent defaults to newest-date minus 24 months.  Format is aligned to DateString common type (optional)
     * @param newestDate             Constrain the request to records with effective date at or before this date.  If absent defaults to current date.  Format is aligned to DateString common type (optional)
     * @param page                   Page of results to request (standard pagination) (optional)
     * @param pageSize               Page size to request.  Default is 25 (standard pagination) (optional)
     * @param xFapiInteractionId     An [RFC4122](https://tools.ietf.org/html/rfc4122) UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction. (optional)
     * @param xFapiAuthDate          The time when the customer last logged in to the Data Recipient Software Product as described in **[[FAPI-1.0-Baseline]](#nref-FAPI-1-0-Baseline)**. Required for all resource calls (customer present and unattended). Not required for unauthenticated calls. (optional)
     * @param xFapiCustomerIpAddress The customer's original IP address if the customer is currently logged in to the data recipient. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls. (optional)
     * @param xCdsClientHeaders      The customer's original standard http headers [Base64](#common-field-types) encoded, including the original User Agent header, if the customer is currently logged in to the data recipient. Mandatory for customer present calls.  Not required for unattended or unauthenticated calls. (optional)
     * @param intervalReads          Type of interval reads. Any one of the valid values for this field can be supplied. If absent defaults to NONE
     * @return Successful response (status code 200)
     * or The following error codes MUST be supported:<br><ul class="error-code-list"><li>[400 - Invalid Field](#error-400-field-invalid)</li><li>[400 - Missing Required Field](#error-400-field-missing)</li><li>[400 - Invalid Page Size](#error-400-field-invalid-page-size)</li><li>[400 - Invalid Version](#error-400-header-invalid-version)</li><li>[406 - Unsupported Version](#error-406-header-unsupported-version)</li><li>[422 - Invalid Page](#error-422-field-invalid-page)</li><li>[422 - Unavailable Service Point](#error-422-unavailable-service-point)</li><li>[422 - Invalid Service Point](#error-422-invalid-service-point)</li></ul> (status code 4xx)
     */
    @ApiOperation(value = "Get Usage For Specific Service Points",
            nickname = "listUsageForServicePoints",
            notes = "Obtain the electricity usage data for a specific set of service points",
            response = EnergyUsageListResponse.class,
            tags = {"Energy", "Electricity Usage",})
    @ApiResponses(value = {
            @ApiResponse(code = 200,
                    responseHeaders = {
                        @ResponseHeader(name = "x-v", response = Integer.class, description = "The [version](#response-headers) of the API endpoint that the data holder has responded with."),
                        @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction.")
                    },
                    message = "Successful response",
                    response = EnergyUsageListResponse.class),
            @ApiResponse(code = 400,
                    responseHeaders = @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction."),
                    message = "Invalid Version / Invalid Page Size / Missing Field / Invalid Field / Invalid Date",
                    response = ErrorListResponse.class),
            @ApiResponse(code = 406,
                    responseHeaders = @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction."),
                    message = "Unsupported Version",
                    response = ErrorListResponse.class),
            @ApiResponse(code = 422,
                    responseHeaders = @ResponseHeader(name = "x-fapi-interaction-id", response = UUID.class, description = "An **[[RFC4122]](#nref-RFC4122)** UUID used as a correlation id. If provided, the data holder **MUST** play back this value in the _x-fapi-interaction-id_ response header. If not provided a **[[RFC4122]](#nref-RFC4122)** UUID value is required to be provided in the response header to track the interaction."),
                    message = "Invalid Service Point / Unavailable Service Point / Invalid Page",
                    response = ErrorListResponse.class)
    })
    @RequestMapping(
            method = RequestMethod.POST,
            value = "/energy/electricity/servicepoints/usage",
            produces = {"application/json"},
            consumes = {"application/json"}
    )
    @PreAuthorize("hasAuthority('SCOPE_energy:electricity.usage:read')")
    ResponseEntity<EnergyUsageListResponse> listUsageForServicePoints(
            @ApiParam(
                    value = "Version of the API endpoint requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [_x-min-v_](#request-headers) and [_x-v_](#request-headers). If the value of [_x-min-v_](#request-headers) is equal to or higher than the value of [_x-v_](#request-headers) then the [_x-min-v_](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder **MUST** respond with a `406 Not Acceptable`. See [HTTP Headers](#request-headers).",
                    required = true)
            @RequestHeader(value = "x-v", required = false)
                    Integer xV,
            @ApiParam(
                    value = "Minimum version of the API endpoint requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [_x-min-v_](#request-headers) and [_x-v_](#request-headers). If all versions requested are not supported then the data holder **MUST** respond with a `406 Not Acceptable`.")
            @RequestHeader(value = "x-min-v",
                    required = false)
                    Integer xMinV,
            @ApiParam(
                    value = "Request payload containing list of specific Service Points to obtain data for",
                    required = true)
            @Valid
            @RequestBody
                    RequestServicePointIds servicePointIdList,
            @ApiParam(
                    value = "Constrain the request to records with effective date at or after this date. If absent defaults to newest-date minus 24 months.  Format is aligned to DateString common type")
            @Valid
            @RequestParam(value = "oldest-date",
                    required = false)
                    LocalDate oldestDate,
            @ApiParam(
                    value = "Constrain the request to records with effective date at or before this date.  If absent defaults to current date.  Format is aligned to DateString common type")
            @Valid
            @RequestParam(value = "newest-date",
                    required = false)
                    LocalDate newestDate,
            @ApiParam(
                    value = "Page of results to request (standard pagination)")
            @Valid
            @RequestParam(value = "page",
                    required = false)
                    Integer page,
            @ApiParam(
                    value = "Page size to request.  Default is 25 (standard pagination)")
            @Valid
            @RequestParam(value = "page-size",
                    required = false)
                    Integer pageSize,
            @ApiParam(
                    value = "An [RFC4122](https://tools.ietf.org/html/rfc4122) UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction.")
            @RequestHeader(value = "x-fapi-interaction-id",
                    required = false)
                    UUID xFapiInteractionId,
            @ApiParam(
                    value = "The time when the customer last logged in to the Data Recipient Software Product as described in **[[FAPI-1.0-Baseline]](#nref-FAPI-1-0-Baseline)**. Required for all resource calls (customer present and unattended). Not required for unauthenticated calls.")
            @RequestHeader(value = "x-fapi-auth-date",
                    required = false)
                    @NotNull @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, fallbackPatterns = DateFormat.HTTP) Date xFapiAuthDate,
            @ApiParam(
                    value = "The customer's original IP address if the customer is currently logged in to the data recipient. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls.")
            @RequestHeader(
                    value = "x-fapi-customer-ip-address",
                    required = false)
                    String xFapiCustomerIpAddress,
            @ApiParam(
                    value = "The customer's original standard http headers [Base64](#common-field-types) encoded, including the original User Agent header, if the customer is currently logged in to the data recipient. Mandatory for customer present calls.  Not required for unattended or unauthenticated calls.")
            @RequestHeader(value = "x-cds-client-headers",
                    required = false)
                    String xCdsClientHeaders,
            @ApiParam(
                    value = "Type of interval reads. Any one of the valid values for this field can be supplied. If absent defaults to NONE")
            @Valid
            @RequestParam(value = "interval-reads",
                    defaultValue = "NONE")
            ParamIntervalReadsEnum intervalReads);

}
