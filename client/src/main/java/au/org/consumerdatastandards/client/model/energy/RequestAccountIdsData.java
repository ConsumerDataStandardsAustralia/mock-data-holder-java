package au.org.consumerdatastandards.client.model.energy;

import java.util.List;
import java.util.Objects;

public class RequestAccountIdsData {

    private List<String> accountIds;

    public RequestAccountIdsData accountIds(List<String> accountIds) {
        this.accountIds = accountIds;
        return this;
    }

    public RequestAccountIdsData addItem(String accountIdsItem) {
        this.accountIds.add(accountIdsItem);
        return this;
    }

    /**
     * Get accountIds
     */
    public List<String> getAccountIds() {
        return accountIds;
    }

    public void setAccountIds(List<String> accountIds) {
        this.accountIds = accountIds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RequestAccountIdsData requestAccountIdsData = (RequestAccountIdsData) o;
        return Objects.equals(this.accountIds, requestAccountIdsData.accountIds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                accountIds);
    }

    @Override
    public String toString() {
        return "class RequestAccountIdsData {\n" +
                "   accountIds: " + toIndentedString(accountIds) + "\n" +
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

