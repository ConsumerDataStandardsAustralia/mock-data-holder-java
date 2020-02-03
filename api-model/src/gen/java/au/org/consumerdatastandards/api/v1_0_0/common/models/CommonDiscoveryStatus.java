package au.org.consumerdatastandards.api.v1_0_0.common.models;

import au.org.consumerdatastandards.support.data.*;

@DataDefinition
public class CommonDiscoveryStatus extends BaseResponse {

    @Property(
        required = true
    )
    CommonDiscoveryStatusData data;
}
