package au.org.consumerdatastandards.api.v1_1_1.banking.models;

import au.org.consumerdatastandards.support.data.CDSDataType;
import au.org.consumerdatastandards.support.data.CustomAttribute;
import au.org.consumerdatastandards.support.data.CustomAttributes;
import au.org.consumerdatastandards.support.data.CustomDataType;
import au.org.consumerdatastandards.support.data.DataDefinition;
import au.org.consumerdatastandards.support.data.Property;

@DataDefinition(
    description = "The set of payment amounts and destination accounts for this payment accommodating multi-part payments. A single entry indicates a simple payment with one destination account. Must have at least one entry"
)
@CustomAttributes({
    @CustomAttribute(name = "x-conditional", value = "amount", multiple = true)
})
public class BankingScheduledPaymentSet {

    @Property(
        required = true
    )
    BankingScheduledPaymentTo to;

    @Property(
        description = "Flag indicating whether the amount of the payment is calculated based on the context of the event. For instance a payment to reduce the balance of a credit card to zero. If absent then false is assumed"
    )
    @CDSDataType(CustomDataType.Boolean)
    Boolean isAmountCalculated;

    @Property(
        description = "The amount of the next payment if known. Mandatory unless the isAmountCalculated field is set to true. Must be zero or positive if present"
    )
    @CDSDataType(CustomDataType.Amount)
    String amount;

    @Property(
        description = "The currency for the payment. AUD assumed if not present"
    )
    @CDSDataType(CustomDataType.Currency)
    String currency;
}
