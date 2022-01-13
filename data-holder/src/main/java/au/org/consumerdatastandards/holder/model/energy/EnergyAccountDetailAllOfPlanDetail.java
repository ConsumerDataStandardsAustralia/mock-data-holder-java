package au.org.consumerdatastandards.holder.model.energy;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Detail on the plan applicable to this account
 */
@ApiModel(description = "Detail on the plan applicable to this account")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen",
        date = "2022-01-11T14:03:27.755+11:00[Australia/Sydney]")
public class EnergyAccountDetailAllOfPlanDetail {
    /**
     * The fuel types covered by the plan
     */
    public enum FuelTypeEnum {
        ELECTRICITY("ELECTRICITY"),

        GAS("GAS"),

        DUAL("DUAL");

        private String value;

        FuelTypeEnum(String value) {
            this.value = value;
        }

        @JsonValue
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        @JsonCreator
        public static FuelTypeEnum fromValue(String value) {
            for (FuelTypeEnum b : FuelTypeEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    @JsonProperty("fuelType")
    private FuelTypeEnum fuelType;

    @JsonProperty("isContingentPlan")
    private Boolean isContingentPlan = false;

    @JsonProperty("meteringCharges")
    @Valid
    private List<EnergyPlanDetailAllOfMeteringCharges> meteringCharges = null;

    @JsonProperty("gasContract")
    private EnergyPlanContract gasContract;

    @JsonProperty("electricityContract")
    private EnergyPlanContract electricityContract;

    public EnergyAccountDetailAllOfPlanDetail fuelType(FuelTypeEnum fuelType) {
        this.fuelType = fuelType;
        return this;
    }

    /**
     * The fuel types covered by the plan
     *
     * @return fuelType
     */
    @ApiModelProperty(required = true,
            value = "The fuel types covered by the plan")
    @NotNull


    public FuelTypeEnum getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelTypeEnum fuelType) {
        this.fuelType = fuelType;
    }

    public EnergyAccountDetailAllOfPlanDetail isContingentPlan(Boolean isContingentPlan) {
        this.isContingentPlan = isContingentPlan;
        return this;
    }

    /**
     * Flag that indicates that the plan is contingent on the customer taking up an alternate fuel plan from the same retailer (for instance, if the fuelType is ELECTRICITY then a GAS plan from the same retailer must be taken up). Has no meaning if the plan has a fuelType of DUAL. If absent the value is assumed to be false
     *
     * @return isContingentPlan
     */
    @ApiModelProperty(value = "Flag that indicates that the plan is contingent on the customer taking up an alternate fuel plan from the same retailer (for instance, if the fuelType is ELECTRICITY then a GAS plan from the same retailer must be taken up). Has no meaning if the plan has a fuelType of DUAL. If absent the value is assumed to be false")


    public Boolean getIsContingentPlan() {
        return isContingentPlan;
    }

    public void setIsContingentPlan(Boolean isContingentPlan) {
        this.isContingentPlan = isContingentPlan;
    }

    public EnergyAccountDetailAllOfPlanDetail meteringCharges(List<EnergyPlanDetailAllOfMeteringCharges> meteringCharges) {
        this.meteringCharges = meteringCharges;
        return this;
    }

    public EnergyAccountDetailAllOfPlanDetail addMeteringChargesItem(EnergyPlanDetailAllOfMeteringCharges meteringChargesItem) {
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

    public EnergyAccountDetailAllOfPlanDetail gasContract(EnergyPlanContract gasContract) {
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

    public EnergyPlanContract getGasContract() {
        return gasContract;
    }

    public void setGasContract(EnergyPlanContract gasContract) {
        this.gasContract = gasContract;
    }

    public EnergyAccountDetailAllOfPlanDetail electricityContract(EnergyPlanContract electricityContract) {
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
        EnergyAccountDetailAllOfPlanDetail energyAccountDetailAllOfPlanDetail = (EnergyAccountDetailAllOfPlanDetail) o;
        return Objects.equals(this.fuelType, energyAccountDetailAllOfPlanDetail.fuelType) &&
                Objects.equals(this.isContingentPlan, energyAccountDetailAllOfPlanDetail.isContingentPlan) &&
                Objects.equals(this.meteringCharges, energyAccountDetailAllOfPlanDetail.meteringCharges) &&
                Objects.equals(this.gasContract, energyAccountDetailAllOfPlanDetail.gasContract) &&
                Objects.equals(this.electricityContract, energyAccountDetailAllOfPlanDetail.electricityContract);
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

