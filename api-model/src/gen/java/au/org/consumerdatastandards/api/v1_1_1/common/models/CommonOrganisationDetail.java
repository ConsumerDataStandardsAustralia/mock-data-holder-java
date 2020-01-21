package au.org.consumerdatastandards.api.v1_1_1.common.models;

import java.util.List;
import au.org.consumerdatastandards.support.data.*;

@DataDefinition(
    allOf = { CommonOrganisation.class }
)
public class CommonOrganisationDetail {

    @Property(
        description = "Must contain at least one address. One and only one address may have the purpose of REGISTERED. Zero or one, and no more than one, record may have the purpose of MAIL. If zero then the REGISTERED address is to be used for mail",
        required = true
    )
    List<CommonPhysicalAddressWithPurpose> physicalAddresses;
}
