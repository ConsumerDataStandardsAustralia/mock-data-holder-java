package au.org.consumerdatastandards.api.v1_1_1.common.models;

import au.org.consumerdatastandards.support.data.DataDefinition;
import au.org.consumerdatastandards.support.data.Property;

@DataDefinition
public class ResponseCommonDiscoveryStatus extends BaseResponse {

    @Property(
        required = true
    )
    ResponseCommonDiscoveryStatusData data;
}
