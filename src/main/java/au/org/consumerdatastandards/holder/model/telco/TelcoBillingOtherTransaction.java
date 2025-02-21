package au.org.consumerdatastandards.holder.model.telco;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * TelcoBillingOtherTransaction
 */
public class TelcoBillingOtherTransaction {
    private String serviceId;

    private String invoiceNumber;

    private String startDate;

    private String endDate;

    /**
     * Type of charge. Assumed to be `OTHER` if absent.
     */
    public enum TypeEnum {
        SERVICE,
        NETWORK,
        EQUIPMENT,
        METERING,
        OTHER
    }

    private TypeEnum type = TypeEnum.OTHER;

    private String amount;

    private String description;

    @Valid
    private List<TelcoBillingAccountTransactionAdjustments> adjustments = null;

    public TelcoBillingOtherTransaction serviceId(String serviceId) {
        this.serviceId = serviceId;
        return this;
    }

    /**
     * The service identifier to which this transaction applies if any. E.g a mobile [MSISDN](https://www.etsi.org/deliver/etsi_gts/03/0303/05.00.00_60/gsmts_0303v050000p.pdf), [FNN](https://www.nbnco.com.au/content/dam/nbnco2/documents/sfaa-wba2-dictionary_FTTN-launch.pdf) or internet service e.g [NBN AVC Service ID](https://www.nbnco.com.au/content/dam/nbnco2/documents/sfaa-wba2-dictionary_FTTN-launch.pdf). In accordance with [CDR ID permanence](#id-permanence) requirements.
     *
     * @return serviceId
     */
    @ApiModelProperty(value = "The service identifier to which this transaction applies if any. E.g a mobile [MSISDN](https://www.etsi.org/deliver/etsi_gts/03/0303/05.00.00_60/gsmts_0303v050000p.pdf), [FNN](https://www.nbnco.com.au/content/dam/nbnco2/documents/sfaa-wba2-dictionary_FTTN-launch.pdf) or internet service e.g [NBN AVC Service ID](https://www.nbnco.com.au/content/dam/nbnco2/documents/sfaa-wba2-dictionary_FTTN-launch.pdf). In accordance with [CDR ID permanence](#id-permanence) requirements.")
    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public TelcoBillingOtherTransaction invoiceNumber(String invoiceNumber) {
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

    public TelcoBillingOtherTransaction startDate(String startDate) {
        this.startDate = startDate;
        return this;
    }

    /**
     * Optional start date for the application of the charge.
     *
     * @return startDate
     */
    @ApiModelProperty(value = "Optional start date for the application of the charge.")
    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public TelcoBillingOtherTransaction endDate(String endDate) {
        this.endDate = endDate;
        return this;
    }

    /**
     * Optional end date for the application of the charge.
     *
     * @return endDate
     */
    @ApiModelProperty(value = "Optional end date for the application of the charge.")
    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public TelcoBillingOtherTransaction type(TypeEnum type) {
        this.type = type;
        return this;
    }

    /**
     * Type of charge. Assumed to be `OTHER` if absent.
     *
     * @return type
     */
    @ApiModelProperty(value = "Type of charge. Assumed to be `OTHER` if absent.")
    public TypeEnum getType() {
        return type;
    }

    public void setType(TypeEnum type) {
        this.type = type;
    }

    public TelcoBillingOtherTransaction amount(String amount) {
        this.amount = amount;
        return this;
    }

    /**
     * The amount of the charge.
     *
     * @return amount
     */
    @ApiModelProperty(required = true, value = "The amount of the charge.")
    @NotNull
    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public TelcoBillingOtherTransaction description(String description) {
        this.description = description;
        return this;
    }

    /**
     * A free text description of the item.
     *
     * @return description
     */
    @ApiModelProperty(required = true, value = "A free text description of the item.")
    @NotNull
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TelcoBillingOtherTransaction adjustments(List<TelcoBillingAccountTransactionAdjustments> adjustments) {
        this.adjustments = adjustments;
        return this;
    }

    public TelcoBillingOtherTransaction addAdjustmentsItem(TelcoBillingAccountTransactionAdjustments adjustmentsItem) {
        if (this.adjustments == null) {
            this.adjustments = new ArrayList<>();
        }
        this.adjustments.add(adjustmentsItem);
        return this;
    }

    /**
     * Optional array of adjustments arising for this transaction.
     *
     * @return adjustments
     */
    @ApiModelProperty(value = "Optional array of adjustments arising for this transaction.")
    @Valid
    public List<TelcoBillingAccountTransactionAdjustments> getAdjustments() {
        return adjustments;
    }

    public void setAdjustments(List<TelcoBillingAccountTransactionAdjustments> adjustments) {
        this.adjustments = adjustments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TelcoBillingOtherTransaction telcoBillingOtherTransaction = (TelcoBillingOtherTransaction) o;
        return Objects.equals(this.serviceId, telcoBillingOtherTransaction.serviceId) &&
                Objects.equals(this.invoiceNumber, telcoBillingOtherTransaction.invoiceNumber) &&
                Objects.equals(this.startDate, telcoBillingOtherTransaction.startDate) &&
                Objects.equals(this.endDate, telcoBillingOtherTransaction.endDate) &&
                Objects.equals(this.type, telcoBillingOtherTransaction.type) &&
                Objects.equals(this.amount, telcoBillingOtherTransaction.amount) &&
                Objects.equals(this.description, telcoBillingOtherTransaction.description) &&
                Objects.equals(this.adjustments, telcoBillingOtherTransaction.adjustments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serviceId, invoiceNumber, startDate, endDate, type, amount, description, adjustments);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TelcoBillingOtherTransaction {\n");
        sb.append("    serviceId: ").append(toIndentedString(serviceId)).append("\n");
        sb.append("    invoiceNumber: ").append(toIndentedString(invoiceNumber)).append("\n");
        sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
        sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    adjustments: ").append(toIndentedString(adjustments)).append("\n");
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
