package au.org.consumerdatastandards.holder.model.energy;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * EnergyAccountAllOfPlans
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen",
        date = "2022-01-11T14:03:27.755+11:00[Australia/Sydney]")
public class EnergyAccountAllOfPlans {
    @JsonProperty("nickname")
    private String nickname;

    @JsonProperty("servicePointIds")
    @Valid
    private List<String> servicePointIds = new ArrayList<>();

    @JsonProperty("planOverview")
    private EnergyAccountAllOfPlanOverview planOverview;

    public EnergyAccountAllOfPlans nickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    /**
     * Optional display name for the plan provided by the customer to help differentiate multiple plans
     *
     * @return nickname
     */
    @ApiModelProperty(value = "Optional display name for the plan provided by the customer to help differentiate multiple plans")


    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public EnergyAccountAllOfPlans servicePointIds(List<String> servicePointIds) {
        this.servicePointIds = servicePointIds;
        return this;
    }

    public EnergyAccountAllOfPlans addServicePointIdsItem(String servicePointIdsItem) {
        this.servicePointIds.add(servicePointIdsItem);
        return this;
    }

    /**
     * An array of servicePointIds, representing NMIs, that this plan is linked to.  If there are no service points allocated to this plan then an empty array would be expected
     *
     * @return servicePointIds
     */
    @ApiModelProperty(required = true,
            value = "An array of servicePointIds, representing NMIs, that this plan is linked to.  If there are no service points allocated to this plan then an empty array would be expected")
    @NotNull


    public List<String> getServicePointIds() {
        return servicePointIds;
    }

    public void setServicePointIds(List<String> servicePointIds) {
        this.servicePointIds = servicePointIds;
    }

    public EnergyAccountAllOfPlans planOverview(EnergyAccountAllOfPlanOverview planOverview) {
        this.planOverview = planOverview;
        return this;
    }

    /**
     * Get planOverview
     *
     * @return planOverview
     */
    @ApiModelProperty(required = true,
            value = "")
    @NotNull

    @Valid

    public EnergyAccountAllOfPlanOverview getPlanOverview() {
        return planOverview;
    }

    public void setPlanOverview(EnergyAccountAllOfPlanOverview planOverview) {
        this.planOverview = planOverview;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EnergyAccountAllOfPlans energyAccountAllOfPlans = (EnergyAccountAllOfPlans) o;
        return Objects.equals(this.nickname, energyAccountAllOfPlans.nickname) &&
                Objects.equals(this.servicePointIds, energyAccountAllOfPlans.servicePointIds) &&
                Objects.equals(this.planOverview, energyAccountAllOfPlans.planOverview);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nickname, servicePointIds, planOverview);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyAccountAllOfPlans {\n");

        sb.append("    nickname: ").append(toIndentedString(nickname)).append("\n");
        sb.append("    servicePointIds: ").append(toIndentedString(servicePointIds)).append("\n");
        sb.append("    planOverview: ").append(toIndentedString(planOverview)).append("\n");
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

