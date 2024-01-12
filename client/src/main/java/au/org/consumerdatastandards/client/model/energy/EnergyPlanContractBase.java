package au.org.consumerdatastandards.client.model.energy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * EnergyPlanContractBase
 */
public class EnergyPlanContractBase implements EnergyPlanContract {

    private String additionalFeeInformation;

    private PricingModelEnum pricingModel;

    private TimeZoneEnum timeZone;

    private Boolean isFixed;

    private String variation;

    private String onExpiryDescription;

    private List<PaymentOptionEnum> paymentOption = new ArrayList<>();

    private EnergyPlanContractIntrinsicGreenPower intrinsicGreenPower;

    private List<EnergyPlanControlledLoad> controlledLoad;

    private List<EnergyPlanContractIncentives> incentives = null;

    private List<EnergyPlanContractDiscounts> discounts = null;

    private List<EnergyPlanContractGreenPowerCharges> greenPowerCharges = null;

    private List<EnergyPlanContractEligibility> eligibility = null;

    private List<EnergyPlanContractFees> fees = null;

    private List<EnergyPlanContractTariffPeriod> tariffPeriod = new ArrayList<>();

    public EnergyPlanContractBase additionalFeeInformation(String additionalFeeInformation) {
        this.additionalFeeInformation = additionalFeeInformation;
        return this;
    }

    /**
     * Free text field containing additional information of the fees for this contract
     *
     * @return additionalFeeInformation
     */
    public String getAdditionalFeeInformation() {
        return additionalFeeInformation;
    }

    public void setAdditionalFeeInformation(String additionalFeeInformation) {
        this.additionalFeeInformation = additionalFeeInformation;
    }

    public EnergyPlanContractBase pricingModel(PricingModelEnum pricingModel) {
        this.pricingModel = pricingModel;
        return this;
    }

    /**
     * The pricing model for the contract.  Contracts for gas must use SINGLE_RATE.  Note that the detail for the enumeration values are:<ul><li>**SINGLE_RATE** - all energy usage is charged at a single unit rate no matter when it is consumed. Multiple unit rates may exist that correspond to varying volumes of usage i.e. a ‘block’ or ‘step’ tariff (first 50kWh @ X cents, next 50kWh at Y cents etc.</li><li>**SINGLE_RATE_CONT_LOAD** - as above, but with an additional, separate unit rate charged for all energy usage from a controlled load i.e. separately metered appliance like hot water service, pool pump etc.</li><li>**TIME_OF_USE** - energy usage is charged at unit rates that vary dependent on time of day and day of week that the energy is consumed</li><li>**TIME_OF_USE_CONT_LOAD** - as above, but with an additional, separate unit rate charged for all energy usage from a controlled load i.e. separately metered appliance like hot water service, pool pump etc.</li><li>**FLEXIBLE** - energy usage is charged at unit rates that vary based on external factors</li><li>**FLEXIBLE_CONT_LOAD** - as above, but with an additional, separate unit rate charged for all energy usage from a controlled load i.e. separately metered appliance like hot water service, pool pump etc.</li><li>**QUOTA** - all energy usage is charged at a single fixed rate, up to a specified usage quota/allowance. All excess usage beyond the allowance is then charged at a single unit rate (may not be the best way to explain it but it is essentially a ‘subscription’ or telco style product i.e. $50/month for up to 150kWh included usage</li></ul>
     *
     * @return pricingModel
     */
    public PricingModelEnum getPricingModel() {
        return pricingModel;
    }

    public void setPricingModel(PricingModelEnum pricingModel) {
        this.pricingModel = pricingModel;
    }

    public EnergyPlanContractBase timeZone(TimeZoneEnum timeZone) {
        this.timeZone = timeZone;
        return this;
    }

    /**
     * Required if pricingModel is set to TIME_OF_USE.  Defines the time zone to use for calculation of the time of use thresholds. Defaults to AEST if absent
     *
     * @return timeZone
     */
    public TimeZoneEnum getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(TimeZoneEnum timeZone) {
        this.timeZone = timeZone;
    }

    public EnergyPlanContractBase isFixed(Boolean isFixed) {
        this.isFixed = isFixed;
        return this;
    }

    /**
     * Flag indicating whether prices are fixed or variable
     *
     * @return isFixed
     */
    public Boolean getIsFixed() {
        return isFixed;
    }

    public void setIsFixed(Boolean isFixed) {
        this.isFixed = isFixed;
    }

    public EnergyPlanContractBase variation(String variation) {
        this.variation = variation;
        return this;
    }

    /**
     * Free text description of price variation policy and conditions for the contract.  Mandatory if `isFixed` is false
     *
     * @return variation
     */
    public String getVariation() {
        return variation;
    }

    public void setVariation(String variation) {
        this.variation = variation;
    }

    public EnergyPlanContractBase onExpiryDescription(String onExpiryDescription) {
        this.onExpiryDescription = onExpiryDescription;
        return this;
    }

