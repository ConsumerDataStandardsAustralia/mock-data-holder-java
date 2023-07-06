package au.org.consumerdatastandards.client.model.telco;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * TelcoAccountListResponseData
 */
public class TelcoAccountListResponseData {
    private List<TelcoAccountResponseData> accounts = new ArrayList<>();

    public TelcoAccountListResponseData accounts(List<TelcoAccountResponseData> accounts) {
        this.accounts = accounts;
        return this;
    }

    public TelcoAccountListResponseData addAccountsItem(TelcoAccountResponseData accountsItem) {
        this.accounts.add(accountsItem);
        return this;
    }

    /**
     * Array of accounts
     *
     * @return accounts
     */
    public List<TelcoAccountResponseData> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<TelcoAccountResponseData> accounts) {
        this.accounts = accounts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TelcoAccountListResponseData telcoAccountListResponseData = (TelcoAccountListResponseData) o;
        return Objects.equals(this.accounts, telcoAccountListResponseData.accounts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accounts);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TelcoAccountListResponseData {\n");
        sb.append("    accounts: ").append(toIndentedString(accounts)).append("\n");
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
