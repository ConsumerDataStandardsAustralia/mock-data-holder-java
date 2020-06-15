package au.org.consumerdatastandards.client.model;

import java.util.List;
import java.util.Objects;

public class BankingProductDetailV3 extends BankingProductV2 implements BankingProductDetail {

    private List<BankingProductBundle> bundles;

    private List<BankingProductFeature> features;

    private List<BankingProductConstraint> constraints;

    private List<BankingProductEligibility> eligibility;

    private List<BankingProductFee> fees;

    private List<BankingProductDepositRate<BankingProductRateTierV3>> depositRates;

    private List<BankingProductLendingRate<BankingProductRateTierV3>> lendingRates;

    /**
     * An array of bundles that this product participates in.  Each bundle is described by free form information but also by a list of product IDs of the other products that are included in the bundle.  It is assumed that the current product is included in the bundle also
     * @return bundles
     */
    public List<BankingProductBundle> getBundles() {
        return bundles;
    }

    public void setBundles(List<BankingProductBundle> bundles) {
        this.bundles = bundles;
    }

    /**
     * Array of features available for the product
     * @return features
     */
    public List<BankingProductFeature> getFeatures() {
        return features;
    }

    public void setFeatures(List<BankingProductFeature> features) {
        this.features = features;
    }

    /**
     * Constraints on the application for or operation of the product such as minimum balances or limit thresholds
     * @return constraints
     */
    public List<BankingProductConstraint> getConstraints() {
        return constraints;
    }

    public void setConstraints(List<BankingProductConstraint> constraints) {
        this.constraints = constraints;
    }

    /**
     * Eligibility criteria for the product
     * @return eligibility
     */
    public List<BankingProductEligibility> getEligibility() {
        return eligibility;
    }

    public void setEligibility(List<BankingProductEligibility> eligibility) {
        this.eligibility = eligibility;
    }

    /**
     * Fees applicable for the product
     * @return fees
     */
    public List<BankingProductFee> getFees() {
        return fees;
    }

    public void setFees(List<BankingProductFee> fees) {
        this.fees = fees;
    }

    /**
     * Interest rates available for deposits
     * @return depositRates
     */
    public List<BankingProductDepositRate<BankingProductRateTierV3>> getDepositRates() {
        return depositRates;
    }

    public void setDepositRates(List<BankingProductDepositRate<BankingProductRateTierV3>> depositRates) {
        this.depositRates = depositRates;
    }

    /**
     * Interest rates charged against lending balances
     * @return lendingRates
     */
    public List<BankingProductLendingRate<BankingProductRateTierV3>> getLendingRates() {
        return lendingRates;
    }

    public void setLendingRates(List<BankingProductLendingRate<BankingProductRateTierV3>> lendingRates) {
        this.lendingRates = lendingRates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BankingProductDetailV3 bankingProductDetail = (BankingProductDetailV3) o;
        return Objects.equals(this.bundles, bankingProductDetail.bundles) &&
            Objects.equals(this.features, bankingProductDetail.features) &&
            Objects.equals(this.constraints, bankingProductDetail.constraints) &&
            Objects.equals(this.eligibility, bankingProductDetail.eligibility) &&
            Objects.equals(this.fees, bankingProductDetail.fees) &&
            Objects.equals(this.depositRates, bankingProductDetail.depositRates) &&
            Objects.equals(this.lendingRates, bankingProductDetail.lendingRates) &&
            super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            bundles,
            features,
            constraints,
            eligibility,
            fees,
            depositRates,
            lendingRates,
            super.hashCode());
    }

    @Override
    public String toString() {
        return "class BankingProductDetail {\n" +
            "   productId: " + toIndentedString(getProductId()) + "\n" +
            "   effectiveFrom: " + toIndentedString(getEffectiveFrom()) + "\n" +
            "   effectiveTo: " + toIndentedString(getEffectiveTo()) + "\n" +
            "   lastUpdated: " + toIndentedString(getLastUpdated()) + "\n" +
            "   productCategory: " + toIndentedString(getProductCategory()) + "\n" +
            "   name: " + toIndentedString(getName()) + "\n" +
            "   description: " + toIndentedString(getDescription()) + "\n" +
            "   brand: " + toIndentedString(getBrand()) + "\n" +
            "   brandName: " + toIndentedString(getBrandName()) + "\n" +
            "   applicationUri: " + toIndentedString(getApplicationUri()) + "\n" +
            "   isTailored: " + toIndentedString(getIsTailored()) + "\n" +
            "   additionalInformation: " + toIndentedString(getAdditionalInformation()) + "\n" +
            "   cardArt: " + toIndentedString(getCardArt()) + "\n" +
            "   bundles: " + toIndentedString(bundles) + "\n" +
            "   features: " + toIndentedString(features) + "\n" +
            "   constraints: " + toIndentedString(constraints) + "\n" +
            "   eligibility: " + toIndentedString(eligibility) + "\n" +
            "   fees: " + toIndentedString(fees) + "\n" +
            "   depositRates: " + toIndentedString(depositRates) + "\n" +
            "   lendingRates: " + toIndentedString(lendingRates) + "\n" +
            "}";
    }
}
