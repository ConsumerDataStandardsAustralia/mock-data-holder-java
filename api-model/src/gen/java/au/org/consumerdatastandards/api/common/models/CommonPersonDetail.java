package au.org.consumerdatastandards.api.common.models;

import java.util.List;
import au.org.consumerdatastandards.support.data.*;

@DataDefinition(
    allOf = { CommonPerson.class },
    referenced = false
)
public class CommonPersonDetail {

    @Property(
        description = "Array is mandatory but may be empty if no phone numbers are held",
        required = true
    )
    List<CommonPhoneNumber> phoneNumbers;

    @Property(
        description = "May be empty",
        required = true
    )
    List<CommonEmailAddress> emailAddresses;

    @Property(
        description = "Must contain at least one address. One and only one address may have the purpose of REGISTERED. Zero or one, and no more than one, record may have the purpose of MAIL. If zero then the REGISTERED address is to be used for mail",
        required = true
    )
    List<CommonPhysicalAddressWithPurpose> physicalAddresses;
}
