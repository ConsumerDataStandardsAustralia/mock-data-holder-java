package au.org.consumerdatastandards.api.banking.models;

import au.org.consumerdatastandards.support.data.*;

@DataDefinition
public class BankingAuthorisedEntity {

    @Property(
        description = "Description of the authorised entity derived from previously executed direct debits"
    )
    String description;

    @Property(
        description = "Name of the financial institution through which the direct debit will be executed. Is required unless the payment is made via a credit card scheme"
    )
    String financialInstitution;

    @Property(
        description = "Australian Business Number for the authorised entity"
    )
    String abn;

    @Property(
        description = "Australian Company Number for the authorised entity"
    )
    String acn;

    @Property(
        description = "Australian Registered Body Number for the authorised entity"
    )
    String arbn;
}
