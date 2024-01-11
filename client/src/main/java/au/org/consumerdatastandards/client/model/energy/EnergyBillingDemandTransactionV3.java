package au.org.consumerdatastandards.client.model.energy;

import java.util.Objects;

/**
 * EnergyBillingDemandTransactionV3
 */
public class EnergyBillingDemandTransactionV3 extends EnergyBillingDemandTransactionV2 {

    private RateMeasureUnitEnum measureUnit;

    public RateMeasureUnitEnum getMeasureUnit() {
        return measureUnit;
    }

    public void setMeasureUnit(RateMeasureUnitEnum measureUnit) {
        this.measureUnit = measureUnit;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o) && Objects.equals(this.measureUnit, ((EnergyBillingDemandTransactionV3)o).measureUnit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(measureUnit, super.hashCode());
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
        super.writeProperties(sb);
        sb.append("    measureUnit: ").append(toIndentedString(measureUnit)).append("\n");
    }
}
