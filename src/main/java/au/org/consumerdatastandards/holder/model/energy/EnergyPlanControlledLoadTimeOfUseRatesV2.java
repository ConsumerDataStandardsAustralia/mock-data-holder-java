package au.org.consumerdatastandards.holder.model.energy;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

/**
 * EnergyPlanControlledLoadTimeOfUseRatesV2
 */
@Entity
@Table(name = "e_ctrled_load_tow_rates")
public class EnergyPlanControlledLoadTimeOfUseRatesV2 extends EnergyPlanControlledLoadTimeOfUseRates {
    private String period;

    /**
     * Usage period for which the block rate applies. Formatted according to [ISO 8601 Durations](https://en.wikipedia.org/wiki/ISO_8601#Durations) (excludes recurrence syntax). Defaults to `P1Y` if absent.
     *
     * @return period
     */
    @ApiModelProperty(value = "Usage period for which the block rate applies. Formatted according to [ISO 8601 Durations](https://en.wikipedia.org/wiki/ISO_8601#Durations) (excludes recurrence syntax). Defaults to `P1Y` if absent.")
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
        EnergyPlanControlledLoadTimeOfUseRatesV2 energyPlanControlledLoadTimeOfUseRates = (EnergyPlanControlledLoadTimeOfUseRatesV2) o;
        return Objects.equals(this.period, energyPlanControlledLoadTimeOfUseRates.period) &&
                super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(period, super.hashCode());
    }

    @Override
    protected void stringProperties(StringBuilder sb) {
        super.stringProperties(sb);
        sb.append("    period: ").append(toIndentedString(period)).append("\n");
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
