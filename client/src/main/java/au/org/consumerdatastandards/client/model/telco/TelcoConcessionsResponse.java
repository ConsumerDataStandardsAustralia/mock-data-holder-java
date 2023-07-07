package au.org.consumerdatastandards.client.model.telco;

import au.org.consumerdatastandards.client.model.LinksPaginated;
import au.org.consumerdatastandards.client.model.MetaPaginated;

import java.util.Objects;

/**
 * TelcoConcessionsResponse
 */
public class TelcoConcessionsResponse {
    private TelcoConcessionsResponseData data;

    private LinksPaginated links;

    private MetaPaginated meta;

    public TelcoConcessionsResponse data(TelcoConcessionsResponseData data) {
        this.data = data;
        return this;
    }

    /**
     * Get data
     *
     * @return data
     */
    public TelcoConcessionsResponseData getData() {
        return data;
    }

    public void setData(TelcoConcessionsResponseData data) {
        this.data = data;
    }

    public TelcoConcessionsResponse links(LinksPaginated links) {
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

    public TelcoConcessionsResponse meta(MetaPaginated meta) {
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
        TelcoConcessionsResponse telcoConcessionsResponse = (TelcoConcessionsResponse) o;
        return Objects.equals(this.data, telcoConcessionsResponse.data) &&
                Objects.equals(this.links, telcoConcessionsResponse.links) &&
                Objects.equals(this.meta, telcoConcessionsResponse.meta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, links, meta);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TelcoConcessionsResponse {\n");
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
