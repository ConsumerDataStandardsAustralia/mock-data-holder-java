package au.org.consumerdatastandards.holder.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;

@ApiModel
public class ResponseBankingAccountById extends BaseResponse {

    /**
     * Get data
     */
    private BankingAccountDetail data;

    /**
     * Get links
     */
    private Links links;

    /**
     * Get meta
     */
    private Meta meta;

    public ResponseBankingAccountById data(BankingAccountDetail data) {
        this.data = data;
        return this;
    }

    @ApiModelProperty(required = true)
    public BankingAccountDetail getData() {
        return data;
    }

    public void setData(BankingAccountDetail data) {
        this.data = data;
    }
    public ResponseBankingAccountById links(Links links) {
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
    public ResponseBankingAccountById meta(Meta meta) {
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
        ResponseBankingAccountById responseBankingAccountById = (ResponseBankingAccountById) o;
        return Objects.equals(this.data, responseBankingAccountById.data) &&
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
        return "class ResponseBankingAccountById {\n" +
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

