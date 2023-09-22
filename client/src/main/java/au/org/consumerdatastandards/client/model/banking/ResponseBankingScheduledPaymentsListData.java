/*
 * Consumer Data Standards
 * Sample client library to Demonstrate the Consumer Data Right APIs
 *
 * NOTE: This class is auto generated
 */
package au.org.consumerdatastandards.client.model.banking;

import java.util.List;
import java.util.Objects;

public class ResponseBankingScheduledPaymentsListData<T extends BankingScheduledPaymentTo> {

    private List<BankingScheduledPayment<T>> scheduledPayments;

    /**
     * The list of scheduled payments to return
     * @return scheduledPayments
     */
    public List<BankingScheduledPayment<T>> getScheduledPayments() {
        return scheduledPayments;
    }

    public void setScheduledPayments(List<BankingScheduledPayment<T>> scheduledPayments) {
        this.scheduledPayments = scheduledPayments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ResponseBankingScheduledPaymentsListData<T> responseBankingScheduledPaymentsListData = (ResponseBankingScheduledPaymentsListData<T>) o;
        return Objects.equals(this.scheduledPayments, responseBankingScheduledPaymentsListData.scheduledPayments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            scheduledPayments);
    }

    @Override
    public String toString() {
        return "class ResponseBankingScheduledPaymentsListData {\n" +
            "   scheduledPayments: " + toIndentedString(scheduledPayments) + "\n" + 
            "}";
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
