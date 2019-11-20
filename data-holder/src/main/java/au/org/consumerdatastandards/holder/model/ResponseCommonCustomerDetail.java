package au.org.consumerdatastandards.holder.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;

@ApiModel
public class ResponseCommonCustomerDetail extends BaseResponse {

    private ResponseCommonCustomerDetailData data;

    public ResponseCommonCustomerDetail data(ResponseCommonCustomerDetailData data) {
        this.data = data;
        return this;
    }

    @ApiModelProperty(required = true)
    public ResponseCommonCustomerDetailData getData() {
        return data;
    }

    public void setData(ResponseCommonCustomerDetailData data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ResponseCommonCustomerDetail responseCommonCustomerDetail = (ResponseCommonCustomerDetail) o;
        return Objects.equals(this.data, responseCommonCustomerDetail.data) &&
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
        return "class ResponseCommonCustomerDetail {\n" +
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

