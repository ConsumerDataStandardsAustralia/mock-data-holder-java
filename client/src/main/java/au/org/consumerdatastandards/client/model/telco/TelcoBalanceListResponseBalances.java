package au.org.consumerdatastandards.client.model.telco;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * TelcoBalanceListResponseBalances
 */
public class TelcoBalanceListResponseBalances {
    private List<TelcoBalanceResponseData> balances = new ArrayList<>();

    public TelcoBalanceListResponseBalances balances(List<TelcoBalanceResponseData> balances) {
        this.balances = balances;
        return this;
    }

    public TelcoBalanceListResponseBalances addBalancesItem(TelcoBalanceResponseData balancesItem) {
        this.balances.add(balancesItem);
        return this;
    }

    /**
     * Array of account balances
     *
     * @return balances
     */
    public List<TelcoBalanceResponseData> getBalances() {
        return balances;
    }

    public void setBalances(List<TelcoBalanceResponseData> balances) {
        this.balances = balances;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TelcoBalanceListResponseBalances telcoBalanceListResponseBalances = (TelcoBalanceListResponseBalances) o;
        return Objects.equals(this.balances, telcoBalanceListResponseBalances.balances);
    }

    @Override
    public int hashCode() {
        return Objects.hash(balances);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TelcoBalanceListResponseBalances {\n");
        sb.append("    balances: ").append(toIndentedString(balances)).append("\n");
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
