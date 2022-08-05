package au.org.consumerdatastandards.client.model.energy;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * EnergyPlanDetail
 */
public class EnergyPlanDetailBean implements EnergyPlanDetail {
    private String planId;

    private OffsetDateTime effectiveFrom;

    private OffsetDateTime effectiveTo;

    private OffsetDateTime lastUpdated;

    private String displayName;

    private String description;

    private TypeEnum type;

    private FuelTypeEnum fuelType;

    private String brand;

    private String brandName;

    private String applicationUri;

    private EnergyPlanAdditionalInformation additionalInformation;

    private CustomerTypeEnum customerType;

    private EnergyPlanGeography geography;

    private List<MeteringCharges> meteringCharges = new ArrayList<>();

    private EnergyPlanContractFull gasContract;

    private EnergyPlanContractFull electricityContract;

    /**
     * The ID of the specific plan
     *
     * @return planId
     */
    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    /**
     * The date and time from which this plan is effective (ie. is available for origination). Used to enable the articulation of products to the regime before they are available for customers to originate
     *
     * @return effectiveFrom
     */
    @Override
    public OffsetDateTime getEffectiveFrom() {
        return effectiveFrom;
    }

    @Override
    public void setEffectiveFrom(OffsetDateTime effectiveFrom) {
        this.effectiveFrom = effectiveFrom;
    }

    /**
     * The date and time at which this plan will be retired and will no longer be offered. Used to enable the managed deprecation of plans
     *
     * @return effectiveTo
     */
    @Override
    public OffsetDateTime getEffectiveTo() {
        return effectiveTo;
    }

    @Override
    public void setEffectiveTo(OffsetDateTime effectiveTo) {
        this.effectiveTo = effectiveTo;
    }

    /**
     * The last date and time that the information for this plan was changed (or the creation date for the plan if it has never been altered)
     *
     * @return lastUpdated
     */
    @Override
    public OffsetDateTime getLastUpdated() {
        return lastUpdated;
    }

    @Override
    public void setLastUpdated(OffsetDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    /**
     * The display name of the plan
     *
     * @return displayName
     */
    @Override
    public String getDisplayName() {
        return displayName;
    }

    @Override
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /**
     * A description of the plan
     *
     * @return description
     */
    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * The type of the plan
     *
     * @return type
     */
    @Override
    public TypeEnum getType() {
        return type;
    }

    @Override
    public void setType(TypeEnum type) {
        this.type = type;
    }

    /**
     * The fuel types covered by the plan
     *
     * @return fuelType
     */
    @Override
    public FuelTypeEnum getFuelType() {
        return fuelType;
    }

    @Override
    public void setFuelType(FuelTypeEnum fuelType) {
        this.fuelType = fuelType;
    }

    /**
     * The ID of the brand under which this plan is offered
     *
     * @return brand
     */
    @Override
    public String getBrand() {
        return brand;
    }

    @Override
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * The display name of the brand under which this plan is offered
     *
     * @return brandName
     */
    @Override
    public String getBrandName() {
        return brandName;
    }

    @Override
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    /**
     * A link to an application web page where this plan can be applied for
     *
     * @return applicationUri
     */
    @Override
    public String getApplicationUri() {
        return applicationUri;
    }

    @Override
    public void setApplicationUri(String applicationUri) {
        this.applicationUri = applicationUri;
    }

    /**
     * Get additionalInformation
     *
     * @return additionalInformation
     */
    @Override
    public EnergyPlanAdditionalInformation getAdditionalInformation() {
        return additionalInformation;
    }

    @Override
    public void setAdditionalInformation(EnergyPlanAdditionalInformation additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    /**
     * The type of customer that the plan is offered to.  If absent then the plan is available to all customers
     *
     * @return customerType
     */
    @Override
    public CustomerTypeEnum getCustomerType() {
        return customerType;
    }

    @Override
    public void setCustomerType(CustomerTypeEnum customerType) {
        this.customerType = customerType;
    }

    /**
     * Get geography
     *
     * @return geography
     */
    @Override
    public EnergyPlanGeography getGeography() {
        return geography;
    }

    @Override
    public void setGeography(EnergyPlanGeography geography) {
        this.geography = geography;
    }

    public EnergyPlanDetail meteringCharges(List<MeteringCharges> meteringCharges) {
        this.meteringCharges = meteringCharges;
        return this;
    }

    public EnergyPlanDetail addMeteringChargesItem(MeteringCharges meteringChargesItem) {
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
    @Override
    public List<MeteringCharges> getMeteringCharges() {
        return meteringCharges;
    }

    @Override
    public void setMeteringCharges(List<MeteringCharges> meteringCharges) {
        this.meteringCharges = meteringCharges;
    }

    public EnergyPlanDetailBean gasContract(EnergyPlanContractFull gasContract) {
        this.gasContract = gasContract;
        return this;
    }

    /**
     * Get gasContract
     *
     * @return gasContract
     */
    @Override
    public EnergyPlanContractFull getGasContract() {
        return gasContract;
    }

    @Override
    public void setGasContract(EnergyPlanContractFull gasContract) {
        this.gasContract = gasContract;
    }

    public EnergyPlanDetailBean electricityContract(EnergyPlanContractFull electricityContract) {
        this.electricityContract = electricityContract;
        return this;
    }

    /**
     * Get electricityContract
     *
     * @return electricityContract
     */
    @Override
    public EnergyPlanContractFull getElectricityContract() {
        return electricityContract;
    }

    @Override
    public void setElectricityContract(EnergyPlanContractFull electricityContract) {
        this.electricityContract = electricityContract;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EnergyPlanDetailBean energyPlanDetail = (EnergyPlanDetailBean) o;
        return Objects.equals(this.planId, energyPlanDetail.planId) &&
                Objects.equals(this.effectiveFrom, energyPlanDetail.effectiveFrom) &&
                Objects.equals(this.effectiveTo, energyPlanDetail.effectiveTo) &&
                Objects.equals(this.lastUpdated, energyPlanDetail.lastUpdated) &&
                Objects.equals(this.displayName, energyPlanDetail.displayName) &&
                Objects.equals(this.description, energyPlanDetail.description) &&
                Objects.equals(this.type, energyPlanDetail.type) &&
                Objects.equals(this.fuelType, energyPlanDetail.fuelType) &&
                Objects.equals(this.brand, energyPlanDetail.brand) &&
                Objects.equals(this.brandName, energyPlanDetail.brandName) &&
                Objects.equals(this.applicationUri, energyPlanDetail.applicationUri) &&
                Objects.equals(this.additionalInformation, energyPlanDetail.additionalInformation) &&
                Objects.equals(this.customerType, energyPlanDetail.customerType) &&
                Objects.equals(this.geography, energyPlanDetail.geography) &&
                Objects.equals(this.meteringCharges, energyPlanDetail.meteringCharges) &&
                Objects.equals(this.gasContract, energyPlanDetail.gasContract) &&
                Objects.equals(this.electricityContract, energyPlanDetail.electricityContract);
    }

    @Override
    public int hashCode() {
        return Objects.hash(planId, effectiveFrom, effectiveTo, lastUpdated, displayName, description, type, fuelType, brand, brandName, applicationUri, additionalInformation, customerType, geography, meteringCharges, gasContract, electricityContract);
    }

    protected void toStringFields(StringBuilder sb) {
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
        sb.append("    meteringCharges: ").append(toIndentedString(meteringCharges)).append("\n");
        sb.append("    gasContract: ").append(toIndentedString(gasContract)).append("\n");
        sb.append("    electricityContract: ").append(toIndentedString(electricityContract)).append("\n");
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    protected String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
