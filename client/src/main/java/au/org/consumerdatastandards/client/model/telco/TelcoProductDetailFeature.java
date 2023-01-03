package au.org.consumerdatastandards.client.model.telco;

import java.util.Objects;

/**
 * TelcoProductDetailFeature
 */
public class TelcoProductDetailFeature {
    private String displayName;

    private String description;

    /**
     * The type of the feature
     */
    public enum CategoryEnum {
        DATA,
        VOICE,
        MESSAGING,
        HANDSET,
        DEVICE,
        NETWORK,
        ENTERTAINMENT,
        SUBSCRIPTION,
        SOFTWARE,
        OTHER
    }

    private CategoryEnum category;

    public TelcoProductDetailFeature displayName(String displayName) {
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

    public TelcoProductDetailFeature description(String description) {
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

    public TelcoProductDetailFeature category(CategoryEnum category) {
        this.category = category;
        return this;
    }

    /**
     * The type of the feature
     *
     * @return category
     */
    public CategoryEnum getCategory() {
        return category;
    }

    public void setCategory(CategoryEnum category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TelcoProductDetailFeature telcoProductDetailFeature = (TelcoProductDetailFeature) o;
        return Objects.equals(this.displayName, telcoProductDetailFeature.displayName) &&
                Objects.equals(this.description, telcoProductDetailFeature.description) &&
                Objects.equals(this.category, telcoProductDetailFeature.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(displayName, description, category);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TelcoProductDetailFeature {\n");
        sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    category: ").append(toIndentedString(category)).append("\n");
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
