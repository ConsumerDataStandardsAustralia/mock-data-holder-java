package au.org.consumerdatastandards.api.banking.models;

import au.org.consumerdatastandards.support.data.*;

@DataDefinition
public class BankingAccount {

    public enum OpenStatus {
        OPEN,
        CLOSED
    }

    @Property(
        description = "A unique ID of the account adhering to the standards for ID permanence",
        required = true
    )
    @CDSDataType(CustomDataType.ASCII)
    String accountId;

    @Property(
        description = "Date that the account was created (if known)"
    )
    @CDSDataType(CustomDataType.Date)
    String creationDate;

    @Property(
        description = "The display name of the account as defined by the bank. This should not incorporate account numbers or PANs. If it does the values should be masked according to the rules of the MaskedAccountString common type.",
        required = true
    )
    String displayName;

    @Property(
        description = "A customer supplied nick name for the account"
    )
    String nickname;

    @Property(
        description = "Open or closed status for the account. If not present then OPEN is assumed"
    )
    OpenStatus openStatus = OpenStatus.OPEN;

    @Property(
        description = "Flag indicating that the customer associated with the authorisation is an owner of the account. Does not indicate sole ownership, however. If not present then 'true' is assumed"
    )
    @CDSDataType(CustomDataType.Boolean)
    Boolean isOwned = true;

    @Property(
        description = "A masked version of the account. Whether BSB/Account Number, Credit Card PAN or another number",
        required = true
    )
    @CDSDataType(CustomDataType.MaskedAccount)
    String maskedNumber;

    @Property(
        required = true
    )
    BankingProductCategory productCategory;

    @Property(
        description = "The unique identifier of the account as defined by the account provider (akin to model number for the account)",
        required = true
    )
    String productName;
}
