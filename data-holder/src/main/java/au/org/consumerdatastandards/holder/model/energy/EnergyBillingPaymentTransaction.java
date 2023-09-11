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
 * EnergyBillingPaymentTransaction
 */
@Entity
public class EnergyBillingPaymentTransaction {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @JsonIgnore
    private String id;

    private String amount;

    /**
     * The method of payment
     */
    public enum MethodEnum {
        DIRECT_DEBIT,
        CARD,
        TRANSFER,
        BPAY,
        CASH,
        CHEQUE,
        OTHER
    }

    private MethodEnum method;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public EnergyBillingPaymentTransaction amount(String amount) {
        this.amount = amount;
        return this;
    }

    /**
     * The amount paid
     *
     * @return amount
     */
    @ApiModelProperty(required = true, value = "The amount paid")
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
    @ApiModelProperty(required = true, value = "The method of payment")
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
