package au.org.consumerdatastandards.holder.model.banking;

import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDate;

public interface BankingAccount {
    @ApiModelProperty(required = true,
            value = "A unique ID of the account adhering to the standards for ID permanence")
    String getAccountId();

    void setAccountId(String accountId);

    String getUserId();

    void setUserId(String userId);

    @ApiModelProperty(value = "Date that the account was created (if known)")
    LocalDate getCreationDate();

    void setCreationDate(LocalDate creationDate);

    @ApiModelProperty(required = true,
            value = "The display name of the account as defined by the bank. This should not incorporate account numbers or PANs. If it does the values should be masked according to the rules of the MaskedAccountString common type.")
    String getDisplayName();

    void setDisplayName(String displayName);

    @ApiModelProperty(value = "Flag indicating that the customer associated with the authorisation is an owner of the account. Does not indicate sole ownership, however. If not present then 'true' is assumed")
    Boolean getIsOwned();

    void setIsOwned(Boolean isOwned);

    @ApiModelProperty(required = true,
            value = "A masked version of the account. Whether BSB/Account Number, Credit Card PAN or another number")
    String getMaskedNumber();

    void setMaskedNumber(String maskedNumber);

    @ApiModelProperty(value = "A customer supplied nick name for the account")
    String getNickname();

    void setNickname(String nickname);

    @ApiModelProperty
    OpenStatus getOpenStatus();

    void setOpenStatus(OpenStatus openStatus);

    @ApiModelProperty(required = true)
    BankingProductCategory getProductCategory();

    void setProductCategory(BankingProductCategory productCategory);

    @ApiModelProperty(required = true,
            value = "The unique identifier of the account as defined by the account holder (akin to model number for the account)")
    String getProductName();

    void setProductName(String productName);

    public enum OpenStatus {
        CLOSED,
        OPEN
    }

    public enum AccountOwnershipEnum {
        UNKNOWN,
        ONE_PARTY,
        TWO_PARTY,
        MANY_PARTY,
        OTHER
    }
}
