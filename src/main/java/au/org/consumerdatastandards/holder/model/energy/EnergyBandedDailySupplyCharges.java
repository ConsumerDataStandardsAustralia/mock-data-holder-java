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

@Entity
public class EnergyBandedDailySupplyCharges {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @JsonIgnore
    private String id;

    private String unitPrice;

    private RateMeasureUnitEnum measureUnit;

    private BigDecimal volume;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * The amount of daily supply charge for the band, in dollars per day exclusive of GST.
     *
     * @return unitPrice
     */
    @ApiModelProperty(required = true, value = "The amount of daily supply charge for the band, in dollars per day exclusive of GST.")
    @NotNull
    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * The measurement unit of rate. Assumed to be `DAYS` if absent.
     *
     * @return measureUnit
     */
    @ApiModelProperty(value = "The measurement unit of rate. Assumed to be `DAYS` if absent.")
    public RateMeasureUnitEnum getMeasureUnit() {
        return measureUnit;
    }

    public void setMeasureUnit(RateMeasureUnitEnum measureUnit) {
        this.measureUnit = measureUnit;
    }

    /**
     * Volume the charge applies to.
     *
     * @return volume
     */
    @ApiModelProperty(value = "Volume the charge applies to.")
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
        EnergyBandedDailySupplyCharges energyBandedDailySupplyCharges = (EnergyBandedDailySupplyCharges) o;
        return Objects.equals(this.unitPrice, energyBandedDailySupplyCharges.unitPrice) &&
                Objects.equals(this.measureUnit, energyBandedDailySupplyCharges.measureUnit) &&
                Objects.equals(this.volume, energyBandedDailySupplyCharges.volume);
    }

    @Override
    public int hashCode() {
        return Objects.hash(unitPrice, measureUnit, volume);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyBandedDailySupplyCharges {\n");
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
