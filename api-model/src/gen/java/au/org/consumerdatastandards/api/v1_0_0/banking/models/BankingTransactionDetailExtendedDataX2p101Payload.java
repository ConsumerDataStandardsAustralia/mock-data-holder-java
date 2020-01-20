package au.org.consumerdatastandards.api.v1_0_0.banking.models;

import au.org.consumerdatastandards.support.data.*;

@DataDefinition(
    referenced = false
)
public class BankingTransactionDetailExtendedDataX2p101Payload {

    @Property(
        description = "An extended string description. Only present if specified by the extensionUType field",
        required = true
    )
    String extendedDescription;

    @Property(
        description = "An end to end ID for the payment created at initiation"
    )
    String endToEndId;

    @Property(
        description = "Purpose of the payment.  Format is defined by NPP standards for the x2p1.01 overlay service"
    )
    String purposeCode;
}
