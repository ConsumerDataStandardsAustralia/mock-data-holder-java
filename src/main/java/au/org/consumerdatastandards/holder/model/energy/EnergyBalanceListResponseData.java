package au.org.consumerdatastandards.holder.model.energy;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * EnergyBalanceListResponseData
 */
public class EnergyBalanceListResponseData {
    @Valid
    private List<EnergyBalanceListResponseDataBalances> balances = new ArrayList<>();

    public EnergyBalanceListResponseData balances(List<EnergyBalanceListResponseDataBalances> balances) {
        this.balances = balances;
        return this;
    }

    public EnergyBalanceListResponseData addBalancesItem(EnergyBalanceListResponseDataBalances balancesItem) {
        this.balances.add(balancesItem);
        return this;
    }

    /**
     * Array of account balances.
     *
     * @return balances
     */
    @ApiModelProperty(required = true, value = "Array of account balances.")
    @NotNull
    @Valid
    public List<EnergyBalanceListResponseDataBalances> getBalances() {
        return balances;
    }

    public void setBalances(List<EnergyBalanceListResponseDataBalances> balances) {
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
        EnergyBalanceListResponseData energyBalanceListResponseData = (EnergyBalanceListResponseData) o;
        return Objects.equals(this.balances, energyBalanceListResponseData.balances);
    }

    @Override
    public int hashCode() {
        return Objects.hash(balances);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyBalanceListResponseData {\n");
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
