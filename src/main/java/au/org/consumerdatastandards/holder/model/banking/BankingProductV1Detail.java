package au.org.consumerdatastandards.holder.model.banking;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.Valid;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "b_prod")
public class BankingProductV1Detail implements BankingProductDetail {

    /**
     * A provider specific unique identifier for this product. This
     * identifier must be unique to a product but does not
     * otherwise need to adhere to ID permanence guidelines.
     */
    @Id
    private String productId;

    /**
     * The date and time from which this product is effective (ie.
     * is available for origination).  Used to enable the
     * articulation of products to the regime before they are
     * available for customers to originate
     */
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private OffsetDateTime effectiveFrom;

    /**
     * The date and time at which this product will be retired and
     * will no longer be offered.  Used to enable the managed
     * deprecation of products
     */
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private OffsetDateTime effectiveTo;

    /**
     * The last date and time that the information for this The last date and time that the information for this product was changed (or the creation date for the product if it has never been altered).
     */
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private OffsetDateTime lastUpdated;

    private BankingProductCategory productCategory;

    /**
     * The display name of the product.
     */
    private String name;

    /**
     * A description of the product.
     */
    @Column(length = 2048)
    private String description;

    /**
     * A label of the brand for the product. A label of the brand for the product. Able to be used for filtering. For data holders with single brands this value is still required.
     */
    private String brand;

    /**
     * An optional display name of the brand.
     */
    private String brandName;

    /**
     * A link to an application web page where this product can be
     * applied for.
     */
    private String applicationUri;

    /**
     * Indicates whether the product is specifically tailored to Indicates whether the product is specifically tailored to a circumstance. In this case fees and prices are significantly negotiated depending on context. While all products are open to a degree of tailoring this flag indicates that tailoring is expected and thus that the provision of specific fees and rates is not applicable.
     */
    private Boolean isTailored;

