package au.org.consumerdatastandards.api.banking.models;

import au.org.consumerdatastandards.api.common.models.CommonPhysicalAddress;
import java.util.List;
import au.org.consumerdatastandards.support.data.*;

@DataDefinition(
    allOf = { BankingAccount.class }
)
@CustomAttributes({
    @CustomAttribute(name = "x-conditional", value = "termDeposit", multiple = true),
    @CustomAttribute(name = "x-conditional", value = "creditCard", multiple = true),
    @CustomAttribute(name = "x-conditional", value = "loan", multiple = true)
})
public class BankingAccountDetail {

    public enum SpecificAccountUType {
        termDeposit,
        creditCard,
        loan
    }

    @Property(
        description = "The unmasked BSB for the account. Is expected to be formatted as digits only with leading zeros included and no punctuation or spaces"
    )
    String bsb;

    @Property(
        description = "The unmasked account number for the account. Should not be supplied if the account number is a PAN requiring PCI compliance. Is expected to be formatted as digits only with leading zeros included and no punctuation or spaces"
    )
    String accountNumber;

    @Property(
        description = "Optional field to indicate if this account is part of a bundle that is providing additional benefit for to the customer"
    )
    String bundleName;

    @Property(
        description = "The type of structure to present account specific fields."
    )
    SpecificAccountUType specificAccountUType;

    @Property(
        requiredIf = { @Condition(propertyName = "specificAccountUType", values = {"termDeposit"}) },
        nullIf = { @Condition(propertyName = "specificAccountUType", values = {"creditCard", "loan"}) }
    )
    BankingTermDepositAccount termDeposit;

    @Property(
        requiredIf = { @Condition(propertyName = "specificAccountUType", values = {"creditCard"}) },
        nullIf = { @Condition(propertyName = "specificAccountUType", values = {"termDeposit", "loan"}) }
    )
    BankingCreditCardAccount creditCard;

    @Property(
        requiredIf = { @Condition(propertyName = "specificAccountUType", values = {"loan"}) },
        nullIf = { @Condition(propertyName = "specificAccountUType", values = {"termDeposit", "creditCard"}) }
    )
    BankingLoanAccount loan;

    @Property(
        description = "current rate to calculate interest earned being applied to deposit balances as it stands at the time of the API call"
    )
    @CDSDataType(CustomDataType.Rate)
    String depositRate;

    @Property(
        description = "The current rate to calculate interest payable being applied to lending balances as it stands at the time of the API call"
    )
    @CDSDataType(CustomDataType.Rate)
    String lendingRate;

    @Property(
        description = "Fully described deposit rates for this account based on the equivalent structure in Product Reference"
    )
    List<BankingProductDepositRate> depositRates;

    @Property(
        description = "Fully described deposit rates for this account based on the equivalent structure in Product Reference"
    )
    List<BankingProductLendingRate> lendingRates;

    @Property(
        description = "Array of features of the account based on the equivalent structure in Product Reference with the following additional field"
    )
    List<Object> features;

    @Property(
        description = "Fees and charges applicable to the account based on the equivalent structure in Product Reference"
    )
    List<BankingProductFee> fees;

    @Property(
        description = "The addresses for the account to be used for correspondence"
    )
    List<CommonPhysicalAddress> addresses;
}
