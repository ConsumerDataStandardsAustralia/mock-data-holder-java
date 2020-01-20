package au.org.consumerdatastandards.api.v1_0_0.banking.models;

import au.org.consumerdatastandards.support.data.*;

@DataDefinition(
    description = "Indicates that the schedule of payments is defined according to an external event that cannot be predetermined. Mandatory if recurrenceUType is set to eventBased"
)
public class BankingScheduledPaymentRecurrenceEventBased {

    @Property(
        description = "Description of the event and conditions that will result in the payment. Expected to be formatted for display to a customer",
        required = true
    )
    String description;
}
