package au.org.consumerdatastandards.api.common.models;

import au.org.consumerdatastandards.support.data.*;

@DataDefinition
@CustomAttributes({
    @CustomAttribute(name = "x-conditional", value = "areaCode", multiple = true)
})
public class CommonPhoneNumber {

    public enum Purpose {
        MOBILE,
        HOME,
        WORK,
        OTHER,
        INTERNATIONAL,
        UNSPECIFIED
    }

    @Property(
        description = "May be true for one and only one entry to indicate the preferred phone number. Assumed to be 'false' if not present"
    )
    @CDSDataType(CustomDataType.Boolean)
    Boolean isPreferred;

    @Property(
        description = "The purpose of the number as specified by the customer",
        required = true
    )
    Purpose purpose;

    @Property(
        description = "If absent, assumed to be Australia (+61). The + should be included"
    )
    String countryCode;

    @Property(
        description = "Required for non Mobile Phones, if field is present and refers to Australian code - the leading 0 should be omitted."
    )
    String areaCode;

    @Property(
        description = "The actual phone number, with leading zeros as appropriate",
        required = true
    )
    String number;

    @Property(
        description = "An extension number (if applicable)"
    )
    String extension;

    @Property(
        description = "Fully formatted phone number with country code, area code, number and extension incorporated. Formatted according to section 5.1.4. of [RFC 3966](https://www.ietf.org/rfc/rfc3966.txt)",
        required = true
    )
    @CDSDataType(CustomDataType.ExternalRef)
    String fullNumber;
}
