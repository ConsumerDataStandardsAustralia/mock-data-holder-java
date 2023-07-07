package au.org.consumerdatastandards.holder.model.telco;

import au.org.consumerdatastandards.holder.model.Links;

import java.util.Objects;

/**
 * TelcoUsageListResponse
 */
public class TelcoUsageListResponse {
    private TelcoUsageListResponseData data;

    private Links links;

    private Object meta;

    /**
     * Get data
     *
     * @return data
     */
    public TelcoUsageListResponseData getData() {
        return data;
    }

    public void setData(TelcoUsageListResponseData data) {
        this.data = data;
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
        TelcoUsageListResponse telcoUsageListResponse = (TelcoUsageListResponse) o;
        return Objects.equals(this.data, telcoUsageListResponse.data) &&
                Objects.equals(this.links, telcoUsageListResponse.links) &&
                Objects.equals(this.meta, telcoUsageListResponse.meta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, links, meta);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TelcoUsageListResponse {\n");
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
