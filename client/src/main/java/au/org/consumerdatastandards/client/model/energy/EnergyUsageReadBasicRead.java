package au.org.consumerdatastandards.client.model.energy;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Mandatory if readUType is set to basicRead
 */
public class EnergyUsageReadBasicRead {
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

    public EnergyUsageReadBasicRead quality(QualityEnum quality) {
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

    public EnergyUsageReadBasicRead value(BigDecimal value) {
        this.value = value;
        return this;
    }

    /**
     * Meter read value.  If positive then it means consumption, if negative it means export
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
        EnergyUsageReadBasicRead energyUsageReadBasicRead = (EnergyUsageReadBasicRead) o;
        return Objects.equals(this.quality, energyUsageReadBasicRead.quality) &&
                Objects.equals(this.value, energyUsageReadBasicRead.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(quality, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyUsageReadBasicRead {\n");
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
