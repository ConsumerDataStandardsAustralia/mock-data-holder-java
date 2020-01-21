package au.org.consumerdatastandards.api.v1_1_1.banking.models;

import java.util.List;
import au.org.consumerdatastandards.support.data.*;

@DataDefinition
@CustomAttributes({
    @CustomAttribute(name = "x-conditional", value = "balanceRate", multiple = true),
    @CustomAttribute(name = "x-conditional", value = "transactionRate", multiple = true),
    @CustomAttribute(name = "x-conditional", value = "accruedRate", multiple = true),
    @CustomAttribute(name = "x-conditional", value = "feeRate", multiple = true),
    @CustomAttribute(name = "x-conditional", value = "additionalValue", multiple = true),
    @CustomAttribute(name = "x-conditional", value = "amount", multiple = true)
})
public class BankingProductDiscount {

    public enum DiscountType {
        BALANCE,
        DEPOSITS,
        PAYMENTS,
        FEE_CAP,
        ELIGIBILITY_ONLY
    }

    @Property(
        description = "Description of the discount",
        required = true
    )
    String description;

    @Property(
        description = "The type of discount. See the next section for an overview of valid values and their meaning",
        required = true
    )
    DiscountType discountType;

    @Property(
        description = "Value of the discount. When following properties include one of amount, balanceRate, transactionRate, accruedRate and feeRate is mandatory"
    )
    @CDSDataType(CustomDataType.Amount)
    String amount;

    @Property(
        description = "A discount rate calculated based on a proportion of the balance. Note that the currency of the fee discount is expected to be the same as the currency of the fee itself. One of amount, balanceRate, transactionRate, accruedRate and feeRate is mandatory. Unless noted in additionalInfo, assumes the application and calculation frequency are the same as the corresponding fee"
    )
    @CDSDataType(CustomDataType.Rate)
    String balanceRate;

    @Property(
        description = "A discount rate calculated based on a proportion of a transaction. Note that the currency of the fee discount is expected to be the same as the currency of the fee itself. One of amount, balanceRate, transactionRate, accruedRate and feeRate is mandatory"
    )
    @CDSDataType(CustomDataType.Rate)
    String transactionRate;

    @Property(
        description = "A discount rate calculated based on a proportion of the calculated interest accrued on the account. Note that the currency of the fee discount is expected to be the same as the currency of the fee itself. One of amount, balanceRate, transactionRate, accruedRate and feeRate is mandatory. Unless noted in additionalInfo, assumes the application and calculation frequency are the same as the corresponding fee"
    )
    @CDSDataType(CustomDataType.Rate)
    String accruedRate;

    @Property(
        description = "A discount rate calculated based on a proportion of the fee to which this discount is attached. Note that the currency of the fee discount is expected to be the same as the currency of the fee itself. One of amount, balanceRate, transactionRate, accruedRate and feeRate is mandatory. Unless noted in additionalInfo, assumes the application and calculation frequency are the same as the corresponding fee"
    )
    @CDSDataType(CustomDataType.Rate)
    String feeRate;

    @Property(
        description = "Generic field containing additional information relevant to the [discountType](#tocSproductdiscounttypedoc) specified. Whether mandatory or not is dependent on the value of [discountType](#tocSproductdiscounttypedoc)"
    )
    String additionalValue;

    @Property(
        description = "Display text providing more information on the discount"
    )
    String additionalInfo;

    @Property(
        description = "Link to a web page with more information on this discount"
    )
    @CDSDataType(CustomDataType.URI)
    String additionalInfoUri;

    @Property(
        description = "Eligibility constraints that apply to this discount"
    )
    List<BankingProductDiscountEligibility> eligibility;
}
