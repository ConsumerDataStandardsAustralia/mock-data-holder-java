package au.org.consumerdatastandards.holder.model.energy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * EnergyPlanContractDemandCharges
 */
@Entity
public class EnergyPlanContractDemandCharges {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @JsonIgnore
    private String id;

    private String displayName;

    private String description;

    private String amount;

    private RateMeasureUnitEnum measureUnit;

    private String startTime;

    private String endTime;

    /**
     * Gets or Sets days
     */
    public enum DaysEnum {
        SUN,
        MON,
        TUE,
        WED,
        THU,
        FRI,
        SAT,
        PUBLIC_HOLIDAYS
    }

    @ElementCollection
    private List<DaysEnum> days = new ArrayList<>();

    private String minDemand;

    private String maxDemand;

    /**
     * Application period for the demand tariff
     */
    public enum MeasurementPeriodEnum {
        DAY,
        MONTH,
        TARIFF_PERIOD
    }

    private MeasurementPeriodEnum measurementPeriod;

    /**
     * Charge period for the demand tariff
     */
    public enum ChargePeriodEnum {
        DAY,
        MONTH,
        TARIFF_PERIOD
    }

    private ChargePeriodEnum chargePeriod;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public EnergyPlanContractDemandCharges displayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    /**
     * Display name of the charge
     *
     * @return displayName
     */
    @ApiModelProperty(required = true, value = "Display name of the charge")
    @NotNull
    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public EnergyPlanContractDemandCharges description(String description) {
        this.description = description;
        return this;
    }

    /**
     * Description of the charge
     *
     * @return description
     */
    @ApiModelProperty(value = "Description of the charge")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EnergyPlanContractDemandCharges amount(String amount) {
        this.amount = amount;
        return this;
    }

    /**
     * The charge amount per  measure unit exclusive of GST
     *
     * @return amount
     */
    @ApiModelProperty(required = true,
            value = "The charge amount per  measure unit exclusive of GST")
    @NotNull
    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public EnergyPlanContractDemandCharges measureUnit(RateMeasureUnitEnum measureUnit) {
        this.measureUnit = measureUnit;
        return this;
    }

    /**
     * The measurement unit of charge amount. Assumed to be KWH if absent
     *
     * @return measureUnit
     */
    @ApiModelProperty(value = "The measurement unit of charge amount. Assumed to be KWH if absent")
    public RateMeasureUnitEnum getMeasureUnit() {
        return measureUnit;
    }

    public void setMeasureUnit(RateMeasureUnitEnum measureUnit) {
        this.measureUnit = measureUnit;
    }

    public EnergyPlanContractDemandCharges startTime(String startTime) {
        this.startTime = startTime;
        return this;
    }

    /**
     * Start of the period.\n\nFormatted according to [ISO 8601 Times](https://en.wikipedia.org/wiki/ISO_8601#Times). If the time is provided without a UTC offset, the time zone will be determined by the value of EnergyPlanContract.timeZone.
     *
     * @return startTime
     */
    @ApiModelProperty(required = true, value = "Start of the period.\n\nFormatted according to [ISO 8601 Times](https://en.wikipedia.org/wiki/ISO_8601#Times). If the time is provided without a UTC offset, the time zone will be determined by the value of EnergyPlanContract.timeZone.")
    @NotNull
    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public EnergyPlanContractDemandCharges endTime(String endTime) {
        this.endTime = endTime;
        return this;
    }

    /**
     * End of the period.\n\nFormatted according to [ISO 8601 Times](https://en.wikipedia.org/wiki/ISO_8601#Times). If the time is provided without a UTC offset, the time zone will be determined by the value of EnergyPlanContract.timeZone.
     *
     * @return endTime
     */
    @ApiModelProperty(required = true, value = "End of the period.\n\nFormatted according to [ISO 8601 Times](https://en.wikipedia.org/wiki/ISO_8601#Times). If the time is provided without a UTC offset, the time zone will be determined by the value of EnergyPlanContract.timeZone.")
    @NotNull
    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public EnergyPlanContractDemandCharges days(List<DaysEnum> days) {
        this.days = days;
        return this;
    }

    /**
     * The days that the demand tariff applies to
     *
     * @return days
     */
    @ApiModelProperty(value = "The days that the demand tariff applies to")
    public List<DaysEnum> getDays() {
        return days;
    }

    public void setDays(List<DaysEnum> days) {
        this.days = days;
    }

