package au.org.consumerdatastandards.holder.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Objects;

@ApiModel
@Entity
@Table(name = "CommonOrganisation")
public class CommonOrganisationDetail extends CommonOrganisation {

    /**
     * Must contain at least one address. One and only one address may have the purpose of REGISTERED. Zero or one, and no more than one, record may have the purpose of MAIL. If zero then the REGISTERED address is to be used for mail
     */
    @OneToMany
    @JoinTable(
        name = "organisation_physical_addresses",
        joinColumns = @JoinColumn(name = "organisation_id"),
        inverseJoinColumns = @JoinColumn(name = "physical_address_id"))
    private List<CommonPhysicalAddressWithPurpose> physicalAddresses;

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
}

