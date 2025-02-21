package au.org.consumerdatastandards.holder.model.telco;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * National voice calls.
 */
@ApiModel(description = "National voice calls.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen",
        date = "2022-12-23T11:32:06.900+11:00[Australia/Sydney]")
public class TelcoServiceBalanceVoiceNational {
    @JsonProperty("description")
    private String description;

    @JsonProperty("duration")
    private String duration;

    @JsonProperty("number")
    private BigDecimal number;

    @JsonProperty("amount")
    private String amount;

    public TelcoServiceBalanceVoiceNational description(String description) {
        this.description = description;
        return this;
    }

    /**
     * An overview of plan limits. Required unless _planType_ is `UNSUPPORTED`.
     *
     * @return description
     */
    @ApiModelProperty(value = "An overview of plan limits. Required unless _planType_ is `UNSUPPORTED`.")


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TelcoServiceBalanceVoiceNational duration(String duration) {
        this.duration = duration;
        return this;
    }

    /**
     * Total duration (hours, minutes, and seconds) of national voice calls. Not limited to 24hrs. Required unless _planType_ is `UNSUPPORTED` or `UNMETERED`.
     *
     * @return duration
     */
    @ApiModelProperty(value = "Total duration (hours, minutes, and seconds) of national voice calls. Not limited to 24hrs. Required unless _planType_ is `UNSUPPORTED` or `UNMETERED`.")


    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public TelcoServiceBalanceVoiceNational number(BigDecimal number) {
        this.number = number;
        return this;
    }

    /**
     * Number of national voice calls. Required unless _planType_ is `UNSUPPORTED` or `UNMETERED`.
     *
     * @return number
     */
    @ApiModelProperty(value = "Number of national voice calls. Required unless _planType_ is `UNSUPPORTED` or `UNMETERED`.")

    @Valid

    public BigDecimal getNumber() {
        return number;
    }

    public void setNumber(BigDecimal number) {
        this.number = number;
    }

    public TelcoServiceBalanceVoiceNational amount(String amount) {
        this.amount = amount;
        return this;
    }

    /**
     * Amount balance of national calls. Required unless _planType_ is `UNSUPPORTED` or `UNMETERED`.
     *
     * @return amount
     */
    @ApiModelProperty(value = "Amount balance of national calls. Required unless _planType_ is `UNSUPPORTED` or `UNMETERED`.")


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
        TelcoServiceBalanceVoiceNational telcoServiceBalanceVoiceNational = (TelcoServiceBalanceVoiceNational) o;
        return Objects.equals(this.description, telcoServiceBalanceVoiceNational.description) &&
                Objects.equals(this.duration, telcoServiceBalanceVoiceNational.duration) &&
                Objects.equals(this.number, telcoServiceBalanceVoiceNational.number) &&
                Objects.equals(this.amount, telcoServiceBalanceVoiceNational.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, duration, number, amount);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TelcoServiceBalanceVoiceNational {\n");

        sb.append("    description: ").append(toIndentedString(description)).append("\n");
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

