package au.org.consumerdatastandards.holder.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;

@ApiModel
public class ResponseBankingTransactionById extends BaseResponse {

    /**
     * Get data
     */
    private BankingTransactionDetail data;

    /**
     * Get links
     */
    private Links links;

    /**
     * Get meta
     */
    private Meta meta;

    public ResponseBankingTransactionById data(BankingTransactionDetail data) {
        this.data = data;
        return this;
    }

    @ApiModelProperty(required = true, value = "")
    public BankingTransactionDetail getData() {
        return data;
    }

    public void setData(BankingTransactionDetail data) {
        this.data = data;
    }
    public ResponseBankingTransactionById links(Links links) {
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
    public ResponseBankingTransactionById meta(Meta meta) {
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
        ResponseBankingTransactionById responseBankingTransactionById = (ResponseBankingTransactionById) o;
        return Objects.equals(this.data, responseBankingTransactionById.data) &&
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
        return "class ResponseBankingTransactionById {\n" +
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
