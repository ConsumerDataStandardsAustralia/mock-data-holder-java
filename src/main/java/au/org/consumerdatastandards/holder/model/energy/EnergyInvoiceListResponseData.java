package au.org.consumerdatastandards.holder.model.energy;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * EnergyInvoiceListResponseData
 */
public class EnergyInvoiceListResponseData {
    @Valid
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
     * Array of invoices sorted by issue date in descending order.
     *
     * @return invoices
     */
    @ApiModelProperty(required = true, value = "Array of invoices sorted by issue date in descending order.")
    @NotNull
    @Valid
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
