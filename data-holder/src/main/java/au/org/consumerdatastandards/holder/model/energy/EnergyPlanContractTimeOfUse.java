package au.org.consumerdatastandards.holder.model.energy;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * EnergyPlanContractTimeOfUse
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen",
        date = "2022-01-11T14:03:27.755+11:00[Australia/Sydney]")
public class EnergyPlanContractTimeOfUse {
    /**
     * Gets or Sets days
     */
    public enum DaysEnum {
        SUNDAY("SUNDAY"),

        MONDAY("MONDAY"),

        TUESDAY("TUESDAY"),

        WEDNESDAY("WEDNESDAY"),

        THURSDAY("THURSDAY"),

        FRIDAY("FRIDAY"),

        SATURDAY("SATURDAY"),

        BUSINESS_DAYS("BUSINESS_DAYS");

        private String value;

        DaysEnum(String value) {
            this.value = value;
        }

        @JsonValue
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        @JsonCreator
        public static DaysEnum fromValue(String value) {
            for (DaysEnum b : DaysEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    @JsonProperty("days")
    @Valid
    private List<DaysEnum> days = new ArrayList<>();

    @JsonProperty("startTime")
    private String startTime;

    @JsonProperty("endTime")
    private String endTime;

    public EnergyPlanContractTimeOfUse days(List<DaysEnum> days) {
        this.days = days;
        return this;
    }

    public EnergyPlanContractTimeOfUse addDaysItem(DaysEnum daysItem) {
        this.days.add(daysItem);
        return this;
    }

    /**
     * The days that the rate applies to
     *
     * @return days
     */
    @ApiModelProperty(required = true,
            value = "The days that the rate applies to")
    @NotNull


    public List<DaysEnum> getDays() {
        return days;
    }

    public void setDays(List<DaysEnum> days) {
        this.days = days;
    }

    public EnergyPlanContractTimeOfUse startTime(String startTime) {
        this.startTime = startTime;
        return this;
    }

    /**
     * Start of the period in HHMM format using 24 hour clock format
     *
     * @return startTime
     */
    @ApiModelProperty(required = true,
            value = "Start of the period in HHMM format using 24 hour clock format")
    @NotNull


    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public EnergyPlanContractTimeOfUse endTime(String endTime) {
        this.endTime = endTime;
        return this;
    }

    /**
     * End of the period in HHMM format using 24 hour clock format
     *
     * @return endTime
     */
    @ApiModelProperty(required = true,
            value = "End of the period in HHMM format using 24 hour clock format")
    @NotNull


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
        EnergyPlanContractTimeOfUse energyPlanContractTimeOfUse = (EnergyPlanContractTimeOfUse) o;
        return Objects.equals(this.days, energyPlanContractTimeOfUse.days) &&
                Objects.equals(this.startTime, energyPlanContractTimeOfUse.startTime) &&
                Objects.equals(this.endTime, energyPlanContractTimeOfUse.endTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(days, startTime, endTime);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyPlanContractTimeOfUse {\n");

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

