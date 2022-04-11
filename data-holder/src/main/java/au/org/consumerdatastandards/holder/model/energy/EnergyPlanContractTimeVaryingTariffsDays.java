package au.org.consumerdatastandards.holder.model.energy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * EnergyPlanContractTimeVaryingTariffsDays
 */
@Entity
public class EnergyPlanContractTimeVaryingTariffsDays {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @JsonIgnore
    private String id;

    private Boolean weekdays;

    private Boolean weekend;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public EnergyPlanContractTimeVaryingTariffsDays weekdays(Boolean weekdays) {
        this.weekdays = weekdays;
        return this;
    }

    /**
     * Indicates whether the tariff is applicable Monday to Friday
     *
     * @return weekdays
     */
    @ApiModelProperty(required = true, value = "Indicates whether the tariff is applicable Monday to Friday")
    @NotNull
    public Boolean getWeekdays() {
        return weekdays;
    }

    public void setWeekdays(Boolean weekdays) {
        this.weekdays = weekdays;
    }

    public EnergyPlanContractTimeVaryingTariffsDays weekend(Boolean weekend) {
        this.weekend = weekend;
        return this;
    }

    /**
     * Indicates whether the tariff is applicable Saturday and Sunday
     *
     * @return weekend
     */
    @ApiModelProperty(required = true, value = "Indicates whether the tariff is applicable Saturday and Sunday")
    @NotNull
    public Boolean getWeekend() {
        return weekend;
    }

    public void setWeekend(Boolean weekend) {
        this.weekend = weekend;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EnergyPlanContractTimeVaryingTariffsDays energyPlanContractTimeVaryingTariffsDays = (EnergyPlanContractTimeVaryingTariffsDays) o;
        return Objects.equals(this.weekdays, energyPlanContractTimeVaryingTariffsDays.weekdays) &&
                Objects.equals(this.weekend, energyPlanContractTimeVaryingTariffsDays.weekend);
    }

    @Override
    public int hashCode() {
        return Objects.hash(weekdays, weekend);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyPlanContractTimeVaryingTariffsDays {\n");
        sb.append("    weekdays: ").append(toIndentedString(weekdays)).append("\n");
        sb.append("    weekend: ").append(toIndentedString(weekend)).append("\n");
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
