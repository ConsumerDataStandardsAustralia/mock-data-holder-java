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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Objects;
import java.time.OffsetDateTime;

@ApiModel
@Entity
public class BankingDirectDebit  {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @JsonIgnore
    private String id;

    /**
     * A unique ID of the account adhering to the standards for ID permanence.
     */
    private String accountId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(updatable = false)
    private BankingAccount bankingAccount;

    /**
     * Get authorisedEntity
     */
    @ManyToOne
    private BankingAuthorisedEntity authorisedEntity;

    /**
     * The amount of the last debit executed under this authorisation
     */
    private String lastDebitAmount;

    /**
     * The date and time of the last debit executed under this authorisation
     */
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private OffsetDateTime lastDebitDateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BankingDirectDebit accountId(String accountId) {
        this.accountId = accountId;
        return this;
    }

    @ApiModelProperty(required = true, value = "A unique ID of the account adhering to the standards for ID permanence.")
    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
    public BankingDirectDebit authorisedEntity(BankingAuthorisedEntity authorisedEntity) {
        this.authorisedEntity = authorisedEntity;
        return this;
    }

    public BankingAccount getBankingAccount() {
        return bankingAccount;
    }

    public void setBankingAccount(BankingAccount bankingAccount) {
        this.bankingAccount = bankingAccount;
    }

    @ApiModelProperty(required = true)
    public BankingAuthorisedEntity getAuthorisedEntity() {
        return authorisedEntity;
    }

    public void setAuthorisedEntity(BankingAuthorisedEntity authorisedEntity) {
        this.authorisedEntity = authorisedEntity;
    }
    public BankingDirectDebit lastDebitAmount(String lastDebitAmount) {
        this.lastDebitAmount = lastDebitAmount;
        return this;
    }

    @ApiModelProperty(value = "The amount of the last debit executed under this authorisation")
    public String getLastDebitAmount() {
        return lastDebitAmount;
    }

    public void setLastDebitAmount(String lastDebitAmount) {
        this.lastDebitAmount = lastDebitAmount;
    }
    public BankingDirectDebit lastDebitDateTime(OffsetDateTime lastDebitDateTime) {
        this.lastDebitDateTime = lastDebitDateTime;
        return this;
    }

    @ApiModelProperty(value = "The date and time of the last debit executed under this authorisation")
    public OffsetDateTime getLastDebitDateTime() {
        return lastDebitDateTime;
    }

    public void setLastDebitDateTime(OffsetDateTime lastDebitDateTime) {
        this.lastDebitDateTime = lastDebitDateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BankingDirectDebit bankingDirectDebit = (BankingDirectDebit) o;
        return Objects.equals(this.id, bankingDirectDebit.id) &&
            Objects.equals(this.accountId, bankingDirectDebit.accountId) &&
            Objects.equals(this.authorisedEntity, bankingDirectDebit.authorisedEntity) &&
            Objects.equals(this.lastDebitAmount, bankingDirectDebit.lastDebitAmount) &&
            Objects.equals(this.lastDebitDateTime, bankingDirectDebit.lastDebitDateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            id,
            accountId,
            authorisedEntity,
            lastDebitAmount,
            lastDebitDateTime);
    }

    @Override
    public String toString() {
        return "class BankingDirectDebit {\n" +
            "   id: " + toIndentedString(id) + "\n" +
            "   accountId: " + toIndentedString(accountId) + "\n" +
            "   authorisedEntity: " + toIndentedString(authorisedEntity) + "\n" +
            "   lastDebitAmount: " + toIndentedString(lastDebitAmount) + "\n" + 
            "   lastDebitDateTime: " + toIndentedString(lastDebitDateTime) + "\n" + 
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

