package au.org.consumerdatastandards.holder.model.energy;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * EnergyAccountDetailV1
 */
@Entity
@Table(name = "e_account")
public class EnergyAccountDetailV1 implements EnergyAccountDetail {

    @Id
    private String accountId;
    private String accountNumber;
    private String displayName;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDate creationDate;

    @Valid
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "e_account_plans",
            joinColumns = @JoinColumn(name = "account_id"),
            inverseJoinColumns = @JoinColumn(name = "plan_id"))
    private List<EnergyAccountDetailPlans> plans = new ArrayList<>();

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "e_account_concessions",
            joinColumns = @JoinColumn(name = "account_id"),
            inverseJoinColumns = @JoinColumn(name = "concession_id"))
    private List<EnergyConcession> concessions;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "e_account_payment_schedules",
            joinColumns = @JoinColumn(name = "account_id"),
            inverseJoinColumns = @JoinColumn(name = "schedule_id"))
    private List<EnergyPaymentSchedule> paymentSchedules;

    public EnergyAccountDetailV1 accountId(String accountId) {
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
    @Override
    public String getAccountId() {
        return accountId;
    }

    @Override
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public EnergyAccountDetailV1 accountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
        return this;
    }

    /**
     * Optional identifier of the account as defined by the data holder.  This must be the value presented on physical statements (if it exists) and must not be used for the value of accountId
     *
     * @return accountNumber
     */
    @ApiModelProperty(value = "Optional identifier of the account as defined by the data holder.  This must be the value presented on physical statements (if it exists) and must not be used for the value of accountId")
    @Override
    public String getAccountNumber() {
        return accountNumber;
    }

    @Override
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public EnergyAccountDetailV1 displayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    /**
     * An optional display name for the account if one exists or can be derived.  The content of this field is at the discretion of the data holder
     *
     * @return displayName
     */
    @ApiModelProperty(value = "An optional display name for the account if one exists or can be derived.  The content of this field is at the discretion of the data holder")
    @Override
    public String getDisplayName() {
        return displayName;
    }

    @Override
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public EnergyAccountDetailV1 creationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    /**
     * The date that the account was created or opened
     *
     * @return creationDate
     */
    @ApiModelProperty(required = true, value = "The date that the account was created or opened")
    @Override
    public LocalDate getCreationDate() {
        return creationDate;
    }

    @Override
    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public EnergyAccountDetailV1 plans(List<EnergyAccountDetailPlans> plans) {
        this.plans = plans;
        return this;
    }

    public EnergyAccountDetailV1 addPlansItem(EnergyAccountDetailPlans plansItem) {
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
    public List<EnergyAccountDetailPlans> getPlans() {
        return plans;
    }

    public void setPlans(List<EnergyAccountDetailPlans> plans) {
        this.plans = plans;
    }

    public List<EnergyConcession> getConcessions() {
        return concessions;
    }

    public void setConcessions(List<EnergyConcession> concessions) {
        this.concessions = concessions;
    }

    public List<EnergyPaymentSchedule> getPaymentSchedules() {
        return paymentSchedules;
    }

    public void setPaymentSchedules(List<EnergyPaymentSchedule> paymentSchedules) {
        this.paymentSchedules = paymentSchedules;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EnergyAccountDetailV1 energyAccountDetail = (EnergyAccountDetailV1) o;
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
        sb.append("class EnergyAccountDetailV1 {\n");
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
