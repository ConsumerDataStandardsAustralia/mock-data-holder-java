package au.org.consumerdatastandards.holder.model.energy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * EnergyDerRecordDerDevices
 */
@Entity
public class EnergyDerRecordDerDevices {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @JsonIgnore
    private String id;

    private BigDecimal deviceIdentifier;

    private Integer count;

    private String manufacturer;

    private String modelNumber;

    /**
     * Code used to indicate the status of the device. This will be used to identify if an inverter is active or inactive or decommissioned
     */
    public enum StatusEnum {
        ACTIVE,
        INACTIVE,
        DECOMMISSIONED
    }

    private StatusEnum status;

    /**
     * Used to indicate the primary technology used in the DER device
     */
    public enum TypeEnum {
        FOSSIL,
        HYDRO,
        WIND,
        SOLAR_PV,
        RENEWABLE,
        GEOTHERMAL,
        STORAGE,
        OTHER
    }

    private TypeEnum type;

    private String subtype;

    private BigDecimal nominalRatedCapacity;

    private BigDecimal nominalStorageCapacity;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public EnergyDerRecordDerDevices count(Integer count) {
        this.count = count;
        return this;
    }

    /**
     * Number of devices in the group of DER devices
     *
     * @return count
     */
    @ApiModelProperty(required = true, value = "Number of devices in the group of DER devices")
    @NotNull
    @Valid
    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
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
     * Maximum output in kVA that is listed in the product specification by the manufacturer. This refers to the capacity of each unit within the device group. Default is 0 if value not known
     *
     * @return nominalRatedCapacity
     */
    @ApiModelProperty(required = true,
            value = "Maximum output in kVA that is listed in the product specification by the manufacturer. This refers to the capacity of each unit within the device group. Default is 0 if value not known")
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
     * Maximum storage capacity in kVAh. This refers to the capacity of each storage module within the device group. Mandatory if type is equal to “STORAGE”. Default is 0 if value not known
     *
     * @return nominalStorageCapacity
     */
    @ApiModelProperty(value = "Maximum storage capacity in kVAh. This refers to the capacity of each storage module within the device group. Mandatory if type is equal to “STORAGE”. Default is 0 if value not known")
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
