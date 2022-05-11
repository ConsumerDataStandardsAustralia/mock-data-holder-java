package au.org.consumerdatastandards.holder.model.energy;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * EnergyPlanContractFull
 */
@Entity
public class EnergyPlanContractFull {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @JsonIgnore
    private String id;

    private String additionalFeeInformation;

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

    private PricingModelEnum pricingModel;

    /**
     * Required if pricingModel is set to TIME_OF_USE.  Defines the time zone to use for calculation of the time of use thresholds
     */
    public enum TimeZoneEnum {
        LOCAL,
        AEST
    }

    private TimeZoneEnum timeZone;

    private Boolean isFixed;

    private String variation;

    private String onExpiryDescription;

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

    @Valid
    @ElementCollection
    private List<PaymentOptionEnum> paymentOption = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    private EnergyPlanContractIntrinsicGreenPower intrinsicGreenPower;

    @OneToOne(cascade = CascadeType.ALL)
    private EnergyPlanControlledLoad controlledLoad;

    @Valid
    @OneToMany(cascade = CascadeType.ALL)
    private List<EnergyPlanContractIncentives> incentives = null;

    @Valid
    @OneToMany(cascade = CascadeType.ALL)
    private List<EnergyPlanContractDiscounts> discounts = null;

    @Valid
    @OneToMany(cascade = CascadeType.ALL)
    private List<EnergyPlanContractGreenPowerCharges> greenPowerCharges = null;

    @Valid
    @OneToMany(cascade = CascadeType.ALL)
    private List<EnergyPlanContractEligibility> eligibility = null;

    @Valid
    @OneToMany(cascade = CascadeType.ALL)
    private List<EnergyPlanContractFees> fees = null;

    @Valid
    @OneToMany(cascade = CascadeType.ALL)
    private List<EnergyPlanContractSolarFeedInTariff> solarFeedInTariff = null;

    @Valid
    @OneToMany(cascade = CascadeType.ALL)
    private List<EnergyPlanContractTariffPeriod> tariffPeriod = new ArrayList<>();

    /**
     * The term for the contract.  If absent assumes no specified term
     */
    public enum TermTypeEnum {
        _1_YEAR("1_YEAR"),
        _2_YEAR("2_YEAR"),
        _3_YEAR("3_YEAR"),
        _4_YEAR("4_YEAR"),
        _5_YEAR("5_YEAR"),
        ONGOING("ONGOING"),
        OTHER("OTHER");

        private final String value;

