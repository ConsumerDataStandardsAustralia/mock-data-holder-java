package au.org.consumerdatastandards.holder.model.telco;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * Summary of the contract details. Required if a contract is required
 */
@ApiModel(description = "Summary of the contract details. Required if a contract is required")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen",
        date = "2022-12-23T11:32:06.900+11:00[Australia/Sydney]")
public class TelcoContract {
    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("duration")
    private BigDecimal duration;

    @JsonProperty("contractUri")
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
    @ApiModelProperty(required = true,
            value = "Name of the contract")
    @NotNull


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
     * Description if the contract
     *
     * @return description
     */
    @ApiModelProperty(value = "Description if the contract")


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
    @ApiModelProperty(required = true,
            value = "Minimum contract duration in months")
    @NotNull

    @Valid

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
    @ApiModelProperty(value = "URI of the contract conditions")


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

