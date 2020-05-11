package au.org.consumerdatastandards.holder.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Defines the criteria and conditions for which a rate applies
 */
@Entity
@Table(name = "BankingProductRateTier")
public class BankingProductRateTierV1 extends BankingProductRateTier {

    @ManyToOne
    @JsonIgnore
    private BankingProductLendingRateV1 lendingRate;

    @ManyToOne
    @JsonIgnore
    private BankingProductDepositRateV1 depositRate;

    @ManyToOne(cascade = CascadeType.ALL)
    private BankingProductRateTierSubTier subTier;

    public BankingProductDepositRateV1 getDepositRate() {
        return depositRate;
    }

    public void setDepositRate(BankingProductDepositRateV1 depositRate) {
        this.depositRate = depositRate;
    }

    public BankingProductLendingRateV1 getLendingRate() {
        return lendingRate;
    }

    public void setLendingRate(BankingProductLendingRateV1 lendingRate) {
        this.lendingRate = lendingRate;
    }

    public BankingProductRateTierSubTier getSubTier() {
        return subTier;
    }

    public void setSubTier(BankingProductRateTierSubTier subTier) {
        this.subTier = subTier;
    }

    protected void stringProperties(StringBuilder sb) {
        sb.append("subTier=").append(subTier)
                .append(", depositRate=").append(depositRate)
                .append(", lendingRate=").append(lendingRate);
    }
}
