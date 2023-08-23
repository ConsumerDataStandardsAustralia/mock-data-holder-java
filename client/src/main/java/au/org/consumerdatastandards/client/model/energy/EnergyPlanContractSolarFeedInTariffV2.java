package au.org.consumerdatastandards.client.model.energy;

import java.time.LocalDate;
import java.util.Objects;

/**
 * EnergyPlanContractSolarFeedInTariffV2
 */
public class EnergyPlanContractSolarFeedInTariffV2 extends EnergyPlanContractSolarFeedInTariffBase {

    private LocalDate startDate;

    private LocalDate endDate;

    private EnergyPlanContractSingleTariffV2 singleTariff;

    private EnergyPlanContractTimeVaryingTariffsV2 timeVaryingTariffs;
    /**
     * The start date of the application of the feed in tariff
     *
     * @return startDate
     */
    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    /**
     * The end date of the application of the feed in tariff
     *
     * @return endDate
     */
    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    /**
     * Get singleTariff
     *
     * @return singleTariff
     */
    public EnergyPlanContractSingleTariffV2 getSingleTariff() {
        return singleTariff;
    }

    public void setSingleTariff(EnergyPlanContractSingleTariffV2 singleTariff) {
        this.singleTariff = singleTariff;
    }

    public EnergyPlanContractSolarFeedInTariffV2 timeVaryingTariffs(EnergyPlanContractTimeVaryingTariffsV2 timeVaryingTariffs) {
        this.timeVaryingTariffs = timeVaryingTariffs;
        return this;
    }

    /**
     * Get timeVaryingTariffs
     *
     * @return timeVaryingTariffs
     */
    public EnergyPlanContractTimeVaryingTariffsV2 getTimeVaryingTariffs() {
        return timeVaryingTariffs;
    }

    public void setTimeVaryingTariffs(EnergyPlanContractTimeVaryingTariffsV2 timeVaryingTariffs) {
        this.timeVaryingTariffs = timeVaryingTariffs;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o) &&
                Objects.equals(this.startDate, ((EnergyPlanContractSolarFeedInTariffV2)o).startDate) &&
                Objects.equals(this.endDate, ((EnergyPlanContractSolarFeedInTariffV2)o).endDate) &&
                Objects.equals(this.singleTariff, ((EnergyPlanContractSolarFeedInTariffV2)o).singleTariff) &&
                Objects.equals(this.timeVaryingTariffs, ((EnergyPlanContractSolarFeedInTariffV2)o).timeVaryingTariffs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startDate, endDate, singleTariff, timeVaryingTariffs, super.hashCode());
    }

    @Override
    protected void writeProperties(StringBuilder sb) {
        super.writeProperties(sb);
        sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
        sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
        sb.append("    singleTariff: ").append(toIndentedString(singleTariff)).append("\n");
        sb.append("    timeVaryingTariffs: ").append(toIndentedString(timeVaryingTariffs)).append("\n");
    }
}
