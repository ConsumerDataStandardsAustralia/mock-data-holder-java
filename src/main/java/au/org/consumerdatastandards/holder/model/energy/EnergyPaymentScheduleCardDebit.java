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
 * Represents a regular credit card payment schedule. Mandatory if _paymentScheduleUType_ is set to `cardDebit`.
 */
@Entity
public class EnergyPaymentScheduleCardDebit {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @JsonIgnore
    private String id;

    /**
     * The type of credit card held on file.
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
     * The mechanism by which the payment amount is calculated. Explanation of values are as follows:<br><ul><li>`STATIC`: Indicates a consistent, static amount, per payment</li><li>`BALANCE`: Indicates that the outstanding balance for the account is paid per period</li><li>`CALCULATED`: Indicates that the payment amount is variable and calculated using a pre-defined algorithm.</li></ul>
     */
    public enum CalculationTypeEnum {
        STATIC,
        BALANCE,
        CALCULATED
    }

    private CalculationTypeEnum calculationType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public EnergyPaymentScheduleCardDebit cardScheme(CardSchemeEnum cardScheme) {
        this.cardScheme = cardScheme;
        return this;
    }

    /**
     * The type of credit card held on file.
     *
     * @return cardScheme
     */
    @ApiModelProperty(required = true, value = "The type of credit card held on file.")
    @NotNull
    public CardSchemeEnum getCardScheme() {
        return cardScheme;
    }

    public void setCardScheme(CardSchemeEnum cardScheme) {
        this.cardScheme = cardScheme;
    }

    public EnergyPaymentScheduleCardDebit paymentFrequency(String paymentFrequency) {
        this.paymentFrequency = paymentFrequency;
        return this;
    }

    /**
     * The frequency that payments will occur. Formatted according to [ISO 8601 Durations](https://en.wikipedia.org/wiki/ISO_8601#Durations) (excludes recurrence syntax).
     *
     * @return paymentFrequency
     */
    @ApiModelProperty(required = true,
            value = "The frequency that payments will occur. Formatted according to [ISO 8601 Durations](https://en.wikipedia.org/wiki/ISO_8601#Durations) (excludes recurrence syntax).")
    @NotNull
    public String getPaymentFrequency() {
        return paymentFrequency;
    }

    public void setPaymentFrequency(String paymentFrequency) {
        this.paymentFrequency = paymentFrequency;
    }

    public EnergyPaymentScheduleCardDebit calculationType(CalculationTypeEnum calculationType) {
        this.calculationType = calculationType;
        return this;
    }

    /**
     * The mechanism by which the payment amount is calculated. Explanation of values are as follows:<br><ul><li>`STATIC`: Indicates a consistent, static amount, per payment</li><li>`BALANCE`: Indicates that the outstanding balance for the account is paid per period</li><li>`CALCULATED`: Indicates that the payment amount is variable and calculated using a pre-defined algorithm.</li></ul>
     *
     * @return calculationType
     */
    @ApiModelProperty(required = true,
            value = "The mechanism by which the payment amount is calculated. Explanation of values are as follows:<br/><ul><li>`STATIC`: Indicates a consistent, static amount, per payment</li><li>`BALANCE`: Indicates that the outstanding balance for the account is paid per period</li><li>`CALCULATED`: Indicates that the payment amount is variable and calculated using a pre-defined algorithm.</li></ul>")
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
        EnergyPaymentScheduleCardDebit energyPaymentScheduleCardDebit = (EnergyPaymentScheduleCardDebit) o;
        return Objects.equals(this.cardScheme, energyPaymentScheduleCardDebit.cardScheme) &&
                Objects.equals(this.paymentFrequency, energyPaymentScheduleCardDebit.paymentFrequency) &&
                Objects.equals(this.calculationType, energyPaymentScheduleCardDebit.calculationType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardScheme, paymentFrequency, calculationType);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyPaymentScheduleCardDebit {\n");
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
