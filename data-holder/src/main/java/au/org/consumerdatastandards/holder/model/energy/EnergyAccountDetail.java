package au.org.consumerdatastandards.holder.model.energy;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * EnergyAccountDetail
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen",
        date = "2022-01-11T14:03:27.755+11:00[Australia/Sydney]")
public class EnergyAccountDetail {
    @JsonProperty("accountId")
    private String accountId;

    @JsonProperty("accountNumber")
    private String accountNumber;

    @JsonProperty("displayName")
    private String displayName;

    @JsonProperty("creationDate")
    private String creationDate;

    @JsonProperty("plans")
    @Valid
    private List<EnergyAccountDetailAllOfPlans> plans = new ArrayList<>();

    public EnergyAccountDetail accountId(String accountId) {
        this.accountId = accountId;
        return this;
    }

    /**
     * The ID of the account.  To be created in accordance with CDR ID permanence requirements
     *
     * @return accountId
     */
    @ApiModelProperty(required = true,
            value = "The ID of the account.  To be created in accordance with CDR ID permanence requirements")
    @NotNull


    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public EnergyAccountDetail accountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
        return this;
    }

    /**
     * Optional identifier of the account as defined by the data holder.  This must be the value presented on physical statements (if it exists) and must not be used for the value of accountId
     *
     * @return accountNumber
     */
    @ApiModelProperty(value = "Optional identifier of the account as defined by the data holder.  This must be the value presented on physical statements (if it exists) and must not be used for the value of accountId")


    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public EnergyAccountDetail displayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    /**
     * An optional display name for the account if one exists or can be derived.  The content of this field is at the discretion of the data holder
     *
     * @return displayName
     */
    @ApiModelProperty(value = "An optional display name for the account if one exists or can be derived.  The content of this field is at the discretion of the data holder")


    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public EnergyAccountDetail creationDate(String creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    /**
     * The date that the account was created or opened
     *
     * @return creationDate
     */
    @ApiModelProperty(required = true,
            value = "The date that the account was created or opened")
    @NotNull


    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public EnergyAccountDetail plans(List<EnergyAccountDetailAllOfPlans> plans) {
        this.plans = plans;
        return this;
    }

    public EnergyAccountDetail addPlansItem(EnergyAccountDetailAllOfPlans plansItem) {
        this.plans.add(plansItem);
        return this;
    }

    /**
     * The array of plans containing service points and associated plan details
     *
     * @return plans
     */
    @ApiModelProperty(required = true,
            value = "The array of plans containing service points and associated plan details")
    @NotNull

    @Valid

    public List<EnergyAccountDetailAllOfPlans> getPlans() {
        return plans;
    }

    public void setPlans(List<EnergyAccountDetailAllOfPlans> plans) {
        this.plans = plans;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EnergyAccountDetail energyAccountDetail = (EnergyAccountDetail) o;
        return Objects.equals(this.accountId, energyAccountDetail.accountId) &&
                Objects.equals(this.accountNumber, energyAccountDetail.accountNumber) &&
                Objects.equals(this.displayName, energyAccountDetail.displayName) &&
                Objects.equals(this.creationDate, energyAccountDetail.creationDate) &&
                Objects.equals(this.plans, energyAccountDetail.plans);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, accountNumber, displayName, creationDate, plans);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyAccountDetail {\n");

        sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
        sb.append("    accountNumber: ").append(toIndentedString(accountNumber)).append("\n");
        sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
        sb.append("    creationDate: ").append(toIndentedString(creationDate)).append("\n");
        sb.append("    plans: ").append(toIndentedString(plans)).append("\n");
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

