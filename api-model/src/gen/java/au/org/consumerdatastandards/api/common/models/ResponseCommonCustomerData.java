package au.org.consumerdatastandards.api.common.models;

import au.org.consumerdatastandards.support.data.*;

@DataDefinition(
    referenced = false
)
public class ResponseCommonCustomerData {

    public enum CustomerUType {
        PERSON,
        ORGANISATION
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
