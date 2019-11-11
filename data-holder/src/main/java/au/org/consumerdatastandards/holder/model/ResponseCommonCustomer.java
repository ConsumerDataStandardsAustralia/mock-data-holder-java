package au.org.consumerdatastandards.holder.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;

@ApiModel
public class ResponseCommonCustomer extends BaseResponse {

    /**
     * Get data
     */
    private ResponseCommonCustomerData data;

    /**
     * Get links
     */
    private Links links;

    /**
     * Get meta
     */
    private Meta meta;

    public ResponseCommonCustomer data(ResponseCommonCustomerData data) {
        this.data = data;
        return this;
    }

    @ApiModelProperty(required = true)
    public ResponseCommonCustomerData getData() {
        return data;
    }

    public void setData(ResponseCommonCustomerData data) {
        this.data = data;
    }
    public ResponseCommonCustomer links(Links links) {
        this.links = links;
        return this;
    }

    @ApiModelProperty(required = true)
    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }
    public ResponseCommonCustomer meta(Meta meta) {
        this.meta = meta;
        return this;
    }

    @ApiModelProperty
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
        ResponseCommonCustomer responseCommonCustomer = (ResponseCommonCustomer) o;
        return Objects.equals(this.data, responseCommonCustomer.data) &&
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
        return "class ResponseCommonCustomer {\n" +
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

