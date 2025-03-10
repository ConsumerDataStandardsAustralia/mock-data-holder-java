package au.org.consumerdatastandards.holder.model.banking;

import au.org.consumerdatastandards.holder.model.CommonPhysicalAddress;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@ApiModel
@Entity
@Table(name = "b_account")
public class BankingAccountDetailV1 implements BankingAccountDetail {

    /**
     * A unique ID of the account adhering to the standards for ID permanence.
     */
    @Id
    private String accountId;

    @JsonIgnore
    private String userId;

    /**
     * Date that the account was created (if known)
     */
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDate creationDate;

    /**
     * The display name of the account as defined by the bank. This should not incorporate account numbers or PANs. If it does the values should be masked according to the rules of the [MaskedAccountString](#common-field-types) common type.
     */
    private String displayName;

    /**
     * Flag indicating that the customer associated with the authorisation is an owner of the account. Does not indicate sole ownership, however. If not present then `true` is assumed.
     */
    @Transient
    private Boolean isOwned;

    /**
     * A masked version of the account. Whether BSB/Account Number, Credit Card PAN or another number.
     */
    private String maskedNumber;

    /**
     * A customer supplied nickname for the account.
     */
    private String nickname;

    private BankingAccount.OpenStatus openStatus;

    private BankingProductCategory productCategory;

    /**
     * The unique identifier of the account as defined by the data holder (akin to model number for the account).
     */
    private String productName;

    /**
     * The unmasked account number for the account. Should not be supplied if the account number is a PAN requiring PCI compliance. Is expected to be formatted as digits only with leading zeros included and no punctuation or spaces.
     */
    private String accountNumber;

