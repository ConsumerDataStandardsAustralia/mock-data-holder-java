package au.org.consumerdatastandards.holder.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Embeddable;
import java.util.Objects;

@ApiModel
@Embeddable
public class BankingTransactionDetailExtendedDataX2p101Payload  {

    /**
     * An end to end ID for the payment created at initiation
     */
    private String endToEndId;

    /**
     * An extended string description. Only present if specified by the extensionUType field
     */
    private String extendedDescription;

    /**
     * Purpose of the payment.  Format is defined by NPP standards for the x2p1.01 overlay service
     */
    private String purposeCode;

    public BankingTransactionDetailExtendedDataX2p101Payload endToEndId(String endToEndId) {
        this.endToEndId = endToEndId;
        return this;
    }

    @ApiModelProperty(value = "An end to end ID for the payment created at initiation")
    public String getEndToEndId() {
        return endToEndId;
    }

    public void setEndToEndId(String endToEndId) {
        this.endToEndId = endToEndId;
    }
    public BankingTransactionDetailExtendedDataX2p101Payload extendedDescription(String extendedDescription) {
        this.extendedDescription = extendedDescription;
        return this;
    }

    @ApiModelProperty(required = true, value = "An extended string description. Only present if specified by the extensionUType field")
    public String getExtendedDescription() {
        return extendedDescription;
    }

    public void setExtendedDescription(String extendedDescription) {
        this.extendedDescription = extendedDescription;
    }
    public BankingTransactionDetailExtendedDataX2p101Payload purposeCode(String purposeCode) {
        this.purposeCode = purposeCode;
        return this;
    }

    @ApiModelProperty(value = "Purpose of the payment.  Format is defined by NPP standards for the x2p1.01 overlay service")
    public String getPurposeCode() {
        return purposeCode;
    }

    public void setPurposeCode(String purposeCode) {
        this.purposeCode = purposeCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BankingTransactionDetailExtendedDataX2p101Payload bankingTransactionDetailExtendedDataX2p101Payload = (BankingTransactionDetailExtendedDataX2p101Payload) o;
        return Objects.equals(this.endToEndId, bankingTransactionDetailExtendedDataX2p101Payload.endToEndId) &&
            Objects.equals(this.extendedDescription, bankingTransactionDetailExtendedDataX2p101Payload.extendedDescription) &&
            Objects.equals(this.purposeCode, bankingTransactionDetailExtendedDataX2p101Payload.purposeCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            endToEndId,
            extendedDescription,
            purposeCode);
    }

    @Override
    public String toString() {
        return "class BankingTransactionDetailExtendedDataX2p101Payload {\n" +
            "   endToEndId: " + toIndentedString(endToEndId) + "\n" + 
            "   extendedDescription: " + toIndentedString(extendedDescription) + "\n" + 
            "   purposeCode: " + toIndentedString(purposeCode) + "\n" + 
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

