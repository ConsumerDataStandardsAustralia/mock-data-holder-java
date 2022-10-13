package au.org.consumerdatastandards.holder.model.energy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * EnergyPlanContractDiscounts
 */
@Entity
@Table(name="ContractDiscount")
public class EnergyPlanContractDiscounts {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @JsonIgnore
    private String id;

    private String displayName;

    private String description;

    /**
     * The type of the discount
     */
    public enum TypeEnum {
        CONDITIONAL,
        GUARANTEED,
        OTHER
    }

    private TypeEnum type;

    /**
     * The type of the discount.  Mandatory if the discount type is CONDITIONAL
     */
    public enum CategoryEnum {
        PAY_ON_TIME,
        DIRECT_DEBIT,
        GUARANTEED_DISCOUNT,
        OTHER
    }

    private CategoryEnum category;

    private String endDate;

    /**
     * The method of calculation of the discount
     */
    public enum MethodUTypeEnum {
        PERCENTOFBILL,
        PERCENTOFUSE,
        FIXEDAMOUNT,
        PERCENTOVERTHRESHOLD
    }

    private MethodUTypeEnum methodUType;

    @OneToOne(cascade = CascadeType.ALL)
    private EnergyPlanContractPercentOfBill percentOfBill;

    @OneToOne(cascade = CascadeType.ALL)
    private EnergyPlanContractPercentOfUse percentOfUse;

    @OneToOne(cascade = CascadeType.ALL)
    private EnergyPlanContractFixedAmount fixedAmount;

    @OneToOne(cascade = CascadeType.ALL)
    private EnergyPlanContractPercentOverThreshold percentOverThreshold;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public EnergyPlanContractDiscounts displayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    /**
     * The display name of the discount
     *
     * @return displayName
     */
    @ApiModelProperty(required = true, value = "The display name of the discount")
    @NotNull
    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public EnergyPlanContractDiscounts description(String description) {
        this.description = description;
        return this;
    }

    /**
     * The description of the discount
     *
     * @return description
     */
    @ApiModelProperty(value = "The description of the discount")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EnergyPlanContractDiscounts type(TypeEnum type) {
        this.type = type;
        return this;
    }

    /**
     * The type of the discount
     *
     * @return type
     */
    @ApiModelProperty(required = true, value = "The type of the discount")
    @NotNull
    public TypeEnum getType() {
        return type;
    }

    public void setType(TypeEnum type) {
        this.type = type;
    }

    public EnergyPlanContractDiscounts category(CategoryEnum category) {
        this.category = category;
        return this;
    }

    /**
     * The type of the discount.  Mandatory if the discount type is CONDITIONAL
     *
     * @return category
     */
    @ApiModelProperty(value = "The type of the discount.  Mandatory if the discount type is CONDITIONAL")
    public CategoryEnum getCategory() {
        return category;
    }

    public void setCategory(CategoryEnum category) {
        this.category = category;
    }

    public EnergyPlanContractDiscounts endDate(String endDate) {
        this.endDate = endDate;
        return this;
    }

    /**
     * Optional end date for the discount after which the discount is no longer available
     *
     * @return endDate
     */
    @ApiModelProperty(value = "Optional end date for the discount after which the discount is no longer available")
    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public EnergyPlanContractDiscounts methodUType(MethodUTypeEnum methodUType) {
        this.methodUType = methodUType;
        return this;
    }

    /**
     * The method of calculation of the discount
     *
     * @return methodUType
     */
    @ApiModelProperty(required = true, value = "The method of calculation of the discount")
    @NotNull
    public MethodUTypeEnum getMethodUType() {
        return methodUType;
    }

    public void setMethodUType(MethodUTypeEnum methodUType) {
        this.methodUType = methodUType;
    }

    public EnergyPlanContractDiscounts percentOfBill(EnergyPlanContractPercentOfBill percentOfBill) {
        this.percentOfBill = percentOfBill;
        return this;
    }

