package au.org.consumerdatastandards.client.model.telco;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * TelcoTransactionListResponseData
 */
public class TelcoTransactionListResponseData {
    private List<TelcoBillingTransaction> transactions = new ArrayList<>();

    public TelcoTransactionListResponseData transactions(List<TelcoBillingTransaction> transactions) {
        this.transactions = transactions;
        return this;
    }

    public TelcoTransactionListResponseData addTransactionsItem(TelcoBillingTransaction transactionsItem) {
        this.transactions.add(transactionsItem);
        return this;
    }

    /**
     * Array of transactions sorted by date and time in descending order
     *
     * @return transactions
     */
    public List<TelcoBillingTransaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<TelcoBillingTransaction> transactions) {
        this.transactions = transactions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TelcoTransactionListResponseData telcoTransactionListResponseData = (TelcoTransactionListResponseData) o;
        return Objects.equals(this.transactions, telcoTransactionListResponseData.transactions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactions);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TelcoTransactionListResponseData {\n");
        sb.append("    transactions: ").append(toIndentedString(transactions)).append("\n");
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
