package au.org.consumerdatastandards.holder.model.telco;

import au.org.consumerdatastandards.holder.model.Links;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * TelcoProductResponse
 */
public class TelcoProductResponse {
    private TelcoProductDetail data = new TelcoProductDetail();

    private Links links;

    private Object meta;

    /**
     * Get data
     *
     * @return data
     */
    @ApiModelProperty(required = true, value = "")
    @NotNull
    @Valid
    public TelcoProductDetail getData() {
        return data;
    }

    public void setData(TelcoProductDetail data) {
        this.data = data;
    }

    public TelcoProductResponse links(Links links) {
        this.links = links;
        return this;
    }

    /**
     * Get links
     *
     * @return links
     */
    @ApiModelProperty(required = true, value = "")
    @NotNull
    @Valid
    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public TelcoProductResponse meta(Object meta) {
        this.meta = meta;
        return this;
    }

    /**
     * Get meta
     *
     * @return meta
     */
    @ApiModelProperty(value = "")
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
        TelcoProductResponse telcoProductResponse = (TelcoProductResponse) o;
        return Objects.equals(this.data, telcoProductResponse.data) &&
                Objects.equals(this.links, telcoProductResponse.links) &&
                Objects.equals(this.meta, telcoProductResponse.meta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, links, meta);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TelcoProductResponse {\n");
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
