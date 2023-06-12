package au.org.consumerdatastandards.client.model.energy;

import java.util.Objects;

/**
 * EnergyPlanDetailV1
 */
public class EnergyPlanDetailV1 extends EnergyPlanDetailBase {

    private EnergyPlanContractFullV1 gasContract;

    private EnergyPlanContractFullV1 electricityContract;

    public EnergyPlanDetailV1 gasContract(EnergyPlanContractFullV1 gasContract) {
        this.gasContract = gasContract;
        return this;
    }

    /**
     * Get gasContract
     *
     * @return gasContract
     */
    @Override
    public EnergyPlanContractFullV1 getGasContract() {
        return gasContract;
    }

    public void setGasContract(EnergyPlanContractFullV1 gasContract) {
        this.gasContract = gasContract;
    }

    public EnergyPlanDetailV1 electricityContract(EnergyPlanContractFullV1 electricityContract) {
        this.electricityContract = electricityContract;
        return this;
    }

    /**
     * Get electricityContract
     *
     * @return electricityContract
     */
    @Override
    public EnergyPlanContractFullV1 getElectricityContract() {
        return electricityContract;
    }

    public void setElectricityContract(EnergyPlanContractFullV1 electricityContract) {
        this.electricityContract = electricityContract;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o) &&
                Objects.equals(this.gasContract, ((EnergyPlanDetailV1)o).gasContract) &&
                Objects.equals(this.electricityContract, ((EnergyPlanDetailV1)o).electricityContract);
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
