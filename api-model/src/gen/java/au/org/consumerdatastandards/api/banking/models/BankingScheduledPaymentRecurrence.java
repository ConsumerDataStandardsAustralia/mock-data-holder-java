package au.org.consumerdatastandards.api.banking.models;

import au.org.consumerdatastandards.support.data.*;

@DataDefinition(
    description = "Object containing the detail of the schedule for the payment"
)
@CustomAttributes({
    @CustomAttribute(name = "x-conditional", value = "onceOff", multiple = true),
    @CustomAttribute(name = "x-conditional", value = "intervalSchedule", multiple = true),
    @CustomAttribute(name = "x-conditional", value = "lastWeekDay", multiple = true),
    @CustomAttribute(name = "x-conditional", value = "eventBased", multiple = true)
})
public class BankingScheduledPaymentRecurrence {

    public enum RecurrenceUType {
        onceOff,
        intervalSchedule,
        lastWeekDay,
        eventBased
    }

    @Property(
        description = "The date of the next payment under the recurrence schedule"
    )
    @CDSDataType(CustomDataType.Date)
    String nextPaymentDate;

    @Property(
        description = "The type of recurrence used to define the schedule",
        required = true
    )
    RecurrenceUType recurrenceUType;

    @Property(
        requiredIf = { @Condition(propertyName = "recurrenceUType", values = {"onceOff"}) },
        nullIf = { @Condition(propertyName = "recurrenceUType", values = {"intervalSchedule", "lastWeekDay", "eventBased"}) }
    )
    BankingScheduledPaymentRecurrenceOnceOff onceOff;

    @Property(
        requiredIf = { @Condition(propertyName = "recurrenceUType", values = {"intervalSchedule"}) },
        nullIf = { @Condition(propertyName = "recurrenceUType", values = {"onceOff", "lastWeekDay", "eventBased"}) }
    )
    BankingScheduledPaymentRecurrenceIntervalSchedule intervalSchedule;

    @Property(
        requiredIf = { @Condition(propertyName = "recurrenceUType", values = {"lastWeekDay"}) },
        nullIf = { @Condition(propertyName = "recurrenceUType", values = {"intervalSchedule", "intervalSchedule", "eventBased"}) }
    )
    BankingScheduledPaymentRecurrenceLastWeekday lastWeekDay;

    @Property(
        requiredIf = { @Condition(propertyName = "recurrenceUType", values = {"eventBased"}) },
        nullIf = { @Condition(propertyName = "recurrenceUType", values = {"onceOff", "intervalSchedule", "lastWeekDay"}) }
    )
    BankingScheduledPaymentRecurrenceEventBased eventBased;
}
