package au.org.consumerdatastandards.client.model.energy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EnergyAccountDetailPlanDetailBase {
    protected FuelTypeEnum fuelType;
    protected Boolean isContingentPlan = false;
    protected List<MeteringCharges> meteringCharges = null;

    public EnergyAccountDetailPlanDetailBase fuelType(FuelTypeEnum fuelType) {
        this.fuelType = fuelType;
        return this;
    }

    /**
     * The fuel types covered by the plan
     *
     * @return fuelType
     */
    public FuelTypeEnum getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelTypeEnum fuelType) {
        this.fuelType = fuelType;
    }

    public EnergyAccountDetailPlanDetailBase isContingentPlan(Boolean isContingentPlan) {
        this.isContingentPlan = isContingentPlan;
        return this;
    }

    /**
     * Flag that indicates that the plan is contingent on the customer taking up an alternate fuel plan from the same retailer (for instance, if the fuelType is ELECTRICITY then a GAS plan from the same retailer must be taken up). Has no meaning if the plan has a fuelType of DUAL. If absent the value is assumed to be false
     *
     * @return isContingentPlan
     */
    public Boolean getIsContingentPlan() {
        return isContingentPlan;
    }

    public void setIsContingentPlan(Boolean isContingentPlan) {
        this.isContingentPlan = isContingentPlan;
    }

    public EnergyAccountDetailPlanDetailBase meteringCharges(List<MeteringCharges> meteringCharges) {
        this.meteringCharges = meteringCharges;
        return this;
    }

    public EnergyAccountDetailPlanDetailBase addMeteringChargesItem(MeteringCharges meteringChargesItem) {
        if (this.meteringCharges == null) {
            this.meteringCharges = new ArrayList<>();
        }
        this.meteringCharges.add(meteringChargesItem);
        return this;
    }

    /**
     * Charges for metering included in the plan
     *
     * @return meteringCharges
     */
    public List<MeteringCharges> getMeteringCharges() {
        return meteringCharges;
    }

    public void setMeteringCharges(List<MeteringCharges> meteringCharges) {
        this.meteringCharges = meteringCharges;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EnergyAccountDetailPlanDetailBase energyAccountDetailPlanDetailBase = (EnergyAccountDetailPlanDetailBase) o;
        return Objects.equals(this.fuelType, energyAccountDetailPlanDetailBase.fuelType) &&
                Objects.equals(this.isContingentPlan, energyAccountDetailPlanDetailBase.isContingentPlan) &&
                Objects.equals(this.meteringCharges, energyAccountDetailPlanDetailBase.meteringCharges);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fuelType, isContingentPlan, meteringCharges);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ").append(getClass().getSimpleName()).append(" {");
        writeProperties(sb);
        sb.append("}");
        return sb.toString();
    }

    protected void writeProperties(StringBuilder sb) {
        sb.append("    fuelType: ").append(toIndentedString(fuelType)).append("\n");
        sb.append("    isContingentPlan: ").append(toIndentedString(isContingentPlan)).append("\n");
        sb.append("    meteringCharges: ").append(toIndentedString(meteringCharges)).append("\n");
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    protected String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
