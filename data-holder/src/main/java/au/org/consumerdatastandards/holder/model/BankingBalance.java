package au.org.consumerdatastandards.holder.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.List;

@ApiModel
@Entity
public class BankingBalance  {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @JsonIgnore
    private String id;

    /**
     * A unique ID of the account adhering to the standards for ID permanence
     */
    private String accountId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(updatable = false)
    private BankingAccount bankingAccount;

    /**
     * Object representing the available limit amortised according to payment schedule. Assumed to be zero if absent
     */
    private String amortisedLimit;

    /**
     * Balance representing the amount of funds available for transfer. Assumed to be zero or positive
     */
    private String availableBalance;

    /**
     * Object representing the maximum amount of credit that is available for this account. Assumed to be zero if absent
     */
    private String creditLimit;

    /**
     * The currency for the balance amounts. If absent assumed to be AUD
     */
    private String currency;

    /**
     * The balance of the account at this time. Should align to the balance available via other channels such as Internet Banking. Assumed to be negative if the customer has money owing
     */
    private String currentBalance;

    /**
     * Optional array of balances for the account in other currencies. Included to support accounts that support multi-currency purses such as Travel Cards
     */
    @OneToMany
    @JoinTable(
        name = "banking_balance_purses",
        joinColumns = @JoinColumn(name = "banking_balance_id"),
        inverseJoinColumns = @JoinColumn(name = "purse_id"))
    private List<BankingBalancePurse> purses;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BankingBalance accountId(String accountId) {
        this.accountId = accountId;
        return this;
    }

    @ApiModelProperty(required = true, value = "A unique ID of the account adhering to the standards for ID permanence")
    public String getAccountId() {
        return accountId;
    }

    public BankingAccount getBankingAccount() {
        return bankingAccount;
    }

    public void setBankingAccount(BankingAccount bankingAccount) {
        this.bankingAccount = bankingAccount;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
    public BankingBalance amortisedLimit(String amortisedLimit) {
        this.amortisedLimit = amortisedLimit;
        return this;
    }

    @ApiModelProperty(value = "Object representing the available limit amortised according to payment schedule. Assumed to be zero if absent")
    public String getAmortisedLimit() {
        return amortisedLimit;
    }

    public void setAmortisedLimit(String amortisedLimit) {
        this.amortisedLimit = amortisedLimit;
    }
    public BankingBalance availableBalance(String availableBalance) {
        this.availableBalance = availableBalance;
        return this;
    }

    @ApiModelProperty(required = true, value = "Balance representing the amount of funds available for transfer. Assumed to be zero or positive")
    public String getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(String availableBalance) {
        this.availableBalance = availableBalance;
    }

    public BankingBalance creditLimit(String creditLimit) {
        this.creditLimit = creditLimit;
        return this;
    }

    @ApiModelProperty(value = "Object representing the maximum amount of credit that is available for this account. Assumed to be zero if absent")
    public String getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(String creditLimit) {
        this.creditLimit = creditLimit;
    }

    public BankingBalance currency(String currency) {
        this.currency = currency;
        return this;
    }

    @ApiModelProperty(value = "The currency for the balance amounts. If absent assumed to be AUD")
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BankingBalance currentBalance(String currentBalance) {
        this.currentBalance = currentBalance;
        return this;
    }

    @ApiModelProperty(required = true, value = "The balance of the account at this time. Should align to the balance available via other channels such as Internet Banking. Assumed to be negative if the customer has money owing")
    public String getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(String currentBalance) {
        this.currentBalance = currentBalance;
    }

    public BankingBalance purses(List<BankingBalancePurse> purses) {
        this.purses = purses;
        return this;
    }

    public BankingBalance addItem(BankingBalancePurse pursesItem) {
        if (this.purses == null) {
            this.purses = new ArrayList<>();
        }
        this.purses.add(pursesItem);
        return this;
    }

    @ApiModelProperty(value = "Optional array of balances for the account in other currencies. Included to support accounts that support multi-currency purses such as Travel Cards")
    public List<BankingBalancePurse> getPurses() {
        return purses;
    }

    public void setPurses(List<BankingBalancePurse> purses) {
        this.purses = purses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BankingBalance bankingBalance = (BankingBalance) o;
        return Objects.equals(this.id, bankingBalance.id) &&
            Objects.equals(this.accountId, bankingBalance.accountId) &&
            Objects.equals(this.amortisedLimit, bankingBalance.amortisedLimit) &&
            Objects.equals(this.availableBalance, bankingBalance.availableBalance) &&
            Objects.equals(this.creditLimit, bankingBalance.creditLimit) &&
            Objects.equals(this.currency, bankingBalance.currency) &&
            Objects.equals(this.currentBalance, bankingBalance.currentBalance) &&
            Objects.equals(this.purses, bankingBalance.purses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            id,
            accountId,
            amortisedLimit,
            availableBalance,
            creditLimit,
            currency,
            currentBalance,
            purses);
    }

    @Override
    public String toString() {
        return "class BankingBalance {\n" +
            "   id: " + toIndentedString(id) + "\n" +
            "   accountId: " + toIndentedString(accountId) + "\n" +
            "   amortisedLimit: " + toIndentedString(amortisedLimit) + "\n" +
            "   availableBalance: " + toIndentedString(availableBalance) + "\n" + 
            "   creditLimit: " + toIndentedString(creditLimit) + "\n" + 
            "   currency: " + toIndentedString(currency) + "\n" + 
            "   currentBalance: " + toIndentedString(currentBalance) + "\n" + 
            "   purses: " + toIndentedString(purses) + "\n" + 
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

