package au.org.consumerdatastandards.api.banking.models;

import java.util.List;
import au.org.consumerdatastandards.support.data.*;

@DataDefinition
public class BankingBalance {

    @Property(
        description = "A unique ID of the account adhering to the standards for ID permanence",
        required = true
    )
    @CDSDataType(CustomDataType.ASCII)
    String accountId;

    @Property(
        description = "The balance of the account at this time. Should align to the balance available via other channels such as Internet Banking. Assumed to be negative if the customer has money owing",
        required = true
    )
    @CDSDataType(CustomDataType.Amount)
    String currentBalance;

    @Property(
        description = "Balance representing the amount of funds available for transfer. Assumed to be zero or positive",
        required = true
    )
    @CDSDataType(CustomDataType.Amount)
    String availableBalance;

    @Property(
        description = "Object representing the maximum amount of credit that is available for this account. Assumed to be zero if absent"
    )
    @CDSDataType(CustomDataType.Amount)
    String creditLimit;

    @Property(
        description = "Object representing the available limit amortised according to payment schedule. Assumed to be zero if absent"
    )
    @CDSDataType(CustomDataType.Amount)
    String amortisedLimit;

    @Property(
        description = "The currency for the balance amounts. If absent assumed to be AUD"
    )
    @CDSDataType(CustomDataType.Currency)
    String currency;

    @Property(
        description = "Optional array of balances for the account in other currencies. Included to support accounts that support multi-currency purses such as Travel Cards"
    )
    List<BankingBalancePurse> purses;
}
