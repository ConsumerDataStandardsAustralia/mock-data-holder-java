package au.org.consumerdatastandards.holder.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Objects;
import java.time.OffsetDateTime;

@ApiModel
@Entity
@Table(name = "BankingTransaction")
public class BankingTransaction  {

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

    private Status status;

    private Type type;

    /**
     * Date and time at which assets become available to the account owner in case of a credit entry, or cease to be available to the account owner in case of a debit transaction entry
     */
    private OffsetDateTime valueDateTime;

    public BankingTransaction accountId(String accountId) {
        this.accountId = accountId;
        return this;
    }

    @ApiModelProperty(required = true, value = "ID of the account for which transactions are provided")
    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public BankingTransaction amount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    @ApiModelProperty(required = true, value = "The value of the transaction. Negative values mean money was outgoing from the account")
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BankingTransaction apcaNumber(String apcaNumber) {
        this.apcaNumber = apcaNumber;
        return this;
    }

    @ApiModelProperty(value = "6 Digit APCA number for the initiating institution")
    public String getApcaNumber() {
        return apcaNumber;
    }

    public void setApcaNumber(String apcaNumber) {
        this.apcaNumber = apcaNumber;
    }

    public BankingTransaction billerCode(String billerCode) {
        this.billerCode = billerCode;
        return this;
    }

    @ApiModelProperty(value = "BPAY Biller Code for the transaction (if available)")
    public String getBillerCode() {
        return billerCode;
    }

    public void setBillerCode(String billerCode) {
        this.billerCode = billerCode;
    }

    public BankingTransaction billerName(String billerName) {
        this.billerName = billerName;
        return this;
    }

    @ApiModelProperty(value = "Name of the BPAY biller for the transaction (if available)")
    public String getBillerName() {
        return billerName;
    }

    public void setBillerName(String billerName) {
        this.billerName = billerName;
    }

    public BankingTransaction crn(String crn) {
        this.crn = crn;
        return this;
    }

    @ApiModelProperty(value = "BPAY CRN for the transaction (if available).<br>Where the CRN contains sensitive information, it should be masked in line with how the Data Holder currently displays account identifiers in their existing online banking channels. If the contents of the CRN match the format of a Credit Card PAN they should be masked according to the rules applicable for MaskedPANString. If the contents are are otherwise sensitive, then it should be masked using the rules applicable for the MaskedAccountString common type.")
    public String getCrn() {
        return crn;
    }

    public void setCrn(String crn) {
        this.crn = crn;
    }

    public BankingTransaction currency(String currency) {
        this.currency = currency;
        return this;
    }

    @ApiModelProperty(value = "The currency for the transaction amount. AUD assumed if not present")
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BankingTransaction description(String description) {
        this.description = description;
        return this;
    }

    @ApiModelProperty(required = true, value = "The transaction description as applied by the financial institution")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BankingTransaction executionDateTime(OffsetDateTime executionDateTime) {
        this.executionDateTime = executionDateTime;
        return this;
    }

    @ApiModelProperty(value = "The time the transaction was executed by the originating customer, if available")
    public OffsetDateTime getExecutionDateTime() {
        return executionDateTime;
    }

    public void setExecutionDateTime(OffsetDateTime executionDateTime) {
        this.executionDateTime = executionDateTime;
    }

    public BankingTransaction isDetailAvailable(Boolean isDetailAvailable) {
        this.isDetailAvailable = isDetailAvailable;
        return this;
    }

    @ApiModelProperty(required = true, value = "True if extended information is available using the transaction detail end point. False if extended data is not available")
    public Boolean getIsDetailAvailable() {
        return isDetailAvailable;
    }

    public void setIsDetailAvailable(Boolean isDetailAvailable) {
        this.isDetailAvailable = isDetailAvailable;
    }

    public BankingTransaction merchantCategoryCode(String merchantCategoryCode) {
        this.merchantCategoryCode = merchantCategoryCode;
        return this;
    }

    @ApiModelProperty(value = "The merchant category code (or MCC) for an outgoing payment to a merchant")
    public String getMerchantCategoryCode() {
        return merchantCategoryCode;
    }

    public void setMerchantCategoryCode(String merchantCategoryCode) {
        this.merchantCategoryCode = merchantCategoryCode;
    }
    public BankingTransaction merchantName(String merchantName) {
        this.merchantName = merchantName;
        return this;
    }

    @ApiModelProperty(value = "Name of the merchant for an outgoing payment to a merchant")
    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public BankingTransaction postingDateTime(OffsetDateTime postingDateTime) {
        this.postingDateTime = postingDateTime;
        return this;
    }

    @ApiModelProperty(value = "The time the transaction was posted. This field is Mandatory if the transaction has status POSTED.  This is the time that appears on a standard statement")
    public OffsetDateTime getPostingDateTime() {
        return postingDateTime;
    }

