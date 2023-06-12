package au.org.consumerdatastandards.client.model.energy;

import java.util.List;
import java.util.Objects;

/**
 * Represents a tariff based on time.  Mandatory if tariffUType is set to timeVaryingTariffs
 */
public class EnergyPlanContractTimeVaryingTariffsV2 extends EnergyPlanContractTimeVaryingTariffsBase {

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
        return super.equals(o) &&
                Objects.equals(this.rates, ((EnergyPlanContractTimeVaryingTariffsV2)o).rates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rates, super.hashCode());
    }

    @Override
    protected void writeProperties(StringBuilder sb) {
        super.writeProperties(sb);
        sb.append("    rates: ").append(toIndentedString(rates)).append("\n");
    }
}
