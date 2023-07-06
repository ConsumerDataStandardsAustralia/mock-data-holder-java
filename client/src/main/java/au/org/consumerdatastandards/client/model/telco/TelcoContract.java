package au.org.consumerdatastandards.client.model.telco;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Summary of the contract details. Mandatory if the billing type is POST_PAID and a contract agreement is required with the service provider for the plan
 */
public class TelcoContract {
    private String name;

    private String description;

    private BigDecimal duration;

    private String contractUri;

    public TelcoContract name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Name of the contract
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TelcoContract description(String description) {
        this.description = description;
        return this;
    }

    /**
     * Description of the contract
     *
     * @return description
     */
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TelcoContract duration(BigDecimal duration) {
        this.duration = duration;
        return this;
    }

    /**
     * Minimum contract duration in months
     *
     * @return duration
     */
    public BigDecimal getDuration() {
        return duration;
    }

    public void setDuration(BigDecimal duration) {
        this.duration = duration;
    }

    public TelcoContract contractUri(String contractUri) {
        this.contractUri = contractUri;
        return this;
    }

    /**
     * URI of the contract conditions
     *
     * @return contractUri
     */
    public String getContractUri() {
        return contractUri;
    }

    public void setContractUri(String contractUri) {
        this.contractUri = contractUri;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TelcoContract telcoContract = (TelcoContract) o;
        return Objects.equals(this.name, telcoContract.name) &&
                Objects.equals(this.description, telcoContract.description) &&
                Objects.equals(this.duration, telcoContract.duration) &&
                Objects.equals(this.contractUri, telcoContract.contractUri);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, duration, contractUri);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TelcoContract {\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    duration: ").append(toIndentedString(duration)).append("\n");
        sb.append("    contractUri: ").append(toIndentedString(contractUri)).append("\n");
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
