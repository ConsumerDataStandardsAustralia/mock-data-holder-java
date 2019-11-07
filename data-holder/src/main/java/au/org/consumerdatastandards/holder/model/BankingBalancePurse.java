package au.org.consumerdatastandards.holder.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;

@ApiModel
public class BankingBalancePurse  {

    /**
     * The balance available for this additional currency purse
     */
    private String amount;

    /**
     * The currency for the purse
     */
    private String currency;

    public BankingBalancePurse amount(String amount) {
        this.amount = amount;
        return this;
    }

    @ApiModelProperty(required = true, value = "The balance available for this additional currency purse")
    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
    public BankingBalancePurse currency(String currency) {
        this.currency = currency;
        return this;
    }

    @ApiModelProperty(value = "The currency for the purse")
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BankingBalancePurse bankingBalancePurse = (BankingBalancePurse) o;
        return Objects.equals(this.amount, bankingBalancePurse.amount) &&
            Objects.equals(this.currency, bankingBalancePurse.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            amount,
            currency);
    }

    @Override
    public String toString() {
        return "class BankingBalancePurse {\n" +
            "   amount: " + toIndentedString(amount) + "\n" + 
            "   currency: " + toIndentedString(currency) + "\n" + 
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

