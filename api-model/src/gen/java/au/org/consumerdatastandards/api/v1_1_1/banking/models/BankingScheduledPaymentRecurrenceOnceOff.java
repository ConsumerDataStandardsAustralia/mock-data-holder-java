package au.org.consumerdatastandards.api.v1_1_1.banking.models;

import au.org.consumerdatastandards.support.data.CDSDataType;
import au.org.consumerdatastandards.support.data.CustomDataType;
import au.org.consumerdatastandards.support.data.DataDefinition;
import au.org.consumerdatastandards.support.data.Property;

import java.time.LocalDate;

@DataDefinition(
    description = "Indicates that the payment is a once off payment on a specific future date. Mandatory if recurrenceUType is set to onceOff"
)
public class BankingScheduledPaymentRecurrenceOnceOff {

    @Property(
        description = "The scheduled date for the once off payment",
        required = true
    )
    @CDSDataType(CustomDataType.Date)
    LocalDate paymentDate;
}
