package au.org.consumerdatastandards.holder.model.energy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

/**
 * EnergyPlanContractTimeVaryingTariffsTimeVariations
 */
@Entity(name = "e_time_variations")
public class EnergyPlanContractTimeVaryingTariffsTimeVariations {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @JsonIgnore
    private String id;

    public enum DaysEnum {
        SUN,
        MON,
        TUE,
        WED,
        THU,
        FRI,
        SAT,
        PUBLIC_HOLIDAYS
    }

    @Valid
    @ElementCollection
    private List<DaysEnum> days;

    private String startTime;

    private String endTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public EnergyPlanContractTimeVaryingTariffsTimeVariations days(List<DaysEnum> days) {
        this.days = days;
        return this;
    }

    /**
     * The days that the tariff applies to. At least one entry required
     *
     * @return days
     */
    @ApiModelProperty(required = true, value = "The days that the tariff applies to. At least one entry required")
    @Valid
    @NotNull
    public List<DaysEnum> getDays() {
        return days;
    }

    public void setDays(List<DaysEnum> days) {
        this.days = days;
    }

    public EnergyPlanContractTimeVaryingTariffsTimeVariations startTime(String startTime) {
        this.startTime = startTime;
        return this;
    }

    /**
     * The beginning of the time period per day for which the tariff applies.  If absent assumes start of day (ie. midnight)
     *
     * @return startTime
     */
    @ApiModelProperty(value = "The beginning of the time period per day for which the tariff applies.  If absent assumes start of day (ie. midnight)")
    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public EnergyPlanContractTimeVaryingTariffsTimeVariations endTime(String endTime) {
        this.endTime = endTime;
        return this;
    }

    /**
     * The end of the time period per day for which the tariff applies.  If absent assumes end of day (ie. one second before midnight)
     *
     * @return endTime
     */
    @ApiModelProperty(value = "The end of the time period per day for which the tariff applies.  If absent assumes end of day (ie. one second before midnight)")
    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EnergyPlanContractTimeVaryingTariffsTimeVariations energyPlanContractTimeVaryingTariffsTimeVariations = (EnergyPlanContractTimeVaryingTariffsTimeVariations) o;
        return Objects.equals(this.days, energyPlanContractTimeVaryingTariffsTimeVariations.days) &&
                Objects.equals(this.startTime, energyPlanContractTimeVaryingTariffsTimeVariations.startTime) &&
                Objects.equals(this.endTime, energyPlanContractTimeVaryingTariffsTimeVariations.endTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(days, startTime, endTime);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyPlanContractTimeVaryingTariffsTimeVariations {\n");
        sb.append("    days: ").append(toIndentedString(days)).append("\n");
        sb.append("    startTime: ").append(toIndentedString(startTime)).append("\n");
        sb.append("    endTime: ").append(toIndentedString(endTime)).append("\n");
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
