package au.org.consumerdatastandards.holder.model.energy;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * EnergyBillingListResponseData
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen",
        date = "2022-01-11T14:03:27.755+11:00[Australia/Sydney]")
public class EnergyBillingListResponseData {
    @JsonProperty("transactions")
    @Valid
    private List<EnergyBillingTransaction> transactions = new ArrayList<>();

    public EnergyBillingListResponseData transactions(List<EnergyBillingTransaction> transactions) {
        this.transactions = transactions;
        return this;
    }

    public EnergyBillingListResponseData addTransactionsItem(EnergyBillingTransaction transactionsItem) {
        this.transactions.add(transactionsItem);
        return this;
    }

    /**
     * Array of transactions sorted by date and time in descending order.
     *
     * @return transactions
     */
    @ApiModelProperty(required = true,
            value = "Array of transactions sorted by date and time in descending order.")
    @NotNull

    @Valid

    public List<EnergyBillingTransaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<EnergyBillingTransaction> transactions) {
        this.transactions = transactions;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EnergyBillingListResponseData energyBillingListResponseData = (EnergyBillingListResponseData) o;
        return Objects.equals(this.transactions, energyBillingListResponseData.transactions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactions);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyBillingListResponseData {\n");

        sb.append("    transactions: ").append(toIndentedString(transactions)).append("\n");
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

