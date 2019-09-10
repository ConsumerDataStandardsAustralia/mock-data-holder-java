package au.org.consumerdatastandards.api.common.models;

import au.org.consumerdatastandards.support.data.*;

@DataDefinition(
    referenced = false
)
public class ResponseCommonCustomerDetailData {

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
    CommonPersonDetail person;

    @Property
    CommonOrganisationDetail organisation;
}
