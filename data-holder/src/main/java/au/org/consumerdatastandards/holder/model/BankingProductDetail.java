package au.org.consumerdatastandards.holder.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "BankingProduct")
public class BankingProductDetail {

    @Id
    @JsonProperty("productId")
    private String productId;

    @OneToOne (cascade = CascadeType.ALL)
    @JsonProperty("additionalInformation")
    private BankingProductAdditionalInformation additionalInformation;

    @JsonProperty("applicationUri")
    private String applicationUri;

    @JsonProperty("brand")
    private String brand;

    @JsonProperty("brandName")
    private String brandName;

    @JsonProperty("description")
    @Column(length = 2048)
    private String description;

    @JsonProperty("effectiveFrom")
    @DateTimeFormat(iso = ISO.DATE_TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private OffsetDateTime effectiveFrom;

    @JsonProperty("effectiveTo")
    @DateTimeFormat(iso = ISO.DATE_TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private OffsetDateTime effectiveTo;

    @JsonProperty("isTailored")
    private Boolean isTailored;

    @JsonProperty("lastUpdated")
    @DateTimeFormat(iso = ISO.DATE_TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private OffsetDateTime lastUpdated;

    @JsonProperty("name")
    private String name;

    @JsonProperty("productCategory")
    private BankingEnumProductCategory productCategory;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "product_bundles",
        joinColumns = @JoinColumn(name = "product_id"),
        inverseJoinColumns = @JoinColumn(name = "bundle_id"))
    @JsonProperty("bundles")
    @Valid
    private List<BankingProductBundle> bundles = null;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "product_constraints",
        joinColumns = @JoinColumn(name = "product_id"),
        inverseJoinColumns = @JoinColumn(name = "constraint_id"))
    @JsonProperty("constraints")
    @Valid
    private List<BankingProductConstraint> constraints = null;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "product_deposit_rates",
        joinColumns = @JoinColumn(name = "product_id"),
        inverseJoinColumns = @JoinColumn(name = "deposit_rate_id"))
    @JsonProperty("depositRates")
    @Valid
    private List<BankingProductDepositRate> depositRates = null;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "product_eligibility",
        joinColumns = @JoinColumn(name = "product_id"),
        inverseJoinColumns = @JoinColumn(name = "eligibility_id"))
    @JsonProperty("eligibility")
    @Valid
    private List<BankingProductEligibility> eligibility = null;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "product_features",
        joinColumns = @JoinColumn(name = "product_id"),
        inverseJoinColumns = @JoinColumn(name = "feature_id"))
    @JsonProperty("features")
    @Valid
    private List<BankingProductFeature> features = null;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "product_fees",
        joinColumns = @JoinColumn(name = "product_id"),
        inverseJoinColumns = @JoinColumn(name = "fee_id"))
    @JsonProperty("fees")
    @Valid
    private List<BankingProductFee> fees = null;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "product_lending_rates",
        joinColumns = @JoinColumn(name = "product_id"),
        inverseJoinColumns = @JoinColumn(name = "lending_rate_id"))
    @JsonProperty("lendingRates")
    @Valid
    private List<BankingProductLendingRate> lendingRates = null;

    public BankingProductDetail additionalInformation(BankingProductAdditionalInformation additionalInformation) {
        this.additionalInformation = additionalInformation;
        return this;
    }

    /**
     * Get additionalInformation
     *
     * @return additionalInformation
     */
    @ApiModelProperty()
    @Valid
    public BankingProductAdditionalInformation getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(BankingProductAdditionalInformation additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public BankingProductDetail applicationUri(String applicationUri) {
        this.applicationUri = applicationUri;
        return this;
    }

    /**
     * A link to the an application web page where this product can be applied for.
     *
     * @return applicationUri
     */
    @ApiModelProperty(value = "A link to the an application web page where this product can be applied for.")
    public String getApplicationUri() {
        return applicationUri;
    }

    public void setApplicationUri(String applicationUri) {
        this.applicationUri = applicationUri;
    }

    public BankingProductDetail brand(String brand) {
        this.brand = brand;
        return this;
    }

    /**
     * A label of the brand for the product. Able to be used for filtering. For data providers with single brands this value is still required
     *
     * @return brand
     */
    @ApiModelProperty(required = true, value = "A label of the brand for the product. Able to be used for filtering. For data providers with single brands this value is still required")
    @NotNull
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public BankingProductDetail brandName(String brandName) {
        this.brandName = brandName;
        return this;
    }

    /**
     * An optional display name of the brand
     *
     * @return brandName
     */
    @ApiModelProperty(value = "An optional display name of the brand")
    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public BankingProductDetail description(String description) {
        this.description = description;
        return this;
    }

    /**
     * A description of the product
     *
     * @return description
     */
    @ApiModelProperty(required = true, value = "A description of the product")
    @NotNull
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BankingProductDetail effectiveFrom(OffsetDateTime effectiveFrom) {
        this.effectiveFrom = effectiveFrom;
        return this;
    }

    /**
     * The date and time from which this product is effective (ie. is available for origination).  Used to enable the articulation of products to the regime before they are available for customers to originate
     *
     * @return effectiveFrom
     */
    @ApiModelProperty(value = "The date and time from which this product is effective (ie. is available for origination).  Used to enable the articulation of products to the regime before they are available for customers to originate")
    @Valid
    public OffsetDateTime getEffectiveFrom() {
        return effectiveFrom;
    }

    public void setEffectiveFrom(OffsetDateTime effectiveFrom) {
        this.effectiveFrom = effectiveFrom;
    }

    public BankingProductDetail effectiveTo(OffsetDateTime effectiveTo) {
        this.effectiveTo = effectiveTo;
        return this;
    }

    /**
     * The date and time at which this product will be retired and will no longer be offered.  Used to enable the managed deprecation of products
     *
     * @return effectiveTo
     */
    @ApiModelProperty(value = "The date and time at which this product will be retired and will no longer be offered.  Used to enable the managed deprecation of products")
    @Valid
    public OffsetDateTime getEffectiveTo() {
        return effectiveTo;
    }

    public void setEffectiveTo(OffsetDateTime effectiveTo) {
        this.effectiveTo = effectiveTo;
    }

    public BankingProductDetail isTailored(Boolean isTailored) {
        this.isTailored = isTailored;
        return this;
    }

    /**
     * Indicates whether the product is specifically tailored to a circumstance.  In this case fees and prices are significantly negotiated depending on context. While all products are open to a degree of tailoring this flag indicates that tailoring is expected and thus that the provision of specific fees and rates is not applicable
     *
     * @return isTailored
     */
    @ApiModelProperty(required = true, value = "Indicates whether the product is specifically tailored to a circumstance.  In this case fees and prices are significantly negotiated depending on context. While all products are open to a degree of tailoring this flag indicates that tailoring is expected and thus that the provision of specific fees and rates is not applicable")
    @NotNull
    public Boolean getIsTailored() {
        return isTailored;
    }

    public void setIsTailored(Boolean isTailored) {
        this.isTailored = isTailored;
    }

    public BankingProductDetail lastUpdated(OffsetDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
        return this;
    }

    /**
     * The last date and time that the information for this product was changed (or the creation date for the product if it has never been altered)
     *
     * @return lastUpdated
     */
    @ApiModelProperty(required = true, value = "The last date and time that the information for this product was changed (or the creation date for the product if it has never been altered)")
    @NotNull
    @Valid
    public OffsetDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(OffsetDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public BankingProductDetail name(String name) {
        this.name = name;
        return this;
    }

    /**
     * The display name of the product
     *
     * @return name
     */
    @ApiModelProperty(required = true, value = "The display name of the product")
    @NotNull
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BankingProductDetail productCategory(BankingEnumProductCategory productCategory) {
        this.productCategory = productCategory;
        return this;
    }

    /**
     * Get productCategory
     *
     * @return productCategory
     */
    @ApiModelProperty(required = true, value = "")
    @NotNull
    @Valid
    public BankingEnumProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(BankingEnumProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public BankingProductDetail productId(String productId) {
        this.productId = productId;
        return this;
    }

    /**
     * A provider specific unique identifier for this product. This identifier must be unique to a product but does not otherwise need to adhere to ID permanence guidelines.
     *
     * @return productId
     */
    @ApiModelProperty(required = true, value = "A provider specific unique identifier for this product. This identifier must be unique to a product but does not otherwise need to adhere to ID permanence guidelines.")
    @NotNull
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public BankingProductDetail bundles(List<BankingProductBundle> bundles) {
        this.bundles = bundles;
        return this;
    }

    public BankingProductDetail addBundlesItem(BankingProductBundle bundlesItem) {
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
    @ApiModelProperty(value = "An array of bundles that this product participates in.  Each bundle is described by free form information but also by a list of product IDs of the other products that are included in the bundle.  It is assumed that the current product is included in the bundle also")
    @Valid
    public List<BankingProductBundle> getBundles() {
        return bundles;
    }

    public void setBundles(List<BankingProductBundle> bundles) {
        this.bundles = bundles;
    }

    public BankingProductDetail constraints(List<BankingProductConstraint> constraints) {
        this.constraints = constraints;
        return this;
    }

    public BankingProductDetail addConstraintsItem(BankingProductConstraint constraintsItem) {
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
    @ApiModelProperty(value = "Constraints on the application for or operation of the product such as minimum balances or limit thresholds")
    @Valid
    public List<BankingProductConstraint> getConstraints() {
        return constraints;
    }

    public void setConstraints(List<BankingProductConstraint> constraints) {
        this.constraints = constraints;
    }

    public BankingProductDetail depositRates(List<BankingProductDepositRate> depositRates) {
        this.depositRates = depositRates;
        return this;
    }

    public BankingProductDetail addDepositRatesItem(BankingProductDepositRate depositRatesItem) {
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
    @ApiModelProperty(value = "Interest rates available for deposits")
    @Valid
    public List<BankingProductDepositRate> getDepositRates() {
        return depositRates;
    }

    public void setDepositRates(List<BankingProductDepositRate> depositRates) {
        this.depositRates = depositRates;
    }

    public BankingProductDetail eligibility(List<BankingProductEligibility> eligibility) {
        this.eligibility = eligibility;
        return this;
    }

    public BankingProductDetail addEligibilityItem(BankingProductEligibility eligibilityItem) {
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
    @ApiModelProperty(value = "Eligibility criteria for the product")
    @Valid
    public List<BankingProductEligibility> getEligibility() {
        return eligibility;
    }

    public void setEligibility(List<BankingProductEligibility> eligibility) {
        this.eligibility = eligibility;
    }

    public BankingProductDetail features(List<BankingProductFeature> features) {
        this.features = features;
        return this;
    }

    public BankingProductDetail addFeaturesItem(BankingProductFeature featuresItem) {
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
    @ApiModelProperty(value = "Array of features available for the product")
    @Valid
    public List<BankingProductFeature> getFeatures() {
        return features;
    }

    public void setFeatures(List<BankingProductFeature> features) {
        this.features = features;
    }

    public BankingProductDetail fees(List<BankingProductFee> fees) {
        this.fees = fees;
        return this;
    }

    public BankingProductDetail addFeesItem(BankingProductFee feesItem) {
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
    @ApiModelProperty(value = "Fees applicable for the product")
    @Valid
    public List<BankingProductFee> getFees() {
        return fees;
    }

    public void setFees(List<BankingProductFee> fees) {
        this.fees = fees;
    }

    public BankingProductDetail lendingRates(List<BankingProductLendingRate> lendingRates) {
        this.lendingRates = lendingRates;
        return this;
    }

    public BankingProductDetail addLendingRatesItem(BankingProductLendingRate lendingRatesItem) {
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
    @ApiModelProperty(value = "Interest rates charged against lending balances")
    @Valid
    public List<BankingProductLendingRate> getLendingRates() {
        return lendingRates;
    }

    public void setLendingRates(List<BankingProductLendingRate> lendingRates) {
        this.lendingRates = lendingRates;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankingProductDetail that = (BankingProductDetail) o;
        return Objects.equals(productId, that.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId);
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

