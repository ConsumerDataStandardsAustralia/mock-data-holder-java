package au.org.consumerdatastandards.holder.model.energy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
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
 * Usage data registers available from the meter
 */
@ApiModel(description = "Usage data registers available from the meter")
@Entity
public class EnergyServicePointDetailRegisters {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @JsonIgnore
    private String id;

    private String registerId;

    private String registerSuffix;

    private BigDecimal averagedDailyLoad;

    /**
     * Indicates the consumption type of register.
     */
    public enum RegisterConsumptionTypeEnum {
        INTERVAL,
        BASIC,
        PROFILE_DATA,
        ACTIVE_IMPORT,
        ACTIVE,
        REACTIVE_IMPORT,
        REACTIVE
    }

    private RegisterConsumptionTypeEnum registerConsumptionType;

    private String networkTariffCode;

    private String unitOfMeasure;

    /**
     * Code to identify the time validity of register contents.
     */
    public enum TimeOfDayEnum {
        ALLDAY,
        INTERVAL,
        PEAK,
        BUSINESS,
        SHOULDER,
        EVENING,
        OFFPEAK,
        CONTROLLED,
        DEMAND
    }

    private TimeOfDayEnum timeOfDay;

    private BigDecimal multiplier;

    private Boolean controlledLoad;

    /**
     * Actual/Subtractive Indicator. Note the details of enumeration values below: <ul><li>`ACTUAL`: implies volume of energy actually metered between two dates</li><li>`CUMULATIVE`: indicates a meter reading for a specific date. A second Meter Reading is required to determine the consumption between those two Meter Reading dates.</li></ul>
     */
    public enum ConsumptionTypeEnum {
        ACTUAL,
        CUMULATIVE
    }

    private ConsumptionTypeEnum consumptionType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public EnergyServicePointDetailRegisters registerId(String registerId) {
        this.registerId = registerId;
        return this;
    }

    /**
     * Unique identifier of the register within this service point. Is not globally unique.
     *
     * @return registerId
     */
    @ApiModelProperty(required = true,
            value = "Unique identifier of the register within this service point. Is not globally unique.")
    @NotNull
    public String getRegisterId() {
        return registerId;
    }

    public void setRegisterId(String registerId) {
        this.registerId = registerId;
    }

    public EnergyServicePointDetailRegisters registerSuffix(String registerSuffix) {
        this.registerSuffix = registerSuffix;
        return this;
    }

    /**
     * Register suffix of the meter register where the meter reads are obtained.
     *
     * @return registerSuffix
     */
    @ApiModelProperty(value = "Register suffix of the meter register where the meter reads are obtained.")
    public String getRegisterSuffix() {
        return registerSuffix;
    }

    public void setRegisterSuffix(String registerSuffix) {
        this.registerSuffix = registerSuffix;
    }

    public EnergyServicePointDetailRegisters averagedDailyLoad(BigDecimal averagedDailyLoad) {
        this.averagedDailyLoad = averagedDailyLoad;
        return this;
    }

    /**
     * The energy delivered through a connection point or metering point over an extended period normalised to a 'per day' basis (kWh). This value is calculated annually.
     *
     * @return averagedDailyLoad
     */
    @ApiModelProperty(value = "The energy delivered through a connection point or metering point over an extended period normalised to a 'per day' basis (kWh). This value is calculated annually.")
    @Valid
    public BigDecimal getAveragedDailyLoad() {
        return averagedDailyLoad;
    }

    public void setAveragedDailyLoad(BigDecimal averagedDailyLoad) {
        this.averagedDailyLoad = averagedDailyLoad;
    }

    public EnergyServicePointDetailRegisters registerConsumptionType(RegisterConsumptionTypeEnum registerConsumptionType) {
        this.registerConsumptionType = registerConsumptionType;
        return this;
    }

    /**
     * Indicates the consumption type of register.
     *
     * @return registerConsumptionType
     */
    @ApiModelProperty(required = true, value = "Indicates the consumption type of register.")
    @NotNull
    public RegisterConsumptionTypeEnum getRegisterConsumptionType() {
        return registerConsumptionType;
    }

    public void setRegisterConsumptionType(RegisterConsumptionTypeEnum registerConsumptionType) {
        this.registerConsumptionType = registerConsumptionType;
    }

    public EnergyServicePointDetailRegisters networkTariffCode(String networkTariffCode) {
        this.networkTariffCode = networkTariffCode;
        return this;
    }

    /**
     * The Network Tariff Code is a free text field containing a code supplied and published by the local network service provider.
     *
     * @return networkTariffCode
     */
    @ApiModelProperty(value = "The Network Tariff Code is a free text field containing a code supplied and published by the local network service provider.")
    public String getNetworkTariffCode() {
        return networkTariffCode;
    }

    public void setNetworkTariffCode(String networkTariffCode) {
        this.networkTariffCode = networkTariffCode;
    }

