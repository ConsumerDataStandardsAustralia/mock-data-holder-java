package au.org.consumerdatastandards.api.v1_0_0.common.models;

import au.org.consumerdatastandards.support.data.*;

@DataDefinition
public class MetaPaginated {

    @Property(
        description = "The total number of records in the full set. See [pagination](#pagination).",
        required = true
    )
    @CDSDataType(CustomDataType.NaturalNumber)
    protected Integer totalRecords;

    @Property(
        description = "The total number of pages in the full set. See [pagination](#pagination).",
        required = true
    )
    @CDSDataType(CustomDataType.NaturalNumber)
    protected Integer totalPages;
}
