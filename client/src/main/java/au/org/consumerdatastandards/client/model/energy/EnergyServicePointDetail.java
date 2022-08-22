package au.org.consumerdatastandards.client.model.energy;

import au.org.consumerdatastandards.client.model.CommonPhysicalAddress;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * EnergyServicePointDetail
 */
public class EnergyServicePointDetail {
    private String servicePointId;

    private String nationalMeteringId;

    /**
     * The classification of the service point as defined in MSATS procedures
     */
    public enum ServicePointClassificationEnum {
        EXTERNAL_PROFILE,
        GENERATOR,
        LARGE,
        SMALL,
        WHOLESALE,
        NON_CONTEST_UNMETERED_LOAD,
        NON_REGISTERED_EMBEDDED_GENERATOR,
        DISTRIBUTION_WHOLESALE
    }

    private ServicePointClassificationEnum servicePointClassification;

    /**
     * Code used to indicate the status of the service point. Note the details for the enumeration values below:<ul><li>**ACTIVE** - An active, energised, service point</li><li>**DE_ENERGISED** - The service point exists but is deenergised</li><li>**EXTINCT** - The service point has been permanently decommissioned</li><li>**GREENFIELD** - Applies to a service point that has never been energised</li><li>**OFF_MARKET** - Applies when the service point is no longer settled in the NEM</li></ul>
     */
    public enum ServicePointStatusEnum {
        ACTIVE,
        DE_ENERGISED,
        EXTINCT,
        GREENFIELD,
        OFF_MARKET
    }

    private ServicePointStatusEnum servicePointStatus;

    /**
     * Jurisdiction code to which the service point belongs.This code defines the jurisdictional rules which apply to the service point. Note the details of enumeration values below:<ul><li>**ALL** - All Jurisdictions</li><li>**ACT** - Australian Capital Territory</li><li>**NEM** - National Electricity Market</li><li>**NSW** - New South Wales</li><li>**QLD** - Queensland</li><li>**SA** - South Australia</li><li>**TAS** - Tasmania</li><li>**VIC** - Victoria</li></ul>
     */
    public enum JurisdictionCodeEnum {
        ALL,
        ACT,
        NEM,
        NSW,
        QLD,
        SA,
        TAS,
        VIC
    }

    private JurisdictionCodeEnum jurisdictionCode;

    private Boolean isGenerator;

    private LocalDate validFromDate;

    private OffsetDateTime lastUpdateDateTime;

    private EnergyServicePointConsumerProfile consumerProfile;

    private EnergyServicePointDetailDistributionLossFactor distributionLossFactor;

    private List<EnergyServicePointDetailRelatedParticipants> relatedParticipants = new ArrayList<>();

    private CommonPhysicalAddress location;

    private EnergyServicePointDetailMeters meters;

    public EnergyServicePointDetail servicePointId(String servicePointId) {
        this.servicePointId = servicePointId;
        return this;
    }

    /**
     * The tokenised ID of the service point for use in the CDR APIs.  Created according to the CDR rules for ID permanence
     *
     * @return servicePointId
     */
    public String getServicePointId() {
        return servicePointId;
    }

    public void setServicePointId(String servicePointId) {
        this.servicePointId = servicePointId;
    }

    public EnergyServicePointDetail nationalMeteringId(String nationalMeteringId) {
        this.nationalMeteringId = nationalMeteringId;
        return this;
    }

    /**
     * The independent ID of the service point, known in the industry as the NMI
     *
     * @return nationalMeteringId
     */
    public String getNationalMeteringId() {
        return nationalMeteringId;
    }

    public void setNationalMeteringId(String nationalMeteringId) {
        this.nationalMeteringId = nationalMeteringId;
    }

    public EnergyServicePointDetail servicePointClassification(ServicePointClassificationEnum servicePointClassification) {
        this.servicePointClassification = servicePointClassification;
        return this;
    }

    /**
     * The classification of the service point as defined in MSATS procedures
     *
     * @return servicePointClassification
     */
    public ServicePointClassificationEnum getServicePointClassification() {
        return servicePointClassification;
    }

    public void setServicePointClassification(ServicePointClassificationEnum servicePointClassification) {
        this.servicePointClassification = servicePointClassification;
    }

    public EnergyServicePointDetail servicePointStatus(ServicePointStatusEnum servicePointStatus) {
        this.servicePointStatus = servicePointStatus;
        return this;
    }

