package au.org.consumerdatastandards.api.v1_0_0.banking.models;

import java.util.List;
import au.org.consumerdatastandards.support.data.*;

@DataDefinition(
    referenced = false
)
public class ResponseBankingProductListData {

    @Property(
        description = "The list of products returned.  If the filter results in an empty set then this array may have no records",
        required = true
    )
    List<BankingProduct> products;
}
