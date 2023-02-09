package au.org.consumerdatastandards.client.model.telco;

import au.org.consumerdatastandards.client.model.Links;

import java.util.Objects;

/**
 * TelcoAccountDetailResponse
 */
public class TelcoAccountDetailResponse {
    private TelcoAccountDetail data;

    private Links links;

    private Object meta;

    /**
     * Get data
     *
     * @return data
     */
    public TelcoAccountDetail getData() {
        return data;
    }

    public void setData(TelcoAccountDetail data) {
        this.data = data;
    }

    public TelcoAccountDetailResponse links(Links links) {
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

    public TelcoAccountDetailResponse meta(Object meta) {
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
        TelcoAccountDetailResponse telcoAccountDetailResponse = (TelcoAccountDetailResponse) o;
        return Objects.equals(this.data, telcoAccountDetailResponse.data) &&
                Objects.equals(this.links, telcoAccountDetailResponse.links) &&
                Objects.equals(this.meta, telcoAccountDetailResponse.meta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, links, meta);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TelcoAccountDetailResponse {\n");
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
