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
public class BankingProductLendingRateV2 extends BankingProductLendingRate {

    /**
     * Rate tiers applicable for this rate.
     */
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "b_prod_lending_rate_tiers",
            joinColumns = @JoinColumn(name = "prod_id"),
            inverseJoinColumns = @JoinColumn(name = "tier_id"))
    @Valid
    private List<BankingProductRateTierV3> tiers = null;

    /**
     * Options in place for repayments. If absent, the lending rate is applicable to all repayment types.
     */
    private RepaymentType repaymentType;

    /**
     * The reason for taking out the loan. If absent, the lending rate is applicable to all loan purposes.
     */
    private LoanPurpose loanPurpose;

    public List<BankingProductRateTierV3> getTiers() {
        return tiers;
    }

    public void setTiers(List<BankingProductRateTierV3> tiers) {
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
