package au.org.consumerdatastandards.client.model.energy;

import java.util.Objects;

/**
 * Represents a manual payment schedule where the customer pays in response to a delivered statement. Mandatory if paymentScheduleUType is set to manualPayment
 */
public class EnergyPaymentScheduleManualPayment {
    private String billFrequency;

    public EnergyPaymentScheduleManualPayment billFrequency(String billFrequency) {
        this.billFrequency = billFrequency;
        return this;
    }

    /**
     * The frequency with which a bill will be issued.  Formatted according to [ISO 8601 Durations](https://en.wikipedia.org/wiki/ISO_8601#Durations) (excludes recurrence syntax)
     *
     * @return billFrequency
     */
    public String getBillFrequency() {
        return billFrequency;
    }

    public void setBillFrequency(String billFrequency) {
        this.billFrequency = billFrequency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EnergyPaymentScheduleManualPayment energyPaymentScheduleManualPayment = (EnergyPaymentScheduleManualPayment) o;
        return Objects.equals(this.billFrequency, energyPaymentScheduleManualPayment.billFrequency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(billFrequency);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyPaymentScheduleManualPayment {\n");
        sb.append("    billFrequency: ").append(toIndentedString(billFrequency)).append("\n");
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
