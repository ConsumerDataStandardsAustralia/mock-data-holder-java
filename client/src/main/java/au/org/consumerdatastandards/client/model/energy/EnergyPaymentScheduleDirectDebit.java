package au.org.consumerdatastandards.client.model.energy;

import java.util.Objects;

/**
 * Represents a regular direct debit from a specified bank account. Mandatory if paymentScheduleUType is set to directDebit
 */
public class EnergyPaymentScheduleDirectDebit {
    private boolean isTokenised;

    private String bsb;

    private String accountNumber;

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

    public EnergyPaymentScheduleDirectDebit isTokenised(boolean isTokenised) {
        this.isTokenised = isTokenised;
        return this;
    }

    /**
     * Flag indicating that the account details are tokenised and cannot be shared.  False if absent.  If false then bsb and accountNumber should not be expected to be included
     *
     * @return isTokenised
     */
    public boolean getIsTokenised() {
        return isTokenised;
    }

    public void setIsTokenised(boolean isTokenised) {
        this.isTokenised = isTokenised;
    }

    public EnergyPaymentScheduleDirectDebit bsb(String bsb) {
        this.bsb = bsb;
        return this;
    }

    /**
     * The unmasked BSB for the account to be debited. Is expected to be formatted as digits only with leading zeros included and no punctuation or spaces.  Is required if isTokenised is absent or false
     *
     * @return bsb
     */
    public String getBsb() {
        return bsb;
    }

    public void setBsb(String bsb) {
        this.bsb = bsb;
    }

    public EnergyPaymentScheduleDirectDebit accountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
        return this;
    }

    /**
     * The unmasked account number for the account to be debited. Is expected to be formatted as digits only with leading zeros included and no punctuation or spaces.  Is required if isTokenised is absent or false
     *
     * @return accountNumber
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public EnergyPaymentScheduleDirectDebit paymentFrequency(String paymentFrequency) {
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

    public EnergyPaymentScheduleDirectDebit calculationType(CalculationTypeEnum calculationType) {
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
        EnergyPaymentScheduleDirectDebit energyPaymentScheduleDirectDebit = (EnergyPaymentScheduleDirectDebit) o;
        return Objects.equals(this.isTokenised, energyPaymentScheduleDirectDebit.isTokenised) &&
                Objects.equals(this.bsb, energyPaymentScheduleDirectDebit.bsb) &&
                Objects.equals(this.accountNumber, energyPaymentScheduleDirectDebit.accountNumber) &&
                Objects.equals(this.paymentFrequency, energyPaymentScheduleDirectDebit.paymentFrequency) &&
                Objects.equals(this.calculationType, energyPaymentScheduleDirectDebit.calculationType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isTokenised, bsb, accountNumber, paymentFrequency, calculationType);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyPaymentScheduleDirectDebit {\n");
        sb.append("    isTokenised: ").append(toIndentedString(isTokenised)).append("\n");
        sb.append("    bsb: ").append(toIndentedString(bsb)).append("\n");
        sb.append("    accountNumber: ").append(toIndentedString(accountNumber)).append("\n");
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
