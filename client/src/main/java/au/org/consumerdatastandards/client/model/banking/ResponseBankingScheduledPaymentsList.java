/*
 * Consumer Data Standards
 * Sample client library to Demonstrate the Consumer Data Right APIs
 *
 * NOTE: This class is auto generated
 */
package au.org.consumerdatastandards.client.model.banking;

import au.org.consumerdatastandards.client.model.PaginatedResponse;

import java.util.Objects;

public class ResponseBankingScheduledPaymentsList<T extends BankingScheduledPaymentTo> extends PaginatedResponse {

    private ResponseBankingScheduledPaymentsListData<T> data;

    /**
     * Get data
     * @return data
     */
    public ResponseBankingScheduledPaymentsListData<T> getData() {
        return data;
    }

    public void setData(ResponseBankingScheduledPaymentsListData<T> data) {
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
        ResponseBankingScheduledPaymentsList<T> responseBankingScheduledPaymentsList = (ResponseBankingScheduledPaymentsList<T>) o;
        return Objects.equals(this.data, responseBankingScheduledPaymentsList.data) &&
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
        return "class ResponseBankingScheduledPaymentsList {\n" +
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
