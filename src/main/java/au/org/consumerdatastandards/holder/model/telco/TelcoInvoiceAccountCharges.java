package au.org.consumerdatastandards.holder.model.telco;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * Object contain charges and credits related to usage.
 */
@ApiModel(description = "Object contain charges and credits related to usage.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen",
        date = "2022-12-23T11:32:06.900+11:00[Australia/Sydney]")
public class TelcoInvoiceAccountCharges {
    @JsonProperty("totalUsageCharges")
    private String totalUsageCharges;

    @JsonProperty("totalOnceOffCharges")
    private String totalOnceOffCharges;

    @JsonProperty("totalDiscounts")
    private String totalDiscounts;

    @JsonProperty("otherCharges")
    private TelcoInvoiceAccountChargesOtherCharges otherCharges;

    @JsonProperty("totalGst")
    private String totalGst;

    public TelcoInvoiceAccountCharges totalUsageCharges(String totalUsageCharges) {
        this.totalUsageCharges = totalUsageCharges;
        return this;
    }

    /**
     * The aggregate total of usage charges for the period covered by the invoice (exclusive of GST).
     *
     * @return totalUsageCharges
     */
    @ApiModelProperty(required = true,
            value = "The aggregate total of usage charges for the period covered by the invoice (exclusive of GST).")
    @NotNull


    public String getTotalUsageCharges() {
        return totalUsageCharges;
    }

    public void setTotalUsageCharges(String totalUsageCharges) {
        this.totalUsageCharges = totalUsageCharges;
    }

    public TelcoInvoiceAccountCharges totalOnceOffCharges(String totalOnceOffCharges) {
        this.totalOnceOffCharges = totalOnceOffCharges;
        return this;
    }

    /**
     * The aggregate total of any once off charges arising from usage for the period covered by the invoice (exclusive of GST).
     *
     * @return totalOnceOffCharges
     */
    @ApiModelProperty(required = true,
            value = "The aggregate total of any once off charges arising from usage for the period covered by the invoice (exclusive of GST).")
    @NotNull


    public String getTotalOnceOffCharges() {
        return totalOnceOffCharges;
    }

    public void setTotalOnceOffCharges(String totalOnceOffCharges) {
        this.totalOnceOffCharges = totalOnceOffCharges;
    }

    public TelcoInvoiceAccountCharges totalDiscounts(String totalDiscounts) {
        this.totalDiscounts = totalDiscounts;
        return this;
    }

    /**
     * The aggregate total of account level discounts or credits for the period covered by the invoice.
     *
     * @return totalDiscounts
     */
    @ApiModelProperty(required = true,
            value = "The aggregate total of account level discounts or credits for the period covered by the invoice.")
    @NotNull


    public String getTotalDiscounts() {
        return totalDiscounts;
    }

    public void setTotalDiscounts(String totalDiscounts) {
        this.totalDiscounts = totalDiscounts;
    }

    public TelcoInvoiceAccountCharges otherCharges(TelcoInvoiceAccountChargesOtherCharges otherCharges) {
        this.otherCharges = otherCharges;
        return this;
    }

    /**
     * Get otherCharges
     *
     * @return otherCharges
     */
    @ApiModelProperty(value = "")

    @Valid

    public TelcoInvoiceAccountChargesOtherCharges getOtherCharges() {
        return otherCharges;
    }

    public void setOtherCharges(TelcoInvoiceAccountChargesOtherCharges otherCharges) {
        this.otherCharges = otherCharges;
    }

    public TelcoInvoiceAccountCharges totalGst(String totalGst) {
        this.totalGst = totalGst;
        return this;
    }

    /**
     * The total GST for all account level charges. If absent then zero is assumed.
     *
     * @return totalGst
     */
    @ApiModelProperty(value = "The total GST for all account level charges. If absent then zero is assumed.")


    public String getTotalGst() {
        return totalGst;
    }

    public void setTotalGst(String totalGst) {
        this.totalGst = totalGst;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TelcoInvoiceAccountCharges telcoInvoiceAccountCharges = (TelcoInvoiceAccountCharges) o;
        return Objects.equals(this.totalUsageCharges, telcoInvoiceAccountCharges.totalUsageCharges) &&
                Objects.equals(this.totalOnceOffCharges, telcoInvoiceAccountCharges.totalOnceOffCharges) &&
                Objects.equals(this.totalDiscounts, telcoInvoiceAccountCharges.totalDiscounts) &&
                Objects.equals(this.otherCharges, telcoInvoiceAccountCharges.otherCharges) &&
                Objects.equals(this.totalGst, telcoInvoiceAccountCharges.totalGst);
    }

    @Override
    public int hashCode() {
        return Objects.hash(totalUsageCharges, totalOnceOffCharges, totalDiscounts, otherCharges, totalGst);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TelcoInvoiceAccountCharges {\n");

        sb.append("    totalUsageCharges: ").append(toIndentedString(totalUsageCharges)).append("\n");
        sb.append("    totalOnceOffCharges: ").append(toIndentedString(totalOnceOffCharges)).append("\n");
        sb.append("    totalDiscounts: ").append(toIndentedString(totalDiscounts)).append("\n");
        sb.append("    otherCharges: ").append(toIndentedString(otherCharges)).append("\n");
        sb.append("    totalGst: ").append(toIndentedString(totalGst)).append("\n");
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

