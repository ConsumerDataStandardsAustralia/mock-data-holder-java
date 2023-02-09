/*
 * Consumer Data Standards
 * Sample client library to Demonstrate the Consumer Data Right APIs
 */
package au.org.consumerdatastandards.client.model.banking;

import java.io.PrintWriter;
import java.util.Objects;

public class BankingAccountV2 extends BankingAccountV1 implements BankingAccount {

    public enum AccountOwnershipEnum {
        UNKNOWN,
        ONE_PARTY,
        TWO_PARTY,
        MANY_PARTY,
        OTHER
    }

    private AccountOwnershipEnum accountOwnership;

    public AccountOwnershipEnum getAccountOwnership() {
        return accountOwnership;
    }

    /**
     * Value indicating the number of customers that have ownership of the account, according to the data holder's definition of account ownership. Does not indicate that all account owners are eligible consumers
     * @param accountOwnership a value from <code>AccountOwnershipEnum</code>
     */
    public void setAccountOwnership(AccountOwnershipEnum accountOwnership) {
        this.accountOwnership = accountOwnership;
    }

    public boolean equals(Object o) {
        return super.equals(o) &&
                Objects.equals(this.accountOwnership, ((BankingAccountV2)o).accountOwnership);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), accountOwnership);
    }

    @Override
    protected void writeProperties(PrintWriter pw) {
        super.writeProperties(pw);
        pw.print("   accountOwnership: "); pw.println(toIndentedString(accountOwnership));
    }
}
