package au.org.consumerdatastandards.client.model.energy;

import java.util.Objects;

/**
 * Specifies quality of reads that are not ACTUAL.
 * For read indices that are not specified, quality is assumed to be ACTUAL.
 * If not present, all quality of all reads are assumed to be actual.
 * Required when interval-reads query parameter equals FULL or MIN_30
 */
public class EnergyUsageReadIntervalReadReadQualities {

    private Integer startInterval;

    private Integer endInterval;

    public enum QualityEnum {
        SUBSTITUTE,
        FINAL_SUBSTITUTE
    }

    private QualityEnum quality;

    /**
     * Start interval for read quality flag. First read begins at 1
     *
     * @return startInterval
     */
    public Integer getStartInterval() {
        return startInterval;
    }

    public void setStartInterval(Integer startInterval) {
        this.startInterval = startInterval;
    }

    /**
     * End interval for read quality flag
     *
     * @return endInterval
     */
    public Integer getEndInterval() {
        return endInterval;
    }

    public void setEndInterval(Integer endInterval) {
        this.endInterval = endInterval;
    }

    /**
     * The quality of the read taken
     *
     * @return quality
     */
    public QualityEnum getQuality() {
        return quality;
    }

    public void setQuality(QualityEnum quality) {
        this.quality = quality;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EnergyUsageReadIntervalReadReadQualities energyUsageReadIntervalReadReadQualities = (EnergyUsageReadIntervalReadReadQualities) o;
        return Objects.equals(this.startInterval, energyUsageReadIntervalReadReadQualities.startInterval) &&
                Objects.equals(this.endInterval, energyUsageReadIntervalReadReadQualities.endInterval) &&
                Objects.equals(this.quality, energyUsageReadIntervalReadReadQualities.quality);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startInterval, endInterval, quality);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyUsageReadIntervalReadReadQualities {\n");
        sb.append("    startInterval: ").append(toIndentedString(startInterval)).append("\n");
        sb.append("    endInterval: ").append(toIndentedString(startInterval)).append("\n");
        sb.append("    quality: ").append(toIndentedString(quality)).append("\n");
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
