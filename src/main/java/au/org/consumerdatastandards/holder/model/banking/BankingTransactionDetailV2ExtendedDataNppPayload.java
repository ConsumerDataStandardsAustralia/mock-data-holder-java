package au.org.consumerdatastandards.holder.model.banking;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Objects;

@ApiModel(description = "Required if the _extensionUType_ value is `nppPayload`.")
@Embeddable
public class BankingTransactionDetailV2ExtendedDataNppPayload {

    /**
     * An end to end ID for the payment created at initiation.
     */
    private String endToEndId;

    /**
     * An extended string description. Required if the _extensionUType_ value is `nppPayload`.
     */
    private String extendedDescription;

    /**
     * Purpose of the payment. Format is defined by the NPP standards for the NPP overlay services including Osko (X2P1).
     */
    private String purposeCode;

    public enum Service {
        X2P1,
        IFTI,
        BSCT,
        CATSCT
    }

    /**
     * Identifier of the applicable overlay service. The _service_ is used in conjunction with the _serviceVersion_. See [here](#npp-services) for more details.
     */
    @Enumerated(EnumType.STRING)
    private Service service;

    /**
     * Two-digit NPP service overlay version with leading zero.
     */
    private String serviceVersion;

    public BankingTransactionDetailV2ExtendedDataNppPayload endToEndId(String endToEndId) {
        this.endToEndId = endToEndId;
        return this;
    }

    @ApiModelProperty(value = "An end to end ID for the payment created at initiation.")
    public String getEndToEndId() {
        return endToEndId;
    }

    public void setEndToEndId(String endToEndId) {
        this.endToEndId = endToEndId;
    }
    public BankingTransactionDetailV2ExtendedDataNppPayload extendedDescription(String extendedDescription) {
        this.extendedDescription = extendedDescription;
        return this;
    }

    @ApiModelProperty(required = true, value = "An extended string description. Required if the _extensionUType_ value is `nppPayload`.")
    public String getExtendedDescription() {
        return extendedDescription;
    }

    public void setExtendedDescription(String extendedDescription) {
        this.extendedDescription = extendedDescription;
    }
    public BankingTransactionDetailV2ExtendedDataNppPayload purposeCode(String purposeCode) {
        this.purposeCode = purposeCode;
        return this;
    }

    @ApiModelProperty(value = "Purpose of the payment. Format is defined by the NPP standards for the NPP overlay services including Osko (X2P1).")
    public String getPurposeCode() {
        return purposeCode;
    }

    public void setPurposeCode(String purposeCode) {
        this.purposeCode = purposeCode;
    }

    public BankingTransactionDetailV2ExtendedDataNppPayload service(Service service) {
        this.service = service;
        return this;
    }

    @ApiModelProperty(required = true, value = "Identifier of the applicable overlay service. The _service_ is used in conjunction with the _serviceVersion_. See [here](#npp-services) for more details.")
    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    @ApiModelProperty(required = true, value = "Two-digit NPP service overlay version with leading zero.")
    public String getServiceVersion() {
        return serviceVersion;
    }

    public void setServiceVersion(String serviceVersion) {
        this.serviceVersion = serviceVersion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BankingTransactionDetailV2ExtendedDataNppPayload bankingTransactionDetailExtendedDataX2p101Payload = (BankingTransactionDetailV2ExtendedDataNppPayload) o;
        return Objects.equals(this.endToEndId, bankingTransactionDetailExtendedDataX2p101Payload.endToEndId) &&
            Objects.equals(this.extendedDescription, bankingTransactionDetailExtendedDataX2p101Payload.extendedDescription) &&
            Objects.equals(this.purposeCode, bankingTransactionDetailExtendedDataX2p101Payload.purposeCode) &&
            Objects.equals(this.service, bankingTransactionDetailExtendedDataX2p101Payload.service) &&
            Objects.equals(this.serviceVersion, bankingTransactionDetailExtendedDataX2p101Payload.serviceVersion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            endToEndId,
            extendedDescription,
            purposeCode,
            service,
            serviceVersion);
    }

    @Override
    public String toString() {
        return "class BankingTransactionDetailExtendedDataNppPayload {\n" +
            "   endToEndId: " + toIndentedString(endToEndId) + "\n" + 
            "   extendedDescription: " + toIndentedString(extendedDescription) + "\n" + 
            "   purposeCode: " + toIndentedString(purposeCode) + "\n" +
            "   service: " + toIndentedString(service) + "\n" +
            "   serviceVersion: " + toIndentedString(serviceVersion) + "\n" +
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
