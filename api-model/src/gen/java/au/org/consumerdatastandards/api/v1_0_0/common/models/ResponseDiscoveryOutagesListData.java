package au.org.consumerdatastandards.api.v1_0_0.common.models;

import java.util.List;
import au.org.consumerdatastandards.support.data.*;

@DataDefinition(
    referenced = false
)
public class ResponseDiscoveryOutagesListData {

    @Property(
        description = "List of scheduled outages. Property is mandatory but may contain and empty list if no outages are scheduled",
        required = true
    )
    List<DiscoveryOutage> outages;
}
