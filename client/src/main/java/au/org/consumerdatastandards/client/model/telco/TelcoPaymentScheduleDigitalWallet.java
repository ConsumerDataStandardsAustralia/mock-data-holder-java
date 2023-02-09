package au.org.consumerdatastandards.client.model.telco;

import java.util.Objects;

/**
 * Represents a regular payment from a digital wallet. Mandatory if paymentScheduleUType is set to digitalWallet
 */
public class TelcoPaymentScheduleDigitalWallet {
    private String name;

    private String identifier;

    /**
     * The type of the digital wallet identifier
     */
    public enum TypeEnum {
        EMAIL,
        CONTACT_NAME,
        TELEPHONE
    }

    private TypeEnum type;

    /**
     * The provider of the digital wallet
     */
    public enum ProviderEnum {
        PAYPAL_AU,
        OTHER
    }

    private ProviderEnum provider;

    private String paymentFrequency;

    /**
     * The mechanism by which the payment amount is calculated.  Explanation of values are as follows:<br/><ul><li>**STATIC** - Indicates a consistent, static amount, per payment</li><li>**BALANCE** - Indicates that the outstanding balance for the account is paid per period</li><li>**CALCULATED** - Indicates that the payment amount is variable and calculated using a pre-defined algorithm</li></ul>
     */
    public enum CalculationTypeEnum {
        STATIC,
        BALANCE,
        CALCULATED
    }

    private CalculationTypeEnum calculationType;

    public TelcoPaymentScheduleDigitalWallet name(String name) {
        this.name = name;
        return this;
    }

    /**
     * The name assigned to the digital wallet by the owner of the wallet, else the display name provided by the digital wallet provider
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TelcoPaymentScheduleDigitalWallet identifier(String identifier) {
        this.identifier = identifier;
        return this;
    }

    /**
     * The identifier of the digital wallet (dependent on type)
     *
     * @return identifier
     */
    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public TelcoPaymentScheduleDigitalWallet type(TypeEnum type) {
        this.type = type;
        return this;
    }

    /**
     * The type of the digital wallet identifier
     *
     * @return type
     */
    public TypeEnum getType() {
        return type;
    }

    public void setType(TypeEnum type) {
        this.type = type;
    }

    public TelcoPaymentScheduleDigitalWallet provider(ProviderEnum provider) {
        this.provider = provider;
        return this;
    }

    /**
     * The provider of the digital wallet
     *
     * @return provider
     */
    public ProviderEnum getProvider() {
        return provider;
    }

    public void setProvider(ProviderEnum provider) {
        this.provider = provider;
    }

    public TelcoPaymentScheduleDigitalWallet paymentFrequency(String paymentFrequency) {
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

    public TelcoPaymentScheduleDigitalWallet calculationType(CalculationTypeEnum calculationType) {
        this.calculationType = calculationType;
        return this;
    }

    /**
     * The mechanism by which the payment amount is calculated.  Explanation of values are as follows:<br/><ul><li>**STATIC** - Indicates a consistent, static amount, per payment</li><li>**BALANCE** - Indicates that the outstanding balance for the account is paid per period</li><li>**CALCULATED** - Indicates that the payment amount is variable and calculated using a pre-defined algorithm</li></ul>
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
        TelcoPaymentScheduleDigitalWallet telcoPaymentScheduleDigitalWallet = (TelcoPaymentScheduleDigitalWallet) o;
        return Objects.equals(this.name, telcoPaymentScheduleDigitalWallet.name) &&
                Objects.equals(this.identifier, telcoPaymentScheduleDigitalWallet.identifier) &&
                Objects.equals(this.type, telcoPaymentScheduleDigitalWallet.type) &&
                Objects.equals(this.provider, telcoPaymentScheduleDigitalWallet.provider) &&
                Objects.equals(this.paymentFrequency, telcoPaymentScheduleDigitalWallet.paymentFrequency) &&
                Objects.equals(this.calculationType, telcoPaymentScheduleDigitalWallet.calculationType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, identifier, type, provider, paymentFrequency, calculationType);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TelcoPaymentScheduleDigitalWallet {\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    identifier: ").append(toIndentedString(identifier)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    provider: ").append(toIndentedString(provider)).append("\n");
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
