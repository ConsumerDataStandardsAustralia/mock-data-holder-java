package au.org.consumerdatastandards.client.model.energy;

import java.util.Objects;

/**
 * EnergyPlanContractSolarFeedInTariffV2
 */
public class EnergyPlanContractSolarFeedInTariffV2 extends EnergyPlanContractSolarFeedInTariffBase {

    private EnergyPlanContractSingleTariffV2 singleTariff;

    private EnergyPlanContractTimeVaryingTariffsV2 timeVaryingTariffs;

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
                Objects.equals(this.singleTariff, ((EnergyPlanContractSolarFeedInTariffV2)o).singleTariff) &&
                Objects.equals(this.timeVaryingTariffs, ((EnergyPlanContractSolarFeedInTariffV2)o).timeVaryingTariffs);
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
