package au.org.consumerdatastandards.client.model.energy;

import java.util.List;
import java.util.Objects;

public class RequestServicePointIdsData {

    /**
     * Get servicePointIds
     */

    private List<String> servicePointIds;

    public RequestServicePointIdsData servicePointIds(List<String> servicePointIds) {
        this.servicePointIds = servicePointIds;
        return this;
    }

    public RequestServicePointIdsData addItem(String servicePointId) {
        this.servicePointIds.add(servicePointId);
        return this;
    }

    public List<String> getServicePointIds() {
        return servicePointIds;
    }

    public void setServicePointIds(List<String> servicePointIds) {
        this.servicePointIds = servicePointIds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RequestServicePointIdsData requestServicePointIdsData = (RequestServicePointIdsData) o;
        return Objects.equals(this.servicePointIds, requestServicePointIdsData.servicePointIds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                servicePointIds);
    }

    @Override
    public String toString() {
        return "class RequestServicePointIdsData {\n" +
                "   servicePointIds: " + toIndentedString(servicePointIds) + "\n" +
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
