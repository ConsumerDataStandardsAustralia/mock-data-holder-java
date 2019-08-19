package au.org.consumerdatastandards.api.banking.models;

import au.org.consumerdatastandards.api.common.models.BaseResponse;
import au.org.consumerdatastandards.support.data.*;

@DataDefinition
public class ResponseBankingProductById extends BaseResponse {

    @Property(
        required = true
    )
    BankingProductDetail data;
}
