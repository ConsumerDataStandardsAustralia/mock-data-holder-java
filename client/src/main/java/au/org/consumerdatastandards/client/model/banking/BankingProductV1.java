package au.org.consumerdatastandards.client.model.banking;

import java.io.PrintWriter;
import java.util.Objects;

public class BankingProductV1 extends BankingProductBase {

    private BankingProductAdditionalInformationV1 additionalInformation;

    /**
     * Get additionalInformation
     * @return additionalInformation
     */
    public BankingProductAdditionalInformationV1 getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(BankingProductAdditionalInformationV1 additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o) &&
                Objects.equals(this.additionalInformation, ((BankingProductV1)o).additionalInformation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), additionalInformation);
    }

    @Override
    protected void writeProperties(PrintWriter pw) {
        super.writeProperties(pw);
        pw.print("   additionalInformation: "); pw.println(toIndentedString(additionalInformation));
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    protected String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
