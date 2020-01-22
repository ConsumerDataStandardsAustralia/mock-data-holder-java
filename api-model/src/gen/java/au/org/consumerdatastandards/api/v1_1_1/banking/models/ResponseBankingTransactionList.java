package au.org.consumerdatastandards.api.v1_1_1.banking.models;

import au.org.consumerdatastandards.support.data.DataDefinition;
import au.org.consumerdatastandards.support.data.Property;

@DataDefinition
public class ResponseBankingTransactionList extends TxPaginatedResponse {

    @Property(
        required = true
    )
    ResponseBankingTransactionListData data;
}
