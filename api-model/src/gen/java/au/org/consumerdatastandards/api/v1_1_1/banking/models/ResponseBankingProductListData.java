package au.org.consumerdatastandards.api.v1_1_1.banking.models;

import au.org.consumerdatastandards.support.data.DataDefinition;
import au.org.consumerdatastandards.support.data.Property;

import java.util.List;

@DataDefinition(
    referenced = false
)
public class ResponseBankingProductListData {

    @Property(
        description = "The list of products returned.  If the filter results in an empty set then this array may have no records",
        required = true
    )
    List<BankingProductV2> products;
}
