package au.org.consumerdatastandards.holder.model.energy;

import au.org.consumerdatastandards.holder.model.LinksPaginated;
import au.org.consumerdatastandards.holder.model.MetaPaginated;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * EnergyPlanListResponse
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen",
        date = "2022-01-11T14:03:27.755+11:00[Australia/Sydney]")
public class EnergyPlanListResponse {
    @JsonProperty("data")
    private EnergyPlanListResponseData data;

    @JsonProperty("links")
    private LinksPaginated links;

    @JsonProperty("meta")
    private MetaPaginated meta;

    public EnergyPlanListResponse data(EnergyPlanListResponseData data) {
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

    public EnergyPlanListResponseData getData() {
        return data;
    }

    public void setData(EnergyPlanListResponseData data) {
        this.data = data;
    }

    public EnergyPlanListResponse links(LinksPaginated links) {
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

    public LinksPaginated getLinks() {
        return links;
    }

    public void setLinks(LinksPaginated links) {
        this.links = links;
    }

    public EnergyPlanListResponse meta(MetaPaginated meta) {
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

    @Valid

    public MetaPaginated getMeta() {
        return meta;
    }

    public void setMeta(MetaPaginated meta) {
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
        EnergyPlanListResponse energyPlanListResponse = (EnergyPlanListResponse) o;
        return Objects.equals(this.data, energyPlanListResponse.data) &&
                Objects.equals(this.links, energyPlanListResponse.links) &&
                Objects.equals(this.meta, energyPlanListResponse.meta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, links, meta);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyPlanListResponse {\n");

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

