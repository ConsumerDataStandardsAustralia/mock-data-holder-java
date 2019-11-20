package au.org.consumerdatastandards.holder.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;
import java.util.List;

@ApiModel
public class ResponseBankingPayeeListData  {

    /**
     * The list of payees returned
     */
    
    private List<BankingPayee> payees;

    public ResponseBankingPayeeListData payees(List<BankingPayee> payees) {
        this.payees = payees;
        return this;
    }

    public ResponseBankingPayeeListData addItem(BankingPayee payeesItem) {
        this.payees.add(payeesItem);
        return this;
    }

    @ApiModelProperty(required = true, value = "The list of payees returned")
    public List<BankingPayee> getPayees() {
        return payees;
    }

    public void setPayees(List<BankingPayee> payees) {
        this.payees = payees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ResponseBankingPayeeListData responseBankingPayeeListData = (ResponseBankingPayeeListData) o;
        return Objects.equals(this.payees, responseBankingPayeeListData.payees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            payees);
    }

    @Override
    public String toString() {
        return "class ResponseBankingPayeeListData {\n" +
            "   payees: " + toIndentedString(payees) + "\n" + 
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

