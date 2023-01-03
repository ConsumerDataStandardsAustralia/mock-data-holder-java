package au.org.consumerdatastandards.client.model.telco;

import java.util.Objects;

/**
 * TelcoAccountUsageServices
 */
public class TelcoAccountUsageServices {
    private TelcoServiceUsage service;

    public TelcoAccountUsageServices service(TelcoServiceUsage service) {
        this.service = service;
        return this;
    }

    /**
     * Get service
     *
     * @return service
     */
    public TelcoServiceUsage getService() {
        return service;
    }

    public void setService(TelcoServiceUsage service) {
        this.service = service;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TelcoAccountUsageServices telcoAccountUsageServices = (TelcoAccountUsageServices) o;
        return Objects.equals(this.service, telcoAccountUsageServices.service);
    }

    @Override
    public int hashCode() {
        return Objects.hash(service);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TelcoAccountUsageServices {\n");
        sb.append("    service: ").append(toIndentedString(service)).append("\n");
        sb.append("}");
        return sb.toString();
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
