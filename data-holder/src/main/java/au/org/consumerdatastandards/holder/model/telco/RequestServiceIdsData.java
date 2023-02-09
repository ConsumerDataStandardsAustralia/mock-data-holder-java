package au.org.consumerdatastandards.holder.model.telco;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;
import java.util.Objects;

@ApiModel
public class RequestServiceIdsData {

    /**
     * Get servicePointIds
     */

    private List<String> serviceIds;

    public RequestServiceIdsData servicePointIds(List<String> serviceIds) {
        this.serviceIds = serviceIds;
        return this;
    }

    public RequestServiceIdsData addItem(String serviceId) {
        this.serviceIds.add(serviceId);
        return this;
    }

    @ApiModelProperty(required = true)
    public List<String> getServicePointIds() {
        return serviceIds;
    }

    public void setServicePointIds(List<String> serviceIds) {
        this.serviceIds = serviceIds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RequestServiceIdsData requestServiceIdsData = (RequestServiceIdsData) o;
        return Objects.equals(this.serviceIds, requestServiceIdsData.serviceIds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                serviceIds);
    }

    @Override
    public String toString() {
        return "class RequestServiceIdsData {\n" +
                "   serviceIds: " + toIndentedString(serviceIds) + "\n" +
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
