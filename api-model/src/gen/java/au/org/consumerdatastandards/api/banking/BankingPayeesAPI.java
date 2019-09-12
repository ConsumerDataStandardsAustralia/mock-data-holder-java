package au.org.consumerdatastandards.api.banking;

import au.org.consumerdatastandards.api.banking.models.ResponseBankingPayeeById;
import au.org.consumerdatastandards.api.banking.models.ResponseBankingPayeeList;
import au.org.consumerdatastandards.support.data.*;
import au.org.consumerdatastandards.support.*;

@Section(name = "BankingPayees", tags = {"Banking", "Payees"})
public interface BankingPayeesAPI  {

    public enum ParamType {
        DOMESTIC,
        INTERNATIONAL,
        BILLER,
        ALL
    }

    @Endpoint(
        path = "/banking/payees/{payeeId}",
        summary = "Get Payee Detail",
        description = "Obtain detailed information on a single payee",
        requestMethod = RequestMethod.GET,
        operationId = "getPayeeDetail",
        responses = {
            @EndpointResponse(
                responseCode = ResponseCode.OK,
                description = "Success",
                content = ResponseBankingPayeeById.class
            )
        }
    )
    @CustomAttributes({
        @CustomAttribute(name = "x-scopes", value = "bank:payees:read", multiple = true),
        @CustomAttribute(name = "x-version", value = "1")
    })
    ResponseBankingPayeeById getPayeeDetail(
        @Param(
            name = "payeeId",
            description = "The ID used to locate the details of a particular payee",
            in = ParamLocation.PATH
        )
        @CDSDataType(CustomDataType.ASCII)
        String payeeId, 
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
        path = "/banking/payees",
        summary = "Get Payees",
        description = "Obtain a list of pre-registered payees",
        requestMethod = RequestMethod.GET,
        operationId = "listPayees",
        responses = {
            @EndpointResponse(
                responseCode = ResponseCode.OK,
                description = "Success",
                content = ResponseBankingPayeeList.class
            )
        }
    )
    @CustomAttributes({
        @CustomAttribute(name = "x-scopes", value = "bank:acounts.basic:read", multiple = true),
        @CustomAttribute(name = "x-version", value = "1")
    })
    ResponseBankingPayeeList listPayees(
        @Param(
            name = "type",
            description = "Filter on the payee type field.  In addition to normal type field values, ALL can be specified to retrieve all payees.  If absent the assumed value is ALL",
            in = ParamLocation.QUERY,
            defaultValue = "ALL"
        )
        ParamType type, 
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
