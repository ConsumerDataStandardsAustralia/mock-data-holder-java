package au.org.consumerdatastandards.holder.model.banking;

import au.org.consumerdatastandards.holder.model.CommonPhysicalAddress;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public interface BankingAccountDetail extends BankingAccount {

    public enum SpecificAccountUType {
        creditCard,
        loan,
        termDeposit
    }

    @ApiModelProperty(value = "The unmasked account number for the account. Should not be supplied if the account number is a PAN requiring PCI compliance. Is expected to be formatted as digits only with leading zeros included and no punctuation or spaces")
    String getAccountNumber();

    void setAccountNumber(String accountNumber);

    @ApiModelProperty(value = "The addresses for the account to be used for correspondence")
    List<CommonPhysicalAddress> getAddresses();

    void setAddresses(List<CommonPhysicalAddress> addresses);

    @ApiModelProperty(value = "The unmasked BSB for the account. Is expected to be formatted as digits only with leading zeros included and no punctuation or spaces")
    String getBsb();

    void setBsb(String bsb);

    @ApiModelProperty(value = "Optional field to indicate if this account is part of a bundle that is providing additional benefit for to the customer")
    String getBundleName();

    void setBundleName(String bundleName);

    @ApiModelProperty
    BankingCreditCardAccount getCreditCard();

    void setCreditCard(BankingCreditCardAccount creditCard);

    @ApiModelProperty(value = "current rate to calculate interest earned being applied to deposit balances as it stands at the time of the API call")
    String getDepositRate();

    void setDepositRate(String depositRate);

    @ApiModelProperty(value = "Fully described deposit rates for this account based on the equivalent structure in Product Reference")
    List<BankingProductDepositRateV1> getDepositRates();

    void setDepositRates(List<BankingProductDepositRateV1> depositRates);

    @ApiModelProperty(value = "Array of features of the account based on the equivalent structure in Product Reference with the following additional field")
    List<BankingAccountProductFeature> getFeatures();

    void setFeatures(List<BankingAccountProductFeature> features);

    @ApiModelProperty(value = "Fees and charges applicable to the account based on the equivalent structure in Product Reference")
    List<BankingProductFee> getFees();

    void setFees(List<BankingProductFee> fees);

    @ApiModelProperty(value = "The current rate to calculate interest payable being applied to lending balances as it stands at the time of the API call")
    String getLendingRate();

    void setLendingRate(String lendingRate);

    @ApiModelProperty(value = "Fully described lending rates for this account based on the equivalent structure in Product Reference")
    List<BankingProductLendingRateV1> getLendingRates();

    void setLendingRates(List<BankingProductLendingRateV1> lendingRates);

    @ApiModelProperty
    BankingLoanAccount getLoan();

    void setLoan(BankingLoanAccount loan);

    @ApiModelProperty
    SpecificAccountUType getSpecificAccountUType();

    void setSpecificAccountUType(SpecificAccountUType specificAccountUType);

    @ApiModelProperty
    List<BankingTermDepositAccount> getTermDeposit();

    void setTermDeposit(List<BankingTermDepositAccount> termDeposit);
}
