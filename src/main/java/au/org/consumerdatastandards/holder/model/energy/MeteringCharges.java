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
 * MeteringCharges
 */
@Entity
public class MeteringCharges {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @JsonIgnore
    private String id;

    private String displayName;

    private String description;

    private String minimumValue;

    private String maximumValue;

    private String period;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public MeteringCharges displayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    /**
     * Display name of the charge.
     *
     * @return displayName
     */
    @ApiModelProperty(required = true, value = "Display name of the charge.")
    @NotNull
    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public MeteringCharges description(String description) {
        this.description = description;
        return this;
    }

    /**
     * Description of the charge.
     *
     * @return description
     */
    @ApiModelProperty(value = "Description of the charge.")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MeteringCharges minimumValue(String minimumValue) {
        this.minimumValue = minimumValue;
        return this;
    }

    /**
     * Minimum value of the charge if the charge is a range or the absolute value of the charge if no range is specified.
     *
     * @return minimumValue
     */
    @ApiModelProperty(required = true,
            value = "Minimum value of the charge if the charge is a range or the absolute value of the charge if no range is specified.")
    @NotNull
    public String getMinimumValue() {
        return minimumValue;
    }

    public void setMinimumValue(String minimumValue) {
        this.minimumValue = minimumValue;
    }

    public MeteringCharges maximumValue(String maximumValue) {
        this.maximumValue = maximumValue;
        return this;
    }

    /**
     * The upper limit of the charge if the charge could occur in a range.
     *
     * @return maximumValue
     */
    @ApiModelProperty(value = "The upper limit of the charge if the charge could occur in a range.")
    public String getMaximumValue() {
        return maximumValue;
    }

    public void setMaximumValue(String maximumValue) {
        this.maximumValue = maximumValue;
    }

    public MeteringCharges period(String period) {
        this.period = period;
        return this;
    }

    /**
     * The charges that occur on a schedule indicates the frequency. Formatted according to [ISO 8601 Durations](https://en.wikipedia.org/wiki/ISO_8601#Durations) (excludes recurrence syntax).
     *
     * @return period
     */
    @ApiModelProperty(value = "The charges that occur on a schedule indicates the frequency. Formatted according to [ISO 8601 Durations](https://en.wikipedia.org/wiki/ISO_8601#Durations) (excludes recurrence syntax).")
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
        MeteringCharges meteringCharges = (MeteringCharges) o;
        return Objects.equals(this.displayName, meteringCharges.displayName) &&
                Objects.equals(this.description, meteringCharges.description) &&
                Objects.equals(this.minimumValue, meteringCharges.minimumValue) &&
                Objects.equals(this.maximumValue, meteringCharges.maximumValue) &&
                Objects.equals(this.period, meteringCharges.period);
    }

    @Override
    public int hashCode() {
        return Objects.hash(displayName, description, minimumValue, maximumValue, period);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class MeteringCharges {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    minimumValue: ").append(toIndentedString(minimumValue)).append("\n");
        sb.append("    maximumValue: ").append(toIndentedString(maximumValue)).append("\n");
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
