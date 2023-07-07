package au.org.consumerdatastandards.holder.model.telco;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * TelcoProduct
 */
public class TelcoProduct {
    private String productId;

    private String effectiveFrom;

    private String effectiveTo;

    private String lastUpdated;

    private String displayName;

    private String description;

    private TypeEnum type = TypeEnum.MOBILE;

    private PurposeEnum purpose = PurposeEnum.PERSONAL;

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

    public TelcoProduct productId(String productId) {
        this.productId = productId;
        return this;
    }

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

    public TelcoProduct effectiveFrom(String effectiveFrom) {
        this.effectiveFrom = effectiveFrom;
        return this;
    }

    /**
     * The date and time from which this product is effective (ie. is available for origination). Used to enable the articulation of products to the regime before they are available for customers to originate
     *
     * @return effectiveFrom
     */
    @ApiModelProperty(value = "The date and time from which this product is effective (ie. is available for origination). Used to enable the articulation of products to the regime before they are available for customers to originate")
    public String getEffectiveFrom() {
        return effectiveFrom;
    }

    public void setEffectiveFrom(String effectiveFrom) {
        this.effectiveFrom = effectiveFrom;
    }

    public TelcoProduct effectiveTo(String effectiveTo) {
        this.effectiveTo = effectiveTo;
        return this;
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

    public TelcoProduct lastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
        return this;
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

    public TelcoProduct displayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    /**
     * The display name of the product
     *
     * @return displayName
     */
    @ApiModelProperty(value = "The display name of the product")
    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public TelcoProduct description(String description) {
        this.description = description;
        return this;
    }

    /**
     * A description of the product
     *
     * @return description
     */
    @ApiModelProperty(value = "A description of the product")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TelcoProduct type(TypeEnum type) {
        this.type = type;
        return this;
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

    public TelcoProduct purpose(PurposeEnum purpose) {
        this.purpose = purpose;
        return this;
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

    public TelcoProduct billingType(BillingTypeEnum billingType) {
        this.billingType = billingType;
        return this;
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

    public TelcoProduct contract(TelcoContract contract) {
        this.contract = contract;
        return this;
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

    public TelcoProduct bundle(Boolean bundle) {
        this.bundle = bundle;
        return this;
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

    public TelcoProduct brand(String brand) {
        this.brand = brand;
        return this;
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

    public TelcoProduct brandName(String brandName) {
        this.brandName = brandName;
        return this;
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

    public TelcoProduct pricing(List<TelcoProductPricing> pricing) {
        this.pricing = pricing;
        return this;
    }

    public TelcoProduct addPricingItem(TelcoProductPricing pricingItem) {
        this.pricing.add(pricingItem);
        return this;
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

    public TelcoProduct thirdPartyAgentId(String thirdPartyAgentId) {
        this.thirdPartyAgentId = thirdPartyAgentId;
        return this;
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

    public TelcoProduct thirdPartyAgentName(String thirdPartyAgentName) {
        this.thirdPartyAgentName = thirdPartyAgentName;
        return this;
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

    public TelcoProduct applicationUri(String applicationUri) {
        this.applicationUri = applicationUri;
        return this;
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

    public TelcoProduct additionalInformation(TelcoAdditionalInformation additionalInformation) {
        this.additionalInformation = additionalInformation;
        return this;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TelcoProduct telcoProduct = (TelcoProduct) o;
        return Objects.equals(this.productId, telcoProduct.productId) &&
                Objects.equals(this.effectiveFrom, telcoProduct.effectiveFrom) &&
                Objects.equals(this.effectiveTo, telcoProduct.effectiveTo) &&
                Objects.equals(this.lastUpdated, telcoProduct.lastUpdated) &&
                Objects.equals(this.displayName, telcoProduct.displayName) &&
                Objects.equals(this.description, telcoProduct.description) &&
                Objects.equals(this.type, telcoProduct.type) &&
                Objects.equals(this.purpose, telcoProduct.purpose) &&
                Objects.equals(this.billingType, telcoProduct.billingType) &&
                Objects.equals(this.contract, telcoProduct.contract) &&
                Objects.equals(this.bundle, telcoProduct.bundle) &&
                Objects.equals(this.brand, telcoProduct.brand) &&
                Objects.equals(this.brandName, telcoProduct.brandName) &&
                Objects.equals(this.pricing, telcoProduct.pricing) &&
                Objects.equals(this.thirdPartyAgentId, telcoProduct.thirdPartyAgentId) &&
                Objects.equals(this.thirdPartyAgentName, telcoProduct.thirdPartyAgentName) &&
                Objects.equals(this.applicationUri, telcoProduct.applicationUri) &&
                Objects.equals(this.additionalInformation, telcoProduct.additionalInformation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, effectiveFrom, effectiveTo, lastUpdated, displayName, description, type, purpose, billingType, contract, bundle, brand, brandName, pricing, thirdPartyAgentId, thirdPartyAgentName, applicationUri, additionalInformation);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TelcoProduct {\n");
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

