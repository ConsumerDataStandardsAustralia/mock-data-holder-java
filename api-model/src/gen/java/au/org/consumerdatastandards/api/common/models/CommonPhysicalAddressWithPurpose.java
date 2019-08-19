package au.org.consumerdatastandards.api.common.models;

import au.org.consumerdatastandards.support.data.*;

@DataDefinition(
    allOf = { CommonPhysicalAddress.class },
    referenced = false
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
