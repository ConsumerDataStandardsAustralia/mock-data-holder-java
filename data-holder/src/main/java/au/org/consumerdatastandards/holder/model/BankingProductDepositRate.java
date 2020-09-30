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
public class BankingProductDepositRate {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @JsonIgnore
    private String depositRateId;

    /**
     * The type of rate (base, bonus, etc). See the next section
     * for an overview of valid values and their meaning
     */
    private DepositRateType depositRateType;

    /**
     * The rate to be applied
     */
    private BigDecimal rate;

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
     * Generic field containing additional information relevant to
     * the depositRateType specified. Whether mandatory or not is
     * dependent on the value of depositRateType
     */
    @Column(length = 2048)
    private String additionalValue;

    /**
     * Display text providing more information on the rate
     */
    @Column(length = 2048)
    private String additionalInfo;

    /**
     * Link to a web page with more information on this rate
     */
    private URI additionalInfoUri;

    public String getDepositRateId() {
        return depositRateId;
    }

    public void setDepositRateId(String depositRateId) {
        this.depositRateId = depositRateId;
    }

    public DepositRateType getDepositRateType() {
        return depositRateType;
    }

    public void setDepositRateType(DepositRateType depositRateType) {
        this.depositRateType = depositRateType;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
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
        BankingProductDepositRate that = (BankingProductDepositRate) o;
        return Objects.equals(depositRateId, that.depositRateId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(depositRateId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(getClass().getSimpleName()).append("{");
        stringProperties(sb);
        return sb.append("}").toString();
    }

    protected void stringProperties(StringBuilder sb) {
        sb.append("depositRateId='").append(depositRateId).append('\'')
                .append(", depositRateType=").append(depositRateType)
                .append(", rate=").append(rate)
                .append(", calculationFrequency='").append(calculationFrequency).append('\'')
                .append(", applicationFrequency='").append(applicationFrequency).append('\'')
                .append(", additionalValue='").append(additionalValue).append('\'')
                .append(", additionalInfo='").append(additionalInfo).append('\'')
                .append(", additionalInfoUri=").append(additionalInfoUri);
    }

    public enum DepositRateType {
        BONUS,
        BUNDLE_BONUS,
        FIXED,
        FLOATING,
        INTRODUCTORY,
        MARKET_LINKED,
        VARIABLE
    }
}
