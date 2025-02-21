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
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Represents a tariff based on time. Mandatory if _tariffUType_ is set to `timeVaryingTariffs`.
 * V3 - since 1.30.0
 */
@ApiModel(description = "Represents a tariff based on time. Mandatory if _tariffUType_ is set to `timeVaryingTariffs`.")
@Entity
@Table(name = "e_plan_time_var_tariff")
public class EnergyPlanContractTimeVaryingTariffsV3 implements EnergyPlanContractTimeVaryingTariffs {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @JsonIgnore
    private String id;

    private TypeEnum type;

    @Valid
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "e_time_var_tariffs_rates",
            joinColumns = @JoinColumn(name = "e_time_var_tariff_id"),
            inverseJoinColumns = @JoinColumn(name = "time_var_id"))
    private List<EnergyRates> rates;

    @Valid
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "e_time_var_tariffs_time_vars",
            joinColumns = @JoinColumn(name = "e_time_var_tariff_id"),
            inverseJoinColumns = @JoinColumn(name = "time_var_id"))
    private List<EnergyPlanContractTimeVaryingTariffsTimeVariations> timeVariations = new ArrayList<>();

    private String displayName;

    private String period;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public EnergyPlanContractTimeVaryingTariffs type(TypeEnum type) {
        this.type = type;
        return this;
    }

    /**
     * The type of the charging time period. If absent applies to all periods.
     *
     * @return type
     */
    @Override
    @ApiModelProperty(value = "The type of the charging time period. If absent applies to all periods.")
    public TypeEnum getType() {
        return type;
    }

    @Override
    public void setType(TypeEnum type) {
        this.type = type;
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

    public EnergyPlanContractTimeVaryingTariffs timeVariations(List<EnergyPlanContractTimeVaryingTariffsTimeVariations> timeVariations) {
        this.timeVariations = timeVariations;
        return this;
    }

    public EnergyPlanContractTimeVaryingTariffs addTimeVariationsItem(EnergyPlanContractTimeVaryingTariffsTimeVariations timeVariationsItem) {
        this.timeVariations.add(timeVariationsItem);
        return this;
    }

    /**
     * Array of time periods for which this tariff is applicable.
     *
     * @return timeVariations
     */
    @Override
    @ApiModelProperty(required = true, value = "Array of time periods for which this tariff is applicable.")
    @NotNull
    @Valid
    public List<EnergyPlanContractTimeVaryingTariffsTimeVariations> getTimeVariations() {
        return timeVariations;
    }

    @Override
    public void setTimeVariations(List<EnergyPlanContractTimeVaryingTariffsTimeVariations> timeVariations) {
        this.timeVariations = timeVariations;
    }

    /**
     * Display name of the tariff.
     *
     * @return displayName
     */
    @ApiModelProperty(required = true, value = "Display name of the tariff.")
    @NotNull
    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
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
        EnergyPlanContractTimeVaryingTariffsV3 energyPlanContractTimeVaryingTariffs = (EnergyPlanContractTimeVaryingTariffsV3) o;
        return Objects.equals(this.type, energyPlanContractTimeVaryingTariffs.type) &&
                Objects.equals(this.rates, energyPlanContractTimeVaryingTariffs.rates) &&
                Objects.equals(this.timeVariations, energyPlanContractTimeVaryingTariffs.timeVariations) &&
                Objects.equals(this.displayName, energyPlanContractTimeVaryingTariffs.displayName) &&
                Objects.equals(this.period, energyPlanContractTimeVaryingTariffs.period);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, rates, timeVariations, displayName, period);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyPlanContractTimeVaryingTariffsV2 {\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    rates: ").append(toIndentedString(rates)).append("\n");
        sb.append("    timeVariations: ").append(toIndentedString(timeVariations)).append("\n");
        sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
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
