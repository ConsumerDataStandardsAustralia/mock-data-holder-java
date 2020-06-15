package au.org.consumerdatastandards.holder.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Defines the criteria and conditions for which a rate applies
 */
@Entity
@Table(name = "BankingProductRateTier")
public class BankingProductRateTierV3 extends BankingProductRateTier {

    @ManyToOne
    @JsonIgnore
    private BankingProductDepositRateV3 depositRate;

    @ManyToOne
    @JsonIgnore
    private BankingProductLendingRateV3 lendingRate;

    private String additionalInfo;

    private String additionalInfoUri;

    public BankingProductDepositRateV3 getDepositRate() {
        return depositRate;
    }

    public void setDepositRate(BankingProductDepositRateV3 depositRate) {
        this.depositRate = depositRate;
    }

    public BankingProductLendingRateV3 getLendingRate() {
        return lendingRate;
    }

    public void setLendingRate(BankingProductLendingRateV3 lendingRate) {
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
        sb.append("additionalInfo='").append(additionalInfo).append('\'')
                .append(", additionalInfoUri=").append(additionalInfoUri)
                .append(", depositRate=").append(depositRate)
                .append(", lendingRate=").append(lendingRate);
    }
}
