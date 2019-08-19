package au.org.consumerdatastandards.api.banking.models;

import au.org.consumerdatastandards.api.common.models.BaseResponse;
import au.org.consumerdatastandards.support.data.*;

@DataDefinition
public class ResponseBankingTransactionById extends BaseResponse {

    @Property(
        required = true
    )
    BankingTransactionDetail data;
}
