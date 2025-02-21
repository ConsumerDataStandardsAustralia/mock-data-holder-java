package au.org.consumerdatastandards.holder.model.energy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * EnergyBalanceListResponseDataBalances
 */
@Entity(name = "e_account_balance")
public class EnergyBalanceListResponseDataBalances {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @JsonIgnore
    private String id;

    private String accountId;

    private String balance;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public EnergyBalanceListResponseDataBalances accountId(String accountId) {
        this.accountId = accountId;
        return this;
    }

    /**
     * The ID of the account.
     *
     * @return accountId
     */
    @ApiModelProperty(required = true, value = "The ID of the account.")
    @NotNull
    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public EnergyBalanceListResponseDataBalances balance(String balance) {
        this.balance = balance;
        return this;
    }

    /**
     * The current balance of the account. A positive value indicates that amount is owing to be paid. A negative value indicates that the account is in credit.
     *
     * @return balance
     */
    @ApiModelProperty(required = true,
            value = "The current balance of the account. A positive value indicates that amount is owing to be paid. A negative value indicates that the account is in credit.")
    @NotNull
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
        EnergyBalanceListResponseDataBalances energyBalanceListResponseDataBalances = (EnergyBalanceListResponseDataBalances) o;
        return Objects.equals(this.accountId, energyBalanceListResponseDataBalances.accountId) &&
                Objects.equals(this.balance, energyBalanceListResponseDataBalances.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, balance);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyBalanceListResponseDataBalances {\n");
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
