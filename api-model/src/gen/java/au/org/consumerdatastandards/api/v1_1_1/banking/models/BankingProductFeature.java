package au.org.consumerdatastandards.api.v1_1_1.banking.models;

import au.org.consumerdatastandards.support.data.*;

@DataDefinition
@CustomAttributes({
    @CustomAttribute(name = "x-conditional", value = "additionalValue", multiple = true),
    @CustomAttribute(name = "x-conditional", value = "additionalInfo", multiple = true)
})
public class BankingProductFeature {

    public enum FeatureType {
        CARD_ACCESS,
        ADDITIONAL_CARDS,
        UNLIMITED_TXNS,
        FREE_TXNS,
        FREE_TXNS_ALLOWANCE,
        LOYALTY_PROGRAM,
        OFFSET,
        OVERDRAFT,
        REDRAW,
        INSURANCE,
        BALANCE_TRANSFERS,
        INTEREST_FREE,
        INTEREST_FREE_TRANSFERS,
        DIGITAL_WALLET,
        DIGITAL_BANKING,
        NPP_PAYID,
        NPP_ENABLED,
        DONATE_INTEREST,
        BILL_PAYMENT,
        COMPLEMENTARY_PRODUCT_DISCOUNTS,
        BONUS_REWARDS,
        NOTIFICATIONS,
        OTHER
    }

    @Property(
        description = "The type of feature described",
        required = true
    )
    FeatureType featureType;

    @Property(
        description = "Generic field containing additional information relevant to the [featureType](#tocSproductfeaturetypedoc) specified. Whether mandatory or not is dependent on the value of the [featureType.](#tocSproductfeaturetypedoc)"
    )
    String additionalValue;

    @Property(
        description = "Display text providing more information on the feature. Mandatory if the [feature type](#tocSproductfeaturetypedoc) is set to OTHER"
    )
    String additionalInfo;

    @Property(
        description = "Link to a web page with more information on this feature"
    )
    @CDSDataType(CustomDataType.URI)
    String additionalInfoUri;
}
