package au.org.consumerdatastandards.holder.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Objects;

@ApiModel
@Entity
@Table(name = "BankingTransaction")
public class BankingTransactionDetail {

    /**
     * A unique ID of the transaction adhering to the standards for ID permanence.  This is mandatory (through hashing if necessary) unless there are specific and justifiable technical reasons why a transaction cannot be uniquely identified for a particular account type
     */
    @Id
    private String transactionId;

    /**
     * ID of the account for which transactions are provided
     */
    private String accountId;

    /**
     * The value of the transaction. Negative values mean money was outgoing from the account
     */
    private BigDecimal amount;

    /**
     * 6 Digit APCA number for the initiating institution
     */
    private String apcaNumber;

    /**
     * BPAY Biller Code for the transaction (if available)
     */
    private String billerCode;

    /**
     * Name of the BPAY biller for the transaction (if available)
     */
    private String billerName;

    /**
     * BPAY CRN for the transaction (if available).<br>Where the CRN contains sensitive information, it should be masked in line with how the Data Holder currently displays account identifiers in their existing online banking channels. If the contents of the CRN match the format of a Credit Card PAN they should be masked according to the rules applicable for MaskedPANString. If the contents are are otherwise sensitive, then it should be masked using the rules applicable for the MaskedAccountString common type.
     */
    private String crn;

    /**
     * The currency for the transaction amount. AUD assumed if not present
     */
    private String currency;

    /**
     * The transaction description as applied by the financial institution
     */
    private String description;

    /**
     * The time the transaction was executed by the originating customer, if available
     */
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private OffsetDateTime executionDateTime;

    /**
     * True if extended information is available using the transaction detail end point. False if extended data is not available
     */
    private Boolean isDetailAvailable;

    /**
     * The merchant category code (or MCC) for an outgoing payment to a merchant
     */
    private String merchantCategoryCode;

    /**
     * Name of the merchant for an outgoing payment to a merchant
     */
    private String merchantName;

    /**
     * The time the transaction was posted. This field is Mandatory if the transaction has status POSTED.  This is the time that appears on a standard statement
     */
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private OffsetDateTime postingDateTime;

    /**
     * The reference for the transaction provided by the originating institution. Empty string if no data provided
     */
    private String reference;

    private BankingTransaction.Status status;

    private BankingTransaction.Type type;

    /**
     * Date and time at which assets become available to the account owner in case of a credit entry, or cease to be available to the account owner in case of a debit transaction entry
     */
    private OffsetDateTime valueDateTime;


    @Embedded
    private BankingTransactionDetailExtendedData extendedData;

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getApcaNumber() {
        return apcaNumber;
    }

    public void setApcaNumber(String apcaNumber) {
        this.apcaNumber = apcaNumber;
    }

    public String getBillerCode() {
        return billerCode;
    }

    public void setBillerCode(String billerCode) {
        this.billerCode = billerCode;
    }

    public String getBillerName() {
        return billerName;
    }

    public void setBillerName(String billerName) {
        this.billerName = billerName;
    }

    public String getCrn() {
        return crn;
    }

