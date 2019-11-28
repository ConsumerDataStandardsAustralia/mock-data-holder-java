package au.org.consumerdatastandards.holder.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import java.util.Objects;

@ApiModel
@Embeddable
public class BankingTransactionDetailExtendedData  {

    public enum ExtensionUType {
        x2p101Payload
    }

    public enum Service {
        X2P1_01("X2P1.01");

        private String value;

        Service(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    private ExtensionUType extensionUType;

    /**
     * Label of the target PayID.  Mandatory for an outbound payment. The name assigned to the BSB/Account Number or PayID (by the owner of the PayID)
     */
    private String payee;

    /**
     * Label of the originating payer. Mandatory for inbound payment
     */
    private String payer;

    private Service service;

    @Embedded
    private BankingTransactionDetailExtendedDataX2p101Payload x2p101Payload;

    public BankingTransactionDetailExtendedData extensionUType(ExtensionUType extensionUType) {
        this.extensionUType = extensionUType;
        return this;
    }

    @ApiModelProperty
    public ExtensionUType getExtensionUType() {
        return extensionUType;
    }

    public void setExtensionUType(ExtensionUType extensionUType) {
        this.extensionUType = extensionUType;
    }
    public BankingTransactionDetailExtendedData payee(String payee) {
        this.payee = payee;
        return this;
    }

    @ApiModelProperty(value = "Label of the target PayID.  Mandatory for an outbound payment. The name assigned to the BSB/Account Number or PayID (by the owner of the PayID)")
    public String getPayee() {
        return payee;
    }

    public void setPayee(String payee) {
        this.payee = payee;
    }
    public BankingTransactionDetailExtendedData payer(String payer) {
        this.payer = payer;
        return this;
    }

    @ApiModelProperty(value = "Label of the originating payer. Mandatory for inbound payment")
    public String getPayer() {
        return payer;
    }

    public void setPayer(String payer) {
        this.payer = payer;
    }
    public BankingTransactionDetailExtendedData service(Service service) {
        this.service = service;
        return this;
    }

    @ApiModelProperty(required = true)
    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
    public BankingTransactionDetailExtendedData x2p101Payload(BankingTransactionDetailExtendedDataX2p101Payload x2p101Payload) {
        this.x2p101Payload = x2p101Payload;
        return this;
    }

    @ApiModelProperty
    public BankingTransactionDetailExtendedDataX2p101Payload getX2p101Payload() {
        return x2p101Payload;
    }

    public void setX2p101Payload(BankingTransactionDetailExtendedDataX2p101Payload x2p101Payload) {
        this.x2p101Payload = x2p101Payload;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BankingTransactionDetailExtendedData bankingTransactionDetailExtendedData = (BankingTransactionDetailExtendedData) o;
        return Objects.equals(this.extensionUType, bankingTransactionDetailExtendedData.extensionUType) &&
            Objects.equals(this.payee, bankingTransactionDetailExtendedData.payee) &&
            Objects.equals(this.payer, bankingTransactionDetailExtendedData.payer) &&
            Objects.equals(this.service, bankingTransactionDetailExtendedData.service) &&
            Objects.equals(this.x2p101Payload, bankingTransactionDetailExtendedData.x2p101Payload);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            extensionUType,
            payee,
            payer,
            service,
            x2p101Payload);
    }

    @Override
    public String toString() {
        return "class BankingTransactionDetailExtendedData {\n" +
            "   extensionUType: " + toIndentedString(extensionUType) + "\n" + 
            "   payee: " + toIndentedString(payee) + "\n" + 
            "   payer: " + toIndentedString(payer) + "\n" + 
            "   service: " + toIndentedString(service) + "\n" + 
            "   x2p101Payload: " + toIndentedString(x2p101Payload) + "\n" + 
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

