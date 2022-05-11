package au.org.consumerdatastandards.holder.model.energy;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * EnergyBalanceListResponseDataBalances
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen",
        date = "2022-01-11T14:03:27.755+11:00[Australia/Sydney]")
public class EnergyBalanceListResponseDataBalances {
    @JsonProperty("accountId")
    private String accountId;

    @JsonProperty("balance")
    private String balance;

    public EnergyBalanceListResponseDataBalances accountId(String accountId) {
        this.accountId = accountId;
        return this;
    }

    /**
     * The ID of the account
     *
     * @return accountId
     */
    @ApiModelProperty(required = true,
            value = "The ID of the account")
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
     * The current balance of the account.  A positive value indicates that amount is owing to be paid.  A negative value indicates that the account is in credit
     *
     * @return balance
     */
    @ApiModelProperty(required = true,
            value = "The current balance of the account.  A positive value indicates that amount is owing to be paid.  A negative value indicates that the account is in credit")
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

