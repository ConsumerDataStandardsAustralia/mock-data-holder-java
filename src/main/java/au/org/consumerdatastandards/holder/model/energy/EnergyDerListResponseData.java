package au.org.consumerdatastandards.holder.model.energy;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * EnergyDerListResponseData
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen",
        date = "2022-01-11T14:03:27.755+11:00[Australia/Sydney]")
public class EnergyDerListResponseData {
    @JsonProperty("derRecords")
    @Valid
    private List<EnergyDerRecord> derRecords = new ArrayList<>();

    public EnergyDerListResponseData derRecords(List<EnergyDerRecord> derRecords) {
        this.derRecords = derRecords;
        return this;
    }

    public EnergyDerListResponseData addDerRecordsItem(EnergyDerRecord derRecordsItem) {
        this.derRecords.add(derRecordsItem);
        return this;
    }

    /**
     * Array of meter reads.
     *
     * @return derRecords
     */
    @ApiModelProperty(required = true,
            value = "Array of meter reads.")
    @NotNull

    @Valid

    public List<EnergyDerRecord> getDerRecords() {
        return derRecords;
    }

    public void setDerRecords(List<EnergyDerRecord> derRecords) {
        this.derRecords = derRecords;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EnergyDerListResponseData energyDerListResponseData = (EnergyDerListResponseData) o;
        return Objects.equals(this.derRecords, energyDerListResponseData.derRecords);
    }

    @Override
    public int hashCode() {
        return Objects.hash(derRecords);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyDerListResponseData {\n");

        sb.append("    derRecords: ").append(toIndentedString(derRecords)).append("\n");
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

