package au.org.consumerdatastandards.api.v1_0_0.banking.models;

import au.org.consumerdatastandards.support.data.*;

@DataDefinition
public class BankingBalancePurse {

    @Property(
        description = "The balance available for this additional currency purse",
        required = true
    )
    @CDSDataType(CustomDataType.Amount)
    String amount;

    @Property(
        description = "The currency for the purse"
    )
    @CDSDataType(CustomDataType.Currency)
    String currency;
}
