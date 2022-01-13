package au.org.consumerdatastandards.holder.model.energy;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * EnergyPlanControlledLoadRates
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen",
        date = "2022-01-11T14:03:27.755+11:00[Australia/Sydney]")
public class EnergyPlanControlledLoadRates {
    @JsonProperty("unitPrice")
    private String unitPrice;

    @JsonProperty("volume")
    private BigDecimal volume;

    public EnergyPlanControlledLoadRates unitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
        return this;
    }

    /**
     * Unit price of usage per kWh (exclusive of GST)
     *
     * @return unitPrice
     */
    @ApiModelProperty(required = true,
            value = "Unit price of usage per kWh (exclusive of GST)")
    @NotNull


    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    public EnergyPlanControlledLoadRates volume(BigDecimal volume) {
        this.volume = volume;
        return this;
    }

    /**
     * Volume in kWh that this rate applies to.  Only applicable for ‘stepped’ rates where different rates apply for different volumes of usage in a period
     *
     * @return volume
     */
    @ApiModelProperty(value = "Volume in kWh that this rate applies to.  Only applicable for ‘stepped’ rates where different rates apply for different volumes of usage in a period")

    @Valid

    public BigDecimal getVolume() {
        return volume;
    }

    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EnergyPlanControlledLoadRates energyPlanControlledLoadRates = (EnergyPlanControlledLoadRates) o;
        return Objects.equals(this.unitPrice, energyPlanControlledLoadRates.unitPrice) &&
                Objects.equals(this.volume, energyPlanControlledLoadRates.volume);
    }

    @Override
    public int hashCode() {
        return Objects.hash(unitPrice, volume);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyPlanControlledLoadRates {\n");

        sb.append("    unitPrice: ").append(toIndentedString(unitPrice)).append("\n");
        sb.append("    volume: ").append(toIndentedString(volume)).append("\n");
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

