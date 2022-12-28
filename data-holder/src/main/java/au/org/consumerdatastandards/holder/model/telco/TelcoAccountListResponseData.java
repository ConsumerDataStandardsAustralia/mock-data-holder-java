package au.org.consumerdatastandards.holder.model.telco;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * TelcoAccountListResponseData
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen",
        date = "2022-12-23T11:32:06.900+11:00[Australia/Sydney]")
public class TelcoAccountListResponseData {
    @JsonProperty("accounts")
    @Valid
    private List<TelcoAccountResponse> accounts = new ArrayList<>();

    public TelcoAccountListResponseData accounts(List<TelcoAccountResponse> accounts) {
        this.accounts = accounts;
        return this;
    }

    public TelcoAccountListResponseData addAccountsItem(TelcoAccountResponse accountsItem) {
        this.accounts.add(accountsItem);
        return this;
    }

    /**
     * Array of accounts
     *
     * @return accounts
     */
    @ApiModelProperty(required = true,
            value = "Array of accounts")
    @NotNull

    @Valid

    public List<TelcoAccountResponse> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<TelcoAccountResponse> accounts) {
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