    /**
     * Code used to indicate the status of the service point. Note the details for the enumeration values below:<ul><li>**ACTIVE** - An active, energised, service point</li><li>**DE_ENERGISED** - The service point exists but is deenergised</li><li>**EXTINCT** - The service point has been permanently decommissioned</li><li>**GREENFIELD** - Applies to a service point that has never been energised</li><li>**OFF_MARKET** - Applies when the service point is no longer settled in the NEM</li></ul>
     *
     * @return servicePointStatus
     */
    public ServicePointStatusEnum getServicePointStatus() {
        return servicePointStatus;
    }

    public void setServicePointStatus(ServicePointStatusEnum servicePointStatus) {
        this.servicePointStatus = servicePointStatus;
    }

    public EnergyServicePointDetail jurisdictionCode(JurisdictionCodeEnum jurisdictionCode) {
        this.jurisdictionCode = jurisdictionCode;
        return this;
    }

    /**
     * Jurisdiction code to which the service point belongs.This code defines the jurisdictional rules which apply to the service point. Note the details of enumeration values below:<ul><li>**ALL** - All Jurisdictions</li><li>**ACT** - Australian Capital Territory</li><li>**NEM** - National Electricity Market</li><li>**NSW** - New South Wales</li><li>**QLD** - Queensland</li><li>**SA** - South Australia</li><li>**TAS** - Tasmania</li><li>**VIC** - Victoria</li></ul>
     *
     * @return jurisdictionCode
     */
    public JurisdictionCodeEnum getJurisdictionCode() {
        return jurisdictionCode;
    }

    public void setJurisdictionCode(JurisdictionCodeEnum jurisdictionCode) {
        this.jurisdictionCode = jurisdictionCode;
    }

    public EnergyServicePointDetail isGenerator(Boolean isGenerator) {
        this.isGenerator = isGenerator;
        return this;
    }

    /**
     * This flag determines whether the energy at this connection point is to be treated as consumer load or as a generating unit(this may include generator auxiliary loads). If absent defaults to false. <br>**Note:** Only applicable for scheduled or semischeduled generators, does not indicate on site generation by consumer
     *
     * @return isGenerator
     */
    public Boolean getIsGenerator() {
        return isGenerator;
    }

    public void setIsGenerator(Boolean isGenerator) {
        this.isGenerator = isGenerator;
    }

    public EnergyServicePointDetail validFromDate(LocalDate validFromDate) {
        this.validFromDate = validFromDate;
        return this;
    }

    /**
     * The start date from which this service point first became valid
     *
     * @return validFromDate
     */
    public LocalDate getValidFromDate() {
        return validFromDate;
    }

    public void setValidFromDate(LocalDate validFromDate) {
        this.validFromDate = validFromDate;
    }

    public EnergyServicePointDetail lastUpdateDateTime(OffsetDateTime lastUpdateDateTime) {
        this.lastUpdateDateTime = lastUpdateDateTime;
        return this;
    }

    /**
     * The date and time that the information for this service point was modified
     *
     * @return lastUpdateDateTime
     */
    public OffsetDateTime getLastUpdateDateTime() {
        return lastUpdateDateTime;
    }

    public void setLastUpdateDateTime(OffsetDateTime lastUpdateDateTime) {
        this.lastUpdateDateTime = lastUpdateDateTime;
    }

    public EnergyServicePointDetail consumerProfile(EnergyServicePointConsumerProfile consumerProfile) {
        this.consumerProfile = consumerProfile;
        return this;
    }

    /**
     * Get consumerProfile
     *
     * @return consumerProfile
     */
    public EnergyServicePointConsumerProfile getConsumerProfile() {
        return consumerProfile;
    }

    public void setConsumerProfile(EnergyServicePointConsumerProfile consumerProfile) {
        this.consumerProfile = consumerProfile;
    }

    public EnergyServicePointDetail distributionLossFactor(EnergyServicePointDetailDistributionLossFactor distributionLossFactor) {
        this.distributionLossFactor = distributionLossFactor;
        return this;
    }

    /**
     * Get distributionLossFactor
     *
     * @return distributionLossFactor
     */
    public EnergyServicePointDetailDistributionLossFactor getDistributionLossFactor() {
        return distributionLossFactor;
    }

    public void setDistributionLossFactor(EnergyServicePointDetailDistributionLossFactor distributionLossFactor) {
        this.distributionLossFactor = distributionLossFactor;
    }

