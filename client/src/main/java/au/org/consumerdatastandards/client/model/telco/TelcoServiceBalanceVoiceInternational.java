package au.org.consumerdatastandards.client.model.telco;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * International voice calls
 */
public class TelcoServiceBalanceVoiceInternational {
    private String description;

    private String duration;

    private BigDecimal number;

    private String amount;

    public TelcoServiceBalanceVoiceInternational description(String description) {
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

    public TelcoServiceBalanceVoiceInternational duration(String duration) {
        this.duration = duration;
        return this;
    }

    /**
     * Total duration (hours, minutes, and seconds) of international voice calls available. Not limited to 24hrs. Required unless planType is UNSUPPORTED or UNMETERED
     *
     * @return duration
     */
    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public TelcoServiceBalanceVoiceInternational number(BigDecimal number) {
        this.number = number;
        return this;
    }

    /**
     * Number of international voice calls available Required unless planType is UNSUPPORTED or UNMETERED
     *
     * @return number
     */
    public BigDecimal getNumber() {
        return number;
    }

    public void setNumber(BigDecimal number) {
        this.number = number;
    }

    public TelcoServiceBalanceVoiceInternational amount(String amount) {
        this.amount = amount;
        return this;
    }

    /**
     * Amount value of international calls available. Required unless planType is UNSUPPORTED or UNMETERED
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
        TelcoServiceBalanceVoiceInternational telcoServiceBalanceVoiceInternational = (TelcoServiceBalanceVoiceInternational) o;
        return Objects.equals(this.description, telcoServiceBalanceVoiceInternational.description) &&
                Objects.equals(this.duration, telcoServiceBalanceVoiceInternational.duration) &&
                Objects.equals(this.number, telcoServiceBalanceVoiceInternational.number) &&
                Objects.equals(this.amount, telcoServiceBalanceVoiceInternational.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, duration, number, amount);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TelcoServiceBalanceVoiceInternational {\n");
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
