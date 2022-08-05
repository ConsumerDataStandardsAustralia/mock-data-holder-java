package au.org.consumerdatastandards.client.model.energy;

import java.util.Objects;

/**
 * Required if methodUType is percentOfUse
 */
public class EnergyPlanContractPercentOfUse {
    private String rate;

    public EnergyPlanContractPercentOfUse rate(String rate) {
        this.rate = rate;
        return this;
    }

    /**
     * The rate of the discount applied to the usageamount
     *
     * @return rate
     */
    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EnergyPlanContractPercentOfUse energyPlanContractPercentOfUse = (EnergyPlanContractPercentOfUse) o;
        return Objects.equals(this.rate, energyPlanContractPercentOfUse.rate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rate);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyPlanContractPercentOfUse {\n");
        sb.append("    rate: ").append(toIndentedString(rate)).append("\n");
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
