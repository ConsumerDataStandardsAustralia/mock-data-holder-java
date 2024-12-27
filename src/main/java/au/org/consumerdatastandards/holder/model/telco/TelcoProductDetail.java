package au.org.consumerdatastandards.holder.model.telco;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * TelcoProductDetail
 */
public class TelcoProductDetail {
    private String productId;

    private String effectiveFrom;

    private String effectiveTo;

    private String lastUpdated;

    private String displayName;

    private String description;

    private TypeEnum type = TypeEnum.MOBILE;

    private PurposeEnum purpose = PurposeEnum.ALL;

    private BillingTypeEnum billingType = BillingTypeEnum.PRE_PAID;

    private TelcoContract contract;

    private Boolean bundle;

    private String brand;

    private String brandName;

    @Valid
    private List<TelcoProductPricing> pricing = new ArrayList<>();

    private String thirdPartyAgentId;

    private String thirdPartyAgentName;

    private String applicationUri;

    private TelcoAdditionalInformation additionalInformation;

    @Valid
    private List<TelcoProductDetailMeteringCharges> meteringCharges = null;

    @Valid
    private List<TelcoProductDetailBundles> bundles = null;

    @Valid
    private List<TelcoProductDetailPlan> plans = null;

    @Valid
    private List<TelcoProductDetailDiscounts> discounts = null;

    @Valid
    private List<TelcoProductDetailIncentives> incentives = null;

    /**
     * The ID of the specific product
     *
     * @return productId
     */
    @ApiModelProperty(required = true, value = "The ID of the specific product")
    @NotNull
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    /**
     * The date and time from which this product is effective (i.e. is available for origination). Used to enable the articulation of products to the regime before they are available for customers to originate.
     *
     * @return effectiveFrom
     */
    @ApiModelProperty(value = "The date and time from which this product is effective (i.e. is available for origination). Used to enable the articulation of products to the regime before they are available for customers to originate.")
    public String getEffectiveFrom() {
        return effectiveFrom;
    }

    public void setEffectiveFrom(String effectiveFrom) {
        this.effectiveFrom = effectiveFrom;
    }

    /**
     * The date and time at which this product will be retired and will no longer be offered. Used to enable the managed deprecation of plans
     *
     * @return effectiveTo
     */
    @ApiModelProperty(value = "The date and time at which this product will be retired and will no longer be offered. Used to enable the managed deprecation of plans")
    public String getEffectiveTo() {
        return effectiveTo;
    }

    public void setEffectiveTo(String effectiveTo) {
        this.effectiveTo = effectiveTo;
    }

