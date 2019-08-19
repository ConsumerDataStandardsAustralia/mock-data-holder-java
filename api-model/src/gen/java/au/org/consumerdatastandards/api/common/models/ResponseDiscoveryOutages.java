package au.org.consumerdatastandards.api.common.models;

import au.org.consumerdatastandards.support.data.*;

@DataDefinition
public class ResponseDiscoveryOutages extends BaseResponse {

    @Property(
        required = true
    )
    ResponseDiscoveryOutagesData data;
}
