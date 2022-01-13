package au.org.consumerdatastandards.holder.model.energy;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * EnergyAccountDetailAllOfPlans
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen",
        date = "2022-01-11T14:03:27.755+11:00[Australia/Sydney]")
public class EnergyAccountDetailAllOfPlans {
    @JsonProperty("nickname")
    private String nickname;

    @JsonProperty("servicePointIds")
    @Valid
    private List<String> servicePointIds = new ArrayList<>();

    @JsonProperty("planOverview")
    private EnergyAccountAllOfPlanOverview planOverview;

    @JsonProperty("planDetail")
    private EnergyAccountDetailAllOfPlanDetail planDetail;

    @JsonProperty("authorisedContacts")
    @Valid
    private List<EnergyAccountDetailAllOfAuthorisedContacts> authorisedContacts = null;

    public EnergyAccountDetailAllOfPlans nickname(String nickname) {
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

    public EnergyAccountDetailAllOfPlans servicePointIds(List<String> servicePointIds) {
        this.servicePointIds = servicePointIds;
        return this;
    }

    public EnergyAccountDetailAllOfPlans addServicePointIdsItem(String servicePointIdsItem) {
        this.servicePointIds.add(servicePointIdsItem);
        return this;
    }

    /**
     * An array of servicePointIds, representing NMIs, that this account is linked to
     *
     * @return servicePointIds
     */
    @ApiModelProperty(required = true,
            value = "An array of servicePointIds, representing NMIs, that this account is linked to")
    @NotNull


    public List<String> getServicePointIds() {
        return servicePointIds;
    }

    public void setServicePointIds(List<String> servicePointIds) {
        this.servicePointIds = servicePointIds;
    }

    public EnergyAccountDetailAllOfPlans planOverview(EnergyAccountAllOfPlanOverview planOverview) {
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

    public EnergyAccountDetailAllOfPlans planDetail(EnergyAccountDetailAllOfPlanDetail planDetail) {
        this.planDetail = planDetail;
        return this;
    }

    /**
     * Get planDetail
     *
     * @return planDetail
     */
    @ApiModelProperty(required = true,
            value = "")
    @NotNull

    @Valid

    public EnergyAccountDetailAllOfPlanDetail getPlanDetail() {
        return planDetail;
    }

    public void setPlanDetail(EnergyAccountDetailAllOfPlanDetail planDetail) {
        this.planDetail = planDetail;
    }

    public EnergyAccountDetailAllOfPlans authorisedContacts(List<EnergyAccountDetailAllOfAuthorisedContacts> authorisedContacts) {
        this.authorisedContacts = authorisedContacts;
        return this;
    }

    public EnergyAccountDetailAllOfPlans addAuthorisedContactsItem(EnergyAccountDetailAllOfAuthorisedContacts authorisedContactsItem) {
        if (this.authorisedContacts == null) {
            this.authorisedContacts = new ArrayList<>();
        }
        this.authorisedContacts.add(authorisedContactsItem);
        return this;
    }

    /**
     * An array of additional contacts that are authorised to act on this account
     *
     * @return authorisedContacts
     */
    @ApiModelProperty(value = "An array of additional contacts that are authorised to act on this account")

    @Valid

    public List<EnergyAccountDetailAllOfAuthorisedContacts> getAuthorisedContacts() {
        return authorisedContacts;
    }

    public void setAuthorisedContacts(List<EnergyAccountDetailAllOfAuthorisedContacts> authorisedContacts) {
        this.authorisedContacts = authorisedContacts;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EnergyAccountDetailAllOfPlans energyAccountDetailAllOfPlans = (EnergyAccountDetailAllOfPlans) o;
        return Objects.equals(this.nickname, energyAccountDetailAllOfPlans.nickname) &&
                Objects.equals(this.servicePointIds, energyAccountDetailAllOfPlans.servicePointIds) &&
                Objects.equals(this.planOverview, energyAccountDetailAllOfPlans.planOverview) &&
                Objects.equals(this.planDetail, energyAccountDetailAllOfPlans.planDetail) &&
                Objects.equals(this.authorisedContacts, energyAccountDetailAllOfPlans.authorisedContacts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nickname, servicePointIds, planOverview, planDetail, authorisedContacts);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyAccountDetailAllOfPlans {\n");

        sb.append("    nickname: ").append(toIndentedString(nickname)).append("\n");
        sb.append("    servicePointIds: ").append(toIndentedString(servicePointIds)).append("\n");
        sb.append("    planOverview: ").append(toIndentedString(planOverview)).append("\n");
        sb.append("    planDetail: ").append(toIndentedString(planDetail)).append("\n");
        sb.append("    authorisedContacts: ").append(toIndentedString(authorisedContacts)).append("\n");
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

