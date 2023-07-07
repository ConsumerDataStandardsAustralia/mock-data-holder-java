package au.org.consumerdatastandards.client.model.energy;

import java.util.List;
import java.util.Objects;

/**
 * Represents a constant tariff.  Mandatory if tariffUType is set to singleTariff
 */
public class EnergyPlanContractSingleTariffV2 {
    private List<EnergyRates> rates;

    /**
     * Array of feed in rates
     *
     * @return rates
     */
    public List<EnergyRates> getRates() {
        return rates;
    }

    public void setRates(List<EnergyRates> rates) {
        this.rates = rates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EnergyPlanContractSingleTariffV2 energyPlanContractSingleTariff = (EnergyPlanContractSingleTariffV2) o;
        return Objects.equals(this.rates, energyPlanContractSingleTariff.rates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rates);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyPlanContractSingleTariffV2 {\n");
        sb.append("    rates: ").append(toIndentedString(rates)).append("\n");
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
