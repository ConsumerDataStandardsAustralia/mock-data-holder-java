package au.org.consumerdatastandards.holder.model.banking;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Objects;

@ApiModel
@Entity
@Table(name = "b_account")
public class BankingAccountV2 implements BankingAccount {
    /**
     * A unique ID of the account adhering to the standards for ID permanence
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
     * The display name of the account as defined by the bank. This should not incorporate account numbers or PANs. If it does the values should be masked according to the rules of the MaskedAccountString common type.
     */
    private String displayName;

    /**
     * Flag indicating that the customer associated with the authorisation is an owner of the account. Does not indicate sole ownership, however. If not present then 'true' is assumed
     */
    @Transient
    private Boolean isOwned;

    /**
     * Value indicating the number of customers that have ownership of the account, according to the data holder's definition of account ownership. Does not indicate that all account owners are eligible consumers
     */
    private AccountOwnershipEnum accountOwnership;

    /**
     * A masked version of the account. Whether BSB/Account Number, Credit Card PAN or another number
     */
    private String maskedNumber;

    /**
     * A customer supplied nick name for the account
     */
    private String nickname;

    private OpenStatus openStatus;

    private BankingProductCategory productCategory;

    /**
     * The unique identifier of the account as defined by the account holder (akin to model number for the account)
     */
    private String productName;

    public BankingAccount accountId(String accountId) {
        this.accountId = accountId;
        return this;
    }

    @Override
    @ApiModelProperty(required = true, value = "A unique ID of the account adhering to the standards for ID permanence")
    @NotNull
    public String getAccountId() {
        return accountId;
    }

    @Override
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public BankingAccount userId(String userId) {
        this.userId = userId;
        return this;
    }

    @Override
    public String getUserId() {
        return userId;
    }

    @Override
    public void setUserId(String userId) {
        this.userId = userId;
    }

    public BankingAccount creationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    @Override
    @ApiModelProperty(value = "Date that the account was created (if known)")
    public LocalDate getCreationDate() {
        return creationDate;
    }

    @Override
    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public BankingAccount displayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    @Override
    @ApiModelProperty(required = true, value = "The display name of the account as defined by the bank. This should not incorporate account numbers or PANs. If it does the values should be masked according to the rules of the MaskedAccountString common type.")
    @NotNull
    public String getDisplayName() {
        return displayName;
    }

    @Override
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public BankingAccount isOwned(Boolean isOwned) {
        this.isOwned = isOwned;
        return this;
    }

    @Override
    @ApiModelProperty(value = "Flag indicating that the customer associated with the authorisation is an owner of the account. Does not indicate sole ownership, however. If not present then 'true' is assumed")
    public Boolean getIsOwned() {
        return isOwned;
    }

    @Override
    public void setIsOwned(Boolean isOwned) {
        this.isOwned = isOwned;
    }
    public BankingAccount maskedNumber(String maskedNumber) {
        this.maskedNumber = maskedNumber;
        return this;
    }

    @ApiModelProperty(required = true, value = "Value indicating the number of customers that have ownership of the account, according to the data holder's definition of account ownership. Does not indicate that all account owners are eligible consumers")
    @NotNull
    public AccountOwnershipEnum getAccountOwnership() {
        return accountOwnership;
    }

    public void setAccountOwnership(AccountOwnershipEnum accountOwnership) {
        this.accountOwnership = accountOwnership;
    }

    @Override
    @ApiModelProperty(required = true, value = "A masked version of the account. Whether BSB/Account Number, Credit Card PAN or another number")
    @NotNull
    public String getMaskedNumber() {
        return maskedNumber;
    }

    @Override
    public void setMaskedNumber(String maskedNumber) {
        this.maskedNumber = maskedNumber;
    }
    public BankingAccount nickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    @Override
    @ApiModelProperty(value = "A customer supplied nick name for the account")
    public String getNickname() {
        return nickname;
    }

    @Override
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public BankingAccount openStatus(OpenStatus openStatus) {
        this.openStatus = openStatus;
        return this;
    }

    @Override
    @ApiModelProperty
    public OpenStatus getOpenStatus() {
        return openStatus;
    }

    @Override
    public void setOpenStatus(OpenStatus openStatus) {
        this.openStatus = openStatus;
    }
    public BankingAccount productCategory(BankingProductCategory productCategory) {
        this.productCategory = productCategory;
        return this;
    }

    @Override
    @ApiModelProperty(required = true)
    @NotNull
    public BankingProductCategory getProductCategory() {
        return productCategory;
    }

    @Override
    public void setProductCategory(BankingProductCategory productCategory) {
        this.productCategory = productCategory;
    }
    public BankingAccount productName(String productName) {
        this.productName = productName;
        return this;
    }

    @Override
    @ApiModelProperty(required = true, value = "The unique identifier of the account as defined by the account holder (akin to model number for the account)")
    @NotNull
    public String getProductName() {
        return productName;
    }

    @Override
    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BankingAccountV2 bankingAccount = (BankingAccountV2) o;
        return Objects.equals(this.accountId, bankingAccount.accountId) &&
            Objects.equals(this.userId, bankingAccount.userId) &&
            Objects.equals(this.creationDate, bankingAccount.creationDate) &&
            Objects.equals(this.displayName, bankingAccount.displayName) &&
            Objects.equals(this.isOwned, bankingAccount.isOwned) &&
            Objects.equals(this.accountOwnership, bankingAccount.accountOwnership) &&
            Objects.equals(this.maskedNumber, bankingAccount.maskedNumber) &&
            Objects.equals(this.nickname, bankingAccount.nickname) &&
            Objects.equals(this.openStatus, bankingAccount.openStatus) &&
            Objects.equals(this.productCategory, bankingAccount.productCategory) &&
            Objects.equals(this.productName, bankingAccount.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            accountId,
            userId,
            creationDate,
            displayName,
            isOwned,
            accountOwnership,
            maskedNumber,
            nickname,
            openStatus,
            productCategory,
            productName);
    }

    @Override
    public String toString() {
        return "class BankingAccount {\n" +
            "   accountId: " + toIndentedString(accountId) + "\n" + 
            "   userId: " + toIndentedString(userId) + "\n" +
            "   creationDate: " + toIndentedString(creationDate) + "\n" +
            "   displayName: " + toIndentedString(displayName) + "\n" + 
            "   isOwned: " + toIndentedString(isOwned) + "\n" + 
            "   accountOwnership: " + toIndentedString(accountOwnership) + "\n" +
            "   maskedNumber: " + toIndentedString(maskedNumber) + "\n" +
            "   nickname: " + toIndentedString(nickname) + "\n" + 
            "   openStatus: " + toIndentedString(openStatus) + "\n" + 
            "   productCategory: " + toIndentedString(productCategory) + "\n" + 
            "   productName: " + toIndentedString(productName) + "\n" + 
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
