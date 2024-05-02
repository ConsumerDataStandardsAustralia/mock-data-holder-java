package au.org.consumerdatastandards.holder.model.banking;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import java.util.List;

@Entity
@Table(name = "b_prod_deposit_rate")
public class BankingProductDepositRateV2 extends BankingProductDepositRate {

    /**
     * Rate tiers applicable for this rate
     */
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "b_prod_deposit_rate_tiers",
            joinColumns = @JoinColumn(name = "deposit_rate_id"),
            inverseJoinColumns = @JoinColumn(name = "tier_id"))
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