    /**
     * The last date and time that the information for this plan was changed (or the creation date for the plan if it has never been altered)
     *
     * @return lastUpdated
     */
    @ApiModelProperty(value = "The last date and time that the information for this plan was changed (or the creation date for the plan if it has never been altered)")
    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    /**
     * The display name of the product.
     *
     * @return displayName
     */
    @ApiModelProperty(value = "The display name of the product.")
    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /**
     * A description of the product.
     *
     * @return description
     */
    @ApiModelProperty(value = "A description of the product.")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * The type of product. [MOBILE](https://www.legislation.gov.au/Details/C2022C00170/Html/Volume_1#_Toc95898745) service or BROADBAND fixed internet service
     *
     * @return type
     */
    @ApiModelProperty(required = true, value = "The type of product. [MOBILE](https://www.legislation.gov.au/Details/C2022C00170/Html/Volume_1#_Toc95898745) service or BROADBAND fixed internet service")
    @NotNull
    public TypeEnum getType() {
        return type;
    }

    public void setType(TypeEnum type) {
        this.type = type;
    }

    /**
     * The purpose type of the product. If absent, then the value PERSONAL is assumed
     *
     * @return purpose
     */
    @ApiModelProperty(value = "The purpose type of the product. If absent, then the value PERSONAL is assumed")
    public PurposeEnum getPurpose() {
        return purpose;
    }

    public void setPurpose(PurposeEnum purpose) {
        this.purpose = purpose;
    }

    /**
     * The type of product
     *
     * @return billingType
     */
    @ApiModelProperty(required = true, value = "The type of product")
    @NotNull
    public BillingTypeEnum getBillingType() {
        return billingType;
    }

    public void setBillingType(BillingTypeEnum billingType) {
        this.billingType = billingType;
    }

    /**
     * Get contract
     *
     * @return contract
     */
    @ApiModelProperty(value = "")
    @Valid
    public TelcoContract getContract() {
        return contract;
    }

    public void setContract(TelcoContract contract) {
        this.contract = contract;
    }

    /**
     * Required if part of a bundle. If not present FALSE is assumed
     *
     * @return bundle
     */
    @ApiModelProperty(value = "Required if part of a bundle. If not present FALSE is assumed")
    public Boolean getBundle() {
        return bundle;
    }

    public void setBundle(Boolean bundle) {
        this.bundle = bundle;
    }

    /**
     * The ID of the brand under which this product is offered
     *
     * @return brand
     */
    @ApiModelProperty(required = true, value = "The ID of the brand under which this product is offered")
    @NotNull
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * The display name of the brand under which this product is offered
     *
     * @return brandName
     */
    @ApiModelProperty(required = true, value = "The display name of the brand under which this product is offered")
    @NotNull
    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    /**
     * List of pricing details for the product plan
     *
     * @return pricing
     */
    @ApiModelProperty(required = true, value = "List of pricing details for the product plan")
    @NotNull
    @Valid
    public List<TelcoProductPricing> getPricing() {
        return pricing;
    }

    public void setPricing(List<TelcoProductPricing> pricing) {
        this.pricing = pricing;
    }

    /**
     * The ID of the Third Party through which this product may be originated
     *
     * @return thirdPartyAgentId
     */
    @ApiModelProperty(value = "The ID of the Third Party through which this product may be originated")
    public String getThirdPartyAgentId() {
        return thirdPartyAgentId;
    }

    public void setThirdPartyAgentId(String thirdPartyAgentId) {
        this.thirdPartyAgentId = thirdPartyAgentId;
    }

    /**
     * The display name of the Third Party through which this product may be originated
     *
     * @return thirdPartyAgentName
     */
    @ApiModelProperty(value = "The display name of the Third Party through which this product may be originated")
    public String getThirdPartyAgentName() {
        return thirdPartyAgentName;
    }

    public void setThirdPartyAgentName(String thirdPartyAgentName) {
        this.thirdPartyAgentName = thirdPartyAgentName;
    }

    /**
     * A link to an application web page where this plan can be applied for
     *
     * @return applicationUri
     */
    @ApiModelProperty(value = "A link to an application web page where this plan can be applied for")
    public String getApplicationUri() {
        return applicationUri;
    }

    public void setApplicationUri(String applicationUri) {
        this.applicationUri = applicationUri;
    }

    /**
     * Get additionalInformation
     *
     * @return additionalInformation
     */
    @ApiModelProperty(value = "")
    @Valid
    public TelcoAdditionalInformation getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(TelcoAdditionalInformation additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public TelcoProductDetail meteringCharges(List<TelcoProductDetailMeteringCharges> meteringCharges) {
        this.meteringCharges = meteringCharges;
        return this;
    }

    public TelcoProductDetail addMeteringChargesItem(TelcoProductDetailMeteringCharges meteringChargesItem) {
        if (this.meteringCharges == null) {
            this.meteringCharges = new ArrayList<>();
        }
        this.meteringCharges.add(meteringChargesItem);
        return this;
    }

    /**
     * Charges for metering included in the plan
     *
     * @return meteringCharges
     */
    @ApiModelProperty(value = "Charges for metering included in the plan")
    @Valid
    public List<TelcoProductDetailMeteringCharges> getMeteringCharges() {
        return meteringCharges;
    }

    public void setMeteringCharges(List<TelcoProductDetailMeteringCharges> meteringCharges) {
        this.meteringCharges = meteringCharges;
    }

    public TelcoProductDetail bundles(List<TelcoProductDetailBundles> bundles) {
        this.bundles = bundles;
        return this;
    }

    public TelcoProductDetail addBundlesItem(TelcoProductDetailBundles bundlesItem) {
        if (this.bundles == null) {
            this.bundles = new ArrayList<>();
        }
        this.bundles.add(bundlesItem);
        return this;
    }

    /**
     * Bundles the product can be part of
     *
     * @return bundles
     */
    @ApiModelProperty(value = "Bundles the product can be part of")
    @Valid
    public List<TelcoProductDetailBundles> getBundles() {
        return bundles;
    }

    public void setBundles(List<TelcoProductDetailBundles> bundles) {
        this.bundles = bundles;
    }

    public TelcoProductDetail plans(List<TelcoProductDetailPlan> plans) {
        this.plans = plans;
        return this;
    }

    public TelcoProductDetail addPlansItem(TelcoProductDetailPlan plansItem) {
        if (this.plans == null) {
            this.plans = new ArrayList<>();
        }
        this.plans.add(plansItem);
        return this;
    }

    /**
     * Plans associated to the product
     *
     * @return plans
     */
    @ApiModelProperty(value = "Plans associated to the product")
    @Valid
    public List<TelcoProductDetailPlan> getPlans() {
        return plans;
    }

    public void setPlans(List<TelcoProductDetailPlan> plans) {
        this.plans = plans;
    }

    public TelcoProductDetail discounts(List<TelcoProductDetailDiscounts> discounts) {
        this.discounts = discounts;
        return this;
    }

    public TelcoProductDetail addDiscountsItem(TelcoProductDetailDiscounts discountsItem) {
        if (this.discounts == null) {
            this.discounts = new ArrayList<>();
        }
        this.discounts.add(discountsItem);
        return this;
    }

    /**
     * Discounts associated to the product
     *
     * @return discounts
     */
    @ApiModelProperty(value = "Discounts associated to the product")
    @Valid
    public List<TelcoProductDetailDiscounts> getDiscounts() {
        return discounts;
    }

    public void setDiscounts(List<TelcoProductDetailDiscounts> discounts) {
        this.discounts = discounts;
    }

    public TelcoProductDetail incentives(List<TelcoProductDetailIncentives> incentives) {
        this.incentives = incentives;
        return this;
    }

    public TelcoProductDetail addIncentivesItem(TelcoProductDetailIncentives incentivesItem) {
        if (this.incentives == null) {
            this.incentives = new ArrayList<>();
        }
        this.incentives.add(incentivesItem);
        return this;
    }

    /**
     * Incentives associated to the product
     *
     * @return incentives
     */
    @ApiModelProperty(value = "Incentives associated to the product")
    @Valid
    public List<TelcoProductDetailIncentives> getIncentives() {
        return incentives;
    }

    public void setIncentives(List<TelcoProductDetailIncentives> incentives) {
        this.incentives = incentives;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TelcoProductDetail telcoProductDetail = (TelcoProductDetail) o;
        return Objects.equals(this.productId, telcoProductDetail.productId) &&
                Objects.equals(this.effectiveFrom, telcoProductDetail.effectiveFrom) &&
                Objects.equals(this.effectiveTo, telcoProductDetail.effectiveTo) &&
                Objects.equals(this.lastUpdated, telcoProductDetail.lastUpdated) &&
                Objects.equals(this.displayName, telcoProductDetail.displayName) &&
                Objects.equals(this.description, telcoProductDetail.description) &&
                Objects.equals(this.type, telcoProductDetail.type) &&
                Objects.equals(this.purpose, telcoProductDetail.purpose) &&
                Objects.equals(this.billingType, telcoProductDetail.billingType) &&
                Objects.equals(this.contract, telcoProductDetail.contract) &&
                Objects.equals(this.bundle, telcoProductDetail.bundle) &&
                Objects.equals(this.brand, telcoProductDetail.brand) &&
                Objects.equals(this.brandName, telcoProductDetail.brandName) &&
                Objects.equals(this.pricing, telcoProductDetail.pricing) &&
                Objects.equals(this.thirdPartyAgentId, telcoProductDetail.thirdPartyAgentId) &&
                Objects.equals(this.thirdPartyAgentName, telcoProductDetail.thirdPartyAgentName) &&
                Objects.equals(this.applicationUri, telcoProductDetail.applicationUri) &&
                Objects.equals(this.additionalInformation, telcoProductDetail.additionalInformation) &&
                Objects.equals(this.meteringCharges, telcoProductDetail.meteringCharges) &&
                Objects.equals(this.bundles, telcoProductDetail.bundles) &&
                Objects.equals(this.plans, telcoProductDetail.plans) &&
                Objects.equals(this.discounts, telcoProductDetail.discounts) &&
                Objects.equals(this.incentives, telcoProductDetail.incentives);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, effectiveFrom, effectiveTo, lastUpdated, displayName, description, type, purpose,
                billingType, contract, bundle, brand, brandName, pricing, thirdPartyAgentId, thirdPartyAgentName,
                applicationUri, additionalInformation, meteringCharges, bundles, plans, discounts, incentives);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TelcoProductDetail {\n");
        sb.append("    productId: ").append(toIndentedString(productId)).append("\n");
        sb.append("    effectiveFrom: ").append(toIndentedString(effectiveFrom)).append("\n");
        sb.append("    effectiveTo: ").append(toIndentedString(effectiveTo)).append("\n");
        sb.append("    lastUpdated: ").append(toIndentedString(lastUpdated)).append("\n");
        sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    purpose: ").append(toIndentedString(purpose)).append("\n");
        sb.append("    billingType: ").append(toIndentedString(billingType)).append("\n");
        sb.append("    contract: ").append(toIndentedString(contract)).append("\n");
        sb.append("    bundle: ").append(toIndentedString(bundle)).append("\n");
        sb.append("    brand: ").append(toIndentedString(brand)).append("\n");
        sb.append("    brandName: ").append(toIndentedString(brandName)).append("\n");
        sb.append("    pricing: ").append(toIndentedString(pricing)).append("\n");
        sb.append("    thirdPartyAgentId: ").append(toIndentedString(thirdPartyAgentId)).append("\n");
        sb.append("    thirdPartyAgentName: ").append(toIndentedString(thirdPartyAgentName)).append("\n");
        sb.append("    applicationUri: ").append(toIndentedString(applicationUri)).append("\n");
        sb.append("    additionalInformation: ").append(toIndentedString(additionalInformation)).append("\n");
        sb.append("    meteringCharges: ").append(toIndentedString(meteringCharges)).append("\n");
        sb.append("    bundles: ").append(toIndentedString(bundles)).append("\n");
        sb.append("    plans: ").append(toIndentedString(plans)).append("\n");
        sb.append("    discounts: ").append(toIndentedString(discounts)).append("\n");
        sb.append("    incentives: ").append(toIndentedString(incentives)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
