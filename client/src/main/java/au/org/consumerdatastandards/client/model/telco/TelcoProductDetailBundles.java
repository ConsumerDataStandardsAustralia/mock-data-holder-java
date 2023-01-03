package au.org.consumerdatastandards.client.model.telco;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * TelcoProductDetailBundles
 */
public class TelcoProductDetailBundles {
    private String displayName;

    private String description;

    private String bundleUri;

    private List<TelcoProductDetailFeature> features = null;

    public TelcoProductDetailBundles displayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    /**
     * The display name of the product bundle
     *
     * @return displayName
     */
    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public TelcoProductDetailBundles description(String description) {
        this.description = description;
        return this;
    }

    /**
     * The description of the product bundle
     *
     * @return description
     */
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TelcoProductDetailBundles bundleUri(String bundleUri) {
        this.bundleUri = bundleUri;
        return this;
    }

    /**
     * The URI of the product bundle
     *
     * @return bundleUri
     */
    public String getBundleUri() {
        return bundleUri;
    }

    public void setBundleUri(String bundleUri) {
        this.bundleUri = bundleUri;
    }

    public TelcoProductDetailBundles features(List<TelcoProductDetailFeature> features) {
        this.features = features;
        return this;
    }

    public TelcoProductDetailBundles addFeaturesItem(TelcoProductDetailFeature featuresItem) {
        if (this.features == null) {
            this.features = new ArrayList<>();
        }
        this.features.add(featuresItem);
        return this;
    }

    /**
     * Optional list of features of the bundle
     *
     * @return features
     */
    public List<TelcoProductDetailFeature> getFeatures() {
        return features;
    }

    public void setFeatures(List<TelcoProductDetailFeature> features) {
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
        TelcoProductDetailBundles telcoProductDetailBundles = (TelcoProductDetailBundles) o;
        return Objects.equals(this.displayName, telcoProductDetailBundles.displayName) &&
                Objects.equals(this.description, telcoProductDetailBundles.description) &&
                Objects.equals(this.bundleUri, telcoProductDetailBundles.bundleUri) &&
                Objects.equals(this.features, telcoProductDetailBundles.features);
    }

    @Override
    public int hashCode() {
        return Objects.hash(displayName, description, bundleUri, features);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TelcoProductDetailBundles {\n");
        sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    bundleUri: ").append(toIndentedString(bundleUri)).append("\n");
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
