package au.org.consumerdatastandards.holder.model.telco;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * International voice calls. Requied if international calling is supported.
 */
@ApiModel(description = "International voice calls. Requied if international calling is supported.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen",
        date = "2022-12-23T11:32:06.900+11:00[Australia/Sydney]")
public class TelcoUsageVoiceInternational {
    @JsonProperty("duration")
    private String duration;

    @JsonProperty("number")
    private BigDecimal number;

    @JsonProperty("amount")
    private String amount;

    public TelcoUsageVoiceInternational duration(String duration) {
        this.duration = duration;
        return this;
    }

    /**
     * Total duration (hours, minutes, and seconds) of international voice calls. Not limited to 24hrs.
     *
     * @return duration
     */
    @ApiModelProperty(required = true,
            value = "Total duration (hours, minutes, and seconds) of international voice calls. Not limited to 24hrs.")
    @NotNull


    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public TelcoUsageVoiceInternational number(BigDecimal number) {
        this.number = number;
        return this;
    }

    /**
     * Number of international voice calls.
     *
     * @return number
     */
    @ApiModelProperty(required = true,
            value = "Number of international voice calls.")
    @NotNull

    @Valid

    public BigDecimal getNumber() {
        return number;
    }

    public void setNumber(BigDecimal number) {
        this.number = number;
    }

    public TelcoUsageVoiceInternational amount(String amount) {
        this.amount = amount;
        return this;
    }

    /**
     * Cost amount of international voice calls.
     *
     * @return amount
     */
    @ApiModelProperty(required = true,
            value = "Cost amount of international voice calls.")
    @NotNull


    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TelcoUsageVoiceInternational telcoUsageVoiceInternational = (TelcoUsageVoiceInternational) o;
        return Objects.equals(this.duration, telcoUsageVoiceInternational.duration) &&
                Objects.equals(this.number, telcoUsageVoiceInternational.number) &&
                Objects.equals(this.amount, telcoUsageVoiceInternational.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(duration, number, amount);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TelcoUsageVoiceInternational {\n");

        sb.append("    duration: ").append(toIndentedString(duration)).append("\n");
        sb.append("    number: ").append(toIndentedString(number)).append("\n");
        sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
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

