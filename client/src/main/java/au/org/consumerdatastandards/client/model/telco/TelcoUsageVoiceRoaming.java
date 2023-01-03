package au.org.consumerdatastandards.client.model.telco;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Roaming voice calls, Required if roaming is supported
 */
public class TelcoUsageVoiceRoaming {
    private String duration;

    private BigDecimal number;

    private String amount;

    public TelcoUsageVoiceRoaming duration(String duration) {
        this.duration = duration;
        return this;
    }

    /**
     * Total duration (hours, minutes, and seconds) of roaming voice calls. Not limited to 24hrs
     *
     * @return duration
     */
    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public TelcoUsageVoiceRoaming number(BigDecimal number) {
        this.number = number;
        return this;
    }

    /**
     * Number of roaming voice calls
     *
     * @return number
     */
    public BigDecimal getNumber() {
        return number;
    }

    public void setNumber(BigDecimal number) {
        this.number = number;
    }

    public TelcoUsageVoiceRoaming amount(String amount) {
        this.amount = amount;
        return this;
    }

    /**
     * Cost amount of roaming voice calls
     *
     * @return amount
     */
    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TelcoUsageVoiceRoaming telcoUsageVoiceRoaming = (TelcoUsageVoiceRoaming) o;
        return Objects.equals(this.duration, telcoUsageVoiceRoaming.duration) &&
                Objects.equals(this.number, telcoUsageVoiceRoaming.number) &&
                Objects.equals(this.amount, telcoUsageVoiceRoaming.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(duration, number, amount);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TelcoUsageVoiceRoaming {\n");
        sb.append("    duration: ").append(toIndentedString(duration)).append("\n");
        sb.append("    number: ").append(toIndentedString(number)).append("\n");
        sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
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
