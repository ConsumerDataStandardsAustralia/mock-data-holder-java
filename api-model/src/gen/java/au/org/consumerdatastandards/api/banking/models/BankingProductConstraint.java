package au.org.consumerdatastandards.api.banking.models;

import au.org.consumerdatastandards.support.data.*;

@DataDefinition
@CustomAttributes({
    @CustomAttribute(name = "x-conditional", value = "additionalValue", multiple = true)
})
public class BankingProductConstraint {

    public enum ConstraintType {
        MIN_BALANCE,
        MAX_BALANCE,
        OPENING_BALANCE,
        MAX_LIMIT,
        MIN_LIMIT
    }

    @Property(
        description = "The type of constraint described.  See the next section for an overview of valid values and their meaning",
        required = true
    )
    ConstraintType constraintType;

    @Property(
        description = "Generic field containing additional information relevant to the [constraintType](#tocSproductconstrainttypedoc) specified.  Whether mandatory or not is dependent on the value of [constraintType](#tocSproductconstrainttypedoc)",
        requiredIf = {
            @Condition(
                propertyName = "constraintType",
                values = {
                    "MIN_BALANCE",
                    "MAX_BALANCE",
                    "OPENING_BALANCE",
                    "MAX_LIMIT",
                    "MIN_LIMIT"
                },
                conditionalCDSDataTypes = {
                    @ConditionalCDSDataType(value = "MIN_BALANCE", cdsDataType = @CDSDataType(CustomDataType.Amount)),
                    @ConditionalCDSDataType(value = "MAX_BALANCE", cdsDataType = @CDSDataType(CustomDataType.Amount)),
                    @ConditionalCDSDataType(value = "OPENING_BALANCE", cdsDataType = @CDSDataType(CustomDataType.Amount)),
                    @ConditionalCDSDataType(value = "MAX_LIMIT", cdsDataType = @CDSDataType(CustomDataType.Amount)),
                    @ConditionalCDSDataType(value = "MIN_LIMIT", cdsDataType = @CDSDataType(CustomDataType.Amount))
                }
            )
        }
    )
    String additionalValue;

    @Property(
        description = "Display text providing more information the constraint"
    )
    String additionalInfo;

    @Property(
        description = "Link to a web page with more information on the constraint"
    )
    @CDSDataType(CustomDataType.URI)
    String additionalInfoUri;
}
