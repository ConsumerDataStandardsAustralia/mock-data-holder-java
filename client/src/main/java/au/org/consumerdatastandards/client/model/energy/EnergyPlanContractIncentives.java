package au.org.consumerdatastandards.client.model.energy;

import java.util.Objects;

/**
 * EnergyPlanContractIncentives
 */
public class EnergyPlanContractIncentives {
    private String displayName;

    private String description;

    /**
     * The type of the incentive
     */
    public enum CategoryEnum {
        GIFT,
        ACCOUNT_CREDIT,
        OTHER
    }

    private CategoryEnum category;

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
