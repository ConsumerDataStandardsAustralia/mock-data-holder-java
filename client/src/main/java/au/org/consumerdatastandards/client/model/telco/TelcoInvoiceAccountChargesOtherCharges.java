package au.org.consumerdatastandards.client.model.telco;

import java.util.Objects;

/**
 * Optional array of charges that may be part of the invoice (for example services fees) (exclusive of GST)
 */
public class TelcoInvoiceAccountChargesOtherCharges {
    private String amount;

    private String description;

    /**
     * A free text description of the charge
     */
    public enum TypeEnum {
        SERVICE,
        EQUIPMENT,
        NETWORK,
        HANDSET,
        DEVICE,
        ENTERTAINMENT,
        SUBSCRIPTION,
        SOFTWARE,
        OTHER
    }

    private TypeEnum type;

    public TelcoInvoiceAccountChargesOtherCharges amount(String amount) {
        this.amount = amount;
        return this;
    }

    /**
     * The aggregate total of charges for this item (exclusive of GST)
     *
     * @return amount
     */
    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public TelcoInvoiceAccountChargesOtherCharges description(String description) {
        this.description = description;
        return this;
    }

    /**
     * A free text description of the charge
     *
     * @return description
     */
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TelcoInvoiceAccountChargesOtherCharges type(TypeEnum type) {
        this.type = type;
        return this;
    }

    /**
     * A free text description of the charge
     *
     * @return type
     */
    public TypeEnum getType() {
        return type;
    }

    public void setType(TypeEnum type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TelcoInvoiceAccountChargesOtherCharges telcoInvoiceAccountChargesOtherCharges = (TelcoInvoiceAccountChargesOtherCharges) o;
        return Objects.equals(this.amount, telcoInvoiceAccountChargesOtherCharges.amount) &&
                Objects.equals(this.description, telcoInvoiceAccountChargesOtherCharges.description) &&
                Objects.equals(this.type, telcoInvoiceAccountChargesOtherCharges.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, description, type);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TelcoInvoiceAccountChargesOtherCharges {\n");
        sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
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
