package au.org.consumerdatastandards.client.model.energy;

import java.util.Objects;

/**
 * EnergyAccountDetailPlans
 */
public class EnergyAccountDetailPlans extends EnergyAccountDetailPlansBase {

    private EnergyAccountDetailPlanDetailV1 planDetail;

    public EnergyAccountDetailPlans planDetail(EnergyAccountDetailPlanDetailV1 planDetail) {
        this.planDetail = planDetail;
        return this;
    }

    /**
     * Get planDetail
     *
     * @return planDetail
     */
    public EnergyAccountDetailPlanDetailV1 getPlanDetail() {
        return planDetail;
    }

    public void setPlanDetail(EnergyAccountDetailPlanDetailV1 planDetail) {
        this.planDetail = planDetail;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o) &&
                Objects.equals(this.planDetail, ((EnergyAccountDetailPlans)o).planDetail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(planDetail, super.hashCode());
    }

    @Override
    protected void writeProperties(StringBuilder sb) {
        super.writeProperties(sb);
        sb.append("    planDetail: ").append(toIndentedString(planDetail)).append("\n");
    }
}
