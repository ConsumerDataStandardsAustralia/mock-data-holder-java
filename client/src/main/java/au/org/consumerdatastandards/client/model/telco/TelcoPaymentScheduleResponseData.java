package au.org.consumerdatastandards.client.model.telco;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * TelcoPaymentScheduleResponseData
 */
public class TelcoPaymentScheduleResponseData {
    private List<TelcoPaymentSchedule> paymentSchedules = new ArrayList<>();

    public TelcoPaymentScheduleResponseData paymentSchedules(List<TelcoPaymentSchedule> paymentSchedules) {
        this.paymentSchedules = paymentSchedules;
        return this;
    }

    public TelcoPaymentScheduleResponseData addPaymentSchedulesItem(TelcoPaymentSchedule paymentSchedulesItem) {
        this.paymentSchedules.add(paymentSchedulesItem);
        return this;
    }

    /**
     * Array may be empty if no payment schedule exist
     *
     * @return paymentSchedules
     */
    public List<TelcoPaymentSchedule> getPaymentSchedules() {
        return paymentSchedules;
    }

    public void setPaymentSchedules(List<TelcoPaymentSchedule> paymentSchedules) {
        this.paymentSchedules = paymentSchedules;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TelcoPaymentScheduleResponseData telcoPaymentScheduleResponseData = (TelcoPaymentScheduleResponseData) o;
        return Objects.equals(this.paymentSchedules, telcoPaymentScheduleResponseData.paymentSchedules);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paymentSchedules);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TelcoPaymentScheduleResponseData {\n");
        sb.append("    paymentSchedules: ").append(toIndentedString(paymentSchedules)).append("\n");
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
