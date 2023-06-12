package au.org.consumerdatastandards.client.model.energy;

import java.util.Objects;

/**
 * Represents a tariff based on time.  Mandatory if tariffUType is set to timeVaryingTariffs
 */
public class EnergyPlanContractTimeVaryingTariffsV1 extends EnergyPlanContractTimeVaryingTariffsBase {

    private String amount;

    public EnergyPlanContractTimeVaryingTariffsV1 amount(String amount) {
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
        return super.equals(o) &&
                Objects.equals(this.amount, ((EnergyPlanContractTimeVaryingTariffsV1)o).amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, super.hashCode());
    }

    @Override
    protected void writeProperties(StringBuilder sb) {
        super.writeProperties(sb);
        sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    }
}
