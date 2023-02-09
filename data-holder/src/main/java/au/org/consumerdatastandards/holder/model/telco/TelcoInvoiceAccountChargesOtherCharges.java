package au.org.consumerdatastandards.holder.model.telco;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * Optional array of charges that may be part of the invoice (for example services fees) (exclusive of GST)
 */
@ApiModel(description = "Optional array of charges that may be part of the invoice (for example services fees) (exclusive of GST)")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen",
        date = "2022-12-23T11:32:06.900+11:00[Australia/Sydney]")
public class TelcoInvoiceAccountChargesOtherCharges {
    @JsonProperty("amount")
    private String amount;

    @JsonProperty("description")
    private String description;

    /**
     * A free text description of the charge
     */
    public enum TypeEnum {
        SERVICE("SERVICE"),

        EQUIPMENT("EQUIPMENT"),

        NETWORK("NETWORK"),

        HANDSET("HANDSET"),

        DEVICE("DEVICE"),

        ENTERTAINMENT("ENTERTAINMENT"),

        SUBSCRIPTION("SUBSCRIPTION"),

        SOFTWARE("SOFTWARE"),

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

    public TelcoInvoiceAccountChargesOtherCharges amount(String amount) {
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

    public TelcoInvoiceAccountChargesOtherCharges description(String description) {
        this.description = description;
        return this;
    }

    /**
     * A free text description of the charge
     *
     * @return description
     */
    @ApiModelProperty(required = true,
            value = "A free text description of the charge")
    @NotNull


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
    @ApiModelProperty(value = "A free text description of the charge")


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