    /**
     * Get percentOfBill
     *
     * @return percentOfBill
     */
    @ApiModelProperty(value = "")
    @Valid
    public EnergyPlanContractPercentOfBill getPercentOfBill() {
        return percentOfBill;
    }

    public void setPercentOfBill(EnergyPlanContractPercentOfBill percentOfBill) {
        this.percentOfBill = percentOfBill;
    }

    public EnergyPlanContractDiscounts percentOfUse(EnergyPlanContractPercentOfUse percentOfUse) {
        this.percentOfUse = percentOfUse;
        return this;
    }

    /**
     * Get percentOfUse
     *
     * @return percentOfUse
     */
    @ApiModelProperty(value = "")
    @Valid
    public EnergyPlanContractPercentOfUse getPercentOfUse() {
        return percentOfUse;
    }

    public void setPercentOfUse(EnergyPlanContractPercentOfUse percentOfUse) {
        this.percentOfUse = percentOfUse;
    }

    public EnergyPlanContractDiscounts fixedAmount(EnergyPlanContractFixedAmount fixedAmount) {
        this.fixedAmount = fixedAmount;
        return this;
    }

    /**
     * Get fixedAmount
     *
     * @return fixedAmount
     */
    @ApiModelProperty(value = "")
    @Valid
    public EnergyPlanContractFixedAmount getFixedAmount() {
        return fixedAmount;
    }

    public void setFixedAmount(EnergyPlanContractFixedAmount fixedAmount) {
        this.fixedAmount = fixedAmount;
    }

    public EnergyPlanContractDiscounts percentOverThreshold(EnergyPlanContractPercentOverThreshold percentOverThreshold) {
        this.percentOverThreshold = percentOverThreshold;
        return this;
    }

    /**
     * Get percentOverThreshold
     *
     * @return percentOverThreshold
     */
    @ApiModelProperty(value = "")
    @Valid
    public EnergyPlanContractPercentOverThreshold getPercentOverThreshold() {
        return percentOverThreshold;
    }

    public void setPercentOverThreshold(EnergyPlanContractPercentOverThreshold percentOverThreshold) {
        this.percentOverThreshold = percentOverThreshold;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EnergyPlanContractDiscounts energyPlanContractDiscounts = (EnergyPlanContractDiscounts) o;
        return Objects.equals(this.displayName, energyPlanContractDiscounts.displayName) &&
                Objects.equals(this.description, energyPlanContractDiscounts.description) &&
                Objects.equals(this.type, energyPlanContractDiscounts.type) &&
                Objects.equals(this.category, energyPlanContractDiscounts.category) &&
                Objects.equals(this.endDate, energyPlanContractDiscounts.endDate) &&
                Objects.equals(this.methodUType, energyPlanContractDiscounts.methodUType) &&
                Objects.equals(this.percentOfBill, energyPlanContractDiscounts.percentOfBill) &&
                Objects.equals(this.percentOfUse, energyPlanContractDiscounts.percentOfUse) &&
                Objects.equals(this.fixedAmount, energyPlanContractDiscounts.fixedAmount) &&
                Objects.equals(this.percentOverThreshold, energyPlanContractDiscounts.percentOverThreshold);
    }

    @Override
    public int hashCode() {
        return Objects.hash(displayName, description, type, category, endDate, methodUType, percentOfBill, percentOfUse, fixedAmount, percentOverThreshold);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyPlanContractDiscounts {\n");
        sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    category: ").append(toIndentedString(category)).append("\n");
        sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
        sb.append("    methodUType: ").append(toIndentedString(methodUType)).append("\n");
        sb.append("    percentOfBill: ").append(toIndentedString(percentOfBill)).append("\n");
        sb.append("    percentOfUse: ").append(toIndentedString(percentOfUse)).append("\n");
        sb.append("    fixedAmount: ").append(toIndentedString(fixedAmount)).append("\n");
        sb.append("    percentOverThreshold: ").append(toIndentedString(percentOverThreshold)).append("\n");
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
