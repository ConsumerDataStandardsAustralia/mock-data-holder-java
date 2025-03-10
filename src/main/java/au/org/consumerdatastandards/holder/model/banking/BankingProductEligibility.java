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

@Entity
public class BankingProductEligibility {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @JsonIgnore
    private String eligibilityId;

    /**
     * The type of eligibility criteria described. For further details, refer to [Product Eligibility Types](#tocSproducteligibilitytypedoc).
     */
    private EligibilityType eligibilityType;

    /**
     * Generic field containing additional information relevant to the [_eligibilityType_](#tocSproducteligibilitytypedoc) specified. Whether mandatory or not is dependent on the value of [_eligibilityType_](#tocSproducteligibilitytypedoc).
     */
    @Column(length = 2048)
    private String additionalValue;

    /**
     * Display text providing more information on the [eligibility](#tocSproducteligibilitytypedoc) criteria. Mandatory if the field is set to `OTHER`.
     */
    @Column(length = 2048)
    private String additionalInfo;

    /**
     * Link to a web page with more information on this eligibility criteria.
     */
    private URI additionalInfoUri;

    public String getEligibilityId() {
        return eligibilityId;
    }

    public void setEligibilityId(String eligibilityId) {
        this.eligibilityId = eligibilityId;
    }

    public EligibilityType getEligibilityType() {
        return eligibilityType;
    }

    public void setEligibilityType(EligibilityType eligibilityType) {
        this.eligibilityType = eligibilityType;
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
        BankingProductEligibility that = (BankingProductEligibility) o;
        return Objects.equals(eligibilityId, that.eligibilityId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eligibilityId);
    }

    @Override
    public String toString() {
        return "BankingProductEligibility{" +
            "eligibilityId='" + eligibilityId + '\'' +
            ", eligibilityType=" + eligibilityType +
            ", additionalValue='" + additionalValue + '\'' +
            ", additionalInfo='" + additionalInfo + '\'' +
            ", additionalInfoUri=" + additionalInfoUri +
            '}';
    }

    public enum EligibilityType {
        BUSINESS,
        EMPLOYMENT_STATUS,
        MAX_AGE,
        MIN_AGE,
        MIN_INCOME,
        MIN_TURNOVER,
        NATURAL_PERSON,
        PENSION_RECIPIENT,
        RESIDENCY_STATUS,
        STAFF,
        STUDENT,
        OTHER
    }
}