    public EnergyServicePointDetail relatedParticipants(List<EnergyServicePointDetailRelatedParticipants> relatedParticipants) {
        this.relatedParticipants = relatedParticipants;
        return this;
    }

    public EnergyServicePointDetail addRelatedParticipantsItem(EnergyServicePointDetailRelatedParticipants relatedParticipantsItem) {
        this.relatedParticipants.add(relatedParticipantsItem);
        return this;
    }

    /**
     * Get relatedParticipants
     *
     * @return relatedParticipants
     */
    public List<EnergyServicePointDetailRelatedParticipants> getRelatedParticipants() {
        return relatedParticipants;
    }

    public void setRelatedParticipants(List<EnergyServicePointDetailRelatedParticipants> relatedParticipants) {
        this.relatedParticipants = relatedParticipants;
    }

    public EnergyServicePointDetail location(CommonPhysicalAddress location) {
        this.location = location;
        return this;
    }

    /**
     * Get location
     *
     * @return location
     */
    public CommonPhysicalAddress getLocation() {
        return location;
    }

    public void setLocation(CommonPhysicalAddress location) {
        this.location = location;
    }

    public EnergyServicePointDetail meters(EnergyServicePointDetailMeters meters) {
        this.meters = meters;
        return this;
    }

    /**
     * The meters associated with the service point. This may be empty where there are no meters physically installed at the service point
     *
     * @return meters
     */
    public EnergyServicePointDetailMeters getMeters() {
        return meters;
    }

    public void setMeters(EnergyServicePointDetailMeters meters) {
        this.meters = meters;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EnergyServicePointDetail energyServicePointDetail = (EnergyServicePointDetail) o;
        return Objects.equals(this.servicePointId, energyServicePointDetail.servicePointId) &&
                Objects.equals(this.nationalMeteringId, energyServicePointDetail.nationalMeteringId) &&
                Objects.equals(this.servicePointClassification, energyServicePointDetail.servicePointClassification) &&
                Objects.equals(this.servicePointStatus, energyServicePointDetail.servicePointStatus) &&
                Objects.equals(this.jurisdictionCode, energyServicePointDetail.jurisdictionCode) &&
                Objects.equals(this.isGenerator, energyServicePointDetail.isGenerator) &&
                Objects.equals(this.validFromDate, energyServicePointDetail.validFromDate) &&
                Objects.equals(this.lastUpdateDateTime, energyServicePointDetail.lastUpdateDateTime) &&
                Objects.equals(this.consumerProfile, energyServicePointDetail.consumerProfile) &&
                Objects.equals(this.distributionLossFactor, energyServicePointDetail.distributionLossFactor) &&
                Objects.equals(this.relatedParticipants, energyServicePointDetail.relatedParticipants) &&
                Objects.equals(this.location, energyServicePointDetail.location) &&
                Objects.equals(this.meters, energyServicePointDetail.meters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(servicePointId, nationalMeteringId, servicePointClassification, servicePointStatus, jurisdictionCode, isGenerator, validFromDate, lastUpdateDateTime, consumerProfile, distributionLossFactor, relatedParticipants, location, meters);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyServicePointDetail {\n");
        sb.append("    servicePointId: ").append(toIndentedString(servicePointId)).append("\n");
        sb.append("    nationalMeteringId: ").append(toIndentedString(nationalMeteringId)).append("\n");
        sb.append("    servicePointClassification: ").append(toIndentedString(servicePointClassification)).append("\n");
        sb.append("    servicePointStatus: ").append(toIndentedString(servicePointStatus)).append("\n");
        sb.append("    jurisdictionCode: ").append(toIndentedString(jurisdictionCode)).append("\n");
        sb.append("    isGenerator: ").append(toIndentedString(isGenerator)).append("\n");
        sb.append("    validFromDate: ").append(toIndentedString(validFromDate)).append("\n");
        sb.append("    lastUpdateDateTime: ").append(toIndentedString(lastUpdateDateTime)).append("\n");
        sb.append("    consumerProfile: ").append(toIndentedString(consumerProfile)).append("\n");
        sb.append("    distributionLossFactor: ").append(toIndentedString(distributionLossFactor)).append("\n");
        sb.append("    relatedParticipants: ").append(toIndentedString(relatedParticipants)).append("\n");
        sb.append("    location: ").append(toIndentedString(location)).append("\n");
        sb.append("    meters: ").append(toIndentedString(meters)).append("\n");
        sb.append("}");
        return sb.toString();
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
