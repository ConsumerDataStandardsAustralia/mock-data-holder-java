package au.org.consumerdatastandards.api.common.models;

import au.org.consumerdatastandards.support.data.*;

@DataDefinition
public class CommonDiscoveryStatus extends BaseResponse {

    @Property(
        required = true
    )
    CommonDiscoveryStatusData data;
}
