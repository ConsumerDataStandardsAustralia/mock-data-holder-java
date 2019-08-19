package au.org.consumerdatastandards.api.banking.models;

import au.org.consumerdatastandards.support.data.*;

@DataDefinition(
    referenced = false
)
public class BankingTransactionDetailExtendedData {

    public enum ExtensionUType {
        EXTENDEDDESCRIPTION
    }

    public enum Service {
        X2P1_01
    }

    @Property(
        description = "Label of the originating payer. Mandatory for inbound payment"
    )
    String payer;

    @Property(
        description = "Label of the target PayID.  Mandatory for an outbound payment"
    )
    String payee;

    @Property(
        description = "Optional extended data provided specific to transaction originated via NPP"
    )
    ExtensionUType extensionUType;

    @Property(
        description = "An extended string description. Only present if specified by the extensionUType field"
    )
    String extendedDescription;

    @Property(
        description = "Identifier of the applicable overlay service. Valid values are: X2P1.01",
        required = true
    )
    Service service;
}
