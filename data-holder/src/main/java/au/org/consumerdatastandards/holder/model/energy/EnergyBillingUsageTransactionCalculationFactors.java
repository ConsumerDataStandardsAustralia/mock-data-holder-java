package au.org.consumerdatastandards.holder.model.energy;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * EnergyBillingUsageTransactionCalculationFactors
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen",
        date = "2022-01-11T14:03:27.755+11:00[Australia/Sydney]")
public class EnergyBillingUsageTransactionCalculationFactors {
    @JsonProperty("value")
    private BigDecimal value;

    /**
     * The type of the calculation factor
     */
    public enum TypeEnum {
        DLF("DLF"),

        MLF("MLF");

        private String value;

        TypeEnum(String value) {
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
        public static TypeEnum fromValue(String value) {
            for (TypeEnum b : TypeEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    @JsonProperty("type")
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
    @ApiModelProperty(required = true,
            value = "The value of the calculation factor")
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
     * The type of the calculation factor
     *
     * @return type
     */
    @ApiModelProperty(required = true,
            value = "The type of the calculation factor")
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

