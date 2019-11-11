package au.org.consumerdatastandards.holder.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@ApiModel
@Entity
public class BankingDomesticPayeeAccount  {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @JsonIgnore
    private String id;

    /**
     * Name of the account to pay to
     */
    private String accountName;

    /**
     * Number of the account to pay to
     */
    private String accountNumber;

    /**
     * BSB of the account to pay to
     */
    private String bsb;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BankingDomesticPayeeAccount accountName(String accountName) {
        this.accountName = accountName;
        return this;
    }

    @ApiModelProperty(required = true, value = "Name of the account to pay to")
    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
    public BankingDomesticPayeeAccount accountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
        return this;
    }

    @ApiModelProperty(required = true, value = "Number of the account to pay to")
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    public BankingDomesticPayeeAccount bsb(String bsb) {
        this.bsb = bsb;
        return this;
    }

    @ApiModelProperty(required = true, value = "BSB of the account to pay to")
    public String getBsb() {
        return bsb;
    }

    public void setBsb(String bsb) {
        this.bsb = bsb;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BankingDomesticPayeeAccount bankingDomesticPayeeAccount = (BankingDomesticPayeeAccount) o;
        return Objects.equals(this.id, bankingDomesticPayeeAccount.id) &&
            Objects.equals(this.accountName, bankingDomesticPayeeAccount.accountName) &&
            Objects.equals(this.accountNumber, bankingDomesticPayeeAccount.accountNumber) &&
            Objects.equals(this.bsb, bankingDomesticPayeeAccount.bsb);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            id,
            accountName,
            accountNumber,
            bsb);
    }

    @Override
    public String toString() {
        return "class BankingDomesticPayeeAccount {\n" +
            "   id: " + toIndentedString(id) + "\n" +
            "   accountName: " + toIndentedString(accountName) + "\n" +
            "   accountNumber: " + toIndentedString(accountNumber) + "\n" +
            "   bsb: " + toIndentedString(bsb) + "\n" + 
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

