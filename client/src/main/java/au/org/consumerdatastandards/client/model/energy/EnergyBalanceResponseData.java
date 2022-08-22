package au.org.consumerdatastandards.client.model.energy;

import java.util.Objects;

/**
 * EnergyBalanceResponseData
 */
public class EnergyBalanceResponseData {
    private String balance;

    public EnergyBalanceResponseData balance(String balance) {
        this.balance = balance;
        return this;
    }

    /**
     * The current balance of the account.  A positive value indicates that amount is owing to be paid.  A negative value indicates that the account is in credit
     *
     * @return balance
     */
    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
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
        EnergyBalanceResponseData energyBalanceResponseData = (EnergyBalanceResponseData) o;
        return Objects.equals(this.balance, energyBalanceResponseData.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(balance);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyBalanceResponseData {\n");
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
