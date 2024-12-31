package au.org.consumerdatastandards.holder.model.banking;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.OffsetDateTime;
import java.util.Objects;

@ApiModel
@Entity
@MappedSuperclass
public class BankingTransactionDetail {

    /**
     * A unique ID of the transaction adhering to the standards for ID permanence. This is mandatory (through hashing if necessary) unless there are specific and justifiable technical reasons why a transaction cannot be uniquely identified for a particular account type. It is mandatory if _isDetailAvailable_ is set to `true`.
     */
    @Id
    private String transactionId;

    /**
     * ID of the account for which transactions are provided.
     */
    private String accountId;

    /**
     * The value of the transaction. Negative values mean money was outgoing from the account.
     */
    private String amount;

    /**
     * 6 Digit APCA number for the initiating institution
     */
    private String apcaNumber;

    /**
     * BPAY Biller Code for the transaction (if available).
     */
    private String billerCode;

    /**
     * Name of the BPAY biller for the transaction (if available).
     */
    private String billerName;

    /**
     * BPAY CRN for the transaction (if available).<br>Where the CRN contains sensitive information, it should be masked in line with how the Data Holder currently displays account identifiers in their existing online banking channels. If the contents of the CRN match the format of a Credit Card PAN they should be masked according to the rules applicable for [MaskedPANString](#common-field-types). If the contents are otherwise sensitive, then it should be masked using the rules applicable for the [MaskedAccountString](#common-field-types) common type.
     */
    private String crn;

    /**
     * The currency for the transaction amount. `AUD` assumed if not present.
     */
    private String currency;

    /**
     * The transaction description as applied by the financial institution.
     */
    private String description;

    /**
     * The time the transaction was executed by the originating customer, if available.
     */
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private OffsetDateTime executionDateTime;

    /**
     * `true` if extended information is available using the transaction detail endpoint. `false` if extended data is not available.
     */
    private Boolean isDetailAvailable;

    /**
     * The merchant category code (or MCC) for an outgoing payment to a merchant.
     */
    private String merchantCategoryCode;

    /**
     * Name of the merchant for an outgoing payment to a merchant.
     */
    private String merchantName;

    /**
     * The time the transaction was posted. This field is Mandatory if the transaction has status `POSTED`. This is the time that appears on a standard statement.
     */
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private OffsetDateTime postingDateTime;

    /**
     * The reference for the transaction provided by the originating institution. Empty string if no data provided.
     */
    private String reference;

    private BankingTransaction.Status status;

    private BankingTransaction.Type type;

    /**
     * Date and time at which assets become available to the account owner in case of a credit entry, or cease to be available to the account owner in case of a debit transaction entry.
     */
    private OffsetDateTime valueDateTime;

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

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
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

    public BankingTransactionDetail amount(String amount) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BankingTransactionDetail that = (BankingTransactionDetail) o;
        return status == that.status && type == that.type &&
                Objects.equals(transactionId, that.transactionId) && Objects.equals(accountId, that.accountId) &&
                Objects.equals(amount, that.amount) && Objects.equals(apcaNumber, that.apcaNumber) &&
                Objects.equals(billerCode, that.billerCode) && Objects.equals(billerName, that.billerName) &&
                Objects.equals(crn, that.crn) && Objects.equals(currency, that.currency) &&
                Objects.equals(description, that.description) &&
                Objects.equals(executionDateTime, that.executionDateTime) &&
                Objects.equals(isDetailAvailable, that.isDetailAvailable) &&
                Objects.equals(merchantCategoryCode, that.merchantCategoryCode) &&
                Objects.equals(merchantName, that.merchantName) &&
                Objects.equals(postingDateTime, that.postingDateTime) &&
                Objects.equals(reference, that.reference) &&
                Objects.equals(valueDateTime, that.valueDateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionId, accountId, amount, apcaNumber, billerCode, billerName, crn, currency,
                description, executionDateTime, isDetailAvailable, merchantCategoryCode, merchantName, postingDateTime,
                reference, status, type, valueDateTime);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(getClass().getSimpleName()).append("{");
        stringProperties(sb);
        return sb.append("\n}").toString();
    }

    protected void stringProperties(StringBuilder sb) {
        sb
                .append("\n   accountId: ").append(toIndentedString(accountId))
                .append("\n   amount: ").append(toIndentedString(amount))
                .append("\n   apcaNumber: ").append(toIndentedString(apcaNumber))
                .append("\n   billerCode: ").append(toIndentedString(billerCode))
                .append("\n   billerName: ").append(toIndentedString(billerName))
                .append("\n   crn: ").append(toIndentedString(crn))
                .append("\n   currency: ").append(toIndentedString(currency))
                .append("\n   description: ").append(toIndentedString(description))
                .append("\n   executionDateTime: ").append(toIndentedString(executionDateTime))
                .append("\n   isDetailAvailable: ").append(toIndentedString(isDetailAvailable))
                .append("\n   merchantCategoryCode: ").append(toIndentedString(merchantCategoryCode))
                .append("\n   merchantName: ").append(toIndentedString(merchantName))
                .append("\n   postingDateTime: ").append(toIndentedString(postingDateTime))
                .append("\n   reference: ").append(toIndentedString(reference))
                .append("\n   status: ").append(toIndentedString(status))
                .append("\n   transactionId: ").append(toIndentedString(transactionId))
                .append("\n   type: ").append(toIndentedString(type))
                .append("\n   valueDateTime: ").append(toIndentedString(valueDateTime));
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    static String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}