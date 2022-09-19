package au.org.consumerdatastandards.client.model.energy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * EnergyPlanContractTimeOfUseRates
 */
public class EnergyPlanControlledLoadSingleRate {

    private String displayName;

    private String description;

    private String dailySupplyCharge;

    private List<EnergyRates> rates = new ArrayList<>();

    public EnergyPlanControlledLoadSingleRate displayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    /**
     * Display name of the controlled load rate
     *
     * @return displayName
     */
    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public EnergyPlanControlledLoadSingleRate description(String description) {
        this.description = description;
        return this;
    }

    /**
     * Description of the controlled load rate
     *
     * @return description
     */
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * The daily supply charge (exclusive of GST) for this controlled load tier
     *
     * @return dailySupplyCharge
     */
    public String getDailySupplyCharge() {
        return dailySupplyCharge;
    }

    public void setDailySupplyCharge(String dailySupplyCharge) {
        this.dailySupplyCharge = dailySupplyCharge;
    }

    public EnergyPlanControlledLoadSingleRate rates(List<EnergyRates> rates) {
        this.rates = rates;
        return this;
    }

    public EnergyPlanControlledLoadSingleRate addRatesItem(EnergyRates ratesItem) {
        this.rates.add(ratesItem);
        return this;
    }

    /**
     * Array of controlled load rates in order of usage volume
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
        EnergyPlanControlledLoadSingleRate energyPlanControlledLoadSingleRate = (EnergyPlanControlledLoadSingleRate) o;
        return Objects.equals(this.displayName, energyPlanControlledLoadSingleRate.displayName) &&
                Objects.equals(this.description, energyPlanControlledLoadSingleRate.description) &&
                Objects.equals(this.dailySupplyCharge, energyPlanControlledLoadSingleRate.dailySupplyCharge) &&
                Objects.equals(this.rates, energyPlanControlledLoadSingleRate.rates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(displayName, description, dailySupplyCharge, rates);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyPlanControlledLoadSingleRate {\n");
        sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    dailySupplyCharge: ").append(toIndentedString(dailySupplyCharge)).append("\n");
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
