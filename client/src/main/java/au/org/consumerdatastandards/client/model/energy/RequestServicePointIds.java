package au.org.consumerdatastandards.client.model.energy;

import java.util.Map;
import java.util.Objects;

public class RequestServicePointIds {

    private RequestServicePointIdsData data;

    private Map<String, Object> meta;

    public RequestServicePointIds data(RequestServicePointIdsData data) {
        this.data = data;
        return this;
    }

    public RequestServicePointIdsData getData() {
        return data;
    }

    public void setData(RequestServicePointIdsData data) {
        this.data = data;
    }

    public RequestServicePointIds meta(Map<String, Object> meta) {
        this.meta = meta;
        return this;
    }

    public Map<String, Object> getMeta() {
        return meta;
    }

    public void setMeta(Map<String, Object> meta) {
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
        RequestServicePointIds requestServicePointIds = (RequestServicePointIds) o;
        return Objects.equals(this.data, requestServicePointIds.data) &&
                Objects.equals(this.meta, requestServicePointIds.meta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                data,
                meta);
    }

    @Override
    public String toString() {
        return "class RequestServicePointIds {\n" +
                "   data: " + toIndentedString(data) + "\n" +
                "   meta: " + toIndentedString(meta) + "\n" +
                "}";
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
