package au.org.consumerdatastandards.api.v1_0_0.banking.models;

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
