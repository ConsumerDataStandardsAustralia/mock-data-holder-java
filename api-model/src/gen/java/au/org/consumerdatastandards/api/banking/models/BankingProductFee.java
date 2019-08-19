package au.org.consumerdatastandards.api.banking.models;

import java.util.List;
import au.org.consumerdatastandards.support.data.*;

@DataDefinition(
    referenced = false,
    anyOf = { "amount", "balanceRate", "transactionRate", "accruedRate" }
)
@CustomAttributes({
    @CustomAttribute(name = "x-conditional", value = "additionalValue", multiple = true),
    @CustomAttribute(name = "x-conditional", value = "amount", multiple = true),
    @CustomAttribute(name = "x-conditional", value = "balanceRate", multiple = true),
    @CustomAttribute(name = "x-conditional", value = "transactionRate", multiple = true),
    @CustomAttribute(name = "x-conditional", value = "accruedRate", multiple = true)
})
public class BankingProductFee {

    public enum FeeType {
        PERIODIC,
        TRANSACTION,
        WITHDRAWAL,
        DEPOSIT,
        PAYMENT,
        PURCHASE,
        EVENT,
        UPFRONT,
        EXIT
    }

    @Property(
        description = "Name of the fee",
        required = true
    )
    String name;

    @Property(
        description = "The type of fee",
        required = true
    )
    FeeType feeType;

    @Property(
        description = "The amount charged for the fee. One of amount, balanceRate, transactionRate and accruedRate is mandatory"
    )
    @CDSDataType(CustomDataType.Amount)
    String amount;

    @Property(
        description = "A fee rate calculated based on a proportion of the balance. One of amount, balanceRate, transactionRate and accruedRate is mandatory"
    )
    @CDSDataType(CustomDataType.Rate)
    String balanceRate;

    @Property(
        description = "A fee rate calculated based on a proportion of a transaction. One of amount, balanceRate, transactionRate and accruedRate is mandatory"
    )
    @CDSDataType(CustomDataType.Rate)
    String transactionRate;

    @Property(
        description = "A fee rate calculated based on a proportion of the calculated interest accrued on the account. One of amount, balanceRate, transactionRate and accruedRate is mandatory"
    )
    @CDSDataType(CustomDataType.Rate)
    String accruedRate;

    @Property(
        description = "The indicative frequency with which the fee is calculated on the account. Only applies if balanceRate or accruedRate is also present. Formatted according to [ISO 8601 Durations](https://en.wikipedia.org/wiki/ISO_8601#Durations)"
    )
    @CDSDataType(CustomDataType.ExternalRef)
    String accrualFrequency;

    @Property(
        description = "The currency the fee will be charged in. Assumes AUD if absent"
    )
    @CDSDataType(CustomDataType.Currency)
    String currency;

    @Property(
        description = "Generic field containing additional information relevant to the feeType specified. Whether mandatory or not is dependent on the value of feeType",
        requiredIf = {
            @Condition(
                propertyName = "feeType",
                values = {"PERIODIC"},
                conditionalCDSDataTypes = {
                    @ConditionalCDSDataType(value = "PERIODIC", cdsDataType = @CDSDataType(CustomDataType.Duration))
                }
            )
        }
    )
    String additionalValue;

    @Property(
        description = "Display text providing more information on the fee"
    )
    String additionalInfo;

    @Property(
        description = "Link to a web page with more information on this fee"
    )
    @CDSDataType(CustomDataType.URI)
    String additionalInfoUri;

    @Property(
        description = "An optional list of discounts to this fee that may be available"
    )
    List<BankingProductDiscount> discounts;
}
