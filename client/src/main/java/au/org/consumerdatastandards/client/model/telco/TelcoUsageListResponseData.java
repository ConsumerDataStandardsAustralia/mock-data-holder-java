package au.org.consumerdatastandards.client.model.telco;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * TelcoUsageListResponseData
 */
public class TelcoUsageListResponseData {
    private List<TelcoAccountUsage> accounts = new ArrayList<>();

    public TelcoUsageListResponseData accounts(List<TelcoAccountUsage> accounts) {
        this.accounts = accounts;
        return this;
    }

    public TelcoUsageListResponseData addAccountsItem(TelcoAccountUsage accountsItem) {
        this.accounts.add(accountsItem);
        return this;
    }

    /**
     * Array of usage on accounts
     *
     * @return accounts
     */
    public List<TelcoAccountUsage> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<TelcoAccountUsage> accounts) {
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
        TelcoUsageListResponseData telcoUsageListResponse = (TelcoUsageListResponseData) o;
        return Objects.equals(this.accounts, telcoUsageListResponse.accounts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accounts);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TelcoUsageListResponseData {\n");
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