    /**
     * Free text field that describes what will occur on or prior to expiry of the fixed contract term or benefit period
     *
     * @return onExpiryDescription
     */
    public String getOnExpiryDescription() {
        return onExpiryDescription;
    }

    public void setOnExpiryDescription(String onExpiryDescription) {
        this.onExpiryDescription = onExpiryDescription;
    }

    public EnergyPlanContractBase paymentOption(List<PaymentOptionEnum> paymentOption) {
        this.paymentOption = paymentOption;
        return this;
    }

    public EnergyPlanContractBase addPaymentOptionItem(PaymentOptionEnum paymentOptionItem) {
        this.paymentOption.add(paymentOptionItem);
        return this;
    }

    /**
     * Payment options for this contract
     *
     * @return paymentOption
     */
    public List<PaymentOptionEnum> getPaymentOption() {
        return paymentOption;
    }

    public void setPaymentOption(List<PaymentOptionEnum> paymentOption) {
        this.paymentOption = paymentOption;
    }

    public EnergyPlanContractBase intrinsicGreenPower(EnergyPlanContractIntrinsicGreenPower intrinsicGreenPower) {
        this.intrinsicGreenPower = intrinsicGreenPower;
        return this;
    }

    /**
     * Get intrinsicGreenPower
     *
     * @return intrinsicGreenPower
     */
    public EnergyPlanContractIntrinsicGreenPower getIntrinsicGreenPower() {
        return intrinsicGreenPower;
    }

    public void setIntrinsicGreenPower(EnergyPlanContractIntrinsicGreenPower intrinsicGreenPower) {
        this.intrinsicGreenPower = intrinsicGreenPower;
    }

    public EnergyPlanContractBase controlledLoad(List<EnergyPlanControlledLoad> controlledLoad) {
        this.controlledLoad = controlledLoad;
        return this;
    }

    /**
     * Get controlledLoad
     *
     * @return controlledLoad
     */
    public List<EnergyPlanControlledLoad> getControlledLoad() {
        return controlledLoad;
    }

    public void setControlledLoad(List<EnergyPlanControlledLoad> controlledLoad) {
        this.controlledLoad = controlledLoad;
    }

    public EnergyPlanContractBase incentives(List<EnergyPlanContractIncentives> incentives) {
        this.incentives = incentives;
        return this;
    }

    public EnergyPlanContractBase addIncentivesItem(EnergyPlanContractIncentives incentivesItem) {
        if (this.incentives == null) {
            this.incentives = new ArrayList<>();
        }
        this.incentives.add(incentivesItem);
        return this;
    }

    /**
     * Optional list of incentives available for the contract
     *
     * @return incentives
     */
    public List<EnergyPlanContractIncentives> getIncentives() {
        return incentives;
    }

    public void setIncentives(List<EnergyPlanContractIncentives> incentives) {
        this.incentives = incentives;
    }

    public EnergyPlanContractBase discounts(List<EnergyPlanContractDiscounts> discounts) {
        this.discounts = discounts;
        return this;
    }

    public EnergyPlanContractBase addDiscountsItem(EnergyPlanContractDiscounts discountsItem) {
        if (this.discounts == null) {
            this.discounts = new ArrayList<>();
        }
        this.discounts.add(discountsItem);
        return this;
    }

    /**
     * Optional list of discounts available for the contract
     *
     * @return discounts
     */
    public List<EnergyPlanContractDiscounts> getDiscounts() {
        return discounts;
    }

    public void setDiscounts(List<EnergyPlanContractDiscounts> discounts) {
        this.discounts = discounts;
    }

    public EnergyPlanContractBase greenPowerCharges(List<EnergyPlanContractGreenPowerCharges> greenPowerCharges) {
        this.greenPowerCharges = greenPowerCharges;
        return this;
    }

    public EnergyPlanContractBase addGreenPowerChargesItem(EnergyPlanContractGreenPowerCharges greenPowerChargesItem) {
        if (this.greenPowerCharges == null) {
            this.greenPowerCharges = new ArrayList<>();
        }
        this.greenPowerCharges.add(greenPowerChargesItem);
        return this;
    }

    /**
     * Optional list of charges applicable to green power
     *
     * @return greenPowerCharges
     */
    public List<EnergyPlanContractGreenPowerCharges> getGreenPowerCharges() {
        return greenPowerCharges;
    }

    public void setGreenPowerCharges(List<EnergyPlanContractGreenPowerCharges> greenPowerCharges) {
        this.greenPowerCharges = greenPowerCharges;
    }

    public EnergyPlanContractBase eligibility(List<EnergyPlanContractEligibility> eligibility) {
        this.eligibility = eligibility;
        return this;
    }

    public EnergyPlanContractBase addEligibilityItem(EnergyPlanContractEligibility eligibilityItem) {
        if (this.eligibility == null) {
            this.eligibility = new ArrayList<>();
        }
        this.eligibility.add(eligibilityItem);
        return this;
    }

