package au.org.consumerdatastandards.holder.model.telco;

import java.util.Objects;
import au.org.consumerdatastandards.holder.model.telco.TelcoProductDetailMeteringCharges;
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
 * Detail on the plan applicable to this account. Mandatory if openStatus is OPEN
 */
@ApiModel(description = "Detail on the plan applicable to this account. Mandatory if openStatus is OPEN")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-12-23T11:32:06.900+11:00[Australia/Sydney]")
public class TelcoAccountDetailPlanDetail   {
  @JsonProperty("charges")
  @Valid
  private List<TelcoProductDetailMeteringCharges> charges = new ArrayList<>();

  public TelcoAccountDetailPlanDetail charges(List<TelcoProductDetailMeteringCharges> charges) {
    this.charges = charges;
    return this;
  }

  public TelcoAccountDetailPlanDetail addChargesItem(TelcoProductDetailMeteringCharges chargesItem) {
    this.charges.add(chargesItem);
    return this;
  }

  /**
   * Charges for metering included in the plan
   * @return charges
  */
  @ApiModelProperty(required = true, value = "Charges for metering included in the plan")
  @NotNull

  @Valid

  public List<TelcoProductDetailMeteringCharges> getCharges() {
    return charges;
  }

  public void setCharges(List<TelcoProductDetailMeteringCharges> charges) {
    this.charges = charges;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TelcoAccountDetailPlanDetail telcoAccountDetailPlanDetail = (TelcoAccountDetailPlanDetail) o;
    return Objects.equals(this.charges, telcoAccountDetailPlanDetail.charges);
  }

  @Override
  public int hashCode() {
    return Objects.hash(charges);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TelcoAccountDetailPlanDetail {\n");
    
    sb.append("    charges: ").append(toIndentedString(charges)).append("\n");
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

