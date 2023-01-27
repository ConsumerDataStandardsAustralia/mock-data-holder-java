/*
 * Consumer Data Standards
 * Sample client library to Demonstrate the Consumer Data Right APIs
 */
package au.org.consumerdatastandards.client.model.banking;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.time.LocalDate;
import java.util.Objects;

public class BankingAccountV1 implements BankingAccount {

    private String accountId;

    private LocalDate creationDate;

    private String displayName;

    private String nickname;

    private OpenStatus openStatus = OpenStatus.OPEN;

    private Boolean isOwned = true;

    private String maskedNumber;

    private BankingProductCategory productCategory;

    private String productName;

    /**
     * A unique ID of the account adhering to the standards for ID permanence
     * @return accountId
     */
    @Override
    public String getAccountId() {
        return accountId;
    }

    @Override
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    /**
     * Date that the account was created (if known)
     * @return creationDate
     */
    @Override
    public LocalDate getCreationDate() {
        return creationDate;
    }

    @Override
    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * The display name of the account as defined by the bank. This should not incorporate account numbers or PANs. If it does the values should be masked according to the rules of the MaskedAccountString common type.
     * @return displayName
     */
    @Override
    public String getDisplayName() {
        return displayName;
    }

    @Override
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /**
     * A customer supplied nick name for the account
     * @return nickname
     */
    @Override
    public String getNickname() {
        return nickname;
    }

    @Override
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * Open or closed status for the account. If not present then OPEN is assumed
     * @return openStatus
     */
    @Override
    public OpenStatus getOpenStatus() {
        return openStatus;
    }

    @Override
    public void setOpenStatus(OpenStatus openStatus) {
        this.openStatus = openStatus;
    }

    /**
     * Flag indicating that the customer associated with the authorisation is an owner of the account. Does not indicate sole ownership, however. If not present then 'true' is assumed
     * @return isOwned
     */
    @Override
    public Boolean getIsOwned() {
        return isOwned;
    }

    @Override
    public void setIsOwned(Boolean isOwned) {
        this.isOwned = isOwned;
    }

    /**
     * A masked version of the account. Whether BSB/Account Number, Credit Card PAN or another number
     * @return maskedNumber
     */
    @Override
    public String getMaskedNumber() {
        return maskedNumber;
    }

    @Override
    public void setMaskedNumber(String maskedNumber) {
        this.maskedNumber = maskedNumber;
    }

    /**
     * Get productCategory
     * @return productCategory
     */
    @Override
    public BankingProductCategory getProductCategory() {
        return productCategory;
    }

    @Override
    public void setProductCategory(BankingProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    /**
     * The unique identifier of the account as defined by the data holder (akin to model number for the account)
     * @return productName
     */
    @Override
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
        BankingAccountV1 bankingAccount = (BankingAccountV1) o;
        return Objects.equals(this.accountId, bankingAccount.accountId) &&
            Objects.equals(this.creationDate, bankingAccount.creationDate) &&
            Objects.equals(this.displayName, bankingAccount.displayName) &&
            Objects.equals(this.nickname, bankingAccount.nickname) &&
            Objects.equals(this.openStatus, bankingAccount.openStatus) &&
            Objects.equals(this.isOwned, bankingAccount.isOwned) &&
            Objects.equals(this.maskedNumber, bankingAccount.maskedNumber) &&
            Objects.equals(this.productCategory, bankingAccount.productCategory) &&
            Objects.equals(this.productName, bankingAccount.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            accountId,
            creationDate,
            displayName,
            nickname,
            openStatus,
            isOwned,
            maskedNumber,
            productCategory,
            productName);
    }

    public String toString() {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        pw.print("class "); pw.print(getClass().getSimpleName()); pw.println(" {");
        writeProperties(pw);
        pw.print("}");
        return sw.toString();
    }

    protected void writeProperties(PrintWriter pw) {
        pw.print("   accountId: "); pw.println(toIndentedString(accountId));
        pw.print("   creationDate: "); pw.println(toIndentedString(creationDate));
        pw.print("   displayName: "); pw.println(toIndentedString(displayName));
        pw.print("   nickname: "); pw.println(toIndentedString(nickname));
        pw.print("   openStatus: "); pw.println(toIndentedString(openStatus));
        pw.print("   isOwned: "); pw.println(toIndentedString(isOwned));
        pw.print("   maskedNumber: "); pw.println(toIndentedString(maskedNumber));
        pw.print("   productCategory: "); pw.println(toIndentedString(productCategory));
        pw.print("   productName: "); pw.println(toIndentedString(productName));
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    protected String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
