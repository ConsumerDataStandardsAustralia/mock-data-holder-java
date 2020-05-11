package au.org.consumerdatastandards.client.model;

import java.util.List;

public interface BankingProductDetail extends BankingProduct {
    List<BankingProductBundle> getBundles();

    void setBundles(List<BankingProductBundle> bundles);

    List<BankingProductFeature> getFeatures();

    void setFeatures(List<BankingProductFeature> features);

    List<BankingProductConstraint> getConstraints();

    void setConstraints(List<BankingProductConstraint> constraints);

    List<BankingProductEligibility> getEligibility();

    void setEligibility(List<BankingProductEligibility> eligibility);

    List<BankingProductFee> getFees();

    void setFees(List<BankingProductFee> fees);
}
