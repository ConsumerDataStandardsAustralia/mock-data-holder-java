package au.org.consumerdatastandards.holder.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;

@ApiModel
public class ResponseBankingPayeeById extends BaseResponse {

    /**
     * Get data
     */
    private BankingPayeeDetail data;

    /**
     * Get links
     */
    private Links links;

    /**
     * Get meta
     */
    private Meta meta;

    public ResponseBankingPayeeById data(BankingPayeeDetail data) {
        this.data = data;
        return this;
    }

    @ApiModelProperty(required = true)
    public BankingPayeeDetail getData() {
        return data;
    }

    public void setData(BankingPayeeDetail data) {
        this.data = data;
    }
    public ResponseBankingPayeeById links(Links links) {
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
    public ResponseBankingPayeeById meta(Meta meta) {
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
        ResponseBankingPayeeById responseBankingPayeeById = (ResponseBankingPayeeById) o;
        return Objects.equals(this.data, responseBankingPayeeById.data) &&
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
        return "class ResponseBankingPayeeById {\n" +
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

