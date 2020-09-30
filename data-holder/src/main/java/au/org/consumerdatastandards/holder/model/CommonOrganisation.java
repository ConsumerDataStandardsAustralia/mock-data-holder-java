package au.org.consumerdatastandards.holder.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;
import java.time.LocalDate;
import java.time.OffsetDateTime;

@ApiModel
@Entity
@Table(name = "CommonOrganisation")
public class CommonOrganisation  {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @JsonIgnore
    private String id;

    /**
     * Australian Business Number for the organisation
     */
    private String abn;

    /**
     * Australian Company Number for the organisation. Required only if an ACN is applicable for the organisation type
     */
    private String acn;

    /**
     * The first name of the individual providing access on behalf of the organisation. For people with single names this field need not be present.  The single name should be in the lastName field
     */
    private String agentFirstName;

    /**
     * The last name of the individual providing access on behalf of the organisation. For people with single names the single name should be in this field
     */
    private String agentLastName;

    /**
     * The role of the individual identified as the agent who is providing authorisation.  Expected to be used for display.  Default to “Unspecified” if the role is not known
     */
    private String agentRole;

    /**
     * Name of the organisation
     */
    private String businessName;

    /**
     * The date the organisation described was established
     */
    private LocalDate establishmentDate;

    /**
     * A valid <a href="http://www.abs.gov.au/anzsic">ANZSIC</a> code for the organisation.
     * If the industry code held by the data holder is not one of the supported
     * <a href="http://www.abs.gov.au/anzsic">ANZSIC</a> versions, then it must not be supplied.
     */
    private String industryCode;

    /**
     * The applicable <a href="http://www.abs.gov.au/ANZSIC">ANZSIC</a> release version of the industry code provided.
     * Should only be supplied if industryCode is also supplied. If industryCode is supplied but industryCodeVersion
     * is absent, default is ANZSIC_1292.0_2006_V2.0
     */
    private IndustryCodeVersion industryCodeVersion;

    /**
     * True if registered with the ACNC.  False if not. Absent or null if not confirmed.
     */
    private Boolean isACNCRegistered;

    /**
     * The date and time that this record was last updated by the customer. If no update has occurred then this date should reflect the initial creation date for the data
     */
    private OffsetDateTime lastUpdateTime;

    /**
     * Legal name, if different to the business name
     */
    private String legalName;

    /**
     * Get organisationType
     */
    private OrganisationType organisationType;

    /**
     * Enumeration with values from [ISO 3166 Alpha-3](https://www.iso.org/iso-3166-country-codes.html) country codes.  Assumed to be AUS if absent
     */
    private String registeredCountry;

    /**
     * Short name used for communication, if  different to the business name
     */
    private String shortName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public CommonOrganisation abn(String abn) {
        this.abn = abn;
        return this;
    }

    @ApiModelProperty(value = "Australian Business Number for the organisation")
    public String getAbn() {
        return abn;
    }

    public void setAbn(String abn) {
        this.abn = abn;
    }
    public CommonOrganisation acn(String acn) {
        this.acn = acn;
        return this;
    }

    @ApiModelProperty(value = "Australian Company Number for the organisation. Required only if an ACN is applicable for the organisation type")
    public String getAcn() {
        return acn;
    }

    public void setAcn(String acn) {
        this.acn = acn;
    }
    public CommonOrganisation agentFirstName(String agentFirstName) {
        this.agentFirstName = agentFirstName;
        return this;
    }

    @ApiModelProperty(value = "The first name of the individual providing access on behalf of the organisation. For people with single names this field need not be present.  The single name should be in the lastName field")
    public String getAgentFirstName() {
        return agentFirstName;
    }

    public void setAgentFirstName(String agentFirstName) {
        this.agentFirstName = agentFirstName;
    }
    public CommonOrganisation agentLastName(String agentLastName) {
        this.agentLastName = agentLastName;
        return this;
    }

