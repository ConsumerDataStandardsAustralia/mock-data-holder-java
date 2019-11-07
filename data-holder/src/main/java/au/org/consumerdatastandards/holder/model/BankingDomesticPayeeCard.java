package au.org.consumerdatastandards.holder.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;

@ApiModel
public class BankingDomesticPayeeCard  {

    /**
     * Name of the account to pay to
     */
    private String cardNumber;

    public BankingDomesticPayeeCard cardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
        return this;
    }

    @ApiModelProperty(required = true, value = "Name of the account to pay to")
    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BankingDomesticPayeeCard bankingDomesticPayeeCard = (BankingDomesticPayeeCard) o;
        return Objects.equals(this.cardNumber, bankingDomesticPayeeCard.cardNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            cardNumber);
    }

    @Override
    public String toString() {
        return "class BankingDomesticPayeeCard {\n" +
            "   cardNumber: " + toIndentedString(cardNumber) + "\n" + 
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

