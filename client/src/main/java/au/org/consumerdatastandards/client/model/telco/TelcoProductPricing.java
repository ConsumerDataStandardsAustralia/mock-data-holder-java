package au.org.consumerdatastandards.client.model.telco;

import java.util.Objects;

/**
 * TelcoProductPricing
 */
public class TelcoProductPricing {
    private String name;

    private String description;

    private String period;

    private String chargeAmount;

    public TelcoProductPricing name(String name) {
        this.name = name;
        return this;
    }

    /**
     * The display name of the pricing
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TelcoProductPricing description(String description) {
        this.description = description;
        return this;
    }

    /**
     * The description of the pricing
     *
     * @return description
     */
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TelcoProductPricing period(String period) {
        this.period = period;
        return this;
    }

    /**
     * The duration that occurs on a pricing schedule indicates the frequency. Formatted according to [ISO 8601 Durations](https://en.wikipedia.org/wiki/ISO_8601#Durations) (excludes recurrence syntax)
     *
     * @return period
     */
    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public TelcoProductPricing chargeAmount(String chargeAmount) {
        this.chargeAmount = chargeAmount;
        return this;
    }

    /**
     * The amount charged for the duration period
     *
     * @return chargeAmount
     */
    public String getChargeAmount() {
        return chargeAmount;
    }

    public void setChargeAmount(String chargeAmount) {
        this.chargeAmount = chargeAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TelcoProductPricing telcoProductPricing = (TelcoProductPricing) o;
        return Objects.equals(this.name, telcoProductPricing.name) &&
                Objects.equals(this.description, telcoProductPricing.description) &&
                Objects.equals(this.period, telcoProductPricing.period) &&
                Objects.equals(this.chargeAmount, telcoProductPricing.chargeAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, period, chargeAmount);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TelcoProductPricing {\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    period: ").append(toIndentedString(period)).append("\n");
        sb.append("    chargeAmount: ").append(toIndentedString(chargeAmount)).append("\n");
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
