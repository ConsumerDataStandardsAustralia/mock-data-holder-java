package au.org.consumerdatastandards.holder.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;
import java.time.LocalDate;

@ApiModel(description = "Indicates that the payment is a once off payment on a specific future date. Mandatory if recurrenceUType is set to onceOff")
public class BankingScheduledPaymentRecurrenceOnceOff  {

    /**
     * The scheduled date for the once off payment
     */
    private LocalDate paymentDate;

    public BankingScheduledPaymentRecurrenceOnceOff paymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
        return this;
    }

    @ApiModelProperty(required = true, value = "The scheduled date for the once off payment")
    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BankingScheduledPaymentRecurrenceOnceOff bankingScheduledPaymentRecurrenceOnceOff = (BankingScheduledPaymentRecurrenceOnceOff) o;
        return Objects.equals(this.paymentDate, bankingScheduledPaymentRecurrenceOnceOff.paymentDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            paymentDate);
    }

    @Override
    public String toString() {
        return "class BankingScheduledPaymentRecurrenceOnceOff {\n" +
            "   paymentDate: " + toIndentedString(paymentDate) + "\n" + 
            "}";
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

