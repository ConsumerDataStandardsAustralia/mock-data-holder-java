package au.org.consumerdatastandards.holder.model.telco;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * Summary of SMS Balance. Required if the service plan supports SMS messaging
 */
@ApiModel(description = "Summary of SMS Balance. Required if the service plan supports SMS messaging")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen",
        date = "2022-12-23T11:32:06.900+11:00[Australia/Sydney]")
public class TelcoServiceBalanceMessagingSms {
    @JsonProperty("description")
    private String description;

    @JsonProperty("national")
    private BigDecimal national;

    @JsonProperty("international")
    private BigDecimal international;

    @JsonProperty("roaming")
    private BigDecimal roaming;

    @JsonProperty("amount")
    private String amount;

    public TelcoServiceBalanceMessagingSms description(String description) {
        this.description = description;
        return this;
    }

    /**
     * An overview of plan limits. Required unless planType is UNSUPPORTED
     *
     * @return description
     */
    @ApiModelProperty(value = "An overview of plan limits. Required unless planType is UNSUPPORTED")


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TelcoServiceBalanceMessagingSms national(BigDecimal national) {
        this.national = national;
        return this;
    }

    /**
     * Number of national SMS messages remaining. Required unless planType is UNSUPPORTED or UNMETERED
     *
     * @return national
     */
    @ApiModelProperty(value = "Number of national SMS messages remaining. Required unless planType is UNSUPPORTED or UNMETERED")

    @Valid

    public BigDecimal getNational() {
        return national;
    }

    public void setNational(BigDecimal national) {
        this.national = national;
    }

    public TelcoServiceBalanceMessagingSms international(BigDecimal international) {
        this.international = international;
        return this;
    }

    /**
     * Number of international SMS messages remaining. Required unless planType is UNSUPPORTED or UNMETERED
     *
     * @return international
     */
    @ApiModelProperty(value = "Number of international SMS messages remaining. Required unless planType is UNSUPPORTED or UNMETERED")

    @Valid

    public BigDecimal getInternational() {
        return international;
    }

    public void setInternational(BigDecimal international) {
        this.international = international;
    }

    public TelcoServiceBalanceMessagingSms roaming(BigDecimal roaming) {
        this.roaming = roaming;
        return this;
    }

    /**
     * Number of roaming SMS messages remaining. Required unless planType is UNSUPPORTED or UNMETERED
     *
     * @return roaming
     */
    @ApiModelProperty(value = "Number of roaming SMS messages remaining. Required unless planType is UNSUPPORTED or UNMETERED")

    @Valid

    public BigDecimal getRoaming() {
        return roaming;
    }

    public void setRoaming(BigDecimal roaming) {
        this.roaming = roaming;
    }

    public TelcoServiceBalanceMessagingSms amount(String amount) {
        this.amount = amount;
        return this;
    }

    /**
     * Amount value of SMS messages remaining. Required unless planType is UNSUPPORTED or UNMETERED
     *
     * @return amount
     */
    @ApiModelProperty(value = "Amount value of SMS messages remaining. Required unless planType is UNSUPPORTED or UNMETERED")


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
        TelcoServiceBalanceMessagingSms telcoServiceBalanceMessagingSms = (TelcoServiceBalanceMessagingSms) o;
        return Objects.equals(this.description, telcoServiceBalanceMessagingSms.description) &&
                Objects.equals(this.national, telcoServiceBalanceMessagingSms.national) &&
                Objects.equals(this.international, telcoServiceBalanceMessagingSms.international) &&
                Objects.equals(this.roaming, telcoServiceBalanceMessagingSms.roaming) &&
                Objects.equals(this.amount, telcoServiceBalanceMessagingSms.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, national, international, roaming, amount);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TelcoServiceBalanceMessagingSms {\n");

        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    national: ").append(toIndentedString(national)).append("\n");
        sb.append("    international: ").append(toIndentedString(international)).append("\n");
        sb.append("    roaming: ").append(toIndentedString(roaming)).append("\n");
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

