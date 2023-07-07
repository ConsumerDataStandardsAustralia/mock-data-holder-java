package au.org.consumerdatastandards.client.model.energy;

import java.util.Objects;

/**
 * EnergyPlanDetailV2
 */
public class EnergyPlanDetailV2 extends EnergyPlanDetailBase {

    private EnergyPlanContractFullV2 gasContract;

    private EnergyPlanContractFullV2 electricityContract;

    public EnergyPlanDetailV2 gasContract(EnergyPlanContractFullV2 gasContract) {
        this.gasContract = gasContract;
        return this;
    }

    /**
     * Get gasContract
     *
     * @return gasContract
     */
    @Override
    public EnergyPlanContractFull getGasContract() {
        return gasContract;
    }

    public void setGasContract(EnergyPlanContractFullV2 gasContract) {
        this.gasContract = gasContract;
    }

    public EnergyPlanDetailV2 electricityContract(EnergyPlanContractFullV2 electricityContract) {
        this.electricityContract = electricityContract;
        return this;
    }

    /**
     * Get electricityContract
     *
     * @return electricityContract
     */
    @Override
    public EnergyPlanContractFullV2 getElectricityContract() {
        return electricityContract;
    }

    public void setElectricityContract(EnergyPlanContractFullV2 electricityContract) {
        this.electricityContract = electricityContract;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o) &&
                Objects.equals(this.gasContract, ((EnergyPlanDetailV2)o).gasContract) &&
                Objects.equals(this.electricityContract, ((EnergyPlanDetailV2)o).electricityContract);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), gasContract, electricityContract);
    }

    @Override
    protected void writeProperties(StringBuilder sb) {
        super.writeProperties(sb);
        sb.append("    gasContract: ").append(toIndentedString(gasContract)).append("\n");
        sb.append("    electricityContract: ").append(toIndentedString(electricityContract)).append("\n");
    }
}
