package au.org.consumerdatastandards.client.model.telco;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Detail on the plan applicable to this account. Mandatory if openStatus is OPEN
 */
public class TelcoAccountDetailPlanDetail {
    private List<TelcoProductDetailMeteringCharges> charges = new ArrayList<>();

    public TelcoAccountDetailPlanDetail charges(List<TelcoProductDetailMeteringCharges> charges) {
        this.charges = charges;
        return this;
    }

    public TelcoAccountDetailPlanDetail addChargesItem(TelcoProductDetailMeteringCharges chargesItem) {
        this.charges.add(chargesItem);
        return this;
    }

    /**
     * Charges for metering included in the plan
     *
     * @return charges
     */
    public List<TelcoProductDetailMeteringCharges> getCharges() {
        return charges;
    }

    public void setCharges(List<TelcoProductDetailMeteringCharges> charges) {
        this.charges = charges;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TelcoAccountDetailPlanDetail telcoAccountDetailPlanDetail = (TelcoAccountDetailPlanDetail) o;
        return Objects.equals(this.charges, telcoAccountDetailPlanDetail.charges);
    }

    @Override
    public int hashCode() {
        return Objects.hash(charges);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TelcoAccountDetailPlanDetail {\n");
        sb.append("    charges: ").append(toIndentedString(charges)).append("\n");
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
