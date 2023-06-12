package au.org.consumerdatastandards.client.model.energy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * EnergyAccountDetailV1
 */
public class EnergyAccountDetailV1 extends EnergyAccountDetailBase {

    private List<EnergyAccountDetailPlans> plans = new ArrayList<>();

    public EnergyAccountDetailV1 plans(List<EnergyAccountDetailPlans> plans) {
        this.plans = plans;
        return this;
    }

    public EnergyAccountDetailV1 addPlansItem(EnergyAccountDetailPlans plansItem) {
        this.plans.add(plansItem);
        return this;
    }

    /**
     * The array of plans containing service points and associated plan details
     *
     * @return plans
     */
    public List<EnergyAccountDetailPlans> getPlans() {
        return plans;
    }

    public void setPlans(List<EnergyAccountDetailPlans> plans) {
        this.plans = plans;
    }

    @Override
    public boolean equals(Object o) {
        if (super.equals(o)) {
            EnergyAccountDetailV1 energyAccountDetailPlanDetail = (EnergyAccountDetailV1) o;
            return Objects.equals(this.plans, energyAccountDetailPlanDetail.plans);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(plans, super.hashCode());
    }

    @Override
    protected void writeProperties(StringBuilder sb) {
        super.writeProperties(sb);
        sb.append("    plans: ").append(toIndentedString(plans)).append("\n");
    }
}
