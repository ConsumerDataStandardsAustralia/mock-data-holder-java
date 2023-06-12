package au.org.consumerdatastandards.client.model.energy;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * EnergyPlanContractSingleRateRates
 */
public class EnergyPlanContractSingleRateRates {
    private String unitPrice;

    private RateMeasureUnitEnum measureUnit;

    private BigDecimal volume;

    public EnergyPlanContractSingleRateRates unitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
        return this;
    }

    /**
     * Unit price of usage per measure unit (exclusive of GST)
     *
     * @return unitPrice
     */
    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    public EnergyPlanContractSingleRateRates measureUnit(RateMeasureUnitEnum measureUnit) {
        this.measureUnit = measureUnit;
        return this;
    }

    /**
     * The measurement unit of rate. Assumed to be KWH if absent
     *
     * @return measureUnit
     */
    public RateMeasureUnitEnum getMeasureUnit() {
        return measureUnit;
    }

    public void setMeasureUnit(RateMeasureUnitEnum measureUnit) {
        this.measureUnit = measureUnit;
    }

    public EnergyPlanContractSingleRateRates volume(BigDecimal volume) {
        this.volume = volume;
        return this;
    }

    /**
     * Volume in kWh that this rate applies to.  Only applicable for ‘stepped’ rates where different rates apply for different volumes of usage in a period
     *
     * @return volume
     */
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
        EnergyPlanContractSingleRateRates energyPlanContractSingleRateRates = (EnergyPlanContractSingleRateRates) o;
        return Objects.equals(this.unitPrice, energyPlanContractSingleRateRates.unitPrice) &&
                Objects.equals(this.measureUnit, energyPlanContractSingleRateRates.measureUnit) &&
                Objects.equals(this.volume, energyPlanContractSingleRateRates.volume);
    }

    @Override
    public int hashCode() {
        return Objects.hash(unitPrice, measureUnit, volume);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyPlanContractSingleRateRates {\n");
        sb.append("    unitPrice: ").append(toIndentedString(unitPrice)).append("\n");
        sb.append("    measureUnit: ").append(toIndentedString(measureUnit)).append("\n");
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
