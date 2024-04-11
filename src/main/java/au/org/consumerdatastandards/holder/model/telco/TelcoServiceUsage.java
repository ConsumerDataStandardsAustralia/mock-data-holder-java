package au.org.consumerdatastandards.holder.model.telco;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.OffsetDateTime;
import java.util.Objects;

/**
 * TelcoServiceUsage
 */
public class TelcoServiceUsage {
    private String serviceId;

    private String displayName;

    private String phoneNumber;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private OffsetDateTime startDate;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private OffsetDateTime endDate;

    private TelcoUsage usage;

    public TelcoServiceUsage serviceId(String serviceId) {
        this.serviceId = serviceId;
        return this;
    }

    /**
     * Tokenised ID of the service identifier. E.g. a mobile [MSISDN](https://www.etsi.org/deliver/etsi_gts/03/0303/05.00.00_60/gsmts_0303v050000p.pdf), [FNN](https://www.nbnco.com.au/content/dam/nbnco2/documents/sfaa-wba2-dictionary_FTTN-launch.pdf) or internet service e.g [NBN AVC Service ID](https://www.nbnco.com.au/content/dam/nbnco2/documents/sfaa-wba2-dictionary_FTTN-launch.pdf). To be created in accordance with [CDR ID permanence](#id-permanence) requirements
     *
     * @return serviceId
     */
    @ApiModelProperty(required = true,
            value = "Tokenised ID of the service identifier. E.g. a mobile [MSISDN](https://www.etsi.org/deliver/etsi_gts/03/0303/05.00.00_60/gsmts_0303v050000p.pdf), [FNN](https://www.nbnco.com.au/content/dam/nbnco2/documents/sfaa-wba2-dictionary_FTTN-launch.pdf) or internet service e.g [NBN AVC Service ID](https://www.nbnco.com.au/content/dam/nbnco2/documents/sfaa-wba2-dictionary_FTTN-launch.pdf). To be created in accordance with [CDR ID permanence](#id-permanence) requirements")
    @NotNull
    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public TelcoServiceUsage displayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    /**
     * Optional description of the service used for display purposes
     *
     * @return displayName
     */
    @ApiModelProperty(value = "Optional description of the service used for display purposes")
    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public TelcoServiceUsage phoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    /**
     * Required if the service includes a phone number
     *
     * @return phoneNumber
     */
    @ApiModelProperty(value = "Required if the service includes a phone number")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public TelcoServiceUsage startDate(OffsetDateTime startDate) {
        this.startDate = startDate;
        return this;
    }

    /**
     * Date when the usage period started
     *
     * @return startDate
     */
    @ApiModelProperty(required = true, value = "Date when the usage period started")
    public OffsetDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(OffsetDateTime startDate) {
        this.startDate = startDate;
    }

    public TelcoServiceUsage endDate(OffsetDateTime endDate) {
        this.endDate = endDate;
        return this;
    }

    /**
     * Date when the usage period ends
     *
     * @return endDate
     */
    @ApiModelProperty(value = "Date when the usage period ends")
    public OffsetDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(OffsetDateTime endDate) {
        this.endDate = endDate;
    }

    public TelcoServiceUsage usage(TelcoUsage usage) {
        this.usage = usage;
        return this;
    }

    /**
     * Get usage
     *
     * @return usage
     */
    @ApiModelProperty(value = "")
    @Valid
    public TelcoUsage getUsage() {
        return usage;
    }

    public void setUsage(TelcoUsage usage) {
        this.usage = usage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TelcoServiceUsage telcoServiceUsage = (TelcoServiceUsage) o;
        return Objects.equals(this.serviceId, telcoServiceUsage.serviceId) &&
                Objects.equals(this.displayName, telcoServiceUsage.displayName) &&
                Objects.equals(this.phoneNumber, telcoServiceUsage.phoneNumber) &&
                Objects.equals(this.startDate, telcoServiceUsage.startDate) &&
                Objects.equals(this.endDate, telcoServiceUsage.endDate) &&
                Objects.equals(this.usage, telcoServiceUsage.usage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serviceId, displayName, phoneNumber, startDate, endDate, usage);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TelcoServiceUsage {\n");
        sb.append("    serviceId: ").append(toIndentedString(serviceId)).append("\n");
        sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
        sb.append("    phoneNumber: ").append(toIndentedString(phoneNumber)).append("\n");
        sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
        sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
        sb.append("    usage: ").append(toIndentedString(usage)).append("\n");
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
