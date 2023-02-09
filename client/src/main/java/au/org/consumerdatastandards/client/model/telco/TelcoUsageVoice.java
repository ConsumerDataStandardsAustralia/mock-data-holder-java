package au.org.consumerdatastandards.client.model.telco;

import java.util.Objects;

/**
 * Summary of voice calls. Required if voice calls are included in product plan
 */
public class TelcoUsageVoice {
    private TelcoUsageVoiceNational national;

    private TelcoUsageVoiceInternational international;

    private TelcoUsageVoiceRoaming roaming;

    public TelcoUsageVoice national(TelcoUsageVoiceNational national) {
        this.national = national;
        return this;
    }

    /**
     * Get national
     *
     * @return national
     */
    public TelcoUsageVoiceNational getNational() {
        return national;
    }

    public void setNational(TelcoUsageVoiceNational national) {
        this.national = national;
    }

    public TelcoUsageVoice international(TelcoUsageVoiceInternational international) {
        this.international = international;
        return this;
    }

    /**
     * Get international
     *
     * @return international
     */
    public TelcoUsageVoiceInternational getInternational() {
        return international;
    }

    public void setInternational(TelcoUsageVoiceInternational international) {
        this.international = international;
    }

    public TelcoUsageVoice roaming(TelcoUsageVoiceRoaming roaming) {
        this.roaming = roaming;
        return this;
    }

    /**
     * Get roaming
     *
     * @return roaming
     */
    public TelcoUsageVoiceRoaming getRoaming() {
        return roaming;
    }

    public void setRoaming(TelcoUsageVoiceRoaming roaming) {
        this.roaming = roaming;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TelcoUsageVoice telcoUsageVoice = (TelcoUsageVoice) o;
        return Objects.equals(this.national, telcoUsageVoice.national) &&
                Objects.equals(this.international, telcoUsageVoice.international) &&
                Objects.equals(this.roaming, telcoUsageVoice.roaming);
    }

    @Override
    public int hashCode() {
        return Objects.hash(national, international, roaming);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TelcoUsageVoice {\n");
        sb.append("    national: ").append(toIndentedString(national)).append("\n");
        sb.append("    international: ").append(toIndentedString(international)).append("\n");
        sb.append("    roaming: ").append(toIndentedString(roaming)).append("\n");
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
