package au.org.consumerdatastandards.api.banking.models;

import java.util.List;
import au.org.consumerdatastandards.support.data.*;

@DataDefinition(
    referenced = false
)
@CustomAttributes({
    @CustomAttribute(name = "x-conditional", value = "additionalValue", multiple = true)
})
public class BankingProductLendingRate {

    public enum LendingRateType {
        FIXED,
        VARIABLE,
        INTRODUCTORY,
        DISCOUNT,
        PENALTY,
        FLOATING,
        MARKET_LINKED,
        CASH_ADVANCE,
        PURCHASE,
        BUNDLE_DISCOUNT_FIXED,
        BUNDLE_DISCOUNT_VARIABLE
    }

    public enum InterestPaymentDue {
        IN_ARREARS,
        IN_ADVANCE
    }

    @Property(
        description = "The type of rate (fixed, variable, etc). See the next section for an overview of valid values and their meaning",
        required = true
    )
    LendingRateType lendingRateType;

    @Property(
        description = "The rate to be applied",
        required = true
    )
    @CDSDataType(CustomDataType.Rate)
    String rate;

    @Property(
        description = "A comparison rate equivalent for this rate"
    )
    @CDSDataType(CustomDataType.Rate)
    String comparisonRate;

    @Property(
        description = "The period after which the rate is applied to the balance to calculate the amount due for the period. Calculation of the amount is often daily (as balances may change) but accumulated until the total amount is 'applied' to the account (see applicationFrequency). Formatted according to [ISO 8601 Durations](https://en.wikipedia.org/wiki/ISO_8601#Durations)"
    )
    @CDSDataType(CustomDataType.ExternalRef)
    String calculationFrequency;

    @Property(
        description = "The period after which the calculated amount(s) (see calculationFrequency) are 'applied' (i.e. debited or credited) to the account. Formatted according to [ISO 8601 Durations](https://en.wikipedia.org/wiki/ISO_8601#Durations)"
    )
    @CDSDataType(CustomDataType.ExternalRef)
    String applicationFrequency;

    @Property(
        description = "When loan payments are due to be paid within each period. The investment benefit of earlier payments affect the rate that can be offered"
    )
    InterestPaymentDue interestPaymentDue;

    @Property(
        description = "Rate tiers applicable for this rate"
    )
    List<BankingProductRateTier> tiers;

    @Property(
        description = "Generic field containing additional information relevant to the [lendingRateType](#tocSproductlendingratetypedoc) specified. Whether mandatory or not is dependent on the value of [lendingRateType](#tocSproductlendingratetypedoc)",
        requiredIf = {
            @Condition(
                propertyName = "lendingRateType",
                values = {
                    "FIXED",
                    "INTRODUCTORY",
                    "DISCOUNT",
                    "PENALTY",
                    "FLOATING",
                    "MARKET_LINKED",
                    "BUNDLE_DISCOUNT_FIXED",
                    "BUNDLE_DISCOUNT_VARIABLE"
                },
                conditionalCDSDataTypes = {
                    @ConditionalCDSDataType(value = "FIXED", cdsDataType = @CDSDataType(CustomDataType.Duration)),
                    @ConditionalCDSDataType(value = "INTRODUCTORY", cdsDataType = @CDSDataType(CustomDataType.Duration))
                }
            )
        }
    )
    String additionalValue;

    @Property(
        description = "Display text providing more information on the rate."
    )
    String additionalInfo;

    @Property(
        description = "Link to a web page with more information on this rate"
    )
    @CDSDataType(CustomDataType.URI)
    String additionalInfoUri;
}
