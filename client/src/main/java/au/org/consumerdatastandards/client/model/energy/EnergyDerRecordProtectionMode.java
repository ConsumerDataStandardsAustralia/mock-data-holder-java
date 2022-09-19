package au.org.consumerdatastandards.client.model.energy;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Required only when the hasCentralProtectionAndControl flag is set to true.  One or more of the object fields will be provided to describe the protection modes in place
 */
public class EnergyDerRecordProtectionMode {
    private BigDecimal exportLimitKva;

    private BigDecimal underFrequencyProtection;

    private BigDecimal underFrequencyProtectionDelay;

    private BigDecimal overFrequencyProtection;

    private BigDecimal overFrequencyProtectionDelay;

    private BigDecimal underVoltageProtection;

    private BigDecimal underVoltageProtectionDelay;

    private BigDecimal overVoltageProtection;

    private BigDecimal overVoltageProtectionDelay;

    private BigDecimal sustainedOverVoltage;

    private BigDecimal sustainedOverVoltageDelay;

    private BigDecimal frequencyRateOfChange;

    private BigDecimal voltageVectorShift;

    private String interTripScheme;

    private BigDecimal neutralVoltageDisplacement;

    public EnergyDerRecordProtectionMode exportLimitkva(BigDecimal exportLimitkva) {
        this.exportLimitKva = exportLimitkva;
        return this;
    }

    /**
     * Maximum amount of power (kVA) that may be exported from a connection point to the grid, as monitored by a control / relay function. An absent value indicates no limit
     *
     * @return exportLimitKva
     */
    public BigDecimal getExportLimitKva() {
        return exportLimitKva;
    }

    public void setExportLimitKva(BigDecimal exportLimitKva) {
        this.exportLimitKva = exportLimitKva;
    }

    public EnergyDerRecordProtectionMode underFrequencyProtection(BigDecimal underFrequencyProtection) {
        this.underFrequencyProtection = underFrequencyProtection;
        return this;
    }

    /**
     * Protective function limit in Hz.
     *
     * @return underFrequencyProtection
     */
    public BigDecimal getUnderFrequencyProtection() {
        return underFrequencyProtection;
    }

    public void setUnderFrequencyProtection(BigDecimal underFrequencyProtection) {
        this.underFrequencyProtection = underFrequencyProtection;
    }

    public EnergyDerRecordProtectionMode underFrequencyProtectionDelay(BigDecimal underFrequencyProtectionDelay) {
        this.underFrequencyProtectionDelay = underFrequencyProtectionDelay;
        return this;
    }

    /**
     * Trip delay time in seconds.
     *
     * @return underFrequencyProtectionDelay
     */
    public BigDecimal getUnderFrequencyProtectionDelay() {
        return underFrequencyProtectionDelay;
    }

    public void setUnderFrequencyProtectionDelay(BigDecimal underFrequencyProtectionDelay) {
        this.underFrequencyProtectionDelay = underFrequencyProtectionDelay;
    }

    public EnergyDerRecordProtectionMode overFrequencyProtection(BigDecimal overFrequencyProtection) {
        this.overFrequencyProtection = overFrequencyProtection;
        return this;
    }

    /**
     * Protective function limit in Hz.
     *
     * @return overFrequencyProtection
     */
    public BigDecimal getOverFrequencyProtection() {
        return overFrequencyProtection;
    }

    public void setOverFrequencyProtection(BigDecimal overFrequencyProtection) {
        this.overFrequencyProtection = overFrequencyProtection;
    }

    public EnergyDerRecordProtectionMode overFrequencyProtectionDelay(BigDecimal overFrequencyProtectionDelay) {
        this.overFrequencyProtectionDelay = overFrequencyProtectionDelay;
        return this;
    }

    /**
     * Trip delay time in seconds.
     *
     * @return overFrequencyProtectionDelay
     */
    public BigDecimal getOverFrequencyProtectionDelay() {
        return overFrequencyProtectionDelay;
    }

    public void setOverFrequencyProtectionDelay(BigDecimal overFrequencyProtectionDelay) {
        this.overFrequencyProtectionDelay = overFrequencyProtectionDelay;
    }

    public EnergyDerRecordProtectionMode underVoltageProtection(BigDecimal underVoltageProtection) {
        this.underVoltageProtection = underVoltageProtection;
        return this;
    }

    /**
     * Protective function limit in V.
     *
     * @return underVoltageProtection
     */
    public BigDecimal getUnderVoltageProtection() {
        return underVoltageProtection;
    }

    public void setUnderVoltageProtection(BigDecimal underVoltageProtection) {
        this.underVoltageProtection = underVoltageProtection;
    }

