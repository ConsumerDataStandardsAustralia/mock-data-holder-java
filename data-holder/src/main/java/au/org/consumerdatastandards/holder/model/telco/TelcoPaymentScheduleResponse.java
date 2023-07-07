package au.org.consumerdatastandards.holder.model.telco;

import au.org.consumerdatastandards.holder.model.LinksPaginated;
import au.org.consumerdatastandards.holder.model.MetaPaginated;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * TelcoPaymentScheduleResponse
 */
public class TelcoPaymentScheduleResponse {
    private TelcoPaymentScheduleResponseData data;

    private LinksPaginated links;

    private MetaPaginated meta;

    public TelcoPaymentScheduleResponse data(TelcoPaymentScheduleResponseData data) {
        this.data = data;
        return this;
    }

    /**
     * Get data
     *
     * @return data
     */
    @ApiModelProperty(required = true, value = "")
    @NotNull
    @Valid
    public TelcoPaymentScheduleResponseData getData() {
        return data;
    }

    public void setData(TelcoPaymentScheduleResponseData data) {
        this.data = data;
    }

    public TelcoPaymentScheduleResponse links(LinksPaginated links) {
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
    public LinksPaginated getLinks() {
        return links;
    }

    public void setLinks(LinksPaginated links) {
        this.links = links;
    }

    public TelcoPaymentScheduleResponse meta(MetaPaginated meta) {
        this.meta = meta;
        return this;
    }

    /**
     * Get meta
     *
     * @return meta
     */
    @ApiModelProperty(required = true, value = "")
    @NotNull
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
        TelcoPaymentScheduleResponse telcoPaymentScheduleResponse = (TelcoPaymentScheduleResponse) o;
        return Objects.equals(this.data, telcoPaymentScheduleResponse.data) &&
                Objects.equals(this.links, telcoPaymentScheduleResponse.links) &&
                Objects.equals(this.meta, telcoPaymentScheduleResponse.meta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, links, meta);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TelcoPaymentScheduleResponse {\n");
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
