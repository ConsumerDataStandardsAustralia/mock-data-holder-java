package au.org.consumerdatastandards.client.model.energy;

import java.time.LocalDate;
import java.util.Objects;

/**
 * EnergyAccountPlanOverview
 */
public class EnergyAccountPlanOverview {
    private String displayName;

    private LocalDate startDate;   // "x-cds-type" : "DateString"

    private LocalDate endDate;   // "x-cds-type" : "DateString"

    public EnergyAccountPlanOverview displayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    /**
     * The name of the plan if one exists
     *
     * @return displayName
     */
    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public EnergyAccountPlanOverview startDate(LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    /**
     * The start date of the applicability of this plan
     *
     * @return startDate
     */
    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public EnergyAccountPlanOverview endDate(LocalDate endDate) {
        this.endDate = endDate;
        return this;
    }

    /**
     * The end date of the applicability of this plan
     *
     * @return endDate
     */
    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EnergyAccountPlanOverview energyAccountPlanOverview = (EnergyAccountPlanOverview) o;
        return Objects.equals(this.displayName, energyAccountPlanOverview.displayName) &&
                Objects.equals(this.startDate, energyAccountPlanOverview.startDate) &&
                Objects.equals(this.endDate, energyAccountPlanOverview.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(displayName, startDate, endDate);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyAccountPlanOverview {\n");
        sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
        sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
        sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
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
