package au.org.consumerdatastandards.client.model.energy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * EnergyPlanContractTariffPeriod
 */
public class EnergyPlanContractTariffPeriod {

    /**
     * Type of charge. Assumed to be other if absent
     */
    public enum TypeEnum {
        ENVIRONMENTAL,
        REGULATED,
        NETWORK,
        METERING,
        RETAIL_SERVICE,
        RCTI,
        OTHER
    }

    private TypeEnum type;

    private String displayName;

    private String startDate;

    private String endDate;

    private String dailySupplyCharges;

    /**
     * Specifies the charge specific time zone for calculation of the time of use thresholds. If absent, timezone value in EnergyPlanContract is assumed.
     */
    public enum TimeZone {
        LOCAL,
        AEST
    }

    private TimeZone timeZone;

    /**
     * Specifies the type of rate applicable to this tariff period
     */
    public enum RateBlockUTypeEnum {
        SINGLERATE("singleRate"),

        TIMEOFUSERATES("timeOfUseRates"),

        DEMANDCHARGES("demandCharges");

        private final String value;

        RateBlockUTypeEnum(String value) {
            this.value = value;
        }

//        @JsonValue
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

//        @JsonCreator
        public static RateBlockUTypeEnum fromValue(String value) {
            for (RateBlockUTypeEnum b : RateBlockUTypeEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    private RateBlockUTypeEnum rateBlockUType;

    private EnergyPlanContractSingleRate singleRate;

    private List<EnergyPlanContractTimeOfUseRates> timeOfUseRates = null;

    private List<EnergyPlanContractDemandCharges> demandCharges = null;

    public EnergyPlanContractTariffPeriod type(TypeEnum type) {
        this.type = type;
        return this;
    }

    /**
     * Type of charge. Assumed to be other if absent
     *
     * @return type
     */
    public TypeEnum getType() {
        return type;
    }

    public void setType(TypeEnum type) {
        this.type = type;
    }

    public EnergyPlanContractTariffPeriod displayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    /**
     * The name of the tariff period
     *
     * @return displayName
     */
    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public EnergyPlanContractTariffPeriod startDate(String startDate) {
        this.startDate = startDate;
        return this;
    }

    /**
     * The start date of the tariff period in a calendar year.  Formatted in mm-dd format
     *
     * @return startDate
     */
    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public EnergyPlanContractTariffPeriod endDate(String endDate) {
        this.endDate = endDate;
        return this;
    }

    /**
     * The end date of the tariff period in a calendar year.  Formatted in mm-dd format
     *
     * @return endDate
     */
    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public EnergyPlanContractTariffPeriod dailySupplyCharges(String dailySupplyCharges) {
        this.dailySupplyCharges = dailySupplyCharges;
        return this;
    }

    /**
     * The amount of access charge for the tariff period, in dollars per day exclusive of GST.
     *
     * @return dailySupplyCharges
     */
    public String getDailySupplyCharges() {
        return dailySupplyCharges;
    }

    public void setDailySupplyCharges(String dailySupplyCharges) {
        this.dailySupplyCharges = dailySupplyCharges;
    }

    /**
     * Specifies the charge specific time zone for calculation of the time of use thresholds. If absent, timezone value in EnergyPlanContract is assumed.
     *
     * @return timeZone
     */
    public TimeZone getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(TimeZone timeZone) {
        this.timeZone = timeZone;
    }

    public EnergyPlanContractTariffPeriod rateBlockUType(RateBlockUTypeEnum rateBlockUType) {
        this.rateBlockUType = rateBlockUType;
        return this;
    }

    /**
     * Specifies the type of rate applicable to this tariff period
     *
     * @return rateBlockUType
     */
    public RateBlockUTypeEnum getRateBlockUType() {
        return rateBlockUType;
    }

    public void setRateBlockUType(RateBlockUTypeEnum rateBlockUType) {
        this.rateBlockUType = rateBlockUType;
    }

    public EnergyPlanContractTariffPeriod singleRate(EnergyPlanContractSingleRate singleRate) {
        this.singleRate = singleRate;
        return this;
    }

    /**
     * Get singleRate
     *
     * @return singleRate
     */
    public EnergyPlanContractSingleRate getSingleRate() {
        return singleRate;
    }

    public void setSingleRate(EnergyPlanContractSingleRate singleRate) {
        this.singleRate = singleRate;
    }

    public EnergyPlanContractTariffPeriod timeOfUseRates(List<EnergyPlanContractTimeOfUseRates> timeOfUseRates) {
        this.timeOfUseRates = timeOfUseRates;
        return this;
    }

    public EnergyPlanContractTariffPeriod addTimeOfUseRatesItem(EnergyPlanContractTimeOfUseRates timeOfUseRatesItem) {
        if (this.timeOfUseRates == null) {
            this.timeOfUseRates = new ArrayList<>();
        }
        this.timeOfUseRates.add(timeOfUseRatesItem);
        return this;
    }

    /**
     * Array of objects representing time of use rates.  Required if rateBlockUType is timeOfUseRates
     *
     * @return timeOfUseRates
     */
    public List<EnergyPlanContractTimeOfUseRates> getTimeOfUseRates() {
        return timeOfUseRates;
    }

    public void setTimeOfUseRates(List<EnergyPlanContractTimeOfUseRates> timeOfUseRates) {
        this.timeOfUseRates = timeOfUseRates;
    }

    public EnergyPlanContractTariffPeriod demandCharges(List<EnergyPlanContractDemandCharges> demandCharges) {
        this.demandCharges = demandCharges;
        return this;
    }

    public EnergyPlanContractTariffPeriod addDemandChargesItem(EnergyPlanContractDemandCharges demandChargesItem) {
        if (this.demandCharges == null) {
            this.demandCharges = new ArrayList<>();
        }
        this.demandCharges.add(demandChargesItem);
        return this;
    }

    /**
     * Array of demand charges.  Required if rateBlockUType is demandCharges
     *
     * @return demandCharges
     */
    public List<EnergyPlanContractDemandCharges> getDemandCharges() {
        return demandCharges;
    }

    public void setDemandCharges(List<EnergyPlanContractDemandCharges> demandCharges) {
        this.demandCharges = demandCharges;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EnergyPlanContractTariffPeriod energyPlanContractTariffPeriod = (EnergyPlanContractTariffPeriod) o;
        return Objects.equals(this.type, energyPlanContractTariffPeriod.type) &&
                Objects.equals(this.displayName, energyPlanContractTariffPeriod.displayName) &&
                Objects.equals(this.startDate, energyPlanContractTariffPeriod.startDate) &&
                Objects.equals(this.endDate, energyPlanContractTariffPeriod.endDate) &&
                Objects.equals(this.dailySupplyCharges, energyPlanContractTariffPeriod.dailySupplyCharges) &&
                Objects.equals(this.timeZone, energyPlanContractTariffPeriod.timeZone) &&
                Objects.equals(this.rateBlockUType, energyPlanContractTariffPeriod.rateBlockUType) &&
                Objects.equals(this.singleRate, energyPlanContractTariffPeriod.singleRate) &&
                Objects.equals(this.timeOfUseRates, energyPlanContractTariffPeriod.timeOfUseRates) &&
                Objects.equals(this.demandCharges, energyPlanContractTariffPeriod.demandCharges);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, displayName, startDate, endDate, dailySupplyCharges, timeZone, rateBlockUType, singleRate, timeOfUseRates, demandCharges);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyPlanContractTariffPeriod {\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
        sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
        sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
        sb.append("    dailySupplyCharges: ").append(toIndentedString(dailySupplyCharges)).append("\n");
        sb.append("    timeZone: ").append(toIndentedString(timeZone)).append("\n");
        sb.append("    rateBlockUType: ").append(toIndentedString(rateBlockUType)).append("\n");
        sb.append("    singleRate: ").append(toIndentedString(singleRate)).append("\n");
        sb.append("    timeOfUseRates: ").append(toIndentedString(timeOfUseRates)).append("\n");
        sb.append("    demandCharges: ").append(toIndentedString(demandCharges)).append("\n");
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
