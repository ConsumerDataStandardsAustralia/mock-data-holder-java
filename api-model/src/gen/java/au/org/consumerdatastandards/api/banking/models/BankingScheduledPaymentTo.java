package au.org.consumerdatastandards.api.banking.models;

import au.org.consumerdatastandards.support.data.*;

@DataDefinition(
    description = "Object containing details of the destination of the payment. Used to specify a variety of payment destination types"
)
@CustomAttributes({
    @CustomAttribute(name = "x-conditional", value = "accountId", multiple = true),
    @CustomAttribute(name = "x-conditional", value = "payeeId", multiple = true),
    @CustomAttribute(name = "x-conditional", value = "domestic", multiple = true),
    @CustomAttribute(name = "x-conditional", value = "biller", multiple = true),
    @CustomAttribute(name = "x-conditional", value = "international", multiple = true)
})
public class BankingScheduledPaymentTo {

    public enum ToUType {
        accountId,
        payeeId,
        domestic,
        biller,
        international
    }

    @Property(
        description = "The type of object provided that specifies the destination of the funds for the payment.",
        required = true
    )
    ToUType toUType;

    @Property(
        description = "Present if toUType is set to accountId. Indicates that the payment is to another account that is accessible under the current consent",
        requiredIf = { @Condition(propertyName = "toUType", values = {"accountId"}) }
    )
    @CDSDataType(CustomDataType.ASCII)
    String accountId;

    @Property(
        description = "Present if toUType is set to payeeId. Indicates that the payment is to registered payee that can be accessed using the payee end point. If the Bank Payees scope has not been consented to then a payeeId should not be provided and the full payee details should be provided instead",
        requiredIf = { @Condition(propertyName = "toUType", values = {"payeeId"}) }
    )
    @CDSDataType(CustomDataType.ASCII)
    String payeeId;

    @Property(
        requiredIf = { @Condition(propertyName = "toUType", values = {"domestic"}) },
        nullIf = { @Condition(propertyName = "toUType", values = {"biller", "international"}) }
    )
    BankingDomesticPayee domestic;

    @Property(
        requiredIf = { @Condition(propertyName = "toUType", values = {"biller"}) },
        nullIf = { @Condition(propertyName = "toUType", values = {"domestic", "international"}) }
    )
    BankingBillerPayee biller;

    @Property(
        requiredIf = { @Condition(propertyName = "toUType", values = {"international"}) },
        nullIf = { @Condition(propertyName = "toUType", values = {"domestic", "biller"}) }
    )
    BankingInternationalPayee international;
}
