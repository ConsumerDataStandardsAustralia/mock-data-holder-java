package au.org.consumerdatastandards.holder.model.energy;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.time.OffsetDateTime;

public interface EnergyPlan {
    /**
     * The ID of the specific plan
     *
     * @return planId
     */
    @ApiModelProperty(required = true,value  = "The ID of the specific plan")
    @NotNull
    String getPlanId();

    void setPlanId(String planId);

    /**
     * The date and time from which this plan is effective (ie. is available for origination). Used to enable the articulation of products to the regime before they are available for customers to originate
     *
     * @return effectiveFrom
     */
    @ApiModelProperty(value = "The date and time from which this plan is effective (ie. is available for origination). Used to enable the articulation of products to the regime before they are available for customers to originate")
    OffsetDateTime getEffectiveFrom();

    void setEffectiveFrom(OffsetDateTime effectiveFrom);

    /**
     * The date and time at which this plan will be retired and will no longer be offered. Used to enable the managed deprecation of plans
     *
     * @return effectiveTo
     */
    @ApiModelProperty(value = "The date and time at which this plan will be retired and will no longer be offered. Used to enable the managed deprecation of plans")
    OffsetDateTime getEffectiveTo();

    void setEffectiveTo(OffsetDateTime effectiveTo);

    /**
     * The last date and time that the information for this plan was changed (or the creation date for the plan if it has never been altered)
     *
     * @return lastUpdated
     */
    @ApiModelProperty(required = true,
            value = "The last date and time that the information for this plan was changed (or the creation date for the plan if it has never been altered)")
    @NotNull
    OffsetDateTime getLastUpdated();

    void setLastUpdated(OffsetDateTime lastUpdated);

    /**
     * The display name of the plan
     *
     * @return displayName
     */
    @ApiModelProperty(value = "The display name of the plan")
    String getDisplayName();

    void setDisplayName(String displayName);

    /**
     * A description of the plan
     *
     * @return description
     */
    @ApiModelProperty(value = "A description of the plan")
    String getDescription();

    void setDescription(String description);

    /**
     * The type of the plan
     *
     * @return type
     */
    @ApiModelProperty(required = true, value = "The type of the plan")
    @NotNull
    TypeEnum getType();

    void setType(TypeEnum type);

    /**
     * The fuel types covered by the plan
     *
     * @return fuelType
     */
    @ApiModelProperty(required = true, value = "The fuel types covered by the plan")
    @NotNull
    FuelTypeEnum getFuelType();

    void setFuelType(FuelTypeEnum fuelType);

    /**
     * The ID of the brand under which this plan is offered
     *
     * @return brand
     */
    @ApiModelProperty(required = true, value = "The ID of the brand under which this plan is offered")
    @NotNull
    String getBrand();

    void setBrand(String brand);

    /**
     * The display name of the brand under which this plan is offered
     *
     * @return brandName
     */
    @ApiModelProperty(required = true, value = "The display name of the brand under which this plan is offered")
    @NotNull
    String getBrandName();

    void setBrandName(String brandName);

    /**
     * A link to an application web page where this plan can be applied for
     *
     * @return applicationUri
     */
    @ApiModelProperty(value = "A link to an application web page where this plan can be applied for")
    String getApplicationUri();

    void setApplicationUri(String applicationUri);

    /**
     * Get additionalInformation
     *
     * @return additionalInformation
     */
    @ApiModelProperty(value = "Object that contains links to additional information on specific topics")
    EnergyPlanAdditionalInformation getAdditionalInformation();

    void setAdditionalInformation(EnergyPlanAdditionalInformation additionalInformation);

    /**
     * The type of customer that the plan is offered to.  If absent then the plan is available to all customers
     *
     * @return customerType
     */
    @ApiModelProperty("The type of customer that the plan is offered to.  If absent then the plan is available to all customers")
    CustomerTypeEnum getCustomerType();

    void setCustomerType(CustomerTypeEnum customerType);

    /**
     * Get geography
     *
     * @return geography
     */
    @ApiModelProperty("Describes the geographical area that the plan is available for. If absent then it is assumed the plan is not geographically limited")
    EnergyPlanGeography getGeography();

    void setGeography(EnergyPlanGeography geography);

    /**
     * The type of the plan
     */
    public enum TypeEnum {
        STANDING,
        MARKET,
        REGULATED
    }

    /**
     * The type of customer that the plan is offered to.  If absent then the plan is available to all customers
     */
    public enum CustomerTypeEnum {
        RESIDENTIAL,
        BUSINESS
    }
}
