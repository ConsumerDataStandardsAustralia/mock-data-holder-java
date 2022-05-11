package au.org.consumerdatastandards.holder.model.energy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * Required if methodUType is percentOverThreshold
 */
@ApiModel(description = "Required if methodUType is percentOverThreshold")
@Entity
public class EnergyPlanContractPercentOverThreshold {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @JsonIgnore
    private String id;

    private String rate;

    private String usageAmount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public EnergyPlanContractPercentOverThreshold rate(String rate) {
        this.rate = rate;
        return this;
    }

    /**
     * The rate of the discount over the usage amount
     *
     * @return rate
     */
    @ApiModelProperty(required = true, value = "The rate of the discount over the usage amount")
    @NotNull
    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public EnergyPlanContractPercentOverThreshold usageAmount(String usageAmount) {
        this.usageAmount = usageAmount;
        return this;
    }

    /**
     * The usage amount threshold above which the discount applies
     *
     * @return usageAmount
     */
    @ApiModelProperty(required = true, value = "The usage amount threshold above which the discount applies")
    @NotNull
    public String getUsageAmount() {
        return usageAmount;
    }

    public void setUsageAmount(String usageAmount) {
        this.usageAmount = usageAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EnergyPlanContractPercentOverThreshold energyPlanContractPercentOverThreshold = (EnergyPlanContractPercentOverThreshold) o;
        return Objects.equals(this.rate, energyPlanContractPercentOverThreshold.rate) &&
                Objects.equals(this.usageAmount, energyPlanContractPercentOverThreshold.usageAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rate, usageAmount);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyPlanContractPercentOverThreshold {\n");
        sb.append("    rate: ").append(toIndentedString(rate)).append("\n");
        sb.append("    usageAmount: ").append(toIndentedString(usageAmount)).append("\n");
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
