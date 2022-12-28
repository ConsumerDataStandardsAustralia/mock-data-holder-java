package au.org.consumerdatastandards.holder.model.telco;

import au.org.consumerdatastandards.holder.model.Links;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * TelcoAccountDetailResponse
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen",
        date = "2022-12-23T11:32:06.900+11:00[Australia/Sydney]")
public class TelcoAccountDetailResponse {
    @JsonProperty("data")
    private JsonNullable<TelcoAccountBase> data = JsonNullable.undefined();

    @JsonProperty("links")
    private Links links;

    @JsonProperty("meta")
    private Object meta;

    public TelcoAccountDetailResponse data(TelcoAccountBase data) {
        this.data = JsonNullable.of(data);
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

    public JsonNullable<TelcoAccountBase> getData() {
        return data;
    }

    public void setData(JsonNullable<TelcoAccountBase> data) {
        this.data = data;
    }

    public TelcoAccountDetailResponse links(Links links) {
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

    public TelcoAccountDetailResponse meta(Object meta) {
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
        TelcoAccountDetailResponse telcoAccountDetailResponse = (TelcoAccountDetailResponse) o;
        return Objects.equals(this.data, telcoAccountDetailResponse.data) &&
                Objects.equals(this.links, telcoAccountDetailResponse.links) &&
                Objects.equals(this.meta, telcoAccountDetailResponse.meta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, links, meta);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TelcoAccountDetailResponse {\n");

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

