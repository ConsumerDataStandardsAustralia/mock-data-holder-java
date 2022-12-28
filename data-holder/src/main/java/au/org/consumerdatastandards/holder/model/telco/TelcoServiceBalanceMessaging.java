package au.org.consumerdatastandards.holder.model.telco;

import java.util.Objects;
import au.org.consumerdatastandards.holder.model.telco.TelcoPlanType;
import au.org.consumerdatastandards.holder.model.telco.TelcoServiceBalanceMessagingMms;
import au.org.consumerdatastandards.holder.model.telco.TelcoServiceBalanceMessagingSms;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Summary of messaging. Required if messaging services is included in the product plan
 */
@ApiModel(description = "Summary of messaging. Required if messaging services is included in the product plan")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-12-23T11:32:06.900+11:00[Australia/Sydney]")
public class TelcoServiceBalanceMessaging   {
  @JsonProperty("planType")
  private TelcoPlanType planType;

  @JsonProperty("sms")
  private TelcoServiceBalanceMessagingSms sms;

  @JsonProperty("mms")
  private TelcoServiceBalanceMessagingMms mms;

  public TelcoServiceBalanceMessaging planType(TelcoPlanType planType) {
    this.planType = planType;
    return this;
  }

  /**
   * Get planType
   * @return planType
  */
  @ApiModelProperty(value = "")

  @Valid

  public TelcoPlanType getPlanType() {
    return planType;
  }

  public void setPlanType(TelcoPlanType planType) {
    this.planType = planType;
  }

  public TelcoServiceBalanceMessaging sms(TelcoServiceBalanceMessagingSms sms) {
    this.sms = sms;
    return this;
  }

  /**
   * Get sms
   * @return sms
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public TelcoServiceBalanceMessagingSms getSms() {
    return sms;
  }

  public void setSms(TelcoServiceBalanceMessagingSms sms) {
    this.sms = sms;
  }

  public TelcoServiceBalanceMessaging mms(TelcoServiceBalanceMessagingMms mms) {
    this.mms = mms;
    return this;
  }

  /**
   * Get mms
   * @return mms
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public TelcoServiceBalanceMessagingMms getMms() {
    return mms;
  }

  public void setMms(TelcoServiceBalanceMessagingMms mms) {
    this.mms = mms;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TelcoServiceBalanceMessaging telcoServiceBalanceMessaging = (TelcoServiceBalanceMessaging) o;
    return Objects.equals(this.planType, telcoServiceBalanceMessaging.planType) &&
        Objects.equals(this.sms, telcoServiceBalanceMessaging.sms) &&
        Objects.equals(this.mms, telcoServiceBalanceMessaging.mms);
  }

  @Override
  public int hashCode() {
    return Objects.hash(planType, sms, mms);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TelcoServiceBalanceMessaging {\n");
    
    sb.append("    planType: ").append(toIndentedString(planType)).append("\n");
    sb.append("    sms: ").append(toIndentedString(sms)).append("\n");
    sb.append("    mms: ").append(toIndentedString(mms)).append("\n");
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

