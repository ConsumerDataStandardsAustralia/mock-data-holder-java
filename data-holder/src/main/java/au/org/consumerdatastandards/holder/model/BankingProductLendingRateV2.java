package au.org.consumerdatastandards.holder.model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import java.util.List;

@Entity
@Table(name = "BankingProductLendingRate")
public class BankingProductLendingRateV2 extends BankingProductLendingRate {

    /**
     * Rate tiers applicable for this rate
     */
    @OneToMany(mappedBy = "lendingRate")
    @Valid
    private List<BankingProductRateTierV2> tiers = null;

    public List<BankingProductRateTierV2> getTiers() {
        return tiers;
    }

    public void setTiers(List<BankingProductRateTierV2> tiers) {
        this.tiers = tiers;
    }

    @Override
    protected void stringProperties(StringBuilder sb) {
        super.stringProperties(sb);
        sb.append(", tiers=").append(tiers);
    }
}
