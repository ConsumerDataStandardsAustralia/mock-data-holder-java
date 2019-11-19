package au.org.consumerdatastandards.holder.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Objects;

@ApiModel
@Entity
@Table(name = "CommonOrganisation")
public class CommonOrganisationDetail {

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
     * [ANZSIC (2006)](http://www.abs.gov.au/anzsic) code for the organisation.
     */
    private String industryCode;

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
    private CommonOrganisation.OrganisationType organisationType;

    /**
     * Enumeration with values from [ISO 3166 Alpha-3](https://www.iso.org/iso-3166-country-codes.html) country codes.  Assumed to be AUS if absent
     */
    private String registeredCountry;

    /**
     * Short name used for communication, if  different to the business name
     */
    private String shortName;

    /**
     * Must contain at least one address. One and only one address may have the purpose of REGISTERED. Zero or one, and no more than one, record may have the purpose of MAIL. If zero then the REGISTERED address is to be used for mail
     */
    @OneToMany
    @JoinTable(
        name = "organisation_physical_addresses",
        joinColumns = @JoinColumn(name = "organisation_id"),
        inverseJoinColumns = @JoinColumn(name = "physical_address_id"))
    private List<CommonPhysicalAddressWithPurpose> physicalAddresses;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAbn() {
        return abn;
    }

    public void setAbn(String abn) {
        this.abn = abn;
    }

    public String getAcn() {
        return acn;
    }

    public void setAcn(String acn) {
        this.acn = acn;
    }

    public String getAgentFirstName() {
        return agentFirstName;
    }

    public void setAgentFirstName(String agentFirstName) {
        this.agentFirstName = agentFirstName;
    }

    public String getAgentLastName() {
        return agentLastName;
    }

    public void setAgentLastName(String agentLastName) {
        this.agentLastName = agentLastName;
    }

    public String getAgentRole() {
        return agentRole;
    }

    public void setAgentRole(String agentRole) {
        this.agentRole = agentRole;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public LocalDate getEstablishmentDate() {
        return establishmentDate;
    }

    public void setEstablishmentDate(LocalDate establishmentDate) {
        this.establishmentDate = establishmentDate;
    }

    public String getIndustryCode() {
        return industryCode;
    }

    public void setIndustryCode(String industryCode) {
        this.industryCode = industryCode;
    }

    public Boolean getIsACNCRegistered() {
        return isACNCRegistered;
    }

    public void setIsACNCRegistered(Boolean ACNCRegistered) {
        isACNCRegistered = ACNCRegistered;
    }

    public OffsetDateTime getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(OffsetDateTime lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getLegalName() {
        return legalName;
    }

    public void setLegalName(String legalName) {
        this.legalName = legalName;
    }

    public CommonOrganisation.OrganisationType getOrganisationType() {
        return organisationType;
    }

    public void setOrganisationType(CommonOrganisation.OrganisationType organisationType) {
        this.organisationType = organisationType;
    }

    public String getRegisteredCountry() {
        return registeredCountry;
    }

    public void setRegisteredCountry(String registeredCountry) {
        this.registeredCountry = registeredCountry;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public CommonOrganisationDetail abn(String abn) {
        this.abn = abn;
        return this;
    }

    public CommonOrganisationDetail acn(String acn) {
        this.acn = acn;
        return this;
    }

    public CommonOrganisationDetail agentFirstName(String agentFirstName) {
        this.agentFirstName = agentFirstName;
        return this;
    }

    public CommonOrganisationDetail agentLastName(String agentLastName) {
        this.agentLastName = agentLastName;
        return this;
    }

    public CommonOrganisationDetail agentRole(String agentRole) {
        this.agentRole = agentRole;
        return this;
    }

    public CommonOrganisationDetail businessName(String businessName) {
        this.businessName = businessName;
        return this;
    }

    public CommonOrganisationDetail establishmentDate(LocalDate establishmentDate) {
        this.establishmentDate = establishmentDate;
        return this;
    }

    public CommonOrganisationDetail industryCode(String industryCode) {
        this.industryCode = industryCode;
        return this;
    }

    public CommonOrganisationDetail isACNCRegistered(Boolean isACNCRegistered) {
        this.isACNCRegistered = isACNCRegistered;
        return this;
    }

    public CommonOrganisationDetail lastUpdateTime(OffsetDateTime lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
        return this;
    }

    public CommonOrganisationDetail legalName(String legalName) {
        this.legalName = legalName;
        return this;
    }

    public CommonOrganisationDetail organisationType(CommonOrganisation.OrganisationType organisationType) {
        this.organisationType = organisationType;
        return this;
    }

    public CommonOrganisationDetail registeredCountry(String registeredCountry) {
        this.registeredCountry = registeredCountry;
        return this;
    }

    public CommonOrganisationDetail shortName(String shortName) {
        this.shortName = shortName;
        return this;
    }

    public CommonOrganisationDetail physicalAddresses(List<CommonPhysicalAddressWithPurpose> physicalAddresses) {
        this.physicalAddresses = physicalAddresses;
        return this;
    }

    public CommonOrganisationDetail addItem(CommonPhysicalAddressWithPurpose physicalAddressesItem) {
        this.physicalAddresses.add(physicalAddressesItem);
        return this;
    }

    @ApiModelProperty(required = true, value = "Must contain at least one address. One and only one address may have the purpose of REGISTERED. Zero or one, and no more than one, record may have the purpose of MAIL. If zero then the REGISTERED address is to be used for mail")
    public List<CommonPhysicalAddressWithPurpose> getPhysicalAddresses() {
        return physicalAddresses;
    }

    public void setPhysicalAddresses(List<CommonPhysicalAddressWithPurpose> physicalAddresses) {
        this.physicalAddresses = physicalAddresses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CommonOrganisationDetail commonOrganisationDetail = (CommonOrganisationDetail) o;
        return Objects.equals(this.physicalAddresses, commonOrganisationDetail.physicalAddresses) &&
            super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            physicalAddresses,
            super.hashCode());
    }

    @Override
    public String toString() {
        return "class CommonOrganisationDetail {\n" +
            "   id: " + toIndentedString(id) + "\n" +
            "   abn: " + toIndentedString(getAbn()) + "\n" +
            "   acn: " + toIndentedString(getAcn()) + "\n" +
            "   agentFirstName: " + toIndentedString(getAgentFirstName()) + "\n" + 
            "   agentLastName: " + toIndentedString(getAgentLastName()) + "\n" + 
            "   agentRole: " + toIndentedString(getAgentRole()) + "\n" + 
            "   businessName: " + toIndentedString(getBusinessName()) + "\n" + 
            "   establishmentDate: " + toIndentedString(getEstablishmentDate()) + "\n" + 
            "   industryCode: " + toIndentedString(getIndustryCode()) + "\n" + 
            "   isACNCRegistered: " + toIndentedString(getIsACNCRegistered()) + "\n" + 
            "   lastUpdateTime: " + toIndentedString(getLastUpdateTime()) + "\n" + 
            "   legalName: " + toIndentedString(getLegalName()) + "\n" + 
            "   organisationType: " + toIndentedString(getOrganisationType()) + "\n" + 
            "   registeredCountry: " + toIndentedString(getRegisteredCountry()) + "\n" + 
            "   shortName: " + toIndentedString(getShortName()) + "\n" + 
            "   physicalAddresses: " + toIndentedString(physicalAddresses) + "\n" + 
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
}

