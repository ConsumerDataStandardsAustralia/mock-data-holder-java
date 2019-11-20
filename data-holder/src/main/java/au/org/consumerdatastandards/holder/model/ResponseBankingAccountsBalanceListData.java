package au.org.consumerdatastandards.holder.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;
import java.util.List;

@ApiModel
public class ResponseBankingAccountsBalanceListData  {

    /**
     * The list of balances returned
     */
    
    private List<BankingBalance> balances;

    public ResponseBankingAccountsBalanceListData balances(List<BankingBalance> balances) {
        this.balances = balances;
        return this;
    }

    public ResponseBankingAccountsBalanceListData addItem(BankingBalance balancesItem) {
        this.balances.add(balancesItem);
        return this;
    }

    @ApiModelProperty(required = true, value = "The list of balances returned")
    public List<BankingBalance> getBalances() {
        return balances;
    }

    public void setBalances(List<BankingBalance> balances) {
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
        ResponseBankingAccountsBalanceListData responseBankingAccountsBalanceListData = (ResponseBankingAccountsBalanceListData) o;
        return Objects.equals(this.balances, responseBankingAccountsBalanceListData.balances);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            balances);
    }

    @Override
    public String toString() {
        return "class ResponseBankingAccountsBalanceListData {\n" +
            "   balances: " + toIndentedString(balances) + "\n" + 
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

