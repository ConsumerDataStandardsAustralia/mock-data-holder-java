package au.org.consumerdatastandards.api.common.models;

import au.org.consumerdatastandards.support.data.*;

@DataDefinition
public class CommonCurrencyAmount  {

    @Property(
        description = "The current balance of the account at this time. Should align to the current balance available via other channels such as ATM balance enquiry or Internet Banking",
        required = true
    )
    @CDSDataType(CustomDataType.Amount)
    String amount;
    
    @Property(
        description = "If not present assumes AUD",
        required = false
    )
    @CDSDataType(CustomDataType.Currency)
    String currency;
}

