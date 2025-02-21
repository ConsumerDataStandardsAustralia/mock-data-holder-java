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
 * Object that contains links to additional information on specific topics.
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
     * General overview of the product. Mandatory if _additionalOverviewUris_ includes one or more supporting documents.
     */
    private URI overviewUri;

    /**
     * Terms and conditions for the product. Mandatory if _additionalTermsUris_ includes one or more supporting documents.
     */
    private URI termsUri;

    /**
     * Eligibility rules and criteria for the product. Mandatory if _additionalEligibilityUris_ includes one or more supporting documents.
     */
    private URI eligibilityUri;

    /**
     * Description of fees, pricing, discounts, exemptions and bonuses for the product. Mandatory if _additionalFeesAndPricingUris_ includes one or more supporting documents.
     */
    private URI feesAndPricingUri;

    /**
     * Description of a bundle that this product can be part of. Mandatory if _additionalBundleUris_ includes one or more supporting documents.
     */
    private URI bundleUri;

    /**
     * An array of additional general overviews for the product or features of the product, if applicable. To be treated as secondary documents to the _overviewUri_. Only to be used if there is a primary _overviewUri_.
     */
    @OneToMany(cascade = CascadeType.ALL)
    private List<AdditionalInformationUri> additionalOverviewUris;

    /**
     * An array of additional terms and conditions for the product, if applicable. To be treated as secondary documents to the _termsUri_. Only to be used if there is a primary _termsUri_.
     */
    @OneToMany(cascade = CascadeType.ALL)
    private List<AdditionalInformationUri> additionalTermsUris;

    /**
     * An array of additional eligibility rules and criteria for the product, if applicable. To be treated as secondary documents to the _eligibilityUri_. Only to be used if there is a primary _eligibilityUri_.
     */
    @OneToMany(cascade = CascadeType.ALL)
    private List<AdditionalInformationUri> additionalEligibilityUris;

    /**
     * An array of additional fees, pricing, discounts, exemptions and bonuses for the product, if applicable. To be treated as secondary documents to the _feesAndPricingUri_. Only to be used if there is a primary _feesAndPricingUri_.
     */
    @OneToMany(cascade = CascadeType.ALL)
    private List<AdditionalInformationUri> additionalFeesAndPricingUris;

    /**
     * An array of additional bundles for the product, if applicable. To be treated as secondary documents to the _bundleUri_. Only to be used if there is a primary _bundleUri_.
     */
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

    public List<AdditionalInformationUri> getAdditionalOverviewUris() {
        return additionalOverviewUris;
    }

    public void setAdditionalOverviewUris(List<AdditionalInformationUri> additionalOverviewUris) {
        this.additionalOverviewUris = additionalOverviewUris;
    }

    public List<AdditionalInformationUri> getAdditionalTermsUris() {
        return additionalTermsUris;
    }

    public void setAdditionalTermsUris(List<AdditionalInformationUri> additionalTermsUris) {
        this.additionalTermsUris = additionalTermsUris;
    }

    public List<AdditionalInformationUri> getAdditionalEligibilityUris() {
        return additionalEligibilityUris;
    }

    public void setAdditionalEligibilityUris(List<AdditionalInformationUri> additionalEligibilityUris) {
        this.additionalEligibilityUris = additionalEligibilityUris;
    }

    public List<AdditionalInformationUri> getAdditionalFeesAndPricingUris() {
        return additionalFeesAndPricingUris;
    }

    public void setAdditionalFeesAndPricingUris(List<AdditionalInformationUri> additionalFeesAndPricingUris) {
        this.additionalFeesAndPricingUris = additionalFeesAndPricingUris;
    }

    public List<AdditionalInformationUri> getAdditionalBundleUris() {
        return additionalBundleUris;
    }

    public void setAdditionalBundleUris(List<AdditionalInformationUri> additionalBundleUris) {
        this.additionalBundleUris = additionalBundleUris;
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
