package au.org.consumerdatastandards.api.banking.models;

import au.org.consumerdatastandards.api.common.models.PaginatedResponse;
import au.org.consumerdatastandards.support.data.*;

@DataDefinition
public class ResponseBankingAccountsBalanceList extends PaginatedResponse {

    @Property(
        required = true
    )
    ResponseBankingAccountsBalanceListData data;
}
