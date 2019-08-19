package au.org.consumerdatastandards.api.common.models;

import au.org.consumerdatastandards.support.data.*;

@DataDefinition
public class ResponseDiscoveryStatus extends BaseResponse {

    @Property(
        required = true
    )
    ResponseDiscoveryStatusData data;
}
