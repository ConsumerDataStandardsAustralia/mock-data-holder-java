package au.org.consumerdatastandards.api.common.models;

import au.org.consumerdatastandards.support.data.*;

@DataDefinition(
    description = "Australian address formatted according to the file format defined by the [PAF file format](https://auspost.com.au/content/dam/auspost_corp/media/documents/australia-post-data-guide.pdf)"
)
public class CommonPAFAddress {

    @Property(
        description = "Unique identifier for an address as defined by Australia Post.  Also known as Delivery Point Identifier"
    )
    String dpid;

    @Property(
        description = "Thoroughfare number for a property (first number in a property ranged address)"
    )
    @CDSDataType(CustomDataType.PositiveInteger)
    Integer thoroughfareNumber1;

    @Property(
        description = "Suffix for the thoroughfare number. Only relevant is thoroughfareNumber1 is populated"
    )
    String thoroughfareNumber1Suffix;

    @Property(
        description = "Second thoroughfare number (only used if the property has a ranged address eg 23-25)"
    )
    @CDSDataType(CustomDataType.PositiveInteger)
    Integer thoroughfareNumber2;

    @Property(
        description = "Suffix for the second thoroughfare number. Only relevant is thoroughfareNumber2 is populated"
    )
    String thoroughfareNumber2Suffix;

    @Property(
        description = "Type of flat or unit for the address"
    )
    String flatUnitType;

    @Property(
        description = "Unit number (including suffix, if applicable)"
    )
    String flatUnitNumber;

    @Property(
        description = "Type of floor or level for the address"
    )
    String floorLevelType;

    @Property(
        description = "Floor or level number (including alpha characters)"
    )
    String floorLevelNumber;

    @Property(
        description = "Allotment number for the address"
    )
    String lotNumber;

    @Property(
        description = "Building/Property name 1"
    )
    String buildingName1;

    @Property(
        description = "Building/Property name 2"
    )
    String buildingName2;

    @Property(
        description = "The name of the street"
    )
    String streetName;

    @Property(
        description = "The street type. Valid enumeration defined by Australia Post PAF code file"
    )
    String streetType;

    @Property(
        description = "The street type suffix. Valid enumeration defined by Australia Post PAF code file"
    )
    String streetSuffix;

    @Property(
        description = "Postal delivery type. (eg. PO BOX). Valid enumeration defined by Australia Post PAF code file"
    )
    String postalDeliveryType;

    @Property(
        description = "Postal delivery number if the address is a postal delivery type"
    )
    @CDSDataType(CustomDataType.PositiveInteger)
    Integer postalDeliveryNumber;

    @Property(
        description = "Postal delivery number prefix related to the postal delivery number"
    )
    String postalDeliveryNumberPrefix;

    @Property(
        description = "Postal delivery number suffix related to the postal delivery number"
    )
    String postalDeliveryNumberSuffix;

    @Property(
        description = "Full name of locality",
        required = true
    )
    String localityName;

    @Property(
        description = "Postcode for the locality",
        required = true
    )
    String postcode;

    @Property(
        description = "State in which the address belongs. Valid enumeration defined by Australia Post PAF code file [State Type Abbreviation](https://auspost.com.au/content/dam/auspost_corp/media/documents/australia-post-data-guide.pdf). NSW, QLD, VIC, NT, WA, SA, TAS, ACT, AAT",
        required = true
    )
    String state;
}
