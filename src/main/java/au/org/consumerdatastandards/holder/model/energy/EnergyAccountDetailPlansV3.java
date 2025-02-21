package au.org.consumerdatastandards.holder.model.energy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * EnergyAccountDetailPlansV3
 */
@Entity
@Table(name = "e_account_plan")
public class EnergyAccountDetailPlansV3 {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @JsonIgnore
    private String id;

    private String nickname;

    @Valid
    @ElementCollection
    private List<String> servicePointIds = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(
            name = "e_acc_plan_overview",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "plan_overview_id"))
    private EnergyAccountPlanOverview planOverview;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(
            name = "e_acc_detail_plan",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "acc_plan_id"))
    private EnergyAccountDetailPlanDetailV3 planDetail;

    @Valid
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "e_acc_detail_auth_contacts",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "auth_contact_id"))
    private List<EnergyAccountDetailAuthorisedContacts> authorisedContacts = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public EnergyAccountDetailPlansV3 nickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    /**
     * Optional display name for the plan provided by the customer to help differentiate multiple plans.
     *
     * @return nickname
     */
    @ApiModelProperty(value = "Optional display name for the plan provided by the customer to help differentiate multiple plans.")
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public EnergyAccountDetailPlansV3 servicePointIds(List<String> servicePointIds) {
        this.servicePointIds = servicePointIds;
        return this;
    }

    public EnergyAccountDetailPlansV3 addServicePointIdsItem(String servicePointIdsItem) {
        this.servicePointIds.add(servicePointIdsItem);
        return this;
    }

    /**
     * An array of _servicePointId_ values, representing NMIs, that this account is linked to.
     *
     * @return servicePointIds
     */
    @ApiModelProperty(required = true,
            value = "An array of _servicePointId_ values, representing NMIs, that this account is linked to.")
    @NotNull
    public List<String> getServicePointIds() {
        return servicePointIds;
    }

    public void setServicePointIds(List<String> servicePointIds) {
        this.servicePointIds = servicePointIds;
    }

    public EnergyAccountDetailPlansV3 planOverview(EnergyAccountPlanOverview planOverview) {
        this.planOverview = planOverview;
        return this;
    }

    /**
     * Mandatory if _openStatus_ is `OPEN`.
     *
     * @return planOverview
     */
    @ApiModelProperty(value = "Mandatory if _openStatus_ is `OPEN`.")
    @Valid
    public EnergyAccountPlanOverview getPlanOverview() {
        return planOverview;
    }

    public void setPlanOverview(EnergyAccountPlanOverview planOverview) {
        this.planOverview = planOverview;
    }

    public EnergyAccountDetailPlansV3 planDetail(EnergyAccountDetailPlanDetailV3 planDetail) {
        this.planDetail = planDetail;
        return this;
    }

    /**
     * Get planDetail
     *
     * @return planDetail
     */
    @ApiModelProperty(value = "")
    @Valid
    public EnergyAccountDetailPlanDetailV3 getPlanDetail() {
        return planDetail;
    }

    public void setPlanDetail(EnergyAccountDetailPlanDetailV3 planDetail) {
        this.planDetail = planDetail;
    }

    public EnergyAccountDetailPlansV3 authorisedContacts(List<EnergyAccountDetailAuthorisedContacts> authorisedContacts) {
        this.authorisedContacts = authorisedContacts;
        return this;
    }

    public EnergyAccountDetailPlansV3 addAuthorisedContactsItem(EnergyAccountDetailAuthorisedContacts authorisedContactsItem) {
        if (this.authorisedContacts == null) {
            this.authorisedContacts = new ArrayList<>();
        }
        this.authorisedContacts.add(authorisedContactsItem);
        return this;
    }

    /**
     * An array of additional contacts that are authorised to act on this account.
     *
     * @return authorisedContacts
     */
    @ApiModelProperty(value = "An array of additional contacts that are authorised to act on this account.")
    @Valid
    public List<EnergyAccountDetailAuthorisedContacts> getAuthorisedContacts() {
        return authorisedContacts;
    }

    public void setAuthorisedContacts(List<EnergyAccountDetailAuthorisedContacts> authorisedContacts) {
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
        EnergyAccountDetailPlansV3 energyAccountDetailPlans = (EnergyAccountDetailPlansV3) o;
        return Objects.equals(this.nickname, energyAccountDetailPlans.nickname) &&
                Objects.equals(this.servicePointIds, energyAccountDetailPlans.servicePointIds) &&
                Objects.equals(this.planOverview, energyAccountDetailPlans.planOverview) &&
                Objects.equals(this.planDetail, energyAccountDetailPlans.planDetail) &&
                Objects.equals(this.authorisedContacts, energyAccountDetailPlans.authorisedContacts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nickname, servicePointIds, planOverview, planDetail, authorisedContacts);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyAccountDetailPlansV3 {\n");
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
