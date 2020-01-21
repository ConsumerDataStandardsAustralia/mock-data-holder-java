package au.org.consumerdatastandards.api.v1_1_1.common.models;

import au.org.consumerdatastandards.support.data.*;

@DataDefinition(
    referenced = false
)
public class ResponseCommonCustomerData {

    public enum CustomerUType {
        person,
        organisation
    }

    @Property(
        description = "The type of customer object that is present",
        required = true
    )
    CustomerUType customerUType;

    @Property
    CommonPerson person;

    @Property
    CommonOrganisation organisation;
}
