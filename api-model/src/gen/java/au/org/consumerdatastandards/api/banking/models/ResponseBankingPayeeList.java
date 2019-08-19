package au.org.consumerdatastandards.api.banking.models;

import au.org.consumerdatastandards.api.common.models.PaginatedResponse;
import au.org.consumerdatastandards.support.data.*;

@DataDefinition
public class ResponseBankingPayeeList extends PaginatedResponse {

    @Property(
        required = true
    )
    ResponseBankingPayeeListData data;
}
