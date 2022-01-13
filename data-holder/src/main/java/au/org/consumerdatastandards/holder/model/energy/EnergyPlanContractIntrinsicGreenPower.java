package au.org.consumerdatastandards.holder.model.energy;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * Describes intrinsic green power for the plan.  If present then the plan includes a percentage of green power in the base plan. Should not be present for gas contracts
 */
@ApiModel(description = "Describes intrinsic green power for the plan.  If present then the plan includes a percentage of green power in the base plan. Should not be present for gas contracts")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen",
        date = "2022-01-11T14:03:27.755+11:00[Australia/Sydney]")
public class EnergyPlanContractIntrinsicGreenPower {
    @JsonProperty("greenPercentage")
    private String greenPercentage;

    public EnergyPlanContractIntrinsicGreenPower greenPercentage(String greenPercentage) {
        this.greenPercentage = greenPercentage;
        return this;
    }

    /**
     * Percentage of green power intrinsically included in the plan
     *
     * @return greenPercentage
     */
    @ApiModelProperty(required = true,
            value = "Percentage of green power intrinsically included in the plan")
    @NotNull


    public String getGreenPercentage() {
        return greenPercentage;
    }

    public void setGreenPercentage(String greenPercentage) {
        this.greenPercentage = greenPercentage;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EnergyPlanContractIntrinsicGreenPower energyPlanContractIntrinsicGreenPower = (EnergyPlanContractIntrinsicGreenPower) o;
        return Objects.equals(this.greenPercentage, energyPlanContractIntrinsicGreenPower.greenPercentage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(greenPercentage);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyPlanContractIntrinsicGreenPower {\n");

        sb.append("    greenPercentage: ").append(toIndentedString(greenPercentage)).append("\n");
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