    public EnergyPlanContractDemandCharges minDemand(String minDemand) {
        this.minDemand = minDemand;
        return this;
    }

    /**
     * Minimum demand for this demand tariff in kW.  If absent then 0 is assumed
     *
     * @return minDemand
     */
    @ApiModelProperty(value = "Minimum demand for this demand tariff in kW.  If absent then 0 is assumed")
    public String getMinDemand() {
        return minDemand;
    }

    public void setMinDemand(String minDemand) {
        this.minDemand = minDemand;
    }

    public EnergyPlanContractDemandCharges maxDemand(String maxDemand) {
        this.maxDemand = maxDemand;
        return this;
    }

    /**
     * Maximum demand for this demand tariff in kW.  If present, must be higher than the value of the minDemand field
     *
     * @return maxDemand
     */
    @ApiModelProperty(value = "Maximum demand for this demand tariff in kW.  If present, must be higher than the value of the minDemand field")
    public String getMaxDemand() {
        return maxDemand;
    }

    public void setMaxDemand(String maxDemand) {
        this.maxDemand = maxDemand;
    }

    public EnergyPlanContractDemandCharges measurementPeriod(MeasurementPeriodEnum measurementPeriod) {
        this.measurementPeriod = measurementPeriod;
        return this;
    }

    /**
     * Application period for the demand tariff
     *
     * @return measurementPeriod
     */
    @ApiModelProperty(required = true, value = "Application period for the demand tariff")
    @NotNull
    public MeasurementPeriodEnum getMeasurementPeriod() {
        return measurementPeriod;
    }

    public void setMeasurementPeriod(MeasurementPeriodEnum measurementPeriod) {
        this.measurementPeriod = measurementPeriod;
    }

    public EnergyPlanContractDemandCharges chargePeriod(ChargePeriodEnum chargePeriod) {
        this.chargePeriod = chargePeriod;
        return this;
    }

    /**
     * Charge period for the demand tariff
     *
     * @return chargePeriod
     */
    @ApiModelProperty(required = true, value = "Charge period for the demand tariff")
    @NotNull
    public ChargePeriodEnum getChargePeriod() {
        return chargePeriod;
    }

    public void setChargePeriod(ChargePeriodEnum chargePeriod) {
        this.chargePeriod = chargePeriod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EnergyPlanContractDemandCharges energyPlanContractDemandCharges = (EnergyPlanContractDemandCharges) o;
        return Objects.equals(this.displayName, energyPlanContractDemandCharges.displayName) &&
                Objects.equals(this.description, energyPlanContractDemandCharges.description) &&
                Objects.equals(this.amount, energyPlanContractDemandCharges.amount) &&
                Objects.equals(this.measureUnit, energyPlanContractDemandCharges.measureUnit) &&
                Objects.equals(this.startTime, energyPlanContractDemandCharges.startTime) &&
                Objects.equals(this.endTime, energyPlanContractDemandCharges.endTime) &&
                Objects.equals(this.days, energyPlanContractDemandCharges.days) &&
                Objects.equals(this.minDemand, energyPlanContractDemandCharges.minDemand) &&
                Objects.equals(this.maxDemand, energyPlanContractDemandCharges.maxDemand) &&
                Objects.equals(this.measurementPeriod, energyPlanContractDemandCharges.measurementPeriod) &&
                Objects.equals(this.chargePeriod, energyPlanContractDemandCharges.chargePeriod);
    }

    @Override
    public int hashCode() {
        return Objects.hash(displayName, description, amount, measureUnit, startTime, endTime, days, minDemand, maxDemand, measurementPeriod, chargePeriod);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyPlanContractDemandCharges {\n");
        sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
        sb.append("    measureUnit: ").append(toIndentedString(measureUnit)).append("\n");
        sb.append("    startTime: ").append(toIndentedString(startTime)).append("\n");
        sb.append("    endTime: ").append(toIndentedString(endTime)).append("\n");
        sb.append("    days: ").append(toIndentedString(days)).append("\n");
        sb.append("    minDemand: ").append(toIndentedString(minDemand)).append("\n");
        sb.append("    maxDemand: ").append(toIndentedString(maxDemand)).append("\n");
        sb.append("    measurementPeriod: ").append(toIndentedString(measurementPeriod)).append("\n");
        sb.append("    chargePeriod: ").append(toIndentedString(chargePeriod)).append("\n");
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
