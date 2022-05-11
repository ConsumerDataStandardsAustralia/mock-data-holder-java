package au.org.consumerdatastandards.client.model.banking;

import java.io.PrintWriter;
import java.util.List;
import java.util.Objects;

public class BankingProductV4 extends BankingProductBase {

    private BankingProductAdditionalInformationV2 additionalInformation;

    private List<BankingProductCardArt> cardArt;

    /**
     * Get additionalInformation
     * @return additionalInformation
     */
    public BankingProductAdditionalInformationV2 getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(BankingProductAdditionalInformationV2 additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    /**
     * An array of card art images
     * @return cardArt
     */
    public List<BankingProductCardArt> getCardArt() {
        return cardArt;
    }

    public void setCardArt(List<BankingProductCardArt> cardArt) {
        this.cardArt = cardArt;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o) &&
            Objects.equals(this.cardArt, ((BankingProductV4)o).cardArt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), additionalInformation, cardArt);
    }

    @Override
    protected void writeProperties(PrintWriter pw) {
        super.writeProperties(pw);
        pw.print("   additionalInformation: "); pw.println(toIndentedString(additionalInformation));
        pw.print("   cardArt: "); pw.println(toIndentedString(cardArt));
    }
}
