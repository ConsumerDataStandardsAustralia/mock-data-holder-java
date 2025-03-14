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
@Table(name = "b_prod_lending_rate")
public class BankingProductLendingRateV1 extends BankingProductLendingRate {

    /**
     * Rate tiers applicable for this rate.
     */
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "b_prod_lending_rate_tiers",
            joinColumns = @JoinColumn(name = "prod_id"),
            inverseJoinColumns = @JoinColumn(name = "tier_id"))
    @Valid
    private List<BankingProductRateTierV1> tiers = null;

    public List<BankingProductRateTierV1> getTiers() {
        return tiers;
    }

    public void setTiers(List<BankingProductRateTierV1> tiers) {
        this.tiers = tiers;
    }

    @Override
    protected void stringProperties(StringBuilder sb) {
        super.stringProperties(sb);
        sb.append(", tiers=").append(tiers);
    }
}
