package au.org.consumerdatastandards.client.model.telco;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * TelcoProductDetailPlan
 */
public class TelcoProductDetailPlan {
    private String displayName;

    private String description;

    private String planUri;

    private List<TelcoProductDetailPlanFeature> features = null;

    public TelcoProductDetailPlan displayName(String displayName) {
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

    public TelcoProductDetailPlan description(String description) {
        this.description = description;
        return this;
    }

    /**
     * The display name of the product plan
     *
     * @return description
     */
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TelcoProductDetailPlan planUri(String planUri) {
        this.planUri = planUri;
        return this;
    }

    /**
     * The URI of the product plan
     *
     * @return planUri
     */
    public String getPlanUri() {
        return planUri;
    }

    public void setPlanUri(String planUri) {
        this.planUri = planUri;
    }

    public TelcoProductDetailPlan features(List<TelcoProductDetailPlanFeature> features) {
        this.features = features;
        return this;
    }

    public TelcoProductDetailPlan addFeaturesItem(TelcoProductDetailPlanFeature featuresItem) {
        if (this.features == null) {
            this.features = new ArrayList<>();
        }
        this.features.add(featuresItem);
        return this;
    }

    /**
     * Optional list of features of the plan
     *
     * @return features
     */
    public List<TelcoProductDetailPlanFeature> getFeatures() {
        return features;
    }

    public void setFeatures(List<TelcoProductDetailPlanFeature> features) {
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
        TelcoProductDetailPlan telcoProductDetailPlan = (TelcoProductDetailPlan) o;
        return Objects.equals(this.displayName, telcoProductDetailPlan.displayName) &&
                Objects.equals(this.description, telcoProductDetailPlan.description) &&
                Objects.equals(this.planUri, telcoProductDetailPlan.planUri) &&
                Objects.equals(this.features, telcoProductDetailPlan.features);
    }

    @Override
    public int hashCode() {
        return Objects.hash(displayName, description, planUri, features);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TelcoProductDetailPlan {\n");
        sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    planUri: ").append(toIndentedString(planUri)).append("\n");
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
