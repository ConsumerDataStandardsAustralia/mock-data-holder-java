package au.org.consumerdatastandards.holder.model.energy;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * EnergyDerRecordDerDevices
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen",
        date = "2022-01-11T14:03:27.755+11:00[Australia/Sydney]")
public class EnergyDerRecordDerDevices {
    @JsonProperty("deviceIdentifier")
    private BigDecimal deviceIdentifier;

    @JsonProperty("count")
    private BigDecimal count;

    @JsonProperty("manufacturer")
    private String manufacturer;

    @JsonProperty("modelNumber")
    private String modelNumber;

    /**
     * Code used to indicate the status of the device. This will be used to identify if an inverter is active or inactive or decommissioned
     */
    public enum StatusEnum {
        ACTIVE("ACTIVE"),

        INACTIVE("INACTIVE"),

        DECOMMISSIONED("DECOMMISSIONED");

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
     * Used to indicate the primary technology used in the DER device
     */
    public enum TypeEnum {
        FOSSIL("FOSSIL"),

        HYDRO("HYDRO"),

        WIND("WIND"),

        SOLAR_PV("SOLAR_PV"),

        RENEWABLE("RENEWABLE"),

        GEOTHERMAL("GEOTHERMAL"),

        STORAGE("STORAGE"),

        OTHER("OTHER");

        private String value;

