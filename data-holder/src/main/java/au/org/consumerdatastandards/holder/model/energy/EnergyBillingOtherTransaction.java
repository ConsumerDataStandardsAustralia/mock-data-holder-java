package au.org.consumerdatastandards.holder.model.energy;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * EnergyBillingOtherTransaction
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen",
        date = "2022-01-11T14:03:27.755+11:00[Australia/Sydney]")
public class EnergyBillingOtherTransaction {
    @JsonProperty("servicePointId")
    private String servicePointId;

    @JsonProperty("invoiceNumber")
    private String invoiceNumber;

    @JsonProperty("startDate")
    private String startDate;

    @JsonProperty("endDate")
    private String endDate;

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

    public EnergyBillingOtherTransaction servicePointId(String servicePointId) {
        this.servicePointId = servicePointId;
        return this;
    }

    /**
     * The ID of the service point to which this transaction applies if any
     *
     * @return servicePointId
     */
    @ApiModelProperty(value = "The ID of the service point to which this transaction applies if any")


    public String getServicePointId() {
        return servicePointId;
    }

    public void setServicePointId(String servicePointId) {
        this.servicePointId = servicePointId;
    }

    public EnergyBillingOtherTransaction invoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
        return this;
    }

    /**
     * The number of the invoice in which this transaction is included if it has been issued
     *
     * @return invoiceNumber
     */
    @ApiModelProperty(value = "The number of the invoice in which this transaction is included if it has been issued")


    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public EnergyBillingOtherTransaction startDate(String startDate) {
        this.startDate = startDate;
        return this;
    }

    /**
     * Optional start date for the application of the charge
     *
     * @return startDate
     */
    @ApiModelProperty(value = "Optional start date for the application of the charge")


    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public EnergyBillingOtherTransaction endDate(String endDate) {
        this.endDate = endDate;
        return this;
    }

    /**
     * Optional end date for the application of the charge
     *
     * @return endDate
     */
    @ApiModelProperty(value = "Optional end date for the application of the charge")


    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public EnergyBillingOtherTransaction type(TypeEnum type) {
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

    public EnergyBillingOtherTransaction amount(String amount) {
        this.amount = amount;
        return this;
    }

    /**
     * The amount of the charge
     *
     * @return amount
     */
    @ApiModelProperty(required = true,
            value = "The amount of the charge")
    @NotNull


    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public EnergyBillingOtherTransaction description(String description) {
        this.description = description;
        return this;
    }

    /**
     * A free text description of the item
     *
     * @return description
     */
    @ApiModelProperty(required = true,
            value = "A free text description of the item")
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
        EnergyBillingOtherTransaction energyBillingOtherTransaction = (EnergyBillingOtherTransaction) o;
        return Objects.equals(this.servicePointId, energyBillingOtherTransaction.servicePointId) &&
                Objects.equals(this.invoiceNumber, energyBillingOtherTransaction.invoiceNumber) &&
                Objects.equals(this.startDate, energyBillingOtherTransaction.startDate) &&
                Objects.equals(this.endDate, energyBillingOtherTransaction.endDate) &&
                Objects.equals(this.type, energyBillingOtherTransaction.type) &&
                Objects.equals(this.amount, energyBillingOtherTransaction.amount) &&
                Objects.equals(this.description, energyBillingOtherTransaction.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(servicePointId, invoiceNumber, startDate, endDate, type, amount, description);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyBillingOtherTransaction {\n");

        sb.append("    servicePointId: ").append(toIndentedString(servicePointId)).append("\n");
        sb.append("    invoiceNumber: ").append(toIndentedString(invoiceNumber)).append("\n");
        sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
        sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
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

