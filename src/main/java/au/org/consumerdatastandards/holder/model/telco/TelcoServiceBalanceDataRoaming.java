package au.org.consumerdatastandards.holder.model.telco;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * Balance of data roaming charges. Required unless _planType_ is `UNSUPPORTED`.
 */
@ApiModel(description = "Balance of data roaming charges. Required unless _planType_ is `UNSUPPORTED`.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen",
        date = "2022-12-23T11:32:06.900+11:00[Australia/Sydney]")
public class TelcoServiceBalanceDataRoaming {
    @JsonProperty("description")
    private String description;

    @JsonProperty("download")
    private BigDecimal download;

    @JsonProperty("amount")
    private String amount;

    public TelcoServiceBalanceDataRoaming description(String description) {
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

    public TelcoServiceBalanceDataRoaming download(BigDecimal download) {
        this.download = download;
        return this;
    }

    /**
     * Amount of data used overseas in megabytes (MB). Required unless _planType_ is `UNSUPPORTED`.
     *
     * @return download
     */
    @ApiModelProperty(value = "Amount of data used overseas in megabytes (MB). Required unless _planType_ is `UNSUPPORTED`.")

    @Valid

    public BigDecimal getDownload() {
        return download;
    }

    public void setDownload(BigDecimal download) {
        this.download = download;
    }

    public TelcoServiceBalanceDataRoaming amount(String amount) {
        this.amount = amount;
        return this;
    }

    /**
     * Amount value of data roaming charges. Required unless _planType_ is `UNSUPPORTED`.
     *
     * @return amount
     */
    @ApiModelProperty(value = "Amount value of data roaming charges. Required unless _planType_ is `UNSUPPORTED`.")


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
        TelcoServiceBalanceDataRoaming telcoServiceBalanceDataRoaming = (TelcoServiceBalanceDataRoaming) o;
        return Objects.equals(this.description, telcoServiceBalanceDataRoaming.description) &&
                Objects.equals(this.download, telcoServiceBalanceDataRoaming.download) &&
                Objects.equals(this.amount, telcoServiceBalanceDataRoaming.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, download, amount);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TelcoServiceBalanceDataRoaming {\n");

        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    download: ").append(toIndentedString(download)).append("\n");
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

