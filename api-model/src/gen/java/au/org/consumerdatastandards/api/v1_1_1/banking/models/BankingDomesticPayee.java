package au.org.consumerdatastandards.api.v1_1_1.banking.models;

import au.org.consumerdatastandards.support.data.Condition;
import au.org.consumerdatastandards.support.data.CustomAttribute;
import au.org.consumerdatastandards.support.data.CustomAttributes;
import au.org.consumerdatastandards.support.data.DataDefinition;
import au.org.consumerdatastandards.support.data.Property;

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
        description = "Type of account object included. Valid values are: **account** A standard Australian account defined by BSB/Account Number. **card** A credit or charge card to pay to (note that PANs are masked). **payId** A PayID recognised by NPP",
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
