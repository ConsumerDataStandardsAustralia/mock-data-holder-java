package au.org.consumerdatastandards.client.model.energy;

import java.time.OffsetDateTime;

public interface EnergyPlan {
    /**
     * The ID of the specific plan
     *
     * @return planId
     */
    String getPlanId();

    void setPlanId(String planId);

    /**
     * The date and time from which this plan is effective (ie. is available for origination). Used to enable the articulation of products to the regime before they are available for customers to originate
     *
     * @return effectiveFrom
     */
    OffsetDateTime getEffectiveFrom();

    void setEffectiveFrom(OffsetDateTime effectiveFrom);

    /**
     * The date and time at which this plan will be retired and will no longer be offered. Used to enable the managed deprecation of plans
     *
     * @return effectiveTo
     */
    OffsetDateTime getEffectiveTo();

    void setEffectiveTo(OffsetDateTime effectiveTo);

    /**
     * The last date and time that the information for this plan was changed (or the creation date for the plan if it has never been altered)
     *
     * @return lastUpdated
     */
    OffsetDateTime getLastUpdated();

    void setLastUpdated(OffsetDateTime lastUpdated);

    /**
     * The display name of the plan
     *
     * @return displayName
     */
    String getDisplayName();

    void setDisplayName(String displayName);

    /**
     * A description of the plan
     *
     * @return description
     */
    String getDescription();

    void setDescription(String description);

    /**
     * The type of the plan
     *
     * @return type
     */
    TypeEnum getType();

    void setType(TypeEnum type);

    /**
     * The fuel types covered by the plan
     *
     * @return fuelType
     */
    FuelTypeEnum getFuelType();

    void setFuelType(FuelTypeEnum fuelType);

    /**
     * The ID of the brand under which this plan is offered
     *
     * @return brand
     */
    String getBrand();

    void setBrand(String brand);

    /**
     * The display name of the brand under which this plan is offered
     *
     * @return brandName
     */
    String getBrandName();

    void setBrandName(String brandName);

    /**
     * A link to an application web page where this plan can be applied for
     *
     * @return applicationUri
     */
    String getApplicationUri();

    void setApplicationUri(String applicationUri);

    /**
     * Get additionalInformation
     *
     * @return additionalInformation
     */
    EnergyPlanAdditionalInformation getAdditionalInformation();

    void setAdditionalInformation(EnergyPlanAdditionalInformation additionalInformation);

    /**
     * The type of customer that the plan is offered to.  If absent then the plan is available to all customers
     *
     * @return customerType
     */
    CustomerTypeEnum getCustomerType();

    void setCustomerType(CustomerTypeEnum customerType);

    /**
     * Get geography
     *
     * @return geography
     */
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
     * The fuel types covered by the plan
     */
    public enum FuelTypeEnum {
        ELECTRICITY,
        GAS,
        DUAL;
    }

    /**
     * The type of customer that the plan is offered to.  If absent then the plan is available to all customers
     */
    public enum CustomerTypeEnum {
        RESIDENTIAL,
        BUSINESS
    }
}
