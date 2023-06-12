package au.org.consumerdatastandards.client.model.energy;

import java.util.Objects;

/**
 * Detail on the plan applicable to this account
 */
public class EnergyAccountDetailPlanDetailV1 extends EnergyAccountDetailPlanDetailBase {

    private EnergyPlanContractV1 gasContract;

    private EnergyPlanContractV1 electricityContract;

    public EnergyAccountDetailPlanDetailBase gasContract(EnergyPlanContractV1 gasContract) {
        this.gasContract = gasContract;
        return this;
    }

    /**
     * Get gasContract
     *
     * @return gasContract
     */
    public EnergyPlanContractV1 getGasContract() {
        return gasContract;
    }

    public void setGasContract(EnergyPlanContractV1 gasContract) {
        this.gasContract = gasContract;
    }

    public EnergyAccountDetailPlanDetailBase electricityContract(EnergyPlanContractV1 electricityContract) {
        this.electricityContract = electricityContract;
        return this;
    }

    /**
     * Get electricityContract
     *
     * @return electricityContract
     */
    public EnergyPlanContractV1 getElectricityContract() {
        return electricityContract;
    }

    public void setElectricityContract(EnergyPlanContractV1 electricityContract) {
        this.electricityContract = electricityContract;
    }

    @Override
    public boolean equals(Object o) {
        if (super.equals(o)) {
            EnergyAccountDetailPlanDetailV1 energyAccountDetailPlanDetail = (EnergyAccountDetailPlanDetailV1) o;
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
