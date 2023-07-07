package au.org.consumerdatastandards.client.model.energy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * EnergyAccountDetailV3
 */
public class EnergyAccountDetailV3 extends EnergyAccountDetailBase {

    private List<EnergyAccountDetailPlansV3> plans = new ArrayList<>();
    private OpenStatus openStatus;

    public OpenStatus getOpenStatus() {
        return openStatus;
    }

    public void setOpenStatus(OpenStatus openStatus) {
        this.openStatus = openStatus;
    }

    /**
     * The array of plans containing service points and associated plan details
     *
     * @return plans
     */
    public List<EnergyAccountDetailPlansV3> getPlans() {
        return plans;
    }

    public void setPlans(List<EnergyAccountDetailPlansV3> plans) {
        this.plans = plans;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o) &&
                Objects.equals(this.openStatus, ((EnergyAccountDetailV3)o).openStatus) &&
                Objects.equals(this.plans, ((EnergyAccountDetailV3)o).plans);
    }

    @Override
    public int hashCode() {
        return Objects.hash(openStatus, plans, super.hashCode());
    }

    @Override
    protected void writeProperties(StringBuilder sb) {
        super.writeProperties(sb);
        sb.append("    plans: ").append(toIndentedString(plans)).append("\n");
        sb.append("    openStatus: ").append(toIndentedString(openStatus)).append("\n");
    }
}
