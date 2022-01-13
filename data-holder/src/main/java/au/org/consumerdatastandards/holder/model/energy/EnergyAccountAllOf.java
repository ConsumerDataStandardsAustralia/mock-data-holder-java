package au.org.consumerdatastandards.holder.model.energy;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The array of plans containing service points and associated plan details
 */
@ApiModel(description = "The array of plans containing service points and associated plan details")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen",
        date = "2022-01-11T14:03:27.755+11:00[Australia/Sydney]")
public class EnergyAccountAllOf {
    @JsonProperty("plans")
    @Valid
    private List<EnergyAccountAllOfPlans> plans = new ArrayList<>();

    public EnergyAccountAllOf plans(List<EnergyAccountAllOfPlans> plans) {
        this.plans = plans;
        return this;
    }

    public EnergyAccountAllOf addPlansItem(EnergyAccountAllOfPlans plansItem) {
        this.plans.add(plansItem);
        return this;
    }

    /**
     * The array of plans containing service points and associated plan details
     *
     * @return plans
     */
    @ApiModelProperty(required = true,
            value = "The array of plans containing service points and associated plan details")
    @NotNull

    @Valid

    public List<EnergyAccountAllOfPlans> getPlans() {
        return plans;
    }

    public void setPlans(List<EnergyAccountAllOfPlans> plans) {
        this.plans = plans;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EnergyAccountAllOf energyAccountAllOf = (EnergyAccountAllOf) o;
        return Objects.equals(this.plans, energyAccountAllOf.plans);
    }

    @Override
    public int hashCode() {
        return Objects.hash(plans);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyAccountAllOf {\n");

        sb.append("    plans: ").append(toIndentedString(plans)).append("\n");
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

