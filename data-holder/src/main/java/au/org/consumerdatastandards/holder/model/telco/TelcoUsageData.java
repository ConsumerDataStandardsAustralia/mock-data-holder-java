package au.org.consumerdatastandards.holder.model.telco;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * Summary of data usage
 */
@ApiModel(description = "Summary of data usage")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen",
        date = "2022-12-23T11:32:06.900+11:00[Australia/Sydney]")
public class TelcoUsageData {
    @JsonProperty("upload")
    private BigDecimal upload;

    @JsonProperty("download")
    private BigDecimal download;

    @JsonProperty("sessions")
    private BigDecimal sessions;

    @JsonProperty("amount")
    private String amount;

    @JsonProperty("roaming")
    private TelcoUsageDatRoaming roaming;

    public TelcoUsageData upload(BigDecimal upload) {
        this.upload = upload;
        return this;
    }

    /**
     * Amount of data uploaded in megabytes (MB)
     *
     * @return upload
     */
    @ApiModelProperty(required = true,
            value = "Amount of data uploaded in megabytes (MB)")
    @NotNull

    @Valid

    public BigDecimal getUpload() {
        return upload;
    }

    public void setUpload(BigDecimal upload) {
        this.upload = upload;
    }

    public TelcoUsageData download(BigDecimal download) {
        this.download = download;
        return this;
    }

    /**
     * Amount of data downloaded in megabytes (MB)
     *
     * @return download
     */
    @ApiModelProperty(required = true,
            value = "Amount of data downloaded in megabytes (MB)")
    @NotNull

    @Valid

    public BigDecimal getDownload() {
        return download;
    }

    public void setDownload(BigDecimal download) {
        this.download = download;
    }

    public TelcoUsageData sessions(BigDecimal sessions) {
        this.sessions = sessions;
        return this;
    }

    /**
     * Number of data sessions
     *
     * @return sessions
     */
    @ApiModelProperty(value = "Number of data sessions")

    @Valid

    public BigDecimal getSessions() {
        return sessions;
    }

    public void setSessions(BigDecimal sessions) {
        this.sessions = sessions;
    }

    public TelcoUsageData amount(String amount) {
        this.amount = amount;
        return this;
    }

    /**
     * Cost amount of data usage
     *
     * @return amount
     */
    @ApiModelProperty(required = true,
            value = "Cost amount of data usage")
    @NotNull


    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public TelcoUsageData roaming(TelcoUsageDatRoaming roaming) {
        this.roaming = roaming;
        return this;
    }

    /**
     * Get roaming
     *
     * @return roaming
     */
    @ApiModelProperty(value = "")

    @Valid

    public TelcoUsageDatRoaming getRoaming() {
        return roaming;
    }

    public void setRoaming(TelcoUsageDatRoaming roaming) {
        this.roaming = roaming;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TelcoUsageData telcoUsageData = (TelcoUsageData) o;
        return Objects.equals(this.upload, telcoUsageData.upload) &&
                Objects.equals(this.download, telcoUsageData.download) &&
                Objects.equals(this.sessions, telcoUsageData.sessions) &&
                Objects.equals(this.amount, telcoUsageData.amount) &&
                Objects.equals(this.roaming, telcoUsageData.roaming);
    }

    @Override
    public int hashCode() {
        return Objects.hash(upload, download, sessions, amount, roaming);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TelcoUsageData {\n");

        sb.append("    upload: ").append(toIndentedString(upload)).append("\n");
        sb.append("    download: ").append(toIndentedString(download)).append("\n");
        sb.append("    sessions: ").append(toIndentedString(sessions)).append("\n");
        sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
        sb.append("    roaming: ").append(toIndentedString(roaming)).append("\n");
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

