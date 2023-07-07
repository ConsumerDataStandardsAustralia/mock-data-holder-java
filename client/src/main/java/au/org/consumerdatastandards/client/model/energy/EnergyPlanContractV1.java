package au.org.consumerdatastandards.client.model.energy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * EnergyPlanContractV1
 */
public class EnergyPlanContractV1 extends EnergyPlanContractBase implements EnergyPlanContract {

    private List<EnergyPlanContractSolarFeedInTariffV1> solarFeedInTariff = null;

    public EnergyPlanContractV1 solarFeedInTariff(List<EnergyPlanContractSolarFeedInTariffV1> solarFeedInTariff) {
        this.solarFeedInTariff = solarFeedInTariff;
        return this;
    }

    public EnergyPlanContractV1 addSolarFeedInTariffItem(EnergyPlanContractSolarFeedInTariffV1 solarFeedInTariffItem) {
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
    public List<EnergyPlanContractSolarFeedInTariffV1> getSolarFeedInTariff() {
        return solarFeedInTariff;
    }

    public void setSolarFeedInTariff(List<EnergyPlanContractSolarFeedInTariffV1> solarFeedInTariff) {
        this.solarFeedInTariff = solarFeedInTariff;
    }

    @Override
    public boolean equals(Object o) {
        if (super.equals(o)) {
            EnergyPlanContractV1 energyPlanContract = (EnergyPlanContractV1) o;
            return Objects.equals(this.solarFeedInTariff, energyPlanContract.solarFeedInTariff);
        }
        return false;
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
}
