package au.org.consumerdatastandards.holder.model.energy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Describes the geographical area that the plan is available for.  If absent then it is assumed the plan is not geographically limited
 */
@ApiModel(description = "Describes the geographical area that the plan is available for.  If absent then it is assumed the plan is not geographically limited")
@Entity
public class EnergyPlanGeography {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @JsonIgnore
    private String geographyId;

    @ElementCollection
    @Valid
    private List<String> excludedPostcodes;

    @ElementCollection
    @Valid
    private List<String> includedPostcodes;

    @ElementCollection
    @Valid
    private List<String> distributors;

    public String getGeographyId() {
        return geographyId;
    }

    public void setGeographyId(String geographyId) {
        this.geographyId = geographyId;
    }

    public EnergyPlanGeography excludedPostcodes(List<String> excludedPostcodes) {
        this.excludedPostcodes = excludedPostcodes;
        return this;
    }

    public EnergyPlanGeography addExcludedPostcodesItem(String excludedPostcodesItem) {
        if (this.excludedPostcodes == null) {
            this.excludedPostcodes = new ArrayList<>();
        }
        this.excludedPostcodes.add(excludedPostcodesItem);
        return this;
    }

    /**
     * Array of valid Australian post codes that are specifically excluded from the plan.  Each element is a single four digit postcode (e.g. 3000) or a range of postcodes defined by two four digit postcodes and a hyphen (e.g. 3000-3999)
     *
     * @return excludedPostcodes
     */
    @ApiModelProperty(value = "Array of valid Australian post codes that are specifically excluded from the plan.  Each element is a single four digit postcode (e.g. 3000) or a range of postcodes defined by two four digit postcodes and a hyphen (e.g. 3000-3999)")
    public List<String> getExcludedPostcodes() {
        return excludedPostcodes;
    }

    public void setExcludedPostcodes(List<String> excludedPostcodes) {
        this.excludedPostcodes = excludedPostcodes;
    }

    public EnergyPlanGeography includedPostcodes(List<String> includedPostcodes) {
        this.includedPostcodes = includedPostcodes;
        return this;
    }

    public EnergyPlanGeography addIncludedPostcodesItem(String includedPostcodesItem) {
        if (this.includedPostcodes == null) {
            this.includedPostcodes = new ArrayList<>();
        }
        this.includedPostcodes.add(includedPostcodesItem);
        return this;
    }

    /**
     * Array of valid Australian post codes that are included from the plan.  If absent defaults to all non-excluded post codes.  Each element is a single four digit postcode (e.g. 3000) or a range of postcodes defined by two four digit postcodes and a hyphen (e.g. 3000-3999)
     *
     * @return includedPostcodes
     */
    @ApiModelProperty(value = "Array of valid Australian post codes that are included from the plan.  If absent defaults to all non-excluded post codes.  Each element is a single four digit postcode (e.g. 3000) or a range of postcodes defined by two four digit postcodes and a hyphen (e.g. 3000-3999)")
    public List<String> getIncludedPostcodes() {
        return includedPostcodes;
    }

    public void setIncludedPostcodes(List<String> includedPostcodes) {
        this.includedPostcodes = includedPostcodes;
    }

    /**
     * Array of distributors for the plan. Must have at least one entry
     *
     * @return distributors
     */
    @ApiModelProperty(required = true, value = "Array of distributors for the plan. Must have at least one entry")
    @NotNull
    public List<String> getDistributors() {
        return distributors;
    }

    public void setDistributors(List<String> distributors) {
        this.distributors = distributors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EnergyPlanGeography energyPlanGeography = (EnergyPlanGeography) o;
        return Objects.equals(this.geographyId, energyPlanGeography.geographyId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(geographyId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyPlanGeography {\n");
        sb.append("    geographyId: ").append(toIndentedString(geographyId)).append("\n");
        sb.append("    excludedPostcodes: ").append(toIndentedString(excludedPostcodes)).append("\n");
        sb.append("    includedPostcodes: ").append(toIndentedString(includedPostcodes)).append("\n");
        sb.append("    distributors: ").append(toIndentedString(distributors)).append("\n");
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
