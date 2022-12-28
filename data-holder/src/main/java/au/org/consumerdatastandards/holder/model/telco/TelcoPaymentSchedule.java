package au.org.consumerdatastandards.holder.model.telco;

import java.util.Objects;
import au.org.consumerdatastandards.holder.model.telco.TelcoPaymentScheduleCardDebit;
import au.org.consumerdatastandards.holder.model.telco.TelcoPaymentScheduleDigitalWallet;
import au.org.consumerdatastandards.holder.model.telco.TelcoPaymentScheduleDirectDebit;
import au.org.consumerdatastandards.holder.model.telco.TelcoPaymentScheduleManualPayment;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * TelcoPaymentSchedule
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-12-23T11:32:06.900+11:00[Australia/Sydney]")
public class TelcoPaymentSchedule   {
  @JsonProperty("amount")
  private String amount;

  /**
   * The type of object present in this response
   */
  public enum PaymentScheduleUTypeEnum {
    CARDDEBIT("cardDebit"),
    
    DIRECTDEBIT("directDebit"),
    
    MANUALPAYMENT("manualPayment"),
    
    DIGITALWALLET("digitalWallet");

    private String value;

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

  @JsonProperty("paymentScheduleUType")
  private PaymentScheduleUTypeEnum paymentScheduleUType;

  @JsonProperty("cardDebit")
  private TelcoPaymentScheduleCardDebit cardDebit;

  @JsonProperty("directDebit")
  private TelcoPaymentScheduleDirectDebit directDebit;

  @JsonProperty("digitalWallet")
  private TelcoPaymentScheduleDigitalWallet digitalWallet;

  @JsonProperty("manualPayment")
  private TelcoPaymentScheduleManualPayment manualPayment;

  public TelcoPaymentSchedule amount(String amount) {
    this.amount = amount;
    return this;
  }

  /**
   * Optional payment amount indicating that a constant payment amount is scheduled to be paid (used in bill smooting scenarios)
   * @return amount
  */
  @ApiModelProperty(value = "Optional payment amount indicating that a constant payment amount is scheduled to be paid (used in bill smooting scenarios)")


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
   * @return paymentScheduleUType
  */
  @ApiModelProperty(required = true, value = "The type of object present in this response")
  @NotNull


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
   * @return cardDebit
  */
  @ApiModelProperty(value = "")

  @Valid

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
   * @return directDebit
  */
  @ApiModelProperty(value = "")

  @Valid

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
   * @return digitalWallet
  */
  @ApiModelProperty(value = "")

  @Valid

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
   * @return manualPayment
  */
  @ApiModelProperty(value = "")

  @Valid

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

