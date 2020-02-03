package au.org.consumerdatastandards.api.v1_1_1.banking.models;

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
        description = "Generic field containing additional information relevant to the [constraintType](#tocSproductconstrainttypedoc) specified.  Whether mandatory or not is dependent on the value of [constraintType](#tocSproductconstrainttypedoc)"
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
