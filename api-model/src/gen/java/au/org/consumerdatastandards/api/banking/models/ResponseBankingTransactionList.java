package au.org.consumerdatastandards.api.banking.models;

import au.org.consumerdatastandards.api.common.models.PaginatedResponse;
import au.org.consumerdatastandards.support.data.*;

@DataDefinition
public class ResponseBankingTransactionList extends PaginatedResponse {

    @Property(
        required = true
    )
    ResponseBankingTransactionListData data;
}
