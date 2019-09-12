package au.org.consumerdatastandards.api.common.models;

import au.org.consumerdatastandards.support.data.*;

@DataDefinition
@CustomAttributes({
    @CustomAttribute(name = "x-conditional", value = "simple", multiple = true),
    @CustomAttribute(name = "x-conditional", value = "paf", multiple = true)
})
public class CommonPhysicalAddress {

    public enum AddressUType {
        simple,
        paf
    }

    @Property(
        description = "The type of address object present",
        required = true
    )
    AddressUType addressUType;

    @Property(
        requiredIf = { @Condition(propertyName = "addressUType", values = {"simple"}) }
    )
    CommonSimpleAddress simple;

    @Property(
        requiredIf = { @Condition(propertyName = "addressUType", values = {"paf"}) }
    )
    CommonPAFAddress paf;
}
