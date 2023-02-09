package au.org.consumerdatastandards.client.model.telco;

import java.util.Objects;

/**
 * TelcoBillingPaymentTransaction
 */
public class TelcoBillingPaymentTransaction {
    private String amount;

    /**
     * The method of payment
     */
    public enum MethodEnum {
        DIRECT_DEBIT,
        CARD,
        TRANSFER,
        BPAY,
        CASH,
        CHEQUE,
        VOUCHER,
        OTHER
    }

    private MethodEnum method;

    public TelcoBillingPaymentTransaction amount(String amount) {
        this.amount = amount;
        return this;
    }

    /**
     * The amount paid
     *
     * @return amount
     */
    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public TelcoBillingPaymentTransaction method(MethodEnum method) {
        this.method = method;
        return this;
    }

    /**
     * The method of payment
     *
     * @return method
     */
    public MethodEnum getMethod() {
        return method;
    }

    public void setMethod(MethodEnum method) {
        this.method = method;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TelcoBillingPaymentTransaction telcoBillingPaymentTransaction = (TelcoBillingPaymentTransaction) o;
        return Objects.equals(this.amount, telcoBillingPaymentTransaction.amount) &&
                Objects.equals(this.method, telcoBillingPaymentTransaction.method);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, method);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TelcoBillingPaymentTransaction {\n");
        sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
        sb.append("    method: ").append(toIndentedString(method)).append("\n");
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
