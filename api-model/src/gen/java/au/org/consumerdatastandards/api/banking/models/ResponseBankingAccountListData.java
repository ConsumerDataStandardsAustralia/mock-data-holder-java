package au.org.consumerdatastandards.api.banking.models;

import java.util.List;
import au.org.consumerdatastandards.support.data.*;

@DataDefinition(
    referenced = false
)
public class ResponseBankingAccountListData {

    @Property(
        description = "The list of accounts returned. If the filter results in an empty set then this array may have no records",
        required = true
    )
    List<BankingAccount> accounts;
}