        TypeEnum(String value) {
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
        public static TypeEnum fromValue(String value) {
            for (TypeEnum b : TypeEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    @JsonProperty("type")
    private TypeEnum type;

    @JsonProperty("subtype")
    private String subtype;

    @JsonProperty("nominalRatedCapacity")
    private BigDecimal nominalRatedCapacity;

    @JsonProperty("nominalStorageCapacity")
    private BigDecimal nominalStorageCapacity;

    public EnergyDerRecordDerDevices deviceIdentifier(BigDecimal deviceIdentifier) {
        this.deviceIdentifier = deviceIdentifier;
        return this;
    }

    /**
     * Unique identifier for a single DER device or a group of DER devices with the same attributes. Does not align with CDR ID permanence standards
     *
     * @return deviceIdentifier
     */
    @ApiModelProperty(required = true,
            value = "Unique identifier for a single DER device or a group of DER devices with the same attributes. Does not align with CDR ID permanence standards")
    @NotNull

    @Valid

    public BigDecimal getDeviceIdentifier() {
        return deviceIdentifier;
    }

    public void setDeviceIdentifier(BigDecimal deviceIdentifier) {
        this.deviceIdentifier = deviceIdentifier;
    }

    public EnergyDerRecordDerDevices count(BigDecimal count) {
        this.count = count;
        return this;
    }

    /**
     * Number of devices in the group of DER devices
     *
     * @return count
     */
    @ApiModelProperty(required = true,
            value = "Number of devices in the group of DER devices")
    @NotNull

    @Valid

    public BigDecimal getCount() {
        return count;
    }

    public void setCount(BigDecimal count) {
        this.count = count;
    }

    public EnergyDerRecordDerDevices manufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
        return this;
    }

    /**
     * The name of the device manufacturer. If absent then assumed to be “unknown”
     *
     * @return manufacturer
     */
    @ApiModelProperty(value = "The name of the device manufacturer. If absent then assumed to be “unknown”")


    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public EnergyDerRecordDerDevices modelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
        return this;
    }

    /**
     * The model number of the device. If absent then assumed to be “unknown”
     *
     * @return modelNumber
     */
    @ApiModelProperty(value = "The model number of the device. If absent then assumed to be “unknown”")


    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    public EnergyDerRecordDerDevices status(StatusEnum status) {
        this.status = status;
        return this;
    }

    /**
     * Code used to indicate the status of the device. This will be used to identify if an inverter is active or inactive or decommissioned
     *
     * @return status
     */
    @ApiModelProperty(value = "Code used to indicate the status of the device. This will be used to identify if an inverter is active or inactive or decommissioned")


    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public EnergyDerRecordDerDevices type(TypeEnum type) {
        this.type = type;
        return this;
    }

    /**
     * Used to indicate the primary technology used in the DER device
     *
     * @return type
     */
    @ApiModelProperty(required = true,
            value = "Used to indicate the primary technology used in the DER device")
    @NotNull


    public TypeEnum getType() {
        return type;
    }

    public void setType(TypeEnum type) {
        this.type = type;
    }

    public EnergyDerRecordDerDevices subtype(String subtype) {
        this.subtype = subtype;
        return this;
    }

    /**
     * Used to indicate the primary technology used in the DER device. This field is also used to record for example the battery chemistry, or the type of PV panel. It is also used to record if a battery is contained in an electric vehicle connected in a vehicle-to-grid arrangement. If absent then assumed to be “other”
     *
     * @return subtype
     */
    @ApiModelProperty(value = "Used to indicate the primary technology used in the DER device. This field is also used to record for example the battery chemistry, or the type of PV panel. It is also used to record if a battery is contained in an electric vehicle connected in a vehicle-to-grid arrangement. If absent then assumed to be “other”")


    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public EnergyDerRecordDerDevices nominalRatedCapacity(BigDecimal nominalRatedCapacity) {
        this.nominalRatedCapacity = nominalRatedCapacity;
        return this;
    }

    /**
     * Maximum output in kVA that is listed in the product specification by the manufacturer. This refers to the capacity of each unit within the device group
     *
     * @return nominalRatedCapacity
     */
    @ApiModelProperty(required = true,
            value = "Maximum output in kVA that is listed in the product specification by the manufacturer. This refers to the capacity of each unit within the device group")
    @NotNull

    @Valid

    public BigDecimal getNominalRatedCapacity() {
        return nominalRatedCapacity;
    }

    public void setNominalRatedCapacity(BigDecimal nominalRatedCapacity) {
        this.nominalRatedCapacity = nominalRatedCapacity;
    }

    public EnergyDerRecordDerDevices nominalStorageCapacity(BigDecimal nominalStorageCapacity) {
        this.nominalStorageCapacity = nominalStorageCapacity;
        return this;
    }

    /**
     * Maximum storage capacity in kVAh. This refers to the capacity of each storage module within the device group. Mandatory if type is equal to “STORAGE”
     *
     * @return nominalStorageCapacity
     */
    @ApiModelProperty(value = "Maximum storage capacity in kVAh. This refers to the capacity of each storage module within the device group. Mandatory if type is equal to “STORAGE”")

    @Valid

    public BigDecimal getNominalStorageCapacity() {
        return nominalStorageCapacity;
    }

    public void setNominalStorageCapacity(BigDecimal nominalStorageCapacity) {
        this.nominalStorageCapacity = nominalStorageCapacity;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EnergyDerRecordDerDevices energyDerRecordDerDevices = (EnergyDerRecordDerDevices) o;
        return Objects.equals(this.deviceIdentifier, energyDerRecordDerDevices.deviceIdentifier) &&
                Objects.equals(this.count, energyDerRecordDerDevices.count) &&
                Objects.equals(this.manufacturer, energyDerRecordDerDevices.manufacturer) &&
                Objects.equals(this.modelNumber, energyDerRecordDerDevices.modelNumber) &&
                Objects.equals(this.status, energyDerRecordDerDevices.status) &&
                Objects.equals(this.type, energyDerRecordDerDevices.type) &&
                Objects.equals(this.subtype, energyDerRecordDerDevices.subtype) &&
                Objects.equals(this.nominalRatedCapacity, energyDerRecordDerDevices.nominalRatedCapacity) &&
                Objects.equals(this.nominalStorageCapacity, energyDerRecordDerDevices.nominalStorageCapacity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deviceIdentifier, count, manufacturer, modelNumber, status, type, subtype, nominalRatedCapacity, nominalStorageCapacity);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyDerRecordDerDevices {\n");

        sb.append("    deviceIdentifier: ").append(toIndentedString(deviceIdentifier)).append("\n");
        sb.append("    count: ").append(toIndentedString(count)).append("\n");
        sb.append("    manufacturer: ").append(toIndentedString(manufacturer)).append("\n");
        sb.append("    modelNumber: ").append(toIndentedString(modelNumber)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    subtype: ").append(toIndentedString(subtype)).append("\n");
        sb.append("    nominalRatedCapacity: ").append(toIndentedString(nominalRatedCapacity)).append("\n");
        sb.append("    nominalStorageCapacity: ").append(toIndentedString(nominalStorageCapacity)).append("\n");
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

