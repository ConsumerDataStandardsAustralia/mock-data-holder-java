package au.org.consumerdatastandards.client.model.telco;

import au.org.consumerdatastandards.client.model.Links;

import java.util.Objects;

/**
 * TelcoInvoiceResponse
 */
public class TelcoInvoiceResponse {
    private TelcoInvoiceListResponseData data;

    private Links links;

    private Object meta;

    public TelcoInvoiceResponse data(TelcoInvoiceListResponseData data) {
        this.data = data;
        return this;
    }

    /**
     * Get data
     *
     * @return data
     */
    public TelcoInvoiceListResponseData getData() {
        return data;
    }

    public void setData(TelcoInvoiceListResponseData data) {
        this.data = data;
    }

    public TelcoInvoiceResponse links(Links links) {
        this.links = links;
        return this;
    }

    /**
     * Get links
     *
     * @return links
     */
    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public TelcoInvoiceResponse meta(Object meta) {
        this.meta = meta;
        return this;
    }

    /**
     * Get meta
     *
     * @return meta
     */
    public Object getMeta() {
        return meta;
    }

    public void setMeta(Object meta) {
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
        TelcoInvoiceResponse telcoInvoiceListResponse = (TelcoInvoiceResponse) o;
        return Objects.equals(this.data, telcoInvoiceListResponse.data) &&
                Objects.equals(this.links, telcoInvoiceListResponse.links) &&
                Objects.equals(this.meta, telcoInvoiceListResponse.meta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, links, meta);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TelcoInvoiceResponse {\n");
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
