package au.org.consumerdatastandards.api.v1_0_0.banking.models;

import au.org.consumerdatastandards.support.data.*;

@DataDefinition
public class BankingDomesticPayeeAccount {

    @Property(
        description = "Name of the account to pay to",
        required = true
    )
    String accountName;

    @Property(
        description = "BSB of the account to pay to",
        required = true
    )
    String bsb;

    @Property(
        description = "Number of the account to pay to",
        required = true
    )
    String accountNumber;
}
