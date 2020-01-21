package au.org.consumerdatastandards.api.v1_1_1.common.models;

import au.org.consumerdatastandards.support.data.*;

@DataDefinition
public class ResponseDiscoveryOutagesList extends BaseResponse {

    @Property(
        required = true
    )
    ResponseDiscoveryOutagesListData data;
}
