package au.org.consumerdatastandards.client.model.energy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Detail on the plan applicable to this account
 */
public class EnergyAccountDetailPlanDetail {
    /**
     * The fuel types covered by the plan
     */
    public enum FuelTypeEnum {
        ELECTRICITY,
        GAS,
        DUAL
    }

    private FuelTypeEnum fuelType;

    private Boolean isContingentPlan = false;

    private List<MeteringCharges> meteringCharges = null;

    private EnergyPlanContract gasContract;

    private EnergyPlanContract electricityContract;

    public EnergyAccountDetailPlanDetail fuelType(FuelTypeEnum fuelType) {
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

    public EnergyAccountDetailPlanDetail isContingentPlan(Boolean isContingentPlan) {
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

    public EnergyAccountDetailPlanDetail meteringCharges(List<MeteringCharges> meteringCharges) {
        this.meteringCharges = meteringCharges;
        return this;
    }

    public EnergyAccountDetailPlanDetail addMeteringChargesItem(MeteringCharges meteringChargesItem) {
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

    public EnergyAccountDetailPlanDetail gasContract(EnergyPlanContract gasContract) {
        this.gasContract = gasContract;
        return this;
    }

    /**
     * Get gasContract
     *
     * @return gasContract
     */
    public EnergyPlanContract getGasContract() {
        return gasContract;
    }

    public void setGasContract(EnergyPlanContract gasContract) {
        this.gasContract = gasContract;
    }

    public EnergyAccountDetailPlanDetail electricityContract(EnergyPlanContract electricityContract) {
        this.electricityContract = electricityContract;
        return this;
    }

    /**
     * Get electricityContract
     *
     * @return electricityContract
     */
    public EnergyPlanContract getElectricityContract() {
        return electricityContract;
    }

    public void setElectricityContract(EnergyPlanContract electricityContract) {
        this.electricityContract = electricityContract;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EnergyAccountDetailPlanDetail energyAccountDetailPlanDetail = (EnergyAccountDetailPlanDetail) o;
        return Objects.equals(this.fuelType, energyAccountDetailPlanDetail.fuelType) &&
                Objects.equals(this.isContingentPlan, energyAccountDetailPlanDetail.isContingentPlan) &&
                Objects.equals(this.meteringCharges, energyAccountDetailPlanDetail.meteringCharges) &&
                Objects.equals(this.gasContract, energyAccountDetailPlanDetail.gasContract) &&
                Objects.equals(this.electricityContract, energyAccountDetailPlanDetail.electricityContract);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fuelType, isContingentPlan, meteringCharges, gasContract, electricityContract);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyAccountDetailAllOfPlanDetail {\n");
        sb.append("    fuelType: ").append(toIndentedString(fuelType)).append("\n");
        sb.append("    isContingentPlan: ").append(toIndentedString(isContingentPlan)).append("\n");
        sb.append("    meteringCharges: ").append(toIndentedString(meteringCharges)).append("\n");
        sb.append("    gasContract: ").append(toIndentedString(gasContract)).append("\n");
        sb.append("    electricityContract: ").append(toIndentedString(electricityContract)).append("\n");
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
