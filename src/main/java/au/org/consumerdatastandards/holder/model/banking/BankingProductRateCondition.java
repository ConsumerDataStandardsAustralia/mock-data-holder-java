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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.net.URI;
import java.util.Objects;

/**
 * Defines a condition for the applicability of a tiered rate.
 */
@Entity
public class BankingProductRateCondition {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @JsonIgnore
    private String rateConditionId;

    /**
     * // Display text providing more information on the condition.
     */
    @Column(length = 2048)
    private String additionalInfo;

    /**
     * Link to a web page with more information on this condition.
     */
    private URI additionalInfoUri;

    public String getRateConditionId() {
        return rateConditionId;
    }

    public void setRateConditionId(String rateConditionId) {
        this.rateConditionId = rateConditionId;
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
        BankingProductRateCondition that = (BankingProductRateCondition) o;
        return Objects.equals(rateConditionId, that.rateConditionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rateConditionId);
    }

    @Override
    public String toString() {
        return "BankingProductRateCondition{" +
            "rateConditionId='" + rateConditionId + '\'' +
            ", additionalInfo='" + additionalInfo + '\'' +
            ", additionalInfoUri=" + additionalInfoUri +
            '}';
    }
}
