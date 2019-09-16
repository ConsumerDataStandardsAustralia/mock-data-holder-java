package au.org.consumerdatastandards.api.banking.models;

import java.util.List;
import au.org.consumerdatastandards.support.data.*;

@DataDefinition
public class BankingLoanAccount {

    public enum RepaymentType {
        INTEREST_ONLY,
        PRINCIPAL_AND_INTEREST
    }

    @Property(
        description = "Optional original start date for the loan"
    )
    @CDSDataType(CustomDataType.Date)
    String originalStartDate;

    @Property(
        description = "Optional original loan value"
    )
    @CDSDataType(CustomDataType.Amount)
    String originalLoanAmount;

    @Property(
        description = "If absent assumes AUD"
    )
    @CDSDataType(CustomDataType.Currency)
    String originalLoanCurrency;

    @Property(
        description = "Date that the loan is due to be repaid in full",
        required = true
    )
    @CDSDataType(CustomDataType.Date)
    String loanEndDate;

    @Property(
        description = "Next date that an instalment is required",
        required = true
    )
    @CDSDataType(CustomDataType.Date)
    String nextInstalmentDate;

    @Property(
        description = "Minimum amount of next instalment"
    )
    @CDSDataType(CustomDataType.Amount)
    String minInstalmentAmount;

    @Property(
        description = "If absent assumes AUD"
    )
    @CDSDataType(CustomDataType.Currency)
    String minInstalmentCurrency;

    @Property(
        description = "Maximum amount of funds that can be redrawn. If not present redraw is not available even if the feature exists for the account"
    )
    @CDSDataType(CustomDataType.Amount)
    String maxRedraw;

    @Property(
        description = "If absent assumes AUD"
    )
    @CDSDataType(CustomDataType.Currency)
    String maxRedrawCurrency;

    @Property(
        description = "Minimum redraw amount"
    )
    @CDSDataType(CustomDataType.Amount)
    String minRedraw;

    @Property(
        description = "If absent assumes AUD"
    )
    @CDSDataType(CustomDataType.Currency)
    String minRedrawCurrency;

    @Property(
        description = "Set to true if one or more offset accounts are configured for this loan account"
    )
    @CDSDataType(CustomDataType.Boolean)
    Boolean offsetAccountEnabled;

    @Property(
        description = "The accountIDs of the configured offset accounts attached to this loan. Only offset accounts that can be accessed under the current authorisation should be included. It is expected behaviour that offsetAccountEnabled is set to true but the offsetAccountIds field is absent or empty. This represents a situation where an offset account exists but details can not be accessed under the current authorisation"
    )
    List<String> offsetAccountIds;

    @Property(
        description = "Options in place for repayments. If absent defaults to PRINCIPAL_AND_INTEREST"
    )
    RepaymentType repaymentType = RepaymentType.PRINCIPAL_AND_INTEREST;

    @Property(
        description = "The expected or required repayment frequency. Formatted according to [ISO 8601 Durations](https://en.wikipedia.org/wiki/ISO_8601#Durations)",
        required = true
    )
    @CDSDataType(CustomDataType.ExternalRef)
    String repaymentFrequency;
}
