package au.org.consumerdatastandards.api.banking.models;

import au.org.consumerdatastandards.support.data.*;

@DataDefinition(
    description = "Defines a condition for the applicability of a tiered rate"
)
public class BankingProductRateCondition {

    @Property(
        description = "Display text providing more information on the condition"
    )
    String additionalInfo;

    @Property(
        description = "Link to a web page with more information on this condition"
    )
    @CDSDataType(CustomDataType.URI)
    String additionalInfoUri;
}
