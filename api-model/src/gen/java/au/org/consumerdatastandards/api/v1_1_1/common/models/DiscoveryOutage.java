package au.org.consumerdatastandards.api.v1_1_1.common.models;

import au.org.consumerdatastandards.support.data.CDSDataType;
import au.org.consumerdatastandards.support.data.CustomDataType;
import au.org.consumerdatastandards.support.data.DataDefinition;
import au.org.consumerdatastandards.support.data.Property;

import java.time.OffsetDateTime;

@DataDefinition
public class DiscoveryOutage {

    @Property(
        description = "Date and time that the outage is scheduled to begin",
        required = true
    )
    @CDSDataType(CustomDataType.DateTime)
    OffsetDateTime outageTime;

    @Property(
        description = "Planned duration of the outage. Formatted according to [ISO 8601 Durations](https://en.wikipedia.org/wiki/ISO_8601#Durations) (excludes recurrence syntax)",
        required = true
    )
    @CDSDataType(CustomDataType.Duration)
    String duration;

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
