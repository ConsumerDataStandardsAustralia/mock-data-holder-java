package au.org.consumerdatastandards.client.model.energy;

import java.util.Objects;

/**
 * EnergyPlanContractSolarFeedInTariffV1
 */
public class EnergyPlanContractSolarFeedInTariffV1 extends EnergyPlanContractSolarFeedInTariffBase {

    private EnergyPlanContractSingleTariffV1 singleTariff;

    private EnergyPlanContractTimeVaryingTariffsV1 timeVaryingTariffs;

    public EnergyPlanContractSolarFeedInTariffV1 singleTariff(EnergyPlanContractSingleTariffV1 singleTariff) {
        this.singleTariff = singleTariff;
        return this;
    }

    /**
     * Get singleTariff
     *
     * @return singleTariff
     */
    public EnergyPlanContractSingleTariffV1 getSingleTariff() {
        return singleTariff;
    }

    public void setSingleTariff(EnergyPlanContractSingleTariffV1 singleTariff) {
        this.singleTariff = singleTariff;
    }

    public EnergyPlanContractSolarFeedInTariffV1 timeVaryingTariffs(EnergyPlanContractTimeVaryingTariffsV1 timeVaryingTariffs) {
        this.timeVaryingTariffs = timeVaryingTariffs;
        return this;
    }

    /**
     * Get timeVaryingTariffs
     *
     * @return timeVaryingTariffs
     */
    public EnergyPlanContractTimeVaryingTariffsV1 getTimeVaryingTariffs() {
        return timeVaryingTariffs;
    }

    public void setTimeVaryingTariffs(EnergyPlanContractTimeVaryingTariffsV1 timeVaryingTariffs) {
        this.timeVaryingTariffs = timeVaryingTariffs;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o) &&
                Objects.equals(this.singleTariff, ((EnergyPlanContractSolarFeedInTariffV1)o).singleTariff) &&
                Objects.equals(this.timeVaryingTariffs, ((EnergyPlanContractSolarFeedInTariffV1)o).timeVaryingTariffs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(singleTariff, timeVaryingTariffs, super.hashCode());
    }

    @Override
    protected void writeProperties(StringBuilder sb) {
        super.writeProperties(sb);
        sb.append("    singleTariff: ").append(toIndentedString(singleTariff)).append("\n");
        sb.append("    timeVaryingTariffs: ").append(toIndentedString(timeVaryingTariffs)).append("\n");
    }
}