    public EnergyDerRecordProtectionMode underVoltageProtectionDelay(BigDecimal underVoltageProtectionDelay) {
        this.underVoltageProtectionDelay = underVoltageProtectionDelay;
        return this;
    }

    /**
     * Trip delay time in seconds.
     *
     * @return underVoltageProtectionDelay
     */
    public BigDecimal getUnderVoltageProtectionDelay() {
        return underVoltageProtectionDelay;
    }

    public void setUnderVoltageProtectionDelay(BigDecimal underVoltageProtectionDelay) {
        this.underVoltageProtectionDelay = underVoltageProtectionDelay;
    }

    public EnergyDerRecordProtectionMode overVoltageProtection(BigDecimal overVoltageProtection) {
        this.overVoltageProtection = overVoltageProtection;
        return this;
    }

    /**
     * Protective function limit in V.
     *
     * @return overVoltageProtection
     */
    public BigDecimal getOverVoltageProtection() {
        return overVoltageProtection;
    }

    public void setOverVoltageProtection(BigDecimal overVoltageProtection) {
        this.overVoltageProtection = overVoltageProtection;
    }

    public EnergyDerRecordProtectionMode overVoltageProtectionDelay(BigDecimal overVoltageProtectionDelay) {
        this.overVoltageProtectionDelay = overVoltageProtectionDelay;
        return this;
    }

    /**
     * Trip delay time in seconds.
     *
     * @return overVoltageProtectionDelay
     */
    public BigDecimal getOverVoltageProtectionDelay() {
        return overVoltageProtectionDelay;
    }

    public void setOverVoltageProtectionDelay(BigDecimal overVoltageProtectionDelay) {
        this.overVoltageProtectionDelay = overVoltageProtectionDelay;
    }

    public EnergyDerRecordProtectionMode sustainedOverVoltage(BigDecimal sustainedOverVoltage) {
        this.sustainedOverVoltage = sustainedOverVoltage;
        return this;
    }

    /**
     * Sustained over voltage.
     *
     * @return sustainedOverVoltage
     */
    public BigDecimal getSustainedOverVoltage() {
        return sustainedOverVoltage;
    }

    public void setSustainedOverVoltage(BigDecimal sustainedOverVoltage) {
        this.sustainedOverVoltage = sustainedOverVoltage;
    }

    public EnergyDerRecordProtectionMode sustainedOverVoltageDelay(BigDecimal sustainedOverVoltageDelay) {
        this.sustainedOverVoltageDelay = sustainedOverVoltageDelay;
        return this;
    }

    /**
     * Sustained Over voltage protection delay in seconds.
     *
     * @return sustainedOverVoltageDelay
     */
    public BigDecimal getSustainedOverVoltageDelay() {
        return sustainedOverVoltageDelay;
    }

    public void setSustainedOverVoltageDelay(BigDecimal sustainedOverVoltageDelay) {
        this.sustainedOverVoltageDelay = sustainedOverVoltageDelay;
    }

    public EnergyDerRecordProtectionMode frequencyRateOfChange(BigDecimal frequencyRateOfChange) {
        this.frequencyRateOfChange = frequencyRateOfChange;
        return this;
    }

    /**
     * Rate of change of frequency trip point (Hz/s).
     *
     * @return frequencyRateOfChange
     */
    public BigDecimal getFrequencyRateOfChange() {
        return frequencyRateOfChange;
    }

    public void setFrequencyRateOfChange(BigDecimal frequencyRateOfChange) {
        this.frequencyRateOfChange = frequencyRateOfChange;
    }

    public EnergyDerRecordProtectionMode voltageVectorShift(BigDecimal voltageVectorShift) {
        this.voltageVectorShift = voltageVectorShift;
        return this;
    }

    /**
     * Trip angle in degrees.
     *
     * @return voltageVectorShift
     */
    public BigDecimal getVoltageVectorShift() {
        return voltageVectorShift;
    }

    public void setVoltageVectorShift(BigDecimal voltageVectorShift) {
        this.voltageVectorShift = voltageVectorShift;
    }

    public EnergyDerRecordProtectionMode interTripScheme(String interTripScheme) {
        this.interTripScheme = interTripScheme;
        return this;
    }

    /**
     * Description of the form of inter-trip (e.g. 'from local substation').
     *
     * @return interTripScheme
     */
    public String getInterTripScheme() {
        return interTripScheme;
    }

    public void setInterTripScheme(String interTripScheme) {
        this.interTripScheme = interTripScheme;
    }

    public EnergyDerRecordProtectionMode neutralVoltageDisplacement(BigDecimal neutralVoltageDisplacement) {
        this.neutralVoltageDisplacement = neutralVoltageDisplacement;
        return this;
    }

