package au.org.consumerdatastandards.holder.model.energy;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * EnergyConcessionsResponseData
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen",
        date = "2022-01-11T14:03:27.755+11:00[Australia/Sydney]")
public class EnergyConcessionsResponseData {
    @JsonProperty("concessions")
    @Valid
    private List<EnergyConcession> concessions = new ArrayList<>();

    public EnergyConcessionsResponseData concessions(List<EnergyConcession> concessions) {
        this.concessions = concessions;
        return this;
    }

    public EnergyConcessionsResponseData addConcessionsItem(EnergyConcession concessionsItem) {
        this.concessions.add(concessionsItem);
        return this;
    }

    /**
     * Array may be empty if no concessions exist.
     *
     * @return concessions
     */
    @ApiModelProperty(required = true,
            value = "Array may be empty if no concessions exist.")
    @NotNull

    @Valid

    public List<EnergyConcession> getConcessions() {
        return concessions;
    }

    public void setConcessions(List<EnergyConcession> concessions) {
        this.concessions = concessions;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EnergyConcessionsResponseData energyConcessionsResponseData = (EnergyConcessionsResponseData) o;
        return Objects.equals(this.concessions, energyConcessionsResponseData.concessions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(concessions);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyConcessionsResponseData {\n");

        sb.append("    concessions: ").append(toIndentedString(concessions)).append("\n");
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

