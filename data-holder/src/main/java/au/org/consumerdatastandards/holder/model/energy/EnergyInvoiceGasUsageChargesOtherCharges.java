package au.org.consumerdatastandards.holder.model.energy;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * EnergyInvoiceGasUsageChargesOtherCharges
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen",
        date = "2022-01-11T14:03:27.755+11:00[Australia/Sydney]")
public class EnergyInvoiceGasUsageChargesOtherCharges {
    /**
     * Type of charge. Assumed to be other if absent
     */
    public enum TypeEnum {
        ENVIRONMENTAL("ENVIRONMENTAL"),

        REGULATED("REGULATED"),

        NETWORK("NETWORK"),

        METERING("METERING"),

        RETAIL_SERVICE("RETAIL_SERVICE"),

        RCTI("RCTI"),

        OTHER("OTHER");

        private String value;

        TypeEnum(String value) {
            this.value = value;
        }

        @JsonValue
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        @JsonCreator
        public static TypeEnum fromValue(String value) {
            for (TypeEnum b : TypeEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    @JsonProperty("type")
    private TypeEnum type;

    @JsonProperty("amount")
    private String amount;

    @JsonProperty("description")
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
    @ApiModelProperty(value = "Type of charge. Assumed to be other if absent")


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
    @ApiModelProperty(required = true,
            value = "The aggregate total of charges for this item (exclusive of GST)")
    @NotNull


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
    @ApiModelProperty(required = true,
            value = "A free text description of the type of charge")
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

