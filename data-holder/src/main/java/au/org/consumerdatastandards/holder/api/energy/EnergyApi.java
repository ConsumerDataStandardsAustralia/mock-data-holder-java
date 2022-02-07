package au.org.consumerdatastandards.holder.api.energy;

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
import au.org.consumerdatastandards.holder.model.ErrorListResponse;
import au.org.consumerdatastandards.holder.model.energy.ParamEffective;
import au.org.consumerdatastandards.holder.model.energy.ParamFuelTypeEnum;
import au.org.consumerdatastandards.holder.model.energy.ParamTypeEnum;
import au.org.consumerdatastandards.holder.model.energy.RequestAccountIds;
import au.org.consumerdatastandards.holder.model.energy.RequestServicePointIds;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.time.OffsetDateTime;
import java.util.UUID;

@Api(value = "energy", description = "the energy API")
public interface EnergyApi {

    /**
     * GET /energy/accounts/{accountId} : Get Energy Account Detail
     * Obtain detailed information for a specific energy account
     *
     * @param accountId              ID of a specific account to obtain data for.  This is a tokenised ID previous obtained from the Account List end point. (required)
     * @param xV                     Version of the API end point requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If the value of [x-min-v](#request-headers) is equal to or higher than the value of [x-v](#request-headers) then the [x-min-v](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable. See [HTTP Headers](#request-headers) (required)
     * @param xMinV                  Minimum version of the API end point requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable. (optional)
     * @param xFapiInteractionId     An [RFC4122](https://tools.ietf.org/html/rfc4122) UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction. (optional)
     * @param xFapiAuthDate          The time when the customer last logged in to the data recipient. Required for all resource calls (customer present and unattended). Not to be included for unauthenticated calls. (optional)
     * @param xFapiCustomerIpAddress The customer&#39;s original IP address if the customer is currently logged in to the data recipient. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls. (optional)
     * @param xCdsClientHeaders      The customer&#39;s original standard http headers [Base64](#common-field-types) encoded, including the original User Agent header, if the customer is currently logged in to the data recipient. Mandatory for customer present calls.  Not required for unattended or unauthenticated calls. (optional)
     * @return Successful response (status code 200)
     * or The following error codes MUST be supported:&lt;br/&gt;&lt;ul class&#x3D;\&quot;error-code-list\&quot;&gt;&lt;li&gt;[400 - Invalid Field](#error-400-field-invalid)&lt;/li&gt;&lt;li&gt;[400 - Invalid Version](#error-400-header-invalid-version)&lt;/li&gt;&lt;li&gt;[406 - Unsupported Version](#error-406-header-unsupported-version)&lt;/li&gt;&lt;li&gt;[404 - Unavailable Energy Account](#error-404-unavailable-energy-account)&lt;/li&gt;&lt;li&gt;[404 - Invalid Energy Account](#error-404-invalid-energy-account)&lt;/li&gt;&lt;/ul&gt; (status code 4xx)
     */
    @ApiOperation(value = "Get Energy Account Detail",
            nickname = "getAccount",
            notes = "Obtain detailed information for a specific energy account",
            response = EnergyAccountDetailResponse.class,
            tags = {"Energy", "Energy Accounts",})
    @ApiResponses(value = {
            @ApiResponse(code = 200,
                    message = "Successful response",
                    response = EnergyAccountDetailResponse.class),
            @ApiResponse(code = 400,
                    message = "Invalid Version / Invalid Field",
                    response = ErrorListResponse.class),
            @ApiResponse(code = 406,
                    message = "Unsupported Version",
                    response = ErrorListResponse.class),
            @ApiResponse(code = 404,
                    message = "Unavailable Energy Account / Invalid Energy Account",
                    response = ErrorListResponse.class)
    })
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/energy/accounts/{accountId}",
            produces = {"application/json"}
    )
    ResponseEntity<EnergyAccountDetailResponse> getAccount(
            @ApiParam(
                    value = "ID of a specific account to obtain data for.  This is a tokenised ID previous obtained from the Account List end point.",
                    required = true)
            @PathVariable("accountId")
                    String accountId,
            @ApiParam(
                    value = "Version of the API end point requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If the value of [x-min-v](#request-headers) is equal to or higher than the value of [x-v](#request-headers) then the [x-min-v](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable. See [HTTP Headers](#request-headers)",
                    required = true)
            @RequestHeader(value = "x-v", required = false)
                    Integer xV,
            @ApiParam(
                    value = "Minimum version of the API end point requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable.")
            @RequestHeader(value = "x-min-v",
                    required = false)
                    Integer xMinV,
            @ApiParam(
                    value = "An [RFC4122](https://tools.ietf.org/html/rfc4122) UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction.")
            @RequestHeader(value = "x-fapi-interaction-id",
                    required = false)
                    UUID xFapiInteractionId,
            @ApiParam(
                    value = "The time when the customer last logged in to the data recipient. Required for all resource calls (customer present and unattended). Not to be included for unauthenticated calls.")
            @RequestHeader(value = "x-fapi-auth-date",
                    required = false)
                    String xFapiAuthDate,
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
     * @param xV                     Version of the API end point requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If the value of [x-min-v](#request-headers) is equal to or higher than the value of [x-v](#request-headers) then the [x-min-v](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable. See [HTTP Headers](#request-headers) (required)
     * @param xMinV                  Minimum version of the API end point requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable. (optional)
     * @param xFapiInteractionId     An [RFC4122](https://tools.ietf.org/html/rfc4122) UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction. (optional)
     * @param xFapiAuthDate          The time when the customer last logged in to the data recipient. Required for all resource calls (customer present and unattended). Not to be included for unauthenticated calls. (optional)
     * @param xFapiCustomerIpAddress The customer&#39;s original IP address if the customer is currently logged in to the data recipient. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls. (optional)
     * @param xCdsClientHeaders      The customer&#39;s original standard http headers [Base64](#common-field-types) encoded, including the original User Agent header, if the customer is currently logged in to the data recipient. Mandatory for customer present calls.  Not required for unattended or unauthenticated calls. (optional)
     * @return Successful response (status code 200)
     * or The following error codes MUST be supported:&lt;br/&gt;&lt;ul class&#x3D;\&quot;error-code-list\&quot;&gt;&lt;li&gt;[400 - Invalid Field](#error-400-field-invalid)&lt;/li&gt;&lt;li&gt;[400 - Invalid Version](#error-400-header-invalid-version)&lt;/li&gt;&lt;li&gt;[406 - Unsupported Version](#error-406-header-unsupported-version)&lt;/li&gt;&lt;li&gt;[404 - Unavailable Energy Account](#error-404-unavailable-energy-account)&lt;/li&gt;&lt;li&gt;[404 - Invalid Energy Account](#error-404-invalid-energy-account)&lt;/li&gt;&lt;/ul&gt; (status code 4xx)
     */
    @ApiOperation(value = "Get Balance For Energy Account",
            nickname = "getBalanceForAccount",
            notes = "Obtain the current balance for a specific account",
            response = EnergyBalanceResponse.class,
            tags = {"Energy", "Billing",})
    @ApiResponses(value = {
            @ApiResponse(code = 200,
                    message = "Successful response",
                    response = EnergyBalanceResponse.class),
            @ApiResponse(code = 400,
                    message = "Invalid Version / Invalid Field",
                    response = ErrorListResponse.class),
            @ApiResponse(code = 406,
                    message = "Unsupported Version",
                    response = ErrorListResponse.class),
            @ApiResponse(code = 404,
                    message = "Unavailable Energy Account / Invalid Energy Account",
                    response = ErrorListResponse.class)
    })
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/energy/accounts/{accountId}/balance",
            produces = {"application/json"}
    )
    ResponseEntity<EnergyBalanceResponse> getBalanceForAccount(
            @ApiParam(
                    value = "ID of a specific account to obtain data for.  This is a tokenised ID previous obtained from the Account List end point.",
                    required = true)
            @PathVariable("accountId")
                    String accountId,
            @ApiParam(
                    value = "Version of the API end point requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If the value of [x-min-v](#request-headers) is equal to or higher than the value of [x-v](#request-headers) then the [x-min-v](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable. See [HTTP Headers](#request-headers)",
                    required = true)
            @RequestHeader(value = "x-v", required = false)
                    Integer xV,
            @ApiParam(
                    value = "Minimum version of the API end point requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable.")
            @RequestHeader(value = "x-min-v",
                    required = false)
                    Integer xMinV,
            @ApiParam(
                    value = "An [RFC4122](https://tools.ietf.org/html/rfc4122) UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction.")
            @RequestHeader(value = "x-fapi-interaction-id",
                    required = false)
                    UUID xFapiInteractionId,
            @ApiParam(
                    value = "The time when the customer last logged in to the data recipient. Required for all resource calls (customer present and unattended). Not to be included for unauthenticated calls.")
            @RequestHeader(value = "x-fapi-auth-date",
                    required = false)
                    String xFapiAuthDate,
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
     * @param xV                     Version of the API end point requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If the value of [x-min-v](#request-headers) is equal to or higher than the value of [x-v](#request-headers) then the [x-min-v](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable. See [HTTP Headers](#request-headers) (required)
     * @param newestTime             Constrain the request to records with effective time at or before this date/time.  If absent defaults to current date/time.  Format is aligned to DateTimeString common type (optional)
     * @param oldestTime             Constrain the request to records with effective time at or after this date/time. If absent defaults to newest-time minus 12 months.  Format is aligned to DateTimeString common type (optional)
     * @param page                   Page of results to request (standard pagination) (optional)
     * @param pageSize               Page size to request.  Default is 25 (standard pagination) (optional)
     * @param xMinV                  Minimum version of the API end point requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable. (optional)
     * @param xFapiInteractionId     An [RFC4122](https://tools.ietf.org/html/rfc4122) UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction. (optional)
     * @param xFapiAuthDate          The time when the customer last logged in to the data recipient. Required for all resource calls (customer present and unattended). Not to be included for unauthenticated calls. (optional)
     * @param xFapiCustomerIpAddress The customer&#39;s original IP address if the customer is currently logged in to the data recipient. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls. (optional)
     * @param xCdsClientHeaders      The customer&#39;s original standard http headers [Base64](#common-field-types) encoded, including the original User Agent header, if the customer is currently logged in to the data recipient. Mandatory for customer present calls.  Not required for unattended or unauthenticated calls. (optional)
     * @return Successful response (status code 200)
     * or The following error codes MUST be supported:&lt;br/&gt;&lt;ul class&#x3D;\&quot;error-code-list\&quot;&gt;&lt;li&gt;[400 - Invalid Field](#error-400-field-invalid)&lt;/li&gt;&lt;li&gt;[400 - Invalid Page Size](#error-400-field-invalid-page-size)&lt;/li&gt;&lt;li&gt;[400 - Invalid Version](#error-400-header-invalid-version)&lt;/li&gt;&lt;li&gt;[406 - Unsupported Version](#error-406-header-unsupported-version)&lt;/li&gt;&lt;li&gt;[422 - Invalid Page](#error-422-field-invalid-page)&lt;/li&gt;&lt;li&gt;[404 - Unavailable Energy Account](#error-404-unavailable-energy-account)&lt;/li&gt;&lt;li&gt;[404 - Invalid Energy Account](#error-404-invalid-energy-account)&lt;/li&gt;&lt;/ul&gt; (status code 4xx)
     */
    @ApiOperation(value = "Get Billing For Account",
            nickname = "getBillingForAccount",
            notes = "Obtain the billing transactions for a specific account",
            response = EnergyBillingListResponse.class,
            tags = {"Energy", "Billing",})
    @ApiResponses(value = {
            @ApiResponse(code = 200,
                    message = "Successful response",
                    response = EnergyBalanceResponse.class),
            @ApiResponse(code = 400,
                    message = "Invalid Version / Invalid Field / Invalid Page Size",
                    response = ErrorListResponse.class),
            @ApiResponse(code = 406,
                    message = "Unsupported Version",
                    response = ErrorListResponse.class),
            @ApiResponse(code = 404,
                    message = "Unavailable Energy Account / Invalid Energy Account",
                    response = ErrorListResponse.class),
            @ApiResponse(code = 422,
                    message = "Invalid Page",
                    response = ErrorListResponse.class)
    })
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/energy/accounts/{accountId}/billing",
            produces = {"application/json"}
    )
    ResponseEntity<EnergyBillingListResponse> getBillingForAccount(
            @ApiParam(
                    value = "ID of a specific account to obtain data for.  This is a tokenised ID previous obtained from the Account List end point.",
                    required = true)
            @PathVariable("accountId")
                    String accountId,
            @ApiParam(
                    value = "Version of the API end point requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If the value of [x-min-v](#request-headers) is equal to or higher than the value of [x-v](#request-headers) then the [x-min-v](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable. See [HTTP Headers](#request-headers)",
                    required = true)
            @RequestHeader(value = "x-v", required = false)
                    Integer xV,
            @ApiParam(
                    value = "Minimum version of the API end point requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable.")
            @RequestHeader(value = "x-min-v",
                    required = false)
                    Integer xMinV,
            @ApiParam(
                    value = "Constrain the request to records with effective time at or before this date/time.  If absent defaults to current date/time.  Format is aligned to DateTimeString common type")
            @Valid
            @RequestParam(value = "newest-time",
                    required = false)
                    String newestTime,
            @ApiParam(
                    value = "Constrain the request to records with effective time at or after this date/time. If absent defaults to newest-time minus 12 months.  Format is aligned to DateTimeString common type")
            @Valid
            @RequestParam(value = "oldest-time",
                    required = false)
                    String oldestTime,
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
                    value = "The time when the customer last logged in to the data recipient. Required for all resource calls (customer present and unattended). Not to be included for unauthenticated calls.")
            @RequestHeader(value = "x-fapi-auth-date",
                    required = false)
                    String xFapiAuthDate,
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
     * @param xV                     Version of the API end point requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If the value of [x-min-v](#request-headers) is equal to or higher than the value of [x-v](#request-headers) then the [x-min-v](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable. See [HTTP Headers](#request-headers) (required)
     * @param xMinV                  Minimum version of the API end point requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable. (optional)
     * @param xFapiInteractionId     An [RFC4122](https://tools.ietf.org/html/rfc4122) UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction. (optional)
     * @param xFapiAuthDate          The time when the customer last logged in to the data recipient. Required for all resource calls (customer present and unattended). Not to be included for unauthenticated calls. (optional)
     * @param xFapiCustomerIpAddress The customer&#39;s original IP address if the customer is currently logged in to the data recipient. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls. (optional)
     * @param xCdsClientHeaders      The customer&#39;s original standard http headers [Base64](#common-field-types) encoded, including the original User Agent header, if the customer is currently logged in to the data recipient. Mandatory for customer present calls.  Not required for unattended or unauthenticated calls. (optional)
     * @return Successful response (status code 200)
     * or The following error codes MUST be supported:&lt;br/&gt;&lt;ul class&#x3D;\&quot;error-code-list\&quot;&gt;&lt;li&gt;[400 - Invalid Field](#error-400-field-invalid)&lt;/li&gt;&lt;li&gt;[400 - Invalid Version](#error-400-header-invalid-version)&lt;/li&gt;&lt;li&gt;[406 - Unsupported Version](#error-406-header-unsupported-version)&lt;/li&gt;&lt;li&gt;[404 - Unavailable Energy Account](#error-404-unavailable-energy-account)&lt;/li&gt;&lt;li&gt;[404 - Invalid Energy Account](#error-404-invalid-energy-account)&lt;/li&gt;&lt;/ul&gt; (status code 4xx)
     */
    @ApiOperation(value = "Get Concessions",
            nickname = "getConcessions",
            notes = "Obtain the details of any concessions or arrangements applied to a specific energy account",
            response = EnergyConcessionsResponse.class,
            tags = {"Energy", "Energy Accounts",})
    @ApiResponses(value = {
            @ApiResponse(code = 200,
                    message = "Successful response",
                    response = EnergyBalanceResponse.class),
            @ApiResponse(code = 400,
                    message = "Invalid Version / Invalid Field",
                    response = ErrorListResponse.class),
            @ApiResponse(code = 406,
                    message = "Unsupported Version",
                    response = ErrorListResponse.class),
            @ApiResponse(code = 404,
                    message = "Unavailable Energy Account / Invalid Energy Account",
                    response = ErrorListResponse.class)
    })
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/energy/accounts/{accountId}/concessions",
            produces = {"application/json"}
    )
    ResponseEntity<EnergyConcessionsResponse> getConcessions(
            @ApiParam(
                    value = "ID of a specific account to obtain data for.  This is a tokenised ID previous obtained from the Account List end point.",
                    required = true)
            @PathVariable("accountId")
                    String accountId,
            @ApiParam(
                    value = "Version of the API end point requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If the value of [x-min-v](#request-headers) is equal to or higher than the value of [x-v](#request-headers) then the [x-min-v](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable. See [HTTP Headers](#request-headers)",
                    required = true)
            @RequestHeader(value = "x-v", required = false)
                    Integer xV,
            @ApiParam(
                    value = "Minimum version of the API end point requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable.")
            @RequestHeader(value = "x-min-v",
                    required = false)
                    Integer xMinV,
            @ApiParam(
                    value = "An [RFC4122](https://tools.ietf.org/html/rfc4122) UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction.")
            @RequestHeader(value = "x-fapi-interaction-id",
                    required = false)
                    UUID xFapiInteractionId,
            @ApiParam(
                    value = "The time when the customer last logged in to the data recipient. Required for all resource calls (customer present and unattended). Not to be included for unauthenticated calls.")
            @RequestHeader(value = "x-fapi-auth-date",
                    required = false)
                    String xFapiAuthDate,
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
     * @param xV                     Version of the API end point requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If the value of [x-min-v](#request-headers) is equal to or higher than the value of [x-v](#request-headers) then the [x-min-v](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable. See [HTTP Headers](#request-headers) (required)
     * @param xMinV                  Minimum version of the API end point requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable. (optional)
     * @param xFapiInteractionId     An [RFC4122](https://tools.ietf.org/html/rfc4122) UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction. (optional)
     * @param xFapiAuthDate          The time when the customer last logged in to the data recipient. Required for all resource calls (customer present and unattended). Not to be included for unauthenticated calls. (optional)
     * @param xFapiCustomerIpAddress The customer&#39;s original IP address if the customer is currently logged in to the data recipient. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls. (optional)
     * @param xCdsClientHeaders      The customer&#39;s original standard http headers [Base64](#common-field-types) encoded, including the original User Agent header, if the customer is currently logged in to the data recipient. Mandatory for customer present calls.  Not required for unattended or unauthenticated calls. (optional)
     * @return Successful response (status code 200)
     * or The following error codes MUST be supported:&lt;br/&gt;&lt;ul class&#x3D;\&quot;error-code-list\&quot;&gt;&lt;li&gt;[400 - Invalid Field](#error-400-field-invalid)&lt;/li&gt;&lt;li&gt;[400 - Invalid Version](#error-400-header-invalid-version)&lt;/li&gt;&lt;li&gt;[406 - Unsupported Version](#error-406-header-unsupported-version)&lt;/li&gt;&lt;li&gt;[404 - Unavailable Service Point](#error-404-unavailable-service-point)&lt;/li&gt;&lt;li&gt;[404 - Invalid Service Point](#error-404-invalid-service-point)&lt;/li&gt;&lt;/ul&gt; (status code 4xx)
     */
    @ApiOperation(value = "Get DER For Service Point",
            nickname = "getDERForServicePoint",
            notes = "Obtain a list of DER data from a particular service point",
            response = EnergyDerDetailResponse.class,
            tags = {"Energy", "Distributed Energy Resources",})
    @ApiResponses(value = {
            @ApiResponse(code = 200,
                    message = "Successful response",
                    response = EnergyDerDetailResponse.class),
            @ApiResponse(code = 400,
                    message = "Invalid Version / Invalid Field",
                    response = ErrorListResponse.class),
            @ApiResponse(code = 406,
                    message = "Unsupported Version",
                    response = ErrorListResponse.class),
            @ApiResponse(code = 404,
                    message = "Unavailable Energy Account / Invalid Energy Account",
                    response = ErrorListResponse.class)
    })
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/energy/electricity/servicepoints/{servicePointId}/der",
            produces = {"application/json"}
    )
    ResponseEntity<EnergyDerDetailResponse> getDERForServicePoint(
            @ApiParam(
                    value = "ID of the specific service point requested.  This is a tokenised ID previous obtained from the Service Point List Data end point.  Note that it is not a nationalMeteringId.",
                    required = true)
            @PathVariable("servicePointId")
                    String servicePointId,
            @ApiParam(
                    value = "Version of the API end point requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If the value of [x-min-v](#request-headers) is equal to or higher than the value of [x-v](#request-headers) then the [x-min-v](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable. See [HTTP Headers](#request-headers)",
                    required = true)
            @RequestHeader(value = "x-v", required = false)
                    Integer xV,
            @ApiParam(
                    value = "Minimum version of the API end point requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable.")
            @RequestHeader(value = "x-min-v",
                    required = false)
                    Integer xMinV,
            @ApiParam(
                    value = "An [RFC4122](https://tools.ietf.org/html/rfc4122) UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction.")
            @RequestHeader(value = "x-fapi-interaction-id",
                    required = false)
                    UUID xFapiInteractionId,
            @ApiParam(
                    value = "The time when the customer last logged in to the data recipient. Required for all resource calls (customer present and unattended). Not to be included for unauthenticated calls.")
            @RequestHeader(value = "x-fapi-auth-date",
                    required = false)
                    String xFapiAuthDate,
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
     * @param xV                     Version of the API end point requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If the value of [x-min-v](#request-headers) is equal to or higher than the value of [x-v](#request-headers) then the [x-min-v](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable. See [HTTP Headers](#request-headers) (required)
     * @param newestDate             Constrain the request to records with effective date at or before this date.  If absent defaults to current date.  Format is aligned to DateString common type (optional)
     * @param oldestDate             Constrain the request to records with effective date at or after this date. If absent defaults to newest-date minus 24 months days.  Format is aligned to DateString common type (optional)
     * @param page                   Page of results to request (standard pagination) (optional)
     * @param pageSize               Page size to request.  Default is 25 (standard pagination) (optional)
     * @param xMinV                  Minimum version of the API end point requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable. (optional)
     * @param xFapiInteractionId     An [RFC4122](https://tools.ietf.org/html/rfc4122) UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction. (optional)
     * @param xFapiAuthDate          The time when the customer last logged in to the data recipient. Required for all resource calls (customer present and unattended). Not to be included for unauthenticated calls. (optional)
     * @param xFapiCustomerIpAddress The customer&#39;s original IP address if the customer is currently logged in to the data recipient. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls. (optional)
     * @param xCdsClientHeaders      The customer&#39;s original standard http headers [Base64](#common-field-types) encoded, including the original User Agent header, if the customer is currently logged in to the data recipient. Mandatory for customer present calls.  Not required for unattended or unauthenticated calls. (optional)
     * @return Successful response (status code 200)
     * or The following error codes MUST be supported:&lt;br/&gt;&lt;ul class&#x3D;\&quot;error-code-list\&quot;&gt;&lt;li&gt;[400 - Invalid Field](#error-400-field-invalid)&lt;/li&gt;&lt;li&gt;[400 - Invalid Page Size](#error-400-field-invalid-page-size)&lt;/li&gt;&lt;li&gt;[400 - Invalid Version](#error-400-header-invalid-version)&lt;/li&gt;&lt;li&gt;[406 - Unsupported Version](#error-406-header-unsupported-version)&lt;/li&gt;&lt;li&gt;[422 - Invalid Page](#error-422-field-invalid-page)&lt;/li&gt;&lt;li&gt;[404 - Unavailable Energy Account](#error-404-unavailable-energy-account)&lt;/li&gt;&lt;li&gt;[404 - Invalid Energy Account](#error-404-invalid-energy-account)&lt;/li&gt;&lt;/ul&gt; (status code 4xx)
     */
    @ApiOperation(value = "Get Invoices For Account",
            nickname = "getInvoicesForAccount",
            notes = "Obtain the invoices for a specific account",
            response = EnergyInvoiceListResponse.class,
            tags = {"Energy", "Billing",})
    @ApiResponses(value = {
            @ApiResponse(code = 200,
                    message = "Successful response",
                    response = EnergyInvoiceListResponse.class),
            @ApiResponse(code = 400,
                    message = "Invalid Version / Invalid Field / Invalid Page Size",
                    response = ErrorListResponse.class),
            @ApiResponse(code = 406,
                    message = "Unsupported Version",
                    response = ErrorListResponse.class),
            @ApiResponse(code = 404,
                    message = "Unavailable Energy Account / Invalid Energy Account",
                    response = ErrorListResponse.class),
            @ApiResponse(code = 422,
                    message = "Invalid Page",
                    response = ErrorListResponse.class)
    })
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/energy/accounts/{accountId}/invoices",
            produces = {"application/json"}
    )
    ResponseEntity<EnergyInvoiceListResponse> getInvoicesForAccount(
            @ApiParam(
                    value = "ID of a specific account to obtain data for.  This is a tokenised ID previous obtained from the Account List end point.",
                    required = true)
            @PathVariable("accountId")
                    String accountId,
            @ApiParam(
                    value = "Version of the API end point requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If the value of [x-min-v](#request-headers) is equal to or higher than the value of [x-v](#request-headers) then the [x-min-v](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable. See [HTTP Headers](#request-headers)",
                    required = true)
            @RequestHeader(value = "x-v", required = false)
                    Integer xV,
            @ApiParam(
                    value = "Minimum version of the API end point requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable.")
            @RequestHeader(value = "x-min-v",
                    required = false)
                    Integer xMinV,
            @ApiParam(
                    value = "Constrain the request to records with effective date at or before this date.  If absent defaults to current date.  Format is aligned to DateString common type")
            @Valid
            @RequestParam(value = "newest-date",
                    required = false)
                    String newestDate,
            @ApiParam(
                    value = "Constrain the request to records with effective date at or after this date. If absent defaults to newest-date minus 24 months days.  Format is aligned to DateString common type")
            @Valid
            @RequestParam(value = "oldest-date",
                    required = false)
                    String oldestDate,
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
                    value = "The time when the customer last logged in to the data recipient. Required for all resource calls (customer present and unattended). Not to be included for unauthenticated calls.")
            @RequestHeader(value = "x-fapi-auth-date",
                    required = false)
                    String xFapiAuthDate,
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
     * Obtain the agreed payment schedule and details, if any, for a specific energy account
     *
     * @param accountId              ID of a specific account to obtain data for.  This is a tokenised ID previous obtained from the Account List end point. (required)
     * @param xV                     Version of the API end point requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If the value of [x-min-v](#request-headers) is equal to or higher than the value of [x-v](#request-headers) then the [x-min-v](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable. See [HTTP Headers](#request-headers) (required)
     * @param xMinV                  Minimum version of the API end point requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable. (optional)
     * @param xFapiInteractionId     An [RFC4122](https://tools.ietf.org/html/rfc4122) UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction. (optional)
     * @param xFapiAuthDate          The time when the customer last logged in to the data recipient. Required for all resource calls (customer present and unattended). Not to be included for unauthenticated calls. (optional)
     * @param xFapiCustomerIpAddress The customer&#39;s original IP address if the customer is currently logged in to the data recipient. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls. (optional)
     * @param xCdsClientHeaders      The customer&#39;s original standard http headers [Base64](#common-field-types) encoded, including the original User Agent header, if the customer is currently logged in to the data recipient. Mandatory for customer present calls.  Not required for unattended or unauthenticated calls. (optional)
     * @return Successful response (status code 200)
     * or The following error codes MUST be supported:&lt;br/&gt;&lt;ul class&#x3D;\&quot;error-code-list\&quot;&gt;&lt;li&gt;[400 - Invalid Field](#error-400-field-invalid)&lt;/li&gt;&lt;li&gt;[400 - Invalid Version](#error-400-header-invalid-version)&lt;/li&gt;&lt;li&gt;[406 - Unsupported Version](#error-406-header-unsupported-version)&lt;/li&gt;&lt;li&gt;[404 - Unavailable Energy Account](#error-404-unavailable-energy-account)&lt;/li&gt;&lt;li&gt;[404 - Invalid Energy Account](#error-404-invalid-energy-account)&lt;/li&gt;&lt;/ul&gt; (status code 4xx)
     */
    @ApiOperation(value = "Get Agreed Payment Schedule",
            nickname = "getPaymentSchedule",
            notes = "Obtain the agreed payment schedule and details, if any, for a specific energy account",
            response = EnergyPaymentScheduleResponse.class,
            tags = {"Energy", "Energy Accounts",})
    @ApiResponses(value = {
            @ApiResponse(code = 200,
                    message = "Successful response",
                    response = EnergyPaymentScheduleResponse.class),
            @ApiResponse(code = 400,
                    message = "Invalid Version / Invalid Field",
                    response = ErrorListResponse.class),
            @ApiResponse(code = 406,
                    message = "Unsupported Version",
                    response = ErrorListResponse.class),
            @ApiResponse(code = 404,
                    message = "Unavailable Energy Account / Invalid Energy Account",
                    response = ErrorListResponse.class)
    })
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/energy/accounts/{accountId}/payment-schedule",
            produces = {"application/json"}
    )
    ResponseEntity<EnergyPaymentScheduleResponse> getPaymentSchedule(
            @ApiParam(
                    value = "ID of a specific account to obtain data for.  This is a tokenised ID previous obtained from the Account List end point.",
                    required = true)
            @PathVariable("accountId")
                    String accountId,
            @ApiParam(
                    value = "Version of the API end point requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If the value of [x-min-v](#request-headers) is equal to or higher than the value of [x-v](#request-headers) then the [x-min-v](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable. See [HTTP Headers](#request-headers)",
                    required = true)
            @RequestHeader(value = "x-v", required = false)
                    Integer xV,
            @ApiParam(
                    value = "Minimum version of the API end point requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable.")
            @RequestHeader(value = "x-min-v",
                    required = false)
                    Integer xMinV,
            @ApiParam(
                    value = "An [RFC4122](https://tools.ietf.org/html/rfc4122) UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction.")
            @RequestHeader(value = "x-fapi-interaction-id",
                    required = false)
                    UUID xFapiInteractionId,
            @ApiParam(
                    value = "The time when the customer last logged in to the data recipient. Required for all resource calls (customer present and unattended). Not to be included for unauthenticated calls.")
            @RequestHeader(value = "x-fapi-auth-date",
                    required = false)
                    String xFapiAuthDate,
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
     * @param xV                 Version of the API end point requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If the value of [x-min-v](#request-headers) is equal to or higher than the value of [x-v](#request-headers) then the [x-min-v](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable. See [HTTP Headers](#request-headers) (required)
     * @param xMinV              Minimum version of the API end point requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable. (optional)
     * @param xFapiInteractionId An [RFC4122](https://tools.ietf.org/html/rfc4122) UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction. (optional)
     * @return Successful response (status code 200)
     * or The following error codes MUST be supported:&lt;br/&gt;&lt;ul class&#x3D;\&quot;error-code-list\&quot;&gt;&lt;li&gt;[400 - Invalid Field](#error-400-field-invalid)&lt;/li&gt;&lt;li&gt;[400 - Invalid Version](#error-400-header-invalid-version)&lt;/li&gt;&lt;li&gt;[404 - Invalid Resource](#error-404-resource-invalid)&lt;/li&gt;&lt;li&gt;[406 - Unsupported Version](#error-406-header-unsupported-version)&lt;/li&gt;&lt;/ul&gt; (status code 4xx)
     */
    @ApiOperation(value = "Get Generic Plan Detail",
            nickname = "getPlan",
            notes = "Obtain detailed information on a single energy plan offered openly to the market",
            response = EnergyPlanResponse.class,
            tags = {"Energy", "Generic Tariffs",})
    @ApiResponses(value = {
            @ApiResponse(code = 200,
                    message = "Successful response",
                    response = EnergyPlanResponse.class),
            @ApiResponse(code = 400,
                    message = "Invalid Version / Invalid Field",
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
                    value = "Version of the API end point requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If the value of [x-min-v](#request-headers) is equal to or higher than the value of [x-v](#request-headers) then the [x-min-v](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable. See [HTTP Headers](#request-headers)",
                    required = true)
            @RequestHeader(value = "x-v", required = false)
                    Integer xV,
            @ApiParam(
                    value = "Minimum version of the API end point requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable.")
            @RequestHeader(value = "x-min-v",
                    required = false)
                    Integer xMinV,
            @ApiParam(
                    value = "An [RFC4122](https://tools.ietf.org/html/rfc4122) UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction.")
            @RequestHeader(value = "x-fapi-interaction-id",
                    required = false)
                    UUID xFapiInteractionId);


    /**
     * GET /energy/electricity/servicepoints/{servicePointId} : Get Service Point Detail
     * Obtain detailed standing information for a specific service point that is owned by the customer that has authorised the current session
     *
     * @param servicePointId         ID of the specific service point requested.  This is a tokenised ID previous obtained from the Service Point List Data end point.  Note that it is not a nationalMeteringId. (required)
     * @param xV                     Version of the API end point requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If the value of [x-min-v](#request-headers) is equal to or higher than the value of [x-v](#request-headers) then the [x-min-v](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable. See [HTTP Headers](#request-headers) (required)
     * @param xMinV                  Minimum version of the API end point requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable. (optional)
     * @param xFapiInteractionId     An [RFC4122](https://tools.ietf.org/html/rfc4122) UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction. (optional)
     * @param xFapiAuthDate          The time when the customer last logged in to the data recipient. Required for all resource calls (customer present and unattended). Not to be included for unauthenticated calls. (optional)
     * @param xFapiCustomerIpAddress The customer&#39;s original IP address if the customer is currently logged in to the data recipient. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls. (optional)
     * @param xCdsClientHeaders      The customer&#39;s original standard http headers [Base64](#common-field-types) encoded, including the original User Agent header, if the customer is currently logged in to the data recipient. Mandatory for customer present calls.  Not required for unattended or unauthenticated calls. (optional)
     * @return Successful response (status code 200)
     * or The following error codes MUST be supported:&lt;br/&gt;&lt;ul class&#x3D;\&quot;error-code-list\&quot;&gt;&lt;li&gt;[400 - Invalid Field](#error-400-field-invalid)&lt;/li&gt;&lt;li&gt;[400 - Invalid Version](#error-400-header-invalid-version)&lt;/li&gt;&lt;li&gt;[406 - Unsupported Version](#error-406-header-unsupported-version)&lt;/li&gt;&lt;li&gt;[404 - Unavailable Service Point](#error-404-unavailable-service-point)&lt;/li&gt;&lt;li&gt;[404 - Invalid Service Point](#error-404-invalid-service-point)&lt;/li&gt;&lt;/ul&gt; (status code 4xx)
     */
    @ApiOperation(value = "Get Service Point Detail",
            nickname = "getServicePoint",
            notes = "Obtain detailed standing information for a specific service point that is owned by the customer that has authorised the current session",
            response = EnergyServicePointDetailResponse.class,
            tags = {"Energy", "NMI Standing Data",})
    @ApiResponses(value = {
            @ApiResponse(code = 200,
                    message = "Successful response",
                    response = EnergyServicePointDetailResponse.class),
            @ApiResponse(code = 400,
                    message = "Invalid Version / Invalid Field",
                    response = ErrorListResponse.class),
            @ApiResponse(code = 406,
                    message = "Unsupported Version",
                    response = ErrorListResponse.class),
            @ApiResponse(code = 404,
                    message = "Unavailable Service Point / Invalid Service Point",
                    response = ErrorListResponse.class)
    })
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/energy/electricity/servicepoints/{servicePointId}",
            produces = {"application/json"}
    )
    ResponseEntity<EnergyServicePointDetailResponse> getServicePoint(
            @ApiParam(
                    value = "ID of the specific service point requested.  This is a tokenised ID previous obtained from the Service Point List Data end point.  Note that it is not a nationalMeteringId.",
                    required = true)
            @PathVariable("servicePointId")
                    String servicePointId,
            @ApiParam(
                    value = "Version of the API end point requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If the value of [x-min-v](#request-headers) is equal to or higher than the value of [x-v](#request-headers) then the [x-min-v](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable. See [HTTP Headers](#request-headers)",
                    required = true)
            @RequestHeader(value = "x-v", required = false)
                    Integer xV,
            @ApiParam(
                    value = "Minimum version of the API end point requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable.")
            @RequestHeader(value = "x-min-v",
                    required = false)
                    Integer xMinV,
            @ApiParam(
                    value = "An [RFC4122](https://tools.ietf.org/html/rfc4122) UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction.")
            @RequestHeader(value = "x-fapi-interaction-id",
                    required = false)
                    UUID xFapiInteractionId,
            @ApiParam(
                    value = "The time when the customer last logged in to the data recipient. Required for all resource calls (customer present and unattended). Not to be included for unauthenticated calls.")
            @RequestHeader(value = "x-fapi-auth-date",
                    required = false)
                    String xFapiAuthDate,
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
     * @param xV                     Version of the API end point requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If the value of [x-min-v](#request-headers) is equal to or higher than the value of [x-v](#request-headers) then the [x-min-v](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable. See [HTTP Headers](#request-headers) (required)
     * @param oldestDate             Constrain the request to records with effective date at or after this date. If absent defaults to newest-date minus 24 months days.  Format is aligned to DateString common type (optional)
     * @param newestDate             Constrain the request to records with effective date at or before this date.  If absent defaults to current date.  Format is aligned to DateString common type (optional)
     * @param page                   Page of results to request (standard pagination) (optional)
     * @param pageSize               Page size to request.  Default is 25 (standard pagination) (optional)
     * @param xMinV                  Minimum version of the API end point requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable. (optional)
     * @param xFapiInteractionId     An [RFC4122](https://tools.ietf.org/html/rfc4122) UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction. (optional)
     * @param xFapiAuthDate          The time when the customer last logged in to the data recipient. Required for all resource calls (customer present and unattended). Not to be included for unauthenticated calls. (optional)
     * @param xFapiCustomerIpAddress The customer&#39;s original IP address if the customer is currently logged in to the data recipient. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls. (optional)
     * @param xCdsClientHeaders      The customer&#39;s original standard http headers [Base64](#common-field-types) encoded, including the original User Agent header, if the customer is currently logged in to the data recipient. Mandatory for customer present calls.  Not required for unattended or unauthenticated calls. (optional)
     * @return Successful response (status code 200)
     * or The following error codes MUST be supported:&lt;br/&gt;&lt;ul class&#x3D;\&quot;error-code-list\&quot;&gt;&lt;li&gt;[400 - Invalid Field](#error-400-field-invalid)&lt;/li&gt;&lt;li&gt;[400 - Invalid Page Size](#error-400-field-invalid-page-size)&lt;/li&gt;&lt;li&gt;[400 - Invalid Version](#error-400-header-invalid-version)&lt;/li&gt;&lt;li&gt;[406 - Unsupported Version](#error-406-header-unsupported-version)&lt;/li&gt;&lt;li&gt;[422 - Invalid Page](#error-422-field-invalid-page)&lt;/li&gt;&lt;li&gt;[404 - Unavailable Service Point](#error-404-unavailable-service-point)&lt;/li&gt;&lt;li&gt;[404 - Invalid Service Point](#error-404-invalid-service-point)&lt;/li&gt;&lt;/ul&gt; (status code 4xx)
     */
    @ApiOperation(value = "Get Usage For Service Point",
            nickname = "getUsageForServicePoint",
            notes = "Obtain a list of electricity usage data from a particular service point",
            response = EnergyUsageListResponse.class,
            tags = {"Energy", "Electricity Usage",})
    @ApiResponses(value = {
            @ApiResponse(code = 200,
                    message = "Successful response",
                    response = EnergyUsageListResponse.class),
            @ApiResponse(code = 400,
                    message = "Invalid Version / Invalid Field / Invalid Page Size",
                    response = ErrorListResponse.class),
            @ApiResponse(code = 406,
                    message = "Unsupported Version",
                    response = ErrorListResponse.class),
            @ApiResponse(code = 404,
                    message = "Unavailable Service Point / Invalid Service Point",
                    response = ErrorListResponse.class),
            @ApiResponse(code = 422,
                    message = "Invalid Page",
                    response = ErrorListResponse.class)
    })
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/energy/electricity/servicepoints/{servicePointId}/usage",
            produces = {"application/json"}
    )
    ResponseEntity<EnergyUsageListResponse> getUsageForServicePoint(
            @ApiParam(
                    value = "ID of the specific service point requested.  This is a tokenised ID previous obtained from the Service Point List Data end point.  Note that it is not a nationalMeteringId.",
                    required = true)
            @PathVariable("servicePointId")
                    String servicePointId,
            @ApiParam(
                    value = "Version of the API end point requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If the value of [x-min-v](#request-headers) is equal to or higher than the value of [x-v](#request-headers) then the [x-min-v](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable. See [HTTP Headers](#request-headers)",
                    required = true)
            @RequestHeader(value = "x-v", required = false)
                    Integer xV,
            @ApiParam(
                    value = "Minimum version of the API end point requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable.")
            @RequestHeader(value = "x-min-v",
                    required = false)
                    Integer xMinV,
            @ApiParam(
                    value = "Constrain the request to records with effective date at or after this date. If absent defaults to newest-date minus 24 months days.  Format is aligned to DateString common type")
            @Valid
            @RequestParam(value = "oldest-date",
                    required = false)
                    String oldestDate,
            @ApiParam(
                    value = "Constrain the request to records with effective date at or before this date.  If absent defaults to current date.  Format is aligned to DateString common type")
            @Valid
            @RequestParam(value = "newest-date",
                    required = false)
                    String newestDate,
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
                    value = "The time when the customer last logged in to the data recipient. Required for all resource calls (customer present and unattended). Not to be included for unauthenticated calls.")
            @RequestHeader(value = "x-fapi-auth-date",
                    required = false)
                    String xFapiAuthDate,
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
     * @param xV                     Version of the API end point requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If the value of [x-min-v](#request-headers) is equal to or higher than the value of [x-v](#request-headers) then the [x-min-v](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable. See [HTTP Headers](#request-headers) (required)
     * @param page                   Page of results to request (standard pagination) (optional)
     * @param pageSize               Page size to request.  Default is 25 (standard pagination) (optional)
     * @param xMinV                  Minimum version of the API end point requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable. (optional)
     * @param xFapiInteractionId     An [RFC4122](https://tools.ietf.org/html/rfc4122) UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction. (optional)
     * @param xFapiAuthDate          The time when the customer last logged in to the data recipient. Required for all resource calls (customer present and unattended). Not to be included for unauthenticated calls. (optional)
     * @param xFapiCustomerIpAddress The customer&#39;s original IP address if the customer is currently logged in to the data recipient. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls. (optional)
     * @param xCdsClientHeaders      The customer&#39;s original standard http headers [Base64](#common-field-types) encoded, including the original User Agent header, if the customer is currently logged in to the data recipient. Mandatory for customer present calls.  Not required for unattended or unauthenticated calls. (optional)
     * @return Successful response (status code 200)
     * or The following error codes MUST be supported:&lt;br/&gt;&lt;ul class&#x3D;\&quot;error-code-list\&quot;&gt;&lt;li&gt;[400 - Invalid Field](#error-400-field-invalid)&lt;/li&gt;&lt;li&gt;[400 - Invalid Page Size](#error-400-field-invalid-page-size)&lt;/li&gt;&lt;li&gt;[400 - Invalid Version](#error-400-header-invalid-version)&lt;/li&gt;&lt;li&gt;[406 - Unsupported Version](#error-406-header-unsupported-version)&lt;/li&gt;&lt;li&gt;[422 - Invalid Page](#error-422-field-invalid-page)&lt;/li&gt;&lt;/ul&gt; (status code 4xx)
     */
    @ApiOperation(value = "Get Energy Accounts",
            nickname = "listAccounts",
            notes = "Obtain the list of energy accounts available under the authorised consent",
            response = EnergyAccountListResponse.class,
            tags = {"Energy", "Energy Accounts",})
    @ApiResponses(value = {
            @ApiResponse(code = 200,
                    message = "Successful response",
                    response = EnergyInvoiceListResponse.class),
            @ApiResponse(code = 400,
                    message = "Invalid Version / Invalid Field / Invalid Page Size",
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
            value = "/energy/accounts",
            produces = {"application/json"}
    )
    ResponseEntity<EnergyAccountListResponse> listAccounts(
            @ApiParam(
                    value = "Version of the API end point requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If the value of [x-min-v](#request-headers) is equal to or higher than the value of [x-v](#request-headers) then the [x-min-v](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable. See [HTTP Headers](#request-headers)",
                    required = true)
            @RequestHeader(value = "x-v", required = false)
                    Integer xV,
            @ApiParam(
                    value = "Minimum version of the API end point requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable.")
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
                    value = "The time when the customer last logged in to the data recipient. Required for all resource calls (customer present and unattended). Not to be included for unauthenticated calls.")
            @RequestHeader(value = "x-fapi-auth-date",
                    required = false)
                    String xFapiAuthDate,
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
     * @param xV                     Version of the API end point requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If the value of [x-min-v](#request-headers) is equal to or higher than the value of [x-v](#request-headers) then the [x-min-v](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable. See [HTTP Headers](#request-headers) (required)
     * @param page                   Page of results to request (standard pagination) (optional)
     * @param pageSize               Page size to request.  Default is 25 (standard pagination) (optional)
     * @param xMinV                  Minimum version of the API end point requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable. (optional)
     * @param xFapiInteractionId     An [RFC4122](https://tools.ietf.org/html/rfc4122) UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction. (optional)
     * @param xFapiAuthDate          The time when the customer last logged in to the data recipient. Required for all resource calls (customer present and unattended). Not to be included for unauthenticated calls. (optional)
     * @param xFapiCustomerIpAddress The customer&#39;s original IP address if the customer is currently logged in to the data recipient. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls. (optional)
     * @param xCdsClientHeaders      The customer&#39;s original standard http headers [Base64](#common-field-types) encoded, including the original User Agent header, if the customer is currently logged in to the data recipient. Mandatory for customer present calls.  Not required for unattended or unauthenticated calls. (optional)
     * @return Successful response (status code 200)
     * or The following error codes MUST be supported:&lt;br/&gt;&lt;ul class&#x3D;\&quot;error-code-list\&quot;&gt;&lt;li&gt;[400 - Invalid Field](#error-400-field-invalid)&lt;/li&gt;&lt;li&gt;[400 - Invalid Page Size](#error-400-field-invalid-page-size)&lt;/li&gt;&lt;li&gt;[400 - Invalid Version](#error-400-header-invalid-version)&lt;/li&gt;&lt;li&gt;[406 - Unsupported Version](#error-406-header-unsupported-version)&lt;/li&gt;&lt;li&gt;[422 - Invalid Page](#error-422-field-invalid-page)&lt;/li&gt;&lt;/ul&gt; (status code 4xx)
     */
    @ApiOperation(value = "Get Bulk Balances for Energy",
            nickname = "listBalancesBulk",
            notes = "Obtain the current balance for all accounts",
            response = EnergyBalanceListResponse.class,
            tags = {"Energy", "Billing",})
    @ApiResponses(value = {
            @ApiResponse(code = 200,
                    message = "Successful response",
                    response = EnergyInvoiceListResponse.class),
            @ApiResponse(code = 400,
                    message = "Invalid Version / Invalid Field / Invalid Page Size",
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
            value = "/energy/accounts/balances",
            produces = {"application/json"}
    )
    ResponseEntity<EnergyBalanceListResponse> listBalancesBulk(
            @ApiParam(
                    value = "Version of the API end point requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If the value of [x-min-v](#request-headers) is equal to or higher than the value of [x-v](#request-headers) then the [x-min-v](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable. See [HTTP Headers](#request-headers)",
                    required = true)
            @RequestHeader(value = "x-v", required = false)
                    Integer xV,
            @ApiParam(
                    value = "Minimum version of the API end point requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable.")
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
                    value = "The time when the customer last logged in to the data recipient. Required for all resource calls (customer present and unattended). Not to be included for unauthenticated calls.")
            @RequestHeader(value = "x-fapi-auth-date",
                    required = false)
                    String xFapiAuthDate,
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
     * @param xV                     Version of the API end point requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If the value of [x-min-v](#request-headers) is equal to or higher than the value of [x-v](#request-headers) then the [x-min-v](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable. See [HTTP Headers](#request-headers) (required)
     * @param accountIdList          Request payload containing list of specific Accounts to obtain data for (required)
     * @param page                   Page of results to request (standard pagination) (optional)
     * @param pageSize               Page size to request.  Default is 25 (standard pagination) (optional)
     * @param xMinV                  Minimum version of the API end point requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable. (optional)
     * @param xFapiInteractionId     An [RFC4122](https://tools.ietf.org/html/rfc4122) UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction. (optional)
     * @param xFapiAuthDate          The time when the customer last logged in to the data recipient. Required for all resource calls (customer present and unattended). Not to be included for unauthenticated calls. (optional)
     * @param xFapiCustomerIpAddress The customer&#39;s original IP address if the customer is currently logged in to the data recipient. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls. (optional)
     * @param xCdsClientHeaders      The customer&#39;s original standard http headers [Base64](#common-field-types) encoded, including the original User Agent header, if the customer is currently logged in to the data recipient. Mandatory for customer present calls.  Not required for unattended or unauthenticated calls. (optional)
     * @return Successful response (status code 200)
     * or The following error codes MUST be supported:&lt;br/&gt;&lt;ul class&#x3D;\&quot;error-code-list\&quot;&gt;&lt;li&gt;[400 - Invalid Field](#error-400-field-invalid)&lt;/li&gt;&lt;li&gt;[400 - Invalid Page Size](#error-400-field-invalid-page-size)&lt;/li&gt;&lt;li&gt;[400 - Invalid Version](#error-400-header-invalid-version)&lt;/li&gt;&lt;li&gt;[406 - Unsupported Version](#error-406-header-unsupported-version)&lt;/li&gt;&lt;li&gt;[422 - Invalid Page](#error-422-field-invalid-page)&lt;/li&gt;&lt;li&gt;[422 - Unavailable Energy Account](#error-422-unavailable-energy-account)&lt;/li&gt;&lt;li&gt;[422 - Invalid Energy Account](#error-422-invalid-energy-account)&lt;/li&gt;&lt;/ul&gt; (status code 4xx)
     */
    @ApiOperation(value = "Get Balances For Specific Energy Accounts",
            nickname = "listBalancesForAccounts",
            notes = "Obtain the current balance for a specified set of accounts",
            response = EnergyBalanceListResponse.class,
            tags = {"Energy", "Billing",})
    @ApiResponses(value = {
            @ApiResponse(code = 200,
                    message = "Successful response",
                    response = EnergyBalanceListResponse.class),
            @ApiResponse(code = 400,
                    message = "Invalid Version / Invalid Page Size / Invalid Field",
                    response = ErrorListResponse.class),
            @ApiResponse(code = 406,
                    message = "Unsupported Version",
                    response = ErrorListResponse.class),
            @ApiResponse(code = 422,
                    message = "Invalid Energy Account / Unavailable Energy Account / Invalid Page",
                    response = ErrorListResponse.class)
    })
    @RequestMapping(
            method = RequestMethod.POST,
            value = "/energy/accounts/balances",
            produces = {"application/json"},
            consumes = {"application/json"}
    )
    ResponseEntity<EnergyBalanceListResponse> listBalancesForAccounts(
            @ApiParam(
                    value = "Version of the API end point requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If the value of [x-min-v](#request-headers) is equal to or higher than the value of [x-v](#request-headers) then the [x-min-v](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable. See [HTTP Headers](#request-headers)",
                    required = true)
            @RequestHeader(value = "x-v", required = false)
                    Integer xV,
            @ApiParam(
                    value = "Minimum version of the API end point requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable.")
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
                    value = "The time when the customer last logged in to the data recipient. Required for all resource calls (customer present and unattended). Not to be included for unauthenticated calls.")
            @RequestHeader(value = "x-fapi-auth-date",
                    required = false)
                    String xFapiAuthDate,
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
     * @param xV                     Version of the API end point requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If the value of [x-min-v](#request-headers) is equal to or higher than the value of [x-v](#request-headers) then the [x-min-v](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable. See [HTTP Headers](#request-headers) (required)
     * @param newestTime             Constrain the request to records with effective time at or before this date/time.  If absent defaults to current date/time.  Format is aligned to DateTimeString common type (optional)
     * @param oldestTime             Constrain the request to records with effective time at or after this date/time. If absent defaults to newest-time minus 12 months.  Format is aligned to DateTimeString common type (optional)
     * @param page                   Page of results to request (standard pagination) (optional)
     * @param pageSize               Page size to request.  Default is 25 (standard pagination) (optional)
     * @param xMinV                  Minimum version of the API end point requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable. (optional)
     * @param xFapiInteractionId     An [RFC4122](https://tools.ietf.org/html/rfc4122) UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction. (optional)
     * @param xFapiAuthDate          The time when the customer last logged in to the data recipient. Required for all resource calls (customer present and unattended). Not to be included for unauthenticated calls. (optional)
     * @param xFapiCustomerIpAddress The customer&#39;s original IP address if the customer is currently logged in to the data recipient. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls. (optional)
     * @param xCdsClientHeaders      The customer&#39;s original standard http headers [Base64](#common-field-types) encoded, including the original User Agent header, if the customer is currently logged in to the data recipient. Mandatory for customer present calls.  Not required for unattended or unauthenticated calls. (optional)
     * @return Successful response (status code 200)
     * or The following error codes MUST be supported:&lt;br/&gt;&lt;ul class&#x3D;\&quot;error-code-list\&quot;&gt;&lt;li&gt;[400 - Invalid Field](#error-400-field-invalid)&lt;/li&gt;&lt;li&gt;[400 - Invalid Page Size](#error-400-field-invalid-page-size)&lt;/li&gt;&lt;li&gt;[400 - Invalid Version](#error-400-header-invalid-version)&lt;/li&gt;&lt;li&gt;[406 - Unsupported Version](#error-406-header-unsupported-version)&lt;/li&gt;&lt;li&gt;[422 - Invalid Page](#error-422-field-invalid-page)&lt;/li&gt;&lt;/ul&gt; (status code 4xx)
     */
    @ApiOperation(value = "Get Bulk Billing",
            nickname = "listBillingBulk",
            notes = "Obtain billing transactions for all accounts",
            response = EnergyBillingListResponse.class,
            tags = {"Energy", "Billing",})
    @ApiResponses(value = {
            @ApiResponse(code = 200,
                    message = "Successful response",
                    response = EnergyInvoiceListResponse.class),
            @ApiResponse(code = 400,
                    message = "Invalid Version / Invalid Field / Invalid Page Size",
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
            value = "/energy/accounts/billing",
            produces = {"application/json"}
    )
    ResponseEntity<EnergyBillingListResponse> listBillingBulk(
            @ApiParam(
                    value = "Version of the API end point requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If the value of [x-min-v](#request-headers) is equal to or higher than the value of [x-v](#request-headers) then the [x-min-v](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable. See [HTTP Headers](#request-headers)",
                    required = true)
            @RequestHeader(value = "x-v", required = false)
                    Integer xV,
            @ApiParam(
                    value = "Minimum version of the API end point requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable.")
            @RequestHeader(value = "x-min-v",
                    required = false)
                    Integer xMinV,
            @ApiParam(
                    value = "Constrain the request to records with effective time at or before this date/time.  If absent defaults to current date/time.  Format is aligned to DateTimeString common type")
            @Valid
            @RequestParam(value = "newest-time",
                    required = false)
                    String newestTime,
            @ApiParam(
                    value = "Constrain the request to records with effective time at or after this date/time. If absent defaults to newest-time minus 12 months.  Format is aligned to DateTimeString common type")
            @Valid
            @RequestParam(value = "oldest-time",
                    required = false)
                    String oldestTime,
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
                    value = "The time when the customer last logged in to the data recipient. Required for all resource calls (customer present and unattended). Not to be included for unauthenticated calls.")
            @RequestHeader(value = "x-fapi-auth-date",
                    required = false)
                    String xFapiAuthDate,
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
     * @param xV                     Version of the API end point requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If the value of [x-min-v](#request-headers) is equal to or higher than the value of [x-v](#request-headers) then the [x-min-v](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable. See [HTTP Headers](#request-headers) (required)
     * @param accountIdList          Request payload containing list of specific Accounts to obtain data for (required)
     * @param newestTime             Constrain the request to records with effective time at or before this date/time.  If absent defaults to current date/time.  Format is aligned to DateTimeString common type (optional)
     * @param oldestTime             Constrain the request to records with effective time at or after this date/time. If absent defaults to newest-time minus 12 months.  Format is aligned to DateTimeString common type (optional)
     * @param page                   Page of results to request (standard pagination) (optional)
     * @param pageSize               Page size to request.  Default is 25 (standard pagination) (optional)
     * @param xMinV                  Minimum version of the API end point requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable. (optional)
     * @param xFapiInteractionId     An [RFC4122](https://tools.ietf.org/html/rfc4122) UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction. (optional)
     * @param xFapiAuthDate          The time when the customer last logged in to the data recipient. Required for all resource calls (customer present and unattended). Not to be included for unauthenticated calls. (optional)
     * @param xFapiCustomerIpAddress The customer&#39;s original IP address if the customer is currently logged in to the data recipient. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls. (optional)
     * @param xCdsClientHeaders      The customer&#39;s original standard http headers [Base64](#common-field-types) encoded, including the original User Agent header, if the customer is currently logged in to the data recipient. Mandatory for customer present calls.  Not required for unattended or unauthenticated calls. (optional)
     * @return Successful response (status code 200)
     * or The following error codes MUST be supported:&lt;br/&gt;&lt;ul class&#x3D;\&quot;error-code-list\&quot;&gt;&lt;li&gt;[400 - Invalid Field](#error-400-field-invalid)&lt;/li&gt;&lt;li&gt;[400 - Invalid Page Size](#error-400-field-invalid-page-size)&lt;/li&gt;&lt;li&gt;[400 - Invalid Version](#error-400-header-invalid-version)&lt;/li&gt;&lt;li&gt;[406 - Unsupported Version](#error-406-header-unsupported-version)&lt;/li&gt;&lt;li&gt;[422 - Invalid Page](#error-422-field-invalid-page)&lt;/li&gt;&lt;li&gt;[422 - Unavailable Energy Account](#error-422-unavailable-energy-account)&lt;/li&gt;&lt;li&gt;[422 - Invalid Energy Account](#error-422-invalid-energy-account)&lt;/li&gt;&lt;/ul&gt; (status code 4xx)
     */
    @ApiOperation(value = "Get Billing For Specific Accounts",
            nickname = "listBillingForAccounts",
            notes = "Obtain billing for a specified set of accounts",
            response = EnergyBillingListResponse.class,
            tags = {"Energy", "Billing",})
    @ApiResponses(value = {
            @ApiResponse(code = 200,
                    message = "Successful response",
                    response = EnergyInvoiceListResponse.class),
            @ApiResponse(code = 400,
                    message = "Invalid Version / Invalid Field / Invalid Page Size",
                    response = ErrorListResponse.class),
            @ApiResponse(code = 406,
                    message = "Unsupported Version",
                    response = ErrorListResponse.class),
            @ApiResponse(code = 422,
                    message = "Invalid Page / Unavailable Energy Account / Invalid Energy Account",
                    response = ErrorListResponse.class)
    })
    @RequestMapping(
            method = RequestMethod.POST,
            value = "/energy/accounts/billing",
            produces = {"application/json"},
            consumes = {"application/json"}
    )
    ResponseEntity<EnergyBillingListResponse> listBillingForAccounts(
            @ApiParam(
                    value = "Version of the API end point requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If the value of [x-min-v](#request-headers) is equal to or higher than the value of [x-v](#request-headers) then the [x-min-v](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable. See [HTTP Headers](#request-headers)",
                    required = true)
            @RequestHeader(value = "x-v", required = false)
                    Integer xV,
            @ApiParam(
                    value = "Minimum version of the API end point requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable.")
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
                    String newestTime,
            @ApiParam(
                    value = "Constrain the request to records with effective time at or after this date/time. If absent defaults to newest-time minus 12 months.  Format is aligned to DateTimeString common type")
            @Valid
            @RequestParam(value = "oldest-time",
                    required = false)
                    String oldestTime,
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
                    value = "The time when the customer last logged in to the data recipient. Required for all resource calls (customer present and unattended). Not to be included for unauthenticated calls.")
            @RequestHeader(value = "x-fapi-auth-date",
                    required = false)
                    String xFapiAuthDate,
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
     * GET /energy/electricity/servicepoints/der : Get Bulk DER
     * Obtain DER data for all service points associated with the customer
     *
     * @param xV                     Version of the API end point requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If the value of [x-min-v](#request-headers) is equal to or higher than the value of [x-v](#request-headers) then the [x-min-v](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable. See [HTTP Headers](#request-headers) (required)
     * @param page                   Page of results to request (standard pagination) (optional)
     * @param pageSize               Page size to request.  Default is 25 (standard pagination) (optional)
     * @param xMinV                  Minimum version of the API end point requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable. (optional)
     * @param xFapiInteractionId     An [RFC4122](https://tools.ietf.org/html/rfc4122) UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction. (optional)
     * @param xFapiAuthDate          The time when the customer last logged in to the data recipient. Required for all resource calls (customer present and unattended). Not to be included for unauthenticated calls. (optional)
     * @param xFapiCustomerIpAddress The customer&#39;s original IP address if the customer is currently logged in to the data recipient. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls. (optional)
     * @param xCdsClientHeaders      The customer&#39;s original standard http headers [Base64](#common-field-types) encoded, including the original User Agent header, if the customer is currently logged in to the data recipient. Mandatory for customer present calls.  Not required for unattended or unauthenticated calls. (optional)
     * @return Successful response (status code 200)
     * or The following error codes MUST be supported:&lt;br/&gt;&lt;ul class&#x3D;\&quot;error-code-list\&quot;&gt;&lt;li&gt;[400 - Invalid Field](#error-400-field-invalid)&lt;/li&gt;&lt;li&gt;[400 - Invalid Page Size](#error-400-field-invalid-page-size)&lt;/li&gt;&lt;li&gt;[400 - Invalid Version](#error-400-header-invalid-version)&lt;/li&gt;&lt;li&gt;[406 - Unsupported Version](#error-406-header-unsupported-version)&lt;/li&gt;&lt;li&gt;[422 - Invalid Page](#error-422-field-invalid-page)&lt;/li&gt;&lt;/ul&gt; (status code 4xx)
     */
    @ApiOperation(value = "Get Bulk DER",
            nickname = "listDERBulk",
            notes = "Obtain DER data for all service points associated with the customer",
            response = EnergyDerListResponse.class,
            tags = {"Energy", "Distributed Energy Resources",})
    @ApiResponses(value = {
            @ApiResponse(code = 200,
                    message = "Successful response",
                    response = EnergyInvoiceListResponse.class),
            @ApiResponse(code = 400,
                    message = "Invalid Version / Invalid Field / Invalid Page Size",
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
            value = "/energy/electricity/servicepoints/der",
            produces = {"application/json"}
    )
    ResponseEntity<EnergyDerListResponse> listDERBulk(
            @ApiParam(
                    value = "Version of the API end point requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If the value of [x-min-v](#request-headers) is equal to or higher than the value of [x-v](#request-headers) then the [x-min-v](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable. See [HTTP Headers](#request-headers)",
                    required = true)
            @RequestHeader(value = "x-v", required = false)
                    Integer xV,
            @ApiParam(
                    value = "Minimum version of the API end point requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable.")
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
                    value = "The time when the customer last logged in to the data recipient. Required for all resource calls (customer present and unattended). Not to be included for unauthenticated calls.")
            @RequestHeader(value = "x-fapi-auth-date",
                    required = false)
                    String xFapiAuthDate,
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
     * @param xV                     Version of the API end point requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If the value of [x-min-v](#request-headers) is equal to or higher than the value of [x-v](#request-headers) then the [x-min-v](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable. See [HTTP Headers](#request-headers) (required)
     * @param servicePointIdList     Request payload containing list of specific Service Points to obtain data for (required)
     * @param page                   Page of results to request (standard pagination) (optional)
     * @param pageSize               Page size to request.  Default is 25 (standard pagination) (optional)
     * @param xMinV                  Minimum version of the API end point requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable. (optional)
     * @param xFapiInteractionId     An [RFC4122](https://tools.ietf.org/html/rfc4122) UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction. (optional)
     * @param xFapiAuthDate          The time when the customer last logged in to the data recipient. Required for all resource calls (customer present and unattended). Not to be included for unauthenticated calls. (optional)
     * @param xFapiCustomerIpAddress The customer&#39;s original IP address if the customer is currently logged in to the data recipient. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls. (optional)
     * @param xCdsClientHeaders      The customer&#39;s original standard http headers [Base64](#common-field-types) encoded, including the original User Agent header, if the customer is currently logged in to the data recipient. Mandatory for customer present calls.  Not required for unattended or unauthenticated calls. (optional)
     * @return Successful response (status code 200)
     * or The following error codes MUST be supported:&lt;br/&gt;&lt;ul class&#x3D;\&quot;error-code-list\&quot;&gt;&lt;li&gt;[400 - Invalid Field](#error-400-field-invalid)&lt;/li&gt;&lt;li&gt;[400 - Invalid Page Size](#error-400-field-invalid-page-size)&lt;/li&gt;&lt;li&gt;[400 - Invalid Version](#error-400-header-invalid-version)&lt;/li&gt;&lt;li&gt;[406 - Unsupported Version](#error-406-header-unsupported-version)&lt;/li&gt;&lt;li&gt;[422 - Invalid Page](#error-422-field-invalid-page)&lt;/li&gt;&lt;li&gt;[422 - Unavailable Service Point](#error-422-unavailable-service-point)&lt;/li&gt;&lt;li&gt;[422 - Invalid Service Point](#error-422-invalid-service-point)&lt;/li&gt;&lt;/ul&gt; (status code 4xx)
     */
    @ApiOperation(value = "Get DER For Specific Service Points",
            nickname = "listDERForServicePoints",
            notes = "Obtain DER data for a specific set of service points",
            response = EnergyDerListResponse.class,
            tags = {"Energy", "Distributed Energy Resources",})
    @ApiResponses(value = {
            @ApiResponse(code = 200,
                    message = "Successful response",
                    response = EnergyDerListResponse.class),
            @ApiResponse(code = 400,
                    message = "Invalid Version / Invalid Field / Invalid Page Size",
                    response = ErrorListResponse.class),
            @ApiResponse(code = 406,
                    message = "Unsupported Version",
                    response = ErrorListResponse.class),
            @ApiResponse(code = 422,
                    message = "Invalid Page / Unavailable Service Point / Invalid Service Point",
                    response = ErrorListResponse.class)
    })
    @RequestMapping(
            method = RequestMethod.POST,
            value = "/energy/electricity/servicepoints/der",
            produces = {"application/json"},
            consumes = {"application/json"}
    )
    ResponseEntity<EnergyDerListResponse> listDERForServicePoints(
            @ApiParam(
                    value = "Version of the API end point requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If the value of [x-min-v](#request-headers) is equal to or higher than the value of [x-v](#request-headers) then the [x-min-v](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable. See [HTTP Headers](#request-headers)",
                    required = true)
            @RequestHeader(value = "x-v", required = false)
                    Integer xV,
            @ApiParam(
                    value = "Minimum version of the API end point requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable.")
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
                    value = "The time when the customer last logged in to the data recipient. Required for all resource calls (customer present and unattended). Not to be included for unauthenticated calls.")
            @RequestHeader(value = "x-fapi-auth-date",
                    required = false)
                    String xFapiAuthDate,
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
     * @param xV                     Version of the API end point requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If the value of [x-min-v](#request-headers) is equal to or higher than the value of [x-v](#request-headers) then the [x-min-v](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable. See [HTTP Headers](#request-headers) (required)
     * @param newestDate             Constrain the request to records with effective date at or before this date.  If absent defaults to current date.  Format is aligned to DateString common type (optional)
     * @param oldestDate             Constrain the request to records with effective date at or after this date. If absent defaults to newest-date minus 24 months days.  Format is aligned to DateString common type (optional)
     * @param page                   Page of results to request (standard pagination) (optional)
     * @param pageSize               Page size to request.  Default is 25 (standard pagination) (optional)
     * @param xMinV                  Minimum version of the API end point requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable. (optional)
     * @param xFapiInteractionId     An [RFC4122](https://tools.ietf.org/html/rfc4122) UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction. (optional)
     * @param xFapiAuthDate          The time when the customer last logged in to the data recipient. Required for all resource calls (customer present and unattended). Not to be included for unauthenticated calls. (optional)
     * @param xFapiCustomerIpAddress The customer&#39;s original IP address if the customer is currently logged in to the data recipient. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls. (optional)
     * @param xCdsClientHeaders      The customer&#39;s original standard http headers [Base64](#common-field-types) encoded, including the original User Agent header, if the customer is currently logged in to the data recipient. Mandatory for customer present calls.  Not required for unattended or unauthenticated calls. (optional)
     * @return Successful response (status code 200)
     * or The following error codes MUST be supported:&lt;br/&gt;&lt;ul class&#x3D;\&quot;error-code-list\&quot;&gt;&lt;li&gt;[400 - Invalid Field](#error-400-field-invalid)&lt;/li&gt;&lt;li&gt;[400 - Invalid Page Size](#error-400-field-invalid-page-size)&lt;/li&gt;&lt;li&gt;[400 - Invalid Version](#error-400-header-invalid-version)&lt;/li&gt;&lt;li&gt;[406 - Unsupported Version](#error-406-header-unsupported-version)&lt;/li&gt;&lt;li&gt;[422 - Invalid Page](#error-422-field-invalid-page)&lt;/li&gt;&lt;/ul&gt; (status code 4xx)
     */
    @ApiOperation(value = "Get Bulk Invoices",
            nickname = "listInvoicesBulk",
            notes = "Obtain the invoices for all accounts",
            response = EnergyInvoiceListResponse.class,
            tags = {"Energy", "Billing",})
    @ApiResponses(value = {
            @ApiResponse(code = 200,
                    message = "Successful response",
                    response = EnergyInvoiceListResponse.class),
            @ApiResponse(code = 400,
                    message = "Invalid Version / Invalid Field / Invalid Page Size",
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
            value = "/energy/accounts/invoices",
            produces = {"application/json"}
    )
    ResponseEntity<EnergyInvoiceListResponse> listInvoicesBulk(
            @ApiParam(
                    value = "Version of the API end point requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If the value of [x-min-v](#request-headers) is equal to or higher than the value of [x-v](#request-headers) then the [x-min-v](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable. See [HTTP Headers](#request-headers)",
                    required = true)
            @RequestHeader(value = "x-v", required = false)
                    Integer xV,
            @ApiParam(
                    value = "Minimum version of the API end point requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable.")
            @RequestHeader(value = "x-min-v",
                    required = false)
                    Integer xMinV,
            @ApiParam(
                    value = "Constrain the request to records with effective date at or before this date.  If absent defaults to current date.  Format is aligned to DateString common type")
            @Valid
            @RequestParam(value = "newest-date",
                    required = false)
                    String newestDate,
            @ApiParam(
                    value = "Constrain the request to records with effective date at or after this date. If absent defaults to newest-date minus 24 months days.  Format is aligned to DateString common type")
            @Valid
            @RequestParam(value = "oldest-date",
                    required = false)
                    String oldestDate,
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
                    value = "The time when the customer last logged in to the data recipient. Required for all resource calls (customer present and unattended). Not to be included for unauthenticated calls.")
            @RequestHeader(value = "x-fapi-auth-date",
                    required = false)
                    String xFapiAuthDate,
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
     * @param xV                     Version of the API end point requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If the value of [x-min-v](#request-headers) is equal to or higher than the value of [x-v](#request-headers) then the [x-min-v](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable. See [HTTP Headers](#request-headers) (required)
     * @param accountIdList          Request payload containing list of specific Accounts to obtain data for (required)
     * @param newestDate             Constrain the request to records with effective date at or before this date.  If absent defaults to current date.  Format is aligned to DateString common type (optional)
     * @param oldestDate             Constrain the request to records with effective date at or after this date. If absent defaults to newest-date minus 24 months days.  Format is aligned to DateString common type (optional)
     * @param page                   Page of results to request (standard pagination) (optional)
     * @param pageSize               Page size to request.  Default is 25 (standard pagination) (optional)
     * @param xMinV                  Minimum version of the API end point requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable. (optional)
     * @param xFapiInteractionId     An [RFC4122](https://tools.ietf.org/html/rfc4122) UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction. (optional)
     * @param xFapiAuthDate          The time when the customer last logged in to the data recipient. Required for all resource calls (customer present and unattended). Not to be included for unauthenticated calls. (optional)
     * @param xFapiCustomerIpAddress The customer&#39;s original IP address if the customer is currently logged in to the data recipient. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls. (optional)
     * @param xCdsClientHeaders      The customer&#39;s original standard http headers [Base64](#common-field-types) encoded, including the original User Agent header, if the customer is currently logged in to the data recipient. Mandatory for customer present calls.  Not required for unattended or unauthenticated calls. (optional)
     * @return Successful response (status code 200)
     * or The following error codes MUST be supported:&lt;br/&gt;&lt;ul class&#x3D;\&quot;error-code-list\&quot;&gt;&lt;li&gt;[400 - Invalid Field](#error-400-field-invalid)&lt;/li&gt;&lt;li&gt;[400 - Invalid Page Size](#error-400-field-invalid-page-size)&lt;/li&gt;&lt;li&gt;[400 - Invalid Version](#error-400-header-invalid-version)&lt;/li&gt;&lt;li&gt;[406 - Unsupported Version](#error-406-header-unsupported-version)&lt;/li&gt;&lt;li&gt;[422 - Invalid Page](#error-422-field-invalid-page)&lt;/li&gt;&lt;li&gt;[422 - Unavailable Energy Account](#error-422-unavailable-energy-account)&lt;/li&gt;&lt;li&gt;[422 - Invalid Energy Account](#error-422-invalid-energy-account)&lt;/li&gt;&lt;/ul&gt; (status code 4xx)
     */
    @ApiOperation(value = "Get Invoices For Specific Accounts",
            nickname = "listInvoicesForAccounts",
            notes = "Obtain invoices for a specified set of accounts",
            response = EnergyInvoiceListResponse.class,
            tags = {"Energy", "Billing",})
    @ApiResponses(value = {
            @ApiResponse(code = 200,
                    message = "Successful response",
                    response = EnergyDerListResponse.class),
            @ApiResponse(code = 400,
                    message = "Invalid Version / Invalid Field / Invalid Page Size",
                    response = ErrorListResponse.class),
            @ApiResponse(code = 406,
                    message = "Unsupported Version",
                    response = ErrorListResponse.class),
            @ApiResponse(code = 422,
                    message = "Invalid Page / Unavailable Energy Account / Invalid Energy Account",
                    response = ErrorListResponse.class)
    })
    @RequestMapping(
            method = RequestMethod.POST,
            value = "/energy/accounts/invoices",
            produces = {"application/json"},
            consumes = {"application/json"}
    )
    ResponseEntity<EnergyInvoiceListResponse> listInvoicesForAccounts(
            @ApiParam(
                    value = "Version of the API end point requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If the value of [x-min-v](#request-headers) is equal to or higher than the value of [x-v](#request-headers) then the [x-min-v](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable. See [HTTP Headers](#request-headers)",
                    required = true)
            @RequestHeader(value = "x-v", required = false)
                    Integer xV,
            @ApiParam(
                    value = "Minimum version of the API end point requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable.")
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
                    value = "Constrain the request to records with effective date at or before this date.  If absent defaults to current date.  Format is aligned to DateString common type")
            @Valid
            @RequestParam(value = "newest-date",
                    required = false)
                    String newestDate,
            @ApiParam(
                    value = "Constrain the request to records with effective date at or after this date. If absent defaults to newest-date minus 24 months days.  Format is aligned to DateString common type")
            @Valid
            @RequestParam(value = "oldest-date",
                    required = false)
                    String oldestDate,
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
                    value = "The time when the customer last logged in to the data recipient. Required for all resource calls (customer present and unattended). Not to be included for unauthenticated calls.")
            @RequestHeader(value = "x-fapi-auth-date",
                    required = false)
                    String xFapiAuthDate,
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
     * @param xV                 Version of the API end point requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If the value of [x-min-v](#request-headers) is equal to or higher than the value of [x-v](#request-headers) then the [x-min-v](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable. See [HTTP Headers](#request-headers) (required)
     * @param type               Used to filter results on the type field.  Any one of the valid values for this field can be supplied plus &#39;ALL&#39;.  If absent defaults to &#39;ALL&#39; (optional, default to ALL)
     * @param fuelType           Used to filter results on the fuelType field.  Any one of the valid values for this field can be supplied plus &#39;ALL&#39;.  If absent defaults to &#39;ALL&#39; (optional, default to ALL)
     * @param effective          Allows for the filtering of plans based on whether the current time is within the period of time defined as effective by the effectiveFrom and effectiveTo fields. Valid values are ‘CURRENT’, ‘FUTURE’ and ‘ALL’. If absent defaults to &#39;CURRENT&#39; (optional, default to CURRENT)
     * @param updatedSince       Only include plans that have been updated after the specified date and time.  If absent defaults to include all plans (optional)
     * @param brand              Used to filter results on the brand field.  If absent defaults to include all plans (optional)
     * @param page               Page of results to request (standard pagination) (optional)
     * @param pageSize           Page size to request.  Default is 25 (standard pagination) (optional)
     * @param xMinV              Minimum version of the API end point requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable. (optional)
     * @param xFapiInteractionId An [RFC4122](https://tools.ietf.org/html/rfc4122) UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction. (optional)
     * @return Successful response (status code 200)
     * or The following error codes MUST be supported:&lt;br/&gt;&lt;ul class&#x3D;\&quot;error-code-list\&quot;&gt;&lt;li&gt;[400 - Invalid Field](#error-400-field-invalid)&lt;/li&gt;&lt;li&gt;[400 - Invalid Page Size](#error-400-field-invalid-page-size)&lt;/li&gt;&lt;li&gt;[400 - Invalid Version](#error-400-header-invalid-version)&lt;/li&gt;&lt;li&gt;[406 - Unsupported Version](#error-406-header-unsupported-version)&lt;/li&gt;&lt;li&gt;[422 - Invalid Page](#error-422-field-invalid-page)&lt;/li&gt;&lt;/ul&gt; (status code 4xx)
     */
    @ApiOperation(value = "Get Generic Plans",
            nickname = "listPlans",
            notes = "Obtain a list of energy plans that are currently offered to the market.  Note that the results returned by this end point are expected to be ordered in descending order according to `lastUpdated`.",
            response = EnergyPlanListResponse.class,
            tags = {"Energy", "Generic Tariffs",})
    @ApiResponses(value = {
            @ApiResponse(code = 200,
                    message = "Successful response",
                    response = EnergyUsageListResponse.class),
            @ApiResponse(code = 400,
                    message = "Invalid Version / Invalid Field / Invalid Page Size",
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
                    value = "Version of the API end point requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If the value of [x-min-v](#request-headers) is equal to or higher than the value of [x-v](#request-headers) then the [x-min-v](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable. See [HTTP Headers](#request-headers)",
                    required = true)
            @RequestHeader(value = "x-v", required = false)
                    Integer xV,
            @ApiParam(
                    value = "Minimum version of the API end point requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable.")
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
                    OffsetDateTime updatedSince,
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
                    Integer pageSize,
            @ApiParam(
                    value = "An [RFC4122](https://tools.ietf.org/html/rfc4122) UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction.")
            @RequestHeader(value = "x-fapi-interaction-id",
                    required = false)
                    UUID xFapiInteractionId);


    /**
     * GET /energy/electricity/servicepoints : Get Service Points
     * Obtain a list of service points owned by the customer that has authorised the current session
     *
     * @param xV                     Version of the API end point requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If the value of [x-min-v](#request-headers) is equal to or higher than the value of [x-v](#request-headers) then the [x-min-v](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable. See [HTTP Headers](#request-headers) (required)
     * @param page                   Page of results to request (standard pagination) (optional)
     * @param pageSize               Page size to request.  Default is 25 (standard pagination) (optional)
     * @param xMinV                  Minimum version of the API end point requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable. (optional)
     * @param xFapiInteractionId     An [RFC4122](https://tools.ietf.org/html/rfc4122) UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction. (optional)
     * @param xFapiAuthDate          The time when the customer last logged in to the data recipient. Required for all resource calls (customer present and unattended). Not to be included for unauthenticated calls. (optional)
     * @param xFapiCustomerIpAddress The customer&#39;s original IP address if the customer is currently logged in to the data recipient. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls. (optional)
     * @param xCdsClientHeaders      The customer&#39;s original standard http headers [Base64](#common-field-types) encoded, including the original User Agent header, if the customer is currently logged in to the data recipient. Mandatory for customer present calls.  Not required for unattended or unauthenticated calls. (optional)
     * @return Successful response (status code 200)
     * or The following error codes MUST be supported:&lt;br/&gt;&lt;ul class&#x3D;\&quot;error-code-list\&quot;&gt;&lt;li&gt;[400 - Invalid Field](#error-400-field-invalid)&lt;/li&gt;&lt;li&gt;[400 - Invalid Page Size](#error-400-field-invalid-page-size)&lt;/li&gt;&lt;li&gt;[400 - Invalid Version](#error-400-header-invalid-version)&lt;/li&gt;&lt;li&gt;[406 - Unsupported Version](#error-406-header-unsupported-version)&lt;/li&gt;&lt;li&gt;[422 - Invalid Page](#error-422-field-invalid-page)&lt;/li&gt;&lt;/ul&gt; (status code 4xx)
     */
    @ApiOperation(value = "Get Service Points",
            nickname = "listServicePoints",
            notes = "Obtain a list of service points owned by the customer that has authorised the current session",
            response = EnergyServicePointListResponse.class,
            tags = {"Energy", "NMI Standing Data",})
    @ApiResponses(value = {
            @ApiResponse(code = 200,
                    message = "Successful response",
                    response = EnergyUsageListResponse.class),
            @ApiResponse(code = 400,
                    message = "Invalid Version / Invalid Field / Invalid Page Size",
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
            value = "/energy/electricity/servicepoints",
            produces = {"application/json"}
    )
    ResponseEntity<EnergyServicePointListResponse> listServicePoints(
            @ApiParam(
                    value = "Version of the API end point requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If the value of [x-min-v](#request-headers) is equal to or higher than the value of [x-v](#request-headers) then the [x-min-v](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable. See [HTTP Headers](#request-headers)",
                    required = true)
            @RequestHeader(value = "x-v", required = false)
                    Integer xV,
            @ApiParam(
                    value = "Minimum version of the API end point requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable.")
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
                    value = "The time when the customer last logged in to the data recipient. Required for all resource calls (customer present and unattended). Not to be included for unauthenticated calls.")
            @RequestHeader(value = "x-fapi-auth-date",
                    required = false)
                    String xFapiAuthDate,
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
     * @param xV                     Version of the API end point requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If the value of [x-min-v](#request-headers) is equal to or higher than the value of [x-v](#request-headers) then the [x-min-v](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable. See [HTTP Headers](#request-headers) (required)
     * @param oldestDate             Constrain the request to records with effective date at or after this date. If absent defaults to newest-date minus 24 months days.  Format is aligned to DateString common type (optional)
     * @param newestDate             Constrain the request to records with effective date at or before this date.  If absent defaults to current date.  Format is aligned to DateString common type (optional)
     * @param page                   Page of results to request (standard pagination) (optional)
     * @param pageSize               Page size to request.  Default is 25 (standard pagination) (optional)
     * @param xMinV                  Minimum version of the API end point requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable. (optional)
     * @param xFapiInteractionId     An [RFC4122](https://tools.ietf.org/html/rfc4122) UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction. (optional)
     * @param xFapiAuthDate          The time when the customer last logged in to the data recipient. Required for all resource calls (customer present and unattended). Not to be included for unauthenticated calls. (optional)
     * @param xFapiCustomerIpAddress The customer&#39;s original IP address if the customer is currently logged in to the data recipient. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls. (optional)
     * @param xCdsClientHeaders      The customer&#39;s original standard http headers [Base64](#common-field-types) encoded, including the original User Agent header, if the customer is currently logged in to the data recipient. Mandatory for customer present calls.  Not required for unattended or unauthenticated calls. (optional)
     * @return Successful response (status code 200)
     * or The following error codes MUST be supported:&lt;br/&gt;&lt;ul class&#x3D;\&quot;error-code-list\&quot;&gt;&lt;li&gt;[400 - Invalid Field](#error-400-field-invalid)&lt;/li&gt;&lt;li&gt;[400 - Invalid Page Size](#error-400-field-invalid-page-size)&lt;/li&gt;&lt;li&gt;[400 - Invalid Version](#error-400-header-invalid-version)&lt;/li&gt;&lt;li&gt;[406 - Unsupported Version](#error-406-header-unsupported-version)&lt;/li&gt;&lt;li&gt;[422 - Invalid Page](#error-422-field-invalid-page)&lt;/li&gt;&lt;/ul&gt; (status code 4xx)
     */
    @ApiOperation(value = "Get Bulk Usage",
            nickname = "listUsageBulk",
            notes = "Obtain usage data for all service points associated with the customer",
            response = EnergyUsageListResponse.class,
            tags = {"Energy", "Electricity Usage",})
    @ApiResponses(value = {
            @ApiResponse(code = 200,
                    message = "Successful response",
                    response = EnergyUsageListResponse.class),
            @ApiResponse(code = 400,
                    message = "Invalid Version / Invalid Field / Invalid Page Size",
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
            value = "/energy/electricity/servicepoints/usage",
            produces = {"application/json"}
    )
    ResponseEntity<EnergyUsageListResponse> listUsageBulk(
            @ApiParam(
                    value = "Version of the API end point requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If the value of [x-min-v](#request-headers) is equal to or higher than the value of [x-v](#request-headers) then the [x-min-v](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable. See [HTTP Headers](#request-headers)",
                    required = true)
            @RequestHeader(value = "x-v", required = false)
                    Integer xV,
            @ApiParam(
                    value = "Minimum version of the API end point requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable.")
            @RequestHeader(value = "x-min-v",
                    required = false)
                    Integer xMinV,
            @ApiParam(
                    value = "Constrain the request to records with effective date at or after this date. If absent defaults to newest-date minus 24 months days.  Format is aligned to DateString common type")
            @Valid
            @RequestParam(value = "oldest-date",
                    required = false)
                    String oldestDate,
            @ApiParam(
                    value = "Constrain the request to records with effective date at or before this date.  If absent defaults to current date.  Format is aligned to DateString common type")
            @Valid
            @RequestParam(value = "newest-date",
                    required = false)
                    String newestDate,
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
                    value = "The time when the customer last logged in to the data recipient. Required for all resource calls (customer present and unattended). Not to be included for unauthenticated calls.")
            @RequestHeader(value = "x-fapi-auth-date",
                    required = false)
                    String xFapiAuthDate,
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
     * POST /energy/electricity/servicepoints/usage : Get Usage For Specific Service Points
     * Obtain the electricity usage data for a specific set of service points
     *
     * @param xV                     Version of the API end point requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If the value of [x-min-v](#request-headers) is equal to or higher than the value of [x-v](#request-headers) then the [x-min-v](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable. See [HTTP Headers](#request-headers) (required)
     * @param servicePointIdList     Request payload containing list of specific Service Points to obtain data for (required)
     * @param oldestDate             Constrain the request to records with effective date at or after this date. If absent defaults to newest-date minus 24 months days.  Format is aligned to DateString common type (optional)
     * @param newestDate             Constrain the request to records with effective date at or before this date.  If absent defaults to current date.  Format is aligned to DateString common type (optional)
     * @param page                   Page of results to request (standard pagination) (optional)
     * @param pageSize               Page size to request.  Default is 25 (standard pagination) (optional)
     * @param xMinV                  Minimum version of the API end point requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable. (optional)
     * @param xFapiInteractionId     An [RFC4122](https://tools.ietf.org/html/rfc4122) UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction. (optional)
     * @param xFapiAuthDate          The time when the customer last logged in to the data recipient. Required for all resource calls (customer present and unattended). Not to be included for unauthenticated calls. (optional)
     * @param xFapiCustomerIpAddress The customer&#39;s original IP address if the customer is currently logged in to the data recipient. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls. (optional)
     * @param xCdsClientHeaders      The customer&#39;s original standard http headers [Base64](#common-field-types) encoded, including the original User Agent header, if the customer is currently logged in to the data recipient. Mandatory for customer present calls.  Not required for unattended or unauthenticated calls. (optional)
     * @return Successful response (status code 200)
     * or The following error codes MUST be supported:&lt;br/&gt;&lt;ul class&#x3D;\&quot;error-code-list\&quot;&gt;&lt;li&gt;[400 - Invalid Field](#error-400-field-invalid)&lt;/li&gt;&lt;li&gt;[400 - Invalid Page Size](#error-400-field-invalid-page-size)&lt;/li&gt;&lt;li&gt;[400 - Invalid Version](#error-400-header-invalid-version)&lt;/li&gt;&lt;li&gt;[406 - Unsupported Version](#error-406-header-unsupported-version)&lt;/li&gt;&lt;li&gt;[422 - Invalid Page](#error-422-field-invalid-page)&lt;/li&gt;&lt;li&gt;[422 - Unavailable Service Point](#error-422-unavailable-service-point)&lt;/li&gt;&lt;li&gt;[422 - Invalid Service Point](#error-422-invalid-service-point)&lt;/li&gt;&lt;/ul&gt; (status code 4xx)
     */
    @ApiOperation(value = "Get Usage For Specific Service Points",
            nickname = "listUsageForServicePoints",
            notes = "Obtain the electricity usage data for a specific set of service points",
            response = EnergyUsageListResponse.class,
            tags = {"Energy", "Electricity Usage",})
    @ApiResponses(value = {
            @ApiResponse(code = 200,
                    message = "Successful response",
                    response = EnergyBalanceListResponse.class),
            @ApiResponse(code = 400,
                    message = "Invalid Version / Invalid Page Size / Invalid Field",
                    response = ErrorListResponse.class),
            @ApiResponse(code = 406,
                    message = "Unsupported Version",
                    response = ErrorListResponse.class),
            @ApiResponse(code = 422,
                    message = "Invalid Service Point / Unavailable Service Point / Invalid Page",
                    response = ErrorListResponse.class)
    })
    @RequestMapping(
            method = RequestMethod.POST,
            value = "/energy/electricity/servicepoints/usage",
            produces = {"application/json"},
            consumes = {"application/json"}
    )
    ResponseEntity<EnergyUsageListResponse> listUsageForServicePoints(
            @ApiParam(
                    value = "Version of the API end point requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If the value of [x-min-v](#request-headers) is equal to or higher than the value of [x-v](#request-headers) then the [x-min-v](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable. See [HTTP Headers](#request-headers)",
                    required = true)
            @RequestHeader(value = "x-v", required = false)
                    Integer xV,
            @ApiParam(
                    value = "Minimum version of the API end point requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable.")
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
                    value = "Constrain the request to records with effective date at or after this date. If absent defaults to newest-date minus 24 months days.  Format is aligned to DateString common type")
            @Valid
            @RequestParam(value = "oldest-date",
                    required = false)
                    String oldestDate,
            @ApiParam(
                    value = "Constrain the request to records with effective date at or before this date.  If absent defaults to current date.  Format is aligned to DateString common type")
            @Valid
            @RequestParam(value = "newest-date",
                    required = false)
                    String newestDate,
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
                    value = "The time when the customer last logged in to the data recipient. Required for all resource calls (customer present and unattended). Not to be included for unauthenticated calls.")
            @RequestHeader(value = "x-fapi-auth-date",
                    required = false)
                    String xFapiAuthDate,
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

}
