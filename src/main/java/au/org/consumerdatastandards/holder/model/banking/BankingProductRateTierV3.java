package au.org.consumerdatastandards.holder.model.banking;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Defines the criteria and conditions for which a rate applies.
 * Incorporates BankingProductRateTierV2.
 */
@Entity
@Table(name = "b_prod_rate_tier")
public class BankingProductRateTierV3 extends BankingProductRateTier {

    @ManyToOne
    @JsonIgnore
    private BankingProductDepositRateV2 depositRate;

    @ManyToOne
    @JsonIgnore
    private BankingProductLendingRateV2 lendingRate;

    /**
     * Display text providing more information on the rate tier.
     */
    private String additionalInfo;

    /**
     * Link to a web page with more information on this rate tier.
     */
    private String additionalInfoUri;

    public BankingProductDepositRateV2 getDepositRate() {
        return depositRate;
    }

    public void setDepositRate(BankingProductDepositRateV2 depositRate) {
        this.depositRate = depositRate;
    }

    public BankingProductLendingRateV2 getLendingRate() {
        return lendingRate;
    }

    public void setLendingRate(BankingProductLendingRateV2 lendingRate) {
        this.lendingRate = lendingRate;
    }

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
    protected void stringProperties(StringBuilder sb) {
        super.stringProperties(sb);
        sb.append("additionalInfo='").append(additionalInfo).append('\'')
                .append(", additionalInfoUri=").append(additionalInfoUri)
                .append(", depositRate=").append(depositRate)
                .append(", lendingRate=").append(lendingRate);
    }
}
