package au.org.consumerdatastandards.holder.model.telco;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * TelcoBillingAccountTransaction
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen",
        date = "2022-12-23T11:32:06.900+11:00[Australia/Sydney]")
public class TelcoBillingAccountTransaction {
    @JsonProperty("serviceIds")
    private String serviceIds;

    @JsonProperty("invoiceNumber")
    private String invoiceNumber;

    @JsonProperty("description")
    private String description;

    @JsonProperty("startDate")
    private String startDate;

    @JsonProperty("endDate")
    private String endDate;

    @JsonProperty("amount")
    private String amount;

    @JsonProperty("adjustments")
    @Valid
    private List<TelcoBillingAccountTransactionAdjustments> adjustments = null;

    public TelcoBillingAccountTransaction serviceIds(String serviceIds) {
        this.serviceIds = serviceIds;
        return this;
    }

    /**
     * Array list of services identifiers to which this transaction applies if any. E.g. a mobile [MSISDN](https://www.etsi.org/deliver/etsi_gts/03/0303/05.00.00_60/gsmts_0303v050000p.pdf), [FNN](https://www.nbnco.com.au/content/dam/nbnco2/documents/sfaa-wba2-dictionary_FTTN-launch.pdf) or internet service e.g [NBN AVC Service ID](https://www.nbnco.com.au/content/dam/nbnco2/documents/sfaa-wba2-dictionary_FTTN-launch.pdf). In accordance with [CDR ID permanence](#id-permanence) requirements
     *
     * @return serviceIds
     */
    @ApiModelProperty(value = "Array list of services identifiers to which this transaction applies if any. E.g. a mobile [MSISDN](https://www.etsi.org/deliver/etsi_gts/03/0303/05.00.00_60/gsmts_0303v050000p.pdf), [FNN](https://www.nbnco.com.au/content/dam/nbnco2/documents/sfaa-wba2-dictionary_FTTN-launch.pdf) or internet service e.g [NBN AVC Service ID](https://www.nbnco.com.au/content/dam/nbnco2/documents/sfaa-wba2-dictionary_FTTN-launch.pdf). In accordance with [CDR ID permanence](#id-permanence) requirements")


    public String getServiceIds() {
        return serviceIds;
    }

    public void setServiceIds(String serviceIds) {
        this.serviceIds = serviceIds;
    }

    public TelcoBillingAccountTransaction invoiceNumber(String invoiceNumber) {
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

    public TelcoBillingAccountTransaction description(String description) {
        this.description = description;
        return this;
    }

    /**
     * Optional description of the transaction that can be used for display purposes
     *
     * @return description
     */
    @ApiModelProperty(value = "Optional description of the transaction that can be used for display purposes")


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TelcoBillingAccountTransaction startDate(String startDate) {
        this.startDate = startDate;
        return this;
    }

    /**
     * Date and time when the usage period starts
     *
     * @return startDate
     */
    @ApiModelProperty(required = true,
            value = "Date and time when the usage period starts")
    @NotNull


    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public TelcoBillingAccountTransaction endDate(String endDate) {
        this.endDate = endDate;
        return this;
    }

    /**
     * Date and time when the usage period ends
     *
     * @return endDate
     */
    @ApiModelProperty(required = true,
            value = "Date and time when the usage period ends")
    @NotNull


    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public TelcoBillingAccountTransaction amount(String amount) {
        this.amount = amount;
        return this;
    }

    /**
     * The amount charged or credited for this transaction prior to any adjustments being applied.  A negative value indicates a credit
     *
     * @return amount
     */
    @ApiModelProperty(required = true,
            value = "The amount charged or credited for this transaction prior to any adjustments being applied.  A negative value indicates a credit")
    @NotNull


    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public TelcoBillingAccountTransaction adjustments(List<TelcoBillingAccountTransactionAdjustments> adjustments) {
        this.adjustments = adjustments;
        return this;
    }

    public TelcoBillingAccountTransaction addAdjustmentsItem(TelcoBillingAccountTransactionAdjustments adjustmentsItem) {
        if (this.adjustments == null) {
            this.adjustments = new ArrayList<>();
        }
        this.adjustments.add(adjustmentsItem);
        return this;
    }

    /**
     * Optional array of adjustments arising for this transaction
     *
     * @return adjustments
     */
    @ApiModelProperty(value = "Optional array of adjustments arising for this transaction")

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
        TelcoBillingAccountTransaction telcoBillingAccountTransaction = (TelcoBillingAccountTransaction) o;
        return Objects.equals(this.serviceIds, telcoBillingAccountTransaction.serviceIds) &&
                Objects.equals(this.invoiceNumber, telcoBillingAccountTransaction.invoiceNumber) &&
                Objects.equals(this.description, telcoBillingAccountTransaction.description) &&
                Objects.equals(this.startDate, telcoBillingAccountTransaction.startDate) &&
                Objects.equals(this.endDate, telcoBillingAccountTransaction.endDate) &&
                Objects.equals(this.amount, telcoBillingAccountTransaction.amount) &&
                Objects.equals(this.adjustments, telcoBillingAccountTransaction.adjustments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serviceIds, invoiceNumber, description, startDate, endDate, amount, adjustments);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TelcoBillingAccountTransaction {\n");

        sb.append("    serviceIds: ").append(toIndentedString(serviceIds)).append("\n");
        sb.append("    invoiceNumber: ").append(toIndentedString(invoiceNumber)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
        sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
        sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
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

