package au.org.consumerdatastandards.api.common.models;

import au.org.consumerdatastandards.support.data.*;

@DataDefinition(
    referenced = false
)
public class CommonDiscoveryStatusData {

    public enum Status {
        OK,
        PARTIAL_FAILURE,
        UNAVAILABLE,
        SCHEDULED_OUTAGE
    }

    @Property(
        description = "Enumeration with values. OK (implementation is fully functional). PARTIAL_FAILURE (one or more end points are unexpectedly unavailable). UNAVAILABLE (the full implementation is unexpectedly unavailable). SCHEDULED_OUTAGE (an advertised outage is in effect)",
        required = true
    )
    Status status;

    @Property(
        description = "Provides an explanation of the current outage that can be displayed to an end customer. Mandatory if the status property is any value other than OK"
    )
    String explanation;

    @Property(
        description = "The date and time that the current outage was detected. Should only be present if the status property is PARTIAL_FAILURE or UNAVAILABLE"
    )
    @CDSDataType(CustomDataType.DateTime)
    String detectionTime;

    @Property(
        description = "The date and time that full service is expected to resume (if known). Should not be present if the status property has a value of OK."
    )
    @CDSDataType(CustomDataType.DateTime)
    String expectedResolutionTime;

    @Property(
        description = "The date and time that this status was last updated by the Data Holder.",
        required = true
    )
    @CDSDataType(CustomDataType.DateTime)
    String updateTime;
}
