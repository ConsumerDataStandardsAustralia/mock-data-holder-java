package au.org.consumerdatastandards.holder.model.telco;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * TelcoConcession
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-12-23T11:32:06.900+11:00[Australia/Sydney]")
public class TelcoConcession   {
  /**
   * The concession type
   */
  public enum TypeEnum {
    CONCESSION("CONCESSION"),
    
    REBATE("REBATE"),
    
    GRANT("GRANT");

    private String value;

    TypeEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static TypeEnum fromValue(String value) {
      for (TypeEnum b : TypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("type")
  private TypeEnum type = TypeEnum.CONCESSION;

  @JsonProperty("displayName")
  private String displayName;

  @JsonProperty("additionalInfo")
  private String additionalInfo;

  @JsonProperty("additionalInfoUri")
  private String additionalInfoUri;

  @JsonProperty("startDate")
  private String startDate;

  @JsonProperty("endDate")
  private String endDate;

  @JsonProperty("discountFrequency")
  private String discountFrequency;

  @JsonProperty("amount")
  private String amount;

  @JsonProperty("percentage")
  private String percentage;

  /**
   * Gets or Sets appliedTo
   */
  public enum AppliedToEnum {
    INVOICE("INVOICE"),
    
    USAGE("USAGE");

    private String value;

    AppliedToEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static AppliedToEnum fromValue(String value) {
      for (AppliedToEnum b : AppliedToEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("appliedTo")
  @Valid
  private List<AppliedToEnum> appliedTo = null;

  public TelcoConcession type(TypeEnum type) {
    this.type = type;
    return this;
  }

  /**
   * The concession type
   * @return type
  */
  @ApiModelProperty(required = true, value = "The concession type")
  @NotNull


  public TypeEnum getType() {
    return type;
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }

  public TelcoConcession displayName(String displayName) {
    this.displayName = displayName;
    return this;
  }

  /**
   * The display name of the concession
   * @return displayName
  */
  @ApiModelProperty(required = true, value = "The display name of the concession")
  @NotNull


  public String getDisplayName() {
    return displayName;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  public TelcoConcession additionalInfo(String additionalInfo) {
    this.additionalInfo = additionalInfo;
    return this;
  }

  /**
   * Display text providing more information on the concession
   * @return additionalInfo
  */
  @ApiModelProperty(value = "Display text providing more information on the concession")


  public String getAdditionalInfo() {
    return additionalInfo;
  }

  public void setAdditionalInfo(String additionalInfo) {
    this.additionalInfo = additionalInfo;
  }

  public TelcoConcession additionalInfoUri(String additionalInfoUri) {
    this.additionalInfoUri = additionalInfoUri;
    return this;
  }

  /**
   * Optional link to additional information regarding the concession
   * @return additionalInfoUri
  */
  @ApiModelProperty(value = "Optional link to additional information regarding the concession")


  public String getAdditionalInfoUri() {
    return additionalInfoUri;
  }

  public void setAdditionalInfoUri(String additionalInfoUri) {
    this.additionalInfoUri = additionalInfoUri;
  }

  public TelcoConcession startDate(String startDate) {
    this.startDate = startDate;
    return this;
  }

  /**
   * Optional start date for the application of the concession
   * @return startDate
  */
  @ApiModelProperty(required = true, value = "Optional start date for the application of the concession")
  @NotNull


  public String getStartDate() {
    return startDate;
  }

  public void setStartDate(String startDate) {
    this.startDate = startDate;
  }

  public TelcoConcession endDate(String endDate) {
    this.endDate = endDate;
    return this;
  }

  /**
   * Optional end date for the application of the concession
   * @return endDate
  */
  @ApiModelProperty(value = "Optional end date for the application of the concession")


  public String getEndDate() {
    return endDate;
  }

  public void setEndDate(String endDate) {
    this.endDate = endDate;
  }

  public TelcoConcession discountFrequency(String discountFrequency) {
    this.discountFrequency = discountFrequency;
    return this;
  }

  /**
   * Conditional attribute for frequency at which a concession is applied. Required if type is FIXED_AMOUNT or FIXED_PERCENTAGE. Formatted according to [ISO 8601 Durations](https://en.wikipedia.org/wiki/ISO_8601#Durations) (excludes recurrence syntax)
   * @return discountFrequency
  */
  @ApiModelProperty(value = "Conditional attribute for frequency at which a concession is applied. Required if type is FIXED_AMOUNT or FIXED_PERCENTAGE. Formatted according to [ISO 8601 Durations](https://en.wikipedia.org/wiki/ISO_8601#Durations) (excludes recurrence syntax)")


  public String getDiscountFrequency() {
    return discountFrequency;
  }

  public void setDiscountFrequency(String discountFrequency) {
    this.discountFrequency = discountFrequency;
  }

  public TelcoConcession amount(String amount) {
    this.amount = amount;
    return this;
  }

  /**
   * Conditional attribute for the amount of discount for the concession- required if type is FIXED_AMOUNT
   * @return amount
  */
  @ApiModelProperty(value = "Conditional attribute for the amount of discount for the concession- required if type is FIXED_AMOUNT")


  public String getAmount() {
    return amount;
  }

  public void setAmount(String amount) {
    this.amount = amount;
  }

  public TelcoConcession percentage(String percentage) {
    this.percentage = percentage;
    return this;
  }

  /**
   * Conditional attribute for the percentage of discount of concession - required if type is FIXED_PERCENTAGE
   * @return percentage
  */
  @ApiModelProperty(value = "Conditional attribute for the percentage of discount of concession - required if type is FIXED_PERCENTAGE")


  public String getPercentage() {
    return percentage;
  }

  public void setPercentage(String percentage) {
    this.percentage = percentage;
  }

  public TelcoConcession appliedTo(List<AppliedToEnum> appliedTo) {
    this.appliedTo = appliedTo;
    return this;
  }

  public TelcoConcession addAppliedToItem(AppliedToEnum appliedToItem) {
    if (this.appliedTo == null) {
      this.appliedTo = new ArrayList<>();
    }
    this.appliedTo.add(appliedToItem);
    return this;
  }

  /**
   * Array of ENUM's to specify what the concession applies to. Multiple ENUM values can be provided. If absent, USAGE is assumed
   * @return appliedTo
  */
  @ApiModelProperty(value = "Array of ENUM's to specify what the concession applies to. Multiple ENUM values can be provided. If absent, USAGE is assumed")


  public List<AppliedToEnum> getAppliedTo() {
    return appliedTo;
  }

  public void setAppliedTo(List<AppliedToEnum> appliedTo) {
    this.appliedTo = appliedTo;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TelcoConcession telcoConcession = (TelcoConcession) o;
    return Objects.equals(this.type, telcoConcession.type) &&
        Objects.equals(this.displayName, telcoConcession.displayName) &&
        Objects.equals(this.additionalInfo, telcoConcession.additionalInfo) &&
        Objects.equals(this.additionalInfoUri, telcoConcession.additionalInfoUri) &&
        Objects.equals(this.startDate, telcoConcession.startDate) &&
        Objects.equals(this.endDate, telcoConcession.endDate) &&
        Objects.equals(this.discountFrequency, telcoConcession.discountFrequency) &&
        Objects.equals(this.amount, telcoConcession.amount) &&
        Objects.equals(this.percentage, telcoConcession.percentage) &&
        Objects.equals(this.appliedTo, telcoConcession.appliedTo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, displayName, additionalInfo, additionalInfoUri, startDate, endDate, discountFrequency, amount, percentage, appliedTo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TelcoConcession {\n");
    
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
    sb.append("    additionalInfo: ").append(toIndentedString(additionalInfo)).append("\n");
    sb.append("    additionalInfoUri: ").append(toIndentedString(additionalInfoUri)).append("\n");
    sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
    sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
    sb.append("    discountFrequency: ").append(toIndentedString(discountFrequency)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    percentage: ").append(toIndentedString(percentage)).append("\n");
    sb.append("    appliedTo: ").append(toIndentedString(appliedTo)).append("\n");
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

