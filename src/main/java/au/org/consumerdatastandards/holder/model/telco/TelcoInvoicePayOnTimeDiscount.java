package au.org.consumerdatastandards.holder.model.telco;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * A discount for on time payment.
 */
@ApiModel(description = "A discount for on time payment.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen",
        date = "2022-12-23T11:32:06.900+11:00[Australia/Sydney]")
public class TelcoInvoicePayOnTimeDiscount {
    @JsonProperty("discountAmount")
    private String discountAmount;

    @JsonProperty("gstAmount")
    private String gstAmount;

    @JsonProperty("date")
    private String date;

    public TelcoInvoicePayOnTimeDiscount discountAmount(String discountAmount) {
        this.discountAmount = discountAmount;
        return this;
    }

    /**
     * The amount that will be discounted if the invoice is paid by the date specified.
     *
     * @return discountAmount
     */
    @ApiModelProperty(required = true,
            value = "The amount that will be discounted if the invoice is paid by the date specified.")
    @NotNull


    public String getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(String discountAmount) {
        this.discountAmount = discountAmount;
    }

    public TelcoInvoicePayOnTimeDiscount gstAmount(String gstAmount) {
        this.gstAmount = gstAmount;
        return this;
    }

    /**
     * The GST amount that will be discounted if the invoice is paid by the date specified. If absent then zero is assumed.
     *
     * @return gstAmount
     */
    @ApiModelProperty(value = "The GST amount that will be discounted if the invoice is paid by the date specified. If absent then zero is assumed.")


    public String getGstAmount() {
        return gstAmount;
    }

    public void setGstAmount(String gstAmount) {
        this.gstAmount = gstAmount;
    }

    public TelcoInvoicePayOnTimeDiscount date(String date) {
        this.date = date;
        return this;
    }

    /**
     * The date by which the invoice must be paid to receive the pay on time discount.
     *
     * @return date
     */
    @ApiModelProperty(required = true,
            value = "The date by which the invoice must be paid to receive the pay on time discount.")
    @NotNull


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TelcoInvoicePayOnTimeDiscount telcoInvoicePayOnTimeDiscount = (TelcoInvoicePayOnTimeDiscount) o;
        return Objects.equals(this.discountAmount, telcoInvoicePayOnTimeDiscount.discountAmount) &&
                Objects.equals(this.gstAmount, telcoInvoicePayOnTimeDiscount.gstAmount) &&
                Objects.equals(this.date, telcoInvoicePayOnTimeDiscount.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(discountAmount, gstAmount, date);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TelcoInvoicePayOnTimeDiscount {\n");

        sb.append("    discountAmount: ").append(toIndentedString(discountAmount)).append("\n");
        sb.append("    gstAmount: ").append(toIndentedString(gstAmount)).append("\n");
        sb.append("    date: ").append(toIndentedString(date)).append("\n");
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

