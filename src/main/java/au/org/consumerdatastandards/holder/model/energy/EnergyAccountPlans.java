package au.org.consumerdatastandards.holder.model.energy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * EnergyAccountPlans
 */
@Entity
@Table(name = "e_account_plan")
public class EnergyAccountPlans {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @JsonIgnore
    private String id;

    private String nickname;

    @Valid
    @ElementCollection
    private List<String> servicePointIds = new ArrayList<>();

    /**
     * Mandatory if _openStatus_ is `OPEN`.
     */
    @OneToOne(cascade = CascadeType.ALL)
    private EnergyAccountPlanOverview planOverview;

    public EnergyAccountPlans nickname(String nickname) {
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

    public EnergyAccountPlans servicePointIds(List<String> servicePointIds) {
        this.servicePointIds = servicePointIds;
        return this;
    }

    public EnergyAccountPlans addServicePointIdsItem(String servicePointIdsItem) {
        this.servicePointIds.add(servicePointIdsItem);
        return this;
    }

    /**
     * An array of _servicePointId_ values, representing NMIs, that this plan is linked to. If there are no service points allocated to this plan then an empty array would be expected.
     *
     * @return servicePointIds
     */
    @ApiModelProperty(required = true,
            value = "An array of _servicePointId_ values, representing NMIs, that this plan is linked to. If there are no service points allocated to this plan then an empty array would be expected.")
    @NotNull
    public List<String> getServicePointIds() {
        return servicePointIds;
    }

    public void setServicePointIds(List<String> servicePointIds) {
        this.servicePointIds = servicePointIds;
    }

    public EnergyAccountPlans planOverview(EnergyAccountPlanOverview planOverview) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EnergyAccountPlans energyAccountPlans = (EnergyAccountPlans) o;
        return Objects.equals(this.nickname, energyAccountPlans.nickname) &&
                Objects.equals(this.servicePointIds, energyAccountPlans.servicePointIds) &&
                Objects.equals(this.planOverview, energyAccountPlans.planOverview);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nickname, servicePointIds, planOverview);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyAccountPlans {\n");
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
