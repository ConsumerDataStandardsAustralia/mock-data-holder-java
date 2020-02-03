package au.org.consumerdatastandards.api.v1_1_1.banking.models;

import au.org.consumerdatastandards.support.data.*;

@DataDefinition(
    description = "Object containing details of the source of the payment. Currently only specifies an account ID but provided as an object to facilitate future extensibility and consistency with the to object"
)
public class BankingScheduledPaymentFrom {

    @Property(
        description = "ID of the account that is the source of funds for the payment",
        required = true
    )
    @CDSDataType(CustomDataType.ASCII)
    String accountId;
}
