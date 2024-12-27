/*
 * Consumer Data Standards
 * Sample Data Holder to Demonstrate the Consumer Data Right APIs
 *
 * NOTE: This class is auto generated
  * Do not edit the class manually.
 */
package au.org.consumerdatastandards.holder.model.banking;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Objects;

@Entity
public class BankingProductDiscount {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @JsonIgnore
    private String discountId;

    /**
     * Description of the discount.
     */
    @Column(length = 2048)
    private String description;

    /**
     * The type of discount. For further details, refer to [Product Discount Types](#tocSproductdiscounttypedoc).
     */
    private DiscountType discountType;

    /**
     * Dollar value of the discount. One of _amount_, _balanceRate_, _transactionRate_, _accruedRate_ and _feeRate_ is mandatory.
     */
    private String amount;

    /**
     * A discount rate calculated based on a proportion of the balance. Note that the currency of the fee discount is expected to be the same as the currency of the fee itself. One of _amount_, _balanceRate_, _transactionRate_, _accruedRate_ and _feeRate_ is mandatory. Unless noted in _additionalInfo_, assumes the application and calculation frequency are the same as the corresponding fee.
     */
    private String balanceRate;

    /**
     * A discount rate calculated based on a proportion of a transaction. Note that the currency of the fee discount is expected to be the same as the currency of the fee itself. One of _amount_, _balanceRate_, _transactionRate_, _accruedRate_ and _feeRate_ is mandatory.
     */
    private String transactionRate;

    /**
     * A discount rate calculated based on a proportion of the calculated interest accrued on the account. Note that the currency of the fee discount is expected to be the same as the currency of the fee itself. One of _amount_, _balanceRate_, _transactionRate_, _accruedRate_ and _feeRate_ is mandatory. Unless noted in _additionalInfo_, assumes the application and calculation frequency are the same as the corresponding fee.
     */
    private String accruedRate;

    /**
     * A discount rate calculated based on a proportion of the fee to which this discount is attached. Note that the currency of the fee discount is expected to be the same as the currency of the fee itself. One of _amount_, _balanceRate_, _transactionRate_, _accruedRate_ and _feeRate_ is mandatory. Unless noted in _additionalInfo_, assumes the application and calculation frequency are the same as the corresponding fee.
     */
    private String feeRate;

    /**
     * Generic field containing additional information relevant to the [_discountType_](#tocSproductdiscounttypedoc) specified. Whether mandatory or not is dependent on the value of [_discountType_](#tocSproductdiscounttypedoc).
     */
    @Column(length = 2048)
    private String additionalValue;

    /**
     * Display text providing more information on the discount.
     */
    @Column(length = 2048)
    private String additionalInfo;

    /**
     * Link to a web page with more information on this discount.
     */
    private URI additionalInfoUri;

    /**
     * Eligibility constraints that apply to this discount. Mandatory if _discountType_ is `ELIGIBILITY_ONLY`.
     */
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "product_discount_eligibility",
        joinColumns = @JoinColumn(name = "product_discount_id"),
        inverseJoinColumns = @JoinColumn(name = "discount_eligibility_id"))
    @Valid
    private List<BankingProductDiscountEligibility> eligibility;

    public String getDiscountId() {
        return discountId;
    }

    public void setDiscountId(String discountId) {
        this.discountId = discountId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DiscountType getDiscountType() {
        return discountType;
    }

    public void setDiscountType(DiscountType discountType) {
        this.discountType = discountType;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getBalanceRate() {
        return balanceRate;
    }

    public void setBalanceRate(String balanceRate) {
        this.balanceRate = balanceRate;
    }

    public String getTransactionRate() {
        return transactionRate;
    }

    public void setTransactionRate(String transactionRate) {
        this.transactionRate = transactionRate;
    }

    public String getAccruedRate() {
        return accruedRate;
    }

    public void setAccruedRate(String accruedRate) {
        this.accruedRate = accruedRate;
    }

    public String getFeeRate() {
        return feeRate;
    }

    public void setFeeRate(String feeRate) {
        this.feeRate = feeRate;
    }

    public String getAdditionalValue() {
        return additionalValue;
    }

    public void setAdditionalValue(String additionalValue) {
        this.additionalValue = additionalValue;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public URI getAdditionalInfoUri() {
        return additionalInfoUri;
    }

    public void setAdditionalInfoUri(URI additionalInfoUri) {
        this.additionalInfoUri = additionalInfoUri;
    }

    public List<BankingProductDiscountEligibility> getEligibility() {
        return eligibility;
    }

    public void setEligibility(List<BankingProductDiscountEligibility> eligibility) {
        this.eligibility = eligibility;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankingProductDiscount that = (BankingProductDiscount) o;
        return Objects.equals(discountId, that.discountId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(discountId);
    }

    @Override
    public String toString() {
        return "BankingProductDiscount{" +
            "discountId='" + discountId + '\'' +
            ", description='" + description + '\'' +
            ", discountType=" + discountType +
            ", amount=" + amount +
            ", balanceRate=" + balanceRate +
            ", transactionRate=" + transactionRate +
            ", accruedRate=" + accruedRate +
            ", feeRate=" + feeRate +
            ", additionalValue='" + additionalValue + '\'' +
            ", additionalInfo='" + additionalInfo + '\'' +
            ", additionalInfoUri=" + additionalInfoUri +
            ", eligibility=" + eligibility +
            '}';
    }

    public enum DiscountType {
        BALANCE,
        DEPOSITS,
        ELIGIBILITY_ONLY,
        FEE_CAP,
        PAYMENTS
    }
}
