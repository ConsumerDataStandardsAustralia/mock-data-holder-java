package au.org.consumerdatastandards.client.model.telco;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * TelcoProductListResponseData
 */
public class TelcoProductListResponseData {
    private List<TelcoProduct> plans = new ArrayList<>();

    public TelcoProductListResponseData plans(List<TelcoProduct> plans) {
        this.plans = plans;
        return this;
    }

    public TelcoProductListResponseData addPlansItem(TelcoProduct plansItem) {
        this.plans.add(plansItem);
        return this;
    }

    /**
     * Array of Products
     *
     * @return plans
     */
    public List<TelcoProduct> getPlans() {
        return plans;
    }

    public void setPlans(List<TelcoProduct> plans) {
        this.plans = plans;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TelcoProductListResponseData telcoProductListResponseData = (TelcoProductListResponseData) o;
        return Objects.equals(this.plans, telcoProductListResponseData.plans);
    }

    @Override
    public int hashCode() {
        return Objects.hash(plans);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TelcoProductListResponseData {\n");
        sb.append("    plans: ").append(toIndentedString(plans)).append("\n");
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
