package au.org.consumerdatastandards.client.model.telco;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Object containing account service usage summary
 */
public class TelcoBalance {
    private List<TelcoServiceBalance> services = new ArrayList<>();

    public TelcoBalance services(List<TelcoServiceBalance> services) {
        this.services = services;
        return this;
    }

    public TelcoBalance addServicesItem(TelcoServiceBalance servicesItem) {
        this.services.add(servicesItem);
        return this;
    }

    /**
     * Summary of balances
     *
     * @return services
     */
    public List<TelcoServiceBalance> getServices() {
        return services;
    }

    public void setServices(List<TelcoServiceBalance> services) {
        this.services = services;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TelcoBalance telcoBalance = (TelcoBalance) o;
        return Objects.equals(this.services, telcoBalance.services);
    }

    @Override
    public int hashCode() {
        return Objects.hash(services);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TelcoBalance {\n");
        sb.append("    services: ").append(toIndentedString(services)).append("\n");
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
