package au.org.consumerdatastandards.holder.model.energy;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * EnergyServicePoint
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen",
        date = "2022-01-11T14:03:27.755+11:00[Australia/Sydney]")
public class EnergyServicePoint {
    @JsonProperty("servicePointId")
    private String servicePointId;

    @JsonProperty("nationalMeteringId")
    private String nationalMeteringId;

    /**
     * The classification of the service point as defined in MSATS procedures
     */
    public enum ServicePointClassificationEnum {
        EXTERNAL_PROFILE("EXTERNAL_PROFILE"),

        GENERATOR("GENERATOR"),

        LARGE("LARGE"),

        SMALL("SMALL"),

        WHOLESALE("WHOLESALE"),

        NON_CONTEST_UNMETERED_LOAD("NON_CONTEST_UNMETERED_LOAD"),

        NON_REGISTERED_EMBEDDED_GENERATOR("NON_REGISTERED_EMBEDDED_GENERATOR"),

        DISTRIBUTION_WHOLESALE("DISTRIBUTION_WHOLESALE");

        private String value;

        ServicePointClassificationEnum(String value) {
            this.value = value;
        }

        @JsonValue
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        @JsonCreator
        public static ServicePointClassificationEnum fromValue(String value) {
            for (ServicePointClassificationEnum b : ServicePointClassificationEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    @JsonProperty("servicePointClassification")
    private ServicePointClassificationEnum servicePointClassification;

    /**
     * Code used to indicate the status of the service point. Note the details for the enumeration values below:<ul><li>**ACTIVE** - An active, energised, service point</li><li>**DE_ENERGISED** - The service point exists but is deenergised</li><li>**EXTINCT** - The service point has been permanently decommissioned</li><li>**GREENFIELD** - Applies to a service point that has never been energised</li><li>**OFF_MARKET** - Applies when the service point is no longer settled in the NEM</li></ul>
     */
    public enum ServicePointStatusEnum {
        ACTIVE("ACTIVE"),

        DE_ENERGISED("DE_ENERGISED"),

        EXTINCT("EXTINCT"),

        GREENFIELD("GREENFIELD"),

        OFF_MARKET("OFF_MARKET");

        private String value;

        ServicePointStatusEnum(String value) {
            this.value = value;
        }

        @JsonValue
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        @JsonCreator
        public static ServicePointStatusEnum fromValue(String value) {
            for (ServicePointStatusEnum b : ServicePointStatusEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    @JsonProperty("servicePointStatus")
    private ServicePointStatusEnum servicePointStatus;

    /**
     * Jurisdiction code to which the service point belongs.This code defines the jurisdictional rules which apply to the service point. Note the details of enumeration values below:<ul><li>**ALL** - All Jurisdictions</li><li>**ACT** - Australian Capital Territory</li><li>**NEM** - National Electricity Market</li><li>**NSW** - New South Wales</li><li>**QLD** - Queensland</li><li>**SA** - South Australia</li><li>**TAS** - Tasmania</li><li>**VIC** - Victoria</li></ul>
     */
    public enum JurisdictionCodeEnum {
        ALL("ALL"),

        ACT("ACT"),

        NEM("NEM"),

        NSW("NSW"),

        QLD("QLD"),

        SA("SA"),

        TAS("TAS"),

        VIC("VIC");

        private String value;

        JurisdictionCodeEnum(String value) {
            this.value = value;
        }

        @JsonValue
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        @JsonCreator
        public static JurisdictionCodeEnum fromValue(String value) {
            for (JurisdictionCodeEnum b : JurisdictionCodeEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    @JsonProperty("jurisdictionCode")
    private JurisdictionCodeEnum jurisdictionCode;

    @JsonProperty("isGenerator")
    private Boolean isGenerator;

    @JsonProperty("validFromDate")
    private String validFromDate;

    @JsonProperty("lastUpdateDateTime")
    private String lastUpdateDateTime;

    @JsonProperty("consumerProfile")
    private EnergyServicePointConsumerProfile consumerProfile;

    public EnergyServicePoint servicePointId(String servicePointId) {
        this.servicePointId = servicePointId;
        return this;
    }

    /**
     * Tokenised ID of the service point to be used for referring to the service point in the CDR API suite. To be created in accordance with CDR ID permanence requirements
     *
     * @return servicePointId
     */
    @ApiModelProperty(required = true,
            value = "Tokenised ID of the service point to be used for referring to the service point in the CDR API suite. To be created in accordance with CDR ID permanence requirements")
    @NotNull


    public String getServicePointId() {
        return servicePointId;
    }

    public void setServicePointId(String servicePointId) {
        this.servicePointId = servicePointId;
    }

    public EnergyServicePoint nationalMeteringId(String nationalMeteringId) {
        this.nationalMeteringId = nationalMeteringId;
        return this;
    }

    /**
     * The independent ID of the service point, known in the industry as the NMI
     *
     * @return nationalMeteringId
     */
    @ApiModelProperty(required = true,
            value = "The independent ID of the service point, known in the industry as the NMI")
    @NotNull


    public String getNationalMeteringId() {
        return nationalMeteringId;
    }

    public void setNationalMeteringId(String nationalMeteringId) {
        this.nationalMeteringId = nationalMeteringId;
    }

    public EnergyServicePoint servicePointClassification(ServicePointClassificationEnum servicePointClassification) {
        this.servicePointClassification = servicePointClassification;
        return this;
    }

    /**
     * The classification of the service point as defined in MSATS procedures
     *
     * @return servicePointClassification
     */
    @ApiModelProperty(required = true,
            value = "The classification of the service point as defined in MSATS procedures")
    @NotNull


    public ServicePointClassificationEnum getServicePointClassification() {
        return servicePointClassification;
    }

    public void setServicePointClassification(ServicePointClassificationEnum servicePointClassification) {
        this.servicePointClassification = servicePointClassification;
    }

    public EnergyServicePoint servicePointStatus(ServicePointStatusEnum servicePointStatus) {
        this.servicePointStatus = servicePointStatus;
        return this;
    }

    /**
     * Code used to indicate the status of the service point. Note the details for the enumeration values below:<ul><li>**ACTIVE** - An active, energised, service point</li><li>**DE_ENERGISED** - The service point exists but is deenergised</li><li>**EXTINCT** - The service point has been permanently decommissioned</li><li>**GREENFIELD** - Applies to a service point that has never been energised</li><li>**OFF_MARKET** - Applies when the service point is no longer settled in the NEM</li></ul>
     *
     * @return servicePointStatus
     */
    @ApiModelProperty(required = true,
            value = "Code used to indicate the status of the service point. Note the details for the enumeration values below:<ul><li>**ACTIVE** - An active, energised, service point</li><li>**DE_ENERGISED** - The service point exists but is deenergised</li><li>**EXTINCT** - The service point has been permanently decommissioned</li><li>**GREENFIELD** - Applies to a service point that has never been energised</li><li>**OFF_MARKET** - Applies when the service point is no longer settled in the NEM</li></ul> ")
    @NotNull


    public ServicePointStatusEnum getServicePointStatus() {
        return servicePointStatus;
    }

    public void setServicePointStatus(ServicePointStatusEnum servicePointStatus) {
        this.servicePointStatus = servicePointStatus;
    }

    public EnergyServicePoint jurisdictionCode(JurisdictionCodeEnum jurisdictionCode) {
        this.jurisdictionCode = jurisdictionCode;
        return this;
    }

    /**
     * Jurisdiction code to which the service point belongs.This code defines the jurisdictional rules which apply to the service point. Note the details of enumeration values below:<ul><li>**ALL** - All Jurisdictions</li><li>**ACT** - Australian Capital Territory</li><li>**NEM** - National Electricity Market</li><li>**NSW** - New South Wales</li><li>**QLD** - Queensland</li><li>**SA** - South Australia</li><li>**TAS** - Tasmania</li><li>**VIC** - Victoria</li></ul>
     *
     * @return jurisdictionCode
     */
    @ApiModelProperty(required = true,
            value = "Jurisdiction code to which the service point belongs.This code defines the jurisdictional rules which apply to the service point. Note the details of enumeration values below:<ul><li>**ALL** - All Jurisdictions</li><li>**ACT** - Australian Capital Territory</li><li>**NEM** - National Electricity Market</li><li>**NSW** - New South Wales</li><li>**QLD** - Queensland</li><li>**SA** - South Australia</li><li>**TAS** - Tasmania</li><li>**VIC** - Victoria</li></ul>")
    @NotNull


    public JurisdictionCodeEnum getJurisdictionCode() {
        return jurisdictionCode;
    }

    public void setJurisdictionCode(JurisdictionCodeEnum jurisdictionCode) {
        this.jurisdictionCode = jurisdictionCode;
    }

    public EnergyServicePoint isGenerator(Boolean isGenerator) {
        this.isGenerator = isGenerator;
        return this;
    }

    /**
     * This flag determines whether the energy at this connection point is to be treated as consumer load or as a generating unit(this may include generator auxiliary loads). If absent defaults to false. <br>**Note:** Only applicable for scheduled or semischeduled generators, does not indicate on site generation by consumer
     *
     * @return isGenerator
     */
    @ApiModelProperty(value = "This flag determines whether the energy at this connection point is to be treated as consumer load or as a generating unit(this may include generator auxiliary loads). If absent defaults to false. <br>**Note:** Only applicable for scheduled or semischeduled generators, does not indicate on site generation by consumer")


    public Boolean getIsGenerator() {
        return isGenerator;
    }

    public void setIsGenerator(Boolean isGenerator) {
        this.isGenerator = isGenerator;
    }

    public EnergyServicePoint validFromDate(String validFromDate) {
        this.validFromDate = validFromDate;
        return this;
    }

    /**
     * The start date from which this service point first became valid
     *
     * @return validFromDate
     */
    @ApiModelProperty(required = true,
            value = "The start date from which this service point first became valid")
    @NotNull


    public String getValidFromDate() {
        return validFromDate;
    }

    public void setValidFromDate(String validFromDate) {
        this.validFromDate = validFromDate;
    }

    public EnergyServicePoint lastUpdateDateTime(String lastUpdateDateTime) {
        this.lastUpdateDateTime = lastUpdateDateTime;
        return this;
    }

    /**
     * The date and time that the information for this service point was modified
     *
     * @return lastUpdateDateTime
     */
    @ApiModelProperty(required = true,
            value = "The date and time that the information for this service point was modified")
    @NotNull


    public String getLastUpdateDateTime() {
        return lastUpdateDateTime;
    }

    public void setLastUpdateDateTime(String lastUpdateDateTime) {
        this.lastUpdateDateTime = lastUpdateDateTime;
    }

    public EnergyServicePoint consumerProfile(EnergyServicePointConsumerProfile consumerProfile) {
        this.consumerProfile = consumerProfile;
        return this;
    }

    /**
     * Get consumerProfile
     *
     * @return consumerProfile
     */
    @ApiModelProperty(value = "")

    @Valid

    public EnergyServicePointConsumerProfile getConsumerProfile() {
        return consumerProfile;
    }

    public void setConsumerProfile(EnergyServicePointConsumerProfile consumerProfile) {
        this.consumerProfile = consumerProfile;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EnergyServicePoint energyServicePoint = (EnergyServicePoint) o;
        return Objects.equals(this.servicePointId, energyServicePoint.servicePointId) &&
                Objects.equals(this.nationalMeteringId, energyServicePoint.nationalMeteringId) &&
                Objects.equals(this.servicePointClassification, energyServicePoint.servicePointClassification) &&
                Objects.equals(this.servicePointStatus, energyServicePoint.servicePointStatus) &&
                Objects.equals(this.jurisdictionCode, energyServicePoint.jurisdictionCode) &&
                Objects.equals(this.isGenerator, energyServicePoint.isGenerator) &&
                Objects.equals(this.validFromDate, energyServicePoint.validFromDate) &&
                Objects.equals(this.lastUpdateDateTime, energyServicePoint.lastUpdateDateTime) &&
                Objects.equals(this.consumerProfile, energyServicePoint.consumerProfile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(servicePointId, nationalMeteringId, servicePointClassification, servicePointStatus, jurisdictionCode, isGenerator, validFromDate, lastUpdateDateTime, consumerProfile);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyServicePoint {\n");

        sb.append("    servicePointId: ").append(toIndentedString(servicePointId)).append("\n");
        sb.append("    nationalMeteringId: ").append(toIndentedString(nationalMeteringId)).append("\n");
        sb.append("    servicePointClassification: ").append(toIndentedString(servicePointClassification)).append("\n");
        sb.append("    servicePointStatus: ").append(toIndentedString(servicePointStatus)).append("\n");
        sb.append("    jurisdictionCode: ").append(toIndentedString(jurisdictionCode)).append("\n");
        sb.append("    isGenerator: ").append(toIndentedString(isGenerator)).append("\n");
        sb.append("    validFromDate: ").append(toIndentedString(validFromDate)).append("\n");
        sb.append("    lastUpdateDateTime: ").append(toIndentedString(lastUpdateDateTime)).append("\n");
        sb.append("    consumerProfile: ").append(toIndentedString(consumerProfile)).append("\n");
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

