package au.org.consumerdatastandards.client.model.banking;

import au.org.consumerdatastandards.client.model.CommonPhysicalAddress;

import java.util.List;

public interface BankingAccountDetail extends BankingAccount {
    /**
     * The unmasked BSB for the account. Is expected to be formatted as digits only with leading zeros included and no punctuation or spaces
     * @return bsb
     */
    String getBsb();

    void setBsb(String bsb);

    /**
     * The unmasked account number for the account. Should not be supplied if the account number is a PAN requiring PCI compliance. Is expected to be formatted as digits only with leading zeros included and no punctuation or spaces
     * @return accountNumber
     */
    String getAccountNumber();

    void setAccountNumber(String accountNumber);

    /**
     * Optional field to indicate if this account is part of a bundle that is providing additional benefit for to the customer
     * @return bundleName
     */
    String getBundleName();

    void setBundleName(String bundleName);

    /**
     * The type of structure to present account specific fields.
     * @return specificAccountUType
     */
    SpecificAccountUType getSpecificAccountUType();

    void setSpecificAccountUType(SpecificAccountUType specificAccountUType);

    /**
     * Get termDeposit
     * @return termDeposit
     */
    List<BankingTermDepositAccount> getTermDeposit();

    void setTermDeposit(List<BankingTermDepositAccount> termDeposit);

    /**
     * Get creditCard
     * @return creditCard
     */
    BankingCreditCardAccount getCreditCard();

    void setCreditCard(BankingCreditCardAccount creditCard);

    /**
     * Get loan
     * @return loan
     */
    BankingLoanAccount getLoan();

    void setLoan(BankingLoanAccount loan);

    /**
     * current rate to calculate interest earned being applied to deposit balances as it stands at the time of the API call
     * @return depositRate
     */
    String getDepositRate();

    void setDepositRate(String depositRate);

    /**
     * The current rate to calculate interest payable being applied to lending balances as it stands at the time of the API call
     * @return lendingRate
     */
    String getLendingRate();

    void setLendingRate(String lendingRate);

    /**
     * Fully described deposit rates for this account based on the equivalent structure in Product Reference
     * @return depositRates
     */
    List<BankingProductDepositRate> getDepositRates();

    void setDepositRates(List<BankingProductDepositRate> depositRates);

    /**
     * Fully described lending rates for this account based on the equivalent structure in Product Reference
     * @return lendingRates
     */
    List<BankingProductLendingRate> getLendingRates();

    void setLendingRates(List<BankingProductLendingRate> lendingRates);

    /**
     * Array of features of the account based on the equivalent structure in Product Reference with the following additional field
     * @return features
     */
    List<Object> getFeatures();

    void setFeatures(List<Object> features);

    /**
     * Fees and charges applicable to the account based on the equivalent structure in Product Reference
     * @return fees
     */
    List<BankingProductFee> getFees();

    void setFees(List<BankingProductFee> fees);

    /**
     * The addresses for the account to be used for correspondence
     * @return addresses
     */
    List<CommonPhysicalAddress> getAddresses();

    void setAddresses(List<CommonPhysicalAddress> addresses);

    public enum SpecificAccountUType {
        termDeposit,
        creditCard,
        loan
    }
}