    public EnergyServicePointDetailRegisters unitOfMeasure(String unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
        return this;
    }

    /**
     * The unit of measure for data held in this register.
     *
     * @return unitOfMeasure
     */
    @ApiModelProperty(value = "The unit of measure for data held in this register.")
    public String getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(String unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public EnergyServicePointDetailRegisters timeOfDay(TimeOfDayEnum timeOfDay) {
        this.timeOfDay = timeOfDay;
        return this;
    }

    /**
     * Code to identify the time validity of register contents.
     *
     * @return timeOfDay
     */
    @ApiModelProperty(value = "Code to identify the time validity of register contents.")
    public TimeOfDayEnum getTimeOfDay() {
        return timeOfDay;
    }

    public void setTimeOfDay(TimeOfDayEnum timeOfDay) {
        this.timeOfDay = timeOfDay;
    }

    public EnergyServicePointDetailRegisters multiplier(BigDecimal multiplier) {
        this.multiplier = multiplier;
        return this;
    }

    /**
     * Multiplier required to take a register value and turn it into a value representing billable energy.
     *
     * @return multiplier
     */
    @ApiModelProperty(value = "Multiplier required to take a register value and turn it into a value representing billable energy.")
    @Valid
    public BigDecimal getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(BigDecimal multiplier) {
        this.multiplier = multiplier;
    }

    public EnergyServicePointDetailRegisters controlledLoad(Boolean controlledLoad) {
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

    public EnergyServicePointDetailRegisters consumptionType(ConsumptionTypeEnum consumptionType) {
        this.consumptionType = consumptionType;
        return this;
    }

    /**
     * Actual/Subtractive Indicator. Note the details of enumeration values below: <ul><li>`ACTUAL`: implies volume of energy actually metered between two dates</li><li>`CUMULATIVE`: indicates a meter reading for a specific date. A second Meter Reading is required to determine the consumption between those two Meter Reading dates.</li></ul>
     *
     * @return consumptionType
     */
    @ApiModelProperty(value = "Actual/Subtractive Indicator. Note the details of enumeration values below: <ul><li>`ACTUAL`: implies volume of energy actually metered between two dates</li><li>`CUMULATIVE`: indicates a meter reading for a specific date. A second Meter Reading is required to determine the consumption between those two Meter Reading dates.</li></ul>")
    public ConsumptionTypeEnum getConsumptionType() {
        return consumptionType;
    }

    public void setConsumptionType(ConsumptionTypeEnum consumptionType) {
        this.consumptionType = consumptionType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EnergyServicePointDetailRegisters energyServicePointDetailRegisters = (EnergyServicePointDetailRegisters) o;
        return Objects.equals(this.registerId, energyServicePointDetailRegisters.registerId) &&
                Objects.equals(this.registerSuffix, energyServicePointDetailRegisters.registerSuffix) &&
                Objects.equals(this.averagedDailyLoad, energyServicePointDetailRegisters.averagedDailyLoad) &&
                Objects.equals(this.registerConsumptionType, energyServicePointDetailRegisters.registerConsumptionType) &&
                Objects.equals(this.networkTariffCode, energyServicePointDetailRegisters.networkTariffCode) &&
                Objects.equals(this.unitOfMeasure, energyServicePointDetailRegisters.unitOfMeasure) &&
                Objects.equals(this.timeOfDay, energyServicePointDetailRegisters.timeOfDay) &&
                Objects.equals(this.multiplier, energyServicePointDetailRegisters.multiplier) &&
                Objects.equals(this.controlledLoad, energyServicePointDetailRegisters.controlledLoad) &&
                Objects.equals(this.consumptionType, energyServicePointDetailRegisters.consumptionType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(registerId, registerSuffix, averagedDailyLoad, registerConsumptionType, networkTariffCode, unitOfMeasure, timeOfDay, multiplier, controlledLoad, consumptionType);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyServicePointDetailMetersRegisters {\n");
        sb.append("    registerId: ").append(toIndentedString(registerId)).append("\n");
        sb.append("    registerSuffix: ").append(toIndentedString(registerSuffix)).append("\n");
        sb.append("    averagedDailyLoad: ").append(toIndentedString(averagedDailyLoad)).append("\n");
        sb.append("    registerConsumptionType: ").append(toIndentedString(registerConsumptionType)).append("\n");
        sb.append("    networkTariffCode: ").append(toIndentedString(networkTariffCode)).append("\n");
        sb.append("    unitOfMeasure: ").append(toIndentedString(unitOfMeasure)).append("\n");
        sb.append("    timeOfDay: ").append(toIndentedString(timeOfDay)).append("\n");
        sb.append("    multiplier: ").append(toIndentedString(multiplier)).append("\n");
        sb.append("    controlledLoad: ").append(toIndentedString(controlledLoad)).append("\n");
        sb.append("    consumptionType: ").append(toIndentedString(consumptionType)).append("\n");
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
