/*
 * Consumer Data Standards
 * Sample client library to Demonstrate the Consumer Data Right APIs
 */
package au.org.consumerdatastandards.client.model.banking;

import au.org.consumerdatastandards.client.model.CommonPhysicalAddress;

import java.util.List;
import java.util.Objects;

public class BankingAccountDetailV3 extends BankingAccountV2 implements BankingAccountDetail {

    private String bsb;

    private String accountNumber;

    private String bundleName;

    private SpecificAccountUType specificAccountUType;

    private List<BankingTermDepositAccount> termDeposit;

    private BankingCreditCardAccount creditCard;

    private BankingLoanAccount loan;

    private String depositRate;

    private String lendingRate;

    private List<BankingProductDepositRate> depositRates;

    private List<BankingProductLendingRate> lendingRates;

    private List<Object> features;

    private List<BankingProductFee> fees;

    private List<CommonPhysicalAddress> addresses;

    /**
     * The unmasked BSB for the account. Is expected to be formatted as digits only with leading zeros included and no punctuation or spaces
     * @return bsb
     */
    @Override
    public String getBsb() {
        return bsb;
    }

    @Override
    public void setBsb(String bsb) {
        this.bsb = bsb;
    }

    /**
     * The unmasked account number for the account. Should not be supplied if the account number is a PAN requiring PCI compliance. Is expected to be formatted as digits only with leading zeros included and no punctuation or spaces
     * @return accountNumber
     */
    @Override
    public String getAccountNumber() {
        return accountNumber;
    }

    @Override
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     * Optional field to indicate if this account is part of a bundle that is providing additional benefit for to the customer
     * @return bundleName
     */
    @Override
    public String getBundleName() {
        return bundleName;
    }

    @Override
    public void setBundleName(String bundleName) {
        this.bundleName = bundleName;
    }

    /**
     * The type of structure to present account specific fields.
     * @return specificAccountUType
     */
    @Override
    public SpecificAccountUType getSpecificAccountUType() {
        return specificAccountUType;
    }

    @Override
    public void setSpecificAccountUType(SpecificAccountUType specificAccountUType) {
        this.specificAccountUType = specificAccountUType;
    }

    /**
     * Get termDeposit
     * @return termDeposit
     */
    @Override
    public List<BankingTermDepositAccount> getTermDeposit() {
        return termDeposit;
    }

    @Override
    public void setTermDeposit(List<BankingTermDepositAccount> termDeposit) {
        this.termDeposit = termDeposit;
    }

    /**
     * Get creditCard
     * @return creditCard
     */
    @Override
    public BankingCreditCardAccount getCreditCard() {
        return creditCard;
    }

    @Override
    public void setCreditCard(BankingCreditCardAccount creditCard) {
        this.creditCard = creditCard;
    }

    /**
     * Get loan
     * @return loan
     */
    @Override
    public BankingLoanAccount getLoan() {
        return loan;
    }

    @Override
    public void setLoan(BankingLoanAccount loan) {
        this.loan = loan;
    }

    /**
     * current rate to calculate interest earned being applied to deposit balances as it stands at the time of the API call
     * @return depositRate
     */
    @Override
    public String getDepositRate() {
        return depositRate;
    }

    @Override
    public void setDepositRate(String depositRate) {
        this.depositRate = depositRate;
    }

    /**
     * The current rate to calculate interest payable being applied to lending balances as it stands at the time of the API call
     * @return lendingRate
     */
    @Override
    public String getLendingRate() {
        return lendingRate;
    }

    @Override
    public void setLendingRate(String lendingRate) {
        this.lendingRate = lendingRate;
    }

    /**
     * Fully described deposit rates for this account based on the equivalent structure in Product Reference
     * @return depositRates
     */
    @Override
    public List<BankingProductDepositRate> getDepositRates() {
        return depositRates;
    }

    @Override
    public void setDepositRates(List<BankingProductDepositRate> depositRates) {
        this.depositRates = depositRates;
    }

