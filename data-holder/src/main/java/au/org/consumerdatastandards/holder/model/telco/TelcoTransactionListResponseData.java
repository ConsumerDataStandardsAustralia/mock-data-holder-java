package au.org.consumerdatastandards.holder.model.telco;

import java.util.Objects;
import au.org.consumerdatastandards.holder.model.telco.TelcoBillingTransaction;
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
 * TelcoTransactionListResponseData
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-12-23T11:32:06.900+11:00[Australia/Sydney]")
public class TelcoTransactionListResponseData   {
  @JsonProperty("transactions")
  @Valid
  private List<TelcoBillingTransaction> transactions = new ArrayList<>();

  public TelcoTransactionListResponseData transactions(List<TelcoBillingTransaction> transactions) {
    this.transactions = transactions;
    return this;
  }

  public TelcoTransactionListResponseData addTransactionsItem(TelcoBillingTransaction transactionsItem) {
    this.transactions.add(transactionsItem);
    return this;
  }

  /**
   * Array of transactions sorted by date and time in descending order
   * @return transactions
  */
  @ApiModelProperty(required = true, value = "Array of transactions sorted by date and time in descending order")
  @NotNull

  @Valid

  public List<TelcoBillingTransaction> getTransactions() {
    return transactions;
  }

  public void setTransactions(List<TelcoBillingTransaction> transactions) {
    this.transactions = transactions;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TelcoTransactionListResponseData telcoTransactionListResponseData = (TelcoTransactionListResponseData) o;
    return Objects.equals(this.transactions, telcoTransactionListResponseData.transactions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(transactions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TelcoTransactionListResponseData {\n");
    
    sb.append("    transactions: ").append(toIndentedString(transactions)).append("\n");
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

