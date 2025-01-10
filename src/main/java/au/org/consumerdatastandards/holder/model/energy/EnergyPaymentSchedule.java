package au.org.consumerdatastandards.holder.model.energy;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * EnergyPaymentSchedule
 */
@Entity
public class EnergyPaymentSchedule {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @JsonIgnore
    private String id;

    private String amount;

    /**
     * The type of object present in this response.
     */
    public enum PaymentScheduleUTypeEnum {
        CARDDEBIT("cardDebit"),

        DIRECTDEBIT("directDebit"),

        MANUALPAYMENT("manualPayment"),

        DIGITALWALLET("digitalWallet");

        private final String value;

        PaymentScheduleUTypeEnum(String value) {
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
        public static PaymentScheduleUTypeEnum fromValue(String value) {
            for (PaymentScheduleUTypeEnum b : PaymentScheduleUTypeEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    private PaymentScheduleUTypeEnum paymentScheduleUType;

    @OneToOne(cascade = CascadeType.ALL)
    private EnergyPaymentScheduleCardDebit cardDebit;

    @OneToOne(cascade = CascadeType.ALL)
    private EnergyPaymentScheduleDirectDebit directDebit;

    @OneToOne(cascade = CascadeType.ALL)
    private EnergyPaymentScheduleDigitalWallet digitalWallet;

    @OneToOne(cascade = CascadeType.ALL)
    private EnergyPaymentScheduleManualPayment manualPayment;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public EnergyPaymentSchedule amount(String amount) {
        this.amount = amount;
        return this;
    }

    /**
     * Optional payment amount indicating that a constant payment amount is scheduled to be paid (used in bill smoothing scenarios).
     *
     * @return amount
     */
    @ApiModelProperty(value = "Optional payment amount indicating that a constant payment amount is scheduled to be paid (used in bill smoothing scenarios).")
    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public EnergyPaymentSchedule paymentScheduleUType(PaymentScheduleUTypeEnum paymentScheduleUType) {
        this.paymentScheduleUType = paymentScheduleUType;
        return this;
    }

    /**
     * The type of object present in this response.
     *
     * @return paymentScheduleUType
     */
    @ApiModelProperty(required = true, value = "The type of object present in this response.")
    @NotNull
    public PaymentScheduleUTypeEnum getPaymentScheduleUType() {
        return paymentScheduleUType;
    }

    public void setPaymentScheduleUType(PaymentScheduleUTypeEnum paymentScheduleUType) {
        this.paymentScheduleUType = paymentScheduleUType;
    }

    public EnergyPaymentSchedule cardDebit(EnergyPaymentScheduleCardDebit cardDebit) {
        this.cardDebit = cardDebit;
        return this;
    }

    /**
     * Represents a regular credit card payment schedule. Mandatory if paymentScheduleUType is set to cardDebit
     *
     * @return cardDebit
     */
    @ApiModelProperty(value = "Represents a regular credit card payment schedule. Mandatory if paymentScheduleUType is set to cardDebit")
    @Valid
    public EnergyPaymentScheduleCardDebit getCardDebit() {
        return cardDebit;
    }

    public void setCardDebit(EnergyPaymentScheduleCardDebit cardDebit) {
        this.cardDebit = cardDebit;
    }

    public EnergyPaymentSchedule directDebit(EnergyPaymentScheduleDirectDebit directDebit) {
        this.directDebit = directDebit;
        return this;
    }

    /**
     * Represents a regular direct debit from a specified bank account. Mandatory if paymentScheduleUType is set to directDebit
     *
     * @return directDebit
     */
    @ApiModelProperty(value = "Represents a regular direct debit from a specified bank account. Mandatory if paymentScheduleUType is set to directDebit")
    @Valid
    public EnergyPaymentScheduleDirectDebit getDirectDebit() {
        return directDebit;
    }

    public void setDirectDebit(EnergyPaymentScheduleDirectDebit directDebit) {
        this.directDebit = directDebit;
    }

    /**
     * Represents a regular payment from a digital wallet. Mandatory if paymentScheduleUType is set to digitalWallet
     *
     * @return digitalWallet
     */
    public EnergyPaymentScheduleDigitalWallet getDigitalWallet() {
        return digitalWallet;
    }

    public void setDigitalWallet(EnergyPaymentScheduleDigitalWallet digitalWallet) {
        this.digitalWallet = digitalWallet;
    }

    public EnergyPaymentSchedule manualPayment(EnergyPaymentScheduleManualPayment manualPayment) {
        this.manualPayment = manualPayment;
        return this;
    }

    /**
     * Represents a manual payment schedule where the customer pays in response to a delivered statement. Mandatory if paymentScheduleUType is set to manualPayment
     *
     * @return manualPayment
     */
    @ApiModelProperty(value = "Represents a manual payment schedule where the customer pays in response to a delivered statement. Mandatory if paymentScheduleUType is set to manualPayment")
    @Valid
    public EnergyPaymentScheduleManualPayment getManualPayment() {
        return manualPayment;
    }

    public void setManualPayment(EnergyPaymentScheduleManualPayment manualPayment) {
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
        EnergyPaymentSchedule energyPaymentSchedule = (EnergyPaymentSchedule) o;
        return Objects.equals(this.amount, energyPaymentSchedule.amount) &&
                Objects.equals(this.paymentScheduleUType, energyPaymentSchedule.paymentScheduleUType) &&
                Objects.equals(this.cardDebit, energyPaymentSchedule.cardDebit) &&
                Objects.equals(this.directDebit, energyPaymentSchedule.directDebit) &&
                Objects.equals(this.digitalWallet, energyPaymentSchedule.digitalWallet) &&
                Objects.equals(this.manualPayment, energyPaymentSchedule.manualPayment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, paymentScheduleUType, cardDebit, directDebit, digitalWallet, manualPayment);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyPaymentSchedule {\n");
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
