package au.org.consumerdatastandards.client.model.energy;

import au.org.consumerdatastandards.client.model.Links;

import java.util.Objects;

/**
 * EnergyPlanResponse
 */
public class EnergyPlanResponse<T extends EnergyPlanDetail> {
    private T data;

    private Links links;

    private Object meta;

    public EnergyPlanResponse<T> data(T data) {
        this.data = data;
        return this;
    }

    /**
     * Get data
     *
     * @return data
     */
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public EnergyPlanResponse<T> links(Links links) {
        this.links = links;
        return this;
    }

    /**
     * Get links
     *
     * @return links
     */
    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public EnergyPlanResponse<T> meta(Object meta) {
        this.meta = meta;
        return this;
    }

    /**
     * Get meta
     *
     * @return meta
     */
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
        EnergyPlanResponse<T> energyPlanResponse = (EnergyPlanResponse<T>) o;
        return Objects.equals(this.data, energyPlanResponse.data) &&
                Objects.equals(this.links, energyPlanResponse.links) &&
                Objects.equals(this.meta, energyPlanResponse.meta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, links, meta);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyPlanResponse {\n");
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
