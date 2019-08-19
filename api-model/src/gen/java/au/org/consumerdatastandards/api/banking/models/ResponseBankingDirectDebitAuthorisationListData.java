package au.org.consumerdatastandards.api.banking.models;

import java.util.List;
import au.org.consumerdatastandards.support.data.*;

@DataDefinition(
    referenced = false
)
public class ResponseBankingDirectDebitAuthorisationListData {

    @Property(
        description = "The list of authorisations returned",
        required = true
    )
    List<BankingDirectDebit> directDebitAuthorisations;
}
