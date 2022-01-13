package au.org.consumerdatastandards.holder.model.energy;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * EnergyPlan
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen",
        date = "2022-01-11T14:03:27.755+11:00[Australia/Sydney]")
public class EnergyPlan {
    @JsonProperty("planId")
    private String planId;

    @JsonProperty("effectiveFrom")
    private String effectiveFrom;

    @JsonProperty("effectiveTo")
    private String effectiveTo;

    @JsonProperty("lastUpdated")
    private String lastUpdated;

    @JsonProperty("displayName")
    private String displayName;

    @JsonProperty("description")
    private String description;

    /**
     * The type of the plan
     */
    public enum TypeEnum {
        STANDING("STANDING"),

        MARKET("MARKET"),

        REGULATED("REGULATED");

        private String value;

        TypeEnum(String value) {
            this.value = value;
        }

        @JsonValue
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        @JsonCreator
        public static TypeEnum fromValue(String value) {
            for (TypeEnum b : TypeEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    @JsonProperty("type")
    private TypeEnum type;

    /**
     * The fuel types covered by the plan
     */
    public enum FuelTypeEnum {
        ELECTRICITY("ELECTRICITY"),

        GAS("GAS"),

        DUAL("DUAL");

        private String value;

        FuelTypeEnum(String value) {
            this.value = value;
        }

        @JsonValue
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        @JsonCreator
        public static FuelTypeEnum fromValue(String value) {
            for (FuelTypeEnum b : FuelTypeEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    @JsonProperty("fuelType")
    private FuelTypeEnum fuelType;

    @JsonProperty("brand")
    private String brand;

    @JsonProperty("brandName")
    private String brandName;

    @JsonProperty("applicationUri")
    private String applicationUri;

    @JsonProperty("additionalInformation")
    private EnergyPlanAdditionalInformation additionalInformation;

    /**
     * The type of customer that the plan is offered to.  If absent then the plan is available to all customers
     */
    public enum CustomerTypeEnum {
        RESIDENTIAL("RESIDENTIAL"),

        BUSINESS("BUSINESS");

        private String value;

        CustomerTypeEnum(String value) {
            this.value = value;
        }

        @JsonValue
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        @JsonCreator
        public static CustomerTypeEnum fromValue(String value) {
            for (CustomerTypeEnum b : CustomerTypeEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    @JsonProperty("customerType")
    private CustomerTypeEnum customerType;

    @JsonProperty("geography")
    private EnergyPlanGeography geography;

    public EnergyPlan planId(String planId) {
        this.planId = planId;
        return this;
    }

    /**
     * The ID of the specific plan
     *
     * @return planId
     */
    @ApiModelProperty(required = true,
            value = "The ID of the specific plan")
    @NotNull


    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    public EnergyPlan effectiveFrom(String effectiveFrom) {
        this.effectiveFrom = effectiveFrom;
        return this;
    }

    /**
     * The date and time from which this plan is effective (ie. is available for origination). Used to enable the articulation of products to the regime before they are available for customers to originate
     *
     * @return effectiveFrom
     */
    @ApiModelProperty(value = "The date and time from which this plan is effective (ie. is available for origination). Used to enable the articulation of products to the regime before they are available for customers to originate")


    public String getEffectiveFrom() {
        return effectiveFrom;
    }

    public void setEffectiveFrom(String effectiveFrom) {
        this.effectiveFrom = effectiveFrom;
    }

    public EnergyPlan effectiveTo(String effectiveTo) {
        this.effectiveTo = effectiveTo;
        return this;
    }

    /**
     * The date and time at which this plan will be retired and will no longer be offered. Used to enable the managed deprecation of plans
     *
     * @return effectiveTo
     */
    @ApiModelProperty(value = "The date and time at which this plan will be retired and will no longer be offered. Used to enable the managed deprecation of plans")


    public String getEffectiveTo() {
        return effectiveTo;
    }

    public void setEffectiveTo(String effectiveTo) {
        this.effectiveTo = effectiveTo;
    }

    public EnergyPlan lastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
        return this;
    }

    /**
     * The last date and time that the information for this plan was changed (or the creation date for the plan if it has never been altered)
     *
     * @return lastUpdated
     */
    @ApiModelProperty(required = true,
            value = "The last date and time that the information for this plan was changed (or the creation date for the plan if it has never been altered)")
    @NotNull


    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public EnergyPlan displayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    /**
     * The display name of the plan
     *
     * @return displayName
     */
    @ApiModelProperty(value = "The display name of the plan")


    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public EnergyPlan description(String description) {
        this.description = description;
        return this;
    }

    /**
     * A description of the plan
     *
     * @return description
     */
    @ApiModelProperty(value = "A description of the plan")


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EnergyPlan type(TypeEnum type) {
        this.type = type;
        return this;
    }

    /**
     * The type of the plan
     *
     * @return type
     */
    @ApiModelProperty(required = true,
            value = "The type of the plan")
    @NotNull


    public TypeEnum getType() {
        return type;
    }

    public void setType(TypeEnum type) {
        this.type = type;
    }

    public EnergyPlan fuelType(FuelTypeEnum fuelType) {
        this.fuelType = fuelType;
        return this;
    }

    /**
     * The fuel types covered by the plan
     *
     * @return fuelType
     */
    @ApiModelProperty(required = true,
            value = "The fuel types covered by the plan")
    @NotNull


    public FuelTypeEnum getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelTypeEnum fuelType) {
        this.fuelType = fuelType;
    }

    public EnergyPlan brand(String brand) {
        this.brand = brand;
        return this;
    }

    /**
     * The ID of the brand under which this plan is offered
     *
     * @return brand
     */
    @ApiModelProperty(required = true,
            value = "The ID of the brand under which this plan is offered")
    @NotNull


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public EnergyPlan brandName(String brandName) {
        this.brandName = brandName;
        return this;
    }

    /**
     * The display name of the brand under which this plan is offered
     *
     * @return brandName
     */
    @ApiModelProperty(required = true,
            value = "The display name of the brand under which this plan is offered")
    @NotNull


    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public EnergyPlan applicationUri(String applicationUri) {
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

    public EnergyPlan additionalInformation(EnergyPlanAdditionalInformation additionalInformation) {
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

    public EnergyPlanAdditionalInformation getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(EnergyPlanAdditionalInformation additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public EnergyPlan customerType(CustomerTypeEnum customerType) {
        this.customerType = customerType;
        return this;
    }

    /**
     * The type of customer that the plan is offered to.  If absent then the plan is available to all customers
     *
     * @return customerType
     */
    @ApiModelProperty(value = "The type of customer that the plan is offered to.  If absent then the plan is available to all customers")


    public CustomerTypeEnum getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerTypeEnum customerType) {
        this.customerType = customerType;
    }

    public EnergyPlan geography(EnergyPlanGeography geography) {
        this.geography = geography;
        return this;
    }

    /**
     * Get geography
     *
     * @return geography
     */
    @ApiModelProperty(value = "")

    @Valid

    public EnergyPlanGeography getGeography() {
        return geography;
    }

    public void setGeography(EnergyPlanGeography geography) {
        this.geography = geography;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EnergyPlan energyPlan = (EnergyPlan) o;
        return Objects.equals(this.planId, energyPlan.planId) &&
                Objects.equals(this.effectiveFrom, energyPlan.effectiveFrom) &&
                Objects.equals(this.effectiveTo, energyPlan.effectiveTo) &&
                Objects.equals(this.lastUpdated, energyPlan.lastUpdated) &&
                Objects.equals(this.displayName, energyPlan.displayName) &&
                Objects.equals(this.description, energyPlan.description) &&
                Objects.equals(this.type, energyPlan.type) &&
                Objects.equals(this.fuelType, energyPlan.fuelType) &&
                Objects.equals(this.brand, energyPlan.brand) &&
                Objects.equals(this.brandName, energyPlan.brandName) &&
                Objects.equals(this.applicationUri, energyPlan.applicationUri) &&
                Objects.equals(this.additionalInformation, energyPlan.additionalInformation) &&
                Objects.equals(this.customerType, energyPlan.customerType) &&
                Objects.equals(this.geography, energyPlan.geography);
    }

    @Override
    public int hashCode() {
        return Objects.hash(planId, effectiveFrom, effectiveTo, lastUpdated, displayName, description, type, fuelType, brand, brandName, applicationUri, additionalInformation, customerType, geography);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyPlan {\n");

        sb.append("    planId: ").append(toIndentedString(planId)).append("\n");
        sb.append("    effectiveFrom: ").append(toIndentedString(effectiveFrom)).append("\n");
        sb.append("    effectiveTo: ").append(toIndentedString(effectiveTo)).append("\n");
        sb.append("    lastUpdated: ").append(toIndentedString(lastUpdated)).append("\n");
        sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    fuelType: ").append(toIndentedString(fuelType)).append("\n");
        sb.append("    brand: ").append(toIndentedString(brand)).append("\n");
        sb.append("    brandName: ").append(toIndentedString(brandName)).append("\n");
        sb.append("    applicationUri: ").append(toIndentedString(applicationUri)).append("\n");
        sb.append("    additionalInformation: ").append(toIndentedString(additionalInformation)).append("\n");
        sb.append("    customerType: ").append(toIndentedString(customerType)).append("\n");
        sb.append("    geography: ").append(toIndentedString(geography)).append("\n");
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

