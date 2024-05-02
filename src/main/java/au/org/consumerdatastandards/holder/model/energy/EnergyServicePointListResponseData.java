package au.org.consumerdatastandards.holder.model.energy;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * EnergyServicePointListResponseData
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen",
        date = "2022-01-11T14:03:27.755+11:00[Australia/Sydney]")
public class EnergyServicePointListResponseData {
    @JsonProperty("servicePoints")
    @Valid
    private List<EnergyServicePoint> servicePoints = new ArrayList<>();

    public EnergyServicePointListResponseData servicePoints(List<EnergyServicePoint> servicePoints) {
        this.servicePoints = servicePoints;
        return this;
    }

    public EnergyServicePointListResponseData addServicePointsItem(EnergyServicePoint servicePointsItem) {
        this.servicePoints.add(servicePointsItem);
        return this;
    }

    /**
     * Get servicePoints
     *
     * @return servicePoints
     */
    @ApiModelProperty(required = true,
            value = "")
    @NotNull

    @Valid

    public List<EnergyServicePoint> getServicePoints() {
        return servicePoints;
    }

    public void setServicePoints(List<EnergyServicePoint> servicePoints) {
        this.servicePoints = servicePoints;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EnergyServicePointListResponseData energyServicePointListResponseData = (EnergyServicePointListResponseData) o;
        return Objects.equals(this.servicePoints, energyServicePointListResponseData.servicePoints);
    }

    @Override
    public int hashCode() {
        return Objects.hash(servicePoints);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyServicePointListResponseData {\n");

        sb.append("    servicePoints: ").append(toIndentedString(servicePoints)).append("\n");
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

