package au.org.consumerdatastandards.client.model.energy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * EnergyPlanContractFullV2
 */
public class EnergyPlanContractFullV2 extends EnergyPlanContractV2 implements EnergyPlanContractFull {

    private TermTypeEnum termType;

    private String benefitPeriod;

    private String terms;

    private List<String> meterTypes = null;

    private Integer coolingOffDays;

    private List<String> billFrequency = new ArrayList<>();

    public EnergyPlanContractFull termType(TermTypeEnum termType) {
        this.termType = termType;
        return this;
    }

    /**
     * The term for the contract.  If absent assumes no specified term
     *
     * @return termType
     */
    @Override
    public TermTypeEnum getTermType() {
        return termType;
    }

    @Override
    public void setTermType(TermTypeEnum termType) {
        this.termType = termType;
    }

    public EnergyPlanContractFull benefitPeriod(String benefitPeriod) {
        this.benefitPeriod = benefitPeriod;
        return this;
    }

    /**
     * Description of the benefit period.  Should only be present if termType has the value ONGOING
     *
     * @return benefitPeriod
     */
    @Override
    public String getBenefitPeriod() {
        return benefitPeriod;
    }

    @Override
    public void setBenefitPeriod(String benefitPeriod) {
        this.benefitPeriod = benefitPeriod;
    }

    public EnergyPlanContractFull terms(String terms) {
        this.terms = terms;
        return this;
    }

    /**
     * Free text description of the terms for the contract
     *
     * @return terms
     */
    @Override
    public String getTerms() {
        return terms;
    }

    @Override
    public void setTerms(String terms) {
        this.terms = terms;
    }

    public EnergyPlanContractFull meterTypes(List<String> meterTypes) {
        this.meterTypes = meterTypes;
        return this;
    }

    public EnergyPlanContractFull addMeterTypesItem(String meterTypesItem) {
        if (this.meterTypes == null) {
            this.meterTypes = new ArrayList<>();
        }
        this.meterTypes.add(meterTypesItem);
        return this;
    }

    /**
     * An array of the meter types that this contract is available for
     *
     * @return meterTypes
     */
    @Override
    public List<String> getMeterTypes() {
        return meterTypes;
    }

    @Override
    public void setMeterTypes(List<String> meterTypes) {
        this.meterTypes = meterTypes;
    }

    public EnergyPlanContractFull coolingOffDays(Integer coolingOffDays) {
        this.coolingOffDays = coolingOffDays;
        return this;
    }

    /**
     * Number of days in the cooling off period for the contract.  Mandatory for plans with type of MARKET
     *
     * @return coolingOffDays
     */
    @Override
    public Integer getCoolingOffDays() {
        return coolingOffDays;
    }

    @Override
    public void setCoolingOffDays(Integer coolingOffDays) {
        this.coolingOffDays = coolingOffDays;
    }

    public EnergyPlanContractFull billFrequency(List<String> billFrequency) {
        this.billFrequency = billFrequency;
        return this;
    }

    public EnergyPlanContractFull addBillFrequencyItem(String billFrequencyItem) {
        this.billFrequency.add(billFrequencyItem);
        return this;
    }

    /**
     * An array of the available billing schedules for this contract. Formatted according to [ISO 8601 Durations](https://en.wikipedia.org/wiki/ISO_8601#Durations) (excludes recurrence syntax)
     *
     * @return billFrequency
     */
    @Override
    public List<String> getBillFrequency() {
        return billFrequency;
    }

    @Override
    public void setBillFrequency(List<String> billFrequency) {
        this.billFrequency = billFrequency;
    }

    @Override
    public boolean equals(Object o) {
        if (super.equals(o)) {
            EnergyPlanContractFullV2 energyPlanContractFull = (EnergyPlanContractFullV2) o;
            return Objects.equals(this.termType, energyPlanContractFull.termType) &&
                    Objects.equals(this.benefitPeriod, energyPlanContractFull.benefitPeriod) &&
                    Objects.equals(this.terms, energyPlanContractFull.terms) &&
                    Objects.equals(this.meterTypes, energyPlanContractFull.meterTypes) &&
                    Objects.equals(this.coolingOffDays, energyPlanContractFull.coolingOffDays) &&
                    Objects.equals(this.billFrequency, energyPlanContractFull.billFrequency);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(termType, benefitPeriod, terms, meterTypes, coolingOffDays, billFrequency, super.hashCode());
    }

    @Override
    protected void writeProperties(StringBuilder sb) {
        super.writeProperties(sb);
        sb.append("    termType: ").append(toIndentedString(termType)).append("\n");
        sb.append("    benefitPeriod: ").append(toIndentedString(benefitPeriod)).append("\n");
        sb.append("    terms: ").append(toIndentedString(terms)).append("\n");
        sb.append("    meterTypes: ").append(toIndentedString(meterTypes)).append("\n");
        sb.append("    coolingOffDays: ").append(toIndentedString(coolingOffDays)).append("\n");
        sb.append("    billFrequency: ").append(toIndentedString(billFrequency)).append("\n");
    }
}