    public void setCrn(String crn) {
        this.crn = crn;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public OffsetDateTime getExecutionDateTime() {
        return executionDateTime;
    }

    public void setExecutionDateTime(OffsetDateTime executionDateTime) {
        this.executionDateTime = executionDateTime;
    }

    public Boolean getIsDetailAvailable() {
        return isDetailAvailable;
    }

    public void setIsDetailAvailable(Boolean detailAvailable) {
        isDetailAvailable = detailAvailable;
    }

    public String getMerchantCategoryCode() {
        return merchantCategoryCode;
    }

    public void setMerchantCategoryCode(String merchantCategoryCode) {
        this.merchantCategoryCode = merchantCategoryCode;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public OffsetDateTime getPostingDateTime() {
        return postingDateTime;
    }

    public void setPostingDateTime(OffsetDateTime postingDateTime) {
        this.postingDateTime = postingDateTime;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public BankingTransaction.Status getStatus() {
        return status;
    }

    public void setStatus(BankingTransaction.Status status) {
        this.status = status;
    }

    public BankingTransaction.Type getType() {
        return type;
    }

    public void setType(BankingTransaction.Type type) {
        this.type = type;
    }

    public OffsetDateTime getValueDateTime() {
        return valueDateTime;
    }

    public void setValueDateTime(OffsetDateTime valueDateTime) {
        this.valueDateTime = valueDateTime;
    }

    public BankingTransactionDetail accountId(String accountId) {
        this.accountId = accountId;
        return this;
    }

    public BankingTransactionDetail amount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    public BankingTransactionDetail apcaNumber(String apcaNumber) {
        this.apcaNumber = apcaNumber;
        return this;
    }

    public BankingTransactionDetail billerCode(String billerCode) {
        this.billerCode = billerCode;
        return this;
    }

    public BankingTransactionDetail billerName(String billerName) {
        this.billerName = billerName;
        return this;
    }

    public BankingTransactionDetail crn(String crn) {
        this.crn = crn;
        return this;
    }

    public BankingTransactionDetail currency(String currency) {
        this.currency = currency;
        return this;
    }

    public BankingTransactionDetail description(String description) {
        this.description = description;
        return this;
    }

    public BankingTransactionDetail executionDateTime(OffsetDateTime executionDateTime) {
        this.executionDateTime = executionDateTime;
        return this;
    }

    public BankingTransactionDetail isDetailAvailable(Boolean isDetailAvailable) {
        this.isDetailAvailable = isDetailAvailable;
        return this;
    }

    public BankingTransactionDetail merchantCategoryCode(String merchantCategoryCode) {
        this.merchantCategoryCode = merchantCategoryCode;
        return this;
    }

    public BankingTransactionDetail merchantName(String merchantName) {
        this.merchantName = merchantName;
        return this;
    }

    public BankingTransactionDetail postingDateTime(OffsetDateTime postingDateTime) {
        this.postingDateTime = postingDateTime;
        return this;
    }

    public BankingTransactionDetail reference(String reference) {
        this.reference = reference;
        return this;
    }

    public BankingTransactionDetail status(BankingTransaction.Status status) {
        this.status = status;
        return this;
    }

    public BankingTransactionDetail transactionId(String transactionId) {
        this.transactionId = transactionId;
        return this;
    }

    public BankingTransactionDetail type(BankingTransaction.Type type) {
        this.type = type;
        return this;
    }

    public BankingTransactionDetail valueDateTime(OffsetDateTime valueDateTime) {
        this.valueDateTime = valueDateTime;
        return this;
    }

    public BankingTransactionDetail extendedData(BankingTransactionDetailExtendedData extendedData) {
        this.extendedData = extendedData;
        return this;
    }

    @ApiModelProperty(required = true)
    public BankingTransactionDetailExtendedData getExtendedData() {
        return extendedData;
    }

    public void setExtendedData(BankingTransactionDetailExtendedData extendedData) {
        this.extendedData = extendedData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BankingTransactionDetail bankingTransactionDetail = (BankingTransactionDetail) o;
        return Objects.equals(this.extendedData, bankingTransactionDetail.extendedData) &&
            super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            extendedData,
            super.hashCode());
    }

    @Override
    public String toString() {
        return "class BankingTransactionDetail {\n" +
            "   accountId: " + toIndentedString(getAccountId()) + "\n" + 
            "   amount: " + toIndentedString(getAmount()) + "\n" + 
            "   apcaNumber: " + toIndentedString(getApcaNumber()) + "\n" + 
            "   billerCode: " + toIndentedString(getBillerCode()) + "\n" + 
            "   billerName: " + toIndentedString(getBillerName()) + "\n" + 
            "   crn: " + toIndentedString(getCrn()) + "\n" + 
            "   currency: " + toIndentedString(getCurrency()) + "\n" + 
            "   description: " + toIndentedString(getDescription()) + "\n" + 
            "   executionDateTime: " + toIndentedString(getExecutionDateTime()) + "\n" + 
            "   isDetailAvailable: " + toIndentedString(getIsDetailAvailable()) + "\n" + 
            "   merchantCategoryCode: " + toIndentedString(getMerchantCategoryCode()) + "\n" + 
            "   merchantName: " + toIndentedString(getMerchantName()) + "\n" + 
            "   postingDateTime: " + toIndentedString(getPostingDateTime()) + "\n" + 
            "   reference: " + toIndentedString(getReference()) + "\n" + 
            "   status: " + toIndentedString(getStatus()) + "\n" + 
            "   transactionId: " + toIndentedString(getTransactionId()) + "\n" + 
            "   type: " + toIndentedString(getType()) + "\n" + 
            "   valueDateTime: " + toIndentedString(getValueDateTime()) + "\n" + 
            "   extendedData: " + toIndentedString(extendedData) + "\n" + 
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