package au.org.consumerdatastandards.client.model.energy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EnergyPlanContractTimeVaryingTariffsBase implements EnergyPlanContractTimeVaryingTariffs {
    private TypeEnum type;
    private List<EnergyPlanContractTimeVaryingTariffsTimeVariations> timeVariations = new ArrayList<>();

    public EnergyPlanContractTimeVaryingTariffsBase type(TypeEnum type) {
        this.type = type;
        return this;
    }

    /**
     * The type of the charging time period. If absent applies to all periods
     *
     * @return type
     */
    public TypeEnum getType() {
        return type;
    }

    public void setType(TypeEnum type) {
        this.type = type;
    }

    public EnergyPlanContractTimeVaryingTariffsBase timeVariations(List<EnergyPlanContractTimeVaryingTariffsTimeVariations> timeVariations) {
        this.timeVariations = timeVariations;
        return this;
    }

    public EnergyPlanContractTimeVaryingTariffsBase addTimeVariationsItem(EnergyPlanContractTimeVaryingTariffsTimeVariations timeVariationsItem) {
        this.timeVariations.add(timeVariationsItem);
        return this;
    }

    /**
     * Array of time periods for which this tariff is applicable
     *
     * @return timeVariations
     */
    public List<EnergyPlanContractTimeVaryingTariffsTimeVariations> getTimeVariations() {
        return timeVariations;
    }

    public void setTimeVariations(List<EnergyPlanContractTimeVaryingTariffsTimeVariations> timeVariations) {
        this.timeVariations = timeVariations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EnergyPlanContractTimeVaryingTariffsBase energyPlanContractTimeVaryingTariffs = (EnergyPlanContractTimeVaryingTariffsBase) o;
        return Objects.equals(this.type, energyPlanContractTimeVaryingTariffs.type) &&
                Objects.equals(this.timeVariations, energyPlanContractTimeVaryingTariffs.timeVariations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, timeVariations);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ").append(getClass().getSimpleName()).append(" {");
        writeProperties(sb);
        sb.append("}");
        return sb.toString();
    }

    protected void writeProperties(StringBuilder sb) {
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    timeVariations: ").append(toIndentedString(timeVariations)).append("\n");
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     * @param o Object
     * @return Indented string representation of <code>o</code>
     */
    protected String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
