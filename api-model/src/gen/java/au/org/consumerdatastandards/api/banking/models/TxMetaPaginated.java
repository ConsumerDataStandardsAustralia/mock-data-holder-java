package au.org.consumerdatastandards.api.banking.models;

import au.org.consumerdatastandards.api.common.models.MetaPaginated;
import au.org.consumerdatastandards.support.data.DataDefinition;
import au.org.consumerdatastandards.support.data.Property;

public class TxMetaPaginated extends MetaPaginated {

    @Property(
        description = "whether the text parameter is supplied or not in getTransactions operation"
    )
    Boolean isQueryParamUnsupported;
}
