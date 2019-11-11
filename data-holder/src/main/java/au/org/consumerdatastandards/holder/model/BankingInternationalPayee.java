package au.org.consumerdatastandards.holder.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.Objects;

@ApiModel
@Entity
public class BankingInternationalPayee  {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @JsonIgnore
    private String id;

    @OneToOne
    private BankingInternationalPayeeBankDetails bankDetails;

    @OneToOne
    private BankingInternationalPayeeBeneficiaryDetails beneficiaryDetails;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BankingInternationalPayee bankDetails(BankingInternationalPayeeBankDetails bankDetails) {
        this.bankDetails = bankDetails;
        return this;
    }

    @ApiModelProperty(required = true)
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

    @ApiModelProperty(required = true)
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
        return Objects.equals(this.id, bankingInternationalPayee.id) &&
            Objects.equals(this.bankDetails, bankingInternationalPayee.bankDetails) &&
            Objects.equals(this.beneficiaryDetails, bankingInternationalPayee.beneficiaryDetails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            id,
            bankDetails,
            beneficiaryDetails);
    }

    @Override
    public String toString() {
        return "class BankingInternationalPayee {\n" +
            "   bankDetails: " + toIndentedString(id) + "\n" +
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

