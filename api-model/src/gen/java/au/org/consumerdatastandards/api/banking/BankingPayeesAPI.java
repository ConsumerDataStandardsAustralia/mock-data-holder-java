package au.org.consumerdatastandards.api.banking;

import au.org.consumerdatastandards.api.banking.models.ResponseBankingPayeeById;
import au.org.consumerdatastandards.api.banking.models.ResponseBankingPayeeList;
import au.org.consumerdatastandards.support.data.*;
import au.org.consumerdatastandards.support.*;

@Section(name = "BankingPayees", tags = {"Banking APIs", "Payees"})
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
        @CustomAttribute(name = "x-scopes", value = "bank_payees", multiple = true),
        @CustomAttribute(name = "x-version", value = "1")
    })
    ResponseBankingPayeeById getPayeeDetail(
        @Param(
            name = "payeeId",
            description = "The ID used to locate the details of a particular payee",
            in = ParamLocation.PATH
        )
        @CDSDataType(CustomDataType.ASCII)
        String payeeId
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
        @CustomAttribute(name = "x-scopes", value = "bank_basic_accounts", multiple = true),
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
        Integer pageSize
    );
}
