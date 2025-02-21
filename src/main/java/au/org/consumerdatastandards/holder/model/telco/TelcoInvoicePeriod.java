package au.org.consumerdatastandards.holder.model.telco;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * Object containing the start and end date for the period covered by the invoice. Mandatory if any usage based charges are included in the invoice.
 */
@ApiModel(description = "Object containing the start and end date for the period covered by the invoice. Mandatory if any usage based charges are included in the invoice.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen",
        date = "2022-12-23T11:32:06.900+11:00[Australia/Sydney]")
public class TelcoInvoicePeriod {
    @JsonProperty("startDate")
    private String startDate;

    @JsonProperty("endDate")
    private String endDate;

    public TelcoInvoicePeriod startDate(String startDate) {
        this.startDate = startDate;
        return this;
    }

    /**
     * The start date of the period covered by this invoice.
     *
     * @return startDate
     */
    @ApiModelProperty(required = true,
            value = "The start date of the period covered by this invoice.")
    @NotNull


    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public TelcoInvoicePeriod endDate(String endDate) {
        this.endDate = endDate;
        return this;
    }

    /**
     * The end date of the period covered by this invoice.
     *
     * @return endDate
     */
    @ApiModelProperty(required = true,
            value = "The end date of the period covered by this invoice.")
    @NotNull


    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TelcoInvoicePeriod telcoInvoicePeriod = (TelcoInvoicePeriod) o;
        return Objects.equals(this.startDate, telcoInvoicePeriod.startDate) &&
                Objects.equals(this.endDate, telcoInvoicePeriod.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startDate, endDate);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TelcoInvoicePeriod {\n");

        sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
        sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
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

