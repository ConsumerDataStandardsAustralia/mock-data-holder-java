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
import java.util.List;
import java.util.Objects;

/**
 * Represents a constant tariff.  Mandatory if tariffUType is set to singleTariff
 */
@ApiModel(description = "Represents a constant tariff.  Mandatory if tariffUType is set to singleTariff")
@Entity
@Table(name = "EnergyPlanSingleTariff")
public class EnergyPlanContractSingleTariffV2 {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @JsonIgnore
    private String id;

    @Valid
    @OneToMany(cascade = CascadeType.ALL)
    private List<EnergyRates> rates;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EnergyPlanContractSingleTariffV2 energyPlanContractSingleTariff = (EnergyPlanContractSingleTariffV2) o;
        return Objects.equals(this.rates, energyPlanContractSingleTariff.rates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rates);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyPlanContractSingleTariffV2 {\n");
        sb.append("    rates: ").append(toIndentedString(rates)).append("\n");
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
