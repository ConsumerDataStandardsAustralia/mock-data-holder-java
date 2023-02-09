package au.org.consumerdatastandards.client.model.telco;

import au.org.consumerdatastandards.client.model.LinksPaginated;
import au.org.consumerdatastandards.client.model.MetaPaginated;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * TelcoServiceUsageListResponse
 */
public class TelcoServiceUsageListResponse {
    private List<TelcoServiceUsage> data = new ArrayList<>();

    private LinksPaginated links;

    private MetaPaginated meta;

    public TelcoServiceUsageListResponse data(List<TelcoServiceUsage> data) {
        this.data = data;
        return this;
    }

    public TelcoServiceUsageListResponse addDataItem(TelcoServiceUsage dataItem) {
        this.data.add(dataItem);
        return this;
    }

    /**
     * Get data
     *
     * @return data
     */
    public List<TelcoServiceUsage> getData() {
        return data;
    }

    public void setData(List<TelcoServiceUsage> data) {
        this.data = data;
    }

    public TelcoServiceUsageListResponse links(LinksPaginated links) {
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

    public TelcoServiceUsageListResponse meta(MetaPaginated meta) {
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
        TelcoServiceUsageListResponse telcoServiceUsageListResponse = (TelcoServiceUsageListResponse) o;
        return Objects.equals(this.data, telcoServiceUsageListResponse.data) &&
                Objects.equals(this.links, telcoServiceUsageListResponse.links) &&
                Objects.equals(this.meta, telcoServiceUsageListResponse.meta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, links, meta);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TelcoServiceUsageListResponse {\n");
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
