package au.org.consumerdatastandards.client.model.telco;

import java.util.Objects;

/**
 * TelcoBillingOnceOffTransaction
 */
public class TelcoBillingOnceOffTransaction {
    private String serviceId;

    private String invoiceNumber;

    private String amount;

    private String description;

    public TelcoBillingOnceOffTransaction serviceId(String serviceId) {
        this.serviceId = serviceId;
        return this;
    }

    /**
     * The ID of the service identifier to which this transaction applies if any. E.g a [MSISDN](https://www.etsi.org/deliver/etsi_gts/03/0303/05.00.00_60/gsmts_0303v050000p.pdf), [FNN](https://www.nbnco.com.au/content/dam/nbnco2/documents/sfaa-wba2-dictionary_FTTN-launch.pdf) or internet service e.g [NBN AVC Service ID](https://www.nbnco.com.au/content/dam/nbnco2/documents/sfaa-wba2-dictionary_FTTN-launch.pdf). In accordance with [CDR ID permanence](#id-permanence) requirements
     *
     * @return serviceId
     */
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
     * The number of the invoice in which this transaction is included if it has been issued
     *
     * @return invoiceNumber
     */
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
     * The amount of the charge or credit.  A positive value indicates a charge and a negative value indicates a credit
     *
     * @return amount
     */
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
     * A free text description of the item
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
