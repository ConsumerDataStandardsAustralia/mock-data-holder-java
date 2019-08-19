package au.org.consumerdatastandards.api.banking.models;

import au.org.consumerdatastandards.support.data.*;

@DataDefinition(
    referenced = false
)
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
        description = "Generic field containing additional information relevant to the featureType specified. Whether mandatory or not is dependent on the value of featureType",
        requiredIf = {
            @Condition(
                propertyName = "featureType",
                values = {
                    "CARD_ACCESS",
                    "FREE_TXNS",
                    "FREE_TXNS_ALLOWANCE",
                    "LOYALTY_PROGRAM",
                    "INSURANCE",
                    "INTEREST_FREE",
                    "INTEREST_FREE_TRANSFERS",
                    "DIGITAL_WALLET",
                    "COMPLEMENTARY_PRODUCT_DISCOUNTS",
                    "BONUS_REWARDS",
                    "NOTIFICATIONS"
                },
                conditionalCDSDataTypes = {
                    @ConditionalCDSDataType(value="FREE_TXNS", cdsDataType = @CDSDataType(CustomDataType.PositiveInteger)),
                    @ConditionalCDSDataType(value="FREE_TXNS_ALLOWANCE", cdsDataType = @CDSDataType(CustomDataType.Amount)),
                    @ConditionalCDSDataType(value="INTEREST_FREE", cdsDataType = @CDSDataType(CustomDataType.Duration)),
                    @ConditionalCDSDataType(value="INTEREST_FREE_TRANSFERS", cdsDataType = @CDSDataType(CustomDataType.Duration)),
                    @ConditionalCDSDataType(value="BONUS_REWARDS", cdsDataType = @CDSDataType(CustomDataType.PositiveInteger)),
                }
            )
        }
    )
    String additionalValue;

    @Property(
        description = "Display text providing more information on the feature. Mandatory if the feature type is set to OTHER",
        requiredIf = { @Condition(propertyName = "featureType", values = {"OTHER"}) }
    )
    String additionalInfo;

    @Property(
        description = "Link to a web page with more information on this feature"
    )
    @CDSDataType(CustomDataType.URI)
    String additionalInfoUri;
}
