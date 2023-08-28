package au.org.consumerdatastandards.holder.model.energy;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * EnergyInvoice
 */
@Entity
public class EnergyInvoice {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @JsonIgnore
    private String id;

    private String accountId;

    private String invoiceNumber;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDate issueDate;    // "x-cds-type" : "DateString"

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDate dueDate;      // "x-cds-type" : "DateString"

    @Embedded
    private EnergyInvoicePeriod period;

    private String invoiceAmount;

    private String gstAmount;

    @OneToOne(cascade = CascadeType.ALL)
    private EnergyInvoicePayOnTimeDiscount payOnTimeDiscount;

    private String balanceAtIssue;

    @ElementCollection
    @Valid
    private List<String> servicePoints = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    private EnergyInvoiceGasUsageCharges gas;

    @OneToOne(cascade = CascadeType.ALL)
    private EnergyInvoiceElectricityUsageCharges electricity;

    @OneToOne(cascade = CascadeType.ALL)
    private EnergyInvoiceAccountCharges accountCharges;

    /**
     * Indicator of the payment status for the invoice
     */
    public enum PaymentStatusEnum {
        PAID,
        PARTIALLY_PAID,
        NOT_PAID
    }

    private PaymentStatusEnum paymentStatus;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public EnergyInvoice accountId(String accountId) {
        this.accountId = accountId;
        return this;
    }

