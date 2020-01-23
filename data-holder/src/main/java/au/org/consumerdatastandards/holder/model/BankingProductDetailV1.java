package au.org.consumerdatastandards.holder.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.Valid;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "BankingProduct")
public class BankingProductDetailV1 implements BankingProductDetail {

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
     * The last date and time that the information for this product
     * was changed (or the creation date for the product if it has
     * never been altered)
     */
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private OffsetDateTime lastUpdated;

    private BankingProductCategory productCategory;

    /**
     * The display name of the product
     */
    private String name;

    /**
     * A description of the product
     */
    @Column(length = 2048)
    private String description;

    /**
     * A label of the brand for the product. Able to be used for
     * filtering. For data providers with single brands this value
     * is still required
     */
    private String brand;

    /**
     * An optional display name of the brand
     */
    private String brandName;

    /**
     * A link to an application web page where this product can be
     * applied for.
     */
    private String applicationUri;

    /**
     * Indicates whether the product is specifically tailored to a
     * circumstance.  In this case fees and prices are
     * significantly negotiated depending on context. While all
     * products are open to a degree of tailoring this flag
     * indicates that tailoring is expected and thus that the
     * provision of specific fees and rates is not applicable
     */
    private Boolean isTailored;

    @OneToOne(cascade = CascadeType.ALL)
    private BankingProductAdditionalInformation additionalInformation;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "product_bundles",
        joinColumns = @JoinColumn(name = "product_id"),
        inverseJoinColumns = @JoinColumn(name = "bundle_id"))
    @Valid
    private List<BankingProductBundle> bundles = null;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "product_constraints",
        joinColumns = @JoinColumn(name = "product_id"),
        inverseJoinColumns = @JoinColumn(name = "constraint_id"))
    @Valid
    private List<BankingProductConstraint> constraints = null;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "product_deposit_rates",
        joinColumns = @JoinColumn(name = "product_id"),
        inverseJoinColumns = @JoinColumn(name = "deposit_rate_id"))
    @Valid
    private List<BankingProductDepositRate> depositRates = null;

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

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "product_fees",
        joinColumns = @JoinColumn(name = "product_id"),
        inverseJoinColumns = @JoinColumn(name = "fee_id"))
    @Valid
    private List<BankingProductFee> fees = null;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "product_lending_rates",
        joinColumns = @JoinColumn(name = "product_id"),
        inverseJoinColumns = @JoinColumn(name = "lending_rate_id"))
    @Valid
    private List<BankingProductLendingRate> lendingRates = null;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public OffsetDateTime getEffectiveFrom() {
        return effectiveFrom;
    }

    public void setEffectiveFrom(OffsetDateTime effectiveFrom) {
        this.effectiveFrom = effectiveFrom;
    }

    public OffsetDateTime getEffectiveTo() {
        return effectiveTo;
    }

    public void setEffectiveTo(OffsetDateTime effectiveTo) {
        this.effectiveTo = effectiveTo;
    }

    public OffsetDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(OffsetDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public BankingProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(BankingProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getApplicationUri() {
        return applicationUri;
    }

    public void setApplicationUri(String applicationUri) {
        this.applicationUri = applicationUri;
    }

    public Boolean getIsTailored() {
        return isTailored;
    }

    public void setIsTailored(Boolean tailored) {
        isTailored = tailored;
    }

    public BankingProductDetailV1 additionalInformation(BankingProductAdditionalInformation additionalInformation) {
        this.additionalInformation = additionalInformation;
        return this;
    }

    /**
     * Get additionalInformation
     *
     * @return additionalInformation
     */
    @Valid
    public BankingProductAdditionalInformation getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(BankingProductAdditionalInformation additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public BankingProductDetailV1 applicationUri(String applicationUri) {
        this.applicationUri = applicationUri;
        return this;
    }

    public BankingProductDetailV1 brand(String brand) {
        this.brand = brand;
        return this;
    }

    public BankingProductDetailV1 brandName(String brandName) {
        this.brandName = brandName;
        return this;
    }

    public BankingProductDetailV1 description(String description) {
        this.description = description;
        return this;
    }

    public BankingProductDetailV1 effectiveFrom(OffsetDateTime effectiveFrom) {
        this.effectiveFrom = effectiveFrom;
        return this;
    }

    public BankingProductDetailV1 effectiveTo(OffsetDateTime effectiveTo) {
        this.effectiveTo = effectiveTo;
        return this;
    }

    public BankingProductDetailV1 isTailored(Boolean isTailored) {
        this.isTailored = isTailored;
        return this;
    }

    public BankingProductDetailV1 lastUpdated(OffsetDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
        return this;
    }

    public BankingProductDetailV1 name(String name) {
        this.name = name;
        return this;
    }

    public BankingProductDetailV1 productCategory(BankingProductCategory productCategory) {
        this.productCategory = productCategory;
        return this;
    }

    public BankingProductDetailV1 productId(String productId) {
        this.productId = productId;
        return this;
    }

    public BankingProductDetailV1 bundles(List<BankingProductBundle> bundles) {
        this.bundles = bundles;
        return this;
    }

    public BankingProductDetailV1 addBundlesItem(BankingProductBundle bundlesItem) {
        if (this.bundles == null) {
            this.bundles = new ArrayList<>();
        }
        this.bundles.add(bundlesItem);
        return this;
    }

    /**
     * An array of bundles that this product participates in.  Each bundle is described by free form information but also by a list of product IDs of the other products that are included in the bundle.  It is assumed that the current product is included in the bundle also
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

    public BankingProductDetailV1 constraints(List<BankingProductConstraint> constraints) {
        this.constraints = constraints;
        return this;
    }

    public BankingProductDetailV1 addConstraintsItem(BankingProductConstraint constraintsItem) {
        if (this.constraints == null) {
            this.constraints = new ArrayList<>();
        }
        this.constraints.add(constraintsItem);
        return this;
    }

    /**
     * Constraints on the application for or operation of the product such as minimum balances or limit thresholds
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

    public BankingProductDetailV1 depositRates(List<BankingProductDepositRate> depositRates) {
        this.depositRates = depositRates;
        return this;
    }

    public BankingProductDetailV1 addDepositRatesItem(BankingProductDepositRate depositRatesItem) {
        if (this.depositRates == null) {
            this.depositRates = new ArrayList<>();
        }
        this.depositRates.add(depositRatesItem);
        return this;
    }

    /**
     * Interest rates available for deposits
     *
     * @return depositRates
     */
    @Valid
    public List<BankingProductDepositRate> getDepositRates() {
        return depositRates;
    }

    public void setDepositRates(List<BankingProductDepositRate> depositRates) {
        this.depositRates = depositRates;
    }

    public BankingProductDetailV1 eligibility(List<BankingProductEligibility> eligibility) {
        this.eligibility = eligibility;
        return this;
    }

    public BankingProductDetailV1 addEligibilityItem(BankingProductEligibility eligibilityItem) {
        if (this.eligibility == null) {
            this.eligibility = new ArrayList<>();
        }
        this.eligibility.add(eligibilityItem);
        return this;
    }

    /**
     * Eligibility criteria for the product
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

    public BankingProductDetailV1 features(List<BankingProductFeature> features) {
        this.features = features;
        return this;
    }

    public BankingProductDetailV1 addFeaturesItem(BankingProductFeature featuresItem) {
        if (this.features == null) {
            this.features = new ArrayList<>();
        }
        this.features.add(featuresItem);
        return this;
    }

    /**
     * Array of features available for the product
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

    public BankingProductDetailV1 fees(List<BankingProductFee> fees) {
        this.fees = fees;
        return this;
    }

    public BankingProductDetailV1 addFeesItem(BankingProductFee feesItem) {
        if (this.fees == null) {
            this.fees = new ArrayList<>();
        }
        this.fees.add(feesItem);
        return this;
    }

    /**
     * Fees applicable for the product
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

    public BankingProductDetailV1 lendingRates(List<BankingProductLendingRate> lendingRates) {
        this.lendingRates = lendingRates;
        return this;
    }

    public BankingProductDetailV1 addLendingRatesItem(BankingProductLendingRate lendingRatesItem) {
        if (this.lendingRates == null) {
            this.lendingRates = new ArrayList<>();
        }
        this.lendingRates.add(lendingRatesItem);
        return this;
    }

    /**
     * Interest rates charged against lending balances
     *
     * @return lendingRates
     */
    @Valid
    public List<BankingProductLendingRate> getLendingRates() {
        return lendingRates;
    }

    public void setLendingRates(List<BankingProductLendingRate> lendingRates) {
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

