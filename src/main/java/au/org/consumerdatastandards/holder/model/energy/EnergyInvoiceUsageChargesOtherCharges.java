package au.org.consumerdatastandards.holder.model.energy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * EnergyInvoiceUsageChargesOtherCharges
 */
@Entity
public class EnergyInvoiceUsageChargesOtherCharges {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @JsonIgnore
    private String id;

    /**
     * Type of charge. Assumed to be other if absent.
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public EnergyInvoiceUsageChargesOtherCharges type(TypeEnum type) {
        this.type = type;
        return this;
    }

    /**
     * Type of charge. Assumed to be other if absent.
     *
     * @return type
     */
    @ApiModelProperty(value = "Type of charge. Assumed to be other if absent.")
    public TypeEnum getType() {
        return type;
    }

    public void setType(TypeEnum type) {
        this.type = type;
    }

    public EnergyInvoiceUsageChargesOtherCharges amount(String amount) {
        this.amount = amount;
        return this;
    }

    /**
     * The aggregate total of charges for this item (exclusive of GST)
     *
     * @return amount
     */
    @ApiModelProperty(required = true, value = "The aggregate total of charges for this item (exclusive of GST)")
    @NotNull
    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public EnergyInvoiceUsageChargesOtherCharges description(String description) {
        this.description = description;
        return this;
    }

    /**
     * A free text description of the type of charge
     *
     * @return description
     */
    @ApiModelProperty(required = true, value = "A free text description of the type of charge")
    @NotNull
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
        EnergyInvoiceUsageChargesOtherCharges energyInvoiceUsageChargesOtherCharges = (EnergyInvoiceUsageChargesOtherCharges) o;
        return Objects.equals(this.type, energyInvoiceUsageChargesOtherCharges.type) &&
                Objects.equals(this.amount, energyInvoiceUsageChargesOtherCharges.amount) &&
                Objects.equals(this.description, energyInvoiceUsageChargesOtherCharges.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, amount, description);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyInvoiceUsageChargesOtherCharges {\n");
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
