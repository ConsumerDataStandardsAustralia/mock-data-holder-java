package au.org.consumerdatastandards.client.model.energy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Object representing a single rate.  Required if rateBlockUType is singleRate
 */
public class EnergyPlanContractSingleRate {
    private String displayName;

    private String description;

    private String generalUnitPrice;

    private List<EnergyPlanContractSingleRateRates> rates = new ArrayList<>();

    private String period;

    public EnergyPlanContractSingleRate displayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    /**
     * Display name of the rate
     *
     * @return displayName
     */
    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public EnergyPlanContractSingleRate description(String description) {
        this.description = description;
        return this;
    }

    /**
     * Description of the rate
     *
     * @return description
     */
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EnergyPlanContractSingleRate generalUnitPrice(String generalUnitPrice) {
        this.generalUnitPrice = generalUnitPrice;
        return this;
    }

    /**
     * The block rate (unit price) for any usage above the included fixed usage, in dollars per kWh inclusive of GST.  Only required if pricingModel field is ‘QUOTA’
     *
     * @return generalUnitPrice
     */
    public String getGeneralUnitPrice() {
        return generalUnitPrice;
    }

    public void setGeneralUnitPrice(String generalUnitPrice) {
        this.generalUnitPrice = generalUnitPrice;
    }

    public EnergyPlanContractSingleRate rates(List<EnergyPlanContractSingleRateRates> rates) {
        this.rates = rates;
        return this;
    }

    public EnergyPlanContractSingleRate addRatesItem(EnergyPlanContractSingleRateRates ratesItem) {
        this.rates.add(ratesItem);
        return this;
    }

    /**
     * Array of controlled load rates in order of usage volume
     *
     * @return rates
     */
    public List<EnergyPlanContractSingleRateRates> getRates() {
        return rates;
    }

    public void setRates(List<EnergyPlanContractSingleRateRates> rates) {
        this.rates = rates;
    }

    public EnergyPlanContractSingleRate period(String period) {
        this.period = period;
        return this;
    }

    /**
     * Usage period for which the block rate applies. Formatted according to [ISO 8601 Durations](https://en.wikipedia.org/wiki/ISO_8601#Durations) (excludes recurrence syntax)
     *
     * @return period
     */
    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EnergyPlanContractSingleRate energyPlanContractSingleRate = (EnergyPlanContractSingleRate) o;
        return Objects.equals(this.displayName, energyPlanContractSingleRate.displayName) &&
                Objects.equals(this.description, energyPlanContractSingleRate.description) &&
                Objects.equals(this.generalUnitPrice, energyPlanContractSingleRate.generalUnitPrice) &&
                Objects.equals(this.rates, energyPlanContractSingleRate.rates) &&
                Objects.equals(this.period, energyPlanContractSingleRate.period);
    }

    @Override
    public int hashCode() {
        return Objects.hash(displayName, description, generalUnitPrice, rates, period);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyPlanContractSingleRate {\n");
        sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    generalUnitPrice: ").append(toIndentedString(generalUnitPrice)).append("\n");
        sb.append("    rates: ").append(toIndentedString(rates)).append("\n");
        sb.append("    period: ").append(toIndentedString(period)).append("\n");
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
