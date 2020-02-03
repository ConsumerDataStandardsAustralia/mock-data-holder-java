package au.org.consumerdatastandards.api.v1_1_1.banking.models;

import au.org.consumerdatastandards.support.data.*;

@DataDefinition
@CustomAttributes({
    @CustomAttribute(name = "x-conditional", value = "crn", multiple = true)
})
public class BankingBillerPayee {

    @Property(
        description = "BPAY Biller Code of the Biller",
        required = true
    )
    String billerCode;

    @Property(
        description = "BPAY CRN of the Biller. If the contents of the CRN match the format of a Credit Card PAN then it should be masked using the rules applicable for the MaskedPANString common type"
    )
    String crn;

    @Property(
        description = "Name of the Biller",
        required = true
    )
    String billerName;
}
