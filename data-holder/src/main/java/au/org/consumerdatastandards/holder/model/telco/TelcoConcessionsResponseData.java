package au.org.consumerdatastandards.holder.model.telco;

import java.util.Objects;
import au.org.consumerdatastandards.holder.model.telco.TelcoConcession;
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
 * TelcoConcessionsResponseData
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-12-23T11:32:06.900+11:00[Australia/Sydney]")
public class TelcoConcessionsResponseData   {
  @JsonProperty("concessions")
  @Valid
  private List<TelcoConcession> concessions = new ArrayList<>();

  public TelcoConcessionsResponseData concessions(List<TelcoConcession> concessions) {
    this.concessions = concessions;
    return this;
  }

  public TelcoConcessionsResponseData addConcessionsItem(TelcoConcession concessionsItem) {
    this.concessions.add(concessionsItem);
    return this;
  }

  /**
   * Array may be empty if no concessions exist
   * @return concessions
  */
  @ApiModelProperty(required = true, value = "Array may be empty if no concessions exist")
  @NotNull

  @Valid

  public List<TelcoConcession> getConcessions() {
    return concessions;
  }

  public void setConcessions(List<TelcoConcession> concessions) {
    this.concessions = concessions;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TelcoConcessionsResponseData telcoConcessionsResponseData = (TelcoConcessionsResponseData) o;
    return Objects.equals(this.concessions, telcoConcessionsResponseData.concessions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(concessions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TelcoConcessionsResponseData {\n");
    
    sb.append("    concessions: ").append(toIndentedString(concessions)).append("\n");
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

