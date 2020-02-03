package au.org.consumerdatastandards.api.v1_0_0.banking.models;

import au.org.consumerdatastandards.support.data.*;

@DataDefinition
public class BankingCreditCardAccount {

    @Property(
        description = "The minimum payment amount due for the next card payment",
        required = true
    )
    @CDSDataType(CustomDataType.Amount)
    String minPaymentAmount;

    @Property(
        description = "The amount due for the next card payment",
        required = true
    )
    @CDSDataType(CustomDataType.Amount)
    String paymentDueAmount;

    @Property(
        description = "If absent assumes AUD"
    )
    @CDSDataType(CustomDataType.Currency)
    String paymentCurrency;

    @Property(
        description = "Date that the next payment for the card is due",
        required = true
    )
    @CDSDataType(CustomDataType.Date)
    String paymentDueDate;
}
