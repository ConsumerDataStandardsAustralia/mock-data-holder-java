package au.org.consumerdatastandards.holder.model.energy;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * EnergyPlanDetail
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen",
        date = "2022-01-11T14:03:27.755+11:00[Australia/Sydney]")
public class EnergyPlanDetail extends EnergyPlan {
    @Valid
    private List<EnergyPlanDetailAllOfMeteringCharges> meteringCharges;

    @JsonProperty("gasContract")
    private EnergyPlanContractFull gasContract;

    @JsonProperty("electricityContract")
    private EnergyPlanContractFull electricityContract;

    public EnergyPlanDetail meteringCharges(List<EnergyPlanDetailAllOfMeteringCharges> meteringCharges) {
        this.meteringCharges = meteringCharges;
        return this;
    }

    public EnergyPlanDetail addMeteringChargesItem(EnergyPlanDetailAllOfMeteringCharges meteringChargesItem) {
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
    @ApiModelProperty(value = "Charges for metering included in the plan")
    @Valid
    public List<EnergyPlanDetailAllOfMeteringCharges> getMeteringCharges() {
        return meteringCharges;
    }

    public void setMeteringCharges(List<EnergyPlanDetailAllOfMeteringCharges> meteringCharges) {
        this.meteringCharges = meteringCharges;
    }

    public EnergyPlanDetail gasContract(EnergyPlanContractFull gasContract) {
        this.gasContract = gasContract;
        return this;
    }

    /**
     * Get gasContract
     *
     * @return gasContract
     */
    @ApiModelProperty(value = "")
    @Valid
    public EnergyPlanContractFull getGasContract() {
        return gasContract;
    }

    public void setGasContract(EnergyPlanContractFull gasContract) {
        this.gasContract = gasContract;
    }

    public EnergyPlanDetail electricityContract(EnergyPlanContractFull electricityContract) {
        this.electricityContract = electricityContract;
        return this;
    }

    /**
     * Get electricityContract
     *
     * @return electricityContract
     */
    @ApiModelProperty(value = "")
    @Valid
    public EnergyPlanContractFull getElectricityContract() {
        return electricityContract;
    }

    public void setElectricityContract(EnergyPlanContractFull electricityContract) {
        this.electricityContract = electricityContract;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        EnergyPlanDetail energyPlanDetail = (EnergyPlanDetail) o;
        return Objects.equals(this.meteringCharges, energyPlanDetail.meteringCharges) &&
                Objects.equals(this.gasContract, energyPlanDetail.gasContract) &&
                Objects.equals(this.electricityContract, energyPlanDetail.electricityContract);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), meteringCharges, gasContract, electricityContract);
    }

    protected void toStringFields(StringBuilder sb) {
        super.toStringFields(sb);
        sb.append("    meteringCharges: ").append(toIndentedString(meteringCharges)).append("\n");
        sb.append("    gasContract: ").append(toIndentedString(gasContract)).append("\n");
        sb.append("    electricityContract: ").append(toIndentedString(electricityContract)).append("\n");
    }
}
