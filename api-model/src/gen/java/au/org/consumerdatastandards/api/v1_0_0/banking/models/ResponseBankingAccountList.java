package au.org.consumerdatastandards.api.v1_0_0.banking.models;

import au.org.consumerdatastandards.api.v1_0_0.common.models.PaginatedResponse;
import au.org.consumerdatastandards.support.data.*;

@DataDefinition
public class ResponseBankingAccountList extends PaginatedResponse {

    @Property(
        required = true
    )
    ResponseBankingAccountListData data;
}
