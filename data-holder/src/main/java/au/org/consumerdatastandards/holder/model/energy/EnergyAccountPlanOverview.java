package au.org.consumerdatastandards.holder.model.energy;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * EnergyAccountAllOfPlanOverview
 */
public class EnergyAccountPlanOverview {
    private String displayName;

    private String startDate;

    private String endDate;

    public EnergyAccountPlanOverview displayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    /**
     * The name of the plan if one exists
     *
     * @return displayName
     */
    @ApiModelProperty(value = "The name of the plan if one exists")
    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public EnergyAccountPlanOverview startDate(String startDate) {
        this.startDate = startDate;
        return this;
    }

    /**
     * The start date of the applicability of this plan
     *
     * @return startDate
     */
    @ApiModelProperty(required = true, value = "The start date of the applicability of this plan")
    @NotNull
    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public EnergyAccountPlanOverview endDate(String endDate) {
        this.endDate = endDate;
        return this;
    }

    /**
     * The end date of the applicability of this plan
     *
     * @return endDate
     */
    @ApiModelProperty(value = "The end date of the applicability of this plan")
    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
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
        sb.append("class EnergyAccountAllOfPlanOverview {\n");
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
