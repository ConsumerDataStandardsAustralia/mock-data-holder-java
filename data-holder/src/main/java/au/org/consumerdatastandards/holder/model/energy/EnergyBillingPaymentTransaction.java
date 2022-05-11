package au.org.consumerdatastandards.holder.model.energy;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * EnergyBillingPaymentTransaction
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen",
        date = "2022-01-11T14:03:27.755+11:00[Australia/Sydney]")
public class EnergyBillingPaymentTransaction {
    @JsonProperty("amount")
    private String amount;

    /**
     * The method of payment
     */
    public enum MethodEnum {
        DIRECT_DEBIT("DIRECT_DEBIT"),

        CARD("CARD"),

        TRANSFER("TRANSFER"),

        BPAY("BPAY"),

        CASH("CASH"),

        CHEQUE("CHEQUE"),

        OTHER("OTHER");

        private String value;

        MethodEnum(String value) {
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
        public static MethodEnum fromValue(String value) {
            for (MethodEnum b : MethodEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    @JsonProperty("method")
    private MethodEnum method;

    public EnergyBillingPaymentTransaction amount(String amount) {
        this.amount = amount;
        return this;
    }

    /**
     * The amount paid
     *
     * @return amount
     */
    @ApiModelProperty(required = true,
            value = "The amount paid")
    @NotNull


    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public EnergyBillingPaymentTransaction method(MethodEnum method) {
        this.method = method;
        return this;
    }

    /**
     * The method of payment
     *
     * @return method
     */
    @ApiModelProperty(required = true,
            value = "The method of payment")
    @NotNull


    public MethodEnum getMethod() {
        return method;
    }

    public void setMethod(MethodEnum method) {
        this.method = method;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EnergyBillingPaymentTransaction energyBillingPaymentTransaction = (EnergyBillingPaymentTransaction) o;
        return Objects.equals(this.amount, energyBillingPaymentTransaction.amount) &&
                Objects.equals(this.method, energyBillingPaymentTransaction.method);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, method);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyBillingPaymentTransaction {\n");

        sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
        sb.append("    method: ").append(toIndentedString(method)).append("\n");
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

