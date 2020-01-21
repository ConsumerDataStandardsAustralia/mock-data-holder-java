package au.org.consumerdatastandards.api.v1_1_1.banking.models;

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
