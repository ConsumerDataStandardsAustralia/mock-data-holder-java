package au.org.consumerdatastandards.api.common.models;

import au.org.consumerdatastandards.support.data.*;

@DataDefinition
public class MetaPaginated {

    @Property(
        description = "The total number of records in the full set. See [pagination](#pagination).",
        required = true
    )
    @CDSDataType(CustomDataType.NaturalNumber)
    Integer totalRecords;

    @Property(
        description = "The total number of pages in the full set. See [pagination](#pagination).",
        required = true
    )
    @CDSDataType(CustomDataType.NaturalNumber)
    Integer totalPages;
}
