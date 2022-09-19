package au.org.consumerdatastandards.client.model.energy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * EnergyPlanContractTimeOfUseRates
 */
public class EnergyPlanContractTimeOfUseRates {
    private String displayName;

    private String description;

    private List<EnergyRates> rates = new ArrayList<>();

    private List<EnergyTimeOfUse> timeOfUse = new ArrayList<>();

    /**
     * The type of usage that the rate applies to
     */
    public enum TypeEnum {
        PEAK,
        OFF_PEAK,
        SHOULDER,
        SHOULDER1,
        SHOULDER2
    }

    private TypeEnum type;

    public EnergyPlanContractTimeOfUseRates displayName(String displayName) {
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

    public EnergyPlanContractTimeOfUseRates description(String description) {
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

    public EnergyPlanContractTimeOfUseRates rates(List<EnergyRates> rates) {
        this.rates = rates;
        return this;
    }

    public EnergyPlanContractTimeOfUseRates addRatesItem(EnergyRates ratesItem) {
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

    public EnergyPlanContractTimeOfUseRates timeOfUse(List<EnergyTimeOfUse> timeOfUse) {
        this.timeOfUse = timeOfUse;
        return this;
    }

    public EnergyPlanContractTimeOfUseRates addTimeOfUseItem(EnergyTimeOfUse timeOfUseItem) {
        this.timeOfUse.add(timeOfUseItem);
        return this;
    }

    /**
     * Array of times of use
     *
     * @return timeOfUse
     */
    public List<EnergyTimeOfUse> getTimeOfUse() {
        return timeOfUse;
    }

    public void setTimeOfUse(List<EnergyTimeOfUse> timeOfUse) {
        this.timeOfUse = timeOfUse;
    }

    public EnergyPlanContractTimeOfUseRates type(TypeEnum type) {
        this.type = type;
        return this;
    }

    /**
     * The type of usage that the rate applies to
     *
     * @return type
     */
    public TypeEnum getType() {
        return type;
    }

    public void setType(TypeEnum type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EnergyPlanContractTimeOfUseRates energyPlanContractTimeOfUseRates = (EnergyPlanContractTimeOfUseRates) o;
        return Objects.equals(this.displayName, energyPlanContractTimeOfUseRates.displayName) &&
                Objects.equals(this.description, energyPlanContractTimeOfUseRates.description) &&
                Objects.equals(this.rates, energyPlanContractTimeOfUseRates.rates) &&
                Objects.equals(this.timeOfUse, energyPlanContractTimeOfUseRates.timeOfUse) &&
                Objects.equals(this.type, energyPlanContractTimeOfUseRates.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(displayName, description, rates, timeOfUse, type);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyPlanContractTimeOfUseRates {\n");
        sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    rates: ").append(toIndentedString(rates)).append("\n");
        sb.append("    timeOfUse: ").append(toIndentedString(timeOfUse)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
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
