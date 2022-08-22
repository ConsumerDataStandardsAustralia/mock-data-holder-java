package au.org.consumerdatastandards.client.model.energy;

import java.util.Objects;

/**
 * Object containing demand tariff by day of week
 */
public class EnergyPlanContractDays {
    private Boolean weekdays;

    private Boolean saturday;

    private Boolean sunday;

    public EnergyPlanContractDays weekdays(Boolean weekdays) {
        this.weekdays = weekdays;
        return this;
    }

    /**
     * Indicates the demand tariff is applicable on weekdays
     *
     * @return weekdays
     */
    public Boolean getWeekdays() {
        return weekdays;
    }

    public void setWeekdays(Boolean weekdays) {
        this.weekdays = weekdays;
    }

    public EnergyPlanContractDays saturday(Boolean saturday) {
        this.saturday = saturday;
        return this;
    }

    /**
     * Indicates the demand tariff is applicable on Saturdays
     *
     * @return saturday
     */
    public Boolean getSaturday() {
        return saturday;
    }

    public void setSaturday(Boolean saturday) {
        this.saturday = saturday;
    }

    public EnergyPlanContractDays sunday(Boolean sunday) {
        this.sunday = sunday;
        return this;
    }

    /**
     * Indicates the demand tariff is applicable on Sundays
     *
     * @return sunday
     */
    public Boolean getSunday() {
        return sunday;
    }

    public void setSunday(Boolean sunday) {
        this.sunday = sunday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EnergyPlanContractDays energyPlanContractDays = (EnergyPlanContractDays) o;
        return Objects.equals(this.weekdays, energyPlanContractDays.weekdays) &&
                Objects.equals(this.saturday, energyPlanContractDays.saturday) &&
                Objects.equals(this.sunday, energyPlanContractDays.sunday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(weekdays, saturday, sunday);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyPlanContractDays {\n");
        sb.append("    weekdays: ").append(toIndentedString(weekdays)).append("\n");
        sb.append("    saturday: ").append(toIndentedString(saturday)).append("\n");
        sb.append("    sunday: ").append(toIndentedString(sunday)).append("\n");
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
