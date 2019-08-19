package au.org.consumerdatastandards.api.banking.models;

import java.util.List;
import au.org.consumerdatastandards.support.data.*;

@DataDefinition(
    referenced = false
)
public class ResponseBankingTransactionListData {

    @Property(
        required = true
    )
    List<BankingTransaction> transactions;
}
