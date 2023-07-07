package au.org.consumerdatastandards.client.model.energy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EnergyAccountDetailPlansBase {
    private String nickname;
    private List<String> servicePointIds = new ArrayList<>();
    private EnergyAccountPlanOverview planOverview;
    private List<EnergyAccountDetailAuthorisedContacts> authorisedContacts = null;

    public EnergyAccountDetailPlansBase nickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    /**
     * Optional display name for the plan provided by the customer to help differentiate multiple plans
     *
     * @return nickname
     */
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public EnergyAccountDetailPlansBase servicePointIds(List<String> servicePointIds) {
        this.servicePointIds = servicePointIds;
        return this;
    }

    public EnergyAccountDetailPlansBase addServicePointIdsItem(String servicePointIdsItem) {
        this.servicePointIds.add(servicePointIdsItem);
        return this;
    }

    /**
     * An array of servicePointIds, representing NMIs, that this account is linked to
     *
     * @return servicePointIds
     */
    public List<String> getServicePointIds() {
        return servicePointIds;
    }

    public void setServicePointIds(List<String> servicePointIds) {
        this.servicePointIds = servicePointIds;
    }

    public EnergyAccountDetailPlansBase planOverview(EnergyAccountPlanOverview planOverview) {
        this.planOverview = planOverview;
        return this;
    }

    /**
     * Get planOverview
     *
     * @return planOverview
     */
    public EnergyAccountPlanOverview getPlanOverview() {
        return planOverview;
    }

    public void setPlanOverview(EnergyAccountPlanOverview planOverview) {
        this.planOverview = planOverview;
    }

    public EnergyAccountDetailPlansBase authorisedContacts(List<EnergyAccountDetailAuthorisedContacts> authorisedContacts) {
        this.authorisedContacts = authorisedContacts;
        return this;
    }

    public EnergyAccountDetailPlansBase addAuthorisedContactsItem(EnergyAccountDetailAuthorisedContacts authorisedContactsItem) {
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
        EnergyAccountDetailPlansBase energyAccountDetailPlans = (EnergyAccountDetailPlansBase) o;
        return Objects.equals(this.nickname, energyAccountDetailPlans.nickname) &&
                Objects.equals(this.servicePointIds, energyAccountDetailPlans.servicePointIds) &&
                Objects.equals(this.planOverview, energyAccountDetailPlans.planOverview) &&
                Objects.equals(this.authorisedContacts, energyAccountDetailPlans.authorisedContacts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nickname, servicePointIds, planOverview, authorisedContacts);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ").append(getClass().getSimpleName()).append(" {");
        writeProperties(sb);
        sb.append("}");
        return sb.toString();
    }

    protected void writeProperties(StringBuilder sb) {
        sb.append("    nickname: ").append(toIndentedString(nickname)).append("\n");
        sb.append("    servicePointIds: ").append(toIndentedString(servicePointIds)).append("\n");
        sb.append("    planOverview: ").append(toIndentedString(planOverview)).append("\n");
        sb.append("    authorisedContacts: ").append(toIndentedString(authorisedContacts)).append("\n");
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    protected String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
