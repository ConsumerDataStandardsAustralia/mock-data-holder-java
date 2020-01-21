package au.org.consumerdatastandards.api.v1_1_1.banking.models;

import au.org.consumerdatastandards.support.data.CDSDataType;
import au.org.consumerdatastandards.support.data.CustomDataType;
import au.org.consumerdatastandards.support.data.DataDefinition;
import au.org.consumerdatastandards.support.data.Property;

@DataDefinition(
    referenced = false,
    description = "Object that contains links to additional information on specific topics"
)
public class BankingProductV2AdditionalInformation {

    @Property(
        description = "General overview of the product"
    )
    @CDSDataType(CustomDataType.URI)
    String overviewUri;

    @Property(
        description = "Terms and conditions for the product"
    )
    @CDSDataType(CustomDataType.URI)
    String termsUri;

    @Property(
        description = "Eligibility rules and criteria for the product"
    )
    @CDSDataType(CustomDataType.URI)
    String eligibilityUri;

    @Property(
        description = "Description of fees, pricing, discounts, exemptions and bonuses for the product"
    )
    @CDSDataType(CustomDataType.URI)
    String feesAndPricingUri;

    @Property(
        description = "Description of a bundle that this product can be part of"
    )
    @CDSDataType(CustomDataType.URI)
    String bundleUri;
}
