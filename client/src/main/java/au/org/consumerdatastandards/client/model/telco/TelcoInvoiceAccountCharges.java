package au.org.consumerdatastandards.client.model.telco;

import java.util.Objects;

/**
 * Object contain charges and credits related to usage
 */
public class TelcoInvoiceAccountCharges {
    private String totalUsageCharges;

    private String totalOnceOffCharges;

    private String totalDiscounts;

    private TelcoInvoiceAccountChargesOtherCharges otherCharges;

    private String totalGst;

    public TelcoInvoiceAccountCharges totalUsageCharges(String totalUsageCharges) {
        this.totalUsageCharges = totalUsageCharges;
        return this;
    }

    /**
     * The aggregate total of usage charges for the period covered by the invoice (exclusive of GST)
     *
     * @return totalUsageCharges
     */
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
     * The aggregate total of any once off charges arising from usage for the period covered by the invoice (exclusive of GST)
     *
     * @return totalOnceOffCharges
     */
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
     * The aggregate total of account level discounts or credits for the period covered by the invoice
     *
     * @return totalDiscounts
     */
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
     * The total GST for all account level charges.  If absent then zero is assumed
     *
     * @return totalGst
     */
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
