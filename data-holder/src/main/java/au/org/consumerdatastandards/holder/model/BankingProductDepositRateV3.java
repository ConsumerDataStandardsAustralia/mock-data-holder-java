package au.org.consumerdatastandards.holder.model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import java.util.List;

@Entity
@Table(name = "BankingProductDepositRate")
public class BankingProductDepositRateV3 extends BankingProductDepositRate {

    /**
     * Rate tiers applicable for this rate
     */
    @OneToMany(mappedBy = "depositRate")
    @Valid
    private List<BankingProductRateTierV3> tiers;

    public List<BankingProductRateTierV3> getTiers() {
        return tiers;
    }

    public void setTiers(List<BankingProductRateTierV3> tiers) {
        this.tiers = tiers;
    }

    @Override
    protected void stringProperties(StringBuilder sb) {
        super.stringProperties(sb);
        sb.append(", tiers=").append(tiers);
    }
}
