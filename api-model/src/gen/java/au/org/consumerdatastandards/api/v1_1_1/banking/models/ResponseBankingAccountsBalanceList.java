package au.org.consumerdatastandards.api.v1_1_1.banking.models;

import au.org.consumerdatastandards.api.v1_1_1.common.models.PaginatedResponse;
import au.org.consumerdatastandards.support.data.*;

@DataDefinition
public class ResponseBankingAccountsBalanceList extends PaginatedResponse {

    @Property(
        required = true
    )
    ResponseBankingAccountsBalanceListData data;
}
