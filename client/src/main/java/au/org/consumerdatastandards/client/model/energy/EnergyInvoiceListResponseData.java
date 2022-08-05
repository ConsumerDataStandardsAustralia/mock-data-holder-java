package au.org.consumerdatastandards.client.model.energy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * EnergyInvoiceListResponseData
 */
public class EnergyInvoiceListResponseData {
    private List<EnergyInvoice> invoices = new ArrayList<>();

    public EnergyInvoiceListResponseData invoices(List<EnergyInvoice> invoices) {
        this.invoices = invoices;
        return this;
    }

    public EnergyInvoiceListResponseData addInvoicesItem(EnergyInvoice invoicesItem) {
        this.invoices.add(invoicesItem);
        return this;
    }

    /**
     * Array of invoices sorted by date in descending order
     *
     * @return invoices
     */
    public List<EnergyInvoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<EnergyInvoice> invoices) {
        this.invoices = invoices;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EnergyInvoiceListResponseData energyInvoiceListResponseData = (EnergyInvoiceListResponseData) o;
        return Objects.equals(this.invoices, energyInvoiceListResponseData.invoices);
    }

    @Override
    public int hashCode() {
        return Objects.hash(invoices);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyInvoiceListResponseData {\n");
        sb.append("    invoices: ").append(toIndentedString(invoices)).append("\n");
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
