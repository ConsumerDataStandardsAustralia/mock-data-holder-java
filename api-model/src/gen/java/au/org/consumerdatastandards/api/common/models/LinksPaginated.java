package au.org.consumerdatastandards.api.common.models;

import au.org.consumerdatastandards.support.data.*;

@DataDefinition
@CustomAttributes({
    @CustomAttribute(name = "x-conditional", value = "prev", multiple = true),
    @CustomAttribute(name = "x-conditional", value = "next", multiple = true),
    @CustomAttribute(name = "x-conditional", value = "first", multiple = true),
    @CustomAttribute(name = "x-conditional", value = "last", multiple = true)
})
public class LinksPaginated {

    @Property(
        description = "Fully qualified link that generated the current response document",
        required = true
    )
    @CDSDataType(CustomDataType.URI)
    String self;

    @Property(
        description = "URI to the first page of this set. Mandatory if this response is not the first page"
    )
    @CDSDataType(CustomDataType.URI)
    String first;

    @Property(
        description = "URI to the previous page of this set. Mandatory if this response is not the first page"
    )
    @CDSDataType(CustomDataType.URI)
    String prev;

    @Property(
        description = "URI to the next page of this set. Mandatory if this response is not the last page"
    )
    @CDSDataType(CustomDataType.URI)
    String next;

    @Property(
        description = "URI to the last page of this set. Mandatory if this response is not the last page"
    )
    @CDSDataType(CustomDataType.URI)
    String last;
}
