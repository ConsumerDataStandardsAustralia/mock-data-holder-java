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

    @Property(
        requiredIf = { @Condition(propertyName = "payeeAccountUType", values = {"account"}) },
        nullIf = { @Condition(propertyName = "payeeAccountUType", values = {"card", "payId"}) }
    )
    BankingDomesticPayeeAccount account;

    @Property(
        requiredIf = { @Condition(propertyName = "payeeAccountUType", values = {"card"}) },
        nullIf = { @Condition(propertyName = "payeeAccountUType", values = {"account", "payId"}) }
    )
    BankingDomesticPayeeCard card;

    @Property(
        requiredIf = { @Condition(propertyName = "payeeAccountUType", values = {"payId"}) },
        nullIf = { @Condition(propertyName = "payeeAccountUType", values = {"account", "card"}) }
    )
    BankingDomesticPayeePayId payId;
}
