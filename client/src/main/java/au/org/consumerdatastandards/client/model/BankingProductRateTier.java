package au.org.consumerdatastandards.client.model;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * Defines the criteria and conditions for which a rate applies
 */
public abstract class BankingProductRateTier {

    private String name;

    private UnitOfMeasure unitOfMeasure;

    private BigDecimal minimumValue;

    private BigDecimal maximumValue;

    private RateApplicationMethod rateApplicationMethod;

    private BankingProductRateCondition applicabilityConditions;

    /**
     * A display name for the tier
     * @return name
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * The unit of measure that applies to the tierValueMinimum and tierValueMaximum values e.g. a **DOLLAR** amount. **PERCENT** (in the case of loan-to-value ratio or LVR). Tier term period representing a discrete number of **MONTH**&#39;s or **DAY**&#39;s (in the case of term deposit tiers)
     * @return unitOfMeasure
     */
    public UnitOfMeasure getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    /**
     * The number of tierUnitOfMeasure units that form the lower bound of the tier. The tier should be inclusive of this value
     * @return minimumValue
     */
    public BigDecimal getMinimumValue() {
        return minimumValue;
    }

    public void setMinimumValue(BigDecimal minimumValue) {
        this.minimumValue = minimumValue;
    }

    /**
     * The number of tierUnitOfMeasure units that form the upper bound of the tier or band. For a tier with a discrete value (as opposed to a range of values e.g. 1 month) this must be the same as tierValueMinimum. Where this is the same as the tierValueMinimum value of the next-higher tier the referenced tier should be exclusive of this value. For example a term deposit of 2 months falls into the upper tier of the following tiers: (1 – 2 months, 2 – 3 months). If absent the tier&#39;s range has no upper bound.
     * @return maximumValue
     */
    public BigDecimal getMaximumValue() {
        return maximumValue;
    }

    public void setMaximumValue(BigDecimal maximumValue) {
        this.maximumValue = maximumValue;
    }

    /**
     * The method used to calculate the amount to be applied using one or more tiers. A single rate may be applied to the entire balance or each applicable tier rate is applied to the portion of the balance that falls into that tier (referred to as &#39;bands&#39; or &#39;steps&#39;)
     * @return rateApplicationMethod
     */
    public RateApplicationMethod getRateApplicationMethod() {
        return rateApplicationMethod;
    }

    public void setRateApplicationMethod(RateApplicationMethod rateApplicationMethod) {
        this.rateApplicationMethod = rateApplicationMethod;
    }

    /**
     * Get applicabilityConditions
     * @return applicabilityConditions
     */
    public BankingProductRateCondition getApplicabilityConditions() {
        return applicabilityConditions;
    }

    public void setApplicabilityConditions(BankingProductRateCondition applicabilityConditions) {
        this.applicabilityConditions = applicabilityConditions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BankingProductRateTier bankingProductRateTier = (BankingProductRateTier) o;
        return Objects.equals(this.name, bankingProductRateTier.name) &&
            Objects.equals(this.unitOfMeasure, bankingProductRateTier.unitOfMeasure) &&
            Objects.equals(this.minimumValue, bankingProductRateTier.minimumValue) &&
            Objects.equals(this.maximumValue, bankingProductRateTier.maximumValue) &&
            Objects.equals(this.rateApplicationMethod, bankingProductRateTier.rateApplicationMethod) &&
            Objects.equals(this.applicabilityConditions, bankingProductRateTier.applicabilityConditions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            name,
            unitOfMeasure,
            minimumValue,
            maximumValue,
            rateApplicationMethod,
            applicabilityConditions);
    }

    @Override
    public String toString() {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        pw.print("class "); pw.print(getClass().getSimpleName()); pw.println(" {");
        writeProperties(pw);
        pw.print("}");
        return sw.toString();
    }

    protected void writeProperties(PrintWriter pw) {
        pw.print("   name: "); pw.println(toIndentedString(name));
        pw.print("   unitOfMeasure: "); pw.println(toIndentedString(unitOfMeasure));
        pw.print("   minimumValue: "); pw.println(toIndentedString(minimumValue));
        pw.print("   maximumValue: "); pw.println(toIndentedString(maximumValue));
        pw.print("   rateApplicationMethod: "); pw.println(toIndentedString(rateApplicationMethod));
        pw.print("   applicabilityConditions: "); pw.println(toIndentedString(applicabilityConditions));
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    protected String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

    public enum UnitOfMeasure {
        DOLLAR,
        PERCENT,
        DAY,
        MONTH
    }

    public enum RateApplicationMethod {
        PER_TIER,
        WHOLE_BALANCE
    }
}
