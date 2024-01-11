package au.org.consumerdatastandards.client.model.energy;

import java.util.Objects;

/**
 * EnergyBillingTransactionV2
 */
public class EnergyBillingTransactionV2 extends EnergyBillingTransactionBase {

    private EnergyBillingDemandTransactionV2 demand;

    public EnergyBillingTransactionV2 demand(EnergyBillingDemandTransactionV2 demand) {
        this.demand = demand;
        return this;
    }

    /**
     * Get demand
     *
     * @return demand
     */
    public EnergyBillingDemandTransactionV2 getDemand() {
        return demand;
    }

    public void setDemand(EnergyBillingDemandTransactionV2 demand) {
        this.demand = demand;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o) && Objects.equals(this.demand, ((EnergyBillingTransactionV2)o).demand);
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
