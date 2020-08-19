package au.org.consumerdatastandards.holder.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "BankingProduct")
public class BankingProductDetailV3 implements BankingProductDetail {

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
        name = "product_cardarts",
        joinColumns = @JoinColumn(name = "product_id"),
        inverseJoinColumns = @JoinColumn(name = "cardart_id"))
    private List<BankingProductV2CardArt> cardArt;

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
    private List<BankingProductDepositRateV2> depositRates = null;

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
    private List<BankingProductLendingRateV2> lendingRates = null;

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

    public BankingProductDetailV3 additionalInformation(BankingProductAdditionalInformation additionalInformation) {
        this.additionalInformation = additionalInformation;
        return this;
    }

    /**
     * Get additionalInformation
     *
     * @return additionalInformation
     */
    @Valid
    @Override
    public BankingProductAdditionalInformation getAdditionalInformation() {
        return additionalInformation;
    }

    @Override
    public void setAdditionalInformation(BankingProductAdditionalInformation additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public List<BankingProductV2CardArt> getCardArt() {
        return cardArt;
    }

    public void setCardArt(List<BankingProductV2CardArt> cardArt) {
        this.cardArt = cardArt;
    }

    public BankingProductDetailV3 applicationUri(String applicationUri) {
        this.applicationUri = applicationUri;
        return this;
    }

    public BankingProductDetailV3 brand(String brand) {
        this.brand = brand;
        return this;
    }

    public BankingProductDetailV3 brandName(String brandName) {
        this.brandName = brandName;
        return this;
    }

    public BankingProductDetailV3 description(String description) {
        this.description = description;
        return this;
    }

    public BankingProductDetailV3 effectiveFrom(OffsetDateTime effectiveFrom) {
        this.effectiveFrom = effectiveFrom;
        return this;
    }

    public BankingProductDetailV3 effectiveTo(OffsetDateTime effectiveTo) {
        this.effectiveTo = effectiveTo;
        return this;
    }

    public BankingProductDetailV3 isTailored(Boolean isTailored) {
        this.isTailored = isTailored;
        return this;
    }

    public BankingProductDetailV3 lastUpdated(OffsetDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
        return this;
    }

    public BankingProductDetailV3 name(String name) {
        this.name = name;
        return this;
    }

    public BankingProductDetailV3 productCategory(BankingProductCategory productCategory) {
        this.productCategory = productCategory;
        return this;
    }

    public BankingProductDetailV3 productId(String productId) {
        this.productId = productId;
        return this;
    }

    public BankingProductDetailV3 bundles(List<BankingProductBundle> bundles) {
        this.bundles = bundles;
        return this;
    }

    public BankingProductDetailV3 addBundlesItem(BankingProductBundle bundlesItem) {
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

    public BankingProductDetailV3 constraints(List<BankingProductConstraint> constraints) {
        this.constraints = constraints;
        return this;
    }

    public BankingProductDetailV3 addConstraintsItem(BankingProductConstraint constraintsItem) {
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

    public BankingProductDetailV3 depositRates(List<BankingProductDepositRateV2> depositRates) {
        this.depositRates = depositRates;
        return this;
    }

    public BankingProductDetailV3 addDepositRatesItem(BankingProductDepositRateV2 depositRatesItem) {
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
    public List<BankingProductDepositRateV2> getDepositRates() {
        return depositRates;
    }

    public void setDepositRates(List<BankingProductDepositRateV2> depositRates) {
        this.depositRates = depositRates;
    }

    public BankingProductDetailV3 eligibility(List<BankingProductEligibility> eligibility) {
        this.eligibility = eligibility;
        return this;
    }

    public BankingProductDetailV3 addEligibilityItem(BankingProductEligibility eligibilityItem) {
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

    public BankingProductDetailV3 features(List<BankingProductFeature> features) {
        this.features = features;
        return this;
    }

    public BankingProductDetailV3 addFeaturesItem(BankingProductFeature featuresItem) {
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

    public BankingProductDetailV3 fees(List<BankingProductFee> fees) {
        this.fees = fees;
        return this;
    }

    public BankingProductDetailV3 addFeesItem(BankingProductFee feesItem) {
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

    public BankingProductDetailV3 lendingRates(List<BankingProductLendingRateV2> lendingRates) {
        this.lendingRates = lendingRates;
        return this;
    }

    public BankingProductDetailV3 addLendingRatesItem(BankingProductLendingRateV2 lendingRatesItem) {
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
    public List<BankingProductLendingRateV2> getLendingRates() {
        return lendingRates;
    }

    public void setLendingRates(List<BankingProductLendingRateV2> lendingRates) {
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
            ", cardArt=" + cardArt +
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