    @OneToOne(cascade = CascadeType.ALL)
    private BankingProductAdditionalInformationV1 additionalInformation;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "product_bundles",
        joinColumns = @JoinColumn(name = "product_id"),
        inverseJoinColumns = @JoinColumn(name = "bundle_id"))
    @Valid
    private List<BankingProductBundle> bundles = null;

    /**
     * Constraints on the application for or operation of the product such as minimum balances or limit thresholds.
     */
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "product_constraints",
        joinColumns = @JoinColumn(name = "product_id"),
        inverseJoinColumns = @JoinColumn(name = "constraint_id"))
    @Valid
    private List<BankingProductConstraint> constraints = null;

    /**
     * Interest rates available for deposits.
     */
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "product_deposit_rates",
        joinColumns = @JoinColumn(name = "product_id"),
        inverseJoinColumns = @JoinColumn(name = "deposit_rate_id"))
    @Valid
    private List<BankingProductDepositRateV1> depositRates = null;

    /**
     * Eligibility criteria for the product.
     */
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "product_eligibility",
        joinColumns = @JoinColumn(name = "product_id"),
        inverseJoinColumns = @JoinColumn(name = "eligibility_id"))
    @Valid
    private List<BankingProductEligibility> eligibility = null;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "product_features",
        joinColumns = @JoinColumn(name = "product_id"),
        inverseJoinColumns = @JoinColumn(name = "feature_id"))
    @Valid
    private List<BankingProductFeature> features = null;

    /**
     * Fees applicable to the product.
     */
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "product_fees",
        joinColumns = @JoinColumn(name = "product_id"),
        inverseJoinColumns = @JoinColumn(name = "fee_id"))
    @Valid
    private List<BankingProductFee> fees = null;

    /**
     * Interest rates charged against lending balances.
     */
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "product_lending_rates",
        joinColumns = @JoinColumn(name = "product_id"),
        inverseJoinColumns = @JoinColumn(name = "lending_rate_id"))
    @Valid
    private List<BankingProductLendingRateV1> lendingRates = null;

    @Override
    public String getProductId() {
        return productId;
    }

    @Override
    public void setProductId(String productId) {
        this.productId = productId;
    }

    @Override
    public OffsetDateTime getEffectiveFrom() {
        return effectiveFrom;
    }

    @Override
    public void setEffectiveFrom(OffsetDateTime effectiveFrom) {
        this.effectiveFrom = effectiveFrom;
    }

    @Override
    public OffsetDateTime getEffectiveTo() {
        return effectiveTo;
    }

    @Override
    public void setEffectiveTo(OffsetDateTime effectiveTo) {
        this.effectiveTo = effectiveTo;
    }

    @Override
    public OffsetDateTime getLastUpdated() {
        return lastUpdated;
    }

    @Override
    public void setLastUpdated(OffsetDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @Override
    public BankingProductCategory getProductCategory() {
        return productCategory;
    }

    @Override
    public void setProductCategory(BankingProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getBrand() {
        return brand;
    }

    @Override
    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String getBrandName() {
        return brandName;
    }

    @Override
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    @Override
    public String getApplicationUri() {
        return applicationUri;
    }

    @Override
    public void setApplicationUri(String applicationUri) {
        this.applicationUri = applicationUri;
    }

    @Override
    public Boolean getIsTailored() {
        return isTailored;
    }

    @Override
    public void setIsTailored(Boolean tailored) {
        isTailored = tailored;
    }

    public BankingProductV1Detail additionalInformation(BankingProductAdditionalInformationV1 additionalInformation) {
        this.additionalInformation = additionalInformation;
        return this;
    }

    /**
     * Get additionalInformation
     *
     * @return additionalInformation
     */
    @Valid
    public BankingProductAdditionalInformationV1 getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(BankingProductAdditionalInformationV1 additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public BankingProductV1Detail applicationUri(String applicationUri) {
        this.applicationUri = applicationUri;
        return this;
    }

    public BankingProductV1Detail brand(String brand) {
        this.brand = brand;
        return this;
    }

    public BankingProductV1Detail brandName(String brandName) {
        this.brandName = brandName;
        return this;
    }

    public BankingProductV1Detail description(String description) {
        this.description = description;
        return this;
    }

    public BankingProductV1Detail effectiveFrom(OffsetDateTime effectiveFrom) {
        this.effectiveFrom = effectiveFrom;
        return this;
    }

    public BankingProductV1Detail effectiveTo(OffsetDateTime effectiveTo) {
        this.effectiveTo = effectiveTo;
        return this;
    }

    public BankingProductV1Detail isTailored(Boolean isTailored) {
        this.isTailored = isTailored;
        return this;
    }

    public BankingProductV1Detail lastUpdated(OffsetDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
        return this;
    }

    public BankingProductV1Detail name(String name) {
        this.name = name;
        return this;
    }

    public BankingProductV1Detail productCategory(BankingProductCategory productCategory) {
        this.productCategory = productCategory;
        return this;
    }

    public BankingProductV1Detail productId(String productId) {
        this.productId = productId;
        return this;
    }

    public BankingProductV1Detail bundles(List<BankingProductBundle> bundles) {
        this.bundles = bundles;
        return this;
    }

    public BankingProductV1Detail addBundlesItem(BankingProductBundle bundlesItem) {
        if (this.bundles == null) {
            this.bundles = new ArrayList<>();
        }
        this.bundles.add(bundlesItem);
        return this;
    }

    /**
     * An array of bundles that this product participates in. Each bundle is described by free form information but also by a list of product IDs of the other products that are included in the bundle. It is assumed that the current product is included in the bundle also.
     *
     * @return bundles
     */
    @Valid
    public List<BankingProductBundle> getBundles() {
        return bundles;
    }

    public void setBundles(List<BankingProductBundle> bundles) {
        this.bundles = bundles;
    }

    public BankingProductV1Detail constraints(List<BankingProductConstraint> constraints) {
        this.constraints = constraints;
        return this;
    }

    public BankingProductV1Detail addConstraintsItem(BankingProductConstraint constraintsItem) {
        if (this.constraints == null) {
            this.constraints = new ArrayList<>();
        }
        this.constraints.add(constraintsItem);
        return this;
    }

    /**
     * Constraints on the application for or operation of the product such as minimum balances or limit thresholds.
     *
     * @return constraints
     */
    @Valid
    public List<BankingProductConstraint> getConstraints() {
        return constraints;
    }

    public void setConstraints(List<BankingProductConstraint> constraints) {
        this.constraints = constraints;
    }

    public BankingProductV1Detail depositRates(List<BankingProductDepositRateV1> depositRates) {
        this.depositRates = depositRates;
        return this;
    }

    public BankingProductV1Detail addDepositRatesItem(BankingProductDepositRateV1 depositRatesItem) {
        if (this.depositRates == null) {
            this.depositRates = new ArrayList<>();
        }
        this.depositRates.add(depositRatesItem);
        return this;
    }

    /**
     * Interest rates available for deposits.
     *
     * @return depositRates
     */
    @Valid
    public List<BankingProductDepositRateV1> getDepositRates() {
        return depositRates;
    }

    public void setDepositRates(List<BankingProductDepositRateV1> depositRates) {
        this.depositRates = depositRates;
    }

    public BankingProductV1Detail eligibility(List<BankingProductEligibility> eligibility) {
        this.eligibility = eligibility;
        return this;
    }

    public BankingProductV1Detail addEligibilityItem(BankingProductEligibility eligibilityItem) {
        if (this.eligibility == null) {
            this.eligibility = new ArrayList<>();
        }
        this.eligibility.add(eligibilityItem);
        return this;
    }

    /**
     * Eligibility criteria for the product.
     *
     * @return eligibility
     */
    @Valid
    public List<BankingProductEligibility> getEligibility() {
        return eligibility;
    }

    public void setEligibility(List<BankingProductEligibility> eligibility) {
        this.eligibility = eligibility;
    }

    public BankingProductV1Detail features(List<BankingProductFeature> features) {
        this.features = features;
        return this;
    }

    public BankingProductV1Detail addFeaturesItem(BankingProductFeature featuresItem) {
        if (this.features == null) {
            this.features = new ArrayList<>();
        }
        this.features.add(featuresItem);
        return this;
    }

    /**
     * Array of features available for the product.
     *
     * @return features
     */
    @Valid
    public List<BankingProductFeature> getFeatures() {
        return features;
    }

    public void setFeatures(List<BankingProductFeature> features) {
        this.features = features;
    }

    public BankingProductV1Detail fees(List<BankingProductFee> fees) {
        this.fees = fees;
        return this;
    }

    public BankingProductV1Detail addFeesItem(BankingProductFee feesItem) {
        if (this.fees == null) {
            this.fees = new ArrayList<>();
        }
        this.fees.add(feesItem);
        return this;
    }

    /**
     * Fees applicable to the product.
     *
     * @return fees
     */
    @Valid
    public List<BankingProductFee> getFees() {
        return fees;
    }

    public void setFees(List<BankingProductFee> fees) {
        this.fees = fees;
    }

    public BankingProductV1Detail lendingRates(List<BankingProductLendingRateV1> lendingRates) {
        this.lendingRates = lendingRates;
        return this;
    }

    public BankingProductV1Detail addLendingRatesItem(BankingProductLendingRateV1 lendingRatesItem) {
        if (this.lendingRates == null) {
            this.lendingRates = new ArrayList<>();
        }
        this.lendingRates.add(lendingRatesItem);
        return this;
    }

    /**
     * Interest rates charged against lending balances.
     *
     * @return lendingRates
     */
    @Valid
    public List<BankingProductLendingRateV1> getLendingRates() {
        return lendingRates;
    }

    public void setLendingRates(List<BankingProductLendingRateV1> lendingRates) {
        this.lendingRates = lendingRates;
    }

    @Override
    public String toString() {
        return "BankingProductDetail{" +
            "productId='" + productId + '\'' +
            ", additionalInformation=" + additionalInformation +
            ", applicationUri='" + applicationUri + '\'' +
            ", brand='" + brand + '\'' +
            ", brandName='" + brandName + '\'' +
            ", description='" + description + '\'' +
            ", effectiveFrom=" + effectiveFrom +
            ", effectiveTo=" + effectiveTo +
            ", isTailored=" + isTailored +
            ", lastUpdated=" + lastUpdated +
            ", name='" + name + '\'' +
            ", productCategory=" + productCategory +
            ", bundles=" + bundles +
            ", constraints=" + constraints +
            ", depositRates=" + depositRates +
            ", eligibility=" + eligibility +
            ", features=" + features +
            ", fees=" + fees +
            ", lendingRates=" + lendingRates +
            '}';
    }
}

