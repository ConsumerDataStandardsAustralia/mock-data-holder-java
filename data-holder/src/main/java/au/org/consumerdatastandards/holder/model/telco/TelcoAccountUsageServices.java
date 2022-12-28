package au.org.consumerdatastandards.holder.model.telco;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * TelcoAccountUsageServices
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen",
        date = "2022-12-23T11:32:06.900+11:00[Australia/Sydney]")
public class TelcoAccountUsageServices {
    @JsonProperty("service")
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
    @ApiModelProperty(required = true,
            value = "")
    @NotNull

    @Valid

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

