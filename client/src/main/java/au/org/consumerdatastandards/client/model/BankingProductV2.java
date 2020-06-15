package au.org.consumerdatastandards.client.model;

import java.io.PrintWriter;
import java.util.List;
import java.util.Objects;

public class BankingProductV2 extends BankingProductV1 {

    private List<BankingProductCardArt> cardArt;

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
            Objects.equals(this.cardArt, ((BankingProductV2)o).cardArt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cardArt);
    }

    @Override
    protected void writeProperties(PrintWriter pw) {
        super.writeProperties(pw);
        pw.print("   cardArt: "); pw.println(toIndentedString(cardArt));
    }
}
