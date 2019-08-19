package au.org.consumerdatastandards.api.banking.models;

import java.util.List;
import au.org.consumerdatastandards.support.data.*;

@DataDefinition(
    referenced = false
)
public class ResponseBankingPayeeListData {

    @Property(
        description = "The list of payees returned",
        required = true
    )
    List<BankingPayee> payees;
}
