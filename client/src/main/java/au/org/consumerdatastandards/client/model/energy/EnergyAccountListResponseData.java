package au.org.consumerdatastandards.client.model.energy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * EnergyAccountListResponseData
 */
public class EnergyAccountListResponseData<T extends EnergyAccount> {
    private List<T> accounts = new ArrayList<>();

    public EnergyAccountListResponseData<T> accounts(List<T> accounts) {
        this.accounts = accounts;
        return this;
    }

    public EnergyAccountListResponseData<T> addAccountsItem(T accountsItem) {
        this.accounts.add(accountsItem);
        return this;
    }

    /**
     * Array of accounts
     *
     * @return accounts
     */
    public List<T> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<T> accounts) {
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
        EnergyAccountListResponseData<T> energyAccountListResponseData = (EnergyAccountListResponseData<T>) o;
        return Objects.equals(this.accounts, energyAccountListResponseData.accounts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accounts);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyAccountListResponseData {\n");
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
