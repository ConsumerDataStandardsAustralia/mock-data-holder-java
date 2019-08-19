package au.org.consumerdatastandards.api.banking.models;

import au.org.consumerdatastandards.support.data.*;

@DataDefinition(
    referenced = false
)
public class BankingInternationalPayeeBankDetailsBankAddress {

    @Property(
        description = "Name of the recipient Bank",
        required = true
    )
    String name;

    @Property(
        description = "Address of the recipient Bank",
        required = true
    )
    String address;
}
