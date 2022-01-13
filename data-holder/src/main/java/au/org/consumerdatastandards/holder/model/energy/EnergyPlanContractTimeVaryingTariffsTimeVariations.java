package au.org.consumerdatastandards.holder.model.energy;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import java.util.Objects;

/**
 * EnergyPlanContractTimeVaryingTariffsTimeVariations
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen",
        date = "2022-01-11T14:03:27.755+11:00[Australia/Sydney]")
public class EnergyPlanContractTimeVaryingTariffsTimeVariations {
    @JsonProperty("days")
    private EnergyPlanContractTimeVaryingTariffsDays days;

    @JsonProperty("startTime")
    private String startTime;

    @JsonProperty("endTime")
    private String endTime;

    public EnergyPlanContractTimeVaryingTariffsTimeVariations days(EnergyPlanContractTimeVaryingTariffsDays days) {
        this.days = days;
        return this;
    }

    /**
     * Get days
     *
     * @return days
     */
    @ApiModelProperty(value = "")

    @Valid

    public EnergyPlanContractTimeVaryingTariffsDays getDays() {
        return days;
    }

    public void setDays(EnergyPlanContractTimeVaryingTariffsDays days) {
        this.days = days;
    }

    public EnergyPlanContractTimeVaryingTariffsTimeVariations startTime(String startTime) {
        this.startTime = startTime;
        return this;
    }

    /**
     * The beginning of the time period per day for which the tariff applies.  If absent assumes start of day (ie. midnight)
     *
     * @return startTime
     */
    @ApiModelProperty(value = "The beginning of the time period per day for which the tariff applies.  If absent assumes start of day (ie. midnight)")


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
     * The end of the time period per day for which the tariff applies.  If absent assumes end of day (ie. one second before midnight)
     *
     * @return endTime
     */
    @ApiModelProperty(value = "The end of the time period per day for which the tariff applies.  If absent assumes end of day (ie. one second before midnight)")


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

