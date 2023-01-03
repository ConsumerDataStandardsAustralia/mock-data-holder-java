package au.org.consumerdatastandards.client.model.telco;

import java.util.Objects;

/**
 * TelcoProductDetailIncentiveFeature
 */
public class TelcoProductDetailIncentiveFeature {
    private String displayName;

    private String description;

    public TelcoProductDetailIncentiveFeature displayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    /**
     * The display name of the incentive feature
     *
     * @return displayName
     */
    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public TelcoProductDetailIncentiveFeature description(String description) {
        this.description = description;
        return this;
    }

    /**
     * The description of the incentive feature
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
        TelcoProductDetailIncentiveFeature telcoProductDetailIncentiveFeature = (TelcoProductDetailIncentiveFeature) o;
        return Objects.equals(this.displayName, telcoProductDetailIncentiveFeature.displayName) &&
                Objects.equals(this.description, telcoProductDetailIncentiveFeature.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(displayName, description);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TelcoProductDetailIncentiveFeature {\n");

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
