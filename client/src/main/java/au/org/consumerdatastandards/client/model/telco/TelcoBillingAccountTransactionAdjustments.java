package au.org.consumerdatastandards.client.model.telco;

import java.util.Objects;

/**
 * TelcoBillingAccountTransactionAdjustments
 */
public class TelcoBillingAccountTransactionAdjustments {
    private String amount;

    private String description;

    public TelcoBillingAccountTransactionAdjustments amount(String amount) {
        this.amount = amount;
        return this;
    }

    /**
     * The amount of the adjustment
     *
     * @return amount
     */
    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public TelcoBillingAccountTransactionAdjustments description(String description) {
        this.description = description;
        return this;
    }

    /**
     * A free text description of the adjustment
     *
     * @return description
     */
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TelcoBillingAccountTransactionAdjustments telcoBillingAccountTransactionAdjustments = (TelcoBillingAccountTransactionAdjustments) o;
        return Objects.equals(this.amount, telcoBillingAccountTransactionAdjustments.amount) &&
                Objects.equals(this.description, telcoBillingAccountTransactionAdjustments.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, description);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TelcoBillingAccountTransactionAdjustments {\n");
        sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
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
