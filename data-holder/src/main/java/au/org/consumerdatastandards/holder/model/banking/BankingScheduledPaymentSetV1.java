package au.org.consumerdatastandards.holder.model.banking;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Objects;

@ApiModel(description = "The set of payment amounts and destination accounts for this payment accommodating multi-part payments. A single entry indicates a simple payment with one destination account. Must have at least one entry")
@Entity
@Table(name = "b_scheduled_payment_set")
public class BankingScheduledPaymentSetV1 implements BankingScheduledPaymentSet {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @JsonIgnore
    private String id;

    /**
     * Flag indicating whether the amount of the payment is calculated based on the context of the event. For instance a payment to reduce the balance of a credit card to zero. If absent then false is assumed
     */
    private String amount;

    /**
     * The currency for the payment. AUD assumed if not present
     */
    private String currency;

    /**
     * Flag indicating whether the amount of the payment is calculated based on the context of the event. For instance a payment to reduce the balance of a credit card to zero. If absent then false is assumed
     */
    private Boolean isAmountCalculated;

    @ManyToOne
    private BankingScheduledPaymentToV1 to;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BankingScheduledPaymentSet amount(String amount) {
        this.amount = amount;
        return this;
    }

    @Override
    @ApiModelProperty(value = "Flag indicating whether the amount of the payment is calculated based on the context of the event. For instance a payment to reduce the balance of a credit card to zero. If absent then false is assumed")
    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
    public BankingScheduledPaymentSet currency(String currency) {
        this.currency = currency;
        return this;
    }

    @Override
    @ApiModelProperty(value = "The currency for the payment. AUD assumed if not present")
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
    public BankingScheduledPaymentSet isAmountCalculated(Boolean isAmountCalculated) {
        this.isAmountCalculated = isAmountCalculated;
        return this;
    }

    @Override
    @ApiModelProperty(value = "Flag indicating whether the amount of the payment is calculated based on the context of the event. For instance a payment to reduce the balance of a credit card to zero. If absent then false is assumed")
    public Boolean getIsAmountCalculated() {
        return isAmountCalculated;
    }

    public void setIsAmountCalculated(Boolean isAmountCalculated) {
        this.isAmountCalculated = isAmountCalculated;
    }
    public BankingScheduledPaymentSet to(BankingScheduledPaymentToV1 to) {
        this.to = to;
        return this;
    }

    @ApiModelProperty(required = true)
    public BankingScheduledPaymentToV1 getTo() {
        return to;
    }

    public void setTo(BankingScheduledPaymentToV1 to) {
        this.to = to;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BankingScheduledPaymentSetV1 bankingScheduledPaymentSet = (BankingScheduledPaymentSetV1) o;
        return Objects.equals(this.id, bankingScheduledPaymentSet.id) &&
            Objects.equals(this.amount, bankingScheduledPaymentSet.amount) &&
            Objects.equals(this.currency, bankingScheduledPaymentSet.currency) &&
            Objects.equals(this.isAmountCalculated, bankingScheduledPaymentSet.isAmountCalculated) &&
            Objects.equals(this.to, bankingScheduledPaymentSet.to);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            id,
            amount,
            currency,
            isAmountCalculated,
            to);
    }

    @Override
    public String toString() {
        return "class BankingScheduledPaymentSetV1 {\n" +
            "   id: " + toIndentedString(id) + "\n" +
            "   amount: " + toIndentedString(amount) + "\n" +
            "   currency: " + toIndentedString(currency) + "\n" +
            "   isAmountCalculated: " + toIndentedString(isAmountCalculated) + "\n" + 
            "   to: " + toIndentedString(to) + "\n" + 
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

