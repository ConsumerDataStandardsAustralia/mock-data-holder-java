package au.org.consumerdatastandards.client.model;

import java.io.PrintWriter;
import java.util.Objects;

/**
 * Defines the criteria and conditions for which a rate applies
 */
public class BankingProductRateTierV2 extends BankingProductRateTier {

    private String additionalInfo;

    private String additionalInfoUri;

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public String getAdditionalInfoUri() {
        return additionalInfoUri;
    }

    public void setAdditionalInfoUri(String additionalInfoUri) {
        this.additionalInfoUri = additionalInfoUri;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o) &&
                Objects.equals(this.additionalInfo, ((BankingProductRateTierV2)o).additionalInfo) &&
                Objects.equals(this.additionalInfoUri, ((BankingProductRateTierV2)o).additionalInfoUri);
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
