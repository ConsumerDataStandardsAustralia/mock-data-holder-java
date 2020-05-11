package au.org.consumerdatastandards.client.model;

import java.io.PrintWriter;
import java.util.Objects;

/**
 * Defines the criteria and conditions for which a rate applies
 */
public class BankingProductRateTierV1 extends BankingProductRateTier {

    private BankingProductRateTierSubTier subTier;

    /**
     * Get subTier
     * @return subTier
     */
    public BankingProductRateTierSubTier getSubTier() {
        return subTier;
    }

    public void setSubTier(BankingProductRateTierSubTier subTier) {
        this.subTier = subTier;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o) &&
            Objects.equals(this.subTier, ((BankingProductRateTierV1)o).subTier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), subTier);
    }

    @Override
    protected void writeProperties(PrintWriter pw) {
        super.writeProperties(pw);
        pw.print("   subTier: "); pw.println(toIndentedString(subTier));
    }
}
