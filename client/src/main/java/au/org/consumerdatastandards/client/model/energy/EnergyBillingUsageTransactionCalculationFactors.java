package au.org.consumerdatastandards.client.model.energy;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * EnergyBillingUsageTransactionCalculationFactors
 */
public class EnergyBillingUsageTransactionCalculationFactors {
    private BigDecimal value;

    /**
     * The type of the calculation factor
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

    /**
     * The value of the calculation factor
     *
     * @return value
     */
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
     * The type of the calculation factor
     *
     * @return type
     */
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
