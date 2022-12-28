package au.org.consumerdatastandards.holder.model.telco;

import java.util.Objects;
import au.org.consumerdatastandards.holder.model.telco.TelcoProductDetailPlanFeature;
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
 * TelcoProductDetailPlan
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-12-23T11:32:06.900+11:00[Australia/Sydney]")
public class TelcoProductDetailPlan   {
  @JsonProperty("displayName")
  private String displayName;

  @JsonProperty("description")
  private String description;

  @JsonProperty("planUri")
  private String planUri;

  @JsonProperty("features")
  @Valid
  private List<TelcoProductDetailPlanFeature> features = null;

  public TelcoProductDetailPlan displayName(String displayName) {
    this.displayName = displayName;
    return this;
  }

  /**
   * The display name of the product plan
   * @return displayName
  */
  @ApiModelProperty(required = true, value = "The display name of the product plan")
  @NotNull


  public String getDisplayName() {
    return displayName;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  public TelcoProductDetailPlan description(String description) {
    this.description = description;
    return this;
  }

  /**
   * The display name of the product plan
   * @return description
  */
  @ApiModelProperty(value = "The display name of the product plan")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public TelcoProductDetailPlan planUri(String planUri) {
    this.planUri = planUri;
    return this;
  }

  /**
   * The URI of the product plan
   * @return planUri
  */
  @ApiModelProperty(value = "The URI of the product plan")


  public String getPlanUri() {
    return planUri;
  }

  public void setPlanUri(String planUri) {
    this.planUri = planUri;
  }

  public TelcoProductDetailPlan features(List<TelcoProductDetailPlanFeature> features) {
    this.features = features;
    return this;
  }

  public TelcoProductDetailPlan addFeaturesItem(TelcoProductDetailPlanFeature featuresItem) {
    if (this.features == null) {
      this.features = new ArrayList<>();
    }
    this.features.add(featuresItem);
    return this;
  }

  /**
   * Optional list of features of the plan
   * @return features
  */
  @ApiModelProperty(value = "Optional list of features of the plan")

  @Valid

  public List<TelcoProductDetailPlanFeature> getFeatures() {
    return features;
  }

  public void setFeatures(List<TelcoProductDetailPlanFeature> features) {
    this.features = features;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TelcoProductDetailPlan telcoProductDetailPlan = (TelcoProductDetailPlan) o;
    return Objects.equals(this.displayName, telcoProductDetailPlan.displayName) &&
        Objects.equals(this.description, telcoProductDetailPlan.description) &&
        Objects.equals(this.planUri, telcoProductDetailPlan.planUri) &&
        Objects.equals(this.features, telcoProductDetailPlan.features);
  }

  @Override
  public int hashCode() {
    return Objects.hash(displayName, description, planUri, features);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TelcoProductDetailPlan {\n");
    
    sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    planUri: ").append(toIndentedString(planUri)).append("\n");
    sb.append("    features: ").append(toIndentedString(features)).append("\n");
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

