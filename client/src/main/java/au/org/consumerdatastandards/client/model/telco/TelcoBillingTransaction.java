package au.org.consumerdatastandards.client.model.telco;

import java.util.Objects;

/**
 * TelcoBillingTransaction
 */
public class TelcoBillingTransaction {
    private String accountId;

    private String executionDateTime;

    private String gst;

    /**
     * Indicator of the type of transaction object present in this record
     */
    public enum TransactionUTypeEnum {
        ACCOUNT,
        ONCEOFF,
        OTHERCHARGES,
        PAYMENT
    }

    private TransactionUTypeEnum transactionUType;

    private TelcoBillingAccountTransaction account;

    private TelcoBillingOnceOffTransaction onceOff;

    private TelcoBillingOtherTransaction otherCharges;

    private TelcoBillingPaymentTransaction payment;

    public TelcoBillingTransaction accountId(String accountId) {
        this.accountId = accountId;
        return this;
    }

    /**
     * The ID of the account for which the transaction occurred. accountId must comply in accordance with [CDR ID permanence](#id-permanence)
     *
     * @return accountId
     */
    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public TelcoBillingTransaction executionDateTime(String executionDateTime) {
        this.executionDateTime = executionDateTime;
        return this;
    }

    /**
     * The date and time that the transaction occurred
     *
     * @return executionDateTime
     */
    public String getExecutionDateTime() {
        return executionDateTime;
    }

    public void setExecutionDateTime(String executionDateTime) {
        this.executionDateTime = executionDateTime;
    }

    public TelcoBillingTransaction gst(String gst) {
        this.gst = gst;
        return this;
    }

    /**
     * The GST incurred in the transaction.  Should not be included for credits or payments.  If absent zero is assumed
     *
     * @return gst
     */
    public String getGst() {
        return gst;
    }

    public void setGst(String gst) {
        this.gst = gst;
    }

    public TelcoBillingTransaction transactionUType(TransactionUTypeEnum transactionUType) {
        this.transactionUType = transactionUType;
        return this;
    }

    /**
     * Indicator of the type of transaction object present in this record
     *
     * @return transactionUType
     */
    public TransactionUTypeEnum getTransactionUType() {
        return transactionUType;
    }

    public void setTransactionUType(TransactionUTypeEnum transactionUType) {
        this.transactionUType = transactionUType;
    }

    public TelcoBillingTransaction account(TelcoBillingAccountTransaction account) {
        this.account = account;
        return this;
    }

    /**
     * Get account
     *
     * @return account
     */
    public TelcoBillingAccountTransaction getAccount() {
        return account;
    }

    public void setAccount(TelcoBillingAccountTransaction account) {
        this.account = account;
    }

    public TelcoBillingTransaction onceOff(TelcoBillingOnceOffTransaction onceOff) {
        this.onceOff = onceOff;
        return this;
    }

    /**
     * Get onceOff
     *
     * @return onceOff
     */
    public TelcoBillingOnceOffTransaction getOnceOff() {
        return onceOff;
    }

    public void setOnceOff(TelcoBillingOnceOffTransaction onceOff) {
        this.onceOff = onceOff;
    }

    public TelcoBillingTransaction otherCharges(TelcoBillingOtherTransaction otherCharges) {
        this.otherCharges = otherCharges;
        return this;
    }

    /**
     * Get otherCharges
     *
     * @return otherCharges
     */
    public TelcoBillingOtherTransaction getOtherCharges() {
        return otherCharges;
    }

    public void setOtherCharges(TelcoBillingOtherTransaction otherCharges) {
        this.otherCharges = otherCharges;
    }

    public TelcoBillingTransaction payment(TelcoBillingPaymentTransaction payment) {
        this.payment = payment;
        return this;
    }

    /**
     * Get payment
     *
     * @return payment
     */
    public TelcoBillingPaymentTransaction getPayment() {
        return payment;
    }

    public void setPayment(TelcoBillingPaymentTransaction payment) {
        this.payment = payment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TelcoBillingTransaction telcoBillingTransaction = (TelcoBillingTransaction) o;
        return Objects.equals(this.accountId, telcoBillingTransaction.accountId) &&
                Objects.equals(this.executionDateTime, telcoBillingTransaction.executionDateTime) &&
                Objects.equals(this.gst, telcoBillingTransaction.gst) &&
                Objects.equals(this.transactionUType, telcoBillingTransaction.transactionUType) &&
                Objects.equals(this.account, telcoBillingTransaction.account) &&
                Objects.equals(this.onceOff, telcoBillingTransaction.onceOff) &&
                Objects.equals(this.otherCharges, telcoBillingTransaction.otherCharges) &&
                Objects.equals(this.payment, telcoBillingTransaction.payment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, executionDateTime, gst, transactionUType, account, onceOff, otherCharges, payment);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TelcoBillingTransaction {\n");
        sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
        sb.append("    executionDateTime: ").append(toIndentedString(executionDateTime)).append("\n");
        sb.append("    gst: ").append(toIndentedString(gst)).append("\n");
        sb.append("    transactionUType: ").append(toIndentedString(transactionUType)).append("\n");
        sb.append("    account: ").append(toIndentedString(account)).append("\n");
        sb.append("    onceOff: ").append(toIndentedString(onceOff)).append("\n");
        sb.append("    otherCharges: ").append(toIndentedString(otherCharges)).append("\n");
        sb.append("    payment: ").append(toIndentedString(payment)).append("\n");
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
