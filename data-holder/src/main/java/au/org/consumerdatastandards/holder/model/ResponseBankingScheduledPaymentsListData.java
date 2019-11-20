package au.org.consumerdatastandards.holder.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;
import java.util.List;

@ApiModel
public class ResponseBankingScheduledPaymentsListData  {

    /**
     * The list of scheduled payments to return
     */
    
    private List<BankingScheduledPayment> scheduledPayments;

    public ResponseBankingScheduledPaymentsListData scheduledPayments(List<BankingScheduledPayment> scheduledPayments) {
        this.scheduledPayments = scheduledPayments;
        return this;
    }

    public ResponseBankingScheduledPaymentsListData addItem(BankingScheduledPayment scheduledPaymentsItem) {
        this.scheduledPayments.add(scheduledPaymentsItem);
        return this;
    }

    @ApiModelProperty(required = true, value = "The list of scheduled payments to return")
    public List<BankingScheduledPayment> getScheduledPayments() {
        return scheduledPayments;
    }

    public void setScheduledPayments(List<BankingScheduledPayment> scheduledPayments) {
        this.scheduledPayments = scheduledPayments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ResponseBankingScheduledPaymentsListData responseBankingScheduledPaymentsListData = (ResponseBankingScheduledPaymentsListData) o;
        return Objects.equals(this.scheduledPayments, responseBankingScheduledPaymentsListData.scheduledPayments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            scheduledPayments);
    }

    @Override
    public String toString() {
        return "class ResponseBankingScheduledPaymentsListData {\n" +
            "   scheduledPayments: " + toIndentedString(scheduledPayments) + "\n" + 
            "}";
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

