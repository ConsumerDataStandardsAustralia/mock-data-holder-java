package au.org.consumerdatastandards.client.model.energy;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Required if pricing model is SINGLE_RATE_CONT_LOAD or TIME_OF_USE_CONT_LOAD or FLEXIBLE_CONT_LOAD
 */
public class EnergyPlanControlledLoad {
    private String displayName;

    public enum RateBlockUTypeEnum {
        SINGLERATE("singleRate"),
        TIMEOFUSERATES("timeOfUseRates");

        private final String value;

        RateBlockUTypeEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

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


    private LocalDate startDate;

    private LocalDate endDate;

    private EnergyPlanControlledLoadSingleRate singleRate;

    private List<EnergyPlanControlledLoadTimeOfUseRates> timeOfUseRates = new ArrayList<>();

    public EnergyPlanControlledLoad displayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    /**
     * A display name for the controlled load
     *
     * @return displayName
     */
    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /**
     * Specifies the type of controlled load rate
     *
     * @return rateBlockUType
     */
    public RateBlockUTypeEnum getRateBlockUType() {
        return rateBlockUType;
    }

    public void setRateBlockUType(RateBlockUTypeEnum rateBlockUType) {
        this.rateBlockUType = rateBlockUType;
    }

    /**
     * Optional start date of the application of the controlled load rate
     *
     * @return startDate
     */
    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    /**
     * Optional end date of the application of the controlled load rate
     *
     * @return endDate
     */
    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    /**
     * Object representing a single controlled load rate.  Required if rateBlockUType is singleRate
     *
     * @return singleRate
     */
    public EnergyPlanControlledLoadSingleRate getSingleRate() {
        return singleRate;
    }

    public void setSingleRate(EnergyPlanControlledLoadSingleRate singleRate) {
        this.singleRate = singleRate;
    }

    /**
     * Array of objects representing time of use rates.  Required if rateBlockUType is timeOfUseRates
     *
     * @return timeOfUseRates
     */
    public List<EnergyPlanControlledLoadTimeOfUseRates> getTimeOfUseRates() {
        return timeOfUseRates;
    }

    public void setTimeOfUseRates(List<EnergyPlanControlledLoadTimeOfUseRates> timeOfUseRates) {
        this.timeOfUseRates = timeOfUseRates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EnergyPlanControlledLoad energyPlanControlledLoad = (EnergyPlanControlledLoad) o;
        return Objects.equals(this.displayName, energyPlanControlledLoad.displayName) &&
                Objects.equals(this.rateBlockUType, energyPlanControlledLoad.rateBlockUType) &&
                Objects.equals(this.startDate, energyPlanControlledLoad.startDate) &&
                Objects.equals(this.endDate, energyPlanControlledLoad.endDate) &&
                Objects.equals(this.singleRate, energyPlanControlledLoad.singleRate) &&
                Objects.equals(this.timeOfUseRates, energyPlanControlledLoad.timeOfUseRates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(displayName, rateBlockUType, startDate, endDate, singleRate, timeOfUseRates);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyPlanControlledLoad {\n");
        sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
        sb.append("    rateBlockUType: ").append(toIndentedString(rateBlockUType)).append("\n");
        sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
        sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
        sb.append("    singleRate: ").append(toIndentedString(singleRate)).append("\n");
        sb.append("    timeOfUseRates: ").append(toIndentedString(timeOfUseRates)).append("\n");
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
