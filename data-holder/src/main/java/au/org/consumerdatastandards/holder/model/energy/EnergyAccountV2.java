package au.org.consumerdatastandards.holder.model.energy;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * EnergyAccountV2
 */
@Entity
@Table(name = "EnergyAccount")
public class EnergyAccountV2 implements EnergyAccountBaseV2 {

    @Id
    private String accountId;
    private String accountNumber;
    private String displayName;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDate creationDate;

    @Valid
    @ManyToMany(cascade = CascadeType.ALL)
    private List<EnergyAccountPlans> plans = new ArrayList<>();

    private OpenStatus openStatus;

    public EnergyAccountV2 accountId(String accountId) {
        this.accountId = accountId;
        return this;
    }

    /**
     * The ID of the account.  To be created in accordance with CDR ID permanence requirements
     *
     * @return accountId
     */
    @Override
    @ApiModelProperty(required = true,
            value = "The ID of the account.  To be created in accordance with CDR ID permanence requirements")
    @NotNull
    public String getAccountId() {
        return accountId;
    }

    @Override
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public EnergyAccountV2 accountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
        return this;
    }

    /**
     * Optional identifier of the account as defined by the data holder.  This must be the value presented on physical statements (if it exists) and must not be used for the value of accountId
     *
     * @return accountNumber
     */
    @Override
    @ApiModelProperty(value = "Optional identifier of the account as defined by the data holder.  This must be the value presented on physical statements (if it exists) and must not be used for the value of accountId")
    public String getAccountNumber() {
        return accountNumber;
    }

    @Override
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public EnergyAccountV2 displayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    /**
     * An optional display name for the account if one exists or can be derived.  The content of this field is at the discretion of the data holder
     *
     * @return displayName
     */
    @Override
    @ApiModelProperty(value = "An optional display name for the account if one exists or can be derived.  The content of this field is at the discretion of the data holder")
    public String getDisplayName() {
        return displayName;
    }

    @Override
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public EnergyAccountV2 creationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    /**
     * The date that the account was created or opened
     *
     * @return creationDate
     */
    @Override
    @ApiModelProperty(required = true, value = "The date that the account was created or opened")
    @NotNull
    public LocalDate getCreationDate() {
        return creationDate;
    }

    @Override
    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public EnergyAccountV2 plans(List<EnergyAccountPlans> plans) {
        this.plans = plans;
        return this;
    }

    public EnergyAccountV2 addPlansItem(EnergyAccountPlans plansItem) {
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
    public List<EnergyAccountPlans> getPlans() {
        return plans;
    }

    public void setPlans(List<EnergyAccountPlans> plans) {
        this.plans = plans;
    }

    @ApiModelProperty
    public OpenStatus getOpenStatus() {
        return openStatus;
    }

    public void setOpenStatus(OpenStatus openStatus) {
        this.openStatus = openStatus;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        EnergyAccountV2 energyAccount = (EnergyAccountV2) o;

        return super.equals(o) &&
                Objects.equals(this.openStatus, energyAccount.openStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAccountId(), getAccountNumber(), getDisplayName(), getCreationDate(), getPlans(), openStatus);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyAccountV2 {\n");
        sb.append("    accountId: ").append(toIndentedString(getAccountId())).append("\n");
        sb.append("    accountNumber: ").append(toIndentedString(getAccountNumber())).append("\n");
        sb.append("    displayName: ").append(toIndentedString(getDisplayName())).append("\n");
        sb.append("    creationDate: ").append(toIndentedString(getCreationDate())).append("\n");
        sb.append("    plans: ").append(toIndentedString(getPlans())).append("\n");
        sb.append("    openStatus: ").append(toIndentedString(openStatus)).append("\n");
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
