package au.org.consumerdatastandards.api.banking.models;

import java.util.List;
import au.org.consumerdatastandards.support.data.*;

@DataDefinition
public class BankingProductBundle {

    @Property(
        description = "Name of the bundle",
        required = true
    )
    String name;

    @Property(
        description = "Description of the bundle",
        required = true
    )
    String description;

    @Property(
        description = "Display text providing more information on the bundle"
    )
    String additionalInfo;

    @Property(
        description = "Link to a web page with more information on the bundle criteria and benefits"
    )
    @CDSDataType(CustomDataType.URI)
    String additionalInfoUri;

    @Property(
        description = "Array of product IDs for products included in the bundle",
        required = true
    )
    List<String> productIds;
}
