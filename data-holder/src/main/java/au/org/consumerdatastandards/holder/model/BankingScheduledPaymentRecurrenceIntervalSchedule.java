package au.org.consumerdatastandards.holder.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Objects;
import java.time.LocalDate;
import java.util.List;

@ApiModel(description = "Indicates that the schedule of payments is defined by a series of intervals. Mandatory if recurrenceUType is set to intervalSchedule")
@Entity
public class BankingScheduledPaymentRecurrenceIntervalSchedule  {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @JsonIgnore
    private String id;

    /**
     * The limit date after which no more payments should be made using this schedule. If both finalPaymentDate and paymentsRemaining are present then payments will stop according to the most constraining value. If neither field is present the payments will continue indefinitely
     */
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDate finalPaymentDate;

    /**
     * An array of interval objects defining the payment schedule.  Each entry in the array is additive, in that it adds payments to the overall payment schedule.  If multiple intervals result in a payment on the same day then only one payment will be made. Must have at least one entry
     */
    @OneToMany
    @JoinTable(
        name = "banking_scheduled_payment_intervals",
        joinColumns = @JoinColumn(name = "interval_schedule_id"),
        inverseJoinColumns = @JoinColumn(name = "interval_id"))
    private List<BankingScheduledPaymentInterval> intervals;

    /**
     * Get nonBusinessDayTreatment
     */
    private NonBusinessDayTreatment nonBusinessDayTreatment;

    /**
     * Indicates the number of payments remaining in the schedule. If both finalPaymentDate and paymentsRemaining are present then payments will stop according to the most constraining value, If neither field is present the payments will continue indefinitely
     */
    private Integer paymentsRemaining;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BankingScheduledPaymentRecurrenceIntervalSchedule finalPaymentDate(LocalDate finalPaymentDate) {
        this.finalPaymentDate = finalPaymentDate;
        return this;
    }

    @ApiModelProperty(value = "The limit date after which no more payments should be made using this schedule. If both finalPaymentDate and paymentsRemaining are present then payments will stop according to the most constraining value. If neither field is present the payments will continue indefinitely")
    public LocalDate getFinalPaymentDate() {
        return finalPaymentDate;
    }

    public void setFinalPaymentDate(LocalDate finalPaymentDate) {
        this.finalPaymentDate = finalPaymentDate;
    }

    public BankingScheduledPaymentRecurrenceIntervalSchedule intervals(List<BankingScheduledPaymentInterval> intervals) {
        this.intervals = intervals;
        return this;
    }

    public BankingScheduledPaymentRecurrenceIntervalSchedule addItem(BankingScheduledPaymentInterval intervalsItem) {
        this.intervals.add(intervalsItem);
        return this;
    }

    @ApiModelProperty(required = true, value = "An array of interval objects defining the payment schedule.  Each entry in the array is additive, in that it adds payments to the overall payment schedule.  If multiple intervals result in a payment on the same day then only one payment will be made. Must have at least one entry")
    public List<BankingScheduledPaymentInterval> getIntervals() {
        return intervals;
    }

    public void setIntervals(List<BankingScheduledPaymentInterval> intervals) {
        this.intervals = intervals;
    }

    public BankingScheduledPaymentRecurrenceIntervalSchedule nonBusinessDayTreatment(NonBusinessDayTreatment nonBusinessDayTreatment) {
        this.nonBusinessDayTreatment = nonBusinessDayTreatment;
        return this;
    }

    @ApiModelProperty
    public NonBusinessDayTreatment getNonBusinessDayTreatment() {
        return nonBusinessDayTreatment;
    }

    public void setNonBusinessDayTreatment(NonBusinessDayTreatment nonBusinessDayTreatment) {
        this.nonBusinessDayTreatment = nonBusinessDayTreatment;
    }

    public BankingScheduledPaymentRecurrenceIntervalSchedule paymentsRemaining(Integer paymentsRemaining) {
        this.paymentsRemaining = paymentsRemaining;
        return this;
    }

    @ApiModelProperty(value = "Indicates the number of payments remaining in the schedule. If both finalPaymentDate and paymentsRemaining are present then payments will stop according to the most constraining value, If neither field is present the payments will continue indefinitely")
    public Integer getPaymentsRemaining() {
        return paymentsRemaining;
    }

    public void setPaymentsRemaining(Integer paymentsRemaining) {
        this.paymentsRemaining = paymentsRemaining;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BankingScheduledPaymentRecurrenceIntervalSchedule bankingScheduledPaymentRecurrenceIntervalSchedule = (BankingScheduledPaymentRecurrenceIntervalSchedule) o;
        return Objects.equals(this.id, bankingScheduledPaymentRecurrenceIntervalSchedule.id) &&
            Objects.equals(this.finalPaymentDate, bankingScheduledPaymentRecurrenceIntervalSchedule.finalPaymentDate) &&
            Objects.equals(this.intervals, bankingScheduledPaymentRecurrenceIntervalSchedule.intervals) &&
            Objects.equals(this.nonBusinessDayTreatment, bankingScheduledPaymentRecurrenceIntervalSchedule.nonBusinessDayTreatment) &&
            Objects.equals(this.paymentsRemaining, bankingScheduledPaymentRecurrenceIntervalSchedule.paymentsRemaining);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            id,
            finalPaymentDate,
            intervals,
            nonBusinessDayTreatment,
            paymentsRemaining);
    }

    @Override
    public String toString() {
        return "class BankingScheduledPaymentRecurrenceIntervalSchedule {\n" +
            "   id: " + toIndentedString(id) + "\n" +
            "   finalPaymentDate: " + toIndentedString(finalPaymentDate) + "\n" +
            "   intervals: " + toIndentedString(intervals) + "\n" +
            "   nonBusinessDayTreatment: " + toIndentedString(nonBusinessDayTreatment) + "\n" + 
            "   paymentsRemaining: " + toIndentedString(paymentsRemaining) + "\n" + 
            "}";
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

    public enum NonBusinessDayTreatment {
        AFTER,
        BEFORE,
        ON,
        ONLY
    }
}

