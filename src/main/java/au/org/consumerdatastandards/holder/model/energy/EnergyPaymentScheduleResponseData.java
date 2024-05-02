package au.org.consumerdatastandards.holder.model.energy;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

public class EnergyPaymentScheduleResponseData {
    private List<EnergyPaymentSchedule> paymentSchedules;

    /**
     * Array may be empty if no payment schedule exist
     *
     * @return paymentSchedules
     */
    @ApiModelProperty(required = true, value = "Array may be empty if no payment schedule exist")
    @NotNull
    @Valid
    public List<EnergyPaymentSchedule> getPaymentSchedules() {
        return paymentSchedules;
    }

    public void setPaymentSchedules(List<EnergyPaymentSchedule> paymentSchedules) {
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
        EnergyPaymentScheduleResponseData data = (EnergyPaymentScheduleResponseData) o;
        return Objects.equals(this.paymentSchedules, data.paymentSchedules);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paymentSchedules);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyPaymentScheduleResponse {\n");
        sb.append("    data: ").append(toIndentedString(paymentSchedules)).append("\n");
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
