package au.org.consumerdatastandards.client.model.energy;

import java.util.Objects;

/**
 * Required if methodUType is fixedAmount
 */
public class EnergyPlanContractFixedAmount {
    private String amount;

    public EnergyPlanContractFixedAmount amount(String amount) {
        this.amount = amount;
        return this;
    }

    /**
     * The amount of the discount
     *
     * @return amount
     */
    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EnergyPlanContractFixedAmount energyPlanContractFixedAmount = (EnergyPlanContractFixedAmount) o;
        return Objects.equals(this.amount, energyPlanContractFixedAmount.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyPlanContractFixedAmount {\n");
        sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
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
