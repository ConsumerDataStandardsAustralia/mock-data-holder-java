package au.org.consumerdatastandards.client.model.energy;

import java.util.Objects;

/**
 * Describes intrinsic green power for the plan.  If present then the plan includes a percentage of green power in the base plan. Should not be present for gas contracts
 */
public class EnergyPlanContractIntrinsicGreenPower {
    private String greenPercentage;

    public EnergyPlanContractIntrinsicGreenPower greenPercentage(String greenPercentage) {
        this.greenPercentage = greenPercentage;
        return this;
    }

    /**
     * Percentage of green power intrinsically included in the plan
     *
     * @return greenPercentage
     */
    public String getGreenPercentage() {
        return greenPercentage;
    }

    public void setGreenPercentage(String greenPercentage) {
        this.greenPercentage = greenPercentage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EnergyPlanContractIntrinsicGreenPower energyPlanContractIntrinsicGreenPower = (EnergyPlanContractIntrinsicGreenPower) o;
        return Objects.equals(this.greenPercentage, energyPlanContractIntrinsicGreenPower.greenPercentage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(greenPercentage);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyPlanContractIntrinsicGreenPower {\n");
        sb.append("    greenPercentage: ").append(toIndentedString(greenPercentage)).append("\n");
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
