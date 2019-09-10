package au.org.consumerdatastandards.api.banking.models;

import au.org.consumerdatastandards.support.data.*;

@DataDefinition
public class BankingDirectDebit {

    @Property(
        description = "A unique ID of the account adhering to the standards for ID permanence.",
        required = true
    )
    @CDSDataType(CustomDataType.ASCII)
    String accountId;

    @Property(
        required = true
    )
    BankingAuthorisedEntity authorisedEntity;

    @Property(
        description = "The date and time of the last debit executed under this authorisation"
    )
    @CDSDataType(CustomDataType.DateTime)
    String lastDebitDateTime;

    @Property(
        description = "The amount of the last debit executed under this authorisation"
    )
    @CDSDataType(CustomDataType.Amount)
    String lastDebitAmount;
}
