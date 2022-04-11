package au.org.consumerdatastandards.holder.model.energy;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public interface EnergyPlanDetail extends EnergyPlan {
    /**
     * Charges for metering included in the plan
     *
     * @return meteringCharges
     */
    @ApiModelProperty(value = "Charges for metering included in the plan")
    List<MeteringCharges> getMeteringCharges();

    void setMeteringCharges(List<MeteringCharges> meteringCharges);

    /**
     * Get gasContract
     *
     * @return gasContract
     */
    @ApiModelProperty(value = "")
    EnergyPlanContractFull getGasContract();

    void setGasContract(EnergyPlanContractFull gasContract);

    /**
     * Get electricityContract
     *
     * @return electricityContract
     */
    @ApiModelProperty(value = "")
    EnergyPlanContractFull getElectricityContract();

    void setElectricityContract(EnergyPlanContractFull electricityContract);
}
