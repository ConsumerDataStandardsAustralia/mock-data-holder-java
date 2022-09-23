package au.org.consumerdatastandards.holder.model.energy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * EnergyTimeOfUse
 */
@Entity(name = "ctrled_load_tou")
public class EnergyPlanControlledLoadTimeOfUse {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @JsonIgnore
    private String id;

    /**
     * Gets or Sets days
     */
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

    @ElementCollection
    private List<DaysEnum> days = new ArrayList<>();

    private String startTime;

    private String endTime;

    private String additionalInfo;

    private URI additionalInfoUri;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public EnergyPlanControlledLoadTimeOfUse days(List<DaysEnum> days) {
        this.days = days;
        return this;
    }

    public EnergyPlanControlledLoadTimeOfUse addDaysItem(DaysEnum daysItem) {
        this.days.add(daysItem);
        return this;
    }

    /**
     * The days that the rate applies to
     *
     * @return days
     */
    @ApiModelProperty(required = true, value = "The days that the rate applies to")
    public List<DaysEnum> getDays() {
        return days;
    }

    public void setDays(List<DaysEnum> days) {
        this.days = days;
    }

    public EnergyPlanControlledLoadTimeOfUse startTime(String startTime) {
        this.startTime = startTime;
        return this;
    }

    /**
     * Start of the period in HHMM format using 24 hour clock format
     *
     * @return startTime
     */
    @ApiModelProperty(required = true, value = "Start of the period in HHMM format using 24 hour clock format")
    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public EnergyPlanControlledLoadTimeOfUse endTime(String endTime) {
        this.endTime = endTime;
        return this;
    }

    /**
     * End of the period in HHMM format using 24 hour clock format
     *
     * @return endTime
     */
    @ApiModelProperty(required = true, value = "End of the period in HHMM format using 24 hour clock format")
    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    /**
     * Display text providing more information on the contrlled load, for e.g. controlled load availability if specific day/time is not known. Required if startTime and endTime absent or if additionalInfoUri provided
     *
     * @return additionalInfo
     */
    @ApiModelProperty(required = true, value = "Display text providing more information on the contrlled load, for e.g. controlled load availability if specific day/time is not known. Required if startTime and endTime absent or if additionalInfoUri provided")
    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    /**
     * Optional link to additional information regarding the controlled load
     *
     * @return additionalInfoUri
     */
    @ApiModelProperty(required = true, value = "Optional link to additional information regarding the controlled load")
    public URI getAdditionalInfoUri() {
        return additionalInfoUri;
    }

    public void setAdditionalInfoUri(URI additionalInfoUri) {
        this.additionalInfoUri = additionalInfoUri;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EnergyPlanControlledLoadTimeOfUse energyTimeOfUse = (EnergyPlanControlledLoadTimeOfUse) o;
        return Objects.equals(this.days, energyTimeOfUse.days) &&
                Objects.equals(this.startTime, energyTimeOfUse.startTime) &&
                Objects.equals(this.endTime, energyTimeOfUse.endTime) &&
                Objects.equals(this.additionalInfo, energyTimeOfUse.additionalInfo) &&
                Objects.equals(this.additionalInfoUri, energyTimeOfUse.additionalInfoUri);
    }

    @Override
    public int hashCode() {
        return Objects.hash(days, startTime, endTime, additionalInfo, additionalInfoUri);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyTimeOfUse {\n");
        sb.append("    days: ").append(toIndentedString(days)).append("\n");
        sb.append("    startTime: ").append(toIndentedString(startTime)).append("\n");
        sb.append("    endTime: ").append(toIndentedString(endTime)).append("\n");
        sb.append("    additionalInfo: ").append(toIndentedString(additionalInfo)).append("\n");
        sb.append("    additionalInfoUri: ").append(toIndentedString(additionalInfoUri)).append("\n");
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
