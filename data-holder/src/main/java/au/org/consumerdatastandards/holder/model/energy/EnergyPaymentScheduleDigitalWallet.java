package au.org.consumerdatastandards.holder.model.energy;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * Represents a regular payment from a digital wallet. Mandatory if paymentScheduleUType is set to digitalWallet
 */
@ApiModel(description = "Represents a regular payment from a digital wallet. Mandatory if paymentScheduleUType is set to digitalWallet")
public class EnergyPaymentScheduleDigitalWallet {
    private String name;

    private String identifier;

    public enum IdentifierTypeEnum {
        EMAIL, CONTACT_NAME, TELEPHONE
    }

    private IdentifierTypeEnum type;

    public enum ProviderEnum {
        PAYPAL_AU, OTHER
    }

    private ProviderEnum provider;

    private String paymentFrequency;

    enum CalculationTypeEnum {
        STATIC, BALANCE, CALCULATED
    }

    private CalculationTypeEnum calculationType;

    /**
     * The name assigned to the digital wallet by the owner of the wallet, else the display name provided by the digital wallet provider
     *
     * @return name
     */
    @ApiModelProperty(required = true,
            value = "The name assigned to the digital wallet by the owner of the wallet, else the display name provided by the digital wallet provider")
    @NotNull
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * The identifier of the digital wallet (dependent on type)
     *
     * @return identifier
     */
    @ApiModelProperty(required = true, value = "The identifier of the digital wallet (dependent on type)")
    @NotNull
    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    /**
     * The type of the digital wallet identifier
     *
     * @return type
     */
    @ApiModelProperty(required = true, value = "The type of the digital wallet identifier")
    @NotNull
    public IdentifierTypeEnum getType() {
        return type;
    }

    public void setType(IdentifierTypeEnum type) {
        this.type = type;
    }

    /**
     * The provider of the digital wallet
     *
     * @return provider
     */
    @ApiModelProperty(required = true, value = "The provider of the digital wallet")
    @NotNull
    public ProviderEnum getProvider() {
        return provider;
    }

    public void setProvider(ProviderEnum provider) {
        this.provider = provider;
    }

    /**
     * The frequency that payments will occur.  Formatted according to [ISO 8601 Durations](https://en.wikipedia.org/wiki/ISO_8601#Durations) (excludes recurrence syntax)
     *
     * @return paymentFrequency
     */
    @ApiModelProperty(required = true,
            value = "The frequency that payments will occur.  Formatted according to [ISO 8601 Durations](https://en.wikipedia.org/wiki/ISO_8601#Durations) (excludes recurrence syntax)")
    @NotNull
    public String getPaymentFrequency() {
        return paymentFrequency;
    }

    public void setPaymentFrequency(String paymentFrequency) {
        this.paymentFrequency = paymentFrequency;
    }

    /**
     * The mechanism by which the payment amount is calculated.  Explanation of values are as follows:<br><ul><li>**STATIC** - Indicates a consistent, static amount, per payment</li><li>**BALANCE** - Indicates that the outstanding balance for the account is paid per period</li><li>**CALCULATED** - Indicates that the payment amount is variable and calculated using a pre-defined algorithm</li></ul>
     *
     * @return calculationType
     */
    @ApiModelProperty(required = true,
            value = "The mechanism by which the payment amount is calculated.  Explanation of values are as follows:<br/><ul><li>**STATIC** - Indicates a consistent, static amount, per payment</li><li>**BALANCE** - Indicates that the outstanding balance for the account is paid per period</li><li>**CALCULATED** - Indicates that the payment amount is variable and calculated using a pre-defined algorithm</li></ul>")
    @NotNull
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
        EnergyPaymentScheduleDigitalWallet that = (EnergyPaymentScheduleDigitalWallet) o;
        return name.equals(that.name) &&
                identifier.equals(that.identifier) &&
                type == that.type &&
                provider == that.provider &&
                paymentFrequency.equals(that.paymentFrequency) &&
                calculationType == that.calculationType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, identifier, type, provider, paymentFrequency, calculationType);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyPaymentScheduleDigitalWallet {\n");
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
