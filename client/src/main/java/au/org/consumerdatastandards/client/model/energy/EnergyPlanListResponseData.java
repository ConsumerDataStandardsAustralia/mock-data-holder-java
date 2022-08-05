package au.org.consumerdatastandards.client.model.energy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * EnergyPlanListResponseData
 */
public class EnergyPlanListResponseData {
    private List<EnergyPlanEntity> plans = new ArrayList<>();

    public EnergyPlanListResponseData plans(List<EnergyPlanEntity> plans) {
        this.plans = plans;
        return this;
    }

    public EnergyPlanListResponseData addPlansItem(EnergyPlanEntity plansItem) {
        this.plans.add(plansItem);
        return this;
    }

    /**
     * Array of plans
     *
     * @return plans
     */
    public List<EnergyPlanEntity> getPlans() {
        return plans;
    }

    public void setPlans(List<EnergyPlanEntity> plans) {
        this.plans = plans;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EnergyPlanListResponseData energyPlanListResponseData = (EnergyPlanListResponseData) o;
        return Objects.equals(this.plans, energyPlanListResponseData.plans);
    }

    @Override
    public int hashCode() {
        return Objects.hash(plans);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyPlanListResponseData {\n");
        sb.append("    plans: ").append(toIndentedString(plans)).append("\n");
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
