package au.org.consumerdatastandards.holder.model.energy;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * EnergyBillingOnceOffTransaction
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen",
        date = "2022-01-11T14:03:27.755+11:00[Australia/Sydney]")
public class EnergyBillingOnceOffTransaction {
    @JsonProperty("servicePointId")
    private String servicePointId;

    @JsonProperty("invoiceNumber")
    private String invoiceNumber;

    @JsonProperty("amount")
    private String amount;

    @JsonProperty("description")
    private String description;

    public EnergyBillingOnceOffTransaction servicePointId(String servicePointId) {
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

    public EnergyBillingOnceOffTransaction invoiceNumber(String invoiceNumber) {
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

    public EnergyBillingOnceOffTransaction amount(String amount) {
        this.amount = amount;
        return this;
    }

    /**
     * The amount of the charge or credit.  A positive value indicates a charge and a negative value indicates a credit
     *
     * @return amount
     */
    @ApiModelProperty(required = true,
            value = "The amount of the charge or credit.  A positive value indicates a charge and a negative value indicates a credit")
    @NotNull


    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public EnergyBillingOnceOffTransaction description(String description) {
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
        EnergyBillingOnceOffTransaction energyBillingOnceOffTransaction = (EnergyBillingOnceOffTransaction) o;
        return Objects.equals(this.servicePointId, energyBillingOnceOffTransaction.servicePointId) &&
                Objects.equals(this.invoiceNumber, energyBillingOnceOffTransaction.invoiceNumber) &&
                Objects.equals(this.amount, energyBillingOnceOffTransaction.amount) &&
                Objects.equals(this.description, energyBillingOnceOffTransaction.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(servicePointId, invoiceNumber, amount, description);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyBillingOnceOffTransaction {\n");

        sb.append("    servicePointId: ").append(toIndentedString(servicePointId)).append("\n");
        sb.append("    invoiceNumber: ").append(toIndentedString(invoiceNumber)).append("\n");
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

