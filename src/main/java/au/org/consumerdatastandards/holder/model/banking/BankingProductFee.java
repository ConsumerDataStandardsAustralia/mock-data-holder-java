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
import java.net.URI;
import java.util.List;
import java.util.Objects;

@Entity
public class BankingProductFee {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @JsonIgnore
    private String feeId;

    /**
     * Name of the fee.
     */
    private String name;

    /**
     * The type of fee. For further details, refer to [Product Fee Types](#tocSproductfeetypedoc).
     */
    private FeeType feeType;

    /**
     * The amount charged for the fee. One of _amount_, _balanceRate_, _transactionRate_ and _accruedRate_ is mandatory unless the _feeType_ `VARIABLE` is supplied.
     */
    private String amount;

    /**
     * A fee rate calculated based on a proportion of the balance. One of _amount_, _balanceRate_, _transactionRate_ and _accruedRate_ is mandatory unless the _feeType_ `VARIABLE` is supplied.
     */
    private String balanceRate;

    /**
     * A fee rate calculated based on a proportion of a transaction. One of _amount_, _balanceRate_, _transactionRate_ and _accruedRate_ is mandatory unless the _feeType_ `VARIABLE` is supplied.
     */
    private String transactionRate;

    /**
     * A fee rate calculated based on a proportion of the calculated interest accrued on the account. One of _amount_, _balanceRate_, _transactionRate_ and _accruedRate_ is mandatory unless the _feeType_ `VARIABLE` is supplied.
     */
    private String accruedRate;

    /**
     * The indicative frequency with which the fee is calculated on the account. Only applies if _balanceRate_ or _accruedRate_ is also present. Formatted according to [ISO 8601 Durations](https://en.wikipedia.org/wiki/ISO_8601#Durations) (excludes recurrence syntax).
     */
    private String accrualFrequency;

    /**
     * The currency the fee will be charged in. Assumes `AUD` if absent.
     */
    private String currency;

    /**
     * Generic field containing additional information relevant to the [_feeType_](#tocSproductfeetypedoc) specified. Whether mandatory or not is dependent on the value of [_feeType_](#tocSproductfeetypedoc).
     */
    @Column(length = 2048)
    private String additionalValue;

    /**
     * Display text providing more information on the fee.
     */
    @Column(length = 2048)
    private String additionalInfo;

    /**
     * Link to a web page with more information on this fee.
     */
    private URI additionalInfoUri;

    /**
     * An optional list of discounts to this fee that may be available.
     */
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "product_fee_discounts",
        joinColumns = @JoinColumn(name = "product_fee_id"),
        inverseJoinColumns = @JoinColumn(name = "product_discount_id"))
    private List<BankingProductDiscount> discounts;

    public String getFeeId() {
        return feeId;
    }

    public void setFeeId(String feeId) {
        this.feeId = feeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FeeType getFeeType() {
        return feeType;
    }

    public void setFeeType(FeeType feeType) {
        this.feeType = feeType;
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

    public String getAccrualFrequency() {
        return accrualFrequency;
    }

    public void setAccrualFrequency(String accrualFrequency) {
        this.accrualFrequency = accrualFrequency;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
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

    public List<BankingProductDiscount> getDiscounts() {
        return discounts;
    }

    public void setDiscounts(List<BankingProductDiscount> discounts) {
        this.discounts = discounts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankingProductFee that = (BankingProductFee) o;
        return Objects.equals(feeId, that.feeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(feeId);
    }

    @Override
    public String toString() {
        return "BankingProductFee{" +
            "feeId='" + feeId + '\'' +
            ", name='" + name + '\'' +
            ", feeType=" + feeType +
            ", amount=" + amount +
            ", balanceRate=" + balanceRate +
            ", transactionRate=" + transactionRate +
            ", accruedRate=" + accruedRate +
            ", accrualFrequency='" + accrualFrequency + '\'' +
            ", currency='" + currency + '\'' +
            ", additionalValue='" + additionalValue + '\'' +
            ", additionalInfo='" + additionalInfo + '\'' +
            ", additionalInfoUri=" + additionalInfoUri +
            ", discounts=" + discounts +
            '}';
    }

    public enum FeeType {
        DEPOSIT,
        EVENT,
        EXIT,
        PAYMENT,
        PERIODIC,
        PURCHASE,
        TRANSACTION,
        UPFRONT,
        VARIABLE,
        WITHDRAWAL
    }
}
