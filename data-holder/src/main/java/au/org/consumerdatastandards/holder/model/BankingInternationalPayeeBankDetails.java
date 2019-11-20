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
public class BankingInternationalPayeeBankDetails  {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @JsonIgnore
    private String id;

    /**
     * Account Targeted for payment
     */
    private String accountNumber;

    @OneToOne
    private BankingInternationalPayeeBankDetailsBankAddress bankAddress;

    /**
     * Swift bank code.  Aligns with standard [ISO 9362](https://www.iso.org/standard/60390.html)
     */
    private String beneficiaryBankBIC;

    /**
     * Number for the Clearing House Interbank Payments System
     */
    private String chipNumber;

    /**
     * Country of the recipient institution. A valid [ISO 3166 Alpha-3](https://www.iso.org/iso-3166-country-codes.html) country code
     */
    private String country;

    /**
     * Number for Fedwire payment (Federal Reserve Wire Network)
     */
    private String fedWireNumber;

    /**
     * The legal entity identifier (LEI) for the beneficiary.  Aligns with [ISO 17442](https://www.iso.org/standard/59771.html)
     */
    private String legalEntityIdentifier;

    /**
     * International bank routing number
     */
    private String routingNumber;

    /**
     * Sort code used for account identification in some jurisdictions
     */
    private String sortCode;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BankingInternationalPayeeBankDetails accountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
        return this;
    }

    @ApiModelProperty(required = true, value = "Account Targeted for payment")
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BankingInternationalPayeeBankDetails bankAddress(BankingInternationalPayeeBankDetailsBankAddress bankAddress) {
        this.bankAddress = bankAddress;
        return this;
    }

    @ApiModelProperty
    public BankingInternationalPayeeBankDetailsBankAddress getBankAddress() {
        return bankAddress;
    }

    public void setBankAddress(BankingInternationalPayeeBankDetailsBankAddress bankAddress) {
        this.bankAddress = bankAddress;
    }
    public BankingInternationalPayeeBankDetails beneficiaryBankBIC(String beneficiaryBankBIC) {
        this.beneficiaryBankBIC = beneficiaryBankBIC;
        return this;
    }

    @ApiModelProperty(value = "Swift bank code.  Aligns with standard [ISO 9362](https://www.iso.org/standard/60390.html)")
    public String getBeneficiaryBankBIC() {
        return beneficiaryBankBIC;
    }

    public void setBeneficiaryBankBIC(String beneficiaryBankBIC) {
        this.beneficiaryBankBIC = beneficiaryBankBIC;
    }

    public BankingInternationalPayeeBankDetails chipNumber(String chipNumber) {
        this.chipNumber = chipNumber;
        return this;
    }

    @ApiModelProperty(value = "Number for the Clearing House Interbank Payments System")
    public String getChipNumber() {
        return chipNumber;
    }

    public void setChipNumber(String chipNumber) {
        this.chipNumber = chipNumber;
    }

    public BankingInternationalPayeeBankDetails country(String country) {
        this.country = country;
        return this;
    }

    @ApiModelProperty(required = true, value = "Country of the recipient institution. A valid [ISO 3166 Alpha-3](https://www.iso.org/iso-3166-country-codes.html) country code")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    public BankingInternationalPayeeBankDetails fedWireNumber(String fedWireNumber) {
        this.fedWireNumber = fedWireNumber;
        return this;
    }

    @ApiModelProperty(value = "Number for Fedwire payment (Federal Reserve Wire Network)")
    public String getFedWireNumber() {
        return fedWireNumber;
    }

    public void setFedWireNumber(String fedWireNumber) {
        this.fedWireNumber = fedWireNumber;
    }

    public BankingInternationalPayeeBankDetails legalEntityIdentifier(String legalEntityIdentifier) {
        this.legalEntityIdentifier = legalEntityIdentifier;
        return this;
    }

    @ApiModelProperty(value = "The legal entity identifier (LEI) for the beneficiary.  Aligns with [ISO 17442](https://www.iso.org/standard/59771.html)")
    public String getLegalEntityIdentifier() {
        return legalEntityIdentifier;
    }

    public void setLegalEntityIdentifier(String legalEntityIdentifier) {
        this.legalEntityIdentifier = legalEntityIdentifier;
    }

    public BankingInternationalPayeeBankDetails routingNumber(String routingNumber) {
        this.routingNumber = routingNumber;
        return this;
    }

    @ApiModelProperty(value = "International bank routing number")
    public String getRoutingNumber() {
        return routingNumber;
    }

    public void setRoutingNumber(String routingNumber) {
        this.routingNumber = routingNumber;
    }

    public BankingInternationalPayeeBankDetails sortCode(String sortCode) {
        this.sortCode = sortCode;
        return this;
    }

    @ApiModelProperty(value = "Sort code used for account identification in some jurisdictions")
    public String getSortCode() {
        return sortCode;
    }

    public void setSortCode(String sortCode) {
        this.sortCode = sortCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BankingInternationalPayeeBankDetails bankingInternationalPayeeBankDetails = (BankingInternationalPayeeBankDetails) o;
        return Objects.equals(this.id, bankingInternationalPayeeBankDetails.id) &&
            Objects.equals(this.accountNumber, bankingInternationalPayeeBankDetails.accountNumber) &&
            Objects.equals(this.bankAddress, bankingInternationalPayeeBankDetails.bankAddress) &&
            Objects.equals(this.beneficiaryBankBIC, bankingInternationalPayeeBankDetails.beneficiaryBankBIC) &&
            Objects.equals(this.chipNumber, bankingInternationalPayeeBankDetails.chipNumber) &&
            Objects.equals(this.country, bankingInternationalPayeeBankDetails.country) &&
            Objects.equals(this.fedWireNumber, bankingInternationalPayeeBankDetails.fedWireNumber) &&
            Objects.equals(this.legalEntityIdentifier, bankingInternationalPayeeBankDetails.legalEntityIdentifier) &&
            Objects.equals(this.routingNumber, bankingInternationalPayeeBankDetails.routingNumber) &&
            Objects.equals(this.sortCode, bankingInternationalPayeeBankDetails.sortCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            id,
            accountNumber,
            bankAddress,
            beneficiaryBankBIC,
            chipNumber,
            country,
            fedWireNumber,
            legalEntityIdentifier,
            routingNumber,
            sortCode);
    }

    @Override
    public String toString() {
        return "class BankingInternationalPayeeBankDetails {\n" +
            "   id: " + toIndentedString(id) + "\n" +
            "   accountNumber: " + toIndentedString(accountNumber) + "\n" +
            "   bankAddress: " + toIndentedString(bankAddress) + "\n" +
            "   beneficiaryBankBIC: " + toIndentedString(beneficiaryBankBIC) + "\n" + 
            "   chipNumber: " + toIndentedString(chipNumber) + "\n" + 
            "   country: " + toIndentedString(country) + "\n" + 
            "   fedWireNumber: " + toIndentedString(fedWireNumber) + "\n" + 
            "   legalEntityIdentifier: " + toIndentedString(legalEntityIdentifier) + "\n" + 
            "   routingNumber: " + toIndentedString(routingNumber) + "\n" + 
            "   sortCode: " + toIndentedString(sortCode) + "\n" + 
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

