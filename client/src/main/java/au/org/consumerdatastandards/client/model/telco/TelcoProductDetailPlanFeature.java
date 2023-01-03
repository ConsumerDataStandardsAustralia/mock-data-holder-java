package au.org.consumerdatastandards.client.model.telco;

import java.util.Objects;

/**
 * TelcoProductDetailPlanFeature
 */
public class TelcoProductDetailPlanFeature {
    private String displayName;

    private String description;

    public TelcoProductDetailPlanFeature displayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    /**
     * The display name of the feature
     *
     * @return displayName
     */
    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public TelcoProductDetailPlanFeature description(String description) {
        this.description = description;
        return this;
    }

    /**
     * The description of the feature
     *
     * @return description
     */
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TelcoProductDetailPlanFeature telcoProductDetailPlanFeature = (TelcoProductDetailPlanFeature) o;
        return Objects.equals(this.displayName, telcoProductDetailPlanFeature.displayName) &&
                Objects.equals(this.description, telcoProductDetailPlanFeature.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(displayName, description);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TelcoProductDetailPlanFeature {\n");
        sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
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
