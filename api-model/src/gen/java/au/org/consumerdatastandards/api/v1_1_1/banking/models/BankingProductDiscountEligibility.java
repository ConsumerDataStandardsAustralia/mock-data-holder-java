package au.org.consumerdatastandards.api.v1_1_1.banking.models;

import au.org.consumerdatastandards.support.data.*;

@DataDefinition
@CustomAttributes({
    @CustomAttribute(name = "x-conditional", value = "additionalValue", multiple = true)
})
public class BankingProductDiscountEligibility {

    public enum DiscountEligibilityType {
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
        INTRODUCTORY,
        OTHER
    }

    @Property(
        description = "The type of the specific eligibility constraint for a discount",
        required = true
    )
    DiscountEligibilityType discountEligibilityType;

    @Property(
        description = "Generic field containing additional information relevant to the [discountEligibilityType](#tocSproductdiscounteligibilitydoc) specified. Whether mandatory or not is dependent on the value of [discountEligibilityType](#tocSproductdiscounteligibilitydoc)"
    )
    String additionalValue;

    @Property(
        description = "Display text providing more information on this eligibility constraint"
    )
    String additionalInfo;

    @Property(
        description = "Link to a web page with more information on this eligibility constraint"
    )
    @CDSDataType(CustomDataType.URI)
    String additionalInfoUri;
}
