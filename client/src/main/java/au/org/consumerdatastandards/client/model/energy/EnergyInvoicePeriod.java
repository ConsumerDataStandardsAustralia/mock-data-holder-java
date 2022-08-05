package au.org.consumerdatastandards.client.model.energy;

import java.util.Objects;

/**
 * Object containing the start and end date for the period covered by the invoice.  Mandatory if any usage or demand based charges are included in the invoice
 */
public class EnergyInvoicePeriod {
    private String startDate;

    private String endDate;

    public EnergyInvoicePeriod startDate(String startDate) {
        this.startDate = startDate;
        return this;
    }

    /**
     * The start date of the period covered by this invoice
     *
     * @return startDate
     */
    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public EnergyInvoicePeriod endDate(String endDate) {
        this.endDate = endDate;
        return this;
    }

    /**
     * The end date of the period covered by this invoice
     *
     * @return endDate
     */
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
        EnergyInvoicePeriod energyInvoicePeriod = (EnergyInvoicePeriod) o;
        return Objects.equals(this.startDate, energyInvoicePeriod.startDate) &&
                Objects.equals(this.endDate, energyInvoicePeriod.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startDate, endDate);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyInvoicePeriod {\n");
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
