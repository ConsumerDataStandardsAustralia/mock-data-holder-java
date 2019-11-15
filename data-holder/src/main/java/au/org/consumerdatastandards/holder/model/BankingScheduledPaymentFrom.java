package au.org.consumerdatastandards.holder.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.util.Objects;

@ApiModel(description = "Object containing details of the source of the payment. Currently only specifies an account ID but provided as an object to facilitate future extensibility and consistency with the to object")
@Embeddable
public class BankingScheduledPaymentFrom  {

    /**
     * ID of the account that is the source of funds for the payment
     */
    private String accountId;

    @ManyToOne
    @JsonIgnore
    private BankingAccount bankingAccount;

    public BankingScheduledPaymentFrom accountId(String accountId) {
        this.accountId = accountId;
        return this;
    }

    @ApiModelProperty(required = true, value = "ID of the account that is the source of funds for the payment")
    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public BankingAccount getBankingAccount() {
        return bankingAccount;
    }

    public void setBankingAccount(BankingAccount bankingAccount) {
        this.bankingAccount = bankingAccount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BankingScheduledPaymentFrom bankingScheduledPaymentFrom = (BankingScheduledPaymentFrom) o;
        return Objects.equals(this.accountId, bankingScheduledPaymentFrom.accountId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            accountId);
    }

    @Override
    public String toString() {
        return "class BankingScheduledPaymentFrom {\n" +
            "   accountId: " + toIndentedString(accountId) + "\n" + 
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

