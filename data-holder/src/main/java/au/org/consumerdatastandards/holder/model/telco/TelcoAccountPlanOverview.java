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
 * Mandatory if openStatus is OPEN
 */
@ApiModel(description = "Mandatory if openStatus is OPEN")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-12-23T11:32:06.900+11:00[Australia/Sydney]")
public class TelcoAccountPlanOverview   {
  @JsonProperty("displayName")
  private String displayName;

  @JsonProperty("startDate")
  private String startDate;

  @JsonProperty("endDate")
  private String endDate;

  public TelcoAccountPlanOverview displayName(String displayName) {
    this.displayName = displayName;
    return this;
  }

  /**
   * The name of the plan if one exists
   * @return displayName
  */
  @ApiModelProperty(value = "The name of the plan if one exists")


  public String getDisplayName() {
    return displayName;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  public TelcoAccountPlanOverview startDate(String startDate) {
    this.startDate = startDate;
    return this;
  }

  /**
   * The start date of the applicability of this plan
   * @return startDate
  */
  @ApiModelProperty(required = true, value = "The start date of the applicability of this plan")
  @NotNull


  public String getStartDate() {
    return startDate;
  }

  public void setStartDate(String startDate) {
    this.startDate = startDate;
  }

  public TelcoAccountPlanOverview endDate(String endDate) {
    this.endDate = endDate;
    return this;
  }

  /**
   * The end date of the applicability of this plan
   * @return endDate
  */
  @ApiModelProperty(value = "The end date of the applicability of this plan")


  public String getEndDate() {
    return endDate;
  }

  public void setEndDate(String endDate) {
    this.endDate = endDate;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TelcoAccountPlanOverview telcoAccountPlanOverview = (TelcoAccountPlanOverview) o;
    return Objects.equals(this.displayName, telcoAccountPlanOverview.displayName) &&
        Objects.equals(this.startDate, telcoAccountPlanOverview.startDate) &&
        Objects.equals(this.endDate, telcoAccountPlanOverview.endDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(displayName, startDate, endDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TelcoAccountPlanOverview {\n");
    
    sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
    sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
    sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
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

