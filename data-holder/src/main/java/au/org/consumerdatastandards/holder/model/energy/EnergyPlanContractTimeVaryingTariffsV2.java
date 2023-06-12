package au.org.consumerdatastandards.holder.model.energy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Represents a tariff based on time.  Mandatory if tariffUType is set to timeVaryingTariffs
 * V2 - since 1.24.0
 */
@ApiModel(description = "Represents a tariff based on time.  Mandatory if tariffUType is set to timeVaryingTariffs")
@Entity
@Table(name = "EnergyPlanTimeVarTariff")
public class EnergyPlanContractTimeVaryingTariffsV2 implements EnergyPlanContractTimeVaryingTariffs {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @JsonIgnore
    private String id;

    private TypeEnum type;

    @Valid
    @OneToMany(cascade = CascadeType.ALL)
    private List<EnergyRates> rates;

    @Valid
    @OneToMany(cascade = CascadeType.ALL)
    private List<EnergyPlanContractTimeVaryingTariffsTimeVariations> timeVariations = new ArrayList<>();

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
     * The type of the charging time period. If absent applies to all periods
     *
     * @return type
     */
    @Override
    @ApiModelProperty(value = "The type of the charging time period. If absent applies to all periods")
    public TypeEnum getType() {
        return type;
    }

    @Override
    public void setType(TypeEnum type) {
        this.type = type;
    }

    /**
     * Array of feed in rates
     *
     * @return rates
     */
    @ApiModelProperty(required = true, value = "Array of feed in rates")
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
     * Array of time periods for which this tariff is applicable
     *
     * @return timeVariations
     */
    @Override
    @ApiModelProperty(required = true, value = "Array of time periods for which this tariff is applicable")
    @NotNull
    @Valid
    public List<EnergyPlanContractTimeVaryingTariffsTimeVariations> getTimeVariations() {
        return timeVariations;
    }

    @Override
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
        EnergyPlanContractTimeVaryingTariffsV2 energyPlanContractTimeVaryingTariffs = (EnergyPlanContractTimeVaryingTariffsV2) o;
        return Objects.equals(this.type, energyPlanContractTimeVaryingTariffs.type) &&
                Objects.equals(this.rates, energyPlanContractTimeVaryingTariffs.rates) &&
                Objects.equals(this.timeVariations, energyPlanContractTimeVaryingTariffs.timeVariations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, rates, timeVariations);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyPlanContractTimeVaryingTariffsV2 {\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    rates: ").append(toIndentedString(rates)).append("\n");
        sb.append("    timeVariations: ").append(toIndentedString(timeVariations)).append("\n");
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
