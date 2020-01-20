package au.org.consumerdatastandards.api.v1_0_0.banking.models;

import java.util.List;
import au.org.consumerdatastandards.support.data.*;

@DataDefinition
public class BankingScheduledPayment {

    public enum Status {
        ACTIVE,
        SKIP,
        INACTIVE
    }

    @Property(
        description = "A unique ID of the scheduled payment adhering to the standards for ID permanence",
        required = true
    )
    @CDSDataType(CustomDataType.ASCII)
    String scheduledPaymentId;

    @Property(
        description = "The short display name of the payee as provided by the customer"
    )
    String nickname;

    @Property(
        description = "The reference for the transaction that will be used by the originating institution for the purposes of constructing a statement narrative on the payer’s account. Empty string if no data provided",
        required = true
    )
    String payerReference;

    @Property(
        description = "The reference for the transaction that will be provided by the originating institution. Empty string if no data provided",
        required = true
    )
    String payeeReference;

    @Property(
        description = "Indicates whether the schedule is currently active. The value SKIP is equivalent to ACTIVE except that the customer has requested the next normal occurrence to be skipped.",
        required = true
    )
    Status status;

    @Property(
        required = true
    )
    BankingScheduledPaymentFrom from;

    @Property(
        required = true
    )
    List<BankingScheduledPaymentSet> paymentSet;

    @Property(
        required = true
    )
    BankingScheduledPaymentRecurrence recurrence;
}
