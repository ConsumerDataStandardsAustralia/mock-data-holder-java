package au.org.consumerdatastandards.client.model.energy;

import java.util.Objects;

/**
 * EnergyBillingPaymentTransaction
 */
public class EnergyBillingPaymentTransaction {
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
        OTHER
    }

    private MethodEnum method;

    public EnergyBillingPaymentTransaction amount(String amount) {
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

    public EnergyBillingPaymentTransaction method(MethodEnum method) {
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
        EnergyBillingPaymentTransaction energyBillingPaymentTransaction = (EnergyBillingPaymentTransaction) o;
        return Objects.equals(this.amount, energyBillingPaymentTransaction.amount) &&
                Objects.equals(this.method, energyBillingPaymentTransaction.method);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, method);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyBillingPaymentTransaction {\n");
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
