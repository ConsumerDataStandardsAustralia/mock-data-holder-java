package au.org.consumerdatastandards.holder.model.telco;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * Represents a regular credit card payment schedule. Mandatory if paymentScheduleUType is set to cardDebit
 */
@ApiModel(description = "Represents a regular credit card payment schedule. Mandatory if paymentScheduleUType is set to cardDebit")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen",
        date = "2022-12-23T11:32:06.900+11:00[Australia/Sydney]")
public class TelcoPaymentScheduleCardDebit {
    /**
     * The type of credit card held on file
     */
    public enum CardSchemeEnum {
        VISA("VISA"),

        MASTERCARD("MASTERCARD"),

        AMEX("AMEX"),

        DINERS("DINERS"),

        OTHER("OTHER"),

        UNKNOWN("UNKNOWN");

        private String value;

        CardSchemeEnum(String value) {
            this.value = value;
        }

        @JsonValue
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        @JsonCreator
        public static CardSchemeEnum fromValue(String value) {
            for (CardSchemeEnum b : CardSchemeEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    @JsonProperty("cardScheme")
    private CardSchemeEnum cardScheme;

    @JsonProperty("paymentFrequency")
    private String paymentFrequency;

    /**
     * The mechanism by which the payment amount is calculated.  Explanation of values are as follows:<br/><ul><li>**STATIC** - Indicates a consistent, static amount, per payment</li><li>**BALANCE** - Indicates that the outstanding balance for the account is paid per period</li><li>**CALCULATED** - Indicates that the payment amount is variable and calculated using a pre-defined algorithm</li></ul>
     */
    public enum CalculationTypeEnum {
        STATIC("STATIC"),

        BALANCE("BALANCE"),

        CALCULATED("CALCULATED");

        private String value;

        CalculationTypeEnum(String value) {
            this.value = value;
        }

        @JsonValue
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        @JsonCreator
        public static CalculationTypeEnum fromValue(String value) {
            for (CalculationTypeEnum b : CalculationTypeEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    @JsonProperty("calculationType")
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
    @ApiModelProperty(required = true,
            value = "The type of credit card held on file")
    @NotNull


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
    @ApiModelProperty(required = true,
            value = "The frequency that payments will occur.  Formatted according to [ISO 8601 Durations](https://en.wikipedia.org/wiki/ISO_8601#Durations) (excludes recurrence syntax)")
    @NotNull


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
     * The mechanism by which the payment amount is calculated.  Explanation of values are as follows:<br/><ul><li>**STATIC** - Indicates a consistent, static amount, per payment</li><li>**BALANCE** - Indicates that the outstanding balance for the account is paid per period</li><li>**CALCULATED** - Indicates that the payment amount is variable and calculated using a pre-defined algorithm</li></ul>
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

