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
 * Summary of MMS usage
 */
@ApiModel(description = "Summary of MMS usage")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-12-23T11:32:06.900+11:00[Australia/Sydney]")
public class TelcoUsageMessagingMms   {
  @JsonProperty("national")
  private BigDecimal national;

  @JsonProperty("international")
  private BigDecimal international;

  @JsonProperty("roaming")
  private BigDecimal roaming;

  @JsonProperty("amount")
  private String amount;

  public TelcoUsageMessagingMms national(BigDecimal national) {
    this.national = national;
    return this;
  }

  /**
   * Number of national MMS messages sent
   * @return national
  */
  @ApiModelProperty(required = true, value = "Number of national MMS messages sent")
  @NotNull

  @Valid

  public BigDecimal getNational() {
    return national;
  }

  public void setNational(BigDecimal national) {
    this.national = national;
  }

  public TelcoUsageMessagingMms international(BigDecimal international) {
    this.international = international;
    return this;
  }

  /**
   * ber of international MMS messages sent
   * @return international
  */
  @ApiModelProperty(value = "ber of international MMS messages sent")

  @Valid

  public BigDecimal getInternational() {
    return international;
  }

  public void setInternational(BigDecimal international) {
    this.international = international;
  }

  public TelcoUsageMessagingMms roaming(BigDecimal roaming) {
    this.roaming = roaming;
    return this;
  }

  /**
   * Number of roaming SMS messages sent. Including premium SMS services
   * @return roaming
  */
  @ApiModelProperty(value = "Number of roaming SMS messages sent. Including premium SMS services")

  @Valid

  public BigDecimal getRoaming() {
    return roaming;
  }

  public void setRoaming(BigDecimal roaming) {
    this.roaming = roaming;
  }

  public TelcoUsageMessagingMms amount(String amount) {
    this.amount = amount;
    return this;
  }

  /**
   * Cost amount of MMS messages
   * @return amount
  */
  @ApiModelProperty(required = true, value = "Cost amount of MMS messages")
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
    TelcoUsageMessagingMms telcoUsageMessagingMms = (TelcoUsageMessagingMms) o;
    return Objects.equals(this.national, telcoUsageMessagingMms.national) &&
        Objects.equals(this.international, telcoUsageMessagingMms.international) &&
        Objects.equals(this.roaming, telcoUsageMessagingMms.roaming) &&
        Objects.equals(this.amount, telcoUsageMessagingMms.amount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(national, international, roaming, amount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TelcoUsageMessagingMms {\n");
    
    sb.append("    national: ").append(toIndentedString(national)).append("\n");
    sb.append("    international: ").append(toIndentedString(international)).append("\n");
    sb.append("    roaming: ").append(toIndentedString(roaming)).append("\n");
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

