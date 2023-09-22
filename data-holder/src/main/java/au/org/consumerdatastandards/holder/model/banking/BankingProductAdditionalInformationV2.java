/*
 * Consumer Data Standards
 * Sample Data Holder to Demonstrate the Consumer Data Right APIs
 */
package au.org.consumerdatastandards.holder.model.banking;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.net.URI;
import java.util.List;
import java.util.Objects;

/**
 * Object that contains links to additional information on
 * specific topics
 */
@Entity
@Table(name = "b_prod_add_info")
public class BankingProductAdditionalInformationV2 implements BankingProductAdditionalInformation {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @JsonIgnore
    private String additionalInformationId;

    /**
     * General overview of the product
     */
    private URI overviewUri;

    /**
     * Terms and conditions for the product
     */
    private URI termsUri;

    /**
     * Eligibility rules and criteria for the product
     */
    private URI eligibilityUri;

    /**
     * Description of fees, pricing, discounts, exemptions and
     * bonuses for the product
     */
    private URI feesAndPricingUri;

    /**
     * Description of a bundle that this product can be part of
     */
    private URI bundleUri;

    @OneToMany(cascade = CascadeType.ALL)
    private List<AdditionalInformationUri> additionalOverviewUris;

    @OneToMany(cascade = CascadeType.ALL)
    private List<AdditionalInformationUri> additionalTermsUris;

    @OneToMany(cascade = CascadeType.ALL)
    private List<AdditionalInformationUri> additionalEligibilityUris;

    @OneToMany(cascade = CascadeType.ALL)
    private List<AdditionalInformationUri> additionalFeesAndPricingUris;

    @OneToMany(cascade = CascadeType.ALL)
    private List<AdditionalInformationUri> additionalBundleUris;

    public String getAdditionalInformationId() {
        return additionalInformationId;
    }

    public void setAdditionalInformationId(String additionalInformationId) {
        this.additionalInformationId = additionalInformationId;
    }

    @Override
    public URI getOverviewUri() {
        return overviewUri;
    }

    @Override
    public void setOverviewUri(URI overviewUri) {
        this.overviewUri = overviewUri;
    }

    @Override
    public URI getTermsUri() {
        return termsUri;
    }

    @Override
    public void setTermsUri(URI termsUri) {
        this.termsUri = termsUri;
    }

    @Override
    public URI getEligibilityUri() {
        return eligibilityUri;
    }

    @Override
    public void setEligibilityUri(URI eligibilityUri) {
        this.eligibilityUri = eligibilityUri;
    }

    @Override
    public URI getFeesAndPricingUri() {
        return feesAndPricingUri;
    }

    @Override
    public void setFeesAndPricingUri(URI feesAndPricingUri) {
        this.feesAndPricingUri = feesAndPricingUri;
    }

    @Override
    public URI getBundleUri() {
        return bundleUri;
    }

    @Override
    public void setBundleUri(URI bundleUri) {
        this.bundleUri = bundleUri;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankingProductAdditionalInformationV2 that = (BankingProductAdditionalInformationV2) o;
        return Objects.equals(additionalInformationId, that.additionalInformationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(additionalInformationId);
    }

    @Override
    public String toString() {
        return "BankingProductAdditionalInformation{" +
            "additionalInformationId='" + additionalInformationId + '\'' +
            ", overviewUri=" + overviewUri +
            ", termsUri=" + termsUri +
            ", eligibilityUri=" + eligibilityUri +
            ", feesAndPricingUri=" + feesAndPricingUri +
            ", bundleUri=" + bundleUri +
            ", additionalOverviewUris=" + additionalOverviewUris +
            ", additionalTermsUris=" + additionalTermsUris +
            ", additionalEligibilityUris=" + additionalEligibilityUris +
            ", additionalFeesAndPricingUris=" + additionalFeesAndPricingUris +
            ", additionalBundleUris=" + additionalBundleUris +
            '}';
    }
}
