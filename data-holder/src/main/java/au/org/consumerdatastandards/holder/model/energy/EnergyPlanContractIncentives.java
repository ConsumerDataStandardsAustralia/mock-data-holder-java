package au.org.consumerdatastandards.holder.model.energy;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * EnergyPlanContractIncentives
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen",
        date = "2022-01-11T14:03:27.755+11:00[Australia/Sydney]")
public class EnergyPlanContractIncentives {
    @JsonProperty("displayName")
    private String displayName;

    @JsonProperty("description")
    private String description;

    /**
     * The type of the incentive
     */
    public enum CategoryEnum {
        GIFT("GIFT"),

        ACCOUNT_CREDIT("ACCOUNT_CREDIT"),

        OTHER("OTHER");

        private String value;

        CategoryEnum(String value) {
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
        public static CategoryEnum fromValue(String value) {
            for (CategoryEnum b : CategoryEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    @JsonProperty("category")
    private CategoryEnum category;

    @JsonProperty("eligibility")
    private String eligibility;

    public EnergyPlanContractIncentives displayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    /**
     * The display name of the incentive
     *
     * @return displayName
     */
    @ApiModelProperty(required = true,
            value = "The display name of the incentive")
    @NotNull


    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public EnergyPlanContractIncentives description(String description) {
        this.description = description;
        return this;
    }

    /**
     * The description of the incentive
     *
     * @return description
     */
    @ApiModelProperty(required = true,
            value = "The description of the incentive")
    @NotNull


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EnergyPlanContractIncentives category(CategoryEnum category) {
        this.category = category;
        return this;
    }

    /**
     * The type of the incentive
     *
     * @return category
     */
    @ApiModelProperty(required = true,
            value = "The type of the incentive")
    @NotNull


    public CategoryEnum getCategory() {
        return category;
    }

    public void setCategory(CategoryEnum category) {
        this.category = category;
    }

    public EnergyPlanContractIncentives eligibility(String eligibility) {
        this.eligibility = eligibility;
        return this;
    }

    /**
     * A display message outlining an eligibility criteria that may apply
     *
     * @return eligibility
     */
    @ApiModelProperty(value = "A display message outlining an eligibility criteria that may apply")


    public String getEligibility() {
        return eligibility;
    }

    public void setEligibility(String eligibility) {
        this.eligibility = eligibility;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EnergyPlanContractIncentives energyPlanContractIncentives = (EnergyPlanContractIncentives) o;
        return Objects.equals(this.displayName, energyPlanContractIncentives.displayName) &&
                Objects.equals(this.description, energyPlanContractIncentives.description) &&
                Objects.equals(this.category, energyPlanContractIncentives.category) &&
                Objects.equals(this.eligibility, energyPlanContractIncentives.eligibility);
    }

    @Override
    public int hashCode() {
        return Objects.hash(displayName, description, category, eligibility);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyPlanContractIncentives {\n");

        sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    category: ").append(toIndentedString(category)).append("\n");
        sb.append("    eligibility: ").append(toIndentedString(eligibility)).append("\n");
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

