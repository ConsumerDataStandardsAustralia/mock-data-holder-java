package au.org.consumerdatastandards.client.model.telco;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * International voice calls. Requied if international calling is supported
 */
public class TelcoUsageVoiceInternational {
    private String duration;

    private BigDecimal number;

    private String amount;

    public TelcoUsageVoiceInternational duration(String duration) {
        this.duration = duration;
        return this;
    }

    /**
     * Total duration (hours, minutes, and seconds) of international voice calls. Not limited to 24hrs
     *
     * @return duration
     */
    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public TelcoUsageVoiceInternational number(BigDecimal number) {
        this.number = number;
        return this;
    }

    /**
     * Number of international voice calls
     *
     * @return number
     */
    public BigDecimal getNumber() {
        return number;
    }

    public void setNumber(BigDecimal number) {
        this.number = number;
    }

    public TelcoUsageVoiceInternational amount(String amount) {
        this.amount = amount;
        return this;
    }

    /**
     * Cost amount of international voice calls
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
        TelcoUsageVoiceInternational telcoUsageVoiceInternational = (TelcoUsageVoiceInternational) o;
        return Objects.equals(this.duration, telcoUsageVoiceInternational.duration) &&
                Objects.equals(this.number, telcoUsageVoiceInternational.number) &&
                Objects.equals(this.amount, telcoUsageVoiceInternational.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(duration, number, amount);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TelcoUsageVoiceInternational {\n");
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
