package au.org.consumerdatastandards.holder.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;
import java.time.OffsetDateTime;

@ApiModel
public class DiscoveryOutage  {

    /**
     * Planned duration of the outage. Formatted according to [ISO 8601 Durations](https://en.wikipedia.org/wiki/ISO_8601#Durations)
     */
    private String duration;

    /**
     * Provides an explanation of the current outage that can be displayed to an end customer
     */
    private String explanation;

    /**
     * Flag that indicates, if present and set to true, that the outage is only partial meaning that only a subset of normally available end points will be affected by the outage
     */
    private Boolean isPartial;

    /**
     * Date and time that the outage is scheduled to begin
     */
    private OffsetDateTime outageTime;

    public DiscoveryOutage duration(String duration) {
        this.duration = duration;
        return this;
    }

    @ApiModelProperty(required = true, value = "Planned duration of the outage. Formatted according to [ISO 8601 Durations](https://en.wikipedia.org/wiki/ISO_8601#Durations)")
    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
    public DiscoveryOutage explanation(String explanation) {
        this.explanation = explanation;
        return this;
    }

    @ApiModelProperty(required = true, value = "Provides an explanation of the current outage that can be displayed to an end customer")
    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }
    public DiscoveryOutage isPartial(Boolean isPartial) {
        this.isPartial = isPartial;
        return this;
    }

    @ApiModelProperty(value = "Flag that indicates, if present and set to true, that the outage is only partial meaning that only a subset of normally available end points will be affected by the outage")
    public Boolean getIsPartial() {
        return isPartial;
    }

    public void setIsPartial(Boolean isPartial) {
        this.isPartial = isPartial;
    }
    public DiscoveryOutage outageTime(OffsetDateTime outageTime) {
        this.outageTime = outageTime;
        return this;
    }

    @ApiModelProperty(required = true, value = "Date and time that the outage is scheduled to begin")
    public OffsetDateTime getOutageTime() {
        return outageTime;
    }

    public void setOutageTime(OffsetDateTime outageTime) {
        this.outageTime = outageTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DiscoveryOutage discoveryOutage = (DiscoveryOutage) o;
        return Objects.equals(this.duration, discoveryOutage.duration) &&
            Objects.equals(this.explanation, discoveryOutage.explanation) &&
            Objects.equals(this.isPartial, discoveryOutage.isPartial) &&
            Objects.equals(this.outageTime, discoveryOutage.outageTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            duration,
            explanation,
            isPartial,
            outageTime);
    }

    @Override
    public String toString() {
        return "class DiscoveryOutage {\n" +
            "   duration: " + toIndentedString(duration) + "\n" + 
            "   explanation: " + toIndentedString(explanation) + "\n" + 
            "   isPartial: " + toIndentedString(isPartial) + "\n" + 
            "   outageTime: " + toIndentedString(outageTime) + "\n" + 
            "}";
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

