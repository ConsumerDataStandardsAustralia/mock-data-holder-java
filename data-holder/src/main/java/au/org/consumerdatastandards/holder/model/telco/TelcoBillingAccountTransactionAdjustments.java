package au.org.consumerdatastandards.holder.model.telco;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * TelcoBillingAccountTransactionAdjustments
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-12-23T11:32:06.900+11:00[Australia/Sydney]")
public class TelcoBillingAccountTransactionAdjustments   {
  @JsonProperty("amount")
  private String amount;

  @JsonProperty("description")
  private String description;

  public TelcoBillingAccountTransactionAdjustments amount(String amount) {
    this.amount = amount;
    return this;
  }

  /**
   * The amount of the adjustment
   * @return amount
  */
  @ApiModelProperty(required = true, value = "The amount of the adjustment")
  @NotNull


  public String getAmount() {
    return amount;
  }

  public void setAmount(String amount) {
    this.amount = amount;
  }

  public TelcoBillingAccountTransactionAdjustments description(String description) {
    this.description = description;
    return this;
  }

  /**
   * A free text description of the adjustment
   * @return description
  */
  @ApiModelProperty(required = true, value = "A free text description of the adjustment")
  @NotNull


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TelcoBillingAccountTransactionAdjustments telcoBillingAccountTransactionAdjustments = (TelcoBillingAccountTransactionAdjustments) o;
    return Objects.equals(this.amount, telcoBillingAccountTransactionAdjustments.amount) &&
        Objects.equals(this.description, telcoBillingAccountTransactionAdjustments.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount, description);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TelcoBillingAccountTransactionAdjustments {\n");
    
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
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

