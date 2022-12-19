package au.org.consumerdatastandards.client.model.energy;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * EnergyDerRecord
 */
public class EnergyDerRecord {
    private String servicePointId;

    private BigDecimal approvedCapacity;

    private int availablePhasesCount;

    private int installedPhasesCount;

    private boolean islandableInstallation;

    private Boolean hasCentralProtectionControl = false;

    private EnergyDerRecordProtectionMode protectionMode;

    private List<EnergyDerRecordAcConnections> acConnections = new ArrayList<>();

    public EnergyDerRecord servicePointId(String servicePointId) {
        this.servicePointId = servicePointId;
        return this;
    }

    /**
     * Tokenised ID of the service point to be used for referring to the service point in the CDR API suite.  To be created in accordance with CDR ID permanence requirements
     *
     * @return servicePointId
     */
    public String getServicePointId() {
        return servicePointId;
    }

    public void setServicePointId(String servicePointId) {
        this.servicePointId = servicePointId;
    }

    public EnergyDerRecord approvedCapacity(BigDecimal approvedCapacity) {
        this.approvedCapacity = approvedCapacity;
        return this;
    }

    /**
     * Approved small generating unit capacity as agreed with NSP in the connection agreement, expressed in kVA. Value of 0 indicates no DER record exists for the given servicePointId
     *
     * @return approvedCapacity
     */
    public BigDecimal getApprovedCapacity() {
        return approvedCapacity;
    }

    public void setApprovedCapacity(BigDecimal approvedCapacity) {
        this.approvedCapacity = approvedCapacity;
    }

    public EnergyDerRecord availablePhasesCount(int availablePhasesCount) {
        this.availablePhasesCount = availablePhasesCount;
        return this;
    }

    /**
     * The number of phases available for the installation of DER. Acceptable values are 0, 1, 2 or 3. Value of 0 indicates no DER record exists for the given servicePointId
     *
     * @return availablePhasesCount
     */
    public int getAvailablePhasesCount() {
        return availablePhasesCount;
    }

    public void setAvailablePhasesCount(int availablePhasesCount) {
        this.availablePhasesCount = availablePhasesCount;
    }

    public EnergyDerRecord installedPhasesCount(int installedPhasesCount) {
        this.installedPhasesCount = installedPhasesCount;
        return this;
    }

    /**
     * The number of phases that DER is connected to. Acceptable values are 0, 1, 2 or 3. Value of 0 indicates no DER record exists for the given servicePointId
     *
     * @return installedPhasesCount
     */
    public int getInstalledPhasesCount() {
        return installedPhasesCount;
    }

    public void setInstalledPhasesCount(int installedPhasesCount) {
        this.installedPhasesCount = installedPhasesCount;
    }

    public EnergyDerRecord islandableInstallation(boolean islandableInstallation) {
        this.islandableInstallation = islandableInstallation;
        return this;
    }

    /**
     * For identification of small generating units designed with the ability to operate in an islanded mode
     *
     * @return islandableInstallation
     */
    public boolean getIslandableInstallation() {
        return islandableInstallation;
    }

    public void setIslandableInstallation(boolean islandableInstallation) {
        this.islandableInstallation = islandableInstallation;
    }

    public EnergyDerRecord hasCentralProtectionControl(Boolean hasCentralProtectionControl) {
        this.hasCentralProtectionControl = hasCentralProtectionControl;
        return this;
    }

    /**
     * For DER installations where NSPs specify the need for additional forms of protection above those inbuilt in an inverter.  If absent then assumed to be false
     *
     * @return hasCentralProtectionControl
     */
    public Boolean getHasCentralProtectionControl() {
        return hasCentralProtectionControl;
    }

    public void setHasCentralProtectionControl(Boolean hasCentralProtectionControl) {
        this.hasCentralProtectionControl = hasCentralProtectionControl;
    }

    public EnergyDerRecord protectionMode(EnergyDerRecordProtectionMode protectionMode) {
        this.protectionMode = protectionMode;
        return this;
    }

    /**
     * Get protectionMode
     *
     * @return protectionMode
     */
    public EnergyDerRecordProtectionMode getProtectionMode() {
        return protectionMode;
    }

    public void setProtectionMode(EnergyDerRecordProtectionMode protectionMode) {
        this.protectionMode = protectionMode;
    }

    public EnergyDerRecord acConnections(List<EnergyDerRecordAcConnections> acConnections) {
        this.acConnections = acConnections;
        return this;
    }

    public EnergyDerRecord addAcConnectionsItem(EnergyDerRecordAcConnections acConnectionsItem) {
        this.acConnections.add(acConnectionsItem);
        return this;
    }

    /**
     * Get acConnections
     *
     * @return acConnections
     */
    public List<EnergyDerRecordAcConnections> getAcConnections() {
        return acConnections;
    }

    public void setAcConnections(List<EnergyDerRecordAcConnections> acConnections) {
        this.acConnections = acConnections;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EnergyDerRecord energyDerRecord = (EnergyDerRecord) o;
        return Objects.equals(this.servicePointId, energyDerRecord.servicePointId) &&
                Objects.equals(this.approvedCapacity, energyDerRecord.approvedCapacity) &&
                Objects.equals(this.availablePhasesCount, energyDerRecord.availablePhasesCount) &&
                Objects.equals(this.installedPhasesCount, energyDerRecord.installedPhasesCount) &&
                Objects.equals(this.islandableInstallation, energyDerRecord.islandableInstallation) &&
                Objects.equals(this.hasCentralProtectionControl, energyDerRecord.hasCentralProtectionControl) &&
                Objects.equals(this.protectionMode, energyDerRecord.protectionMode) &&
                Objects.equals(this.acConnections, energyDerRecord.acConnections);
    }

    @Override
    public int hashCode() {
        return Objects.hash(servicePointId, approvedCapacity, availablePhasesCount, installedPhasesCount, islandableInstallation, hasCentralProtectionControl, protectionMode, acConnections);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyDerRecord {\n");
        sb.append("    servicePointId: ").append(toIndentedString(servicePointId)).append("\n");
        sb.append("    approvedCapacity: ").append(toIndentedString(approvedCapacity)).append("\n");
        sb.append("    availablePhasesCount: ").append(toIndentedString(availablePhasesCount)).append("\n");
        sb.append("    installedPhasesCount: ").append(toIndentedString(installedPhasesCount)).append("\n");
        sb.append("    islandableInstallation: ").append(toIndentedString(islandableInstallation)).append("\n");
        sb.append("    hasCentralProtectionControl: ").append(toIndentedString(hasCentralProtectionControl)).append("\n");
        sb.append("    protectionMode: ").append(toIndentedString(protectionMode)).append("\n");
        sb.append("    acConnections: ").append(toIndentedString(acConnections)).append("\n");
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
