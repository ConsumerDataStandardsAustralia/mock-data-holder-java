package au.org.consumerdatastandards.api.common.models;

import au.org.consumerdatastandards.support.data.DataDefinition;
import au.org.consumerdatastandards.support.data.Property;

@DataDefinition
public class BaseResponse {

    @Property(
        description = "The links attribute contains a Links object with links to related API end points. This will include links to support pagination.",
        required = true
    )
    protected Links links;

    @Property(
        description = "The meta object is used to provide additional information such as second factor authorisation data, traffic management, pagination counts or other purposes that are complementary to the workings of the API."
    )
    protected Meta meta;
}
