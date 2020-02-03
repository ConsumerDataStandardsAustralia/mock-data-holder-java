package au.org.consumerdatastandards.api.v1_1_1.banking.models;

import au.org.consumerdatastandards.support.data.CDSDataType;
import au.org.consumerdatastandards.support.data.CustomDataType;
import au.org.consumerdatastandards.support.data.DataDefinition;
import au.org.consumerdatastandards.support.data.Property;

import java.time.LocalDate;

@DataDefinition(
    description = "Indicates that the schedule of payments is defined according to the last occurrence of a specific weekday in an interval. Mandatory if recurrenceUType is set to lastWeekDay"
)
public class BankingScheduledPaymentRecurrenceLastWeekday {

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

    @Property(
        description = "The limit date after which no more payments should be made using this schedule. If both finalPaymentDate and paymentsRemaining are present then payments will stop according to the most constraining value. If neither field is present the payments will continue indefinitely"
    )
    @CDSDataType(CustomDataType.Date)
    LocalDate finalPaymentDate;

    @Property(
        description = "Indicates the number of payments remaining in the schedule. If both finalPaymentDate and paymentsRemaining are present then payments will stop according to the most constraining value. If neither field is present the payments will continue indefinitely"
    )
    @CDSDataType(CustomDataType.PositiveInteger)
    Integer paymentsRemaining;

    @Property(
        description = "The interval for the payment. Formatted according to [ISO 8601 Durations](https://en.wikipedia.org/wiki/ISO_8601#Durations) (excludes recurrence syntax) with components less than a day in length ignored. This duration defines the period between payments starting with nextPaymentDate",
        required = true
    )
    @CDSDataType(CustomDataType.ExternalRef)
    String interval;

    @Property(
        description = "The weekDay specified. The payment will occur on the last occurrence of this weekday in the interval.",
        required = true
    )
    LastWeekDay lastWeekDay;

    @Property(
        description = "Enumerated field giving the treatment where a scheduled payment date is not a business day. If absent assumed to be ON.<br/>**AFTER** - If a scheduled payment date is a non-business day the payment will be made on the first business day after the scheduled payment date.<br/>**BEFORE** - If a scheduled payment date is a non-business day the payment will be made on the first business day before the scheduled payment date.<br/>**ON** - If a scheduled payment date is a non-business day the payment will be made on that day regardless.<br/>**ONLY** - Payments only occur on business days. If a scheduled payment date is a non-business day the payment will be ignored"
    )
    NonBusinessDayTreatment nonBusinessDayTreatment = NonBusinessDayTreatment.ON;
}