    @ApiModelProperty(required = true, value = "The last name of the individual providing access on behalf of the organisation. For people with single names the single name should be in this field")
    public String getAgentLastName() {
        return agentLastName;
    }

    public void setAgentLastName(String agentLastName) {
        this.agentLastName = agentLastName;
    }
    public CommonOrganisation agentRole(String agentRole) {
        this.agentRole = agentRole;
        return this;
    }

    @ApiModelProperty(required = true, value = "The role of the individual identified as the agent who is providing authorisation.  Expected to be used for display.  Default to “Unspecified” if the role is not known")
    public String getAgentRole() {
        return agentRole;
    }

    public void setAgentRole(String agentRole) {
        this.agentRole = agentRole;
    }
    public CommonOrganisation businessName(String businessName) {
        this.businessName = businessName;
        return this;
    }

    @ApiModelProperty(required = true, value = "Name of the organisation")
    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }
    public CommonOrganisation establishmentDate(LocalDate establishmentDate) {
        this.establishmentDate = establishmentDate;
        return this;
    }

    @ApiModelProperty(value = "The date the organisation described was established")
    public LocalDate getEstablishmentDate() {
        return establishmentDate;
    }

    public void setEstablishmentDate(LocalDate establishmentDate) {
        this.establishmentDate = establishmentDate;
    }
    public CommonOrganisation industryCode(String industryCode) {
        this.industryCode = industryCode;
        return this;
    }

    @ApiModelProperty(value = "A valid [ANZSIC](http://www.abs.gov.au/anzsic) code for the organisation. If the industry code held by the data holder is not one of the supported [ANZSIC](http://www.abs.gov.au/anzsic) versions, then it must not be supplied.")
    public String getIndustryCode() {
        return industryCode;
    }

    public void setIndustryCode(String industryCode) {
        this.industryCode = industryCode;
    }

    @ApiModelProperty(value = "The applicable [ANZSIC](http://www.abs.gov.au/ANZSIC) release version of the industry code provided. Should only be supplied if industryCode is also supplied. If industryCode is supplied but industryCodeVersion is absent, default is ANZSIC_1292.0_2006_V2.0")
    public IndustryCodeVersion getIndustryCodeVersion() {
        return industryCodeVersion;
    }

    public void setIndustryCodeVersion(IndustryCodeVersion industryCodeVersion) {
        this.industryCodeVersion = industryCodeVersion;
    }

    public CommonOrganisation isACNCRegistered(Boolean isACNCRegistered) {
        this.isACNCRegistered = isACNCRegistered;
        return this;
    }

    @ApiModelProperty(value = "True if registered with the ACNC.  False if not. Absent or null if not confirmed.")
    public Boolean getIsACNCRegistered() {
        return isACNCRegistered;
    }

    public void setIsACNCRegistered(Boolean isACNCRegistered) {
        this.isACNCRegistered = isACNCRegistered;
    }
    public CommonOrganisation lastUpdateTime(OffsetDateTime lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
        return this;
    }

    @ApiModelProperty(value = "The date and time that this record was last updated by the customer. If no update has occurred then this date should reflect the initial creation date for the data")
    public OffsetDateTime getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(OffsetDateTime lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }
    public CommonOrganisation legalName(String legalName) {
        this.legalName = legalName;
        return this;
    }

    @ApiModelProperty(value = "Legal name, if different to the business name")
    public String getLegalName() {
        return legalName;
    }

    public void setLegalName(String legalName) {
        this.legalName = legalName;
    }
    public CommonOrganisation organisationType(OrganisationType organisationType) {
        this.organisationType = organisationType;
        return this;
    }

    @ApiModelProperty(required = true)
    public OrganisationType getOrganisationType() {
        return organisationType;
    }

    public void setOrganisationType(OrganisationType organisationType) {
        this.organisationType = organisationType;
    }
    public CommonOrganisation registeredCountry(String registeredCountry) {
        this.registeredCountry = registeredCountry;
        return this;
    }

    @ApiModelProperty(value = "Enumeration with values from [ISO 3166 Alpha-3](https://www.iso.org/iso-3166-country-codes.html) country codes.  Assumed to be AUS if absent")
    public String getRegisteredCountry() {
        return registeredCountry;
    }

    public void setRegisteredCountry(String registeredCountry) {
        this.registeredCountry = registeredCountry;
    }
    public CommonOrganisation shortName(String shortName) {
        this.shortName = shortName;
        return this;
    }

    @ApiModelProperty(value = "Short name used for communication, if  different to the business name")
    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CommonOrganisation commonOrganisation = (CommonOrganisation) o;
        return Objects.equals(this.id, commonOrganisation.id) &&
            Objects.equals(this.abn, commonOrganisation.abn) &&
            Objects.equals(this.acn, commonOrganisation.acn) &&
            Objects.equals(this.agentFirstName, commonOrganisation.agentFirstName) &&
            Objects.equals(this.agentLastName, commonOrganisation.agentLastName) &&
            Objects.equals(this.agentRole, commonOrganisation.agentRole) &&
            Objects.equals(this.businessName, commonOrganisation.businessName) &&
            Objects.equals(this.establishmentDate, commonOrganisation.establishmentDate) &&
            Objects.equals(this.industryCode, commonOrganisation.industryCode) &&
            Objects.equals(this.industryCodeVersion, commonOrganisation.industryCodeVersion) &&
            Objects.equals(this.isACNCRegistered, commonOrganisation.isACNCRegistered) &&
            Objects.equals(this.lastUpdateTime, commonOrganisation.lastUpdateTime) &&
            Objects.equals(this.legalName, commonOrganisation.legalName) &&
            Objects.equals(this.organisationType, commonOrganisation.organisationType) &&
            Objects.equals(this.registeredCountry, commonOrganisation.registeredCountry) &&
            Objects.equals(this.shortName, commonOrganisation.shortName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            id,
            abn,
            acn,
            agentFirstName,
            agentLastName,
            agentRole,
            businessName,
            establishmentDate,
            industryCode,
            industryCodeVersion,
            isACNCRegistered,
            lastUpdateTime,
            legalName,
            organisationType,
            registeredCountry,
            shortName);
    }

    @Override
    public String toString() {
        return "class CommonOrganisation {\n" +
            "   id: " + toIndentedString(id) + "\n" +
            "   abn: " + toIndentedString(abn) + "\n" +
            "   acn: " + toIndentedString(acn) + "\n" +
            "   agentFirstName: " + toIndentedString(agentFirstName) + "\n" + 
            "   agentLastName: " + toIndentedString(agentLastName) + "\n" + 
            "   agentRole: " + toIndentedString(agentRole) + "\n" + 
            "   businessName: " + toIndentedString(businessName) + "\n" + 
            "   establishmentDate: " + toIndentedString(establishmentDate) + "\n" + 
            "   industryCode: " + toIndentedString(industryCode) + "\n" +
            "   industryCodeVersion: " + toIndentedString(industryCodeVersion) + "\n" +
            "   isACNCRegistered: " + toIndentedString(isACNCRegistered) + "\n" +
            "   lastUpdateTime: " + toIndentedString(lastUpdateTime) + "\n" + 
            "   legalName: " + toIndentedString(legalName) + "\n" + 
            "   organisationType: " + toIndentedString(organisationType) + "\n" + 
            "   registeredCountry: " + toIndentedString(registeredCountry) + "\n" + 
            "   shortName: " + toIndentedString(shortName) + "\n" + 
            "}";
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

    public enum OrganisationType {
        COMPANY,
        GOVERNMENT_ENTITY,
        PARTNERSHIP,
        SOLE_TRADER,
        TRUST,
        OTHER
    }

    public enum IndustryCodeVersion {
        ANZSIC_1292_0_2006_V2_0("ANZSIC_1292.0_2006_V2.0"),
        ANZSIC_1292_0_2006_V1_0("ANZSIC_1292.0_2006_V1.0");

        private final String value;

        IndustryCodeVersion(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }
    }
}