    /**
     * Trip voltage.
     *
     * @return neutralVoltageDisplacement
     */
    public BigDecimal getNeutralVoltageDisplacement() {
        return neutralVoltageDisplacement;
    }

    public void setNeutralVoltageDisplacement(BigDecimal neutralVoltageDisplacement) {
        this.neutralVoltageDisplacement = neutralVoltageDisplacement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EnergyDerRecordProtectionMode energyDerRecordProtectionMode = (EnergyDerRecordProtectionMode) o;
        return Objects.equals(this.exportLimitKva, energyDerRecordProtectionMode.exportLimitKva) &&
                Objects.equals(this.underFrequencyProtection, energyDerRecordProtectionMode.underFrequencyProtection) &&
                Objects.equals(this.underFrequencyProtectionDelay, energyDerRecordProtectionMode.underFrequencyProtectionDelay) &&
                Objects.equals(this.overFrequencyProtection, energyDerRecordProtectionMode.overFrequencyProtection) &&
                Objects.equals(this.overFrequencyProtectionDelay, energyDerRecordProtectionMode.overFrequencyProtectionDelay) &&
                Objects.equals(this.underVoltageProtection, energyDerRecordProtectionMode.underVoltageProtection) &&
                Objects.equals(this.underVoltageProtectionDelay, energyDerRecordProtectionMode.underVoltageProtectionDelay) &&
                Objects.equals(this.overVoltageProtection, energyDerRecordProtectionMode.overVoltageProtection) &&
                Objects.equals(this.overVoltageProtectionDelay, energyDerRecordProtectionMode.overVoltageProtectionDelay) &&
                Objects.equals(this.sustainedOverVoltage, energyDerRecordProtectionMode.sustainedOverVoltage) &&
                Objects.equals(this.sustainedOverVoltageDelay, energyDerRecordProtectionMode.sustainedOverVoltageDelay) &&
                Objects.equals(this.frequencyRateOfChange, energyDerRecordProtectionMode.frequencyRateOfChange) &&
                Objects.equals(this.voltageVectorShift, energyDerRecordProtectionMode.voltageVectorShift) &&
                Objects.equals(this.interTripScheme, energyDerRecordProtectionMode.interTripScheme) &&
                Objects.equals(this.neutralVoltageDisplacement, energyDerRecordProtectionMode.neutralVoltageDisplacement);
    }

    @Override
    public int hashCode() {
        return Objects.hash(exportLimitKva, underFrequencyProtection, underFrequencyProtectionDelay, overFrequencyProtection, overFrequencyProtectionDelay, underVoltageProtection, underVoltageProtectionDelay, overVoltageProtection, overVoltageProtectionDelay, sustainedOverVoltage, sustainedOverVoltageDelay, frequencyRateOfChange, voltageVectorShift, interTripScheme, neutralVoltageDisplacement);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyDerRecordProtectionMode {\n");
        sb.append("    exportLimitKva: ").append(toIndentedString(exportLimitKva)).append("\n");
        sb.append("    underFrequencyProtection: ").append(toIndentedString(underFrequencyProtection)).append("\n");
        sb.append("    underFrequencyProtectionDelay: ").append(toIndentedString(underFrequencyProtectionDelay)).append("\n");
        sb.append("    overFrequencyProtection: ").append(toIndentedString(overFrequencyProtection)).append("\n");
        sb.append("    overFrequencyProtectionDelay: ").append(toIndentedString(overFrequencyProtectionDelay)).append("\n");
        sb.append("    underVoltageProtection: ").append(toIndentedString(underVoltageProtection)).append("\n");
        sb.append("    underVoltageProtectionDelay: ").append(toIndentedString(underVoltageProtectionDelay)).append("\n");
        sb.append("    overVoltageProtection: ").append(toIndentedString(overVoltageProtection)).append("\n");
        sb.append("    overVoltageProtectionDelay: ").append(toIndentedString(overVoltageProtectionDelay)).append("\n");
        sb.append("    sustainedOverVoltage: ").append(toIndentedString(sustainedOverVoltage)).append("\n");
        sb.append("    sustainedOverVoltageDelay: ").append(toIndentedString(sustainedOverVoltageDelay)).append("\n");
        sb.append("    frequencyRateOfChange: ").append(toIndentedString(frequencyRateOfChange)).append("\n");
        sb.append("    voltageVectorShift: ").append(toIndentedString(voltageVectorShift)).append("\n");
        sb.append("    interTripScheme: ").append(toIndentedString(interTripScheme)).append("\n");
        sb.append("    neutralVoltageDisplacement: ").append(toIndentedString(neutralVoltageDisplacement)).append("\n");
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
