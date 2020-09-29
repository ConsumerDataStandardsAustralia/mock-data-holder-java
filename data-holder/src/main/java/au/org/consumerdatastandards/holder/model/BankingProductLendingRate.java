package au.org.consumerdatastandards.holder.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.math.BigDecimal;
import java.net.URI;
import java.util.Objects;

@MappedSuperclass
public abstract class BankingProductLendingRate {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @JsonIgnore
    private String lendingRateId;

    /**
     * The type of rate (fixed, variable, etc). See the next
     * section for an overview of valid values and their meaning
     */
    private LendingRateType lendingRateType;

    /**
     * The rate to be applied
     */
    private BigDecimal rate;

    /**
     * A comparison rate equivalent for this rate
     */
    private BigDecimal comparisonRate;

    /**
     * The period after which the rate is applied to the balance to
     * calculate the amount due for the period. Calculation of the
     * amount is often daily (as balances may change) but
     * accumulated until the total amount is 'applied' to the
     * account (see applicationFrequency). Formatted according to
     * [ISO 8601
     * Durations](https:*en.wikipedia.org/wiki/ISO_8601#Durations)
     */
    private String calculationFrequency;

    /**
     * The period after which the calculated amount(s) (see
     * calculationFrequency) are 'applied' (i.e. debited or
     * credited) to the account. Formatted according to [ISO 8601
     * Durations](https:*en.wikipedia.org/wiki/ISO_8601#Durations)
     */
    private String applicationFrequency;

    /**
     * When loan payments are due to be paid within each period.
     * The investment benefit of earlier payments affect the rate
     * that can be offered
     */
    private InterestPaymentDue interestPaymentDue;

    /**
     * Generic field containing additional information relevant to
     * the lendingRateType specified. Whether mandatory or not is
     * dependent on the value of lendingRateType
     */
    @Column(length = 2048)
    private String additionalValue;

    /**
     * Display text providing more information on the rate.
     */
    @Column(length = 2048)
    private String additionalInfo;

    /**
     * Link to a web page with more information on this rate
     */
    private URI additionalInfoUri;

    public String getLendingRateId() {
        return lendingRateId;
    }

    public void setLendingRateId(String lendingRateId) {
        this.lendingRateId = lendingRateId;
    }

    public LendingRateType getLendingRateType() {
        return lendingRateType;
    }

    public void setLendingRateType(LendingRateType lendingRateType) {
        this.lendingRateType = lendingRateType;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public BigDecimal getComparisonRate() {
        return comparisonRate;
    }

    public void setComparisonRate(BigDecimal comparisonRate) {
        this.comparisonRate = comparisonRate;
    }

    public String getCalculationFrequency() {
        return calculationFrequency;
    }

    public void setCalculationFrequency(String calculationFrequency) {
        this.calculationFrequency = calculationFrequency;
    }

    public String getApplicationFrequency() {
        return applicationFrequency;
    }

    public void setApplicationFrequency(String applicationFrequency) {
        this.applicationFrequency = applicationFrequency;
    }

    public InterestPaymentDue getInterestPaymentDue() {
        return interestPaymentDue;
    }

    public void setInterestPaymentDue(InterestPaymentDue interestPaymentDue) {
        this.interestPaymentDue = interestPaymentDue;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankingProductLendingRate that = (BankingProductLendingRate) o;
        return Objects.equals(lendingRateId, that.lendingRateId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lendingRateId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(getClass().getSimpleName()).append("{");
        stringProperties(sb);
        return sb.append("}").toString();
    }

    protected void stringProperties(StringBuilder sb) {
        sb.append("lendingRateId='").append(lendingRateId).append('\'')
                .append(", lendingRateType=").append(lendingRateType)
                .append(", rate=").append(rate)
                .append(", comparisonRate=").append(comparisonRate)
                .append(", calculationFrequency='").append(calculationFrequency).append('\'')
                .append(", applicationFrequency='").append(applicationFrequency).append('\'')
                .append(", interestPaymentDue=").append(interestPaymentDue)
                .append(", additionalValue='").append(additionalValue).append('\'')
                .append(", additionalInfo='").append(additionalInfo).append('\'')
                .append(", additionalInfoUri=").append(additionalInfoUri);
    }

    public enum InterestPaymentDue {
        IN_ADVANCE,
        IN_ARREARS
    }

    public enum LendingRateType {
        BUNDLE_DISCOUNT_FIXED,
        BUNDLE_DISCOUNT_VARIABLE,
        CASH_ADVANCE,
        DISCOUNT,
        FLOATING,
        INTRODUCTORY,
        MARKET_LINKED,
        PENALTY,
        PURCHASE,
        VARIABLE,
        FIXED
    }
}
