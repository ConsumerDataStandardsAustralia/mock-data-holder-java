package au.org.consumerdatastandards.holder.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;
import java.util.List;

@ApiModel
public class ResponseDiscoveryOutagesListData  {

    /**
     * List of scheduled outages. Property is mandatory but may contain and empty list if no outages are scheduled
     */
    
    private List<DiscoveryOutage> outages;

    public ResponseDiscoveryOutagesListData outages(List<DiscoveryOutage> outages) {
        this.outages = outages;
        return this;
    }

    public ResponseDiscoveryOutagesListData addItem(DiscoveryOutage outagesItem) {
        this.outages.add(outagesItem);
        return this;
    }

    @ApiModelProperty(required = true, value = "List of scheduled outages. Property is mandatory but may contain and empty list if no outages are scheduled")
    public List<DiscoveryOutage> getOutages() {
        return outages;
    }

    public void setOutages(List<DiscoveryOutage> outages) {
        this.outages = outages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ResponseDiscoveryOutagesListData responseDiscoveryOutagesListData = (ResponseDiscoveryOutagesListData) o;
        return Objects.equals(this.outages, responseDiscoveryOutagesListData.outages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            outages);
    }

    @Override
    public String toString() {
        return "class ResponseDiscoveryOutagesListData {\n" +
            "   outages: " + toIndentedString(outages) + "\n" + 
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

