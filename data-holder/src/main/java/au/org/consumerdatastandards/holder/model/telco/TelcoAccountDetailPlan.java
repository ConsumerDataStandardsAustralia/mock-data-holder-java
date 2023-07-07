package au.org.consumerdatastandards.holder.model.telco;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * TelcoAccountDetailPlan
 */
public class TelcoAccountDetailPlan {
    private String nickname;

    @Valid
    private List<String> serviceIds = new ArrayList<>();

    private TelcoAccountPlanOverview planOverview;

    private TelcoAccountDetailPlanDetail planDetail;

    private TypeEnum type = TypeEnum.MOBILE;

    private BillingTypeEnum billingType = BillingTypeEnum.PRE_PAID;

    public TelcoAccountDetailPlan nickname(String nickname) {
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

    public TelcoAccountDetailPlan serviceIds(List<String> serviceIds) {
        this.serviceIds = serviceIds;
        return this;
    }

    public TelcoAccountDetailPlan addServiceIdsItem(String serviceIdsItem) {
        this.serviceIds.add(serviceIdsItem);
        return this;
    }

    /**
     * The serviceId representing a unique service identifier such as a mobile [MSISDN](https://www.etsi.org/deliver/etsi_gts/03/0303/05.00.00_60/gsmts_0303v050000p.pdf), [FNN](https://www.nbnco.com.au/content/dam/nbnco2/documents/sfaa-wba2-dictionary_FTTN-launch.pdf) or internet service e.g [NBN AVC Service ID](https://www.nbnco.com.au/content/dam/nbnco2/documents/sfaa-wba2-dictionary_FTTN-launch.pdf). In accordance with [CDR ID permanence](#id-permanence) requirement
     *
     * @return serviceIds
     */
    @ApiModelProperty(required = true,
            value = "The serviceId representing a unique service identifier such as a mobile [MSISDN](https://www.etsi.org/deliver/etsi_gts/03/0303/05.00.00_60/gsmts_0303v050000p.pdf), [FNN](https://www.nbnco.com.au/content/dam/nbnco2/documents/sfaa-wba2-dictionary_FTTN-launch.pdf) or internet service e.g [NBN AVC Service ID](https://www.nbnco.com.au/content/dam/nbnco2/documents/sfaa-wba2-dictionary_FTTN-launch.pdf). In accordance with [CDR ID permanence](#id-permanence) requirement")
    @NotNull
    public List<String> getServiceIds() {
        return serviceIds;
    }

    public void setServiceIds(List<String> serviceIds) {
        this.serviceIds = serviceIds;
    }

    public TelcoAccountDetailPlan planOverview(TelcoAccountPlanOverview planOverview) {
        this.planOverview = planOverview;
        return this;
    }

    /**
     * Get planOverview
     *
     * @return planOverview
     */
    @ApiModelProperty(required = true, value = "")
    @Valid
    @NotNull
    public TelcoAccountPlanOverview getPlanOverview() {
        return planOverview;
    }

    public void setPlanOverview(TelcoAccountPlanOverview planOverview) {
        this.planOverview = planOverview;
    }

    public TelcoAccountDetailPlan planDetail(TelcoAccountDetailPlanDetail planDetail) {
        this.planDetail = planDetail;
        return this;
    }

    /**
     * Get planDetail
     *
     * @return planDetail
     */
    @ApiModelProperty(required = true, value = "")
    @Valid
    @NotNull
    public TelcoAccountDetailPlanDetail getPlanDetail() {
        return planDetail;
    }

    public void setPlanDetail(TelcoAccountDetailPlanDetail planDetail) {
        this.planDetail = planDetail;
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

    public TelcoAccountDetailPlan billingType(BillingTypeEnum billingType) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TelcoAccountDetailPlan telcoAccountDetailPlan = (TelcoAccountDetailPlan) o;
        return Objects.equals(this.nickname, telcoAccountDetailPlan.nickname) &&
                Objects.equals(this.serviceIds, telcoAccountDetailPlan.serviceIds) &&
                Objects.equals(this.planOverview, telcoAccountDetailPlan.planOverview) &&
                Objects.equals(this.planDetail, telcoAccountDetailPlan.planDetail) &&
                Objects.equals(this.type, telcoAccountDetailPlan.type) &&
                Objects.equals(this.billingType, telcoAccountDetailPlan.billingType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nickname, serviceIds, planOverview, planDetail, type, billingType);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TelcoAccountDetailPlan {\n");
        sb.append("    nickname: ").append(toIndentedString(nickname)).append("\n");
        sb.append("    serviceIds: ").append(toIndentedString(serviceIds)).append("\n");
        sb.append("    planOverview: ").append(toIndentedString(planOverview)).append("\n");
        sb.append("    planDetail: ").append(toIndentedString(planDetail)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    billingType: ").append(toIndentedString(billingType)).append("\n");
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
