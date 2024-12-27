package au.org.consumerdatastandards.holder.model.telco;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * Object that contains links to additional information on specific topics.
 */
@ApiModel(description = "Object that contains links to additional information on specific topics.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen",
        date = "2022-12-23T11:32:06.900+11:00[Australia/Sydney]")
public class TelcoAdditionalInformation {
    @JsonProperty("overviewUri")
    private String overviewUri;

    @JsonProperty("termsUri")
    private String termsUri;

    @JsonProperty("eligibilityUri")
    private String eligibilityUri;

    @JsonProperty("pricingUri")
    private String pricingUri;

    @JsonProperty("bundleUri")
    private String bundleUri;

    public TelcoAdditionalInformation overviewUri(String overviewUri) {
        this.overviewUri = overviewUri;
        return this;
    }

    /**
     * A link to a general overview of the plan
     *
     * @return overviewUri
     */
    @ApiModelProperty(value = "A link to a general overview of the plan")


    public String getOverviewUri() {
        return overviewUri;
    }

    public void setOverviewUri(String overviewUri) {
        this.overviewUri = overviewUri;
    }

    public TelcoAdditionalInformation termsUri(String termsUri) {
        this.termsUri = termsUri;
        return this;
    }

    /**
     * A link to terms and conditions for the plan
     *
     * @return termsUri
     */
    @ApiModelProperty(value = "A link to terms and conditions for the plan")


    public String getTermsUri() {
        return termsUri;
    }

    public void setTermsUri(String termsUri) {
        this.termsUri = termsUri;
    }

    public TelcoAdditionalInformation eligibilityUri(String eligibilityUri) {
        this.eligibilityUri = eligibilityUri;
        return this;
    }

    /**
     * A link to detail on eligibility criteria for the plan
     *
     * @return eligibilityUri
     */
    @ApiModelProperty(value = "A link to detail on eligibility criteria for the plan")


    public String getEligibilityUri() {
        return eligibilityUri;
    }

    public void setEligibilityUri(String eligibilityUri) {
        this.eligibilityUri = eligibilityUri;
    }

    public TelcoAdditionalInformation pricingUri(String pricingUri) {
        this.pricingUri = pricingUri;
        return this;
    }

    /**
     * A link to detail on pricing for the plan
     *
     * @return pricingUri
     */
    @ApiModelProperty(value = "A link to detail on pricing for the plan")


    public String getPricingUri() {
        return pricingUri;
    }

    public void setPricingUri(String pricingUri) {
        this.pricingUri = pricingUri;
    }

    public TelcoAdditionalInformation bundleUri(String bundleUri) {
        this.bundleUri = bundleUri;
        return this;
    }

    /**
     * A link to detail on bundles that this plan can be a part of
     *
     * @return bundleUri
     */
    @ApiModelProperty(value = "A link to detail on bundles that this plan can be a part of")


    public String getBundleUri() {
        return bundleUri;
    }

    public void setBundleUri(String bundleUri) {
        this.bundleUri = bundleUri;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TelcoAdditionalInformation telcoAdditionalInformation = (TelcoAdditionalInformation) o;
        return Objects.equals(this.overviewUri, telcoAdditionalInformation.overviewUri) &&
                Objects.equals(this.termsUri, telcoAdditionalInformation.termsUri) &&
                Objects.equals(this.eligibilityUri, telcoAdditionalInformation.eligibilityUri) &&
                Objects.equals(this.pricingUri, telcoAdditionalInformation.pricingUri) &&
                Objects.equals(this.bundleUri, telcoAdditionalInformation.bundleUri);
    }

    @Override
    public int hashCode() {
        return Objects.hash(overviewUri, termsUri, eligibilityUri, pricingUri, bundleUri);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TelcoAdditionalInformation {\n");

        sb.append("    overviewUri: ").append(toIndentedString(overviewUri)).append("\n");
        sb.append("    termsUri: ").append(toIndentedString(termsUri)).append("\n");
        sb.append("    eligibilityUri: ").append(toIndentedString(eligibilityUri)).append("\n");
        sb.append("    pricingUri: ").append(toIndentedString(pricingUri)).append("\n");
        sb.append("    bundleUri: ").append(toIndentedString(bundleUri)).append("\n");
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

