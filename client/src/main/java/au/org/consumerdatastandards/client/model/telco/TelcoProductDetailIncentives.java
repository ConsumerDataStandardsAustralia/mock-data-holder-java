package au.org.consumerdatastandards.client.model.telco;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * TelcoProductDetailIncentives
 */
public class TelcoProductDetailIncentives {
    private String displayName;

    private String description;

    private String incentiveUri;

    private List<TelcoProductDetailIncentiveFeature> features = null;

    public TelcoProductDetailIncentives displayName(String displayName) {
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

    public TelcoProductDetailIncentives description(String description) {
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

    public TelcoProductDetailIncentives incentiveUri(String incentiveUri) {
        this.incentiveUri = incentiveUri;
        return this;
    }

    /**
     * The URI of the incentive
     *
     * @return incentiveUri
     */
    public String getIncentiveUri() {
        return incentiveUri;
    }

    public void setIncentiveUri(String incentiveUri) {
        this.incentiveUri = incentiveUri;
    }

    public TelcoProductDetailIncentives features(List<TelcoProductDetailIncentiveFeature> features) {
        this.features = features;
        return this;
    }

    public TelcoProductDetailIncentives addFeaturesItem(TelcoProductDetailIncentiveFeature featuresItem) {
        if (this.features == null) {
            this.features = new ArrayList<>();
        }
        this.features.add(featuresItem);
        return this;
    }

    /**
     * Optional list of features of the incentive
     *
     * @return features
     */
    public List<TelcoProductDetailIncentiveFeature> getFeatures() {
        return features;
    }

    public void setFeatures(List<TelcoProductDetailIncentiveFeature> features) {
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
        TelcoProductDetailIncentives telcoProductDetailIncentives = (TelcoProductDetailIncentives) o;
        return Objects.equals(this.displayName, telcoProductDetailIncentives.displayName) &&
                Objects.equals(this.description, telcoProductDetailIncentives.description) &&
                Objects.equals(this.incentiveUri, telcoProductDetailIncentives.incentiveUri) &&
                Objects.equals(this.features, telcoProductDetailIncentives.features);
    }

    @Override
    public int hashCode() {
        return Objects.hash(displayName, description, incentiveUri, features);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TelcoProductDetailIncentives {\n");
        sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    incentiveUri: ").append(toIndentedString(incentiveUri)).append("\n");
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
