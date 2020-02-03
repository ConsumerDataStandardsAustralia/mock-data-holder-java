package au.org.consumerdatastandards.api.v1_1_1.banking.models;

import au.org.consumerdatastandards.support.data.CDSDataType;
import au.org.consumerdatastandards.support.data.CustomDataType;
import au.org.consumerdatastandards.support.data.DataDefinition;
import au.org.consumerdatastandards.support.data.Property;

import java.time.LocalDate;

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
    LocalDate lodgementDate;

    @Property(
        description = "Maturity date for the term deposit",
        required = true
    )
    @CDSDataType(CustomDataType.Date)
    LocalDate maturityDate;

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
