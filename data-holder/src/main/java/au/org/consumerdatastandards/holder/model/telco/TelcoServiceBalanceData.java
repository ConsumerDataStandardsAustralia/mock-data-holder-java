package au.org.consumerdatastandards.holder.model.telco;

import java.util.Objects;
import au.org.consumerdatastandards.holder.model.telco.TelcoPlanType;
import au.org.consumerdatastandards.holder.model.telco.TelcoServiceBalanceDataRoaming;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Summary of data balances
 */
@ApiModel(description = "Summary of data balances")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-12-23T11:32:06.900+11:00[Australia/Sydney]")
public class TelcoServiceBalanceData   {
  @JsonProperty("planType")
  private TelcoPlanType planType;

  @JsonProperty("description")
  private String description;

  @JsonProperty("upload")
  private BigDecimal upload;

  @JsonProperty("download")
  private BigDecimal download;

  @JsonProperty("amount")
  private String amount;

  @JsonProperty("roaming")
  private TelcoServiceBalanceDataRoaming roaming;

  public TelcoServiceBalanceData planType(TelcoPlanType planType) {
    this.planType = planType;
    return this;
  }

  /**
   * Get planType
   * @return planType
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public TelcoPlanType getPlanType() {
    return planType;
  }

  public void setPlanType(TelcoPlanType planType) {
    this.planType = planType;
  }

  public TelcoServiceBalanceData description(String description) {
    this.description = description;
    return this;
  }

  /**
   * An overview of plan limits. Required unless planType is UNSUPPORTED
   * @return description
  */
  @ApiModelProperty(value = "An overview of plan limits. Required unless planType is UNSUPPORTED")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public TelcoServiceBalanceData upload(BigDecimal upload) {
    this.upload = upload;
    return this;
  }

  /**
   * Remaining upload data in megabytes (MB). Required unless planType is UNSUPPORTED or UNMETERED
   * @return upload
  */
  @ApiModelProperty(value = "Remaining upload data in megabytes (MB). Required unless planType is UNSUPPORTED or UNMETERED")

  @Valid

  public BigDecimal getUpload() {
    return upload;
  }

  public void setUpload(BigDecimal upload) {
    this.upload = upload;
  }

  public TelcoServiceBalanceData download(BigDecimal download) {
    this.download = download;
    return this;
  }

  /**
   * Remaining download data in megabytes (MB). Required unless planType is UNSUPPORTED or UNMETERED
   * @return download
  */
  @ApiModelProperty(value = "Remaining download data in megabytes (MB). Required unless planType is UNSUPPORTED or UNMETERED")

  @Valid

  public BigDecimal getDownload() {
    return download;
  }

  public void setDownload(BigDecimal download) {
    this.download = download;
  }

  public TelcoServiceBalanceData amount(String amount) {
    this.amount = amount;
    return this;
  }

  /**
   * Remaining value amount of data available. Required unless planType is UNSUPPORTED or UNMETERED
   * @return amount
  */
  @ApiModelProperty(value = "Remaining value amount of data available. Required unless planType is UNSUPPORTED or UNMETERED")


  public String getAmount() {
    return amount;
  }

  public void setAmount(String amount) {
    this.amount = amount;
  }

  public TelcoServiceBalanceData roaming(TelcoServiceBalanceDataRoaming roaming) {
    this.roaming = roaming;
    return this;
  }

  /**
   * Get roaming
   * @return roaming
  */
  @ApiModelProperty(value = "")

  @Valid

  public TelcoServiceBalanceDataRoaming getRoaming() {
    return roaming;
  }

  public void setRoaming(TelcoServiceBalanceDataRoaming roaming) {
    this.roaming = roaming;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TelcoServiceBalanceData telcoServiceBalanceData = (TelcoServiceBalanceData) o;
    return Objects.equals(this.planType, telcoServiceBalanceData.planType) &&
        Objects.equals(this.description, telcoServiceBalanceData.description) &&
        Objects.equals(this.upload, telcoServiceBalanceData.upload) &&
        Objects.equals(this.download, telcoServiceBalanceData.download) &&
        Objects.equals(this.amount, telcoServiceBalanceData.amount) &&
        Objects.equals(this.roaming, telcoServiceBalanceData.roaming);
  }

  @Override
  public int hashCode() {
    return Objects.hash(planType, description, upload, download, amount, roaming);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TelcoServiceBalanceData {\n");
    
    sb.append("    planType: ").append(toIndentedString(planType)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    upload: ").append(toIndentedString(upload)).append("\n");
    sb.append("    download: ").append(toIndentedString(download)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    roaming: ").append(toIndentedString(roaming)).append("\n");
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

