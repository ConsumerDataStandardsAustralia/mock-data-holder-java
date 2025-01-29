package au.org.consumerdatastandards.holder.model.energy;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.List;

public interface EnergyPlanContractFull extends EnergyPlanContract {

    /**
     * The term for the contract. If absent assumes no specified term.
     *
     * @return termType
     */
    @ApiModelProperty(value = "The term for the contract. If absent assumes no specified term.")
    TermTypeEnum getTermType();

    void setTermType(TermTypeEnum termType);

    /**
     * Description of the benefit period. Should only be present if termType has the value `ONGOING`.
     *
     * @return benefitPeriod
     */
    @ApiModelProperty(value = "Description of the benefit period. Should only be present if termType has the value `ONGOING`.")
    String getBenefitPeriod();

    void setBenefitPeriod(String benefitPeriod);

    /**
     * Free text description of the terms for the contract.
     *
     * @return terms
     */
    @ApiModelProperty(value = "Free text description of the terms for the contract.")
    String getTerms();

    void setTerms(String terms);

    /**
     * An array of the meter types that this contract is available for.
     *
     * @return meterTypes
     */
    @ApiModelProperty(value = "An array of the meter types that this contract is available for.")
    List<String> getMeterTypes();

    void setMeterTypes(List<String> meterTypes);

    /**
     * Number of days in the cooling off period for the contract. Mandatory for plans with type of `MARKET`.
     *
     * @return coolingOffDays
     */
    @ApiModelProperty(value = "Number of days in the cooling off period for the contract. Mandatory for plans with type of `MARKET`.")
    Integer getCoolingOffDays();

    void setCoolingOffDays(Integer coolingOffDays);

    /**
     * An array of the available billing schedules for this contract. Formatted according to [ISO 8601 Durations](https://en.wikipedia.org/wiki/ISO_8601#Durations) (excludes recurrence syntax).
     *
     * @return billFrequency
     */
    @ApiModelProperty(required = true,
            value = "An array of the available billing schedules for this contract. Formatted according to [ISO 8601 Durations](https://en.wikipedia.org/wiki/ISO_8601#Durations) (excludes recurrence syntax).")
    @NotNull
    List<String> getBillFrequency();
    void setBillFrequency(List<String> billFrequency);

    /**
     * The term for the contract. If absent assumes no specified term.
     */
    public enum TermTypeEnum {
        _1_YEAR("1_YEAR"),
        _2_YEAR("2_YEAR"),
        _3_YEAR("3_YEAR"),
        _4_YEAR("4_YEAR"),
        _5_YEAR("5_YEAR"),
        ONGOING("ONGOING"),
        OTHER("OTHER");

        private final String value;

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
            for (TermTypeEnum b : EnergyPlanContractFull.TermTypeEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }
}
