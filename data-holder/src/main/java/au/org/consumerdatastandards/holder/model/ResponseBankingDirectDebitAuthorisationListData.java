package au.org.consumerdatastandards.holder.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;
import java.util.List;

@ApiModel
public class ResponseBankingDirectDebitAuthorisationListData  {

    /**
     * The list of authorisations returned
     */
    
    private List<BankingDirectDebit> directDebitAuthorisations;

    public ResponseBankingDirectDebitAuthorisationListData directDebitAuthorisations(List<BankingDirectDebit> directDebitAuthorisations) {
        this.directDebitAuthorisations = directDebitAuthorisations;
        return this;
    }

    public ResponseBankingDirectDebitAuthorisationListData addItem(BankingDirectDebit directDebitAuthorisationsItem) {
        this.directDebitAuthorisations.add(directDebitAuthorisationsItem);
        return this;
    }

    @ApiModelProperty(required = true, value = "The list of authorisations returned")
    public List<BankingDirectDebit> getDirectDebitAuthorisations() {
        return directDebitAuthorisations;
    }

    public void setDirectDebitAuthorisations(List<BankingDirectDebit> directDebitAuthorisations) {
        this.directDebitAuthorisations = directDebitAuthorisations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ResponseBankingDirectDebitAuthorisationListData responseBankingDirectDebitAuthorisationListData = (ResponseBankingDirectDebitAuthorisationListData) o;
        return Objects.equals(this.directDebitAuthorisations, responseBankingDirectDebitAuthorisationListData.directDebitAuthorisations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            directDebitAuthorisations);
    }

    @Override
    public String toString() {
        return "class ResponseBankingDirectDebitAuthorisationListData {\n" +
            "   directDebitAuthorisations: " + toIndentedString(directDebitAuthorisations) + "\n" + 
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

