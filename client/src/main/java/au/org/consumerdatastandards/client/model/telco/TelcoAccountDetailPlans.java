package au.org.consumerdatastandards.client.model.telco;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * TelcoAccountDetailPlans
 */
public class TelcoAccountDetailPlans {
    private String nickname;

    private List<String> serviceIds = new ArrayList<>();

    private TelcoAccountPlanOverview planOverview;

    private TelcoAccountDetailPlanDetail planDetail;

    private List<TelcoAccountDetailAuthorisedContacts> authorisedContacts = null;

    public TelcoAccountDetailPlans nickname(String nickname) {
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

    public TelcoAccountDetailPlans serviceIds(List<String> serviceIds) {
        this.serviceIds = serviceIds;
        return this;
    }

    public TelcoAccountDetailPlans addServiceIdsItem(String serviceIdsItem) {
        this.serviceIds.add(serviceIdsItem);
        return this;
    }

    /**
     * The serviceId representing a unique service identifier such as a mobile [MSISDN](https://www.etsi.org/deliver/etsi_gts/03/0303/05.00.00_60/gsmts_0303v050000p.pdf), [FNN](https://www.nbnco.com.au/content/dam/nbnco2/documents/sfaa-wba2-dictionary_FTTN-launch.pdf) or internet service e.g [NBN AVC Service ID](https://www.nbnco.com.au/content/dam/nbnco2/documents/sfaa-wba2-dictionary_FTTN-launch.pdf). In accordance with [CDR ID permanence](#id-permanence) requirement
     *
     * @return serviceIds
     */
    public List<String> getServiceIds() {
        return serviceIds;
    }

    public void setServiceIds(List<String> serviceIds) {
        this.serviceIds = serviceIds;
    }

    public TelcoAccountDetailPlans planOverview(TelcoAccountPlanOverview planOverview) {
        this.planOverview = planOverview;
        return this;
    }

    /**
     * Get planOverview
     *
     * @return planOverview
     */
    public TelcoAccountPlanOverview getPlanOverview() {
        return planOverview;
    }

    public void setPlanOverview(TelcoAccountPlanOverview planOverview) {
        this.planOverview = planOverview;
    }

    public TelcoAccountDetailPlans planDetail(TelcoAccountDetailPlanDetail planDetail) {
        this.planDetail = planDetail;
        return this;
    }

    /**
     * Get planDetail
     *
     * @return planDetail
     */
    public TelcoAccountDetailPlanDetail getPlanDetail() {
        return planDetail;
    }

    public void setPlanDetail(TelcoAccountDetailPlanDetail planDetail) {
        this.planDetail = planDetail;
    }

    public TelcoAccountDetailPlans authorisedContacts(List<TelcoAccountDetailAuthorisedContacts> authorisedContacts) {
        this.authorisedContacts = authorisedContacts;
        return this;
    }

    public TelcoAccountDetailPlans addAuthorisedContactsItem(TelcoAccountDetailAuthorisedContacts authorisedContactsItem) {
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
    public List<TelcoAccountDetailAuthorisedContacts> getAuthorisedContacts() {
        return authorisedContacts;
    }

    public void setAuthorisedContacts(List<TelcoAccountDetailAuthorisedContacts> authorisedContacts) {
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
        TelcoAccountDetailPlans telcoAccountDetailPlans = (TelcoAccountDetailPlans) o;
        return Objects.equals(this.nickname, telcoAccountDetailPlans.nickname) &&
                Objects.equals(this.serviceIds, telcoAccountDetailPlans.serviceIds) &&
                Objects.equals(this.planOverview, telcoAccountDetailPlans.planOverview) &&
                Objects.equals(this.planDetail, telcoAccountDetailPlans.planDetail) &&
                Objects.equals(this.authorisedContacts, telcoAccountDetailPlans.authorisedContacts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nickname, serviceIds, planOverview, planDetail, authorisedContacts);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TelcoAccountDetailPlans {\n");
        sb.append("    nickname: ").append(toIndentedString(nickname)).append("\n");
        sb.append("    serviceIds: ").append(toIndentedString(serviceIds)).append("\n");
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
