package au.org.consumerdatastandards.holder.model.energy;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * Represents a constant tariff.  Mandatory if tariffUType is set to singleTariff
 */
@ApiModel(description = "Represents a constant tariff.  Mandatory if tariffUType is set to singleTariff")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen",
        date = "2022-01-11T14:03:27.755+11:00[Australia/Sydney]")
public class EnergyPlanContractSingleTariff {
    @JsonProperty("amount")
    private String amount;

    public EnergyPlanContractSingleTariff amount(String amount) {
        this.amount = amount;
        return this;
    }

    /**
     * The tariff amount
     *
     * @return amount
     */
    @ApiModelProperty(required = true,
            value = "The tariff amount")
    @NotNull


    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EnergyPlanContractSingleTariff energyPlanContractSingleTariff = (EnergyPlanContractSingleTariff) o;
        return Objects.equals(this.amount, energyPlanContractSingleTariff.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyPlanContractSingleTariff {\n");

        sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
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

