package au.org.consumerdatastandards.api.v1_1_1.banking.models;

import au.org.consumerdatastandards.api.v1_0_0.common.models.MetaPaginated;
import au.org.consumerdatastandards.support.data.Property;

public class TxMetaPaginated extends MetaPaginated {

    @Property(
        description = "whether the text parameter is supplied or not in getTransactions operation"
    )
    Boolean isQueryParamUnsupported;
}
