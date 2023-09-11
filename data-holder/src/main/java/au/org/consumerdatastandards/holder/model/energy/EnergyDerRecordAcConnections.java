package au.org.consumerdatastandards.holder.model.energy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * EnergyDerRecordAcConnections
 */
@Entity(name = "e_der_ac_connections")
public class EnergyDerRecordAcConnections {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @JsonIgnore
    private String id;

    private BigDecimal connectionIdentifier;

    private Integer count;

    /**
     * Indicates whether the DER device is connected via an inverter (and what category of inverter it is) or not (e.g. rotating machine). If absent, assume equipment type to be “OTHER”.
     */
    public enum EquipmentTypeEnum {
        INVERTER,
        OTHER
    }

    private EquipmentTypeEnum equipmentType;

    private String manufacturerName;

    private String inverterSeries;

    private String inverterModelNumber;

    private String commissioningDate;

    /**
     * Code used to indicate the status of the Inverter. This will be used to identify if an inverter is active or inactive or decommissioned
     */
    public enum StatusEnum {
        ACTIVE,
        INACTIVE,
        DECOMMISSIONED
    }

    private StatusEnum status;

    private BigDecimal inverterDeviceCapacity;

    @Valid
    @OneToMany(cascade = CascadeType.ALL)
    private List<EnergyDerRecordDerDevices> derDevices = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public EnergyDerRecordAcConnections connectionIdentifier(BigDecimal connectionIdentifier) {
        this.connectionIdentifier = connectionIdentifier;
        return this;
    }

    /**
     * AC Connection ID as defined in the DER register.  Does not align with CDR ID permanence standards
     *
     * @return connectionIdentifier
     */
    @ApiModelProperty(required = true,
            value = "AC Connection ID as defined in the DER register.  Does not align with CDR ID permanence standards")
    @NotNull
    @Valid
    public BigDecimal getConnectionIdentifier() {
        return connectionIdentifier;
    }

    public void setConnectionIdentifier(BigDecimal connectionIdentifier) {
        this.connectionIdentifier = connectionIdentifier;
    }

    public EnergyDerRecordAcConnections count(Integer count) {
        this.count = count;
        return this;
    }

    /**
     * Number of AC Connections in the group. For the suite of AC Connections to be considered as a group, all of the AC Connections included must have the same attributes
     *
     * @return count
     */
    @ApiModelProperty(required = true,
            value = "Number of AC Connections in the group. For the suite of AC Connections to be considered as a group, all of the AC Connections included must have the same attributes")
    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public EnergyDerRecordAcConnections equipmentType(EquipmentTypeEnum equipmentType) {
        this.equipmentType = equipmentType;
        return this;
    }

    /**
     * Indicates whether the DER device is connected via an inverter (and what category of inverter it is) or not (e.g. rotating machine). If absent, assume equipment type to be “OTHER”.
     *
     * @return equipmentType
     */
    @ApiModelProperty(value = "Indicates whether the DER device is connected via an inverter (and what category of inverter it is) or not (e.g. rotating machine). If absent, assume equipment type to be “OTHER”.")
    public EquipmentTypeEnum getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(EquipmentTypeEnum equipmentType) {
        this.equipmentType = equipmentType;
    }

