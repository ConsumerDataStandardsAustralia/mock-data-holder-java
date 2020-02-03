package au.org.consumerdatastandards.api.v1_0_0.banking.models;

import java.math.BigDecimal;
import au.org.consumerdatastandards.support.data.*;

@DataDefinition(
    description = "Defines the criteria and conditions for which a rate applies"
)
public class BankingProductRateTier {

    public enum UnitOfMeasure {
        DOLLAR,
        PERCENT,
        MONTH,
        DAY
    }

    public enum RateApplicationMethod {
        WHOLE_BALANCE,
        PER_TIER
    }

    @Property(
        description = "A display name for the tier",
        required = true
    )
    String name;

    @Property(
        description = "The unit of measure that applies to the tierValueMinimum and tierValueMaximum values e.g. 'DOLLAR', 'MONTH' (in the case of term deposit tiers), 'PERCENT' (in the case of loan-to-value ratio or LVR)",
        required = true
    )
    UnitOfMeasure unitOfMeasure;

    @Property(
        description = "The number of tierUnitOfMeasure units that form the lower bound of the tier. The tier should be inclusive of this value",
        required = true
    )
    BigDecimal minimumValue;

    @Property(
        description = "The number of tierUnitOfMeasure units that form the upper bound of the tier or band. For a tier with a discrete value (as opposed to a range of values e.g. 1 month) this must be the same as tierValueMinimum. Where this is the same as the tierValueMinimum value of the next-higher tier the referenced tier should be exclusive of this value. For example a term deposit of 2 months falls into the upper tier of the following tiers: (1 – 2 months, 2 – 3 months). If absent the tier's range has no upper bound."
    )
    BigDecimal maximumValue;

    @Property(
        description = "The method used to calculate the amount to be applied using one or more tiers. A single rate may be applied to the entire balance or each applicable tier rate is applied to the portion of the balance that falls into that tier (referred to as 'bands' or 'steps')"
    )
    RateApplicationMethod rateApplicationMethod;

    @Property
    BankingProductRateCondition applicabilityConditions;

    @Property
    BankingProductRateTierSubTier subTier;
}
