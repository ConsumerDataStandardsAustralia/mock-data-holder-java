package au.org.consumerdatastandards.holder.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.Objects;
import java.util.List;

@ApiModel
@Entity
public class BankingScheduledPayment  {

    /**
     * A unique ID of the scheduled payment adhering to the standards for ID permanence
     */
    @Id
    private String scheduledPaymentId;

    @Embedded
    private BankingScheduledPaymentFrom from;

    /**
     * The short display name of the payee as provided by the customer
     */
    private String nickname;

    /**
     * The reference for the transaction that will be provided by the originating institution. Empty string if no data provided
     */
    private String payeeReference;

    /**
     * The reference for the transaction that will be used by the originating institution for the purposes of constructing a statement narrative on the payer’s account. Empty string if no data provided
     */
    private String payerReference;

    @OneToMany
    @JoinTable(
        name = "banking_scheduled_payment_sets",
        joinColumns = @JoinColumn(name = "scheduled_payment_id"),
        inverseJoinColumns = @JoinColumn(name = "payment_set_id"))
    private List<BankingScheduledPaymentSet> paymentSet;

    @ManyToOne
    private BankingScheduledPaymentRecurrence recurrence;

    private Status status;

    public BankingScheduledPayment from(BankingScheduledPaymentFrom from) {
        this.from = from;
        return this;
    }

    @ApiModelProperty(required = true)
    public BankingScheduledPaymentFrom getFrom() {
        return from;
    }

    public void setFrom(BankingScheduledPaymentFrom from) {
        this.from = from;
    }
    public BankingScheduledPayment nickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    @ApiModelProperty(value = "The short display name of the payee as provided by the customer")
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public BankingScheduledPayment payeeReference(String payeeReference) {
        this.payeeReference = payeeReference;
        return this;
    }

    @ApiModelProperty(required = true, value = "The reference for the transaction that will be provided by the originating institution. Empty string if no data provided")
    public String getPayeeReference() {
        return payeeReference;
    }

    public void setPayeeReference(String payeeReference) {
        this.payeeReference = payeeReference;
    }
    public BankingScheduledPayment payerReference(String payerReference) {
        this.payerReference = payerReference;
        return this;
    }

    @ApiModelProperty(required = true, value = "The reference for the transaction that will be used by the originating institution for the purposes of constructing a statement narrative on the payer’s account. Empty string if no data provided")
    public String getPayerReference() {
        return payerReference;
    }

    public void setPayerReference(String payerReference) {
        this.payerReference = payerReference;
    }
    public BankingScheduledPayment paymentSet(List<BankingScheduledPaymentSet> paymentSet) {
        this.paymentSet = paymentSet;
        return this;
    }

    public BankingScheduledPayment addItem(BankingScheduledPaymentSet paymentSetItem) {
        this.paymentSet.add(paymentSetItem);
        return this;
    }

    @ApiModelProperty(required = true)
    public List<BankingScheduledPaymentSet> getPaymentSet() {
        return paymentSet;
    }

    public void setPaymentSet(List<BankingScheduledPaymentSet> paymentSet) {
        this.paymentSet = paymentSet;
    }
    public BankingScheduledPayment recurrence(BankingScheduledPaymentRecurrence recurrence) {
        this.recurrence = recurrence;
        return this;
    }

    @ApiModelProperty(required = true)
    public BankingScheduledPaymentRecurrence getRecurrence() {
        return recurrence;
    }

    public void setRecurrence(BankingScheduledPaymentRecurrence recurrence) {
        this.recurrence = recurrence;
    }
    public BankingScheduledPayment scheduledPaymentId(String scheduledPaymentId) {
        this.scheduledPaymentId = scheduledPaymentId;
        return this;
    }

    @ApiModelProperty(required = true, value = "A unique ID of the scheduled payment adhering to the standards for ID permanence")
    public String getScheduledPaymentId() {
        return scheduledPaymentId;
    }

    public void setScheduledPaymentId(String scheduledPaymentId) {
        this.scheduledPaymentId = scheduledPaymentId;
    }
    public BankingScheduledPayment status(Status status) {
        this.status = status;
        return this;
    }

    @ApiModelProperty(required = true)
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BankingScheduledPayment bankingScheduledPayment = (BankingScheduledPayment) o;
        return Objects.equals(this.from, bankingScheduledPayment.from) &&
            Objects.equals(this.nickname, bankingScheduledPayment.nickname) &&
            Objects.equals(this.payeeReference, bankingScheduledPayment.payeeReference) &&
            Objects.equals(this.payerReference, bankingScheduledPayment.payerReference) &&
            Objects.equals(this.paymentSet, bankingScheduledPayment.paymentSet) &&
            Objects.equals(this.recurrence, bankingScheduledPayment.recurrence) &&
            Objects.equals(this.scheduledPaymentId, bankingScheduledPayment.scheduledPaymentId) &&
            Objects.equals(this.status, bankingScheduledPayment.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            from,
            nickname,
            payeeReference,
            payerReference,
            paymentSet,
            recurrence,
            scheduledPaymentId,
            status);
    }

    @Override
    public String toString() {
        return "class BankingScheduledPayment {\n" +
            "   from: " + toIndentedString(from) + "\n" + 
            "   nickname: " + toIndentedString(nickname) + "\n" + 
            "   payeeReference: " + toIndentedString(payeeReference) + "\n" + 
            "   payerReference: " + toIndentedString(payerReference) + "\n" + 
            "   paymentSet: " + toIndentedString(paymentSet) + "\n" + 
            "   recurrence: " + toIndentedString(recurrence) + "\n" + 
            "   scheduledPaymentId: " + toIndentedString(scheduledPaymentId) + "\n" + 
            "   status: " + toIndentedString(status) + "\n" + 
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

    public enum Status {
        ACTIVE,
        INACTIVE,
        SKIP
    }
}

