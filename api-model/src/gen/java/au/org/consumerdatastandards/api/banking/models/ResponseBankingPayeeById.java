package au.org.consumerdatastandards.api.banking.models;

import au.org.consumerdatastandards.api.common.models.BaseResponse;
import au.org.consumerdatastandards.support.data.*;

@DataDefinition
public class ResponseBankingPayeeById extends BaseResponse {

    @Property(
        required = true
    )
    BankingPayeeDetail data;
}
