package au.org.consumerdatastandards.api.banking.models;

import au.org.consumerdatastandards.support.data.*;

@DataDefinition(
    allOf = { BankingTransaction.class }
)
public class BankingTransactionDetail {

    @Property(
        required = true
    )
    BankingTransactionDetailExtendedData extendedData;
}
