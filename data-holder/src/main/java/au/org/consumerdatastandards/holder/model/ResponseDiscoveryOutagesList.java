package au.org.consumerdatastandards.holder.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;

@ApiModel
public class ResponseDiscoveryOutagesList extends BaseResponse {

    /**
     * Get data
     */
    private ResponseDiscoveryOutagesListData data;

    /**
     * Get links
     */
    private Links links;

    /**
     * Get meta
     */
    private Meta meta;

    public ResponseDiscoveryOutagesList data(ResponseDiscoveryOutagesListData data) {
        this.data = data;
        return this;
    }

    @ApiModelProperty(required = true, value = "")
    public ResponseDiscoveryOutagesListData getData() {
        return data;
    }

    public void setData(ResponseDiscoveryOutagesListData data) {
        this.data = data;
    }
    public ResponseDiscoveryOutagesList links(Links links) {
        this.links = links;
        return this;
    }

    @ApiModelProperty(required = true, value = "")
    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }
    public ResponseDiscoveryOutagesList meta(Meta meta) {
        this.meta = meta;
        return this;
    }

    @ApiModelProperty(value = "")
    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
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
        ResponseDiscoveryOutagesList responseDiscoveryOutagesList = (ResponseDiscoveryOutagesList) o;
        return Objects.equals(this.data, responseDiscoveryOutagesList.data) &&
            super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            data,
            super.hashCode());
    }

    @Override
    public String toString() {
        return "class ResponseDiscoveryOutagesList {\n" +
            "   data: " + toIndentedString(data) + "\n" + 
            "   links: " + toIndentedString(getLinks()) + "\n" + 
            "   meta: " + toIndentedString(getMeta()) + "\n" + 
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

