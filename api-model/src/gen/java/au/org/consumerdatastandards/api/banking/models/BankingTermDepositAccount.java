package au.org.consumerdatastandards.api.banking.models;

import au.org.consumerdatastandards.support.data.*;

@DataDefinition
public class BankingTermDepositAccount {

    public enum MaturityInstructions {
        ROLLED_OVER,
        PAID_OUT_AT_MATURITY
    }

    @Property(
        description = "The lodgement date of the original deposit",
        required = true
    )
    @CDSDataType(CustomDataType.Date)
    String lodgementDate;

    @Property(
        description = "Maturity date for the term deposit",
        required = true
    )
    @CDSDataType(CustomDataType.Date)
    String maturityDate;

    @Property(
        description = "Amount to be paid upon maturity. If absent it implies the amount to paid is variable and cannot currently be calculated"
    )
    @CDSDataType(CustomDataType.Amount)
    String maturityAmount;

    @Property(
        description = "If absent assumes AUD"
    )
    @CDSDataType(CustomDataType.Currency)
    String maturityCurrency;

    @Property(
        description = "Current instructions on action to be taken at maturity",
        required = true
    )
    MaturityInstructions maturityInstructions;
}