    /**
     * Fully described deposit rates for this account based on the equivalent structure in Product Reference
     * @return lendingRates
     */
    @Override
    public List<BankingProductLendingRate> getLendingRates() {
        return lendingRates;
    }

    @Override
    public void setLendingRates(List<BankingProductLendingRate> lendingRates) {
        this.lendingRates = lendingRates;
    }

    /**
     * Array of features of the account based on the equivalent structure in Product Reference with the following additional field
     * @return features
     */
    @Override
    public List<Object> getFeatures() {
        return features;
    }

    @Override
    public void setFeatures(List<Object> features) {
        this.features = features;
    }

    /**
     * Fees and charges applicable to the account based on the equivalent structure in Product Reference
     * @return fees
     */
    @Override
    public List<BankingProductFee> getFees() {
        return fees;
    }

    @Override
    public void setFees(List<BankingProductFee> fees) {
        this.fees = fees;
    }

    /**
     * The addresses for the account to be used for correspondence
     * @return addresses
     */
    @Override
    public List<CommonPhysicalAddress> getAddresses() {
        return addresses;
    }

    @Override
    public void setAddresses(List<CommonPhysicalAddress> addresses) {
        this.addresses = addresses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BankingAccountDetailV3 bankingAccountDetail = (BankingAccountDetailV3) o;
        return Objects.equals(this.bsb, bankingAccountDetail.bsb) &&
            Objects.equals(this.accountNumber, bankingAccountDetail.accountNumber) &&
            Objects.equals(this.bundleName, bankingAccountDetail.bundleName) &&
            Objects.equals(this.specificAccountUType, bankingAccountDetail.specificAccountUType) &&
            Objects.equals(this.termDeposit, bankingAccountDetail.termDeposit) &&
            Objects.equals(this.creditCard, bankingAccountDetail.creditCard) &&
            Objects.equals(this.loan, bankingAccountDetail.loan) &&
            Objects.equals(this.depositRate, bankingAccountDetail.depositRate) &&
            Objects.equals(this.lendingRate, bankingAccountDetail.lendingRate) &&
            Objects.equals(this.depositRates, bankingAccountDetail.depositRates) &&
            Objects.equals(this.lendingRates, bankingAccountDetail.lendingRates) &&
            Objects.equals(this.features, bankingAccountDetail.features) &&
            Objects.equals(this.fees, bankingAccountDetail.fees) &&
            Objects.equals(this.addresses, bankingAccountDetail.addresses) &&
            super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            bsb,
            accountNumber,
            bundleName,
            specificAccountUType,
            termDeposit,
            creditCard,
            loan,
            depositRate,
            lendingRate,
            depositRates,
            lendingRates,
            features,
            fees,
            addresses,
            super.hashCode());
    }

    @Override
    public String toString() {
        return "class BankingAccountDetail {\n" +
            "   bsb: " + toIndentedString(bsb) + "\n" +
            "   accountNumber: " + toIndentedString(accountNumber) + "\n" +
            "   bundleName: " + toIndentedString(bundleName) + "\n" +
            "   specificAccountUType: " + toIndentedString(specificAccountUType) + "\n" +
            "   termDeposit: " + toIndentedString(termDeposit) + "\n" +
            "   creditCard: " + toIndentedString(creditCard) + "\n" +
            "   loan: " + toIndentedString(loan) + "\n" +
            "   depositRate: " + toIndentedString(depositRate) + "\n" +
            "   lendingRate: " + toIndentedString(lendingRate) + "\n" +
            "   depositRates: " + toIndentedString(depositRates) + "\n" +
            "   lendingRates: " + toIndentedString(lendingRates) + "\n" +
            "   features: " + toIndentedString(features) + "\n" +
            "   fees: " + toIndentedString(fees) + "\n" +
            "   addresses: " + toIndentedString(addresses) + "\n" +
            "}";
    }
}
