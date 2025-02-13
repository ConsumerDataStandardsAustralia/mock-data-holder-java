package au.org.consumerdatastandards.holder.model.energy;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Required if pricing model is `SINGLE_RATE_CONT_LOAD` or `TIME_OF_USE_CONT_LOAD` or `FLEXIBLE_CONT_LOAD`.
 */
@ApiModel(description = "Required if pricing model is `SINGLE_RATE_CONT_LOAD` or `TIME_OF_USE_CONT_LOAD` or `FLEXIBLE_CONT_LOAD`.")
@Entity
@Table(name = "e_plan_ctrl_load")
public class EnergyPlanControlledLoadV2 extends EnergyPlanControlledLoad {
    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(
            name = "e_c_loads_s_rate",
            joinColumns = @JoinColumn(name = "c_load_id"),
            inverseJoinColumns = @JoinColumn(name = "s_rate_id"))
    private EnergyPlanControlledLoadSingleRateV2 singleRate;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "e_c_loads_tou_rates",
            joinColumns = @JoinColumn(name = "c_load_id"),
            inverseJoinColumns = @JoinColumn(name = "tou_rate_id"))
    private List<EnergyPlanControlledLoadTimeOfUseRatesV2> timeOfUseRates = new ArrayList<>();

    /**
     * Object representing a single controlled load rate. Required if _rateBlockUType_ is `singleRate`.
     *
     * @return singleRate
     */
    @ApiModelProperty("Object representing a single controlled load rate. Required if _rateBlockUType_ is `singleRate`.")
    public EnergyPlanControlledLoadSingleRateV2 getSingleRate() {
        return singleRate;
    }

    public void setSingleRate(EnergyPlanControlledLoadSingleRateV2 singleRate) {
        this.singleRate = singleRate;
    }

    /**
     * Array of objects representing time of use rates. Required if _rateBlockUType_ is `timeOfUseRates`.
     *
     * @return timeOfUseRates
     */
    @ApiModelProperty("Array of objects representing time of use rates. Required if _rateBlockUType_ is `timeOfUseRates`.")
    public List<EnergyPlanControlledLoadTimeOfUseRatesV2> getTimeOfUseRates() {
        return timeOfUseRates;
    }

    public void setTimeOfUseRates(List<EnergyPlanControlledLoadTimeOfUseRatesV2> timeOfUseRates) {
        this.timeOfUseRates = timeOfUseRates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EnergyPlanControlledLoadV2 energyPlanControlledLoad = (EnergyPlanControlledLoadV2) o;
        return Objects.equals(this.singleRate, energyPlanControlledLoad.singleRate) &&
                Objects.equals(this.timeOfUseRates, energyPlanControlledLoad.timeOfUseRates) &&
                super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(singleRate, timeOfUseRates, super.hashCode());
    }

    @Override
    protected void stringProperties(StringBuilder sb) {
        super.stringProperties(sb);
        sb.append("    singleRate: ").append(toIndentedString(singleRate)).append("\n");
        sb.append("    timeOfUseRates: ").append(toIndentedString(timeOfUseRates)).append("\n");
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
