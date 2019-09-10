package au.org.consumerdatastandards.api.banking.models;

import au.org.consumerdatastandards.support.data.*;

@DataDefinition
@CustomAttributes({
    @CustomAttribute(name = "x-conditional", value = "account", multiple = true),
    @CustomAttribute(name = "x-conditional", value = "card", multiple = true),
    @CustomAttribute(name = "x-conditional", value = "payId", multiple = true)
})
public class BankingDomesticPayee {

    public enum PayeeAccountUType {
        account,
        card,
        payId
    }

    @Property(
        description = "Type of account object included. Valid values are: { payeeAccountUType - - account A standard Australian account defined by BSB/Account Number payId A PayID recognised by NPP",
        required = true
    )
    PayeeAccountUType payeeAccountUType;

    @Property
    BankingDomesticPayeeAccount account;

    @Property
    BankingDomesticPayeeCard card;

    @Property
    BankingDomesticPayeePayId payId;
}
