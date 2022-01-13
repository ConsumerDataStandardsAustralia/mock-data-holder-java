package au.org.consumerdatastandards.holder.model.energy;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * EnergyPlanContractFullAllOf
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen",
        date = "2022-01-11T14:03:27.755+11:00[Australia/Sydney]")
public class EnergyPlanContractFullAllOf {
    /**
     * The term for the contract.  If absent assumes no specified term
     */
    public enum TermTypeEnum {
        _1_YEAR("1_YEAR"),

        _2_YEAR("2_YEAR"),

        _3_YEAR("3_YEAR"),

        _4_YEAR("4_YEAR"),

        _5_YEAR("5_YEAR"),

        ONGOING("ONGOING"),

        OTHER("OTHER");

        private String value;

        TermTypeEnum(String value) {
            this.value = value;
        }

        @JsonValue
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        @JsonCreator
        public static TermTypeEnum fromValue(String value) {
            for (TermTypeEnum b : TermTypeEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    @JsonProperty("termType")
    private TermTypeEnum termType;

    @JsonProperty("benefitPeriod")
    private String benefitPeriod;

    @JsonProperty("terms")
    private String terms;

    @JsonProperty("meterTypes")
    @Valid
    private List<String> meterTypes = null;

    @JsonProperty("coolingOffDays")
    private String coolingOffDays;

    @JsonProperty("billFrequency")
    @Valid
    private List<String> billFrequency = new ArrayList<>();

    public EnergyPlanContractFullAllOf termType(TermTypeEnum termType) {
        this.termType = termType;
        return this;
    }

    /**
     * The term for the contract.  If absent assumes no specified term
     *
     * @return termType
     */
    @ApiModelProperty(value = "The term for the contract.  If absent assumes no specified term")


    public TermTypeEnum getTermType() {
        return termType;
    }

    public void setTermType(TermTypeEnum termType) {
        this.termType = termType;
    }

    public EnergyPlanContractFullAllOf benefitPeriod(String benefitPeriod) {
        this.benefitPeriod = benefitPeriod;
        return this;
    }

    /**
     * Description of the benefit period.  Should only be present if termType has the value ONGOING
     *
     * @return benefitPeriod
     */
    @ApiModelProperty(value = "Description of the benefit period.  Should only be present if termType has the value ONGOING")


    public String getBenefitPeriod() {
        return benefitPeriod;
    }

    public void setBenefitPeriod(String benefitPeriod) {
        this.benefitPeriod = benefitPeriod;
    }

    public EnergyPlanContractFullAllOf terms(String terms) {
        this.terms = terms;
        return this;
    }

    /**
     * Free text description of the terms for the contract
     *
     * @return terms
     */
    @ApiModelProperty(value = "Free text description of the terms for the contract")


    public String getTerms() {
        return terms;
    }

    public void setTerms(String terms) {
        this.terms = terms;
    }

    public EnergyPlanContractFullAllOf meterTypes(List<String> meterTypes) {
        this.meterTypes = meterTypes;
        return this;
    }

    public EnergyPlanContractFullAllOf addMeterTypesItem(String meterTypesItem) {
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
    @ApiModelProperty(value = "An array of the meter types that this contract is available for")


    public List<String> getMeterTypes() {
        return meterTypes;
    }

    public void setMeterTypes(List<String> meterTypes) {
        this.meterTypes = meterTypes;
    }

    public EnergyPlanContractFullAllOf coolingOffDays(String coolingOffDays) {
        this.coolingOffDays = coolingOffDays;
        return this;
    }

    /**
     * Number of days in the cooling off period for the contract.  Mandatory for plans with type of MARKET
     *
     * @return coolingOffDays
     */
    @ApiModelProperty(value = "Number of days in the cooling off period for the contract.  Mandatory for plans with type of MARKET ")


    public String getCoolingOffDays() {
        return coolingOffDays;
    }

    public void setCoolingOffDays(String coolingOffDays) {
        this.coolingOffDays = coolingOffDays;
    }

    public EnergyPlanContractFullAllOf billFrequency(List<String> billFrequency) {
        this.billFrequency = billFrequency;
        return this;
    }

    public EnergyPlanContractFullAllOf addBillFrequencyItem(String billFrequencyItem) {
        this.billFrequency.add(billFrequencyItem);
        return this;
    }

    /**
     * An array of the available billing schedules for this contract. Formatted according to [ISO 8601 Durations](https://en.wikipedia.org/wiki/ISO_8601#Durations) (excludes recurrence syntax)
     *
     * @return billFrequency
     */
    @ApiModelProperty(required = true,
            value = "An array of the available billing schedules for this contract. Formatted according to [ISO 8601 Durations](https://en.wikipedia.org/wiki/ISO_8601#Durations) (excludes recurrence syntax)")
    @NotNull


    public List<String> getBillFrequency() {
        return billFrequency;
    }

    public void setBillFrequency(List<String> billFrequency) {
        this.billFrequency = billFrequency;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EnergyPlanContractFullAllOf energyPlanContractFullAllOf = (EnergyPlanContractFullAllOf) o;
        return Objects.equals(this.termType, energyPlanContractFullAllOf.termType) &&
                Objects.equals(this.benefitPeriod, energyPlanContractFullAllOf.benefitPeriod) &&
                Objects.equals(this.terms, energyPlanContractFullAllOf.terms) &&
                Objects.equals(this.meterTypes, energyPlanContractFullAllOf.meterTypes) &&
                Objects.equals(this.coolingOffDays, energyPlanContractFullAllOf.coolingOffDays) &&
                Objects.equals(this.billFrequency, energyPlanContractFullAllOf.billFrequency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(termType, benefitPeriod, terms, meterTypes, coolingOffDays, billFrequency);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyPlanContractFullAllOf {\n");

        sb.append("    termType: ").append(toIndentedString(termType)).append("\n");
        sb.append("    benefitPeriod: ").append(toIndentedString(benefitPeriod)).append("\n");
        sb.append("    terms: ").append(toIndentedString(terms)).append("\n");
        sb.append("    meterTypes: ").append(toIndentedString(meterTypes)).append("\n");
        sb.append("    coolingOffDays: ").append(toIndentedString(coolingOffDays)).append("\n");
        sb.append("    billFrequency: ").append(toIndentedString(billFrequency)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}

