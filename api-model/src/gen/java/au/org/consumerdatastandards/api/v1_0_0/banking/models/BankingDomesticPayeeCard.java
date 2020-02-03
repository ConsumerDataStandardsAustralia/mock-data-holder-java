package au.org.consumerdatastandards.api.v1_0_0.banking.models;

import au.org.consumerdatastandards.support.data.*;

@DataDefinition
public class BankingDomesticPayeeCard {

    @Property(
        description = "Name of the account to pay to",
        required = true
    )
    @CDSDataType(CustomDataType.MaskedPAN)
    String cardNumber;
}
