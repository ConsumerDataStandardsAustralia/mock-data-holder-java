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

@ApiModel
@Entity
public class BankingDomesticPayee  {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @JsonIgnore
    private String id;

    @ManyToOne
    private BankingDomesticPayeeAccount account;

    @ManyToOne
    private BankingDomesticPayeeCard card;

    @ManyToOne
    private BankingDomesticPayeePayId payId;

    private PayeeAccountUType payeeAccountUType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BankingDomesticPayee account(BankingDomesticPayeeAccount account) {
        this.account = account;
        return this;
    }

    @ApiModelProperty
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

    @ApiModelProperty
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

    @ApiModelProperty
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

    @ApiModelProperty(required = true)
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
        return Objects.equals(this.id, bankingDomesticPayee.id) &&
            Objects.equals(this.account, bankingDomesticPayee.account) &&
            Objects.equals(this.card, bankingDomesticPayee.card) &&
            Objects.equals(this.payId, bankingDomesticPayee.payId) &&
            Objects.equals(this.payeeAccountUType, bankingDomesticPayee.payeeAccountUType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            id,
            account,
            card,
            payId,
            payeeAccountUType);
    }

    @Override
    public String toString() {
        return "class BankingDomesticPayee {\n" +
            "   id: " + toIndentedString(id) + "\n" +
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

    public enum PayeeAccountUType {
        account,
        card,
        payId
    }
}

