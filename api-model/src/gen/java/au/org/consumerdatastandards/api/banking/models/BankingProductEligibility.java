package au.org.consumerdatastandards.api.banking.models;

import au.org.consumerdatastandards.support.data.*;

@DataDefinition(
    referenced = false
)
@CustomAttributes({
    @CustomAttribute(name = "x-conditional", value = "additionalValue", multiple = true),
    @CustomAttribute(name = "x-conditional", value = "additionalInfo", multiple = true)
})
public class BankingProductEligibility {

    public enum EligibilityType {
        BUSINESS,
        PENSION_RECIPIENT,
        MIN_AGE,
        MAX_AGE,
        MIN_INCOME,
        MIN_TURNOVER,
        STAFF,
        STUDENT,
        EMPLOYMENT_STATUS,
        RESIDENCY_STATUS,
        NATURAL_PERSON,
        OTHER
    }

    @Property(
        description = "The type of eligibility criteria described.  See the next section for an overview of valid values and their meaning",
        required = true
    )
    EligibilityType eligibilityType;

    @Property(
        description = "Generic field containing additional information relevant to the [eligibilityType](#tocSproducteligibilitytypedoc) specified.  Whether mandatory or not is dependent on the value of [eligibilityType](#tocSproducteligibilitytypedoc)",
        requiredIf = {
            @Condition(
                propertyName = "eligibilityType",
                values = {
                    "MIN_AGE",
                    "MAX_AGE",
                    "MIN_INCOME",
                    "MIN_TURNOVER",
                    "EMPLOYMENT_STATUS",
                    "RESIDENCY_STATUS"
                },
                conditionalCDSDataTypes = {
                    @ConditionalCDSDataType(value = "MIN_AGE", cdsDataType = @CDSDataType(CustomDataType.PositiveInteger)),
                    @ConditionalCDSDataType(value = "MAX_AGE", cdsDataType = @CDSDataType(CustomDataType.PositiveInteger)),
                    @ConditionalCDSDataType(value = "MIN_INCOME", cdsDataType = @CDSDataType(CustomDataType.Amount)),
                    @ConditionalCDSDataType(value = "MIN_TURNOVER", cdsDataType = @CDSDataType(CustomDataType.Amount))
                }
            )
        }
    )
    String additionalValue;

    @Property(
        description = "Display text providing more information on the eligibility criteria. Mandatory if the [eligibilityType](#tocSproducteligibilitytypedoc) field is set to OTHER",
        requiredIf = { @Condition(propertyName = "eligibilityType", values = {"OTHER"}) }
    )
    String additionalInfo;

    @Property(
        description = "Link to a web page with more information on this eligibility criteria"
    )
    @CDSDataType(CustomDataType.URI)
    String additionalInfoUri;
}