    /**
     * Eligibility restrictions or requirements
     *
     * @return eligibility
     */
    public List<EnergyPlanContractEligibility> getEligibility() {
        return eligibility;
    }

    public void setEligibility(List<EnergyPlanContractEligibility> eligibility) {
        this.eligibility = eligibility;
    }

    public EnergyPlanContractBase fees(List<EnergyPlanContractFees> fees) {
        this.fees = fees;
        return this;
    }

    public EnergyPlanContractBase addFeesItem(EnergyPlanContractFees feesItem) {
        if (this.fees == null) {
            this.fees = new ArrayList<>();
        }
        this.fees.add(feesItem);
        return this;
    }

    /**
     * An array of fees applicable to the plan
     *
     * @return fees
     */
    public List<EnergyPlanContractFees> getFees() {
        return fees;
    }

    public void setFees(List<EnergyPlanContractFees> fees) {
        this.fees = fees;
    }

    public EnergyPlanContractBase tariffPeriod(List<EnergyPlanContractTariffPeriod> tariffPeriod) {
        this.tariffPeriod = tariffPeriod;
        return this;
    }

    public EnergyPlanContractBase addTariffPeriodItem(EnergyPlanContractTariffPeriod tariffPeriodItem) {
        this.tariffPeriod.add(tariffPeriodItem);
        return this;
    }

    /**
     * Array of tariff periods
     *
     * @return tariffPeriod
     */
    public List<EnergyPlanContractTariffPeriod> getTariffPeriod() {
        return tariffPeriod;
    }

    public void setTariffPeriod(List<EnergyPlanContractTariffPeriod> tariffPeriod) {
        this.tariffPeriod = tariffPeriod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EnergyPlanContractBase energyPlanContract = (EnergyPlanContractBase) o;
        return Objects.equals(this.additionalFeeInformation, energyPlanContract.additionalFeeInformation) &&
                Objects.equals(this.pricingModel, energyPlanContract.pricingModel) &&
                Objects.equals(this.timeZone, energyPlanContract.timeZone) &&
                Objects.equals(this.isFixed, energyPlanContract.isFixed) &&
                Objects.equals(this.variation, energyPlanContract.variation) &&
                Objects.equals(this.onExpiryDescription, energyPlanContract.onExpiryDescription) &&
                Objects.equals(this.paymentOption, energyPlanContract.paymentOption) &&
                Objects.equals(this.intrinsicGreenPower, energyPlanContract.intrinsicGreenPower) &&
                Objects.equals(this.controlledLoad, energyPlanContract.controlledLoad) &&
                Objects.equals(this.incentives, energyPlanContract.incentives) &&
                Objects.equals(this.discounts, energyPlanContract.discounts) &&
                Objects.equals(this.greenPowerCharges, energyPlanContract.greenPowerCharges) &&
                Objects.equals(this.eligibility, energyPlanContract.eligibility) &&
                Objects.equals(this.fees, energyPlanContract.fees) &&
                Objects.equals(this.tariffPeriod, energyPlanContract.tariffPeriod);
    }

    @Override
    public int hashCode() {
        return Objects.hash(additionalFeeInformation, pricingModel, timeZone, isFixed, variation, onExpiryDescription, paymentOption, intrinsicGreenPower, controlledLoad, incentives, discounts, greenPowerCharges, eligibility, fees, tariffPeriod);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ").append(getClass().getSimpleName()).append(" {");
        writeProperties(sb);
        sb.append("}");
        return sb.toString();
    }

    protected void writeProperties(StringBuilder sb) {
        sb.append("    additionalFeeInformation: ").append(toIndentedString(additionalFeeInformation)).append("\n");
        sb.append("    pricingModel: ").append(toIndentedString(pricingModel)).append("\n");
        sb.append("    timeZone: ").append(toIndentedString(timeZone)).append("\n");
        sb.append("    isFixed: ").append(toIndentedString(isFixed)).append("\n");
        sb.append("    variation: ").append(toIndentedString(variation)).append("\n");
        sb.append("    onExpiryDescription: ").append(toIndentedString(onExpiryDescription)).append("\n");
        sb.append("    paymentOption: ").append(toIndentedString(paymentOption)).append("\n");
        sb.append("    intrinsicGreenPower: ").append(toIndentedString(intrinsicGreenPower)).append("\n");
        sb.append("    controlledLoad: ").append(toIndentedString(controlledLoad)).append("\n");
        sb.append("    incentives: ").append(toIndentedString(incentives)).append("\n");
        sb.append("    discounts: ").append(toIndentedString(discounts)).append("\n");
        sb.append("    greenPowerCharges: ").append(toIndentedString(greenPowerCharges)).append("\n");
        sb.append("    eligibility: ").append(toIndentedString(eligibility)).append("\n");
        sb.append("    fees: ").append(toIndentedString(fees)).append("\n");
        sb.append("    tariffPeriod: ").append(toIndentedString(tariffPeriod)).append("\n");
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     * @param o Object
     * @return Indented string representation of <code>o</code>
     */
    protected String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
