package au.org.consumerdatastandards.holder.model.telco;

import java.util.Objects;
import au.org.consumerdatastandards.holder.model.telco.TelcoBalanceResponseData;
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
 * TelcoBalanceListResponseBalances
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-12-23T11:32:06.900+11:00[Australia/Sydney]")
public class TelcoBalanceListResponseBalances   {
  @JsonProperty("balances")
  @Valid
  private List<TelcoBalanceResponseData> balances = new ArrayList<>();

  public TelcoBalanceListResponseBalances balances(List<TelcoBalanceResponseData> balances) {
    this.balances = balances;
    return this;
  }

  public TelcoBalanceListResponseBalances addBalancesItem(TelcoBalanceResponseData balancesItem) {
    this.balances.add(balancesItem);
    return this;
  }

  /**
   * Array of account balances
   * @return balances
  */
  @ApiModelProperty(required = true, value = "Array of account balances")
  @NotNull

  @Valid

  public List<TelcoBalanceResponseData> getBalances() {
    return balances;
  }

  public void setBalances(List<TelcoBalanceResponseData> balances) {
    this.balances = balances;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TelcoBalanceListResponseBalances telcoBalanceListResponseBalances = (TelcoBalanceListResponseBalances) o;
    return Objects.equals(this.balances, telcoBalanceListResponseBalances.balances);
  }

  @Override
  public int hashCode() {
    return Objects.hash(balances);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TelcoBalanceListResponseBalances {\n");
    
    sb.append("    balances: ").append(toIndentedString(balances)).append("\n");
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

