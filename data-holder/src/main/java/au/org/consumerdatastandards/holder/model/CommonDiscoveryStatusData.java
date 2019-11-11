package au.org.consumerdatastandards.holder.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;
import java.time.OffsetDateTime;

@ApiModel
public class CommonDiscoveryStatusData  {

    /**
     * The date and time that the current outage was detected. Should only be present if the status property is PARTIAL_FAILURE or UNAVAILABLE
     */
    private OffsetDateTime detectionTime;

    /**
     * The date and time that full service is expected to resume (if known). Should not be present if the status property has a value of OK.
     */
    private OffsetDateTime expectedResolutionTime;

    /**
     * Provides an explanation of the current outage that can be displayed to an end customer. Mandatory if the status property is any value other than OK
     */
    private String explanation;

    private Status status;

    /**
     * The date and time that this status was last updated by the Data Holder.
     */
    private OffsetDateTime updateTime;

    public CommonDiscoveryStatusData detectionTime(OffsetDateTime detectionTime) {
        this.detectionTime = detectionTime;
        return this;
    }

    @ApiModelProperty(value = "The date and time that the current outage was detected. Should only be present if the status property is PARTIAL_FAILURE or UNAVAILABLE")
    public OffsetDateTime getDetectionTime() {
        return detectionTime;
    }

    public void setDetectionTime(OffsetDateTime detectionTime) {
        this.detectionTime = detectionTime;
    }
    public CommonDiscoveryStatusData expectedResolutionTime(OffsetDateTime expectedResolutionTime) {
        this.expectedResolutionTime = expectedResolutionTime;
        return this;
    }

    @ApiModelProperty(value = "The date and time that full service is expected to resume (if known). Should not be present if the status property has a value of OK.")
    public OffsetDateTime getExpectedResolutionTime() {
        return expectedResolutionTime;
    }

    public void setExpectedResolutionTime(OffsetDateTime expectedResolutionTime) {
        this.expectedResolutionTime = expectedResolutionTime;
    }
    public CommonDiscoveryStatusData explanation(String explanation) {
        this.explanation = explanation;
        return this;
    }

    @ApiModelProperty(value = "Provides an explanation of the current outage that can be displayed to an end customer. Mandatory if the status property is any value other than OK")
    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }
    public CommonDiscoveryStatusData status(Status status) {
        this.status = status;
        return this;
    }

    @ApiModelProperty(required = true)
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
    public CommonDiscoveryStatusData updateTime(OffsetDateTime updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    @ApiModelProperty(required = true, value = "The date and time that this status was last updated by the Data Holder.")
    public OffsetDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(OffsetDateTime updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CommonDiscoveryStatusData commonDiscoveryStatusData = (CommonDiscoveryStatusData) o;
        return Objects.equals(this.detectionTime, commonDiscoveryStatusData.detectionTime) &&
            Objects.equals(this.expectedResolutionTime, commonDiscoveryStatusData.expectedResolutionTime) &&
            Objects.equals(this.explanation, commonDiscoveryStatusData.explanation) &&
            Objects.equals(this.status, commonDiscoveryStatusData.status) &&
            Objects.equals(this.updateTime, commonDiscoveryStatusData.updateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            detectionTime,
            expectedResolutionTime,
            explanation,
            status,
            updateTime);
    }

    @Override
    public String toString() {
        return "class CommonDiscoveryStatusData {\n" +
            "   detectionTime: " + toIndentedString(detectionTime) + "\n" + 
            "   expectedResolutionTime: " + toIndentedString(expectedResolutionTime) + "\n" + 
            "   explanation: " + toIndentedString(explanation) + "\n" + 
            "   status: " + toIndentedString(status) + "\n" + 
            "   updateTime: " + toIndentedString(updateTime) + "\n" + 
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

    public enum Status {
        OK,
        PARTIAL_FAILURE,
        SCHEDULED_OUTAGE,
        UNAVAILABLE
    }
}

