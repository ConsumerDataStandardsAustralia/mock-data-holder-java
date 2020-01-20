package au.org.consumerdatastandards.api.v1_0_0.banking.models;

import au.org.consumerdatastandards.api.v1_0_0.common.models.BaseResponse;
import au.org.consumerdatastandards.support.data.*;

@DataDefinition
public class ResponseBankingAccountById extends BaseResponse {

    @Property(
        required = true
    )
    BankingAccountDetail data;
}
