package au.org.consumerdatastandards.client.model.telco;

import java.util.Objects;

/**
 * TelcoProductDetailDiscountFeature
 */
public class TelcoProductDetailDiscountFeature {
    private String displayName;

    private String description;

    public TelcoProductDetailDiscountFeature displayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    /**
     * The display name of the discount feature
     *
     * @return displayName
     */
    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public TelcoProductDetailDiscountFeature description(String description) {
        this.description = description;
        return this;
    }

    /**
     * The description of the discount feature
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
        TelcoProductDetailDiscountFeature telcoProductDetailDiscountFeature = (TelcoProductDetailDiscountFeature) o;
        return Objects.equals(this.displayName, telcoProductDetailDiscountFeature.displayName) &&
                Objects.equals(this.description, telcoProductDetailDiscountFeature.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(displayName, description);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TelcoProductDetailDiscountFeature {\n");
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
