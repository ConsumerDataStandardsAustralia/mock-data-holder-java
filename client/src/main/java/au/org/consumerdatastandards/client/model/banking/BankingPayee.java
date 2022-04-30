/*
 * Consumer Data Standards
 * Sample client library to Demonstrate the Consumer Data Right APIs
 *
 * NOTE: This class is auto generated by the codegen artefact
 * https://github.com/ConsumerDataStandardsAustralia/java-artefacts/codegen
 */
package au.org.consumerdatastandards.client.model.banking;

import java.time.LocalDate;
import java.util.Objects;

public class BankingPayee {

    public enum Type {
        BILLER,
        DIGITAL_WALLET,
        DOMESTIC,
        INTERNATIONAL
    }

    private String payeeId;

    private String nickname;

    private String description;

    private Type type;

    private LocalDate creationDate;

    /**
     * ID of the payee adhering to the rules of ID permanence
     * @return payeeId
     */
    public String getPayeeId() {
        return payeeId;
    }

    public void setPayeeId(String payeeId) {
        this.payeeId = payeeId;
    }

    /**
     * The short display name of the payee as provided by the customer.
     * Where a customer has not provided a nickname, a display name derived by the bank for the payee consistent
     * with existing digital banking channels
     * @return nickname
     */
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * A description of the payee provided by the customer
     * @return description
     */
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * The type of payee.<br/>DOMESTIC means a registered payee for domestic payments including NPP. <br/>INTERNATIONAL means a registered payee for international payments. <br/>BILLER means a registered payee for BPAY. <br/>DIGITAL_WALLET means a registered payee for a bank's digital wallet
     * @return type
     */
    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    /**
     * The date the payee was created by the customer
     * @return creationDate
     */
    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BankingPayee bankingPayee = (BankingPayee) o;
        return Objects.equals(this.payeeId, bankingPayee.payeeId) &&
            Objects.equals(this.nickname, bankingPayee.nickname) &&
            Objects.equals(this.description, bankingPayee.description) &&
            Objects.equals(this.type, bankingPayee.type) &&
            Objects.equals(this.creationDate, bankingPayee.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            payeeId,
            nickname,
            description,
            type,
            creationDate);
    }

    @Override
    public String toString() {
        return "class BankingPayee {\n" +
            "   payeeId: " + toIndentedString(payeeId) + "\n" + 
            "   nickname: " + toIndentedString(nickname) + "\n" + 
            "   description: " + toIndentedString(description) + "\n" + 
            "   type: " + toIndentedString(type) + "\n" + 
            "   creationDate: " + toIndentedString(creationDate) + "\n" + 
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
