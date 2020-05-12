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

    private RepaymentType repaymentType;

    private LoanPurpose loanPurpose;

    public List<BankingProductRateTierV2> getTiers() {
        return tiers;
    }

    public void setTiers(List<BankingProductRateTierV2> tiers) {
        this.tiers = tiers;
    }

    public RepaymentType getRepaymentType() {
        return repaymentType;
    }

    public void setRepaymentType(RepaymentType repaymentType) {
        this.repaymentType = repaymentType;
    }

    public LoanPurpose getLoanPurpose() {
        return loanPurpose;
    }

    public void setLoanPurpose(LoanPurpose loanPurpose) {
        this.loanPurpose = loanPurpose;
    }

    @Override
    protected void stringProperties(StringBuilder sb) {
        super.stringProperties(sb);
        sb.append(", tiers=").append(tiers)
                .append(", repaymentType=").append(repaymentType)
                .append(", repaymentType=").append(repaymentType);
    }

    public enum RepaymentType {
        INTEREST_ONLY,
        PRINCIPAL_AND_INTEREST
    }

    public enum LoanPurpose {
        OWNER_OCCUPIED,
        INVESTMENT
    }
}