    public EnergyDerRecordAcConnections manufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
        return this;
    }

    /**
     * The name of the inverter manufacturer. Mandatory if equipmentType is INVERTER
     *
     * @return manufacturerName
     */
    @ApiModelProperty(value = "The name of the inverter manufacturer. Mandatory if equipmentType is INVERTER")
    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public EnergyDerRecordAcConnections inverterSeries(String inverterSeries) {
        this.inverterSeries = inverterSeries;
        return this;
    }

    /**
     * The inverter series. Mandatory if equipmentType is INVERTER
     *
     * @return inverterSeries
     */
    @ApiModelProperty(value = "The inverter series. Mandatory if equipmentType is INVERTER")
    public String getInverterSeries() {
        return inverterSeries;
    }

    public void setInverterSeries(String inverterSeries) {
        this.inverterSeries = inverterSeries;
    }

    public EnergyDerRecordAcConnections inverterModelNumber(String inverterModelNumber) {
        this.inverterModelNumber = inverterModelNumber;
        return this;
    }

    /**
     * The inverter model number. Mandatory if equipmentType is INVERTER
     *
     * @return inverterModelNumber
     */
    @ApiModelProperty(value = "The inverter model number. Mandatory if equipmentType is INVERTER")
    public String getInverterModelNumber() {
        return inverterModelNumber;
    }

    public void setInverterModelNumber(String inverterModelNumber) {
        this.inverterModelNumber = inverterModelNumber;
    }

    public EnergyDerRecordAcConnections commissioningDate(String commissioningDate) {
        this.commissioningDate = commissioningDate;
        return this;
    }

    /**
     * The date that the DER installation is commissioned
     *
     * @return commissioningDate
     */
    @ApiModelProperty(required = true, value = "The date that the DER installation is commissioned")
    @NotNull
    public String getCommissioningDate() {
        return commissioningDate;
    }

    public void setCommissioningDate(String commissioningDate) {
        this.commissioningDate = commissioningDate;
    }

    public EnergyDerRecordAcConnections status(StatusEnum status) {
        this.status = status;
        return this;
    }

    /**
     * Code used to indicate the status of the Inverter. This will be used to identify if an inverter is active or inactive or decommissioned
     *
     * @return status
     */
    @ApiModelProperty(required = true,
            value = "Code used to indicate the status of the Inverter. This will be used to identify if an inverter is active or inactive or decommissioned")
    @NotNull
    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public EnergyDerRecordAcConnections inverterDeviceCapacity(BigDecimal inverterDeviceCapacity) {
        this.inverterDeviceCapacity = inverterDeviceCapacity;
        return this;
    }

    /**
     * The rated AC output power that is listed in the product specified by the manufacturer. Mandatory if equipmentType is INVERTER. Default is 0 if value not known
     *
     * @return inverterDeviceCapacity
     */
    @ApiModelProperty(value = "The rated AC output power that is listed in the product specified by the manufacturer. Mandatory if equipmentType is INVERTER. Default is 0 if value not known")
    @Valid
    public BigDecimal getInverterDeviceCapacity() {
        return inverterDeviceCapacity;
    }

    public void setInverterDeviceCapacity(BigDecimal inverterDeviceCapacity) {
        this.inverterDeviceCapacity = inverterDeviceCapacity;
    }

    public EnergyDerRecordAcConnections derDevices(List<EnergyDerRecordDerDevices> derDevices) {
        this.derDevices = derDevices;
        return this;
    }

    public EnergyDerRecordAcConnections addDerDevicesItem(EnergyDerRecordDerDevices derDevicesItem) {
        this.derDevices.add(derDevicesItem);
        return this;
    }

    /**
     * Get derDevices
     *
     * @return derDevices
     */
    @ApiModelProperty(required = true, value = "")
    @NotNull
    @Valid
    public List<EnergyDerRecordDerDevices> getDerDevices() {
        return derDevices;
    }

    public void setDerDevices(List<EnergyDerRecordDerDevices> derDevices) {
        this.derDevices = derDevices;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EnergyDerRecordAcConnections energyDerRecordAcConnections = (EnergyDerRecordAcConnections) o;
        return Objects.equals(this.connectionIdentifier, energyDerRecordAcConnections.connectionIdentifier) &&
                Objects.equals(this.count, energyDerRecordAcConnections.count) &&
                Objects.equals(this.equipmentType, energyDerRecordAcConnections.equipmentType) &&
                Objects.equals(this.manufacturerName, energyDerRecordAcConnections.manufacturerName) &&
                Objects.equals(this.inverterSeries, energyDerRecordAcConnections.inverterSeries) &&
                Objects.equals(this.inverterModelNumber, energyDerRecordAcConnections.inverterModelNumber) &&
                Objects.equals(this.commissioningDate, energyDerRecordAcConnections.commissioningDate) &&
                Objects.equals(this.status, energyDerRecordAcConnections.status) &&
                Objects.equals(this.inverterDeviceCapacity, energyDerRecordAcConnections.inverterDeviceCapacity) &&
                Objects.equals(this.derDevices, energyDerRecordAcConnections.derDevices);
    }

    @Override
    public int hashCode() {
        return Objects.hash(connectionIdentifier, count, equipmentType, manufacturerName, inverterSeries, inverterModelNumber, commissioningDate, status, inverterDeviceCapacity, derDevices);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyDerRecordAcConnections {\n");
        sb.append("    connectionIdentifier: ").append(toIndentedString(connectionIdentifier)).append("\n");
        sb.append("    count: ").append(toIndentedString(count)).append("\n");
        sb.append("    equipmentType: ").append(toIndentedString(equipmentType)).append("\n");
        sb.append("    manufacturerName: ").append(toIndentedString(manufacturerName)).append("\n");
        sb.append("    inverterSeries: ").append(toIndentedString(inverterSeries)).append("\n");
        sb.append("    inverterModelNumber: ").append(toIndentedString(inverterModelNumber)).append("\n");
        sb.append("    commissioningDate: ").append(toIndentedString(commissioningDate)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("    inverterDeviceCapacity: ").append(toIndentedString(inverterDeviceCapacity)).append("\n");
        sb.append("    derDevices: ").append(toIndentedString(derDevices)).append("\n");
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
