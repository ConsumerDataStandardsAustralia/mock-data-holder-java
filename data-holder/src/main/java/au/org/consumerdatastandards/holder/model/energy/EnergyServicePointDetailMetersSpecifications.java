package au.org.consumerdatastandards.holder.model.energy;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * Technical characteristics of the meter
 */
@ApiModel(description = "Technical characteristics of the meter")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen",
        date = "2022-01-11T14:03:27.755+11:00[Australia/Sydney]")
public class EnergyServicePointDetailMetersSpecifications {
    /**
     * A code to denote the status of the meter. Note the details of enumeration values below: <ul><li>**CURRENT** -Applies when a meter is current and not disconnected</li><li>**DISCONNECTED** - Applies when a meter is present but has been remotely disconnected</li></ul>
     */
    public enum StatusEnum {
        CURRENT("CURRENT"),

        DISCONNECTED("DISCONNECTED");

        private String value;

        StatusEnum(String value) {
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
        public static StatusEnum fromValue(String value) {
            for (StatusEnum b : StatusEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    @JsonProperty("status")
    private StatusEnum status;

    /**
     * The metering Installation type code indicates whether the metering installation has to be manually read. Note the details of enumeration values below: <ul><li>**BASIC** - Accumulation Meter – Type 6</li><li>**COMMS1** - Interval Meter with communications – Type 1</li><li>**COMMS2** - Interval Meter with communications – Type 2</li><li>**COMMS3** - Interval Meter with communications – Type 3</li><li>**COMMS4** - Interval Meter with communications – Type 4</li><li>**COMMS4C** - CT connected metering installation that meets the minimum services specifications</li><li>**COMMS4D** - Whole current metering installation that meets the minimum services specifications</li><li>**MRAM** - Small customer metering installation – Type 4A</li><li>**MRIM** - Manually Read Interval Meter – Type 5</li><li>**UMCP** - Unmetered Supply – Type 7</li><li>**VICAMI** - A relevant metering installation as defined in clause 9.9C of the NER</li><li>**NCONUML** - Non-contestable unmeter load - Introduced as part of Global Settlement</li></ul>
     */
    public enum InstallationTypeEnum {
        BASIC("BASIC"),

        COMMS1("COMMS1"),

        COMMS2("COMMS2"),

        COMMS3("COMMS3"),

        COMMS4("COMMS4"),

        COMMS4C("COMMS4C"),

        COMMS4D("COMMS4D"),

        MRAM("MRAM"),

        MRIM("MRIM"),

        PROF("PROF"),

        SAMPLE("SAMPLE"),

        UMCP("UMCP"),

        VICAMI("VICAMI"),

        NCOLNUML("NCOLNUML");

        private String value;

        InstallationTypeEnum(String value) {
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
        public static InstallationTypeEnum fromValue(String value) {
            for (InstallationTypeEnum b : InstallationTypeEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    @JsonProperty("installationType")
    private InstallationTypeEnum installationType;

    @JsonProperty("manufacturer")
    private String manufacturer;

    @JsonProperty("model")
    private String model;

    @JsonProperty("readType")
    private String readType;

    @JsonProperty("nextScheduledReadDate")
    private String nextScheduledReadDate;

    public EnergyServicePointDetailMetersSpecifications status(StatusEnum status) {
        this.status = status;
        return this;
    }

    /**
     * A code to denote the status of the meter. Note the details of enumeration values below: <ul><li>**CURRENT** -Applies when a meter is current and not disconnected</li><li>**DISCONNECTED** - Applies when a meter is present but has been remotely disconnected</li></ul>
     *
     * @return status
     */
    @ApiModelProperty(required = true,
            value = "A code to denote the status of the meter. Note the details of enumeration values below: <ul><li>**CURRENT** -Applies when a meter is current and not disconnected</li><li>**DISCONNECTED** - Applies when a meter is present but has been remotely disconnected</li></ul>")
    @NotNull


    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public EnergyServicePointDetailMetersSpecifications installationType(InstallationTypeEnum installationType) {
        this.installationType = installationType;
        return this;
    }

    /**
     * The metering Installation type code indicates whether the metering installation has to be manually read. Note the details of enumeration values below: <ul><li>**BASIC** - Accumulation Meter – Type 6</li><li>**COMMS1** - Interval Meter with communications – Type 1</li><li>**COMMS2** - Interval Meter with communications – Type 2</li><li>**COMMS3** - Interval Meter with communications – Type 3</li><li>**COMMS4** - Interval Meter with communications – Type 4</li><li>**COMMS4C** - CT connected metering installation that meets the minimum services specifications</li><li>**COMMS4D** - Whole current metering installation that meets the minimum services specifications</li><li>**MRAM** - Small customer metering installation – Type 4A</li><li>**MRIM** - Manually Read Interval Meter – Type 5</li><li>**UMCP** - Unmetered Supply – Type 7</li><li>**VICAMI** - A relevant metering installation as defined in clause 9.9C of the NER</li><li>**NCONUML** - Non-contestable unmeter load - Introduced as part of Global Settlement</li></ul>
     *
     * @return installationType
     */
    @ApiModelProperty(required = true,
            value = "The metering Installation type code indicates whether the metering installation has to be manually read. Note the details of enumeration values below: <ul><li>**BASIC** - Accumulation Meter – Type 6</li><li>**COMMS1** - Interval Meter with communications – Type 1</li><li>**COMMS2** - Interval Meter with communications – Type 2</li><li>**COMMS3** - Interval Meter with communications – Type 3</li><li>**COMMS4** - Interval Meter with communications – Type 4</li><li>**COMMS4C** - CT connected metering installation that meets the minimum services specifications</li><li>**COMMS4D** - Whole current metering installation that meets the minimum services specifications</li><li>**MRAM** - Small customer metering installation – Type 4A</li><li>**MRIM** - Manually Read Interval Meter – Type 5</li><li>**UMCP** - Unmetered Supply – Type 7</li><li>**VICAMI** - A relevant metering installation as defined in clause 9.9C of the NER</li><li>**NCONUML** - Non-contestable unmeter load - Introduced as part of Global Settlement</li></ul>")
    @NotNull


    public InstallationTypeEnum getInstallationType() {
        return installationType;
    }

    public void setInstallationType(InstallationTypeEnum installationType) {
        this.installationType = installationType;
    }

    public EnergyServicePointDetailMetersSpecifications manufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
        return this;
    }

    /**
     * Free text field to identify the manufacturer of the installed meter
     *
     * @return manufacturer
     */
    @ApiModelProperty(value = "Free text field to identify the manufacturer of the installed meter")


    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public EnergyServicePointDetailMetersSpecifications model(String model) {
        this.model = model;
        return this;
    }

    /**
     * Free text field to identify the meter manufacturer’s designation for the meter model
     *
     * @return model
     */
    @ApiModelProperty(value = "Free text field to identify the meter manufacturer’s designation for the meter model")


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public EnergyServicePointDetailMetersSpecifications readType(String readType) {
        this.readType = readType;
        return this;
    }

    /**
     * Code to denote the method and frequency of Meter Reading. The value is formatted as follows: <ul><li>First Character = Remote (R) or Manual (M)</li><li>Second Character = Mode: T = telephone W = wireless P = powerline I = infra-red G = galvanic V = visual </li><li>Third Character = Frequency of Scheduled Meter Readings: 1 = Twelve times per year 2 = Six times per year 3 = Four times per year D = Daily or weekly</li><li>Optional Fourth Character = to identify what interval length the meter is capable of reading. This includes five, 15 and 30 minute granularity as the following: A – 5 minute B – 15 minute C – 30 minute D – Cannot convert to 5 minute (i.e. due to metering installation de-energised) M - Manually Read Accumulation Meter</li></ul> For example, <ul><li>MV3 = Manual, Visual, Quarterly</li> <li>MV3M = Manual, Visual, Quarterly, Manually Read Accumulation Meter</li> <li>RWDC = Remote, Wireless, Daily, 30 minutes interval</li></ul>
     *
     * @return readType
     */
    @ApiModelProperty(value = "Code to denote the method and frequency of Meter Reading. The value is formatted as follows: <ul><li>First Character = Remote (R) or Manual (M)</li><li>Second Character = Mode: T = telephone W = wireless P = powerline I = infra-red G = galvanic V = visual </li><li>Third Character = Frequency of Scheduled Meter Readings: 1 = Twelve times per year 2 = Six times per year 3 = Four times per year D = Daily or weekly</li><li>Optional Fourth Character = to identify what interval length the meter is capable of reading. This includes five, 15 and 30 minute granularity as the following: A – 5 minute B – 15 minute C – 30 minute D – Cannot convert to 5 minute (i.e. due to metering installation de-energised) M - Manually Read Accumulation Meter</li></ul> For example, <ul><li>MV3 = Manual, Visual, Quarterly</li> <li>MV3M = Manual, Visual, Quarterly, Manually Read Accumulation Meter</li> <li>RWDC = Remote, Wireless, Daily, 30 minutes interval</li></ul>")


    public String getReadType() {
        return readType;
    }

    public void setReadType(String readType) {
        this.readType = readType;
    }

    public EnergyServicePointDetailMetersSpecifications nextScheduledReadDate(String nextScheduledReadDate) {
        this.nextScheduledReadDate = nextScheduledReadDate;
        return this;
    }

    /**
     * This date is the next scheduled meter read date (NSRD) if a manual Meter Reading is required
     *
     * @return nextScheduledReadDate
     */
    @ApiModelProperty(value = "This date is the next scheduled meter read date (NSRD) if a manual Meter Reading is required")


    public String getNextScheduledReadDate() {
        return nextScheduledReadDate;
    }

    public void setNextScheduledReadDate(String nextScheduledReadDate) {
        this.nextScheduledReadDate = nextScheduledReadDate;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EnergyServicePointDetailMetersSpecifications energyServicePointDetailMetersSpecifications = (EnergyServicePointDetailMetersSpecifications) o;
        return Objects.equals(this.status, energyServicePointDetailMetersSpecifications.status) &&
                Objects.equals(this.installationType, energyServicePointDetailMetersSpecifications.installationType) &&
                Objects.equals(this.manufacturer, energyServicePointDetailMetersSpecifications.manufacturer) &&
                Objects.equals(this.model, energyServicePointDetailMetersSpecifications.model) &&
                Objects.equals(this.readType, energyServicePointDetailMetersSpecifications.readType) &&
                Objects.equals(this.nextScheduledReadDate, energyServicePointDetailMetersSpecifications.nextScheduledReadDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, installationType, manufacturer, model, readType, nextScheduledReadDate);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyServicePointDetailMetersSpecifications {\n");

        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("    installationType: ").append(toIndentedString(installationType)).append("\n");
        sb.append("    manufacturer: ").append(toIndentedString(manufacturer)).append("\n");
        sb.append("    model: ").append(toIndentedString(model)).append("\n");
        sb.append("    readType: ").append(toIndentedString(readType)).append("\n");
        sb.append("    nextScheduledReadDate: ").append(toIndentedString(nextScheduledReadDate)).append("\n");
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

