package au.org.consumerdatastandards.api.v1_1_1.banking.models;

import au.org.consumerdatastandards.support.data.*;

@DataDefinition(
    referenced = false
)
public class BankingTransactionDetailExtendedData {

    public enum ExtensionUType {
        x2p101Payload
    }

    public enum Service {
        X2P1_01("X2P1.01");

        private String value;

        Service(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    @Property(
        description = "Label of the originating payer. Mandatory for inbound payment"
    )
    String payer;

    @Property(
        description = "Label of the target PayID.  Mandatory for an outbound payment. The name assigned to the BSB/Account Number or PayID (by the owner of the PayID)"
    )
    String payee;

    @Property(
        description = "Optional extended data provided specific to transaction originated via NPP"
    )
    ExtensionUType extensionUType;

    @Property
    BankingTransactionDetailExtendedDataX2p101Payload x2p101Payload;

    @Property(
        description = "Identifier of the applicable overlay service. Valid values are: X2P1.01",
        required = true
    )
    Service service;
}
