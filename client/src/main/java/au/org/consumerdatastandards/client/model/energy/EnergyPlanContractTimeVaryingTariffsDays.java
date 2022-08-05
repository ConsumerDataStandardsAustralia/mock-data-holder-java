package au.org.consumerdatastandards.client.model.energy;

import java.util.Objects;

/**
 * EnergyPlanContractTimeVaryingTariffsDays
 */
public class EnergyPlanContractTimeVaryingTariffsDays {
    private Boolean weekdays;

    private Boolean weekend;

    public EnergyPlanContractTimeVaryingTariffsDays weekdays(Boolean weekdays) {
        this.weekdays = weekdays;
        return this;
    }

    /**
     * Indicates whether the tariff is applicable Monday to Friday
     *
     * @return weekdays
     */
    public Boolean getWeekdays() {
        return weekdays;
    }

    public void setWeekdays(Boolean weekdays) {
        this.weekdays = weekdays;
    }

    public EnergyPlanContractTimeVaryingTariffsDays weekend(Boolean weekend) {
        this.weekend = weekend;
        return this;
    }

    /**
     * Indicates whether the tariff is applicable Saturday and Sunday
     *
     * @return weekend
     */
    public Boolean getWeekend() {
        return weekend;
    }

    public void setWeekend(Boolean weekend) {
        this.weekend = weekend;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EnergyPlanContractTimeVaryingTariffsDays energyPlanContractTimeVaryingTariffsDays = (EnergyPlanContractTimeVaryingTariffsDays) o;
        return Objects.equals(this.weekdays, energyPlanContractTimeVaryingTariffsDays.weekdays) &&
                Objects.equals(this.weekend, energyPlanContractTimeVaryingTariffsDays.weekend);
    }

    @Override
    public int hashCode() {
        return Objects.hash(weekdays, weekend);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyPlanContractTimeVaryingTariffsDays {\n");
        sb.append("    weekdays: ").append(toIndentedString(weekdays)).append("\n");
        sb.append("    weekend: ").append(toIndentedString(weekend)).append("\n");
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
