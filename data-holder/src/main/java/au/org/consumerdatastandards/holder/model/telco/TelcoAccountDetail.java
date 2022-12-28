package au.org.consumerdatastandards.holder.model.telco;

import java.util.Objects;
import au.org.consumerdatastandards.holder.model.telco.TelcoAccountDetailPlans;
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
 * The array of plans containing services and associated plan details
 */
@ApiModel(description = "The array of plans containing services and associated plan details")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-12-23T11:32:06.900+11:00[Australia/Sydney]")
public class TelcoAccountDetail   {
  @JsonProperty("plans")
  @Valid
  private List<TelcoAccountDetailPlans> plans = new ArrayList<>();

  public TelcoAccountDetail plans(List<TelcoAccountDetailPlans> plans) {
    this.plans = plans;
    return this;
  }

  public TelcoAccountDetail addPlansItem(TelcoAccountDetailPlans plansItem) {
    this.plans.add(plansItem);
    return this;
  }

  /**
   * The array of plans containing services and associated plan details
   * @return plans
  */
  @ApiModelProperty(required = true, value = "The array of plans containing services and associated plan details")
  @NotNull

  @Valid

  public List<TelcoAccountDetailPlans> getPlans() {
    return plans;
  }

  public void setPlans(List<TelcoAccountDetailPlans> plans) {
    this.plans = plans;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TelcoAccountDetail telcoAccountDetail = (TelcoAccountDetail) o;
    return Objects.equals(this.plans, telcoAccountDetail.plans);
  }

  @Override
  public int hashCode() {
    return Objects.hash(plans);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TelcoAccountDetail {\n");
    
    sb.append("    plans: ").append(toIndentedString(plans)).append("\n");
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

