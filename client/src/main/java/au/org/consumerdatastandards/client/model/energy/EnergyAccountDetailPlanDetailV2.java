package au.org.consumerdatastandards.client.model.energy;

import java.util.Objects;

/**
 * Detail on the plan applicable to this account
 */
public class EnergyAccountDetailPlanDetailV2 extends EnergyAccountDetailPlanDetailBase {

    private EnergyPlanContractV2 gasContract;

    private EnergyPlanContractV2 electricityContract;

    public EnergyAccountDetailPlanDetailBase gasContract(EnergyPlanContractV2 gasContract) {
        this.gasContract = gasContract;
        return this;
    }

    /**
     * Get gasContract
     *
     * @return gasContract
     */
    public EnergyPlanContractV2 getGasContract() {
        return gasContract;
    }

    public void setGasContract(EnergyPlanContractV2 gasContract) {
        this.gasContract = gasContract;
    }

    public EnergyAccountDetailPlanDetailBase electricityContract(EnergyPlanContractV2 electricityContract) {
        this.electricityContract = electricityContract;
        return this;
    }

    /**
     * Get electricityContract
     *
     * @return electricityContract
     */
    public EnergyPlanContractV2 getElectricityContract() {
        return electricityContract;
    }

    public void setElectricityContract(EnergyPlanContractV2 electricityContract) {
        this.electricityContract = electricityContract;
    }

    @Override
    public boolean equals(Object o) {
        if (super.equals(o)) {
            EnergyAccountDetailPlanDetailV2 energyAccountDetailPlanDetail = (EnergyAccountDetailPlanDetailV2) o;
            return Objects.equals(this.gasContract, energyAccountDetailPlanDetail.gasContract) &&
                    Objects.equals(this.electricityContract, energyAccountDetailPlanDetail.electricityContract);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(gasContract, electricityContract, super.hashCode());
    }

    @Override
    protected void writeProperties(StringBuilder sb) {
        super.writeProperties(sb);
        sb.append("    gasContract: ").append(toIndentedString(gasContract)).append("\n");
        sb.append("    electricityContract: ").append(toIndentedString(electricityContract)).append("\n");
    }
}
