package au.org.consumerdatastandards.client.model.telco;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * TelcoInvoice
 */
public class TelcoInvoice {
    private String accountId;

    private String invoiceNumber;

    private String issueDate;

    private String dueDate;

    private TelcoInvoicePeriod period;

    private String invoiceAmount;

    private String gstAmount;

    private TelcoInvoicePayOnTimeDiscount payOnTimeDiscount;

    private String balanceAtIssue;

    private List<String> services = new ArrayList<>();

    private TelcoInvoiceAccountCharges accountCharges;

    private TelcoUsage accountUsage;

    /**
     * Indicator of the payment status for the invoice
     */
    public enum PaymentStatusEnum {
        PAID,
        PARTIALLY_PAID,
        NOT_PAID
    }

    private PaymentStatusEnum paymentStatus = PaymentStatusEnum.NOT_PAID;

    public TelcoInvoice accountId(String accountId) {
        this.accountId = accountId;
        return this;
    }

    /**
     * The ID of the account for which the invoice was issued. accountId must comply in accordance with [CDR ID permanence](#id-permanence)
     *
     * @return accountId
     */
    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public TelcoInvoice invoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
        return this;
    }

    /**
     * The number assigned to this invoice by the telco Retailer
     *
     * @return invoiceNumber
     */
    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public TelcoInvoice issueDate(String issueDate) {
        this.issueDate = issueDate;
        return this;
    }

    /**
     * The date that the invoice was actually issued (as opposed to generated or calculated)
     *
     * @return issueDate
     */
    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public TelcoInvoice dueDate(String dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    /**
     * The date that the invoice is due to be paid
     *
     * @return dueDate
     */
    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public TelcoInvoice period(TelcoInvoicePeriod period) {
        this.period = period;
        return this;
    }

    /**
     * Get period
     *
     * @return period
     */
    public TelcoInvoicePeriod getPeriod() {
        return period;
    }

    public void setPeriod(TelcoInvoicePeriod period) {
        this.period = period;
    }

    public TelcoInvoice invoiceAmount(String invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
        return this;
    }

    /**
     * The net amount due for this invoice regardless of previous balance
     *
     * @return invoiceAmount
     */
    public String getInvoiceAmount() {
        return invoiceAmount;
    }

    public void setInvoiceAmount(String invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }

    public TelcoInvoice gstAmount(String gstAmount) {
        this.gstAmount = gstAmount;
        return this;
    }

    /**
     * The total GST amount for this invoice.  If absent then zero is assumed
     *
     * @return gstAmount
     */
    public String getGstAmount() {
        return gstAmount;
    }

    public void setGstAmount(String gstAmount) {
        this.gstAmount = gstAmount;
    }

    public TelcoInvoice payOnTimeDiscount(TelcoInvoicePayOnTimeDiscount payOnTimeDiscount) {
        this.payOnTimeDiscount = payOnTimeDiscount;
        return this;
    }

    /**
     * Get payOnTimeDiscount
     *
     * @return payOnTimeDiscount
     */
    public TelcoInvoicePayOnTimeDiscount getPayOnTimeDiscount() {
        return payOnTimeDiscount;
    }

    public void setPayOnTimeDiscount(TelcoInvoicePayOnTimeDiscount payOnTimeDiscount) {
        this.payOnTimeDiscount = payOnTimeDiscount;
    }

    public TelcoInvoice balanceAtIssue(String balanceAtIssue) {
        this.balanceAtIssue = balanceAtIssue;
        return this;
    }

    /**
     * The account balance at the time the invoice was issued
     *
     * @return balanceAtIssue
     */
    public String getBalanceAtIssue() {
        return balanceAtIssue;
    }

    public void setBalanceAtIssue(String balanceAtIssue) {
        this.balanceAtIssue = balanceAtIssue;
    }

    public TelcoInvoice services(List<String> services) {
        this.services = services;
        return this;
    }

    public TelcoInvoice addServicesItem(String servicesItem) {
        this.services.add(servicesItem);
        return this;
    }

    /**
     * An array of service IDs to which this invoice applies. May be empty if the invoice contains no usage related charges
     *
     * @return services
     */
    public List<String> getServices() {
        return services;
    }

    public void setServices(List<String> services) {
        this.services = services;
    }

    public TelcoInvoice accountCharges(TelcoInvoiceAccountCharges accountCharges) {
        this.accountCharges = accountCharges;
        return this;
    }

    /**
     * Get accountCharges
     *
     * @return accountCharges
     */
    public TelcoInvoiceAccountCharges getAccountCharges() {
        return accountCharges;
    }

    public void setAccountCharges(TelcoInvoiceAccountCharges accountCharges) {
        this.accountCharges = accountCharges;
    }

    public TelcoInvoice accountUsage(TelcoUsage accountUsage) {
        this.accountUsage = accountUsage;
        return this;
    }

    /**
     * Get accountUsage
     *
     * @return accountUsage
     */
    public TelcoUsage getAccountUsage() {
        return accountUsage;
    }

    public void setAccountUsage(TelcoUsage accountUsage) {
        this.accountUsage = accountUsage;
    }

    public TelcoInvoice paymentStatus(PaymentStatusEnum paymentStatus) {
        this.paymentStatus = paymentStatus;
        return this;
    }

    /**
     * Indicator of the payment status for the invoice
     *
     * @return paymentStatus
     */
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
        TelcoInvoice telcoInvoice = (TelcoInvoice) o;
        return Objects.equals(this.accountId, telcoInvoice.accountId) &&
                Objects.equals(this.invoiceNumber, telcoInvoice.invoiceNumber) &&
                Objects.equals(this.issueDate, telcoInvoice.issueDate) &&
                Objects.equals(this.dueDate, telcoInvoice.dueDate) &&
                Objects.equals(this.period, telcoInvoice.period) &&
                Objects.equals(this.invoiceAmount, telcoInvoice.invoiceAmount) &&
                Objects.equals(this.gstAmount, telcoInvoice.gstAmount) &&
                Objects.equals(this.payOnTimeDiscount, telcoInvoice.payOnTimeDiscount) &&
                Objects.equals(this.balanceAtIssue, telcoInvoice.balanceAtIssue) &&
                Objects.equals(this.services, telcoInvoice.services) &&
                Objects.equals(this.accountCharges, telcoInvoice.accountCharges) &&
                Objects.equals(this.accountUsage, telcoInvoice.accountUsage) &&
                Objects.equals(this.paymentStatus, telcoInvoice.paymentStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, invoiceNumber, issueDate, dueDate, period, invoiceAmount, gstAmount, payOnTimeDiscount, balanceAtIssue, services, accountCharges, accountUsage, paymentStatus);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TelcoInvoice {\n");
        sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
        sb.append("    invoiceNumber: ").append(toIndentedString(invoiceNumber)).append("\n");
        sb.append("    issueDate: ").append(toIndentedString(issueDate)).append("\n");
        sb.append("    dueDate: ").append(toIndentedString(dueDate)).append("\n");
        sb.append("    period: ").append(toIndentedString(period)).append("\n");
        sb.append("    invoiceAmount: ").append(toIndentedString(invoiceAmount)).append("\n");
        sb.append("    gstAmount: ").append(toIndentedString(gstAmount)).append("\n");
        sb.append("    payOnTimeDiscount: ").append(toIndentedString(payOnTimeDiscount)).append("\n");
        sb.append("    balanceAtIssue: ").append(toIndentedString(balanceAtIssue)).append("\n");
        sb.append("    services: ").append(toIndentedString(services)).append("\n");
        sb.append("    accountCharges: ").append(toIndentedString(accountCharges)).append("\n");
        sb.append("    accountUsage: ").append(toIndentedString(accountUsage)).append("\n");
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
