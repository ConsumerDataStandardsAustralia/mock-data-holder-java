package au.org.consumerdatastandards.holder.model.telco;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * Represents a manual payment schedule where the customer pays in response to a delivered statement. Mandatory if _paymentScheduleUType_ is set to `manualPayment`.
 */
@ApiModel(description = "Represents a manual payment schedule where the customer pays in response to a delivered statement. Mandatory if _paymentScheduleUType_ is set to `manualPayment`.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen",
        date = "2022-12-23T11:32:06.900+11:00[Australia/Sydney]")
public class TelcoPaymentScheduleManualPayment {
    @JsonProperty("billFrequency")
    private String billFrequency;

    public TelcoPaymentScheduleManualPayment billFrequency(String billFrequency) {
        this.billFrequency = billFrequency;
        return this;
    }

    /**
     * The frequency with which a bill will be issued. Formatted according to [ISO 8601 Durations](https://en.wikipedia.org/wiki/ISO_8601#Durations) (excludes recurrence syntax).
     *
     * @return billFrequency
     */
    @ApiModelProperty(required = true,
            value = "The frequency with which a bill will be issued. Formatted according to [ISO 8601 Durations](https://en.wikipedia.org/wiki/ISO_8601#Durations) (excludes recurrence syntax).")
    @NotNull


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
        TelcoPaymentScheduleManualPayment telcoPaymentScheduleManualPayment = (TelcoPaymentScheduleManualPayment) o;
        return Objects.equals(this.billFrequency, telcoPaymentScheduleManualPayment.billFrequency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(billFrequency);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TelcoPaymentScheduleManualPayment {\n");

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

