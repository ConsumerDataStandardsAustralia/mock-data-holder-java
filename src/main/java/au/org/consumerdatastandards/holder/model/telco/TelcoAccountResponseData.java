package au.org.consumerdatastandards.holder.model.telco;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * TelcoAccountResponseData
 */
public class TelcoAccountResponseData {
    private String accountId;

    private String accountNumber;

    private String displayName;

    private String creationDate;

    private String lastUpdated;

    private String brand;

    /**
     * Open or closed status for the account. If not present then OPEN is assumed
     */
    public enum OpenStatusEnum {
        CLOSED,
        OPEN
    }

    private OpenStatusEnum openStatus = OpenStatusEnum.OPEN;

    @Valid
    private List<TelcoAccountPlan> plans = new ArrayList<>();

    public TelcoAccountResponseData accountId(String accountId) {
        this.accountId = accountId;
        return this;
    }

    /**
     * The ID of the account. To be created in accordance with [CDR ID permanence](#id-permanence) requirements
     *
     * @return accountId
     */
    @ApiModelProperty(value = "The ID of the account. To be created in accordance with [CDR ID permanence](#id-permanence) requirements")
    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public TelcoAccountResponseData accountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
        return this;
    }

    /**
     * Masked identifier of the account as defined by the data holder. This must be the value presented on physical statements (required if it exists) and must not be used for the value of the accountId
     *
     * @return accountNumber
     */
    @ApiModelProperty(value = "Masked identifier of the account as defined by the data holder. This must be the value presented on physical statements (required if it exists) and must not be used for the value of the accountId")
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public TelcoAccountResponseData displayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    /**
     * An optional display name for the account if one exists or can be derived. The content of this field is at the discretion of the data holder
     *
     * @return displayName
     */
    @ApiModelProperty(value = "An optional display name for the account if one exists or can be derived. The content of this field is at the discretion of the data holder")
    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public TelcoAccountResponseData creationDate(String creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    /**
     * The date that the account was created or opened. Mandatory if openStatus is OPEN
     *
     * @return creationDate
     */
    @ApiModelProperty(value = "The date that the account was created or opened. Mandatory if openStatus is OPEN")
    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public TelcoAccountResponseData lastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
        return this;
    }

    /**
     * The date and time which the account was last updated
     *
     * @return lastUpdated
     */
    @ApiModelProperty(value = "The date and time which the account was last updated")
    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public TelcoAccountResponseData brand(String brand) {
        this.brand = brand;
        return this;
    }

    /**
     * The retail name of the brand
     *
     * @return brand
     */
    @ApiModelProperty(value = "The retail name of the brand")
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public TelcoAccountResponseData openStatus(OpenStatusEnum openStatus) {
        this.openStatus = openStatus;
        return this;
    }

    /**
     * Open or closed status for the account. If not present then OPEN is assumed
     *
     * @return openStatus
     */
    @ApiModelProperty(value = "Open or closed status for the account. If not present then OPEN is assumed")
    public OpenStatusEnum getOpenStatus() {
        return openStatus;
    }

    public void setOpenStatus(OpenStatusEnum openStatus) {
        this.openStatus = openStatus;
    }

    public TelcoAccountResponseData plans(List<TelcoAccountPlan> plans) {
        this.plans = plans;
        return this;
    }

    public TelcoAccountResponseData addPlansItem(TelcoAccountPlan plansItem) {
        this.plans.add(plansItem);
        return this;
    }

    /**
     * The array of plans containing service and associated plan details
     *
     * @return plans
     */
    @ApiModelProperty(required = true, value = "The array of plans containing service and associated plan details")
    @NotNull
    @Valid
    public List<TelcoAccountPlan> getPlans() {
        return plans;
    }

    public void setPlans(List<TelcoAccountPlan> plans) {
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
        TelcoAccountResponseData telcoAccountResponseData = (TelcoAccountResponseData) o;
        return Objects.equals(this.accountId, telcoAccountResponseData.accountId) &&
                Objects.equals(this.accountNumber, telcoAccountResponseData.accountNumber) &&
                Objects.equals(this.displayName, telcoAccountResponseData.displayName) &&
                Objects.equals(this.creationDate, telcoAccountResponseData.creationDate) &&
                Objects.equals(this.lastUpdated, telcoAccountResponseData.lastUpdated) &&
                Objects.equals(this.brand, telcoAccountResponseData.brand) &&
                Objects.equals(this.openStatus, telcoAccountResponseData.openStatus) &&
                Objects.equals(this.plans, telcoAccountResponseData.plans);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, accountNumber, displayName, creationDate, lastUpdated, brand, openStatus, plans);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TelcoAccountResponseData {\n");
        sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
        sb.append("    accountNumber: ").append(toIndentedString(accountNumber)).append("\n");
        sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
        sb.append("    creationDate: ").append(toIndentedString(creationDate)).append("\n");
        sb.append("    lastUpdated: ").append(toIndentedString(lastUpdated)).append("\n");
        sb.append("    brand: ").append(toIndentedString(brand)).append("\n");
        sb.append("    openStatus: ").append(toIndentedString(openStatus)).append("\n");
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
