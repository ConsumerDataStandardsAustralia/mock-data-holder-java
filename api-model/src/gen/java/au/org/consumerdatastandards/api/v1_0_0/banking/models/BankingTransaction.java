package au.org.consumerdatastandards.api.v1_0_0.banking.models;

import au.org.consumerdatastandards.support.data.*;

@DataDefinition
@CustomAttributes({
    @CustomAttribute(name = "x-conditional", value = "transactionId", multiple = true),
    @CustomAttribute(name = "x-conditional", value = "postingDateTime", multiple = true)
})
public class BankingTransaction {

    public enum Type {
        FEE,
        INTEREST_CHARGED,
        INTEREST_PAID,
        TRANSFER_OUTGOING,
        TRANSFER_INCOMING,
        PAYMENT,
        DIRECT_DEBIT,
        OTHER
    }

    public enum Status {
        PENDING,
        POSTED
    }

    @Property(
        description = "ID of the account for which transactions are provided",
        required = true
    )
    @CDSDataType(CustomDataType.ASCII)
    String accountId;

    @Property(
        description = "A unique ID of the transaction adhering to the standards for ID permanence.  This is mandatory (through hashing if necessary) unless there are specific and justifiable technical reasons why a transaction cannot be uniquely identified for a particular account type"
    )
    @CDSDataType(CustomDataType.ASCII)
    String transactionId;

    @Property(
        description = "True if extended information is available using the transaction detail end point. False if extended data is not available",
        required = true
    )
    @CDSDataType(CustomDataType.Boolean)
    Boolean isDetailAvailable;

    @Property(
        description = "The type of the transaction",
        required = true
    )
    Type type;

    @Property(
        description = "Status of the transaction whether pending or posted. Note that there is currently no provision in the standards to guarantee the ability to correlate a pending transaction with an associated posted transaction",
        required = true
    )
    Status status;

    @Property(
        description = "The transaction description as applied by the financial institution",
        required = true
    )
    String description;

    @Property(
        description = "The time the transaction was posted. This field is Mandatory if the transaction has status POSTED.  This is the time that appears on a standard statement"
    )
    @CDSDataType(CustomDataType.DateTime)
    String postingDateTime;

    @Property(
        description = "Date and time at which assets become available to the account owner in case of a credit entry, or cease to be available to the account owner in case of a debit transaction entry"
    )
    @CDSDataType(CustomDataType.DateTime)
    String valueDateTime;

    @Property(
        description = "The time the transaction was executed by the originating customer, if available"
    )
    @CDSDataType(CustomDataType.DateTime)
    String executionDateTime;

    @Property(
        description = "The value of the transaction. Negative values mean money was outgoing from the account",
        required = true
    )
    @CDSDataType(CustomDataType.Amount)
    String amount;

    @Property(
        description = "The currency for the transaction amount. AUD assumed if not present"
    )
    @CDSDataType(CustomDataType.Currency)
    String currency;

    @Property(
        description = "The reference for the transaction provided by the originating institution. Empty string if no data provided",
        required = true
    )
    String reference;

    @Property(
        description = "Name of the merchant for an outgoing payment to a merchant"
    )
    String merchantName;

    @Property(
        description = "The merchant category code (or MCC) for an outgoing payment to a merchant"
    )
    String merchantCategoryCode;

    @Property(
        description = "BPAY Biller Code for the transaction (if available)"
    )
    String billerCode;

    @Property(
        description = "Name of the BPAY biller for the transaction (if available)"
    )
    String billerName;

    @Property(
        description = "BPAY CRN for the transaction (if available)"
    )
    String crn;

    @Property(
        description = "6 Digit APCA number for the initiating institution"
    )
    String apcaNumber;
}
