package au.org.consumerdatastandards.holder.model.energy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * EnergyPlanContractRates
 */
@Entity
public class EnergyPlanContractRates {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @JsonIgnore
    private String id;

    private String unitPrice;

    /**
     * The measurement unit of rate. Assumed to be KWH if absent
     */
    public enum MeasureUnitEnum {
        KWH,
        KVA,
        KVAR,
        KVARH,
        KW,
        DAYS,
        METER,
        MONTH
    }

    private MeasureUnitEnum measureUnit;

    private BigDecimal volume;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public EnergyPlanContractRates unitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
        return this;
    }

    /**
     * Unit price of usage per  measure unit (exclusive of GST)
     *
     * @return unitPrice
     */
    @ApiModelProperty(required = true, value = "Unit price of usage per  measure unit (exclusive of GST)")
    @NotNull
    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    public EnergyPlanContractRates measureUnit(MeasureUnitEnum measureUnit) {
        this.measureUnit = measureUnit;
        return this;
    }

    /**
     * The measurement unit of rate. Assumed to be KWH if absent
     *
     * @return measureUnit
     */
    @ApiModelProperty(value = "The measurement unit of rate. Assumed to be KWH if absent")
    public MeasureUnitEnum getMeasureUnit() {
        return measureUnit;
    }

    public void setMeasureUnit(MeasureUnitEnum measureUnit) {
        this.measureUnit = measureUnit;
    }

    public EnergyPlanContractRates volume(BigDecimal volume) {
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
        EnergyPlanContractRates energyPlanContractRates = (EnergyPlanContractRates) o;
        return Objects.equals(this.unitPrice, energyPlanContractRates.unitPrice) &&
                Objects.equals(this.measureUnit, energyPlanContractRates.measureUnit) &&
                Objects.equals(this.volume, energyPlanContractRates.volume);
    }

    @Override
    public int hashCode() {
        return Objects.hash(unitPrice, measureUnit, volume);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyPlanContractRates {\n");
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