    /**
     * The ID of the account for which the invoice was issued
     *
     * @return accountId
     */
    @ApiModelProperty(required = true, value = "The ID of the account for which the invoice was issued")
    @NotNull
    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public EnergyInvoice invoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
        return this;
    }

    /**
     * The number assigned to this invoice by the energy Retailer
     *
     * @return invoiceNumber
     */
    @ApiModelProperty(required = true, value = "The number assigned to this invoice by the energy Retailer")
    @NotNull
    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public EnergyInvoice issueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
        return this;
    }

    /**
     * The date that the invoice was actually issued (as opposed to generated or calculated)
     *
     * @return issueDate
     */
    @ApiModelProperty(required = true,
            value = "The date that the invoice was actually issued (as opposed to generated or calculated)")
    @NotNull
    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public EnergyInvoice dueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    /**
     * The date that the invoice is due to be paid
     *
     * @return dueDate
     */
    @ApiModelProperty(value = "The date that the invoice is due to be paid")
    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public EnergyInvoice period(EnergyInvoicePeriod period) {
        this.period = period;
        return this;
    }

    /**
     * Get period
     *
     * @return period
     */
    @ApiModelProperty(value = "")
    @Valid
    public EnergyInvoicePeriod getPeriod() {
        return period;
    }

    public void setPeriod(EnergyInvoicePeriod period) {
        this.period = period;
    }

    public EnergyInvoice invoiceAmount(String invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
        return this;
    }

    /**
     * The net amount due for this invoice regardless of previous balance
     *
     * @return invoiceAmount
     */
    @ApiModelProperty(value = "The net amount due for this invoice regardless of previous balance")
    public String getInvoiceAmount() {
        return invoiceAmount;
    }

    public void setInvoiceAmount(String invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }

    public EnergyInvoice gstAmount(String gstAmount) {
        this.gstAmount = gstAmount;
        return this;
    }

    /**
     * The total GST amount for this invoice.  If absent then zero is assumed
     *
     * @return gstAmount
     */
    @ApiModelProperty(value = "The total GST amount for this invoice.  If absent then zero is assumed")
    public String getGstAmount() {
        return gstAmount;
    }

    public void setGstAmount(String gstAmount) {
        this.gstAmount = gstAmount;
    }

    public EnergyInvoice payOnTimeDiscount(EnergyInvoicePayOnTimeDiscount payOnTimeDiscount) {
        this.payOnTimeDiscount = payOnTimeDiscount;
        return this;
    }

    /**
     * Get payOnTimeDiscount
     *
     * @return payOnTimeDiscount
     */
    @ApiModelProperty(value = "")
    @Valid
    public EnergyInvoicePayOnTimeDiscount getPayOnTimeDiscount() {
        return payOnTimeDiscount;
    }

    public void setPayOnTimeDiscount(EnergyInvoicePayOnTimeDiscount payOnTimeDiscount) {
        this.payOnTimeDiscount = payOnTimeDiscount;
    }

    public EnergyInvoice balanceAtIssue(String balanceAtIssue) {
        this.balanceAtIssue = balanceAtIssue;
        return this;
    }

    /**
     * The account balance at the time the invoice was issued
     *
     * @return balanceAtIssue
     */
    @ApiModelProperty(required = true, value = "The account balance at the time the invoice was issued")
    @NotNull
    public String getBalanceAtIssue() {
        return balanceAtIssue;
    }

    public void setBalanceAtIssue(String balanceAtIssue) {
        this.balanceAtIssue = balanceAtIssue;
    }

    public EnergyInvoice servicePoints(List<String> servicePoints) {
        this.servicePoints = servicePoints;
        return this;
    }

    public EnergyInvoice addServicePointsItem(String servicePointsItem) {
        this.servicePoints.add(servicePointsItem);
        return this;
    }

    /**
     * Array of service point IDs to which this invoice applies. May be empty if the invoice contains no electricity usage related charges
     *
     * @return servicePoints
     */
    @ApiModelProperty(required = true,
            value = "Array of service point IDs to which this invoice applies. May be empty if the invoice contains no electricity usage related charges")
    @NotNull
    public List<String> getServicePoints() {
        return servicePoints;
    }

    public void setServicePoints(List<String> servicePoints) {
        this.servicePoints = servicePoints;
    }

    public EnergyInvoice gas(EnergyInvoiceGasUsageCharges gas) {
        this.gas = gas;
        return this;
    }

    /**
     * Get gas
     *
     * @return gas
     */
    @ApiModelProperty(value = "")
    @Valid
    public EnergyInvoiceGasUsageCharges getGas() {
        return gas;
    }

    public void setGas(EnergyInvoiceGasUsageCharges gas) {
        this.gas = gas;
    }

    public EnergyInvoice electricity(EnergyInvoiceElectricityUsageCharges electricity) {
        this.electricity = electricity;
        return this;
    }

    /**
     * Get electricity
     *
     * @return electricity
     */
    @ApiModelProperty(value = "")
    @Valid
    public EnergyInvoiceElectricityUsageCharges getElectricity() {
        return electricity;
    }

    public void setElectricity(EnergyInvoiceElectricityUsageCharges electricity) {
        this.electricity = electricity;
    }

    public EnergyInvoice accountCharges(EnergyInvoiceAccountCharges accountCharges) {
        this.accountCharges = accountCharges;
        return this;
    }

    /**
     * Get accountCharges
     *
     * @return accountCharges
     */
    @ApiModelProperty(value = "")
    @Valid
    public EnergyInvoiceAccountCharges getAccountCharges() {
        return accountCharges;
    }

    public void setAccountCharges(EnergyInvoiceAccountCharges accountCharges) {
        this.accountCharges = accountCharges;
    }

    public EnergyInvoice paymentStatus(PaymentStatusEnum paymentStatus) {
        this.paymentStatus = paymentStatus;
        return this;
    }

    /**
     * Indicator of the payment status for the invoice
     *
     * @return paymentStatus
     */
    @ApiModelProperty(required = true, value = "Indicator of the payment status for the invoice")
    @NotNull
    public PaymentStatusEnum getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatusEnum paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EnergyInvoice energyInvoice = (EnergyInvoice) o;
        return Objects.equals(this.accountId, energyInvoice.accountId) &&
                Objects.equals(this.invoiceNumber, energyInvoice.invoiceNumber) &&
                Objects.equals(this.issueDate, energyInvoice.issueDate) &&
                Objects.equals(this.dueDate, energyInvoice.dueDate) &&
                Objects.equals(this.period, energyInvoice.period) &&
                Objects.equals(this.invoiceAmount, energyInvoice.invoiceAmount) &&
                Objects.equals(this.gstAmount, energyInvoice.gstAmount) &&
                Objects.equals(this.payOnTimeDiscount, energyInvoice.payOnTimeDiscount) &&
                Objects.equals(this.balanceAtIssue, energyInvoice.balanceAtIssue) &&
                Objects.equals(this.servicePoints, energyInvoice.servicePoints) &&
                Objects.equals(this.gas, energyInvoice.gas) &&
                Objects.equals(this.electricity, energyInvoice.electricity) &&
                Objects.equals(this.accountCharges, energyInvoice.accountCharges) &&
                Objects.equals(this.paymentStatus, energyInvoice.paymentStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, invoiceNumber, issueDate, dueDate, period, invoiceAmount, gstAmount, payOnTimeDiscount, balanceAtIssue, servicePoints, gas, electricity, accountCharges, paymentStatus);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyInvoice {\n");
        sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
        sb.append("    invoiceNumber: ").append(toIndentedString(invoiceNumber)).append("\n");
        sb.append("    issueDate: ").append(toIndentedString(issueDate)).append("\n");
        sb.append("    dueDate: ").append(toIndentedString(dueDate)).append("\n");
        sb.append("    period: ").append(toIndentedString(period)).append("\n");
        sb.append("    invoiceAmount: ").append(toIndentedString(invoiceAmount)).append("\n");
        sb.append("    gstAmount: ").append(toIndentedString(gstAmount)).append("\n");
        sb.append("    payOnTimeDiscount: ").append(toIndentedString(payOnTimeDiscount)).append("\n");
        sb.append("    balanceAtIssue: ").append(toIndentedString(balanceAtIssue)).append("\n");
        sb.append("    servicePoints: ").append(toIndentedString(servicePoints)).append("\n");
        sb.append("    gas: ").append(toIndentedString(gas)).append("\n");
        sb.append("    electricity: ").append(toIndentedString(electricity)).append("\n");
        sb.append("    accountCharges: ").append(toIndentedString(accountCharges)).append("\n");
        sb.append("    paymentStatus: ").append(toIndentedString(paymentStatus)).append("\n");
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
