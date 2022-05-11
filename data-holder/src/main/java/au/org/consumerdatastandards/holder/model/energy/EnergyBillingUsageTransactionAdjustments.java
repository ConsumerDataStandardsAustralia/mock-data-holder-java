package au.org.consumerdatastandards.holder.model.energy;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * EnergyBillingUsageTransactionAdjustments
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen",
        date = "2022-01-11T14:03:27.755+11:00[Australia/Sydney]")
public class EnergyBillingUsageTransactionAdjustments {
    @JsonProperty("amount")
    private String amount;

    @JsonProperty("description")
    private String description;

    public EnergyBillingUsageTransactionAdjustments amount(String amount) {
        this.amount = amount;
        return this;
    }

    /**
     * The amount of the adjustment
     *
     * @return amount
     */
    @ApiModelProperty(required = true,
            value = "The amount of the adjustment")
    @NotNull


    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public EnergyBillingUsageTransactionAdjustments description(String description) {
        this.description = description;
        return this;
    }

    /**
     * A free text description of the adjustment
     *
     * @return description
     */
    @ApiModelProperty(required = true,
            value = "A free text description of the adjustment")
    @NotNull


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EnergyBillingUsageTransactionAdjustments energyBillingUsageTransactionAdjustments = (EnergyBillingUsageTransactionAdjustments) o;
        return Objects.equals(this.amount, energyBillingUsageTransactionAdjustments.amount) &&
                Objects.equals(this.description, energyBillingUsageTransactionAdjustments.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, description);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyBillingUsageTransactionAdjustments {\n");

        sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
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

