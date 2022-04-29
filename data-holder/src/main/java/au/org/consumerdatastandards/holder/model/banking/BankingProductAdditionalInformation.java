package au.org.consumerdatastandards.holder.model.banking;

import java.net.URI;

public interface BankingProductAdditionalInformation {
    URI getOverviewUri();

    void setOverviewUri(URI overviewUri);

    URI getTermsUri();

    void setTermsUri(URI termsUri);

    URI getEligibilityUri();

    void setEligibilityUri(URI eligibilityUri);

    URI getFeesAndPricingUri();

    void setFeesAndPricingUri(URI feesAndPricingUri);

    URI getBundleUri();

    void setBundleUri(URI bundleUri);
}
