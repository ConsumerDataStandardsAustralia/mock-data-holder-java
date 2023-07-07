package au.org.consumerdatastandards.client.model.energy;

import java.util.List;

public interface EnergyPlanContractFull extends EnergyPlanContract {
    /**
     * The term for the contract.  If absent assumes no specified term
     *
     * @return termType
     */
    TermTypeEnum getTermType();

    void setTermType(TermTypeEnum termType);

    /**
     * Description of the benefit period.  Should only be present if termType has the value ONGOING
     *
     * @return benefitPeriod
     */
    String getBenefitPeriod();

    void setBenefitPeriod(String benefitPeriod);

    /**
     * Free text description of the terms for the contract
     *
     * @return terms
     */
    String getTerms();

    void setTerms(String terms);

    /**
     * An array of the meter types that this contract is available for
     *
     * @return meterTypes
     */
    List<String> getMeterTypes();

    void setMeterTypes(List<String> meterTypes);

    /**
     * Number of days in the cooling off period for the contract.  Mandatory for plans with type of MARKET
     *
     * @return coolingOffDays
     */
    Integer getCoolingOffDays();

    void setCoolingOffDays(Integer coolingOffDays);

    /**
     * An array of the available billing schedules for this contract. Formatted according to [ISO 8601 Durations](https://en.wikipedia.org/wiki/ISO_8601#Durations) (excludes recurrence syntax)
     *
     * @return billFrequency
     */
    List<String> getBillFrequency();

    void setBillFrequency(List<String> billFrequency);

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

        private final String value;

        TermTypeEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static TermTypeEnum fromValue(String value) {
            for (TermTypeEnum b : TermTypeEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }
}
