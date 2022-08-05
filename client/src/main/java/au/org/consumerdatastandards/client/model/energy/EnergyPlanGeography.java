package au.org.consumerdatastandards.client.model.energy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Describes the geographical area that the plan is available for.  If absent then it is assumed the plan is not geographically limited
 */
public class EnergyPlanGeography {
    private List<String> excludedPostcodes;

    private List<String> includedPostcodes;

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
    public List<String> getIncludedPostcodes() {
        return includedPostcodes;
    }

    public void setIncludedPostcodes(List<String> includedPostcodes) {
        this.includedPostcodes = includedPostcodes;
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
        return Objects.equals(this.excludedPostcodes, energyPlanGeography.excludedPostcodes) &&
                Objects.equals(this.includedPostcodes, energyPlanGeography.includedPostcodes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(excludedPostcodes, includedPostcodes);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyPlanGeography {\n");
        sb.append("    excludedPostcodes: ").append(toIndentedString(excludedPostcodes)).append("\n");
        sb.append("    includedPostcodes: ").append(toIndentedString(includedPostcodes)).append("\n");
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
