package au.org.consumerdatastandards.holder.model.energy;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * EnergyAccountListResponseData
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen",
        date = "2022-01-11T14:03:27.755+11:00[Australia/Sydney]")
public class EnergyAccountListResponseData {
    @JsonProperty("accounts")
    @Valid
    private List<EnergyAccount> accounts = new ArrayList<>();

    public EnergyAccountListResponseData accounts(List<EnergyAccount> accounts) {
        this.accounts = accounts;
        return this;
    }

    public EnergyAccountListResponseData addAccountsItem(EnergyAccount accountsItem) {
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

    public List<EnergyAccount> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<EnergyAccount> accounts) {
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
        EnergyAccountListResponseData energyAccountListResponseData = (EnergyAccountListResponseData) o;
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

