package au.org.consumerdatastandards.api.banking.models;

import java.util.List;
import au.org.consumerdatastandards.support.data.*;

@DataDefinition(
    referenced = false
)
@CustomAttributes({
    @CustomAttribute(name = "x-conditional", value = "additionalValue", multiple = true)
})
public class BankingProductDepositRate {

    public enum DepositRateType {
        FIXED,
        BONUS,
        BUNDLE_BONUS,
        VARIABLE,
        INTRODUCTORY,
        FLOATING,
        MARKET_LINKED
    }

    @Property(
        description = "The type of rate (base, bonus, etc). See the next section for an overview of valid values and their meaning",
        required = true
    )
    DepositRateType depositRateType;

    @Property(
        description = "The rate to be applied",
        required = true
    )
    @CDSDataType(CustomDataType.Rate)
    String rate;

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
        description = "Rate tiers applicable for this rate"
    )
    List<BankingProductRateTier> tiers;

    @Property(
        description = "Generic field containing additional information relevant to the [depositRateType](#tocSproductdepositratetypedoc) specified. Whether mandatory or not is dependent on the value of [depositRateType](#tocSproductdepositratetypedoc)",
        requiredIf = {
            @Condition(
                propertyName = "depositRateType",
                values = {
                    "FIXED",
                    "BONUS",
                    "BUNDLE_BONUS",
                    "INTRODUCTORY",
                    "FLOATING",
                    "MARKET_LINKED"
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
        description = "Display text providing more information on the rate"
    )
    String additionalInfo;

    @Property(
        description = "Link to a web page with more information on this rate"
    )
    @CDSDataType(CustomDataType.URI)
    String additionalInfoUri;
}
