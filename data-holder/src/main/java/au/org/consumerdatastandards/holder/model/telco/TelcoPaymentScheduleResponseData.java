package au.org.consumerdatastandards.holder.model.telco;

import java.util.Objects;
import au.org.consumerdatastandards.holder.model.telco.TelcoPaymentSchedule;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * TelcoPaymentScheduleResponseData
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-12-23T11:32:06.900+11:00[Australia/Sydney]")
public class TelcoPaymentScheduleResponseData   {
  @JsonProperty("paymentSchedules")
  @Valid
  private List<TelcoPaymentSchedule> paymentSchedules = new ArrayList<>();

  public TelcoPaymentScheduleResponseData paymentSchedules(List<TelcoPaymentSchedule> paymentSchedules) {
    this.paymentSchedules = paymentSchedules;
    return this;
  }

  public TelcoPaymentScheduleResponseData addPaymentSchedulesItem(TelcoPaymentSchedule paymentSchedulesItem) {
    this.paymentSchedules.add(paymentSchedulesItem);
    return this;
  }

  /**
   * Array may be empty if no payment schedule exist
   * @return paymentSchedules
  */
  @ApiModelProperty(required = true, value = "Array may be empty if no payment schedule exist")
  @NotNull

  @Valid

  public List<TelcoPaymentSchedule> getPaymentSchedules() {
    return paymentSchedules;
  }

  public void setPaymentSchedules(List<TelcoPaymentSchedule> paymentSchedules) {
    this.paymentSchedules = paymentSchedules;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TelcoPaymentScheduleResponseData telcoPaymentScheduleResponseData = (TelcoPaymentScheduleResponseData) o;
    return Objects.equals(this.paymentSchedules, telcoPaymentScheduleResponseData.paymentSchedules);
  }

  @Override
  public int hashCode() {
    return Objects.hash(paymentSchedules);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TelcoPaymentScheduleResponseData {\n");
    
    sb.append("    paymentSchedules: ").append(toIndentedString(paymentSchedules)).append("\n");
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

