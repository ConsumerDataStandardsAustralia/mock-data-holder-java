package au.org.consumerdatastandards.holder.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;
import java.util.Objects;

@ApiModel
public class BankingTransactionDetail extends BankingTransaction {

    /**
     * ID of the account for which transactions are provided
     */
    private String accountId;

    /**
     * The value of the transaction. Negative values mean money was outgoing from the account
     */
    private String amount;

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
     * BPAY CRN for the transaction (if available)
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
    private OffsetDateTime postingDateTime;

    /**
     * The reference for the transaction provided by the originating institution. Empty string if no data provided
     */
    private String reference;

    /**
     * Get status
     */
    private BankingTransaction.Status status;

    /**
     * A unique ID of the transaction adhering to the standards for ID permanence.  This is mandatory (through hashing if necessary) unless there are specific and justifiable technical reasons why a transaction cannot be uniquely identified for a particular account type
     */
    private String transactionId;

    /**
     * Get type
     */
    private BankingTransaction.Type type;

    /**
     * Date and time at which assets become available to the account owner in case of a credit entry, or cease to be available to the account owner in case of a debit transaction entry
     */
    private OffsetDateTime valueDateTime;

    /**
     * Get extendedData
     */
    private BankingTransactionDetailExtendedData extendedData;

    public BankingTransactionDetail accountId(String accountId) {
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
    public BankingTransactionDetail amount(String amount) {
        this.amount = amount;
        return this;
    }

    @ApiModelProperty(required = true, value = "The value of the transaction. Negative values mean money was outgoing from the account")
    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
    public BankingTransactionDetail apcaNumber(String apcaNumber) {
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
    public BankingTransactionDetail billerCode(String billerCode) {
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
    public BankingTransactionDetail billerName(String billerName) {
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
    public BankingTransactionDetail crn(String crn) {
        this.crn = crn;
        return this;
    }

    @ApiModelProperty(value = "BPAY CRN for the transaction (if available)")
    public String getCrn() {
        return crn;
    }

    public void setCrn(String crn) {
        this.crn = crn;
    }
    public BankingTransactionDetail currency(String currency) {
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
    public BankingTransactionDetail description(String description) {
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
    public BankingTransactionDetail executionDateTime(OffsetDateTime executionDateTime) {
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
    public BankingTransactionDetail isDetailAvailable(Boolean isDetailAvailable) {
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
    public BankingTransactionDetail merchantCategoryCode(String merchantCategoryCode) {
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
    public BankingTransactionDetail merchantName(String merchantName) {
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
    public BankingTransactionDetail postingDateTime(OffsetDateTime postingDateTime) {
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
    public BankingTransactionDetail reference(String reference) {
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
    public BankingTransactionDetail status(BankingTransaction.Status status) {
        this.status = status;
        return this;
    }

    @ApiModelProperty(required = true)
    public BankingTransaction.Status getStatus() {
        return status;
    }

    public void setStatus(BankingTransaction.Status status) {
        this.status = status;
    }
    public BankingTransactionDetail transactionId(String transactionId) {
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
    public BankingTransactionDetail type(BankingTransaction.Type type) {
        this.type = type;
        return this;
    }

    @ApiModelProperty(required = true)
    public BankingTransaction.Type getType() {
        return type;
    }

    public void setType(BankingTransaction.Type type) {
        this.type = type;
    }
    public BankingTransactionDetail valueDateTime(OffsetDateTime valueDateTime) {
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

