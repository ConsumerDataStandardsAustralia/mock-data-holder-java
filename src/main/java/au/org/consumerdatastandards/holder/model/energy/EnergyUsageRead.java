package au.org.consumerdatastandards.holder.model.energy;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Objects;

/**
 * EnergyUsageRead
 */
@Entity
public class EnergyUsageRead {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @JsonIgnore
    private String id;

    private String servicePointId;

    private String registerId;

    private String registerSuffix;

    private String meterId;

    private Boolean controlledLoad;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDate readStartDate;   // "x-cds-type" : "DateString"

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDate readEndDate;   // "x-cds-type" : "DateString"


    private String unitOfMeasure;

    /**
     * Specify the type of the meter read data.
     */
    public enum ReadUTypeEnum {
        BASIC_READ("basicRead"),

        INTERVAL_READ("intervalRead");

        private final String value;

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

    private ReadUTypeEnum readUType;

    @OneToOne(cascade = CascadeType.ALL)
    private EnergyUsageReadBasicRead basicRead;

    @OneToOne(cascade = CascadeType.ALL)
    private EnergyUsageReadIntervalRead intervalRead;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public EnergyUsageRead servicePointId(String servicePointId) {
        this.servicePointId = servicePointId;
        return this;
    }

    /**
     * Tokenised ID of the service point to be used for referring to the service point in the CDR API suite. To be created in accordance with CDR ID permanence requirements.
     *
     * @return servicePointId
     */
    @ApiModelProperty(required = true,
            value = "Tokenised ID of the service point to be used for referring to the service point in the CDR API suite. To be created in accordance with CDR ID permanence requirements.")
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
     * Register ID of the meter register where the meter reads are obtained.
     *
     * @return registerId
     */
    @ApiModelProperty(value = "Register ID of the meter register where the meter reads are obtained.")
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
     * Register suffix of the meter register where the meter reads are obtained.
     *
     * @return registerSuffix
     */
    @ApiModelProperty(required = true, value = "Register suffix of the meter register where the meter reads are obtained.")
    @NotNull
    public String getRegisterSuffix() {
        return registerSuffix;
    }

    public void setRegisterSuffix(String registerSuffix) {
        this.registerSuffix = registerSuffix;
    }

    public EnergyUsageRead meterId(String meterId) {
        this.meterId = meterId;
        return this;
    }

    /**
     * Meter id/serial number as it appears in customer's bill. ID permanence rules do not apply.
     *
     * @return meterId
     */
    @ApiModelProperty(value = "Meter id/serial number as it appears in customer's bill. ID permanence rules do not apply.")
    public String getMeterId() {
        return meterId;
    }

    public void setMeterId(String meterId) {
        this.meterId = meterId;
    }

    public EnergyUsageRead controlledLoad(Boolean controlledLoad) {
        this.controlledLoad = controlledLoad;
        return this;
    }

    /**
     * Indicates whether the energy recorded by this register is created under a Controlled Load regime.
     *
     * @return controlledLoad
     */
    @ApiModelProperty(value = "Indicates whether the energy recorded by this register is created under a Controlled Load regime.")
    public Boolean getControlledLoad() {
        return controlledLoad;
    }

    public void setControlledLoad(Boolean controlledLoad) {
        this.controlledLoad = controlledLoad;
    }

    public EnergyUsageRead readStartDate(LocalDate readStartDate) {
        this.readStartDate = readStartDate;
        return this;
    }

    /**
     * Date when the meter reads start in AEST and assumed to start from 12:00am AEST.
     *
     * @return readStartDate
     */
    @ApiModelProperty(required = true, value = "Date when the meter reads start in AEST and assumed to start from 12:00am AEST.")
    @NotNull
    public LocalDate getReadStartDate() {
        return readStartDate;
    }

    public void setReadStartDate(LocalDate readStartDate) {
        this.readStartDate = readStartDate;
    }

    public EnergyUsageRead readEndDate(LocalDate readEndDate) {
        this.readEndDate = readEndDate;
        return this;
    }

    /**
     * Date when the meter reads end in AEST. If absent then assumed to be equal to _readStartDate_. In this case the entry represents data for a single date specified by _readStartDate_.
     *
     * @return readEndDate
     */
    @ApiModelProperty(value = "Date when the meter reads end in AEST. If absent then assumed to be equal to _readStartDate_. In this case the entry represents data for a single date specified by _readStartDate_.")
    public LocalDate getReadEndDate() {
        return readEndDate;
    }

    public void setReadEndDate(LocalDate readEndDate) {
        this.readEndDate = readEndDate;
    }

    public EnergyUsageRead unitOfMeasure(String unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
        return this;
    }

    /**
     * Unit of measure of the meter reads. Refer to Appendix B of <a href='https://www.aemo.com.au/-/media/files/stakeholder_consultation/consultations/nem-consultations/2019/5ms-metering-package-2/final-determination/mdff-specification-nem12-nem13-v21-final-determination-clean.pdf?la=en&hash=03FCBA0D60E091DE00F2361AE76206EA'>MDFF Specification NEM12 NEM13 v2.1</a> for a list of possible values.
     *
     * @return unitOfMeasure
     */
    @ApiModelProperty(value = "Unit of measure of the meter reads. Refer to Appendix B of <a href='https://www.aemo.com.au/-/media/files/stakeholder_consultation/consultations/nem-consultations/2019/5ms-metering-package-2/final-determination/mdff-specification-nem12-nem13-v21-final-determination-clean.pdf?la=en&hash=03FCBA0D60E091DE00F2361AE76206EA'>MDFF Specification NEM12 NEM13 v2.1</a> for a list of possible values.")
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
     * Specify the type of the meter read data.
     *
     * @return readUType
     */
    @ApiModelProperty(required = true, value = "Specify the type of the meter read data.")
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
                Objects.equals(this.meterId, energyUsageRead.meterId) &&
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
        return Objects.hash(servicePointId, registerId, registerSuffix, meterId, controlledLoad, readStartDate, readEndDate, unitOfMeasure, readUType, basicRead, intervalRead);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyUsageRead {\n");
        sb.append("    servicePointId: ").append(toIndentedString(servicePointId)).append("\n");
        sb.append("    registerId: ").append(toIndentedString(registerId)).append("\n");
        sb.append("    registerSuffix: ").append(toIndentedString(registerSuffix)).append("\n");
        sb.append("    meterId: ").append(toIndentedString(meterId)).append("\n");
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
