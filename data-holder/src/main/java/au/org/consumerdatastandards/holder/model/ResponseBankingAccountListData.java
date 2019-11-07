package au.org.consumerdatastandards.holder.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;
import java.util.List;

@ApiModel
public class ResponseBankingAccountListData  {

    /**
     * The list of accounts returned. If the filter results in an empty set then this array may have no records
     */
    
    private List<BankingAccount> accounts;

    public ResponseBankingAccountListData accounts(List<BankingAccount> accounts) {
        this.accounts = accounts;
        return this;
    }

    public ResponseBankingAccountListData addItem(BankingAccount accountsItem) {
        this.accounts.add(accountsItem);
        return this;
    }

    @ApiModelProperty(required = true, value = "The list of accounts returned. If the filter results in an empty set then this array may have no records")
    public List<BankingAccount> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<BankingAccount> accounts) {
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
        ResponseBankingAccountListData responseBankingAccountListData = (ResponseBankingAccountListData) o;
        return Objects.equals(this.accounts, responseBankingAccountListData.accounts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            accounts);
    }

    @Override
    public String toString() {
        return "class ResponseBankingAccountListData {\n" +
            "   accounts: " + toIndentedString(accounts) + "\n" + 
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

