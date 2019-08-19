package au.org.consumerdatastandards.api.common.models;

import au.org.consumerdatastandards.support.data.*;

@DataDefinition
@CustomAttributes({
    @CustomAttribute(name = "x-conditional", value = "person", multiple = true),
    @CustomAttribute(name = "x-conditional", value = "organisation", multiple = true)
})
public class ResponseCommonCustomer extends BaseResponse {

    @Property(
        required = true
    )
    ResponseCommonCustomerData data;
}
