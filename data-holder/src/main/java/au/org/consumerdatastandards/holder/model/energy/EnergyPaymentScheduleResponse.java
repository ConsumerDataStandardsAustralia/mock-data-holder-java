package au.org.consumerdatastandards.holder.model.energy;

import au.org.consumerdatastandards.holder.model.Links;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * EnergyPaymentScheduleResponse
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen",
        date = "2022-01-11T14:03:27.755+11:00[Australia/Sydney]")
public class EnergyPaymentScheduleResponse {
    @JsonProperty("data")
    private EnergyPaymentSchedule data;

    @JsonProperty("links")
    private Links links;

    @JsonProperty("meta")
    private Object meta;

    public EnergyPaymentScheduleResponse data(EnergyPaymentSchedule data) {
        this.data = data;
        return this;
    }

    /**
     * Get data
     *
     * @return data
     */
    @ApiModelProperty(required = true,
            value = "")
    @NotNull

    @Valid

    public EnergyPaymentSchedule getData() {
        return data;
    }

    public void setData(EnergyPaymentSchedule data) {
        this.data = data;
    }

    public EnergyPaymentScheduleResponse links(Links links) {
        this.links = links;
        return this;
    }

    /**
     * Get links
     *
     * @return links
     */
    @ApiModelProperty(required = true,
            value = "")
    @NotNull

    @Valid

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public EnergyPaymentScheduleResponse meta(Object meta) {
        this.meta = meta;
        return this;
    }

    /**
     * Get meta
     *
     * @return meta
     */
    @ApiModelProperty(required = true,
            value = "")
    @NotNull


    public Object getMeta() {
        return meta;
    }

    public void setMeta(Object meta) {
        this.meta = meta;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EnergyPaymentScheduleResponse energyPaymentScheduleResponse = (EnergyPaymentScheduleResponse) o;
        return Objects.equals(this.data, energyPaymentScheduleResponse.data) &&
                Objects.equals(this.links, energyPaymentScheduleResponse.links) &&
                Objects.equals(this.meta, energyPaymentScheduleResponse.meta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, links, meta);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyPaymentScheduleResponse {\n");

        sb.append("    data: ").append(toIndentedString(data)).append("\n");
        sb.append("    links: ").append(toIndentedString(links)).append("\n");
        sb.append("    meta: ").append(toIndentedString(meta)).append("\n");
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

