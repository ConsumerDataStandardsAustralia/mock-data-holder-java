package au.org.consumerdatastandards.client.model.telco;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * TelcoProductDetailDiscounts
 */
public class TelcoProductDetailDiscounts {
    private String displayName;

    private String description;

    private String discountUri;

    private List<TelcoProductDetailDiscountFeature> features = null;

    public TelcoProductDetailDiscounts displayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    /**
     * The display name of the product plan
     *
     * @return displayName
     */
    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public TelcoProductDetailDiscounts description(String description) {
        this.description = description;
        return this;
    }

    /**
     * The description name of the product plan
     *
     * @return description
     */
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TelcoProductDetailDiscounts discountUri(String discountUri) {
        this.discountUri = discountUri;
        return this;
    }

    /**
     * The URI of the discount
     *
     * @return discountUri
     */
    public String getDiscountUri() {
        return discountUri;
    }

    public void setDiscountUri(String discountUri) {
        this.discountUri = discountUri;
    }

    public TelcoProductDetailDiscounts features(List<TelcoProductDetailDiscountFeature> features) {
        this.features = features;
        return this;
    }

    public TelcoProductDetailDiscounts addFeaturesItem(TelcoProductDetailDiscountFeature featuresItem) {
        if (this.features == null) {
            this.features = new ArrayList<>();
        }
        this.features.add(featuresItem);
        return this;
    }

    /**
     * Optional list of features of the discount
     *
     * @return features
     */
    public List<TelcoProductDetailDiscountFeature> getFeatures() {
        return features;
    }

    public void setFeatures(List<TelcoProductDetailDiscountFeature> features) {
        this.features = features;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TelcoProductDetailDiscounts telcoProductDetailDiscounts = (TelcoProductDetailDiscounts) o;
        return Objects.equals(this.displayName, telcoProductDetailDiscounts.displayName) &&
                Objects.equals(this.description, telcoProductDetailDiscounts.description) &&
                Objects.equals(this.discountUri, telcoProductDetailDiscounts.discountUri) &&
                Objects.equals(this.features, telcoProductDetailDiscounts.features);
    }

    @Override
    public int hashCode() {
        return Objects.hash(displayName, description, discountUri, features);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TelcoProductDetailDiscounts {\n");
        sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    discountUri: ").append(toIndentedString(discountUri)).append("\n");
        sb.append("    features: ").append(toIndentedString(features)).append("\n");
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