    public void setPostingDateTime(OffsetDateTime postingDateTime) {
        this.postingDateTime = postingDateTime;
    }
    public BankingTransaction reference(String reference) {
        this.reference = reference;
        return this;
    }

    @ApiModelProperty(required = true, value = "The reference for the transaction provided by the originating institution. Empty string if no data provided")
    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public BankingTransaction status(Status status) {
        this.status = status;
        return this;
    }

    @ApiModelProperty(required = true)
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public BankingTransaction transactionId(String transactionId) {
        this.transactionId = transactionId;
        return this;
    }

    @ApiModelProperty(value = "A unique ID of the transaction adhering to the standards for ID permanence.  This is mandatory (through hashing if necessary) unless there are specific and justifiable technical reasons why a transaction cannot be uniquely identified for a particular account type")
    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public BankingTransaction type(Type type) {
        this.type = type;
        return this;
    }

    @ApiModelProperty(required = true)
    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
    public BankingTransaction valueDateTime(OffsetDateTime valueDateTime) {
        this.valueDateTime = valueDateTime;
        return this;
    }

    @ApiModelProperty(value = "Date and time at which assets become available to the account owner in case of a credit entry, or cease to be available to the account owner in case of a debit transaction entry")
    public OffsetDateTime getValueDateTime() {
        return valueDateTime;
    }

    public void setValueDateTime(OffsetDateTime valueDateTime) {
        this.valueDateTime = valueDateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BankingTransaction bankingTransaction = (BankingTransaction) o;
        return Objects.equals(this.accountId, bankingTransaction.accountId) &&
            Objects.equals(this.amount, bankingTransaction.amount) &&
            Objects.equals(this.apcaNumber, bankingTransaction.apcaNumber) &&
            Objects.equals(this.billerCode, bankingTransaction.billerCode) &&
            Objects.equals(this.billerName, bankingTransaction.billerName) &&
            Objects.equals(this.crn, bankingTransaction.crn) &&
            Objects.equals(this.currency, bankingTransaction.currency) &&
            Objects.equals(this.description, bankingTransaction.description) &&
            Objects.equals(this.executionDateTime, bankingTransaction.executionDateTime) &&
            Objects.equals(this.isDetailAvailable, bankingTransaction.isDetailAvailable) &&
            Objects.equals(this.merchantCategoryCode, bankingTransaction.merchantCategoryCode) &&
            Objects.equals(this.merchantName, bankingTransaction.merchantName) &&
            Objects.equals(this.postingDateTime, bankingTransaction.postingDateTime) &&
            Objects.equals(this.reference, bankingTransaction.reference) &&
            Objects.equals(this.status, bankingTransaction.status) &&
            Objects.equals(this.transactionId, bankingTransaction.transactionId) &&
            Objects.equals(this.type, bankingTransaction.type) &&
            Objects.equals(this.valueDateTime, bankingTransaction.valueDateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            accountId,
            amount,
            apcaNumber,
            billerCode,
            billerName,
            crn,
            currency,
            description,
            executionDateTime,
            isDetailAvailable,
            merchantCategoryCode,
            merchantName,
            postingDateTime,
            reference,
            status,
            transactionId,
            type,
            valueDateTime);
    }

    @Override
    public String toString() {
        return "class BankingTransaction {\n" +
            "   accountId: " + toIndentedString(accountId) + "\n" + 
            "   amount: " + toIndentedString(amount) + "\n" + 
            "   apcaNumber: " + toIndentedString(apcaNumber) + "\n" + 
            "   billerCode: " + toIndentedString(billerCode) + "\n" + 
            "   billerName: " + toIndentedString(billerName) + "\n" + 
            "   crn: " + toIndentedString(crn) + "\n" + 
            "   currency: " + toIndentedString(currency) + "\n" + 
            "   description: " + toIndentedString(description) + "\n" + 
            "   executionDateTime: " + toIndentedString(executionDateTime) + "\n" + 
            "   isDetailAvailable: " + toIndentedString(isDetailAvailable) + "\n" + 
            "   merchantCategoryCode: " + toIndentedString(merchantCategoryCode) + "\n" + 
            "   merchantName: " + toIndentedString(merchantName) + "\n" + 
            "   postingDateTime: " + toIndentedString(postingDateTime) + "\n" + 
            "   reference: " + toIndentedString(reference) + "\n" + 
            "   status: " + toIndentedString(status) + "\n" + 
            "   transactionId: " + toIndentedString(transactionId) + "\n" + 
            "   type: " + toIndentedString(type) + "\n" + 
            "   valueDateTime: " + toIndentedString(valueDateTime) + "\n" + 
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

    public enum Type {
        DIRECT_DEBIT,
        FEE,
        INTEREST_CHARGED,
        INTEREST_PAID,
        PAYMENT,
        TRANSFER_INCOMING,
        TRANSFER_OUTGOING,
        OTHER
    }

    public enum Status {
        PENDING,
        POSTED
    }
}

