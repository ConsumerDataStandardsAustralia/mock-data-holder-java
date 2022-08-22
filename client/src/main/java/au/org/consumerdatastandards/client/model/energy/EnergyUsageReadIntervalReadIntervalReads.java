package au.org.consumerdatastandards.client.model.energy;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * EnergyUsageReadIntervalReadIntervalReads
 */
public class EnergyUsageReadIntervalReadIntervalReads {
    /**
     * The quality of the read taken.  If absent then assumed to be ACTUAL
     */
    public enum QualityEnum {
        ACTUAL,
        SUBSTITUTE,
        FINAL_SUBSTITUTE
    }

    private QualityEnum quality = QualityEnum.ACTUAL;

    private BigDecimal value;

    public EnergyUsageReadIntervalReadIntervalReads quality(QualityEnum quality) {
        this.quality = quality;
        return this;
    }

    /**
     * The quality of the read taken.  If absent then assumed to be ACTUAL
     *
     * @return quality
     */


    public QualityEnum getQuality() {
        return quality;
    }

    public void setQuality(QualityEnum quality) {
        this.quality = quality;
    }

    public EnergyUsageReadIntervalReadIntervalReads value(BigDecimal value) {
        this.value = value;
        return this;
    }

    /**
     * Interval value.  If positive then it means consumption, if negative it means export
     *
     * @return value
     */
    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EnergyUsageReadIntervalReadIntervalReads energyUsageReadIntervalReadIntervalReads = (EnergyUsageReadIntervalReadIntervalReads) o;
        return Objects.equals(this.quality, energyUsageReadIntervalReadIntervalReads.quality) &&
                Objects.equals(this.value, energyUsageReadIntervalReadIntervalReads.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(quality, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyUsageReadIntervalReadIntervalReads {\n");
        sb.append("    quality: ").append(toIndentedString(quality)).append("\n");
        sb.append("    value: ").append(toIndentedString(value)).append("\n");
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
