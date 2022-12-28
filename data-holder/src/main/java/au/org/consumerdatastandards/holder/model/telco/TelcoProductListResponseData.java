package au.org.consumerdatastandards.holder.model.telco;

import java.util.Objects;
import au.org.consumerdatastandards.holder.model.telco.TelcoProduct;
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
 * TelcoProductListResponseData
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-12-23T11:32:06.900+11:00[Australia/Sydney]")
public class TelcoProductListResponseData   {
  @JsonProperty("plans")
  @Valid
  private List<TelcoProduct> plans = new ArrayList<>();

  public TelcoProductListResponseData plans(List<TelcoProduct> plans) {
    this.plans = plans;
    return this;
  }

  public TelcoProductListResponseData addPlansItem(TelcoProduct plansItem) {
    this.plans.add(plansItem);
    return this;
  }

  /**
   * Array of Products
   * @return plans
  */
  @ApiModelProperty(required = true, value = "Array of Products")
  @NotNull

  @Valid

  public List<TelcoProduct> getPlans() {
    return plans;
  }

  public void setPlans(List<TelcoProduct> plans) {
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
    TelcoProductListResponseData telcoProductListResponseData = (TelcoProductListResponseData) o;
    return Objects.equals(this.plans, telcoProductListResponseData.plans);
  }

  @Override
  public int hashCode() {
    return Objects.hash(plans);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TelcoProductListResponseData {\n");
    
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

