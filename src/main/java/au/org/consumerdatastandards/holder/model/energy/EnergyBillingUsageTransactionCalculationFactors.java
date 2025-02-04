package au.org.consumerdatastandards.holder.model.energy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * EnergyBillingUsageTransactionCalculationFactors
 */
@Entity(name = "e_billing_usage_trans_calc_factors")
public class EnergyBillingUsageTransactionCalculationFactors {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @JsonIgnore
    private String id;

    @Column(name = "factor_value")
    private BigDecimal value;

    /**
     * The type of the calculation factor.
     */
    public enum TypeEnum {
        DLF,
        MLF
    }

    private TypeEnum type;

    public EnergyBillingUsageTransactionCalculationFactors value(BigDecimal value) {
        this.value = value;
        return this;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * The value of the calculation factor.
     *
     * @return value
     */
    @ApiModelProperty(required = true, value = "The value of the calculation factor.")
    @NotNull
    @Valid
    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public EnergyBillingUsageTransactionCalculationFactors type(TypeEnum type) {
        this.type = type;
        return this;
    }

    /**
     * The type of the calculation factor.
     *
     * @return type
     */
    @ApiModelProperty(required = true, value = "The type of the calculation factor.")
    @NotNull
    public TypeEnum getType() {
        return type;
    }

    public void setType(TypeEnum type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EnergyBillingUsageTransactionCalculationFactors energyBillingUsageTransactionCalculationFactors = (EnergyBillingUsageTransactionCalculationFactors) o;
        return Objects.equals(this.value, energyBillingUsageTransactionCalculationFactors.value) &&
                Objects.equals(this.type, energyBillingUsageTransactionCalculationFactors.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, type);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyBillingUsageTransactionCalculationFactors {\n");
        sb.append("    value: ").append(toIndentedString(value)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
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
