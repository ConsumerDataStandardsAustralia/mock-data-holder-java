package au.org.consumerdatastandards.holder.model.energy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

/**
 * Represents a constant tariff. Mandatory if _tariffUType_ is set to `singleTariff`.
 */
@ApiModel(description = "Represents a constant tariff. Mandatory if _tariffUType_ is set to `singleTariff`.")
@Entity
@Table(name = "e_plan_single_tariff")
public class EnergyPlanContractSingleTariffV3 {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @JsonIgnore
    private String id;

    @Valid
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "e_p_c_s_tariff_rates",
            joinColumns = @JoinColumn(name = "s_tariff_id"),
            inverseJoinColumns = @JoinColumn(name = "e_rate_id"))
    private List<EnergyRates> rates;

    private String period;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * Array of feed in rates.
     *
     * @return rates
     */
    @ApiModelProperty(required = true, value = "Array of feed in rates.")
    @Valid
    public List<EnergyRates> getRates() {
        return rates;
    }

    public void setRates(List<EnergyRates> rates) {
        this.rates = rates;
    }

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
        EnergyPlanContractSingleTariffV3 energyPlanContractSingleTariff = (EnergyPlanContractSingleTariffV3) o;
        return Objects.equals(this.rates, energyPlanContractSingleTariff.rates) &&
            Objects.equals(this.period, energyPlanContractSingleTariff.period);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rates, period);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyPlanContractSingleTariffV3 {\n");
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
