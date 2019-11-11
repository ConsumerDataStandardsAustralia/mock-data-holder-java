package au.org.consumerdatastandards.holder.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;
import java.time.LocalDate;

@ApiModel
@Entity
@Table(name = "BankingPayee")
public class BankingPayee  {

    /**
     * ID of the payee adhering to the rules of ID permanence
     */
    @Id
    private String payeeId;

    /**
     * The date the payee was created by the customer
     */
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDate creationDate;

    /**
     * A description of the payee provided by the customer
     */
    private String description;

    /**
     * The short display name of the payee as provided by the customer
     */
    private String nickname;

    private Type type;

    public BankingPayee creationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    @ApiModelProperty(value = "The date the payee was created by the customer")
    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }
    public BankingPayee description(String description) {
        this.description = description;
        return this;
    }

    @ApiModelProperty(value = "A description of the payee provided by the customer")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public BankingPayee nickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    @ApiModelProperty(required = true, value = "The short display name of the payee as provided by the customer")
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public BankingPayee payeeId(String payeeId) {
        this.payeeId = payeeId;
        return this;
    }

    @ApiModelProperty(required = true, value = "ID of the payee adhering to the rules of ID permanence")
    public String getPayeeId() {
        return payeeId;
    }

    public void setPayeeId(String payeeId) {
        this.payeeId = payeeId;
    }
    public BankingPayee type(Type type) {
        this.type = type;
        return this;
    }

    @ApiModelProperty(required = true)
    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
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
        return Objects.equals(this.creationDate, bankingPayee.creationDate) &&
            Objects.equals(this.description, bankingPayee.description) &&
            Objects.equals(this.nickname, bankingPayee.nickname) &&
            Objects.equals(this.payeeId, bankingPayee.payeeId) &&
            Objects.equals(this.type, bankingPayee.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            creationDate,
            description,
            nickname,
            payeeId,
            type);
    }

    @Override
    public String toString() {
        return "class BankingPayee {\n" +
            "   creationDate: " + toIndentedString(creationDate) + "\n" + 
            "   description: " + toIndentedString(description) + "\n" + 
            "   nickname: " + toIndentedString(nickname) + "\n" + 
            "   payeeId: " + toIndentedString(payeeId) + "\n" + 
            "   type: " + toIndentedString(type) + "\n" + 
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

    public enum Type {
        BILLER,
        DOMESTIC,
        INTERNATIONAL
    }
}

