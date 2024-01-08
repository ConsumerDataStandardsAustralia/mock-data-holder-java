package au.org.consumerdatastandards.client.model.energy;

import java.util.List;
import java.util.Objects;

/**
 * EnergyPlanContractTimeVaryingTariffsTimeVariations
 */
public class EnergyPlanContractTimeVaryingTariffsTimeVariations {
    public enum DaysEnum {
        SUN,
        MON,
        TUE,
        WED,
        THU,
        FRI,
        SAT,
        PUBLIC_HOLIDAYS
    }

    private List<DaysEnum> days;

    private String startTime;

    private String endTime;

    public EnergyPlanContractTimeVaryingTariffsTimeVariations days(List<DaysEnum> days) {
        this.days = days;
        return this;
    }

    /**
     * The days that the tariff applies to. At least one entry required
     *
     * @return days
     */
    public List<DaysEnum> getDays() {
        return days;
    }

    public void setDays(List<DaysEnum> days) {
        this.days = days;
    }

    public EnergyPlanContractTimeVaryingTariffsTimeVariations startTime(String startTime) {
        this.startTime = startTime;
        return this;
    }

    /**
     * The beginning of the time period per day for which the tariff applies.  If absent assumes start of day (ie. midnight).\n\nFormatted according to [ISO 8601 Times](https://en.wikipedia.org/wiki/ISO_8601#Times). If the time is provided without a UTC offset, the time zone will be determined by the value of EnergyPlanContract.timeZone.
     *
     * @return startTime
     */
    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public EnergyPlanContractTimeVaryingTariffsTimeVariations endTime(String endTime) {
        this.endTime = endTime;
        return this;
    }

    /**
     * The end of the time period per day for which the tariff applies.  If absent assumes end of day (ie. one second before midnight).\n\nFormatted according to [ISO 8601 Times](https://en.wikipedia.org/wiki/ISO_8601#Times). If the time is provided without a UTC offset, the time zone will be determined by the value of EnergyPlanContract.timeZone.
     *
     * @return endTime
     */
    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EnergyPlanContractTimeVaryingTariffsTimeVariations energyPlanContractTimeVaryingTariffsTimeVariations = (EnergyPlanContractTimeVaryingTariffsTimeVariations) o;
        return Objects.equals(this.days, energyPlanContractTimeVaryingTariffsTimeVariations.days) &&
                Objects.equals(this.startTime, energyPlanContractTimeVaryingTariffsTimeVariations.startTime) &&
                Objects.equals(this.endTime, energyPlanContractTimeVaryingTariffsTimeVariations.endTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(days, startTime, endTime);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyPlanContractTimeVaryingTariffsTimeVariations {\n");
        sb.append("    days: ").append(toIndentedString(days)).append("\n");
        sb.append("    startTime: ").append(toIndentedString(startTime)).append("\n");
        sb.append("    endTime: ").append(toIndentedString(endTime)).append("\n");
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
