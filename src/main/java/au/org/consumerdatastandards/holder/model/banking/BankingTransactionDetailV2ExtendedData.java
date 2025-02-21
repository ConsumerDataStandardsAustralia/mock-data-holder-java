package au.org.consumerdatastandards.holder.model.banking;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Objects;

@ApiModel
@Embeddable
public class BankingTransactionDetailV2ExtendedData {

    public enum ExtensionUType {
        nppPayload
    }

    /**
     * Optional extended data specific to transactions. Currently extended data is supported for NPP service overlays.
     */
    @Enumerated(EnumType.STRING)
    private ExtensionUType extensionUType;

    /**
     * Label of the target PayID. Mandatory for an outbound payment. The name assigned to the BSB/Account Number or PayID (by the owner of the PayID).
     */
    private String payee;

    /**
     * Label of the originating payer. Mandatory for inbound payment.
     */
    private String payer;

    @Embedded
    private BankingTransactionDetailV2ExtendedDataNppPayload nppPayload;

    public BankingTransactionDetailV2ExtendedData extensionUType(ExtensionUType extensionUType) {
        this.extensionUType = extensionUType;
        return this;
    }

    @ApiModelProperty("Optional extended data specific to transactions. Currently extended data is supported for NPP service overlays.")
    public ExtensionUType getExtensionUType() {
        return extensionUType;
    }

    public void setExtensionUType(ExtensionUType extensionUType) {
        this.extensionUType = extensionUType;
    }
    public BankingTransactionDetailV2ExtendedData payee(String payee) {
        this.payee = payee;
        return this;
    }

    @ApiModelProperty(value = "Label of the target PayID. Mandatory for an outbound payment. The name assigned to the BSB/Account Number or PayID (by the owner of the PayID).")
    public String getPayee() {
        return payee;
    }

    public void setPayee(String payee) {
        this.payee = payee;
    }

    public BankingTransactionDetailV2ExtendedData payer(String payer) {
        this.payer = payer;
        return this;
    }

    @ApiModelProperty(value = "Label of the originating payer. Mandatory for inbound payment.")
    public String getPayer() {
        return payer;
    }

    public void setPayer(String payer) {
        this.payer = payer;
    }

    public BankingTransactionDetailV2ExtendedData nppPayload(BankingTransactionDetailV2ExtendedDataNppPayload nppPayload) {
        this.nppPayload = nppPayload;
        return this;
    }

    @ApiModelProperty
    public BankingTransactionDetailV2ExtendedDataNppPayload getNppPayload() {
        return nppPayload;
    }

    public void setNppPayload(BankingTransactionDetailV2ExtendedDataNppPayload nppPayload) {
        this.nppPayload = nppPayload;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BankingTransactionDetailV2ExtendedData bankingTransactionDetailExtendedData = (BankingTransactionDetailV2ExtendedData) o;
        return Objects.equals(this.extensionUType, bankingTransactionDetailExtendedData.extensionUType) &&
            Objects.equals(this.payee, bankingTransactionDetailExtendedData.payee) &&
            Objects.equals(this.payer, bankingTransactionDetailExtendedData.payer) &&
            Objects.equals(this.nppPayload, bankingTransactionDetailExtendedData.nppPayload);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            extensionUType,
            payee,
            payer,
                nppPayload);
    }

    @Override
    public String toString() {
        return "class BankingTransactionDetailExtendedData {\n" +
            "   extensionUType: " + toIndentedString(extensionUType) + "\n" + 
            "   payee: " + toIndentedString(payee) + "\n" + 
            "   payer: " + toIndentedString(payer) + "\n" + 
            "   nppPayload: " + toIndentedString(nppPayload) + "\n" +
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
