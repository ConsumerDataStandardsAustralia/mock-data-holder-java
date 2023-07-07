package au.org.consumerdatastandards.client.model.energy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * EnergyPlanContractV2
 */
public class EnergyPlanContractV2 extends EnergyPlanContractBase implements EnergyPlanContract {

    private List<EnergyPlanContractSolarFeedInTariffV2> solarFeedInTariff = null;

    public EnergyPlanContractV2 solarFeedInTariff(List<EnergyPlanContractSolarFeedInTariffV2> solarFeedInTariff) {
        this.solarFeedInTariff = solarFeedInTariff;
        return this;
    }

    public EnergyPlanContractV2 addSolarFeedInTariffItem(EnergyPlanContractSolarFeedInTariffV2 solarFeedInTariffItem) {
        if (this.solarFeedInTariff == null) {
            this.solarFeedInTariff = new ArrayList<>();
        }
        this.solarFeedInTariff.add(solarFeedInTariffItem);
        return this;
    }

    /**
     * Array of feed in tariffs for solar power
     *
     * @return solarFeedInTariff
     */
    public List<EnergyPlanContractSolarFeedInTariffV2> getSolarFeedInTariff() {
        return solarFeedInTariff;
    }

    public void setSolarFeedInTariff(List<EnergyPlanContractSolarFeedInTariffV2> solarFeedInTariff) {
        this.solarFeedInTariff = solarFeedInTariff;
    }

    @Override
    public int hashCode() {
        return Objects.hash(solarFeedInTariff, super.hashCode());
    }

    @Override
    protected void writeProperties(StringBuilder sb) {
        super.writeProperties(sb);
        sb.append("    solarFeedInTariff: ").append(toIndentedString(solarFeedInTariff)).append("\n");
    }

    @Override
    public boolean equals(Object o) {
        if (super.equals(o)) {
            EnergyPlanContractV2 energyPlanContract = (EnergyPlanContractV2) o;
            return Objects.equals(this.solarFeedInTariff, energyPlanContract.solarFeedInTariff);
        }
        return false;
    }
}
