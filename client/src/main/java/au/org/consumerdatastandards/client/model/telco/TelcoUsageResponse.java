package au.org.consumerdatastandards.client.model.telco;

import au.org.consumerdatastandards.client.model.Links;

import java.util.Objects;

/**
 * TelcoUsageResponse
 */
public class TelcoUsageResponse {
    private TelcoAccountUsage data;

    private Links links;

    private Object meta;

    public TelcoUsageResponse data(TelcoAccountUsage data) {
        this.data = data;
        return this;
    }

    /**
     * Get data
     *
     * @return data
     */
    public TelcoAccountUsage getData() {
        return data;
    }

    public void setData(TelcoAccountUsage data) {
        this.data = data;
    }

    public TelcoUsageResponse links(Links links) {
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

    public TelcoUsageResponse meta(Object meta) {
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
        TelcoUsageResponse telcoUsageResponse = (TelcoUsageResponse) o;
        return Objects.equals(this.data, telcoUsageResponse.data) &&
                Objects.equals(this.links, telcoUsageResponse.links) &&
                Objects.equals(this.meta, telcoUsageResponse.meta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, links, meta);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TelcoUsageResponse {\n");
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
