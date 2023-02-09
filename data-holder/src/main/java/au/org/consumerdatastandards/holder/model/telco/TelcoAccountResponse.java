package au.org.consumerdatastandards.holder.model.telco;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * TelcoAccountResponse
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen",
        date = "2022-12-23T11:32:06.900+11:00[Australia/Sydney]")
public class TelcoAccountResponse {
    @JsonProperty("accountId")
    private String accountId;

    @JsonProperty("accountNumber")
    private String accountNumber;

    @JsonProperty("displayName")
    private String displayName;

    @JsonProperty("creationDate")
    private String creationDate;

    @JsonProperty("lastUpdated")
    private String lastUpdated;

    @JsonProperty("brand")
    private String brand;

    /**
     * Open or closed status for the account. If not present then OPEN is assumed
     */
    public enum OpenStatusEnum {
        CLOSED("CLOSED"),

        OPEN("OPEN");

        private String value;

        OpenStatusEnum(String value) {
            this.value = value;
        }

        @JsonValue
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        @JsonCreator
        public static OpenStatusEnum fromValue(String value) {
            for (OpenStatusEnum b : OpenStatusEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    @JsonProperty("openStatus")
    private OpenStatusEnum openStatus = OpenStatusEnum.OPEN;

    @JsonProperty("plans")
    @Valid
    private List<TelcoAccountPlans> plans = new ArrayList<>();

    public TelcoAccountResponse accountId(String accountId) {
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

    public TelcoAccountResponse accountNumber(String accountNumber) {
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

    public TelcoAccountResponse displayName(String displayName) {
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

    public TelcoAccountResponse creationDate(String creationDate) {
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

    public TelcoAccountResponse lastUpdated(String lastUpdated) {
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

    public TelcoAccountResponse brand(String brand) {
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

    public TelcoAccountResponse openStatus(OpenStatusEnum openStatus) {
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

    public TelcoAccountResponse plans(List<TelcoAccountPlans> plans) {
        this.plans = plans;
        return this;
    }

    public TelcoAccountResponse addPlansItem(TelcoAccountPlans plansItem) {
        this.plans.add(plansItem);
        return this;
    }

    /**
     * The array of plans containing service and associated plan details
     *
     * @return plans
     */
    @ApiModelProperty(required = true,
            value = "The array of plans containing service and associated plan details")
    @NotNull

    @Valid

    public List<TelcoAccountPlans> getPlans() {
        return plans;
    }

    public void setPlans(List<TelcoAccountPlans> plans) {
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
        TelcoAccountResponse telcoAccountResponse = (TelcoAccountResponse) o;
        return Objects.equals(this.accountId, telcoAccountResponse.accountId) &&
                Objects.equals(this.accountNumber, telcoAccountResponse.accountNumber) &&
                Objects.equals(this.displayName, telcoAccountResponse.displayName) &&
                Objects.equals(this.creationDate, telcoAccountResponse.creationDate) &&
                Objects.equals(this.lastUpdated, telcoAccountResponse.lastUpdated) &&
                Objects.equals(this.brand, telcoAccountResponse.brand) &&
                Objects.equals(this.openStatus, telcoAccountResponse.openStatus) &&
                Objects.equals(this.plans, telcoAccountResponse.plans);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, accountNumber, displayName, creationDate, lastUpdated, brand, openStatus, plans);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TelcoAccountResponse {\n");

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

