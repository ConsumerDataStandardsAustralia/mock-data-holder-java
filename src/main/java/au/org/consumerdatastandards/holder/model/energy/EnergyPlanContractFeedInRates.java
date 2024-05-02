package au.org.consumerdatastandards.holder.model.energy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * EnergyPlanContractTiers
 */
@Entity(name = "e_feed_in_rates")
public class EnergyPlanContractFeedInRates {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @JsonIgnore
    private String id;

    private String unitPrice;

    private String measureUnit;

    private String amount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * Unit price of usage per measure unit (exclusive of GST)
     *
     * @return unitPrice
     */
    @ApiModelProperty(required = true, value = "Unit price of usage per measure unit (exclusive of GST)")
    @NotNull
    public String getUnitPrice() {
        return unitPrice;
    }

    public EnergyPlanContractFeedInRates amount(String amount) {
        this.amount = amount;
        return this;
    }

    /**
     * The amount of the charge if the type implies the application of a fixed amount
     *
     * @return amount
     */
    @ApiModelProperty(value = "The amount of the charge if the type implies the application of a fixed amount")
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
        EnergyPlanContractFeedInRates energyPlanContractTiers = (EnergyPlanContractFeedInRates) o;
        return Objects.equals(this.unitPrice, energyPlanContractTiers.unitPrice) &&
                Objects.equals(this.amount, energyPlanContractTiers.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(unitPrice, amount);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyPlanContractTiers {\n");
        sb.append("    unitPrice: ").append(toIndentedString(unitPrice)).append("\n");
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
