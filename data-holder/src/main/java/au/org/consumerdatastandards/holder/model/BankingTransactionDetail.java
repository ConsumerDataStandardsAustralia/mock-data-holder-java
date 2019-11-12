package au.org.consumerdatastandards.holder.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.OffsetDateTime;
import java.util.Objects;

@ApiModel
@Entity
@Table(name = "BankingTransaction")
public class BankingTransactionDetail extends BankingTransaction {

    /**
     * Get extendedData
     */
    @Embedded
    private BankingTransactionDetailExtendedData extendedData;

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
}