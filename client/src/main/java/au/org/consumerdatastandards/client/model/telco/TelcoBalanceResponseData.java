package au.org.consumerdatastandards.client.model.telco;

import java.util.Objects;

/**
 * TelcoBalanceResponseData
 */
public class TelcoBalanceResponseData {
    private String accountId;

    private TelcoBalance balance;

    public TelcoBalanceResponseData accountId(String accountId) {
        this.accountId = accountId;
        return this;
    }

    /**
     * The ID of the account. In accordance with [CDR ID permanence](#id-permanence) requirements
     *
     * @return accountId
     */
    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public TelcoBalanceResponseData balance(TelcoBalance balance) {
        this.balance = balance;
        return this;
    }

    /**
     * Get balance
     *
     * @return balance
     */
    public TelcoBalance getBalance() {
        return balance;
    }

    public void setBalance(TelcoBalance balance) {
        this.balance = balance;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TelcoBalanceResponseData telcoBalanceResponseData = (TelcoBalanceResponseData) o;
        return Objects.equals(this.accountId, telcoBalanceResponseData.accountId) &&
                Objects.equals(this.balance, telcoBalanceResponseData.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, balance);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TelcoBalanceResponseData {\n");
        sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
        sb.append("    balance: ").append(toIndentedString(balance)).append("\n");
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
