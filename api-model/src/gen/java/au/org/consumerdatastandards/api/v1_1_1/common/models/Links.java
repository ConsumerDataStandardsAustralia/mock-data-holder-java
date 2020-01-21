package au.org.consumerdatastandards.api.v1_1_1.common.models;

import au.org.consumerdatastandards.support.data.*;

@DataDefinition
public class Links {

    @Property(
        description = "Fully qualified link that generated the current response document",
        required = true
    )
    @CDSDataType(CustomDataType.URI)
    String self;
}
