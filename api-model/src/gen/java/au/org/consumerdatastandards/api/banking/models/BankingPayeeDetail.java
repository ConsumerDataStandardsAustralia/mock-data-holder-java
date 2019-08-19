package au.org.consumerdatastandards.api.banking.models;

import au.org.consumerdatastandards.support.data.*;

@DataDefinition(
    allOf = { BankingPayee.class },
    anyOf = { "domestic", "biller", "international" }
)
@CustomAttributes({
    @CustomAttribute(name = "x-conditional", value = "domestic", multiple = true),
    @CustomAttribute(name = "x-conditional", value = "biller", multiple = true),
    @CustomAttribute(name = "x-conditional", value = "international", multiple = true)
})
public class BankingPayeeDetail {

    public enum PayeeUType {
        DOMESTIC,
        BILLER,
        INTERNATIONAL
    }

    @Property(
        description = "Type of object included that describes the payee in detail",
        required = true
    )
    PayeeUType payeeUType;

    @Property
    BankingDomesticPayee domestic;

    @Property
    BankingBillerPayee biller;

    @Property
    BankingInternationalPayee international;
}
