package au.org.consumerdatastandards.holder.model.energy;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Required if pricing model is SINGLE_RATE_CONT_LOAD or TIME_OF_USE_CONT_LOAD or FLEXIBLE_CONT_LOAD
 */
@ApiModel(description = "Required if pricing model is SINGLE_RATE_CONT_LOAD or TIME_OF_USE_CONT_LOAD or FLEXIBLE_CONT_LOAD")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen",
        date = "2022-01-11T14:03:27.755+11:00[Australia/Sydney]")
public class EnergyPlanControlledLoad {
    @JsonProperty("displayName")
    private String displayName;

    @JsonProperty("description")
    private String description;

    @JsonProperty("dailyCharge")
    private String dailyCharge;

    @JsonProperty("period")
    private String period;

    @JsonProperty("rates")
    @Valid
    private List<EnergyPlanControlledLoadRates> rates = new ArrayList<>();

    public EnergyPlanControlledLoad displayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    /**
     * A display name for the controlled load tier
     *
     * @return displayName
     */
    @ApiModelProperty(required = true,
            value = "A display name for the controlled load tier")
    @NotNull


    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public EnergyPlanControlledLoad description(String description) {
        this.description = description;
        return this;
    }

    /**
     * A description of the controlled load tier
     *
     * @return description
     */
    @ApiModelProperty(value = "A description of the controlled load tier")


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EnergyPlanControlledLoad dailyCharge(String dailyCharge) {
        this.dailyCharge = dailyCharge;
        return this;
    }

    /**
     * The daily supply charge (exclusive of GST) for this controlled load tier
     *
     * @return dailyCharge
     */
    @ApiModelProperty(required = true,
            value = "The daily supply charge (exclusive of GST) for this controlled load tier")
    @NotNull


    public String getDailyCharge() {
        return dailyCharge;
    }

    public void setDailyCharge(String dailyCharge) {
        this.dailyCharge = dailyCharge;
    }

    public EnergyPlanControlledLoad period(String period) {
        this.period = period;
        return this;
    }

    /**
     * The period for which the controlled load rate applies. Formatted according to [ISO 8601 Durations](https://en.wikipedia.org/wiki/ISO_8601#Durations) (excludes recurrence syntax)
     *
     * @return period
     */
    @ApiModelProperty(required = true,
            value = "The period for which the controlled load rate applies. Formatted according to [ISO 8601 Durations](https://en.wikipedia.org/wiki/ISO_8601#Durations) (excludes recurrence syntax)")
    @NotNull


    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public EnergyPlanControlledLoad rates(List<EnergyPlanControlledLoadRates> rates) {
        this.rates = rates;
        return this;
    }

    public EnergyPlanControlledLoad addRatesItem(EnergyPlanControlledLoadRates ratesItem) {
        this.rates.add(ratesItem);
        return this;
    }

    /**
     * Array of controlled load rates in order of usage volume
     *
     * @return rates
     */
    @ApiModelProperty(required = true,
            value = "Array of controlled load rates in order of usage volume")
    @NotNull

    @Valid

    public List<EnergyPlanControlledLoadRates> getRates() {
        return rates;
    }

    public void setRates(List<EnergyPlanControlledLoadRates> rates) {
        this.rates = rates;
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
                Objects.equals(this.description, energyPlanControlledLoad.description) &&
                Objects.equals(this.dailyCharge, energyPlanControlledLoad.dailyCharge) &&
                Objects.equals(this.period, energyPlanControlledLoad.period) &&
                Objects.equals(this.rates, energyPlanControlledLoad.rates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(displayName, description, dailyCharge, period, rates);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyPlanControlledLoad {\n");

        sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    dailyCharge: ").append(toIndentedString(dailyCharge)).append("\n");
        sb.append("    period: ").append(toIndentedString(period)).append("\n");
        sb.append("    rates: ").append(toIndentedString(rates)).append("\n");
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

