package au.org.consumerdatastandards.holder.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;
import java.time.LocalDate;

@ApiModel(description = "Object containing the detail of the schedule for the payment")
public class BankingScheduledPaymentRecurrence  {

    /**
     * Get eventBased
     */
    private BankingScheduledPaymentRecurrenceEventBased eventBased;

    /**
     * Get intervalSchedule
     */
    private BankingScheduledPaymentRecurrenceIntervalSchedule intervalSchedule;

    /**
     * Get lastWeekDay
     */
    private BankingScheduledPaymentRecurrenceLastWeekday lastWeekDay;

    /**
     * The date of the next payment under the recurrence schedule
     */
    private LocalDate nextPaymentDate;

    /**
     * Get onceOff
     */
    private BankingScheduledPaymentRecurrenceOnceOff onceOff;

    public enum RecurrenceUType {
        EVENTBASED,
        INTERVALSCHEDULE,
        LASTWEEKDAY,
        ONCEOFF
    }
    /**
     * Get recurrenceUType
     */
    private RecurrenceUType recurrenceUType;

    public BankingScheduledPaymentRecurrence eventBased(BankingScheduledPaymentRecurrenceEventBased eventBased) {
        this.eventBased = eventBased;
        return this;
    }

    @ApiModelProperty(value = "")
    public BankingScheduledPaymentRecurrenceEventBased getEventBased() {
        return eventBased;
    }

    public void setEventBased(BankingScheduledPaymentRecurrenceEventBased eventBased) {
        this.eventBased = eventBased;
    }
    public BankingScheduledPaymentRecurrence intervalSchedule(BankingScheduledPaymentRecurrenceIntervalSchedule intervalSchedule) {
        this.intervalSchedule = intervalSchedule;
        return this;
    }

    @ApiModelProperty(value = "")
    public BankingScheduledPaymentRecurrenceIntervalSchedule getIntervalSchedule() {
        return intervalSchedule;
    }

    public void setIntervalSchedule(BankingScheduledPaymentRecurrenceIntervalSchedule intervalSchedule) {
        this.intervalSchedule = intervalSchedule;
    }
    public BankingScheduledPaymentRecurrence lastWeekDay(BankingScheduledPaymentRecurrenceLastWeekday lastWeekDay) {
        this.lastWeekDay = lastWeekDay;
        return this;
    }

    @ApiModelProperty(value = "")
    public BankingScheduledPaymentRecurrenceLastWeekday getLastWeekDay() {
        return lastWeekDay;
    }

    public void setLastWeekDay(BankingScheduledPaymentRecurrenceLastWeekday lastWeekDay) {
        this.lastWeekDay = lastWeekDay;
    }
    public BankingScheduledPaymentRecurrence nextPaymentDate(LocalDate nextPaymentDate) {
        this.nextPaymentDate = nextPaymentDate;
        return this;
    }

    @ApiModelProperty(value = "The date of the next payment under the recurrence schedule")
    public LocalDate getNextPaymentDate() {
        return nextPaymentDate;
    }

    public void setNextPaymentDate(LocalDate nextPaymentDate) {
        this.nextPaymentDate = nextPaymentDate;
    }
    public BankingScheduledPaymentRecurrence onceOff(BankingScheduledPaymentRecurrenceOnceOff onceOff) {
        this.onceOff = onceOff;
        return this;
    }

    @ApiModelProperty(value = "")
    public BankingScheduledPaymentRecurrenceOnceOff getOnceOff() {
        return onceOff;
    }

    public void setOnceOff(BankingScheduledPaymentRecurrenceOnceOff onceOff) {
        this.onceOff = onceOff;
    }
    public BankingScheduledPaymentRecurrence recurrenceUType(RecurrenceUType recurrenceUType) {
        this.recurrenceUType = recurrenceUType;
        return this;
    }

    @ApiModelProperty(required = true, value = "")
    public RecurrenceUType getRecurrenceUType() {
        return recurrenceUType;
    }

    public void setRecurrenceUType(RecurrenceUType recurrenceUType) {
        this.recurrenceUType = recurrenceUType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BankingScheduledPaymentRecurrence bankingScheduledPaymentRecurrence = (BankingScheduledPaymentRecurrence) o;
        return Objects.equals(this.eventBased, bankingScheduledPaymentRecurrence.eventBased) &&
            Objects.equals(this.intervalSchedule, bankingScheduledPaymentRecurrence.intervalSchedule) &&
            Objects.equals(this.lastWeekDay, bankingScheduledPaymentRecurrence.lastWeekDay) &&
            Objects.equals(this.nextPaymentDate, bankingScheduledPaymentRecurrence.nextPaymentDate) &&
            Objects.equals(this.onceOff, bankingScheduledPaymentRecurrence.onceOff) &&
            Objects.equals(this.recurrenceUType, bankingScheduledPaymentRecurrence.recurrenceUType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            eventBased,
            intervalSchedule,
            lastWeekDay,
            nextPaymentDate,
            onceOff,
            recurrenceUType);
    }

    @Override
    public String toString() {
        return "class BankingScheduledPaymentRecurrence {\n" +
            "   eventBased: " + toIndentedString(eventBased) + "\n" + 
            "   intervalSchedule: " + toIndentedString(intervalSchedule) + "\n" + 
            "   lastWeekDay: " + toIndentedString(lastWeekDay) + "\n" + 
            "   nextPaymentDate: " + toIndentedString(nextPaymentDate) + "\n" + 
            "   onceOff: " + toIndentedString(onceOff) + "\n" + 
            "   recurrenceUType: " + toIndentedString(recurrenceUType) + "\n" + 
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

