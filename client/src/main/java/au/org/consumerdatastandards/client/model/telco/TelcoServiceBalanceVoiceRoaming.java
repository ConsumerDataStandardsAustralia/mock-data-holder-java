package au.org.consumerdatastandards.client.model.telco;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Roaming voice calls
 */
public class TelcoServiceBalanceVoiceRoaming {
    private String description;

    private String duration;

    private BigDecimal number;

    private String amount;

    public TelcoServiceBalanceVoiceRoaming description(String description) {
        this.description = description;
        return this;
    }

    /**
     * An overview of plan limits. Required unless planType is UNSUPPORTED
     *
     * @return description
     */
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TelcoServiceBalanceVoiceRoaming duration(String duration) {
        this.duration = duration;
        return this;
    }

    /**
     * Total duration (hours, minutes, and seconds) of roaming voice calls available. Not limited to 24hrs. Required unless planType is UNSUPPORTED or UNMETERED
     *
     * @return duration
     */
    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public TelcoServiceBalanceVoiceRoaming number(BigDecimal number) {
        this.number = number;
        return this;
    }

    /**
     * Number of roaming voice calls available Required unless planType is UNSUPPORTED or UNMETERED
     *
     * @return number
     */
    public BigDecimal getNumber() {
        return number;
    }

    public void setNumber(BigDecimal number) {
        this.number = number;
    }

    public TelcoServiceBalanceVoiceRoaming amount(String amount) {
        this.amount = amount;
        return this;
    }

    /**
     * Amount value of roaming calls available. Required unless planType is UNSUPPORTED or UNMETERED
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
        TelcoServiceBalanceVoiceRoaming telcoServiceBalanceVoiceRoaming = (TelcoServiceBalanceVoiceRoaming) o;
        return Objects.equals(this.description, telcoServiceBalanceVoiceRoaming.description) &&
                Objects.equals(this.duration, telcoServiceBalanceVoiceRoaming.duration) &&
                Objects.equals(this.number, telcoServiceBalanceVoiceRoaming.number) &&
                Objects.equals(this.amount, telcoServiceBalanceVoiceRoaming.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, duration, number, amount);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TelcoServiceBalanceVoiceRoaming {\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
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
