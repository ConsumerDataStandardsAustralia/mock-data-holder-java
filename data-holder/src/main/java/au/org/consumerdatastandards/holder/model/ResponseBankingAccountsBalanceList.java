package au.org.consumerdatastandards.holder.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;

@ApiModel
public class ResponseBankingAccountsBalanceList extends PaginatedResponse {

    private ResponseBankingAccountsBalanceListData data;

    public ResponseBankingAccountsBalanceList data(ResponseBankingAccountsBalanceListData data) {
        this.data = data;
        return this;
    }

    @ApiModelProperty(required = true)
    public ResponseBankingAccountsBalanceListData getData() {
        return data;
    }

    public void setData(ResponseBankingAccountsBalanceListData data) {
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
        ResponseBankingAccountsBalanceList responseBankingAccountsBalanceList = (ResponseBankingAccountsBalanceList) o;
        return Objects.equals(this.data, responseBankingAccountsBalanceList.data) &&
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
        return "class ResponseBankingAccountsBalanceList {\n" +
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

