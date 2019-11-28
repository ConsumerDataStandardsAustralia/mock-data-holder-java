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

@ApiModel(description = "Object containing the detail of the schedule for the payment")
@Entity
public class BankingScheduledPaymentRecurrence  {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @JsonIgnore
    private String id;

    @Embedded
    private BankingScheduledPaymentRecurrenceEventBased eventBased;

    @ManyToOne
    private BankingScheduledPaymentRecurrenceIntervalSchedule intervalSchedule;

    @Embedded
    private BankingScheduledPaymentRecurrenceLastWeekday lastWeekDay;

    /**
     * The date of the next payment under the recurrence schedule
     */
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDate nextPaymentDate;

    @Embedded
    private BankingScheduledPaymentRecurrenceOnceOff onceOff;

    private RecurrenceUType recurrenceUType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BankingScheduledPaymentRecurrence eventBased(BankingScheduledPaymentRecurrenceEventBased eventBased) {
        this.eventBased = eventBased;
        return this;
    }

    @ApiModelProperty
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

    @ApiModelProperty
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

    @ApiModelProperty
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

    @ApiModelProperty
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

    @ApiModelProperty(required = true)
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
        return Objects.equals(this.id, bankingScheduledPaymentRecurrence.id) &&
            Objects.equals(this.eventBased, bankingScheduledPaymentRecurrence.eventBased) &&
            Objects.equals(this.intervalSchedule, bankingScheduledPaymentRecurrence.intervalSchedule) &&
            Objects.equals(this.lastWeekDay, bankingScheduledPaymentRecurrence.lastWeekDay) &&
            Objects.equals(this.nextPaymentDate, bankingScheduledPaymentRecurrence.nextPaymentDate) &&
            Objects.equals(this.onceOff, bankingScheduledPaymentRecurrence.onceOff) &&
            Objects.equals(this.recurrenceUType, bankingScheduledPaymentRecurrence.recurrenceUType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            id,
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
            "   id: " + toIndentedString(id) + "\n" +
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

    public enum RecurrenceUType {
        eventBased,
        intervalSchedule,
        lastWeekDay,
        onceOff
    }
}

