package au.org.consumerdatastandards.api.v1_1_1.common.models;

import au.org.consumerdatastandards.support.data.CDSDataType;
import au.org.consumerdatastandards.support.data.CustomDataType;
import au.org.consumerdatastandards.support.data.DataDefinition;
import au.org.consumerdatastandards.support.data.Property;

import java.time.LocalDate;
import java.time.OffsetDateTime;

@DataDefinition
public class CommonOrganisation {

    public enum OrganisationType {
        SOLE_TRADER,
        COMPANY,
        PARTNERSHIP,
        TRUST,
        GOVERNMENT_ENTITY,
        OTHER
    }

    @Property(
        description = "The date and time that this record was last updated by the customer. If no update has occurred then this date should reflect the initial creation date for the data"
    )
    @CDSDataType(CustomDataType.DateTime)
    OffsetDateTime lastUpdateTime;

    @Property(
        description = "The first name of the individual providing access on behalf of the organisation. For people with single names this field need not be present.  The single name should be in the lastName field"
    )
    String agentFirstName;

    @Property(
        description = "The last name of the individual providing access on behalf of the organisation. For people with single names the single name should be in this field",
        required = true
    )
    String agentLastName;

    @Property(
        description = "The role of the individual identified as the agent who is providing authorisation.  Expected to be used for display. Default to Unspecified if the role is not known",
        required = true
    )
    String agentRole;

    @Property(
        description = "Name of the organisation",
        required = true
    )
    String businessName;

    @Property(
        description = "Legal name, if different to the business name"
    )
    String legalName;

    @Property(
        description = "Short name used for communication, if different to the business name"
    )
    String shortName;

    @Property(
        description = "Australian Business Number for the organisation"
    )
    String abn;

    @Property(
        description = "Australian Company Number for the organisation. Required only if an ACN is applicable for the organisation type"
    )
    String acn;

    @Property(
        description = "True if registered with the ACNC.  False if not. Absent or null if not confirmed."
    )
    @CDSDataType(CustomDataType.Boolean)
    Boolean isACNCRegistered;

    @Property(
        description = "[ANZSIC (2006)](http://www.abs.gov.au/anzsic) code for the organisation."
    )
    String industryCode;

    @Property(
        description = "Legal organisation type",
        required = true
    )
    OrganisationType organisationType;

    @Property(
        description = "Enumeration with values from [ISO 3166 Alpha-3](https://www.iso.org/iso-3166-country-codes.html) country codes.  Assumed to be AUS if absent"
    )
    @CDSDataType(CustomDataType.ExternalRef)
    String registeredCountry;

    @Property(
        description = "The date the organisation described was established"
    )
    @CDSDataType(CustomDataType.Date)
    LocalDate establishmentDate;
}
