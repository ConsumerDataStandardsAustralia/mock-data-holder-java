package au.org.consumerdatastandards.holder.model.energy;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Objects;

/**
 * Required if pricing model is `SINGLE_RATE_CONT_LOAD` or `TIME_OF_USE_CONT_LOAD` or `FLEXIBLE_CONT_LOAD`.
 */
@ApiModel(description = "Required if pricing model is `SINGLE_RATE_CONT_LOAD` or `TIME_OF_USE_CONT_LOAD` or `FLEXIBLE_CONT_LOAD`.")
@MappedSuperclass
public class EnergyPlanControlledLoad {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @JsonIgnore
    private String id;

    private String displayName;

    public enum RateBlockUTypeEnum {
        SINGLERATE("singleRate"),
        TIMEOFUSERATES("timeOfUseRates");

        private final String value;

        RateBlockUTypeEnum(String value) {
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
        public static RateBlockUTypeEnum fromValue(String value) {
            for (RateBlockUTypeEnum b : RateBlockUTypeEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    private RateBlockUTypeEnum rateBlockUType;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDate startDate;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDate endDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public EnergyPlanControlledLoad displayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    /**
     * A display name for the controlled load.
     *
     * @return displayName
     */
    @ApiModelProperty(required = true, value = "A display name for the controlled load.")
    @NotNull
    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /**
     * Specifies the type of controlloed load rate.
     *
     * @return rateBlockUType
     */
    @ApiModelProperty(required = true, value = "Specifies the type of controlloed load rate.")
    @NotNull
    public RateBlockUTypeEnum getRateBlockUType() {
        return rateBlockUType;
    }

    public void setRateBlockUType(RateBlockUTypeEnum rateBlockUType) {
        this.rateBlockUType = rateBlockUType;
    }

    /**
     * Optional start date of the application of the controlled load rate.
     *
     * @return startDate
     */
    @ApiModelProperty("Optional start date of the application of the controlled load rate.")
    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    /**
     * Optional end date of the application of the controlled load rate.
     *
     * @return endDate
     */
    @ApiModelProperty("Optional end date of the application of the controlled load rate.")
    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EnergyPlanControlledLoad energyPlanControlledLoad = (EnergyPlanControlledLoad) o;
        return Objects.equals(this.displayName, energyPlanControlledLoad.displayName) &&
                Objects.equals(this.rateBlockUType, energyPlanControlledLoad.rateBlockUType) &&
                Objects.equals(this.startDate, energyPlanControlledLoad.startDate) &&
                Objects.equals(this.endDate, energyPlanControlledLoad.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(displayName, rateBlockUType, startDate, endDate);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(getClass().getSimpleName()).append("{\n");
        stringProperties(sb);
        return sb.append("}").toString();
    }

    protected void stringProperties(StringBuilder sb) {
        sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
        sb.append("    rateBlockUType: ").append(toIndentedString(rateBlockUType)).append("\n");
        sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
        sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
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
