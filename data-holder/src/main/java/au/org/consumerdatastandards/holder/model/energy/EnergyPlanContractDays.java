package au.org.consumerdatastandards.holder.model.energy;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * Object containing demand tariff by day of week
 */
@ApiModel(description = "Object containing demand tariff by day of week")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen",
        date = "2022-01-11T14:03:27.755+11:00[Australia/Sydney]")
public class EnergyPlanContractDays {
    @JsonProperty("weekdays")
    private Boolean weekdays;

    @JsonProperty("saturday")
    private Boolean saturday;

    @JsonProperty("sunday")
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
    @ApiModelProperty(required = true,
            value = "Indicates the demand tariff is applicable on weekdays")
    @NotNull


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
    @ApiModelProperty(required = true,
            value = "Indicates the demand tariff is applicable on Saturdays")
    @NotNull


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
    @ApiModelProperty(required = true,
            value = "Indicates the demand tariff is applicable on Sundays")
    @NotNull


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

