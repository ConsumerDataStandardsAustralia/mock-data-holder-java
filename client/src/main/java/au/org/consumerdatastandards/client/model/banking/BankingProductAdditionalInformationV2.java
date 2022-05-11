package au.org.consumerdatastandards.client.model.banking;

import java.io.PrintWriter;
import java.util.List;
import java.util.Objects;

public class BankingProductAdditionalInformationV2 extends BankingProductAdditionalInformationV1 {
    private List<AdditionalInformationUri> additionalOverviewUris;
    private List<AdditionalInformationUri> additionalTermsUris;
    private List<AdditionalInformationUri> additionalEligibilityUris;
    private List<AdditionalInformationUri> additionalFeesAndPricingUris;
    private List<AdditionalInformationUri> additionalBundleUris;

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
    protected void writeProperties(PrintWriter pw) {
        super.writeProperties(pw);
        pw.print("   additionalOverviewUris: "); pw.println(toIndentedString(additionalOverviewUris));
        pw.print("   additionalTermsUris: "); pw.println(toIndentedString(additionalTermsUris));
        pw.print("   additionalEligibilityUris: "); pw.println(toIndentedString(additionalEligibilityUris));
        pw.print("   additionalFeesAndPricingUris: "); pw.println(toIndentedString(additionalFeesAndPricingUris));
        pw.print("   additionalBundleUris: "); pw.println(toIndentedString(additionalBundleUris));
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o) &&
                Objects.equals(this.additionalOverviewUris, ((BankingProductAdditionalInformationV2)o).additionalOverviewUris) &&
                Objects.equals(this.additionalTermsUris, ((BankingProductAdditionalInformationV2)o).additionalTermsUris) &&
                Objects.equals(this.additionalEligibilityUris, ((BankingProductAdditionalInformationV2)o).additionalEligibilityUris) &&
                Objects.equals(this.additionalFeesAndPricingUris, ((BankingProductAdditionalInformationV2)o).additionalFeesAndPricingUris) &&
                Objects.equals(this.additionalBundleUris, ((BankingProductAdditionalInformationV2)o).additionalBundleUris);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), additionalOverviewUris, additionalTermsUris, additionalEligibilityUris,
                additionalFeesAndPricingUris, additionalBundleUris);
    }
}
