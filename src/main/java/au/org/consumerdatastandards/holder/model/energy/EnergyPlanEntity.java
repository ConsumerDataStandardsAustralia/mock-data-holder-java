package au.org.consumerdatastandards.holder.model.energy;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.OffsetDateTime;
import java.util.Objects;

@Entity
@Table(name = "e_plan")
public class EnergyPlanEntity implements EnergyPlan {
    @Id
    private String planId;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private OffsetDateTime effectiveFrom;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private OffsetDateTime effectiveTo;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private OffsetDateTime lastUpdated;

    private String displayName;

    private String description;

    private TypeEnum type;

    private FuelTypeEnum fuelType;

    private String brand;

    private String brandName;

    private String applicationUri;

    @OneToOne(cascade = CascadeType.ALL)
    private EnergyPlanAdditionalInformation additionalInformation;

    private CustomerTypeEnum customerType;

    @OneToOne(cascade = CascadeType.ALL)
    private EnergyPlanGeography geography;

    /**
     * The ID of the specific plan
     *
     * @return planId
     */
    @ApiModelProperty(required = true,value  = "The ID of the specific plan")
    @NotNull
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
    @ApiModelProperty(value = "The date and time from which this plan is effective (ie. is available for origination). Used to enable the articulation of products to the regime before they are available for customers to originate")
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
    @ApiModelProperty(value = "The date and time at which this plan will be retired and will no longer be offered. Used to enable the managed deprecation of plans")
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
    @ApiModelProperty(required = true,
            value = "The last date and time that the information for this plan was changed (or the creation date for the plan if it has never been altered)")
    @NotNull
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
    @ApiModelProperty(value = "The display name of the plan")
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
    @ApiModelProperty(value = "A description of the plan")
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
    @ApiModelProperty(required = true, value = "The type of the plan")
    @NotNull
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
    @ApiModelProperty(required = true, value = "The fuel types covered by the plan")
    @NotNull
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
    @ApiModelProperty(required = true, value = "The ID of the brand under which this plan is offered")
    @NotNull
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
    @ApiModelProperty(required = true, value = "The display name of the brand under which this plan is offered")
    @NotNull
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
    @ApiModelProperty(value = "A link to an application web page where this plan can be applied for")
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
    @ApiModelProperty(value = "Object that contains links to additional information on specific topics.")
    @Valid
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
    @ApiModelProperty("The type of customer that the plan is offered to.  If absent then the plan is available to all customers")
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
    @ApiModelProperty("Describes the geographical area that the plan is available for. If absent then it is assumed the plan is not geographically limited")
    @Valid
    @Override
    public EnergyPlanGeography getGeography() {
        return geography;
    }

    @Override
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
        EnergyPlanEntity energyPlan = (EnergyPlanEntity) o;
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
        sb.append("class ").append(getClass().getSimpleName()).append(" {\n");
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
