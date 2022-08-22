package au.org.consumerdatastandards.client.model.energy;

import java.util.Objects;

/**
 * EnergyInvoiceGasUsageChargesOtherCharges
 */
public class EnergyInvoiceGasUsageChargesOtherCharges {
    /**
     * Type of charge. Assumed to be other if absent
     */
    public enum TypeEnum {
        ENVIRONMENTAL,
        REGULATED,
        NETWORK,
        METERING,
        RETAIL_SERVICE,
        RCTI,
        OTHER
    }

    private TypeEnum type;

    private String amount;

    private String description;

    public EnergyInvoiceGasUsageChargesOtherCharges type(TypeEnum type) {
        this.type = type;
        return this;
    }

    /**
     * Type of charge. Assumed to be other if absent
     *
     * @return type
     */
    public TypeEnum getType() {
        return type;
    }

    public void setType(TypeEnum type) {
        this.type = type;
    }

    public EnergyInvoiceGasUsageChargesOtherCharges amount(String amount) {
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

    public EnergyInvoiceGasUsageChargesOtherCharges description(String description) {
        this.description = description;
        return this;
    }

    /**
     * A free text description of the type of charge
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
        EnergyInvoiceGasUsageChargesOtherCharges energyInvoiceGasUsageChargesOtherCharges = (EnergyInvoiceGasUsageChargesOtherCharges) o;
        return Objects.equals(this.type, energyInvoiceGasUsageChargesOtherCharges.type) &&
                Objects.equals(this.amount, energyInvoiceGasUsageChargesOtherCharges.amount) &&
                Objects.equals(this.description, energyInvoiceGasUsageChargesOtherCharges.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, amount, description);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyInvoiceGasUsageChargesOtherCharges {\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
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
