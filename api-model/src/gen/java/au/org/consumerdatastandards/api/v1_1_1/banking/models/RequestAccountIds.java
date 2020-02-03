package au.org.consumerdatastandards.api.v1_1_1.banking.models;

import au.org.consumerdatastandards.api.v1_1_1.common.models.Meta;
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
