package au.org.consumerdatastandards.api.v1_0_0.banking.models;

import au.org.consumerdatastandards.api.v1_0_0.common.models.Meta;
import au.org.consumerdatastandards.support.data.*;

@DataDefinition
public class RequestAccountIds {

    @Property(
        required = true
    )
    RequestAccountIdsData data;

    @Property
    Meta meta;
}
