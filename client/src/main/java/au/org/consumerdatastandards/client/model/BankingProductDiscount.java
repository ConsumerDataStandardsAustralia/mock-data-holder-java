/*
 * Consumer Data Standards
 * Sample client library to Demonstrate the Consumer Data Right APIs
 *
 * NOTE: This class is auto generated by the codegen artefact
 * https://github.com/ConsumerDataStandardsAustralia/java-artefacts/codegen
 */
package au.org.consumerdatastandards.client.model;

import java.util.List;
import java.util.Objects;

public class BankingProductDiscount {

  public enum DiscountTypeEnum {

    BALANCE,

    DEPOSITS,

    ELIGIBILITY_ONLY,

    FEE_CAP,

    PAYMENTS
  }

  private String accruedRate;

  private String additionalInfo;

  private String additionalInfoUri;

  private String additionalValue;

  private String amount;

  private String balanceRate;

  private String description;

  private DiscountTypeEnum discountType;

  private List<BankingProductDiscountEligibility> eligibility;

  private String feeRate;

  private String transactionRate;

  /**
   * A discount rate calculated based on a proportion of the calculated interest accrued on the account. Note that the currency of the fee discount is expected to be the same as the currency of the fee itself. One of amount, balanceRate, transactionRate, accruedRate and feeRate is mandatory. Unless noted in additionalInfo, assumes the application and calculation frequency are the same as the corresponding fee
   * @return accruedRate
   */
  public String getAccruedRate() {
    return accruedRate;
  }

  public void setAccruedRate(String accruedRate) {
    this.accruedRate = accruedRate;
  }

  /**
   * Display text providing more information on the discount
   * @return additionalInfo
   */
  public String getAdditionalInfo() {
    return additionalInfo;
  }

  public void setAdditionalInfo(String additionalInfo) {
    this.additionalInfo = additionalInfo;
  }

  /**
   * Link to a web page with more information on this discount
   * @return additionalInfoUri
   */
  public String getAdditionalInfoUri() {
    return additionalInfoUri;
  }

  public void setAdditionalInfoUri(String additionalInfoUri) {
    this.additionalInfoUri = additionalInfoUri;
  }

  /**
   * Generic field containing additional information relevant to the [discountType](#tocSproductdiscounttypedoc) specified. Whether mandatory or not is dependent on the value of [discountType](#tocSproductdiscounttypedoc)
   * @return additionalValue
   */
  public String getAdditionalValue() {
    return additionalValue;
  }

  public void setAdditionalValue(String additionalValue) {
    this.additionalValue = additionalValue;
  }

  /**
   * Value of the discount
   * @return amount
   */
  public String getAmount() {
    return amount;
  }

  public void setAmount(String amount) {
    this.amount = amount;
  }

  /**
   * A discount rate calculated based on a proportion of the balance. Note that the currency of the fee discount is expected to be the same as the currency of the fee itself. One of amount, balanceRate, transactionRate, accruedRate and feeRate is mandatory. Unless noted in additionalInfo, assumes the application and calculation frequency are the same as the corresponding fee
   * @return balanceRate
   */
  public String getBalanceRate() {
    return balanceRate;
  }

  public void setBalanceRate(String balanceRate) {
    this.balanceRate = balanceRate;
  }

  /**
   * Description of the discount
   * @return description
   */
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * Get discountType
   * @return discountType
   */
  public DiscountTypeEnum getDiscountType() {
    return discountType;
  }

  public void setDiscountType(DiscountTypeEnum discountType) {
    this.discountType = discountType;
  }

  /**
   * Eligibility constraints that apply to this discount
   * @return eligibility
   */
  public List<BankingProductDiscountEligibility> getEligibility() {
    return eligibility;
  }

  public void setEligibility(List<BankingProductDiscountEligibility> eligibility) {
    this.eligibility = eligibility;
  }

  /**
   * A discount rate calculated based on a proportion of the fee to which this discount is attached. Note that the currency of the fee discount is expected to be the same as the currency of the fee itself. One of amount, balanceRate, transactionRate, accruedRate and feeRate is mandatory. Unless noted in additionalInfo, assumes the application and calculation frequency are the same as the corresponding fee
   * @return feeRate
   */
  public String getFeeRate() {
    return feeRate;
  }

  public void setFeeRate(String feeRate) {
    this.feeRate = feeRate;
  }

  /**
   * A discount rate calculated based on a proportion of a transaction. Note that the currency of the fee discount is expected to be the same as the currency of the fee itself. One of amount, balanceRate, transactionRate, accruedRate and feeRate is mandatory
   * @return transactionRate
   */
  public String getTransactionRate() {
    return transactionRate;
  }

  public void setTransactionRate(String transactionRate) {
    this.transactionRate = transactionRate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BankingProductDiscount bankingProductDiscount = (BankingProductDiscount) o;
    return Objects.equals(this.accruedRate, bankingProductDiscount.accruedRate) &&
        Objects.equals(this.additionalInfo, bankingProductDiscount.additionalInfo) &&
        Objects.equals(this.additionalInfoUri, bankingProductDiscount.additionalInfoUri) &&
        Objects.equals(this.additionalValue, bankingProductDiscount.additionalValue) &&
        Objects.equals(this.amount, bankingProductDiscount.amount) &&
        Objects.equals(this.balanceRate, bankingProductDiscount.balanceRate) &&
        Objects.equals(this.description, bankingProductDiscount.description) &&
        Objects.equals(this.discountType, bankingProductDiscount.discountType) &&
        Objects.equals(this.eligibility, bankingProductDiscount.eligibility) &&
        Objects.equals(this.feeRate, bankingProductDiscount.feeRate) &&
        Objects.equals(this.transactionRate, bankingProductDiscount.transactionRate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        accruedRate,
        additionalInfo,
        additionalInfoUri,
        additionalValue,
        amount,
        balanceRate,
        description,
        discountType,
        eligibility,
        feeRate,
        transactionRate);
  }


  @Override
  public String toString() {
    return "class BankingProductDiscount {\n" +
        "    accruedRate: " + toIndentedString(accruedRate) + "\n" +
        "    additionalInfo: " + toIndentedString(additionalInfo) + "\n" +
        "    additionalInfoUri: " + toIndentedString(additionalInfoUri) + "\n" +
        "    additionalValue: " + toIndentedString(additionalValue) + "\n" +
        "    amount: " + toIndentedString(amount) + "\n" +
        "    balanceRate: " + toIndentedString(balanceRate) + "\n" +
        "    description: " + toIndentedString(description) + "\n" +
        "    discountType: " + toIndentedString(discountType) + "\n" +
        "    eligibility: " + toIndentedString(eligibility) + "\n" +
        "    feeRate: " + toIndentedString(feeRate) + "\n" +
        "    transactionRate: " + toIndentedString(transactionRate) + "\n" +
        "}";
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
