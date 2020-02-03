package au.org.consumerdatastandards.api.v1_0_0.banking.models;

import au.org.consumerdatastandards.support.data.*;

@DataDefinition
public class BankingDomesticPayeePayId {

    public enum Type {
        EMAIL,
        TELEPHONE,
        ABN,
        ORG_IDENTIFIER
    }

    @Property(
        description = "The name assigned to the PayID by the owner of the PayID"
    )
    String name;

    @Property(
        description = "The identifier of the PayID (dependent on type)",
        required = true
    )
    String identifier;

    @Property(
        description = "The type of the PayID",
        required = true
    )
    Type type;
}
