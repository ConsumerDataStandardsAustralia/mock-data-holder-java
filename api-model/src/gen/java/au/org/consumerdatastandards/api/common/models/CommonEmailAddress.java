package au.org.consumerdatastandards.api.common.models;

import au.org.consumerdatastandards.support.data.*;

@DataDefinition
public class CommonEmailAddress {

    public enum Purpose {
        WORK,
        HOME,
        OTHER,
        UNSPECIFIED
    }

    @Property(
        description = "May be true for one and only one email record in the collection. Denotes the default email address"
    )
    @CDSDataType(CustomDataType.Boolean)
    Boolean isPreferred;

    @Property(
        description = "The purpose for the email, as specified by the customer (Enumeration)",
        required = true
    )
    Purpose purpose;

    @Property(
        description = "A correctly formatted email address, as defined by the addr_spec format in [RFC 5322](https://www.ietf.org/rfc/rfc5322.txt)",
        required = true
    )
    @CDSDataType(CustomDataType.ExternalRef)
    String address;
}
