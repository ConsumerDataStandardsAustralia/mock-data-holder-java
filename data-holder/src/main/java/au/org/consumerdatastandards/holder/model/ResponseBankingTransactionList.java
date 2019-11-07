package au.org.consumerdatastandards.holder.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;

@ApiModel
public class ResponseBankingTransactionList extends PaginatedResponse {

    /**
     * Get data
     */
    private ResponseBankingTransactionListData data;

    /**
     * Get links
     */
    private LinksPaginated links;

    /**
     * Get meta
     */
    private MetaPaginated meta;

    public ResponseBankingTransactionList data(ResponseBankingTransactionListData data) {
        this.data = data;
        return this;
    }

    @ApiModelProperty(required = true, value = "")
    public ResponseBankingTransactionListData getData() {
        return data;
    }

    public void setData(ResponseBankingTransactionListData data) {
        this.data = data;
    }
    public ResponseBankingTransactionList links(LinksPaginated links) {
        this.links = links;
        return this;
    }

    @ApiModelProperty(required = true, value = "")
    public LinksPaginated getLinks() {
        return links;
    }

    public void setLinks(LinksPaginated links) {
        this.links = links;
    }
    public ResponseBankingTransactionList meta(MetaPaginated meta) {
        this.meta = meta;
        return this;
    }

    @ApiModelProperty(required = true, value = "")
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
        ResponseBankingTransactionList responseBankingTransactionList = (ResponseBankingTransactionList) o;
        return Objects.equals(this.data, responseBankingTransactionList.data) &&
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
        return "class ResponseBankingTransactionList {\n" +
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

