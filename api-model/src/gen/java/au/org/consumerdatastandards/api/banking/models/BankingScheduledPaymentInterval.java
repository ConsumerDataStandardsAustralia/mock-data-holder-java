package au.org.consumerdatastandards.api.banking.models;

import au.org.consumerdatastandards.support.data.*;

@DataDefinition
public class BankingScheduledPaymentInterval {

    @Property(
        description = "An interval for the payment. Formatted according to [ISO 8601 Durations](https://en.wikipedia.org/wiki/ISO_8601#Durations) with components less than a day in length ignored. This duration defines the period between payments starting with nextPaymentDate",
        required = true
    )
    @CDSDataType(CustomDataType.ExternalRef)
    String interval;

    @Property(
        description = "Uses an interval to define the ordinal day within the interval defined by the interval field on which the payment occurs. If the resulting duration is 0 days in length or larger than the number of days in the interval then the payment will occur on the last day of the interval. A duration of 1 day indicates the first day of the interval. If absent the assumed value is P1D. Formatted according to [ISO 8601 Durations](https://en.wikipedia.org/wiki/ISO_8601#Durations) with components less than a day in length ignored. The first day of a week is considered to be Monday."
    )
    @CDSDataType(CustomDataType.ExternalRef)
    String dayInInterval;
}
