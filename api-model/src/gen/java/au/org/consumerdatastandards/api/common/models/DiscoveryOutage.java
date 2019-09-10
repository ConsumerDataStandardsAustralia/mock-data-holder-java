package au.org.consumerdatastandards.api.common.models;

import java.math.BigDecimal;
import au.org.consumerdatastandards.support.data.*;

@DataDefinition
public class DiscoveryOutage {

    @Property(
        description = "Date and time that the outage is scheduled to begin",
        required = true
    )
    @CDSDataType(CustomDataType.DateTime)
    String outageTime;

    @Property(
        description = "Planned duration of the outage in minutes",
        required = true
    )
    BigDecimal duration;

    @Property(
        description = "Flag that indicates, if present and set to true, that the outage is only partial meaning that only a subset of normally available end points will be affected by the outage"
    )
    Boolean isPartial;

    @Property(
        description = "Provides an explanation of the current outage that can be displayed to an end customer",
        required = true
    )
    String explanation;
}
