package au.org.consumerdatastandards.holder.model.telco;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * Summary of MMS Balance. Required if the service plan supports MMS messaging.
 */
@ApiModel(description = "Summary of MMS Balance. Required if the service plan supports MMS messaging.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen",
        date = "2022-12-23T11:32:06.900+11:00[Australia/Sydney]")
public class TelcoServiceBalanceMessagingMms {
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

    public TelcoServiceBalanceMessagingMms description(String description) {
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

    public TelcoServiceBalanceMessagingMms national(BigDecimal national) {
        this.national = national;
        return this;
    }

    /**
     * Number of national MMS messages remaining. Required unless _planType_ is `UNSUPPORTED` or `UNMETERED`.
     *
     * @return national
     */
    @ApiModelProperty(value = "Number of national MMS messages remaining. Required unless _planType_ is `UNSUPPORTED` or `UNMETERED`.")

    @Valid

    public BigDecimal getNational() {
        return national;
    }

    public void setNational(BigDecimal national) {
        this.national = national;
    }

    public TelcoServiceBalanceMessagingMms international(BigDecimal international) {
        this.international = international;
        return this;
    }

    /**
     * Number of international MMS messages remaining. Required unless _planType_ is `UNSUPPORTED` or `UNMETERED`.
     *
     * @return international
     */
    @ApiModelProperty(value = "Number of international MMS messages remaining. Required unless _planType_ is `UNSUPPORTED` or `UNMETERED`.")

    @Valid

    public BigDecimal getInternational() {
        return international;
    }

    public void setInternational(BigDecimal international) {
        this.international = international;
    }

    public TelcoServiceBalanceMessagingMms roaming(BigDecimal roaming) {
        this.roaming = roaming;
        return this;
    }

    /**
     * Number of roaming MMS messages remaining. Required unless _planType_ is `UNSUPPORTED` or `UNMETERED`.
     *
     * @return roaming
     */
    @ApiModelProperty(value = "Number of roaming MMS messages remaining. Required unless _planType_ is `UNSUPPORTED` or `UNMETERED`.")

    @Valid

    public BigDecimal getRoaming() {
        return roaming;
    }

    public void setRoaming(BigDecimal roaming) {
        this.roaming = roaming;
    }

    public TelcoServiceBalanceMessagingMms amount(String amount) {
        this.amount = amount;
        return this;
    }

    /**
     * Amount value of MMS messages remaining. Required unless _planType_ is `UNSUPPORTED` or `UNMETERED`.
     *
     * @return amount
     */
    @ApiModelProperty(value = "Amount value of MMS messages remaining. Required unless _planType_ is `UNSUPPORTED` or `UNMETERED`.")


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
        TelcoServiceBalanceMessagingMms telcoServiceBalanceMessagingMms = (TelcoServiceBalanceMessagingMms) o;
        return Objects.equals(this.description, telcoServiceBalanceMessagingMms.description) &&
                Objects.equals(this.national, telcoServiceBalanceMessagingMms.national) &&
                Objects.equals(this.international, telcoServiceBalanceMessagingMms.international) &&
                Objects.equals(this.roaming, telcoServiceBalanceMessagingMms.roaming) &&
                Objects.equals(this.amount, telcoServiceBalanceMessagingMms.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, national, international, roaming, amount);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TelcoServiceBalanceMessagingMms {\n");

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