        TermTypeEnum(String value) {
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
        public static TermTypeEnum fromValue(String value) {
            for (TermTypeEnum b : TermTypeEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    private TermTypeEnum termType;

    private String benefitPeriod;

    private String terms;

    @Valid
    @ElementCollection
    private List<String> meterTypes = null;

    private String coolingOffDays;

    @Valid
    @ElementCollection
    private List<String> billFrequency = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public EnergyPlanContractFull additionalFeeInformation(String additionalFeeInformation) {
        this.additionalFeeInformation = additionalFeeInformation;
        return this;
    }

    /**
     * Free text field containing additional information of the fees for this contract
     *
     * @return additionalFeeInformation
     */
    @ApiModelProperty(value = "Free text field containing additional information of the fees for this contract")
    public String getAdditionalFeeInformation() {
        return additionalFeeInformation;
    }

    public void setAdditionalFeeInformation(String additionalFeeInformation) {
        this.additionalFeeInformation = additionalFeeInformation;
    }

    public EnergyPlanContractFull pricingModel(PricingModelEnum pricingModel) {
        this.pricingModel = pricingModel;
        return this;
    }

    /**
     * The pricing model for the contract.  Contracts for gas must use SINGLE_RATE.  Note that the detail for the enumeration values are:<ul><li>**SINGLE_RATE** - all energy usage is charged at a single unit rate no matter when it is consumed. Multiple unit rates may exist that correspond to varying volumes of usage i.e. a ‘block’ or ‘step’ tariff (first 50kWh @ X cents, next 50kWh at Y cents etc.</li><li>**SINGLE_RATE_CONT_LOAD** - as above, but with an additional, separate unit rate charged for all energy usage from a controlled load i.e. separately metered appliance like hot water service, pool pump etc.</li><li>**TIME_OF_USE** - energy usage is charged at unit rates that vary dependent on time of day and day of week that the energy is consumed</li><li>**TIME_OF_USE_CONT_LOAD** - as above, but with an additional, separate unit rate charged for all energy usage from a controlled load i.e. separately metered appliance like hot water service, pool pump etc.</li><li>**FLEXIBLE** - energy usage is charged at unit rates that vary based on external factors</li><li>**FLEXIBLE_CONT_LOAD** - as above, but with an additional, separate unit rate charged for all energy usage from a controlled load i.e. separately metered appliance like hot water service, pool pump etc.</li><li>**QUOTA** - all energy usage is charged at a single fixed rate, up to a specified usage quota/allowance. All excess usage beyond the allowance is then charged at a single unit rate (may not be the best way to explain it but it is essentially a ‘subscription’ or telco style product i.e. $50/month for up to 150kWh included usage</li></ul>
     *
     * @return pricingModel
     */
    @ApiModelProperty(required = true,
            value = "The pricing model for the contract.  Contracts for gas must use SINGLE_RATE.  Note that the detail for the enumeration values are:<ul><li>**SINGLE_RATE** - all energy usage is charged at a single unit rate no matter when it is consumed. Multiple unit rates may exist that correspond to varying volumes of usage i.e. a ‘block’ or ‘step’ tariff (first 50kWh @ X cents, next 50kWh at Y cents etc.</li><li>**SINGLE_RATE_CONT_LOAD** - as above, but with an additional, separate unit rate charged for all energy usage from a controlled load i.e. separately metered appliance like hot water service, pool pump etc.</li><li>**TIME_OF_USE** - energy usage is charged at unit rates that vary dependent on time of day and day of week that the energy is consumed</li><li>**TIME_OF_USE_CONT_LOAD** - as above, but with an additional, separate unit rate charged for all energy usage from a controlled load i.e. separately metered appliance like hot water service, pool pump etc.</li><li>**FLEXIBLE** - energy usage is charged at unit rates that vary based on external factors</li><li>**FLEXIBLE_CONT_LOAD** - as above, but with an additional, separate unit rate charged for all energy usage from a controlled load i.e. separately metered appliance like hot water service, pool pump etc.</li><li>**QUOTA** - all energy usage is charged at a single fixed rate, up to a specified usage quota/allowance. All excess usage beyond the allowance is then charged at a single unit rate (may not be the best way to explain it but it is essentially a ‘subscription’ or telco style product i.e. $50/month for up to 150kWh included usage</li></ul>")
    @NotNull
    public PricingModelEnum getPricingModel() {
        return pricingModel;
    }

    public void setPricingModel(PricingModelEnum pricingModel) {
        this.pricingModel = pricingModel;
    }

    public EnergyPlanContractFull timeZone(TimeZoneEnum timeZone) {
        this.timeZone = timeZone;
        return this;
    }

    /**
     * Required if pricingModel is set to TIME_OF_USE.  Defines the time zone to use for calculation of the time of use thresholds
     *
     * @return timeZone
     */
    @ApiModelProperty(value = "Required if pricingModel is set to TIME_OF_USE.  Defines the time zone to use for calculation of the time of use thresholds")
    public TimeZoneEnum getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(TimeZoneEnum timeZone) {
        this.timeZone = timeZone;
    }

    public EnergyPlanContractFull isFixed(Boolean isFixed) {
        this.isFixed = isFixed;
        return this;
    }

    /**
     * Flag indicating whether prices are fixed or variable
     *
     * @return isFixed
     */
    @ApiModelProperty(required = true,
            value = "Flag indicating whether prices are fixed or variable")
    @NotNull
    public Boolean getIsFixed() {
        return isFixed;
    }

    public void setIsFixed(Boolean isFixed) {
        this.isFixed = isFixed;
    }

    public EnergyPlanContractFull variation(String variation) {
        this.variation = variation;
        return this;
    }

    /**
     * Free text description of price variation policy and conditions for the contract.  Mandatory if isFixed is true
     *
     * @return variation
     */
    @ApiModelProperty(value = "Free text description of price variation policy and conditions for the contract.  Mandatory if isFixed is true")
    public String getVariation() {
        return variation;
    }

    public void setVariation(String variation) {
        this.variation = variation;
    }

    public EnergyPlanContractFull onExpiryDescription(String onExpiryDescription) {
        this.onExpiryDescription = onExpiryDescription;
        return this;
    }

    /**
     * Free text field that describes what will occur on or prior to expiry of the fixed contract term or benefit period
     *
     * @return onExpiryDescription
     */
    @ApiModelProperty(value = "Free text field that describes what will occur on or prior to expiry of the fixed contract term or benefit period")
    public String getOnExpiryDescription() {
        return onExpiryDescription;
    }

    public void setOnExpiryDescription(String onExpiryDescription) {
        this.onExpiryDescription = onExpiryDescription;
    }

    public EnergyPlanContractFull paymentOption(List<PaymentOptionEnum> paymentOption) {
        this.paymentOption = paymentOption;
        return this;
    }

    public EnergyPlanContractFull addPaymentOptionItem(PaymentOptionEnum paymentOptionItem) {
        this.paymentOption.add(paymentOptionItem);
        return this;
    }

    /**
     * Payment options for this contract
     *
     * @return paymentOption
     */
    @ApiModelProperty(required = true,
            value = "Payment options for this contract")
    @NotNull
    public List<PaymentOptionEnum> getPaymentOption() {
        return paymentOption;
    }

    public void setPaymentOption(List<PaymentOptionEnum> paymentOption) {
        this.paymentOption = paymentOption;
    }

    public EnergyPlanContractFull intrinsicGreenPower(EnergyPlanContractIntrinsicGreenPower intrinsicGreenPower) {
        this.intrinsicGreenPower = intrinsicGreenPower;
        return this;
    }

    /**
     * Get intrinsicGreenPower
     *
     * @return intrinsicGreenPower
     */
    @ApiModelProperty(value = "")
    @Valid
    public EnergyPlanContractIntrinsicGreenPower getIntrinsicGreenPower() {
        return intrinsicGreenPower;
    }

    public void setIntrinsicGreenPower(EnergyPlanContractIntrinsicGreenPower intrinsicGreenPower) {
        this.intrinsicGreenPower = intrinsicGreenPower;
    }

    public EnergyPlanContractFull controlledLoad(EnergyPlanControlledLoad controlledLoad) {
        this.controlledLoad = controlledLoad;
        return this;
    }

    /**
     * Get controlledLoad
     *
     * @return controlledLoad
     */
    @ApiModelProperty(value = "")
    @Valid
    public EnergyPlanControlledLoad getControlledLoad() {
        return controlledLoad;
    }

    public void setControlledLoad(EnergyPlanControlledLoad controlledLoad) {
        this.controlledLoad = controlledLoad;
    }

    public EnergyPlanContractFull incentives(List<EnergyPlanContractIncentives> incentives) {
        this.incentives = incentives;
        return this;
    }

    public EnergyPlanContractFull addIncentivesItem(EnergyPlanContractIncentives incentivesItem) {
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
    @ApiModelProperty(value = "Optional list of incentives available for the contract")
    @Valid
    public List<EnergyPlanContractIncentives> getIncentives() {
        return incentives;
    }

    public void setIncentives(List<EnergyPlanContractIncentives> incentives) {
        this.incentives = incentives;
    }

    public EnergyPlanContractFull discounts(List<EnergyPlanContractDiscounts> discounts) {
        this.discounts = discounts;
        return this;
    }

    public EnergyPlanContractFull addDiscountsItem(EnergyPlanContractDiscounts discountsItem) {
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
    @ApiModelProperty(value = "Optional list of discounts available for the contract")
    @Valid
    public List<EnergyPlanContractDiscounts> getDiscounts() {
        return discounts;
    }

    public void setDiscounts(List<EnergyPlanContractDiscounts> discounts) {
        this.discounts = discounts;
    }

    public EnergyPlanContractFull greenPowerCharges(List<EnergyPlanContractGreenPowerCharges> greenPowerCharges) {
        this.greenPowerCharges = greenPowerCharges;
        return this;
    }

    public EnergyPlanContractFull addGreenPowerChargesItem(EnergyPlanContractGreenPowerCharges greenPowerChargesItem) {
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
    @ApiModelProperty(value = "Optional list of charges applicable to green power")
    @Valid
    public List<EnergyPlanContractGreenPowerCharges> getGreenPowerCharges() {
        return greenPowerCharges;
    }

    public void setGreenPowerCharges(List<EnergyPlanContractGreenPowerCharges> greenPowerCharges) {
        this.greenPowerCharges = greenPowerCharges;
    }

    public EnergyPlanContractFull eligibility(List<EnergyPlanContractEligibility> eligibility) {
        this.eligibility = eligibility;
        return this;
    }

    public EnergyPlanContractFull addEligibilityItem(EnergyPlanContractEligibility eligibilityItem) {
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
    @ApiModelProperty(value = "Eligibility restrictions or requirements")
    @Valid
    public List<EnergyPlanContractEligibility> getEligibility() {
        return eligibility;
    }

    public void setEligibility(List<EnergyPlanContractEligibility> eligibility) {
        this.eligibility = eligibility;
    }

    public EnergyPlanContractFull fees(List<EnergyPlanContractFees> fees) {
        this.fees = fees;
        return this;
    }

    public EnergyPlanContractFull addFeesItem(EnergyPlanContractFees feesItem) {
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
    @ApiModelProperty(value = "An array of fees applicable to the plan")
    @Valid
    public List<EnergyPlanContractFees> getFees() {
        return fees;
    }

    public void setFees(List<EnergyPlanContractFees> fees) {
        this.fees = fees;
    }

    public EnergyPlanContractFull solarFeedInTariff(List<EnergyPlanContractSolarFeedInTariff> solarFeedInTariff) {
        this.solarFeedInTariff = solarFeedInTariff;
        return this;
    }

    public EnergyPlanContractFull addSolarFeedInTariffItem(EnergyPlanContractSolarFeedInTariff solarFeedInTariffItem) {
        if (this.solarFeedInTariff == null) {
            this.solarFeedInTariff = new ArrayList<>();
        }
        this.solarFeedInTariff.add(solarFeedInTariffItem);
        return this;
    }

    /**
     * Array of feed in tariffs for solar power
     *
     * @return solarFeedInTariff
     */
    @ApiModelProperty(value = "Array of feed in tariffs for solar power")
    @Valid
    public List<EnergyPlanContractSolarFeedInTariff> getSolarFeedInTariff() {
        return solarFeedInTariff;
    }

    public void setSolarFeedInTariff(List<EnergyPlanContractSolarFeedInTariff> solarFeedInTariff) {
        this.solarFeedInTariff = solarFeedInTariff;
    }

    public EnergyPlanContractFull tariffPeriod(List<EnergyPlanContractTariffPeriod> tariffPeriod) {
        this.tariffPeriod = tariffPeriod;
        return this;
    }

    public EnergyPlanContractFull addTariffPeriodItem(EnergyPlanContractTariffPeriod tariffPeriodItem) {
        this.tariffPeriod.add(tariffPeriodItem);
        return this;
    }

    /**
     * Array of tariff periods
     *
     * @return tariffPeriod
     */
    @ApiModelProperty(required = true, value = "Array of tariff periods")
    @NotNull
    @Valid
    public List<EnergyPlanContractTariffPeriod> getTariffPeriod() {
        return tariffPeriod;
    }

    public void setTariffPeriod(List<EnergyPlanContractTariffPeriod> tariffPeriod) {
        this.tariffPeriod = tariffPeriod;
    }

    public EnergyPlanContractFull termType(TermTypeEnum termType) {
        this.termType = termType;
        return this;
    }

    /**
     * The term for the contract.  If absent assumes no specified term
     *
     * @return termType
     */
    @ApiModelProperty(value = "The term for the contract.  If absent assumes no specified term")
    public TermTypeEnum getTermType() {
        return termType;
    }

    public void setTermType(TermTypeEnum termType) {
        this.termType = termType;
    }

    public EnergyPlanContractFull benefitPeriod(String benefitPeriod) {
        this.benefitPeriod = benefitPeriod;
        return this;
    }

    /**
     * Description of the benefit period.  Should only be present if termType has the value ONGOING
     *
     * @return benefitPeriod
     */
    @ApiModelProperty(value = "Description of the benefit period.  Should only be present if termType has the value ONGOING")
    public String getBenefitPeriod() {
        return benefitPeriod;
    }

    public void setBenefitPeriod(String benefitPeriod) {
        this.benefitPeriod = benefitPeriod;
    }

    public EnergyPlanContractFull terms(String terms) {
        this.terms = terms;
        return this;
    }

    /**
     * Free text description of the terms for the contract
     *
     * @return terms
     */
    @ApiModelProperty(value = "Free text description of the terms for the contract")
    public String getTerms() {
        return terms;
    }

    public void setTerms(String terms) {
        this.terms = terms;
    }

    public EnergyPlanContractFull meterTypes(List<String> meterTypes) {
        this.meterTypes = meterTypes;
        return this;
    }

    public EnergyPlanContractFull addMeterTypesItem(String meterTypesItem) {
        if (this.meterTypes == null) {
            this.meterTypes = new ArrayList<>();
        }
        this.meterTypes.add(meterTypesItem);
        return this;
    }

    /**
     * An array of the meter types that this contract is available for
     *
     * @return meterTypes
     */
    @ApiModelProperty(value = "An array of the meter types that this contract is available for")
    public List<String> getMeterTypes() {
        return meterTypes;
    }

    public void setMeterTypes(List<String> meterTypes) {
        this.meterTypes = meterTypes;
    }

    public EnergyPlanContractFull coolingOffDays(String coolingOffDays) {
        this.coolingOffDays = coolingOffDays;
        return this;
    }

    /**
     * Number of days in the cooling off period for the contract.  Mandatory for plans with type of MARKET
     *
     * @return coolingOffDays
     */
    @ApiModelProperty(value = "Number of days in the cooling off period for the contract.  Mandatory for plans with type of MARKET ")
    public String getCoolingOffDays() {
        return coolingOffDays;
    }

    public void setCoolingOffDays(String coolingOffDays) {
        this.coolingOffDays = coolingOffDays;
    }

    public EnergyPlanContractFull billFrequency(List<String> billFrequency) {
        this.billFrequency = billFrequency;
        return this;
    }

    public EnergyPlanContractFull addBillFrequencyItem(String billFrequencyItem) {
        this.billFrequency.add(billFrequencyItem);
        return this;
    }

    /**
     * An array of the available billing schedules for this contract. Formatted according to [ISO 8601 Durations](https://en.wikipedia.org/wiki/ISO_8601#Durations) (excludes recurrence syntax)
     *
     * @return billFrequency
     */
    @ApiModelProperty(required = true,
            value = "An array of the available billing schedules for this contract. Formatted according to [ISO 8601 Durations](https://en.wikipedia.org/wiki/ISO_8601#Durations) (excludes recurrence syntax)")
    @NotNull
    public List<String> getBillFrequency() {
        return billFrequency;
    }

    public void setBillFrequency(List<String> billFrequency) {
        this.billFrequency = billFrequency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EnergyPlanContractFull energyPlanContractFull = (EnergyPlanContractFull) o;
        return Objects.equals(this.additionalFeeInformation, energyPlanContractFull.additionalFeeInformation) &&
                Objects.equals(this.pricingModel, energyPlanContractFull.pricingModel) &&
                Objects.equals(this.timeZone, energyPlanContractFull.timeZone) &&
                Objects.equals(this.isFixed, energyPlanContractFull.isFixed) &&
                Objects.equals(this.variation, energyPlanContractFull.variation) &&
                Objects.equals(this.onExpiryDescription, energyPlanContractFull.onExpiryDescription) &&
                Objects.equals(this.paymentOption, energyPlanContractFull.paymentOption) &&
                Objects.equals(this.intrinsicGreenPower, energyPlanContractFull.intrinsicGreenPower) &&
                Objects.equals(this.controlledLoad, energyPlanContractFull.controlledLoad) &&
                Objects.equals(this.incentives, energyPlanContractFull.incentives) &&
                Objects.equals(this.discounts, energyPlanContractFull.discounts) &&
                Objects.equals(this.greenPowerCharges, energyPlanContractFull.greenPowerCharges) &&
                Objects.equals(this.eligibility, energyPlanContractFull.eligibility) &&
                Objects.equals(this.fees, energyPlanContractFull.fees) &&
                Objects.equals(this.solarFeedInTariff, energyPlanContractFull.solarFeedInTariff) &&
                Objects.equals(this.tariffPeriod, energyPlanContractFull.tariffPeriod) &&
                Objects.equals(this.termType, energyPlanContractFull.termType) &&
                Objects.equals(this.benefitPeriod, energyPlanContractFull.benefitPeriod) &&
                Objects.equals(this.terms, energyPlanContractFull.terms) &&
                Objects.equals(this.meterTypes, energyPlanContractFull.meterTypes) &&
                Objects.equals(this.coolingOffDays, energyPlanContractFull.coolingOffDays) &&
                Objects.equals(this.billFrequency, energyPlanContractFull.billFrequency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(additionalFeeInformation, pricingModel, timeZone, isFixed, variation, onExpiryDescription, paymentOption, intrinsicGreenPower, controlledLoad, incentives, discounts, greenPowerCharges, eligibility, fees, solarFeedInTariff, tariffPeriod, termType, benefitPeriod, terms, meterTypes, coolingOffDays, billFrequency);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyPlanContractFull {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
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
        sb.append("    solarFeedInTariff: ").append(toIndentedString(solarFeedInTariff)).append("\n");
        sb.append("    tariffPeriod: ").append(toIndentedString(tariffPeriod)).append("\n");
        sb.append("    termType: ").append(toIndentedString(termType)).append("\n");
        sb.append("    benefitPeriod: ").append(toIndentedString(benefitPeriod)).append("\n");
        sb.append("    terms: ").append(toIndentedString(terms)).append("\n");
        sb.append("    meterTypes: ").append(toIndentedString(meterTypes)).append("\n");
        sb.append("    coolingOffDays: ").append(toIndentedString(coolingOffDays)).append("\n");
        sb.append("    billFrequency: ").append(toIndentedString(billFrequency)).append("\n");
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
