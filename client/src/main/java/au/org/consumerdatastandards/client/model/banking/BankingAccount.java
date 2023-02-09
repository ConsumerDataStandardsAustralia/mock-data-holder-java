package au.org.consumerdatastandards.client.model.banking;

import java.time.LocalDate;

public interface BankingAccount {
    /**
     * A unique ID of the account adhering to the standards for ID permanence
     * @return accountId
     */
    String getAccountId();

    void setAccountId(String accountId);

    /**
     * Date that the account was created (if known)
     * @return creationDate
     */
    LocalDate getCreationDate();

    void setCreationDate(LocalDate creationDate);

    /**
     * The display name of the account as defined by the bank. This should not incorporate account numbers or PANs. If it does the values should be masked according to the rules of the MaskedAccountString common type.
     * @return displayName
     */
    String getDisplayName();

    void setDisplayName(String displayName);

    /**
     * A customer supplied nick name for the account
     * @return nickname
     */
    String getNickname();

    void setNickname(String nickname);

    /**
     * Open or closed status for the account. If not present then OPEN is assumed
     * @return openStatus
     */
    OpenStatus getOpenStatus();

    void setOpenStatus(OpenStatus openStatus);

    /**
     * Flag indicating that the customer associated with the authorisation is an owner of the account. Does not indicate sole ownership, however. If not present then 'true' is assumed
     * @return isOwned
     */
    Boolean getIsOwned();

    void setIsOwned(Boolean isOwned);

    /**
     * A masked version of the account. Whether BSB/Account Number, Credit Card PAN or another number
     * @return maskedNumber
     */
    String getMaskedNumber();

    void setMaskedNumber(String maskedNumber);

    /**
     * Get productCategory
     * @return productCategory
     */
    BankingProductCategory getProductCategory();

    void setProductCategory(BankingProductCategory productCategory);

    /**
     * The unique identifier of the account as defined by the data holder (akin to model number for the account)
     * @return productName
     */
    String getProductName();

    void setProductName(String productName);

    public enum OpenStatus {
        OPEN,
        CLOSED
    }
}
