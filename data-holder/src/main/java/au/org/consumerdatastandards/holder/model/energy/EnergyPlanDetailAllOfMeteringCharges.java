package au.org.consumerdatastandards.holder.model.energy;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * EnergyPlanDetailAllOfMeteringCharges
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen",
        date = "2022-01-11T14:03:27.755+11:00[Australia/Sydney]")
public class EnergyPlanDetailAllOfMeteringCharges {
    @JsonProperty("displayName")
    private String displayName;

    @JsonProperty("description")
    private String description;

    @JsonProperty("minimumValue")
    private String minimumValue;

    @JsonProperty("maximumValue")
    private String maximumValue;

    @JsonProperty("period")
    private String period;

    public EnergyPlanDetailAllOfMeteringCharges displayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    /**
     * Display name of the charge
     *
     * @return displayName
     */
    @ApiModelProperty(required = true,
            value = "Display name of the charge")
    @NotNull


    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public EnergyPlanDetailAllOfMeteringCharges description(String description) {
        this.description = description;
        return this;
    }

    /**
     * Description of the charge
     *
     * @return description
     */
    @ApiModelProperty(value = "Description of the charge")


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EnergyPlanDetailAllOfMeteringCharges minimumValue(String minimumValue) {
        this.minimumValue = minimumValue;
        return this;
    }

    /**
     * Minimum value of the charge if the charge is a range or the absolute value of the charge if no range is specified
     *
     * @return minimumValue
     */
    @ApiModelProperty(required = true,
            value = "Minimum value of the charge if the charge is a range or the absolute value of the charge if no range is specified")
    @NotNull


    public String getMinimumValue() {
        return minimumValue;
    }

    public void setMinimumValue(String minimumValue) {
        this.minimumValue = minimumValue;
    }

    public EnergyPlanDetailAllOfMeteringCharges maximumValue(String maximumValue) {
        this.maximumValue = maximumValue;
        return this;
    }

    /**
     * The upper limit of the charge if the charge could occur in a range
     *
     * @return maximumValue
     */
    @ApiModelProperty(value = "The upper limit of the charge if the charge could occur in a range")


    public String getMaximumValue() {
        return maximumValue;
    }

    public void setMaximumValue(String maximumValue) {
        this.maximumValue = maximumValue;
    }

    public EnergyPlanDetailAllOfMeteringCharges period(String period) {
        this.period = period;
        return this;
    }

    /**
     * The charges that occur on a schedule indicates the frequency. Formatted according to [ISO 8601 Durations](https://en.wikipedia.org/wiki/ISO_8601#Durations) (excludes recurrence syntax)
     *
     * @return period
     */
    @ApiModelProperty(value = "The charges that occur on a schedule indicates the frequency. Formatted according to [ISO 8601 Durations](https://en.wikipedia.org/wiki/ISO_8601#Durations) (excludes recurrence syntax)")


    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EnergyPlanDetailAllOfMeteringCharges energyPlanDetailAllOfMeteringCharges = (EnergyPlanDetailAllOfMeteringCharges) o;
        return Objects.equals(this.displayName, energyPlanDetailAllOfMeteringCharges.displayName) &&
                Objects.equals(this.description, energyPlanDetailAllOfMeteringCharges.description) &&
                Objects.equals(this.minimumValue, energyPlanDetailAllOfMeteringCharges.minimumValue) &&
                Objects.equals(this.maximumValue, energyPlanDetailAllOfMeteringCharges.maximumValue) &&
                Objects.equals(this.period, energyPlanDetailAllOfMeteringCharges.period);
    }

    @Override
    public int hashCode() {
        return Objects.hash(displayName, description, minimumValue, maximumValue, period);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyPlanDetailAllOfMeteringCharges {\n");

        sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    minimumValue: ").append(toIndentedString(minimumValue)).append("\n");
        sb.append("    maximumValue: ").append(toIndentedString(maximumValue)).append("\n");
        sb.append("    period: ").append(toIndentedString(period)).append("\n");
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

