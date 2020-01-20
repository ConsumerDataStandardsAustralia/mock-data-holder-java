package au.org.consumerdatastandards.api.v1_0_0.common.models;

import au.org.consumerdatastandards.support.data.*;

@DataDefinition(
    allOf = { CommonPhysicalAddress.class }
)
public class CommonPhysicalAddressWithPurpose {

    public enum Purpose {
        REGISTERED,
        MAIL,
        PHYSICAL,
        WORK,
        OTHER
    }

    @Property(
        description = "Enumeration of values indicating the purpose of the physical address",
        required = true
    )
    Purpose purpose;
}
