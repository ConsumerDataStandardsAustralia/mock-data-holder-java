package au.org.consumerdatastandards.holder.model.telco;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Object containing account service usage summary
 */
@ApiModel(description = "Object containing account service usage summary")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen",
        date = "2022-12-23T11:32:06.900+11:00[Australia/Sydney]")
public class TelcoBalance {
    @JsonProperty("services")
    @Valid
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
    @ApiModelProperty(required = true,
            value = "Summary of balances")
    @NotNull

    @Valid

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

