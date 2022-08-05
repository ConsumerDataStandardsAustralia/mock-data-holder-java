package au.org.consumerdatastandards.client.model.energy;

import au.org.consumerdatastandards.client.model.LinksPaginated;
import au.org.consumerdatastandards.client.model.MetaPaginated;

import java.util.Objects;

/**
 * EnergyInvoiceListResponse
 */
public class EnergyInvoiceListResponse {
    private EnergyInvoiceListResponseData data;

    private LinksPaginated links;

    private MetaPaginated meta;

    public EnergyInvoiceListResponse data(EnergyInvoiceListResponseData data) {
        this.data = data;
        return this;
    }

    /**
     * Get data
     *
     * @return data
     */
    public EnergyInvoiceListResponseData getData() {
        return data;
    }

    public void setData(EnergyInvoiceListResponseData data) {
        this.data = data;
    }

    public EnergyInvoiceListResponse links(LinksPaginated links) {
        this.links = links;
        return this;
    }

    /**
     * Get links
     *
     * @return links
     */
    public LinksPaginated getLinks() {
        return links;
    }

    public void setLinks(LinksPaginated links) {
        this.links = links;
    }

    public EnergyInvoiceListResponse meta(MetaPaginated meta) {
        this.meta = meta;
        return this;
    }

    /**
     * Get meta
     *
     * @return meta
     */
    public MetaPaginated getMeta() {
        return meta;
    }

    public void setMeta(MetaPaginated meta) {
        this.meta = meta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EnergyInvoiceListResponse energyInvoiceListResponse = (EnergyInvoiceListResponse) o;
        return Objects.equals(this.data, energyInvoiceListResponse.data) &&
                Objects.equals(this.links, energyInvoiceListResponse.links) &&
                Objects.equals(this.meta, energyInvoiceListResponse.meta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, links, meta);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyInvoiceListResponse {\n");
        sb.append("    data: ").append(toIndentedString(data)).append("\n");
        sb.append("    links: ").append(toIndentedString(links)).append("\n");
        sb.append("    meta: ").append(toIndentedString(meta)).append("\n");
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
