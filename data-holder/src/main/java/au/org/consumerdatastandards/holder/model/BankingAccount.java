package au.org.consumerdatastandards.holder.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;
import java.time.LocalDate;

@ApiModel
public class BankingAccount  {

    /**
     * A unique ID of the account adhering to the standards for ID permanence
     */
    private String accountId;

    /**
     * Date that the account was created (if known)
     */
    private LocalDate creationDate;

    /**
     * The display name of the account as defined by the bank. This should not incorporate account numbers or PANs. If it does the values should be masked according to the rules of the MaskedAccountString common type.
     */
    private String displayName;

    /**
     * Flag indicating that the customer associated with the authorisation is an owner of the account. Does not indicate sole ownership, however. If not present then 'true' is assumed
     */
    private Boolean isOwned;

    /**
     * A masked version of the account. Whether BSB/Account Number, Credit Card PAN or another number
     */
    private String maskedNumber;

    /**
     * A customer supplied nick name for the account
     */
    private String nickname;

    public enum OpenStatus {
        CLOSED,
        OPEN
    }
    /**
     * Get openStatus
     */
    private OpenStatus openStatus;

    /**
     * Get productCategory
     */
    private BankingProductCategory productCategory;

    /**
     * The unique identifier of the account as defined by the account holder (akin to model number for the account)
     */
    private String productName;

    public BankingAccount accountId(String accountId) {
        this.accountId = accountId;
        return this;
    }

    @ApiModelProperty(required = true, value = "A unique ID of the account adhering to the standards for ID permanence")
    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
    public BankingAccount creationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    @ApiModelProperty(value = "Date that the account was created (if known)")
    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }
    public BankingAccount displayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    @ApiModelProperty(required = true, value = "The display name of the account as defined by the bank. This should not incorporate account numbers or PANs. If it does the values should be masked according to the rules of the MaskedAccountString common type.")
    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
    public BankingAccount isOwned(Boolean isOwned) {
        this.isOwned = isOwned;
        return this;
    }

    @ApiModelProperty(value = "Flag indicating that the customer associated with the authorisation is an owner of the account. Does not indicate sole ownership, however. If not present then 'true' is assumed")
    public Boolean getIsOwned() {
        return isOwned;
    }

    public void setIsOwned(Boolean isOwned) {
        this.isOwned = isOwned;
    }
    public BankingAccount maskedNumber(String maskedNumber) {
        this.maskedNumber = maskedNumber;
        return this;
    }

    @ApiModelProperty(required = true, value = "A masked version of the account. Whether BSB/Account Number, Credit Card PAN or another number")
    public String getMaskedNumber() {
        return maskedNumber;
    }

    public void setMaskedNumber(String maskedNumber) {
        this.maskedNumber = maskedNumber;
    }
    public BankingAccount nickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    @ApiModelProperty(value = "A customer supplied nick name for the account")
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public BankingAccount openStatus(OpenStatus openStatus) {
        this.openStatus = openStatus;
        return this;
    }

    @ApiModelProperty(value = "")
    public OpenStatus getOpenStatus() {
        return openStatus;
    }

    public void setOpenStatus(OpenStatus openStatus) {
        this.openStatus = openStatus;
    }
    public BankingAccount productCategory(BankingProductCategory productCategory) {
        this.productCategory = productCategory;
        return this;
    }

    @ApiModelProperty(required = true, value = "")
    public BankingProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(BankingProductCategory productCategory) {
        this.productCategory = productCategory;
    }
    public BankingAccount productName(String productName) {
        this.productName = productName;
        return this;
    }

    @ApiModelProperty(required = true, value = "The unique identifier of the account as defined by the account holder (akin to model number for the account)")
    public String getProductName() {
        return productName;
    }

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
        BankingAccount bankingAccount = (BankingAccount) o;
        return Objects.equals(this.accountId, bankingAccount.accountId) &&
            Objects.equals(this.creationDate, bankingAccount.creationDate) &&
            Objects.equals(this.displayName, bankingAccount.displayName) &&
            Objects.equals(this.isOwned, bankingAccount.isOwned) &&
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
            creationDate,
            displayName,
            isOwned,
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
            "   creationDate: " + toIndentedString(creationDate) + "\n" + 
            "   displayName: " + toIndentedString(displayName) + "\n" + 
            "   isOwned: " + toIndentedString(isOwned) + "\n" + 
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
