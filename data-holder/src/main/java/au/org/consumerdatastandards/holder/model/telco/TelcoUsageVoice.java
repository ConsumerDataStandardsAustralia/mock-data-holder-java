package au.org.consumerdatastandards.holder.model.telco;

import java.util.Objects;
import au.org.consumerdatastandards.holder.model.telco.TelcoUsageVoiceInternational;
import au.org.consumerdatastandards.holder.model.telco.TelcoUsageVoiceNational;
import au.org.consumerdatastandards.holder.model.telco.TelcoUsageVoiceRoaming;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Summary of voice calls. Required if voice calls are included in product plan
 */
@ApiModel(description = "Summary of voice calls. Required if voice calls are included in product plan")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-12-23T11:32:06.900+11:00[Australia/Sydney]")
public class TelcoUsageVoice   {
  @JsonProperty("national")
  private TelcoUsageVoiceNational national;

  @JsonProperty("international")
  private TelcoUsageVoiceInternational international;

  @JsonProperty("roaming")
  private TelcoUsageVoiceRoaming roaming;

  public TelcoUsageVoice national(TelcoUsageVoiceNational national) {
    this.national = national;
    return this;
  }

  /**
   * Get national
   * @return national
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public TelcoUsageVoiceNational getNational() {
    return national;
  }

  public void setNational(TelcoUsageVoiceNational national) {
    this.national = national;
  }

  public TelcoUsageVoice international(TelcoUsageVoiceInternational international) {
    this.international = international;
    return this;
  }

  /**
   * Get international
   * @return international
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public TelcoUsageVoiceInternational getInternational() {
    return international;
  }

  public void setInternational(TelcoUsageVoiceInternational international) {
    this.international = international;
  }

  public TelcoUsageVoice roaming(TelcoUsageVoiceRoaming roaming) {
    this.roaming = roaming;
    return this;
  }

  /**
   * Get roaming
   * @return roaming
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public TelcoUsageVoiceRoaming getRoaming() {
    return roaming;
  }

  public void setRoaming(TelcoUsageVoiceRoaming roaming) {
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
    TelcoUsageVoice telcoUsageVoice = (TelcoUsageVoice) o;
    return Objects.equals(this.national, telcoUsageVoice.national) &&
        Objects.equals(this.international, telcoUsageVoice.international) &&
        Objects.equals(this.roaming, telcoUsageVoice.roaming);
  }

  @Override
  public int hashCode() {
    return Objects.hash(national, international, roaming);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TelcoUsageVoice {\n");
    
    sb.append("    national: ").append(toIndentedString(national)).append("\n");
    sb.append("    international: ").append(toIndentedString(international)).append("\n");
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

