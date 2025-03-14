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
public class BankingProductDiscountEligibility {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @JsonIgnore
    private String discountEligibilityId;

    /**
     * The type of the specific eligibility constraint for a discount. For further details, refer to [Product Discount Eligibility Types](#tocSproductdiscounteligibilitydoc).
     */
    private DiscountEligibilityType discountEligibilityType;

    /**
     * Generic field containing additional information relevant to the [_discountEligibilityType_](#tocSproductdiscounteligibilitydoc) specified. Whether mandatory or not is dependent on the value of [_discountEligibilityType_](#tocSproductdiscounteligibilitydoc).
     */
    @Column(length = 2048)
    private String additionalValue;

    /**
     * Display text providing more information on this eligibility constraint. Whether mandatory or not is dependent on the value of [_discountEligibilityType_](#tocSproductdiscounteligibilitydoc).
     */
    @Column(length = 2048)
    private String additionalInfo;

    /**
     * Link to a web page with more information on this eligibility constraint.
     */
    private URI additionalInfoUri;

    public String getDiscountEligibilityId() {
        return discountEligibilityId;
    }

    public void setDiscountEligibilityId(String discountEligibilityId) {
        this.discountEligibilityId = discountEligibilityId;
    }

    public DiscountEligibilityType getDiscountEligibilityType() {
        return discountEligibilityType;
    }

    public void setDiscountEligibilityType(DiscountEligibilityType discountEligibilityType) {
        this.discountEligibilityType = discountEligibilityType;
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
        BankingProductDiscountEligibility that = (BankingProductDiscountEligibility) o;
        return Objects.equals(discountEligibilityId, that.discountEligibilityId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(discountEligibilityId);
    }

    @Override
    public String toString() {
        return "BankingProductDiscountEligibility{" +
            "discountEligibilityId='" + discountEligibilityId + '\'' +
            ", discountEligibilityType=" + discountEligibilityType +
            ", additionalValue='" + additionalValue + '\'' +
            ", additionalInfo='" + additionalInfo + '\'' +
            ", additionalInfoUri=" + additionalInfoUri +
            '}';
    }


    public enum DiscountEligibilityType {
        BUSINESS,
        EMPLOYMENT_STATUS,
        INTRODUCTORY,
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
