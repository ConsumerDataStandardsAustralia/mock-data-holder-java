package au.org.consumerdatastandards.holder.model.energy;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * EnergyPlanDetailAllOf
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen",
        date = "2022-01-11T14:03:27.755+11:00[Australia/Sydney]")
public class EnergyPlanDetailAllOf {
    @JsonProperty("meteringCharges")
    @Valid
    private List<EnergyPlanDetailAllOfMeteringCharges> meteringCharges = null;

    @JsonProperty("gasContract")
    private EnergyPlanContractFull gasContract;

    @JsonProperty("electricityContract")
    private EnergyPlanContractFull electricityContract;

    public EnergyPlanDetailAllOf meteringCharges(List<EnergyPlanDetailAllOfMeteringCharges> meteringCharges) {
        this.meteringCharges = meteringCharges;
        return this;
    }

    public EnergyPlanDetailAllOf addMeteringChargesItem(EnergyPlanDetailAllOfMeteringCharges meteringChargesItem) {
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

    public EnergyPlanDetailAllOf gasContract(EnergyPlanContractFull gasContract) {
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

    public EnergyPlanDetailAllOf electricityContract(EnergyPlanContractFull electricityContract) {
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
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EnergyPlanDetailAllOf energyPlanDetailAllOf = (EnergyPlanDetailAllOf) o;
        return Objects.equals(this.meteringCharges, energyPlanDetailAllOf.meteringCharges) &&
                Objects.equals(this.gasContract, energyPlanDetailAllOf.gasContract) &&
                Objects.equals(this.electricityContract, energyPlanDetailAllOf.electricityContract);
    }

    @Override
    public int hashCode() {
        return Objects.hash(meteringCharges, gasContract, electricityContract);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyPlanDetailAllOf {\n");

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

