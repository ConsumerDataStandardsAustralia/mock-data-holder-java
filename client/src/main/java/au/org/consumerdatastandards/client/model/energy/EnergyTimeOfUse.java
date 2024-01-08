package au.org.consumerdatastandards.client.model.energy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * EnergyTimeOfUse
 */
public class EnergyTimeOfUse {
    /**
     * Gets or Sets days
     */
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

    private List<DaysEnum> days = new ArrayList<>();

    private String startTime;

    private String endTime;

    public EnergyTimeOfUse days(List<DaysEnum> days) {
        this.days = days;
        return this;
    }

    public EnergyTimeOfUse addDaysItem(DaysEnum daysItem) {
        this.days.add(daysItem);
        return this;
    }

    /**
     * The days that the rate applies to
     *
     * @return days
     */
    public List<DaysEnum> getDays() {
        return days;
    }

    public void setDays(List<DaysEnum> days) {
        this.days = days;
    }

    public EnergyTimeOfUse startTime(String startTime) {
        this.startTime = startTime;
        return this;
    }

    /**
     * Start of the period.\n\nFormatted according to [ISO 8601 Times](https://en.wikipedia.org/wiki/ISO_8601#Times). If the time is provided without a UTC offset, the time zone will be determined by the value of EnergyPlanContract.timeZone.
     *
     * @return startTime
     */
    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public EnergyTimeOfUse endTime(String endTime) {
        this.endTime = endTime;
        return this;
    }

    /**
     * End of the period.\n\nFormatted according to [ISO 8601 Times](https://en.wikipedia.org/wiki/ISO_8601#Times). If the time is provided without a UTC offset, the time zone will be determined by the value of EnergyPlanContract.timeZone.
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
        EnergyTimeOfUse energyTimeOfUse = (EnergyTimeOfUse) o;
        return Objects.equals(this.days, energyTimeOfUse.days) &&
                Objects.equals(this.startTime, energyTimeOfUse.startTime) &&
                Objects.equals(this.endTime, energyTimeOfUse.endTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(days, startTime, endTime);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyTimeOfUse {\n");
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
