package au.org.consumerdatastandards.holder.model.energy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

/**
 * Object that contains links to additional information on specific topics
 */
@ApiModel(description = "Object that contains links to additional information on specific topics")
@Entity
public class EnergyPlanAdditionalInformation {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @JsonIgnore
    private String additionalInformationId;

    private String overviewUri;

    private String termsUri;

    private String eligibilityUri;

    private String pricingUri;

    private String bundleUri;

    public String getAdditionalInformationId() {
        return additionalInformationId;
    }

    public void setAdditionalInformationId(String additionalInformationId) {
        this.additionalInformationId = additionalInformationId;
    }

    public EnergyPlanAdditionalInformation overviewUri(String overviewUri) {
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

    public EnergyPlanAdditionalInformation termsUri(String termsUri) {
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

    public EnergyPlanAdditionalInformation eligibilityUri(String eligibilityUri) {
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

    public EnergyPlanAdditionalInformation pricingUri(String pricingUri) {
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

    public EnergyPlanAdditionalInformation bundleUri(String bundleUri) {
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
        EnergyPlanAdditionalInformation that = (EnergyPlanAdditionalInformation) o;
        return Objects.equals(additionalInformationId, that.additionalInformationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(additionalInformationId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyPlanAdditionalInformation {\n");
        sb.append("    additionalInformationId: ").append(toIndentedString(additionalInformationId)).append('\n');
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
