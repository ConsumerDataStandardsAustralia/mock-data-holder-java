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
 * Required if methodUType is percentOfUse
 */
@ApiModel(description = "Required if methodUType is percentOfUse")
@Entity
public class EnergyPlanContractPercentOfUse {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @JsonIgnore
    private String id;

    private String rate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public EnergyPlanContractPercentOfUse rate(String rate) {
        this.rate = rate;
        return this;
    }

    /**
     * The rate of the discount applied to the usageamount
     *
     * @return rate
     */
    @ApiModelProperty(required = true, value = "The rate of the discount applied to the usageamount")
    @NotNull
    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EnergyPlanContractPercentOfUse energyPlanContractPercentOfUse = (EnergyPlanContractPercentOfUse) o;
        return Objects.equals(this.rate, energyPlanContractPercentOfUse.rate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rate);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyPlanContractPercentOfUse {\n");
        sb.append("    rate: ").append(toIndentedString(rate)).append("\n");
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
