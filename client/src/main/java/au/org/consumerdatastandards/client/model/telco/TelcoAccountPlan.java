package au.org.consumerdatastandards.client.model.telco;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * TelcoAccountPlan
 */
public class TelcoAccountPlan {
    private String nickname;

    private TypeEnum type = TypeEnum.MOBILE;

    private BillingTypeEnum billingType = BillingTypeEnum.PRE_PAID;

    private List<String> serviceIds = new ArrayList<>();

    private TelcoAccountPlanOverview planOverview;

    public TelcoAccountPlan nickname(String nickname) {
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

    public TelcoAccountPlan type(TypeEnum type) {
        this.type = type;
        return this;
    }

    /**
     * The type of the plan
     *
     * @return type
     */
    public TypeEnum getType() {
        return type;
    }

    public void setType(TypeEnum type) {
        this.type = type;
    }

    public TelcoAccountPlan billingType(BillingTypeEnum billingType) {
        this.billingType = billingType;
        return this;
    }

    /**
     * The billing type of then plan
     *
     * @return billingType
     */
    public BillingTypeEnum getBillingType() {
        return billingType;
    }

    public void setBillingType(BillingTypeEnum billingType) {
        this.billingType = billingType;
    }

    public TelcoAccountPlan serviceIds(List<String> serviceIds) {
        this.serviceIds = serviceIds;
        return this;
    }

    public TelcoAccountPlan addServiceIdsItem(String serviceIdsItem) {
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

    public TelcoAccountPlan planOverview(TelcoAccountPlanOverview planOverview) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TelcoAccountPlan telcoAccountPlan = (TelcoAccountPlan) o;
        return Objects.equals(this.nickname, telcoAccountPlan.nickname) &&
                Objects.equals(this.type, telcoAccountPlan.type) &&
                Objects.equals(this.billingType, telcoAccountPlan.billingType) &&
                Objects.equals(this.serviceIds, telcoAccountPlan.serviceIds) &&
                Objects.equals(this.planOverview, telcoAccountPlan.planOverview);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nickname, type, billingType, serviceIds, planOverview);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TelcoAccountPlan {\n");
        sb.append("    nickname: ").append(toIndentedString(nickname)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    billingType: ").append(toIndentedString(billingType)).append("\n");
        sb.append("    serviceIds: ").append(toIndentedString(serviceIds)).append("\n");
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