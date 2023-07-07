package au.org.consumerdatastandards.client.model.energy;

import java.time.LocalDate;

public interface EnergyAccount {

    enum OpenStatus {
        CLOSED,
        OPEN
    }

    /**
     * The ID of the account.  To be created in accordance with CDR ID permanence requirements
     *
     * @return accountId
     */
    String getAccountId();

    void setAccountId(String accountId);

    /**
     * Optional identifier of the account as defined by the data holder.  This must be the value presented on physical statements (if it exists) and must not be used for the value of accountId
     *
     * @return accountNumber
     */
    String getAccountNumber();

    void setAccountNumber(String accountNumber);

    /**
     * An optional display name for the account if one exists or can be derived.  The content of this field is at the discretion of the data holder
     *
     * @return displayName
     */
    String getDisplayName();

    void setDisplayName(String displayName);

    /**
     * The date that the account was created or opened
     *
     * @return creationDate
     */
    LocalDate getCreationDate();

    void setCreationDate(LocalDate creationDate);
}
