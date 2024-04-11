package au.org.consumerdatastandards.holder.model.telco;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * TelcoAccountUsage
 */
public class TelcoAccountUsage {
    private String accountId;

    @Valid
    private List<TelcoAccountUsageServices> services = null;

    public TelcoAccountUsage accountId(String accountId) {
        this.accountId = accountId;
        return this;
    }

    /**
     * Tokenised ID of the account. In accordance with [CDR ID permanence](#id-permanence) requirements
     *
     * @return accountId
     */
    @ApiModelProperty(required = true,
            value = "Tokenised ID of the account. In accordance with [CDR ID permanence](#id-permanence) requirements")
    @NotNull
    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public TelcoAccountUsage services(List<TelcoAccountUsageServices> services) {
        this.services = services;
        return this;
    }

    public TelcoAccountUsage addServicesItem(TelcoAccountUsageServices servicesItem) {
        if (this.services == null) {
            this.services = new ArrayList<>();
        }
        this.services.add(servicesItem);
        return this;
    }

    /**
     * List of services that are part of the account
     *
     * @return services
     */
    @ApiModelProperty(required = true, value = "List of services that are part of the account")
    @Valid
    @NotNull
    public List<TelcoAccountUsageServices> getServices() {
        return services;
    }

    public void setServices(List<TelcoAccountUsageServices> services) {
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
        TelcoAccountUsage telcoAccountUsage = (TelcoAccountUsage) o;
        return Objects.equals(this.accountId, telcoAccountUsage.accountId) &&
                Objects.equals(this.services, telcoAccountUsage.services);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, services);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TelcoAccountUsage {\n");
        sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
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
