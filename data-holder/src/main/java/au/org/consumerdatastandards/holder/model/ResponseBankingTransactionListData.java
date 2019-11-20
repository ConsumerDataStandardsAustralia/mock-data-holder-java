package au.org.consumerdatastandards.holder.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;
import java.util.List;

@ApiModel
public class ResponseBankingTransactionListData  {

    /**
     * Get transactions
     */
    
    private List<BankingTransaction> transactions;

    public ResponseBankingTransactionListData transactions(List<BankingTransaction> transactions) {
        this.transactions = transactions;
        return this;
    }

    public ResponseBankingTransactionListData addItem(BankingTransaction transactionsItem) {
        this.transactions.add(transactionsItem);
        return this;
    }

    @ApiModelProperty(required = true)
    public List<BankingTransaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<BankingTransaction> transactions) {
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
        ResponseBankingTransactionListData responseBankingTransactionListData = (ResponseBankingTransactionListData) o;
        return Objects.equals(this.transactions, responseBankingTransactionListData.transactions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            transactions);
    }

    @Override
    public String toString() {
        return "class ResponseBankingTransactionListData {\n" +
            "   transactions: " + toIndentedString(transactions) + "\n" + 
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

