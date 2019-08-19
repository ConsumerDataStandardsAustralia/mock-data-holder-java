package au.org.consumerdatastandards.api.banking.models;

import au.org.consumerdatastandards.support.data.*;

@DataDefinition
public class BankingInternationalPayee {

    @Property(
        required = true
    )
    BankingInternationalPayeeBeneficiaryDetails beneficiaryDetails;

    @Property(
        required = true
    )
    BankingInternationalPayeeBankDetails bankDetails;
}
