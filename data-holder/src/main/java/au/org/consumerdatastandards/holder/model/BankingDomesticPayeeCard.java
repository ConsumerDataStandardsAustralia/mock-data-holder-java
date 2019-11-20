package au.org.consumerdatastandards.holder.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@ApiModel
@Entity
public class BankingDomesticPayeeCard  {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @JsonIgnore
    private String id;

    /**
     * Name of the account to pay to
     */
    private String cardNumber;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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
        return Objects.equals(this.id, bankingDomesticPayeeCard.id) &&
            Objects.equals(this.cardNumber, bankingDomesticPayeeCard.cardNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            id,
            cardNumber);
    }

    @Override
    public String toString() {
        return "class BankingDomesticPayeeCard {\n" +
            "   id: " + toIndentedString(id) + "\n" +
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

