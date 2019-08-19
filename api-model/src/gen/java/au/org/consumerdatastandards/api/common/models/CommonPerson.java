package au.org.consumerdatastandards.api.common.models;

import java.util.List;
import au.org.consumerdatastandards.support.data.*;

@DataDefinition
public class CommonPerson {

    @Property(
        description = "The date and time that this record was last updated by the customer.  If no update has occurred then this date should reflect the initial creation date for the data",
        required = true
    )
    @CDSDataType(CustomDataType.DateTime)
    String lastUpdateTime;

    @Property(
        description = "For people with single names this field need not be present.  The single name should be in the lastName field"
    )
    String firstName;

    @Property(
        description = "For people with single names the single name should be in this field",
        required = true
    )
    String lastName;

    @Property(
        description = "Field is mandatory but array may be empty",
        required = true
    )
    List<String> middleNames;

    @Property(
        description = "Also known as title or salutation.  The prefix to the name (e.g. Mr, Mrs, Ms, Miss, Sir, etc)"
    )
    String prefix;

    @Property(
        description = "Used for a trailing suffix to the name (e.g. Jr)"
    )
    String suffix;

    @Property(
        description = "Value is a valid [ANZCO v1.2](http://www.abs.gov.au/ANZSCO) Standard Occupation classification."
    )
    String occupationCode;
}
