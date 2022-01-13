package au.org.consumerdatastandards.holder.model.energy;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * EnergyPlanDetail
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen",
        date = "2022-01-11T14:03:27.755+11:00[Australia/Sydney]")
public class EnergyPlanDetail {
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

    @JsonProperty("meteringCharges")
    @Valid
    private List<EnergyPlanDetailAllOfMeteringCharges> meteringCharges = null;

    @JsonProperty("gasContract")
    private EnergyPlanContractFull gasContract;

    @JsonProperty("electricityContract")
    private EnergyPlanContractFull electricityContract;

    public EnergyPlanDetail planId(String planId) {
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

    public EnergyPlanDetail effectiveFrom(String effectiveFrom) {
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

    public EnergyPlanDetail effectiveTo(String effectiveTo) {
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

    public EnergyPlanDetail lastUpdated(String lastUpdated) {
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

    public EnergyPlanDetail displayName(String displayName) {
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

    public EnergyPlanDetail description(String description) {
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

    public EnergyPlanDetail type(TypeEnum type) {
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

    public EnergyPlanDetail fuelType(FuelTypeEnum fuelType) {
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

    public EnergyPlanDetail brand(String brand) {
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

    public EnergyPlanDetail brandName(String brandName) {
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

    public EnergyPlanDetail applicationUri(String applicationUri) {
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

    public EnergyPlanDetail additionalInformation(EnergyPlanAdditionalInformation additionalInformation) {
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

    public EnergyPlanDetail customerType(CustomerTypeEnum customerType) {
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

    public EnergyPlanDetail geography(EnergyPlanGeography geography) {
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

    public EnergyPlanDetail meteringCharges(List<EnergyPlanDetailAllOfMeteringCharges> meteringCharges) {
        this.meteringCharges = meteringCharges;
        return this;
    }

    public EnergyPlanDetail addMeteringChargesItem(EnergyPlanDetailAllOfMeteringCharges meteringChargesItem) {
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

    public List<EnergyPlanDetailAllOfMeteringCharges> getMeteringCharges() {
        return meteringCharges;
    }

    public void setMeteringCharges(List<EnergyPlanDetailAllOfMeteringCharges> meteringCharges) {
        this.meteringCharges = meteringCharges;
    }

    public EnergyPlanDetail gasContract(EnergyPlanContractFull gasContract) {
        this.gasContract = gasContract;
        return this;
    }

    /**
     * Get gasContract
     *
     * @return gasContract
     */
    @ApiModelProperty(value = "")

    @Valid

    public EnergyPlanContractFull getGasContract() {
        return gasContract;
    }

    public void setGasContract(EnergyPlanContractFull gasContract) {
        this.gasContract = gasContract;
    }

    public EnergyPlanDetail electricityContract(EnergyPlanContractFull electricityContract) {
        this.electricityContract = electricityContract;
        return this;
    }

    /**
     * Get electricityContract
     *
     * @return electricityContract
     */
    @ApiModelProperty(value = "")

    @Valid

    public EnergyPlanContractFull getElectricityContract() {
        return electricityContract;
    }

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
        EnergyPlanDetail energyPlanDetail = (EnergyPlanDetail) o;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyPlanDetail {\n");

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

