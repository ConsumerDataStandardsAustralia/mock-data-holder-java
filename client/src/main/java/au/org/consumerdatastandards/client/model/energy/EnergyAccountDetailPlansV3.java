package au.org.consumerdatastandards.client.model.energy;

import java.util.Objects;

/**
 * EnergyAccountDetailPlansV3
 */
public class EnergyAccountDetailPlansV3 extends EnergyAccountDetailPlansBase {
    private EnergyAccountDetailPlanDetailV2 planDetail;

    /**
     * Get planDetail
     *
     * @return planDetail
     */
    public EnergyAccountDetailPlanDetailV2 getPlanDetail() {
        return planDetail;
    }

    public void setPlanDetail(EnergyAccountDetailPlanDetailV2 planDetail) {
        this.planDetail = planDetail;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o) &&
                Objects.equals(this.planDetail, ((EnergyAccountDetailPlansV3)o).planDetail);
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
