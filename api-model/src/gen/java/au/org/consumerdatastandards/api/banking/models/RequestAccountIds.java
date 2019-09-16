package au.org.consumerdatastandards.api.banking.models;

import au.org.consumerdatastandards.api.common.models.Meta;
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
