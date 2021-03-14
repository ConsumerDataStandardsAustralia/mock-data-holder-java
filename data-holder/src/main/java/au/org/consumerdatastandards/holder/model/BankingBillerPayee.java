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
public class BankingBillerPayee  {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @JsonIgnore
    private String id;

    /**
     * BPAY Biller Code of the Biller
     */
    private String billerCode;

    /**
     * Name of the Biller
     */
    private String billerName;

    /**
     * BPAY CRN of the Biller (if available).<br>Where the CRN contains sensitive information, it should be masked in line with how the Data Holder currently displays account identifiers in their existing online banking channels. If the contents of the CRN match the format of a Credit Card PAN they should be masked according to the rules applicable for MaskedPANString. If the contents are are otherwise sensitive, then it should be masked using the rules applicable for the MaskedAccountString common type.
     */
    private String crn;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BankingBillerPayee billerCode(String billerCode) {
        this.billerCode = billerCode;
        return this;
    }

    @ApiModelProperty(required = true, value = "BPAY Biller Code of the Biller")
    public String getBillerCode() {
        return billerCode;
    }

    public void setBillerCode(String billerCode) {
        this.billerCode = billerCode;
    }
    public BankingBillerPayee billerName(String billerName) {
        this.billerName = billerName;
        return this;
    }

    @ApiModelProperty(required = true, value = "Name of the Biller")
    public String getBillerName() {
        return billerName;
    }

    public void setBillerName(String billerName) {
        this.billerName = billerName;
    }
    public BankingBillerPayee crn(String crn) {
        this.crn = crn;
        return this;
    }

    @ApiModelProperty(value = "BPAY CRN of the Biller (if available).<br>Where the CRN contains sensitive information, it should be masked in line with how the Data Holder currently displays account identifiers in their existing online banking channels. If the contents of the CRN match the format of a Credit Card PAN they should be masked according to the rules applicable for MaskedPANString. If the contents are are otherwise sensitive, then it should be masked using the rules applicable for the MaskedAccountString common type.")
    public String getCrn() {
        return crn;
    }

    public void setCrn(String crn) {
        this.crn = crn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BankingBillerPayee bankingBillerPayee = (BankingBillerPayee) o;
        return Objects.equals(this.id, bankingBillerPayee.id) &&
            Objects.equals(this.billerCode, bankingBillerPayee.billerCode) &&
            Objects.equals(this.billerName, bankingBillerPayee.billerName) &&
            Objects.equals(this.crn, bankingBillerPayee.crn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            id,
            billerCode,
            billerName,
            crn);
    }

    @Override
    public String toString() {
        return "class BankingBillerPayee {\n" +
            "   id: " + toIndentedString(id) + "\n" +
            "   billerCode: " + toIndentedString(billerCode) + "\n" +
            "   billerName: " + toIndentedString(billerName) + "\n" +
            "   crn: " + toIndentedString(crn) + "\n" + 
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

