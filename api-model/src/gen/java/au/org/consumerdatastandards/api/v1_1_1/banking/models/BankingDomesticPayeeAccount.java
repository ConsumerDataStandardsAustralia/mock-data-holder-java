package au.org.consumerdatastandards.api.v1_1_1.banking.models;

import au.org.consumerdatastandards.support.data.DataDefinition;
import au.org.consumerdatastandards.support.data.Property;

@DataDefinition
public class BankingDomesticPayeeAccount {

    @Property(
        description = "Name of the account to pay to"
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
