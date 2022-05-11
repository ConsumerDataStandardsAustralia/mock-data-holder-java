package au.org.consumerdatastandards.holder.model.energy;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * Required only when the hasCentralProtectionAndControl flag is set to true.  One or more of the object fields will be provided to describe the protection modes in place
 */
@ApiModel(description = "Required only when the hasCentralProtectionAndControl flag is set to true.  One or more of the object fields will be provided to describe the protection modes in place")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen",
        date = "2022-01-11T14:03:27.755+11:00[Australia/Sydney]")
public class EnergyDerRecordProtectionMode {
    @JsonProperty("exportLimitkva")
    private BigDecimal exportLimitkva;

    @JsonProperty("underFrequencyProtection")
    private BigDecimal underFrequencyProtection;

    @JsonProperty("underFrequencyProtectionDelay")
    private BigDecimal underFrequencyProtectionDelay;

    @JsonProperty("overFrequencyProtection")
    private BigDecimal overFrequencyProtection;

    @JsonProperty("overFrequencyProtectionDelay")
    private BigDecimal overFrequencyProtectionDelay;

    @JsonProperty("underVoltageProtection")
    private BigDecimal underVoltageProtection;

    @JsonProperty("underVoltageProtectionDelay")
    private BigDecimal underVoltageProtectionDelay;

    @JsonProperty("overVoltageProtection")
    private BigDecimal overVoltageProtection;

    @JsonProperty("overVoltageProtectionDelay")
    private BigDecimal overVoltageProtectionDelay;

    @JsonProperty("sustainedOverVoltage")
    private BigDecimal sustainedOverVoltage;

    @JsonProperty("sustainedOverVoltageDelay")
    private BigDecimal sustainedOverVoltageDelay;

    @JsonProperty("frequencyRateOfChange")
    private BigDecimal frequencyRateOfChange;

    @JsonProperty("voltageVectorShift")
    private BigDecimal voltageVectorShift;

    @JsonProperty("interTripScheme")
    private String interTripScheme;

    @JsonProperty("neutralVoltageDisplacement")
    private BigDecimal neutralVoltageDisplacement;

    public EnergyDerRecordProtectionMode exportLimitkva(BigDecimal exportLimitkva) {
        this.exportLimitkva = exportLimitkva;
        return this;
    }

    /**
     * Maximum amount of power (kVA) that may be exported from a connection point to the grid, as monitored by a control / relay function. An absent value indicates no limit
     *
     * @return exportLimitkva
     */
    @ApiModelProperty(value = "Maximum amount of power (kVA) that may be exported from a connection point to the grid, as monitored by a control / relay function. An absent value indicates no limit")

    @Valid

    public BigDecimal getExportLimitkva() {
        return exportLimitkva;
    }

    public void setExportLimitkva(BigDecimal exportLimitkva) {
        this.exportLimitkva = exportLimitkva;
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
    @ApiModelProperty(value = "Protective function limit in Hz.")

    @Valid

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
    @ApiModelProperty(value = "Trip delay time in seconds.")

    @Valid

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
    @ApiModelProperty(value = "Protective function limit in Hz.")

    @Valid

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
    @ApiModelProperty(value = "Trip delay time in seconds.")

    @Valid

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
    @ApiModelProperty(value = "Protective function limit in V.")

    @Valid

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
    @ApiModelProperty(value = "Trip delay time in seconds.")

    @Valid

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
    @ApiModelProperty(value = "Protective function limit in V.")

    @Valid

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
    @ApiModelProperty(value = "Trip delay time in seconds.")

    @Valid

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
    @ApiModelProperty(value = "Sustained over voltage.")

    @Valid

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
     * Trip delay time in seconds.
     *
     * @return sustainedOverVoltageDelay
     */
    @ApiModelProperty(value = "Trip delay time in seconds.")

    @Valid

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
    @ApiModelProperty(value = "Rate of change of frequency trip point (Hz/s).")

    @Valid

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
    @ApiModelProperty(value = "Trip angle in degrees.")

    @Valid

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
    @ApiModelProperty(value = "Description of the form of inter-trip (e.g. 'from local substation').")


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
    @ApiModelProperty(value = "Trip voltage.")

    @Valid

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
        return Objects.equals(this.exportLimitkva, energyDerRecordProtectionMode.exportLimitkva) &&
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
        return Objects.hash(exportLimitkva, underFrequencyProtection, underFrequencyProtectionDelay, overFrequencyProtection, overFrequencyProtectionDelay, underVoltageProtection, underVoltageProtectionDelay, overVoltageProtection, overVoltageProtectionDelay, sustainedOverVoltage, sustainedOverVoltageDelay, frequencyRateOfChange, voltageVectorShift, interTripScheme, neutralVoltageDisplacement);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyDerRecordProtectionMode {\n");

        sb.append("    exportLimitkva: ").append(toIndentedString(exportLimitkva)).append("\n");
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

