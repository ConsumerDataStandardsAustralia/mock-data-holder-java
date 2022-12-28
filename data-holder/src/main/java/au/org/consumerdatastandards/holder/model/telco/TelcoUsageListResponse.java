package au.org.consumerdatastandards.holder.model.telco;

import java.util.Objects;
import au.org.consumerdatastandards.holder.model.telco.TelcoAccountUsage;
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
 * TelcoUsageListResponse
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-12-23T11:32:06.900+11:00[Australia/Sydney]")
public class TelcoUsageListResponse   {
  @JsonProperty("accounts")
  @Valid
  private List<TelcoAccountUsage> accounts = new ArrayList<>();

  public TelcoUsageListResponse accounts(List<TelcoAccountUsage> accounts) {
    this.accounts = accounts;
    return this;
  }

  public TelcoUsageListResponse addAccountsItem(TelcoAccountUsage accountsItem) {
    this.accounts.add(accountsItem);
    return this;
  }

  /**
   * Array of usage on accounts
   * @return accounts
  */
  @ApiModelProperty(required = true, value = "Array of usage on accounts")
  @NotNull

  @Valid

  public List<TelcoAccountUsage> getAccounts() {
    return accounts;
  }

  public void setAccounts(List<TelcoAccountUsage> accounts) {
    this.accounts = accounts;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TelcoUsageListResponse telcoUsageListResponse = (TelcoUsageListResponse) o;
    return Objects.equals(this.accounts, telcoUsageListResponse.accounts);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accounts);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TelcoUsageListResponse {\n");
    
    sb.append("    accounts: ").append(toIndentedString(accounts)).append("\n");
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

