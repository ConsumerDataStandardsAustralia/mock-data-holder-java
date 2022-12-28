package au.org.consumerdatastandards.holder.model.telco;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * TelcoBillingPaymentTransaction
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-12-23T11:32:06.900+11:00[Australia/Sydney]")
public class TelcoBillingPaymentTransaction   {
  @JsonProperty("amount")
  private String amount;

  /**
   * The method of payment
   */
  public enum MethodEnum {
    DIRECT_DEBIT("DIRECT_DEBIT"),
    
    CARD("CARD"),
    
    TRANSFER("TRANSFER"),
    
    BPAY("BPAY"),
    
    CASH("CASH"),
    
    CHEQUE("CHEQUE"),
    
    VOUCHER("VOUCHER"),
    
    OTHER("OTHER");

    private String value;

    MethodEnum(String value) {
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
    public static MethodEnum fromValue(String value) {
      for (MethodEnum b : MethodEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("method")
  private MethodEnum method;

  public TelcoBillingPaymentTransaction amount(String amount) {
    this.amount = amount;
    return this;
  }

  /**
   * The amount paid
   * @return amount
  */
  @ApiModelProperty(required = true, value = "The amount paid")
  @NotNull


  public String getAmount() {
    return amount;
  }

  public void setAmount(String amount) {
    this.amount = amount;
  }

  public TelcoBillingPaymentTransaction method(MethodEnum method) {
    this.method = method;
    return this;
  }

  /**
   * The method of payment
   * @return method
  */
  @ApiModelProperty(required = true, value = "The method of payment")
  @NotNull


  public MethodEnum getMethod() {
    return method;
  }

  public void setMethod(MethodEnum method) {
    this.method = method;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TelcoBillingPaymentTransaction telcoBillingPaymentTransaction = (TelcoBillingPaymentTransaction) o;
    return Objects.equals(this.amount, telcoBillingPaymentTransaction.amount) &&
        Objects.equals(this.method, telcoBillingPaymentTransaction.method);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount, method);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TelcoBillingPaymentTransaction {\n");
    
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    method: ").append(toIndentedString(method)).append("\n");
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

