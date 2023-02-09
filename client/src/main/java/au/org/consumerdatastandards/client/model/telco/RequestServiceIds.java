package au.org.consumerdatastandards.client.model.telco;

import java.util.Map;
import java.util.Objects;

public class RequestServiceIds {

    private RequestServiceIdsData data;

    private Map<String, Object> meta;

    public RequestServiceIds data(RequestServiceIdsData data) {
        this.data = data;
        return this;
    }

    public RequestServiceIdsData getData() {
        return data;
    }

    public void setData(RequestServiceIdsData data) {
        this.data = data;
    }

    public RequestServiceIds meta(Map<String, Object> meta) {
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
        RequestServiceIds requestServiceIds = (RequestServiceIds) o;
        return Objects.equals(this.data, requestServiceIds.data) &&
                Objects.equals(this.meta, requestServiceIds.meta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                data,
                meta);
    }

    @Override
    public String toString() {
        return "class RequestServiceIds {\n" +
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
