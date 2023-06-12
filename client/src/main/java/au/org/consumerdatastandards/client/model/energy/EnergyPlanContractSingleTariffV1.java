package au.org.consumerdatastandards.client.model.energy;

import java.util.Objects;

/**
 * Represents a constant tariff.  Mandatory if tariffUType is set to singleTariff
 */
public class EnergyPlanContractSingleTariffV1 {
    private String amount;

    public EnergyPlanContractSingleTariffV1 amount(String amount) {
        this.amount = amount;
        return this;
    }

    /**
     * The tariff amount
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
        EnergyPlanContractSingleTariffV1 energyPlanContractSingleTariff = (EnergyPlanContractSingleTariffV1) o;
        return Objects.equals(this.amount, energyPlanContractSingleTariff.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyPlanContractSingleTariffV1 {\n");
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
