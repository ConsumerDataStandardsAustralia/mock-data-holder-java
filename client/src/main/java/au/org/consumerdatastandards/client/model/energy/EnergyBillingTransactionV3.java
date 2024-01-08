package au.org.consumerdatastandards.client.model.energy;

import java.util.Objects;

/**
 * EnergyBillingTransactionV3
 */
public class EnergyBillingTransactionV3 extends EnergyBillingTransactionBase {

    private EnergyBillingDemandTransactionV3 demand;

    public EnergyBillingTransactionV3 demand(EnergyBillingDemandTransactionV3 demand) {
        this.demand = demand;
        return this;
    }

    /**
     * Get demand
     *
     * @return demand
     */
    public EnergyBillingDemandTransactionV3 getDemand() {
        return demand;
    }

    public void setDemand(EnergyBillingDemandTransactionV3 demand) {
        this.demand = demand;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o) && Objects.equals(this.demand, ((EnergyBillingTransactionV3)o).demand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(demand, super.hashCode());
    }

    @Override
    protected void writeProperties(StringBuilder sb) {
        super.writeProperties(sb);
        sb.append("    demand: ").append(toIndentedString(demand)).append("\n");
    }
}
