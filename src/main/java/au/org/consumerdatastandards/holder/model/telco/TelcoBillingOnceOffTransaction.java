package au.org.consumerdatastandards.holder.model.telco;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * TelcoBillingOnceOffTransaction
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen",
        date = "2022-12-23T11:32:06.900+11:00[Australia/Sydney]")
public class TelcoBillingOnceOffTransaction {
    @JsonProperty("serviceId")
    private String serviceId;

    @JsonProperty("invoiceNumber")
    private String invoiceNumber;

    @JsonProperty("amount")
    private String amount;

    @JsonProperty("description")
    private String description;

    public TelcoBillingOnceOffTransaction serviceId(String serviceId) {
        this.serviceId = serviceId;
        return this;
    }

    /**
     * The ID of the service identifier to which this transaction applies if any. E.g a [MSISDN](https://www.etsi.org/deliver/etsi_gts/03/0303/05.00.00_60/gsmts_0303v050000p.pdf), [FNN](https://www.nbnco.com.au/content/dam/nbnco2/documents/sfaa-wba2-dictionary_FTTN-launch.pdf) or internet service e.g [NBN AVC Service ID](https://www.nbnco.com.au/content/dam/nbnco2/documents/sfaa-wba2-dictionary_FTTN-launch.pdf). In accordance with [CDR ID permanence](#id-permanence) requirements.
     *
     * @return serviceId
     */
    @ApiModelProperty(value = "The ID of the service identifier to which this transaction applies if any. E.g a [MSISDN](https://www.etsi.org/deliver/etsi_gts/03/0303/05.00.00_60/gsmts_0303v050000p.pdf), [FNN](https://www.nbnco.com.au/content/dam/nbnco2/documents/sfaa-wba2-dictionary_FTTN-launch.pdf) or internet service e.g [NBN AVC Service ID](https://www.nbnco.com.au/content/dam/nbnco2/documents/sfaa-wba2-dictionary_FTTN-launch.pdf). In accordance with [CDR ID permanence](#id-permanence) requirements.")


    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public TelcoBillingOnceOffTransaction invoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
        return this;
    }

    /**
     * The number of the invoice in which this transaction is included if it has been issued.
     *
     * @return invoiceNumber
     */
    @ApiModelProperty(value = "The number of the invoice in which this transaction is included if it has been issued.")


    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public TelcoBillingOnceOffTransaction amount(String amount) {
        this.amount = amount;
        return this;
    }

    /**
     * The amount of the charge or credit. A positive value indicates a charge and a negative value indicates a credit.
     *
     * @return amount
     */
    @ApiModelProperty(required = true,
            value = "The amount of the charge or credit. A positive value indicates a charge and a negative value indicates a credit.")
    @NotNull
    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public TelcoBillingOnceOffTransaction description(String description) {
        this.description = description;
        return this;
    }

    /**
     * A free text description of the item.
     *
     * @return description
     */
    @ApiModelProperty(required = true,
            value = "A free text description of the item.")
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
        TelcoBillingOnceOffTransaction telcoBillingOnceOffTransaction = (TelcoBillingOnceOffTransaction) o;
        return Objects.equals(this.serviceId, telcoBillingOnceOffTransaction.serviceId) &&
                Objects.equals(this.invoiceNumber, telcoBillingOnceOffTransaction.invoiceNumber) &&
                Objects.equals(this.amount, telcoBillingOnceOffTransaction.amount) &&
                Objects.equals(this.description, telcoBillingOnceOffTransaction.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serviceId, invoiceNumber, amount, description);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TelcoBillingOnceOffTransaction {\n");

        sb.append("    serviceId: ").append(toIndentedString(serviceId)).append("\n");
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

