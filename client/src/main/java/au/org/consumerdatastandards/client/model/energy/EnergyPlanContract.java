package au.org.consumerdatastandards.client.model.energy;

import java.util.List;

public interface EnergyPlanContract {
    /**
     * Free text field containing additional information of the fees for this contract
     *
     * @return additionalFeeInformation
     */
    String getAdditionalFeeInformation();

    void setAdditionalFeeInformation(String additionalFeeInformation);

    /**
     * The pricing model for the contract.  Contracts for gas must use SINGLE_RATE.  Note that the detail for the enumeration values are:<ul><li>**SINGLE_RATE** - all energy usage is charged at a single unit rate no matter when it is consumed. Multiple unit rates may exist that correspond to varying volumes of usage i.e. a ‘block’ or ‘step’ tariff (first 50kWh @ X cents, next 50kWh at Y cents etc.</li><li>**SINGLE_RATE_CONT_LOAD** - as above, but with an additional, separate unit rate charged for all energy usage from a controlled load i.e. separately metered appliance like hot water service, pool pump etc.</li><li>**TIME_OF_USE** - energy usage is charged at unit rates that vary dependent on time of day and day of week that the energy is consumed</li><li>**TIME_OF_USE_CONT_LOAD** - as above, but with an additional, separate unit rate charged for all energy usage from a controlled load i.e. separately metered appliance like hot water service, pool pump etc.</li><li>**FLEXIBLE** - energy usage is charged at unit rates that vary based on external factors</li><li>**FLEXIBLE_CONT_LOAD** - as above, but with an additional, separate unit rate charged for all energy usage from a controlled load i.e. separately metered appliance like hot water service, pool pump etc.</li><li>**QUOTA** - all energy usage is charged at a single fixed rate, up to a specified usage quota/allowance. All excess usage beyond the allowance is then charged at a single unit rate (may not be the best way to explain it but it is essentially a ‘subscription’ or telco style product i.e. $50/month for up to 150kWh included usage</li></ul>
     *
     * @return pricingModel
     */
    PricingModelEnum getPricingModel();

    void setPricingModel(PricingModelEnum pricingModel);

    /**
     * Required if pricingModel is set to TIME_OF_USE.  Defines the time zone to use for calculation of the time of use thresholds. Defaults to AEST if absent
     *
     * @return timeZone
     */
    TimeZoneEnum getTimeZone();

    void setTimeZone(TimeZoneEnum timeZone);

    /**
     * Flag indicating whether prices are fixed or variable
     *
     * @return isFixed
     */
    Boolean getIsFixed();

    void setIsFixed(Boolean isFixed);

    /**
     * Free text description of price variation policy and conditions for the contract.  Mandatory if `isFixed` is false
     *
     * @return variation
     */
    String getVariation();

    void setVariation(String variation);

    /**
     * Free text field that describes what will occur on or prior to expiry of the fixed contract term or benefit period
     *
     * @return onExpiryDescription
     */
    String getOnExpiryDescription();

    void setOnExpiryDescription(String onExpiryDescription);

    /**
     * Payment options for this contract
     *
     * @return paymentOption
     */
    List<PaymentOptionEnum> getPaymentOption();

    void setPaymentOption(List<PaymentOptionEnum> paymentOption);

    /**
     * Get intrinsicGreenPower
     *
     * @return intrinsicGreenPower
     */
    EnergyPlanContractIntrinsicGreenPower getIntrinsicGreenPower();

    void setIntrinsicGreenPower(EnergyPlanContractIntrinsicGreenPower intrinsicGreenPower);

    /**
     * Get controlledLoad
     *
     * @return controlledLoad
     */
    List<EnergyPlanControlledLoad> getControlledLoad();

    void setControlledLoad(List<EnergyPlanControlledLoad> controlledLoad);

    /**
     * Optional list of incentives available for the contract
     *
     * @return incentives
     */
    List<EnergyPlanContractIncentives> getIncentives();

    void setIncentives(List<EnergyPlanContractIncentives> incentives);

    /**
     * Optional list of discounts available for the contract
     *
     * @return discounts
     */
    List<EnergyPlanContractDiscounts> getDiscounts();

    void setDiscounts(List<EnergyPlanContractDiscounts> discounts);

    /**
     * Optional list of charges applicable to green power
     *
     * @return greenPowerCharges
     */
    List<EnergyPlanContractGreenPowerCharges> getGreenPowerCharges();

    void setGreenPowerCharges(List<EnergyPlanContractGreenPowerCharges> greenPowerCharges);

    /**
     * Eligibility restrictions or requirements
     *
     * @return eligibility
     */
    List<EnergyPlanContractEligibility> getEligibility();

    void setEligibility(List<EnergyPlanContractEligibility> eligibility);

    /**
     * An array of fees applicable to the plan
     *
     * @return fees
     */
    List<EnergyPlanContractFees> getFees();

    void setFees(List<EnergyPlanContractFees> fees);

    /**
     * Array of tariff periods
     *
     * @return tariffPeriod
     */
    List<EnergyPlanContractTariffPeriod> getTariffPeriod();

    void setTariffPeriod(List<EnergyPlanContractTariffPeriod> tariffPeriod);

    /**
     * The pricing model for the contract.  Contracts for gas must use SINGLE_RATE.  Note that the detail for the enumeration values are:<ul><li>**SINGLE_RATE** - all energy usage is charged at a single unit rate no matter when it is consumed. Multiple unit rates may exist that correspond to varying volumes of usage i.e. a ‘block’ or ‘step’ tariff (first 50kWh @ X cents, next 50kWh at Y cents etc.</li><li>**SINGLE_RATE_CONT_LOAD** - as above, but with an additional, separate unit rate charged for all energy usage from a controlled load i.e. separately metered appliance like hot water service, pool pump etc.</li><li>**TIME_OF_USE** - energy usage is charged at unit rates that vary dependent on time of day and day of week that the energy is consumed</li><li>**TIME_OF_USE_CONT_LOAD** - as above, but with an additional, separate unit rate charged for all energy usage from a controlled load i.e. separately metered appliance like hot water service, pool pump etc.</li><li>**FLEXIBLE** - energy usage is charged at unit rates that vary based on external factors</li><li>**FLEXIBLE_CONT_LOAD** - as above, but with an additional, separate unit rate charged for all energy usage from a controlled load i.e. separately metered appliance like hot water service, pool pump etc.</li><li>**QUOTA** - all energy usage is charged at a single fixed rate, up to a specified usage quota/allowance. All excess usage beyond the allowance is then charged at a single unit rate (may not be the best way to explain it but it is essentially a ‘subscription’ or telco style product i.e. $50/month for up to 150kWh included usage</li></ul>
     */
    public enum PricingModelEnum {
        SINGLE_RATE,
        SINGLE_RATE_CONT_LOAD,
        TIME_OF_USE,
        TIME_OF_USE_CONT_LOAD,
        FLEXIBLE,
        FLEXIBLE_CONT_LOAD,
        QUOTA
    }

    /**
     * Required if pricingModel is set to TIME_OF_USE.  Defines the time zone to use for calculation of the time of use thresholds. Defaults to AEST if absent
     */
    public enum TimeZoneEnum {
        LOCAL,
        AEST
    }

    /**
     * Gets or Sets paymentOption
     */
    public enum PaymentOptionEnum {
        PAPER_BILL,
        CREDIT_CARD,
        DIRECT_DEBIT,
        BPAY,
        OTHER
    }
}
