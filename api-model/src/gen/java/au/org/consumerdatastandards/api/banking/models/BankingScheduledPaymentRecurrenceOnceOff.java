package au.org.consumerdatastandards.api.banking.models;

import au.org.consumerdatastandards.support.data.*;

@DataDefinition(
    description = "Indicates that the payment is a once off payment on a specific future date. Mandatory if recurrenceUType is set to onceOff"
)
public class BankingScheduledPaymentRecurrenceOnceOff {

    @Property(
        description = "The scheduled date for the once off payment",
        required = true
    )
    @CDSDataType(CustomDataType.Date)
    String paymentDate;
}