    /**
     * The addresses for the account to be used for correspondence.
     */
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "banking_account_addresses",
        joinColumns = @JoinColumn(name = "banking_account_id"),
        inverseJoinColumns = @JoinColumn(name = "common_physical_address_id"))
    private List<CommonPhysicalAddress> addresses;

    /**
     * The unmasked BSB for the account. Is expected to be formatted as digits only with leading zeros included and no punctuation or spaces.
     */
    private String bsb;

    /**
     * Optional field to indicate if this account is part of a bundle that is providing additional benefit to the customer.
     */
    private String bundleName;

    /**
     * Get creditCard
     */
    @ManyToOne
    private BankingCreditCardAccount creditCard;

    /**
     * Current rate to calculate interest earned being applied to deposit balances as it stands at the time of the API call.
     */
    private String depositRate;

    /**
     * Fully described deposit rates for this account based on the equivalent structure in Product Reference.
     */
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "banking_account_deposit_rates",
        joinColumns = @JoinColumn(name = "banking_account_id"),
        inverseJoinColumns = @JoinColumn(name = "deposit_rate_id"))
    private List<BankingProductDepositRateV1> depositRates;

    /**
     * Array of features of the account based on the equivalent structure in Product Reference with the following additional field.
     */
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "banking_account_features",
        joinColumns = @JoinColumn(name = "banking_account_id"),
        inverseJoinColumns = @JoinColumn(name = "feature_id"))
    private List<BankingAccountProductFeature> features;

    /**
     * Fees and charges applicable to the account based on the equivalent structure in Product Reference.
     */
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "banking_account_fees",
        joinColumns = @JoinColumn(name = "banking_account_id"),
        inverseJoinColumns = @JoinColumn(name = "product_fee_id"))
    private List<BankingProductFee> fees;

    /**
     * The current rate to calculate interest payable being applied to lending balances as it stands at the time of the API call.
     */
    private String lendingRate;

    /**
     * Fully described lending rates for this account based on the equivalent structure in Product Reference.
     */
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "banking_account_lending_rates",
        joinColumns = @JoinColumn(name = "banking_account_id"),
        inverseJoinColumns = @JoinColumn(name = "lending_rate_id"))
    private List<BankingProductLendingRateV1> lendingRates;

    @ManyToOne
    @JoinTable(
            name = "b_account_loans",
            joinColumns = @JoinColumn(name = "account_id"),
            inverseJoinColumns = @JoinColumn(name = "loan_id"))
    private BankingLoanAccount loan;

    private SpecificAccountUType specificAccountUType;

    @OneToMany
    @JoinTable(
            name = "b_account_term_deposits",
            joinColumns = @JoinColumn(name = "account_id"),
            inverseJoinColumns = @JoinColumn(name = "term_deposit_id"))
    private List<BankingTermDepositAccount> termDeposit;

    @Override
    public String getAccountId() {
        return accountId;
    }

    @Override
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    @Override
    public String getUserId() {
        return userId;
    }

    @Override
    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public LocalDate getCreationDate() {
        return creationDate;
    }

    @Override
    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String getDisplayName() {
        return displayName;
    }

    @Override
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public Boolean getIsOwned() {
        return isOwned;
    }

    @Override
    public void setIsOwned(Boolean owned) {
        isOwned = owned;
    }

    @Override
    public String getMaskedNumber() {
        return maskedNumber;
    }

    @Override
    public void setMaskedNumber(String maskedNumber) {
        this.maskedNumber = maskedNumber;
    }

    @Override
    public String getNickname() {
        return nickname;
    }

    @Override
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public BankingAccount.OpenStatus getOpenStatus() {
        return openStatus;
    }

    @Override
    public void setOpenStatus(BankingAccount.OpenStatus openStatus) {
        this.openStatus = openStatus;
    }

    @Override
    public BankingProductCategory getProductCategory() {
        return productCategory;
    }

    @Override
    public void setProductCategory(BankingProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    @Override
    public String getProductName() {
        return productName;
    }

    @Override
    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BankingAccountDetail accountId(String accountId) {
        this.accountId = accountId;
        return this;
    }

    public BankingAccountDetail creationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    public BankingAccountDetail displayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    public BankingAccountDetail isOwned(Boolean isOwned) {
        this.isOwned = isOwned;
        return this;
    }

    public BankingAccountDetail maskedNumber(String maskedNumber) {
        this.maskedNumber = maskedNumber;
        return this;
    }

    public BankingAccountDetail nickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public BankingAccountDetail openStatus(BankingAccount.OpenStatus openStatus) {
        this.openStatus = openStatus;
        return this;
    }

    public BankingAccountDetail productCategory(BankingProductCategory productCategory) {
        this.productCategory = productCategory;
        return this;
    }

    public BankingAccountDetail productName(String productName) {
        this.productName = productName;
        return this;
    }

    public BankingAccountDetail accountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
        return this;
    }

    @Override
    @ApiModelProperty(value = "The unmasked account number for the account. Should not be supplied if the account number is a PAN requiring PCI compliance. Is expected to be formatted as digits only with leading zeros included and no punctuation or spaces.")
    public String getAccountNumber() {
        return accountNumber;
    }

    @Override
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BankingAccountDetail addresses(List<CommonPhysicalAddress> addresses) {
        this.addresses = addresses;
        return this;
    }

    public BankingAccountDetail addItem(CommonPhysicalAddress addressesItem) {
        if (this.addresses == null) {
            this.addresses = new ArrayList<>();
        }
        this.addresses.add(addressesItem);
        return this;
    }

    @Override
    @ApiModelProperty(value = "The addresses for the account to be used for correspondence.")
    public List<CommonPhysicalAddress> getAddresses() {
        return addresses;
    }

    @Override
    public void setAddresses(List<CommonPhysicalAddress> addresses) {
        this.addresses = addresses;
    }

    public BankingAccountDetail bsb(String bsb) {
        this.bsb = bsb;
        return this;
    }

    @Override
    @ApiModelProperty(value = "The unmasked BSB for the account. Is expected to be formatted as digits only with leading zeros included and no punctuation or spaces.")
    public String getBsb() {
        return bsb;
    }

    @Override
    public void setBsb(String bsb) {
        this.bsb = bsb;
    }

    public BankingAccountDetail bundleName(String bundleName) {
        this.bundleName = bundleName;
        return this;
    }

    @Override
    @ApiModelProperty(value = "Optional field to indicate if this account is part of a bundle that is providing additional benefit to the customer.")
    public String getBundleName() {
        return bundleName;
    }

    @Override
    public void setBundleName(String bundleName) {
        this.bundleName = bundleName;
    }

    public BankingAccountDetail creditCard(BankingCreditCardAccount creditCard) {
        this.creditCard = creditCard;
        return this;
    }

    @Override
    @ApiModelProperty
    public BankingCreditCardAccount getCreditCard() {
        return creditCard;
    }

    @Override
    public void setCreditCard(BankingCreditCardAccount creditCard) {
        this.creditCard = creditCard;
    }

    public BankingAccountDetail depositRate(String depositRate) {
        this.depositRate = depositRate;
        return this;
    }

    @Override
    @ApiModelProperty(value = "Current rate to calculate interest earned being applied to deposit balances as it stands at the time of the API call.")
    public String getDepositRate() {
        return depositRate;
    }

    @Override
    public void setDepositRate(String depositRate) {
        this.depositRate = depositRate;
    }

    public BankingAccountDetail depositRates(List<BankingProductDepositRateV1> depositRates) {
        this.depositRates = depositRates;
        return this;
    }

    public BankingAccountDetail addItem(BankingProductDepositRateV1 depositRatesItem) {
        if (this.depositRates == null) {
            this.depositRates = new ArrayList<>();
        }
        this.depositRates.add(depositRatesItem);
        return this;
    }

    @ApiModelProperty(value = "Fully described deposit rates for this account based on the equivalent structure in Product Reference.")
    public List<BankingProductDepositRateV1> getDepositRates() {
        return depositRates;
    }

    public void setDepositRates(List<BankingProductDepositRateV1> depositRates) {
        this.depositRates = depositRates;
    }

    public BankingAccountDetail features(List<BankingAccountProductFeature> features) {
        this.features = features;
        return this;
    }

    public BankingAccountDetail addItem(BankingAccountProductFeature featuresItem) {
        if (this.features == null) {
            this.features = new ArrayList<>();
        }
        this.features.add(featuresItem);
        return this;
    }

    @Override
    @ApiModelProperty(value = "Array of features of the account based on the equivalent structure in Product Reference with the following additional field.")
    public List<BankingAccountProductFeature> getFeatures() {
        return features;
    }

    @Override
    public void setFeatures(List<BankingAccountProductFeature> features) {
        this.features = features;
    }

    public BankingAccountDetail fees(List<BankingProductFee> fees) {
        this.fees = fees;
        return this;
    }

    public BankingAccountDetail addItem(BankingProductFee feesItem) {
        if (this.fees == null) {
            this.fees = new ArrayList<>();
        }
        this.fees.add(feesItem);
        return this;
    }

    @Override
    @ApiModelProperty(value = "Fees and charges applicable to the account based on the equivalent structure in Product Reference.")
    public List<BankingProductFee> getFees() {
        return fees;
    }

    @Override
    public void setFees(List<BankingProductFee> fees) {
        this.fees = fees;
    }

    public BankingAccountDetail lendingRate(String lendingRate) {
        this.lendingRate = lendingRate;
        return this;
    }

    @Override
    @ApiModelProperty(value = "The current rate to calculate interest payable being applied to lending balances as it stands at the time of the API call.")
    public String getLendingRate() {
        return lendingRate;
    }

    @Override
    public void setLendingRate(String lendingRate) {
        this.lendingRate = lendingRate;
    }

    public BankingAccountDetail lendingRates(List<BankingProductLendingRateV1> lendingRates) {
        this.lendingRates = lendingRates;
        return this;
    }

    public BankingAccountDetail addItem(BankingProductLendingRateV1 lendingRatesItem) {
        if (this.lendingRates == null) {
            this.lendingRates = new ArrayList<>();
        }
        this.lendingRates.add(lendingRatesItem);
        return this;
    }

    @ApiModelProperty(value = "Fully described lending rates for this account based on the equivalent structure in Product Reference.")
    public List<BankingProductLendingRateV1> getLendingRates() {
        return lendingRates;
    }

    public void setLendingRates(List<BankingProductLendingRateV1> lendingRates) {
        this.lendingRates = lendingRates;
    }

    public BankingAccountDetail loan(BankingLoanAccount loan) {
        this.loan = loan;
        return this;
    }

    @Override
    @ApiModelProperty
    public BankingLoanAccount getLoan() {
        return loan;
    }

    @Override
    public void setLoan(BankingLoanAccount loan) {
        this.loan = loan;
    }

    public BankingAccountDetail specificAccountUType(SpecificAccountUType specificAccountUType) {
        this.specificAccountUType = specificAccountUType;
        return this;
    }

    @Override
    @ApiModelProperty
    public SpecificAccountUType getSpecificAccountUType() {
        return specificAccountUType;
    }

    @Override
    public void setSpecificAccountUType(SpecificAccountUType specificAccountUType) {
        this.specificAccountUType = specificAccountUType;
    }

    public BankingAccountDetail termDeposit(List<BankingTermDepositAccount> termDeposit) {
        this.termDeposit = termDeposit;
        return this;
    }

    @Override
    @ApiModelProperty
    public List<BankingTermDepositAccount> getTermDeposit() {
        return termDeposit;
    }

    @Override
    public void setTermDeposit(List<BankingTermDepositAccount> termDeposit) {
        this.termDeposit = termDeposit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BankingAccountDetailV1 bankingAccountDetail = (BankingAccountDetailV1) o;
        return Objects.equals(this.accountNumber, bankingAccountDetail.accountNumber) &&
            Objects.equals(this.userId, bankingAccountDetail.userId) &&
            Objects.equals(this.creationDate, bankingAccountDetail.creationDate) &&
            Objects.equals(this.displayName, bankingAccountDetail.displayName) &&
            Objects.equals(this.isOwned, bankingAccountDetail.isOwned) &&
            Objects.equals(this.maskedNumber, bankingAccountDetail.maskedNumber) &&
            Objects.equals(this.nickname, bankingAccountDetail.nickname) &&
            Objects.equals(this.openStatus, bankingAccountDetail.openStatus) &&
            Objects.equals(this.productCategory, bankingAccountDetail.productCategory) &&
            Objects.equals(this.productName, bankingAccountDetail.productName) &&
            Objects.equals(this.addresses, bankingAccountDetail.addresses) &&
            Objects.equals(this.bsb, bankingAccountDetail.bsb) &&
            Objects.equals(this.bundleName, bankingAccountDetail.bundleName) &&
            Objects.equals(this.creditCard, bankingAccountDetail.creditCard) &&
            Objects.equals(this.depositRate, bankingAccountDetail.depositRate) &&
            Objects.equals(this.depositRates, bankingAccountDetail.depositRates) &&
            Objects.equals(this.features, bankingAccountDetail.features) &&
            Objects.equals(this.fees, bankingAccountDetail.fees) &&
            Objects.equals(this.lendingRate, bankingAccountDetail.lendingRate) &&
            Objects.equals(this.lendingRates, bankingAccountDetail.lendingRates) &&
            Objects.equals(this.loan, bankingAccountDetail.loan) &&
            Objects.equals(this.specificAccountUType, bankingAccountDetail.specificAccountUType) &&
            Objects.equals(this.termDeposit, bankingAccountDetail.termDeposit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            accountId,
            userId,
            creationDate,
            displayName,
            isOwned,
            maskedNumber,
            nickname,
            openStatus,
            productCategory,
            productName,
            accountNumber,
            addresses,
            bsb,
            bundleName,
            creditCard,
            depositRate,
            depositRates,
            features,
            fees,
            lendingRate,
            lendingRates,
            loan,
            specificAccountUType,
            termDeposit);
    }

    @Override
    public String toString() {
        return "class BankingAccountDetail {\n" +
            "   accountId: " + toIndentedString(getAccountId()) + "\n" +
            "   creationDate: " + toIndentedString(getCreationDate()) + "\n" +
            "   displayName: " + toIndentedString(getDisplayName()) + "\n" +
            "   isOwned: " + toIndentedString(getIsOwned()) + "\n" +
            "   maskedNumber: " + toIndentedString(getMaskedNumber()) + "\n" +
            "   nickname: " + toIndentedString(getNickname()) + "\n" +
            "   openStatus: " + toIndentedString(getOpenStatus()) + "\n" +
            "   productCategory: " + toIndentedString(getProductCategory()) + "\n" +
            "   productName: " + toIndentedString(getProductName()) + "\n" +
            "   accountNumber: " + toIndentedString(accountNumber) + "\n" +
            "   addresses: " + toIndentedString(addresses) + "\n" +
            "   bsb: " + toIndentedString(bsb) + "\n" +
            "   bundleName: " + toIndentedString(bundleName) + "\n" +
            "   creditCard: " + toIndentedString(creditCard) + "\n" +
            "   depositRate: " + toIndentedString(depositRate) + "\n" +
            "   depositRates: " + toIndentedString(depositRates) + "\n" +
            "   features: " + toIndentedString(features) + "\n" +
            "   fees: " + toIndentedString(fees) + "\n" +
            "   lendingRate: " + toIndentedString(lendingRate) + "\n" +
            "   lendingRates: " + toIndentedString(lendingRates) + "\n" +
            "   loan: " + toIndentedString(loan) + "\n" +
            "   specificAccountUType: " + toIndentedString(specificAccountUType) + "\n" +
            "   termDeposit: " + toIndentedString(termDeposit) + "\n" +
            "}";
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
