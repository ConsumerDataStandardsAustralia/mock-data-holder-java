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
 * TelcoProductPricing
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-12-23T11:32:06.900+11:00[Australia/Sydney]")
public class TelcoProductPricing   {
  @JsonProperty("name")
  private String name;

  @JsonProperty("description")
  private String description;

  @JsonProperty("period")
  private String period;

  @JsonProperty("chargeAmount")
  private String chargeAmount;

  public TelcoProductPricing name(String name) {
    this.name = name;
    return this;
  }

  /**
   * The display name of the pricing
   * @return name
  */
  @ApiModelProperty(required = true, value = "The display name of the pricing")
  @NotNull


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public TelcoProductPricing description(String description) {
    this.description = description;
    return this;
  }

  /**
   * The description of the pricing
   * @return description
  */
  @ApiModelProperty(required = true, value = "The description of the pricing")
  @NotNull


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public TelcoProductPricing period(String period) {
    this.period = period;
    return this;
  }

  /**
   * The duration that occurs on a pricing schedule indicates the frequency. Formatted according to [ISO 8601 Durations](https://en.wikipedia.org/wiki/ISO_8601#Durations) (excludes recurrence syntax)
   * @return period
  */
  @ApiModelProperty(value = "The duration that occurs on a pricing schedule indicates the frequency. Formatted according to [ISO 8601 Durations](https://en.wikipedia.org/wiki/ISO_8601#Durations) (excludes recurrence syntax)")


  public String getPeriod() {
    return period;
  }

  public void setPeriod(String period) {
    this.period = period;
  }

  public TelcoProductPricing chargeAmount(String chargeAmount) {
    this.chargeAmount = chargeAmount;
    return this;
  }

  /**
   * The amount charged for the duration period
   * @return chargeAmount
  */
  @ApiModelProperty(required = true, value = "The amount charged for the duration period")
  @NotNull


  public String getChargeAmount() {
    return chargeAmount;
  }

  public void setChargeAmount(String chargeAmount) {
    this.chargeAmount = chargeAmount;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TelcoProductPricing telcoProductPricing = (TelcoProductPricing) o;
    return Objects.equals(this.name, telcoProductPricing.name) &&
        Objects.equals(this.description, telcoProductPricing.description) &&
        Objects.equals(this.period, telcoProductPricing.period) &&
        Objects.equals(this.chargeAmount, telcoProductPricing.chargeAmount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, description, period, chargeAmount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TelcoProductPricing {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    period: ").append(toIndentedString(period)).append("\n");
    sb.append("    chargeAmount: ").append(toIndentedString(chargeAmount)).append("\n");
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

