package au.org.consumerdatastandards.client.model.telco;

import java.util.Objects;

/**
 * Represents a regular credit card payment schedule. Mandatory if paymentScheduleUType is set to cardDebit
 */
public class TelcoPaymentScheduleCardDebit {
    /**
     * The type of credit card held on file
     */
    public enum CardSchemeEnum {
        VISA,
        MASTERCARD,
        AMEX,
        DINERS,
        OTHER,
        UNKNOWN
    }

    private CardSchemeEnum cardScheme;

    private String paymentFrequency;

    /**
     * The mechanism by which the payment amount is calculated.  Explanation of values are as follows:<br><ul><li>**STATIC** - Indicates a consistent, static amount, per payment</li><li>**BALANCE** - Indicates that the outstanding balance for the account is paid per period</li><li>**CALCULATED** - Indicates that the payment amount is variable and calculated using a pre-defined algorithm</li></ul>
     */
    public enum CalculationTypeEnum {
        STATIC,
        BALANCE,
        CALCULATED
    }

    private CalculationTypeEnum calculationType;

    public TelcoPaymentScheduleCardDebit cardScheme(CardSchemeEnum cardScheme) {
        this.cardScheme = cardScheme;
        return this;
    }

    /**
     * The type of credit card held on file
     *
     * @return cardScheme
     */
    public CardSchemeEnum getCardScheme() {
        return cardScheme;
    }

    public void setCardScheme(CardSchemeEnum cardScheme) {
        this.cardScheme = cardScheme;
    }

    public TelcoPaymentScheduleCardDebit paymentFrequency(String paymentFrequency) {
        this.paymentFrequency = paymentFrequency;
        return this;
    }

    /**
     * The frequency that payments will occur.  Formatted according to [ISO 8601 Durations](https://en.wikipedia.org/wiki/ISO_8601#Durations) (excludes recurrence syntax)
     *
     * @return paymentFrequency
     */
    public String getPaymentFrequency() {
        return paymentFrequency;
    }

    public void setPaymentFrequency(String paymentFrequency) {
        this.paymentFrequency = paymentFrequency;
    }

    public TelcoPaymentScheduleCardDebit calculationType(CalculationTypeEnum calculationType) {
        this.calculationType = calculationType;
        return this;
    }

    /**
     * The mechanism by which the payment amount is calculated.  Explanation of values are as follows:<br><ul><li>**STATIC** - Indicates a consistent, static amount, per payment</li><li>**BALANCE** - Indicates that the outstanding balance for the account is paid per period</li><li>**CALCULATED** - Indicates that the payment amount is variable and calculated using a pre-defined algorithm</li></ul>
     *
     * @return calculationType
     */
    public CalculationTypeEnum getCalculationType() {
        return calculationType;
    }

    public void setCalculationType(CalculationTypeEnum calculationType) {
        this.calculationType = calculationType;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TelcoPaymentScheduleCardDebit telcoPaymentScheduleCardDebit = (TelcoPaymentScheduleCardDebit) o;
        return Objects.equals(this.cardScheme, telcoPaymentScheduleCardDebit.cardScheme) &&
                Objects.equals(this.paymentFrequency, telcoPaymentScheduleCardDebit.paymentFrequency) &&
                Objects.equals(this.calculationType, telcoPaymentScheduleCardDebit.calculationType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardScheme, paymentFrequency, calculationType);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TelcoPaymentScheduleCardDebit {\n");
        sb.append("    cardScheme: ").append(toIndentedString(cardScheme)).append("\n");
        sb.append("    paymentFrequency: ").append(toIndentedString(paymentFrequency)).append("\n");
        sb.append("    calculationType: ").append(toIndentedString(calculationType)).append("\n");
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
