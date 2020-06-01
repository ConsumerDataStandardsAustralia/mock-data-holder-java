package au.org.consumerdatastandards.client.model;

import java.io.PrintWriter;
import java.util.Objects;

/**
 * Defines the criteria and conditions for which a rate applies
 */
public class BankingProductRateTierV3 extends BankingProductRateTier {

    private String additionalInfo;

    private String additionalInfoUri;

    /**
     * Display text providing more information on the rate tier.
     * @return additionalInfo
     */
    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    /**
     * Link to a web page with more information on this rate tier.
     * @return additionalInfoUri
     */
    public String getAdditionalInfoUri() {
        return additionalInfoUri;
    }

    public void setAdditionalInfoUri(String additionalInfoUri) {
        this.additionalInfoUri = additionalInfoUri;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o) &&
                Objects.equals(this.additionalInfo, ((BankingProductRateTierV3)o).additionalInfo) &&
                Objects.equals(this.additionalInfoUri, ((BankingProductRateTierV3)o).additionalInfoUri);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), additionalInfo, additionalInfoUri);
    }

    @Override
    protected void writeProperties(PrintWriter pw) {
        super.writeProperties(pw);
        pw.print("   additionalInfo: "); pw.println(toIndentedString(additionalInfo));
        pw.print("   additionalInfoUri: "); pw.println(toIndentedString(additionalInfoUri));
    }
}
