package au.org.consumerdatastandards.client.model.energy;

import java.time.OffsetDateTime;
import java.util.Objects;

public class EnergyBillingTransactionBase {
    private String accountId;
    private OffsetDateTime executionDateTime;
    private String gst;
    private TransactionUTypeEnum transactionUType;
    private EnergyBillingUsageTransaction usage;
    private EnergyBillingOnceOffTransaction onceOff;
    private EnergyBillingOtherTransaction otherCharges;
    private EnergyBillingPaymentTransaction payment;

    public EnergyBillingTransactionBase accountId(String accountId) {
        this.accountId = accountId;
        return this;
    }

    /**
     * The ID of the account for which transaction applies
     *
     * @return accountId
     */
    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public EnergyBillingTransactionBase executionDateTime(OffsetDateTime executionDateTime) {
        this.executionDateTime = executionDateTime;
        return this;
    }

    /**
     * The date and time that the transaction occurred
     *
     * @return executionDateTime
     */
    public OffsetDateTime getExecutionDateTime() {
        return executionDateTime;
    }

    public void setExecutionDateTime(OffsetDateTime executionDateTime) {
        this.executionDateTime = executionDateTime;
    }

    public EnergyBillingTransactionBase gst(String gst) {
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

    public EnergyBillingTransactionBase transactionUType(TransactionUTypeEnum transactionUType) {
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

    public EnergyBillingTransactionBase usage(EnergyBillingUsageTransaction usage) {
        this.usage = usage;
        return this;
    }

    /**
     * Get usage
     *
     * @return usage
     */
    public EnergyBillingUsageTransaction getUsage() {
        return usage;
    }

    public void setUsage(EnergyBillingUsageTransaction usage) {
        this.usage = usage;
    }

    public EnergyBillingTransactionBase onceOff(EnergyBillingOnceOffTransaction onceOff) {
        this.onceOff = onceOff;
        return this;
    }

    /**
     * Get onceOff
     *
     * @return onceOff
     */
    public EnergyBillingOnceOffTransaction getOnceOff() {
        return onceOff;
    }

    public void setOnceOff(EnergyBillingOnceOffTransaction onceOff) {
        this.onceOff = onceOff;
    }

    public EnergyBillingTransactionBase otherCharges(EnergyBillingOtherTransaction otherCharges) {
        this.otherCharges = otherCharges;
        return this;
    }

    /**
     * Get otherCharges
     *
     * @return otherCharges
     */
    public EnergyBillingOtherTransaction getOtherCharges() {
        return otherCharges;
    }

    public void setOtherCharges(EnergyBillingOtherTransaction otherCharges) {
        this.otherCharges = otherCharges;
    }

    public EnergyBillingTransactionBase payment(EnergyBillingPaymentTransaction payment) {
        this.payment = payment;
        return this;
    }

    /**
     * Get payment
     *
     * @return payment
     */
    public EnergyBillingPaymentTransaction getPayment() {
        return payment;
    }

    public void setPayment(EnergyBillingPaymentTransaction payment) {
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
        EnergyBillingTransactionBase energyBillingTransaction = (EnergyBillingTransactionBase) o;
        return Objects.equals(this.accountId, energyBillingTransaction.accountId) &&
                Objects.equals(this.executionDateTime, energyBillingTransaction.executionDateTime) &&
                Objects.equals(this.gst, energyBillingTransaction.gst) &&
                Objects.equals(this.transactionUType, energyBillingTransaction.transactionUType) &&
                Objects.equals(this.usage, energyBillingTransaction.usage) &&
                Objects.equals(this.onceOff, energyBillingTransaction.onceOff) &&
                Objects.equals(this.otherCharges, energyBillingTransaction.otherCharges) &&
                Objects.equals(this.payment, energyBillingTransaction.payment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, executionDateTime, gst, transactionUType, usage, onceOff, otherCharges, payment);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ").append(getClass().getSimpleName()).append(" {");
        writeProperties(sb);
        sb.append("}");
        return sb.toString();
    }

    protected void writeProperties(StringBuilder sb) {
        sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
        sb.append("    executionDateTime: ").append(toIndentedString(executionDateTime)).append("\n");
        sb.append("    gst: ").append(toIndentedString(gst)).append("\n");
        sb.append("    transactionUType: ").append(toIndentedString(transactionUType)).append("\n");
        sb.append("    usage: ").append(toIndentedString(usage)).append("\n");
        sb.append("    onceOff: ").append(toIndentedString(onceOff)).append("\n");
        sb.append("    otherCharges: ").append(toIndentedString(otherCharges)).append("\n");
        sb.append("    payment: ").append(toIndentedString(payment)).append("\n");
        sb.append("}");
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    protected String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

    /**
     * Indicator of the type of transaction object present in this record
     */
    public enum TransactionUTypeEnum {
        USAGE("usage"),

        DEMAND("demand"),

        ONCEOFF("onceOff"),

        OTHERCHARGES("otherCharges"),

        PAYMENT("payment");

        private final String value;

        TransactionUTypeEnum(String value) {
            this.value = value;
        }

        //        @JsonValue
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        //        @JsonCreator
        public static TransactionUTypeEnum fromValue(String value) {
            for (TransactionUTypeEnum b : EnergyBillingTransactionBase.TransactionUTypeEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }
}
