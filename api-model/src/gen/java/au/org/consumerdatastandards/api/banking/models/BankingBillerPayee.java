package au.org.consumerdatastandards.api.banking.models;

import au.org.consumerdatastandards.support.data.*;

@DataDefinition
@CustomAttributes({
    @CustomAttribute(name = "x-conditional", value = "crn", multiple = true)
})
public class BankingBillerPayee {

    @Property(
        description = "BPay Biller Code of the Biller",
        required = true
    )
    String billerCode;

    @Property(
        description = "BPay CRN of the Biller. If the contents of the CRN match the format of a Credit Card PAN then it should be masked using the rules applicable for the MaskedPANString common type"
    )
    String crn;

    @Property(
        description = "Name of the Biller",
        required = true
    )
    String billerName;
}
