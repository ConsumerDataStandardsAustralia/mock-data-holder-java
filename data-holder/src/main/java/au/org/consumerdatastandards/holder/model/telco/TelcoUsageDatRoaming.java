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
 * Roaming Data Usage
 */
@ApiModel(description = "Roaming Data Usage")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-12-23T11:32:06.900+11:00[Australia/Sydney]")
public class TelcoUsageDatRoaming   {
  @JsonProperty("download")
  private BigDecimal download;

  @JsonProperty("amount")
  private String amount;

  public TelcoUsageDatRoaming download(BigDecimal download) {
    this.download = download;
    return this;
  }

  /**
   * Amount of data used while roaming in megabytes (MB)
   * @return download
  */
  @ApiModelProperty(value = "Amount of data used while roaming in megabytes (MB)")

  @Valid

  public BigDecimal getDownload() {
    return download;
  }

  public void setDownload(BigDecimal download) {
    this.download = download;
  }

  public TelcoUsageDatRoaming amount(String amount) {
    this.amount = amount;
    return this;
  }

  /**
   * Amount value of data roaming charges
   * @return amount
  */
  @ApiModelProperty(value = "Amount value of data roaming charges")


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
    TelcoUsageDatRoaming telcoUsageDatRoaming = (TelcoUsageDatRoaming) o;
    return Objects.equals(this.download, telcoUsageDatRoaming.download) &&
        Objects.equals(this.amount, telcoUsageDatRoaming.amount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(download, amount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TelcoUsageDatRoaming {\n");
    
    sb.append("    download: ").append(toIndentedString(download)).append("\n");
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

