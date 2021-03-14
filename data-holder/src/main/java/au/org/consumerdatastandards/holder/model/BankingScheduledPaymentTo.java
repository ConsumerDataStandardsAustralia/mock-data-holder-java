package au.org.consumerdatastandards.holder.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Objects;

@ApiModel(description = "Object containing details of the destination of the payment. Used to specify a variety of payment destination types")
@Entity
public class BankingScheduledPaymentTo  {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @JsonIgnore
    private String id;

    /**
     * Present if toUType is set to accountId. Indicates that the payment is to another account that is accessible under the current consent
     */
    private String accountId;

    @ManyToOne
    private BankingBillerPayee biller;

    @ManyToOne
    private BankingDomesticPayee domestic;

    @ManyToOne
    private BankingInternationalPayee international;

    /**
     * Present if toUType is set to payeeId. Indicates that the payment is to registered payee that can be accessed using the payee end point. If the Bank Payees scope has not been consented to then a payeeId should not be provided and the full payee details should be provided instead
     */
    private String payeeId;

    private ToUType toUType;

    /**
     * The short display name of the payee as provided by the customer unless toUType is set to payeeId. Where a customer has not provided a nickname, a display name derived by the bank for payee should be provided that is consistent with existing digital banking channels
     */
    private String nickname;

    /**
     * The reference for the transaction, if applicable, that will be provided by the originating institution for the specific payment. If not empty, it overrides the value provided at the BankingScheduledPayment level.
     */
    private String payeeReference;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BankingScheduledPaymentTo accountId(String accountId) {
        this.accountId = accountId;
        return this;
    }

    @ApiModelProperty(value = "Present if toUType is set to accountId. Indicates that the payment is to another account that is accessible under the current consent")
    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public BankingScheduledPaymentTo biller(BankingBillerPayee biller) {
        this.biller = biller;
        return this;
    }

    @ApiModelProperty
    public BankingBillerPayee getBiller() {
        return biller;
    }

    public void setBiller(BankingBillerPayee biller) {
        this.biller = biller;
    }

    public BankingScheduledPaymentTo domestic(BankingDomesticPayee domestic) {
        this.domestic = domestic;
        return this;
    }

    @ApiModelProperty
    public BankingDomesticPayee getDomestic() {
        return domestic;
    }

    public void setDomestic(BankingDomesticPayee domestic) {
        this.domestic = domestic;
    }

    public BankingScheduledPaymentTo international(BankingInternationalPayee international) {
        this.international = international;
        return this;
    }

    @ApiModelProperty
    public BankingInternationalPayee getInternational() {
        return international;
    }

    public void setInternational(BankingInternationalPayee international) {
        this.international = international;
    }

    public BankingScheduledPaymentTo payeeId(String payeeId) {
        this.payeeId = payeeId;
        return this;
    }

    @ApiModelProperty(value = "Present if toUType is set to payeeId. Indicates that the payment is to registered payee that can be accessed using the payee end point. If the Bank Payees scope has not been consented to then a payeeId should not be provided and the full payee details should be provided instead")
    public String getPayeeId() {
        return payeeId;
    }

    public void setPayeeId(String payeeId) {
        this.payeeId = payeeId;
    }
    public BankingScheduledPaymentTo toUType(ToUType toUType) {
        this.toUType = toUType;
        return this;
    }

    @ApiModelProperty(value = "The short display name of the payee as provided by the customer unless toUType is set to payeeId. Where a customer has not provided a nickname, a display name derived by the bank for payee should be provided that is consistent with existing digital banking channels")
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @ApiModelProperty(required = true, value = "The reference for the transaction, if applicable, that will be provided by the originating institution for the specific payment. If not empty, it overrides the value provided at the BankingScheduledPayment level.")
    public String getPayeeReference() {
        return payeeReference;
    }

    public void setPayeeReference(String payeeReference) {
        this.payeeReference = payeeReference;
    }

    @ApiModelProperty(required = true)
    public ToUType getToUType() {
        return toUType;
    }

    public void setToUType(ToUType toUType) {
        this.toUType = toUType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BankingScheduledPaymentTo bankingScheduledPaymentTo = (BankingScheduledPaymentTo) o;
        return Objects.equals(this.id, bankingScheduledPaymentTo.id) &&
            Objects.equals(this.accountId, bankingScheduledPaymentTo.accountId) &&
            Objects.equals(this.biller, bankingScheduledPaymentTo.biller) &&
            Objects.equals(this.domestic, bankingScheduledPaymentTo.domestic) &&
            Objects.equals(this.international, bankingScheduledPaymentTo.international) &&
            Objects.equals(this.payeeId, bankingScheduledPaymentTo.payeeId) &&
            Objects.equals(this.nickname, bankingScheduledPaymentTo.nickname) &&
            Objects.equals(this.payeeReference, bankingScheduledPaymentTo.payeeReference) &&
            Objects.equals(this.toUType, bankingScheduledPaymentTo.toUType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            id,
            accountId,
            biller,
            domestic,
            international,
            payeeId,
            nickname,
            payeeReference,
            toUType);
    }

    @Override
    public String toString() {
        return "class BankingScheduledPaymentTo {\n" +
            "   id: " + toIndentedString(id) + "\n" +
            "   accountId: " + toIndentedString(accountId) + "\n" +
            "   biller: " + toIndentedString(biller) + "\n" +
            "   domestic: " + toIndentedString(domestic) + "\n" + 
            "   international: " + toIndentedString(international) + "\n" + 
            "   payeeId: " + toIndentedString(payeeId) + "\n" +
            "   nickname: " + toIndentedString(nickname) + "\n" +
            "   payeeReference: " + toIndentedString(payeeReference) + "\n" +
            "   toUType: " + toIndentedString(toUType) + "\n" +
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

    public enum ToUType {
        accountId,
        biller,
        domestic,
        international,
        payeeId
    }
}

