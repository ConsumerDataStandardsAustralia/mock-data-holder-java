package au.org.consumerdatastandards.client.model.energy;

import java.util.Objects;

/**
 * Object contain charges and credits related to electricity usage
 */
public class EnergyInvoiceAccountCharges {
    private String totalCharges;

    private String totalDiscounts;

    private String totalGst;

    public EnergyInvoiceAccountCharges totalCharges(String totalCharges) {
        this.totalCharges = totalCharges;
        return this;
    }

    /**
     * The aggregate total of account level charges for the period covered by the invoice
     *
     * @return totalCharges
     */
    public String getTotalCharges() {
        return totalCharges;
    }

    public void setTotalCharges(String totalCharges) {
        this.totalCharges = totalCharges;
    }

    public EnergyInvoiceAccountCharges totalDiscounts(String totalDiscounts) {
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

    public EnergyInvoiceAccountCharges totalGst(String totalGst) {
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
        EnergyInvoiceAccountCharges energyInvoiceAccountCharges = (EnergyInvoiceAccountCharges) o;
        return Objects.equals(this.totalCharges, energyInvoiceAccountCharges.totalCharges) &&
                Objects.equals(this.totalDiscounts, energyInvoiceAccountCharges.totalDiscounts) &&
                Objects.equals(this.totalGst, energyInvoiceAccountCharges.totalGst);
    }

    @Override
    public int hashCode() {
        return Objects.hash(totalCharges, totalDiscounts, totalGst);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyInvoiceAccountCharges {\n");
        sb.append("    totalCharges: ").append(toIndentedString(totalCharges)).append("\n");
        sb.append("    totalDiscounts: ").append(toIndentedString(totalDiscounts)).append("\n");
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
