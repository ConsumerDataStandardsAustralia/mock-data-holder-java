package au.org.consumerdatastandards.api.v1_1_1.banking.models;

import au.org.consumerdatastandards.support.data.CDSDataType;
import au.org.consumerdatastandards.support.data.CustomDataType;
import au.org.consumerdatastandards.support.data.DataDefinition;
import au.org.consumerdatastandards.support.data.Property;

import java.time.OffsetDateTime;

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
    OffsetDateTime lastDebitDateTime;

    @Property(
        description = "The amount of the last debit executed under this authorisation"
    )
    @CDSDataType(CustomDataType.Amount)
    String lastDebitAmount;
}
