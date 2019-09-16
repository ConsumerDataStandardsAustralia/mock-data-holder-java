package au.org.consumerdatastandards.api.banking.models;

import au.org.consumerdatastandards.support.data.*;

@DataDefinition(
    description = "Indicates that the schedule of payments is defined according to the last occurrence of a specific weekday in an interval. Mandatory if recurrenceUType is set to lastWeekDay"
)
public class BankingScheduledPaymentRecurrenceLastWeekday {

    @Property(
        description = "The limit date after which no more payments should be made using this schedule. If both finalPaymentDate and paymentsRemaining are present then payments will stop according to the most constraining value. If neither field is present the payments will continue indefinitely"
    )
    @CDSDataType(CustomDataType.Date)
    String finalPaymentDate;

    @Property(
        description = "Indicates the number of payments remaining in the schedule. If both finalPaymentDate and paymentsRemaining are present then payments will stop according to the most constraining value. If neither field is present the payments will continue indefinitely"
    )
    @CDSDataType(CustomDataType.PositiveInteger)
    Integer paymentsRemaining;

    @Property(
        description = "The interval for the payment. Formatted according to [ISO 8601 Durations](https://en.wikipedia.org/wiki/ISO_8601#Durations) with components less than a day in length ignored. This duration defines the period between payments starting with nextPaymentDate",
        required = true
    )
    @CDSDataType(CustomDataType.ExternalRef)
    String interval;

    @Property(
        description = "The weekDay specified. The payment will occur on the last occurrence of this weekday in the interval. Value is constrained to 1 to 7 with 1 indicating Monday.",
        required = true
    )
    @CDSDataType(CustomDataType.PositiveInteger)
    Integer lastWeekDay;
}
