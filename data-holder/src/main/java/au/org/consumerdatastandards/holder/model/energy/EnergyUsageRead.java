package au.org.consumerdatastandards.holder.model.energy;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * EnergyUsageRead
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen",
        date = "2022-01-11T14:03:27.755+11:00[Australia/Sydney]")
public class EnergyUsageRead {
    @JsonProperty("servicePointId")
    private String servicePointId;

    @JsonProperty("registerId")
    private String registerId;

    @JsonProperty("registerSuffix")
    private String registerSuffix;

    @JsonProperty("meterID")
    private String meterID;

    @JsonProperty("controlledLoad")
    private Boolean controlledLoad;

    @JsonProperty("readStartDate")
    private String readStartDate;

    @JsonProperty("readEndDate")
    private String readEndDate;

    @JsonProperty("unitOfMeasure")
    private String unitOfMeasure;

    /**
     * Specify the type of the meter read data
     */
    public enum ReadUTypeEnum {
        BASICREAD("basicRead"),

        INTERVALREAD("intervalRead");

        private String value;

        ReadUTypeEnum(String value) {
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
        public static ReadUTypeEnum fromValue(String value) {
            for (ReadUTypeEnum b : ReadUTypeEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    @JsonProperty("readUType")
    private ReadUTypeEnum readUType;

    @JsonProperty("basicRead")
    private EnergyUsageReadBasicRead basicRead;

    @JsonProperty("intervalRead")
    private EnergyUsageReadIntervalRead intervalRead;

    public EnergyUsageRead servicePointId(String servicePointId) {
        this.servicePointId = servicePointId;
        return this;
    }

    /**
     * Tokenised ID of the service point to be used for referring to the service point in the CDR API suite.  To be created in accordance with CDR ID permanence requirements
     *
     * @return servicePointId
     */
    @ApiModelProperty(required = true,
            value = "Tokenised ID of the service point to be used for referring to the service point in the CDR API suite.  To be created in accordance with CDR ID permanence requirements")
    @NotNull


    public String getServicePointId() {
        return servicePointId;
    }

    public void setServicePointId(String servicePointId) {
        this.servicePointId = servicePointId;
    }

    public EnergyUsageRead registerId(String registerId) {
        this.registerId = registerId;
        return this;
    }

    /**
     * Register ID of the meter register where the meter reads are obtained
     *
     * @return registerId
     */
    @ApiModelProperty(value = "Register ID of the meter register where the meter reads are obtained")


    public String getRegisterId() {
        return registerId;
    }

    public void setRegisterId(String registerId) {
        this.registerId = registerId;
    }

    public EnergyUsageRead registerSuffix(String registerSuffix) {
        this.registerSuffix = registerSuffix;
        return this;
    }

    /**
     * Register suffix of the meter register where the meter reads are obtained
     *
     * @return registerSuffix
     */
    @ApiModelProperty(required = true,
            value = "Register suffix of the meter register where the meter reads are obtained")
    @NotNull


    public String getRegisterSuffix() {
        return registerSuffix;
    }

    public void setRegisterSuffix(String registerSuffix) {
        this.registerSuffix = registerSuffix;
    }

    public EnergyUsageRead meterID(String meterID) {
        this.meterID = meterID;
        return this;
    }

    /**
     * Meter id/serial number as it appears in customer’s bill. ID permanence rules do not apply.
     *
     * @return meterID
     */
    @ApiModelProperty(value = "Meter id/serial number as it appears in customer’s bill. ID permanence rules do not apply.")


    public String getMeterID() {
        return meterID;
    }

    public void setMeterID(String meterID) {
        this.meterID = meterID;
    }

    public EnergyUsageRead controlledLoad(Boolean controlledLoad) {
        this.controlledLoad = controlledLoad;
        return this;
    }

    /**
     * Indicates whether the energy recorded by this register is created under a Controlled Load regime. ControlledLoad field will have 'No if register does not relate to a Controlled Load, “Yes” if register relates to a Controlled Load If absent the status is unknown.
     *
     * @return controlledLoad
     */
    @ApiModelProperty(value = "Indicates whether the energy recorded by this register is created under a Controlled Load regime. ControlledLoad field will have 'No if register does not relate to a Controlled Load, “Yes” if register relates to a Controlled Load If absent the status is unknown. ")


    public Boolean getControlledLoad() {
        return controlledLoad;
    }

    public void setControlledLoad(Boolean controlledLoad) {
        this.controlledLoad = controlledLoad;
    }

    public EnergyUsageRead readStartDate(String readStartDate) {
        this.readStartDate = readStartDate;
        return this;
    }

    /**
     * Date time when the meter reads start
     *
     * @return readStartDate
     */
    @ApiModelProperty(required = true,
            value = "Date time when the meter reads start")
    @NotNull


    public String getReadStartDate() {
        return readStartDate;
    }

    public void setReadStartDate(String readStartDate) {
        this.readStartDate = readStartDate;
    }

    public EnergyUsageRead readEndDate(String readEndDate) {
        this.readEndDate = readEndDate;
        return this;
    }

    /**
     * Date time when the meter reads end.  If absent then assumed to be equal to readStartDate.  In this case the entry represents data for a single date specified by readStartDate
     *
     * @return readEndDate
     */
    @ApiModelProperty(value = "Date time when the meter reads end.  If absent then assumed to be equal to readStartDate.  In this case the entry represents data for a single date specified by readStartDate")


    public String getReadEndDate() {
        return readEndDate;
    }

    public void setReadEndDate(String readEndDate) {
        this.readEndDate = readEndDate;
    }

    public EnergyUsageRead unitOfMeasure(String unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
        return this;
    }

    /**
     * Unit of measure of the meter reads. Refer to Appendix B of <a href='https://www.aemo.com.au/-/media/files/stakeholder_consultation/consultations/nem-consultations/2019/5ms-metering-package-2/final-determination/mdff-specification-nem12-nem13-v21-final-determination-clean.pdf?la=en&hash=03FCBA0D60E091DE00F2361AE76206EA'>MDFF Specification NEM12 NEM13 v2.1</a> for a list of possible values
     *
     * @return unitOfMeasure
     */
    @ApiModelProperty(value = "Unit of measure of the meter reads. Refer to Appendix B of <a href='https://www.aemo.com.au/-/media/files/stakeholder_consultation/consultations/nem-consultations/2019/5ms-metering-package-2/final-determination/mdff-specification-nem12-nem13-v21-final-determination-clean.pdf?la=en&hash=03FCBA0D60E091DE00F2361AE76206EA'>MDFF Specification NEM12 NEM13 v2.1</a> for a list of possible values")


    public String getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(String unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public EnergyUsageRead readUType(ReadUTypeEnum readUType) {
        this.readUType = readUType;
        return this;
    }

    /**
     * Specify the type of the meter read data
     *
     * @return readUType
     */
    @ApiModelProperty(required = true,
            value = "Specify the type of the meter read data")
    @NotNull


    public ReadUTypeEnum getReadUType() {
        return readUType;
    }

    public void setReadUType(ReadUTypeEnum readUType) {
        this.readUType = readUType;
    }

    public EnergyUsageRead basicRead(EnergyUsageReadBasicRead basicRead) {
        this.basicRead = basicRead;
        return this;
    }

    /**
     * Get basicRead
     *
     * @return basicRead
     */
    @ApiModelProperty(value = "")

    @Valid

    public EnergyUsageReadBasicRead getBasicRead() {
        return basicRead;
    }

    public void setBasicRead(EnergyUsageReadBasicRead basicRead) {
        this.basicRead = basicRead;
    }

    public EnergyUsageRead intervalRead(EnergyUsageReadIntervalRead intervalRead) {
        this.intervalRead = intervalRead;
        return this;
    }

    /**
     * Get intervalRead
     *
     * @return intervalRead
     */
    @ApiModelProperty(value = "")

    @Valid

    public EnergyUsageReadIntervalRead getIntervalRead() {
        return intervalRead;
    }

    public void setIntervalRead(EnergyUsageReadIntervalRead intervalRead) {
        this.intervalRead = intervalRead;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EnergyUsageRead energyUsageRead = (EnergyUsageRead) o;
        return Objects.equals(this.servicePointId, energyUsageRead.servicePointId) &&
                Objects.equals(this.registerId, energyUsageRead.registerId) &&
                Objects.equals(this.registerSuffix, energyUsageRead.registerSuffix) &&
                Objects.equals(this.meterID, energyUsageRead.meterID) &&
                Objects.equals(this.controlledLoad, energyUsageRead.controlledLoad) &&
                Objects.equals(this.readStartDate, energyUsageRead.readStartDate) &&
                Objects.equals(this.readEndDate, energyUsageRead.readEndDate) &&
                Objects.equals(this.unitOfMeasure, energyUsageRead.unitOfMeasure) &&
                Objects.equals(this.readUType, energyUsageRead.readUType) &&
                Objects.equals(this.basicRead, energyUsageRead.basicRead) &&
                Objects.equals(this.intervalRead, energyUsageRead.intervalRead);
    }

    @Override
    public int hashCode() {
        return Objects.hash(servicePointId, registerId, registerSuffix, meterID, controlledLoad, readStartDate, readEndDate, unitOfMeasure, readUType, basicRead, intervalRead);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyUsageRead {\n");

        sb.append("    servicePointId: ").append(toIndentedString(servicePointId)).append("\n");
        sb.append("    registerId: ").append(toIndentedString(registerId)).append("\n");
        sb.append("    registerSuffix: ").append(toIndentedString(registerSuffix)).append("\n");
        sb.append("    meterID: ").append(toIndentedString(meterID)).append("\n");
        sb.append("    controlledLoad: ").append(toIndentedString(controlledLoad)).append("\n");
        sb.append("    readStartDate: ").append(toIndentedString(readStartDate)).append("\n");
        sb.append("    readEndDate: ").append(toIndentedString(readEndDate)).append("\n");
        sb.append("    unitOfMeasure: ").append(toIndentedString(unitOfMeasure)).append("\n");
        sb.append("    readUType: ").append(toIndentedString(readUType)).append("\n");
        sb.append("    basicRead: ").append(toIndentedString(basicRead)).append("\n");
        sb.append("    intervalRead: ").append(toIndentedString(intervalRead)).append("\n");
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

