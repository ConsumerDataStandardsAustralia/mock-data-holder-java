package au.org.consumerdatastandards.holder.model.telco;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * National voice calls
 */
@ApiModel(description = "National voice calls")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-12-23T11:32:06.900+11:00[Australia/Sydney]")
public class TelcoUsageVoiceNational   {
  @JsonProperty("duration")
  private String duration;

  @JsonProperty("number")
  private BigDecimal number;

  @JsonProperty("amount")
  private String amount;

  public TelcoUsageVoiceNational duration(String duration) {
    this.duration = duration;
    return this;
  }

  /**
   * Total duration (hours, minutes, and seconds) of national voice calls. Not limited to 24hrs
   * @return duration
  */
  @ApiModelProperty(required = true, value = "Total duration (hours, minutes, and seconds) of national voice calls. Not limited to 24hrs")
  @NotNull


  public String getDuration() {
    return duration;
  }

  public void setDuration(String duration) {
    this.duration = duration;
  }

  public TelcoUsageVoiceNational number(BigDecimal number) {
    this.number = number;
    return this;
  }

  /**
   * Number of national voice calls
   * @return number
  */
  @ApiModelProperty(required = true, value = "Number of national voice calls")
  @NotNull

  @Valid

  public BigDecimal getNumber() {
    return number;
  }

  public void setNumber(BigDecimal number) {
    this.number = number;
  }

  public TelcoUsageVoiceNational amount(String amount) {
    this.amount = amount;
    return this;
  }

  /**
   * Cost amount of national calls
   * @return amount
  */
  @ApiModelProperty(required = true, value = "Cost amount of national calls")
  @NotNull


  public String getAmount() {
    return amount;
  }

  public void setAmount(String amount) {
    this.amount = amount;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TelcoUsageVoiceNational telcoUsageVoiceNational = (TelcoUsageVoiceNational) o;
    return Objects.equals(this.duration, telcoUsageVoiceNational.duration) &&
        Objects.equals(this.number, telcoUsageVoiceNational.number) &&
        Objects.equals(this.amount, telcoUsageVoiceNational.amount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(duration, number, amount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TelcoUsageVoiceNational {\n");
    
    sb.append("    duration: ").append(toIndentedString(duration)).append("\n");
    sb.append("    number: ").append(toIndentedString(number)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
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

