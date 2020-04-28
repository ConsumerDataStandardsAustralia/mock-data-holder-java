package au.org.consumerdatastandards.holder.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;
import java.time.LocalDate;

@ApiModel(description = "Indicates that the schedule of payments is defined according to the last occurrence of a specific weekday in an interval. Mandatory if recurrenceUType is set to lastWeekDay")
@Embeddable
public class BankingScheduledPaymentRecurrenceLastWeekday  {

    public enum LastWeekDay {
        MON,
        TUE,
        WED,
        THU,
        FRI,
        SAT,
        SUN
    }

    public enum NonBusinessDayTreatment {
        AFTER,
        BEFORE,
        ON,
        ONLY
    }

    /**
     * The limit date after which no more payments should be made using this schedule. If both finalPaymentDate and paymentsRemaining are present then payments will stop according to the most constraining value. If neither field is present the payments will continue indefinitely
     */
    private LocalDate finalPaymentDate;

    /**
     * The interval for the payment. Formatted according to [ISO 8601 Durations](https://en.wikipedia.org/wiki/ISO_8601#Durations) with components less than a day in length ignored. This duration defines the period between payments starting with nextPaymentDate
     */
    @Column(name = "interv")
    private String interval;

    /**
     * The weekDay specified. The payment will occur on the last occurrence of this weekday in the interval. Value is constrained to 1 to 7 with 1 indicating Monday.
     */
    private LastWeekDay lastWeekDay;

    /**
     * Indicates the number of payments remaining in the schedule. If both finalPaymentDate and paymentsRemaining are present then payments will stop according to the most constraining value. If neither field is present the payments will continue indefinitely
     */
    private Integer paymentsRemaining;

    /**
     * Enumerated field giving the treatment where a scheduled payment date is not a business day. If absent assumed to be ON.<br>**AFTER** - If a scheduled payment date is a non-business day the payment will be made on the first business day after the scheduled payment date.<br>**BEFORE** - If a scheduled payment date is a non-business day the payment will be made on the first business day before the scheduled payment date.<br>**ON** - If a scheduled payment date is a non-business day the payment will be made on that day regardless.<br>**ONLY** - Payments only occur on business days. If a scheduled payment date is a non-business day the payment will be ignored
     */
    private NonBusinessDayTreatment nonBusinessDayTreatment = NonBusinessDayTreatment.ON;

    public BankingScheduledPaymentRecurrenceLastWeekday finalPaymentDate(LocalDate finalPaymentDate) {
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
    public BankingScheduledPaymentRecurrenceLastWeekday interval(String interval) {
        this.interval = interval;
        return this;
    }

    @ApiModelProperty(required = true, value = "The interval for the payment. Formatted according to [ISO 8601 Durations](https://en.wikipedia.org/wiki/ISO_8601#Durations) with components less than a day in length ignored. This duration defines the period between payments starting with nextPaymentDate")
    public String getInterval() {
        return interval;
    }

    public void setInterval(String interval) {
        this.interval = interval;
    }

    public BankingScheduledPaymentRecurrenceLastWeekday lastWeekDay(LastWeekDay lastWeekDay) {
        this.lastWeekDay = lastWeekDay;
        return this;
    }

    @ApiModelProperty(required = true, value = "The weekDay specified. The payment will occur on the last occurrence of this weekday in the interval. Value is constrained to 1 to 7 with 1 indicating Monday.")
    public LastWeekDay getLastWeekDay() {
        return lastWeekDay;
    }

    public void setLastWeekDay(LastWeekDay lastWeekDay) {
        this.lastWeekDay = lastWeekDay;
    }

    public BankingScheduledPaymentRecurrenceLastWeekday paymentsRemaining(Integer paymentsRemaining) {
        this.paymentsRemaining = paymentsRemaining;
        return this;
    }

    @ApiModelProperty(value = "Indicates the number of payments remaining in the schedule. If both finalPaymentDate and paymentsRemaining are present then payments will stop according to the most constraining value. If neither field is present the payments will continue indefinitely")
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
        BankingScheduledPaymentRecurrenceLastWeekday bankingScheduledPaymentRecurrenceLastWeekday = (BankingScheduledPaymentRecurrenceLastWeekday) o;
        return Objects.equals(this.finalPaymentDate, bankingScheduledPaymentRecurrenceLastWeekday.finalPaymentDate) &&
            Objects.equals(this.interval, bankingScheduledPaymentRecurrenceLastWeekday.interval) &&
            Objects.equals(this.lastWeekDay, bankingScheduledPaymentRecurrenceLastWeekday.lastWeekDay) &&
            Objects.equals(this.paymentsRemaining, bankingScheduledPaymentRecurrenceLastWeekday.paymentsRemaining);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            finalPaymentDate,
            interval,
            lastWeekDay,
            paymentsRemaining);
    }

    @Override
    public String toString() {
        return "class BankingScheduledPaymentRecurrenceLastWeekday {\n" +
            "   finalPaymentDate: " + toIndentedString(finalPaymentDate) + "\n" +
            "   interval: " + toIndentedString(interval) + "\n" +
            "   lastWeekDay: " + toIndentedString(lastWeekDay) + "\n" +
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
}

