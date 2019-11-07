package au.org.consumerdatastandards.holder.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;

@ApiModel
public class BankingDomesticPayee  {

    /**
     * Get account
     */
    private BankingDomesticPayeeAccount account;

    /**
     * Get card
     */
    private BankingDomesticPayeeCard card;

    /**
     * Get payId
     */
    private BankingDomesticPayeePayId payId;

    public enum PayeeAccountUType {
        ACCOUNT,
        CARD,
        PAYID
    }
    /**
     * Get payeeAccountUType
     */
    private PayeeAccountUType payeeAccountUType;

    public BankingDomesticPayee account(BankingDomesticPayeeAccount account) {
        this.account = account;
        return this;
    }

    @ApiModelProperty(value = "")
    public BankingDomesticPayeeAccount getAccount() {
        return account;
    }

    public void setAccount(BankingDomesticPayeeAccount account) {
        this.account = account;
    }
    public BankingDomesticPayee card(BankingDomesticPayeeCard card) {
        this.card = card;
        return this;
    }

    @ApiModelProperty(value = "")
    public BankingDomesticPayeeCard getCard() {
        return card;
    }

    public void setCard(BankingDomesticPayeeCard card) {
        this.card = card;
    }
    public BankingDomesticPayee payId(BankingDomesticPayeePayId payId) {
        this.payId = payId;
        return this;
    }

    @ApiModelProperty(value = "")
    public BankingDomesticPayeePayId getPayId() {
        return payId;
    }

    public void setPayId(BankingDomesticPayeePayId payId) {
        this.payId = payId;
    }
    public BankingDomesticPayee payeeAccountUType(PayeeAccountUType payeeAccountUType) {
        this.payeeAccountUType = payeeAccountUType;
        return this;
    }

    @ApiModelProperty(required = true, value = "")
    public PayeeAccountUType getPayeeAccountUType() {
        return payeeAccountUType;
    }

    public void setPayeeAccountUType(PayeeAccountUType payeeAccountUType) {
        this.payeeAccountUType = payeeAccountUType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BankingDomesticPayee bankingDomesticPayee = (BankingDomesticPayee) o;
        return Objects.equals(this.account, bankingDomesticPayee.account) &&
            Objects.equals(this.card, bankingDomesticPayee.card) &&
            Objects.equals(this.payId, bankingDomesticPayee.payId) &&
            Objects.equals(this.payeeAccountUType, bankingDomesticPayee.payeeAccountUType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            account,
            card,
            payId,
            payeeAccountUType);
    }

    @Override
    public String toString() {
        return "class BankingDomesticPayee {\n" +
            "   account: " + toIndentedString(account) + "\n" + 
            "   card: " + toIndentedString(card) + "\n" + 
            "   payId: " + toIndentedString(payId) + "\n" + 
            "   payeeAccountUType: " + toIndentedString(payeeAccountUType) + "\n" + 
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

