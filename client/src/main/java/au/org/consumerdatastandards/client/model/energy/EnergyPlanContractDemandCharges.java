package au.org.consumerdatastandards.client.model.energy;

import java.util.Objects;

/**
 * EnergyPlanContractDemandCharges
 */
public class EnergyPlanContractDemandCharges {
    private String displayName;

    private String description;

    private String amount;

    /**
     * The measurement unit of charge amount. Assumed to be KWH if absent
     */
    public enum MeasureUnitEnum {
        KWH,
        KVA,
        KVAR,
        KVARH,
        KW,
        DAYS,
        METER,
        MONTH
    }

    private MeasureUnitEnum measureUnit;

    private String startTime;

    private String endTime;

    private EnergyPlanContractDays days;

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

    public EnergyPlanContractDemandCharges displayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    /**
     * Display name of the charge
     *
     * @return displayName
     */
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
    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public EnergyPlanContractDemandCharges measureUnit(MeasureUnitEnum measureUnit) {
        this.measureUnit = measureUnit;
        return this;
    }

    /**
     * The measurement unit of charge amount. Assumed to be KWH if absent
     *
     * @return measureUnit
     */
    public MeasureUnitEnum getMeasureUnit() {
        return measureUnit;
    }

    public void setMeasureUnit(MeasureUnitEnum measureUnit) {
        this.measureUnit = measureUnit;
    }

    public EnergyPlanContractDemandCharges startTime(String startTime) {
        this.startTime = startTime;
        return this;
    }

    /**
     * Start of the period in HHMM format using 24 hour clock format
     *
     * @return startTime
     */
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
     * End of the period in HHMM format using 24 hour clock format
     *
     * @return endTime
     */
    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public EnergyPlanContractDemandCharges days(EnergyPlanContractDays days) {
        this.days = days;
        return this;
    }

    /**
     * Get days
     *
     * @return days
     */
    public EnergyPlanContractDays getDays() {
        return days;
    }

    public void setDays(EnergyPlanContractDays days) {
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
