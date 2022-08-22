package au.org.consumerdatastandards.client.model.energy;

import java.util.List;

public interface EnergyPlanDetail extends EnergyPlan {
    /**
     * Charges for metering included in the plan
     *
     * @return meteringCharges
     */
    List<MeteringCharges> getMeteringCharges();

    void setMeteringCharges(List<MeteringCharges> meteringCharges);

    /**
     * Get gasContract
     *
     * @return gasContract
     */
    EnergyPlanContractFull getGasContract();

    void setGasContract(EnergyPlanContractFull gasContract);

    /**
     * Get electricityContract
     *
     * @return electricityContract
     */
    EnergyPlanContractFull getElectricityContract();

    void setElectricityContract(EnergyPlanContractFull electricityContract);
}
