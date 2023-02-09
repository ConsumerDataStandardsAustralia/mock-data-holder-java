package au.org.consumerdatastandards.client.model.telco;

import java.util.Objects;

/**
 * TelcoPaymentSchedule
 */
public class TelcoPaymentSchedule {
    private String amount;

    /**
     * The type of object present in this response
     */
    public enum PaymentScheduleUTypeEnum {
        CARDDEBIT,
        DIRECTDEBIT,
        MANUALPAYMENT,
        DIGITALWALLET
    }

    private PaymentScheduleUTypeEnum paymentScheduleUType;

    private TelcoPaymentScheduleCardDebit cardDebit;

    private TelcoPaymentScheduleDirectDebit directDebit;

    private TelcoPaymentScheduleDigitalWallet digitalWallet;

    private TelcoPaymentScheduleManualPayment manualPayment;

    public TelcoPaymentSchedule amount(String amount) {
        this.amount = amount;
        return this;
    }

    /**
     * Optional payment amount indicating that a constant payment amount is scheduled to be paid (used in bill smooting scenarios)
     *
     * @return amount
     */
    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public TelcoPaymentSchedule paymentScheduleUType(PaymentScheduleUTypeEnum paymentScheduleUType) {
        this.paymentScheduleUType = paymentScheduleUType;
        return this;
    }

    /**
     * The type of object present in this response
     *
     * @return paymentScheduleUType
     */
    public PaymentScheduleUTypeEnum getPaymentScheduleUType() {
        return paymentScheduleUType;
    }

    public void setPaymentScheduleUType(PaymentScheduleUTypeEnum paymentScheduleUType) {
        this.paymentScheduleUType = paymentScheduleUType;
    }

    public TelcoPaymentSchedule cardDebit(TelcoPaymentScheduleCardDebit cardDebit) {
        this.cardDebit = cardDebit;
        return this;
    }

    /**
     * Get cardDebit
     *
     * @return cardDebit
     */
    public TelcoPaymentScheduleCardDebit getCardDebit() {
        return cardDebit;
    }

    public void setCardDebit(TelcoPaymentScheduleCardDebit cardDebit) {
        this.cardDebit = cardDebit;
    }

    public TelcoPaymentSchedule directDebit(TelcoPaymentScheduleDirectDebit directDebit) {
        this.directDebit = directDebit;
        return this;
    }

    /**
     * Get directDebit
     *
     * @return directDebit
     */
    public TelcoPaymentScheduleDirectDebit getDirectDebit() {
        return directDebit;
    }

    public void setDirectDebit(TelcoPaymentScheduleDirectDebit directDebit) {
        this.directDebit = directDebit;
    }

    public TelcoPaymentSchedule digitalWallet(TelcoPaymentScheduleDigitalWallet digitalWallet) {
        this.digitalWallet = digitalWallet;
        return this;
    }

    /**
     * Get digitalWallet
     *
     * @return digitalWallet
     */
    public TelcoPaymentScheduleDigitalWallet getDigitalWallet() {
        return digitalWallet;
    }

    public void setDigitalWallet(TelcoPaymentScheduleDigitalWallet digitalWallet) {
        this.digitalWallet = digitalWallet;
    }

    public TelcoPaymentSchedule manualPayment(TelcoPaymentScheduleManualPayment manualPayment) {
        this.manualPayment = manualPayment;
        return this;
    }

    /**
     * Get manualPayment
     *
     * @return manualPayment
     */
    public TelcoPaymentScheduleManualPayment getManualPayment() {
        return manualPayment;
    }

    public void setManualPayment(TelcoPaymentScheduleManualPayment manualPayment) {
        this.manualPayment = manualPayment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TelcoPaymentSchedule telcoPaymentSchedule = (TelcoPaymentSchedule) o;
        return Objects.equals(this.amount, telcoPaymentSchedule.amount) &&
                Objects.equals(this.paymentScheduleUType, telcoPaymentSchedule.paymentScheduleUType) &&
                Objects.equals(this.cardDebit, telcoPaymentSchedule.cardDebit) &&
                Objects.equals(this.directDebit, telcoPaymentSchedule.directDebit) &&
                Objects.equals(this.digitalWallet, telcoPaymentSchedule.digitalWallet) &&
                Objects.equals(this.manualPayment, telcoPaymentSchedule.manualPayment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, paymentScheduleUType, cardDebit, directDebit, digitalWallet, manualPayment);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TelcoPaymentSchedule {\n");
        sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
        sb.append("    paymentScheduleUType: ").append(toIndentedString(paymentScheduleUType)).append("\n");
        sb.append("    cardDebit: ").append(toIndentedString(cardDebit)).append("\n");
        sb.append("    directDebit: ").append(toIndentedString(directDebit)).append("\n");
        sb.append("    digitalWallet: ").append(toIndentedString(digitalWallet)).append("\n");
        sb.append("    manualPayment: ").append(toIndentedString(manualPayment)).append("\n");
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
