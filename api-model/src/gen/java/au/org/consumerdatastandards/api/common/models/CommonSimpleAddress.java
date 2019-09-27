package au.org.consumerdatastandards.api.common.models;

import au.org.consumerdatastandards.support.data.*;

@DataDefinition
@CustomAttributes({
    @CustomAttribute(name = "x-conditional", value = "postcode", multiple = true)
})
public class CommonSimpleAddress {

    @Property(
        description = "Name of the individual or business formatted for inclusion in an address used for physical mail"
    )
    String mailingName;

    @Property(
        description = "First line of the standard address object",
        required = true
    )
    String addressLine1;

    @Property(
        description = "Second line of the standard address object"
    )
    String addressLine2;

    @Property(
        description = "Third line of the standard address object"
    )
    String addressLine3;

    @Property(
        description = "Mandatory for Australian addresses"
    )
    String postcode;

    @Property(
        description = "Name of the city or locality",
        required = true
    )
    String city;

    @Property(
        description = "Free text if the country is not Australia. If country is Australia then must be one of the values defined by the [State Type Abbreviation](https://auspost.com.au/content/dam/auspost_corp/media/documents/australia-post-data-guide.pdf) in the PAF file format. NSW, QLD, VIC, NT, WA, SA, TAS, ACT, AAT",
        required = true
    )
    String state;

    @Property(
        description = "A valid [ISO 3166 Alpha-3](https://www.iso.org/iso-3166-country-codes.html) country code. Australia (AUS) is assumed if country is not present."
    )
    @CDSDataType(CustomDataType.ExternalRef)
    String country = "AUS";
}
