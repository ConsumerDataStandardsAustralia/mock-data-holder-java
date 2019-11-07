package au.org.consumerdatastandards.holder.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;

@ApiModel
public class BankingInternationalPayee  {

    /**
     * Get bankDetails
     */
    private BankingInternationalPayeeBankDetails bankDetails;

    /**
     * Get beneficiaryDetails
     */
    private BankingInternationalPayeeBeneficiaryDetails beneficiaryDetails;

    public BankingInternationalPayee bankDetails(BankingInternationalPayeeBankDetails bankDetails) {
        this.bankDetails = bankDetails;
        return this;
    }

    @ApiModelProperty(required = true, value = "")
    public BankingInternationalPayeeBankDetails getBankDetails() {
        return bankDetails;
    }

    public void setBankDetails(BankingInternationalPayeeBankDetails bankDetails) {
        this.bankDetails = bankDetails;
    }
    public BankingInternationalPayee beneficiaryDetails(BankingInternationalPayeeBeneficiaryDetails beneficiaryDetails) {
        this.beneficiaryDetails = beneficiaryDetails;
        return this;
    }

    @ApiModelProperty(required = true, value = "")
    public BankingInternationalPayeeBeneficiaryDetails getBeneficiaryDetails() {
        return beneficiaryDetails;
    }

    public void setBeneficiaryDetails(BankingInternationalPayeeBeneficiaryDetails beneficiaryDetails) {
        this.beneficiaryDetails = beneficiaryDetails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BankingInternationalPayee bankingInternationalPayee = (BankingInternationalPayee) o;
        return Objects.equals(this.bankDetails, bankingInternationalPayee.bankDetails) &&
            Objects.equals(this.beneficiaryDetails, bankingInternationalPayee.beneficiaryDetails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            bankDetails,
            beneficiaryDetails);
    }

    @Override
    public String toString() {
        return "class BankingInternationalPayee {\n" +
            "   bankDetails: " + toIndentedString(bankDetails) + "\n" + 
            "   beneficiaryDetails: " + toIndentedString(beneficiaryDetails) + "\n" + 
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

